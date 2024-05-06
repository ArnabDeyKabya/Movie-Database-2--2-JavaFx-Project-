package com.example.javafxproject6;

import java.io.Serializable;
import java.lang.Math;
public class Movies implements Serializable {
    private String  title;
    private int release_year;
    private String [] genere = new String[3];
    private int running_time;
    private String production_company;
    private long budget;
    private long  revenue;
    private long profit;

    public void setTitle(String title) {
        this.title = title;
    }

    public void setRelease_year(int release_year) {
        this.release_year = release_year;
    }

    public void setGenere(String[] genere) {
        this.genere = genere;
    }

    public void setRunning_time(int running_time) {
        this.running_time = running_time;
    }

    public void setProduction_company(String production_company) {
        this.production_company = production_company;
    }

    public void setBudget(long budget) {
        this.budget = budget;
    }
    public void setRevenue(long revenue){
        this.revenue = revenue;
    }

    public String getTitle() {
        return title;
    }

    public int getRelease_year() {
        return release_year;
    }

    public String[] getGenere() {
        return genere;
    }

    public int getRunning_time() {
        return running_time;
    }

    public String getProduction_company() {
        return production_company;
    }

    public long getBudget() {
        return budget;
    }

    public long getRevenue() {
        return revenue;
    }

    public long getProfit() {
        return ((this.getRevenue() - this.getBudget()));
    }

    public Movies(String  title, int release_year, String [] genere, int running_time, String production_company, long budget, long  revenue )
    {
        this.title = title;
        this. release_year = release_year;
        this. genere[0] = genere[0];
        this. genere[1] = genere[1];
        this. genere[2] = genere[2];
        this.running_time = running_time;
        this.production_company = production_company;
        this.budget = budget;
        this.revenue = revenue;
    }
    public void printMovei()
    {
        System.out.println("Movie Title: " + getTitle());
        System.out.println("Movie Releasing Year: " + getRelease_year());
        System.out.println("Movie Genre 1: " + getGenere()[0]);
        System.out.println("Movie Genre 2: " + getGenere()[1]);
        if(getGenere()[2] != null) System.out.println("Movie Genre 3: " + getGenere()[2]);
        System.out.println("Production Company : " + getProduction_company());
        System.out.println("Movie's Running Time: " + getRunning_time() + " minutes");
        System.out.println("Budget : " + getBudget());
        System.out.println("Revenue : " + getRevenue());
        System.out.println();
        System.out.println();
    }
    private String genre1;
    private String genre2;
    private String genre3;

    public String getGenre1() {
        return this.genere[0];
    }

    public String getGenre3() {
        return this.genere[2];
    }

    public void setGenre3() {
        this.genre3 =this.genere[2];
    }

    public void setGenere1() {
        this.genre1 = this.genere[0];
    }

    public String getGenre2() {
        return this.genere[1];
    }

    public void setGenre2() {
        this.genre2 = this.genere[1];
    }
}
