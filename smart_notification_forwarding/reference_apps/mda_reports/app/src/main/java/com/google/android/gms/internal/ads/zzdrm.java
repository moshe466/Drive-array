package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdro;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzdrm<T extends zzdro<T>> {
    private static final zzdrm zzhjs = new zzdrm(true);
    final zzdub<T, Object> a;
    private boolean zzhjq;
    private boolean zzhjr;

    private zzdrm() {
        this.a = zzdub.a(16);
    }

    private zzdrm(zzdub<T, Object> zzdubVar) {
        this.a = zzdubVar;
        zzaxq();
    }

    private zzdrm(boolean z) {
        this(zzdub.a(0));
        zzaxq();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int a(zzdvf zzdvfVar, int i, Object obj) {
        int zzfz = zzdrb.zzfz(i);
        if (zzdvfVar == zzdvf.zzhso) {
            zzdrv.a((zzdte) obj);
            zzfz <<= 1;
        }
        return zzfz + zzb(zzdvfVar, obj);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(zzdrb zzdrbVar, zzdvf zzdvfVar, int i, Object obj) {
        if (zzdvfVar == zzdvf.zzhso) {
            zzdte zzdteVar = (zzdte) obj;
            zzdrv.a(zzdteVar);
            zzdrbVar.zzaa(i, 3);
            zzdteVar.zzb(zzdrbVar);
            zzdrbVar.zzaa(i, 4);
            return;
        }
        zzdrbVar.zzaa(i, zzdvfVar.zzbcq());
        switch (zzdrl.b[zzdvfVar.ordinal()]) {
            case 1:
                zzdrbVar.zzb(((Double) obj).doubleValue());
                return;
            case 2:
                zzdrbVar.zzf(((Float) obj).floatValue());
                return;
            case 3:
                zzdrbVar.zzfg(((Long) obj).longValue());
                return;
            case 4:
                zzdrbVar.zzfg(((Long) obj).longValue());
                return;
            case 5:
                zzdrbVar.zzfv(((Integer) obj).intValue());
                return;
            case 6:
                zzdrbVar.zzfi(((Long) obj).longValue());
                return;
            case 7:
                zzdrbVar.zzfy(((Integer) obj).intValue());
                return;
            case 8:
                zzdrbVar.zzbn(((Boolean) obj).booleanValue());
                return;
            case 9:
                ((zzdte) obj).zzb(zzdrbVar);
                return;
            case 10:
                zzdrbVar.zzg((zzdte) obj);
                return;
            case 11:
                if (obj instanceof zzdqk) {
                    zzdrbVar.zzbe((zzdqk) obj);
                    return;
                } else {
                    zzdrbVar.zzhg((String) obj);
                    return;
                }
            case 12:
                if (obj instanceof zzdqk) {
                    zzdrbVar.zzbe((zzdqk) obj);
                    return;
                } else {
                    byte[] bArr = (byte[]) obj;
                    zzdrbVar.zzk(bArr, 0, bArr.length);
                    return;
                }
            case 13:
                zzdrbVar.zzfw(((Integer) obj).intValue());
                return;
            case 14:
                zzdrbVar.zzfy(((Integer) obj).intValue());
                return;
            case 15:
                zzdrbVar.zzfi(((Long) obj).longValue());
                return;
            case 16:
                zzdrbVar.zzfx(((Integer) obj).intValue());
                return;
            case 17:
                zzdrbVar.zzfh(((Long) obj).longValue());
                return;
            case 18:
                if (obj instanceof zzdry) {
                    zzdrbVar.zzfv(((zzdry) obj).zzae());
                    return;
                } else {
                    zzdrbVar.zzfv(((Integer) obj).intValue());
                    return;
                }
            default:
                return;
        }
    }

    private final Object zza(T t) {
        Object obj = this.a.get(t);
        if (!(obj instanceof zzdsf)) {
            return obj;
        }
        return zzdsf.zzbas();
    }

    private final void zza(T t, Object obj) {
        if (!t.zzazq()) {
            zza(t.zzazo(), obj);
        } else {
            if (!(obj instanceof List)) {
                throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
            }
            ArrayList arrayList = new ArrayList();
            arrayList.addAll((List) obj);
            int size = arrayList.size();
            int i = 0;
            while (i < size) {
                Object obj2 = arrayList.get(i);
                i++;
                zza(t.zzazo(), obj2);
            }
            obj = arrayList;
        }
        if (obj instanceof zzdsf) {
            this.zzhjr = true;
        }
        this.a.put(t, obj);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x001c, code lost:
    
        if ((r3 instanceof com.google.android.gms.internal.ads.zzdsf) == false) goto L4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0025, code lost:
    
        if ((r3 instanceof com.google.android.gms.internal.ads.zzdry) == false) goto L4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x002e, code lost:
    
        if ((r3 instanceof byte[]) == false) goto L4;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static void zza(com.google.android.gms.internal.ads.zzdvf r2, java.lang.Object r3) {
        /*
            com.google.android.gms.internal.ads.zzdrv.a(r3)
            int[] r0 = com.google.android.gms.internal.ads.zzdrl.a
            com.google.android.gms.internal.ads.zzdvm r2 = r2.zzbcp()
            int r2 = r2.ordinal()
            r2 = r0[r2]
            r0 = 1
            r1 = 0
            switch(r2) {
                case 1: goto L40;
                case 2: goto L3d;
                case 3: goto L3a;
                case 4: goto L37;
                case 5: goto L34;
                case 6: goto L31;
                case 7: goto L28;
                case 8: goto L1f;
                case 9: goto L16;
                default: goto L14;
            }
        L14:
            r0 = 0
            goto L42
        L16:
            boolean r2 = r3 instanceof com.google.android.gms.internal.ads.zzdte
            if (r2 != 0) goto L42
            boolean r2 = r3 instanceof com.google.android.gms.internal.ads.zzdsf
            if (r2 == 0) goto L14
            goto L42
        L1f:
            boolean r2 = r3 instanceof java.lang.Integer
            if (r2 != 0) goto L42
            boolean r2 = r3 instanceof com.google.android.gms.internal.ads.zzdry
            if (r2 == 0) goto L14
            goto L42
        L28:
            boolean r2 = r3 instanceof com.google.android.gms.internal.ads.zzdqk
            if (r2 != 0) goto L42
            boolean r2 = r3 instanceof byte[]
            if (r2 == 0) goto L14
            goto L42
        L31:
            boolean r0 = r3 instanceof java.lang.String
            goto L42
        L34:
            boolean r0 = r3 instanceof java.lang.Boolean
            goto L42
        L37:
            boolean r0 = r3 instanceof java.lang.Double
            goto L42
        L3a:
            boolean r0 = r3 instanceof java.lang.Float
            goto L42
        L3d:
            boolean r0 = r3 instanceof java.lang.Long
            goto L42
        L40:
            boolean r0 = r3 instanceof java.lang.Integer
        L42:
            if (r0 == 0) goto L45
            return
        L45:
            java.lang.IllegalArgumentException r2 = new java.lang.IllegalArgumentException
            java.lang.String r3 = "Wrong object type used with protocol message reflection."
            r2.<init>(r3)
            goto L4e
        L4d:
            throw r2
        L4e:
            goto L4d
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzdrm.zza(com.google.android.gms.internal.ads.zzdvf, java.lang.Object):void");
    }

    private static Object zzao(Object obj) {
        if (obj instanceof zzdtj) {
            return ((zzdtj) obj).clone();
        }
        if (!(obj instanceof byte[])) {
            return obj;
        }
        byte[] bArr = (byte[]) obj;
        byte[] bArr2 = new byte[bArr.length];
        System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
        return bArr2;
    }

    public static <T extends zzdro<T>> zzdrm<T> zzazm() {
        return zzhjs;
    }

    public static int zzb(zzdro<?> zzdroVar, Object obj) {
        zzdvf zzazo = zzdroVar.zzazo();
        int zzae = zzdroVar.zzae();
        if (!zzdroVar.zzazq()) {
            return a(zzazo, zzae, obj);
        }
        int i = 0;
        List list = (List) obj;
        if (zzdroVar.zzazr()) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                i += zzb(zzazo, it.next());
            }
            return zzdrb.zzfz(zzae) + i + zzdrb.zzgh(i);
        }
        Iterator it2 = list.iterator();
        while (it2.hasNext()) {
            i += a(zzazo, zzae, it2.next());
        }
        return i;
    }

    private static int zzb(zzdvf zzdvfVar, Object obj) {
        switch (zzdrl.b[zzdvfVar.ordinal()]) {
            case 1:
                return zzdrb.zzc(((Double) obj).doubleValue());
            case 2:
                return zzdrb.zzg(((Float) obj).floatValue());
            case 3:
                return zzdrb.zzfj(((Long) obj).longValue());
            case 4:
                return zzdrb.zzfk(((Long) obj).longValue());
            case 5:
                return zzdrb.zzga(((Integer) obj).intValue());
            case 6:
                return zzdrb.zzfm(((Long) obj).longValue());
            case 7:
                return zzdrb.zzgd(((Integer) obj).intValue());
            case 8:
                return zzdrb.zzbo(((Boolean) obj).booleanValue());
            case 9:
                return zzdrb.zzi((zzdte) obj);
            case 10:
                return obj instanceof zzdsf ? zzdrb.zza((zzdsf) obj) : zzdrb.zzh((zzdte) obj);
            case 11:
                return obj instanceof zzdqk ? zzdrb.zzbf((zzdqk) obj) : zzdrb.zzhh((String) obj);
            case 12:
                return obj instanceof zzdqk ? zzdrb.zzbf((zzdqk) obj) : zzdrb.zzx((byte[]) obj);
            case 13:
                return zzdrb.zzgb(((Integer) obj).intValue());
            case 14:
                return zzdrb.zzge(((Integer) obj).intValue());
            case 15:
                return zzdrb.zzfn(((Long) obj).longValue());
            case 16:
                return zzdrb.zzgc(((Integer) obj).intValue());
            case 17:
                return zzdrb.zzfl(((Long) obj).longValue());
            case 18:
                return obj instanceof zzdry ? zzdrb.zzgf(((zzdry) obj).zzae()) : zzdrb.zzgf(((Integer) obj).intValue());
            default:
                throw new RuntimeException("There is no way to get here, but the compiler thinks otherwise.");
        }
    }

    private static <T extends zzdro<T>> boolean zzb(Map.Entry<T, Object> entry) {
        T key = entry.getKey();
        if (key.zzazp() == zzdvm.MESSAGE) {
            boolean zzazq = key.zzazq();
            Object value = entry.getValue();
            if (zzazq) {
                Iterator it = ((List) value).iterator();
                while (it.hasNext()) {
                    if (!((zzdte) it.next()).isInitialized()) {
                        return false;
                    }
                }
            } else {
                if (!(value instanceof zzdte)) {
                    if (value instanceof zzdsf) {
                        return true;
                    }
                    throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
                }
                if (!((zzdte) value).isInitialized()) {
                    return false;
                }
            }
        }
        return true;
    }

    private final void zzc(Map.Entry<T, Object> entry) {
        T key = entry.getKey();
        Object value = entry.getValue();
        if (value instanceof zzdsf) {
            value = zzdsf.zzbas();
        }
        if (key.zzazq()) {
            Object zza = zza((zzdrm<T>) key);
            if (zza == null) {
                zza = new ArrayList();
            }
            Iterator it = ((List) value).iterator();
            while (it.hasNext()) {
                ((List) zza).add(zzao(it.next()));
            }
            this.a.put(key, zza);
            return;
        }
        if (key.zzazp() != zzdvm.MESSAGE) {
            this.a.put(key, zzao(value));
            return;
        }
        Object zza2 = zza((zzdrm<T>) key);
        if (zza2 == null) {
            this.a.put(key, zzao(value));
        } else {
            this.a.put(key, zza2 instanceof zzdtj ? key.zza((zzdtj) zza2, (zzdtj) value) : key.zza(((zzdte) zza2).zzazx(), (zzdte) value).zzbaf());
        }
    }

    private static int zzd(Map.Entry<T, Object> entry) {
        T key = entry.getKey();
        Object value = entry.getValue();
        if (key.zzazp() != zzdvm.MESSAGE || key.zzazq() || key.zzazr()) {
            return zzb((zzdro<?>) key, value);
        }
        boolean z = value instanceof zzdsf;
        int zzae = entry.getKey().zzae();
        return z ? zzdrb.zzb(zzae, (zzdsf) value) : zzdrb.zzd(zzae, (zzdte) value);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Iterator<Map.Entry<T, Object>> a() {
        return this.zzhjr ? new zzdsk(this.a.a().iterator()) : this.a.a().iterator();
    }

    public final /* synthetic */ Object clone() {
        zzdrm zzdrmVar = new zzdrm();
        for (int i = 0; i < this.a.zzbbs(); i++) {
            Map.Entry<T, Object> zzgw = this.a.zzgw(i);
            zzdrmVar.zza((zzdrm) zzgw.getKey(), zzgw.getValue());
        }
        for (Map.Entry<T, Object> entry : this.a.zzbbt()) {
            zzdrmVar.zza((zzdrm) entry.getKey(), entry.getValue());
        }
        zzdrmVar.zzhjr = this.zzhjr;
        return zzdrmVar;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zzdrm) {
            return this.a.equals(((zzdrm) obj).a);
        }
        return false;
    }

    public final int hashCode() {
        return this.a.hashCode();
    }

    public final boolean isImmutable() {
        return this.zzhjq;
    }

    public final boolean isInitialized() {
        for (int i = 0; i < this.a.zzbbs(); i++) {
            if (!zzb(this.a.zzgw(i))) {
                return false;
            }
        }
        Iterator<Map.Entry<T, Object>> it = this.a.zzbbt().iterator();
        while (it.hasNext()) {
            if (!zzb(it.next())) {
                return false;
            }
        }
        return true;
    }

    public final Iterator<Map.Entry<T, Object>> iterator() {
        return this.zzhjr ? new zzdsk(this.a.entrySet().iterator()) : this.a.entrySet().iterator();
    }

    public final void zza(zzdrm<T> zzdrmVar) {
        for (int i = 0; i < zzdrmVar.a.zzbbs(); i++) {
            zzc(zzdrmVar.a.zzgw(i));
        }
        Iterator<Map.Entry<T, Object>> it = zzdrmVar.a.zzbbt().iterator();
        while (it.hasNext()) {
            zzc(it.next());
        }
    }

    public final void zzaxq() {
        if (this.zzhjq) {
            return;
        }
        this.a.zzaxq();
        this.zzhjq = true;
    }

    public final int zzazn() {
        int i = 0;
        for (int i2 = 0; i2 < this.a.zzbbs(); i2++) {
            i += zzd(this.a.zzgw(i2));
        }
        Iterator<Map.Entry<T, Object>> it = this.a.zzbbt().iterator();
        while (it.hasNext()) {
            i += zzd(it.next());
        }
        return i;
    }
}
