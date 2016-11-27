package br.com.cristiana.listteam.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.List;

import br.com.cristiana.listteam.DetalhesActivity;
import br.com.cristiana.listteam.R;
import br.com.cristiana.listteam.adapter.TeamListAdapter;
import br.com.cristiana.listteam.api.TeamAPI;
import br.com.cristiana.listteam.listener.OnClickListener;
import br.com.cristiana.listteam.model.Team;
import br.com.cristiana.listteam.utils.Constantes;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class TeamFragments extends Fragment implements Callback<List<Team>> {

    private RecyclerView rvTeam;
    private TeamListAdapter adapter;

    public TeamFragments() {}

    @Override
    public void onCreate(Bundle bundle) {

        super.onCreate(bundle);
    }

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.activity_team_fragments, container, false);
        rvTeam = (RecyclerView)v.findViewById(R.id.rvTeam);
        rvTeam.setLayoutManager(new LinearLayoutManager(getActivity()));
        //Padrão de animação na hora do scroll
        rvTeam.setItemAnimator(new DefaultItemAnimator());
        rvTeam.setHasFixedSize(true);
        return v;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        loadTeams();
    }

    private void loadTeams(){
        Retrofit retrofit = new Retrofit.Builder().baseUrl("http://www.mocky.io")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        TeamAPI api = retrofit.create(TeamAPI.class);
        Call<List<Team>> call = api.listOfTeam();
        call.enqueue(this);

    }

    private OnClickListener onClickListener(){
        return new OnClickListener() {
            @Override
            public void onClick(View v, int position) {
                Intent i = new Intent(getContext(), DetalhesActivity.class);
                i.putExtra(Constantes.KEY_TEAM, adapter.getItem(position));
                startActivity(i);

            }
        };
    }

    @Override
    public void onResponse(Call<List<Team>> call, Response<List<Team>> response) {
        adapter = new TeamListAdapter(getContext(), response.body(), onClickListener());

        //Coloca em Grid os cards
        GridLayoutManager glm = new GridLayoutManager(getContext(),2);
        rvTeam.setLayoutManager(glm);
        rvTeam.setAdapter(adapter);
    }

    @Override
    public void onFailure(Call<List<Team>> call, Throwable t) {
        Toast.makeText(getContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
    }
}
