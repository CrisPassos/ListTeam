package br.com.cristiana.listteam.api;

import java.util.List;

import br.com.cristiana.listteam.model.Team;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Cristiana on 26/11/2016.
 */

public interface TeamAPI {

    @GET("/v2/57c49ba10f00007111b50c00")
    Call<List<Team>> listOfTeam();

}
