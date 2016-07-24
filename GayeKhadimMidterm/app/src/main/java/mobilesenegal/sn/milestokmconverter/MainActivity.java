package mobilesenegal.sn.milestokmconverter;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    Button btnConverter;
    EditText txtMiles;
    TextView txtKm;
    double nbMiles, nbKm;
    static final int MILESKM = 1609;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        txtMiles =(EditText) findViewById(R.id.nbMiles);
        txtKm =(TextView) findViewById(R.id.nbKm);
        btnConverter =(Button) findViewById(R.id.btnConvert);
        btnConverter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    if (isEmpty(txtMiles)) {
                        Toast.makeText(getApplicationContext(), "Veuillez entrer une valeur !", Toast.LENGTH_SHORT).show();
                        return;
                    }
                    nbMiles = Double.parseDouble(txtMiles.getText().toString());
                    nbKm = nbMiles * MILESKM;
                    txtKm.setText(Double.toString(nbKm));
                } catch (Exception e){
                    Log.e("error1","Erreur de calcul...");
                }
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private boolean isEmpty(EditText etText) {
        if (etText.getText().toString().trim().length() > 0)
            return false;

        return true;
    }
}
