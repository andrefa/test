package org.fiveware.model.entity;

import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

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
	@NotNull
	private Long genderId;
	
	@OneToMany(fetch=FetchType.EAGER)
	@JoinTable(name = "user_interest", joinColumns = { 
			@JoinColumn(name = "user_id", referencedColumnName = "user_id", nullable = false) },
		inverseJoinColumns = { 
				@JoinColumn(name = "interest_id", referencedColumnName = "interest_id", nullable = false)})
	private Set<Interest> interests = new LinkedHashSet<>();

	public User() {}
	
	public User(Long userId) {
		this.userId = userId;
	}

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
	
	public Long getGenderId() {
		return genderId;
	}

	public void setGenderId(Long genderId) {
		this.genderId = genderId;
	}

	public Set<Interest> getInterests() {
		return interests;
	}

	public void setInterests(Set<Interest> interests) {
		this.interests = interests;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (userId == null) {
			if (other.userId != null)
				return false;
		} else if (!userId.equals(other.userId))
			return false;
		return true;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((userId == null) ? 0 : userId.hashCode());
		return result;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", fullName=" + fullName + ", email=" + email + ", genderId=" + genderId + ", interests=" + interests + "]";
	}

}