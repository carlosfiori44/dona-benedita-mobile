package com.example.donabenedita.telasFornecedor;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.donabenedita.MainActivity;
import com.example.donabenedita.R;
import com.example.donabenedita.classes.Cliente;
import com.example.donabenedita.classes.Fornecedor;
import com.example.donabenedita.classes.Logado;
import com.example.donabenedita.classes.Produto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class InicialFActivity extends AppCompatActivity {
    //Variaveis
    private TextView logado;
    private List<Produto> produto = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicial_f);
        //Ids
        logado = findViewById(R.id.tvLogin);

        Bundle dados = getIntent().getExtras(); //Passando os dados

        Logado login = (Logado) dados.getSerializable("logado");
        logado.setText("Bem-vindo " + login.getNome());
        produto = (List<Produto>) dados.getSerializable("produto");
    }

    public void novo(View view){
        Bundle dados = getIntent().getExtras(); //Passando os dados
        Intent intent = new Intent(getApplicationContext(), CadastroProdutoActivity.class);
        Logado login = (Logado) dados.getSerializable("logado");
        intent.putExtra("fornecedor", login.getNome());
        startActivity(intent);
    }

    public void ver(View view){
        Intent intent = new Intent(getApplicationContext(), MostraProdutoActivity.class);
        intent.putExtra("produto", (Serializable) produto);
        startActivity(intent);
    }

    public void sair(View view){
        Intent intent = new Intent();
        intent.putExtra("produto", (Serializable) produto);
        setResult(Activity.RESULT_OK, intent);
        finish();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) { //Guardando os dados no array list
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 1) { //Caso seja do cliente
            if (resultCode == Activity.RESULT_OK) {
                produto.add((Produto) data.getExtras().getSerializable("produto"));
                Toast.makeText(this, "Cadastro efetuado!", Toast.LENGTH_SHORT).show();
            }
        }
    }
}

