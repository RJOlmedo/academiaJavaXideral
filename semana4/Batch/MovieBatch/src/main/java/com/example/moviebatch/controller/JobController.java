package com.example.moviebatch.controller;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/jobs")
public class JobController {

    @Autowired
    private JobLauncher jobLauncher;

    @Autowired
    private Job importMovieJob;

    @PostMapping("/importMovies")
    public void importMovies() throws Exception {
        jobLauncher.run(importMovieJob, new org.springframework.batch.core.JobParameters());
    }
}