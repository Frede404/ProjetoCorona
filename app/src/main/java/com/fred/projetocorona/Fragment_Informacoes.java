package com.fred.projetocorona;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class Fragment_Informacoes extends Fragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment__informacoes, container, false);
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState){
        super.onViewCreated(view, savedInstanceState);

        view.findViewById(R.id.B_registo).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RegistoDiario();
            }
        });
        view.findViewById(R.id.B_historico_registo).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                HistoricoRegistos();
            }
        });
        view.findViewById(R.id.B_testes).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                VerTeste();
            }
        });
    }

    private void RegistoDiario() {
        NavController navController = NavHostFragment.findNavController(Fragment_Informacoes.this);
        navController.navigate(R.id.action_Informacoes_to_Registo);
    }

    private void HistoricoRegistos() {
        NavController navController = NavHostFragment.findNavController(Fragment_Informacoes.this);
        navController.navigate(R.id.action_Informacoes_to_Historico_Registos);
    }

    private void VerTeste() {
        NavController navController = NavHostFragment.findNavController(Fragment_Informacoes.this);
        navController.navigate(R.id.action_Informacoes_to_Teste);
    }
}