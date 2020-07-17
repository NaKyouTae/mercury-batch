package com.mercury.jpa.model;

import java.io.Serializable;

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
@Table(name="batch_job_instance")
public class BatchJobInstance implements Serializable {
	
//	CREATE TABLE BATCH_STEP_EXECUTION_SEQ (ID BIGINT NOT NULL);
//	INSERT INTO BATCH_STEP_EXECUTION_SEQ values(0);
//	CREATE TABLE BATCH_JOB_EXECUTION_SEQ (ID BIGINT NOT NULL);
//	INSERT INTO BATCH_JOB_EXECUTION_SEQ values(0);
//	CREATE TABLE BATCH_JOB_SEQ (ID BIGINT NOT NULL);
//	INSERT INTO BATCH_JOB_SEQ values(0);
	
	
//	Table Name = batch_job_instance
//	Column = job_instance_id bigint(20)
//	Column = version bigint(20)
//	Column = job_name varchar(100)
//	Column = job_key varchar(32)
	
	private static final long serialVersionUID = 6331694858242263022L;

	@Id
	@Column(length = 20)
	private Long job_instance_id;
	
	@Column(length = 20)
	private Long version;
	
	@Column(length = 100)
	private String job_name;
	
	@Column(length = 32)
	private String job_key;
}
