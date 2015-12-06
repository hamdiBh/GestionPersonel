package isims.gsc.gestionpersonel;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

/**
 * Created by hamdi on 05/12/15.
 */
    public class MyHelper extends SQLiteOpenHelper {

    public  static  final  int DB_VERSION =1;
    public  static  final  String DB_NAME = "gestionPersonnels";
    public  static  final  String TABLE_NAME ="personne";
    public  static  final  String KEY_NOM= "nom";
    public  static  final  String KEY_PRENOM= "prenom";
    public  static  final  String KEY_FONCTION= "fonction";
    public  static  final  String KEY_MATRICULE= "matricule";




    public MyHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String query = "CREATE TABLE "+ TABLE_NAME + " ( "
                +KEY_NOM +" TEXT ,"
                +KEY_PRENOM + " TEXT ,"
                +KEY_FONCTION + " TEXT ,"
                +KEY_MATRICULE + " TEXT PRIMARY KEY "
                +" ) ";
        db.execSQL(query);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }


    public  void  addPerson(Personne personne){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(KEY_NOM,personne.getNom());
        values.put(KEY_PRENOM,personne.getPrenom());
        values.put(KEY_FONCTION,personne.getFonction());
        values.put(KEY_MATRICULE,personne.getMatricule());


        sqLiteDatabase.insert(TABLE_NAME,null,values);
    }

    public ArrayList<Personne> getAllPersons(){
        ArrayList<Personne> personnes= new ArrayList<>();
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        String query = "SELECT * FROM " +TABLE_NAME ;
        Cursor cursor = sqLiteDatabase.rawQuery(query,null);

        if(cursor.moveToFirst()){

            do{

                Personne personne = new Personne();

                personne.setNom(cursor.getString(0));
                personne.setPrenom(cursor.getString(1));
                personne.setFonction(cursor.getString(2));
                personne.setMatricule(cursor.getString(3));

                personnes.add(personne);

            }while (cursor.moveToNext());

        }
        return  personnes;
    }
}
