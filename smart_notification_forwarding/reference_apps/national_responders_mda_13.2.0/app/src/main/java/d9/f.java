package d9;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f extends e {
    public static int a(int i10, int i11) {
        return i10 < i11 ? i11 : i10;
    }

    public static long b(long j10, long j11) {
        return j10 < j11 ? j11 : j10;
    }

    public static int c(int i10, int i11) {
        return i10 > i11 ? i11 : i10;
    }

    public static long d(long j10, long j11) {
        return j10 > j11 ? j11 : j10;
    }

    public static a e(int i10, int i11) {
        return a.f8745i.a(i10, i11, -1);
    }

    public static c f(int i10, int i11) {
        return i11 <= Integer.MIN_VALUE ? c.f8753j.a() : new c(i10, i11 - 1);
    }
}
