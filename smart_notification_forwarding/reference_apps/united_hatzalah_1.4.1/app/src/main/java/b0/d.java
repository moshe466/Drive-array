package B0;

import android.content.Context;
import androidx.window.extensions.layout.WindowLayoutComponent;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.concurrent.locks.ReentrantLock;
import s2.C0684i;

/* loaded from: classes.dex */
public final class d implements A0.a {

    /* renamed from: a, reason: collision with root package name */
    public final WindowLayoutComponent f74a;

    /* renamed from: b, reason: collision with root package name */
    public final ReentrantLock f75b = new ReentrantLock();

    /* renamed from: c, reason: collision with root package name */
    public final LinkedHashMap f76c = new LinkedHashMap();

    /* renamed from: d, reason: collision with root package name */
    public final LinkedHashMap f77d = new LinkedHashMap();

    public d(WindowLayoutComponent windowLayoutComponent) {
        this.f74a = windowLayoutComponent;
    }

    @Override // A0.a
    public final void a(Context context, i0.c cVar, io.flutter.embedding.android.a aVar) {
        C0684i c0684i;
        LinkedHashMap linkedHashMap = this.f76c;
        ReentrantLock reentrantLock = this.f75b;
        reentrantLock.lock();
        try {
            f fVar = (f) linkedHashMap.get(context);
            LinkedHashMap linkedHashMap2 = this.f77d;
            if (fVar != null) {
                fVar.b(aVar);
                linkedHashMap2.put(aVar, context);
                c0684i = C0684i.f6340a;
            } else {
                c0684i = null;
            }
            if (c0684i == null) {
                f fVar2 = new f(context);
                linkedHashMap.put(context, fVar2);
                linkedHashMap2.put(aVar, context);
                fVar2.b(aVar);
                this.f74a.addWindowLayoutInfoListener(context, fVar2);
            }
            reentrantLock.unlock();
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    @Override // A0.a
    public final void b(io.flutter.embedding.android.a aVar) {
        LinkedHashMap linkedHashMap = this.f76c;
        LinkedHashMap linkedHashMap2 = this.f77d;
        ReentrantLock reentrantLock = this.f75b;
        reentrantLock.lock();
        try {
            Context context = (Context) linkedHashMap2.get(aVar);
            if (context == null) {
                return;
            }
            f fVar = (f) linkedHashMap.get(context);
            if (fVar == null) {
                return;
            }
            LinkedHashSet linkedHashSet = fVar.f81d;
            ReentrantLock reentrantLock2 = fVar.f79b;
            reentrantLock2.lock();
            try {
                linkedHashSet.remove(aVar);
                reentrantLock2.unlock();
                linkedHashMap2.remove(aVar);
                if (linkedHashSet.isEmpty()) {
                    linkedHashMap.remove(context);
                    this.f74a.removeWindowLayoutInfoListener(fVar);
                }
            } catch (Throwable th) {
                reentrantLock2.unlock();
                throw th;
            }
        } finally {
            reentrantLock.unlock();
        }
    }
}
