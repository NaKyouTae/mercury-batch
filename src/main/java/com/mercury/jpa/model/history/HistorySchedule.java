package com.mercury.jpa.model.history;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
@Entity
@Table(name="MERCURY_TB_HISTORY_SCHEDULE")
public class HistorySchedule implements Serializable{
	
	private static final long serialVersionUID = 1703105043060750938L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private long idx;
	
	@Column
	private String jobName;
	
	@Column
	private String scheduleName;
	
	@Column
	private String triggerName;
	
	@Column
	private String cron;
	
	@Column
	private String startDate;
	
	@Column
	private String type;
	
	@Lob
	@Column(columnDefinition = "text")
	private String message;
}
