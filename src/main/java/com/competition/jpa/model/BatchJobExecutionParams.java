package com.competition.jpa.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@ToString
@Entity
@Table(name="batch_job_execution_params")
public class BatchJobExecutionParams implements Serializable {
	
//	Table Name = batch_job_execution_params
//	Column = job_execution_id bigint(20)
//	Column = type_cd varchar(6)
//	Column = key_name varchar(100)
//	Column = string_val varchar(250)
//	Column = date_val datetime
//	Column = long_val bigint(20)
//	Column = double_val double
//	Column = ientifying char(1)
	
	private static final long serialVersionUID = 5495921991557725506L;
	
	
	@Id
	@Column(length = 20)
	private Long job_execution_id;
	
	@Column(length = 6)
	private String type_cd;
	
	@Column(length = 100)
	private String key_name;
	
	@Column(length = 250)
	private String string_val;
	
	@Column
	private Date date_val;
	
	@Column(length = 20)
	private Long long_val;
	
	@Column
	private Double double_val;
	
	@Column(length = 1)
	private String identifying;
	
}
