package com.competition.quartz.job;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

import org.quartz.CronTrigger;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.JobKey;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.quartz.impl.StdSchedulerFactory;
import org.quartz.impl.matchers.GroupMatcher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.CronTriggerFactoryBean;
import org.springframework.stereotype.Component;

import com.competition.quartz.service.user.UserQuartzService;


@Component
public class UserScheduleJob implements Job{
	
	@Autowired
	private UserQuartzService userQuartzService;
	
	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
//		userQuartzService.seUsers();
		
			try {
				Scheduler scheduler = new StdSchedulerFactory().getScheduler();
				
				for(String name : scheduler.getJobGroupNames()) {
					for(JobKey key : scheduler.getJobKeys(GroupMatcher.jobGroupEquals(name))) {
						String jobName = key.getName();
						String jobGroup = key.getGroup();
						
						List<CronTrigger> triggers = (List<CronTrigger>) scheduler.getTriggersOfJob(key);
						
						Trigger trigger = triggers.get(0);
						
						Date next = trigger.getNextFireTime();
						
						System.out.println("[Job Name] : " + jobName + " [Group Name] : " + jobGroup + " - " + next);
						System.out.println("[Trigger CronExpression] : " + triggers.get(0).getCronExpression());
						
						CronTriggerFactoryBean tf = new CronTriggerFactoryBean();
						
						tf.setJobDetail(scheduler.getJobDetail(key));
						tf.setName(jobName);
						tf.setGroup(jobGroup);
						tf.setCronExpression("*/20 * * * * ?");
						
						tf.afterPropertiesSet();
						
						trigger = tf.getObject();
						
						scheduler.rescheduleJob(trigger.getKey(), trigger);
						
					}
				}
			} catch (SchedulerException | ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
}