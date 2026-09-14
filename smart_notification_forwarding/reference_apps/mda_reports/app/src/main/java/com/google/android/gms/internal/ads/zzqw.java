package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;

/* loaded from: classes.dex */
public final class zzqw {
    final long a;
    final String b;
    final int c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzqw(long j, String str, int i) {
        this.a = j;
        this.b = str;
        this.c = i;
    }

    public final boolean equals(@Nullable Object obj) {
        if (obj != null && (obj instanceof zzqw)) {
            zzqw zzqwVar = (zzqw) obj;
            if (zzqwVar.a == this.a && zzqwVar.c == this.c) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return (int) this.a;
    }
}
