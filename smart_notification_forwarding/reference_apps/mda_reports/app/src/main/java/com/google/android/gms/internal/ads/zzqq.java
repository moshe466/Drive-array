package com.google.android.gms.internal.ads;

import java.util.Comparator;

/* loaded from: classes.dex */
final class zzqq implements Comparator<zzqw> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzqq(zzqr zzqrVar) {
    }

    @Override // java.util.Comparator
    public final /* synthetic */ int compare(zzqw zzqwVar, zzqw zzqwVar2) {
        zzqw zzqwVar3 = zzqwVar;
        zzqw zzqwVar4 = zzqwVar2;
        int i = zzqwVar3.c - zzqwVar4.c;
        return i != 0 ? i : (int) (zzqwVar3.a - zzqwVar4.a);
    }
}
