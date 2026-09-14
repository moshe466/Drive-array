package com.google.android.gms.internal.ads;

import io.fabric.sdk.android.services.network.HttpRequest;
import java.nio.charset.Charset;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* loaded from: classes.dex */
public final class zzdiq<P> {
    private static final Charset UTF_8 = Charset.forName(HttpRequest.CHARSET_UTF8);
    private final Class<P> zzgxu;
    private ConcurrentMap<String, List<zzdip<P>>> zzgye = new ConcurrentHashMap();
    private zzdip<P> zzgyf;

    private zzdiq(Class<P> cls) {
        this.zzgxu = cls;
    }

    public static <P> zzdiq<P> zza(Class<P> cls) {
        return new zzdiq<>(cls);
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0078  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final com.google.android.gms.internal.ads.zzdip<P> zza(P r6, com.google.android.gms.internal.ads.zzdnk.zza r7) {
        /*
            r5 = this;
            com.google.android.gms.internal.ads.zzdne r0 = r7.zzasj()
            com.google.android.gms.internal.ads.zzdne r1 = com.google.android.gms.internal.ads.zzdne.ENABLED
            if (r0 != r1) goto L8d
            com.google.android.gms.internal.ads.zzdip r0 = new com.google.android.gms.internal.ads.zzdip
            int[] r1 = com.google.android.gms.internal.ads.zzdic.a
            com.google.android.gms.internal.ads.zzdnw r2 = r7.zzask()
            int r2 = r2.ordinal()
            r1 = r1[r2]
            r2 = 5
            r3 = 1
            if (r1 == r3) goto L37
            r4 = 2
            if (r1 == r4) goto L37
            r4 = 3
            if (r1 == r4) goto L2e
            r2 = 4
            if (r1 != r2) goto L26
            byte[] r1 = com.google.android.gms.internal.ads.zzdhz.zzgxq
            goto L4c
        L26:
            java.security.GeneralSecurityException r6 = new java.security.GeneralSecurityException
            java.lang.String r7 = "unknown output prefix type"
            r6.<init>(r7)
            throw r6
        L2e:
            java.nio.ByteBuffer r1 = java.nio.ByteBuffer.allocate(r2)
            java.nio.ByteBuffer r1 = r1.put(r3)
            goto L40
        L37:
            java.nio.ByteBuffer r1 = java.nio.ByteBuffer.allocate(r2)
            r2 = 0
            java.nio.ByteBuffer r1 = r1.put(r2)
        L40:
            int r2 = r7.zzawb()
            java.nio.ByteBuffer r1 = r1.putInt(r2)
            byte[] r1 = r1.array()
        L4c:
            com.google.android.gms.internal.ads.zzdne r2 = r7.zzasj()
            com.google.android.gms.internal.ads.zzdnw r7 = r7.zzask()
            r0.<init>(r6, r1, r2, r7)
            java.util.ArrayList r6 = new java.util.ArrayList
            r6.<init>()
            r6.add(r0)
            java.lang.String r7 = new java.lang.String
            byte[] r1 = r0.zzasl()
            java.nio.charset.Charset r2 = com.google.android.gms.internal.ads.zzdiq.UTF_8
            r7.<init>(r1, r2)
            java.util.concurrent.ConcurrentMap<java.lang.String, java.util.List<com.google.android.gms.internal.ads.zzdip<P>>> r1 = r5.zzgye
            java.util.List r6 = java.util.Collections.unmodifiableList(r6)
            java.lang.Object r6 = r1.put(r7, r6)
            java.util.List r6 = (java.util.List) r6
            if (r6 == 0) goto L8c
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            r1.addAll(r6)
            r1.add(r0)
            java.util.concurrent.ConcurrentMap<java.lang.String, java.util.List<com.google.android.gms.internal.ads.zzdip<P>>> r6 = r5.zzgye
            java.util.List r1 = java.util.Collections.unmodifiableList(r1)
            r6.put(r7, r1)
        L8c:
            return r0
        L8d:
            java.security.GeneralSecurityException r6 = new java.security.GeneralSecurityException
            java.lang.String r7 = "only ENABLED key is allowed"
            r6.<init>(r7)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzdiq.zza(java.lang.Object, com.google.android.gms.internal.ads.zzdnk$zza):com.google.android.gms.internal.ads.zzdip");
    }

    public final void zza(zzdip<P> zzdipVar) {
        if (zzdipVar == null) {
            throw new IllegalArgumentException("the primary entry must be non-null");
        }
        if (zzdipVar.zzasj() != zzdne.ENABLED) {
            throw new IllegalArgumentException("the primary entry has to be ENABLED");
        }
        List<zzdip<P>> list = this.zzgye.get(new String(zzdipVar.zzasl(), UTF_8));
        if (list == null) {
            list = Collections.emptyList();
        }
        if (list.isEmpty()) {
            throw new IllegalArgumentException("the primary entry cannot be set to an entry which is not held by this primitive set");
        }
        this.zzgyf = zzdipVar;
    }

    public final Class<P> zzarz() {
        return this.zzgxu;
    }

    public final zzdip<P> zzasm() {
        return this.zzgyf;
    }
}
