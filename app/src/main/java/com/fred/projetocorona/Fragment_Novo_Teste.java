package com.fred.projetocorona;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class Fragment_Novo_Teste extends Fragment {

    private Spinner spinner;
    private String[] test = {"Positivo","Negativo","Inconclusivo"};

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment__novo__teste,container,false);
        spinner = (Spinner) view.findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> mSortAdapter = new ArrayAdapter<CharSequence>(getActivity(), android.R.layout.simple_spinner_item, test);
        mSortAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(mSortAdapter);
        return view;
        //return inflater.inflate(R.layout.fragment__novo__teste, container, false);
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState){
        super.onViewCreated(view, savedInstanceState);

        MainActivity activity = (MainActivity) getActivity();
        activity.setFragmentActual(this);
        activity.setMenuActual(R.menu.menu_novo_teste);
    }

    public void Guardar(){
        Cancelar();
    }

    public void Cancelar(){
        NavController navController = NavHostFragment.findNavController(Fragment_Novo_Teste.this);
        navController.navigate(R.id.action_Novo_Teste_to_Teste);
    }

    public void Home(){
        NavController navController = NavHostFragment.findNavController(Fragment_Novo_Teste.this);
        navController.navigate(R.id.action_Novo_Teste_to_Perfil);
    }
}