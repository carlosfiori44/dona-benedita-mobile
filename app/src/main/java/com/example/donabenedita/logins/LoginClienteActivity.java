package com.example.donabenedita.logins;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.donabenedita.R;
import com.example.donabenedita.classes.Cliente;
import com.example.donabenedita.classes.Logado;
import com.example.donabenedita.telasCliente.InicialCActivity;

import java.util.List;

public class LoginClienteActivity extends AppCompatActivity {
    //Declarando as variáveis
    private TextView email, senha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_cliente);
        //Definindo id
        email = findViewById(R.id.tvCnpj);
        senha = findViewById(R.id.tvSenha);
    }

    public void login(View view) { //Método para realizar o login e suas validações
        Bundle dados = getIntent().getExtras(); //Passando os dados
        List<Cliente> cliente = (List<Cliente>) dados.getSerializable("clientes");
        if (!cliente.isEmpty()) {
            for (Cliente clientes : cliente) {
                if (!email.getText().toString().equals("") || !senha.getText().toString().equals("")) { //Validação, caso não esteja preenchido
                    if (clientes.getEmail().equals(email.getText().toString()) && clientes.getSenha().equals(senha.getText().toString())) {
                        Intent intent = new Intent(getApplicationContext(), InicialCActivity.class);
                        Logado logado = new Logado(clientes.getEmail(), clientes.getNome());
                        intent.putExtra("logado", logado);
                        Toast.makeText(this, "Entrando...", Toast.LENGTH_SHORT).show();
                        finish();
                        startActivity(intent);
                    } else {
                        Toast.makeText(this, "E-mail ou Senha inválidos!", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(this, "Preencha todos os campos!", Toast.LENGTH_SHORT).show();
                }
            }
        } else {
            Toast.makeText(this, "Realize o cadastro!", Toast.LENGTH_SHORT).show();
            finish();
        }
    }

    public void voltar(View view) { //Caso queira voltar
        finish();
    }
}
