package com.fred.projetocorona;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class BDOpenHelper extends SQLiteOpenHelper {
    public static final String NOME_BD = "gestaodiariacovid.db";
    private static final int VERSAO_BD = 1;
    private static final boolean DESENVOLVIMENTO = true;

    public BDOpenHelper(@Nullable Context context) {
        super(context, NOME_BD,null, VERSAO_BD);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        BDTabelaPerfis tabelaPerfis = new BDTabelaPerfis(db);
        tabelaPerfis.criaTabelaPerfis();

        BDTabelaTestes tabelaTestes = new BDTabelaTestes(db);
        tabelaTestes.criaTabelaTestes();

        BDTabelaRegisto tabelaRegisto = new BDTabelaRegisto(db);
        tabelaRegisto.criaTabelaRegistos();

        if (DESENVOLVIMENTO) {
            seedData(db);
        }
    }

    private void seedData(SQLiteDatabase db) {
        /*BdTableCategorias tabelaCategorias = new BdTableCategorias(db);

        Categoria categoria = new Categoria();
        categoria.setDescricao("Ação");
        long idCatAcao = tabelaCategorias.insert(Converte.categoriaToContentValues(categoria));*/
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
