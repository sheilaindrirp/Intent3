package id.sch.smktelkom_mlg.learn.intent3;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //TELEPON
        findViewById(R.id.imageViewPhone).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialPhoneNumber("085733573529");
            }
        });

        //SMS
        findViewById(R.id.imageViewSMS).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                composeSmsMessage("Pesan dari SMK Telkom Malanng");
            }
        });
    }

    //Fungsi TELEPON
    public void dialPhoneNumber(String phoneNumber) {
        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:" + phoneNumber));
        if (intent.resolveActivity(getPackageManager()) != null) startActivity(intent);
    }

    //FUNGSI SMS
    public void composeSmsMessage(String message) {
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra("sms_body", message);
        if (intent.resolveActivity(getPackageManager()) != null) startActivity(intent);
    }
}
