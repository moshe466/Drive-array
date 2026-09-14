package com.google.android.gms.internal.ads;

import androidx.core.view.PointerIconCompat;
import java.util.UUID;

/* loaded from: classes.dex */
public final class zzgi {
    public static final int CHANNEL_OUT_7POINT1_SURROUND;
    public static final UUID zzacb;
    private static final UUID zzacc;
    private static final UUID zzacd;
    private static final UUID zzace;

    static {
        CHANNEL_OUT_7POINT1_SURROUND = zzoq.SDK_INT < 23 ? PointerIconCompat.TYPE_GRAB : 6396;
        zzacb = new UUID(0L, 0L);
        zzacc = new UUID(1186680826959645954L, -5988876978535335093L);
        zzacd = new UUID(-1301668207276963122L, -6645017420763422227L);
        zzace = new UUID(-7348484286925749626L, -6083546864340672619L);
    }

    public static long zzdm(long j) {
        if (j == -9223372036854775807L) {
            return -9223372036854775807L;
        }
        return j / 1000;
    }

    public static long zzdn(long j) {
        if (j == -9223372036854775807L) {
            return -9223372036854775807L;
        }
        return j * 1000;
    }
}
