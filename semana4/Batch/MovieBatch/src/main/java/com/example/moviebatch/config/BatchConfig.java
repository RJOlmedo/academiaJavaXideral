package com.example.moviebatch.config;

import com.example.moviebatch.model.Movie;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.database.JpaItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.batch.item.support.CompositeItemProcessor;
import org.springframework.batch.item.support.builder.CompositeItemProcessorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.transaction.PlatformTransactionManager;

import jakarta.persistence.EntityManagerFactory;

@Configuration
@EnableBatchProcessing
public class BatchConfig {

    private final JobBuilderFactory jobBuilderFactory;
    private final StepBuilderFactory stepBuilderFactory;

    public BatchConfig(JobBuilderFactory jobBuilderFactory, StepBuilderFactory stepBuilderFactory) {
        this.jobBuilderFactory = jobBuilderFactory;
        this.stepBuilderFactory = stepBuilderFactory;
    }

    @Bean
    public Job importMovieJob(JobRepository jobRepository, Step step1) {
        return jobBuilderFactory.get("importMovieJob")
                .incrementer(new RunIdIncrementer())
                .flow(step1)
                .end()
                .build();
    }

    @Bean
    public Step step1(JobRepository jobRepository, PlatformTransactionManager transactionManager,
                      FlatFileItemReader<Movie> reader, JpaItemWriter<Movie> writer) {
        return stepBuilderFactory.get("step1")
                .<Movie, Movie>chunk(10)
                .reader(reader)
                .processor(compositeProcessor())
                .writer(writer)
                .build();
    }

    @Bean
    public FlatFileItemReader<Movie> reader() {
        return new FlatFileItemReaderBuilder<Movie>()
                .name("movieItemReader")
                .resource(new ClassPathResource("movies.csv"))
                .delimited()
                .names(new String[]{"id", "title", "genre", "year"})
                .targetType(Movie.class)
                .build();
    }

    @Bean
    public MovieGenreFilterProcessor processor() {
        return new MovieGenreFilterProcessor();
    }

    @Bean
    public JpaItemWriter<Movie> writer(EntityManagerFactory entityManagerFactory) {
        JpaItemWriter<Movie> writer = new JpaItemWriter<>();
        writer.setEntityManagerFactory(entityManagerFactory);
        return writer;
    }

    @Bean
    public CompositeItemProcessor<Movie, Movie> compositeProcessor() {
        return new CompositeItemProcessorBuilder<Movie, Movie>()
                .delegates(processor()) // Add other processors if needed
                .build();
    }
}
