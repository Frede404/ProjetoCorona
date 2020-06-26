package com.fred.projetocorona;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.provider.BaseColumns;
import android.text.TextUtils;

import java.util.Arrays;

public class BDTabelaPerfis implements BaseColumns {
    public static final String NOME_TABELA = "perfis";

    public static final String NOME = "nome";
    public static final String DATA_NASC = "data_nascimento";
    public static final String CARDIOVASCULAR = "cardiovascular";
    public static final String DIABETES = "diabetese";
    public static final String PRESPIRATORIOS = "prob_respiratorios";
    public static final String HIPERTENSAO = "hipertensao";
    public static final String PONCOLOGICOS = "prob_oncologicos";
    public static final String SIS_EMUNITARIO = "sis_emunitario";

    private SQLiteDatabase db;

    public static final String ID_COMPLETO = NOME_TABELA + "." + _ID;
    public static final String NOME_COMPLETO = NOME_TABELA + "." + NOME;
    public static final String DATA_NASC_COMPLETO = NOME_TABELA + "." + DATA_NASC;
    public static final String CARDIOVASCULAR_COMPLETO = NOME_TABELA + "." + CARDIOVASCULAR;
    public static final String DIABETES_COMPLETO = NOME_TABELA + "." + DIABETES;
    public static final String PRESPIRATORIOS_COMPLETO = NOME_TABELA + "." + PRESPIRATORIOS;
    public static final String HIPERTENSAO_COMPLETO = NOME_TABELA + "." + HIPERTENSAO;
    public static final String PONCOLOGICOS_COMPLETO = NOME_TABELA + "." + PONCOLOGICOS;
    public static final String SIS_EMUNITARIO_COMPLETO = NOME_TABELA + "." + SIS_EMUNITARIO;
    public static final String[] TODOS_OS_CAMPOS_PERFIL = {ID_COMPLETO, NOME_COMPLETO, DATA_NASC_COMPLETO,CARDIOVASCULAR_COMPLETO,DIABETES_COMPLETO,PRESPIRATORIOS_COMPLETO,HIPERTENSAO_COMPLETO,PONCOLOGICOS_COMPLETO,SIS_EMUNITARIO_COMPLETO};

    public BDTabelaPerfis(SQLiteDatabase db){
        this.db = db;
    }

    public void criaTabelaPerfis(){
        db.execSQL("CREATE TABLE " + NOME_TABELA + "(" +
                _ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                NOME + " TEXT NOT NULL, " +
                DATA_NASC + " TEXT NOT NULL, " +
                CARDIOVASCULAR + " INTEGER NOT NULL, " +
                DIABETES + " INTEGER NOT NULL, " +
                PRESPIRATORIOS + " INTEGER NOT NULL, " +
                HIPERTENSAO + " INTEGER NOT NULL, " +
                PONCOLOGICOS + " INTEGER NOT NULL, " +
                SIS_EMUNITARIO + " INTEGER NOT NULL " + ")"
                );
    }

    public long insert(ContentValues values) {
        return db.insert(NOME_TABELA, null, values);
    }

    public Cursor query(String[] columns, String selection,
                        String[] selectionArgs, String groupBy, String having,
                        String orderBy) {
        return db.query(NOME_TABELA, columns, selection, selectionArgs, groupBy, having, orderBy);
    }

    public int update(ContentValues values, String whereClause, String[] whereArgs) {
        return db.update(NOME_TABELA, values, whereClause, whereArgs);
    }

    public int delete(String whereClause, String[] whereArgs) {
        return db.delete(NOME_TABELA, whereClause, whereArgs);
    }
}