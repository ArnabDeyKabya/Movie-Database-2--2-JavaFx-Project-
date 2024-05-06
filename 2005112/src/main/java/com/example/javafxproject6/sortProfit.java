package com.example.javafxproject6;

import java.util.Comparator;
class sortProfit implements Comparator<Movies> {
    public int compare(Movies m1, Movies m2)
    {
        return (int) -(m1.getProfit()- m2.getProfit());
    }

}
