package com.competition.jpa.model.quartz;

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
@Table(name = "QUARTJOB")
public class QuartzJob implements Serializable {
	
	private static final long serialVersionUID = 5316254324233497690L;

	@Id
	@Column
	private String idx;
	
	@Column
	private String key;
	
	@Column
	private String description;
	
	@Column
	private String clasz;
	
}
