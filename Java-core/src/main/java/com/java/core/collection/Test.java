package com.java.core.collection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test {

    public static void main(String[] args) {
        List<String> deno = new ArrayList<String>();
        Map<String, String> denoMap = new HashMap<String, String>();
        denoMap.put("amount", "10000");
        denoMap.put("description", "10,000 Chips");
        deno.add(denoMap.toString());
        denoMap.put("amount", "20000");
        denoMap.put("description", "20,000 Chips");
        deno.add(denoMap.toString());
        denoMap.put("amount", "50000");
        denoMap.put("description", "50,000 Chips");
        deno.add(denoMap.toString());
        denoMap.put("amount", "100000");
        denoMap.put("description", "100,000 Chips");
        deno.add(denoMap.toString());
        denoMap.put("amount", "300000");
        denoMap.put("description", "300,000 Chips");
        deno.add(denoMap.toString());
        denoMap.put("amount", "500000");
        denoMap.put("description", "50,000 Chips");
        deno.add(denoMap.toString());
    }
}
