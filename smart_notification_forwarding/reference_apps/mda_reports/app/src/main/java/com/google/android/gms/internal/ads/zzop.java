package com.google.android.gms.internal.ads;

import androidx.annotation.NonNull;
import java.util.concurrent.ThreadFactory;

/* loaded from: classes.dex */
final class zzop implements ThreadFactory {
    private final /* synthetic */ String zzbgu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzop(String str) {
        this.zzbgu = str;
    }

    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(@NonNull Runnable runnable) {
        return new Thread(runnable, this.zzbgu);
    }
}
