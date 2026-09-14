package com.google.android.gms.internal.ads;

import android.graphics.Rect;
import java.util.List;

/* loaded from: classes.dex */
public final class zzpt {
    private final long timestamp;
    public final boolean zzbnq;
    private final boolean zzbny;
    public final boolean zzbnz;
    public final Rect zzboa;
    public final Rect zzbob;
    public final Rect zzboc;
    public final boolean zzbod;
    public final Rect zzboe;
    public final boolean zzbof;
    public final Rect zzbog;
    private final float zzboh;
    public final List<Rect> zzboi;
    public final int zzzd;

    public zzpt(long j, boolean z, boolean z2, int i, Rect rect, Rect rect2, Rect rect3, boolean z3, Rect rect4, boolean z4, Rect rect5, float f, boolean z5, List<Rect> list) {
        this.timestamp = j;
        this.zzbny = z;
        this.zzbnz = z2;
        this.zzzd = i;
        this.zzboa = rect;
        this.zzbob = rect2;
        this.zzboc = rect3;
        this.zzbod = z3;
        this.zzboe = rect4;
        this.zzbof = z4;
        this.zzbog = rect5;
        this.zzboh = f;
        this.zzbnq = z5;
        this.zzboi = list;
    }
}
