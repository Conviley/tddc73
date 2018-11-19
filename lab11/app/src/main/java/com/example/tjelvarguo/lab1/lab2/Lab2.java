package com.example.tjelvarguo.lab1.lab2;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.widget.EditText;
import android.widget.ExpandableListView;

import com.example.tjelvarguo.lab1.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Lab2 extends Activity {

    HashMap<String, List<String>> movieCollection;
    List<String> genres;
    ExpandableListView expList;
    EditText searchBar;
    MovieAdapter adapter;

    int selectedGenreIndex;
    int selectedMovieIndex;

    boolean onGenre;

    public enum MatchStatus {
        NO_MATCH, COMPLETE_MATCH, PARTIAL_MATCH
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab2);

        searchBar = findViewById(R.id.searchBar);
        searchBar.setText("/");
        searchBar.setSelection(searchBar.getText().length());

        expList = findViewById(R.id.movieList);

        movieCollection = DataProvider.getInfo();

        genres = new ArrayList<>(movieCollection.keySet());

        adapter = new MovieAdapter(this, movieCollection, genres, searchBar);

        expList.setAdapter(adapter);

        searchBar.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (charSequence.length() == 0) {
                    searchBar.setText("/");
                    searchBar.setSelection(searchBar.getText().length());
                    return;
                }
                String genre = "";
                String movie = "";

                onGenre = true;

                if (charSequence.charAt(0) != '/') {
                    searchBar.setError("Ogiltig Sökväg");
                } else {
                    for (int j = 1; j < charSequence.length(); j++) {
                        MatchStatus matchStatus = MatchStatus.PARTIAL_MATCH;
                        if (charSequence.charAt(j) == '/') {
                            onGenre = false;
                        } else if (onGenre) {
                            genre += charSequence.charAt(j);
                            matchStatus = lookForMatch(genres, genre);
                        } else {
                            movie += charSequence.charAt(j);
                            matchStatus = lookForMatch(movieCollection.get(genre), movie);
                        }
                        respondToMatchStatus(matchStatus, searchBar, onGenre, genre, movie);
                    }
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {
            }
        });
    }

    private MatchStatus lookForMatch(List<String> existingData, String input) {
        MatchStatus matchStatus = MatchStatus.NO_MATCH;
        for (int i = 0; i < existingData.size(); i++) {
            String data = existingData.get(i);
            if (data.equals(input)) {
                matchStatus = MatchStatus.COMPLETE_MATCH;
                if (onGenre) {
                    selectedGenreIndex = i;
                } else {
                    selectedMovieIndex = i;
                }
                return matchStatus;
            } else if (data.startsWith(input)){
                matchStatus = MatchStatus.PARTIAL_MATCH;
            }
        }

        return matchStatus;
    }

    private void respondToMatchStatus(MatchStatus matchStatus, EditText searchBar, boolean onGenre,
                                      String genre, String movie) {
        searchBar.setError(null);
        if ( matchStatus == MatchStatus.COMPLETE_MATCH) {
            if (onGenre) {
                expList.expandGroup(selectedGenreIndex);
            } else {
                int childIndex = expList.getFlatListPosition(ExpandableListView.
                        getPackedPositionForChild(selectedGenreIndex, selectedMovieIndex));
                expList.setItemChecked(childIndex, true);
            }

        } else if (matchStatus == MatchStatus.NO_MATCH) {
            searchBar.setError("Ogiltig Sökväg");
        }
    }
}
