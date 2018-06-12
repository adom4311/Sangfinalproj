package com.example.georg.sangfinalproj;

import android.content.Context;
import android.widget.TextView;

public class Schedule {

    private String monday[] = new String[7];
    private String tuesday[] = new String[7];
    private String wednesday[] = new String[7];
    private String thursday[] = new String[7];
    private String friday[] = new String[7];

    public Schedule()
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

    public void addSchedule(String scheduleText)
    {
        int temp;
        String tempst;
        for(int i=0;i<scheduleText.length();i++)
        {
            if(scheduleText.charAt(i)=='월')
            {
                i=i+1;
                switch (scheduleText.charAt(i))
                {
                    case 'A':
                        monday[0]="수업";
                        break;
                    case 'B':
                        monday[1]="수업";
                        break;
                    case 'C':
                        monday[2]="수업";
                        break;
                    case 'D':
                        monday[3]="수업";
                        break;
                    case 'E':
                        monday[4]="수업";
                        break;
                    case 'F':
                        monday[5]="수업";
                        break;
                    case 'G':
                        monday[6]="수업";
                        break;

                }
            }
            else if(scheduleText.charAt(i)=='화')
            {
                i=i+1;
                switch (scheduleText.charAt(i))
                {
                    case 'A':
                        tuesday[0]="수업";
                        break;
                    case 'B':
                        tuesday[1]="수업";
                        break;
                    case 'C':
                        tuesday[2]="수업";
                        break;
                    case 'D':
                        tuesday[3]="수업";
                        break;
                    case 'E':
                        tuesday[4]="수업";
                        break;
                    case 'F':
                        tuesday[5]="수업";
                        break;
                    case 'G':
                        tuesday[6]="수업";
                        break;

                }
            }
            else if(scheduleText.charAt(i)=='수')
            {
                i=i+1;
                switch (scheduleText.charAt(i))
                {
                    case 'A':
                        wednesday[0]="수업";
                        break;
                    case 'B':
                        wednesday[1]="수업";
                        break;
                    case 'C':
                        wednesday[2]="수업";
                        break;
                    case 'D':
                        wednesday[3]="수업";
                        break;
                    case 'E':
                        wednesday[4]="수업";
                        break;
                    case 'F':
                        wednesday[5]="수업";
                        break;
                    case 'G':
                        wednesday[6]="수업";
                        break;

                }
            }
            else if(scheduleText.charAt(i)=='목')
            {
                i=i+1;
                switch (scheduleText.charAt(i))
                {
                    case 'A':
                        thursday[0]="수업";
                        break;
                    case 'B':
                        thursday[1]="수업";
                        break;
                    case 'C':
                        thursday[2]="수업";
                        break;
                    case 'D':
                        thursday[3]="수업";
                        break;
                    case 'E':
                        thursday[4]="수업";
                        break;
                    case 'F':
                        thursday[5]="수업";
                        break;
                    case 'G':
                        thursday[6]="수업";
                        break;

                }
            }
            else if(scheduleText.charAt(i)=='금')
            {
                i=i+1;
                switch (scheduleText.charAt(i))
                {
                    case 'A':
                        friday[0]="수업";
                        break;
                    case 'B':
                        friday[1]="수업";
                        break;
                    case 'C':
                        friday[2]="수업";
                        break;
                    case 'D':
                        friday[3]="수업";
                        break;
                    case 'E':
                        friday[4]="수업";
                        break;
                    case 'F':
                        friday[5]="수업";
                        break;
                    case 'G':
                        friday[6]="수업";
                        break;

                }
            }

        }
    }
    public boolean validate(String scheduleText) {
        if (scheduleText.equals("")) {
            return true;
        }
        for (int i = 0; i < scheduleText.length(); i++) {
            if (scheduleText.charAt(i) == '월') {
                i=i+1;
                switch (scheduleText.charAt(i)) {
                    case 'A':
                        if (monday[0] == "수업")
                            return false;
                    case 'B':
                        if (monday[1] == "수업")
                            return false;
                    case 'C':
                        if (monday[2] == "수업")
                            return false;
                    case 'D':
                        if (monday[3] == "수업")
                            return false;
                    case 'E':
                        if (monday[4] == "수업")
                            return false;
                    case 'F':
                        if (monday[5] == "수업")
                            return false;
                    case 'G':
                        if (monday[6] == "수업")
                            return false;

                }
            } else if (scheduleText.charAt(i) == '화') {
                i=i+1;
                switch (scheduleText.charAt(i)) {
                    case 'A':
                        if (tuesday[0] == "수업")
                            return false;
                    case 'B':
                        if (tuesday[1] == "수업")
                            return false;
                    case 'C':
                        if (tuesday[2] == "수업")
                            return false;
                    case 'D':
                        if (tuesday[3] == "수업")
                            return false;
                    case 'E':
                        if (tuesday[4] == "수업")
                            return false;
                    case 'F':
                        if (tuesday[5] == "수업")
                            return false;
                    case 'G':
                        if (tuesday[6] == "수업")
                            return false;
                }
            }
            else if (scheduleText.charAt(i) == '수') {
                i=i+1;
                switch (scheduleText.charAt(i)) {
                    case 'A':
                        if (wednesday[0] == "수업")
                            return false;
                    case 'B':
                        if (wednesday[1] == "수업")
                            return false;
                    case 'C':
                        if (wednesday[2] == "수업")
                            return false;
                    case 'D':
                        if (wednesday[3] == "수업")
                            return false;
                    case 'E':
                        if (wednesday[4] == "수업")
                            return false;
                    case 'F':
                        if (wednesday[5] == "수업")
                            return false;
                    case 'G':
                        if (wednesday[6] == "수업")
                            return false;

                }
            }
            else if (scheduleText.charAt(i) == '목') {
                i=i+1;
                switch (scheduleText.charAt(i)) {
                    case 'A':
                        if (thursday[0] == "수업")
                            return false;
                    case 'B':
                        if (thursday[1] == "수업")
                            return false;
                    case 'C':
                        if (thursday[2] == "수업")
                            return false;
                    case 'D':
                        if (thursday[3] == "수업")
                            return false;
                    case 'E':
                        if (thursday[4] == "수업")
                            return false;
                    case 'F':
                        if (thursday[5] == "수업")
                            return false;
                    case 'G':
                        if (thursday[6] == "수업")
                            return false;
                }
            }
            else if (scheduleText.charAt(i) == '금') {
                i=i+1;
                switch (scheduleText.charAt(i)) {
                    case 'A':
                        if (friday[0] == "수업")
                            return false;
                    case 'B':
                        if (friday[1] == "수업")
                            return false;
                    case 'C':
                        if (friday[2] == "수업")
                            return false;
                    case 'D':
                        if (friday[3] == "수업")
                            return false;
                    case 'E':
                        if (friday[4] == "수업")
                            return false;
                    case 'F':
                        if (friday[5] == "수업")
                            return false;
                    case 'G':
                        if (friday[6] == "수업")
                            return false;

                }
            }
        }
        return true;
    }

