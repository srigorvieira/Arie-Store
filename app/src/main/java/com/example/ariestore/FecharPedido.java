package com.example.ariestore;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ariestore.Controllers.ControllerCliente;
import com.example.ariestore.Controllers.ControllerItem;
import com.example.ariestore.Controllers.ControllerPedido;
import com.example.ariestore.models.Cliente;
import com.example.ariestore.models.Item;
import com.example.ariestore.models.Pedido;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class FecharPedido extends AppCompatActivity {

    private ArrayList<Cliente> ListaCliente;
    private ArrayList<Item> ListaItem;
    private ArrayList<Pedido> ListaPedido;
    private Button btAdicionarItem;
    private EditText edQuantidade;
    private Spinner spCliente;
    private Spinner spItem;
    private TextView tvPedidosCadastrados;
    private TextView tvListaItem;
    private TextView tvListaCliente;
    private int posicaoSelecionadaCliente = 0;
    private int posicaoSelecionadaItem = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fechar_pedido);

        btAdicionarItem = findViewById(R.id.btAdicionarItem);
        edQuantidade = findViewById(R.id.edQuantidade);

        EditText edInstallmentCount = findViewById(R.id.edInstallmentCount);

        tvPedidosCadastrados = findViewById(R.id.tvPedidoCadastrados);
        tvListaCliente = findViewById(R.id.tvListaCliente);
        tvListaItem = findViewById(R.id.tvListaItem);

        RadioGroup rgTipoPagto = findViewById(R.id.rgTipoPagto);

        spCliente.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int posicao, long l) {
                if (posicao > 0) {
                    posicaoSelecionadaCliente = posicao;
                    tvListaCliente.setVisibility(View.GONE);
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
                    tvListaItem.setVisibility(View.GONE);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        rgTipoPagto.setOnCheckedChangeListener((group, checkedId) -> {
            if (checkedId == R.id.rbAvista) {
                edInstallmentCount.setVisibility(View.GONE);
            } else if (checkedId == R.id.rbInstallment) {
                edInstallmentCount.setVisibility(View.VISIBLE);
            }
        });

        carregaClientes();
        carregaItem();
        atualizaListaPedido();
        btAdicionarItem.setOnClickListener(view -> cadastraPedido());
    }

    //METODOS AQUI--------

    private void cadastraPedido() {
        int qtProduto;

        if (edQuantidade.getText().toString().isEmpty()) {
            edQuantidade.setError("Informe a quantidade desejada!");
            edQuantidade.requestFocus();
            return;
        } else {
            qtProduto = Integer.parseInt(edQuantidade.getText().toString());
            if (qtProduto <= 0) {
                edQuantidade.setError("A quantia deve ser maior que zero!");
                edQuantidade.requestFocus();
                return;
            }
        }

        Item item = ListaItem.get(posicaoSelecionadaItem - 1);
        Cliente cliente = ListaCliente.get(posicaoSelecionadaCliente - 1);

        boolean noDinheiro = ((RadioButton) findViewById(R.id.rbAvista)).isChecked();

        double valorTotal = calcValorTotal(qtProduto, noDinheiro, item.getVlrItem());

        Pedido pedido = new Pedido();
        pedido.setItem(item);
        pedido.setQtdItem(qtProduto);
        pedido.setVlrTotal(valorTotal);
        pedido.setCliente(cliente);
        pedido.setNoDinheiro(noDinheiro);
        pedido.setQtdParcelas(noDinheiro ? 1 : Integer.parseInt(((EditText) findViewById(R.id.edInstallmentCount)).getText().toString()));

        ControllerPedido.getInstance().salvaPedido(pedido);
        Toast.makeText(this, "Pedido cadastrado!", Toast.LENGTH_LONG).show();

        finish();
    }

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

    private void atualizaListaPedido() {
        String texto = "";

        for (Pedido pedido : ControllerPedido.getInstance().retornarPedido()) {
            String pagto = pedido.isNoDinheiro() ? "A vista" : "A prazo - " + pedido.getQtdParcelas() +
                    "/" + vlrParcela(pedido.getVlrTotal(), pedido.getQtdParcelas());
            texto += "Item: " + pedido.getItem() + "\n" +
                    "Quantidade " + pedido.getQtdItem() + "\n" +
                    "Cliente: " + pedido.getCliente() + "\n" +
                    "Pagamento: " + pagto + "\n" +
                    "Total R$: " + pedido.getVlrTotal() + "\n" + "\n";
        }
        tvPedidosCadastrados.setText(texto);
    }

    public double vlrParcela(double valor, int parcela) {
        return (valor / parcela);
    }

    public double calcValorTotal(int qtdItem, boolean noDinheiro, double vlrUnitario) {
        double valorTotal = vlrUnitario * qtdItem;

        if (!noDinheiro)
            valorTotal *= 1.05;
        else
            valorTotal *= 0.95;

        return valorTotal;
    }
}