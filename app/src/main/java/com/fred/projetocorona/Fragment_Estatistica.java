package com.fred.projetocorona;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class Fragment_Estatistica extends Fragment {
    private TextView TV_pessoas_registadas;
    private TextView TV_doentes_cronicos;
    private TextView TV_n_testes;
    private TextView TV_n_testes_positivos;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment__estatistica, container, false);
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState){
        super.onViewCreated(view, savedInstanceState);
        Context context = getContext();

        MainActivity activity = (MainActivity) getActivity();
        activity.setFragmentActual(this);
        activity.setMenuActual(R.menu.menu_estatisticas);

        TV_pessoas_registadas = view.findViewById(R.id.TV_pessoas_registadas);
        TV_doentes_cronicos = view.findViewById(R.id.TV_doentes_cronicos);
        TV_n_testes = view.findViewById(R.id.TV_n_testes);
        TV_n_testes_positivos = view.findViewById(R.id.TV_n_testes_positivos);

        BDEstatisticasProvider bdEstatisticasProvider = new BDEstatisticasProvider(context);

        TV_pessoas_registadas.setText(getString(R.string.TextoPessoasRegistadas) + ": " + bdEstatisticasProvider.getPessoas_registadas());
        TV_doentes_cronicos.setText(getString(R.string.Textodoentescronicos) + ": " + bdEstatisticasProvider.getDoentes_cronicos());
        TV_n_testes.setText(getString(R.string.TextoNtestesRealizados) + ": " + bdEstatisticasProvider.getN_testes());
        TV_n_testes_positivos.setText(getString(R.string.Textotestespositivos) + ": " + bdEstatisticasProvider.getTestes_positivos());
    }

    public void Voltar(){
        NavController navController = NavHostFragment.findNavController(Fragment_Estatistica.this);
        navController.navigate(R.id.action_Estatistica_to_Main);
    }
}