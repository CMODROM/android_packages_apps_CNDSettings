/*
* Copyright (C) 2011 The CyanogenMod Project
*
* Licensed under the Apache License, Version 2.0 (the "License");
* you may not use this file except in compliance with the License.
* You may obtain a copy of the License at
*
* http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.
*/
package com.codenamedroid.settings.activities;

import com.codenamedroid.settings.R;

import java.util.ArrayList;

import android.content.ContentResolver;
import android.os.Bundle;
import android.preference.CheckBoxPreference;
import android.preference.ListPreference;
import android.preference.Preference;
import android.preference.PreferenceFragment;
import android.preference.PreferenceActivity;
import android.preference.PreferenceScreen;
import android.preference.Preference.OnPreferenceChangeListener;
import android.provider.Settings;

import com.codenamedroid.settings.SettingsFragment;

public class StatusBarBattery extends PreferenceActivity {

    private static final String PREF_BATT_TEXT = "text_widget";
    private static final String PREF_BATT_TEXT_CENTER = "text_widget_center";

    CheckBoxPreference mEnableBatteryText;
    CheckBoxPreference mEnableCenterBatteryText;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        addPreferencesFromResource(R.xml.prefs_statusbar_battery);

        mEnableBatteryText = (CheckBoxPreference) findPreference(PREF_BATT_TEXT);
        mEnableBatteryText.setChecked(Settings.System.getInt(getApplicationContext().getContentResolver(),
            Settings.System.STATUSBAR_BATTERY_TEXT, 0) == 1);
        
        mEnableCenterBatteryText = (CheckBoxPreference) findPreference(PREF_BATT_TEXT_CENTER);
        mEnableCenterBatteryText.setChecked(Settings.System.getInt(getApplicationContext().getContentResolver(), Settings.System.STATUSBAR_BATTERY_TEXT_STYLE, 1) == 1);
        
    }

    @Override
    public boolean onPreferenceTreeClick(PreferenceScreen preferenceScreen,
             Preference preference) {
        if (preference == mEnableBatteryText) {
            Settings.System.putInt(getApplicationContext().getContentResolver(),
                    Settings.System.STATUSBAR_BATTERY_TEXT,
                     ((CheckBoxPreference) preference).isChecked() ? 1 : 0);
            return true;
            
        } else if (preference == mEnableCenterBatteryText) {
            
            Settings.System.putInt(getApplicationContext().getContentResolver(),
                    Settings.System.STATUSBAR_BATTERY_TEXT_STYLE,
                    ((CheckBoxPreference) preference).isChecked() ? 1 : 0);
            return true;
        }
        return super.onPreferenceTreeClick(preferenceScreen, preference);
    }
    
    private boolean getBoolean(Object o) {
        return Boolean.valueOf(o.toString());
    }
    
    private int getInt(Object o) {
        return Integer.valueOf(o.toString());
    }
}
