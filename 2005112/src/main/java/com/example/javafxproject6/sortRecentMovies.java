package com.example.javafxproject6;

import java.util.Comparator;
class sortRecentMovies implements Comparator<Movies> {
    public int compare(Movies m1, Movies m2)
    {
        return (int) -(m1.getRelease_year()- m2.getRelease_year());
    }

}
