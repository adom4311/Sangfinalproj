package com.example.georg.sangfinalproj;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    private AlertDialog dialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final EditText idtext = (EditText)findViewById(R.id.idtext_main);
        final EditText pstext = (EditText)findViewById(R.id.passtext_main);
        final Button loginButton = (Button)findViewById(R.id.mainlogin);

        loginButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                final String userID = idtext.getText().toString();
                String userPassword = pstext.getText().toString();

                Response.Listener<String > responseListner = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try
                        {
                            JSONObject jsonResponse = new JSONObject(response);
                            boolean success = jsonResponse.getBoolean("success");
                            if(success){
                                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                                dialog = builder.setMessage("로그인에 성공했습니다.").setPositiveButton("확인",null).create();
                                dialog.show();
                                Intent intent = new Intent(MainActivity.this,accessActivity.class);
                                intent.putExtra("userID", userID);
                                MainActivity.this.startActivity(intent);
                                finish();
                            }
                            else
                            {
                                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                                dialog = builder.setMessage("계정을 다시 확인하세요.").setNegativeButton("확인",null).create();
                                dialog.show();
                            }
                        }
                        catch(Exception e)
                        {
                            e.printStackTrace();

                        }
                    }
                };
                LoginRequest loginRequest = new LoginRequest(userID, userPassword, responseListner);
                RequestQueue  quee = Volley.newRequestQueue(MainActivity.this);
                quee.add(loginRequest);
            }
        });
    }
    protected void onStop(){
        super.onStop();
        if(dialog != null)
        {
            dialog.dismiss();
            dialog=null;
        }
    }




    public void registerClick(View v)
    {
        Intent registerintent = new Intent(this,RegisterActivity.class);
        startActivity(registerintent);
    }




}
