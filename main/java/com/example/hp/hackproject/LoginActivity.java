package com.example.hp.hackproject;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.widget.EditText;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;


public class LoginActivity extends AppCompatActivity implements SurfaceHolder.Callback{

    private SurfaceView mSurfaceView = null;
    private MediaPlayer mp = null;
    private EditText etMemberName = null;
    private EditText etPassword = null;

    HashMap<String, String> people = new HashMap<String, String>();

    public HashMap<String, String> getPeopleMap() {
        return people;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mp = new MediaPlayer();
        mSurfaceView = findViewById(R.id.sv_splash);
        mSurfaceView.getHolder().addCallback(this);

        initView();
    }

    private void initView() {
        etMemberName = findViewById(R.id.et_member_name);
        etPassword = findViewById(R.id.et_password);
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        Uri video = Uri.parse("android.resource://" + getPackageName() + "/"
                + R.raw.splash);

        try {
            if(mp == null)
                mp = new MediaPlayer();
            mp.setDataSource(this, video);
            mp.prepare();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //Get the dimensions of the video
        int videoWidth = mp.getVideoWidth();
        int videoHeight = mp.getVideoHeight();

        //Get the width of the screen
        int screenWidth = getWindowManager().getDefaultDisplay().getWidth();
        int screenHight = getWindowManager().getDefaultDisplay().getHeight();

        //Get the SurfaceView layout parameters
        android.view.ViewGroup.LayoutParams lp = mSurfaceView.getLayoutParams();

        //Set the width of the SurfaceView to the width of the screen
        lp.width = screenWidth;

        //Set the height of the SurfaceView to match the aspect ratio of the video
        //be sure to cast these as floats otherwise the calculation will likely be 0
        //lp.height = (int) (((float)videoHeight / (float)videoWidth) * (float)screenWidth);
        lp.height = screenHight;
        //Commit the layout parameters
        mSurfaceView.setLayoutParams(lp);

        //Start video
        mp.setDisplay(holder);
        mp.setLooping(true);
        mp.start();
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        mp.stop();
        mp.release();
        mp = null;
    }

    public void onLoginTap(View view) {
        HashMap<String, String>params=new HashMap<String, String>();
        params.put("username", String.valueOf(etMemberName));
        params.put("password", String.valueOf(etPassword));
        if(validateInput()){
            Intent hackIntent = Hack.getIntent(LoginActivity.this);
            startActivity(hackIntent);
            finish();
        }
    }


    public boolean validateInput(){
        boolean result  = true;
        if(etMemberName.getText().toString().trim().length() <= 0){
            etMemberName.setError("Enter Member Name");
            result =false;
        }else if(etPassword.getText().toString().trim().length() <= 0){
            etPassword.setError("Enter Password");
            result =false;
        }

        return result;
    }//end validateInput()

    @Override
    protected void onDestroy() {
        super.onDestroy();

    }
}
