package com.example.ariestore;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.ariestore.models.Item;


public class activity_cadastro_item extends AppCompatActivity {

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

    }

    public void atualizarItem(){
        String texto = "";
        texto += tvItensCadastrados.getText().toString();

        for (Item item: ControllerItem.getInstance().retornarItem()){
            texto += "Código do item: "+item.getCodItem()+" - "+"\n"
                    +"Descrição: "+item.getDescItem()+" - "+"\n"
                    +"Valor UND: "+item.getVlrItem()+" - "+"\n";
        }
        tvItensCadastrados.setText(texto);
    }

}