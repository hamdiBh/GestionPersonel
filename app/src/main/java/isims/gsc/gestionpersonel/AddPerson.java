package isims.gsc.gestionpersonel;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddPerson extends ActionBarActivity {

    EditText nom,prenom,fonction,matricule;
    Button addPerson;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_person);

        nom = (EditText) findViewById(R.id.nom);
        prenom = (EditText) findViewById(R.id.prenom);
        fonction = (EditText) findViewById(R.id.fonction);
        matricule = (EditText) findViewById(R.id.matricule);

        addPerson = (Button) findViewById(R.id.newBtn);


        addPerson.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String _nom = nom.getText().toString();
                String _prenom = prenom.getText().toString();
                String _fonction = fonction.getText().toString();
                String _matricule = matricule.getText().toString();

                Personne personne = new Personne(_nom,_prenom,_matricule,_fonction);

                MyHelper helper = new MyHelper(getApplicationContext());

                helper.addPerson(personne);

                startActivity(new Intent(getApplicationContext(),MainActivity.class));

            }
        });



    }
}
