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
package com.codenamedroid.settings;

import android.app.Fragment;
import android.content.ContentResolver;
import android.content.pm.PackageManager;
import android.content.Context;
import android.os.Bundle;
import android.preference.PreferenceActivity;
import android.preference.PreferenceFragment;

public class SettingsFragment extends PreferenceFragment {

    @Override
    public void onActivityCreated(Bundle icicle) {
        super.onActivityCreated(icicle);
    }

    public ContentResolver getContentResolver() {
         return getActivity().getContentResolver();
    }

    public Context getContext() {
        return getActivity().getApplicationContext();
    }
}

