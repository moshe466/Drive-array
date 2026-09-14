package com.google.firebase.database.core;

import F0.AbstractC0008a;
import com.google.firebase.emulators.EmulatedServiceSettings;
import java.net.URI;
import org.apache.tika.metadata.TikaCoreProperties;

/* loaded from: classes.dex */
public final class RepoInfo {
    private static final String LAST_SESSION_ID_PARAM = "ls";
    private static final String VERSION_PARAM = "v";
    public String host;
    public String internalHost;
    public String namespace;
    public boolean secure;

    public void applyEmulatorSettings(EmulatedServiceSettings emulatedServiceSettings) {
        if (emulatedServiceSettings == null) {
            return;
        }
        String str = emulatedServiceSettings.getHost() + TikaCoreProperties.NAMESPACE_PREFIX_DELIMITER + emulatedServiceSettings.getPort();
        this.host = str;
        this.internalHost = str;
        this.secure = false;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || RepoInfo.class != obj.getClass()) {
            return false;
        }
        RepoInfo repoInfo = (RepoInfo) obj;
        if (this.secure != repoInfo.secure || !this.host.equals(repoInfo.host)) {
            return false;
        }
        return this.namespace.equals(repoInfo.namespace);
    }

    public URI getConnectionURL(String str) {
        String str2;
        if (this.secure) {
            str2 = "wss";
        } else {
            str2 = "ws";
        }
        StringBuilder i = e0.a.i(str2, "://");
        i.append(this.internalHost);
        i.append("/.ws?ns=");
        String u3 = AbstractC0008a.u(i, this.namespace, "&v=5");
        if (str != null) {
            u3 = AbstractC0008a.o(u3, "&ls=", str);
        }
        return URI.create(u3);
    }

    public int hashCode() {
        return this.namespace.hashCode() + (((this.host.hashCode() * 31) + (this.secure ? 1 : 0)) * 31);
    }

    public boolean isCacheableHost() {
        return this.internalHost.startsWith("s-");
    }

    public boolean isCustomHost() {
        if (!this.host.contains(".firebaseio.com") && !this.host.contains(".firebaseio-demo.com")) {
            return true;
        }
        return false;
    }

    public boolean isDemoHost() {
        return this.host.contains(".firebaseio-demo.com");
    }

    public boolean isSecure() {
        return this.secure;
    }

    public String toDebugString() {
        StringBuilder sb = new StringBuilder("(host=");
        sb.append(this.host);
        sb.append(", secure=");
        sb.append(this.secure);
        sb.append(", ns=");
        sb.append(this.namespace);
        sb.append(" internal=");
        return AbstractC0008a.u(sb, this.internalHost, ")");
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
