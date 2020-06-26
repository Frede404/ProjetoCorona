package com.fred.projetocorona;

public class Registos {
    private long id;
    private String data;
    private float temperatura;
    private int tosse;
    private int fadiga;
    private long idPerfil;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public float getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(float temperatura) {
        this.temperatura = temperatura;
    }

    public int getTosse() {
        return tosse;
    }

    public boolean isTosse() {
        return converteintregisto(tosse);
    }

    public void setTosse(int tosse) {
        this.tosse = tosse;
    }

    public int getFadiga() {
        return fadiga;
    }

    public boolean isFadiga() {
        return converteintregisto(fadiga);
    }

    public void setFadiga(int fadiga) {
        this.fadiga = fadiga;
    }

    public long getIdPerfil() {
        return idPerfil;
    }

    public void setIdPerfil(long idPerfil) {
        this.idPerfil = idPerfil;
    }

    private boolean converteintregisto(int conversor){
        if(conversor == 1){
            return true;
        }else{
            return false;
        }
    }
}