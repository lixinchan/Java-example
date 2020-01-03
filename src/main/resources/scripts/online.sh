# description: Auto-starts boot
# 使用脚本请注意，Jenkins部署使用用户需与此脚本的用户和组一致
ip_and_host=$(ifconfig eth0 | grep inet | awk '{print $2}')[$(hostname)]
# tag需要自定义以环境+服务名称格式定义，例：
TAG="online"
RETVAL="0"
# slb vid，例:
SLB_VID=""
# slb hostid，例:
SLB_HOSTID=""
# slb port
SLB_PORT=80
# slb ip，例：
SLB_IP=""
# 服务的端口，例：8080
SERVER_PORT=8060
# 服务的环境，例：dev beta prod
ACTIVE_ENV="beta"
# 服务jar包所在目录，例：/home/www-data/
JAR_DIR=""
# jar包名称，例：
JAR_NAME=""
# JVM ops 请自行修改-Xmx -Xms参数值
JAVA_OPS="-server -Xmx2g -Xms2g -Xss256k -XX:+UseGCLogFileRotation -XX:NumberOfGCLogFiles=10 -XX:GCLogFileSize=100M -XX:MetaspaceSize=256M -XX:MaxMetaspaceSize=512m -Djava.security.egd=file:/dev/./urandom -XX:+UseConcMarkSweepGC -XX:ParallelGCThreads=4 -XX:NewRatio=2 -XX:+PrintGCTimeStamps -XX:+PrintGCDetails -verbose:gc -Xloggc:/home/logs/gc/gc.log"

function set_slb_weight() {
  echo ""
  echo "#########################"
  echo "will set $ip_and_host slb $1"
  curl -d "vid=${SLB_VID}&hostid=${SLB_HOSTID}&port=${SLB_PORT}&weight=$1" "${SLB_IP}"
}

function http_check() {
  curl -s "http://127.0.0.1:${SERVER_PORT}" | grep welcome
  return $?
}

function health_check() {
  echo "check service's health..."
  res=1
  for i in $(seq 20); do
    http_check
    res=$?
    if [ "$res" == "0" ]; then
      echo "$TAG service availavle."
      break
    else
      echo "$TAG not availavle."
      echo "check again ..."
      sleep 1s
    fi
  done
  if [ "$res" == "1" ]; then
    set_slb_weight 0
    ps aux | grep "$TAG" | grep -v "grep" | awk '{print $2}' | xargs -r kill
    exit 1
  fi
}

function smooth_start() {
  echo "begin smooth start..."
  set_slb_weight 10
  sleep 5s
  set_slb_weight 40
  sleep 5s
  set_slb_weight 70
  sleep 3s
  echo "end smooth start..."
}

function smooth_down() {
  set_slb_weight 70
  sleep 3s
  set_slb_weight 30
  sleep 3s
}

# See how we were called.
function start() {
  echo "starting"
  nohup java "${JAVA_OPS}" -Dappliction=${TAG} -jar ${JAR_DIR}/${JAR_NAME} --spring.profiles.active=${ACTIVE_ENV} >/dev/null &
  echo "starting..."

  sleep 10s
  health_check
  status
  smooth_start

  set_slb_weight 100
  echo "start done!!"
}

function query_pid() {
  pid=$(ps -ef | grep -v 'grep' | egrep $TAG | awk '{printf $2 " "}')
  echo "$pid"
}

function check_stop() {
  pid=$(query_pid)
  res=0
  for i in $(seq 10); do
    pid=$(query_pid)
    if [ "$pid" != "" ]; then
      res=1
      echo "check again ..."
      sleep 1s
    else
      res=0
      echo "${TAG} is stopped"
      break
    fi
  done
  if [ "$res" == "1" ]; then
    status
    exit 1
  fi
}

function stop() {
  pid=$(query_pid)
  if [ "$pid" != "" ]; then
    http_check
    res=$?
    if [ "$res" == "0" ]; then
      smooth_down
    fi
  fi
  set_slb_weight 0

  sleep 3s

  if [ "$pid" != "" ]; then
    echo -n "boot ( pid $pid) is running"
    echo
    echo -n $"Shutting down boot: "
    pid=$(query_pid)
    if [ "$pid" != "" ]; then
      echo "kill boot process, pid: $pid"
      ps aux | grep "$TAG" | grep -v "grep" | awk '{print $2}' | xargs -r kill
    fi
  else
    echo "boot is stopped"
  fi

  check_stop
}

function status() {
  pid=$(query_pid)
  if [ "$pid" != "" ]; then
    echo "boot is running,pid is $pid"
  else
    echo "boot is stopped"
  fi
}

function usage() {
  echo "Usage: $0 {start|stop|restart|status}"
  RETVAL="2"
}

# See how we were called.
RETVAL="0"
case "$1" in
start)
  start
  ;;
stop)
  stop
  ;;
restart)
  stop
  start
  ;;
reload)
  RETVAL="3"
  ;;
status)
  status
  ;;
*)
  usage
  ;;
esac

exit $RETVAL
