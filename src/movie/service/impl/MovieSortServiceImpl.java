package movie.service.impl;

import movie.ExceptionData;
import movie.db.DataBase;
import movie.models.Movie;

import java.util.Comparator;

public class MovieSortServiceImpl {
    public void sortMovieByName(String ascOrDesc) {
        if (ascOrDesc.equals("asc")) {
            DataBase.movies.sort(new Comparator<Movie>() {
                @Override
                public int compare(Movie o1, Movie o2) {
                    return o1.getName().compareTo(o2.getName());
                }
            });
            System.out.println(DataBase.movies);
        } else if (ascOrDesc.equals("desc")) {
            DataBase.movies.sort(new Comparator<Movie>() {
                @Override
                public int compare(Movie o1, Movie o2) {
                    return o2.getName().compareTo(o1.getName());
                }
            });
            System.out.println("Sorted movies (" + ascOrDesc + "): " + DataBase.movies);
        } else {
            try {
                throw new ExceptionData("Please choice 'asc' or 'desc'!!!");
            } catch (ExceptionData e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public void sortByYear(String ascOrDesc) {
        if (ascOrDesc.equals("asc")){
            DataBase.movies.sort(new Comparator<Movie>() {
                @Override
                public int compare(Movie o1, Movie o2) {
                    return o1.getYear().compareTo(o2.getYear());
                }
            });
            System.out.println("Sorted movies (" + ascOrDesc + "): " + DataBase.movies);
        }else if (ascOrDesc.equals("desc")){
            DataBase.movies.sort(new Comparator<Movie>() {
                @Override
                public int compare(Movie o1, Movie o2) {
                    return o2.getYear().compareTo(o1.getYear());
                }
            });
            System.out.println("Sorted movies (" + ascOrDesc + "): " + DataBase.movies);
        }else {
            try {
                throw new ExceptionData("Please choice 'asc' or 'desc'!!!");
            } catch (ExceptionData e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public void sortByProducer(String nameOrLastName) {
        if (nameOrLastName.equals("name")){
            DataBase.movies.sort(new Comparator<Movie>() {
                @Override
                public int compare(Movie o1, Movie o2) {
                    return o1.getProducer().getFirstName().compareTo(o2.getProducer().getFirstName());
                }
            });
            System.out.println("Sorted movies (" + nameOrLastName + "): " + DataBase.movies);
        }else if (nameOrLastName.equals("last name")){
            DataBase.movies.sort(new Comparator<Movie>() {
                @Override
                public int compare(Movie o1, Movie o2) {
                    return o1.getProducer().getLastName().compareTo(o2.getProducer().getLastName());
                }
            });
            System.out.println("Sorted movies (" + nameOrLastName + "): " + DataBase.movies);
        }

    }

}
