package com.example.ariestore;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class activity_cadastro_cliente extends AppCompatActivity {

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


    }
}