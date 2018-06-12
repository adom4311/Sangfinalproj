package com.example.georg.sangfinalproj;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

public class Addclass extends AppCompatActivity {
    Context context = this;
    private ArrayAdapter yearAdapter;
    private Spinner yearSpinner;
    private ArrayAdapter termAdapter;
    private Spinner termSpinner;
    private ArrayAdapter areaAdapter;
    private Spinner areaSpinner;
    private ArrayAdapter majorAdapter;
    private Spinner majorSpinner;

    private String courseUniversity="";
    private String courseYear="";
    private String courseTerm="";
    private String courseArea="";
    private ListView courseListView;
    private CourseListAdapter adapter;
    private List<Course> courseList;
    protected void onCreate(Bundle savedIntstanceState) {
        super.onCreate(savedIntstanceState);
        setContentView(R.layout.addclass_activity);
        final RadioGroup radioGroup = (RadioGroup)findViewById(R.id.courseUniversityGroup);
        yearSpinner = (Spinner)findViewById(R.id.yearSpinner);
        termSpinner = (Spinner)findViewById(R.id.termSpinner);
        areaSpinner = (Spinner)findViewById(R.id.areaSpinner);
        majorSpinner = (Spinner)findViewById(R.id.majorSpinner);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton courseButton = (RadioButton)findViewById(checkedId);
                courseUniversity = courseButton.getText().toString();

                yearAdapter = ArrayAdapter.createFromResource(getApplicationContext(),R.array.year,R.layout.support_simple_spinner_dropdown_item);
                yearSpinner.setAdapter(yearAdapter);

                termAdapter = ArrayAdapter.createFromResource(getApplicationContext(),R.array.term,R.layout.support_simple_spinner_dropdown_item);
                termSpinner.setAdapter(termAdapter);

                if(courseUniversity.equals("학부"))
                {
                    areaAdapter = ArrayAdapter.createFromResource(getApplicationContext(),R.array.universityArea,R.layout.support_simple_spinner_dropdown_item);
                    areaSpinner.setAdapter(areaAdapter);
                    majorAdapter= ArrayAdapter.createFromResource(getApplicationContext(),R.array.universityRefinementMajor,R.layout.support_simple_spinner_dropdown_item);
                    majorSpinner.setAdapter(majorAdapter);
                }
                else if(courseUniversity.equals("대학원"))
                {
                    areaAdapter = ArrayAdapter.createFromResource(getApplicationContext(),R.array.graduatedArea,R.layout.support_simple_spinner_dropdown_item);
                    areaSpinner.setAdapter(areaAdapter);
                    majorAdapter= ArrayAdapter.createFromResource(getApplicationContext(),R.array.graduateMajor,R.layout.support_simple_spinner_dropdown_item);
                    majorSpinner.setAdapter(majorAdapter);
                }

            }
        });
        areaSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(areaSpinner.getSelectedItem().equals("영역별 교양"))
                {
                    majorAdapter= ArrayAdapter.createFromResource(getApplicationContext(),R.array.fieldRefinementMajor,R.layout.support_simple_spinner_dropdown_item);
                    majorSpinner.setAdapter(majorAdapter);
                }
                if(areaSpinner.getSelectedItem().equals("일반교양"))
                {
                    majorAdapter= ArrayAdapter.createFromResource(getApplicationContext(),R.array.universityRefinementMajor,R.layout.support_simple_spinner_dropdown_item);
                    majorSpinner.setAdapter(majorAdapter);
                }
                if(areaSpinner.getSelectedItem().equals("전공 기초"))
                {
                    majorAdapter= ArrayAdapter.createFromResource(getApplicationContext(),R.array.majorbase,R.layout.support_simple_spinner_dropdown_item);
                    majorSpinner.setAdapter(majorAdapter);
                }
                if(areaSpinner.getSelectedItem().equals("전공"))
                {
                    majorAdapter= ArrayAdapter.createFromResource(getApplicationContext(),R.array.universitymajor,R.layout.support_simple_spinner_dropdown_item);
                    majorSpinner.setAdapter(majorAdapter);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        courseListView=(ListView)findViewById(R.id.courseListView);
        courseList = new ArrayList<Course>();
        adapter=new CourseListAdapter(context.getApplicationContext(),courseList,this);
        courseListView.setAdapter(adapter);

        Button searchButton = (Button)findViewById(R.id.searchButton);
        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new BackgroundTask().execute();
            }
        });
    }

    class BackgroundTask extends AsyncTask<Void, Void, String>
    {

        String target;

        @Override
        public void onPreExecute() {
            try
            {
                target="http://adom4311.cafe24.com/CourseList.php?courseUniversity="+courseUniversity
                        + "&courseYear=" +yearSpinner.getSelectedItem().toString().substring(0, 4)
                        + "&courseTerm=" + termSpinner.getSelectedItem().toString()
                        + "&courseArea=" + areaSpinner.getSelectedItem().toString()
                        + "&courseMajor=" + majorSpinner.getSelectedItem().toString();
               /* target="http://adom4311.cafe24.com/CourseList.php?courseUniversity="+ URLEncoder.encode(courseUniversity,"UTF-8")
                        + "&courseYear=" + URLEncoder.encode(yearSpinner.getSelectedItem().toString().substring(0, 4),"UTF-8")
                        + "&courseTerm =" + URLEncoder.encode(termSpinner.getSelectedItem().toString(),"UTF-8")
                        + "&courseArea=" + URLEncoder.encode(areaSpinner.getSelectedItem().toString(), "UTF-8")
                        + "&courseMajor=" + URLEncoder.encode(majorSpinner.getSelectedItem().toString(),"UTF-8");*/
               System.out.println(courseUniversity);
                System.out.println(yearSpinner.getSelectedItem().toString().substring(0, 4));
                System.out.println(termSpinner.getSelectedItem().toString());
                System.out.println(majorSpinner.getSelectedItem().toString());
                System.out.println(target);
            }
            catch(Exception e)
            {

            }

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
                courseList.clear();
                JSONObject jsonObject = new JSONObject(s);
                JSONArray jsonArray = jsonObject.getJSONArray("response");
                int count=0;
                int courseID;
                String courseUniversity;
                int courseYear;
                String courseTerm;
                String courseArea;
                String courseMajor;
                int courseGrade;
                String courseTitle;
                int courseCredit;
                int coursePersonnel;
                String courseProfessor;
                String courseTime;
                String courseRoom;
                while(count<jsonArray.length())
                {
                    JSONObject object = jsonArray.getJSONObject(count);
                    courseID = object.getInt("courseID");
                    courseUniversity=object.getString("courseUniversity");
                    courseYear=object.getInt("courseYear");
                    courseTerm=object.getString("courseTerm");
                    courseArea=object.getString("courseArea");
                    courseMajor=object.getString("courseMajor");
                    courseGrade=object.getInt("courseGrade");
                    courseTitle=object.getString("courseTitle");
                    courseCredit=object.getInt("courseCredit");
                    coursePersonnel=object.getInt("coursePersonnel");
                    courseProfessor=object.getString("courseProfessor");
                    courseTime=object.getString("courseTime");
                    courseRoom=object.getString("courseRoom");
                    Course course = new Course(courseID, courseUniversity, courseYear, courseTerm, courseMajor, courseArea, courseGrade, courseTitle, courseCredit, coursePersonnel, courseProfessor, courseTime, courseRoom);
                    courseList.add(course);
                    count++;
                }
                if(count==0)
                {
                    AlertDialog dialog;
                    AlertDialog.Builder builder= new AlertDialog.Builder(context);
                    dialog=builder.setMessage("조회된 강의가 없습니다.").setPositiveButton("확인",null).create();
                    dialog.show();

                }
                adapter.notifyDataSetChanged();

            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
        }
    }





}
