package unit_testing;

import java.awt.*;
import java.util.ArrayList;
import java.util.stream.IntStream;

public class Store {
    private ArrayList<Movie> movies = new ArrayList<>();

    public boolean addMovie(Movie movie) {
        if(movies.contains(movie)) {
            System.out.println("Movie already exists in collection");
            return false;
        }
        movies.add(movie);
        return true;
    }

    public Movie getMovie(int index) {
        return movies.get(index);
    }

    public boolean contains(Movie movie) {
        return this.movies.contains(movie);
    }

    public void sellMovie(String title) {
//        for(int i = 0; i < this.movies.size(); i++) {
//            if(this.movies.get(i).getName().equals(title)) {
//                this.movies.remove(i);
//            }
//        }
        if(this.getMovieIndex(title) == -1) {
            throw new IllegalStateException("Movie does not exist");
        }
        if(!this.movies.get(getMovieIndex(title)).isAvailable()) {
            throw new IllegalStateException("Cannot sell, movie is currently rented out");
        }
        this.movies.removeIf((movie) -> {
            return movie.getName().equals(title);
        });
    }

    public int getMovieIndex(String title) {
//        for(int i = 0; i < movies.size(); i++) {
//            if(movies.get(i).getName().equals(title)) {
//                return i;
//            }
//        }
//        return -1;
        return IntStream.range(0, this.movies.size())
                .filter((i) -> {
                    return this.movies.get(i).getName().equals(title);
                })
                .findFirst()
                .orElse(-1);
    }

    public void rentMovie(String title) {
        int index = this.getMovieIndex(title);
        if(index > -1) {
            System.out.println("Movie is being rented to you");
            movies.get(index).setIsAvailable(false);
        } else {
            System.out.println("Movie does not exist");
        }

    }
}
