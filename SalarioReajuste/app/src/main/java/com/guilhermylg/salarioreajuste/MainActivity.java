package com.guilhermylg.salarioreajuste;
import android.os.Bundle;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText etSalario;
    RadioGroup rgAumento;
    Button btnCalcular, btnLimpar;
    TextView tvResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etSalario = findViewById(R.id.etSalario);
        rgAumento = findViewById(R.id.rgAumento);
        btnCalcular = findViewById(R.id.btnCalcular);
        tvResultado = findViewById(R.id.tvResultado);
        btnLimpar = findViewById(R.id.btnLimpar);
        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String valorTexto = etSalario.getText().toString();
                if (valorTexto.isEmpty()) {
                    tvResultado.setText("Por favor, digite um salário válido.");
                    return;
                }

                double salario = Double.parseDouble(valorTexto);
                double aumento = 0.0;

                int selectedId = rgAumento.getCheckedRadioButtonId();

                if (selectedId == R.id.rb40) {
                    aumento = 0.40;
                } else if (selectedId == R.id.rb45) {
                    aumento = 0.45;
                } else if (selectedId == R.id.rb50) {
                    aumento = 0.50;
                }

                double novoSalario = salario * (1 + aumento);
                tvResultado.setText(String.format("Novo salário: R$ %.2f", novoSalario));
            }
        });
        btnLimpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                etSalario.setText("");
                rgAumento.clearCheck();
                tvResultado.setText("");
            }
        });
    }
}

