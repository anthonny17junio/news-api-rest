package com.news.api.news;

import com.news.api.news.applicationProperties.ApplicationProperties;
import com.news.api.news.tasks.CatchNewsTask;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

@Configuration
@EnableScheduling
@SpringBootApplication
public class NewsApplication implements SchedulingConfigurer {

	public static void main(String[] args) {
		SpringApplication.run(NewsApplication.class, args);
	}


	//Start - Schedule to catch news
	@Autowired
	private ApplicationProperties applicationProperties;

	@Bean
	public CatchNewsTask myBean() {
		return new CatchNewsTask();
	}

	@Bean(destroyMethod = "shutdown")
	public Executor taskExecutor() {
		return Executors.newScheduledThreadPool(100);
	}

	@Override
	public void configureTasks(ScheduledTaskRegistrar scheduledTaskRegistrar) {
		//Kill the task
		scheduledTaskRegistrar.setScheduler(taskExecutor());
		//Add a triggerTask
		scheduledTaskRegistrar.addTriggerTask(this::run, triggerContext -> {
			Calendar nextExecutionTime = new GregorianCalendar();
			Date lastActualExecutionTime = triggerContext.lastActualExecutionTime();
			nextExecutionTime.setTime(lastActualExecutionTime != null ? lastActualExecutionTime : new Date());
			//Here get the time that is in application.properties and schedule the new task
			nextExecutionTime.add(Calendar.SECOND, applicationProperties.getTime());
			return nextExecutionTime.getTime();
		});
	}

	private void run() {
		try {
			myBean().catchNews();
		} catch (ParserConfigurationException | SAXException | IOException | TransformerException e) {
			e.printStackTrace();
		}
	}
	//End - Schedule to catch news
}
