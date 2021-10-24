package com.example.distributed.lock;

/**
 * zookeeper distributed lock
 *
 * @author clx
 */
public class ZkDistributedLock extends AbstractDistributedLock {
	
	@Override
	public boolean tryLock() {
		return false;
	}

	@Override
	public void unlock() {

	}
}
