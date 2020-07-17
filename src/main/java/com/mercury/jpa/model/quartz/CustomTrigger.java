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
@Table(name = "CUSTOMTRIGGER")
public class CustomTrigger implements Serializable {
	
	private static final long serialVersionUID = -1984362789674303002L;
	
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
	private String cron;
	
	@Column
	private String jobTitle;
	
	@Column
	private String insertDate;
}
