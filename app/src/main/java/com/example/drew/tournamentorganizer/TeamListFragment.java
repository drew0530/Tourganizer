package com.example.drew.tournamentorganizer;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.support.v4.app.Fragment;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import static android.app.Activity.RESULT_OK;

/**
 * Created by Drew on 10/10/18.
 */

public class TeamListFragment extends Fragment {
    RecyclerView recyclerView;
    List<TeamCard> cardList;
    static final int ADD_TEAM_REQUEST = 1;  // The request code'
    TeamAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        DatabaseHelper db = new DatabaseHelper(getActivity());
        View view = inflater.inflate(R.layout.fragment_team_list, null);
        cardList = new ArrayList<>();
        recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        Cursor data = db.getTeamData();

        //Getting data from DB and displaying it
        if(data.getCount() != 0){
            while(data.moveToNext()){
                cardList.add(new TeamCard(
                        data.getInt(0),
                        data.getString(1),
                        data.getString(2)
                ));
            }
        }

        adapter = new TeamAdapter(getActivity(), cardList);
        recyclerView.setAdapter(adapter);

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        configureFAB();
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == ADD_TEAM_REQUEST) {
            // Make sure the request was successful
            if(resultCode == RESULT_OK){
                System.out.println("INTENT DATA : " + data.getStringExtra("NEW_TEAM_ID") + " " + data.getStringExtra("NEW_TEAM_NAME") + " " + data.getStringExtra("NEW_TEAM_COMMENTS"));
                // add the data into a new card
                cardList.add( new TeamCard(
                        Integer.parseInt(data.getStringExtra("NEW_TEAM_ID")),
                        data.getStringExtra("NEW_TEAM_NAME"),
                        data.getStringExtra("NEW_TEAM_COMMENT")
                ));
                adapter.notifyDataSetChanged();
                recyclerView.setAdapter(adapter);
                recyclerView.invalidate();
            }

        }
    }

    //function to instantiate the Floating action button
    private void configureFAB() {
        FloatingActionButton fab = getActivity().findViewById(R.id.teamfab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), NewTeamActivity.class);
                startActivityForResult(intent, ADD_TEAM_REQUEST);
            }
        });
    }

}