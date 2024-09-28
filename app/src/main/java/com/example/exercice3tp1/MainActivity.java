package com.example.exercice3tp1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    CheckBox[] checkBoxes;
    RadioButton radioOui, radioNon;
    Button nextButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialisation des CheckBox dans un tableau
        checkBoxes = new CheckBox[]{
                findViewById(R.id.checkbox_multiple_versions),
                findViewById(R.id.checkbox_mvc),
                findViewById(R.id.checkbox_main_value),
                findViewById(R.id.checkbox_validated_controls)
        };

        // Initialisation des RadioButtons
        radioOui = findViewById(R.id.radio_yes);
        radioNon = findViewById(R.id.radio_no);

        // Bouton Suivant
        nextButton = findViewById(R.id.button_next);

        Button buttonQuitter = findViewById(R.id.button_quit);

        buttonQuitter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Fermer l'activité et quitter l'application
                finish();
            }
        });

        // Quand l'utilisateur clique sur le bouton "Suivant"
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);

                // Passer les valeurs des CheckBox
                boolean[] checkBoxValues = new boolean[checkBoxes.length];
                for (int i = 0; i < checkBoxes.length; i++) {
                    checkBoxValues[i] = checkBoxes[i].isChecked();
                }
                intent.putExtra("checkBoxValues", checkBoxValues);

                // Passer la valeur des RadioButtons
                intent.putExtra("radioOui", radioOui.isChecked());

                // Lancer la nouvelle activité
                startActivity(intent);
            }
        });
    }
}

