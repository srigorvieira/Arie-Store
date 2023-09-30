package com.example.ariestore;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.ariestore.models.Cliente;
import com.example.ariestore.models.Item;

import java.util.ArrayList;

public class FecharPedido extends AppCompatActivity {

    private ArrayList<Cliente> ListaCliente;
    private ArrayList<Item> ListaItem;
    private Button btAdicionarItem;
    private EditText edQuantidade;
    private RadioGroup rbAvista;
    private RadioGroup rbPrazo;
    private Spinner spCliente;
    private Spinner spItem;
    private TextView tvPedidosRealizados;
    private TextView tvErroCliente;
    private TextView tvErroItem;
    private int posicaoSelecionadaCliente = 0;
    private int posicaoSelecionadaItem = 0;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fechar_pedido);

        btAdicionarItem = findViewById(R.id.btAdicionarItem);
        edQuantidade = findViewById(R.id.edQuantidade);
        spCliente = findViewById(R.id.spCliente);
        spItem = findViewById(R.id.spItem);
        tvErroCliente = findViewById(R.id.tvErroCliente);
        tvErroItem = findViewById(R.id.tvErroItem);
        tvPedidosRealizados = findViewById(R.id.tvPedidosRealizados);
        rbPrazo = findViewById(R.id.rbPrazo);
        rbAvista = findViewById(R.id.rbAvista);


        spCliente.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int posicao, long l) {
                if (posicao > 0) {
                    posicaoSelecionadaCliente = posicao;
                    tvErroCliente.setVisibility(View.GONE);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        spItem.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int posicao, long l) {
                if (posicao > 0) {
                    posicaoSelecionadaItem = posicao;
                    tvErroItem.setVisibility(View.GONE);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });




        carregaClientes();
        carregaItem();
    }


    //METODOS AQUI--------
    private void carregaClientes() {
        ListaCliente = ControllerCliente.getInstance().retornarClientes();
        String[] vetCli = new String[ListaCliente.size() + 1];
        vetCli[0] = "Selecione o cliente";

        for (int i = 0; i < ListaCliente.size(); i++) {
            Cliente cliente = ListaCliente.get(i);

            vetCli[i + 1] = cliente.getNmCliente() + " - " + cliente.getCpfCliente();
        }
        ArrayAdapter adapter = new ArrayAdapter(FecharPedido.this,
                android.R.layout.simple_dropdown_item_1line, vetCli);

        spCliente.setAdapter(adapter);
    }

    private void carregaItem() {
        ListaItem = ControllerItem.getInstance().retornarItem();
        String[] vetItem = new String[ListaItem.size() + 1];
        vetItem[0] = "Selecione o item";

        for (int i = 0; i < ListaItem.size(); i++) {
            Item item = ListaItem.get(i);

            vetItem[i + 1] = item.getDescItem() + " - " + item.getVlrItem();
        }
        ArrayAdapter adapter = new ArrayAdapter(FecharPedido.this,
                android.R.layout.simple_dropdown_item_1line, vetItem);

        spItem.setAdapter(adapter);
    }


    //DAR CONTUNUIDADE
    private double calcVlrTotal(double vlrUnitario, int quantidade){
        return vlrUnitario * quantidade;
    }

    private void adicionarItemPedido(){

        //BUSCA INFO DO CADASTRO DO ITEM
        double vlrUnitario = Item.getVlrItem;

        //LE O DADO INPUTADO PELO USER
        int quantidade = Integer.parseInt(edQuantidade.getText().toString());

        //ARMAZENA O O RESULTADO DO CALCULO
        double valorTotal = calcVlrTotal(vlrUnitario, quantidade);
    }

}