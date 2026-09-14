package w;

import h.AbstractActivityC0441k;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes.dex */
public final class v implements Iterable {

    /* renamed from: a, reason: collision with root package name */
    public final ArrayList f6679a = new ArrayList();

    /* renamed from: b, reason: collision with root package name */
    public final AbstractActivityC0441k f6680b;

    public v(AbstractActivityC0441k abstractActivityC0441k) {
        this.f6680b = abstractActivityC0441k;
    }

    @Override // java.lang.Iterable
    public final Iterator iterator() {
        return this.f6679a.iterator();
    }
}
