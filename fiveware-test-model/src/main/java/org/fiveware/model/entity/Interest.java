package org.fiveware.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "interest")
public class Interest extends BaseEntity {

	private static final long serialVersionUID = 1116063280372050867L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "interest_id")
	private Long interestId;
	
	
	@Column(name = "interest_description")
	@Size(max = 100)
	@NotNull
	private String interestDescription;
	
	public Interest() {}
	
	public Interest(Long interestId) {
		this.interestId = interestId;
	}

	@Override
	public Long getId() {
		return interestId;
	}

	@Override
	public void setId(Long id) {
		this.interestId = id;
	}

	public String getInterestDescription() {
		return interestDescription;
	}

	public void setInterestDescription(String interestDescription) {
		this.interestDescription = interestDescription;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((interestId == null) ? 0 : interestId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Interest other = (Interest) obj;
		if (interestId == null) {
			if (other.interestId != null)
				return false;
		} else if (!interestId.equals(other.interestId))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Interest [interestId=" + interestId + ", interestDescription=" + interestDescription + "]";
	}

}