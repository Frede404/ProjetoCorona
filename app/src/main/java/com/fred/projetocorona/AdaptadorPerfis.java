package com.fred.projetocorona;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class AdaptadorPerfis extends RecyclerView.Adapter<AdaptadorPerfis.ViewHolderPerfil>  {

    private final Context context;
    private Cursor cursor = null;

    public void setCursor(Cursor cursor) {
        if (cursor != this.cursor) {
            this.cursor = cursor;
            notifyDataSetChanged();
        }
    }

    public AdaptadorPerfis(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolderPerfil onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemPerfil = LayoutInflater.from(context).inflate(R.layout.item_perfil, parent, false);

        return new ViewHolderPerfil(itemPerfil);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderPerfil holder, int position) {
        cursor.moveToPosition(position);
        PerfilPessoa perfil = Converte.cursorToPerfil(cursor);
        holder.setPerfil(perfil);
    }

    @Override
    public int getItemCount() {
        if(cursor == null) {
            return 0;
        }

        return cursor.getCount();
    }

    private ViewHolderPerfil viewHolderPerfilSelecionado = null;

    public class ViewHolderPerfil extends RecyclerView.ViewHolder implements View.OnClickListener {
        private PerfilPessoa perfil = null;

        private final TextView textViewNome;
        private final TextView textViewDataNasc;

        public ViewHolderPerfil(@NonNull View itemView) {
            super(itemView);

            textViewNome = (TextView)itemView.findViewById(R.id.TV_Item_Perfil_Nome);
            textViewDataNasc = (TextView)itemView.findViewById(R.id.TV_Item_Perfil_Data_Nasc);

            itemView.setOnClickListener(this);
        }

        public void setPerfil(PerfilPessoa perfil) {
            this.perfil = perfil;

            textViewNome.setText(perfil.getNome());
            textViewDataNasc.setText(String.valueOf(perfil.getDataNascimento()));
        }

        @Override
        public void onClick(View v) {
            if (viewHolderPerfilSelecionado == this) {
                return;
            }

            if (viewHolderPerfilSelecionado != null) {
                viewHolderPerfilSelecionado.desSeleciona();
            }

            viewHolderPerfilSelecionado = this;
            seleciona();

            MainActivity activity = (MainActivity) AdaptadorPerfis.this.context;
            activity.PerfilAlterado(perfil);
        }

        private void seleciona() {
            itemView.setBackgroundResource(R.color.colorAccent);
        }

        private void desSeleciona() {
            itemView.setBackgroundResource(android.R.color.white);
        }
    }
}