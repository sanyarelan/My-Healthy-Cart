package com.example.hp.hackproject;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.speech.RecognizerIntent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

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
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;

public class Hack extends AppCompatActivity implements View.OnClickListener {

    EditText nameText;
    EditText ageText;
    EditText phoneText;
    AutoCompleteTextView allergyText;
    AutoCompleteTextView diseaseText;
    private ImageButton ivNameText;
    private ImageButton ivAgeText;
    private ImageButton ivPhoneText;
    private ImageButton ivAllergyText;
    private ImageButton ivDiseaseText;
    private final int REQ_CODE_SPEECH_INPUT_NAME = 100;
    private final int REQ_CODE_SPEECH_INPUT_AGE = 101;
    private final int REQ_CODE_SPEECH_INPUT_PHONE_NUMBER = 102;
    private final int REQ_CODE_SPEECH_INPUT_ALLERGY = 103;
    private final int REQ_CODE_SPEECH_INPUT_DISEASE = 104;

    public static Intent getIntent(Context context) {
        Intent hakIntent = new Intent(context, Hack.class);
        return hakIntent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hack);
        nameText = findViewById(R.id.nameText);
        ageText = findViewById(R.id.ageText);
        phoneText = findViewById(R.id.phoneText);
        allergyText = findViewById(R.id.allergyText);
        diseaseText = findViewById(R.id.diseaseText);

        /*speak*/
        setContentView(R.layout.activity_hack);
        ivNameText = findViewById(R.id.ivNameText);
        ivAgeText = findViewById(R.id.ivAgeText);
        ivPhoneText = findViewById(R.id.ivPhoneText);
        ivAllergyText = findViewById(R.id.ivAllergyText);
        ivDiseaseText = findViewById(R.id.ivDiseaseText);

