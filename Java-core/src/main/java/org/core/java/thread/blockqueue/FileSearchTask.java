package org.core.java.thread.blockqueue;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.concurrent.BlockingQueue;

/**
 * file consumer
 * 
 * @author clx at 2017年4月11日 上午11:46:13
 */
public class FileSearchTask implements Runnable {

    private BlockingQueue<File> queue;
    private String keyWord;
    
    public  FileSearchTask(BlockingQueue<File> queue, String keyWord) {
        this.queue = queue;
        this.keyWord = keyWord;
    }
    
    @Override
    public void run() {
        try {
            boolean done = false;
            while (!done) {
                File file = queue.take();
                if (FileEnumTask.DUMMY == file) {
                    queue.put(file);
                    done = true;
                } else {
                    this.search(file);
                }
            }
        } catch (InterruptedException | FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    
    private void search(File file) throws FileNotFoundException {

        Scanner in = new Scanner(new FileInputStream(file));
        int lineNumber = 0;
        while (in.hasNextLine()) {
            lineNumber++;
            String line = in.nextLine();
            if (line.contains(keyWord)) {
                System.out.printf("%s:%d:%s%n", file.getPath(), lineNumber,
                        line);
            }
        }
        in.close();
    }
}
