package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes.dex */
public final class a extends b2 {

    /* renamed from: b, reason: collision with root package name */
    private final Map<String, Long> f5796b;

    /* renamed from: c, reason: collision with root package name */
    private final Map<String, Integer> f5797c;

    /* renamed from: d, reason: collision with root package name */
    private long f5798d;

    public a(t4 t4Var) {
        super(t4Var);
        this.f5797c = new l.a();
        this.f5796b = new l.a();
    }

    private final void A(String str, long j10, c7 c7Var) {
        if (c7Var == null) {
            h().N().a("Not logging ad unit exposure. No active activity");
            return;
        }
        if (j10 < 1000) {
            h().N().b("Not logging ad unit exposure. Less than 1000 ms. exposure", Long.valueOf(j10));
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putString("_ai", str);
        bundle.putLong("_xt", j10);
        b7.O(c7Var, bundle, true);
        p().R("am", "_xu", bundle);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void B(long j10) {
        Iterator<String> it = this.f5796b.keySet().iterator();
        while (it.hasNext()) {
            this.f5796b.put(it.next(), Long.valueOf(j10));
        }
        if (this.f5796b.isEmpty()) {
            return;
        }
        this.f5798d = j10;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void E(String str, long j10) {
        c();
        b2.p.g(str);
        if (this.f5797c.isEmpty()) {
            this.f5798d = j10;
        }
        Integer num = this.f5797c.get(str);
        if (num != null) {
            this.f5797c.put(str, Integer.valueOf(num.intValue() + 1));
        } else if (this.f5797c.size() >= 100) {
            h().I().a("Too many ads visible");
        } else {
            this.f5797c.put(str, 1);
            this.f5796b.put(str, Long.valueOf(j10));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void F(String str, long j10) {
        c();
        b2.p.g(str);
        Integer num = this.f5797c.get(str);
        if (num == null) {
            h().F().b("Call to endAdUnitExposure for unknown ad unit id", str);
            return;
        }
        c7 D = s().D(false);
        int intValue = num.intValue() - 1;
        if (intValue != 0) {
            this.f5797c.put(str, Integer.valueOf(intValue));
            return;
        }
        this.f5797c.remove(str);
        Long l10 = this.f5796b.get(str);
        if (l10 == null) {
            h().F().a("First ad unit exposure time was never set");
        } else {
            long longValue = j10 - l10.longValue();
            this.f5796b.remove(str);
            A(str, longValue, D);
        }
        if (this.f5797c.isEmpty()) {
            long j11 = this.f5798d;
            if (j11 == 0) {
                h().F().a("First ad exposure time was never set");
            } else {
                w(j10 - j11, D);
                this.f5798d = 0L;
            }
        }
    }

    private final void w(long j10, c7 c7Var) {
        if (c7Var == null) {
            h().N().a("Not logging ad exposure. No active activity");
            return;
        }
        if (j10 < 1000) {
            h().N().b("Not logging ad exposure. Less than 1000 ms. exposure", Long.valueOf(j10));
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putLong("_xt", j10);
        b7.O(c7Var, bundle, true);
        p().R("am", "_xa", bundle);
    }

    public final void D(String str, long j10) {
        if (str == null || str.length() == 0) {
            h().F().a("Ad unit id must be a non-empty string");
        } else {
            e().z(new z(this, str, j10));
        }
    }

    public final void v(long j10) {
        c7 D = s().D(false);
        for (String str : this.f5796b.keySet()) {
            A(str, j10 - this.f5796b.get(str).longValue(), D);
        }
        if (!this.f5796b.isEmpty()) {
            w(j10 - this.f5798d, D);
        }
        B(j10);
    }

    public final void z(String str, long j10) {
        if (str == null || str.length() == 0) {
            h().F().a("Ad unit id must be a non-empty string");
        } else {
            e().z(new a1(this, str, j10));
        }
    }
}
