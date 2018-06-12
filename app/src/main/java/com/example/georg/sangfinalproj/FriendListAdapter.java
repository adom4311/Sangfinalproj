package com.example.georg.sangfinalproj;


import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

import java.util.List;

public class FriendListAdapter extends BaseAdapter{

    private Context context;
    private List<Friend> friendList;

    public FriendListAdapter(Context context, List<Friend> freindlist) {
        this.context = context;
        this.friendList = freindlist;
    }

    @Override
    public int getCount() {
        return friendList.size();
    }

    @Override
    public Object getItem(int position) {
        return friendList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        View v = View.inflate(context, R.layout.friend,null);
        final TextView nameText = (TextView)v.findViewById(R.id.friendtext);
        nameText.setText(friendList.get(position).getName());
        CheckBox checkBox = (CheckBox) v.findViewById(R.id.friendRadio);
        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked)
                {
                    accessActivity.friendstring.add(friendList.get(position).getName());
                    for(int i=0;i<accessActivity.friendstring.size();i++)
                    {
                        System.out.println(accessActivity.friendstring.get(i));
                    }

                }
                else
                {
                    for(int i=0;i<accessActivity.friendstring.size();i++)
                    {
                        if(accessActivity.friendstring.get(i).equals(friendList.get(position).getName()))
                        {
                            accessActivity.friendstring.remove(i);
                            break;
                        }
                    }

                }

            }
        });
        Button button = (Button)v.findViewById(R.id.friendschedulebtn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context,Firendschedule.class);
                intent.putExtra("userID",friendList.get(position).getName());
                context.startActivity(intent);

            }
        });







        return v;
    }
}
