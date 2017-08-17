package org.java.core.collection;

import java.util.ArrayList;
import java.util.List;

/**
 * @author clx at 2017年3月29日 下午5:29:48
 */
public class ListTest {
    public static void main(String[] args) {
        Result result = new Result();
        List<String> list = new ArrayList<String>();
        result.setResult(list);
        for (int index = 0; index < 5; index++) {
            list.add("H");
        }
        System.out.println(result);
    }
}

class Result {
    private List<String> result;

    public List<String> getResult() {
        return result;
    }

    public void setResult(List<String> result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "Result [result=" + result + "]";
    }
}