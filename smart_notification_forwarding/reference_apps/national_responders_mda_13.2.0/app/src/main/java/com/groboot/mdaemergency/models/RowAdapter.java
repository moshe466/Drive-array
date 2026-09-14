package com.groboot.mdaemergency.models;

import w6.t;

/* loaded from: classes.dex */
public class RowAdapter {
    public boolean isSection;
    public Object object;
    public int section;
    public eRowAdapterType type;

    /* loaded from: classes.dex */
    public enum eRowAdapterSubType {
        shortcut,
        sendLogs,
        sendLogs5seconds,
        sendLogs30seconds
    }

    /* loaded from: classes.dex */
    public enum eRowAdapterType {
        settingList,
        settingItem,
        permissions,
        checkbox,
        dialog,
        sound,
        switchBox,
        shortcut,
        sendLogs,
        ExternalLinkItem;

        String key;
        eRowAdapterSubType subType;

        public String getKey() {
            return this.key;
        }

        public eRowAdapterSubType getSubType() {
            return this.subType;
        }

        public void setKey(String str) {
            this.key = str;
        }

        public void setSubType(eRowAdapterSubType erowadaptersubtype) {
            this.subType = erowadaptersubtype;
        }
    }

    public RowAdapter(SettingItem settingItem) {
        this.object = settingItem;
        this.type = eRowAdapterType.settingItem;
    }

    public RowAdapter(Object obj, eRowAdapterType erowadaptertype) {
        this.object = obj;
        this.type = erowadaptertype;
    }

    public RowAdapter(Object obj, boolean z10) {
        this.object = obj;
        this.isSection = z10;
        this.type = eRowAdapterType.settingList;
    }

    public RowAdapter(String str) {
        this.object = str;
        this.type = eRowAdapterType.checkbox;
    }

    public RowAdapter(t tVar) {
        this.object = tVar;
        this.type = eRowAdapterType.permissions;
    }
}
