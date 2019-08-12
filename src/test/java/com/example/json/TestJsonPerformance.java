package com.example.json;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * test jackson gosn fastjson performance
 *
 * @author mf
 */
public class TestJsonPerformance {

	@Test
	public void testSerialize() throws Exception {
		System.out.println("100 objects:");
		serialize(100);
		System.out.println("500 objects:");
		serialize(500);
		System.out.println("1000 objects:");
		serialize(1000);
		System.out.println("5000 objects:");
		serialize(5000);
		System.out.println("10000 objects:");
		serialize(10000);
		System.out.println("50000 objects:");
		serialize(50000);
		System.out.println("100000 objects:");
		serialize(100000);
	}

	@Test
	public void testDeserialize() throws IOException {
		System.out.println("100 objects:");
		deserialize(100);
		System.out.println("500 objects:");
		deserialize(500);
		System.out.println("1000 objects:");
		deserialize(1000);
		System.out.println("5000 objects:");
		deserialize(5000);
		System.out.println("10000 objects:");
		deserialize(10000);
		System.out.println("50000 objects:");
		deserialize(50000);
		System.out.println("100000 objects:");
		deserialize(100000);
	}

	private void serialize(int n) throws IOException {
		List<Template> templates = new ArrayList<>();
		for (int idx = 0; idx < n; idx++) {
			Template template = new Template();
			template.setId(idx);
			template.setName(String.valueOf(idx));
			template.setCode(Collections.singletonList(idx));
			template.setAddrList(Collections.singletonList(Collections.singletonMap(idx, String.valueOf(idx))));
			template.setAddress(Collections.singletonMap(String.valueOf(idx), String.valueOf(idx)));
			template.setCodes(Collections.singletonMap(String.valueOf(idx), Collections.singletonList(idx)));
			templates.add(template);
		}

		long startJackson = System.currentTimeMillis();
		ObjectMapper mapper = new ObjectMapper();
		String jacksonResult = mapper.writeValueAsString(templates);
		System.out.println("Jackson serialize time:" + (System.currentTimeMillis() - startJackson));
		writeFile(jacksonResult, n);

		long startGson = System.currentTimeMillis();
		Gson gson = new GsonBuilder().create();
		gson.toJson(templates);
		System.out.println("Gson serialize time:" + (System.currentTimeMillis() - startGson));

		long startFastjson = System.currentTimeMillis();
		JSON.toJSONString(templates);
		System.out.println("Fastjson serialize time:" + (System.currentTimeMillis() - startFastjson));
	}

	private void deserialize(int n) throws IOException {
		String content = readFile(n);
		long startJackson = System.currentTimeMillis();
		ObjectMapper mapper = new ObjectMapper();
		List<Template> jacksonResult = mapper.readValue(content, List.class);
		System.out.println("Jackson deserialize time:" + (System.currentTimeMillis() - startJackson) + " size:" + jacksonResult.size());

		long startGson = System.currentTimeMillis();
		Gson gson = new GsonBuilder().create();
		List<Template> gsonResult = gson.fromJson(content, List.class);
		System.out.println("Gson deserialize time:" + (System.currentTimeMillis() - startGson) + " size:" + gsonResult.size());

		long startFastjson = System.currentTimeMillis();
		List<Template> fastjsonResult = (List<Template>) JSON.parse(content);
		System.out.println("Fastjson serialize time:" + (System.currentTimeMillis() - startFastjson) + " size:" + fastjsonResult.size());
	}

	private void writeFile(String content, int prefix) throws IOException {
		BufferedWriter writer = new BufferedWriter(new FileWriter("./src/test/resources/json/" + prefix + ".json"));
		writer.write(content);
		writer.flush();
		writer.close();
	}

	private String readFile(int prefix) throws IOException {
		BufferedReader reader = new BufferedReader(new FileReader("./src/test/resources/json/" + prefix + ".json"));
		String result = reader.readLine();
		reader.close();
		return result;
	}


	public static class Template {
		private int id;
		private String name;
		private List<Integer> code;
		private List<Map<Integer, String>> addrList;
		private Map<String, String> address;
		private Map<String, List<Integer>> codes;

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public List<Integer> getCode() {
			return code;
		}

		public void setCode(List<Integer> code) {
			this.code = code;
		}

		public Map<String, String> getAddress() {
			return address;
		}

		public void setAddress(Map<String, String> address) {
			this.address = address;
		}

		public List<Map<Integer, String>> getAddrList() {
			return addrList;
		}

		public void setAddrList(List<Map<Integer, String>> addrList) {
			this.addrList = addrList;
		}

		public Map<String, List<Integer>> getCodes() {
			return codes;
		}

		public void setCodes(Map<String, List<Integer>> codes) {
			this.codes = codes;
		}
	}
}
