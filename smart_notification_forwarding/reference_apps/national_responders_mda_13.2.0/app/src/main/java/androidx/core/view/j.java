package androidx.core.view;

import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes.dex */
public class j {

    /* renamed from: a, reason: collision with root package name */
    private final Runnable f2582a;

    /* renamed from: b, reason: collision with root package name */
    private final CopyOnWriteArrayList<l> f2583b = new CopyOnWriteArrayList<>();

    /* renamed from: c, reason: collision with root package name */
    private final Map<l, a> f2584c = new HashMap();

    /* loaded from: classes.dex */
    private static class a {

        /* renamed from: a, reason: collision with root package name */
        final androidx.lifecycle.h f2585a;

        /* renamed from: b, reason: collision with root package name */
        private androidx.lifecycle.j f2586b;

        void a() {
            this.f2585a.c(this.f2586b);
            this.f2586b = null;
        }
    }

    public j(Runnable runnable) {
        this.f2582a = runnable;
    }

    public void a(l lVar) {
        this.f2583b.add(lVar);
        this.f2582a.run();
    }

    public void b(Menu menu, MenuInflater menuInflater) {
        Iterator<l> it = this.f2583b.iterator();
        while (it.hasNext()) {
            it.next().c(menu, menuInflater);
        }
    }

    public void c(Menu menu) {
        Iterator<l> it = this.f2583b.iterator();
        while (it.hasNext()) {
            it.next().b(menu);
        }
    }

    public boolean d(MenuItem menuItem) {
        Iterator<l> it = this.f2583b.iterator();
        while (it.hasNext()) {
            if (it.next().a(menuItem)) {
                return true;
            }
        }
        return false;
    }

    public void e(Menu menu) {
        Iterator<l> it = this.f2583b.iterator();
        while (it.hasNext()) {
            it.next().d(menu);
        }
    }

    public void f(l lVar) {
        this.f2583b.remove(lVar);
        a remove = this.f2584c.remove(lVar);
        if (remove != null) {
            remove.a();
        }
        this.f2582a.run();
    }
}
