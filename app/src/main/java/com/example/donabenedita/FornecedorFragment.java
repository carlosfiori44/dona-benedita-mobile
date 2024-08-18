package com.example.donabenedita;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.method.ScrollingMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.donabenedita.classes.Fornecedor;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FornecedorFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FornecedorFragment extends Fragment {
    //Variáveis
    private TextView dados;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private List<Fornecedor> mParam1;
    private String mParam2;

    public FornecedorFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FornecedorFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static FornecedorFragment newInstance(String param1, String param2) {
        FornecedorFragment fragment = new FornecedorFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = (List<Fornecedor>) getArguments().getSerializable("fornecedor"); //Pegando os dados
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_fornecedor, container, false);
        dados = view.findViewById(R.id.tvMostraFornece);
        dados.setMovementMethod(new ScrollingMovementMethod());
        dados.setText("\nFornecedores");
        for (Fornecedor fornecedor:mParam1) {
            dados.append("\n\nNome: " + fornecedor.getNome() + "\nCNPJ: " + fornecedor.getCnpj());
        }
        return view;
    }
}