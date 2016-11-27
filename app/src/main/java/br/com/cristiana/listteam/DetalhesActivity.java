package br.com.cristiana.listteam;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import br.com.cristiana.listteam.model.Team;
import br.com.cristiana.listteam.utils.Constantes;

public class DetalhesActivity extends AppCompatActivity {

    private TextView tvAno, tvEstado;
    private ImageView ivTime;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhes);

        tvAno = (TextView) findViewById(R.id.tvAnoD);
        tvEstado = (TextView) findViewById(R.id.tvEstadoD);
        ivTime = (ImageView) findViewById(R.id.ivTimeD);

        if (getIntent() != null){
            Team team = getIntent().getParcelableExtra(Constantes.KEY_TEAM);

            String ano = String.valueOf(team.getAnoFundacao());
            tvAno.setText(ano);

            tvEstado.setText(team.getEstado());
            Picasso.with(this)
                    .load(team.getEscudo())
                    .placeholder(R.mipmap.ic_launcher)
                    .error(R.mipmap.ic_launcher)
                    .into(ivTime);


            Toast.makeText(this, team.getNome(), Toast.LENGTH_SHORT).show();
        }
    }
}
