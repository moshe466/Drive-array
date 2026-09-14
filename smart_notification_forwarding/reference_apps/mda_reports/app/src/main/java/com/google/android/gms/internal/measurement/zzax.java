package com.google.android.gms.internal.measurement;

import android.util.Log;
import android.util.Pair;
import com.google.android.gms.internal.measurement.zzx;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzax extends zzx.zza {
    private final /* synthetic */ com.google.android.gms.measurement.internal.zzgz zzc;
    private final /* synthetic */ zzx zzd;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzax(zzx zzxVar, com.google.android.gms.measurement.internal.zzgz zzgzVar) {
        super(zzxVar);
        this.zzd = zzxVar;
        this.zzc = zzgzVar;
    }

    @Override // com.google.android.gms.internal.measurement.zzx.zza
    final void zza() {
        List list;
        Pair pair;
        zzm zzmVar;
        List list2;
        String str;
        List list3;
        List list4;
        int i = 0;
        while (true) {
            list = this.zzd.zzf;
            if (i >= list.size()) {
                pair = null;
                break;
            }
            com.google.android.gms.measurement.internal.zzgz zzgzVar = this.zzc;
            list3 = this.zzd.zzf;
            if (zzgzVar.equals(((Pair) list3.get(i)).first)) {
                list4 = this.zzd.zzf;
                pair = (Pair) list4.get(i);
                break;
            }
            i++;
        }
        if (pair == null) {
            str = this.zzd.zzc;
            Log.w(str, "OnEventListener had not been registered.");
        } else {
            zzmVar = this.zzd.zzr;
            zzmVar.unregisterOnMeasurementEventListener((zzs) pair.second);
            list2 = this.zzd.zzf;
            list2.remove(pair);
        }
    }
}
