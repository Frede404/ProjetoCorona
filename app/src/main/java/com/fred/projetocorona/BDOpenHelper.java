package com.fred.projetocorona;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class BDOpenHelper extends SQLiteOpenHelper {
    public static final String NOME_BD = "gestaodiariacovid.db";
    private static final int VERSAO_BD = 1;

    public BDOpenHelper(@Nullable Context context) {
        super(context, NOME_BD,null, VERSAO_BD);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        BDTabelaPerfis tabelaPerfis = new BDTabelaPerfis(db);
        tabelaPerfis.criaTabelaPerfis();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
