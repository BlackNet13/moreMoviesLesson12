package sg.rp.edu.rp.c346.id22038845.moremovieslesson12;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //logo for app on the outside is learn from: https://youtu.be/m6qBOTjZ4Lw

    Button btnInsert, btnShowList;

    EditText ed1, ed2, ed3, ed5;

    Spinner spnGenre;

    String rating = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnInsert = findViewById(R.id.btnInsert);
        btnShowList = findViewById(R.id.btnShowList);

        ed1 = findViewById(R.id.ed1);
        ed2 = findViewById(R.id.ed2);
        ed3 = findViewById(R.id.ed3);
        ed5 = findViewById(R.id.ed5);

        spnGenre = findViewById(R.id.spinner);

        Intent intent = new Intent(MainActivity.this, MainActivity2.class);

        spnGenre.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 0:
                        rating = "G";
                        break;
                    case 1:
                        rating = "PG";
                        break;
                    case 2:
                        rating = "PG13";
                        break;
                    case 3:
                        rating = "NC16";
                        break;
                    case 4:
                        rating = "M18";
                        break;
                    case 5:
                        rating = "R21";
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        btnInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DBHelper db = new DBHelper(MainActivity.this);

                db.insertMovie(ed1.getText().toString(),ed2.getText().toString(),ed3.getText().toString(), rating, ed5.getText().toString());
                Toast toast = Toast.makeText(MainActivity.this,"Movie: <"+ed1.getText()+"> has been inserted",Toast.LENGTH_LONG);

                toast.show();
            }
        });

        btnShowList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DBHelper db = new DBHelper(MainActivity.this);
                startActivity(intent);
            }
        });
    }
}