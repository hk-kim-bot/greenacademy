package com.tt.demo.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name="Demousers")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity

@SequenceGenerator(
		name="SEQ_Generator",
		sequenceName="demo_seq",
		initialValue=1,
		allocationSize=1
		)

public class Users {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQ_Generator")
	private int id;
	
	@Column(nullable=false,length=30,unique=true)
	private String username;
	@Column(nullable=false,length=100)
	private String password;
	@Column(nullable=false,length=50)
	private String email;
	@Enumerated(EnumType.STRING)
	private RoleType roles;
	@CreationTimestamp
	private Timestamp createDate;
	
}
