package movie;

import movie.db.DataBase;
import movie.enums.Genre;
import movie.models.Actor;
import movie.models.Movie;
import movie.models.Producer;
import movie.service.impl.MovieServiceImpl;
import movie.service.impl.MovieSortServiceImpl;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;


public class Main {
       static MovieSortServiceImpl movieSortService = new MovieSortServiceImpl();
    public static void main(String[] args) {
        MovieServiceImpl movieService = new MovieServiceImpl();

        List<Actor> actors = new LinkedList<>(Arrays.asList(
                new Actor("Aibek","chon ata"),
                new Actor("Baiel","boss"),
                new Actor("Ainura","kichinekei kyz"),
                new Actor("Askat","koshuna"),
                new Actor("Nursultan","kachok"),
                new Actor("Nurbol","balasy"),
                new Actor("Muhammed","moldo"),
                new Actor("Gulaiym","kelini"),
                new Actor("Bekmyrza","chon atanyn dosu")
        ));
        DataBase.movies.add(new Movie("el emne deit", LocalDate.of(2004,12,24), Genre.COMEDY, new Producer("Kanchoro","Maraimov"),actors));
        DataBase.movies.add(new Movie("spaidarman", LocalDate.of(1991,4,13), Genre.ACTION, new Producer("Baiel","Karybaev"),actors));
        DataBase.movies.add(new Movie("man", LocalDate.of(2024,5,3), Genre.CRIME, new Producer("Aibek","Duisho uulu"),actors));
        DataBase.movies.add(new Movie("malysh", LocalDate.of(2000,6,10), Genre.DOCUMENTARY, new Producer("Muhammed","Mambetkulov"),actors));
        while (true){
            System.out.print("""
                    -------  Movie  ---------
                    1.Get All Movies
                    2.Find Movie By Full Name Or PartName
                    3.Find Movie By Actor Name
                    4.Find Movie By Year
                    5.Find Movie By Producer
                    6.Find Movie By Genre
                    7.Find Movie By Role
                    8.Sort
                    0.logout
                    """);
            System.out.print("choice: ");
            String choice = new Scanner(System.in).nextLine();

            switch (choice){
                case "1" -> System.out.println(movieService.getAllMovies());
                case "2" -> System.out.println(movieService.findMovieByFullNameOrPartName(getName()));
                case "3" -> System.out.println(movieService.findMovieByActorName(getActorName()));
                case "4" -> System.out.println(movieService.findMovieByYear(getYearMovie()));
                case "5" -> System.out.println(movieService.findMovieByProducer(getProducer()));
                case "6" -> System.out.println(movieService.findMovieByGenre(getGenre()));
                case "7" -> System.out.println(movieService.findMovieByRole(getRole()));
                case "8" -> sort();
                case "0" ->{
                    System.out.println("Logout...");
                    return;
                }

            }
        }
    }
    public static void sort(){
        System.out.print("""
               1. sort Movie By Name
               2. sort By Year
               3. sort By Producer
                """);
        System.out.print("choice: ");
        switch (new Scanner(System.in).nextLine()){
            case "1" ->{
                System.out.println("1. -from A to Z");
                System.out.println("2. -from Z to A");
                System.out.print("choice: ");
                String s = new Scanner(System.in).nextLine();
                switch (s){
                    case "1" -> movieSortService.sortMovieByName("asc");
                    case "2" -> movieSortService.sortMovieByName("desc");
                    default -> System.out.println("Error choice!!");
                }
            }
            case "2" -> {
                System.out.println("1. -Ascending");
                System.out.println("2. -Descending");
                System.out.print("choice: ");
                String s = new Scanner(System.in).nextLine();
                switch (s){
                    case "1" -> movieSortService.sortByYear("asc");
                    case "2" -> movieSortService.sortByYear("desc");
                    default -> System.out.println("Error choice!!");
                }
            }
            case "3" -> {
                System.out.println("1. -Name");
                System.out.println("2. -Last name");
                System.out.print("choice: ");
                String s = new Scanner(System.in).nextLine();
                switch (s){
                    case "1" -> movieSortService.sortByProducer("name");
                    case "2" -> movieSortService.sortByProducer("last name");
                    default -> System.out.println("Error choice!!");
                }
            }
        }

    }
    public static String getRole(){
        System.out.print("write Role: ");
        return new Scanner(System.in).nextLine();
    }
    public static Genre getGenre(){
        System.out.print("write genre: ");
        String s = new Scanner(System.in).nextLine().toUpperCase();
        Genre f = null;
        switch (s){
            case "COMEDY" -> f = Genre.COMEDY;
            case "ACTION" -> f = Genre.ACTION;
            case "CRIME" -> f = Genre.CRIME;
            case "DOCUMENTARY" -> f = Genre.DOCUMENTARY;
            default -> System.out.println("Error choice!!");
        }
        return f;
    }
    public static String getName(){
        System.out.print("write Name Movie: ");
        return new Scanner(System.in).nextLine();
    }
    public static String getActorName(){
        System.out.print("write Actor Name : ");
        return new Scanner(System.in).nextLine();
    }
    public static LocalDate getYearMovie(){
        System.out.print("write Year Movie : ");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String s;
        do {
           s = new Scanner(System.in).nextLine();
            try {
                LocalDate d = LocalDate.parse(s,formatter);
                System.out.println(d);
                return d;
            } catch (DateTimeParseException e) {
                System.out.print("Invalid date format. Please use 'yyyy-MM-dd': ");
            }

        }while (s != null);
        return null;
    }

    public static String getProducer(){
        System.out.print("write full name Producer: ");
        return new Scanner(System.in).nextLine();}
}