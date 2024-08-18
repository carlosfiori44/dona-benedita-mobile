package com.example.donabenedita.cadastros;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.donabenedita.R;
import com.example.donabenedita.classes.Fornecedor;

import java.util.List;

public class CadasFornecedorActivity extends AppCompatActivity {
    //Declarando variáveis
    private TextView cnpj, nome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadas_fornecedor);
        //Declarando id
        nome = findViewById(R.id.ptNome);
        cnpj = findViewById(R.id.ptCnpj);
    }

    public void cadastrar(View view) {
        if (nome.getText().toString().equals("") || cnpj.getText().toString().equals("")) { //Validação, caso não esteja preenchido
            Toast.makeText(this, "Preencha todos os campos!", Toast.LENGTH_SHORT).show();
        } else {
            Fornecedor fornecedor;
            Bundle dados = getIntent().getExtras(); //Passando os dados
            List<Fornecedor> fornece = (List<Fornecedor>) dados.getSerializable("fornecedor");
            if (fornece.isEmpty()) {
                fornecedor = new Fornecedor(cnpj.getText().toString(), nome.getText().toString());
                Intent intent = new Intent();
                intent.putExtra("fornecedor", fornecedor);
                setResult(Activity.RESULT_OK, intent);
                finish();
            } else {
                for (Fornecedor fornecedo : fornece) {
                    if(!fornecedo.getCnpj().equals(cnpj.getText().toString())){
                        fornecedor = new Fornecedor(cnpj.getText().toString(), nome.getText().toString());
                        Intent intent = new Intent();
                        intent.putExtra("fornecedor", fornecedor);
                        setResult(Activity.RESULT_OK, intent);
                        finish();
                    } else{
                        Toast.makeText(this, "Esse CNPJ já está cadastrado!", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        }
    }

    public void voltar(View view){ //Caso queira voltar
        finish();
    }
}