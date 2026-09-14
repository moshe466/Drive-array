package com.groboot.mdaemergency.models;

import com.groboot.mdaemergency.enums.j;

/* loaded from: classes.dex */
public class SettingItem implements Cloneable {
    public boolean CheckAll;
    public String Description;
    public String Key;
    public boolean Value;
    public j type;

    public SettingItem(String str, String str2) {
        this.Key = "";
        this.Description = "";
        this.Key = str;
        this.Description = str2;
        setValue(false);
    }

    public SettingItem(String str, String str2, j jVar) {
        this.Key = "";
        this.Description = "";
        this.Key = str;
        this.Description = str2;
        setValue(false);
        this.type = jVar;
    }

    public SettingItem(String str, String str2, j jVar, Boolean bool) {
        this.Key = "";
        this.Description = "";
        this.Key = str;
        this.Description = str2;
        setValue(bool.booleanValue());
        this.type = jVar;
    }

    public SettingItem(String str, String str2, Boolean bool) {
        this.Key = "";
        this.Description = "";
        this.Key = str;
        this.Description = str2;
        this.Value = bool.booleanValue();
    }

    public SettingItem(String str, boolean z10) {
        this.Key = "";
        this.Description = "";
        this.Description = str;
        this.Value = z10;
    }

    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public SettingItem m2clone() {
        return new SettingItem(this.Key, this.Description, Boolean.valueOf(this.Value));
    }

    public void setValue(boolean z10) {
        this.Value = z10;
    }
}
