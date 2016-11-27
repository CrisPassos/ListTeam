package br.com.cristiana.listteam.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import br.com.cristiana.listteam.R;
import br.com.cristiana.listteam.listener.OnClickListener;
import br.com.cristiana.listteam.model.Team;

/**
 * Created by Cristiana on 26/11/2016.
 */

public class TeamListAdapter extends
        RecyclerView.Adapter<TeamListAdapter.TeamViewHolder> {

    private Context context;
    private List<Team> teams;
    private OnClickListener clickListener;

    public TeamListAdapter(Context context, List<Team> teams, OnClickListener clickListener) {
        this.context = context;
        this.teams = teams;
        this.clickListener = clickListener;
    }

    @Override
    public TeamViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context)
                .inflate(R.layout.item_time, parent, false);

        return new TeamViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final TeamViewHolder holder, final int position) {

        holder.tvTime.setText(teams.get(position).getNome());
        holder.tvEstado.setText(teams.get(position).getEstado());

        String ano = String.valueOf(teams.get(position).getAnoFundacao());

        holder.tvAnoFundacao.setText(ano);

        Picasso.with(context)
                .load(teams.get(position).getEscudo())
                .placeholder(R.mipmap.ic_launcher)
                .error(R.mipmap.ic_launcher)
                .into(holder.ivBrasao);

        if (clickListener !=null){
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    clickListener.onClick(holder.itemView, position);
                }
            });
        }

    }
    public Team getItem(int position){
        return teams.get(position);
    }

    @Override
    public int getItemCount() {
        return teams.size();
    }

    public static class TeamViewHolder extends RecyclerView.ViewHolder{

        TextView tvTime, tvAnoFundacao, tvEstado;
        ImageView ivBrasao;

        public TeamViewHolder(View itemView) {
            super(itemView);
            tvTime = (TextView) itemView.findViewById(R.id.tv_time);
            tvAnoFundacao = (TextView) itemView.findViewById(R.id.tv_anoFundacao);
            tvEstado = (TextView) itemView.findViewById(R.id.tv_estado);
            ivBrasao = (ImageView) itemView.findViewById(R.id.ivBrasao);
        }
    }
}