    public void addSchedule(String scheduleText, String courseTitle, String courseProfessor)
    {
        int temp;
        String tempst;
        String professor;
        if(courseProfessor.equals(""))
        {
            professor = "";
        }
        else
        {
            professor="("+courseProfessor+")";
        }
        for(int i=0;i<scheduleText.length();i++)
        {
            if(scheduleText.charAt(i)=='월')
            {
                i=i+1;
                System.out.println("월요일에 걸렸어");
                switch (scheduleText.charAt(i))
                {
                    case 'A':
                        monday[0]=courseTitle + professor;
                        break;
                    case 'B':
                        monday[1]=courseTitle + professor;
                        break;
                    case 'C':
                        monday[2]=courseTitle + professor;
                        break;
                    case 'D':
                        monday[3]=courseTitle + professor;
                        break;
                    case 'E':
                        monday[4]=courseTitle + professor;
                        break;
                    case 'F':
                        monday[5]=courseTitle + professor;
                        break;
                    case 'G':
                        monday[6]=courseTitle + professor;
                        break;

                }
            }
            else if(scheduleText.charAt(i)=='화')
            {
                i=i+1;
                switch (scheduleText.charAt(i))
                {
                    case 'A':
                        tuesday[0]=courseTitle + professor;
                        break;
                    case 'B':
                        tuesday[1]=courseTitle + professor;
                        break;
                    case 'C':
                        tuesday[2]=courseTitle + professor;
                        break;
                    case 'D':
                        tuesday[3]=courseTitle + professor;
                        break;
                    case 'E':
                        tuesday[4]=courseTitle + professor;
                        break;
                    case 'F':
                        tuesday[5]=courseTitle + professor;
                        break;
                    case 'G':
                        tuesday[6]=courseTitle + professor;
                        break;

                }
            }
            else if(scheduleText.charAt(i)=='수')
            {
                i=i+1;
                switch (scheduleText.charAt(i))
                {
                    case 'A':
                        wednesday[0]=courseTitle + professor;
                        break;
                    case 'B':
                        wednesday[1]=courseTitle + professor;
                        break;
                    case 'C':
                        wednesday[2]=courseTitle + professor;
                        break;
                    case 'D':
                        wednesday[3]=courseTitle + professor;
                        break;
                    case 'E':
                        wednesday[4]=courseTitle + professor;
                        break;
                    case 'F':
                        wednesday[5]=courseTitle + professor;
                        break;
                    case 'G':
                        wednesday[6]=courseTitle + professor;
                        break;

                }
            }
            else if(scheduleText.charAt(i)=='목')
            {
                i=i+1;
                switch (scheduleText.charAt(i))
                {
                    case 'A':
                        thursday[0]=courseTitle + professor;
                        break;
                    case 'B':
                        thursday[1]=courseTitle + professor;
                        break;
                    case 'C':
                        thursday[2]=courseTitle + professor;
                        break;
                    case 'D':
                        thursday[3]=courseTitle + professor;
                        break;
                    case 'E':
                        thursday[4]=courseTitle + professor;
                        break;
                    case 'F':
                        thursday[5]=courseTitle + professor;
                        break;
                    case 'G':
                        thursday[6]=courseTitle + professor;
                        break;

                }
            }
            else if(scheduleText.charAt(i)=='금')
            {
                i=i+1;
                switch (scheduleText.charAt(i))
                {
                    case 'A':
                        friday[0]=courseTitle + professor;
                        break;
                    case 'B':
                        friday[1]=courseTitle + professor;
                        break;
                    case 'C':
                        friday[2]=courseTitle + professor;
                        break;
                    case 'D':
                        friday[3]=courseTitle + professor;
                        break;
                    case 'E':
                        friday[4]=courseTitle + professor;
                        break;
                    case 'F':
                        friday[5]=courseTitle + professor;
                        break;
                    case 'G':
                        friday[6]=courseTitle + professor;
                        break;

                }
            }

        }
    }

