package com.fred.projetocorona;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class BDContentProvider extends ContentProvider {
    private static final String AUTHORITY = "com.fred.projetocorona";
    private static final String PERFIS = "perfis";
    public static final String REGISTOS = "registos";
    public static final String TESTES = "testes";

    private static final Uri ENDERECO_BASE = Uri.parse("content://" + AUTHORITY);
    public static final Uri ENDERECO_PERFIS = Uri.withAppendedPath(ENDERECO_BASE, PERFIS);
    public static final Uri ENDERECO_REGISTOS = Uri.withAppendedPath(ENDERECO_BASE, REGISTOS);
    public static final Uri ENDERECO_TESTES = Uri.withAppendedPath(ENDERECO_BASE, TESTES);

    private static final int URI_PERFIS = 100;
    private static final int URI_ID_PERFIS = 101;
    public static final int URI_REGISTOS = 200;
    public static final int URI_ID_REGISTO = 201;
    public static final int URI_TESTES = 300;
    public static final int URI_ID_TESTE = 301;

    private static final String CURSOR_DIR = "vnd.android.cursor.dir/";
    private static final String CURSOR_ITEM = "vnd.android.cursor.item/";

    private BDOpenHelper openHelper;

    private UriMatcher getUriMatcher(){
        UriMatcher uriMatcher = new UriMatcher(UriMatcher.NO_MATCH);

        uriMatcher.addURI(AUTHORITY, PERFIS, URI_PERFIS);
        uriMatcher.addURI(AUTHORITY, PERFIS + "/#", URI_ID_PERFIS);

        uriMatcher.addURI(AUTHORITY, REGISTOS, URI_REGISTOS);
        uriMatcher.addURI(AUTHORITY, REGISTOS + "/#", URI_ID_REGISTO);

        uriMatcher.addURI(AUTHORITY,TESTES, URI_TESTES);
        uriMatcher.addURI(AUTHORITY,TESTES + "/#", URI_ID_TESTE);

        return uriMatcher;
    }

    @Override
    public boolean onCreate() {
        openHelper = new BDOpenHelper(getContext());

        return true;
    }

    @Nullable
    @Override
    public Cursor query(@NonNull Uri uri, @Nullable String[] projection, @Nullable String selection, @Nullable String[] selectionArgs, @Nullable String sortOrder) {
        SQLiteDatabase bd = openHelper.getReadableDatabase();

        String id = uri.getLastPathSegment();

        switch (getUriMatcher().match(uri)) {
            case URI_PERFIS:
                return new BDTabelaPerfis(bd).query(projection, selection, selectionArgs, null, null, sortOrder);

            case URI_ID_PERFIS:
                return new BDTabelaPerfis(bd).query(projection, BDTabelaPerfis._ID + "=?", new String[] { id }, null, null, sortOrder);

            case URI_REGISTOS:
                return new BDTabelaRegisto(bd).query(projection, selection, selectionArgs, null, null, sortOrder);
            case URI_ID_REGISTO:
                return new BDTabelaRegisto(bd).query(projection, BDTabelaRegisto._ID + "=?", new String[]{id},null, null, sortOrder);

            case URI_TESTES:
                return new BDTabelaTestes(bd).query(projection, selection, selectionArgs, null, null, sortOrder);
            case URI_ID_TESTE:
                return new BDTabelaTestes(bd).query(projection, BDTabelaTestes._ID + "=?", new String[]{id},null, null, sortOrder);

            default:
                throw new UnsupportedOperationException("Endereço query inválido: " + uri.getPath());
        }
    }

    @Nullable
    @Override
    public String getType(@NonNull Uri uri) {
        int codigoUri = getUriMatcher().match(uri);

        switch (codigoUri) {
            case URI_PERFIS:
                return CURSOR_DIR + PERFIS;
            case URI_ID_PERFIS:
                return CURSOR_ITEM + PERFIS;
            case URI_REGISTOS:
                return CURSOR_DIR + REGISTOS;
            case URI_ID_REGISTO:
                return CURSOR_ITEM + REGISTOS;
            case URI_TESTES:
                return CURSOR_DIR + TESTES;
            case URI_ID_TESTE:
                return CURSOR_ITEM + TESTES;

            default:
                return null;
        }
    }

    @Nullable
    @Override
    public Uri insert(@NonNull Uri uri, @Nullable ContentValues values) {
        SQLiteDatabase bd = openHelper.getWritableDatabase();

        long id;

        switch (getUriMatcher().match(uri)) {
            case URI_PERFIS:
                id = (new BDTabelaPerfis(bd).insert(values));
                break;
            case URI_REGISTOS:
                id = (new BDTabelaRegisto(bd).insert(values));
                break;
            case URI_TESTES:
                id = (new BDTabelaTestes(bd).insert(values));
                break;

            default:
                throw new UnsupportedOperationException("Endereço insert inválido: " + uri.getPath());
        }

        if (id == -1) {
            throw new SQLException("Não foi possível inserir o registo: " + uri.getPath());
        }

        return Uri.withAppendedPath(uri, String.valueOf(id));
    }

    @Override
    public int delete(@NonNull Uri uri, @Nullable String selection, @Nullable String[] selectionArgs) {
        SQLiteDatabase bd = openHelper.getWritableDatabase();

        String id = uri.getLastPathSegment();

        switch (getUriMatcher().match(uri)) {
            case URI_ID_PERFIS:
                return new BDTabelaPerfis(bd).delete(BDTabelaPerfis._ID + "=?", new String[]{id});
            case URI_ID_REGISTO:
                return new BDTabelaRegisto(bd).delete(BDTabelaRegisto._ID + "=?", new String[]{id});
            case URI_ID_TESTE:
                return new BDTabelaTestes(bd).delete(BDTabelaTestes._ID + "=?", new String[]{id});

            default:
                throw new UnsupportedOperationException("Endereço delete inválido: " + uri.getPath());
        }
    }

    @Override
    public int update(@NonNull Uri uri, @Nullable ContentValues values, @Nullable String selection, @Nullable String[] selectionArgs) {
        SQLiteDatabase bd = openHelper.getWritableDatabase();

        String id = uri.getLastPathSegment();

        switch (getUriMatcher().match(uri)) {
            case URI_ID_PERFIS:
                return new BDTabelaPerfis(bd).update(values, BDTabelaPerfis._ID + "=?", new String[] { id });
            case URI_ID_REGISTO:
                return new BDTabelaRegisto(bd).update(values, BDTabelaRegisto._ID + "=?", new String[]{id});
            case URI_ID_TESTE:
                return new BDTabelaTestes(bd).update(values, BDTabelaTestes._ID + "=?", new String[]{id});

            default:
                throw new UnsupportedOperationException("Endereço de update inválido: " + uri.getPath());
        }
    }
}