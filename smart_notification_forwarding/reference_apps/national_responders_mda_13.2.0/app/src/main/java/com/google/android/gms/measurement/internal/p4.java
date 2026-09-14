package com.google.android.gms.measurement.internal;

import android.content.ContentValues;
import android.database.sqlite.SQLiteException;
import android.text.TextUtils;
import com.google.android.gms.internal.measurement.db;
import com.google.android.gms.internal.measurement.w0;
import com.google.android.gms.internal.measurement.x0;
import java.util.ArrayList;
import java.util.Map;

/* loaded from: classes.dex */
public final class p4 extends b9 implements d {

    /* renamed from: j, reason: collision with root package name */
    private static int f6309j = 65535;

    /* renamed from: k, reason: collision with root package name */
    private static int f6310k = 2;

    /* renamed from: d, reason: collision with root package name */
    private final Map<String, Map<String, String>> f6311d;

    /* renamed from: e, reason: collision with root package name */
    private final Map<String, Map<String, Boolean>> f6312e;

    /* renamed from: f, reason: collision with root package name */
    private final Map<String, Map<String, Boolean>> f6313f;

    /* renamed from: g, reason: collision with root package name */
    private final Map<String, com.google.android.gms.internal.measurement.x0> f6314g;

    /* renamed from: h, reason: collision with root package name */
    private final Map<String, Map<String, Integer>> f6315h;

    /* renamed from: i, reason: collision with root package name */
    private final Map<String, String> f6316i;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p4(e9 e9Var) {
        super(e9Var);
        this.f6311d = new l.a();
        this.f6312e = new l.a();
        this.f6313f = new l.a();
        this.f6314g = new l.a();
        this.f6316i = new l.a();
        this.f6315h = new l.a();
    }

    private final void A(String str, x0.a aVar) {
        l.a aVar2 = new l.a();
        l.a aVar3 = new l.a();
        l.a aVar4 = new l.a();
        if (aVar != null) {
            for (int i10 = 0; i10 < aVar.u(); i10++) {
                w0.a w10 = aVar.w(i10).w();
                if (TextUtils.isEmpty(w10.w())) {
                    h().I().a("EventConfig contained null event name");
                } else {
                    String w11 = w10.w();
                    String b10 = v2.i.b(w10.w());
                    if (!TextUtils.isEmpty(b10)) {
                        w10 = w10.u(b10);
                        aVar.x(i10, w10);
                    }
                    if (!db.a() || !m().t(s.N0)) {
                        w11 = w10.w();
                    }
                    aVar2.put(w11, Boolean.valueOf(w10.x()));
                    aVar3.put(w10.w(), Boolean.valueOf(w10.y()));
                    if (w10.z()) {
                        if (w10.A() < f6310k || w10.A() > f6309j) {
                            h().I().c("Invalid sampling rate. Event name, sample rate", w10.w(), Integer.valueOf(w10.A()));
                        } else {
                            aVar4.put(w10.w(), Integer.valueOf(w10.A()));
                        }
                    }
                }
            }
        }
        this.f6312e.put(str, aVar2);
        this.f6313f.put(str, aVar3);
        this.f6315h.put(str, aVar4);
    }

    private final void M(String str) {
        u();
        c();
        b2.p.g(str);
        if (this.f6314g.get(str) == null) {
            byte[] t02 = r().t0(str);
            if (t02 != null) {
                x0.a w10 = y(str, t02).w();
                A(str, w10);
                this.f6311d.put(str, z((com.google.android.gms.internal.measurement.x0) ((com.google.android.gms.internal.measurement.l7) w10.g())));
                this.f6314g.put(str, (com.google.android.gms.internal.measurement.x0) ((com.google.android.gms.internal.measurement.l7) w10.g()));
                this.f6316i.put(str, null);
                return;
            }
            this.f6311d.put(str, null);
            this.f6312e.put(str, null);
            this.f6313f.put(str, null);
            this.f6314g.put(str, null);
            this.f6316i.put(str, null);
            this.f6315h.put(str, null);
        }
    }

    private final com.google.android.gms.internal.measurement.x0 y(String str, byte[] bArr) {
        if (bArr == null) {
            return com.google.android.gms.internal.measurement.x0.Q();
        }
        try {
            com.google.android.gms.internal.measurement.x0 x0Var = (com.google.android.gms.internal.measurement.x0) ((com.google.android.gms.internal.measurement.l7) ((x0.a) k9.C(com.google.android.gms.internal.measurement.x0.P(), bArr)).g());
            h().N().c("Parsed config. version, gmp_app_id", x0Var.E() ? Long.valueOf(x0Var.F()) : null, x0Var.G() ? x0Var.I() : null);
            return x0Var;
        } catch (com.google.android.gms.internal.measurement.x7 | RuntimeException e10) {
            h().I().c("Unable to merge remote config. appId", r3.x(str), e10);
            return com.google.android.gms.internal.measurement.x0.Q();
        }
    }

