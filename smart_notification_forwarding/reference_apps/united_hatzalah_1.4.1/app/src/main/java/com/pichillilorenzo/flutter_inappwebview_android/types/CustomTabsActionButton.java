package com.pichillilorenzo.flutter_inappwebview_android.types;

import F0.AbstractC0008a;
import java.util.Arrays;
import java.util.Map;

/* loaded from: classes.dex */
public class CustomTabsActionButton {
    private String description;
    private byte[] icon;
    private int id;
    private boolean shouldTint;

    public CustomTabsActionButton(int i, byte[] bArr, String str, boolean z3) {
        this.id = i;
        this.icon = bArr;
        this.description = str;
        this.shouldTint = z3;
    }

    public static CustomTabsActionButton fromMap(Map<String, Object> map) {
        if (map == null) {
            return null;
        }
        return new CustomTabsActionButton(((Integer) map.get("id")).intValue(), (byte[]) map.get("icon"), (String) map.get("description"), ((Boolean) map.get("shouldTint")).booleanValue());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        CustomTabsActionButton customTabsActionButton = (CustomTabsActionButton) obj;
        if (this.id != customTabsActionButton.id || this.shouldTint != customTabsActionButton.shouldTint || !Arrays.equals(this.icon, customTabsActionButton.icon)) {
            return false;
        }
        return this.description.equals(customTabsActionButton.description);
    }

    public String getDescription() {
        return this.description;
    }

    public byte[] getIcon() {
        return this.icon;
    }

    public int getId() {
        return this.id;
    }

    public int hashCode() {
        return AbstractC0008a.g(this.description, (Arrays.hashCode(this.icon) + (this.id * 31)) * 31, 31) + (this.shouldTint ? 1 : 0);
    }

    public boolean isShouldTint() {
        return this.shouldTint;
    }

    public void setDescription(String str) {
        this.description = str;
    }

    public void setIcon(byte[] bArr) {
        this.icon = bArr;
    }

    public void setId(int i) {
        this.id = i;
    }

    public void setShouldTint(boolean z3) {
        this.shouldTint = z3;
    }

    public String toString() {
        return "CustomTabsActionButton{id=" + this.id + ", icon=" + Arrays.toString(this.icon) + ", description='" + this.description + "', shouldTint=" + this.shouldTint + '}';
    }
}
