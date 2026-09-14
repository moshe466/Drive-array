package com.pichillilorenzo.flutter_inappwebview_android.types;

import F0.AbstractC0008a;
import android.webkit.WebResourceRequest;
import com.google.android.gms.common.internal.ImagesContract;
import io.flutter.plugins.firebase.crashlytics.Constants;
import java.util.HashMap;
import java.util.Map;
import t0.d;
import u0.AbstractC0729g;
import u0.F;

/* loaded from: classes.dex */
public class WebResourceRequestExt {
    private boolean hasGesture;
    private Map<String, String> headers;
    private boolean isForMainFrame;
    private boolean isRedirect;
    private String method;
    private String url;

    public WebResourceRequestExt(String str, Map<String, String> map, boolean z3, boolean z4, boolean z5, String str2) {
        this.url = str;
        this.headers = map;
        this.isRedirect = z3;
        this.hasGesture = z4;
        this.isForMainFrame = z5;
        this.method = str2;
    }

    public static WebResourceRequestExt fromWebResourceRequest(WebResourceRequest webResourceRequest) {
        boolean isRedirect;
        if (d.a("WEB_RESOURCE_REQUEST_IS_REDIRECT")) {
            F.f6536m.getClass();
            isRedirect = AbstractC0729g.j(webResourceRequest);
        } else {
            isRedirect = webResourceRequest.isRedirect();
        }
        return new WebResourceRequestExt(webResourceRequest.getUrl().toString(), webResourceRequest.getRequestHeaders(), isRedirect, webResourceRequest.hasGesture(), webResourceRequest.isForMainFrame(), webResourceRequest.getMethod());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            WebResourceRequestExt webResourceRequestExt = (WebResourceRequestExt) obj;
            if (this.isRedirect != webResourceRequestExt.isRedirect || this.hasGesture != webResourceRequestExt.hasGesture || this.isForMainFrame != webResourceRequestExt.isForMainFrame || !this.url.equals(webResourceRequestExt.url)) {
                return false;
            }
            Map<String, String> map = this.headers;
            if (map == null ? webResourceRequestExt.headers != null : !map.equals(webResourceRequestExt.headers)) {
                return false;
            }
            String str = this.method;
            String str2 = webResourceRequestExt.method;
            if (str != null) {
                return str.equals(str2);
            }
            if (str2 == null) {
                return true;
            }
        }
        return false;
    }

    public Map<String, String> getHeaders() {
        return this.headers;
    }

    public String getMethod() {
        return this.method;
    }

    public String getUrl() {
        return this.url;
    }

    public int hashCode() {
        int i;
        int hashCode = this.url.hashCode() * 31;
        Map<String, String> map = this.headers;
        int i3 = 0;
        if (map != null) {
            i = map.hashCode();
        } else {
            i = 0;
        }
        int i4 = (((((((hashCode + i) * 31) + (this.isRedirect ? 1 : 0)) * 31) + (this.hasGesture ? 1 : 0)) * 31) + (this.isForMainFrame ? 1 : 0)) * 31;
        String str = this.method;
        if (str != null) {
            i3 = str.hashCode();
        }
        return i4 + i3;
    }

    public boolean isForMainFrame() {
        return this.isForMainFrame;
    }

    public boolean isHasGesture() {
        return this.hasGesture;
    }

    public boolean isRedirect() {
        return this.isRedirect;
    }

    public void setForMainFrame(boolean z3) {
        this.isForMainFrame = z3;
    }

    public void setHasGesture(boolean z3) {
        this.hasGesture = z3;
    }

    public void setHeaders(Map<String, String> map) {
        this.headers = map;
    }

    public void setMethod(String str) {
        this.method = str;
    }

    public void setRedirect(boolean z3) {
        this.isRedirect = z3;
    }

    public void setUrl(String str) {
        this.url = str;
    }

    public Map<String, Object> toMap() {
        HashMap hashMap = new HashMap();
        hashMap.put(ImagesContract.URL, this.url);
        hashMap.put("headers", this.headers);
        hashMap.put("isRedirect", Boolean.valueOf(this.isRedirect));
        hashMap.put("hasGesture", Boolean.valueOf(this.hasGesture));
        hashMap.put("isForMainFrame", Boolean.valueOf(this.isForMainFrame));
        hashMap.put(Constants.METHOD, this.method);
        return hashMap;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("WebResourceRequestExt{url=");
        sb.append(this.url);
        sb.append(", headers=");
        sb.append(this.headers);
        sb.append(", isRedirect=");
        sb.append(this.isRedirect);
        sb.append(", hasGesture=");
        sb.append(this.hasGesture);
        sb.append(", isForMainFrame=");
        sb.append(this.isForMainFrame);
        sb.append(", method='");
        return AbstractC0008a.u(sb, this.method, "'}");
    }
}
