package com.fred.projetocorona;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

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

        /*view.findViewById(R.id.BPerfis).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Perfis();
            }
        });*/
    }

    /*private void Perfis() {
        NavController navController = NavHostFragment.findNavController(fragment_menu_principal.this);
        navController.navigate(R.id.id_da_seta);
    }*/
}