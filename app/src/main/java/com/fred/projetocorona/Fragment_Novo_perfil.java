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
    private CheckBox novo_prespiratorio;
    private CheckBox novo_hipertensao;
    private CheckBox novo_poncologico;
    private CheckBox novo_sisimunitario;
    private MainActivity activity;

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

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Context context = getContext();//novo

        activity = (MainActivity) getActivity();
        activity.setFragmentActual(this);
        activity.setMenuActual(R.menu.menu_novo_perfil);

        novo_nome = view.findViewById(R.id.TIET_novo_nome);
        nova_data = view.findViewById(R.id.TIET_nova_data);
        novo_cardiovascular = view.findViewById(R.id.CB_novo_cardiovascular);
        novo_diabetes = view.findViewById(R.id.CB_novo_diabetes);
        novo_prespiratorio = view.findViewById(R.id.CB_novo_respiratorio);
        novo_hipertensao = view.findViewById(R.id.CB_novo_hipertensao);
        novo_poncologico = view.findViewById(R.id.CB_novo_oncologicos);
        novo_sisimunitario = view.findViewById(R.id.CB_novo_sistema_imunitario);
    }

    public void Guardar() {
        String nome = novo_nome.getText().toString();
        String data = nova_data.getText().toString();
        boolean cardiovascular = novo_cardiovascular.isChecked();
        boolean diabetes = novo_diabetes.isChecked();
        boolean prespiratorio = novo_prespiratorio.isChecked();
        boolean hipertensao = novo_hipertensao.isChecked();
        boolean poncologicos = novo_poncologico.isChecked();
        boolean sisimunitario = novo_sisimunitario.isChecked();

        if (nome.length() == 0) {//validacoes
            novo_nome.setError("Insira um nome");
            novo_nome.requestFocus();
            return;
        } else if (data.length() == 0) {
            nova_data.setError("Insira uma data");
            nova_data.requestFocus();
            return;
        }

        PerfilPessoa perfil = new PerfilPessoa();
        perfil.setNome(nome);
        perfil.setDataNascimento(data);
        perfil.setCardiovascular(converteboolean(cardiovascular));
        perfil.setDiabetes(converteboolean(diabetes));
        perfil.setPRespiratorios(converteboolean(prespiratorio));
        perfil.setHipertenso(converteboolean(hipertensao));
        perfil.setPOncologicos(converteboolean(poncologicos));
        perfil.setSisEmunitario(converteboolean(sisimunitario));

        try {
            getActivity().getContentResolver().insert(BDContentProvider.ENDERECO_PERFIS, Converte.PerfilToContentValues(perfil));
            perfil.setId(PerfilPessoa.AUXNOVOPERFIL);
            activity.setPerfil(perfil);
            Toast.makeText(getContext(), R.string.TextoInsereSucesso, Toast.LENGTH_SHORT).show();
            NavController navController = NavHostFragment.findNavController(Fragment_Novo_perfil.this);
            navController.navigate(R.id.action_Novo_perfil_to_Informacoes);
        } catch (Exception e) {
            //Snackbar.make(novo_nome, R.string.TextoErroInserir, Snackbar.LENGTH_INDEFINITE).show();
            Toast.makeText(getContext(), R.string.TextoErroInserir, Toast.LENGTH_SHORT).show();
        }

    }

    public void Cancelar() {
        NavController navController = NavHostFragment.findNavController(Fragment_Novo_perfil.this);
        navController.navigate(R.id.action_Novo_perfil_to_Perfil);
    }

    private int converteboolean(boolean auxboolean){
        if(auxboolean)
        {
            return 1;
        }else

        {
            return 0;
        }
    }
}