package com.example.application.kisan;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

/**
 * Created by HP on 13-03-2018.
 */

public class helpdesk1 extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.helpdesk);
        ImageView img1 = findViewById(R.id.phn1);
        int id = getTaskId();
        //if(id == R.id.phn1 )
        img1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:7042033397"));
                startActivity(intent);
            }

        });
        ImageView img2 = findViewById(R.id.msg1);
        img2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri uri = Uri.parse("smsto:12346556");
                Intent it = new Intent(Intent.ACTION_SENDTO, uri);
                it.putExtra("sms_body", "Here you can set the SMS text to be sent");
                startActivity(it);
            }

        });
        ImageView img3 = findViewById(R.id.mail1);
        img3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String to = "test@gmail.com";
                String subject= "Hi I am subject";
                String body="Hi I am test body";
                String mailTo = "mailto:" + to +
                        "?&subject=" + Uri.encode(subject) +
                        "&body=" + Uri.encode(body);
                Intent emailIntent = new Intent(Intent.ACTION_VIEW);
                emailIntent.setData(Uri.parse(mailTo));
                startActivity(emailIntent);
            }

        });

    }
}
