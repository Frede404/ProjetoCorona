package com.fred.projetocorona;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Fragment_Altera_Perfil extends Fragment {
    private TextView nome_antigo;
    private EditText altera_nome;
    private TextView data_antiga;
    private EditText altera_data;
    private CheckBox altera_cardiovascular;
    private CheckBox altera_diabetes;
    private CheckBox altera_prespiratorios;
    private CheckBox altera_hipertenso;
    private CheckBox altera_poncologicos;
    private CheckBox altera_sisimunitario;

    private PerfilPessoa perfil;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment__altera__perfil, container, false);
    }


    public void onViewCreated(@NonNull View view, Bundle savedInstanceState){
        super.onViewCreated(view, savedInstanceState);
        Context context = getContext();

        MainActivity activity = (MainActivity) getActivity();
        activity.setFragmentActual(this);
        activity.setMenuActual(R.menu.menu_altera_perfil);

        nome_antigo = view.findViewById(R.id.TV_Nome_antigo);
        altera_nome = view.findViewById(R.id.TIET_altera_nome);
        data_antiga = view.findViewById(R.id.TV_data_antiga);
        altera_data = view.findViewById(R.id.TIET_altera_data);
        altera_cardiovascular = view.findViewById(R.id.CB_altera_cardiovascular);
        altera_diabetes = view.findViewById(R.id.CB_altera_diabetes);
        altera_prespiratorios = view.findViewById(R.id.CB_altera_respiratorio);
        altera_hipertenso = view.findViewById(R.id.CB_altera_hipertensao);
        altera_poncologicos = view.findViewById(R.id.CB_altera_oncologicos);
        altera_sisimunitario = view.findViewById(R.id.CB_altera_sistema_imunitario);

        perfil = activity.getPerfil();
        nome_antigo.setText(nome_antigo.getText().toString() + ": " + perfil.getNome());
        altera_nome.setText(perfil.getNome());
        data_antiga.setText(data_antiga.getText().toString() + ": " + perfil.getDataNascimento());
        altera_data.setText(perfil.getDataNascimento());
        altera_cardiovascular.setChecked(perfil.getCardiovascular());
        altera_diabetes.setChecked(perfil.getDiabetes());
        altera_prespiratorios.setChecked(perfil.getPRespiratorios());
        altera_hipertenso.setChecked(perfil.getHipertenso());
        altera_poncologicos.setChecked(perfil.getPOncologicos());
        altera_sisimunitario.setChecked(perfil.getSisEmunitario());
    }

    public void Guardar(){
        String nome = altera_nome.getText().toString();
        String data = altera_data.getText().toString();
        boolean cardiovascular = altera_cardiovascular.isChecked();
        boolean diabetes = altera_diabetes.isChecked();
        boolean prespiratorios = altera_prespiratorios.isChecked();
        boolean hipertensao = altera_hipertenso.isChecked();
        boolean poncologicos = altera_poncologicos.isChecked();
        boolean sisimunitario = altera_sisimunitario.isChecked();

        if(nome.length() == 0){
            altera_nome.setError(getString(R.string.Textoinserirnome));
            altera_nome.requestFocus();
        }else if(data.length() == 0){
            altera_data.setError(getString(R.string.Textodataerrada));
            altera_data.requestFocus();
        }

        perfil.setNome(nome);
        perfil.setDataNascimento(data);
        perfil.setCardiovascular(converetebooleanalteraperfil(cardiovascular));
        perfil.setDiabetes(converetebooleanalteraperfil(diabetes));
        perfil.setPRespiratorios(converetebooleanalteraperfil(prespiratorios));
        perfil.setHipertenso(converetebooleanalteraperfil(hipertensao));
        perfil.setPOncologicos(converetebooleanalteraperfil(poncologicos));
        perfil.setSisEmunitario(converetebooleanalteraperfil(sisimunitario));

        try {
            Uri enderecoPerfil = Uri.withAppendedPath(BDContentProvider.ENDERECO_PERFIS, String.valueOf(perfil.getId()));

            int registoApagados = getActivity().getContentResolver().update(enderecoPerfil, Converte.PerfilToContentValues(perfil), null, null);
            if (registoApagados == 1) {
                Toast.makeText(getContext(), R.string.Textoalterarsucesso, Toast.LENGTH_SHORT).show();
                Cancelar();
            }
        }catch (Exception e){
            Toast.makeText(getContext(), R.string.Textoerroalterar, Toast.LENGTH_SHORT).show();
        }
    }

    public void Cancelar(){
        NavController navController = NavHostFragment.findNavController(Fragment_Altera_Perfil.this);
        navController.navigate(R.id.action_Altera_Perfil_to_Perfil);
    }

    private int converetebooleanalteraperfil(boolean conversor){
        if(conversor){
            return 1;
        }else{
            return 0;
        }
    }
}