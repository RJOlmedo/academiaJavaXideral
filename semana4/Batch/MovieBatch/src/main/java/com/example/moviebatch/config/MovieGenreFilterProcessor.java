package com.example.moviebatch.config;

import com.example.moviebatch.model.Movie;
import org.springframework.batch.item.ItemProcessor;

public class MovieGenreFilterProcessor implements ItemProcessor<Movie, Movie> {

    @Override
    public Movie process(Movie movie) throws Exception {
        // Filter only Action and Adventure movies
        if ("Action".equalsIgnoreCase(movie.getGenre()) || "Adventure".equalsIgnoreCase(movie.getGenre())) {
            return movie; // Keep the movie
        }
        return null; // Filter out the movie
    }
}