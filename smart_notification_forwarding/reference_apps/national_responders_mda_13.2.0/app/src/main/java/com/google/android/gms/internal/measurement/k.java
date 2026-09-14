package com.google.android.gms.internal.measurement;

import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.internal.measurement.h;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class k extends h.a {

    /* renamed from: j, reason: collision with root package name */
    private final /* synthetic */ String f5416j;

    /* renamed from: k, reason: collision with root package name */
    private final /* synthetic */ String f5417k;

    /* renamed from: l, reason: collision with root package name */
    private final /* synthetic */ Context f5418l;

    /* renamed from: m, reason: collision with root package name */
    private final /* synthetic */ Bundle f5419m;

    /* renamed from: n, reason: collision with root package name */
    private final /* synthetic */ h f5420n;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k(h hVar, String str, String str2, Context context, Bundle bundle) {
        super(hVar);
        this.f5420n = hVar;
        this.f5416j = str;
        this.f5417k = str2;
        this.f5418l = context;
        this.f5419m = bundle;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0048 A[Catch: Exception -> 0x008f, TryCatch #0 {Exception -> 0x008f, blocks: (B:3:0x0002, B:5:0x000f, B:6:0x0020, B:11:0x0035, B:13:0x0048, B:16:0x004e, B:18:0x005c, B:22:0x0071), top: B:2:0x0002 }] */
    /* JADX WARN: Removed duplicated region for block: B:16:0x004e A[Catch: Exception -> 0x008f, TryCatch #0 {Exception -> 0x008f, blocks: (B:3:0x0002, B:5:0x000f, B:6:0x0020, B:11:0x0035, B:13:0x0048, B:16:0x004e, B:18:0x005c, B:22:0x0071), top: B:2:0x0002 }] */
    @Override // com.google.android.gms.internal.measurement.h.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void a() {
        /*
            r14 = this;
            r0 = 0
            r1 = 1
            com.google.android.gms.internal.measurement.h r2 = r14.f5420n     // Catch: java.lang.Exception -> L8f
            java.lang.String r3 = r14.f5416j     // Catch: java.lang.Exception -> L8f
            java.lang.String r4 = r14.f5417k     // Catch: java.lang.Exception -> L8f
            boolean r2 = com.google.android.gms.internal.measurement.h.u(r2, r3, r4)     // Catch: java.lang.Exception -> L8f
            r3 = 0
            if (r2 == 0) goto L1d
            java.lang.String r3 = r14.f5417k     // Catch: java.lang.Exception -> L8f
            java.lang.String r2 = r14.f5416j     // Catch: java.lang.Exception -> L8f
            com.google.android.gms.internal.measurement.h r4 = r14.f5420n     // Catch: java.lang.Exception -> L8f
            java.lang.String r4 = com.google.android.gms.internal.measurement.h.v(r4)     // Catch: java.lang.Exception -> L8f
            r10 = r2
            r11 = r3
            r9 = r4
            goto L20
        L1d:
            r9 = r3
            r10 = r9
            r11 = r10
        L20:
            android.content.Context r2 = r14.f5418l     // Catch: java.lang.Exception -> L8f
            com.google.android.gms.internal.measurement.h.x(r2)     // Catch: java.lang.Exception -> L8f
            java.lang.Boolean r2 = com.google.android.gms.internal.measurement.h.P()     // Catch: java.lang.Exception -> L8f
            boolean r2 = r2.booleanValue()     // Catch: java.lang.Exception -> L8f
            if (r2 != 0) goto L34
            if (r10 == 0) goto L32
            goto L34
        L32:
            r2 = 0
            goto L35
        L34:
            r2 = 1
        L35:
            com.google.android.gms.internal.measurement.h r3 = r14.f5420n     // Catch: java.lang.Exception -> L8f
            android.content.Context r4 = r14.f5418l     // Catch: java.lang.Exception -> L8f
            com.google.android.gms.internal.measurement.qf r4 = r3.c(r4, r2)     // Catch: java.lang.Exception -> L8f
            com.google.android.gms.internal.measurement.h.d(r3, r4)     // Catch: java.lang.Exception -> L8f
            com.google.android.gms.internal.measurement.h r3 = r14.f5420n     // Catch: java.lang.Exception -> L8f
            com.google.android.gms.internal.measurement.qf r3 = com.google.android.gms.internal.measurement.h.B(r3)     // Catch: java.lang.Exception -> L8f
            if (r3 != 0) goto L4e
            com.google.android.gms.internal.measurement.h r2 = r14.f5420n     // Catch: java.lang.Exception -> L8f
            com.google.android.gms.internal.measurement.h.v(r2)     // Catch: java.lang.Exception -> L8f
            return
        L4e:
            android.content.Context r3 = r14.f5418l     // Catch: java.lang.Exception -> L8f
            int r3 = com.google.android.gms.internal.measurement.h.A(r3)     // Catch: java.lang.Exception -> L8f
            android.content.Context r4 = r14.f5418l     // Catch: java.lang.Exception -> L8f
            int r4 = com.google.android.gms.internal.measurement.h.F(r4)     // Catch: java.lang.Exception -> L8f
            if (r2 == 0) goto L67
            int r2 = java.lang.Math.max(r3, r4)     // Catch: java.lang.Exception -> L8f
            if (r4 >= r3) goto L64
            r3 = 1
            goto L65
        L64:
            r3 = 0
        L65:
            r8 = r3
            goto L71
        L67:
            if (r3 <= 0) goto L6a
            r4 = r3
        L6a:
            if (r3 <= 0) goto L6e
            r2 = 1
            goto L6f
        L6e:
            r2 = 0
        L6f:
            r8 = r2
            r2 = r4
        L71:
            com.google.android.gms.internal.measurement.f r13 = new com.google.android.gms.internal.measurement.f     // Catch: java.lang.Exception -> L8f
            r4 = 33025(0x8101, double:1.63165E-319)
            long r6 = (long) r2     // Catch: java.lang.Exception -> L8f
            android.os.Bundle r12 = r14.f5419m     // Catch: java.lang.Exception -> L8f
            r3 = r13
            r3.<init>(r4, r6, r8, r9, r10, r11, r12)     // Catch: java.lang.Exception -> L8f
            com.google.android.gms.internal.measurement.h r2 = r14.f5420n     // Catch: java.lang.Exception -> L8f
            com.google.android.gms.internal.measurement.qf r2 = com.google.android.gms.internal.measurement.h.B(r2)     // Catch: java.lang.Exception -> L8f
            android.content.Context r3 = r14.f5418l     // Catch: java.lang.Exception -> L8f
            j2.a r3 = j2.b.z(r3)     // Catch: java.lang.Exception -> L8f
            long r4 = r14.f5358f     // Catch: java.lang.Exception -> L8f
            r2.initialize(r3, r13, r4)     // Catch: java.lang.Exception -> L8f
            return
        L8f:
            r2 = move-exception
            com.google.android.gms.internal.measurement.h r3 = r14.f5420n
            com.google.android.gms.internal.measurement.h.l(r3, r2, r1, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.k.a():void");
    }
}
