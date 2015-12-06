package isims.gsc.gestionpersonel;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class MainActivity extends ActionBarActivity {


    RecyclerView recyclerView;
    Button addPerson;
    ArrayList<Personne>personnes ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        personnes = new ArrayList<Personne>();

        MyHelper helper = new MyHelper(getApplicationContext());

        personnes = helper.getAllPersons();

        recyclerView = (RecyclerView) findViewById(R.id.listePersonels);
        LinearLayoutManager manager = new
                LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(manager);

        PersonAdapter personAdapter = new PersonAdapter(personnes);

        recyclerView.setAdapter(personAdapter);

        addPerson = (Button) findViewById(R.id.addPerson);

        addPerson.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(),
                        AddPerson.class);

                startActivity(intent);

            }
        });

    }
}
