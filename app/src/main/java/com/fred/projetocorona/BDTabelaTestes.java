package com.fred.projetocorona;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.provider.BaseColumns;
import android.text.TextUtils;

import java.util.Arrays;

public class BDTabelaTestes implements BaseColumns {
    public static final String NOME_TABELA = "testes";

    public static final String DATA_TESTE = "data_teste";
    public static final String DATA_RESULTADO = "data_resultado";
    public static final String RESULTADO = "resultado";

    private SQLiteDatabase db;

    public static final String ID_COMPLETO = NOME_TABELA + "." + _ID;
    public static final String DATA_TESTE_COMPLETO = NOME_TABELA + "." + DATA_TESTE;
    public static final String DATA_RESULTADO_COMPLETO = NOME_TABELA + "." + DATA_RESULTADO;
    public static final String RESULTADO_COMPLETO = NOME_TABELA + "." + RESULTADO;

    public BDTabelaTestes(SQLiteDatabase db){
        this.db = db;
    }

    public void criaTabelaTestes(){
        db.execSQL("CREATE TABLE " + NOME_TABELA + "(" +
                _ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                DATA_TESTE + " TEXT NOT NULL, " +
                DATA_RESULTADO + " TEXT NOT NULL, " +
                RESULTADO + " TEXT NOT NULL " + ")"
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
