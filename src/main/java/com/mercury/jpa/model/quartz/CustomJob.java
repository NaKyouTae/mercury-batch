package com.mercury.jpa.model.quartz;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "MERCURY_TB_QUARTZ_JOB")
public class CustomJob implements Serializable {
	
	private static final long serialVersionUID = -6396193715656287996L;

	@Id
	@Column
	private String idx;
	
	@Column
	private String name;
	
	@Column
	private String title;	
	
	@Column
	private String description;
	
	@Column
	private String clasz;
	
	@Column
	private String insertDate;
	
	@Column
	private Boolean execute = Boolean.TRUE;
}
