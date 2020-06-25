package com.fred.projetocorona;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.database.Cursor;
import android.net.Uri;
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
import android.widget.Toast;

public class Fragment_Perfil extends Fragment implements LoaderManager.LoaderCallbacks<Cursor> {
    public static final int _CURSOR_LOADER_PERFIS = 0;
    private AdaptadorPerfis adaptadorperfil;
    private PerfilPessoa perfil;
    private MainActivity activity;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment__perfil, container, false);
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState){
        super.onViewCreated(view, savedInstanceState);

        Context context = getContext();

        activity = (MainActivity) getActivity();
        activity.setFragmentActual(this);
        activity.setMenuActual(R.menu.menu_perfil);

        view.findViewById(R.id.B_informacao).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Informacao();
            }
        });

        RecyclerView recyclerViewPerfis = (RecyclerView) view.findViewById(R.id.RV_Perfis);
        adaptadorperfil = new AdaptadorPerfis(context);

        recyclerViewPerfis.setAdapter(adaptadorperfil);
        recyclerViewPerfis.setLayoutManager(new LinearLayoutManager(context));
        adaptadorperfil.setCursor(null);

        LoaderManager.getInstance(this).initLoader(_CURSOR_LOADER_PERFIS, null, this);//gestao dos items (scroll);
    }

    private void Informacao() {
        try {
            if (activity.getPerfil().getId() >= 0) {
                NavController navController = NavHostFragment.findNavController(Fragment_Perfil.this);
                navController.navigate(R.id.action_Perfil_to_Informacoes);
            }
        }catch (Exception e){
            Toast.makeText(getContext(), R.string.Textoselecioneperfil, Toast.LENGTH_SHORT).show();
        }
    }

    public void Voltar(){
        NavController navController = NavHostFragment.findNavController(Fragment_Perfil.this);
        navController.navigate(R.id.action_Perfil_to_Main);
    }

    public void Adicionar(){
        NavController navController = NavHostFragment.findNavController(Fragment_Perfil.this);
        navController.navigate(R.id.action_Perfil_to_Novo_perfil);
    }

    public void Editar(){
        NavController navController = NavHostFragment.findNavController(Fragment_Perfil.this);
        navController.navigate(R.id.action_Perfil_to_Altera_Perfil);
    }

    public void Eliminar(){
        perfil= activity.getPerfil();

        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());

        builder.setTitle(R.string.Textoeliminarperfildialog);
        builder.setMessage("Tem a certeza que pretende elimar o perfil " + perfil.getNome() + "?");
        builder.setIcon(R.drawable.ic_baseline_delete_24);
        builder.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                EliminaDefinitivamente();
            }
        });
        builder.setNegativeButton("Não", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        builder.show();
    }

    private void EliminaDefinitivamente(){
        try {
            Uri enderecoPerfil = Uri.withAppendedPath(BDContentProvider.ENDERECO_PERFIS, String.valueOf(perfil.getId()));

            int registoApagados = getActivity().getContentResolver().delete(enderecoPerfil, null, null);
            if (registoApagados == 1) {
                Toast.makeText(getContext(), R.string.Textoeliminadosucesso, Toast.LENGTH_SHORT).show();
                NavController navController = NavHostFragment.findNavController(Fragment_Perfil.this);
                navController.navigate(R.id.action_Perfil_self);
            }
        }catch (Exception e){
            Toast.makeText(getContext(), R.string.Textoerroeliminar, Toast.LENGTH_SHORT).show();
        }
    }

    @NonNull
    @Override
    public Loader<Cursor> onCreateLoader(int id, @Nullable Bundle args) {
        return new androidx.loader.content.CursorLoader(getContext(),BDContentProvider.ENDERECO_PERFIS, BDTabelaPerfis.TODOS_CAMPOS, null, null, BDTabelaPerfis.NOME);
    }

    @Override
    public void onLoadFinished(@NonNull Loader<Cursor> loader, Cursor data) {
        adaptadorperfil.setCursor(data);
    }

    @Override
    public void onLoaderReset(@NonNull Loader<Cursor> loader) {
        adaptadorperfil.setCursor(null);
    }
}