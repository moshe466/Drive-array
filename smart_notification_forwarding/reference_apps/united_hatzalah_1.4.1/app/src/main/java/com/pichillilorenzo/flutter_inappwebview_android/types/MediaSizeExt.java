package com.pichillilorenzo.flutter_inappwebview_android.types;

import android.print.PrintAttributes;
import com.google.firebase.messaging.Constants;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public class MediaSizeExt {
    private int heightMils;
    private String id;
    private String label;
    private int widthMils;

    public MediaSizeExt(String str, String str2, int i, int i3) {
        this.id = str;
        this.label = str2;
        this.widthMils = i;
        this.heightMils = i3;
    }

    public static MediaSizeExt fromMap(Map<String, Object> map) {
        if (map == null) {
            return null;
        }
        return new MediaSizeExt((String) map.get("id"), (String) map.get(Constants.ScionAnalytics.PARAM_LABEL), ((Integer) map.get("widthMils")).intValue(), ((Integer) map.get("heightMils")).intValue());
    }

    public static MediaSizeExt fromMediaSize(PrintAttributes.MediaSize mediaSize) {
        if (mediaSize == null) {
            return null;
        }
        return new MediaSizeExt(mediaSize.getId(), null, mediaSize.getHeightMils(), mediaSize.getWidthMils());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            MediaSizeExt mediaSizeExt = (MediaSizeExt) obj;
            if (this.widthMils != mediaSizeExt.widthMils || this.heightMils != mediaSizeExt.heightMils || !this.id.equals(mediaSizeExt.id)) {
                return false;
            }
            String str = this.label;
            String str2 = mediaSizeExt.label;
            if (str != null) {
                return str.equals(str2);
            }
            if (str2 == null) {
                return true;
            }
        }
        return false;
    }

    public int getHeightMils() {
        return this.heightMils;
    }

    public String getId() {
        return this.id;
    }

    public String getLabel() {
        return this.label;
    }

    public int getWidthMils() {
        return this.widthMils;
    }

    public int hashCode() {
        int i;
        int hashCode = this.id.hashCode() * 31;
        String str = this.label;
        if (str != null) {
            i = str.hashCode();
        } else {
            i = 0;
        }
        return ((((hashCode + i) * 31) + this.widthMils) * 31) + this.heightMils;
    }

    public void setHeightMils(int i) {
        this.heightMils = i;
    }

    public void setId(String str) {
        this.id = str;
    }

    public void setLabel(String str) {
        this.label = str;
    }

    public void setWidthMils(int i) {
        this.widthMils = i;
    }

    public Map<String, Object> toMap() {
        HashMap hashMap = new HashMap();
        hashMap.put("id", this.id);
        hashMap.put(Constants.ScionAnalytics.PARAM_LABEL, this.label);
        hashMap.put("heightMils", Integer.valueOf(this.heightMils));
        hashMap.put("widthMils", Integer.valueOf(this.widthMils));
        return hashMap;
    }

    public PrintAttributes.MediaSize toMediaSize() {
        return new PrintAttributes.MediaSize(this.id, "Custom", this.widthMils, this.heightMils);
    }

    public String toString() {
        return "MediaSizeExt{id='" + this.id + "', label='" + this.label + "', widthMils=" + this.widthMils + ", heightMils=" + this.heightMils + '}';
    }
}
