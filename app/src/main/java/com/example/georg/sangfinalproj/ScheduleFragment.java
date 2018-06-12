package com.example.georg.sangfinalproj;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link ScheduleFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link ScheduleFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ScheduleFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    Button btn;
    Schedule schedule=new Schedule();



    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public ScheduleFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ScheduleFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ScheduleFragment newInstance(String param1, String param2) {
        ScheduleFragment fragment = new ScheduleFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);

        }

    }

    private AutoResizeTextView monday[] = new AutoResizeTextView[7];
    private AutoResizeTextView tuesday[] = new AutoResizeTextView[7];
    private AutoResizeTextView wednesday[] = new AutoResizeTextView[7];
    private AutoResizeTextView thursday[] = new AutoResizeTextView[7];
    private AutoResizeTextView friday[] = new AutoResizeTextView[7];
    String mondayA="";
    String mondayB="";
    String mondayC="";
    String mondayD="";
    String mondayE="";
    String mondayF="";
    String mondayG="";
    String tuesdayA="";
    String tuesdayB="";
    String tuesdayC="";
    String tuesdayD="";
    String tuesdayE="";
    String tuesdayF="";
    String tuesdayG="";
    String wednesdayA="";
    String wednesdayB="";
    String wednesdayC="";
    String wednesdayD="";
    String wednesdayE="";
    String wednesdayF="";
    String wednesdayG="";
    String thursdayA="";
    String thursdayB="";
    String thursdayC="";
    String thursdayD="";
    String thursdayE="";
    String thursdayF="";
    String thursdayG="";
    String fridayA="";
    String fridayB="";
    String fridayC="";
    String fridayD="";
    String fridayE="";
    String fridayF="";
    String fridayG="";
    private AlertDialog dialog;



    public void onActivityCreated(Bundle b)
    {
        super.onActivityCreated(b);
        monday[0]=(AutoResizeTextView)getView().findViewById(R.id.mondayA);
        monday[1]=(AutoResizeTextView)getView().findViewById(R.id.mondayB);
        monday[2]=(AutoResizeTextView)getView().findViewById(R.id.mondayC);
        monday[3]=(AutoResizeTextView)getView().findViewById(R.id.mondayD);
        monday[4]=(AutoResizeTextView)getView().findViewById(R.id.mondayE);
        monday[5]=(AutoResizeTextView)getView().findViewById(R.id.mondayF);
        monday[6]=(AutoResizeTextView)getView().findViewById(R.id.mondayG);
        tuesday[0]=(AutoResizeTextView)getView().findViewById(R.id.tuesdayA);
        tuesday[1]=(AutoResizeTextView)getView().findViewById(R.id.tuesdayB);
        tuesday[2]=(AutoResizeTextView)getView().findViewById(R.id.tuesdayC);
        tuesday[3]=(AutoResizeTextView)getView().findViewById(R.id.tuesdayD);
        tuesday[4]=(AutoResizeTextView)getView().findViewById(R.id.tuesdayD);
        tuesday[5]=(AutoResizeTextView)getView().findViewById(R.id.tuesdayF);
        tuesday[6]=(AutoResizeTextView)getView().findViewById(R.id.tuesdayG);
        wednesday[0]=(AutoResizeTextView)getView().findViewById(R.id.wednesdayA);
        wednesday[1]=(AutoResizeTextView)getView().findViewById(R.id.wednesdayB);
        wednesday[2]=(AutoResizeTextView)getView().findViewById(R.id.wednesdayC);
        wednesday[3]=(AutoResizeTextView)getView().findViewById(R.id.wednesdayD);
        wednesday[4]=(AutoResizeTextView)getView().findViewById(R.id.wednesdayE);
        wednesday[5]=(AutoResizeTextView)getView().findViewById(R.id.wednesdayF);
        wednesday[6]=(AutoResizeTextView)getView().findViewById(R.id.wednesdayG);
        thursday[0]=(AutoResizeTextView)getView().findViewById(R.id.thursdayA);
        thursday[1]=(AutoResizeTextView)getView().findViewById(R.id.thursdayB);
        thursday[2]=(AutoResizeTextView)getView().findViewById(R.id.thursdayC);
        thursday[3]=(AutoResizeTextView)getView().findViewById(R.id.thursdayD);
        thursday[4]=(AutoResizeTextView)getView().findViewById(R.id.thursdayE);
        thursday[5]=(AutoResizeTextView)getView().findViewById(R.id.thursdayF);
        thursday[6]=(AutoResizeTextView)getView().findViewById(R.id.thursdayG);
        friday[0]=(AutoResizeTextView)getView().findViewById(R.id.fridayA);
        friday[1]=(AutoResizeTextView)getView().findViewById(R.id.fridayB);
        friday[2]=(AutoResizeTextView)getView().findViewById(R.id.fridayC);
        friday[3]=(AutoResizeTextView)getView().findViewById(R.id.fridayD);
        friday[4]=(AutoResizeTextView)getView().findViewById(R.id.fridayE);
        friday[5]=(AutoResizeTextView)getView().findViewById(R.id.fridayF);
        friday[6]=(AutoResizeTextView)getView().findViewById(R.id.fridayG);



        new BackgroundTask().execute();
        new BackgroundTaskforNon().execute();

        monday[0].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(monday[0].getCurrentTextColor()== Color.WHITE)
                {
                    AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                    dialog = builder.setMessage(mondayA).setPositiveButton("확인",null).create();
                    dialog.show();

                }
            }
        });

        monday[1].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(monday[1].getCurrentTextColor()== Color.WHITE)
                {
                    AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                    dialog = builder.setMessage(mondayB).setPositiveButton("확인",null).create();
                    dialog.show();

                }
            }
        });
        monday[2].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(monday[2].getCurrentTextColor()== Color.WHITE)
                {
                    AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                    dialog = builder.setMessage(mondayC).setPositiveButton("확인",null).create();
                    dialog.show();

                }
            }
        });
        monday[3].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(monday[3].getCurrentTextColor()== Color.WHITE)
                {
                    AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                    dialog = builder.setMessage(mondayD).setPositiveButton("확인",null).create();
                    dialog.show();

                }
            }
        });
        monday[4].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(monday[4].getCurrentTextColor()== Color.WHITE)
                {
                    AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                    dialog = builder.setMessage(mondayE).setPositiveButton("확인",null).create();
                    dialog.show();

                }
            }
        });
        monday[5].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(monday[5].getCurrentTextColor()== Color.WHITE)
                {
                    AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                    dialog = builder.setMessage(mondayF).setPositiveButton("확인",null).create();
                    dialog.show();

                }
            }
        });
        monday[6].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(monday[6].getCurrentTextColor()== Color.WHITE)
                {
                    AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                    dialog = builder.setMessage(mondayG).setPositiveButton("확인",null).create();
                    dialog.show();

                }
            }
        });





        tuesday[0].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(tuesday[0].getCurrentTextColor()== Color.WHITE)
                {
                    AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                    dialog = builder.setMessage(tuesdayA).setPositiveButton("확인",null).create();
                    dialog.show();

                }
            }
        });

        tuesday[1].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(tuesday[1].getCurrentTextColor()== Color.WHITE)
                {
                    AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                    dialog = builder.setMessage(tuesdayB).setPositiveButton("확인",null).create();
                    dialog.show();

                }
            }
        });
        tuesday[2].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(tuesday[2].getCurrentTextColor()== Color.WHITE)
                {
                    AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                    dialog = builder.setMessage(tuesdayC).setPositiveButton("확인",null).create();
                    dialog.show();

                }
            }
        });
        tuesday[3].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(tuesday[3].getCurrentTextColor()== Color.WHITE)
                {
                    AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                    dialog = builder.setMessage(tuesdayD).setPositiveButton("확인",null).create();
                    dialog.show();

                }
            }
        });
        tuesday[4].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(tuesday[4].getCurrentTextColor()== Color.WHITE)
                {
                    AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                    dialog = builder.setMessage(tuesdayE).setPositiveButton("확인",null).create();
                    dialog.show();

                }
            }
        });
        tuesday[5].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(tuesday[5].getCurrentTextColor()== Color.WHITE)
                {
                    AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                    dialog = builder.setMessage(tuesdayF).setPositiveButton("확인",null).create();
                    dialog.show();

                }
            }
        });
        tuesday[6].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(tuesday[6].getCurrentTextColor()== Color.WHITE)
                {
                    AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                    dialog = builder.setMessage(tuesdayG).setPositiveButton("확인",null).create();
                    dialog.show();

                }
            }
        });





        wednesday[0].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(wednesday[0].getCurrentTextColor()== Color.WHITE)
                {
                    AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                    dialog = builder.setMessage(wednesdayA).setPositiveButton("확인",null).create();
                    dialog.show();

                }
            }
        });

        wednesday[1].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(wednesday[1].getCurrentTextColor()== Color.WHITE)
                {
                    AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                    dialog = builder.setMessage(wednesdayB).setPositiveButton("확인",null).create();
                    dialog.show();

                }
            }
        });
        wednesday[2].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(wednesday[2].getCurrentTextColor()== Color.WHITE)
                {
                    AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                    dialog = builder.setMessage(wednesdayC).setPositiveButton("확인",null).create();
                    dialog.show();

                }
            }
        });
        wednesday[3].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(wednesday[3].getCurrentTextColor()== Color.WHITE)
                {
                    AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                    dialog = builder.setMessage(wednesdayD).setPositiveButton("확인",null).create();
                    dialog.show();

                }
            }
        });
        wednesday[4].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(wednesday[4].getCurrentTextColor()== Color.WHITE)
                {
                    AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                    dialog = builder.setMessage(wednesdayE).setPositiveButton("확인",null).create();
                    dialog.show();

                }
            }
        });
        wednesday[5].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(wednesday[5].getCurrentTextColor()== Color.WHITE)
                {
                    AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                    dialog = builder.setMessage(wednesdayF).setPositiveButton("확인",null).create();
                    dialog.show();

                }
            }
        });
        wednesday[6].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(wednesday[6].getCurrentTextColor()== Color.WHITE)
                {
                    AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                    dialog = builder.setMessage(wednesdayG).setPositiveButton("확인",null).create();
                    dialog.show();

                }
            }
        });






        thursday[0].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(thursday[0].getCurrentTextColor()== Color.WHITE)
                {
                    AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                    dialog = builder.setMessage(thursdayA).setPositiveButton("확인",null).create();
                    dialog.show();

                }
            }
        });

        thursday[1].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(thursday[1].getCurrentTextColor()== Color.WHITE)
                {
                    AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                    dialog = builder.setMessage(thursdayB).setPositiveButton("확인",null).create();
                    dialog.show();

                }
            }
        });
        thursday[2].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(thursday[2].getCurrentTextColor()== Color.WHITE)
                {
                    AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                    dialog = builder.setMessage(thursdayC).setPositiveButton("확인",null).create();
                    dialog.show();

                }
            }
        });
        thursday[3].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(thursday[3].getCurrentTextColor()== Color.WHITE)
                {
                    AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                    dialog = builder.setMessage(thursdayD).setPositiveButton("확인",null).create();
                    dialog.show();

                }
            }
        });
        thursday[4].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(thursday[4].getCurrentTextColor()== Color.WHITE)
                {
                    AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                    dialog = builder.setMessage(thursdayE).setPositiveButton("확인",null).create();
                    dialog.show();

                }
            }
        });
        thursday[5].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(thursday[5].getCurrentTextColor()== Color.WHITE)
                {
                    AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                    dialog = builder.setMessage(thursdayF).setPositiveButton("확인",null).create();
                    dialog.show();

                }
            }
        });
        thursday[6].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(thursday[6].getCurrentTextColor()== Color.WHITE)
                {
                    AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                    dialog = builder.setMessage(thursdayG).setPositiveButton("확인",null).create();
                    dialog.show();

                }
            }
        });





        friday[0].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(friday[0].getCurrentTextColor()== Color.WHITE)
                {
                    AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                    dialog = builder.setMessage(fridayA).setPositiveButton("확인",null).create();
                    dialog.show();

                }
            }
        });

        friday[1].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(friday[1].getCurrentTextColor()== Color.WHITE)
                {
                    AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                    dialog = builder.setMessage(fridayB).setPositiveButton("확인",null).create();
                    dialog.show();

                }
            }
        });
        friday[2].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(friday[2].getCurrentTextColor()== Color.WHITE)
                {
                    AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                    dialog = builder.setMessage(fridayC).setPositiveButton("확인",null).create();
                    dialog.show();

                }
            }
        });
        friday[3].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(friday[3].getCurrentTextColor()== Color.WHITE)
                {
                    AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                    dialog = builder.setMessage(fridayD).setPositiveButton("확인",null).create();
                    dialog.show();

                }
            }
        });
        friday[4].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(friday[4].getCurrentTextColor()== Color.WHITE)
                {
                    AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                    dialog = builder.setMessage(fridayE).setPositiveButton("확인",null).create();
                    dialog.show();

                }
            }
        });
        friday[5].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(friday[5].getCurrentTextColor()== Color.WHITE)
                {
                    AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                    dialog = builder.setMessage(fridayF).setPositiveButton("확인",null).create();
                    dialog.show();

                }
            }
        });
        friday[6].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(friday[6].getCurrentTextColor()== Color.WHITE)
                {
                    AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                    dialog = builder.setMessage(fridayG).setPositiveButton("확인",null).create();
                    dialog.show();

                }
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
                target="http://adom4311.cafe24.com/ScheduleList.php?userID="+accessActivity.userID;
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
                String courseTitle;
                int courseID;
                while(count<jsonArray.length())
                {
                    JSONObject object = jsonArray.getJSONObject(count);

                    courseID = object.getInt("courseID");
                    courseProfessor=object.getString("courseProfessor");
                    courseTime=object.getString("courseTime");
                    courseTitle = object.getString("courseTitle");
                    schedule.addSchedule(courseTime, courseTitle, courseProfessor);
                    count++;
                }
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
            schedule.setting(monday, tuesday, wednesday, thursday, friday, getContext());
        }
    }


    class BackgroundTaskforNon extends AsyncTask<Void, Void, String>
    {

        String target;

        @Override
        public void onPreExecute() {
            try
            {
                target="http://adom4311.cafe24.com/NoscheduleLIst.php?userID="+accessActivity.userID;
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
                int idcount=0;
                boolean check=false;
                String[][][] userID=new String[100][6][8];

                String temp;
                String courseTime;


                while(count<jsonArray.length())
                {
                    JSONObject object = jsonArray.getJSONObject(count);


                    temp=object.getString("userID");
                    courseTime=object.getString("courseTime");
                    for(int i=0;i<idcount;i++)
                    {
                        if(temp.equals(userID[i][0][0]))
                        {
                            check=true;
                            if(courseTime.contains("월A"))
                            {
                                userID[i][1][1]+="sc";
                            }
                            if(courseTime.contains("월B"))
                            {
                                userID[i][1][2]+="sc";
                            }
                            if(courseTime.contains("월C"))
                            {
                                userID[i][1][3]+="sc";
                            }
                            if(courseTime.contains("월D"))
                            {
                                userID[i][1][4]+="sc";
                            }
                            if(courseTime.contains("월E"))
                            {
                                userID[i][1][5]+="sc";
                            }
                            if(courseTime.contains("월F"))
                            {
                                userID[i][1][6]+="sc";
                            }
                            if(courseTime.contains("월G"))
                            {
                                userID[i][1][7]+="sc";
                            }

                            if(courseTime.contains("화A"))
                            {
                                userID[i][2][1]+="sc";
                            }
                            if(courseTime.contains("화B"))
                            {
                                userID[i][2][2]+="sc";
                            }
                            if(courseTime.contains("화C"))
                            {
                                userID[i][2][3]+="sc";
                            }
                            if(courseTime.contains("화D"))
                            {
                                userID[i][2][4]+="sc";
                            }
                            if(courseTime.contains("화E"))
                            {
                                userID[i][2][5]+="sc";
                            }
                            if(courseTime.contains("화F"))
                            {
                                userID[i][2][6]+="sc";
                            }
                            if(courseTime.contains("화G"))
                            {
                                userID[i][2][7]+="sc";
                            }

                            if(courseTime.contains("수A"))
                            {
                                userID[i][3][1]+="sc";
                            }
                            if(courseTime.contains("수B"))
                            {
                                userID[i][3][2]+="sc";
                            }
                            if(courseTime.contains("수C"))
                            {
                                userID[i][3][3]+="sc";
                            }
                            if(courseTime.contains("수D"))
                            {
                                userID[i][3][4]+="sc";
                            }
                            if(courseTime.contains("수E"))
                            {
                                userID[i][3][5]+="sc";
                            }
                            if(courseTime.contains("수F"))
                            {
                                userID[i][3][6]+="sc";
                            }
                            if(courseTime.contains("수G"))
                            {
                                userID[i][3][7]+="sc";
                            }

                            if(courseTime.contains("목A"))
                            {
                                userID[i][4][1]+="sc";
                            }
                            if(courseTime.contains("목B"))
                            {
                                userID[i][4][2]+="sc";
                            }
                            if(courseTime.contains("목C"))
                            {
                                userID[i][4][3]+="sc";
                            }
                            if(courseTime.contains("목D"))
                            {
                                userID[i][4][4]+="sc";
                            }
                            if(courseTime.contains("목E"))
                            {
                                userID[i][4][5]+="sc";
                            }
                            if(courseTime.contains("목F"))
                            {
                                userID[i][4][6]+="sc";
                            }
                            if(courseTime.contains("목G"))
                            {
                                userID[i][4][7]+="sc";
                            }
                            if(courseTime.contains("금A"))
                            {
                                userID[i][5][1]+="sc";
                            }
                            if(courseTime.contains("금B"))
                            {
                                userID[i][5][2]+="sc";
                            }
                            if(courseTime.contains("금C"))
                            {
                                userID[i][5][3]+="sc";
                            }
                            if(courseTime.contains("금D"))
                            {
                                userID[i][5][4]+="sc";
                            }
                            if(courseTime.contains("금E"))
                            {
                                userID[i][5][5]+="sc";
                            }
                            if(courseTime.contains("금F"))
                            {
                                userID[i][5][6]+="sc";
                            }
                            if(courseTime.contains("금G"))
                            {
                                userID[i][5][7]+="sc";
                            }
                            break;
                        }

                    }
                    if(check==false)
                    {
                        userID[idcount][0][0]=temp;
                        if(courseTime.contains("월A"))
                        {
                            userID[idcount][1][1]="sc";
                        }
                        if(courseTime.contains("월B"))
                        {
                            userID[idcount][1][2]+="sc";
                        }
                        if(courseTime.contains("월C"))
                        {
                            userID[idcount][1][3]+="sc";
                        }
                        if(courseTime.contains("월D"))
                        {
                            userID[idcount][1][4]+="sc";
                        }
                        if(courseTime.contains("월E"))
                        {
                            userID[idcount][1][5]+="sc";
                        }
                        if(courseTime.contains("월F"))
                        {
                            userID[idcount][1][6]+="sc";
                        }
                        if(courseTime.contains("월G"))
                        {
                            userID[idcount][1][7]+="sc";
                        }

                        if(courseTime.contains("화A"))
                        {
                            userID[idcount][2][1]+="sc";
                        }
                        if(courseTime.contains("화B"))
                        {
                            userID[idcount][2][2]+="sc";
                        }
                        if(courseTime.contains("화C"))
                        {
                            userID[idcount][2][3]+="sc";
                        }
                        if(courseTime.contains("화D"))
                        {
                            userID[idcount][2][4]+="sc";
                        }
                        if(courseTime.contains("화E"))
                        {
                            userID[idcount][2][5]+="sc";
                        }
                        if(courseTime.contains("화F"))
                        {
                            userID[idcount][2][6]+="sc";
                        }
                        if(courseTime.contains("화G"))
                        {
                            userID[idcount][2][7]+="sc";
                        }

                        if(courseTime.contains("수A"))
                        {
                            userID[idcount][3][1]+="sc";
                        }
                        if(courseTime.contains("수B"))
                        {
                            userID[idcount][3][2]+="sc";
                        }
                        if(courseTime.contains("수C"))
                        {
                            userID[idcount][3][3]+="sc";
                        }
                        if(courseTime.contains("수D"))
                        {
                            userID[idcount][3][4]+="sc";
                        }
                        if(courseTime.contains("수E"))
                        {
                            userID[idcount][3][5]+="sc";
                        }
                        if(courseTime.contains("수F"))
                        {
                            userID[idcount][3][6]+="sc";
                        }
                        if(courseTime.contains("수G"))
                        {
                            userID[idcount][3][7]+="sc";
                        }

                        if(courseTime.contains("목A"))
                        {
                            userID[idcount][4][1]+="sc";
                        }
                        if(courseTime.contains("목B"))
                        {
                            userID[idcount][4][2]+="sc";
                        }
                        if(courseTime.contains("목C"))
                        {
                            userID[idcount][4][3]+="sc";
                        }
                        if(courseTime.contains("목D"))
                        {
                            userID[idcount][4][4]+="sc";
                        }
                        if(courseTime.contains("목E"))
                        {
                            userID[idcount][4][5]+="sc";
                        }
                        if(courseTime.contains("목F"))
                        {
                            userID[idcount][4][6]+="sc";
                        }
                        if(courseTime.contains("목G"))
                        {
                            userID[idcount][4][7]+="sc";
                        }
                        if(courseTime.contains("금A"))
                        {
                            userID[idcount][5][1]+="sc";
                        }
                        if(courseTime.contains("금B"))
                        {
                            userID[idcount][5][2]+="sc";
                        }
                        if(courseTime.contains("금C"))
                        {
                            userID[idcount][5][3]+="sc";
                        }
                        if(courseTime.contains("금D"))
                        {
                            userID[idcount][5][4]="sc";
                        }
                        if(courseTime.contains("금E"))
                        {
                            userID[idcount][5][5]="sc";
                        }
                        if(courseTime.contains("금F"))
                        {
                            userID[idcount][5][6]="sc";
                        }
                        if(courseTime.contains("금G"))
                        {
                            userID[idcount][5][7]="sc";
                        }
                        idcount++;
                    }
                    if(check==true)
                    {
                        check=false;
                    }




                    count++;
                }
                for(int i=0;i<idcount;i++)
                {
                    for(int j=0;j<6;j++)
                    {
                        for(int k=0;k<8;k++)
                        {
                            if(userID[i][j][k]==null)
                            {
                                userID[i][j][k]="null";
                            }
                        }
                    }
                }
                for(int i=0;i<idcount;i++)
                {
                    if(!userID[i][1][1].contains("sc"))
                    {
                        mondayA=mondayA+userID[i][0][0]+"님도 수업이 없어요\n";
                        System.out.println("없어요");
                    }
                    if(!userID[i][1][2].contains("sc"))
                    {
                        mondayB=mondayB+userID[i][0][0]+"님도 수업이 없어요\n";
                    }
                    if(!userID[i][1][3].contains("sc"))
                    {
                        mondayC=mondayC+userID[i][0][0]+"님도 수업이 없어요\n";
                    }
                    if(!userID[i][1][4].contains("sc"))
                    {
                        mondayD=mondayD+userID[i][0][0]+"님도 수업이 없어요\n";
                    }
                    if(!userID[i][1][5].contains("sc"))
                    {
                        mondayE=mondayE+userID[i][0][0]+"님도 수업이 없어요\n";
                    }
                    if(!userID[i][1][6].contains("sc"))
                    {
                        mondayF=mondayF+userID[i][0][0]+"님도 수업이 없어요\n";
                    }
                    if(!userID[i][1][7].contains("sc"))
                    {
                        mondayG=mondayG+userID[i][0][0]+"님도 수업이 없어요\n";
                    }



                    if(!userID[i][2][1].contains("sc"))
                    {
                        tuesdayA=tuesdayA+userID[i][0][0]+"님도 수업이 없어요\n";
                    }
                    if(!userID[i][2][2].contains("sc"))
                    {
                        tuesdayB=tuesdayB+userID[i][0][0]+"님도 수업이 없어요\n";
                    }
                    if(!userID[i][2][3].contains("sc"))
                    {
                        tuesdayC=  tuesdayC+userID[i][0][0]+"님도 수업이 없어요\n";
                    }
                    if(!userID[i][2][4].contains("sc")) {
                        tuesdayD = tuesdayD + userID[i][0][0] + "님도 수업이 없어요\n";

                    }

                    if(!userID[i][2][5].contains("sc"))
                    {
                        tuesdayE= tuesdayE+userID[i][0][0]+"님도 수업이 없어요\n";
                    }
                    if(!userID[i][2][6].contains("sc"))
                    {
                        tuesdayF= tuesdayF+userID[i][0][0]+"님도 수업이 없어요\n";
                    }
                    if(!userID[i][2][7].contains("sc"))
                    {
                        tuesdayG= tuesdayG+userID[i][0][0]+"님도 수업이 없어요\n";
                    }


                    if(!userID[i][3][1].contains("sc"))
                    {
                        wednesdayA=wednesdayA+userID[i][0][0]+"님도 수업이 없어요\n";
                    }
                    if(!userID[i][3][2].contains("sc"))
                    {
                        wednesdayB=wednesdayB+userID[i][0][0]+"님도 수업이 없어요\n";
                    }
                    if(!userID[i][3][3].contains("sc"))
                    {
                        wednesdayC=  wednesdayC+userID[i][0][0]+"님도 수업이 없어요\n";
                    }
                    if(!userID[i][3][4].contains("sc")) {
                        wednesdayD = wednesdayD + userID[i][0][0] + "님도 수업이 없어요\n";
                    }
                    if(!userID[i][3][5].contains("sc"))
                    {
                        wednesdayE= wednesdayE+userID[i][0][0]+"님도 수업이 없어요\n";
                    }
                    if(!userID[i][3][6].contains("sc"))
                    {
                        wednesdayF= wednesdayF+userID[i][0][0]+"님도 수업이 없어요\n";
                    }
                    if(!userID[i][3][7].contains("sc"))
                    {
                        wednesdayG= wednesdayG+userID[i][0][0]+"님도 수업이 없어요\n";
                    }


                    if(!userID[i][4][1].contains("sc"))
                    {
                       thursdayA=thursdayA+userID[i][0][0]+"님도 수업이 없어요\n";
                    }
                    if(!userID[i][4][2].contains("sc"))
                    {
                        thursdayB=thursdayB+userID[i][0][0]+"님도 수업이 없어요\n";
                    }
                    if(!userID[i][4][3].contains("sc"))
                    {
                        thursdayC=  thursdayC+userID[i][0][0]+"님도 수업이 없어요\n";
                    }
                    if(!userID[i][4][4].contains("sc")) {
                        thursdayD = thursdayD + userID[i][0][0] + "님도 수업이 없어요\n";
                    }
                    if(!userID[i][4][5].contains("sc"))
                    {
                        thursdayE= thursdayE+userID[i][0][0]+"님도 수업이 없어요\n";
                    }
                    if(!userID[i][4][6].contains("sc"))
                    {
                        thursdayF= thursdayF+userID[i][0][0]+"님도 수업이 없어요\n";
                    }
                    if(!userID[i][4][7].contains("sc"))
                    {
                        thursdayG= thursdayG+userID[i][0][0]+"님도 수업이 없어요\n";
                    }


                    if(!userID[i][5][1].contains("sc"))
                    {
                        fridayA=fridayA+userID[i][0][0]+"님도 수업이 없어요\n";
                    }
                    if(!userID[i][5][2].contains("sc"))
                    {
                        fridayB=fridayB+userID[i][0][0]+"님도 수업이 없어요\n";
                    }
                    if(!userID[i][5][3].contains("sc"))
                    {
                        fridayC=  fridayC+userID[i][0][0]+"님도 수업이 없어요\n";
                    }
                    if(!userID[i][5][4].contains("sc")) {
                        fridayD = fridayD + userID[i][0][0] + "님도 수업이 없어요\n";
                    }
                    if(!userID[i][5][5].contains("sc"))
                    {
                        fridayE= fridayE+userID[i][0][0]+"님도 수업이 없어요\n";
                    }
                    if(!userID[i][5][6].contains("sc"))
                    {
                        fridayF= fridayF+userID[i][0][0]+"님도 수업이 없어요\n";
                    }
                    if(!userID[i][5][7].contains("sc"))
                    {
                        fridayG= fridayG+userID[i][0][0]+"님도 수업이 없어요\n";
                    }




                }
                if(mondayA.equals("")) mondayA="혼자먹으세요 ㅠㅠ";
                if(mondayB.equals("")) mondayB="혼자먹으세요 ㅠㅠ";
                if(mondayC.equals("")) mondayC="혼자먹으세요 ㅠㅠ";
                if(mondayD.equals("")) mondayD="혼자먹으세요 ㅠㅠ";
                if(mondayE.equals("")) mondayE="혼자먹으세요 ㅠㅠ";
                if(mondayF.equals("")) mondayF="혼자먹으세요 ㅠㅠ";
                if(mondayG.equals("")) mondayG="혼자먹으세요 ㅠㅠ";
                if(tuesdayA.equals("")) tuesdayA="혼자먹으세요 ㅠㅠ";
                if(tuesdayB.equals("")) tuesdayB="혼자먹으세요 ㅠㅠ";
                if(tuesdayC.equals("")) tuesdayC="혼자먹으세요 ㅠㅠ";
                if(tuesdayD.equals("")) tuesdayD="혼자먹으세요 ㅠㅠ";
                if(tuesdayF.equals("")) tuesdayF="혼자먹으세요 ㅠㅠ";
                if(tuesdayG.equals("")) tuesdayG="혼자먹으세요 ㅠㅠ";
                if(wednesdayA.equals("")) wednesdayA="혼자먹으세요 ㅠㅠ";
                if(wednesdayB.equals("")) wednesdayB="혼자먹으세요 ㅠㅠ";
                if(wednesdayC.equals("")) wednesdayC="혼자먹으세요 ㅠㅠ";
                if(wednesdayD.equals("")) wednesdayC="혼자먹으세요 ㅠㅠ";
                if(wednesdayD.equals("")) wednesdayD="혼자먹으세요 ㅠㅠ";
                if(wednesdayE.equals("")) wednesdayE="혼자먹으세요 ㅠㅠ";
                if(wednesdayF.equals("")) wednesdayF="혼자먹으세요 ㅠㅠ";
                if(wednesdayG.equals("")) wednesdayG="혼자먹으세요 ㅠㅠ";
                if(thursdayA.equals("")) thursdayA="혼자먹으세요 ㅠㅠ";
                if(thursdayB.equals("")) thursdayB="혼자먹으세요 ㅠㅠ";
                if(thursdayC.equals("")) thursdayC="혼자먹으세요 ㅠㅠ";
                if(thursdayD.equals("")) thursdayD="혼자먹으세요 ㅠㅠ";
                if(thursdayF.equals("")) thursdayF="혼자먹으세요 ㅠㅠ";
                if(thursdayE.equals("")) thursdayE="혼자먹으세요 ㅠㅠ";
                if(thursdayG.equals("")) thursdayG="혼자먹으세요 ㅠㅠ";
                if(fridayA.equals("")) fridayA="혼자먹으세요 ㅠㅠ";
                if(fridayB.equals("")) fridayB="혼자먹으세요 ㅠㅠ";
                if(fridayC.equals("")) fridayC="혼자먹으세요 ㅠㅠ";
                if(fridayD.equals("")) fridayD="혼자먹으세요 ㅠㅠ";
                if(fridayE.equals("")) fridayE="혼자먹으세요 ㅠㅠ";
                if(fridayF.equals("")) fridayF="혼자먹으세요 ㅠㅠ";
                if(fridayG.equals("")) fridayG="혼자먹으세요 ㅠㅠ";

            }
            catch(Exception e)
            {
                e.printStackTrace();
            }


        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_schedule, container, false);
        btn=(Button)view.findViewById(R.id.classplusbtn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),Addclass.class);
                startActivity(intent);
            }
        });
        return view;
    }

  /*  public void onClick(View v) {

    }*/

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);


        }



    }


    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);

    }
}
