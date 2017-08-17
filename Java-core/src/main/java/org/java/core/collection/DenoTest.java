package org.java.core.collection;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import com.google.gson.Gson;

public class DenoTest {

    private static Gson gson = new Gson();

    public static void main(String[] args) {

        // Map<Integer, String> map = getDenoValues();
        //
        // StringBuilder sb = new StringBuilder(300);
        //
        // for (Map.Entry<Integer, String> entry : map.entrySet()) {
        // sb.append(entry.getKey()).append(entry.getValue());
        // }
        // System.out.println(sb.toString());

        // System.out.println(getDeno());

        // String s = "200";
        // String str = s.substring(s.lastIndexOf(".") + 1, s.length());
        // System.out.println(str.length());

        String price = "230";
        System.out.println(Long.parseLong(price));
    }

    public static Map<Integer, String> getDenoValues() {
        Map<Integer, String> valueMap = new TreeMap<Integer, String>();
        valueMap.put(10000, "10,000 Chips");
        valueMap.put(20000, "20,000 Chips");
        valueMap.put(50000, "50,000 Chips");
        valueMap.put(100000, "100,000 Chips");
        valueMap.put(300000, "300,000 Chips");
        valueMap.put(500000, "500,000 Chips");
        return valueMap;
    }

    public static List<String> getDeno() {
        List<String> deno = new LinkedList<String>();
        Map<String, Object> denoMap = new HashMap<String, Object>();
        Map<Integer, String> valueMap = getDenoValues();
        for (Map.Entry<Integer, String> entry : valueMap.entrySet()) {
            denoMap.put("amount", entry.getKey());
            denoMap.put("description", entry.getValue());
            deno.add(gson.toJson(denoMap));
        }
        return deno;
    }
}
