package com.fred.projetocorona;

public class PerfilPessoa {
    private long id;
    private String Nome;
    private String DataNascimento;
    private int Cardiovascular;
    private int Diabetes;
    private int PRespiratorios;
    private int Hipertenso;
    private int POncologicos;
    private int SisEmunitario;
    public static long AUXNOVOPERFIL;

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

    public boolean getCardiovascular() {
        return converteintperfil(Cardiovascular);
    }

    public void setCardiovascular(int cardiovascular) {
        Cardiovascular = cardiovascular;
    }

    public boolean getDiabetes() {
        return converteintperfil(Diabetes);
    }

    public void setDiabetes(int diabetes) {
        Diabetes = diabetes;
    }

    public boolean getPRespiratorios() {
        return converteintperfil(PRespiratorios);
    }

    public void setPRespiratorios(int PRespiratorios) {
        this.PRespiratorios = PRespiratorios;
    }

    public boolean getHipertenso() {
        return converteintperfil(Hipertenso);
    }

    public void setHipertenso(int hipertenso) {
        Hipertenso = hipertenso;
    }

    public boolean getPOncologicos() {
        return converteintperfil(POncologicos);
    }

    public void setPOncologicos(int POncologicos) {
        this.POncologicos = POncologicos;
    }

    public boolean getSisEmunitario() {
        return converteintperfil(SisEmunitario);
    }

    public void setSisEmunitario(int sisEmunitario) {
        SisEmunitario = sisEmunitario;
    }

    private boolean converteintperfil(int conversor){
        if(conversor == 1){
            return true;
        }else{
            return false;
        }
    }
}
