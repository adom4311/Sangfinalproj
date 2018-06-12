package com.example.georg.sangfinalproj;

import android.app.Activity;
import android.os.AsyncTask;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class accessActivity extends AppCompatActivity {
    private ListView noticeListView;
    private NoticeListAdapter adapter;
    private List<Notice> noticeList;
    public static String userID;
    public static ArrayList<String> friendstring = new ArrayList<>();


    protected void onCreate(Bundle savedIntstanceState)
    {
        super.onCreate(savedIntstanceState);
        setContentView(R.layout.accessactivity);
        noticeListView = (ListView)findViewById(R.id.noticeListView);

        userID = getIntent().getStringExtra("userID");

        noticeList=new ArrayList<Notice>();


        noticeList.add(new Notice("저에요1","2018-05-22","공지사항입니다1."));
        /*noticeList.add(new Notice("저에요2","2018-05-22","공지사항입니다2."));
        noticeList.add(new Notice("저에요3","2018-05-22","공지사항입니다3."));
        noticeList.add(new Notice("저에요4","2018-05-22","공지사항입니다4."));
        noticeList.add(new Notice("저에요5","2018-05-22","공지사항입니다5."));
        noticeList.add(new Notice("저에요6","2018-05-22","공지사항입니다."));
        noticeList.add(new Notice("저에요7","2018-05-22","공지사항입니다."));
        noticeList.add(new Notice("저에요8","2018-05-22","공지사항입니다."));*/
        new BackgroundTask().execute();
        adapter = new NoticeListAdapter(getApplicationContext(),noticeList);
        noticeListView.setAdapter(adapter);


        final Button scheduleButton = (Button)findViewById(R.id.schedulebutton);

        final Button addfriendButton = (Button)findViewById(R.id.addfriend);
        final LinearLayout notice = (LinearLayout)findViewById(R.id.notice);


        scheduleButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                notice.setVisibility(View.GONE);
                scheduleButton.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));

                addfriendButton.setBackgroundColor(getResources().getColor(R.color.colornotice));

                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragment, new ScheduleFragment());
                fragmentTransaction.commit();
            }
        });



        addfriendButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                notice.setVisibility(View.GONE);
                addfriendButton.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));

                scheduleButton.setBackgroundColor(getResources().getColor(R.color.colornotice));

                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragment, new FindfreindFragment());
                fragmentTransaction.commit();
            }
        });



    }

    class BackgroundTask extends AsyncTask<Void, Void, String>
    {

        String target="http://adom4311.cafe24.com/NoticeList.php";

        @Override
        public void onPreExecute() {
            target="http://adom4311.cafe24.com/NoticeList.php";
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
                String noticeContent, noticeName, noticeDate;
                while(count<jsonArray.length())
                {
                    JSONObject object = jsonArray.getJSONObject(count);

                    noticeContent = object.getString("noticeContent");
                    noticeName=object.getString("noticeName");
                    noticeDate=object.getString("noticeDate");
                    Notice notice = new Notice(noticeName,noticeDate,noticeContent);
                    noticeList.add(notice);
                    count++;
                }
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
        }
    }
    private long lastTimeBackPressed;

    @Override
    public void onBackPressed() {
        if(System.currentTimeMillis()-lastTimeBackPressed<1500)
        {
            finish();
            return ;
        }
        Toast.makeText(this,"'뒤로' 버튼을 한 번 더 눌러 종료합니다.", Toast.LENGTH_SHORT);
        lastTimeBackPressed=System.currentTimeMillis();
    }
}
