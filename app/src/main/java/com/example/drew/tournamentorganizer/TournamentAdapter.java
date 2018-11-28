package com.example.drew.tournamentorganizer;

import android.content.Context;
import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Drew on 10/10/18.
 */

public class TournamentAdapter extends RecyclerView.Adapter<TournamentAdapter.TournamentViewHolder>{

    private Context ctx;
    private List<TournamentCard> tournamentList;

    public TournamentAdapter(Context ctx, List<TournamentCard> cardList) {
        this.ctx = ctx;
        this.tournamentList = cardList;
    }

    @Override
    public TournamentViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(ctx);
        View view = inflater.inflate(R.layout.tournament_card_layout, null);
        return new TournamentViewHolder(view);
    }

    @Override
    public void onBindViewHolder(TournamentViewHolder holder, int position) {
        TournamentCard tournament = tournamentList.get(position);

        holder.textViewTournamentName.setText(tournament.getTournamentName());
        holder.textViewDate.setText(String.valueOf(tournament.getDate()));
        holder.textViewTeam1Name.setText(tournament.getTeam1Name());
        holder.textViewTeam2Name.setText(tournament.getTeam2Name());

        holder.imageViewTeam1.setImageDrawable(ctx.getResources().getDrawable(tournament.getTeam1Image()));
        holder.imageViewTeam2.setImageDrawable(ctx.getResources().getDrawable(tournament.getTeam2Image()));

        holder.parentLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ctx, TournamentInfoActivity.class);
                // !!!! use intent.putExtra("extraName", value) for each thing you want to pass to the next activity here!
                ctx.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return tournamentList.size();
    }

    class TournamentViewHolder extends RecyclerView.ViewHolder {

        ImageView imageViewTeam1, imageViewTeam2;
        TextView textViewTournamentName, textViewDate, textViewTeam1Name, textViewTeam2Name;
        RelativeLayout parentLayout;

        public TournamentViewHolder(View itemView) {
            super(itemView);

            parentLayout = itemView.findViewById(R.id.tournament_card);
            imageViewTeam1 = itemView.findViewById(R.id.team1Image);
            imageViewTeam2 = itemView.findViewById(R.id.team2Image);
            textViewTournamentName = itemView.findViewById(R.id.tournamentName);
            textViewDate = itemView.findViewById(R.id.dateTime);
            textViewTeam1Name = itemView.findViewById(R.id.team1Text);
            textViewTeam2Name = itemView.findViewById(R.id.team2Text);
        }
    }
}
