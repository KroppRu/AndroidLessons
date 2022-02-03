package ru.kropp.lesson073preferencesenable;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.preference.CheckBoxPreference;
import android.preference.Preference;
import android.preference.PreferenceActivity;
import android.preference.PreferenceCategory;
import android.preference.PreferenceScreen;

public class PrefActivity extends PreferenceActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        CheckBoxPreference chb3;
        PreferenceCategory categ2;
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.pref);

        chb3 = (CheckBoxPreference) findPreference("chb3");
        categ2  = (PreferenceCategory) findPreference("categ2");
        categ2.setEnabled(chb3.isChecked());

        chb3.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
            @Override
            public boolean onPreferenceClick(Preference preference) {
                categ2.setEnabled(((CheckBoxPreference)preference).isChecked());
                return false;
            }
        });
    }
}