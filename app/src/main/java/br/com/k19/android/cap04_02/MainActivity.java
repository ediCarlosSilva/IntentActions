package br.com.k19.android.cap04_02;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        Button viewSiteButton = (Button) findViewById(R.id.view_site_button);
        Button sendEmailButton = (Button) findViewById(R.id.send_email_button);
        Button makeCallButton = (Button) findViewById(R.id.make_call_button);

        viewSiteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.
                    parse("http://k19.com.br"));
                startActivity(intent);
            }
        });

        sendEmailButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("plain/text");
                intent.putExtra(Intent.EXTRA_EMAIL,
                        new String[] { "contato@k19.com.br" });
                startActivity(Intent.createChooser(intent, "Enviar email"));
            }
        });

        makeCallButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL, Uri
                    .parse("tel: 2387-3781"));
                startActivity(intent);
            }
        });
    }
}
