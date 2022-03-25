package com.example.utsezzaguidegcdc;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    String aTitle[] = {"Elesis Sieghart", "Ronan Erudon", "Harpe Noir", "Lime Serenity", "Cindy"};
    String aDescription[] = {"Semi-Tank, Support, Carry PvP" , "Tank, Support-M.Atk, Invicible" , "Carry-PvE/PvP, Great-M.Atk" , "Support, Semi-Tank, Dispel, Heal" , "Support, Great-Heal"};
    int images[] = {R.drawable.elesis, R.drawable.ronan, R.drawable.harpe, R.drawable.lime, R.drawable.cindy};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listView);

        MyAdapter adapter = new MyAdapter(this, aTitle, aDescription, images);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0){
                    startActivity(new Intent(MainActivity.this, Elesis.class));
                }

                if (position == 1){
                    startActivity(new Intent(MainActivity.this, Ronan.class));
                }

                if (position == 2){
                    startActivity(new Intent(MainActivity.this, Harpe.class));
                }

                if (position == 3){
                    startActivity(new Intent(MainActivity.this, Lime.class));
                }

                if (position == 4){
                    Toast.makeText(MainActivity.this, "Cindy Tidak Tersedia Untuk Sekarang", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    class MyAdapter extends ArrayAdapter<String> {

        Context context;
        String rTitle[];
        String rDescription[];
        int rImgs[];

        MyAdapter(Context c, String title[], String description[], int imgs[]){
            super(c, R.layout.row, R.id.TextView1, title);
            this.context = c;
            this.rTitle = title;
            this.rDescription = description;
            this.rImgs = imgs;

        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            LayoutInflater layoutInflater = (LayoutInflater) getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View row = layoutInflater.inflate(R.layout.row, parent, false);
            ImageView images = row.findViewById(R.id.image);
            TextView myTitle = row.findViewById(R.id.TextView1);
            TextView myDescription = row.findViewById(R.id.TextView2);

            images.setImageResource(rImgs[position]);
            myTitle.setText(rTitle[position]);
            myDescription.setText(rDescription[position]);

            return row;
        }
    }
}