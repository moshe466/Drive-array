package androidx.fragment.app;

import java.util.ArrayList;
import java.util.Iterator;

/* renamed from: androidx.fragment.app.v, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final /* synthetic */ class RunnableC0286v implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3521a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f3522b;

    public /* synthetic */ RunnableC0286v(Object obj, int i) {
        this.f3521a = i;
        this.f3522b = obj;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f3521a) {
            case 0:
                G g3 = (G) this.f3522b;
                A0 a02 = g3.mViewLifecycleOwner;
                a02.f3258f.b(g3.mSavedViewRegistryState);
                g3.mSavedViewRegistryState = null;
                return;
            case 1:
                s0.a(4, (ArrayList) this.f3522b);
                return;
            default:
                Iterator it = ((AbstractC0272g0) this.f3522b).f3401n.iterator();
                if (!it.hasNext()) {
                    return;
                }
                it.next().getClass();
                throw new ClassCastException();
        }
    }
}
