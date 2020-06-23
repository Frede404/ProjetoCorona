package com.fred.projetocorona;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class Fragment_Main extends Fragment {


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment__main, container, false);
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState){
        super.onViewCreated(view, savedInstanceState);

        view.findViewById(R.id.B_perfis).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Perfis();
            }
        });

        view.findViewById(R.id.B_estatistica).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Estatistica();
            }
        });

        view.findViewById(R.id.B_sair).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Exit();
            }
        });
    }

    private void Perfis() {
        NavController navController = NavHostFragment.findNavController(Fragment_Main.this);
        navController.navigate(R.id.action_Main_to_Perfil);
    }

    private void Estatistica() {
        NavController navController = NavHostFragment.findNavController(Fragment_Main.this);
        navController.navigate(R.id.action_Main_to_Estatistica);
    }

    private void Exit() {
        getActivity().finish();
    }

}