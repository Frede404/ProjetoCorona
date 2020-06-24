package com.fred.projetocorona;

public class Registos {
    private long id;
    private String data;
    private float temperatura;
    private boolean tosse;
    private boolean fadiga;

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public float getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(float temperatura) {
        this.temperatura = temperatura;
    }

    public boolean isTosse() {
        return tosse;
    }

    public void setTosse(boolean tosse) {
        this.tosse = tosse;
    }

    public boolean isFadiga() {
        return fadiga;
    }

    public void setFadiga(boolean fadiga) {
        this.fadiga = fadiga;
    }
}