    private static Map<String, String> z(com.google.android.gms.internal.measurement.x0 x0Var) {
        l.a aVar = new l.a();
        if (x0Var != null) {
            for (com.google.android.gms.internal.measurement.y0 y0Var : x0Var.J()) {
                aVar.put(y0Var.A(), y0Var.B());
            }
        }
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean B(String str, byte[] bArr, String str2) {
        u();
        c();
        b2.p.g(str);
        x0.a w10 = y(str, bArr).w();
        if (w10 == null) {
            return false;
        }
        A(str, w10);
        this.f6314g.put(str, (com.google.android.gms.internal.measurement.x0) ((com.google.android.gms.internal.measurement.l7) w10.g()));
        this.f6316i.put(str, str2);
        this.f6311d.put(str, z((com.google.android.gms.internal.measurement.x0) ((com.google.android.gms.internal.measurement.l7) w10.g())));
        r().S(str, new ArrayList(w10.y()));
        try {
            w10.z();
            bArr = ((com.google.android.gms.internal.measurement.x0) ((com.google.android.gms.internal.measurement.l7) w10.g())).f();
        } catch (RuntimeException e10) {
            h().I().c("Unable to serialize reduced-size config. Storing full config instead. appId", r3.x(str), e10);
        }
        f r10 = r();
        b2.p.g(str);
        r10.c();
        r10.u();
        new ContentValues().put("remote_config", bArr);
        try {
            if (r10.y().update("apps", r2, "app_id = ?", new String[]{str}) == 0) {
                r10.h().F().b("Failed to update remote config (got 0). appId", r3.x(str));
            }
        } catch (SQLiteException e11) {
            r10.h().F().c("Error storing remote config. appId", r3.x(str), e11);
        }
        this.f6314g.put(str, (com.google.android.gms.internal.measurement.x0) ((com.google.android.gms.internal.measurement.l7) w10.g()));
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final String C(String str) {
        c();
        return this.f6316i.get(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean D(String str, String str2) {
        Boolean bool;
        c();
        M(str);
        if (K(str) && o9.C0(str2)) {
            return true;
        }
        if (L(str) && o9.e0(str2)) {
            return true;
        }
        Map<String, Boolean> map = this.f6312e.get(str);
        if (map == null || (bool = map.get(str2)) == null) {
            return false;
        }
        return bool.booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void E(String str) {
        c();
        this.f6316i.put(str, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean F(String str, String str2) {
        Boolean bool;
        c();
        M(str);
        if ("ecommerce_purchase".equals(str2) || "purchase".equals(str2) || "refund".equals(str2)) {
            return true;
        }
        Map<String, Boolean> map = this.f6313f.get(str);
        if (map == null || (bool = map.get(str2)) == null) {
            return false;
        }
        return bool.booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final int G(String str, String str2) {
        Integer num;
        c();
        M(str);
        Map<String, Integer> map = this.f6315h.get(str);
        if (map == null || (num = map.get(str2)) == null) {
            return 1;
        }
        return num.intValue();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void H(String str) {
        c();
        this.f6314g.remove(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean I(String str) {
        c();
        com.google.android.gms.internal.measurement.x0 x10 = x(str);
        if (x10 == null) {
            return false;
        }
        return x10.O();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final long J(String str) {
        String g10 = g(str, "measurement.account.time_zone_offset_minutes");
        if (TextUtils.isEmpty(g10)) {
            return 0L;
        }
        try {
            return Long.parseLong(g10);
        } catch (NumberFormatException e10) {
            h().I().c("Unable to parse timezone offset. appId", r3.x(str), e10);
            return 0L;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean K(String str) {
        return "1".equals(g(str, "measurement.upload.blacklist_internal"));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean L(String str) {
        return "1".equals(g(str, "measurement.upload.blacklist_public"));
    }

    @Override // com.google.android.gms.measurement.internal.d
    public final String g(String str, String str2) {
        c();
        M(str);
        Map<String, String> map = this.f6311d.get(str);
        if (map != null) {
            return map.get(str2);
        }
        return null;
    }

    @Override // com.google.android.gms.measurement.internal.b9
    protected final boolean w() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final com.google.android.gms.internal.measurement.x0 x(String str) {
        u();
        c();
        b2.p.g(str);
        M(str);
        return this.f6314g.get(str);
    }
}
