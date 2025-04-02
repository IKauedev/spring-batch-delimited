package com.springbatch.filedelimited.domain.model;

public class Customer {
	private String name;
	private String lastname;
	private String age;
	private String email;

	public Customer() {}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Customer{" +
				"name='" + name + '\'' +
				", lastname='" + lastname + '\'' +
				", age='" + age + '\'' +
				", email='" + email + '\'' +
				'}';
	}
}