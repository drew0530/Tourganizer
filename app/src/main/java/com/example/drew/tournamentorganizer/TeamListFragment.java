package com.example.drew.tournamentorganizer;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.support.v4.app.Fragment;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Drew on 10/10/18.
 */

public class TeamListFragment extends Fragment {

    RecyclerView recyclerView;
    List<TeamCard> cardList;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tournament_list, null);
        cardList = new ArrayList<>();
        recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);

        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        // Adding mock data to display in RecyclerView
        //TODO: make this a loop to add team cards
            cardList.add(new TeamCard(
                "Gay Boys for 1",
                "Drew is Gay",
                69
            ));


        //creating recyclerview adapter
        TeamAdapter adapter = new TeamAdapter(getActivity(), cardList);

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

    //function to instantiate the Floating action button
    private void configureFAB() {
        FloatingActionButton fab = getActivity().findViewById(R.id.teamfab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), NewTeamActivity.class);
                startActivity(intent);
            }
        });
    }
}