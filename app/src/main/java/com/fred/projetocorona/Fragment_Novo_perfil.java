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
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class Fragment_Novo_perfil extends Fragment {
    private EditText novo_nome;
    private EditText nova_data;
    private CheckBox novo_cardiovascular;
    private CheckBox novo_diabetes;
    private CheckBox novo_prespiratorios;
    private CheckBox novo_hipertenso;
    private CheckBox novo_poncologicos;
    private CheckBox novo_sisimunitario;

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

        novo_nome = view.findViewById(R.id.TIET_novo_nome);
        nova_data = view.findViewById(R.id.TIET_nova_data);
        novo_cardiovascular = view.findViewById(R.id.CB_novo_cardiovascular);
        novo_diabetes = view.findViewById(R.id.CB_novo_diabetes);
        novo_prespiratorios = view.findViewById(R.id.CB_novo_respiratorio);
        novo_hipertenso = view.findViewById(R.id.CB_novo_hipertensao);
        novo_poncologicos = view.findViewById(R.id.CB_novo_oncologicos);
        novo_sisimunitario = view.findViewById(R.id.CB_novo_sistema_imunitario);
    }

    public void Guardar(){
        String nome = novo_nome.getText().toString();
        String data = nova_data.getText().toString();
        boolean cardiovascular = novo_cardiovascular.isChecked();
        boolean diabetes = novo_diabetes.isChecked();
        boolean prespiratorios = novo_prespiratorios.isChecked();
        boolean hipertensao = novo_hipertenso.isChecked();
        boolean poncologicos = novo_poncologicos.isChecked();
        boolean sisimunitario = novo_sisimunitario.isChecked();

        if(nome.length() == 0){
            novo_nome.setError(getString(R.string.Textoinserirnome));
            novo_nome.requestFocus();
        }else if(data.length() == 0){
            nova_data.setError(getString(R.string.Textodataerrada));
            nova_data.requestFocus();
        }

        PerfilPessoa perfil = new PerfilPessoa();
        perfil.setNome(nome);
        perfil.setDataNascimento(data);
        perfil.setCardiovascular(converetebooleannovoperfil(cardiovascular));
        perfil.setDiabetes(converetebooleannovoperfil(diabetes));
        perfil.setPRespiratorios(converetebooleannovoperfil(prespiratorios));
        perfil.setHipertenso(converetebooleannovoperfil(hipertensao));
        perfil.setPOncologicos(converetebooleannovoperfil(poncologicos));
        perfil.setSisEmunitario(converetebooleannovoperfil(sisimunitario));

        try{
            getActivity().getContentResolver().insert(BDContentProvider.ENDERECO_PERFIS, Converte.PerfilToContentValues(perfil));
            Toast.makeText(getContext(), R.string.Textoadicionadosucesso, Toast.LENGTH_SHORT).show();
            NavController navController = NavHostFragment.findNavController(Fragment_Novo_perfil.this);
            navController.navigate(R.id.action_Novo_perfil_to_Informacoes);
        }catch (Exception e){
            Toast.makeText(getContext(), R.string.Textofalhaadicao, Toast.LENGTH_SHORT).show();
        }
    }

    public void Cancelar(){
        NavController navController = NavHostFragment.findNavController(Fragment_Novo_perfil.this);
        navController.navigate(R.id.action_Novo_perfil_to_Perfil);
    }

    private int converetebooleannovoperfil(boolean conversor){
        if(conversor){
            return 1;
        }else{
            return 0;
        }
    }
}