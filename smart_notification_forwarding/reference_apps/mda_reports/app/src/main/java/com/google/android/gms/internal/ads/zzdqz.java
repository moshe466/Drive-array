package com.google.android.gms.internal.ads;

import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzdqz implements zzdtu {
    private int tag;
    private final zzdqw zzhir;
    private int zzhis;
    private int zzhit = 0;

    private zzdqz(zzdqw zzdqwVar) {
        zzdrv.a(zzdqwVar, "input");
        this.zzhir = zzdqwVar;
        this.zzhir.d = this;
    }

    public static zzdqz zza(zzdqw zzdqwVar) {
        zzdqz zzdqzVar = zzdqwVar.d;
        return zzdqzVar != null ? zzdqzVar : new zzdqz(zzdqwVar);
    }

    private final Object zza(zzdvf zzdvfVar, Class<?> cls, zzdrg zzdrgVar) {
        switch (zzdrc.a[zzdvfVar.ordinal()]) {
            case 1:
                return Boolean.valueOf(zzayi());
            case 2:
                return zzayk();
            case 3:
                return Double.valueOf(readDouble());
            case 4:
                return Integer.valueOf(zzaym());
            case 5:
                return Integer.valueOf(zzayh());
            case 6:
                return Long.valueOf(zzayg());
            case 7:
                return Float.valueOf(readFloat());
            case 8:
                return Integer.valueOf(zzayf());
            case 9:
                return Long.valueOf(zzaye());
            case 10:
                zzfr(2);
                return zzc(zzdtp.zzbbm().zzh(cls), zzdrgVar);
            case 11:
                return Integer.valueOf(zzayn());
            case 12:
                return Long.valueOf(zzayo());
            case 13:
                return Integer.valueOf(zzayp());
            case 14:
                return Long.valueOf(zzayq());
            case 15:
                return zzayj();
            case 16:
                return Integer.valueOf(zzayl());
            case 17:
                return Long.valueOf(zzayd());
            default:
                throw new RuntimeException("unsupported field type.");
        }
    }

    private final void zza(List<String> list, boolean z) {
        int zzayc;
        int zzayc2;
        if ((this.tag & 7) != 2) {
            throw zzdse.f();
        }
        if (!(list instanceof zzdsl) || z) {
            do {
                list.add(z ? zzayj() : readString());
                if (this.zzhir.zzays()) {
                    return;
                } else {
                    zzayc = this.zzhir.zzayc();
                }
            } while (zzayc == this.tag);
            this.zzhit = zzayc;
            return;
        }
        zzdsl zzdslVar = (zzdsl) list;
        do {
            zzdslVar.zzbg(zzayk());
            if (this.zzhir.zzays()) {
                return;
            } else {
                zzayc2 = this.zzhir.zzayc();
            }
        } while (zzayc2 == this.tag);
        this.zzhit = zzayc2;
    }

    private final <T> T zzc(zzdua<T> zzduaVar, zzdrg zzdrgVar) {
        int zzayl = this.zzhir.zzayl();
        zzdqw zzdqwVar = this.zzhir;
        if (zzdqwVar.a >= zzdqwVar.b) {
            throw new zzdse("Protocol message had too many levels of nesting.  May be malicious.  Use CodedInputStream.setRecursionLimit() to increase the depth limit.");
        }
        int zzfj = zzdqwVar.zzfj(zzayl);
        T newInstance = zzduaVar.newInstance();
        this.zzhir.a++;
        zzduaVar.zza(newInstance, this, zzdrgVar);
        zzduaVar.zzan(newInstance);
        this.zzhir.zzfh(0);
        r5.a--;
        this.zzhir.zzfk(zzfj);
        return newInstance;
    }

    private final <T> T zzd(zzdua<T> zzduaVar, zzdrg zzdrgVar) {
        int i = this.zzhis;
        this.zzhis = ((this.tag >>> 3) << 3) | 4;
        try {
            T newInstance = zzduaVar.newInstance();
            zzduaVar.zza(newInstance, this, zzdrgVar);
            zzduaVar.zzan(newInstance);
            if (this.tag == this.zzhis) {
                return newInstance;
            }
            throw zzdse.h();
        } finally {
            this.zzhis = i;
        }
    }

    private final void zzfr(int i) {
        if ((this.tag & 7) != i) {
            throw zzdse.f();
        }
    }

    private static void zzfs(int i) {
        if ((i & 7) != 0) {
            throw zzdse.h();
        }
    }

    private static void zzft(int i) {
        if ((i & 3) != 0) {
            throw zzdse.h();
        }
    }

    private final void zzfu(int i) {
        if (this.zzhir.zzayt() != i) {
            throw zzdse.a();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final int getTag() {
        return this.tag;
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final double readDouble() {
        zzfr(1);
        return this.zzhir.readDouble();
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final float readFloat() {
        zzfr(5);
        return this.zzhir.readFloat();
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final String readString() {
        zzfr(2);
        return this.zzhir.readString();
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final void readStringList(List<String> list) {
        zza(list, false);
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final <T> T zza(zzdua<T> zzduaVar, zzdrg zzdrgVar) {
        zzfr(2);
        return (T) zzc(zzduaVar, zzdrgVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.ads.zzdtu
    public final <T> void zza(List<T> list, zzdua<T> zzduaVar, zzdrg zzdrgVar) {
        int zzayc;
        int i = this.tag;
        if ((i & 7) != 2) {
            throw zzdse.f();
        }
        do {
            list.add(zzc(zzduaVar, zzdrgVar));
            if (this.zzhir.zzays() || this.zzhit != 0) {
                return;
            } else {
                zzayc = this.zzhir.zzayc();
            }
        } while (zzayc == i);
        this.zzhit = zzayc;
    }

    /* JADX WARN: Code restructure failed: missing block: B:38:0x005b, code lost:
    
        r8.put(r2, r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x0063, code lost:
    
        return;
     */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.ads.zzdtu
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final <K, V> void zza(java.util.Map<K, V> r8, com.google.android.gms.internal.ads.zzdsv<K, V> r9, com.google.android.gms.internal.ads.zzdrg r10) {
        /*
            r7 = this;
            r0 = 2
            r7.zzfr(r0)
            com.google.android.gms.internal.ads.zzdqw r1 = r7.zzhir
            int r1 = r1.zzayl()
            com.google.android.gms.internal.ads.zzdqw r2 = r7.zzhir
            int r1 = r2.zzfj(r1)
            K r2 = r9.zzhor
            V r3 = r9.zzcfu
        L14:
            int r4 = r7.zzaza()     // Catch: java.lang.Throwable -> L64
            r5 = 2147483647(0x7fffffff, float:NaN)
            if (r4 == r5) goto L5b
            com.google.android.gms.internal.ads.zzdqw r5 = r7.zzhir     // Catch: java.lang.Throwable -> L64
            boolean r5 = r5.zzays()     // Catch: java.lang.Throwable -> L64
            if (r5 != 0) goto L5b
            r5 = 1
            java.lang.String r6 = "Unable to parse map entry."
            if (r4 == r5) goto L46
            if (r4 == r0) goto L39
            boolean r4 = r7.zzazb()     // Catch: com.google.android.gms.internal.ads.zzdsd -> L4e java.lang.Throwable -> L64
            if (r4 == 0) goto L33
            goto L14
        L33:
            com.google.android.gms.internal.ads.zzdse r4 = new com.google.android.gms.internal.ads.zzdse     // Catch: com.google.android.gms.internal.ads.zzdsd -> L4e java.lang.Throwable -> L64
            r4.<init>(r6)     // Catch: com.google.android.gms.internal.ads.zzdsd -> L4e java.lang.Throwable -> L64
            throw r4     // Catch: com.google.android.gms.internal.ads.zzdsd -> L4e java.lang.Throwable -> L64
        L39:
            com.google.android.gms.internal.ads.zzdvf r4 = r9.zzhos     // Catch: com.google.android.gms.internal.ads.zzdsd -> L4e java.lang.Throwable -> L64
            V r5 = r9.zzcfu     // Catch: com.google.android.gms.internal.ads.zzdsd -> L4e java.lang.Throwable -> L64
            java.lang.Class r5 = r5.getClass()     // Catch: com.google.android.gms.internal.ads.zzdsd -> L4e java.lang.Throwable -> L64
            java.lang.Object r3 = r7.zza(r4, r5, r10)     // Catch: com.google.android.gms.internal.ads.zzdsd -> L4e java.lang.Throwable -> L64
            goto L14
        L46:
            com.google.android.gms.internal.ads.zzdvf r4 = r9.zzhoq     // Catch: com.google.android.gms.internal.ads.zzdsd -> L4e java.lang.Throwable -> L64
            r5 = 0
            java.lang.Object r2 = r7.zza(r4, r5, r5)     // Catch: com.google.android.gms.internal.ads.zzdsd -> L4e java.lang.Throwable -> L64
            goto L14
        L4e:
            boolean r4 = r7.zzazb()     // Catch: java.lang.Throwable -> L64
            if (r4 == 0) goto L55
            goto L14
        L55:
            com.google.android.gms.internal.ads.zzdse r8 = new com.google.android.gms.internal.ads.zzdse     // Catch: java.lang.Throwable -> L64
            r8.<init>(r6)     // Catch: java.lang.Throwable -> L64
            throw r8     // Catch: java.lang.Throwable -> L64
        L5b:
            r8.put(r2, r3)     // Catch: java.lang.Throwable -> L64
            com.google.android.gms.internal.ads.zzdqw r8 = r7.zzhir
            r8.zzfk(r1)
            return
        L64:
            r8 = move-exception
            com.google.android.gms.internal.ads.zzdqw r9 = r7.zzhir
            r9.zzfk(r1)
            goto L6c
        L6b:
            throw r8
        L6c:
            goto L6b
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzdqz.zza(java.util.Map, com.google.android.gms.internal.ads.zzdsv, com.google.android.gms.internal.ads.zzdrg):void");
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final long zzayd() {
        zzfr(0);
        return this.zzhir.zzayd();
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final long zzaye() {
        zzfr(0);
        return this.zzhir.zzaye();
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final int zzayf() {
        zzfr(0);
        return this.zzhir.zzayf();
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final long zzayg() {
        zzfr(1);
        return this.zzhir.zzayg();
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final int zzayh() {
        zzfr(5);
        return this.zzhir.zzayh();
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final boolean zzayi() {
        zzfr(0);
        return this.zzhir.zzayi();
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final String zzayj() {
        zzfr(2);
        return this.zzhir.zzayj();
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final zzdqk zzayk() {
        zzfr(2);
        return this.zzhir.zzayk();
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final int zzayl() {
        zzfr(0);
        return this.zzhir.zzayl();
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final int zzaym() {
        zzfr(0);
        return this.zzhir.zzaym();
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final int zzayn() {
        zzfr(5);
        return this.zzhir.zzayn();
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final long zzayo() {
        zzfr(1);
        return this.zzhir.zzayo();
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final int zzayp() {
        zzfr(0);
        return this.zzhir.zzayp();
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final long zzayq() {
        zzfr(0);
        return this.zzhir.zzayq();
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final int zzaza() {
        int i = this.zzhit;
        if (i != 0) {
            this.tag = i;
            this.zzhit = 0;
        } else {
            this.tag = this.zzhir.zzayc();
        }
        int i2 = this.tag;
        if (i2 == 0 || i2 == this.zzhis) {
            return Integer.MAX_VALUE;
        }
        return i2 >>> 3;
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final boolean zzazb() {
        int i;
        if (this.zzhir.zzays() || (i = this.tag) == this.zzhis) {
            return false;
        }
        return this.zzhir.zzfi(i);
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final <T> T zzb(zzdua<T> zzduaVar, zzdrg zzdrgVar) {
        zzfr(3);
        return (T) zzd(zzduaVar, zzdrgVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.ads.zzdtu
    public final <T> void zzb(List<T> list, zzdua<T> zzduaVar, zzdrg zzdrgVar) {
        int zzayc;
        int i = this.tag;
        if ((i & 7) != 3) {
            throw zzdse.f();
        }
        do {
            list.add(zzd(zzduaVar, zzdrgVar));
            if (this.zzhir.zzays() || this.zzhit != 0) {
                return;
            } else {
                zzayc = this.zzhir.zzayc();
            }
        } while (zzayc == i);
        this.zzhit = zzayc;
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final void zzi(List<Double> list) {
        int zzayc;
        int zzayc2;
        if (!(list instanceof zzdre)) {
            int i = this.tag & 7;
            if (i != 1) {
                if (i != 2) {
                    throw zzdse.f();
                }
                int zzayl = this.zzhir.zzayl();
                zzfs(zzayl);
                int zzayt = this.zzhir.zzayt() + zzayl;
                do {
                    list.add(Double.valueOf(this.zzhir.readDouble()));
                } while (this.zzhir.zzayt() < zzayt);
                return;
            }
            do {
                list.add(Double.valueOf(this.zzhir.readDouble()));
                if (this.zzhir.zzays()) {
                    return;
                } else {
                    zzayc = this.zzhir.zzayc();
                }
            } while (zzayc == this.tag);
            this.zzhit = zzayc;
            return;
        }
        zzdre zzdreVar = (zzdre) list;
        int i2 = this.tag & 7;
        if (i2 != 1) {
            if (i2 != 2) {
                throw zzdse.f();
            }
            int zzayl2 = this.zzhir.zzayl();
            zzfs(zzayl2);
            int zzayt2 = this.zzhir.zzayt() + zzayl2;
            do {
                zzdreVar.zzd(this.zzhir.readDouble());
            } while (this.zzhir.zzayt() < zzayt2);
            return;
        }
        do {
            zzdreVar.zzd(this.zzhir.readDouble());
            if (this.zzhir.zzays()) {
                return;
            } else {
                zzayc2 = this.zzhir.zzayc();
            }
        } while (zzayc2 == this.tag);
        this.zzhit = zzayc2;
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final void zzj(List<Float> list) {
        int zzayc;
        int zzayc2;
        if (!(list instanceof zzdrs)) {
            int i = this.tag & 7;
            if (i == 2) {
                int zzayl = this.zzhir.zzayl();
                zzft(zzayl);
                int zzayt = this.zzhir.zzayt() + zzayl;
                do {
                    list.add(Float.valueOf(this.zzhir.readFloat()));
                } while (this.zzhir.zzayt() < zzayt);
                return;
            }
            if (i != 5) {
                throw zzdse.f();
            }
            do {
                list.add(Float.valueOf(this.zzhir.readFloat()));
                if (this.zzhir.zzays()) {
                    return;
                } else {
                    zzayc = this.zzhir.zzayc();
                }
            } while (zzayc == this.tag);
            this.zzhit = zzayc;
            return;
        }
        zzdrs zzdrsVar = (zzdrs) list;
        int i2 = this.tag & 7;
        if (i2 == 2) {
            int zzayl2 = this.zzhir.zzayl();
            zzft(zzayl2);
            int zzayt2 = this.zzhir.zzayt() + zzayl2;
            do {
                zzdrsVar.zzh(this.zzhir.readFloat());
            } while (this.zzhir.zzayt() < zzayt2);
            return;
        }
        if (i2 != 5) {
            throw zzdse.f();
        }
        do {
            zzdrsVar.zzh(this.zzhir.readFloat());
            if (this.zzhir.zzays()) {
                return;
            } else {
                zzayc2 = this.zzhir.zzayc();
            }
        } while (zzayc2 == this.tag);
        this.zzhit = zzayc2;
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final void zzk(List<Long> list) {
        int zzayc;
        int zzayc2;
        if (!(list instanceof zzdss)) {
            int i = this.tag & 7;
            if (i != 0) {
                if (i != 2) {
                    throw zzdse.f();
                }
                int zzayt = this.zzhir.zzayt() + this.zzhir.zzayl();
                do {
                    list.add(Long.valueOf(this.zzhir.zzayd()));
                } while (this.zzhir.zzayt() < zzayt);
                zzfu(zzayt);
                return;
            }
            do {
                list.add(Long.valueOf(this.zzhir.zzayd()));
                if (this.zzhir.zzays()) {
                    return;
                } else {
                    zzayc = this.zzhir.zzayc();
                }
            } while (zzayc == this.tag);
            this.zzhit = zzayc;
            return;
        }
        zzdss zzdssVar = (zzdss) list;
        int i2 = this.tag & 7;
        if (i2 != 0) {
            if (i2 != 2) {
                throw zzdse.f();
            }
            int zzayt2 = this.zzhir.zzayt() + this.zzhir.zzayl();
            do {
                zzdssVar.zzfr(this.zzhir.zzayd());
            } while (this.zzhir.zzayt() < zzayt2);
            zzfu(zzayt2);
            return;
        }
        do {
            zzdssVar.zzfr(this.zzhir.zzayd());
            if (this.zzhir.zzays()) {
                return;
            } else {
                zzayc2 = this.zzhir.zzayc();
            }
        } while (zzayc2 == this.tag);
        this.zzhit = zzayc2;
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final void zzl(List<Long> list) {
        int zzayc;
        int zzayc2;
        if (!(list instanceof zzdss)) {
            int i = this.tag & 7;
            if (i != 0) {
                if (i != 2) {
                    throw zzdse.f();
                }
                int zzayt = this.zzhir.zzayt() + this.zzhir.zzayl();
                do {
                    list.add(Long.valueOf(this.zzhir.zzaye()));
                } while (this.zzhir.zzayt() < zzayt);
                zzfu(zzayt);
                return;
            }
            do {
                list.add(Long.valueOf(this.zzhir.zzaye()));
                if (this.zzhir.zzays()) {
                    return;
                } else {
                    zzayc = this.zzhir.zzayc();
                }
            } while (zzayc == this.tag);
            this.zzhit = zzayc;
            return;
        }
        zzdss zzdssVar = (zzdss) list;
        int i2 = this.tag & 7;
        if (i2 != 0) {
            if (i2 != 2) {
                throw zzdse.f();
            }
            int zzayt2 = this.zzhir.zzayt() + this.zzhir.zzayl();
            do {
                zzdssVar.zzfr(this.zzhir.zzaye());
            } while (this.zzhir.zzayt() < zzayt2);
            zzfu(zzayt2);
            return;
        }
        do {
            zzdssVar.zzfr(this.zzhir.zzaye());
            if (this.zzhir.zzays()) {
                return;
            } else {
                zzayc2 = this.zzhir.zzayc();
            }
        } while (zzayc2 == this.tag);
        this.zzhit = zzayc2;
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final void zzm(List<Integer> list) {
        int zzayc;
        int zzayc2;
        if (!(list instanceof zzdrw)) {
            int i = this.tag & 7;
            if (i != 0) {
                if (i != 2) {
                    throw zzdse.f();
                }
                int zzayt = this.zzhir.zzayt() + this.zzhir.zzayl();
                do {
                    list.add(Integer.valueOf(this.zzhir.zzayf()));
                } while (this.zzhir.zzayt() < zzayt);
                zzfu(zzayt);
                return;
            }
            do {
                list.add(Integer.valueOf(this.zzhir.zzayf()));
                if (this.zzhir.zzays()) {
                    return;
                } else {
                    zzayc = this.zzhir.zzayc();
                }
            } while (zzayc == this.tag);
            this.zzhit = zzayc;
            return;
        }
        zzdrw zzdrwVar = (zzdrw) list;
        int i2 = this.tag & 7;
        if (i2 != 0) {
            if (i2 != 2) {
                throw zzdse.f();
            }
            int zzayt2 = this.zzhir.zzayt() + this.zzhir.zzayl();
            do {
                zzdrwVar.zzgl(this.zzhir.zzayf());
            } while (this.zzhir.zzayt() < zzayt2);
            zzfu(zzayt2);
            return;
        }
        do {
            zzdrwVar.zzgl(this.zzhir.zzayf());
            if (this.zzhir.zzays()) {
                return;
            } else {
                zzayc2 = this.zzhir.zzayc();
            }
        } while (zzayc2 == this.tag);
        this.zzhit = zzayc2;
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final void zzn(List<Long> list) {
        int zzayc;
        int zzayc2;
        if (!(list instanceof zzdss)) {
            int i = this.tag & 7;
            if (i != 1) {
                if (i != 2) {
                    throw zzdse.f();
                }
                int zzayl = this.zzhir.zzayl();
                zzfs(zzayl);
                int zzayt = this.zzhir.zzayt() + zzayl;
                do {
                    list.add(Long.valueOf(this.zzhir.zzayg()));
                } while (this.zzhir.zzayt() < zzayt);
                return;
            }
            do {
                list.add(Long.valueOf(this.zzhir.zzayg()));
                if (this.zzhir.zzays()) {
                    return;
                } else {
                    zzayc = this.zzhir.zzayc();
                }
            } while (zzayc == this.tag);
            this.zzhit = zzayc;
            return;
        }
        zzdss zzdssVar = (zzdss) list;
        int i2 = this.tag & 7;
        if (i2 != 1) {
            if (i2 != 2) {
                throw zzdse.f();
            }
            int zzayl2 = this.zzhir.zzayl();
            zzfs(zzayl2);
            int zzayt2 = this.zzhir.zzayt() + zzayl2;
            do {
                zzdssVar.zzfr(this.zzhir.zzayg());
            } while (this.zzhir.zzayt() < zzayt2);
            return;
        }
        do {
            zzdssVar.zzfr(this.zzhir.zzayg());
            if (this.zzhir.zzays()) {
                return;
            } else {
                zzayc2 = this.zzhir.zzayc();
            }
        } while (zzayc2 == this.tag);
        this.zzhit = zzayc2;
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final void zzo(List<Integer> list) {
        int zzayc;
        int zzayc2;
        if (!(list instanceof zzdrw)) {
            int i = this.tag & 7;
            if (i == 2) {
                int zzayl = this.zzhir.zzayl();
                zzft(zzayl);
                int zzayt = this.zzhir.zzayt() + zzayl;
                do {
                    list.add(Integer.valueOf(this.zzhir.zzayh()));
                } while (this.zzhir.zzayt() < zzayt);
                return;
            }
            if (i != 5) {
                throw zzdse.f();
            }
            do {
                list.add(Integer.valueOf(this.zzhir.zzayh()));
                if (this.zzhir.zzays()) {
                    return;
                } else {
                    zzayc = this.zzhir.zzayc();
                }
            } while (zzayc == this.tag);
            this.zzhit = zzayc;
            return;
        }
        zzdrw zzdrwVar = (zzdrw) list;
        int i2 = this.tag & 7;
        if (i2 == 2) {
            int zzayl2 = this.zzhir.zzayl();
            zzft(zzayl2);
            int zzayt2 = this.zzhir.zzayt() + zzayl2;
            do {
                zzdrwVar.zzgl(this.zzhir.zzayh());
            } while (this.zzhir.zzayt() < zzayt2);
            return;
        }
        if (i2 != 5) {
            throw zzdse.f();
        }
        do {
            zzdrwVar.zzgl(this.zzhir.zzayh());
            if (this.zzhir.zzays()) {
                return;
            } else {
                zzayc2 = this.zzhir.zzayc();
            }
        } while (zzayc2 == this.tag);
        this.zzhit = zzayc2;
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final void zzp(List<Boolean> list) {
        int zzayc;
        int zzayc2;
        if (!(list instanceof zzdqi)) {
            int i = this.tag & 7;
            if (i != 0) {
                if (i != 2) {
                    throw zzdse.f();
                }
                int zzayt = this.zzhir.zzayt() + this.zzhir.zzayl();
                do {
                    list.add(Boolean.valueOf(this.zzhir.zzayi()));
                } while (this.zzhir.zzayt() < zzayt);
                zzfu(zzayt);
                return;
            }
            do {
                list.add(Boolean.valueOf(this.zzhir.zzayi()));
                if (this.zzhir.zzays()) {
                    return;
                } else {
                    zzayc = this.zzhir.zzayc();
                }
            } while (zzayc == this.tag);
            this.zzhit = zzayc;
            return;
        }
        zzdqi zzdqiVar = (zzdqi) list;
        int i2 = this.tag & 7;
        if (i2 != 0) {
            if (i2 != 2) {
                throw zzdse.f();
            }
            int zzayt2 = this.zzhir.zzayt() + this.zzhir.zzayl();
            do {
                zzdqiVar.addBoolean(this.zzhir.zzayi());
            } while (this.zzhir.zzayt() < zzayt2);
            zzfu(zzayt2);
            return;
        }
        do {
            zzdqiVar.addBoolean(this.zzhir.zzayi());
            if (this.zzhir.zzays()) {
                return;
            } else {
                zzayc2 = this.zzhir.zzayc();
            }
        } while (zzayc2 == this.tag);
        this.zzhit = zzayc2;
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final void zzq(List<String> list) {
        zza(list, true);
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final void zzr(List<zzdqk> list) {
        int zzayc;
        if ((this.tag & 7) != 2) {
            throw zzdse.f();
        }
        do {
            list.add(zzayk());
            if (this.zzhir.zzays()) {
                return;
            } else {
                zzayc = this.zzhir.zzayc();
            }
        } while (zzayc == this.tag);
        this.zzhit = zzayc;
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final void zzs(List<Integer> list) {
        int zzayc;
        int zzayc2;
        if (!(list instanceof zzdrw)) {
            int i = this.tag & 7;
            if (i != 0) {
                if (i != 2) {
                    throw zzdse.f();
                }
                int zzayt = this.zzhir.zzayt() + this.zzhir.zzayl();
                do {
                    list.add(Integer.valueOf(this.zzhir.zzayl()));
                } while (this.zzhir.zzayt() < zzayt);
                zzfu(zzayt);
                return;
            }
            do {
                list.add(Integer.valueOf(this.zzhir.zzayl()));
                if (this.zzhir.zzays()) {
                    return;
                } else {
                    zzayc = this.zzhir.zzayc();
                }
            } while (zzayc == this.tag);
            this.zzhit = zzayc;
            return;
        }
        zzdrw zzdrwVar = (zzdrw) list;
        int i2 = this.tag & 7;
        if (i2 != 0) {
            if (i2 != 2) {
                throw zzdse.f();
            }
            int zzayt2 = this.zzhir.zzayt() + this.zzhir.zzayl();
            do {
                zzdrwVar.zzgl(this.zzhir.zzayl());
            } while (this.zzhir.zzayt() < zzayt2);
            zzfu(zzayt2);
            return;
        }
        do {
            zzdrwVar.zzgl(this.zzhir.zzayl());
            if (this.zzhir.zzays()) {
                return;
            } else {
                zzayc2 = this.zzhir.zzayc();
            }
        } while (zzayc2 == this.tag);
        this.zzhit = zzayc2;
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final void zzt(List<Integer> list) {
        int zzayc;
        int zzayc2;
        if (!(list instanceof zzdrw)) {
            int i = this.tag & 7;
            if (i != 0) {
                if (i != 2) {
                    throw zzdse.f();
                }
                int zzayt = this.zzhir.zzayt() + this.zzhir.zzayl();
                do {
                    list.add(Integer.valueOf(this.zzhir.zzaym()));
                } while (this.zzhir.zzayt() < zzayt);
                zzfu(zzayt);
                return;
            }
            do {
                list.add(Integer.valueOf(this.zzhir.zzaym()));
                if (this.zzhir.zzays()) {
                    return;
                } else {
                    zzayc = this.zzhir.zzayc();
                }
            } while (zzayc == this.tag);
            this.zzhit = zzayc;
            return;
        }
        zzdrw zzdrwVar = (zzdrw) list;
        int i2 = this.tag & 7;
        if (i2 != 0) {
            if (i2 != 2) {
                throw zzdse.f();
            }
            int zzayt2 = this.zzhir.zzayt() + this.zzhir.zzayl();
            do {
                zzdrwVar.zzgl(this.zzhir.zzaym());
            } while (this.zzhir.zzayt() < zzayt2);
            zzfu(zzayt2);
            return;
        }
        do {
            zzdrwVar.zzgl(this.zzhir.zzaym());
            if (this.zzhir.zzays()) {
                return;
            } else {
                zzayc2 = this.zzhir.zzayc();
            }
        } while (zzayc2 == this.tag);
        this.zzhit = zzayc2;
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final void zzu(List<Integer> list) {
        int zzayc;
        int zzayc2;
        if (!(list instanceof zzdrw)) {
            int i = this.tag & 7;
            if (i == 2) {
                int zzayl = this.zzhir.zzayl();
                zzft(zzayl);
                int zzayt = this.zzhir.zzayt() + zzayl;
                do {
                    list.add(Integer.valueOf(this.zzhir.zzayn()));
                } while (this.zzhir.zzayt() < zzayt);
                return;
            }
            if (i != 5) {
                throw zzdse.f();
            }
            do {
                list.add(Integer.valueOf(this.zzhir.zzayn()));
                if (this.zzhir.zzays()) {
                    return;
                } else {
                    zzayc = this.zzhir.zzayc();
                }
            } while (zzayc == this.tag);
            this.zzhit = zzayc;
            return;
        }
        zzdrw zzdrwVar = (zzdrw) list;
        int i2 = this.tag & 7;
        if (i2 == 2) {
            int zzayl2 = this.zzhir.zzayl();
            zzft(zzayl2);
            int zzayt2 = this.zzhir.zzayt() + zzayl2;
            do {
                zzdrwVar.zzgl(this.zzhir.zzayn());
            } while (this.zzhir.zzayt() < zzayt2);
            return;
        }
        if (i2 != 5) {
            throw zzdse.f();
        }
        do {
            zzdrwVar.zzgl(this.zzhir.zzayn());
            if (this.zzhir.zzays()) {
                return;
            } else {
                zzayc2 = this.zzhir.zzayc();
            }
        } while (zzayc2 == this.tag);
        this.zzhit = zzayc2;
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final void zzv(List<Long> list) {
        int zzayc;
        int zzayc2;
        if (!(list instanceof zzdss)) {
            int i = this.tag & 7;
            if (i != 1) {
                if (i != 2) {
                    throw zzdse.f();
                }
                int zzayl = this.zzhir.zzayl();
                zzfs(zzayl);
                int zzayt = this.zzhir.zzayt() + zzayl;
                do {
                    list.add(Long.valueOf(this.zzhir.zzayo()));
                } while (this.zzhir.zzayt() < zzayt);
                return;
            }
            do {
                list.add(Long.valueOf(this.zzhir.zzayo()));
                if (this.zzhir.zzays()) {
                    return;
                } else {
                    zzayc = this.zzhir.zzayc();
                }
            } while (zzayc == this.tag);
            this.zzhit = zzayc;
            return;
        }
        zzdss zzdssVar = (zzdss) list;
        int i2 = this.tag & 7;
        if (i2 != 1) {
            if (i2 != 2) {
                throw zzdse.f();
            }
            int zzayl2 = this.zzhir.zzayl();
            zzfs(zzayl2);
            int zzayt2 = this.zzhir.zzayt() + zzayl2;
            do {
                zzdssVar.zzfr(this.zzhir.zzayo());
            } while (this.zzhir.zzayt() < zzayt2);
            return;
        }
        do {
            zzdssVar.zzfr(this.zzhir.zzayo());
            if (this.zzhir.zzays()) {
                return;
            } else {
                zzayc2 = this.zzhir.zzayc();
            }
        } while (zzayc2 == this.tag);
        this.zzhit = zzayc2;
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final void zzw(List<Integer> list) {
        int zzayc;
        int zzayc2;
        if (!(list instanceof zzdrw)) {
            int i = this.tag & 7;
            if (i != 0) {
                if (i != 2) {
                    throw zzdse.f();
                }
                int zzayt = this.zzhir.zzayt() + this.zzhir.zzayl();
                do {
                    list.add(Integer.valueOf(this.zzhir.zzayp()));
                } while (this.zzhir.zzayt() < zzayt);
                zzfu(zzayt);
                return;
            }
            do {
                list.add(Integer.valueOf(this.zzhir.zzayp()));
                if (this.zzhir.zzays()) {
                    return;
                } else {
                    zzayc = this.zzhir.zzayc();
                }
            } while (zzayc == this.tag);
            this.zzhit = zzayc;
            return;
        }
        zzdrw zzdrwVar = (zzdrw) list;
        int i2 = this.tag & 7;
        if (i2 != 0) {
            if (i2 != 2) {
                throw zzdse.f();
            }
            int zzayt2 = this.zzhir.zzayt() + this.zzhir.zzayl();
            do {
                zzdrwVar.zzgl(this.zzhir.zzayp());
            } while (this.zzhir.zzayt() < zzayt2);
            zzfu(zzayt2);
            return;
        }
        do {
            zzdrwVar.zzgl(this.zzhir.zzayp());
            if (this.zzhir.zzays()) {
                return;
            } else {
                zzayc2 = this.zzhir.zzayc();
            }
        } while (zzayc2 == this.tag);
        this.zzhit = zzayc2;
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final void zzx(List<Long> list) {
        int zzayc;
        int zzayc2;
        if (!(list instanceof zzdss)) {
            int i = this.tag & 7;
            if (i != 0) {
                if (i != 2) {
                    throw zzdse.f();
                }
                int zzayt = this.zzhir.zzayt() + this.zzhir.zzayl();
                do {
                    list.add(Long.valueOf(this.zzhir.zzayq()));
                } while (this.zzhir.zzayt() < zzayt);
                zzfu(zzayt);
                return;
            }
            do {
                list.add(Long.valueOf(this.zzhir.zzayq()));
                if (this.zzhir.zzays()) {
                    return;
                } else {
                    zzayc = this.zzhir.zzayc();
                }
            } while (zzayc == this.tag);
            this.zzhit = zzayc;
            return;
        }
        zzdss zzdssVar = (zzdss) list;
        int i2 = this.tag & 7;
        if (i2 != 0) {
            if (i2 != 2) {
                throw zzdse.f();
            }
            int zzayt2 = this.zzhir.zzayt() + this.zzhir.zzayl();
            do {
                zzdssVar.zzfr(this.zzhir.zzayq());
            } while (this.zzhir.zzayt() < zzayt2);
            zzfu(zzayt2);
            return;
        }
        do {
            zzdssVar.zzfr(this.zzhir.zzayq());
            if (this.zzhir.zzays()) {
                return;
            } else {
                zzayc2 = this.zzhir.zzayc();
            }
        } while (zzayc2 == this.tag);
        this.zzhit = zzayc2;
    }
}
