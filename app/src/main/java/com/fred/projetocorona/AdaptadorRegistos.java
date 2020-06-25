package com.fred.projetocorona;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class AdaptadorRegistos extends RecyclerView.Adapter<AdaptadorRegistos.ViewHolderRegisto>{
    private Context context;

    private Cursor cursor = null;

    public void setCursor(Cursor cursor){
        if(cursor != this.cursor){
            this.cursor = cursor;
            notifyDataSetChanged();
        }
    }

    public AdaptadorRegistos(Context context){
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolderRegisto onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemRegisto = LayoutInflater.from(context).inflate(R.layout.item_registo_diario, parent, false);

        return new ViewHolderRegisto(itemRegisto);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderRegisto holder, int position) {
        cursor.moveToPosition(position);
        Registos registo = Converte.cursorParaRegisto(cursor);
        holder.setRegisto(registo);
    }

    /**
     * Returns the total number of items in the data set held by the adapter.
     *
     * @return The total number of items in this adapter.
     */
    @Override
    public int getItemCount() {
        if(cursor == null){
            return 0;
        }
        return cursor.getCount();
    }

    public class ViewHolderRegisto extends RecyclerView.ViewHolder {

        private Registos registo = null;

        private final TextView textViewItemRegistoDataRegisto;
        private final TextView textViewItemRegistoTemperatura;
        private final TextView textViewItemRegistoProblemas;


        public ViewHolderRegisto(@NonNull View itemView) {
            super(itemView);

            textViewItemRegistoDataRegisto = (TextView)itemView.findViewById(R.id.TV_Item_Registo_data);
            textViewItemRegistoTemperatura = (TextView)itemView.findViewById(R.id.TV_Item_Registo_Temperatura);
            textViewItemRegistoProblemas = (TextView)itemView.findViewById(R.id.TV_Item_Registo_Problemas);
        }

        public void setRegisto(Registos registo) {
            this.registo = registo;
            textViewItemRegistoDataRegisto.setText(registo.getData());
            textViewItemRegistoTemperatura.setText(""+registo.getTemperatura());
            if(registo.isTosse() && registo.isFadiga()){
                textViewItemRegistoProblemas.setText("tosse e fadiga");
            }else if(registo.getTosse() != registo.getFadiga()){
                if(registo.isTosse()){
                    textViewItemRegistoProblemas.setText("tosse");
                }else{
                    textViewItemRegistoProblemas.setText("fadiga");
                }
            }else{
                textViewItemRegistoProblemas.setVisibility(View.GONE);
            }
        }
    }
}