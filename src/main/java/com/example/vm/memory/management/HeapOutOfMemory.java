package com.example.vm.memory.management;

import java.util.ArrayList;
import java.util.List;

/**
 * -Xms20m -Xmx20m -XX:+HeapDumpOnOutOfMemoryError
 * 
 * @author clx 2018/12/15
 */
public class HeapOutOfMemory {

	static class OutOfMemoryObject {

	}

	public static void main(String[] args) {
		List<OutOfMemoryObject> list = new ArrayList<>();
		while (true) {
			list.add(new OutOfMemoryObject());
		}
	}
}
