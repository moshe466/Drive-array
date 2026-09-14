package I2;

import java.util.Random;
import kotlin.jvm.internal.j;

/* loaded from: classes.dex */
public final class c extends a {

    /* renamed from: c, reason: collision with root package name */
    public final b f932c = new b(0);

    @Override // I2.a
    public final Random b() {
        Object obj = this.f932c.get();
        j.d(obj, "get(...)");
        return (Random) obj;
    }
}
