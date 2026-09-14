package com.google.android.recaptcha.internal;

import java.util.Iterator;
import java.util.Map;

/* loaded from: classes.dex */
final class zzom implements zzow {
    private final zzoi zza;
    private final zzpl zzb;
    private final boolean zzc;
    private final zzmp zzd;

    private zzom(zzpl zzplVar, zzmp zzmpVar, zzoi zzoiVar) {
        this.zzb = zzplVar;
        this.zzc = zzoiVar instanceof zzna;
        this.zzd = zzmpVar;
        this.zza = zzoiVar;
    }

    public static zzom zzc(zzpl zzplVar, zzmp zzmpVar, zzoi zzoiVar) {
        return new zzom(zzplVar, zzmpVar, zzoiVar);
    }

    @Override // com.google.android.recaptcha.internal.zzow
    public final int zza(Object obj) {
        int zzb = ((zznd) obj).zzc.zzb();
        if (this.zzc) {
            return zzb + ((zzna) obj).zzb.zzb();
        }
        return zzb;
    }

    @Override // com.google.android.recaptcha.internal.zzow
    public final int zzb(Object obj) {
        int hashCode = ((zznd) obj).zzc.hashCode();
        if (this.zzc) {
            return (hashCode * 53) + ((zzna) obj).zzb.zza.hashCode();
        }
        return hashCode;
    }

    @Override // com.google.android.recaptcha.internal.zzow
    public final Object zze() {
        zzoi zzoiVar = this.zza;
        if (zzoiVar instanceof zznd) {
            return ((zznd) zzoiVar).zzv();
        }
        return zzoiVar.zzad().zzl();
    }

    @Override // com.google.android.recaptcha.internal.zzow
    public final void zzf(Object obj) {
        this.zzb.zzi(obj);
        this.zzd.zza(obj);
    }

    @Override // com.google.android.recaptcha.internal.zzow
    public final void zzg(Object obj, Object obj2) {
        zzoy.zzq(this.zzb, obj, obj2);
        if (this.zzc) {
            zzoy.zzp(this.zzd, obj, obj2);
        }
    }

