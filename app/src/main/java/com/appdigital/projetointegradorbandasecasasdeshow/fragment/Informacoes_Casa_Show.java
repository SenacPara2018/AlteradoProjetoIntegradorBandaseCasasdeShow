package com.appdigital.projetointegradorbandasecasasdeshow.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.appdigital.projetointegradorbandasecasasdeshow.R;
import com.appdigital.projetointegradorbandasecasasdeshow.model.Banda;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class Informacoes_Casa_Show extends Fragment {
    ListView listViewDeBanda;
    Banda banda;
    ArrayList listaArrayBanda;
    ArrayAdapter adapter;
    DatabaseReference reference;
    FirebaseDatabase database;


    public Informacoes_Casa_Show() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_informacoes_casa_show, container, false);
        listViewDeBanda = view.findViewById(R.id.listView_Casa_Show);
        iniciarFirebase();
        getLista();
        return view;

    }
    public void iniciarFirebase(){
        database = FirebaseDatabase.getInstance();
        reference = database.getReference("Banda");
    }
    public void getLista(){
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                listaArrayBanda =  new ArrayList();
                for(DataSnapshot d: dataSnapshot.getChildren()){
                    banda = d.getValue(Banda.class);
                    listaArrayBanda.add(banda);
                }
                carregarListaDeBanda();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
    public void carregarListaDeBanda(){
        adapter = new ArrayAdapter(getContext(), android.R.layout.simple_list_item_1, listaArrayBanda);
        listViewDeBanda.setAdapter(adapter);

    }

}
