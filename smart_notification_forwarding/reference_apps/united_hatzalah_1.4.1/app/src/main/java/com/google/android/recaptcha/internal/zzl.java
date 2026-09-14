package com.google.android.recaptcha.internal;

import P2.G;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.j;
import t2.AbstractC0705g;
import t2.C0716r;
import w2.InterfaceC0763d;

/* loaded from: classes.dex */
public final class zzl {
    private final List zza;
    private zzek zzb;

    /* JADX WARN: Multi-variable type inference failed */
    public zzl() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    private final void zzh(zze... elements) {
        List list = this.zza;
        j.e(list, "<this>");
        j.e(elements, "elements");
        list.addAll(AbstractC0705g.B(elements));
    }

    public final Object zzb(String str, long j2, InterfaceC0763d interfaceC0763d) {
        return G.g(new zzh(this, str, j2, null), interfaceC0763d);
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0031  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object zzc(long r12, com.google.android.recaptcha.internal.zzsc r14, com.google.android.recaptcha.internal.zzek r15, w2.InterfaceC0763d r16) {
        /*
            r11 = this;
            r0 = r16
            boolean r1 = r0 instanceof com.google.android.recaptcha.internal.zzi
            if (r1 == 0) goto L15
            r1 = r0
            com.google.android.recaptcha.internal.zzi r1 = (com.google.android.recaptcha.internal.zzi) r1
            int r2 = r1.zzc
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r4 = r2 & r3
            if (r4 == 0) goto L15
            int r2 = r2 - r3
            r1.zzc = r2
            goto L1a
        L15:
            com.google.android.recaptcha.internal.zzi r1 = new com.google.android.recaptcha.internal.zzi
            r1.<init>(r11, r0)
        L1a:
            java.lang.Object r0 = r1.zza
            x2.a r9 = x2.EnumC0779a.f6740a
            int r2 = r1.zzc
            r10 = 1
            if (r2 == 0) goto L31
            if (r2 != r10) goto L29
            a.AbstractC0228a.C(r0)
            goto L47
        L29:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L31:
            a.AbstractC0228a.C(r0)
            com.google.android.recaptcha.internal.zzk r2 = new com.google.android.recaptcha.internal.zzk
            r8 = 0
            r3 = r11
            r5 = r12
            r7 = r14
            r4 = r15
            r2.<init>(r3, r4, r5, r7, r8)
            r1.zzc = r10
            java.lang.Object r0 = P2.G.g(r2, r1)
            if (r0 != r9) goto L47
            return r9
        L47:
            s2.f r0 = (s2.C0681f) r0
            java.lang.Object r0 = r0.f6335a
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.recaptcha.internal.zzl.zzc(long, com.google.android.recaptcha.internal.zzsc, com.google.android.recaptcha.internal.zzek, w2.d):java.lang.Object");
    }

    public final List zzd() {
        return this.zza;
    }

    public final void zzf(zze... zzeVarArr) {
        zzh((zze[]) Arrays.copyOf(zzeVarArr, 1));
    }

    public final void zzg(zzsr zzsrVar) {
        Iterator it = this.zza.iterator();
        while (it.hasNext()) {
            ((zze) it.next()).zzk(zzsrVar);
        }
    }

    public /* synthetic */ zzl(List list, int i, f fVar) {
        this.zza = new ArrayList();
        zze[] zzeVarArr = (zze[]) C0716r.f6476a.toArray(new zze[0]);
        zzh((zze[]) Arrays.copyOf(zzeVarArr, zzeVarArr.length));
    }
}
