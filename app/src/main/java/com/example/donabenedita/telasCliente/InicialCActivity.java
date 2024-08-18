package com.example.donabenedita.telasCliente;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.donabenedita.R;
import com.example.donabenedita.classes.Logado;

public class InicialCActivity extends AppCompatActivity {
    //Variaveis
    private TextView logado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicial_c);
        //Ids
        logado = findViewById(R.id.tvLogin);

        Bundle dados = getIntent().getExtras(); //Passando os dados
        Logado login = (Logado) dados.getSerializable("logado");
        logado.setText("Bem-vindo " + login.getNome());
    }

    public void sair(View view){
        finish();
    }
}