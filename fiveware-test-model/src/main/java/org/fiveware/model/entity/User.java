package org.fiveware.model.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.fiveware.model.entity.enums.Gender;

@Entity
@Table(name = "user")
public class User extends BaseEntity {

	private static final long serialVersionUID = 7139384358356526607L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id")
	private Long userId;
	
	@Column(name = "full_name")
	@Size(max = 80)
	@NotNull
	private String fullName;
	
	@Column
	@Size(max = 80)
	@NotNull
	private String email;
	
	@Column(name="gender_id") 
	@Enumerated(EnumType.ORDINAL) 
	@NotNull
	private Gender gender;
	
	@OneToMany
	@JoinTable(name = "user_interest", joinColumns = { 
			@JoinColumn(name = "user_id", referencedColumnName = "user_id", nullable = false) },
		inverseJoinColumns = { 
				@JoinColumn(name = "interest_id", referencedColumnName = "interest_id", nullable = false)})
	private Set<Interest> interests;

	@Override
	public Long getId() {
		return userId;
	}

	@Override
	public void setId(Long id) {
		this.userId = id;
	}
	
	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public Gender getGender() {
		return gender;
	}
	
	public void setGender(Gender gender) {
		this.gender = gender;
	}
	
	public Set<Interest> getInterests() {
		return interests;
	}

	public void setInterests(Set<Interest> interests) {
		this.interests = interests;
	}

	@Override
	public boolean equals(Object obj) {
		return EqualsBuilder.reflectionEquals(this, obj, false);
	}
	
	@Override
	public int hashCode() {
		return HashCodeBuilder.reflectionHashCode(this, false);
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", fullName=" + fullName + ", email=" + email + ", gender=" + gender + ", interests=" + interests + "]";
	}

}