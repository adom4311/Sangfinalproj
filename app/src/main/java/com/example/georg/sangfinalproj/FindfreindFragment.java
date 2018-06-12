package com.example.georg.sangfinalproj;

import android.content.Context;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link FindfreindFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link FindfreindFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FindfreindFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public FindfreindFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FindfreindFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static FindfreindFragment newInstance(String param1, String param2) {
        FindfreindFragment fragment = new FindfreindFragment();
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

    private ArrayList<Friend> frdLIst;
    private ListView listView;
    private FriendListAdapter adapter;
    public ArrayList<String> friendstring=new ArrayList<>();
    Combineschedule combineschedule = new Combineschedule();
    ImageButton imageButton;
    String tempid;


    public void onActivityCreated(Bundle b) {

        super.onActivityCreated(b);
        listView=(ListView)getView().findViewById(R.id.friendListview);
        frdLIst=new ArrayList<>();
        imageButton=(ImageButton)getView().findViewById(R.id.combinestartbtn);


        frdLIst.add(new Friend("백상"));
        new BackgroundTask().execute();



        adapter = new FriendListAdapter(getActivity(),frdLIst);
        listView.setAdapter(adapter);

        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

              new BackgroundTaskcombine().execute();
              new BackgroundTaskcombine2().execute();
              new BackgroundTaskcombine3().execute();
              new BackgroundTaskcombine4().execute();


            }
        });





    }



    class BackgroundTask extends AsyncTask<Void, Void, String>
    {

        String target;

        @Override
        public void onPreExecute() {
            target="http://adom4311.cafe24.com/userfriend.php?userID="+accessActivity.userID;


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
                String friend;
                while(count<jsonArray.length())
                {
                    JSONObject object = jsonArray.getJSONObject(count);
                    friend = object.getString("userID");

                    frdLIst.add(new Friend(friend));
                    System.out.println(friend);
                    adapter.notifyDataSetChanged();
                    count++;
                }
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
        }
    }




    class BackgroundTaskcombine extends AsyncTask<Void, Void, String>
    {

        String target;

        @Override
        public void onPreExecute() {
            target="http://adom4311.cafe24.com/combineschedule.php?userID="+accessActivity.friendstring.get(0);


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

                String courseTime;

                while(count<jsonArray.length())
                {
                    JSONObject object = jsonArray.getJSONObject(count);
                     courseTime = object.getString("courseTime");
                     System.out.println(tempid);
                     combineschedule.addschedule(courseTime,accessActivity.friendstring.get(0));


                    count++;
                }


            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
        }
    }

    class BackgroundTaskcombine2 extends AsyncTask<Void, Void, String>
    {

        String target;

        @Override
        public void onPreExecute() {
            target="http://adom4311.cafe24.com/combineschedule.php?userID="+accessActivity.friendstring.get(1);


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

                String courseTime;

                while(count<jsonArray.length())
                {
                    JSONObject object = jsonArray.getJSONObject(count);
                    courseTime = object.getString("courseTime");
                    System.out.println(tempid);
                    combineschedule.addschedule(courseTime,accessActivity.friendstring.get(1));


                    count++;
                }

            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
        }
    }

    class BackgroundTaskcombine3 extends AsyncTask<Void, Void, String>
    {

        String target;

        @Override
        public void onPreExecute() {
            if(accessActivity.friendstring.size()<3)
            {
                target="http://adom4311.cafe24.com/combineschedule.php";
            }
            else
            {
                target="http://adom4311.cafe24.com/combineschedule.php?userID="+accessActivity.friendstring.get(2);

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

                String courseTime;

                while(count<jsonArray.length())
                {
                    JSONObject object = jsonArray.getJSONObject(count);
                    courseTime = object.getString("courseTime");
                    System.out.println(tempid);
                    combineschedule.addschedule(courseTime,accessActivity.friendstring.get(2));


                    count++;
                }

            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
        }
    }
    class BackgroundTaskcombine4 extends AsyncTask<Void, Void, String>
    {

        String target;

        @Override
        public void onPreExecute() {
            if(accessActivity.friendstring.size()<4)
            {
                target="http://adom4311.cafe24.com/combineschedule.php";
            }
            else
            {
                target="http://adom4311.cafe24.com/combineschedule.php?userID="+accessActivity.friendstring.get(3);

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

                String courseTime;

                while(count<jsonArray.length())
                {
                    JSONObject object = jsonArray.getJSONObject(count);
                    courseTime = object.getString("courseTime");
                    System.out.println(tempid);
                    combineschedule.addschedule(courseTime,accessActivity.friendstring.get(3));


                    count++;
                }
                combineschedule.outputschedule(getContext());
                combineschedule.clearschedule();

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
        return inflater.inflate(R.layout.fragment_findfreind, container, false);
    }

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
