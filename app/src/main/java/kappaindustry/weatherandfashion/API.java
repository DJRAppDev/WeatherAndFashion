package kappaindustry.weatherandfashion;

import android.os.AsyncTask;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

class API extends AsyncTask<Void, Void, String> {
    private Exception exception;

    private final String urlField = "http://openweathermap.org/city/5110253";
    private final String apiKey = "0fe4b095e453ce3f432586038d5b7f6f";

    private TextView temp;
    private String response;

    public API(TextView tv) {
        tv = temp;
        Log.d("Tag","Running");
    }

    @Override
    protected void onPreExecute() {
    }

    @Override
    protected String doInBackground(Void... urls) {
        try {
            URL url = new URL(urlField);
            HttpURLConnection connection = (HttpURLConnection)url.openConnection();
            connection.addRequestProperty("x-api-key", apiKey);
            try{
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                StringBuilder stringBuilder = new StringBuilder();
                String line;
                while ((line = bufferedReader.readLine()) != null) {
                    stringBuilder.append(line).append("\n");
                }
                bufferedReader.close();
                response = stringBuilder.toString();
                return response;
            }
            finally{
                connection.disconnect();
            }
        } catch (Exception e) {
            Log.e("ERROR", e.getMessage(), e);
            return null;
        }
    }

    protected void onPostExecute() {
        if(response == null) {
            response = "THERE WAS AN ERROR";
        }
        else {
            Log.i("INFO", response);
            temp.setText(response);
        }
    }
}
