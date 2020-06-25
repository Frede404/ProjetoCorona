package com.fred.projetocorona;

public class PerfilPessoa {
   /* private long id;
    private String Nome;
    private String DataNascimento;
    private int Cardiovascular;
    private int Diabetes;
    private int PRespiratorios;
    private int Hipertenso;
    private int POncologicos;
    private int SisEmunitario;

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

    public int getCardiovascular() {
        return Cardiovascular;
    }

    public boolean isCardiovascular() {
        return converteintperfis(Cardiovascular);
    }

    public void setCardiovascular(int cardiovascular) {
        Cardiovascular = cardiovascular;
    }

    public int getDiabetes() {
        return Diabetes;
    }

    public boolean isDiabetes() {
        return converteintperfis(Diabetes);
    }

    public void setDiabetes(int diabetes) {
        Diabetes = diabetes;
    }

    public int getPRespiratorios() {
        return PRespiratorios;
    }

    public boolean isPRespiratorios() {
        return converteintperfis(PRespiratorios);
    }

    public void setPRespiratorios(int PRespiratorios) {
        this.PRespiratorios = PRespiratorios;
    }

    public int getHipertenso() {
        return Hipertenso;
    }

    public boolean isHipertenso() {
        return converteintperfis(Hipertenso);
    }

    public void setHipertenso(int hipertenso) {
        Hipertenso = hipertenso;
    }

    public int getPOncologicos() {
        return POncologicos;
    }

    public boolean isPOncologicos() {
        return converteintperfis(POncologicos);
    }

    public void setPOncologicos(int POncologicos) {
        this.POncologicos = POncologicos;
    }

    public int getSisEmunitario() {
        return SisEmunitario;
    }

    public boolean isSisEmunitario() {
        return converteintperfis(SisEmunitario);
    }

    public void setSisEmunitario(int sisEmunitario) {
        SisEmunitario = sisEmunitario;
    }

    private boolean converteintperfis(int conversor){
        if(conversor == 1){
            return true;
        }else{
            return false;
        }
    }
*/
    private long id;
    private String Nome;
    private String DataNascimento;
    private int Cardiovascular;
    private int Diabetes;
    private int PRespiratorios;
    private int Hipertenso;
    private int POncologicos;
    private int SisEmunitario;

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
        boolean auxboolean;
        if(Cardiovascular == 1){
            auxboolean = true;
        }else{
            auxboolean = false;
        }
        return auxboolean;
    }

    public void setCardiovascular(int cardiovascular) {
        Cardiovascular = cardiovascular;
    }

    public boolean getDiabetes() {
        boolean auxboolean;
        if(Diabetes == 1){
            auxboolean = true;
        }else{
            auxboolean = false;
        }
        return auxboolean;
    }

    public void setDiabetes(int diabetes) {
        Diabetes = diabetes;
    }

    public boolean getPRespiratorios() {
        boolean auxboolean;
        if(PRespiratorios == 1){
            auxboolean = true;
        }else{
            auxboolean = false;
        }
        return auxboolean;
    }

    public void setPRespiratorios(int PRespiratorios) {
        this.PRespiratorios = PRespiratorios;
    }

    public boolean getHipertenso() {
        boolean auxboolean;
        if(Hipertenso == 1){
            auxboolean = true;
        }else{
            auxboolean = false;
        }
        return auxboolean;
    }

    public void setHipertenso(int hipertenso) {
        Hipertenso = hipertenso;
    }

    public boolean getPOncologicos() {
        boolean auxboolean;
        if(POncologicos == 1){
            auxboolean = true;
        }else{
            auxboolean = false;
        }
        return auxboolean;
    }

    public void setPOncologicos(int POncologicos) {
        this.POncologicos = POncologicos;
    }

    public boolean getSisEmunitario() {
        boolean auxboolean;
        if(SisEmunitario == 1){
            auxboolean = true;
        }else{
            auxboolean = false;
        }
        return auxboolean;
    }

    public void setSisEmunitario(int sisEmunitario) {
        SisEmunitario = sisEmunitario;
    }
}
