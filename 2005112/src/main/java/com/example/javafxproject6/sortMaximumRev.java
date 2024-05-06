package com.example.javafxproject6;

import java.util.Comparator;
class sortMaximumRev implements Comparator<Movies> {
    public int compare(Movies m1, Movies m2)
    {
        return (int) -(m1.getRevenue()- m2.getRevenue());
    }

}
