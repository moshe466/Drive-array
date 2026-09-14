package com.google.android.gms.internal.ads;

import java.util.ArrayDeque;
import java.util.Arrays;

/* loaded from: classes.dex */
public final class zzdtv {
    private final ArrayDeque<zzdqk> zzhqa;

    private zzdtv() {
        this.zzhqa = new ArrayDeque<>();
    }

    public /* synthetic */ zzdtv(zzdtw zzdtwVar) {
        this();
    }

    public static /* synthetic */ zzdqk a(zzdtv zzdtvVar, zzdqk zzdqkVar, zzdqk zzdqkVar2) {
        return zzdtvVar.zzc(zzdqkVar, zzdqkVar2);
    }

    private final void zzbh(zzdqk zzdqkVar) {
        zzdtw zzdtwVar;
        zzdqk zzdqkVar2;
        while (!zzdqkVar.b()) {
            if (!(zzdqkVar instanceof zzdtt)) {
                String valueOf = String.valueOf(zzdqkVar.getClass());
                StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 49);
                sb.append("Has a new type of ByteString been created? Found ");
                sb.append(valueOf);
                throw new IllegalArgumentException(sb.toString());
            }
            zzdtt zzdttVar = (zzdtt) zzdqkVar;
            zzdqkVar2 = zzdttVar.zzhpw;
            zzbh(zzdqkVar2);
            zzdqkVar = zzdttVar.zzhpx;
        }
        int zzgu = zzgu(zzdqkVar.size());
        int i = zzdtt.a[zzgu + 1];
        if (this.zzhqa.isEmpty() || this.zzhqa.peek().size() >= i) {
            this.zzhqa.push(zzdqkVar);
            return;
        }
        int i2 = zzdtt.a[zzgu];
        zzdqk pop = this.zzhqa.pop();
        while (true) {
            zzdtwVar = null;
            if (this.zzhqa.isEmpty() || this.zzhqa.peek().size() >= i2) {
                break;
            } else {
                pop = new zzdtt(this.zzhqa.pop(), pop, zzdtwVar);
            }
        }
        zzdtt zzdttVar2 = new zzdtt(pop, zzdqkVar, zzdtwVar);
        while (!this.zzhqa.isEmpty()) {
            if (this.zzhqa.peek().size() >= zzdtt.a[zzgu(zzdttVar2.size()) + 1]) {
                break;
            } else {
                zzdttVar2 = new zzdtt(this.zzhqa.pop(), zzdttVar2, zzdtwVar);
            }
        }
        this.zzhqa.push(zzdttVar2);
    }

    public final zzdqk zzc(zzdqk zzdqkVar, zzdqk zzdqkVar2) {
        zzbh(zzdqkVar);
        zzbh(zzdqkVar2);
        zzdqk pop = this.zzhqa.pop();
        while (!this.zzhqa.isEmpty()) {
            pop = new zzdtt(this.zzhqa.pop(), pop, null);
        }
        return pop;
    }

    private static int zzgu(int i) {
        int binarySearch = Arrays.binarySearch(zzdtt.a, i);
        return binarySearch < 0 ? (-(binarySearch + 1)) - 1 : binarySearch;
    }
}
