package org.jsp.cms.entity;

import java.time.LocalTime;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Faculty {
	
	@Id
	private int id;
	@MapsId
	@OneToOne
	private User user;
	private String photo;
	private LocalTime officeHours;
	
//	
//	@OneToOne(cascade = CascadeType.PERSIST)
//	private User user;
//	
	
	@ManyToOne(cascade = CascadeType.PERSIST)
	private Department department;
	

}
