package com.example.donabenedita;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class AdmActivity extends AppCompatActivity {
    //Declarando variáveis
    private TextView mostra;
    private ClienteFragment clienteFragment;
    private FornecedorFragment fornecedorFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adm);
        //Ids
        mostra = findViewById(R.id.tvMostraCliente);

        Bundle dados = getIntent().getExtras(); //Recuperando dados

        clienteFragment = new ClienteFragment();
        fornecedorFragment = new FornecedorFragment();

        //Passando os dados para a fragment
        clienteFragment.setArguments(dados);
        fornecedorFragment.setArguments(dados);
    }

    public void cliente(View view) {
        //Criar uma transação entre frameLayout e fragment
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        //Interação do frameLayout com o fragment
        transaction.replace(R.id.frameConteudo, clienteFragment);
        //Validação
        transaction.commit();
    }

    public void fornecedor(View view) {
        //Criar uma transação entre frameLayout e fragment
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        //Interação do frameLayout com o fragment
        transaction.replace(R.id.frameConteudo, fornecedorFragment);
        //Validação
        transaction.commit();
    }

    public void sair(View view) {
        this.finish();
    }
}
