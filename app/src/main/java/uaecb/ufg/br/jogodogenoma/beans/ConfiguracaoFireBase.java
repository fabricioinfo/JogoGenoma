package uaecb.ufg.br.jogodogenoma.beans;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by Fabricio on 17/11/2017.
 */

public class ConfiguracaoFireBase {
    public static DatabaseReference database;
    public static FirebaseAuth auth;

    public static DatabaseReference getReferencia(){
        if(database == null){
            database = FirebaseDatabase.getInstance().getReference();
        }
        return database;
    }

    public static FirebaseAuth getFirebaseAuth(){
        if(auth == null){
            auth = FirebaseAuth.getInstance();
        }
        return auth;
    }
}