    public void setting(AutoResizeTextView[] monday, AutoResizeTextView[] tuesday, AutoResizeTextView[] wednesday, AutoResizeTextView[] thursday, AutoResizeTextView[] friday ,Context context)
    {
        int maxLength =0;
        String maxString="";
        for(int i=0;i<7;i++)
        {
            if(this.monday[i].length()>maxLength)
            {
                maxLength=this.monday[i].length();
                maxString=this.monday[i];
            }
            if(this.tuesday[i].length()>maxLength)
            {
                maxLength=this.tuesday[i].length();
                maxString=this.tuesday[i];
            }
            if(this.wednesday[i].length()>maxLength)
            {
                maxLength=this.wednesday[i].length();
                maxString=this.wednesday[i];
            }
            if(this.thursday[i].length()>maxLength)
            {
                maxLength=this.thursday[i].length();
                maxString=this.thursday[i];
            }
            if(this.friday[i].length()>maxLength)
            {
                maxLength=this.friday[i].length();
                maxString=this.friday[i];
            }
        }
        for(int i=0;i<7;i++)
        {
            if(!this.monday[i].equals(""))
            {
                monday[i].setText(this.monday[i]);
                monday[i].setBackgroundColor(context.getResources().getColor(R.color.colorPrimary));
                monday[i].setTextColor(context.getResources().getColor(R.color.colorlightwhite));
            }
            else
            {
                monday[i].setText(maxString);
            }
            if(!this.tuesday[i].equals(""))
            {
                tuesday[i].setText(this.tuesday[i]);
                tuesday[i].setBackgroundColor(context.getResources().getColor(R.color.colorPrimary));
                tuesday[i].setTextColor(context.getResources().getColor(R.color.colorlightwhite));
            }
            else
            {
                tuesday[i].setText(maxString);
            }
            if(!this.wednesday[i].equals(""))
            {
                wednesday[i].setText(this.wednesday[i]);
                wednesday[i].setBackgroundColor(context.getResources().getColor(R.color.colorPrimary));
                wednesday[i].setTextColor(context.getResources().getColor(R.color.colorlightwhite));
            }
            else
            {
                wednesday[i].setText(maxString);
            }
            if(!this.thursday[i].equals(""))
            {
                thursday[i].setText(this.thursday[i]);
                thursday[i].setBackgroundColor(context.getResources().getColor(R.color.colorPrimary));
                thursday[i].setTextColor(context.getResources().getColor(R.color.colorlightwhite));
            }
            else
            {
                thursday[i].setText(maxString);
            }
            if(!this.friday[i].equals(""))
            {
                friday[i].setText(this.friday[i]);
                friday[i].setBackgroundColor(context.getResources().getColor(R.color.colorPrimary));
                friday[i].setTextColor(context.getResources().getColor(R.color.colorlightwhite));
            }
            else
            {
                friday[i].setText(maxString);
            }
           /* monday[i].resizeText();
            tuesday[i].resizeText();
            wednesday[i].resizeText();
            thursday[i].resizeText();
            friday[i].resizeText();*/



        }
    }
}
