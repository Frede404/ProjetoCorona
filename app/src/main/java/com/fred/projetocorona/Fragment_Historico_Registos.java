package com.fred.projetocorona;

import android.content.Context;
import android.database.Cursor;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.loader.app.LoaderManager;
import androidx.loader.content.Loader;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class Fragment_Historico_Registos extends Fragment implements LoaderManager.LoaderCallbacks<Cursor>{
    public static final int _CURSOR_LOADER_REGISTOS = 0;
    private AdaptadorRegistos adaptadorregistos;
    private long idperfil;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment__historico__registos, container, false);
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState){
        super.onViewCreated(view, savedInstanceState);
        Context context = getContext();

        MainActivity activity = (MainActivity) getActivity();
        activity.setFragmentActual(this);
        activity.setMenuActual(R.menu.menu_historico_registo);
        idperfil=activity.getPerfil().getId();

        RecyclerView recyclerViewPerfis = (RecyclerView) view.findViewById(R.id.RV_Historico_Registos);
        adaptadorregistos = new AdaptadorRegistos(context);

        recyclerViewPerfis.setAdapter(adaptadorregistos);
        recyclerViewPerfis.setLayoutManager(new LinearLayoutManager(context));
        adaptadorregistos.setCursor(null);

        LoaderManager.getInstance(this).initLoader(_CURSOR_LOADER_REGISTOS, null, this);//gestao dos items (scroll);
    }

    public void Voltar(){
        NavController navController = NavHostFragment.findNavController(Fragment_Historico_Registos.this);
        navController.navigate(R.id.action_Historico_Registos_to_Informacoes);
    }

    public void Home(){
        NavController navController = NavHostFragment.findNavController(Fragment_Historico_Registos.this);
        navController.navigate(R.id.action_Historico_Registos_to_Perfil);
    }

    @NonNull
    @Override
    public Loader<Cursor> onCreateLoader(int id, @Nullable Bundle args) {
        return new androidx.loader.content.CursorLoader(getContext(), BDContentProvider.ENDERECO_REGISTOS, BDTabelaRegisto.TODOS_OS_CAMPOS_REGISTO, BDTabelaRegisto.FK_ID_PERFIL_COMPLETO+"=?", new String[]{String.valueOf(idperfil)}, BDTabelaRegisto.DATA);
    }

    @Override
    public void onLoadFinished(@NonNull Loader<Cursor> loader, Cursor data) {
        adaptadorregistos.setCursor(data);
    }

    @Override
    public void onLoaderReset(@NonNull Loader<Cursor> loader) {
        adaptadorregistos.setCursor(null);
    }
}