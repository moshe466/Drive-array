package com.google.android.play.core.integrity;

import F0.AbstractC0008a;
import com.google.android.play.core.integrity.StandardIntegrityManager;

/* loaded from: classes.dex */
final class h extends StandardIntegrityManager.StandardIntegrityTokenRequest {

    /* renamed from: a, reason: collision with root package name */
    private final String f4001a;

    public /* synthetic */ h(String str, g gVar) {
        this.f4001a = str;
    }

    @Override // com.google.android.play.core.integrity.StandardIntegrityManager.StandardIntegrityTokenRequest
    public final String a() {
        return this.f4001a;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof StandardIntegrityManager.StandardIntegrityTokenRequest)) {
            return false;
        }
        StandardIntegrityManager.StandardIntegrityTokenRequest standardIntegrityTokenRequest = (StandardIntegrityManager.StandardIntegrityTokenRequest) obj;
        String str = this.f4001a;
        if (str == null) {
            if (standardIntegrityTokenRequest.a() == null) {
                return true;
            }
            return false;
        }
        return str.equals(standardIntegrityTokenRequest.a());
    }

    public final int hashCode() {
        int hashCode;
        String str = this.f4001a;
        if (str == null) {
            hashCode = 0;
        } else {
            hashCode = str.hashCode();
        }
        return hashCode ^ 1000003;
    }

    public final String toString() {
        return AbstractC0008a.u(new StringBuilder("StandardIntegrityTokenRequest{requestHash="), this.f4001a, "}");
    }
}
