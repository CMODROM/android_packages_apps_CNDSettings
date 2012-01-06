
package com.codenamedroid.settings.activities;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.RemoteException;
import android.os.ServiceManager;
import android.preference.CheckBoxPreference;
import android.preference.ListPreference;
import android.preference.Preference;
import android.preference.Preference.OnPreferenceChangeListener;
import android.preference.PreferenceFragment;
import android.preference.PreferenceGroup;
import android.preference.PreferenceScreen;
import android.provider.Settings;
import android.text.Spannable;
import android.view.IWindowManager;
import android.widget.EditText;

import com.codenamedroid.settings.R;

public class MiscSettings extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getFragmentManager().beginTransaction().replace(android.R.id.content,
                new MiscSettingsPreferences()).commit();
    }

    public static class MiscSettingsPreferences extends PreferenceFragment {

        private static final String PREF_CRT_OFF = "crt_off";
        private static final String PREF_CUSTOM_CARRIER_LABEL = "custom_carrier_label";

        CheckBoxPreference mCrtOffAnimation;
        CheckBoxPreference mShowImeSwitcher;
        Preference mCustomLabel;

        String mCustomLabelText = null;

        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            // Load the preferences from an XML resource
            addPreferencesFromResource(R.xml.prefs_ui);

            PreferenceScreen prefs = getPreferenceScreen();

            mCrtOffAnimation = (CheckBoxPreference) findPreference(PREF_CRT_OFF);
            mCrtOffAnimation.setChecked(Settings.System.getInt(getActivity().getContentResolver(),
                    Settings.System.CRT_OFF_ANIMATION, 1) == 1);

            mCustomLabel = findPreference(PREF_CUSTOM_CARRIER_LABEL);
            updateCustomLabelTextSummary();

        }

        private void updateCustomLabelTextSummary() {
            mCustomLabelText = Settings.System.getString(getActivity().getContentResolver(),
                    Settings.System.CUSTOM_CARRIER_LABEL);
            if (mCustomLabelText == null) {
                mCustomLabel
                        .setSummary("Once set a reboot is required");
            } else {
                mCustomLabel.setSummary(mCustomLabelText);
            }

        }

        @Override
        public boolean onPreferenceTreeClick(PreferenceScreen preferenceScreen,
                Preference preference) {
            if (preference == mCrtOffAnimation) {

                boolean checked = ((CheckBoxPreference) preference).isChecked();
                Settings.System.putInt(getActivity().getContentResolver(),
                        Settings.System.CRT_OFF_ANIMATION, checked ? 1 : 0);
                return true;

            } else if (preference == mCustomLabel) {
                AlertDialog.Builder alert = new AlertDialog.Builder(getActivity());

                alert.setTitle("Custom Carrier Label");
                alert.setMessage("Please enter a new one!");

                // Set an EditText view to get user input
                final EditText input = new EditText(getActivity());
                input.setText(mCustomLabelText != null ? mCustomLabelText : "");
                alert.setView(input);

                alert.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int whichButton) {
                        String value = ((Spannable) input.getText()).toString();
                        Settings.System.putString(getActivity().getContentResolver(),
                                Settings.System.CUSTOM_CARRIER_LABEL, value);
                        updateCustomLabelTextSummary();
                    }
                });

                alert.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int whichButton) {
                        // Canceled.
                    }
                });

                alert.show();
            }

            return super.onPreferenceTreeClick(preferenceScreen, preference);
        }

    }

}
