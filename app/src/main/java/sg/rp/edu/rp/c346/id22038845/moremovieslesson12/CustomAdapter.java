package sg.rp.edu.rp.c346.id22038845.moremovieslesson12;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class CustomAdapter extends ArrayAdapter {
    Context parent_context;

    int layout_id;

    ArrayList<Movies> movieList;

    public CustomAdapter(Context context, int resource, ArrayList<Movies> objects){
        super(context,resource,objects);
        parent_context = context;
        layout_id = resource;
        movieList = objects;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        LayoutInflater inflater = (LayoutInflater) parent_context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View rowView = inflater.inflate(layout_id, parent, false);

        TextView tvTitle = rowView.findViewById(R.id.tV1);
        TextView tvGenre = rowView.findViewById(R.id.tV2);
        TextView tvYear = rowView.findViewById(R.id.tV4);

        Movies currentMovies = movieList.get(position);

        ImageView imgView = rowView.findViewById(R.id.iV);
        ImageView tvRating = rowView.findViewById(R.id.iVRating);

        Picasso.with(parent_context).load(currentMovies.getLink()).resize(1000,600).into(imgView);

        int img = 0;

        switch (currentMovies.getRating()){
            case "G":
                img = R.drawable.rating_g;
                break;
            case "PG":
                img = R.drawable.rating_pg;
                break;
            case "PG13":
                img = R.drawable.rating_pg13;
                break;
            case "NC16":
                img = R.drawable.rating_nc16;
                break;
            case "M18":
                img = R.drawable.rating_m18;
                break;
            case "R21":
                img = R.drawable.rating_r21;
                break;
        }

        tvRating.setImageResource(img);

        tvTitle.setText(currentMovies.getTitle());
        tvGenre.setText(currentMovies.getGenre());
        tvYear.setText(String.valueOf(currentMovies.getYear()));

        return rowView;
    }
}
