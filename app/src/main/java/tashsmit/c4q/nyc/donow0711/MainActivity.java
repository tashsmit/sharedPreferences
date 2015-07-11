package tashsmit.c4q.nyc.donow0711;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.preference.PreferenceManager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity {

    private TextView loremText;
    private Button setPref;
    private String fontSize;
    private boolean bold;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        PreferenceManager.setDefaultValues(this, R.xml.preferences, false);
        setContentView(R.layout.activity_main);

        //initialize views
        loremText = (TextView) findViewById(R.id.loremText);
        setPref = (Button) findViewById(R.id.preferences);

        setPref.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(getApplicationContext(), shared_pref.class);
                startActivity(i);
            }
        });
    }

    @Override
    public void onResume() {
        super.onResume();
        //get shared preferences
        SharedPreferences _sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
        fontSize = _sharedPreferences.getString("fontSize", "20");
        bold = _sharedPreferences.getBoolean("bold", false);

        if (fontSize != null) {
            loremText.setTextSize(Float.parseFloat(fontSize));
        }

        if (bold) {
            loremText.setTypeface(Typeface.SANS_SERIF,Typeface.BOLD_ITALIC);
        }
        else {
            loremText.setTypeface(null);
        }

    }
}
