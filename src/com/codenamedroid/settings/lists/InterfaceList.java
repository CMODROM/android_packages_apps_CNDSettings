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
package com.codenamedroid.settings.lists;

import com.codenamedroid.settings.R;
import java.util.ArrayList;

public class InterfaceList extends MasterLists {
    public static ArrayList<MasterLists.List> mList = null;

    public InterfaceList() {
        //mList.put(new MasterLists.List(ResID, ResID, Intent, Type));
        mList = new ArrayList<MasterLists.List>();
        mList.add(new MasterLists.List(R.string.status_bar_settings_header, 0, "com.codenamedroid.settings.activities.PowerWidget", TYPE_CATEGORY));
        mList.add(new MasterLists.List(R.string.clock_settings_title, 0, "com.codenamedroid.settings.activities.StatusBarClock", TYPE_NORMAL));
        mList.add(new MasterLists.List(R.string.battery_settings_title, 0, "com.codenamedroid.settings.activities.StatusBarBattery", TYPE_SWITCH));
        mList.add(new MasterLists.List(R.string.title_expanded_widget, 0, "com.codenamedroid.settings.activities.PowerWidget", TYPE_SWITCH));
        mList.add(new MasterLists.List(R.string.input_settings_header, 0, "com.codenamedroid.settings.activities.PowerWidget", TYPE_CATEGORY));
        mList.add(new MasterLists.List(R.string.title_input_nav, 0, "com.codenamedroid.settings.activities.NavButtons", TYPE_NORMAL));
        mList.add(new MasterLists.List(R.string.display_settings_header, 0, "com.codenamedroid.settings.activities.PowerWidget", TYPE_CATEGORY));
        mList.add(new MasterLists.List(R.string.backlight_settings_title, 0, "com.codenamedroid.settings.activities.Backlight", TYPE_SWITCH));
        mList.add(new MasterLists.List(R.string.lockscreen_settings_header, 0, "com.codenamedroid.settings.activities.Lockscreens", TYPE_CATEGORY));
        mList.add(new MasterLists.List(R.string.lockscreen_settings_title, 0, "com.codenamedroid.settings.activities.Lockscreens", TYPE_NORMAL));
        mList.add(new MasterLists.List(R.string.misc_settings_header, 0, "com.codenamedroid.settings.activities.PowerWidget", TYPE_CATEGORY));
        mList.add(new MasterLists.List(R.string.misc_settings_title, 0, "com.codenamedroid.settings.activities.MiscSettings", TYPE_NORMAL));
    }

    public ArrayList<MasterLists.List> getList() {
        return mList;
    }

}
