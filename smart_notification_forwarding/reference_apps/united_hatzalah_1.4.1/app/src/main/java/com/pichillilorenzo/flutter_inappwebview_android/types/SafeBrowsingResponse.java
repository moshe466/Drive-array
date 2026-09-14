package com.pichillilorenzo.flutter_inappwebview_android.types;

import java.util.Map;

/* loaded from: classes.dex */
public class SafeBrowsingResponse {
    private Integer action;
    private boolean report;

    public SafeBrowsingResponse(boolean z3, Integer num) {
        this.report = z3;
        this.action = num;
    }

    public static SafeBrowsingResponse fromMap(Map<String, Object> map) {
        if (map == null) {
            return null;
        }
        return new SafeBrowsingResponse(((Boolean) map.get("report")).booleanValue(), (Integer) map.get("action"));
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            SafeBrowsingResponse safeBrowsingResponse = (SafeBrowsingResponse) obj;
            if (this.report != safeBrowsingResponse.report) {
                return false;
            }
            Integer num = this.action;
            Integer num2 = safeBrowsingResponse.action;
            if (num != null) {
                return num.equals(num2);
            }
            if (num2 == null) {
                return true;
            }
        }
        return false;
    }

    public Integer getAction() {
        return this.action;
    }

    public int hashCode() {
        int i;
        int i3 = (this.report ? 1 : 0) * 31;
        Integer num = this.action;
        if (num != null) {
            i = num.hashCode();
        } else {
            i = 0;
        }
        return i3 + i;
    }

    public boolean isReport() {
        return this.report;
    }

    public void setAction(Integer num) {
        this.action = num;
    }

    public void setReport(boolean z3) {
        this.report = z3;
    }

    public String toString() {
        return "SafeBrowsingResponse{report=" + this.report + ", action=" + this.action + '}';
    }
}
