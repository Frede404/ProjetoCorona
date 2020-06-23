package com.fred.projetocorona;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class Fragment_Novo_perfil extends Fragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment__novo_perfil, container, false);
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState){
        super.onViewCreated(view, savedInstanceState);

        MainActivity activity = (MainActivity) getActivity();
        activity.setFragmentActual(this);
        activity.setMenuActual(R.menu.menu_novo_perfil);
    }

    public void Guardar(){
        NavController navController = NavHostFragment.findNavController(Fragment_Novo_perfil.this);
        navController.navigate(R.id.action_Novo_perfil_to_Informacoes);
    }

    public void Cancelar(){
        NavController navController = NavHostFragment.findNavController(Fragment_Novo_perfil.this);
        navController.navigate(R.id.action_Novo_perfil_to_Perfil);
    }
}