package androidx.activity;

import android.annotation.SuppressLint;
import androidx.lifecycle.h;
import androidx.lifecycle.l;
import java.util.ArrayDeque;
import java.util.Iterator;

/* loaded from: classes.dex */
public final class OnBackPressedDispatcher {

    /* renamed from: a, reason: collision with root package name */
    private final Runnable f479a;

    /* renamed from: b, reason: collision with root package name */
    final ArrayDeque<g> f480b = new ArrayDeque<>();

    /* loaded from: classes.dex */
    private class LifecycleOnBackPressedCancellable implements androidx.lifecycle.j, androidx.activity.a {

        /* renamed from: a, reason: collision with root package name */
        private final androidx.lifecycle.h f481a;

        /* renamed from: b, reason: collision with root package name */
        private final g f482b;

        /* renamed from: c, reason: collision with root package name */
        private androidx.activity.a f483c;

        LifecycleOnBackPressedCancellable(androidx.lifecycle.h hVar, g gVar) {
            this.f481a = hVar;
            this.f482b = gVar;
            hVar.a(this);
        }

        @Override // androidx.activity.a
        public void cancel() {
            this.f481a.c(this);
            this.f482b.e(this);
            androidx.activity.a aVar = this.f483c;
            if (aVar != null) {
                aVar.cancel();
                this.f483c = null;
            }
        }

        @Override // androidx.lifecycle.j
        public void d(l lVar, h.b bVar) {
            if (bVar == h.b.ON_START) {
                this.f483c = OnBackPressedDispatcher.this.b(this.f482b);
                return;
            }
            if (bVar != h.b.ON_STOP) {
                if (bVar == h.b.ON_DESTROY) {
                    cancel();
                }
            } else {
                androidx.activity.a aVar = this.f483c;
                if (aVar != null) {
                    aVar.cancel();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a implements androidx.activity.a {

        /* renamed from: a, reason: collision with root package name */
        private final g f485a;

        a(g gVar) {
            this.f485a = gVar;
        }

        @Override // androidx.activity.a
        public void cancel() {
            OnBackPressedDispatcher.this.f480b.remove(this.f485a);
            this.f485a.e(this);
        }
    }

    public OnBackPressedDispatcher(Runnable runnable) {
        this.f479a = runnable;
    }

    @SuppressLint({"LambdaLast"})
    public void a(l lVar, g gVar) {
        androidx.lifecycle.h b10 = lVar.b();
        if (b10.b() == h.c.DESTROYED) {
            return;
        }
        gVar.a(new LifecycleOnBackPressedCancellable(b10, gVar));
    }

    androidx.activity.a b(g gVar) {
        this.f480b.add(gVar);
        a aVar = new a(gVar);
        gVar.a(aVar);
        return aVar;
    }

    public void c() {
        Iterator<g> descendingIterator = this.f480b.descendingIterator();
        while (descendingIterator.hasNext()) {
            g next = descendingIterator.next();
            if (next.c()) {
                next.b();
                return;
            }
        }
        Runnable runnable = this.f479a;
        if (runnable != null) {
            runnable.run();
        }
    }
}
