package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.text.TextUtils;
import java.util.Iterator;

/* loaded from: classes.dex */
public final class n {

    /* renamed from: a, reason: collision with root package name */
    final String f6237a;

    /* renamed from: b, reason: collision with root package name */
    final String f6238b;

    /* renamed from: c, reason: collision with root package name */
    private final String f6239c;

    /* renamed from: d, reason: collision with root package name */
    final long f6240d;

    /* renamed from: e, reason: collision with root package name */
    final long f6241e;

    /* renamed from: f, reason: collision with root package name */
    final p f6242f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(t4 t4Var, String str, String str2, String str3, long j10, long j11, Bundle bundle) {
        p pVar;
        b2.p.g(str2);
        b2.p.g(str3);
        this.f6237a = str2;
        this.f6238b = str3;
        this.f6239c = TextUtils.isEmpty(str) ? null : str;
        this.f6240d = j10;
        this.f6241e = j11;
        if (j11 != 0 && j11 > j10) {
            t4Var.h().I().b("Event created with reverse previous/current timestamps. appId", r3.x(str2));
        }
        if (bundle == null || bundle.isEmpty()) {
            pVar = new p(new Bundle());
        } else {
            Bundle bundle2 = new Bundle(bundle);
            Iterator<String> it = bundle2.keySet().iterator();
            while (it.hasNext()) {
                String next = it.next();
                if (next == null) {
                    t4Var.h().F().a("Param name can't be null");
                } else {
                    Object H = t4Var.G().H(next, bundle2.get(next));
                    if (H == null) {
                        t4Var.h().I().b("Param value can't be null", t4Var.H().z(next));
                    } else {
                        t4Var.G().N(bundle2, next, H);
                    }
                }
                it.remove();
            }
            pVar = new p(bundle2);
        }
        this.f6242f = pVar;
    }

    private n(t4 t4Var, String str, String str2, String str3, long j10, long j11, p pVar) {
        b2.p.g(str2);
        b2.p.g(str3);
        b2.p.k(pVar);
        this.f6237a = str2;
        this.f6238b = str3;
        this.f6239c = TextUtils.isEmpty(str) ? null : str;
        this.f6240d = j10;
        this.f6241e = j11;
        if (j11 != 0 && j11 > j10) {
            t4Var.h().I().c("Event created with reverse previous/current timestamps. appId, name", r3.x(str2), r3.x(str3));
        }
        this.f6242f = pVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final n a(t4 t4Var, long j10) {
        return new n(t4Var, this.f6239c, this.f6237a, this.f6238b, this.f6240d, j10, this.f6242f);
    }

    public final String toString() {
        String str = this.f6237a;
        String str2 = this.f6238b;
        String valueOf = String.valueOf(this.f6242f);
        StringBuilder sb2 = new StringBuilder(String.valueOf(str).length() + 33 + String.valueOf(str2).length() + valueOf.length());
        sb2.append("Event{appId='");
        sb2.append(str);
        sb2.append("', name='");
        sb2.append(str2);
        sb2.append("', params=");
        sb2.append(valueOf);
        sb2.append('}');
        return sb2.toString();
    }
}
