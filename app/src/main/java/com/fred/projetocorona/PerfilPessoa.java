package com.fred.projetocorona;

public class PerfilPessoa {
    private long id;
    private String Nome;
    private String DataNascimento;
    private boolean Cardiovascular;
    private boolean Diabetes;
    private boolean PRespiratorios;
    private boolean Hipertenso;
    private boolean POncologicos;
    private boolean SisEmunitario;
    private float Altura;
    private float Peso;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String nome) {
        Nome = nome;
    }

    public String getDataNascimento() {
        return DataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        DataNascimento = dataNascimento;
    }

    public boolean isCardiovascular() {
        return Cardiovascular;
    }

    public void setCardiovascular(boolean cardiovascular) {
        Cardiovascular = cardiovascular;
    }

    public boolean isDiabetes() {
        return Diabetes;
    }

    public void setDiabetes(boolean diabetes) {
        Diabetes = diabetes;
    }

    public boolean isPRespiratorios() {
        return PRespiratorios;
    }

    public void setPRespiratorios(boolean PRespiratorios) {
        this.PRespiratorios = PRespiratorios;
    }

    public boolean isHipertenso() {
        return Hipertenso;
    }

    public void setHipertenso(boolean hipertenso) {
        Hipertenso = hipertenso;
    }

    public boolean isPOncologicos() {
        return POncologicos;
    }

    public void setPOncologicos(boolean POncologicos) {
        this.POncologicos = POncologicos;
    }

    public boolean isSisEmunitario() {
        return SisEmunitario;
    }

    public void setSisEmunitario(boolean sisEmunitario) {
        SisEmunitario = sisEmunitario;
    }

    public float getAltura() {
        return Altura;
    }

    public void setAltura(float altura) {
        Altura = altura;
    }

    public float getPeso() {
        return Peso;
    }

    public void setPeso(float peso) {
        Peso = peso;
    }
}
