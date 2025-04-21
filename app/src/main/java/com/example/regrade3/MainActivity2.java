package com.example.regrade3;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main2);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        EditText editText1 = findViewById(R.id.editTextNumber);    // Valor 1
        EditText editText2 = findViewById(R.id.editTextNumber2);   // Valor 2
        EditText editText3 = findViewById(R.id.editTextNumber3);   // Valor 3
        TextView textView = findViewById(R.id.textView);           // Resultado (x)
        Button button = findViewById(R.id.button2);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String v1 = editText1.getText().toString(); // Valor 1
                String v2 = editText2.getText().toString(); // Valor 2
                String v3 = editText3.getText().toString(); // Valor 3

                if (!v1.isEmpty() && !v2.isEmpty() && !v3.isEmpty()) {
                    double valor1 = Double.parseDouble(v1);
                    double valor2 = Double.parseDouble(v2);
                    double valor3 = Double.parseDouble(v3);

                    if (valor2 != 0) {
                        double x = (valor1 * valor3) / valor2; // Calculando o valor de x
                        textView.setText("Resultado: " + String.format("%.2f", x)); // Exibe com 2 casas decimais
                    } else {
                        textView.setText("Erro: Divisão por zero");
                    }
                } else {
                    textView.setText("Preencha todos os campos");
                }
            }
        });
    }
}
