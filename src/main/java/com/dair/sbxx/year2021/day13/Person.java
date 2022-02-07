package com.dair.sbxx.year2021.day13;

/**
 * @author Dair
 * @since
 */
public class Person {
	
	private String userName;
	
	private Integer age;
	
	private String idCard;
	
	public String getUserName() {
		return userName;
	}
	
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public Integer getAge() {
		return age;
	}
	
	public void setAge(Integer age) {
		this.age = age;
	}
	
	public String getIdCard() {
		return idCard;
	}
	
	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}
	
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Person)) return false;
		
		Person person = (Person) o;
		
		if (getUserName() != null ? !getUserName().equals(person.getUserName()) : person.getUserName() != null)
			return false;
		if (getAge() != null ? !getAge().equals(person.getAge()) : person.getAge() != null) return false;
		return getIdCard() != null ? getIdCard().equals(person.getIdCard()) : person.getIdCard() == null;
	}
	
	@Override
	public int hashCode() {
		int result = getUserName() != null ? getUserName().hashCode() : 0;
		result = 31 * result + (getAge() != null ? getAge().hashCode() : 0);
		result = 31 * result + (getIdCard() != null ? getIdCard().hashCode() : 0);
		return result;
	}
}
