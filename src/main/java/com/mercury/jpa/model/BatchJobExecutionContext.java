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
@Table(name="batch_job_execution_context")
public class BatchJobExecutionContext implements Serializable {

//	Table Name = batch_job_execution_context
//	Column = job_execution_id bigint(20)
//	Column = short_context varchar(2500)
//	Column = serialized_context text
	
	private static final long serialVersionUID = -5291827957182873594L;
	
	@Id
	@Column(length = 20)
	private Long job_execution_id;
	
	@Column(length = 2500)
	private String short_context;
	
	@Column(length = 5000)
	private String serialized_context;
}
