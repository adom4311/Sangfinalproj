package com.example.georg.sangfinalproj;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

public class RegisterActivity extends AppCompatActivity {

    private String userID;
    private String userPasswrod;
    private AlertDialog dialog;
    private boolean validate =false;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);


        final EditText idtext = (EditText) findViewById(R.id.regidtext);
        final EditText passtext = (EditText) findViewById(R.id.regpasedit);
        Button validatebutton = (Button) findViewById(R.id.regdupcheck);
        validatebutton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                String userID=idtext.getText().toString();
                if(validate)
                {
                    return;
                }
                if(userID.equals(""))
                {
                    AlertDialog.Builder builder = new AlertDialog.Builder(RegisterActivity.this);
                    dialog= builder.setMessage("아이디는 빈 칸일 수 없습니다.")
                            .setPositiveButton("확인",null).create();
                    dialog.show();
                    return;
                }
                Response.Listener<String> responseListener = new Response.Listener<String>(){
                    public void onResponse(String response){
                        try
                        {
                            JSONObject jsonResponse = new JSONObject(response);
                            boolean success = jsonResponse.getBoolean("success");
                            if(success){
                                AlertDialog.Builder builder = new AlertDialog.Builder(RegisterActivity.this);
                                dialog= builder.setMessage("아이디를 사용할 수 있습니다.")
                                        .setPositiveButton("확인",null).create();
                                dialog.show();
                                idtext.setEnabled(false);
                                validate=true;


                            }
                            else
                            {
                                AlertDialog.Builder builder = new AlertDialog.Builder(RegisterActivity.this);
                                dialog= builder.setMessage("이 아이디를 사용할 수 없습니다.")
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
                ValidateRequest validateRequest = new ValidateRequest(userID,responseListener);
                RequestQueue queue = Volley.newRequestQueue(RegisterActivity.this);
                queue.add(validateRequest);
            }
        });
        Button registerButton =(Button)findViewById(R.id.registend);
        registerButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                String userID = idtext.getText().toString();
                String userPassword=passtext.getText().toString();

                if(!validate)
                {
                    AlertDialog.Builder builder = new AlertDialog.Builder(RegisterActivity.this);
                    dialog= builder.setMessage("먼저 중복 체크를 해주세요")
                            .setPositiveButton("확인",null).create();
                    dialog.show();
                    return ;
                }
                if(userID.equals("")||userPassword.equals(""))
                {
                    AlertDialog.Builder builder = new AlertDialog.Builder(RegisterActivity.this);
                    dialog= builder.setMessage("빈 칸 없이 입력해 주세요")
                            .setPositiveButton("확인",null).create();
                    dialog.show();
                    return ;
                }
                Response.Listener<String> responseListener = new Response.Listener<String>(){
                    public void onResponse(String response){
                        try
                        {
                            JSONObject jsonResponse = new JSONObject(response);
                            boolean success = jsonResponse.getBoolean("success");
                            if(success){
                                AlertDialog.Builder builder = new AlertDialog.Builder(RegisterActivity.this);
                                dialog= builder.setMessage("회원가입이 완료되었습니다.")
                                        .setPositiveButton("확인",null).create();
                                dialog.show();
                                idtext.setEnabled(false);
                                validate=true;
                                Intent newintent = new Intent(getApplicationContext(),MainActivity.class);
                                startActivity(newintent);



                            }
                            else
                            {
                                AlertDialog.Builder builder = new AlertDialog.Builder(RegisterActivity.this);
                                dialog= builder.setMessage("회원 등록에 실패했습니다.")
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
                RegisterRequest registerRequest = new RegisterRequest(userID,userPassword,responseListener);
                RequestQueue queue = Volley.newRequestQueue(RegisterActivity.this);
                queue.add(registerRequest);

            }
        });


    }

    @Override
    protected void onStop() {
        super.onStop();
        if(dialog!=null)
        {
            dialog.dismiss();
            dialog=null;
        }
    }
}
