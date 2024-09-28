package com.example.exercice3tp1;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {

    TextView resultView;
    String[] checkBoxLabels = {
            "Multiple Versions Combined",
            "Model View Controller",
            "Main Value Compiled",
            "Mandatory Validated Controls"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        resultView = findViewById(R.id.result_view);

        // Récupérer les données de l'Intent
        Intent intent = getIntent();
        boolean[] checkBoxValues = intent.getBooleanArrayExtra("checkBoxValues");
        boolean radioOui = intent.getBooleanExtra("radioOui", false);

        // Construire le texte à afficher
        StringBuilder result = new StringBuilder("Sélectionné:\n");

        for (int i = 0; i < checkBoxValues.length; i++) {
            if (checkBoxValues[i]) {
                result.append("- ").append(checkBoxLabels[i]).append("\n");
            }
        }

        result.append("Syntaxe JSP : ").append(radioOui ? "OUI" : "NON");

        // Afficher les résultats
        resultView.setText(result.toString());
    }
}


