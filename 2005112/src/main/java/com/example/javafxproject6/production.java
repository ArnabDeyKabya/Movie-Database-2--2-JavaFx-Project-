package com.example.javafxproject6;

import java.util.*;

public class production {
    public ArrayList<Movies> most_recent_movies(MoveiData object2, String s)
    {
        List<Movies> List1 = new ArrayList();
        int year = -1;
        Collections.sort(object2.moviesList2, new sortRecentMovies());
        for(int i = 0; i<object2.moviesList2.size(); i++)
        {
            Movies m = object2.moviesList2.get(i);
            if(m.getProduction_company().equalsIgnoreCase(s))
            {
                year = m.getRelease_year();
                break;
            }
        }
        for(int i = 0; i<object2.moviesList2.size(); i++)
        {
            Movies m = object2.moviesList2.get(i);
            if(m.getProduction_company().equalsIgnoreCase(s) && m.getRelease_year()==year)
            {
                List1.add(m);
            }
        }
        return (ArrayList<Movies>) List1;
    }
    public ArrayList<Movies> Movies_with_the_Maximum_Revenue(MoveiData object2, String s)
    {
        List<Movies> List2 = new ArrayList();
        Collections.sort(object2.moviesList2, new sortMaximumRev());
        long revenue = -1;
        for(int i = 0; i<object2.moviesList2.size(); i++)
        {
            Movies m = object2.moviesList2.get(i);
            if(m.getProduction_company().equalsIgnoreCase(s)) {
                revenue = m.getRevenue();
                break;
            }
        }
        for(int i = 0; i<object2.moviesList2.size(); i++)
        {
            Movies m = object2.moviesList2.get(i);
            if(m.getProduction_company().equalsIgnoreCase(s) && m.getRevenue()==revenue)
            {
                List2.add(m);
            }
        }
        return (ArrayList<Movies>) List2;
    }
    public long Total_Profit(MoveiData object2, String s)
    {
        long sum_profit = 0;
        for(int i = 0; i<object2.moviesList2.size(); i++)
        {
            Movies m = object2.moviesList2.get(i);
            if(m.getProduction_company().equalsIgnoreCase(s))
            {
                sum_profit += m.getProfit();
            }
        }
        return sum_profit;
    }
    public void list_of_moveis(MoveiData object2)
    {
        Map<String, Integer> hash = new HashMap<>();
        for(int i = 0; i<object2.moviesList2.size(); i++)
        {
            Movies m = object2.moviesList2.get(i);
            if(hash.get(m.getProduction_company()) == null){
                hash.put(m.getProduction_company(), 1);
            }
            else{
                hash.put(m.getProduction_company(), hash.get(m.getProduction_company())+1);
            }
        }
        for(Map.Entry<String, Integer> entry : hash.entrySet())
        {
            if(!entry.getKey().strip().equals(""))
                 System.out.println("Production Company: " +entry.getKey() +", Movies made: "+entry.getValue());
        }
    }
}
