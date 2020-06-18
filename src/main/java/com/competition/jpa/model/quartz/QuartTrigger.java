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
@Table(name = "QUARTTRIGGER")
public class QuartTrigger implements Serializable {
	
	private static final long serialVersionUID = -1984362789674303002L;
	
	@Id
	@Column
	private String Idx;
	
	@Column
	private String key;
	
	@Column
	private String description;
	
	@Column
	private String cron;
	
	@Column
	private String jobKey;
}
