package com.example.commons.json;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * @author clx 2019-08-13
 */
public class TestJsonUtils {
	public static class Template {

		@Expose
		private int id;
		@Expose
		private String name;
		@Expose
		@SerializedName(value = "addr")
		private String address;
		@Expose
		@SerializedName(value = "zip_code")
		private String zipCode;

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

		public String getAddress() {
			return address;
		}

		public void setAddress(String address) {
			this.address = address;
		}

		public String getZipCode() {
			return zipCode;
		}

		public void setZipCode(String zipCode) {
			this.zipCode = zipCode;
		}
	}

	public static void main(String[] args) {
		Template template = new Template();
		template.setId(1);
		template.setName("test");
		template.setAddress("hahaha");
		String result = JsonUtils.toJsonStr(template);
		System.out.println(result);
	}
}
