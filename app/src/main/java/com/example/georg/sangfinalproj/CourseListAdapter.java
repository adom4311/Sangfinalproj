package com.example.georg.sangfinalproj;

import android.app.Activity;
import android.content.Context;
import android.location.Address;
import android.os.AsyncTask;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class CourseListAdapter extends BaseAdapter{

    private Context context;
    private List<Course> courseList;
    private Context father;
    private String userID = accessActivity.userID;
    private Schedule schedule = new Schedule();
    private List<Integer> courseIDList;

    public CourseListAdapter(Context context, List<Course> courseList, Context father) {
        this.context = context;
        this.courseList = courseList;
        this.father = father;
        schedule = new Schedule();
        courseIDList = new ArrayList<Integer>();
        new BackgroundTask().execute();

    }

    @Override
    public int getCount() {
        return courseList.size();
    }

    @Override
    public Object getItem(int position) {
        return courseList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        View v = View.inflate(context, R.layout.course,null);
        TextView courseGrade = (TextView)v.findViewById(R.id.courseGrade);
        TextView courseTitle = (TextView)v.findViewById(R.id.courseTitle);
        TextView courseCredit = (TextView)v.findViewById(R.id.courseCredit);
        TextView coursePersonnel = (TextView)v.findViewById(R.id.coursePersonnel);
        TextView courseProfessor = (TextView)v.findViewById(R.id.courseproffesor);
        TextView courseTime = (TextView)v.findViewById(R.id.courseTime);

        if(courseList.get(position).getCourseGrade()==0)
        {
            courseGrade.setText("모든 학년");
        }
        else
        {
            courseGrade.setText(courseList.get(position).getCourseGrade()+"학년");
        }
        courseTitle.setText(courseList.get(position).getCourseTitle());
        courseCredit.setText(courseList.get(position).getCourseCredit()+"학점");
        if(courseList.get(position).getCoursePersonnel()==0)
        {
            coursePersonnel.setText("인원 제한 없음");
        }
        else
        {
            coursePersonnel.setText("제한 인원 : " + courseList.get(position).getCoursePersonnel()+"명");
        }
        courseProfessor.setText(courseList.get(position).getCourseProfessor()+"교수님");
        courseTime.setText(courseList.get(position).getCourseTime()+"");




        v.setTag(courseList.get(position).getCourseID());

        Button adButton = (Button)v.findViewById(R.id.addButton);
        adButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean validate =false;
                validate = schedule.validate(courseList.get(position).getCourseTime());
                if(!alreayIn(courseIDList, courseList.get(position).getCourseID()))
                {
                    AlertDialog.Builder builder = new AlertDialog.Builder(father);
                    AlertDialog dialog= builder.setMessage("이미 추가한 강의 입니다.")
                            .setPositiveButton("확인",null).create();
                    dialog.show();
                }
                else if(validate == false)
                {
                    AlertDialog.Builder builder = new AlertDialog.Builder(father);
                    AlertDialog dialog= builder.setMessage("시간표 중복입니다")
                            .setPositiveButton("확인",null).create();
                    dialog.show();
                }
                else
                {
                    String userID = accessActivity.userID;
                    Response.Listener<String> responseListener = new Response.Listener<String>(){
                        public void onResponse(String response){
                            try
                            {
                                JSONObject jsonResponse = new JSONObject(response);
                                boolean success = jsonResponse.getBoolean("success");
                                if(success){
                                    AlertDialog.Builder builder = new AlertDialog.Builder(father);
                                    AlertDialog dialog= builder.setMessage("강의가 추가되었습니다.")
                                            .setPositiveButton("확인",null).create();
                                    dialog.show();
                                    courseIDList.add(courseList.get(position).getCourseID());
                                    schedule.addSchedule(courseList.get(position).getCourseTime());

                                }
                                else
                                {
                                    AlertDialog.Builder builder = new AlertDialog.Builder(father);
                                    AlertDialog dialog= builder.setMessage("강의 추가에 실패했습니다..")
                                            .setPositiveButton("확인",null).create();
                                    dialog.show();
                                }
                            }

                            catch(Exception e)
                            {
                                e.printStackTrace();
                            }
                        }
                    };
                    AddRequest addRequest = new AddRequest(userID, courseList.get(position).getCourseID()+"",responseListener);
                    RequestQueue queue = Volley.newRequestQueue(father);
                    queue.add(addRequest);

                }

            }
        });
        return v;
    }

    class BackgroundTask extends AsyncTask<Void, Void, String>
    {

        String target;

        @Override
        public void onPreExecute() {
            try
            {
                target="http://adom4311.cafe24.com/ScheduleList.php?userID="+userID;
            }
            catch(Exception e)
            {
                e.printStackTrace();
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
                JSONObject jsonObject = new JSONObject(s);
                JSONArray jsonArray = jsonObject.getJSONArray("response");
                int count=0;
                String courseProfessor;
                String courseTime;
                int courseID;
                while(count<jsonArray.length())
                {
                    JSONObject object = jsonArray.getJSONObject(count);

                    courseID = object.getInt("courseID");
                    courseProfessor=object.getString("courseProfessor");
                    courseTime=object.getString("courseTime");
                    courseIDList.add(courseID);
                    schedule.addSchedule(courseTime);
                    count++;
                }
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
        }
    }

    public boolean alreayIn(List<Integer> courseIDList, int item)
    {
        for(int i=0;i<courseIDList.size();i++)
        {
            if(courseIDList.get(i)==item)
            {
                return false;
            }
        }
        return true;
    }
}
