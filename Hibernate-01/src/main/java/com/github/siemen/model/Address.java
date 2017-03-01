/**
 * 
 */
package com.github.siemen.model;

/**
 * @author ����
 *
 */
public class Address {

	private String post;
	private String street;
	private String phone;
	
	public Address(){}
	
	
	
	/**
	 * @param post
	 * @param street
	 * @param phone
	 */
	public Address(String post, String street, String phone) {
		super();
		this.post = post;
		this.street = street;
		this.phone = phone;
	}



	public String getPost() {
		return post;
	}
	public void setPost(String post) {
		this.post = post;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	
}
