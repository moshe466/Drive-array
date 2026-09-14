package com.google.firebase.database.connection;

import F0.AbstractC0008a;
import java.net.URI;

/* loaded from: classes.dex */
public class HostInfo {
    private static final String LAST_SESSION_ID_PARAM = "ls";
    private static final String VERSION_PARAM = "v";
    private final String host;
    private final String namespace;
    private final boolean secure;

    public HostInfo(String str, String str2, boolean z3) {
        this.host = str;
        this.namespace = str2;
        this.secure = z3;
    }

    public static URI getConnectionUrl(String str, boolean z3, String str2, String str3) {
        String str4;
        if (z3) {
            str4 = "wss";
        } else {
            str4 = "ws";
        }
        String str5 = str4 + "://" + str + "/.ws?ns=" + str2 + "&v=5";
        if (str3 != null) {
            str5 = AbstractC0008a.o(str5, "&ls=", str3);
        }
        return URI.create(str5);
    }

    public String getHost() {
        return this.host;
    }

    public String getNamespace() {
        return this.namespace;
    }

    public boolean isSecure() {
        return this.secure;
    }

    public String toString() {
        String str;
        StringBuilder sb = new StringBuilder("http");
        if (this.secure) {
            str = "s";
        } else {
            str = "";
        }
        sb.append(str);
        sb.append("://");
        sb.append(this.host);
        return sb.toString();
    }
}
