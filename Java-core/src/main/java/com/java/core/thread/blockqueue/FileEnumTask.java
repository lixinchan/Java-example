package com.java.core.thread.blockqueue;

import java.io.File;
import java.util.concurrent.BlockingQueue;

/**
 * file product
 * 
 * @author clx at 2017年4月11日 上午11:31:34
 */
public class FileEnumTask implements Runnable {

    public static File DUMMY = new File("");
    private BlockingQueue<File> queue;
    private File startingDirectory;

    public FileEnumTask(BlockingQueue<File> queue, File startingDirectory) {
        this.queue = queue;
        this.startingDirectory = startingDirectory;
    }

    @Override
    public void run() {
        try {
            this.enumFile(startingDirectory);
            queue.put(DUMMY);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void enumFile(File startingDirectory) throws InterruptedException {

        File[] files = startingDirectory.listFiles();
        for (File file : files) {
            if (file.isDirectory()) {
                enumFile(file);
            } else {
                queue.put(file);
            }
        }
    }

}
