package com.example.drew.tournamentorganizer;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class TeamAdapter extends RecyclerView.Adapter<TeamAdapter.TeamViewHolder> implements View.OnClickListener{
    private Context ctx;
    private List<TeamCard> teamList;

    public TeamAdapter(Context ctx, List<TeamCard> cardList) {
        this.ctx = ctx;
        this.teamList = cardList;
    }

    @Override
    public TeamAdapter.TeamViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(ctx);
        View view = inflater.inflate(R.layout.team_card_layout, null);
        return new TeamAdapter.TeamViewHolder(view);
    }

    @Override
    public void onBindViewHolder(TeamAdapter.TeamViewHolder holder, int position) {
        TeamCard team = teamList.get(position);

        holder.textViewTeamName.setText(team.getTeamName());
        holder.textViewComments.setText(team.getTeamComments());

    }

    @Override
    public int getItemCount() {
        return teamList.size();
    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent(ctx, NewTeamActivity.class);
        ctx.startActivity(intent);
    }

    class TeamViewHolder extends RecyclerView.ViewHolder {

        TextView textViewTeamName, textViewComments;

        public TeamViewHolder(View itemView) {
            super(itemView);

            textViewTeamName = itemView.findViewById(R.id.team_name);
            textViewComments = itemView.findViewById(R.id.team_comments);
        }
    }
}
