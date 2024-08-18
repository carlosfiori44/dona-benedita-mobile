package com.example.donabenedita.cadastros;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.donabenedita.R;
import com.example.donabenedita.classes.Cliente;
import com.example.donabenedita.classes.Fornecedor;

import java.util.List;

public class CadasClienteActivity extends AppCompatActivity {
    //Declarando as variáveis
    private TextView nome, email, senha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadas_cliente);
        //Definindo id
        nome = findViewById(R.id.ptNome);
        email = findViewById(R.id.ptEmail);
        senha = findViewById(R.id.ptSenha);
    }

    public void cadastro(View view) { //Criando o método para pegar os dados e voltar para a MainActivity
        if (nome.getText().toString().equals("") || email.getText().toString().equals("") || senha.getText().toString().equals("")) { //Validação, caso não esteja preenchido
            Toast.makeText(this, "Preencha todos os campos!", Toast.LENGTH_SHORT).show();
        } else {
            Cliente cliente;
            Bundle dados = getIntent().getExtras(); //Passando os dados
            List<Cliente> client = (List<Cliente>) dados.getSerializable("clientes");
            if(client.isEmpty()){
                cliente = new Cliente(email.getText().toString(), senha.getText().toString(), nome.getText().toString(), null, null, null, null);
                Intent intent = new Intent();
                intent.putExtra("cliente", cliente);
                setResult(Activity.RESULT_OK, intent);
                finish();
            } else {
                for (Cliente clientes : client) {
                    if (!clientes.getEmail().equals(email.getText().toString())) {
                        cliente = new Cliente(email.getText().toString(), senha.getText().toString(), nome.getText().toString(), null, null, null, null);
                        Intent intent = new Intent();
                        intent.putExtra("cliente", cliente);
                        setResult(Activity.RESULT_OK, intent);
                        finish();
                    } else {
                         Toast.makeText(this, "Esse e-mail já está cadastrado!", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        }
    }

    public void voltar(View view){ //Caso queira voltar
        finish();
    }
}