package com.pichillilorenzo.flutter_inappwebview_android.types;

import F0.AbstractC0008a;
import com.google.android.gms.common.internal.ImagesContract;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public class ProxyRuleExt {
    private String schemeFilter;
    private String url;

    public ProxyRuleExt(String str, String str2) {
        this.schemeFilter = str;
        this.url = str2;
    }

    public static ProxyRuleExt fromMap(Map<String, String> map) {
        if (map == null) {
            return null;
        }
        return new ProxyRuleExt(map.get("schemeFilter"), map.get(ImagesContract.URL));
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        ProxyRuleExt proxyRuleExt = (ProxyRuleExt) obj;
        String str = this.schemeFilter;
        if (str == null ? proxyRuleExt.schemeFilter != null : !str.equals(proxyRuleExt.schemeFilter)) {
            return false;
        }
        return this.url.equals(proxyRuleExt.url);
    }

    public String getSchemeFilter() {
        return this.schemeFilter;
    }

    public String getUrl() {
        return this.url;
    }

    public int hashCode() {
        int i;
        String str = this.schemeFilter;
        if (str != null) {
            i = str.hashCode();
        } else {
            i = 0;
        }
        return this.url.hashCode() + (i * 31);
    }

    public void setSchemeFilter(String str) {
        this.schemeFilter = str;
    }

    public void setUrl(String str) {
        this.url = str;
    }

    public Map<String, String> toMap() {
        HashMap hashMap = new HashMap();
        hashMap.put(ImagesContract.URL, this.url);
        hashMap.put("schemeFilter", this.schemeFilter);
        return hashMap;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("ProxyRuleExt{schemeFilter='");
        sb.append(this.schemeFilter);
        sb.append("', url='");
        return AbstractC0008a.u(sb, this.url, "'}");
    }
}
