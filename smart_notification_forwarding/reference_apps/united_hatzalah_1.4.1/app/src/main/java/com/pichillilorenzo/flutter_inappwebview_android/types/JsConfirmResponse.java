package com.pichillilorenzo.flutter_inappwebview_android.types;

import io.flutter.plugins.firebase.crashlytics.Constants;
import java.util.Map;

/* loaded from: classes.dex */
public class JsConfirmResponse {
    private Integer action;
    private String cancelButtonTitle;
    private String confirmButtonTitle;
    private boolean handledByClient;
    private String message;

    public JsConfirmResponse(String str, String str2, String str3, boolean z3, Integer num) {
        this.message = str;
        this.confirmButtonTitle = str2;
        this.cancelButtonTitle = str3;
        this.handledByClient = z3;
        this.action = num;
    }

    public static JsConfirmResponse fromMap(Map<String, Object> map) {
        if (map == null) {
            return null;
        }
        return new JsConfirmResponse((String) map.get(Constants.MESSAGE), (String) map.get("confirmButtonTitle"), (String) map.get("cancelButtonTitle"), ((Boolean) map.get("handledByClient")).booleanValue(), (Integer) map.get("action"));
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            JsConfirmResponse jsConfirmResponse = (JsConfirmResponse) obj;
            if (this.handledByClient != jsConfirmResponse.handledByClient) {
                return false;
            }
            String str = this.message;
            if (str == null ? jsConfirmResponse.message != null : !str.equals(jsConfirmResponse.message)) {
                return false;
            }
            String str2 = this.confirmButtonTitle;
            if (str2 == null ? jsConfirmResponse.confirmButtonTitle != null : !str2.equals(jsConfirmResponse.confirmButtonTitle)) {
                return false;
            }
            String str3 = this.cancelButtonTitle;
            if (str3 == null ? jsConfirmResponse.cancelButtonTitle != null : !str3.equals(jsConfirmResponse.cancelButtonTitle)) {
                return false;
            }
            Integer num = this.action;
            Integer num2 = jsConfirmResponse.action;
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

    public String getCancelButtonTitle() {
        return this.cancelButtonTitle;
    }

    public String getConfirmButtonTitle() {
        return this.confirmButtonTitle;
    }

    public String getMessage() {
        return this.message;
    }

    public int hashCode() {
        int i;
        int i3;
        int i4;
        String str = this.message;
        int i5 = 0;
        if (str != null) {
            i = str.hashCode();
        } else {
            i = 0;
        }
        int i6 = i * 31;
        String str2 = this.confirmButtonTitle;
        if (str2 != null) {
            i3 = str2.hashCode();
        } else {
            i3 = 0;
        }
        int i7 = (i6 + i3) * 31;
        String str3 = this.cancelButtonTitle;
        if (str3 != null) {
            i4 = str3.hashCode();
        } else {
            i4 = 0;
        }
        int i8 = (((i7 + i4) * 31) + (this.handledByClient ? 1 : 0)) * 31;
        Integer num = this.action;
        if (num != null) {
            i5 = num.hashCode();
        }
        return i8 + i5;
    }

    public boolean isHandledByClient() {
        return this.handledByClient;
    }

    public void setAction(Integer num) {
        this.action = num;
    }

    public void setCancelButtonTitle(String str) {
        this.cancelButtonTitle = str;
    }

    public void setConfirmButtonTitle(String str) {
        this.confirmButtonTitle = str;
    }

    public void setHandledByClient(boolean z3) {
        this.handledByClient = z3;
    }

    public void setMessage(String str) {
        this.message = str;
    }

    public String toString() {
        return "JsConfirmResponse{message='" + this.message + "', confirmButtonTitle='" + this.confirmButtonTitle + "', cancelButtonTitle='" + this.cancelButtonTitle + "', handledByClient=" + this.handledByClient + ", action=" + this.action + '}';
    }
}
