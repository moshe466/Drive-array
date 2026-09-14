package com.pichillilorenzo.flutter_inappwebview_android.types;

import F0.AbstractC0008a;
import com.pichillilorenzo.flutter_inappwebview_android.Util;
import java.util.Map;
import java.util.Objects;

/* loaded from: classes.dex */
public class InAppBrowserMenuItem {
    private Object icon;
    private String iconColor;
    private int id;
    private Integer order;
    private boolean showAsAction;
    private String title;

    public InAppBrowserMenuItem(int i, String str, Integer num, Object obj, String str2, boolean z3) {
        this.id = i;
        this.title = str;
        this.order = num;
        this.icon = obj;
        this.iconColor = str2;
        this.showAsAction = z3;
    }

    public static InAppBrowserMenuItem fromMap(Map<String, Object> map) {
        Object obj;
        AndroidResource androidResource = null;
        if (map == null) {
            return null;
        }
        int intValue = ((Integer) map.get("id")).intValue();
        String str = (String) map.get("title");
        Integer num = (Integer) map.get("order");
        Object obj2 = map.get("icon");
        if (obj2 instanceof Map) {
            androidResource = AndroidResource.fromMap((Map) map.get("icon"));
        } else if (obj2 instanceof byte[]) {
            obj = obj2;
            return new InAppBrowserMenuItem(intValue, str, num, obj, (String) map.get("iconColor"), ((Boolean) Util.getOrDefault(map, "showAsAction", Boolean.FALSE)).booleanValue());
        }
        obj = androidResource;
        return new InAppBrowserMenuItem(intValue, str, num, obj, (String) map.get("iconColor"), ((Boolean) Util.getOrDefault(map, "showAsAction", Boolean.FALSE)).booleanValue());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        InAppBrowserMenuItem inAppBrowserMenuItem = (InAppBrowserMenuItem) obj;
        if (this.id != inAppBrowserMenuItem.id || this.showAsAction != inAppBrowserMenuItem.showAsAction || !this.title.equals(inAppBrowserMenuItem.title) || !Objects.equals(this.order, inAppBrowserMenuItem.order) || !Objects.equals(this.icon, inAppBrowserMenuItem.icon)) {
            return false;
        }
        return Objects.equals(this.iconColor, inAppBrowserMenuItem.iconColor);
    }

    public Object getIcon() {
        return this.icon;
    }

    public String getIconColor() {
        return this.iconColor;
    }

    public int getId() {
        return this.id;
    }

    public Integer getOrder() {
        return this.order;
    }

    public String getTitle() {
        return this.title;
    }

    public int hashCode() {
        int i;
        int i3;
        int g3 = AbstractC0008a.g(this.title, this.id * 31, 31);
        Integer num = this.order;
        int i4 = 0;
        if (num != null) {
            i = num.hashCode();
        } else {
            i = 0;
        }
        int i5 = (g3 + i) * 31;
        Object obj = this.icon;
        if (obj != null) {
            i3 = obj.hashCode();
        } else {
            i3 = 0;
        }
        int i6 = (i5 + i3) * 31;
        String str = this.iconColor;
        if (str != null) {
            i4 = str.hashCode();
        }
        return ((i6 + i4) * 31) + (this.showAsAction ? 1 : 0);
    }

    public boolean isShowAsAction() {
        return this.showAsAction;
    }

    public void setIcon(Object obj) {
        this.icon = obj;
    }

    public void setIconColor(String str) {
        this.iconColor = str;
    }

    public void setId(int i) {
        this.id = i;
    }

    public void setOrder(Integer num) {
        this.order = num;
    }

    public void setShowAsAction(boolean z3) {
        this.showAsAction = z3;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public String toString() {
        return "InAppBrowserMenuItem{id=" + this.id + ", title='" + this.title + "', order=" + this.order + ", icon=" + this.icon + ", iconColor='" + this.iconColor + "', showAsAction=" + this.showAsAction + '}';
    }
}
