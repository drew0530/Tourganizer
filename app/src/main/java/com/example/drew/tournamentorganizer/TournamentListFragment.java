package com.example.drew.tournamentorganizer;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Drew on 11/5/18.
 */

public class TournamentListFragment extends Fragment{

    RecyclerView recyclerView;
    List<TournamentCard> cardList;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tournament_list, null);
        cardList = new ArrayList<>();
        recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);

        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        // Adding mock data to display in RecyclerView
        cardList.add(new TournamentCard(
                "ExampleTournament1",
                "Team Red",
                "Team Blue",
                "12-28-2018",
                R.drawable.red_team,
                R.drawable.blue_team
        ));

        cardList.add(new TournamentCard(
                "ExampleTournament2",
                "Team Orange",
                "Team Green",
                "1-14-2019",
                R.drawable.orange_team,
                R.drawable.green_team
        ));

        // Adding mock data to display in RecyclerView
        cardList.add(new TournamentCard(
                "ExampleTournament4",
                "Team Red",
                "Team Orange",
                "3-14-2019",
                R.drawable.red_team,
                R.drawable.orange_team
        ));

        cardList.add(new TournamentCard(
                "ExampleTournament5",
                "Team Blue",
                "Team Green",
                "5-30-2019",
                R.drawable.blue_team,
                R.drawable.green_team
        ));

        //creating recyclerview adapter
        TournamentAdapter adapter = new TournamentAdapter(getActivity(), cardList);

        //setting adapter to recyclerview
        recyclerView.setAdapter(adapter);

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        configureFAB();
//        configureTCards();
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }

    //function to instantiate the onclick for tournament cards
    private void configureTCards() {
        CardView tCards = getActivity().findViewById(R.id.cardView);
        tCards.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), TournamentInfoActivity.class);
                startActivity(intent);
            }
        });
    }

    //function to instantiate the Floating action button
    private void configureFAB() {
        FloatingActionButton fab = getActivity().findViewById(R.id.tournamentfab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), NewTournamentActivity.class);
                startActivity(intent);
            }
        });
    }
}
