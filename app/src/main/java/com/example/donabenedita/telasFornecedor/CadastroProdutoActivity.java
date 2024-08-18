package com.example.donabenedita.telasFornecedor;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.donabenedita.R;
import com.example.donabenedita.classes.Fornecedor;
import com.example.donabenedita.classes.Produto;

import java.util.List;

public class CadastroProdutoActivity extends AppCompatActivity {
    //Declarando variáveis
    private TextView quantidade, preco, descricao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_produto);
        //Declarando ids
        quantidade = findViewById(R.id.ptQuantidade);
        preco = findViewById(R.id.ptQuantidade);
        descricao = findViewById(R.id.ptDescr);
    }

    public void cadastra(View view) {
        if (quantidade.getText().toString().equals("") || preco.getText().toString().equals("") || descricao.getText().toString().equals("")) { //Validação, caso não esteja preenchido
            Toast.makeText(this, "Preencha todos os campos!", Toast.LENGTH_SHORT).show();
        } else {
            Bundle dados = getIntent().getExtras(); //Passando os dados
            String fornecedor = dados.getString("fornecedor");
            Produto produtos = new Produto(Integer.parseInt(quantidade.getText().toString()),
                    Integer.parseInt(preco.getText().toString()), fornecedor, descricao.getText().toString());
            Intent intent = new Intent();
            intent.putExtra("produto", produtos);
            setResult(Activity.RESULT_OK, intent);
            finish();
        }
    }

    public void volta(View view){
        finish();
    }
}