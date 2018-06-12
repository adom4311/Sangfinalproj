package com.example.georg.sangfinalproj;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Firendschedule extends AppCompatActivity {
    String id;
    static Fschedule fschedule = new Fschedule();
    private AutoResizeTextView monday[] = new AutoResizeTextView[7];
    private AutoResizeTextView tuesday[] = new AutoResizeTextView[7];
    private AutoResizeTextView wednesday[] = new AutoResizeTextView[7];
    private AutoResizeTextView thursday[] = new AutoResizeTextView[7];
    private AutoResizeTextView friday[] = new AutoResizeTextView[7];

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_friendschedule);
        monday[0]=(AutoResizeTextView)findViewById(R.id.mondayAs);
        monday[1]=(AutoResizeTextView)findViewById(R.id.mondayBs);
        monday[2]=(AutoResizeTextView)findViewById(R.id.mondayCs);
        monday[3]=(AutoResizeTextView)findViewById(R.id.mondayDs);
        monday[4]=(AutoResizeTextView)findViewById(R.id.mondayEs);
        monday[5]=(AutoResizeTextView)findViewById(R.id.mondayFs);
        monday[6]=(AutoResizeTextView)findViewById(R.id.mondayGs);
        tuesday[0]=(AutoResizeTextView)findViewById(R.id.tuesdayAs);
        tuesday[1]=(AutoResizeTextView)findViewById(R.id.tuesdayBs);
        tuesday[2]=(AutoResizeTextView)findViewById(R.id.tuesdayCs);
        tuesday[3]=(AutoResizeTextView)findViewById(R.id.tuesdayDs);
        tuesday[4]=(AutoResizeTextView)findViewById(R.id.tuesdayDs);
        tuesday[5]=(AutoResizeTextView)findViewById(R.id.tuesdayFs);
        tuesday[6]=(AutoResizeTextView)findViewById(R.id.tuesdayGs);
        wednesday[0]=(AutoResizeTextView)findViewById(R.id.wednesdayAs);
        wednesday[1]=(AutoResizeTextView)findViewById(R.id.wednesdayBs);
        wednesday[2]=(AutoResizeTextView)findViewById(R.id.wednesdayCs);
        wednesday[3]=(AutoResizeTextView)findViewById(R.id.wednesdayDs);
        wednesday[4]=(AutoResizeTextView)findViewById(R.id.wednesdayEs);
        wednesday[5]=(AutoResizeTextView)findViewById(R.id.wednesdayFs);
        wednesday[6]=(AutoResizeTextView)findViewById(R.id.wednesdayGs);
        thursday[0]=(AutoResizeTextView)findViewById(R.id.thursdayAs);
        thursday[1]=(AutoResizeTextView)findViewById(R.id.thursdayBs);
        thursday[2]=(AutoResizeTextView)findViewById(R.id.thursdayCs);
        thursday[3]=(AutoResizeTextView)findViewById(R.id.thursdayDs);
        thursday[4]=(AutoResizeTextView)findViewById(R.id.thursdayEs);
        thursday[5]=(AutoResizeTextView)findViewById(R.id.thursdayFs);
        thursday[6]=(AutoResizeTextView)findViewById(R.id.thursdayGs);
        friday[0]=(AutoResizeTextView)findViewById(R.id.fridayAs);
        friday[1]=(AutoResizeTextView)findViewById(R.id.fridayBs);
        friday[2]=(AutoResizeTextView)findViewById(R.id.fridayCs);
        friday[3]=(AutoResizeTextView)findViewById(R.id.fridayDs);
        friday[4]=(AutoResizeTextView)findViewById(R.id.fridayEs);
        friday[5]=(AutoResizeTextView)findViewById(R.id.fridayFs);
        friday[6]=(AutoResizeTextView)findViewById(R.id.fridayGs);


        Intent intent = getIntent();
        id=intent.getStringExtra("userID");
        System.out.println(id);




        new BackgroundTask().execute();
    }


    class BackgroundTask extends AsyncTask<Void, Void, String>
    {

        String target;


        @Override
        public void onPreExecute() {
            try
            {
                target="http://adom4311.cafe24.com/ScheduleList.php?userID="+id;


            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
            fschedule.clearsetting();



        }

        @Override
        public String doInBackground(Void... voids) {
            try{
                URL url = new URL(target);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                String temp;
                StringBuilder stringBuilder = new StringBuilder();
                while((temp=bufferedReader.readLine()) != null)
                {
                    stringBuilder.append(temp+"\n");
                }
                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();

                return stringBuilder.toString().trim();

            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        public void onProgressUpdate(Void... values) {
            super.onProgressUpdate();
        }

        @Override
        public void onPostExecute(String s) {
            try{
                JSONObject jsonObject = new JSONObject(s);
                JSONArray jsonArray = jsonObject.getJSONArray("response");
                int count=0;
                String courseProfessor;
                String courseTime;
                String courseTitle;
                int courseID;
                while(count<jsonArray.length())
                {
                    JSONObject object = jsonArray.getJSONObject(count);

                    courseID = object.getInt("courseID");
                    courseProfessor=object.getString("courseProfessor");
                    courseTime=object.getString("courseTime");
                    courseTitle = object.getString("courseTitle");
                   /* for (int i = 0; i < 7; i++) {
                        monday[i].setText("");
                        monday[i].setBackgroundColor(getApplicationContext().getResources().getColor(R.color.white));
                        monday[i].setTextColor(getApplicationContext().getResources().getColor(R.color.white));
                        tuesday[i].setText("");
                        tuesday[i].setBackgroundColor(getApplicationContext().getResources().getColor(R.color.white));
                        tuesday[i].setTextColor(getApplicationContext().getResources().getColor(R.color.white));
                        wednesday[i].setText("");
                        wednesday[i].setBackgroundColor(getApplicationContext().getResources().getColor(R.color.white));
                        wednesday[i].setTextColor(getApplicationContext().getResources().getColor(R.color.white));
                        thursday[i].setText("");
                        thursday[i].setBackgroundColor(getApplicationContext().getResources().getColor(R.color.white));
                        thursday[i].setTextColor(getApplicationContext().getResources().getColor(R.color.white));
                        friday[i].setText("");
                        friday[i].setBackgroundColor(getApplicationContext().getResources().getColor(R.color.white));
                        friday[i].setTextColor(getApplicationContext().getResources().getColor(R.color.white));
                    }*/


                    fschedule.addSchedule(courseTime, courseTitle, courseProfessor);
                    count++;
                }
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
           fschedule.setting(monday, tuesday, wednesday, thursday, friday, getApplicationContext());
        }
    }
}
