package com.tt.demo.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

import org.hibernate.annotations.CreationTimestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@SequenceGenerator(
		name="SEQ_Generator3",
		sequenceName="demo_seq3",
		initialValue=1,
		allocationSize=1
		)
public class Reply {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="SEQ_Generator3")
	private int id;
	@Column(nullable=false,length=200)
	private String content;
	@ManyToOne
	@JoinColumn(name="boardid")
	private boards boards;
	@ManyToOne
	@JoinColumn(name="userdid")
	private Users users;
	@CreationTimestamp
	private Timestamp createDate;
}
