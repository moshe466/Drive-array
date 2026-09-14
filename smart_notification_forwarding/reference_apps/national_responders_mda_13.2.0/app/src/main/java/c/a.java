package c;

import android.content.Context;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    private final Set<b> f4344a = new CopyOnWriteArraySet();

    /* renamed from: b, reason: collision with root package name */
    private volatile Context f4345b;

    public void a(b bVar) {
        if (this.f4345b != null) {
            bVar.a(this.f4345b);
        }
        this.f4344a.add(bVar);
    }

    public void b() {
        this.f4345b = null;
    }

    public void c(Context context) {
        this.f4345b = context;
        Iterator<b> it = this.f4344a.iterator();
        while (it.hasNext()) {
            it.next().a(context);
        }
    }
}
