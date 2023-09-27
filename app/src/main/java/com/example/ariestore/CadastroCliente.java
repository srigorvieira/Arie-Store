package com.example.ariestore;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ariestore.models.Cliente;

public class CadastroCliente extends AppCompatActivity {

    private Button btSalvar;
    private EditText edNmCliente;
    private EditText edCpfCliente;
    private TextView tvClientesCadastrados;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_cliente);

        btSalvar = findViewById(R.id.btSalvar);
        edNmCliente = findViewById(R.id.edNmCliente);
        edCpfCliente = findViewById(R.id.edCpfCliente);
        tvClientesCadastrados = findViewById(R.id.tvClientesCadastrados);

        this.atualizarListaCliente();

        btSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                salvarCliente();
            }
        });

    }

    private void salvarCliente() {

        //VALIDA SE O CAMPO FOI PREENCHIDO OU NAO
        if (edNmCliente.getText().toString().isEmpty()) {
            edNmCliente.setError("Preencha o nome do cliente!");
            return;
        }

        if (edCpfCliente.getText().toString().isEmpty()) {
            edCpfCliente.setError("Obrigatório informar o CPF!");
            return;
        }

        //INSTANCIANDO OBJETO CLIENTE
        Cliente cliente = new Cliente();
        cliente.setNmCliente(edNmCliente.getText().toString());
        cliente.setCpfCliente(edCpfCliente.getText().toString());

        ControllerCliente.getInstance().salvarCliente(cliente);

        //MSG PRA CONFIRMAR O CADASTRO DO CLIENTE
        Toast.makeText(CadastroCliente.this,
                "Cadastro realizado com sucesso!", Toast.LENGTH_LONG).show();

        this.finish();
    }

    private void atualizarListaCliente() {
        String texto = "";
        texto += tvClientesCadastrados.getText().toString();

        for (Cliente cliente : ControllerCliente.getInstance().retornarClientes()) {
            texto += "Nome: " + Cliente.getNmCliente() + " - " + Cliente.getCpfCliente() + "\n";
        }
        tvClientesCadastrados.setText(texto);
    }
}