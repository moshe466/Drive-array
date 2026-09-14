package com.groboot.mdaemergency.models;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public class SettingItemAdpter {
    public boolean isSectionItem;
    public SettingsList settingList;
    public String title;

    public SettingItemAdpter() {
        this.title = "";
    }

    public SettingItemAdpter(String str, boolean z10) {
        this.title = "";
        this.title = str;
        this.isSectionItem = z10;
    }

    public ArrayList<SettingItemAdpter> settingsToListSettingAdapter(List<SettingsListGroup> list) {
        ArrayList<SettingItemAdpter> arrayList = new ArrayList<>();
        if (!list.isEmpty()) {
            for (SettingsListGroup settingsListGroup : list) {
                arrayList.add(new SettingItemAdpter(settingsListGroup.Description, true));
                Iterator<SettingsList> it = settingsListGroup.List.iterator();
                while (it.hasNext()) {
                    arrayList.add(new SettingItemAdpter(it.next().Description, false));
                }
            }
        }
        return arrayList;
    }
}
