package kotlinx.coroutines.internal;

/* loaded from: classes.dex */
public final class l {
    public static final void a(int i10) {
        if (!(i10 >= 1)) {
            throw new IllegalArgumentException(y8.k.j("Expected positive parallelism level, but got ", Integer.valueOf(i10)).toString());
        }
    }
}
