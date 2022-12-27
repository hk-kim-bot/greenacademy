package com.tt.demo.model;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name="demoboard")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@SequenceGenerator(
		name="SEQ_Generator2",
		sequenceName="demo_seq2",
		initialValue=1,
		allocationSize=1
		)

public class boards {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="SEQ_Generator2")
	private int id;
	@Column(nullable=false, length=100)
	private String title;
	@Lob
	private String content;
	private int count;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="userid")
	private Users users;
	@OneToMany(mappedBy="boards",fetch=FetchType.EAGER)
	private List<Reply> reply;
	@CreationTimestamp
	private Timestamp createDate;
}
