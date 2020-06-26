package com.fred.projetocorona;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class BDEstatisticasProvider {
    private BDOpenHelper openHelper;
    private SQLiteDatabase bd;
    int pessoas_registadas;
    int doentes_cronicos;
    int n_testes;
    int testes_positivos;

    public BDEstatisticasProvider(Context context){
        openHelper = new BDOpenHelper(context);
        bd = openHelper.getReadableDatabase();

        Pessoas_Registadas();
        Doentes_Cronicos();
        N_Testes();
        Testes_Positivos();
    }

    private void Pessoas_Registadas(){
        String sql_pessoas_registadas = "SELECT COUNT(*) " +
                " FROM " + BDTabelaPerfis.NOME_TABELA;

        Cursor cursor = bd.rawQuery(sql_pessoas_registadas,null);
        cursor.moveToNext();
        pessoas_registadas = cursor.getInt(0);
    }

    private void Doentes_Cronicos(){
        String sql_doentes_cronicos = "SELECT COUNT(*) " +
                " FROM " + BDTabelaPerfis.NOME_TABELA +
                " WHERE " + BDTabelaPerfis.CARDIOVASCULAR_COMPLETO + " = 1" +
                " OR " + BDTabelaPerfis.DIABETES_COMPLETO + " = 1" +
                " OR " + BDTabelaPerfis.PRESPIRATORIOS_COMPLETO + " = 1" +
                " OR " + BDTabelaPerfis.HIPERTENSAO_COMPLETO + " = 1" +
                " OR " + BDTabelaPerfis.PONCOLOGICOS_COMPLETO + " = 1" +
                " OR " + BDTabelaPerfis.SIS_EMUNITARIO_COMPLETO + " = 1";

        Cursor cursor = bd.rawQuery(sql_doentes_cronicos,null);
        cursor.moveToNext();
        doentes_cronicos = cursor.getInt(0);
    }

    private void N_Testes(){
        String sql_ntestes = "SELECT COUNT(*) " +
                " FROM " + BDTabelaTestes.NOME_TABELA + ", " + BDTabelaPerfis.NOME_TABELA +
                " WHERE " + BDTabelaTestes.FK_ID_PERFIL_COMPLETO + " = " + BDTabelaPerfis.ID_COMPLETO;

        Cursor cursor = bd.rawQuery(sql_ntestes,null);
        cursor.moveToNext();
        n_testes = cursor.getInt(0);
    }

    private void Testes_Positivos(){
        String sql_ntestes = "SELECT COUNT(*) " +
                " FROM " + BDTabelaTestes.NOME_TABELA + ", " + BDTabelaPerfis.NOME_TABELA +
                " WHERE " + BDTabelaTestes.FK_ID_PERFIL_COMPLETO + " = " + BDTabelaPerfis.ID_COMPLETO +
                " AND " + BDTabelaTestes.RESULTADO_COMPLETO + " = 'Positivo'";

        Cursor cursor = bd.rawQuery(sql_ntestes,null);
        cursor.moveToNext();
        testes_positivos = cursor.getInt(0);
    }

    public int getPessoas_registadas() {
        return pessoas_registadas;
    }

    public int getDoentes_cronicos() {
        return doentes_cronicos;
    }

    public int getN_testes() {
        return n_testes;
    }

    public int getTestes_positivos() {
        return testes_positivos;
    }
}
