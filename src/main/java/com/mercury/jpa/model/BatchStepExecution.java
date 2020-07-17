package com.mercury.jpa.model;

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
@Table(name="batch_step_execution")
public class BatchStepExecution implements Serializable {
	
//	batch_step_execution
//	step_execution_id bigint(20)
//	version bigint(20)
//	step_name varchar(100)
//	job_execution_id bigint(20)
//	start_time datetime
//	end_time datetime
//	status varchar(10)
//	commit_count bigint(20)
//	read_count bigint(20)
//	filter_count bigint(20)
//	write_count bigint(20)
//	read_skip_count bigint(20)
//	write_skip_count bigint(20)
//	process_skip_count bigint(20)
//	rollback_count bigint(20)
//	exit_code varchar(100)
//	exit_message varchar(2500)
//	last_updated datetime
	
	private static final long serialVersionUID = -2483743393698284707L;
	
	@Id
	@Column(length = 20)
	private Long step_execution_id;
	
	@Column(length = 20)
	private Long version;
	
	@Column(length = 100)
	private String step_name;
	
	@Column(length = 20)
	private Long job_execution_id;
	
	@Column
	private Date start_time;
	
	@Column
	private Date end_time;
	
	@Column(length = 10)
	private String status;
	
	@Column(length = 20)
	private Long commit_count;
	
	@Column(length = 20)
	private Long read_count;
	
	@Column(length = 20)
	private Long filter_count;
	
	@Column(length = 20)
	private Long write_count;
	
	@Column(length = 20)
	private Long read_skip_count;
	
	@Column(length = 20)
	private Long write_skip_count;
	
	@Column(length = 20)
	private Long process_skip_count;
	
	@Column(length = 20)
	private Long rollback_count;
	
	@Column(length = 100)
	private String exit_code;
	
	@Column(length = 2500)
	private String exit_message;
	
	@Column
	private Date last_updated;
	
}
