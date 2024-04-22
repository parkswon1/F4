package project.collections.movie.compare;

import project.collections.movie.Movie;

import java.util.Comparator;

public class ReleaseYearComparator implements Comparator<Movie> {
    @Override
    public int compare(Movie o1, Movie o2) {
        return Integer.compare(o2.getYear(), o1.getYear());
    }
}
