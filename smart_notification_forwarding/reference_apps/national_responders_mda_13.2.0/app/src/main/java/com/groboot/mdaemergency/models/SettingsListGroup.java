package com.groboot.mdaemergency.models;

import java.util.ArrayList;

/* loaded from: classes.dex */
public class SettingsListGroup {
    public String Description;
    public ArrayList<SettingsList> List;
    public eListGroupType type;

    /* loaded from: classes.dex */
    public enum eListGroupType {
        Filters,
        AlertTones,
        PTT,
        Message,
        Permission,
        AlertVolume,
        Shabbat
    }

    public SettingsListGroup() {
        this.Description = "";
    }

    public SettingsListGroup(SettingsListGroup settingsListGroup) {
        this.Description = "";
        this.List = settingsListGroup.List;
        this.Description = settingsListGroup.Description;
    }

    public SettingsListGroup(String str, eListGroupType elistgrouptype) {
        this.Description = "";
        this.Description = str;
        this.List = new ArrayList<>();
        this.type = elistgrouptype;
    }

    public SettingsListGroup(String str, ArrayList<SettingsList> arrayList) {
        this.Description = "";
        this.Description = str;
        this.List = arrayList;
    }
}
