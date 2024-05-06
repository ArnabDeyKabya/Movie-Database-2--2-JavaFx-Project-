package com.example.javafxproject6;

import java.sql.SQLOutput;
import java.util.*;
import java.util.Comparator;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class MoveiData {
    List<Movies> moviesList1 = new ArrayList();
    List<Movies> moviesList2 = new ArrayList();
    List<Movies> moviesList3 = new ArrayList();
    MoveiData()
    {;}
    public ArrayList<Movies> Search_production_company_forFX(String s)
    {
        moviesList3.clear();
        for(Movies mov : moviesList1)
        {
            if(mov.getProduction_company().equalsIgnoreCase(s))
            {
                moviesList3.add(mov);
            }
        }
        return (ArrayList<Movies>) moviesList3;
    }
    public ArrayList<Movies> Most_recent_movies_forFX()
    {
        List<Movies> List1 = new ArrayList();
        int year = -1;
        Collections.sort(AnotherLoginPageController.titlelist, new sortRecentMovies());
        year = AnotherLoginPageController.titlelist.get(0).getRelease_year();
        for(int i = 0; i<AnotherLoginPageController.titlelist.size(); i++)
        {
            Movies m = AnotherLoginPageController.titlelist.get(i);
            if(m.getRelease_year()==year)
            {
                List1.add(m);
            }
        }
        return (ArrayList<Movies>) List1;
    }
    public ArrayList<Movies> Movies_with_max_revenue_forfx()
    {
        List<Movies> List2 = new ArrayList();
        Collections.sort(AnotherLoginPageController.titlelist, new sortMaximumRev());
        long revenue = AnotherLoginPageController.titlelist.get(0).getRevenue();
        for(int i = 0; i<AnotherLoginPageController.titlelist.size(); i++)
        {
            Movies m =AnotherLoginPageController.titlelist.get(i);
            if(m.getRevenue()==revenue)
            {
                List2.add(m);
            }
        }
        return (ArrayList<Movies>) List2;
    }
    public long total_profit_forfx()
    {
        long sum_profit = 0;
        for(int i = 0; i<AnotherLoginPageController.titlelist.size(); i++)
        {
            Movies m =AnotherLoginPageController.titlelist.get(i);
            sum_profit += m.getProfit();

        }
        return sum_profit;
    }

    public void add_movies_for_fx(Movies mov) throws Exception {
        moviesList1.add(mov);
        moviesList2.add(mov);
        writefile();
    }

    public void transfer_movie_for_fx(String name, String production)
    {
        System.out.println("Hello");
        Movies mov = null;
        for(int i = 0; i<moviesList1.size(); i++)
       {
           Movies m = moviesList1.get(i);
           if(m.getTitle().equalsIgnoreCase(name))
           {
               mov = new Movies(name, m.getRelease_year(), m.getGenere(), m.getRunning_time(), production, m.getBudget(), m.getRevenue());
               moviesList1.remove(m);
               break;
           }
       }
        System.out.println(mov.getProduction_company());
        moviesList1.add(mov);
    }

    public ArrayList<Movies> show_all_movies_fo_fx()
    {
        List<Movies> List2 = new ArrayList();
        for(int i = 0; i<AnotherLoginPageController.titlelist.size(); i++)
        {
            Movies m =AnotherLoginPageController.titlelist.get(i);
            List2.add(m);
        }
        return (ArrayList<Movies>) List2;
    }

    public void printinfo(Movies n)
    {
        System.out.println("Movie Title: " + n.getTitle());
        System.out.println("Movie Releasing Year: " + n.getRelease_year());
        System.out.println("Movie Genre 1: " + n.getGenere()[0]);
        System.out.println("Movie Genre 2: " + n.getGenere()[1]);
        if(n.getGenere()[2] != null) System.out.println("Movie Genre 3: " + n.getGenere()[2]);
        System.out.println("Production Company : " + n.getProduction_company());
        System.out.println("Movie's Running Time: " + n.getRunning_time() + " minutes");
        System.out.println("Budget : " + n.getBudget());
        System.out.println("Revenue : " + n.getRevenue());
        System.out.println();
        System.out.println();
    }
    public int search_by_movie_title(String s)
    {
        int flag =0;
        int i;
        for( i = 0; i<AnotherLoginPageController.titlelist.size(); i++)
        {
            Movies m = AnotherLoginPageController.titlelist.get(i);
            if(m.getTitle().equalsIgnoreCase(s)){
                flag = 1;
                break;
            }
        }
       if(flag == 0) return 0;
       else return 1;
    }
    public ArrayList<Movies> search_by_release_year(int year)
    {
        List<Movies> List2 = new ArrayList();
        int i;
        for( i = 0; i<moviesList1.size(); i++)
        {
            Movies m = moviesList1.get(i);
            if(m.getRelease_year() == year)
            {
                List2.add(m);
            }
        }
        return (ArrayList<Movies>) List2;
    }
    public int search_by_production_company(String s)
    {
        System.out.println("Size of MovieList1 : "+moviesList1.size());
        int i, flag = 0;
        for( i = 0; i<moviesList1.size(); i++)
        {
            Movies m = moviesList1.get(i);
            if(m.getProduction_company().equalsIgnoreCase(s))
            {
                flag = 1;
                break;

            }
        }
        if(flag == 0) return 0;
        else return 1;
    }
    public ArrayList<Movies> search_by_running_time(int time1, int time2)
    {
        List<Movies> List8 = new ArrayList();
        int i;
        for( i = 0; i<moviesList1.size(); i++)
        {
            Movies m = moviesList1.get(i);
            if(m.getRunning_time() <= time1 && m.getRunning_time() >= time2)
            {
                List8.add(m);
            }
        }
        return (ArrayList<Movies>) List8;
    }
    public ArrayList<Movies> search_by_genre(String s)
    {
        List<Movies> List2 = new ArrayList();
        int i, j;
        for( i = 0; i<moviesList1.size(); i++)
        {
            Movies m = moviesList1.get(i);
            for(j = 0; j<3; j++)
            {
                if(m.getGenere()[j].equalsIgnoreCase(s))
                {
                    List2.add(m);
                }
            }
        }
        return (ArrayList<Movies>) List2;
    }
    public void add_movies() throws Exception {
        int flag = 1, i, year, time;
        String[] generes = new String[3];
        String name, pr_name;
        long bud, rev;
        System.out.println("Input the movie information: ");
        Scanner scn = new Scanner(System.in);
        System.out.println("Enter The Movie Title: ");
        name = scn.nextLine();
        for(i = 0; i<moviesList1.size(); i++)
        {
            Movies m = moviesList1.get(i);
            if(m.getTitle().equalsIgnoreCase(name))
            {
                flag = 0;
                System.out.println("ERROR !!!....The movie already exists..");
            }
        }
        if(flag == 1)
        {
            System.out.println("Enter the release year : ");
            year = scn.nextInt();
            scn.nextLine();
            System.out.println("Enter the movei genre: ");
            for (int j = 0; j<3; j++)
            {
                System.out.println("Enter genre "+ (j+1) + " :");
                generes[j] = scn.nextLine();
            }
            System.out.println("Enter the running time: ");
            time = scn.nextInt();
            scn.nextLine();
            System.out.println("Enter the production company: ");
            pr_name = scn.nextLine();
            System.out.println("Enter the budget: ");
            bud = scn.nextLong();
            System.out.println("Enter the Revene: ");
            rev = scn.nextLong();
            Movies mov = new Movies(name, year, generes, time, pr_name, bud, rev);
            moviesList1.add(mov);
            moviesList2.add(mov);
            writefile();
        }
    }
    public void writefile() throws Exception {
        BufferedWriter bw = new BufferedWriter(new FileWriter("movies.txt"));
        for (Movies mov : moviesList1){
            bw.append(mov.getTitle());
            bw.append(",");
            String s1 = Integer.toString(mov.getRelease_year());
            bw.append(s1);
            bw.append(",");
            bw.append(mov.getGenere()[0]);
            bw.append(",");
            bw.append(mov.getGenere()[1]);
            bw.append(",");
            bw.append(mov.getGenere()[2]);
            bw.append(",");
            String s2 = Integer.toString(mov.getRunning_time());
            bw.append(s2);
            bw.append(",");
            bw.append(mov.getProduction_company());
            bw.append(",");
            String s3 = Long.toString(mov.getBudget());
            bw.append(s3);
            bw.append(",");
            String s4 = Long.toString(mov.getRevenue());
            bw.append(s4);
            bw.append(System.lineSeparator());
        }
        bw.close();
    }
}
