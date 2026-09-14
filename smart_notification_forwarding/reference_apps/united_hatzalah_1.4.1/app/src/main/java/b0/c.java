package B0;

import F0.C0035g2;
import android.app.Activity;
import android.content.Context;
import androidx.window.extensions.layout.WindowLayoutComponent;
import androidx.window.extensions.layout.WindowLayoutInfo;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.jvm.internal.h;
import kotlin.jvm.internal.s;
import s2.C0684i;
import t2.C0716r;
import w0.C0748d;

/* loaded from: classes.dex */
public final class c implements A0.a {

    /* renamed from: a, reason: collision with root package name */
    public final WindowLayoutComponent f68a;

    /* renamed from: b, reason: collision with root package name */
    public final C0035g2 f69b;

    /* renamed from: c, reason: collision with root package name */
    public final ReentrantLock f70c = new ReentrantLock();

    /* renamed from: d, reason: collision with root package name */
    public final LinkedHashMap f71d = new LinkedHashMap();

    /* renamed from: e, reason: collision with root package name */
    public final LinkedHashMap f72e = new LinkedHashMap();

    /* renamed from: f, reason: collision with root package name */
    public final LinkedHashMap f73f = new LinkedHashMap();

    public c(WindowLayoutComponent windowLayoutComponent, C0035g2 c0035g2) {
        this.f68a = windowLayoutComponent;
        this.f69b = c0035g2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v0, types: [B0.b, kotlin.jvm.internal.h] */
    @Override // A0.a
    public final void a(Context context, i0.c cVar, io.flutter.embedding.android.a aVar) {
        C0684i c0684i;
        LinkedHashMap linkedHashMap = this.f71d;
        ReentrantLock reentrantLock = this.f70c;
        reentrantLock.lock();
        try {
            f fVar = (f) linkedHashMap.get(context);
            LinkedHashMap linkedHashMap2 = this.f72e;
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
                if (context instanceof Activity) {
                    this.f73f.put(fVar2, this.f69b.r(this.f68a, s.a(WindowLayoutInfo.class), (Activity) context, new h(1, fVar2, f.class, "accept", "accept(Landroidx/window/extensions/layout/WindowLayoutInfo;)V", 0)));
                } else {
                    fVar2.accept(new WindowLayoutInfo(C0716r.f6476a));
                    reentrantLock.unlock();
                    return;
                }
            }
            reentrantLock.unlock();
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    @Override // A0.a
    public final void b(io.flutter.embedding.android.a aVar) {
        LinkedHashMap linkedHashMap = this.f71d;
        LinkedHashMap linkedHashMap2 = this.f72e;
        ReentrantLock reentrantLock = this.f70c;
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
                    C0748d c0748d = (C0748d) this.f73f.remove(fVar);
                    if (c0748d != null) {
                        c0748d.f6688a.invoke(c0748d.f6689b, c0748d.f6690c);
                    }
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
