package isims.gsc.gestionpersonel;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by hamdi on 07/11/15.
 */
public class PersonAdapter extends

        RecyclerView.Adapter<PersonAdapter.personViewHolder> {

        ArrayList<Personne> personnes;

        PersonAdapter(ArrayList<Personne> personnes){
                this.personnes = personnes;

        }



        @Override
        public personViewHolder
        onCreateViewHolder(ViewGroup parent, int viewType) {
                View view = LayoutInflater.
                        from(parent.getContext()).
                        inflate(R.layout.card, parent, false);
                personViewHolder personViewHolder = new personViewHolder(view);
                return personViewHolder;
        }

        @Override
        public void onBindViewHolder
                (final PersonAdapter.personViewHolder holder, int position) {
                final Personne personne = personnes.get(position);
                holder.nom.setText(personne.getNom());
                holder.prenom.setText(personne.getPrenom());
                holder.fonction.setText(personne.getFonction());
                holder.matricule.setText(personne.getMatricule());

                holder.itemView.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                                Toast.makeText(holder.itemView.getContext(),personne.toString(),Toast.LENGTH_SHORT).show();
                        }
                });

        }

        @Override
        public int getItemCount() {
                return personnes.size();
        }

        class  personViewHolder extends  RecyclerView.ViewHolder{

                TextView nom;
                TextView prenom;
                TextView matricule;
                TextView fonction;

                public personViewHolder(View itemView) {
                        super(itemView);
                        nom = (TextView) itemView.findViewById(R.id.nom);
                        prenom = (TextView) itemView.findViewById(R.id.prenom);
                        matricule = (TextView) itemView.findViewById(R.id.matricule);
                        fonction = (TextView) itemView.findViewById(R.id.fonction);

                }
        }
}
