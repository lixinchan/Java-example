package org.java.core.thread;

/**
 * @author clx at 2017年8月17日 上午10:00:53
 */
public class ProducerConsumer {

    private boolean hasValue = false;
    private String value = "";

    public void producer(String value) {
        while (hasValue) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
        System.out.println("Producing" + value + "as the next consumable!");
        this.value = value;
        hasValue = true;
    }

    public String consumer() {
        while (!hasValue) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
        System.out.println("Consuming" + this.value);
        hasValue = false;
        return this.value;
    }
}
