package com.example.gestionetudiants;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import com.example.gestionetudiants.classes.Etudiant;
import com.example.gestionetudiants.service.EtudiantService;

public class MainActivity extends AppCompatActivity {

    private EditText nom;
    private EditText prenom;
    private Button add;

    private EditText id;
    private Button rechercher;
    private Button supprimer;
    private TextView res;

    void clear() {
        nom.setText("");
        prenom.setText("");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EtudiantService es = new EtudiantService(this);

        nom        = findViewById(R.id.nom);
        prenom     = findViewById(R.id.prenom);
        add        = findViewById(R.id.bn);
        id         = findViewById(R.id.id);
        rechercher = findViewById(R.id.load);
        supprimer  = findViewById(R.id.delete);
        res        = findViewById(R.id.res);

        add.setOnClickListener(v -> {
            String nomVal    = nom.getText().toString().trim();
            String prenomVal = prenom.getText().toString().trim();
            if (nomVal.isEmpty() || prenomVal.isEmpty()) {
                Toast.makeText(this, "Veuillez remplir Nom et Prénom", Toast.LENGTH_SHORT).show();
                return;
            }
            es.create(new Etudiant(nomVal, prenomVal));
            clear();
            for (Etudiant e : es.findAll()) {
                Log.d(e.getId() + "", e.getNom() + " " + e.getPrenom());
            }
            Toast.makeText(this, "✓ Étudiant ajouté", Toast.LENGTH_SHORT).show();
        });

        rechercher.setOnClickListener(v -> {
            String txt = id.getText().toString().trim();
            if (txt.isEmpty()) {
                res.setText("");
                Toast.makeText(this, "Saisir un ID", Toast.LENGTH_SHORT).show();
                return;
            }
            Etudiant e = es.findById(Integer.parseInt(txt));
            if (e == null) {
                res.setText("");
                Toast.makeText(this, "Étudiant introuvable", Toast.LENGTH_SHORT).show();
                return;
            }
            res.setText(e.getNom() + " " + e.getPrenom());
        });

        supprimer.setOnClickListener(v -> {
            String txt = id.getText().toString().trim();
            if (txt.isEmpty()) {
                Toast.makeText(this, "Saisir un ID", Toast.LENGTH_SHORT).show();
                return;
            }
            Etudiant e = es.findById(Integer.parseInt(txt));
            if (e == null) {
                Toast.makeText(this, "Aucun étudiant à supprimer", Toast.LENGTH_SHORT).show();
                return;
            }
            es.delete(e);
            res.setText("");
            id.setText("");
            Toast.makeText(this, "✓ Étudiant supprimé", Toast.LENGTH_SHORT).show();
        });
    }
}
