package com.google.android.gms.internal.fido;

import java.util.Comparator;
import org.apache.tika.fork.ForkServer;

/* loaded from: classes.dex */
enum zzcm implements Comparator {
    INSTANCE;

    @Override // java.util.Comparator
    public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
        byte[] bArr = (byte[]) obj;
        byte[] bArr2 = (byte[]) obj2;
        int min = Math.min(bArr.length, bArr2.length);
        for (int i = 0; i < min; i++) {
            int i3 = (bArr[i] & ForkServer.ERROR) - (bArr2[i] & ForkServer.ERROR);
            if (i3 != 0) {
                return i3;
            }
        }
        return bArr.length - bArr2.length;
    }

    @Override // java.lang.Enum
    public final String toString() {
        return "UnsignedBytes.lexicographicalComparator() (pure Java version)";
    }
}
