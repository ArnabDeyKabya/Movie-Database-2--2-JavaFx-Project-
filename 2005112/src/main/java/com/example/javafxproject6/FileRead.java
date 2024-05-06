package com.example.javafxproject6;

import java.io.BufferedReader;
import java.io.FileReader;

public class FileRead {
    private static final String INPUT_FILE_NAME = "movies.txt";
    public void readfile(MoveiData object1, MoveiData object2) throws Exception{
        BufferedReader br = new BufferedReader(new FileReader(INPUT_FILE_NAME));
        while (true) {
            String line = br.readLine();
            if(line != null)
            {
                String[] out = line.split(",");
                String name = out[0];
                int year = Integer.parseInt(out[1]);
                String[] genres = new String[3];
                genres[0] = out[2];
                genres[1] = out[3];
                genres[2] = out[4];
                int run_time = Integer.parseInt(out[5]);
                String company = out[6];
                long money = Long.parseLong (out[7]);
                long income = Long.parseLong (out[8]);
                Movies ob = new Movies(name, year, genres, run_time, company,money, income);
                object1.moviesList1.add(ob);
                object2.moviesList2.add(ob);
            }
            if (line == null) break;
        }
        br.close();
    }
}
