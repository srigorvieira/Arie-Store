package com.example.ariestore;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button btCadastroCliente;
    private Button btCadastroItem;
    private Button btLancaPedido;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btCadastroCliente = findViewById(R.id.btCadastroCliente);
        btCadastroItem = findViewById(R.id.btCadastroItem);
        btLancaPedido = findViewById(R.id.btLancaPedido);

        //AQUI VAI ABRIR AS TELAS
        btCadastroCliente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openCadastroCliente();
            }
        });

        btCadastroItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openCadastroItem();
            }
        });

        btLancaPedido.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openLancaPedido();
            }
        });



    }

    //**INTENT** SOLICITA CHAMA O OUTRO COMPONENTE
    private void openLancaPedido() {
        Intent intent = new Intent(this, FecharPedido.class);
        startActivity(intent);
    }

    private void openCadastroItem() {
        Intent intent = new Intent(this, CadastroItem.class);
        startActivity(intent);
    }

    private void openCadastroCliente() {
        Intent intent = new Intent(this, CadastroCliente.class);
        startActivity(intent);
    }
}