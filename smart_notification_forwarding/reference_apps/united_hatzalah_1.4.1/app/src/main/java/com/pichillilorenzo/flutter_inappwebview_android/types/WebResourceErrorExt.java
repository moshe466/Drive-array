package com.pichillilorenzo.flutter_inappwebview_android.types;

import F0.AbstractC0008a;
import android.webkit.WebResourceError;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;
import org.chromium.support_lib_boundary.WebkitToCompatConverterBoundaryInterface;
import t0.d;
import t0.q;
import u0.AbstractC0728f;
import u0.C0722C;
import u0.F;
import u0.G;
import u0.J;

/* loaded from: classes.dex */
public class WebResourceErrorExt {
    private String description;
    private int type;

    public WebResourceErrorExt(int i, String str) {
        this.type = i;
        this.description = str;
    }

    public static WebResourceErrorExt fromWebResourceError(WebResourceError webResourceError) {
        return new WebResourceErrorExt(webResourceError.getErrorCode(), webResourceError.getDescription().toString());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        WebResourceErrorExt webResourceErrorExt = (WebResourceErrorExt) obj;
        if (this.type != webResourceErrorExt.type) {
            return false;
        }
        return this.description.equals(webResourceErrorExt.description);
    }

    public String getDescription() {
        return this.description;
    }

    public int getType() {
        return this.type;
    }

    public int hashCode() {
        return this.description.hashCode() + (this.type * 31);
    }

    public void setDescription(String str) {
        this.description = str;
    }

    public void setType(int i) {
        this.type = i;
    }

    public Map<String, Object> toMap() {
        HashMap hashMap = new HashMap();
        hashMap.put("type", Integer.valueOf(getType()));
        hashMap.put("description", getDescription());
        return hashMap;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("WebResourceErrorExt{type=");
        sb.append(this.type);
        sb.append(", description='");
        return AbstractC0008a.u(sb, this.description, "'}");
    }

    public static WebResourceErrorExt fromWebResourceError(q qVar) {
        int i;
        String str;
        if (d.a("WEB_RESOURCE_ERROR_GET_CODE")) {
            C0722C c0722c = (C0722C) qVar;
            c0722c.getClass();
            F.f6538o.getClass();
            if (c0722c.f6507a == null) {
                J j2 = G.f6548a;
                c0722c.f6507a = (WebResourceError) ((WebkitToCompatConverterBoundaryInterface) j2.f6552b).convertWebResourceError(Proxy.getInvocationHandler(c0722c.f6508b));
            }
            i = AbstractC0728f.f(c0722c.f6507a);
        } else {
            i = -1;
        }
        if (d.a("WEB_RESOURCE_ERROR_GET_DESCRIPTION")) {
            C0722C c0722c2 = (C0722C) qVar;
            c0722c2.getClass();
            F.f6537n.getClass();
            if (c0722c2.f6507a == null) {
                J j3 = G.f6548a;
                c0722c2.f6507a = (WebResourceError) ((WebkitToCompatConverterBoundaryInterface) j3.f6552b).convertWebResourceError(Proxy.getInvocationHandler(c0722c2.f6508b));
            }
            str = AbstractC0728f.e(c0722c2.f6507a).toString();
        } else {
            str = "";
        }
        return new WebResourceErrorExt(i, str);
    }
}
