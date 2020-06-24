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
}
