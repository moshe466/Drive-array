package com.google.android.gms.internal.p002firebaseauthapi;

import java.util.Comparator;

/* loaded from: classes.dex */
final class zzajr implements Comparator<zzajp> {
    @Override // java.util.Comparator
    public final /* synthetic */ int compare(zzajp zzajpVar, zzajp zzajpVar2) {
        zzajp zzajpVar3 = zzajpVar;
        zzajp zzajpVar4 = zzajpVar2;
        zzajv zzajvVar = (zzajv) zzajpVar3.iterator();
        zzajv zzajvVar2 = (zzajv) zzajpVar4.iterator();
        while (zzajvVar.hasNext() && zzajvVar2.hasNext()) {
            int compare = Integer.compare(zzajp.zza(zzajvVar.zza()), zzajp.zza(zzajvVar2.zza()));
            if (compare != 0) {
                return compare;
            }
        }
        return Integer.compare(zzajpVar3.zzb(), zzajpVar4.zzb());
    }
}
