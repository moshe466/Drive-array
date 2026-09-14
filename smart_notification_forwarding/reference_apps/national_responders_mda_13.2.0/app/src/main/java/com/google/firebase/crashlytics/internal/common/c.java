package com.google.firebase.crashlytics.internal.common;

import java.util.Objects;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class c extends p {

    /* renamed from: a, reason: collision with root package name */
    private final w3.v f7077a;

    /* renamed from: b, reason: collision with root package name */
    private final String f7078b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(w3.v vVar, String str) {
        Objects.requireNonNull(vVar, "Null report");
        this.f7077a = vVar;
        Objects.requireNonNull(str, "Null sessionId");
        this.f7078b = str;
    }

    @Override // com.google.firebase.crashlytics.internal.common.p
    public w3.v b() {
        return this.f7077a;
    }

    @Override // com.google.firebase.crashlytics.internal.common.p
    public String c() {
        return this.f7078b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof p)) {
            return false;
        }
        p pVar = (p) obj;
        return this.f7077a.equals(pVar.b()) && this.f7078b.equals(pVar.c());
    }

    public int hashCode() {
        return ((this.f7077a.hashCode() ^ 1000003) * 1000003) ^ this.f7078b.hashCode();
    }

    public String toString() {
        return "CrashlyticsReportWithSessionId{report=" + this.f7077a + ", sessionId=" + this.f7078b + "}";
    }
}
