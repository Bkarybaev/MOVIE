package movie.models;

import movie.enums.Genre;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

public class Movie {

    private String name;
    private LocalDate year;
    private Genre genre;
    private Producer producer;
    private List<Actor> actors = new LinkedList<>();

    public Movie() {
    }

    public Movie(String name, LocalDate year, Genre genre, Producer producer, List<Actor> actors) {
        this.name = name;
        this.year = year;
        this.genre = genre;
        this.producer = producer;
        this.actors = actors;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getYear() {
        return year;
    }

    public void setYear(LocalDate year) {
        this.year = year;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public Producer getProducer() {
        return producer;
    }

    public void setProducer(Producer producer) {
        this.producer = producer;
    }

    public List<Actor> getActors() {
        return actors;
    }

    public void setActors(List<Actor> actors) {
        this.actors = actors;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "name='" + name + '\'' +
                ", year=" + year +
                ", genre=" + genre +
                ", producer=" + producer +
                ", actors=" + actors +
                '}'+"\n";
    }
}
