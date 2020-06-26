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

public class Fragment_Teste extends Fragment implements LoaderManager.LoaderCallbacks<Cursor> {
    private long idperfil;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment__teste, container, false);
    }
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState){
        super.onViewCreated(view, savedInstanceState);
        Context context = getContext();

        MainActivity activity = (MainActivity) getActivity();
        activity.setFragmentActual(this);
        activity.setMenuActual(R.menu.menu_teste);
        idperfil=activity.getPerfil().getId();

        view.findViewById(R.id.B_historico_testes).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                HistoricoTestes();
            }
        });
    }

    private void HistoricoTestes() {
        NavController navController = NavHostFragment.findNavController(Fragment_Teste.this);
        navController.navigate(R.id.action_Teste_to_Historico_Testes);
    }

    public void Adicionar(){
        NavController navController = NavHostFragment.findNavController(Fragment_Teste.this);
        navController.navigate(R.id.action_Teste_to_Novo_Teste);
    }

    public void Voltar(){
        NavController navController = NavHostFragment.findNavController(Fragment_Teste.this);
        navController.navigate(R.id.action_Teste_to_Informacoes);
    }

    public void Home(){
        NavController navController = NavHostFragment.findNavController(Fragment_Teste.this);
        navController.navigate(R.id.action_Teste_to_Perfil);
    }

    @NonNull
    @Override
    public Loader<Cursor> onCreateLoader(int id, @Nullable Bundle args) {
        return new androidx.loader.content.CursorLoader(getContext(), BDContentProvider.ENDERECO_TESTES, BDTabelaTestes.TODOS_OS_CAMPOS_TESTES, BDTabelaTestes.FK_ID_PERFIL_COMPLETO + "=?", new String[]{String.valueOf(idperfil)}, BDTabelaTestes.DATA_RESULTADO);
    }

    @Override
    public void onLoadFinished(@NonNull Loader<Cursor> loader, Cursor data) {

    }

    @Override
    public void onLoaderReset(@NonNull Loader<Cursor> loader) {

    }
}