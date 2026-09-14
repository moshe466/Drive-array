package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdrt;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public class zzdrg {
    private static volatile boolean zzhjg = false;
    private static boolean zzhjh = true;
    private static volatile zzdrg zzhji;
    private static volatile zzdrg zzhjj;
    private static final zzdrg zzhjk = new zzdrg(true);
    private final Map<zza, zzdrt.zzf<?, ?>> zzhjl;

    /* loaded from: classes.dex */
    static final class zza {
        private final int number;
        private final Object object;

        zza(Object obj, int i) {
            this.object = obj;
            this.number = i;
        }

        public final boolean equals(Object obj) {
            if (!(obj instanceof zza)) {
                return false;
            }
            zza zzaVar = (zza) obj;
            return this.object == zzaVar.object && this.number == zzaVar.number;
        }

        public final int hashCode() {
            return (System.identityHashCode(this.object) * 65535) + this.number;
        }
    }

    zzdrg() {
        this.zzhjl = new HashMap();
    }

    private zzdrg(boolean z) {
        this.zzhjl = Collections.emptyMap();
    }

    public static zzdrg zzazh() {
        zzdrg zzdrgVar = zzhji;
        if (zzdrgVar == null) {
            synchronized (zzdrg.class) {
                zzdrgVar = zzhji;
                if (zzdrgVar == null) {
                    zzdrgVar = zzhjk;
                    zzhji = zzdrgVar;
                }
            }
        }
        return zzdrgVar;
    }

    public static zzdrg zzazi() {
        zzdrg zzdrgVar = zzhjj;
        if (zzdrgVar == null) {
            synchronized (zzdrg.class) {
                zzdrgVar = zzhjj;
                if (zzdrgVar == null) {
                    zzdrgVar = zzdrr.a(zzdrg.class);
                    zzhjj = zzdrgVar;
                }
            }
        }
        return zzdrgVar;
    }

    public final <ContainingType extends zzdte> zzdrt.zzf<ContainingType, ?> zza(ContainingType containingtype, int i) {
        return (zzdrt.zzf) this.zzhjl.get(new zza(containingtype, i));
    }
}
