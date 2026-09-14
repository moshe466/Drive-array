package J2;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import kotlin.jvm.internal.j;

/* loaded from: classes.dex */
public final class a extends I2.a {
    @Override // I2.a
    public final Random b() {
        ThreadLocalRandom current = ThreadLocalRandom.current();
        j.d(current, "current(...)");
        return current;
    }
}
