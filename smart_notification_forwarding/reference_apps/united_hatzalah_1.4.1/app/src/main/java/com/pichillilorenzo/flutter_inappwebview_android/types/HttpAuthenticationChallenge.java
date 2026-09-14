package com.pichillilorenzo.flutter_inappwebview_android.types;

import com.google.firebase.messaging.Constants;
import java.util.Map;

/* loaded from: classes.dex */
public class HttpAuthenticationChallenge extends URLAuthenticationChallenge {
    private int previousFailureCount;
    URLCredential proposedCredential;

    public HttpAuthenticationChallenge(URLProtectionSpace uRLProtectionSpace, int i, URLCredential uRLCredential) {
        super(uRLProtectionSpace);
        this.previousFailureCount = i;
        this.proposedCredential = uRLCredential;
    }

    @Override // com.pichillilorenzo.flutter_inappwebview_android.types.URLAuthenticationChallenge
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass() || !super.equals(obj)) {
            return false;
        }
        HttpAuthenticationChallenge httpAuthenticationChallenge = (HttpAuthenticationChallenge) obj;
        if (this.previousFailureCount != httpAuthenticationChallenge.previousFailureCount) {
            return false;
        }
        URLCredential uRLCredential = this.proposedCredential;
        URLCredential uRLCredential2 = httpAuthenticationChallenge.proposedCredential;
        if (uRLCredential != null) {
            return uRLCredential.equals(uRLCredential2);
        }
        if (uRLCredential2 == null) {
            return true;
        }
        return false;
    }

    public int getPreviousFailureCount() {
        return this.previousFailureCount;
    }

    public URLCredential getProposedCredential() {
        return this.proposedCredential;
    }

    @Override // com.pichillilorenzo.flutter_inappwebview_android.types.URLAuthenticationChallenge
    public int hashCode() {
        int i;
        int hashCode = ((super.hashCode() * 31) + this.previousFailureCount) * 31;
        URLCredential uRLCredential = this.proposedCredential;
        if (uRLCredential != null) {
            i = uRLCredential.hashCode();
        } else {
            i = 0;
        }
        return hashCode + i;
    }

    public void setPreviousFailureCount(int i) {
        this.previousFailureCount = i;
    }

    public void setProposedCredential(URLCredential uRLCredential) {
        this.proposedCredential = uRLCredential;
    }

    @Override // com.pichillilorenzo.flutter_inappwebview_android.types.URLAuthenticationChallenge
    public Map<String, Object> toMap() {
        Map<String, Object> map;
        Map<String, Object> map2 = super.toMap();
        map2.put("previousFailureCount", Integer.valueOf(this.previousFailureCount));
        URLCredential uRLCredential = this.proposedCredential;
        if (uRLCredential != null) {
            map = uRLCredential.toMap();
        } else {
            map = null;
        }
        map2.put("proposedCredential", map);
        map2.put("failureResponse", null);
        map2.put(Constants.IPC_BUNDLE_KEY_SEND_ERROR, null);
        return map2;
    }

    @Override // com.pichillilorenzo.flutter_inappwebview_android.types.URLAuthenticationChallenge
    public String toString() {
        return "HttpAuthenticationChallenge{previousFailureCount=" + this.previousFailureCount + ", proposedCredential=" + this.proposedCredential + "} " + super.toString();
    }
}
