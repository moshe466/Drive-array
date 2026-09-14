package I2;

import java.util.Random;

/* loaded from: classes.dex */
public abstract class a extends e {
    @Override // I2.e
    public final int a(int i) {
        return b().nextInt(i);
    }

    public abstract Random b();
}
