package com.example.practica7.Adaptadores;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.example.practica7.Modelos.Persona;
import com.example.practica7.R;

import java.util.List;

public class PersonaAdaptador extends RecyclerView.Adapter<PersonaAdaptador.viewHolder> {

    List<Persona> lp;

    public PersonaAdaptador(List<Persona> lp) {
        this.lp = lp;
    }

    @NonNull
    @Override
    public PersonaAdaptador.viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item,parent,false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PersonaAdaptador.viewHolder holder, int position) {
           holder.setData(lp.get(position));
    }

    @Override
    public int getItemCount() {
        return lp.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView Nombre;
        TextView Telefono;
        ImageButton llamar;
        Persona personaHolder;

        public viewHolder(@NonNull View itemView) {
            super(itemView);
            Nombre=itemView.findViewById(R.id.txtNombre);
            Telefono=itemView.findViewById(R.id.txtTelefono);
            llamar=itemView.findViewById(R.id.boton);
            llamar.setOnClickListener(this);


        }
        public void setData(Persona p){
            personaHolder=p;
            Nombre.setText(personaHolder.getNombre());
            Telefono.setText(personaHolder.getTelefono());

        }

        @Override
        public void onClick(View view) {
            hacerLlamada();
        }
        private void hacerLlamada(){
                Intent llamar=new Intent(Intent.ACTION_CALL,Uri.parse("tel:"+personaHolder.getTelefono()));
                itemView.getContext().startActivity(llamar);
        }


    }
}
