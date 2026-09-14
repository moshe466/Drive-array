package c9;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import y8.k;

/* loaded from: classes.dex */
public final class a extends b9.a {
    @Override // b9.a
    public Random c() {
        ThreadLocalRandom current = ThreadLocalRandom.current();
        k.d(current, "current()");
        return current;
    }
}
