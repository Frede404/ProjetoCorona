package com.fred.projetocorona;

import android.content.ContentValues;
import android.database.Cursor;

public class Converte {
    public static ContentValues PerfilToContentValues(PerfilPessoa perfil) {
        ContentValues valores = new ContentValues();

        valores.put(BDTabelaPerfis.NOME, perfil.getNome());
        valores.put(BDTabelaPerfis.DATA_NASC, perfil.getDataNascimento());
        valores.put(BDTabelaPerfis.CARDIOVASCULAR, perfil.isCardiovascular());
        valores.put(BDTabelaPerfis.DIABETES, perfil.isDiabetes());
        valores.put(BDTabelaPerfis.PRESPIRATORIOS, perfil.isPRespiratorios());
        valores.put(BDTabelaPerfis.HIPERTENSAO, perfil.isHipertenso());
        valores.put(BDTabelaPerfis.PONCOLOGICOS, perfil.isPOncologicos());
        valores.put(BDTabelaPerfis.SIS_EMUNITARIO, perfil.isSisEmunitario());
        valores.put(BDTabelaPerfis.ALTURA,perfil.getAltura());
        valores.put(BDTabelaPerfis.PESO,perfil.getPeso());

        return valores;
    }

    public static PerfilPessoa contentValuesToPerfil(ContentValues valores) {
        PerfilPessoa perfil = new PerfilPessoa();

        perfil.setId(valores.getAsLong(BDTabelaPerfis._ID));
        perfil.setNome(valores.getAsString(BDTabelaPerfis.NOME));
        perfil.setDataNascimento(valores.getAsString(BDTabelaPerfis.DATA_NASC));
        perfil.setCardiovascular(valores.getAsBoolean(BDTabelaPerfis.CARDIOVASCULAR));
        perfil.setDiabetes(valores.getAsBoolean(BDTabelaPerfis.DIABETES));
        perfil.setPRespiratorios(valores.getAsBoolean(BDTabelaPerfis.PRESPIRATORIOS));
        perfil.setHipertenso(valores.getAsBoolean(BDTabelaPerfis.HIPERTENSAO));
        perfil.setPOncologicos(valores.getAsBoolean(BDTabelaPerfis.PONCOLOGICOS));
        perfil.setSisEmunitario(valores.getAsBoolean(BDTabelaPerfis.SIS_EMUNITARIO));
        perfil.setAltura(valores.getAsFloat(BDTabelaPerfis.ALTURA));
        perfil.setPeso(valores.getAsFloat(BDTabelaPerfis.PESO));

        return perfil;
    }

    public static PerfilPessoa cursorToPerfil(Cursor cursor) {
        PerfilPessoa perfil = new PerfilPessoa();

        perfil.setId(cursor.getLong(cursor.getColumnIndex(BDTabelaPerfis._ID)));
        perfil.setNome(cursor.getString(cursor.getColumnIndex(BDTabelaPerfis.NOME)));
        perfil.setDataNascimento(cursor.getString(cursor.getColumnIndex(BDTabelaPerfis.DATA_NASC)));
        perfil.setCardiovascular(cursor.isNull(cursor.getColumnIndex(BDTabelaPerfis.CARDIOVASCULAR)));
        perfil.setDiabetes(cursor.isNull(cursor.getColumnIndex(BDTabelaPerfis.DIABETES)));
        perfil.setPRespiratorios(cursor.isNull(cursor.getColumnIndex(BDTabelaPerfis.PRESPIRATORIOS)));
        perfil.setHipertenso(cursor.isNull(cursor.getColumnIndex(BDTabelaPerfis.HIPERTENSAO)));
        perfil.setPOncologicos(cursor.isNull(cursor.getColumnIndex(BDTabelaPerfis.PONCOLOGICOS)));
        perfil.setSisEmunitario(cursor.isNull(cursor.getColumnIndex(BDTabelaPerfis.SIS_EMUNITARIO)));
        perfil.setAltura(cursor.getFloat(cursor.getColumnIndex(BDTabelaPerfis.ALTURA)));
        perfil.setPeso(cursor.getFloat(cursor.getColumnIndex(BDTabelaPerfis.PESO)));

        return perfil;
    }

    public static ContentValues registoParaContentValues(Registos registo){
        ContentValues values = new ContentValues();
        values.put(BDTabelaRegisto.TEMPERATURA, registo.getTemperatura());
        values.put(BDTabelaRegisto.TOSSE, registo.isTosse());
        values.put(BDTabelaRegisto.FADIGA, registo.isFadiga());
        return values;
    }
    public static Registos contentValuesParaRegisto(ContentValues values){
        Registos registo = new Registos();

        registo.setId(values.getAsLong(BDTabelaRegisto._ID));
        registo.setTemperatura(values.getAsFloat(BDTabelaRegisto.TEMPERATURA));
        registo.setTosse(values.getAsBoolean(BDTabelaRegisto.TOSSE));
        registo.setFadiga(values.getAsBoolean(BDTabelaRegisto.FADIGA));


        return registo;
    }

    public static Registos cursorParaRegisto(Cursor cursor){
        Registos registo = new Registos();
        registo.setId(cursor.getLong(cursor.getColumnIndex(BDTabelaRegisto._ID)));
        registo.setData(cursor.getString(cursor.getColumnIndex(BDTabelaRegisto.DATA)));
        registo.setTemperatura(cursor.getFloat(cursor.getColumnIndex(String.valueOf(BDTabelaRegisto.TEMPERATURA))));
        registo.setTosse(cursor.isNull(cursor.getColumnIndex(BDTabelaRegisto.TOSSE)));
        registo.setFadiga(cursor.isNull(cursor.getColumnIndex(BDTabelaRegisto.FADIGA)));

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
