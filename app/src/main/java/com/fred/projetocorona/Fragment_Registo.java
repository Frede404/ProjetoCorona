package com.fred.projetocorona;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class Fragment_Registo extends Fragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment__registo, container, false);
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState){
        super.onViewCreated(view, savedInstanceState);

        MainActivity activity = (MainActivity) getActivity();
        activity.setFragmentActual(this);
        activity.setMenuActual(R.menu.menu_registo);
    }

    public void Guardar(){
        Cancelar();
    }

    public void Cancelar(){
        NavController navController = NavHostFragment.findNavController(Fragment_Registo.this);
        navController.navigate(R.id.action_Registo_to_Informacoes);
    }

    public void Home(){
        NavController navController = NavHostFragment.findNavController(Fragment_Registo.this);
        navController.navigate(R.id.action_Registo_to_Perfil);
    }
}