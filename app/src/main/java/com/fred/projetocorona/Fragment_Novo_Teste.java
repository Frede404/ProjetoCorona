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
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class Fragment_Novo_Teste extends Fragment {
    private Spinner spinner;
    private String[] test = {"","Positivo","Negativo","Inconclusivo"};

    private EditText TIET_data_teste;
    private EditText TIET_data_resultado;
    MainActivity activity;

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

        activity = (MainActivity) getActivity();
        activity.setFragmentActual(this);
        activity.setMenuActual(R.menu.menu_novo_teste);

        TIET_data_teste=view.findViewById(R.id.TIET_data_teste);
        TIET_data_resultado=view.findViewById(R.id.TIET_data_resultado);
    }

    public void Guardar(){
        String data_teste = TIET_data_teste.getText().toString();
        String data_resultado = TIET_data_resultado.getText().toString();
        int aux = spinner.getSelectedItemPosition();

        if (data_teste.length() == 0) {//validacoes
            TIET_data_teste.setError(getString(R.string.TextoInsiraData));
            TIET_data_teste.requestFocus();
            return;
        } else if (data_resultado.length() == 0) {
            TIET_data_resultado.setError(getString(R.string.TextoInsiraData));
            TIET_data_resultado.requestFocus();
            return;
        }else if(aux == 0){
            Toast.makeText(getContext(), R.string.TextoSelecionresultado, Toast.LENGTH_SHORT).show();
            return;
        }else if(!activity.vericaData(data_teste)){
            TIET_data_teste.setError(getString(R.string.TextoInsiradatavalida));
            TIET_data_teste.requestFocus();
            return;
        }else if(!activity.vericaData(data_resultado)){
            TIET_data_resultado.setError(getString(R.string.TextoInsiradatavalida));
            TIET_data_resultado.requestFocus();
            return;
        }

        String spiner_resultado = spinner.getSelectedItem().toString();
        long id_perfil = activity.getPerfil().getId();

        Testes teste = new Testes();
        teste.setIdPerfil(id_perfil);
        teste.setData_teste(data_teste);
        teste.setData_resultado(data_resultado);
        teste.setResultado(spiner_resultado);

        try{
            getActivity().getContentResolver().insert(BDContentProvider.ENDERECO_TESTES, Converte.testeParaContentValues(teste));
            Toast.makeText(getContext(),R.string.TextoInsereSucesso, Toast.LENGTH_SHORT).show();
            Cancelar();
        }catch (Exception e){
            Toast.makeText(getContext(),R.string.TextoErroInserir, Toast.LENGTH_SHORT).show();
        }
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