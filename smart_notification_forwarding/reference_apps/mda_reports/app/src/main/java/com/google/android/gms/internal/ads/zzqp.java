package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.VisibleForTesting;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
/* loaded from: classes.dex */
public final class zzqp {
    private final float bottom;
    private final float left;
    private final float right;
    private final float top;
    private final int zzbqf;

    @VisibleForTesting
    public zzqp(float f, float f2, float f3, float f4, int i) {
        this.left = f;
        this.top = f2;
        this.right = f + f3;
        this.bottom = f2 + f4;
        this.zzbqf = i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final float a() {
        return this.left;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final float b() {
        return this.top;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final float c() {
        return this.right;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final float d() {
        return this.bottom;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final int e() {
        return this.zzbqf;
    }
}
