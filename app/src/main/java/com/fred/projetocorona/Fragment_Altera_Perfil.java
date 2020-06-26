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
    private EditText altera_nome;
    private TextView nome_antigo;
    private EditText altera_data;
    private TextView data_antiga;
    private CheckBox altera_cardiovascular;
    private CheckBox altera_diabetes;
    private CheckBox altera_prespiratorio;
    private CheckBox altera_hipertensao;
    private CheckBox altera_poncologico;
    private CheckBox altera_sisimunitario;

    private PerfilPessoa perfil;
    private long id;

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
        altera_prespiratorio = view.findViewById(R.id.CB_altera_respiratorio);
        altera_hipertensao = view.findViewById(R.id.CB_altera_hipertensao);
        altera_poncologico = view.findViewById(R.id.CB_altera_oncologicos);
        altera_sisimunitario = view.findViewById(R.id.CB_altera_sistema_imunitario);

        perfil = activity.getPerfil();
        id = perfil.getId();
        altera_nome.setText(perfil.getNome());
        nome_antigo.setText(nome_antigo.getText() + " " + perfil.getNome());
        altera_data.setText(perfil.getDataNascimento());
        data_antiga.setText(data_antiga.getText() + " " + perfil.getDataNascimento());
        altera_cardiovascular.setChecked(perfil.getCardiovascular());
        altera_diabetes.setChecked(perfil.getDiabetes());
        altera_prespiratorio.setChecked(perfil.getPRespiratorios());
        altera_hipertensao.setChecked(perfil.getHipertenso());
        altera_poncologico.setChecked(perfil.getPOncologicos());
        altera_sisimunitario.setChecked(perfil.getSisEmunitario());
    }

    public void Guardar(){
        String nome = altera_nome.getText().toString();
        String data = altera_data.getText().toString();
        boolean cardiovascular = altera_cardiovascular.isChecked();
        boolean diabetes = altera_diabetes.isChecked();
        boolean prespiratorio = altera_prespiratorio.isChecked();
        boolean hipertensao = altera_hipertensao.isChecked();
        boolean poncologicos = altera_poncologico.isChecked();
        boolean sisimunitario = altera_sisimunitario.isChecked();

        if (nome.length() == 0) {//validacoes
            altera_nome.setError("Insira um nome");
            altera_nome.requestFocus();
            return;
        } else if (data.length() == 0) {
            altera_data.setError("Insira uma data");
            altera_data.requestFocus();
            return;
        }

        perfil.setNome(nome);
        perfil.setDataNascimento(data);
        perfil.setCardiovascular(converteboolean(cardiovascular));
        perfil.setDiabetes(converteboolean(diabetes));
        perfil.setPRespiratorios(converteboolean(prespiratorio));
        perfil.setHipertenso(converteboolean(hipertensao));
        perfil.setPOncologicos(converteboolean(poncologicos));
        perfil.setSisEmunitario(converteboolean(sisimunitario));

        try {
            Uri enderecoPerfil = Uri.withAppendedPath(BDContentProvider.ENDERECO_PERFIS, String.valueOf(perfil.getId()));

            int registos = getActivity().getContentResolver().update(enderecoPerfil, Converte.PerfilToContentValues(perfil), null,null);
            if(registos == 1){
                Toast.makeText(getContext(),"Perfil alterado com sucesso", Toast.LENGTH_SHORT).show();
                Cancelar();
                return;
            }
        } catch (Exception e) {

        }
        Toast.makeText(getContext(),"Perfil alterado com sucesso", Toast.LENGTH_SHORT).show();

    }

    public void Cancelar(){
        NavController navController = NavHostFragment.findNavController(Fragment_Altera_Perfil.this);
        navController.navigate(R.id.action_Altera_Perfil_to_Perfil);
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