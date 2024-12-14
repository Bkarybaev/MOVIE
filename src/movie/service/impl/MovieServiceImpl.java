package movie.service.impl;

import movie.db.DataBase;
import movie.enums.Genre;
import movie.models.Actor;
import movie.models.Movie;
import movie.service.MovieService;

import java.time.LocalDate;
import java.util.List;

public class MovieServiceImpl implements MovieService {

    @Override
    public List<Movie> getAllMovies() {
        return DataBase.movies;
    }

    @Override
    public Movie findMovieByFullNameOrPartName(String name) {
        for (Movie movie : DataBase.movies) {
            if (movie.getName().contains(name)){
                return movie;
            }
        }
        return null;
    }

    @Override
    public Movie findMovieByActorName(String actorName) {
        for (Movie movie : DataBase.movies) {
            for (Actor actor : movie.getActors()) {
                if (actor.getActorFullName().contains(actorName)){
                    return movie;
                }
            }
        }
        return null;
    }

    @Override
    public Movie findMovieByYear(LocalDate year) {
        for (Movie movie : DataBase.movies) {
            if (movie.getYear().equals(year)){
                return movie;
            }
        }
        return null;
    }

    @Override
    public Movie findMovieByProducer(String producerFullName) {
        for (Movie movie : DataBase.movies) {
            if (movie.getProducer().getFirstName().concat(" "+movie.getProducer().getLastName()).equals(producerFullName)){
                return movie;
            }
        }
        return null;
    }

    @Override
    public Movie findMovieByGenre(Genre genre) {
        for (Movie movie : DataBase.movies) {
            if (movie.getGenre().equals(genre)){
                return movie;
            }
        }
        return null;
    }

    @Override
    public Movie findMovieByRole(String role) {
        for (Movie movie : DataBase.movies) {
            for (Actor actor : movie.getActors()) {
                if (actor.getRole().equals(role)){
                    return movie;
                }
            }
            break;
        }
        return null;
    }
}
