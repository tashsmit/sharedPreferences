package tashsmit.c4q.nyc.donow0711;

import android.os.Bundle;
import android.preference.PreferenceActivity;
import android.preference.PreferenceManager;

/**
 * Created by c4q-tashasmith on 7/11/15.
 */
public class shared_pref extends PreferenceActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.preferences);
        PreferenceManager.setDefaultValues(shared_pref.this, R.xml.preferences, false);
    }
}
