package com.example.drew.tournamentorganizer;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Drew on 11/5/18.
 */

public class TournamentListFragment extends Fragment{

    RecyclerView recyclerView;
    TournamentAdapter adapter;

    List<TournamentCard> cardList;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        cardList = new ArrayList<>();
        recyclerView = (RecyclerView) getActivity().findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);

        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

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
                R.drawable.green_team,
                R.drawable.orange_team
        ));

        return inflater.inflate(R.layout.fragment_tournament_list, null);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        configureFAB();
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }

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
