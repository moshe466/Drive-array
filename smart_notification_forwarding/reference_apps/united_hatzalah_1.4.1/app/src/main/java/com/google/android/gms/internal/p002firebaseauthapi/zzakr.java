package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.internal.p002firebaseauthapi.zzakt;
import com.google.firebase.remoteconfig.internal.Code;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzakr<T extends zzakt<T>> {
    private static final zzakr<?> zzb = new zzakr<>(true);
    final zzamw<T, Object> zza;
    private boolean zzc;
    private boolean zzd;

    private zzakr() {
        this.zza = new zzamz();
    }

    public static int zza(zzanw zzanwVar, int i, Object obj) {
        int zzi = zzakg.zzi(i);
        if (zzanwVar == zzanw.zzj) {
            zzalb.zza((zzamc) obj);
            zzi <<= 1;
        }
        return zzi + zza(zzanwVar, obj);
    }

    public static <T extends zzakt<T>> zzakr<T> zzb() {
        return (zzakr<T>) zzb;
    }

    public final /* synthetic */ Object clone() {
        zzakr zzakrVar = new zzakr();
        int zza = this.zza.zza();
        for (int i = 0; i < zza; i++) {
            Map.Entry<T, Object> zza2 = this.zza.zza(i);
            zzakrVar.zzb(zza2.getKey(), zza2.getValue());
        }
        for (Map.Entry<T, Object> entry : this.zza.zzb()) {
            zzakrVar.zzb(entry.getKey(), entry.getValue());
        }
        zzakrVar.zzd = this.zzd;
        return zzakrVar;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzakr)) {
            return false;
        }
        return this.zza.equals(((zzakr) obj).zza);
    }

    public final int hashCode() {
        return this.zza.hashCode();
    }

    public final Iterator<Map.Entry<T, Object>> zzc() {
        if (this.zza.isEmpty()) {
            return Collections.emptyIterator();
        }
        if (this.zzd) {
            return new zzali(this.zza.zzc().iterator());
        }
        return this.zza.zzc().iterator();
    }

    public final Iterator<Map.Entry<T, Object>> zzd() {
        if (this.zza.isEmpty()) {
            return Collections.emptyIterator();
        }
        if (this.zzd) {
            return new zzali(this.zza.entrySet().iterator());
        }
        return this.zza.entrySet().iterator();
    }

    public final void zze() {
        if (this.zzc) {
            return;
        }
        int zza = this.zza.zza();
        for (int i = 0; i < zza; i++) {
            Object value = this.zza.zza(i).getValue();
            if (value instanceof zzaky) {
                ((zzaky) value).zzs();
            }
        }
        Iterator<Map.Entry<T, Object>> it = this.zza.zzb().iterator();
        while (it.hasNext()) {
            Object value2 = it.next().getValue();
            if (value2 instanceof zzaky) {
                ((zzaky) value2).zzs();
            }
        }
        this.zza.zzd();
        this.zzc = true;
    }

    public final boolean zzf() {
        return this.zzc;
    }

    public final boolean zzg() {
        int zza = this.zza.zza();
        for (int i = 0; i < zza; i++) {
            if (!zzc(this.zza.zza(i))) {
                return false;
            }
        }
        Iterator<Map.Entry<T, Object>> it = this.zza.zzb().iterator();
        while (it.hasNext()) {
            if (!zzc(it.next())) {
                return false;
            }
        }
        return true;
    }

    private final void zzb(Map.Entry<T, Object> entry) {
        zzamc zze;
        T key = entry.getKey();
        Object value = entry.getValue();
        boolean z3 = value instanceof zzalg;
        if (key.zze()) {
            if (!z3) {
                Object zza = zza((zzakr<T>) key);
                List list = (List) value;
                int size = list.size();
                if (zza == null) {
                    zza = new ArrayList(size);
                }
                List list2 = (List) zza;
                for (int i = 0; i < size; i++) {
                    list2.add(zza(list.get(i)));
                }
                this.zza.zza((zzamw<T, Object>) key, (T) zza);
                return;
            }
            throw new IllegalStateException("Lazy fields can not be repeated");
        }
        if (key.zzc() != zzaod.MESSAGE) {
            if (!z3) {
                this.zza.zza((zzamw<T, Object>) key, (T) zza(value));
                return;
            }
            throw new IllegalStateException("Lazy fields must be message-valued");
        }
        Object zza2 = zza((zzakr<T>) key);
        if (zza2 == null) {
            this.zza.zza((zzamw<T, Object>) key, (T) zza(value));
            if (z3) {
                this.zzd = true;
                return;
            }
            return;
        }
        if (!z3) {
            if (zza2 instanceof zzaml) {
                zze = key.zza((zzaml) zza2, (zzaml) value);
            } else {
                zze = key.zza(((zzamc) zza2).zzr(), (zzamc) value).zze();
            }
            this.zza.zza((zzamw<T, Object>) key, (T) zze);
            return;
        }
        throw new NoSuchMethodError();
    }

    private zzakr(zzamw<T, Object> zzamwVar) {
        this.zza = zzamwVar;
        zze();
    }

    private static int zza(zzanw zzanwVar, Object obj) {
        switch (zzakq.zzb[zzanwVar.ordinal()]) {
            case 1:
                return zzakg.zza(((Double) obj).doubleValue());
            case 2:
                return zzakg.zza(((Float) obj).floatValue());
            case 3:
                return zzakg.zzd(((Long) obj).longValue());
            case 4:
                return zzakg.zzg(((Long) obj).longValue());
            case 5:
                return zzakg.zze(((Integer) obj).intValue());
            case 6:
                return zzakg.zzc(((Long) obj).longValue());
            case 7:
                return zzakg.zzd(((Integer) obj).intValue());
            case 8:
                return zzakg.zza(((Boolean) obj).booleanValue());
            case 9:
                return zzakg.zza((zzamc) obj);
            case 10:
                if (obj instanceof zzalg) {
                    return zzakg.zza((zzalg) obj);
                }
                return zzakg.zzb((zzamc) obj);
            case 11:
                if (obj instanceof zzajp) {
                    return zzakg.zza((zzajp) obj);
                }
                return zzakg.zza((String) obj);
            case Code.UNIMPLEMENTED /* 12 */:
                if (obj instanceof zzajp) {
                    return zzakg.zza((zzajp) obj);
                }
                return zzakg.zza((byte[]) obj);
            case 13:
                return zzakg.zzj(((Integer) obj).intValue());
            case 14:
                return zzakg.zzg(((Integer) obj).intValue());
            case 15:
                return zzakg.zze(((Long) obj).longValue());
            case 16:
                return zzakg.zzh(((Integer) obj).intValue());
            case 17:
                return zzakg.zzf(((Long) obj).longValue());
            case ConnectionResult.SERVICE_UPDATING /* 18 */:
                if (obj instanceof zzala) {
                    return zzakg.zzc(((zzala) obj).zza());
                }
                return zzakg.zzc(((Integer) obj).intValue());
            default:
                throw new RuntimeException("There is no way to get here, but the compiler thinks otherwise.");
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0020, code lost:
    
        if ((r4 instanceof com.google.android.gms.internal.p002firebaseauthapi.zzalg) == false) goto L4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0029, code lost:
    
        if ((r4 instanceof com.google.android.gms.internal.p002firebaseauthapi.zzala) == false) goto L4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0032, code lost:
    
        if ((r4 instanceof byte[]) == false) goto L4;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static void zzc(T r3, java.lang.Object r4) {
        /*
            com.google.android.gms.internal.firebase-auth-api.zzanw r0 = r3.zzb()
            com.google.android.gms.internal.p002firebaseauthapi.zzalb.zza(r4)
            int[] r1 = com.google.android.gms.internal.p002firebaseauthapi.zzakq.zza
            com.google.android.gms.internal.firebase-auth-api.zzaod r0 = r0.zzb()
            int r0 = r0.ordinal()
            r0 = r1[r0]
            r1 = 1
            r2 = 0
            switch(r0) {
                case 1: goto L44;
                case 2: goto L41;
                case 3: goto L3e;
                case 4: goto L3b;
                case 5: goto L38;
                case 6: goto L35;
                case 7: goto L2c;
                case 8: goto L23;
                case 9: goto L1a;
                default: goto L18;
            }
        L18:
            r1 = r2
            goto L46
        L1a:
            boolean r0 = r4 instanceof com.google.android.gms.internal.p002firebaseauthapi.zzamc
            if (r0 != 0) goto L46
            boolean r0 = r4 instanceof com.google.android.gms.internal.p002firebaseauthapi.zzalg
            if (r0 == 0) goto L18
            goto L46
        L23:
            boolean r0 = r4 instanceof java.lang.Integer
            if (r0 != 0) goto L46
            boolean r0 = r4 instanceof com.google.android.gms.internal.p002firebaseauthapi.zzala
            if (r0 == 0) goto L18
            goto L46
        L2c:
            boolean r0 = r4 instanceof com.google.android.gms.internal.p002firebaseauthapi.zzajp
            if (r0 != 0) goto L46
            boolean r0 = r4 instanceof byte[]
            if (r0 == 0) goto L18
            goto L46
        L35:
            boolean r1 = r4 instanceof java.lang.String
            goto L46
        L38:
            boolean r1 = r4 instanceof java.lang.Boolean
            goto L46
        L3b:
            boolean r1 = r4 instanceof java.lang.Double
            goto L46
        L3e:
            boolean r1 = r4 instanceof java.lang.Float
            goto L46
        L41:
            boolean r1 = r4 instanceof java.lang.Long
            goto L46
        L44:
            boolean r1 = r4 instanceof java.lang.Integer
        L46:
            if (r1 == 0) goto L49
            return
        L49:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            int r1 = r3.zza()
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            com.google.android.gms.internal.firebase-auth-api.zzanw r3 = r3.zzb()
            com.google.android.gms.internal.firebase-auth-api.zzaod r3 = r3.zzb()
            java.lang.Class r4 = r4.getClass()
            java.lang.String r4 = r4.getName()
            java.lang.Object[] r3 = new java.lang.Object[]{r1, r3, r4}
            java.lang.String r4 = "Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n"
            java.lang.String r3 = java.lang.String.format(r4, r3)
            r0.<init>(r3)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.p002firebaseauthapi.zzakr.zzc(com.google.android.gms.internal.firebase-auth-api.zzakt, java.lang.Object):void");
    }

    private zzakr(boolean z3) {
        this(new zzamz());
        zze();
    }

    private static <T extends zzakt<T>> boolean zzc(Map.Entry<T, Object> entry) {
        T key = entry.getKey();
        if (key.zzc() != zzaod.MESSAGE) {
            return true;
        }
        if (key.zze()) {
            List list = (List) entry.getValue();
            int size = list.size();
            for (int i = 0; i < size; i++) {
                if (!zzb(list.get(i))) {
                    return false;
                }
            }
            return true;
        }
        return zzb(entry.getValue());
    }

    private final void zzb(T t3, Object obj) {
        if (t3.zze()) {
            if (obj instanceof List) {
                List list = (List) obj;
                int size = list.size();
                ArrayList arrayList = new ArrayList(size);
                for (int i = 0; i < size; i++) {
                    Object obj2 = list.get(i);
                    zzc(t3, obj2);
                    arrayList.add(obj2);
                }
                obj = arrayList;
            } else {
                throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
            }
        } else {
            zzc(t3, obj);
        }
        if (obj instanceof zzalg) {
            this.zzd = true;
        }
        this.zza.zza((zzamw<T, Object>) t3, (T) obj);
    }

    public static int zza(zzakt<?> zzaktVar, Object obj) {
        zzanw zzb2 = zzaktVar.zzb();
        int zza = zzaktVar.zza();
        if (zzaktVar.zze()) {
            List list = (List) obj;
            int size = list.size();
            int i = 0;
            if (!zzaktVar.zzd()) {
                int i3 = 0;
                while (i < size) {
                    i3 += zza(zzb2, zza, list.get(i));
                    i++;
                }
                return i3;
            }
            if (list.isEmpty()) {
                return 0;
            }
            int i4 = 0;
            while (i < size) {
                i4 += zza(zzb2, list.get(i));
                i++;
            }
            return zzakg.zzj(i4) + zzakg.zzi(zza) + i4;
        }
        return zza(zzb2, zza, obj);
    }

    private static boolean zzb(Object obj) {
        if (obj instanceof zzame) {
            return ((zzame) obj).zzj();
        }
        if (obj instanceof zzalg) {
            return true;
        }
        throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
    }

    public final int zza() {
        int zza = this.zza.zza();
        int i = 0;
        for (int i3 = 0; i3 < zza; i3++) {
            i += zza((Map.Entry) this.zza.zza(i3));
        }
        Iterator<Map.Entry<T, Object>> it = this.zza.zzb().iterator();
        while (it.hasNext()) {
            i += zza((Map.Entry) it.next());
        }
        return i;
    }

    private static int zza(Map.Entry<T, Object> entry) {
        T key = entry.getKey();
        Object value = entry.getValue();
        if (key.zzc() == zzaod.MESSAGE && !key.zze() && !key.zzd()) {
            if (value instanceof zzalg) {
                return zzakg.zza(entry.getKey().zza(), (zzalg) value);
            }
            return zzakg.zza(entry.getKey().zza(), (zzamc) value);
        }
        return zza((zzakt<?>) key, value);
    }

    private static Object zza(Object obj) {
        if (obj instanceof zzaml) {
            return ((zzaml) obj).clone();
        }
        if (!(obj instanceof byte[])) {
            return obj;
        }
        byte[] bArr = (byte[]) obj;
        byte[] bArr2 = new byte[bArr.length];
        System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
        return bArr2;
    }

    private final Object zza(T t3) {
        Object obj = this.zza.get(t3);
        if (obj instanceof zzalg) {
            throw new NoSuchMethodError();
        }
        return obj;
    }

    public final void zza(zzakr<T> zzakrVar) {
        int zza = zzakrVar.zza.zza();
        for (int i = 0; i < zza; i++) {
            zzb((Map.Entry) zzakrVar.zza.zza(i));
        }
        Iterator<Map.Entry<T, Object>> it = zzakrVar.zza.zzb().iterator();
        while (it.hasNext()) {
            zzb((Map.Entry) it.next());
        }
    }

    public static void zza(zzakg zzakgVar, zzanw zzanwVar, int i, Object obj) {
        if (zzanwVar == zzanw.zzj) {
            zzamc zzamcVar = (zzamc) obj;
            zzalb.zza(zzamcVar);
            zzakgVar.zzk(i, 3);
            zzamcVar.zza(zzakgVar);
            zzakgVar.zzk(i, 4);
            return;
        }
        zzakgVar.zzk(i, zzanwVar.zza());
        switch (zzakq.zzb[zzanwVar.ordinal()]) {
            case 1:
                zzakgVar.zzb(((Double) obj).doubleValue());
                return;
            case 2:
                zzakgVar.zzb(((Float) obj).floatValue());
                return;
            case 3:
                zzakgVar.zzj(((Long) obj).longValue());
                return;
            case 4:
                zzakgVar.zzj(((Long) obj).longValue());
                return;
            case 5:
                zzakgVar.zzl(((Integer) obj).intValue());
                return;
            case 6:
                zzakgVar.zzh(((Long) obj).longValue());
                return;
            case 7:
                zzakgVar.zzk(((Integer) obj).intValue());
                return;
            case 8:
                zzakgVar.zzb(((Boolean) obj).booleanValue());
                return;
            case 9:
                ((zzamc) obj).zza(zzakgVar);
                return;
            case 10:
                zzakgVar.zzc((zzamc) obj);
                return;
            case 11:
                if (obj instanceof zzajp) {
                    zzakgVar.zzb((zzajp) obj);
                    return;
                } else {
                    zzakgVar.zzb((String) obj);
                    return;
                }
            case Code.UNIMPLEMENTED /* 12 */:
                if (obj instanceof zzajp) {
                    zzakgVar.zzb((zzajp) obj);
                    return;
                } else {
                    byte[] bArr = (byte[]) obj;
                    zzakgVar.zzb(bArr, 0, bArr.length);
                    return;
                }
            case 13:
                zzakgVar.zzn(((Integer) obj).intValue());
                return;
            case 14:
                zzakgVar.zzk(((Integer) obj).intValue());
                return;
            case 15:
                zzakgVar.zzh(((Long) obj).longValue());
                return;
            case 16:
                zzakgVar.zzm(((Integer) obj).intValue());
                return;
            case 17:
                zzakgVar.zzi(((Long) obj).longValue());
                return;
            case ConnectionResult.SERVICE_UPDATING /* 18 */:
                if (obj instanceof zzala) {
                    zzakgVar.zzl(((zzala) obj).zza());
                    return;
                } else {
                    zzakgVar.zzl(((Integer) obj).intValue());
                    return;
                }
            default:
                return;
        }
    }
}
