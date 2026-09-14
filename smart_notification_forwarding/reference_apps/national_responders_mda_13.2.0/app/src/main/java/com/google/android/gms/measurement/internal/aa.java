package com.google.android.gms.measurement.internal;

import android.database.sqlite.SQLiteException;
import android.text.TextUtils;
import android.util.Pair;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class aa {

    /* renamed from: a, reason: collision with root package name */
    private com.google.android.gms.internal.measurement.d1 f5819a;

    /* renamed from: b, reason: collision with root package name */
    private Long f5820b;

    /* renamed from: c, reason: collision with root package name */
    private long f5821c;

    /* renamed from: d, reason: collision with root package name */
    private final /* synthetic */ z9 f5822d;

    private aa(z9 z9Var) {
        this.f5822d = z9Var;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ aa(z9 z9Var, y9 y9Var) {
        this(z9Var);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final com.google.android.gms.internal.measurement.d1 a(String str, com.google.android.gms.internal.measurement.d1 d1Var) {
        t3 G;
        String str2;
        Object obj;
        String V = d1Var.V();
        List<com.google.android.gms.internal.measurement.f1> B = d1Var.B();
        this.f5822d.o();
        Long l10 = (Long) k9.X(d1Var, "_eid");
        boolean z10 = l10 != null;
        if (z10 && V.equals("_ep")) {
            this.f5822d.o();
            V = (String) k9.X(d1Var, "_en");
            if (TextUtils.isEmpty(V)) {
                this.f5822d.h().G().b("Extra parameter without an event name. eventId", l10);
                return null;
            }
            if (this.f5819a == null || this.f5820b == null || l10.longValue() != this.f5820b.longValue()) {
                Pair<com.google.android.gms.internal.measurement.d1, Long> D = this.f5822d.r().D(str, l10);
                if (D == null || (obj = D.first) == null) {
                    this.f5822d.h().G().c("Extra parameter without existing main event. eventName, eventId", V, l10);
                    return null;
                }
                this.f5819a = (com.google.android.gms.internal.measurement.d1) obj;
                this.f5821c = ((Long) D.second).longValue();
                this.f5822d.o();
                this.f5820b = (Long) k9.X(this.f5819a, "_eid");
            }
            long j10 = this.f5821c - 1;
            this.f5821c = j10;
            if (j10 <= 0) {
                f r10 = this.f5822d.r();
                r10.c();
                r10.h().N().b("Clearing complex main event info. appId", str);
                try {
                    r10.y().execSQL("delete from main_event_params where app_id=?", new String[]{str});
                } catch (SQLiteException e10) {
                    r10.h().F().b("Error clearing complex main event", e10);
                }
            } else {
                this.f5822d.r().b0(str, l10, this.f5821c, this.f5819a);
            }
            ArrayList arrayList = new ArrayList();
            for (com.google.android.gms.internal.measurement.f1 f1Var : this.f5819a.B()) {
                this.f5822d.o();
                if (k9.B(d1Var, f1Var.O()) == null) {
                    arrayList.add(f1Var);
                }
            }
            if (arrayList.isEmpty()) {
                G = this.f5822d.h().G();
                str2 = "No unique parameters in main event. eventName";
                G.b(str2, V);
            } else {
                arrayList.addAll(B);
                B = arrayList;
            }
        } else if (z10) {
            this.f5820b = l10;
            this.f5819a = d1Var;
            this.f5822d.o();
            Object X = k9.X(d1Var, "_epc");
            long longValue = ((Long) (X != null ? X : 0L)).longValue();
            this.f5821c = longValue;
            if (longValue <= 0) {
                G = this.f5822d.h().G();
                str2 = "Complex event with zero extra param count. eventName";
                G.b(str2, V);
            } else {
                this.f5822d.r().b0(str, l10, this.f5821c, d1Var);
            }
        }
        return (com.google.android.gms.internal.measurement.d1) ((com.google.android.gms.internal.measurement.l7) d1Var.w().B(V).J().A(B).g());
    }
}
