package com.guilhermylg.carrinhocompras;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    CheckBox cbArroz, cbLeite, cbCarne, cbFeijao, cbRefri;
    Button btnCalcular, btnLimpar;
    TextView tvTotal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cbArroz = findViewById(R.id.cbArroz);
        cbLeite = findViewById(R.id.cbLeite);
        cbCarne = findViewById(R.id.cbCarne);
        cbFeijao = findViewById(R.id.cbFeijao);
        cbRefri = findViewById(R.id.cbRefri);
        btnCalcular = findViewById(R.id.btnCalcular);
        btnLimpar = findViewById(R.id.btnLimpar);
        tvTotal = findViewById(R.id.tvTotal);

        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double total = 0.0;

                if (cbArroz.isChecked()) total += 2.69;
                if (cbLeite.isChecked()) total += 2.70;
                if (cbCarne.isChecked()) total += 16.70;
                if (cbFeijao.isChecked()) total += 3.38;
                if (cbRefri.isChecked()) total += 3.00;

                tvTotal.setText(String.format("Total: R$ %.2f", total));
            }
        });
        btnLimpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             cbArroz.setChecked(false);
             cbCarne.setChecked(false);
             cbFeijao.setChecked(false);
             cbLeite.setChecked(false);
             cbRefri.setChecked(false);
             tvTotal.setText("Total: R$ 0.00");
            }
        });
    }
}
