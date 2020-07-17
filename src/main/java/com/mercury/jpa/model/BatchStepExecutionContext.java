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
@Table(name="batch_step_execution_context")
public class BatchStepExecutionContext implements Serializable {
	
//	Talbe Name = batch_step_execution_context
//	Column = step_execution_id bigint(20)
//	Column = short_context varchar(2500)
//	Column = serialized_context text
	
	private static final long serialVersionUID = -4234698269033628371L;

	
	@Id
	@Column(length = 20)
	private Long step_execution_id;
	
	@Column(length = 2500)
	private String short_context;
	
	@Column(length = 5000)
	private String serialized_context;
}
