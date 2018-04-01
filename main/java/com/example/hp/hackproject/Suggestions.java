package com.example.hp.hackproject;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.support.v7.app.AppCompatActivity;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;

public class Suggestions extends Activity{
    String[] suggestionsArray = {"Fruits","Vegetables","Dairy","Nuts", "Exercises"};

    public static Intent getIntent(Context context) {
        Intent sugIntent = new Intent(context, Suggestions.class);
        return sugIntent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_suggestions);

        ArrayAdapter adapter = new ArrayAdapter<String>(this,R.layout.activity_suggestions, suggestionsArray);

        ListView listView = (ListView) findViewById(R.id.suggestions_list);
        listView.setAdapter(adapter);
    }
}
