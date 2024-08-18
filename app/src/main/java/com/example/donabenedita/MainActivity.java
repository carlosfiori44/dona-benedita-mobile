package com.example.donabenedita;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.donabenedita.cadastros.CadasClienteActivity;
import com.example.donabenedita.cadastros.CadasFornecedorActivity;
import com.example.donabenedita.classes.Cliente;
import com.example.donabenedita.classes.Fornecedor;
import com.example.donabenedita.classes.Produto;
import com.example.donabenedita.logins.LoginClienteActivity;
import com.example.donabenedita.logins.LoginFornecedorActivity;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    //Declarando as variáveis
    private Spinner spinner;
    private List<Cliente> clientes = new ArrayList<>(); //Criando a lista para guardar os cadastros
    private List<Fornecedor> fornece = new ArrayList<>();
    private List<Produto> produto = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Definindo os ids
        spinner = findViewById(R.id.spinner);
    }

    public void onLogin(View view){ //Criando o método para ir a tela de login
        Intent intent = null;
        if(spinner.getSelectedItem().toString().equals("Cliente")) {
            intent = new Intent(getApplicationContext(), LoginClienteActivity.class);
            intent.putExtra("clientes", (Serializable) clientes);
        } else if (spinner.getSelectedItem().toString().equals("Fornecedor")){
            intent = new Intent(getApplicationContext(), LoginFornecedorActivity.class);
            intent.putExtra("fornecedor", (Serializable) fornece);
            intent.putExtra("produto", (Serializable) produto);
        }
        startActivity(intent);
    }

    public void onCadastro(View view){ //Criando método para ir a tela de cadastro
        Intent intent = null;
        if(spinner.getSelectedItem().toString().equals("Cliente")) {
            intent = new Intent(getApplicationContext(), CadasClienteActivity.class);
            intent.putExtra("clientes", (Serializable) clientes);
            startActivityForResult(intent, 1);
        } else if (spinner.getSelectedItem().toString().equals("Fornecedor")){
            intent = new Intent(getApplicationContext(), CadasFornecedorActivity.class);
            intent.putExtra("fornecedor", (Serializable) fornece);
            startActivityForResult(intent, 2);
        }
    }

    public void adm(View view){
        Intent intent = new Intent(getApplicationContext(), AdmActivity.class);
        intent.putExtra("cliente", (Serializable) clientes);
        intent.putExtra("fornecedor", (Serializable) fornece);
        startActivity(intent);
    }

    public void sair(View view){
        finish();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) { //Guardando os dados no array list
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 1) { //Caso seja do cliente
            if (resultCode == Activity.RESULT_OK) {
                clientes.add((Cliente) data.getExtras().getSerializable("cliente"));
                Toast.makeText(this, "Cadastro efetuado!", Toast.LENGTH_SHORT).show();
            }
        }

        if(requestCode == 2){
            if(resultCode == Activity.RESULT_OK){ //Caso seja do fornecedor
                fornece.add((Fornecedor) data.getExtras().getSerializable("fornecedor"));
                Toast.makeText(this, "Cadastro efetuado!", Toast.LENGTH_SHORT).show();
            }
        }

        if(requestCode == 3){
            if(resultCode == Activity.RESULT_OK){ //Caso seja do fornecedor
                produto = (List<Produto>) data.getExtras().getSerializable("produto");
                Toast.makeText(this, "", Toast.LENGTH_SHORT).show();
            }
        }
    }
}