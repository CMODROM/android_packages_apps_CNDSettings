
package com.codenamedroid.settings.activities;

import android.app.Activity;
import android.os.Bundle;
import android.preference.CheckBoxPreference;
import android.preference.Preference;
import android.preference.PreferenceFragment;
import android.preference.PreferenceScreen;
import android.provider.Settings;

import com.codenamedroid.settings.R;

public class Lockscreens extends Activity {
    private static final String PREF_MENU = "pref_lockscreen_menu_unlock";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getFragmentManager().beginTransaction().replace(android.R.id.content,
                new LockscreenPreferenceFragment()).commit();
    }

    public class LockscreenPreferenceFragment extends PreferenceFragment {

        private static final String PREF_MENU = "pref_lockscreen_menu_unlock";

        CheckBoxPreference menuButtonLocation;

        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);

            // Load the preferences from an XML resource
            addPreferencesFromResource(R.xml.prefs_lockscreens);

            menuButtonLocation = (CheckBoxPreference) findPreference(PREF_MENU);
            menuButtonLocation.setChecked(Settings.System.getInt(getActivity()
                    .getContentResolver(), Settings.System.LOCKSCREEN_ENABLE_MENU_KEY,
                    1) == 1);
        }

        @Override
        public boolean onPreferenceTreeClick(PreferenceScreen preferenceScreen,
                Preference preference) {
            if (preference == menuButtonLocation) {
                Settings.System.putInt(getActivity().getContentResolver(),
                        Settings.System.LOCKSCREEN_ENABLE_MENU_KEY,
                        ((CheckBoxPreference) preference).isChecked() ? 1 : 0);
                return true;
            }

            return super.onPreferenceTreeClick(preferenceScreen, preference);
        }

    }

}
