package org.fiveware.model.entity.enums;

public enum Gender {

	MALE(1l, "Masculino"), 
	FEMALE(2l, "Feminino");

	private Long genderId;
	private String description;

	private Gender(Long genderId, String description) {
		this.genderId = genderId;
		this.description = description;
	}

	public Long getGenderId() {
		return genderId;
	}

	public void setGenderId(Long genderId) {
		this.genderId = genderId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}