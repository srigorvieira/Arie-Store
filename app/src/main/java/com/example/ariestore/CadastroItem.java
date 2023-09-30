package com.example.ariestore;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ariestore.models.Item;


public class CadastroItem extends AppCompatActivity {

    private Button btSalvar;
    private EditText edCodItem;
    private EditText edDescItem;
    private EditText edVlrItem;
    private TextView tvItensCadastrados;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_item);

        btSalvar = findViewById(R.id.btSalvar);
        edCodItem = findViewById(R.id.edCodItem);
        edDescItem = findViewById(R.id.edDescItem);
        edVlrItem = findViewById(R.id.edVlrItem);
        tvItensCadastrados = findViewById(R.id.tvItensCadastrados);

        this.atualizarItem();

        btSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                salvarItem();
            }
        });

    }

    private void salvarItem() {

        //VALIDA SE O CAMPO FOI PREENCHIDO
        if(edCodItem.getText().toString().isEmpty()){
            edCodItem.setError("Informe o código do produto!");
            return;
        }
        if (edDescItem.getText().toString().isEmpty()){
            edDescItem.setError("Informe a descrição!");
            return;
        }
        if (edVlrItem.getText().toString().isEmpty()){
            edVlrItem.setError("Informe um valor");
            return;
        }

        //INSTANCIANDO O ITEM
        Item item = new Item();
        item.setCodItem(Integer.parseInt(edCodItem.getText().toString()));
        item.setDescItem(edDescItem.getText().toString());
        item.setVlrItem(Integer.parseInt(edVlrItem.getText().toString()));

        ControllerItem.getInstance().salvarItem(item);

        //MSG DE CONFIRMAÇÃO
        Toast.makeText(CadastroItem.this,
                "Cadastro realizado com sucesso", Toast.LENGTH_LONG).show();

        this.finish();
    }

    public void atualizarItem(){
        String texto = "";
        texto += tvItensCadastrados.getText().toString();

        for (Item item: ControllerItem.getInstance().retornarItem()){
            texto += "Código do item: "+item.getCodItem()+"\n"
                    +"Descrição: "+item.getDescItem()+"\n"
                    +"Valor unitário R$: "+item.getVlrItem()+"\n"+"\n";
        }
        tvItensCadastrados.setText(texto);
    }

}