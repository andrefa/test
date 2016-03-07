package org.fiveware.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

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
		return "Interest [interestId=" + interestId + ", interestDescription=" + interestDescription + "]";
	}

}