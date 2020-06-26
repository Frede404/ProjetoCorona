package com.fred.projetocorona;

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

public class Fragment_Registo extends Fragment {
    private String dataatual;
    private TextView TV_data_actual;
    private EditText TIET_temperatura;
    private CheckBox CB_tosse;
    private CheckBox CB_dif_respirar;
    private MainActivity activity;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment__registo, container, false);
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState){
        super.onViewCreated(view, savedInstanceState);

        activity = (MainActivity) getActivity();
        activity.setFragmentActual(this);
        activity.setMenuActual(R.menu.menu_registo);

        dataatual = activity.getData();

        TV_data_actual = view.findViewById(R.id.TV_data_actual);
        TV_data_actual.setText(dataatual);
        TIET_temperatura = view.findViewById(R.id.TIET_temperatura);
        CB_tosse = view.findViewById(R.id.CB_tosse);
        CB_dif_respirar = view.findViewById(R.id.CB_dif_respirar);
    }

    public void Guardar(){
        try {
            float temperatura = Float.parseFloat(TIET_temperatura.getText().toString());
            boolean tosse = CB_tosse.isChecked();
            boolean fadiga = CB_dif_respirar.isChecked();
            long id_perfil = activity.getPerfil().getId();

            Registos registo = new Registos();
            registo.setData(dataatual);
            registo.setTemperatura(temperatura);
            registo.setTosse(converteboolean(tosse));
            registo.setFadiga(converteboolean(fadiga));
            registo.setIdPerfil(id_perfil);

            try{
                getActivity().getContentResolver().insert(BDContentProvider.ENDERECO_REGISTOS, Converte.registoParaContentValues(registo));
                Toast.makeText(getContext(), R.string.Textoadicionadosucesso, Toast.LENGTH_SHORT).show();
                Cancelar();
            }catch (Exception e){
                Toast.makeText(getContext(),R.string.Textofalhaadicao, Toast.LENGTH_SHORT).show();
            }
        }catch(Exception e){
            TIET_temperatura.setError(getString(R.string.TemperaturaInvalida));
            TIET_temperatura.requestFocus();
        }
    }

    public void Cancelar(){
        NavController navController = NavHostFragment.findNavController(Fragment_Registo.this);
        navController.navigate(R.id.action_Registo_to_Informacoes);
    }

    public void Home(){
        NavController navController = NavHostFragment.findNavController(Fragment_Registo.this);
        navController.navigate(R.id.action_Registo_to_Perfil);
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