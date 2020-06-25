package com.fred.projetocorona;

import android.content.ContentValues;
import android.database.Cursor;

public class Converte {
    public static ContentValues PerfilToContentValues(PerfilPessoa perfil) {//mandar para a base de daos
        ContentValues valores = new ContentValues();

        valores.put(BDTabelaPerfis.NOME, perfil.getNome());
        valores.put(BDTabelaPerfis.DATA_NASC, perfil.getDataNascimento());
        valores.put(BDTabelaPerfis.CARDIOVASCULAR, perfil.getCardiovascular());
        valores.put(BDTabelaPerfis.DIABETES, perfil.getDiabetes());
        valores.put(BDTabelaPerfis.PRESPIRATORIOS, perfil.getPRespiratorios());
        valores.put(BDTabelaPerfis.HIPERTENSAO, perfil.getHipertenso());
        valores.put(BDTabelaPerfis.PONCOLOGICOS, perfil.getPOncologicos());
        valores.put(BDTabelaPerfis.SIS_EMUNITARIO, perfil.getSisEmunitario());

        return valores;
    }

    public static PerfilPessoa contentValuesToPerfil(ContentValues valores) {
        PerfilPessoa perfil = new PerfilPessoa();

        perfil.setId(valores.getAsLong(BDTabelaPerfis._ID));
        perfil.setNome(valores.getAsString(BDTabelaPerfis.NOME));
        perfil.setDataNascimento(valores.getAsString(BDTabelaPerfis.DATA_NASC));
        perfil.setCardiovascular(valores.getAsInteger(BDTabelaPerfis.CARDIOVASCULAR));
        perfil.setDiabetes(valores.getAsInteger(BDTabelaPerfis.DIABETES));
        perfil.setPRespiratorios(valores.getAsInteger(BDTabelaPerfis.PRESPIRATORIOS));
        perfil.setHipertenso(valores.getAsInteger(BDTabelaPerfis.HIPERTENSAO));
        perfil.setPOncologicos(valores.getAsInteger(BDTabelaPerfis.PONCOLOGICOS));
        perfil.setSisEmunitario(valores.getAsInteger(BDTabelaPerfis.SIS_EMUNITARIO));

        return perfil;
    }

    public static PerfilPessoa cursorToPerfil(Cursor cursor) {
        PerfilPessoa perfil = new PerfilPessoa();

        perfil.setId(cursor.getLong(cursor.getColumnIndex(BDTabelaPerfis._ID)));
        perfil.setNome(cursor.getString(cursor.getColumnIndex(BDTabelaPerfis.NOME)));
        perfil.setDataNascimento(cursor.getString(cursor.getColumnIndex(BDTabelaPerfis.DATA_NASC)));
        perfil.setCardiovascular(cursor.getInt(cursor.getColumnIndex(BDTabelaPerfis.CARDIOVASCULAR)));
        perfil.setDiabetes(cursor.getInt(cursor.getColumnIndex(BDTabelaPerfis.DIABETES)));
        perfil.setPRespiratorios(cursor.getInt(cursor.getColumnIndex(BDTabelaPerfis.PRESPIRATORIOS)));
        perfil.setHipertenso(cursor.getInt(cursor.getColumnIndex(BDTabelaPerfis.HIPERTENSAO)));
        perfil.setPOncologicos(cursor.getInt(cursor.getColumnIndex(BDTabelaPerfis.PONCOLOGICOS)));
        perfil.setSisEmunitario(cursor.getInt(cursor.getColumnIndex(BDTabelaPerfis.SIS_EMUNITARIO)));

        return perfil;
    }

    public static ContentValues registoParaContentValues(Registos registo){
        ContentValues values = new ContentValues();
        values.put(BDTabelaRegisto.TEMPERATURA, registo.getTemperatura());
        values.put(BDTabelaRegisto.TOSSE, registo.getTosse());
        values.put(BDTabelaRegisto.FADIGA, registo.getFadiga());
        return values;
    }
    public static Registos contentValuesParaRegisto(ContentValues values){
        Registos registo = new Registos();

        registo.setId(values.getAsLong(BDTabelaRegisto._ID));
        registo.setTemperatura(values.getAsFloat(BDTabelaRegisto.TEMPERATURA));
        registo.setTosse(values.getAsInteger(BDTabelaRegisto.TOSSE));
        registo.setFadiga(values.getAsInteger(BDTabelaRegisto.FADIGA));


        return registo;
    }

    public static Registos cursorParaRegisto(Cursor cursor){
        Registos registo = new Registos();
        registo.setId(cursor.getLong(cursor.getColumnIndex(BDTabelaRegisto._ID)));
        registo.setData(cursor.getString(cursor.getColumnIndex(BDTabelaRegisto.DATA)));
        registo.setTemperatura(cursor.getFloat(cursor.getColumnIndex(String.valueOf(BDTabelaRegisto.TEMPERATURA))));
        registo.setTosse(cursor.getInt(cursor.getColumnIndex(BDTabelaRegisto.TOSSE)));
        registo.setFadiga(cursor.getInt(cursor.getColumnIndex(BDTabelaRegisto.FADIGA)));

        return registo;
    }

    public static ContentValues testeParaContentValues(Testes teste){
        ContentValues values = new ContentValues();

        values.put(BDTabelaTestes.DATA_TESTE, teste.getData_teste());
        values.put(BDTabelaTestes.DATA_RESULTADO, teste.getResultado());
        values.put(BDTabelaTestes.RESULTADO, teste.getResultado());

        return values;
    }
    public static Testes contentValuesParaTeste(ContentValues values){
        Testes teste = new Testes();
        teste.setId(values.getAsLong(BDTabelaTestes._ID));
        teste.setData_teste(values.getAsString(BDTabelaTestes.DATA_TESTE));
        teste.setData_resultado(values.getAsString(BDTabelaTestes.DATA_RESULTADO));
        teste.setResultado(values.getAsString(BDTabelaTestes.RESULTADO));

        return teste;
    }

    public static Testes cursorParaTeste(Cursor cursor){
        Testes teste = new Testes();
        teste.setId(cursor.getLong(cursor.getColumnIndex(BDTabelaTestes._ID)));
        teste.setData_teste(cursor.getString(cursor.getColumnIndex(BDTabelaTestes.DATA_TESTE)));
        teste.setData_resultado(cursor.getString(cursor.getColumnIndex((BDTabelaTestes.DATA_RESULTADO))));
        teste.setResultado(cursor.getString(cursor.getColumnIndex(BDTabelaTestes.RESULTADO)));

        return teste;
    }
}
