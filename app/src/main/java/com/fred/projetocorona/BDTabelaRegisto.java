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

    private SQLiteDatabase db;

    public static final String ID_COMPLETO = NOME_TABELA + "." + _ID;
    public static final String DATA_COMPLETO = NOME_TABELA + "." + DATA;
    public static final String TEMPERATURA_COMPLETO = NOME_TABELA + "." + TEMPERATURA;
    public static final String TOSSE_COMPLETO = NOME_TABELA + "." + TOSSE;
    public static final String FADIGA_COMPLETO = NOME_TABELA + "." + FADIGA;

    public BDTabelaRegisto(SQLiteDatabase db){
        this.db = db;
    }

    public void criaTabelaRegistos(){
        db.execSQL("CREATE TABLE " + NOME_TABELA + "(" +
                _ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                DATA + " TEXT NOT NULL, " +
                TEMPERATURA + " REAL NOT NULL, " +
                TOSSE + " BOOLEAN NOT NULL, " +
                FADIGA + " BOOLEAN NOT NULL " + ")"
        );
    }

    public long insert(ContentValues values) {
        return db.insert(NOME_TABELA, null, values);
    }

    public Cursor query(String[] columns, String selection,
                        String[] selectionArgs, String groupBy, String having,
                        String orderBy) {

        if (!Arrays.asList(columns).contains(DATA_COMPLETO)) {
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
