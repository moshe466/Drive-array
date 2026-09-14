package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import java.util.Arrays;

@TargetApi(21)
/* loaded from: classes.dex */
public final class zzhn {
    private static final zzhn zzahb = new zzhn(new int[]{2}, 2);
    private final int[] zzahc;
    private final int zzahd;

    private zzhn(int[] iArr, int i) {
        this.zzahc = Arrays.copyOf(iArr, iArr.length);
        Arrays.sort(this.zzahc);
        this.zzahd = 2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzhn)) {
            return false;
        }
        zzhn zzhnVar = (zzhn) obj;
        return Arrays.equals(this.zzahc, zzhnVar.zzahc) && this.zzahd == zzhnVar.zzahd;
    }

    public final int hashCode() {
        return this.zzahd + (Arrays.hashCode(this.zzahc) * 31);
    }

    public final String toString() {
        int i = this.zzahd;
        String arrays = Arrays.toString(this.zzahc);
        StringBuilder sb = new StringBuilder(String.valueOf(arrays).length() + 67);
        sb.append("AudioCapabilities[maxChannelCount=");
        sb.append(i);
        sb.append(", supportedEncodings=");
        sb.append(arrays);
        sb.append("]");
        return sb.toString();
    }

    public final boolean zzq(int i) {
        return Arrays.binarySearch(this.zzahc, i) >= 0;
    }
}
