package r3;

import java.util.Set;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public abstract class a implements e {
    @Override // r3.e
    public <T> T a(Class<T> cls) {
        r4.b<T> c10 = c(cls);
        if (c10 == null) {
            return null;
        }
        return c10.get();
    }

    @Override // r3.e
    public <T> Set<T> b(Class<T> cls) {
        return d(cls).get();
    }
}
