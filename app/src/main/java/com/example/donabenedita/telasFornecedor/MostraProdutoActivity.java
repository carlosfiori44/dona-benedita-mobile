package com.example.donabenedita.telasFornecedor;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.donabenedita.R;
import com.example.donabenedita.classes.Produto;

import java.util.List;

public class MostraProdutoActivity extends AppCompatActivity {
    private TextView mostra;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostra_produto);
        mostra = findViewById(R.id.tvMostra);

        Bundle dados = getIntent().getExtras();
        List<Produto> produto = (List<Produto>) dados.getSerializable("produto");
        if(!produto.isEmpty()) {
            for (Produto produtos : produto) {
                mostra.setText(produtos.getDescricao() + "\n" + produtos.getFornecedor() + "\n" + produtos.getPreco()
                        + "\n" + produtos.getQuantidade());
            }
        } else{
            mostra.setText("Não tem cadastro de produto!");
        }
    }
}