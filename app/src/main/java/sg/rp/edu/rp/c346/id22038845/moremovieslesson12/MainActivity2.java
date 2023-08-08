package sg.rp.edu.rp.c346.id22038845.moremovieslesson12;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity2 extends AppCompatActivity {

    ArrayList<String> strList;

    ListView lvResults;

    Spinner rateSpn;

    TextView back;

    ArrayAdapter<String> spnA;

    ArrayList<Movies> data;

    ArrayList<Movies> alMovie;

    CustomAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        lvResults = findViewById(R.id.lv);
        rateSpn = findViewById(R.id.spinner);
        back = findViewById(R.id.back);

        spnA = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1);

        List<String> rateF = new ArrayList<>();
        rateF.add("Filter by rating");
        DBHelper db = new DBHelper(MainActivity2.this);
        List<Movies> movieList = db.getAllMovies();
        for(Movies movie : movieList){
            String rating = movie.getRating();

            if(!rateF.contains(rating)) {
                rateF.add(rating);
            }
        }

        for(int i= 0; i<rateF.size(); i++){
            spnA.add(rateF.get(i));
        }

        rateSpn.setAdapter(spnA);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity2.this, MainActivity.class);
                startActivity(intent);
            }
        });

        lvResults.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Movies movie = data.get(position);
                Intent x = new Intent(MainActivity2.this, MainActivity3.class);
                x.putExtra("data", movie);
                startActivity(x);
            }
        });

        rateSpn.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(position!=0){
                    data = db.getMovieByRating(parent.getItemAtPosition(position).toString());
                }else{
                    data = db.getAllMovies();
                }
                alMovie = new ArrayList<>();
                adapter = new CustomAdapter(MainActivity2.this,R.layout.row, alMovie);

                lvResults.setAdapter(adapter);
                db.close();

                for(int i=0; i< data.size(); i++){
                    alMovie.add(data.get(i));
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });




    }

    @Override
    protected void onResume() {
        super.onResume();
        DBHelper db = new DBHelper(MainActivity2.this);

        data = new ArrayList<>();

        data = db.getAllMovies();

        strList = new ArrayList<String>();

        alMovie = new ArrayList<>();
        adapter = new CustomAdapter(MainActivity2.this,R.layout.row,alMovie);

        lvResults.setAdapter(adapter);
        db.close();
        for(int i = 0; i <data.size(); i++){
            alMovie.add(data.get(i));
        }

    }
}