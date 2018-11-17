package com.example.tjelvarguo.lab1.lab2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Tjelvar Guo on 2018-11-17.
 */

public class DataProvider {

    public static HashMap<String, List<String>> getInfo() {
        HashMap<String, List<String>> movieDetails = new HashMap<String, List<String>>();
        List<String> actionMovies = new ArrayList<>();
        addItemsToList(actionMovies, new String[]{"Die Hard", "The Predator", "Robocop"});

        List<String> romanticMovies = new ArrayList<>();
        addItemsToList(romanticMovies, new String[]{"Love Actually", "Notting hill"});

        List<String> horrorMovies = new ArrayList<>();
        addItemsToList(horrorMovies, new String[]{"Get Out", "The Conjuring", "Excorsist", });

        movieDetails.put("Action Movies", actionMovies);
        movieDetails.put("Romantic Movies", romanticMovies);
        movieDetails.put("Horror Movies", horrorMovies);

        return movieDetails;
    }

    private static  void addItemsToList(List<String> list, String[] items ) {
        for (String item : items) {
            list.add(item);
        }
    }

}
