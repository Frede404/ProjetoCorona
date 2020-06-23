package com.fred.projetocorona;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class Fragment_Teste extends Fragment {

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

        MainActivity activity = (MainActivity) getActivity();
        activity.setFragmentActual(this);
        activity.setMenuActual(R.menu.menu_teste);

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
}