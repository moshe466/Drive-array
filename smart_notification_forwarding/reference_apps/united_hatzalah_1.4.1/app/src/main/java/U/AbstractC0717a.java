package u;

import kotlin.jvm.internal.j;

/* renamed from: u.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0717a {

    /* renamed from: a, reason: collision with root package name */
    public static final int[] f6499a = new int[0];

    /* renamed from: b, reason: collision with root package name */
    public static final Object[] f6500b = new Object[0];

    public static final int a(int i, int i3, int[] array) {
        j.e(array, "array");
        int i4 = i - 1;
        int i5 = 0;
        while (i5 <= i4) {
            int i6 = (i5 + i4) >>> 1;
            int i7 = array[i6];
            if (i7 < i3) {
                i5 = i6 + 1;
            } else if (i7 > i3) {
                i4 = i6 - 1;
            } else {
                return i6;
            }
        }
        return ~i5;
    }

    public static final int b(long[] array, int i, long j2) {
        j.e(array, "array");
        int i3 = i - 1;
        int i4 = 0;
        while (i4 <= i3) {
            int i5 = (i4 + i3) >>> 1;
            long j3 = array[i5];
            if (j3 < j2) {
                i4 = i5 + 1;
            } else if (j3 > j2) {
                i3 = i5 - 1;
            } else {
                return i5;
            }
        }
        return ~i4;
    }
}
