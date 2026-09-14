package com.google.android.gms.internal.p002firebaseauthapi;

import java.util.Iterator;
import java.util.Map;

/* loaded from: classes.dex */
final class zzami<T> implements zzamv<T> {
    private final zzamc zza;
    private final zzano<?, ?> zzb;
    private final boolean zzc;
    private final zzakm<?> zzd;

    private zzami(zzano<?, ?> zzanoVar, zzakm<?> zzakmVar, zzamc zzamcVar) {
        this.zzb = zzanoVar;
        this.zzc = zzakmVar.zza(zzamcVar);
        this.zzd = zzakmVar;
        this.zza = zzamcVar;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzamv
    public final int zza(T t3) {
        zzano<?, ?> zzanoVar = this.zzb;
        int zzb = zzanoVar.zzb(zzanoVar.zzd(t3));
        return this.zzc ? zzb + this.zzd.zza(t3).zza() : zzb;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzamv
    public final int zzb(T t3) {
        int hashCode = this.zzb.zzd(t3).hashCode();
        return this.zzc ? (hashCode * 53) + this.zzd.zza(t3).hashCode() : hashCode;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzamv
    public final void zzd(T t3) {
        this.zzb.zzf(t3);
        this.zzd.zzc(t3);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzamv
    public final boolean zze(T t3) {
        return this.zzd.zza(t3).zzg();
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzamv
    public final boolean zzb(T t3, T t4) {
        if (!this.zzb.zzd(t3).equals(this.zzb.zzd(t4))) {
            return false;
        }
        if (this.zzc) {
            return this.zzd.zza(t3).equals(this.zzd.zza(t4));
        }
        return true;
    }

    public static <T> zzami<T> zza(zzano<?, ?> zzanoVar, zzakm<?> zzakmVar, zzamc zzamcVar) {
        return new zzami<>(zzanoVar, zzakmVar, zzamcVar);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzamv
    public final T zza() {
        zzamc zzamcVar = this.zza;
        if (zzamcVar instanceof zzaky) {
            return (T) ((zzaky) zzamcVar).zzo();
        }
        return (T) zzamcVar.zzq().zzf();
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzamv
    public final void zza(T t3, T t4) {
        zzamx.zza(this.zzb, t3, t4);
        if (this.zzc) {
            zzamx.zza(this.zzd, t3, t4);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0089 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:20:? A[LOOP:0: B:2:0x000c->B:20:?, LOOP_END, SYNTHETIC] */
    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzamv
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void zza(T r12, com.google.android.gms.internal.p002firebaseauthapi.zzams r13, com.google.android.gms.internal.p002firebaseauthapi.zzakk r14) {
        /*
            r11 = this;
            com.google.android.gms.internal.firebase-auth-api.zzano<?, ?> r0 = r11.zzb
            com.google.android.gms.internal.firebase-auth-api.zzakm<?> r1 = r11.zzd
            java.lang.Object r2 = r0.zzc(r12)
            com.google.android.gms.internal.firebase-auth-api.zzakr r3 = r1.zzb(r12)
        Lc:
            int r4 = r13.zzc()     // Catch: java.lang.Throwable -> L35
            r5 = 2147483647(0x7fffffff, float:NaN)
            if (r4 != r5) goto L19
            r0.zzb(r12, r2)
            return
        L19:
            int r4 = r13.zzd()     // Catch: java.lang.Throwable -> L35
            r6 = 11
            r7 = 0
            if (r4 == r6) goto L41
            r5 = r4 & 7
            r6 = 2
            if (r5 != r6) goto L3c
            com.google.android.gms.internal.firebase-auth-api.zzamc r5 = r11.zza     // Catch: java.lang.Throwable -> L35
            int r4 = r4 >>> 3
            java.lang.Object r4 = r1.zza(r14, r5, r4)     // Catch: java.lang.Throwable -> L35
            if (r4 == 0) goto L37
            r1.zza(r13, r4, r14, r3)     // Catch: java.lang.Throwable -> L35
            goto L86
        L35:
            r13 = move-exception
            goto L92
        L37:
            boolean r4 = r0.zza(r2, r13, r7)     // Catch: java.lang.Throwable -> L35
            goto L87
        L3c:
            boolean r4 = r13.zzt()     // Catch: java.lang.Throwable -> L35
            goto L87
        L41:
            r4 = 0
            r6 = r4
        L43:
            int r8 = r13.zzc()     // Catch: java.lang.Throwable -> L35
            r9 = 12
            if (r8 == r5) goto L75
            int r8 = r13.zzd()     // Catch: java.lang.Throwable -> L35
            r10 = 16
            if (r8 != r10) goto L5e
            int r7 = r13.zzj()     // Catch: java.lang.Throwable -> L35
            com.google.android.gms.internal.firebase-auth-api.zzamc r4 = r11.zza     // Catch: java.lang.Throwable -> L35
            java.lang.Object r4 = r1.zza(r14, r4, r7)     // Catch: java.lang.Throwable -> L35
            goto L43
        L5e:
            r10 = 26
            if (r8 != r10) goto L6d
            if (r4 == 0) goto L68
            r1.zza(r13, r4, r14, r3)     // Catch: java.lang.Throwable -> L35
            goto L43
        L68:
            com.google.android.gms.internal.firebase-auth-api.zzajp r6 = r13.zzp()     // Catch: java.lang.Throwable -> L35
            goto L43
        L6d:
            if (r8 == r9) goto L75
            boolean r8 = r13.zzt()     // Catch: java.lang.Throwable -> L35
            if (r8 != 0) goto L43
        L75:
            int r5 = r13.zzd()     // Catch: java.lang.Throwable -> L35
            if (r5 != r9) goto L8d
            if (r6 == 0) goto L86
            if (r4 == 0) goto L83
            r1.zza(r6, r4, r14, r3)     // Catch: java.lang.Throwable -> L35
            goto L86
        L83:
            r0.zza(r2, r7, r6)     // Catch: java.lang.Throwable -> L35
        L86:
            r4 = 1
        L87:
            if (r4 != 0) goto Lc
            r0.zzb(r12, r2)
            return
        L8d:
            com.google.android.gms.internal.firebase-auth-api.zzalf r13 = com.google.android.gms.internal.p002firebaseauthapi.zzalf.zzb()     // Catch: java.lang.Throwable -> L35
            throw r13     // Catch: java.lang.Throwable -> L35
        L92:
            r0.zzb(r12, r2)
            throw r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.p002firebaseauthapi.zzami.zza(java.lang.Object, com.google.android.gms.internal.firebase-auth-api.zzams, com.google.android.gms.internal.firebase-auth-api.zzakk):void");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:22:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00a1 A[EDGE_INSN: B:24:0x00a1->B:25:0x00a1 BREAK  A[LOOP:1: B:10:0x0059->B:18:0x0059], SYNTHETIC] */
    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzamv
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void zza(T r10, byte[] r11, int r12, int r13, com.google.android.gms.internal.p002firebaseauthapi.zzajk r14) {
        /*
            r9 = this;
            r0 = r10
            com.google.android.gms.internal.firebase-auth-api.zzaky r0 = (com.google.android.gms.internal.p002firebaseauthapi.zzaky) r0
            com.google.android.gms.internal.firebase-auth-api.zzann r1 = r0.zzb
            com.google.android.gms.internal.firebase-auth-api.zzann r2 = com.google.android.gms.internal.p002firebaseauthapi.zzann.zzc()
            if (r1 != r2) goto L11
            com.google.android.gms.internal.firebase-auth-api.zzann r1 = com.google.android.gms.internal.p002firebaseauthapi.zzann.zzd()
            r0.zzb = r1
        L11:
            r6 = r1
            com.google.android.gms.internal.firebase-auth-api.zzaky$zzb r10 = (com.google.android.gms.internal.firebase-auth-api.zzaky.zzb) r10
            r10.zza()
            r10 = 0
            r0 = r10
        L19:
            if (r12 >= r13) goto Laf
            int r4 = com.google.android.gms.internal.p002firebaseauthapi.zzajl.zzc(r11, r12, r14)
            int r2 = r14.zza
            r12 = 11
            r1 = 2
            if (r2 == r12) goto L54
            r12 = r2 & 7
            if (r12 != r1) goto L4c
            com.google.android.gms.internal.firebase-auth-api.zzakm<?> r12 = r9.zzd
            com.google.android.gms.internal.firebase-auth-api.zzakk r0 = r14.zzd
            com.google.android.gms.internal.firebase-auth-api.zzamc r1 = r9.zza
            int r3 = r2 >>> 3
            java.lang.Object r12 = r12.zza(r0, r1, r3)
            r0 = r12
            com.google.android.gms.internal.firebase-auth-api.zzaky$zzd r0 = (com.google.android.gms.internal.firebase-auth-api.zzaky.zzd) r0
            if (r0 != 0) goto L43
            r3 = r11
            r5 = r13
            r7 = r14
            int r12 = com.google.android.gms.internal.p002firebaseauthapi.zzajl.zza(r2, r3, r4, r5, r6, r7)
            goto L19
        L43:
            com.google.android.gms.internal.p002firebaseauthapi.zzamr.zza()
            java.lang.NoSuchMethodError r10 = new java.lang.NoSuchMethodError
            r10.<init>()
            throw r10
        L4c:
            r3 = r11
            r5 = r13
            r7 = r14
            int r12 = com.google.android.gms.internal.p002firebaseauthapi.zzajl.zza(r2, r3, r4, r5, r7)
            goto L19
        L54:
            r3 = r11
            r5 = r13
            r7 = r14
            r11 = 0
            r12 = r10
        L59:
            if (r4 >= r5) goto La0
            int r13 = com.google.android.gms.internal.p002firebaseauthapi.zzajl.zzc(r3, r4, r7)
            int r14 = r7.zza
            int r2 = r14 >>> 3
            r4 = r14 & 7
            if (r2 == r1) goto L81
            r8 = 3
            if (r2 == r8) goto L6b
            goto L97
        L6b:
            if (r0 != 0) goto L78
            if (r4 != r1) goto L97
            int r4 = com.google.android.gms.internal.p002firebaseauthapi.zzajl.zza(r3, r13, r7)
            java.lang.Object r12 = r7.zzc
            com.google.android.gms.internal.firebase-auth-api.zzajp r12 = (com.google.android.gms.internal.p002firebaseauthapi.zzajp) r12
            goto L59
        L78:
            com.google.android.gms.internal.p002firebaseauthapi.zzamr.zza()
            java.lang.NoSuchMethodError r10 = new java.lang.NoSuchMethodError
            r10.<init>()
            throw r10
        L81:
            if (r4 != 0) goto L97
            int r4 = com.google.android.gms.internal.p002firebaseauthapi.zzajl.zzc(r3, r13, r7)
            int r11 = r7.zza
            com.google.android.gms.internal.firebase-auth-api.zzakm<?> r13 = r9.zzd
            com.google.android.gms.internal.firebase-auth-api.zzakk r14 = r7.zzd
            com.google.android.gms.internal.firebase-auth-api.zzamc r0 = r9.zza
            java.lang.Object r13 = r13.zza(r14, r0, r11)
            r0 = r13
            com.google.android.gms.internal.firebase-auth-api.zzaky$zzd r0 = (com.google.android.gms.internal.firebase-auth-api.zzaky.zzd) r0
            goto L59
        L97:
            r2 = 12
            if (r14 == r2) goto La1
            int r4 = com.google.android.gms.internal.p002firebaseauthapi.zzajl.zza(r14, r3, r13, r5, r7)
            goto L59
        La0:
            r13 = r4
        La1:
            if (r12 == 0) goto La9
            int r11 = r11 << 3
            r11 = r11 | r1
            r6.zza(r11, r12)
        La9:
            r12 = r13
            r11 = r3
            r13 = r5
            r14 = r7
            goto L19
        Laf:
            r5 = r13
            if (r12 != r5) goto Lb3
            return
        Lb3:
            com.google.android.gms.internal.firebase-auth-api.zzalf r10 = com.google.android.gms.internal.p002firebaseauthapi.zzalf.zzg()
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.p002firebaseauthapi.zzami.zza(java.lang.Object, byte[], int, int, com.google.android.gms.internal.firebase-auth-api.zzajk):void");
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzamv
    public final void zza(T t3, zzaof zzaofVar) {
        Iterator<Map.Entry<?, Object>> zzd = this.zzd.zza(t3).zzd();
        while (zzd.hasNext()) {
            Map.Entry<?, Object> next = zzd.next();
            zzakt zzaktVar = (zzakt) next.getKey();
            if (zzaktVar.zzc() == zzaod.MESSAGE && !zzaktVar.zze() && !zzaktVar.zzd()) {
                if (next instanceof zzalj) {
                    zzaofVar.zza(zzaktVar.zza(), (Object) ((zzalj) next).zza().zzb());
                } else {
                    zzaofVar.zza(zzaktVar.zza(), next.getValue());
                }
            } else {
                throw new IllegalStateException("Found invalid MessageSet item.");
            }
        }
        zzano<?, ?> zzanoVar = this.zzb;
        zzanoVar.zza((zzano<?, ?>) zzanoVar.zzd(t3), zzaofVar);
    }
}
