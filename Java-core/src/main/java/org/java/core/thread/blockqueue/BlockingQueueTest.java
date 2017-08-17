package org.java.core.thread.blockqueue;

import java.io.File;
import java.util.Scanner;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * @author clx at 2017年4月11日 上午11:29:57
 */
public class BlockingQueueTest {
    
    final static int FILE_QUEUE_SIZE = 16;
    final static int SEARCH_THREAD = 100;
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter base directory:");
        String directory = in.nextLine();
        System.out.println("Enter keyWord:");
        String keyWord = in.nextLine();
        
        BlockingQueue<File> queue = new ArrayBlockingQueue<File>(FILE_QUEUE_SIZE);
        new Thread(new FileEnumTask(queue, new File(directory))).start();
        
        for(int index = 0; index < SEARCH_THREAD; index++) {
            new Thread(new FileSearchTask(queue, keyWord)).start();
        }
        in.close();
    }
}
