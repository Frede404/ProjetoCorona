package com.fred.projetocorona;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class Fragment_Perfil extends Fragment {

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

        MainActivity activity = (MainActivity) getActivity();
        activity.setFragmentActual(this);
        activity.setMenuActual(R.menu.menu_perfil);

        view.findViewById(R.id.B_informacao).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Informacao();
            }
        });
    }

    private void Informacao() {
        NavController navController = NavHostFragment.findNavController(Fragment_Perfil.this);
        navController.navigate(R.id.action_Perfil_to_Informacoes);
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
        //eliminar
    }
}