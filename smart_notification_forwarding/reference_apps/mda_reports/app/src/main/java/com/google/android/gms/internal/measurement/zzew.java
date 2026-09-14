package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzey;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzew<T extends zzey<T>> {
    private static final zzew zzd = new zzew(true);
    final zzhi<T, Object> a;
    private boolean zzb;
    private boolean zzc;

    private zzew() {
        this.a = zzhi.a(16);
    }

    private zzew(zzhi<T, Object> zzhiVar) {
        this.a = zzhiVar;
        zzb();
    }

    private zzew(boolean z) {
        this(zzhi.a(0));
        zzb();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int a(zzim zzimVar, int i, Object obj) {
        int zze = zzen.zze(i);
        if (zzimVar == zzim.zzj) {
            zzff.a((zzgo) obj);
            zze <<= 1;
        }
        return zze + zzb(zzimVar, obj);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(zzen zzenVar, zzim zzimVar, int i, Object obj) {
        if (zzimVar == zzim.zzj) {
            zzgo zzgoVar = (zzgo) obj;
            zzff.a(zzgoVar);
            zzenVar.zza(i, 3);
            zzgoVar.zza(zzenVar);
            zzenVar.zza(i, 4);
            return;
        }
        zzenVar.zza(i, zzimVar.zzb());
        switch (zzev.b[zzimVar.ordinal()]) {
            case 1:
                zzenVar.zza(((Double) obj).doubleValue());
                return;
            case 2:
                zzenVar.zza(((Float) obj).floatValue());
                return;
            case 3:
                zzenVar.zza(((Long) obj).longValue());
                return;
            case 4:
                zzenVar.zza(((Long) obj).longValue());
                return;
            case 5:
                zzenVar.zza(((Integer) obj).intValue());
                return;
            case 6:
                zzenVar.zzc(((Long) obj).longValue());
                return;
            case 7:
                zzenVar.zzd(((Integer) obj).intValue());
                return;
            case 8:
                zzenVar.zza(((Boolean) obj).booleanValue());
                return;
            case 9:
                ((zzgo) obj).zza(zzenVar);
                return;
            case 10:
                zzenVar.zza((zzgo) obj);
                return;
            case 11:
                if (obj instanceof zzdu) {
                    zzenVar.zza((zzdu) obj);
                    return;
                } else {
                    zzenVar.zza((String) obj);
                    return;
                }
            case 12:
                if (obj instanceof zzdu) {
                    zzenVar.zza((zzdu) obj);
                    return;
                } else {
                    byte[] bArr = (byte[]) obj;
                    zzenVar.zzb(bArr, 0, bArr.length);
                    return;
                }
            case 13:
                zzenVar.zzb(((Integer) obj).intValue());
                return;
            case 14:
                zzenVar.zzd(((Integer) obj).intValue());
                return;
            case 15:
                zzenVar.zzc(((Long) obj).longValue());
                return;
            case 16:
                zzenVar.zzc(((Integer) obj).intValue());
                return;
            case 17:
                zzenVar.zzb(((Long) obj).longValue());
                return;
            case 18:
                if (obj instanceof zzfi) {
                    zzenVar.zza(((zzfi) obj).zza());
                    return;
                } else {
                    zzenVar.zza(((Integer) obj).intValue());
                    return;
                }
            default:
                return;
        }
    }

    public static int zza(zzey<?> zzeyVar, Object obj) {
        zzim zzb = zzeyVar.zzb();
        int zza = zzeyVar.zza();
        if (!zzeyVar.zzd()) {
            return a(zzb, zza, obj);
        }
        int i = 0;
        List list = (List) obj;
        if (zzeyVar.zze()) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                i += zzb(zzb, it.next());
            }
            return zzen.zze(zza) + i + zzen.zzl(i);
        }
        Iterator it2 = list.iterator();
        while (it2.hasNext()) {
            i += a(zzb, zza, it2.next());
        }
        return i;
    }

    public static <T extends zzey<T>> zzew<T> zza() {
        return zzd;
    }

    private final Object zza(T t) {
        Object obj = this.a.get(t);
        if (!(obj instanceof zzfp)) {
            return obj;
        }
        return zzfp.zza();
    }

    private static Object zza(Object obj) {
        if (obj instanceof zzgt) {
            return ((zzgt) obj).clone();
        }
        if (!(obj instanceof byte[])) {
            return obj;
        }
        byte[] bArr = (byte[]) obj;
        byte[] bArr2 = new byte[bArr.length];
        System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
        return bArr2;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x001c, code lost:
    
        if ((r3 instanceof com.google.android.gms.internal.measurement.zzfp) == false) goto L4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0025, code lost:
    
        if ((r3 instanceof com.google.android.gms.internal.measurement.zzfi) == false) goto L4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x002e, code lost:
    
        if ((r3 instanceof byte[]) == false) goto L4;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static void zza(com.google.android.gms.internal.measurement.zzim r2, java.lang.Object r3) {
        /*
            com.google.android.gms.internal.measurement.zzff.a(r3)
            int[] r0 = com.google.android.gms.internal.measurement.zzev.a
            com.google.android.gms.internal.measurement.zzip r2 = r2.zza()
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
            boolean r2 = r3 instanceof com.google.android.gms.internal.measurement.zzgo
            if (r2 != 0) goto L42
            boolean r2 = r3 instanceof com.google.android.gms.internal.measurement.zzfp
            if (r2 == 0) goto L14
            goto L42
        L1f:
            boolean r2 = r3 instanceof java.lang.Integer
            if (r2 != 0) goto L42
            boolean r2 = r3 instanceof com.google.android.gms.internal.measurement.zzfi
            if (r2 == 0) goto L14
            goto L42
        L28:
            boolean r2 = r3 instanceof com.google.android.gms.internal.measurement.zzdu
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
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzew.zza(com.google.android.gms.internal.measurement.zzim, java.lang.Object):void");
    }

    private static <T extends zzey<T>> boolean zza(Map.Entry<T, Object> entry) {
        T key = entry.getKey();
        if (key.zzc() == zzip.MESSAGE) {
            boolean zzd2 = key.zzd();
            Object value = entry.getValue();
            if (zzd2) {
                Iterator it = ((List) value).iterator();
                while (it.hasNext()) {
                    if (!((zzgo) it.next()).zzbl()) {
                        return false;
                    }
                }
            } else {
                if (!(value instanceof zzgo)) {
                    if (value instanceof zzfp) {
                        return true;
                    }
                    throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
                }
                if (!((zzgo) value).zzbl()) {
                    return false;
                }
            }
        }
        return true;
    }

    private static int zzb(zzim zzimVar, Object obj) {
        switch (zzev.b[zzimVar.ordinal()]) {
            case 1:
                return zzen.zzb(((Double) obj).doubleValue());
            case 2:
                return zzen.zzb(((Float) obj).floatValue());
            case 3:
                return zzen.zzd(((Long) obj).longValue());
            case 4:
                return zzen.zze(((Long) obj).longValue());
            case 5:
                return zzen.zzf(((Integer) obj).intValue());
            case 6:
                return zzen.zzg(((Long) obj).longValue());
            case 7:
                return zzen.zzi(((Integer) obj).intValue());
            case 8:
                return zzen.zzb(((Boolean) obj).booleanValue());
            case 9:
                return zzen.zzc((zzgo) obj);
            case 10:
                return obj instanceof zzfp ? zzen.zza((zzfp) obj) : zzen.zzb((zzgo) obj);
            case 11:
                return obj instanceof zzdu ? zzen.zzb((zzdu) obj) : zzen.zzb((String) obj);
            case 12:
                return obj instanceof zzdu ? zzen.zzb((zzdu) obj) : zzen.zzb((byte[]) obj);
            case 13:
                return zzen.zzg(((Integer) obj).intValue());
            case 14:
                return zzen.zzj(((Integer) obj).intValue());
            case 15:
                return zzen.zzh(((Long) obj).longValue());
            case 16:
                return zzen.zzh(((Integer) obj).intValue());
            case 17:
                return zzen.zzf(((Long) obj).longValue());
            case 18:
                return obj instanceof zzfi ? zzen.zzk(((zzfi) obj).zza()) : zzen.zzk(((Integer) obj).intValue());
            default:
                throw new RuntimeException("There is no way to get here, but the compiler thinks otherwise.");
        }
    }

    private final void zzb(T t, Object obj) {
        if (!t.zzd()) {
            zza(t.zzb(), obj);
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
                zza(t.zzb(), obj2);
            }
            obj = arrayList;
        }
        if (obj instanceof zzfp) {
            this.zzc = true;
        }
        this.a.put(t, obj);
    }

    private final void zzb(Map.Entry<T, Object> entry) {
        T key = entry.getKey();
        Object value = entry.getValue();
        if (value instanceof zzfp) {
            value = zzfp.zza();
        }
        if (key.zzd()) {
            Object zza = zza((zzew<T>) key);
            if (zza == null) {
                zza = new ArrayList();
            }
            Iterator it = ((List) value).iterator();
            while (it.hasNext()) {
                ((List) zza).add(zza(it.next()));
            }
            this.a.put(key, zza);
            return;
        }
        if (key.zzc() != zzip.MESSAGE) {
            this.a.put(key, zza(value));
            return;
        }
        Object zza2 = zza((zzew<T>) key);
        if (zza2 == null) {
            this.a.put(key, zza(value));
        } else {
            this.a.put(key, zza2 instanceof zzgt ? key.zza((zzgt) zza2, (zzgt) value) : key.zza(((zzgo) zza2).zzbr(), (zzgo) value).zzu());
        }
    }

    private static int zzc(Map.Entry<T, Object> entry) {
        T key = entry.getKey();
        Object value = entry.getValue();
        if (key.zzc() != zzip.MESSAGE || key.zzd() || key.zze()) {
            return zza((zzey<?>) key, value);
        }
        boolean z = value instanceof zzfp;
        int zza = entry.getKey().zza();
        return z ? zzen.zzb(zza, (zzfp) value) : zzen.zzb(zza, (zzgo) value);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Iterator<Map.Entry<T, Object>> a() {
        return this.zzc ? new zzfu(this.a.a().iterator()) : this.a.a().iterator();
    }

    public final /* synthetic */ Object clone() {
        zzew zzewVar = new zzew();
        for (int i = 0; i < this.a.zzc(); i++) {
            Map.Entry<T, Object> zzb = this.a.zzb(i);
            zzewVar.zzb((zzew) zzb.getKey(), zzb.getValue());
        }
        for (Map.Entry<T, Object> entry : this.a.zzd()) {
            zzewVar.zzb((zzew) entry.getKey(), entry.getValue());
        }
        zzewVar.zzc = this.zzc;
        return zzewVar;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zzew) {
            return this.a.equals(((zzew) obj).a);
        }
        return false;
    }

    public final int hashCode() {
        return this.a.hashCode();
    }

    public final void zza(zzew<T> zzewVar) {
        for (int i = 0; i < zzewVar.a.zzc(); i++) {
            zzb(zzewVar.a.zzb(i));
        }
        Iterator<Map.Entry<T, Object>> it = zzewVar.a.zzd().iterator();
        while (it.hasNext()) {
            zzb(it.next());
        }
    }

    public final void zzb() {
        if (this.zzb) {
            return;
        }
        this.a.zza();
        this.zzb = true;
    }

    public final boolean zzc() {
        return this.zzb;
    }

    public final Iterator<Map.Entry<T, Object>> zzd() {
        return this.zzc ? new zzfu(this.a.entrySet().iterator()) : this.a.entrySet().iterator();
    }

    public final boolean zzf() {
        for (int i = 0; i < this.a.zzc(); i++) {
            if (!zza((Map.Entry) this.a.zzb(i))) {
                return false;
            }
        }
        Iterator<Map.Entry<T, Object>> it = this.a.zzd().iterator();
        while (it.hasNext()) {
            if (!zza((Map.Entry) it.next())) {
                return false;
            }
        }
        return true;
    }

    public final int zzg() {
        int i = 0;
        for (int i2 = 0; i2 < this.a.zzc(); i2++) {
            i += zzc(this.a.zzb(i2));
        }
        Iterator<Map.Entry<T, Object>> it = this.a.zzd().iterator();
        while (it.hasNext()) {
            i += zzc(it.next());
        }
        return i;
    }
}
