package com.example;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;

/**
 * User: olav
 * Date: 01.10.2019
 * Time: 15:42
 */
@Configuration
public class ScheduledConfigurerConfiguration implements SchedulingConfigurer {

    @Override
    public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {

        ThreadPoolTaskScheduler taskScheduler = new ThreadPoolTaskScheduler();
        taskScheduler.setPoolSize(5);// Set the pool of threads
        taskScheduler.setThreadNamePrefix("solakerbp-s-t");
        taskScheduler.initialize();
        taskRegistrar.setTaskScheduler(taskScheduler);

    }

    @Bean
    @ConditionalOnProperty(
            prefix = "sol.work-permit-task",
            name = "enabled",
            matchIfMissing = true,
            havingValue = "true"
    )
    WorkPermitJob workPermitJob(){
        return new WorkPermitJob();
    }

}
