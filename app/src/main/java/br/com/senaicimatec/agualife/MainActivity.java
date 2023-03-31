package br.com.senaicimatec.agualife;
import androidx.appcompat.app.AppCompatActivity;
import java.util.*;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.TextView;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    private EditText editTextNome;
    private Button bt_calcular;
    private TextView textVResultado;
    private EditText edit_idade;
    private EditText edit_peso;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        atletas = new ArrayList<>();
        editTextNome = findViewById(R.id.editTextNome);
        bt_calcular = findViewById(R.id.bt_calcular);
        edit_idade = findViewById(R.id.edit_idade);
        edit_peso = findViewById(R.id.edit_peso);
        textVResultado = findViewById(R.id.textVResultado);
        atletasListView = findViewById(R.id.atletasListView);

        AtletaAdapter adapter = new AtletaAdapter(this, R.layout.item_lista, getAtletasFromDatabase());
        atletasListView.setAdapter(adapter);

        bt_calcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nome = editTextNome.getText().toString();
                int idade = Integer.parseInt(String.valueOf(edit_idade.getText()));
                double peso = Double.parseDouble(String.valueOf(EditText.getText.toString()));

                int consumo = ConsumoAgua.calcularConsumoDiarioAgua(peso, idade);
                Atleta atleta = new Atleta(nome, idade, peso);
                gerenciador.cadastrarAtleta(atleta);

                textVResultado.setText(consumo + "L");
            }
        });
    }
}