    @Override // com.google.android.recaptcha.internal.zzow
    public final void zzh(Object obj, zzov zzovVar, zzmo zzmoVar) {
        boolean zzO;
        zzpl zzplVar = this.zzb;
        Object zza = zzplVar.zza(obj);
        ((zzna) obj).zzi();
        while (zzovVar.zzc() != Integer.MAX_VALUE) {
            try {
                int zzd = zzovVar.zzd();
                int i = 0;
                if (zzd != 11) {
                    if ((zzd & 7) == 2) {
                        if (zzmoVar.zza(this.zza, zzd >>> 3) == null) {
                            zzO = zzplVar.zzk(zza, zzovVar, 0);
                        } else {
                            throw null;
                        }
                    } else {
                        zzO = zzovVar.zzO();
                    }
                    if (!zzO) {
                        break;
                    }
                } else {
                    zznc zzncVar = null;
                    zzle zzleVar = null;
                    while (zzovVar.zzc() != Integer.MAX_VALUE) {
                        int zzd2 = zzovVar.zzd();
                        if (zzd2 == 16) {
                            i = zzovVar.zzj();
                            zzncVar = zzmoVar.zza(this.zza, i);
                        } else if (zzd2 == 26) {
                            if (zzncVar == null) {
                                zzleVar = zzovVar.zzp();
                            } else {
                                throw null;
                            }
                        } else if (!zzovVar.zzO()) {
                            break;
                        }
                    }
                    if (zzovVar.zzd() == 12) {
                        if (zzleVar == null) {
                            continue;
                        } else if (zzncVar == null) {
                            zzplVar.zzg(zza, i, zzleVar);
                        } else {
                            throw null;
                        }
                    } else {
                        throw new zznn("Protocol message end-group tag did not match expected tag.");
                    }
                }
            } finally {
                zzplVar.zzj(obj, zza);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x008b A[EDGE_INSN: B:24:0x008b->B:25:0x008b BREAK  A[LOOP:1: B:10:0x004e->B:18:0x004e], SYNTHETIC] */
    @Override // com.google.android.recaptcha.internal.zzow
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void zzi(java.lang.Object r10, byte[] r11, int r12, int r13, com.google.android.recaptcha.internal.zzkt r14) {
        /*
            r9 = this;
            r0 = r10
            com.google.android.recaptcha.internal.zznd r0 = (com.google.android.recaptcha.internal.zznd) r0
            com.google.android.recaptcha.internal.zzpm r1 = r0.zzc
            com.google.android.recaptcha.internal.zzpm r2 = com.google.android.recaptcha.internal.zzpm.zzc()
            if (r1 != r2) goto L11
            com.google.android.recaptcha.internal.zzpm r1 = com.google.android.recaptcha.internal.zzpm.zzf()
            r0.zzc = r1
        L11:
            r6 = r1
            com.google.android.recaptcha.internal.zzna r10 = (com.google.android.recaptcha.internal.zzna) r10
            r10.zzi()
            r10 = 0
            r0 = r10
        L19:
            if (r12 >= r13) goto L98
            int r4 = com.google.android.recaptcha.internal.zzku.zzi(r11, r12, r14)
            int r2 = r14.zza
            r12 = 11
            r1 = 2
            if (r2 == r12) goto L49
            r12 = r2 & 7
            if (r12 != r1) goto L41
            com.google.android.recaptcha.internal.zzmo r12 = r14.zzd
            com.google.android.recaptcha.internal.zzoi r0 = r9.zza
            int r1 = r2 >>> 3
            com.google.android.recaptcha.internal.zznc r0 = r12.zza(r0, r1)
            if (r0 != 0) goto L3e
            r3 = r11
            r5 = r13
            r7 = r14
            int r12 = com.google.android.recaptcha.internal.zzku.zzh(r2, r3, r4, r5, r6, r7)
            goto L19
        L3e:
            int r11 = com.google.android.recaptcha.internal.zzos.zza
            throw r10
        L41:
            r3 = r11
            r5 = r13
            r7 = r14
            int r12 = com.google.android.recaptcha.internal.zzku.zzo(r2, r3, r4, r5, r7)
            goto L19
        L49:
            r3 = r11
            r5 = r13
            r7 = r14
            r11 = 0
            r12 = r10
        L4e:
            if (r4 >= r5) goto L8a
            int r13 = com.google.android.recaptcha.internal.zzku.zzi(r3, r4, r7)
            int r14 = r7.zza
            int r2 = r14 >>> 3
            r4 = r14 & 7
            if (r2 == r1) goto L70
            r8 = 3
            if (r2 == r8) goto L60
            goto L81
        L60:
            if (r0 != 0) goto L6d
            if (r4 != r1) goto L81
            int r4 = com.google.android.recaptcha.internal.zzku.zza(r3, r13, r7)
            java.lang.Object r12 = r7.zzc
            com.google.android.recaptcha.internal.zzle r12 = (com.google.android.recaptcha.internal.zzle) r12
            goto L4e
        L6d:
            int r11 = com.google.android.recaptcha.internal.zzos.zza
            throw r10
        L70:
            if (r4 != 0) goto L81
            int r4 = com.google.android.recaptcha.internal.zzku.zzi(r3, r13, r7)
            int r11 = r7.zza
            com.google.android.recaptcha.internal.zzmo r13 = r7.zzd
            com.google.android.recaptcha.internal.zzoi r14 = r9.zza
            com.google.android.recaptcha.internal.zznc r0 = r13.zza(r14, r11)
            goto L4e
        L81:
            r2 = 12
            if (r14 == r2) goto L8b
            int r4 = com.google.android.recaptcha.internal.zzku.zzo(r14, r3, r13, r5, r7)
            goto L4e
        L8a:
            r13 = r4
        L8b:
            if (r12 == 0) goto L93
            int r11 = r11 << 3
            r11 = r11 | r1
            r6.zzj(r11, r12)
        L93:
            r12 = r13
            r11 = r3
            r13 = r5
            r14 = r7
            goto L19
        L98:
            r5 = r13
            if (r12 != r5) goto L9c
            return
        L9c:
            com.google.android.recaptcha.internal.zznn r10 = new com.google.android.recaptcha.internal.zznn
            java.lang.String r11 = "Failed to parse the message."
            r10.<init>(r11)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.recaptcha.internal.zzom.zzi(java.lang.Object, byte[], int, int, com.google.android.recaptcha.internal.zzkt):void");
    }

    @Override // com.google.android.recaptcha.internal.zzow
    public final void zzj(Object obj, zzpy zzpyVar) {
        Iterator zzf = ((zzna) obj).zzb.zzf();
        while (zzf.hasNext()) {
            Map.Entry entry = (Map.Entry) zzf.next();
            zzms zzmsVar = (zzms) entry.getKey();
            if (zzmsVar.zze() == zzpx.MESSAGE) {
                zzmsVar.zzg();
                zzmsVar.zzf();
                if (entry instanceof zznp) {
                    zzpyVar.zzw(zzmsVar.zza(), ((zznp) entry).zza().zzb());
                } else {
                    zzpyVar.zzw(zzmsVar.zza(), entry.getValue());
                }
            } else {
                throw new IllegalStateException("Found invalid MessageSet item.");
            }
        }
        ((zznd) obj).zzc.zzk(zzpyVar);
    }

    @Override // com.google.android.recaptcha.internal.zzow
    public final boolean zzk(Object obj, Object obj2) {
        if (!((zznd) obj).zzc.equals(((zznd) obj2).zzc)) {
            return false;
        }
        if (this.zzc) {
            return ((zzna) obj).zzb.equals(((zzna) obj2).zzb);
        }
        return true;
    }

    @Override // com.google.android.recaptcha.internal.zzow
    public final boolean zzl(Object obj) {
        return ((zzna) obj).zzb.zzk();
    }
}
