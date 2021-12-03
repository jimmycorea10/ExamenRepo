package com.example.examenreposicionjc;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class lista extends AppCompatActivity {

    RecyclerView recyclerView;
    DatabaseReference database;
    DatabaseReference database2;
    public static MyAdapter myAdapter;
    ArrayList<Usuarios> list;
    Button btnDetalle;
    EditText etBuscador;

    private String la="";
    private String lon="";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista);

        btnDetalle= findViewById(R.id.btndetallelist);
        recyclerView = findViewById(R.id.userlist);
        database = FirebaseDatabase.getInstance().getReference("tabla");
        database2 = FirebaseDatabase.getInstance().getReference("foto");
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        list = new ArrayList<>();
        myAdapter = new MyAdapter(this,list);
        recyclerView.setAdapter(myAdapter);

        database.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                for (DataSnapshot dataSnapshot : snapshot.getChildren()){


                    Usuarios user = dataSnapshot.getValue(Usuarios.class);
                    list.add(user);



                }
                myAdapter.notifyDataSetChanged();

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });




    }

    public void filtrar(String texto) {
        ArrayList<Usuarios> filtrarLista = new ArrayList<>();

        for(Usuarios usuario : list) {
            if(usuario.getName1().toLowerCase().contains(texto.toLowerCase())) {
                filtrarLista.add(usuario);
            }
        }

        myAdapter.filtrar(filtrarLista);
    }





}