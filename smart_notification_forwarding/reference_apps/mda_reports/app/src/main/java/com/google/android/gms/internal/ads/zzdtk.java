package com.google.android.gms.internal.ads;

import java.util.Iterator;
import java.util.Map;

/* loaded from: classes.dex */
final class zzdtk<T> implements zzdua<T> {
    private final zzdte zzhpb;
    private final boolean zzhpc;
    private final zzdus<?, ?> zzhpl;
    private final zzdri<?> zzhpm;

    private zzdtk(zzdus<?, ?> zzdusVar, zzdri<?> zzdriVar, zzdte zzdteVar) {
        this.zzhpl = zzdusVar;
        this.zzhpc = zzdriVar.a(zzdteVar);
        this.zzhpm = zzdriVar;
        this.zzhpb = zzdteVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T> zzdtk<T> a(zzdus<?, ?> zzdusVar, zzdri<?> zzdriVar, zzdte zzdteVar) {
        return new zzdtk<>(zzdusVar, zzdriVar, zzdteVar);
    }

    @Override // com.google.android.gms.internal.ads.zzdua
    public final boolean equals(T t, T t2) {
        if (!this.zzhpl.d(t).equals(this.zzhpl.d(t2))) {
            return false;
        }
        if (this.zzhpc) {
            return this.zzhpm.a(t).equals(this.zzhpm.a(t2));
        }
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzdua
    public final int hashCode(T t) {
        int hashCode = this.zzhpl.d(t).hashCode();
        return this.zzhpc ? (hashCode * 53) + this.zzhpm.a(t).hashCode() : hashCode;
    }

    @Override // com.google.android.gms.internal.ads.zzdua
    public final T newInstance() {
        return (T) this.zzhpb.zzazy().zzbae();
    }

    @Override // com.google.android.gms.internal.ads.zzdua
    public final void zza(T t, zzdtu zzdtuVar, zzdrg zzdrgVar) {
        boolean z;
        zzdus<?, ?> zzdusVar = this.zzhpl;
        zzdri<?> zzdriVar = this.zzhpm;
        Object e = zzdusVar.e(t);
        zzdrm<?> b = zzdriVar.b(t);
        do {
            try {
                if (zzdtuVar.zzaza() == Integer.MAX_VALUE) {
                    return;
                }
                int tag = zzdtuVar.getTag();
                if (tag == 11) {
                    int i = 0;
                    Object obj = null;
                    zzdqk zzdqkVar = null;
                    while (zzdtuVar.zzaza() != Integer.MAX_VALUE) {
                        int tag2 = zzdtuVar.getTag();
                        if (tag2 == 16) {
                            i = zzdtuVar.zzayl();
                            obj = zzdriVar.a(zzdrgVar, this.zzhpb, i);
                        } else if (tag2 == 26) {
                            if (obj != null) {
                                zzdriVar.a(zzdtuVar, obj, zzdrgVar, b);
                            } else {
                                zzdqkVar = zzdtuVar.zzayk();
                            }
                        } else if (!zzdtuVar.zzazb()) {
                            break;
                        }
                    }
                    if (zzdtuVar.getTag() != 12) {
                        throw zzdse.e();
                    }
                    if (zzdqkVar != null) {
                        if (obj != null) {
                            zzdriVar.a(zzdqkVar, obj, zzdrgVar, b);
                        } else {
                            zzdusVar.a((zzdus<?, ?>) e, i, zzdqkVar);
                        }
                    }
                } else if ((tag & 7) == 2) {
                    Object a = zzdriVar.a(zzdrgVar, this.zzhpb, tag >>> 3);
                    if (a != null) {
                        zzdriVar.a(zzdtuVar, a, zzdrgVar, b);
                    } else {
                        z = zzdusVar.a((zzdus<?, ?>) e, zzdtuVar);
                    }
                } else {
                    z = zzdtuVar.zzazb();
                }
                z = true;
            } finally {
                zzdusVar.b((Object) t, (T) e);
            }
        } while (z);
    }

    @Override // com.google.android.gms.internal.ads.zzdua
    public final void zza(T t, zzdvl zzdvlVar) {
        Iterator<Map.Entry<?, Object>> it = this.zzhpm.a(t).iterator();
        while (it.hasNext()) {
            Map.Entry<?, Object> next = it.next();
            zzdro zzdroVar = (zzdro) next.getKey();
            if (zzdroVar.zzazp() != zzdvm.MESSAGE || zzdroVar.zzazq() || zzdroVar.zzazr()) {
                throw new IllegalStateException("Found invalid MessageSet item.");
            }
            zzdvlVar.zzc(zzdroVar.zzae(), next instanceof zzdsh ? ((zzdsh) next).zzbau().zzaxk() : next.getValue());
        }
        zzdus<?, ?> zzdusVar = this.zzhpl;
        zzdusVar.b((zzdus<?, ?>) zzdusVar.d(t), zzdvlVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0099 A[EDGE_INSN: B:24:0x0099->B:25:0x0099 BREAK  A[LOOP:1: B:10:0x0053->B:18:0x0053], SYNTHETIC] */
    @Override // com.google.android.gms.internal.ads.zzdua
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void zza(T r10, byte[] r11, int r12, int r13, com.google.android.gms.internal.ads.zzdqf r14) {
        /*
            r9 = this;
            r0 = r10
            com.google.android.gms.internal.ads.zzdrt r0 = (com.google.android.gms.internal.ads.zzdrt) r0
            com.google.android.gms.internal.ads.zzdur r1 = r0.zzhmk
            com.google.android.gms.internal.ads.zzdur r2 = com.google.android.gms.internal.ads.zzdur.zzbcf()
            if (r1 != r2) goto L11
            com.google.android.gms.internal.ads.zzdur r1 = com.google.android.gms.internal.ads.zzdur.a()
            r0.zzhmk = r1
        L11:
            com.google.android.gms.internal.ads.zzdrt$zzd r10 = (com.google.android.gms.internal.ads.zzdrt.zzd) r10
            r10.e()
            r10 = 0
            r0 = r10
        L18:
            if (r12 >= r13) goto La4
            int r4 = com.google.android.gms.internal.ads.zzdqg.a(r11, r12, r14)
            int r2 = r14.zzhhq
            r12 = 11
            r3 = 2
            if (r2 == r12) goto L51
            r12 = r2 & 7
            if (r12 != r3) goto L4c
            com.google.android.gms.internal.ads.zzdri<?> r12 = r9.zzhpm
            com.google.android.gms.internal.ads.zzdrg r0 = r14.zzhht
            com.google.android.gms.internal.ads.zzdte r3 = r9.zzhpb
            int r5 = r2 >>> 3
            java.lang.Object r12 = r12.a(r0, r3, r5)
            r0 = r12
            com.google.android.gms.internal.ads.zzdrt$zzf r0 = (com.google.android.gms.internal.ads.zzdrt.zzf) r0
            if (r0 != 0) goto L43
            r3 = r11
            r5 = r13
            r6 = r1
            r7 = r14
            int r12 = com.google.android.gms.internal.ads.zzdqg.a(r2, r3, r4, r5, r6, r7)
            goto L18
        L43:
            com.google.android.gms.internal.ads.zzdtp.zzbbm()
            java.lang.NoSuchMethodError r10 = new java.lang.NoSuchMethodError
            r10.<init>()
            throw r10
        L4c:
            int r12 = com.google.android.gms.internal.ads.zzdqg.a(r2, r11, r4, r13, r14)
            goto L18
        L51:
            r12 = 0
            r2 = r10
        L53:
            if (r4 >= r13) goto L99
            int r4 = com.google.android.gms.internal.ads.zzdqg.a(r11, r4, r14)
            int r5 = r14.zzhhq
            int r6 = r5 >>> 3
            r7 = r5 & 7
            if (r6 == r3) goto L7b
            r8 = 3
            if (r6 == r8) goto L65
            goto L90
        L65:
            if (r0 != 0) goto L72
            if (r7 != r3) goto L90
            int r4 = com.google.android.gms.internal.ads.zzdqg.e(r11, r4, r14)
            java.lang.Object r2 = r14.zzhhs
            com.google.android.gms.internal.ads.zzdqk r2 = (com.google.android.gms.internal.ads.zzdqk) r2
            goto L53
        L72:
            com.google.android.gms.internal.ads.zzdtp.zzbbm()
            java.lang.NoSuchMethodError r10 = new java.lang.NoSuchMethodError
            r10.<init>()
            throw r10
        L7b:
            if (r7 != 0) goto L90
            int r4 = com.google.android.gms.internal.ads.zzdqg.a(r11, r4, r14)
            int r12 = r14.zzhhq
            com.google.android.gms.internal.ads.zzdri<?> r0 = r9.zzhpm
            com.google.android.gms.internal.ads.zzdrg r5 = r14.zzhht
            com.google.android.gms.internal.ads.zzdte r6 = r9.zzhpb
            java.lang.Object r0 = r0.a(r5, r6, r12)
            com.google.android.gms.internal.ads.zzdrt$zzf r0 = (com.google.android.gms.internal.ads.zzdrt.zzf) r0
            goto L53
        L90:
            r6 = 12
            if (r5 == r6) goto L99
            int r4 = com.google.android.gms.internal.ads.zzdqg.a(r5, r11, r4, r13, r14)
            goto L53
        L99:
            if (r2 == 0) goto La1
            int r12 = r12 << 3
            r12 = r12 | r3
            r1.a(r12, r2)
        La1:
            r12 = r4
            goto L18
        La4:
            if (r12 != r13) goto La7
            return
        La7:
            com.google.android.gms.internal.ads.zzdse r10 = com.google.android.gms.internal.ads.zzdse.h()
            goto Lad
        Lac:
            throw r10
        Lad:
            goto Lac
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzdtk.zza(java.lang.Object, byte[], int, int, com.google.android.gms.internal.ads.zzdqf):void");
    }

    @Override // com.google.android.gms.internal.ads.zzdua
    public final void zzan(T t) {
        this.zzhpl.a(t);
        this.zzhpm.c(t);
    }

    @Override // com.google.android.gms.internal.ads.zzdua
    public final int zzax(T t) {
        zzdus<?, ?> zzdusVar = this.zzhpl;
        int f = zzdusVar.f(zzdusVar.d(t)) + 0;
        return this.zzhpc ? f + this.zzhpm.a(t).zzazn() : f;
    }

    @Override // com.google.android.gms.internal.ads.zzdua
    public final boolean zzaz(T t) {
        return this.zzhpm.a(t).isInitialized();
    }

    @Override // com.google.android.gms.internal.ads.zzdua
    public final void zzf(T t, T t2) {
        zzduc.a(this.zzhpl, t, t2);
        if (this.zzhpc) {
            zzduc.a(this.zzhpm, t, t2);
        }
    }
}
