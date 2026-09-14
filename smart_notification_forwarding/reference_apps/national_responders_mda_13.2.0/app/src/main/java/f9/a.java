package f9;

import y8.k;

/* loaded from: classes.dex */
public final class a extends Exception {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(IllegalAccessException illegalAccessException) {
        super(illegalAccessException);
        k.e(illegalAccessException, "cause");
    }
}
