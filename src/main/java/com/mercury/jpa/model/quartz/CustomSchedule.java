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
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "MERCURY_TB_QUARTZ_SCHEDULE")
public class CustomSchedule implements Serializable {

	private static final long serialVersionUID = 5269345207014488526L;

	@Id
	@Column
	private String idx;
	
	@Column
	private String name;
	
	@Column
	private String jobIdx;
	
	@Column
	private String triggerIdx;
	
	@Column
	private String insertDate;
}
