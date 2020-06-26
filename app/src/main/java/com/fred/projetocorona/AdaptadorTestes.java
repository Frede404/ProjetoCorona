package com.fred.projetocorona;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class AdaptadorTestes extends RecyclerView.Adapter<AdaptadorTestes.ViewHolderTeste>{
    private final Context context;

    private Cursor cursor;

    public void setCursor(Cursor cursor){
        if(cursor != this.cursor){
            this.cursor = cursor;
            notifyDataSetChanged();
        }
    }

    public AdaptadorTestes(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public AdaptadorTestes.ViewHolderTeste onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemTeste = LayoutInflater.from(context).inflate(R.layout.item_testes, parent, false);

        return new ViewHolderTeste(itemTeste);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderTeste holder, int position) {
        cursor.moveToPosition(position);
        Testes teste = Converte.cursorParaTeste(cursor);
        holder.setTeste(teste);
    }

    @Override
    public int getItemCount() {
        if(cursor == null) {
            return 0;
        }
        return cursor.getCount();
    }

    public class ViewHolderTeste extends RecyclerView.ViewHolder {

        private Testes teste = null;
        private final TextView textViewItemTesteDataTeste;
        private final TextView textViewItemTesteResultado;

        public ViewHolderTeste(@NonNull View itemView) {
            super(itemView);

            textViewItemTesteDataTeste = (TextView)itemView.findViewById(R.id.TV_Item_Teste_Data_Realizado);
            textViewItemTesteResultado = (TextView)itemView.findViewById(R.id.TV_Item_Teste_Resultdo);
        }

        public void setTeste(Testes teste) {
            this.teste = teste;
            textViewItemTesteDataTeste.setText(teste.getData_teste());
            textViewItemTesteResultado.setText(teste.getResultado());
        }
    }
}