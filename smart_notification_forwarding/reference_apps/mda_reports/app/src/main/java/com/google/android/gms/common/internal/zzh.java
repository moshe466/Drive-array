package com.google.android.gms.common.internal;

import androidx.annotation.NonNull;

/* loaded from: classes.dex */
public final class zzh {

    @NonNull
    private final String mPackageName;
    private final int zzdt = 129;

    @NonNull
    private final String zzej;
    private final boolean zzek;

    public zzh(@NonNull String str, @NonNull String str2, boolean z, int i) {
        this.mPackageName = str;
        this.zzej = str2;
        this.zzek = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @NonNull
    public final String a() {
        return this.mPackageName;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final int b() {
        return this.zzdt;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @NonNull
    public final String c() {
        return this.zzej;
    }
}
