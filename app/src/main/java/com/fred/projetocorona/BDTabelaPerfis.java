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

    public BDTabelaPerfis(SQLiteDatabase db){
        this.db = db;
    }

    public void criaTabelaPerfis(){
        db.execSQL("CREATE TABLE " + NOME_TABELA + "(" +
                _ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                NOME + " TEXT NOT NULL, " +
                DATA_NASC + " TEXT NOT NULL, " +
                CARDIOVASCULAR + " BOOLEAN NOT NULL, " +
                DIABETES + " BOOLEAN NOT NULL, " +
                PRESPIRATORIOS + " BOOLEAN NOT NULL, " +
                HIPERTENSAO + " BOOLEAN NOT NULL, " +
                PONCOLOGICOS + " BOOLEAN NOT NULL, " +
                SIS_EMUNITARIO + " BOOLEAN NOT NULL " + ")"
                );
    }

    public long insert(ContentValues values) {
        return db.insert(NOME_TABELA, null, values);
    }

    public Cursor query(String[] columns, String selection,
                        String[] selectionArgs, String groupBy, String having,
                        String orderBy) {

        if (!Arrays.asList(columns).contains(NOME_COMPLETO)) {
            return db.query(NOME_TABELA, columns, selection, selectionArgs, groupBy, having, orderBy);
        }

        String campos = TextUtils.join(",", columns);

        String sql = "SELECT " + campos;
        //sql += " FROM " + NOME_TABELA + " INNER JOIN " + BdTableCategorias.NOME_TABELA;
        //sql += " ON " + CAMPO_ID_CATEGORIA_COMPLETO + "=" + BdTableCategorias.CAMPO_ID_COMPLETO;

        if (selection != null) {
            sql += " WHERE " + selection;
        }

        if (groupBy != null) {
            sql += " GROUP BY " + groupBy;

            if (having != null) {
                sql += " HAVING " + having;
            }
        }

        if (orderBy != null) {
            sql += " ORDER BY " + orderBy;
        }

        return db.rawQuery(sql, selectionArgs);
    }

    public int update(ContentValues values, String whereClause, String[] whereArgs) {
        return db.update(NOME_TABELA, values, whereClause, whereArgs);
    }

    public int delete(String whereClause, String[] whereArgs) {
        return db.delete(NOME_TABELA, whereClause, whereArgs);
    }
}
