package com.groboot.mdaemergency.models;

import com.groboot.mdaemergency.enums.j;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes.dex */
public class SettingsList {
    public String Description;
    public ArrayList<SettingItem> ItemList;
    public boolean MultiSelect;
    public int Type;
    public j settingType;

    public SettingsList(j jVar, String str, int i10, ArrayList<SettingItem> arrayList, String str2) {
        this.Description = "";
        this.Type = 0;
        this.settingType = jVar;
        this.Description = str;
        this.ItemList = arrayList;
        this.Type = i10;
        this.MultiSelect = false;
        findItemSelectedByKey(str2);
        Iterator<SettingItem> it = arrayList.iterator();
        while (it.hasNext()) {
            it.next().type = jVar;
        }
    }

    public SettingsList(String str, int i10, ArrayList<SettingItem> arrayList, String str2) {
        this.Description = "";
        this.Type = 0;
        this.settingType = j.MultiSelect;
        this.Description = str;
        this.ItemList = arrayList;
        this.Type = i10;
        this.MultiSelect = false;
        findItemSelectedByKey(str2);
    }

    public SettingsList(String str, ArrayList<SettingItem> arrayList, boolean z10) {
        this.Description = "";
        this.Type = 0;
        this.Description = str;
        this.ItemList = arrayList;
        this.MultiSelect = z10;
    }

    private void findItemSelectedByKey(String str) {
        Iterator<SettingItem> it = this.ItemList.iterator();
        while (it.hasNext()) {
            SettingItem next = it.next();
            if (str.equals(next.Key)) {
                next.Value = true;
            }
        }
    }

    public void setItems(ArrayList<SettingItem> arrayList) {
        this.ItemList = new ArrayList<>();
        Iterator<SettingItem> it = arrayList.iterator();
        while (it.hasNext()) {
            this.ItemList.add(it.next());
        }
    }

    public void setSettingType(j jVar) {
        this.settingType = jVar;
        Iterator<SettingItem> it = this.ItemList.iterator();
        while (it.hasNext()) {
            it.next().type = jVar;
        }
    }
}
