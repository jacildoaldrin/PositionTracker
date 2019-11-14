package ca.georgebrown.comp3074.positiontracker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.Serializable;

import ca.georgebrown.comp3074.positiontracker.model.Route;

public class ViewRouteActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_route);

        TextView name = findViewById(R.id.editName);
        TextView date = findViewById(R.id.editDate);
        TextView tags = findViewById(R.id.editTags);
        TextView rating = findViewById(R.id.editRating);

        final Route route = (Route)getIntent().getExtras().getSerializable("route");

        name.setText(route.getRouteName());
        date.setText(route.getDate());
//        tags.setText(route.getTags().get(0));
//        rating.setText(route.getRating());

        //View current Route button
        Button mapsBtn = findViewById(R.id.btnSave);
        mapsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:43.6711247,-79.4141207"));
                startActivity(i);
            }
        });

        //Add new Route button
        Button editRouteBtn = findViewById(R.id.btnEditRoute);
        editRouteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(ViewRouteActivity.this, EditRouteActivity.class);
                i.putExtra("route", route);
                startActivity(i);
            }
        });

        //Add new Route button
        Button shareBtn = findViewById(R.id.btnShare);
        shareBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast t = Toast.makeText(view.getContext(),"Route has been successfully shared!",Toast.LENGTH_LONG);
                t.show();
            }
        });

    }
}
