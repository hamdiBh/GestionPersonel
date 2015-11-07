package isims.gsc.gestionpersonel;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends ActionBarActivity {


    RecyclerView recyclerView;
    ArrayList<Personne>personnes ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        personnes.add(new Personne("aaa", "bbb", "ccc", "dd"));
        personnes.add(new Personne("aaa","bbb","ccc","dd"));
        personnes.add(new Personne("aaa","bbb","ccc","dd"));
        personnes.add(new Personne("aaa","bbb","ccc","dd"));



        recyclerView = (RecyclerView) findViewById(R.id.listePersonels);
        LinearLayoutManager manager = new
                LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(manager);

        PersonAdapter personAdapter = new PersonAdapter(personnes);

        recyclerView.setAdapter(personAdapter);


    }
}
