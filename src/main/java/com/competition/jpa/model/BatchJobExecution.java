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
@Table(name="batch_job_execution")
public class BatchJobExecution implements Serializable {
	
//	Table Name = batch_job_execution
//	Column = job_execution_id bigint(20)
//	Column = version bigint(20)
//	Column = job_instance_id bigint(20)
//	Column = create_time datetime
//	Column = start_time datetime
//	Column = end_time datetime
//	Column = status varchar(10)
//	Column = exit_code varchar(100)
//	Column = exit_message varchar(2500)
//	Column = last_updated datetime
	
	private static final long serialVersionUID = -3479674353627665833L;

	@Id
	@Column(length = 20)
	private Long job_execution_id;
	
	@Column(length = 20)
	private Long version;
	
	@Column(length = 20)
	private Long job_instance_id;
	
	@Column
	private Date create_time;
	
	@Column
	private Date start_time;
	
	@Column
	private Date end_time;
	
	@Column(length = 10)
	private String status;
	
	@Column(length = 100)
	private String exit_code;
	
	@Column(length = 2500)
	private String exit_message;
	
	@Column
	private Date last_updated;
	
	@Column(length = 2500)
	private String job_configuration_location; 
	
	
}
