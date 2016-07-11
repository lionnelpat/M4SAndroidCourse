package lionnel.mobilesenegal.sn.menuproject;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        Button Btn_SMS          = (Button) findViewById(R.id.bt_sms);
        Button Btn_PHONE        = (Button) findViewById(R.id.bt_phone);
        Button Btn_WEB          = (Button) findViewById(R.id.bt_web);
        Button Btn_MAP          = (Button) findViewById(R.id.bt_map);
        Button Btn_SHARE        = (Button) findViewById(R.id.bt_share);
        Button Btn_NEW_ACTIVITY = (Button) findViewById(R.id.bt_new_activity);

        Btn_SMS.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                sendSMS();
            }
        });

        Btn_PHONE.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                CALL();
            }
        });

        Btn_WEB.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                WEB();
            }
        });

        Btn_MAP.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                MAP();
            }
        });

        Btn_SHARE.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                    SHARE();
            }
        });

        Btn_NEW_ACTIVITY.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                ShowActivity();
            }
        });
    }



    /*--- Send SMS methods -- */

    protected void sendSMS() {
        Log.i("Send SMS", "");
        Intent smsIntent = new Intent(Intent.ACTION_VIEW);

        smsIntent.setData(Uri.parse("smsto:"));
        smsIntent.setType("vnd.android-dir/mms-sms");
        smsIntent.putExtra("address"  , new String ("+221705842612"));
        smsIntent.putExtra("sms_body"  , "Lionnel Patrick DOOKO ");

        try {
            startActivity(smsIntent);
            finish();
            Log.i("Envoi SMS termine...", "");
        }
        catch (android.content.ActivityNotFoundException ex) {
            Toast.makeText(MainActivity.this,
                    "Echec d'envoi SMS, essayer encore SVP.", Toast.LENGTH_SHORT).show();
        }
    }

    protected void CALL() {
        Log.i("Phone Call", "");
        Intent phoneIntent = new Intent(Intent.ACTION_DIAL);

        phoneIntent.setData(Uri.parse("tel:705842612"));

        try {
            startActivity(phoneIntent);
            finish();
            Log.i("Appel termine...", "");
        }
        catch (android.content.ActivityNotFoundException ex) {
            Toast.makeText(MainActivity.this,
                    "Echec d'appel, essayer encore SVP.", Toast.LENGTH_SHORT).show();
        }
    }

    protected void WEB() {
        Log.i("WEB browser", "");
        Intent webIntent = new Intent(Intent.ACTION_VIEW);

        webIntent.setData(Uri.parse("http://www.enseignemoi.com/bible/"));

        try {
            startActivity(webIntent);
            finish();
            Log.i("Page web lancee...", "");
        }
        catch (android.content.ActivityNotFoundException ex) {
            Toast.makeText(MainActivity.this,
                    "Echec , essayer encore SVP.", Toast.LENGTH_SHORT).show();
        }
    }

    protected void MAP() {
        Log.i("MAP google", "");
        String mapUri = String.format("geo:14.706441, -17.457477");
        Uri geo = Uri.parse(mapUri);
        Intent mapIntent = new Intent(Intent.ACTION_VIEW, geo);

        try {
            startActivity(mapIntent);
            finish();
            Log.i("google map ...", "");
        }
        catch (android.content.ActivityNotFoundException ex) {
            Toast.makeText(MainActivity.this,
                    "Echec , essayer encore SVP.", Toast.LENGTH_SHORT).show();
        }
    }

    protected void SHARE() {
        Log.i("Share Apps", "");
        Intent shareIntent = new Intent(Intent.ACTION_SEND);
        shareIntent.setType("text/plain");
        shareIntent.putExtra(Intent.EXTRA_SUBJECT,"lionnel");
        shareIntent.putExtra(Intent.EXTRA_TEXT, "Join us on ");

        try {
            startActivity(Intent.createChooser(shareIntent,"Share the Love"));
            finish();
            Log.i("Share apps ...", "");
        }
        catch (android.content.ActivityNotFoundException ex) {
            Toast.makeText(MainActivity.this,
                    "Echec , essayer encore SVP.", Toast.LENGTH_SHORT).show();
        }
    }

    protected void ShowActivity() {
        Log.i("Show New Activity", "");
        Intent intent = new Intent(this,NewActivity.class);

        try {
            startActivity(intent);
            finish();
            Log.i("Share apps ...", "");
        }
        catch (android.content.ActivityNotFoundException ex) {
            Toast.makeText(MainActivity.this,
                    "Echec , essayer encore SVP.", Toast.LENGTH_SHORT).show();
        }
    }

    protected void HelpActivity() {
        Log.i("Show Help Activity", "");
        Intent intent = new Intent(this,HelpActivity.class);

        try {
            startActivity(intent);
            finish();
            Log.i("Help Activity ...", "");
        }
        catch (android.content.ActivityNotFoundException ex) {
            Toast.makeText(MainActivity.this,
                    "Echec , essayer encore SVP.", Toast.LENGTH_SHORT).show();
        }
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            Toast T = Toast.makeText(this, "MENU",Toast.LENGTH_LONG);
            T.show();
            return true;
        }

        if (id == R.id.action_help) {

            HelpActivity();

            Toast T = Toast.makeText(this, "HELP",Toast.LENGTH_LONG);
            T.show();
            return true;
        }



        return super.onOptionsItemSelected(item);
    }


    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    protected void onPostResume() {
        super.onPostResume();
    }

}

