package mobilesenegal.sn.firebasestudent;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {

    private Button btnSumbit;
    private EditText etID, etNom;
    private DatabaseReference dbRef;
    private String id, nom;

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);
        dbRef = FirebaseDatabase.getInstance().getReference();

        btnSumbit = (Button) rootView.findViewById(R.id.submit);
        etID = (EditText) rootView.findViewById(R.id.idField);
        etNom = (EditText) rootView.findViewById(R.id.nameField);

        btnSumbit.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("bouton", "The button is clicked!");
                id = etID.getText().toString().trim();
                nom = etNom.getText().toString().trim();
                Student student = new Student(id, nom);
                dbRef.push().setValue(student);
            }
        });

        return rootView;
    }
}
