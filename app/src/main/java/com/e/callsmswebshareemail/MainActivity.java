package com.e.callsmswebshareemail;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void call(View view) {
       // Toast.makeText(this, "Calling Demo", Toast.LENGTH_SHORT).show();
        Intent i1=new Intent();
        i1.setAction(Intent.ACTION_CALL); // what to do
        i1.setData(Uri.parse("tel:7893515868"));
        startActivity(i1); // firing intent
    }

    public void sms(View view) {
        //Toast.makeText(this, "SMS", Toast.LENGTH_SHORT).show();
        Intent i2=new Intent();
        i2.setAction(Intent.ACTION_SENDTO);
        i2.setData(Uri.parse("smsto:7893515868"));
        i2.putExtra("sms_body","This is for you.........."); // text message
        startActivity(i2);
    }

    public void web(View view) {
        Intent i3=new Intent();
        i3.setAction(Intent.ACTION_VIEW);
        i3.setData(Uri.parse("https://www.google.com"));
        startActivity(i3);
    }

    public void share(View view) {
        Intent i=new Intent();
        i.setAction(Intent.ACTION_SEND);
        i.setType("text/plain");
        i.putExtra(Intent.EXTRA_TEXT,"This is for sharing via  any app......");
        startActivity(Intent.createChooser(i,"Edu Dmoe App"));
    }

    public void email(View view) {
        Intent e=new Intent();
        e.setAction(Intent.ACTION_SEND);
        e.setType("message/rfc822");
        String[] to={"ios.shashank@gmail.com","androidjavashashank@gmail.com"};
        String[] cc={"ios.shashank@gmail.com","androidjavashashank@gmail.com"};
        String[] bcc={"ios.shashank@gmail.com","androidjavashashank@gmail.com"};
        String subject="Come to Birthday";
        String body="Come with gift or dont come";
        e.putExtra(Intent.EXTRA_EMAIL,to);
        e.putExtra(Intent.EXTRA_CC,cc);
        e.putExtra(Intent.EXTRA_BCC,bcc);
        e.putExtra(Intent.EXTRA_SUBJECT,subject);
        e.putExtra(Intent.EXTRA_TEXT,body);
        startActivity(Intent.createChooser(e,"My Mail App"));


    }
}