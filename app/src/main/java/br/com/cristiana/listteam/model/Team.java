package br.com.cristiana.listteam.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Cristiana on 26/11/2016.
 */

public class Team implements Parcelable {

    private String nome;
    private String estado;
    private String escudo;
    @SerializedName("anofundacao")
    private int anoFundacao;

    protected Team(Parcel in) {
        nome = in.readString();
        estado = in.readString();
        escudo = in.readString();
        anoFundacao = in.readInt();
    }

    public void Team() { }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(nome);
        dest.writeString(estado);
        dest.writeString(escudo);
        dest.writeInt(anoFundacao);
    }

    public Team(String nome, String estado, String escudo, int anoFundacao) {
        this.nome = nome;
        this.estado = estado;
        this.escudo = escudo;
        this.anoFundacao = anoFundacao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getEscudo() {
        return escudo;
    }

    public void setEscudo(String escudo) {
        this.escudo = escudo;
    }

    public int getAnoFundacao() {
        return anoFundacao;
    }

    public void setAnoFundacao(int anoFundacao) {
        this.anoFundacao = anoFundacao;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Team> CREATOR = new Creator<Team>() {
        @Override
        public Team createFromParcel(Parcel in) {
            return new Team(in);
        }

        @Override
        public Team[] newArray(int size) {
            return new Team[size];
        }
    };






}
