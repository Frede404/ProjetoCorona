package com.fred.projetocorona;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class Fragment_Historico_Testes extends Fragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment__historico__testes, container, false);
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState){
        super.onViewCreated(view, savedInstanceState);

        MainActivity activity = (MainActivity) getActivity();
        activity.setFragmentActual(this);
        activity.setMenuActual(R.menu.menu_historico_testes);
    }

    public void Voltar(){
        NavController navController = NavHostFragment.findNavController(Fragment_Historico_Testes.this);
        navController.navigate(R.id.action_Historico_Testes_to_Teste);
    }

    public void Home(){
        NavController navController = NavHostFragment.findNavController(Fragment_Historico_Testes.this);
        navController.navigate(R.id.action_Historico_Testes_to_Perfil);
    }
}