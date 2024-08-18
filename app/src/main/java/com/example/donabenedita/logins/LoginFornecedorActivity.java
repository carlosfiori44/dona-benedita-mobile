package com.example.donabenedita.logins;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.donabenedita.R;
import com.example.donabenedita.classes.Cliente;
import com.example.donabenedita.classes.Fornecedor;
import com.example.donabenedita.classes.Logado;
import com.example.donabenedita.classes.Produto;
import com.example.donabenedita.telasFornecedor.InicialFActivity;

import java.io.Serializable;
import java.util.List;

public class LoginFornecedorActivity extends AppCompatActivity {
    //Declarando as variáveis
    private TextView cnpj;
    private List<Produto> produto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_fornecedor);
        //Definindo id
        cnpj = findViewById(R.id.tvCnpj);
    }

    public void login(View view) { //Método para realizar o login e suas validações
        Bundle dados = getIntent().getExtras(); //Passando os dados
        List<Fornecedor> fornece = (List<Fornecedor>) dados.getSerializable("fornecedor");
        if (!fornece.isEmpty()) {
            for (Fornecedor fornecedor : fornece) {
                if (!cnpj.getText().toString().equals("")) { //Validação, caso não esteja preenchido
                    if (fornecedor.getCnpj().equals(cnpj.getText().toString())) {
                        Toast.makeText(this, "Entrando...", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getApplicationContext(), InicialFActivity.class);
                        Logado logado = new Logado(fornecedor.getCnpj(), fornecedor.getNome());
                        produto = (List<Produto>) dados.getSerializable("produto");
                        intent.putExtra("logado", logado);
                        intent.putExtra("produto", (Serializable) produto);
                        finish();
                        startActivityForResult(intent, 1);
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

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) { //Guardando os dados no array list
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1) { //Caso seja do cliente
            if (resultCode == Activity.RESULT_OK) {
                produto.add((Produto) data.getExtras().getSerializable("produto"));
                Toast.makeText(this, "Cadastro efetuado!", Toast.LENGTH_SHORT).show();
            }
        }
    }

    public void voltar(View view) { //Caso queira voltar
        finish();
    }
}