        ivNameText.setOnClickListener(this);
        ivAgeText.setOnClickListener(this);
        ivPhoneText.setOnClickListener(this);
        ivAllergyText.setOnClickListener(this);
        ivDiseaseText.setOnClickListener(this);

    }

    public void submitForm(View view) {
            Intent sugIntent = Suggestions.getIntent(Hack.this);
            startActivity(sugIntent);
            finish();
    }

    @Override
    public void onClick(View view) {
        /*Write the code as for speechToText hide the toast*/
        int id = view.getId();
        switch (id) {
            case R.id.ivNameText:
                promptSpeechInput_name();
                break;
            case R.id.ivAgeText:
                promptSpeechInput_age();
                break;
            case R.id.ivPhoneText:
                promptSpeechInput_phoneNumber();
                break;
            case R.id.ivAllergyText:
                promptSpeechInput_allergy();
                break;
            case R.id.ivDiseaseText:
                promptSpeechInput_disease();
                break;
        }
    }

    private void promptSpeechInput_name() {
        Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,
                RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault());
        intent.putExtra(RecognizerIntent.EXTRA_PROMPT,
                getString(R.string.speech_prompt));
        try {
            startActivityForResult(intent, REQ_CODE_SPEECH_INPUT_NAME);
        } catch (ActivityNotFoundException a) {
            Toast.makeText(getApplicationContext(),
                    getString(R.string.speech_not_supported),
                    Toast.LENGTH_SHORT).show();
        }
    }

    private void promptSpeechInput_age() {
        Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,
                RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault());
        intent.putExtra(RecognizerIntent.EXTRA_PROMPT,
                getString(R.string.speech_prompt));
        try {
            startActivityForResult(intent, REQ_CODE_SPEECH_INPUT_AGE);
        } catch (ActivityNotFoundException a) {
            Toast.makeText(getApplicationContext(),
                    getString(R.string.speech_not_supported),
                    Toast.LENGTH_SHORT).show();
        }
    }

    private void promptSpeechInput_phoneNumber() {
        Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,
                RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault());
        intent.putExtra(RecognizerIntent.EXTRA_PROMPT,
                getString(R.string.speech_prompt));
        try {
            startActivityForResult(intent, REQ_CODE_SPEECH_INPUT_PHONE_NUMBER);
        } catch (ActivityNotFoundException a) {
            Toast.makeText(getApplicationContext(),
                    getString(R.string.speech_not_supported),
                    Toast.LENGTH_SHORT).show();
        }
    }

    private void promptSpeechInput_allergy() {
        Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,
                RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault());
        intent.putExtra(RecognizerIntent.EXTRA_PROMPT,
                getString(R.string.speech_prompt));
        try {
            startActivityForResult(intent, REQ_CODE_SPEECH_INPUT_ALLERGY);
        } catch (ActivityNotFoundException a) {
            Toast.makeText(getApplicationContext(),
                    getString(R.string.speech_not_supported),
                    Toast.LENGTH_SHORT).show();
        }
    }

    private void promptSpeechInput_disease() {
        Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,
                RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault());
        intent.putExtra(RecognizerIntent.EXTRA_PROMPT,
                getString(R.string.speech_prompt));
        try {
            startActivityForResult(intent, REQ_CODE_SPEECH_INPUT_DISEASE);
        } catch (ActivityNotFoundException a) {
            Toast.makeText(getApplicationContext(),
                    getString(R.string.speech_not_supported),
                    Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        switch (requestCode) {
            case REQ_CODE_SPEECH_INPUT_NAME: {
                if (resultCode == RESULT_OK && null != data) {
                    ArrayList<String> result = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
                    nameText.setText(result.get(0));
                }
                break;
            }
            case REQ_CODE_SPEECH_INPUT_AGE: {
                if (resultCode == RESULT_OK && null != data) {
                    ArrayList<String> result = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
                    ageText.setText(result.get(0));
                }
                break;
            }
            case REQ_CODE_SPEECH_INPUT_PHONE_NUMBER: {
                if (resultCode == RESULT_OK && null != data) {
                    ArrayList<String> result = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
                    phoneText.setText(result.get(0));
                }
                break;
            }
            case REQ_CODE_SPEECH_INPUT_ALLERGY: {
                if (resultCode == RESULT_OK && null != data) {
                    ArrayList<String> result = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
                    allergyText.setText(result.get(0));
                }
                break;
            }
            case REQ_CODE_SPEECH_INPUT_DISEASE: {
                if (resultCode == RESULT_OK && null != data) {
                    ArrayList<String> result = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
                    diseaseText.setText(result.get(0));
                }
                break;
            }
        }
    }

    public String getPickUpDetails(){
        String address = "http://127.0.0.1:8000/admin/catalog/health/add/";
        //String address = "https://www.google.com/";
        HttpURLConnection urlConnection;
        String requestBody;
        Uri.Builder builder = new Uri.Builder();
        LoginActivity logIn=new LoginActivity();
        Map<String, String> params = logIn.getPeopleMap();
        params.put("name", String.valueOf(nameText));
        params.put("age", String.valueOf(ageText));
        params.put("phone", String.valueOf(phoneText));
        params.put("allergy", String.valueOf(allergyText));
        params.put("disease", String.valueOf(diseaseText));

        // encode parameters
        Iterator entries = params.entrySet().iterator();
        while (entries.hasNext()) {
            Map.Entry entry = (Map.Entry) entries.next();
            builder.appendQueryParameter(entry.getKey().toString(), entry.getValue().toString());
            entries.remove();
        }
        requestBody = builder.build().getEncodedQuery();

        try {
            URL url = new URL(address);
            urlConnection = (HttpURLConnection) url.openConnection();

            urlConnection.setDoOutput(true);
            urlConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            OutputStream outputStream = new BufferedOutputStream(urlConnection.getOutputStream());
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(outputStream, "utf-8"));
            writer.write(requestBody);
            writer.flush();
            writer.close();
            outputStream.close();

            JSONObject jsonObject = new JSONObject();
            InputStream inputStream;
            // get stream
            if (urlConnection.getResponseCode() < HttpURLConnection.HTTP_BAD_REQUEST) {
                inputStream = urlConnection.getInputStream();
            } else {
                inputStream = urlConnection.getErrorStream();
            }
            // parse stream
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            String temp, response = "";
            while ((temp = bufferedReader.readLine()) != null) {
                response += temp;
            }
            // put into JSONObject
            jsonObject.put("Content", response);
            jsonObject.put("Message", urlConnection.getResponseMessage());
            jsonObject.put("Length", urlConnection.getContentLength());
            jsonObject.put("Type", urlConnection.getContentType());

            return jsonObject.toString();
        } catch (IOException | JSONException e) {
            return e.toString();
        }
    }
}