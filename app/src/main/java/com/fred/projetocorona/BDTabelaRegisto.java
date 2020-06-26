package com.fred.projetocorona;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.provider.BaseColumns;
import android.text.TextUtils;

import java.util.Arrays;

public class BDTabelaRegisto implements BaseColumns{
    public static final String NOME_TABELA = "registos";

    public static final String DATA = "data";
    public static final String TEMPERATURA = "temperatura";
    public static final String TOSSE = "tosse";
    public static final String FADIGA = "fadiga";
    public static final String FK_ID_PERFIL = "id_perfil";

    private SQLiteDatabase db;

    public static final String ID_COMPLETO = NOME_TABELA + "." + _ID;
    public static final String DATA_COMPLETO = NOME_TABELA + "." + DATA;
    public static final String TEMPERATURA_COMPLETO = NOME_TABELA + "." + TEMPERATURA;
    public static final String TOSSE_COMPLETO = NOME_TABELA + "." + TOSSE;
    public static final String FADIGA_COMPLETO = NOME_TABELA + "." + FADIGA;
    public static final String FK_ID_PERFIL_COMPLETO = NOME_TABELA + "." + FK_ID_PERFIL;
    public static final String[] TODOS_OS_CAMPOS_REGISTO = {ID_COMPLETO, DATA_COMPLETO, TEMPERATURA_COMPLETO, TOSSE_COMPLETO, FADIGA_COMPLETO, FK_ID_PERFIL_COMPLETO};

    public BDTabelaRegisto(SQLiteDatabase db){
        this.db = db;
    }

    public void criaTabelaRegistos(){
        db.execSQL("CREATE TABLE " + NOME_TABELA + "(" +
                _ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                DATA + " TEXT NOT NULL, " +
                TEMPERATURA + " REAL NOT NULL, " +
                TOSSE + " INTEGER NOT NULL, " +
                FADIGA + " INTEGER NOT NULL, " +
                FK_ID_PERFIL + " INTEGER NOT NULL," +
                " FOREIGN KEY(" + FK_ID_PERFIL + ") REFERENCES " +
                BDTabelaPerfis.NOME_TABELA +"("+ BDTabelaPerfis._ID + ")" +")"
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