package com.rickyolmedo.employeesystem.batch.config;

import com.rickyolmedo.employeesystem.batch.model.Employee;
import com.rickyolmedo.employeesystem.batch.processor.EmployeeProcessor;
import com.rickyolmedo.employeesystem.batch.reader.EmployeeReader;
import com.rickyolmedo.employeesystem.batch.writer.EmployeeWriter;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.beans.factory.annotation.Autowired;

@Configuration
@EnableBatchProcessing
public class BatchConfig {

    @Autowired
    private JobBuilderFactory jobBuilderFactory;

    @Autowired
    private StepBuilderFactory stepBuilderFactory;

    @Bean
    public Job processJob(Step step1) {
        return jobBuilderFactory.get("processJob")
                .incrementer(new RunIdIncrementer())
                .flow(step1)
                .end()
                .build();
    }

    @Bean
    public Step step1(EmployeeReader reader, EmployeeProcessor processor, EmployeeWriter writer) {
        return stepBuilderFactory.get("step1")
                .<Employee, Employee>chunk(10)
                .reader(reader)
                .processor(processor)
                .writer(writer)
                .build();
    }
}
