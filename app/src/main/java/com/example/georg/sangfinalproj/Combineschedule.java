package com.example.georg.sangfinalproj;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.Environment;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;

public class Combineschedule extends Activity{
    private String monday[] = new String[7];
    private String tuesday[] = new String[7];
    private String wednesday[] = new String[7];
    private String thursday[] = new String[7];
    private String friday[] = new String[7];
    File file;

    Combineschedule()
    {
        for(int i=0;i<7;i++)
        {
            monday[i]="";
            tuesday[i]="";
            wednesday[i]="";
            thursday[i]="";
            friday[i]="";
        }
    }

    public void addschedule(String str, String id)
    {

        if(str.contains("월A"))
        {
            monday[0]+=id+"님 ";
        }
        if(str.contains("월B"))
        {
            monday[1]+=id+"님 ";
        }
        if(str.contains("월C"))
        {
            monday[2]+=id+"님 ";
        }
        if(str.contains("월D"))
        {
            monday[3]+=id+"님 ";
        }
        if(str.contains("월E"))
        {
            monday[4]+=id+"님 ";
        }
        if(str.contains("월F"))
        {
            monday[5]+=id+"님 ";
        }
        if(str.contains("월G"))
        {
            monday[6]+=id+"님 ";
        }


        if(str.contains("화A"))
        {
            tuesday[0]+=id+"님 ";
        }
        if(str.contains("화B"))
        {
            tuesday[1]+=id+"님 ";
        }
        if(str.contains("화C"))
        {
            tuesday[2]+=id+"님 ";
        }
        if(str.contains("화D"))
        {
            tuesday[3]+=id+"님 ";
        }
        if(str.contains("화E"))
        {
            tuesday[4]+=id+"님 ";
        }
        if(str.contains("화F"))
        {
            tuesday[5]+=id+"님 ";
        }
        if(str.contains("화G"))
        {
            tuesday[6]+=id+"님 ";
        }




        if(str.contains("수A"))
        {
            wednesday[0]+=id+"님 ";
        }
        if(str.contains("수B"))
        {
            wednesday[1]+=id+"님 ";
        }
        if(str.contains("수C"))
        {
            wednesday[2]+=id+"님 ";
        }
        if(str.contains("수D"))
        {
            wednesday[3]+=id+"님 ";
        }
        if(str.contains("수E"))
        {
            wednesday[4]+=id+"님 ";
        }
        if(str.contains("수F"))
        {
            wednesday[5]+=id+"님 ";
        }
        if(str.contains("수G"))
        {
            wednesday[6]+=id+"님 ";
        }
        if(str.contains("목A"))
        {
            thursday[0]+=id+"님 ";
        }
        if(str.contains("목B"))
        {
            thursday[1]+=id+"님 ";
        }
        if(str.contains("목C"))
        {
            thursday[2]+=id+"님 ";
        }
        if(str.contains("목D"))
        {
            thursday[3]+=id+"님 ";
        }
        if(str.contains("목E"))
        {
            thursday[4]+=id+"님 ";
        }
        if(str.contains("목F"))
        {
            thursday[5]+=id+"님 ";
        }
        if(str.contains("목G"))
        {
            thursday[6]+=id+"님 ";
        }
        if(str.contains("금A"))
        {
            friday[0]+=id+"님 ";
        }
        if(str.contains("금B"))
        {
            friday[1]+=id+"님 ";
        }
        if(str.contains("금C"))
        {
            friday[2]+=id+"님 ";
        }
        if(str.contains("금D"))
        {
            friday[3]+=id+"님 ";
        }
        if(str.contains("금E"))
        {
            friday[4]+=id+"님 ";
        }
        if(str.contains("금F"))
        {
            friday[5]+=id+"님 ";
        }
        if(str.contains("금G"))
        {
            friday[6]+=id+"님 ";
        }
    }
    public void outputschedule(Context context)
    {
     /*   String inputData = tuesday[1];
        String filename = "text.txt";

        String state = Environment.getExternalStorageState();
        if(state.equals(Environment.MEDIA_MOUNTED)==false)
        {
            Toast.makeText(this,"외부실패",Toast.LENGTH_SHORT).show();
        }
        File file = new File(getExternalFilesDir(null), filename);
        try
        {
            OutputStream os = new FileOutputStream(file);
            os.write(inputData.getBytes());
            os.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }*/
        String answer="";
        Dialog dialog;
        answer="월, 화, 수, 목, 금\n";
        for(int i=0;i<7;i++)
        {
            answer+=monday[i]+", "+tuesday[i]+", "+wednesday[i]+", "+thursday[i]+", "+friday[i]+"\n";
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        dialog = builder.setMessage(answer).setPositiveButton("확인",null).create();
        dialog.show();


    }

    public void clearschedule()
    {
        for(int i=0;i<7;i++)
        {
            monday[i]="";
            tuesday[i]="";
            wednesday[i]="";
            thursday[i]="";
            friday[i]="";
        }
    }

}
