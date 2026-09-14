package com.google.android.gms.internal.ads;

import java.util.Comparator;

/* loaded from: classes.dex */
final class zzdqm implements Comparator<zzdqk> {
    @Override // java.util.Comparator
    public final /* synthetic */ int compare(zzdqk zzdqkVar, zzdqk zzdqkVar2) {
        int zzb;
        int zzb2;
        zzdqk zzdqkVar3 = zzdqkVar;
        zzdqk zzdqkVar4 = zzdqkVar2;
        zzdqp zzdqpVar = (zzdqp) zzdqkVar3.iterator();
        zzdqp zzdqpVar2 = (zzdqp) zzdqkVar4.iterator();
        while (zzdqpVar.hasNext() && zzdqpVar2.hasNext()) {
            zzb = zzdqk.zzb(zzdqpVar.nextByte());
            zzb2 = zzdqk.zzb(zzdqpVar2.nextByte());
            int compare = Integer.compare(zzb, zzb2);
            if (compare != 0) {
                return compare;
            }
        }
        return Integer.compare(zzdqkVar3.size(), zzdqkVar4.size());
    }
}
