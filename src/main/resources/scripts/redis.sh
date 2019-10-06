TAG="redis-server"
RETVAL="0"

function start() {
  nohup $TAG /etc/redis/6379.conf >nohup.out
}

function stop() {
  pid=$(ps -ef | grep -v 'grep' | egrep $TAG | awk '{printf $2 " "}')
  if [ "$pid" != "" ]; then
    echo "kill boot process, pid: $pid"
    ps aux | grep $TAG | grep -v 'grep' | awk '{print $2}' | xargs -r kill
  fi
}

function status() {
  pid=$(ps -ef | grep -v 'grep' | egrep $TAG | awk '{printf $2 " "}')
  if [ "$pid" != "" ]; then
    echo "$TAG is running"
  else
    echo "$TAG is stoped"
  fi
}

function usage() {
  echo "usage: $0 {start|stop|restart|status}"
  RETVAL="2"
}

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
status)
  status
  ;;
*)
  usage
  ;;
esac

exit $RETVAL
