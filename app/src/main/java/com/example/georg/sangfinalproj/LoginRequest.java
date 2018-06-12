package com.example.georg.sangfinalproj;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class LoginRequest extends StringRequest{
    final static private String URL = "http://adom4311.cafe24.com/UserLogin.php";
    private Map<String, String> parameters;

    public LoginRequest(String userID, String userPassword, Response.Listener<String> listenr){
        super(Method.POST, URL, listenr,null);
        parameters = new HashMap<>();
        parameters.put("userID",userID);
        parameters.put("userPassword",userPassword);

    }

    @Override
    protected Map<String, String> getParams()  {
        return parameters;
    }
}