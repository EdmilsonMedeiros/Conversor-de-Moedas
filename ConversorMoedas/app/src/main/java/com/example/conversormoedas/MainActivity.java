package com.example.conversormoedas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    //Instancias
    private ViewHolder mViewHolder = new ViewHolder();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        this.mViewHolder.editValue = findViewById(R.id.edit_value);
        this.mViewHolder.textDolar = findViewById(R.id.text_dolar);
        this.mViewHolder.textEuro = findViewById(R.id.text_euro);
        this.mViewHolder.buttonCalculate = findViewById(R.id.button_alculate);

        this.mViewHolder.buttonCalculate.setOnClickListener(this);

        //Limpar TextViews
        this.clearValues();
    }


    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.button_alculate){
            //Lógica
            String value = this.mViewHolder.editValue.getText().toString();
            if ("".equals(value)){
                //Mostrar mensagem de campo vázio
                Toast.makeText(this, this.getString(R.string.informe_valor), Toast.LENGTH_LONG).show();
            }else{
                //Converter value para tipo Double
                Double real = Double.valueOf(value);

                this.mViewHolder.textDolar.setText(String.format("%.2f", (real / 4 )));
                this.mViewHolder.textEuro.setText(String.format("%.2f", (real / 5 )));
            }

        }
    }

    private void clearValues() {
        //Limpar TextViews
        this.mViewHolder.textDolar.setText("");
        this.mViewHolder.textEuro.setText("");
    }

    //ViewHolder
    private static class ViewHolder{
        EditText editValue;
        TextView textDolar;
        TextView textEuro;
        Button buttonCalculate;
    }
}
