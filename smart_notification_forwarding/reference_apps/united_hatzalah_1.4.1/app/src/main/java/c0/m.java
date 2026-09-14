package C0;

import F0.C0035g2;
import android.app.Activity;
import android.content.Context;
import android.os.IBinder;
import android.view.Window;
import android.view.WindowManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.locks.ReentrantLock;
import s2.C0684i;
import t2.C0716r;

/* loaded from: classes.dex */
public final class m implements A0.a {

    /* renamed from: c, reason: collision with root package name */
    public static volatile m f103c;

    /* renamed from: d, reason: collision with root package name */
    public static final ReentrantLock f104d = new ReentrantLock();

    /* renamed from: a, reason: collision with root package name */
    public final a f105a;

    /* renamed from: b, reason: collision with root package name */
    public final CopyOnWriteArrayList f106b = new CopyOnWriteArrayList();

    public m(k kVar) {
        this.f105a = kVar;
        if (kVar != null) {
            kVar.d(new C0035g2(this, 1));
        }
    }

    @Override // A0.a
    public final void a(Context context, i0.c cVar, io.flutter.embedding.android.a aVar) {
        Activity activity;
        Object obj;
        WindowManager.LayoutParams attributes;
        C0684i c0684i = null;
        r1 = null;
        IBinder iBinder = null;
        z0.j jVar = null;
        if (context instanceof Activity) {
            activity = (Activity) context;
        } else {
            activity = null;
        }
        C0716r c0716r = C0716r.f6476a;
        if (activity != null) {
            ReentrantLock reentrantLock = f104d;
            reentrantLock.lock();
            try {
                a aVar2 = this.f105a;
                if (aVar2 == null) {
                    aVar.accept(new z0.j(c0716r));
                    return;
                }
                CopyOnWriteArrayList copyOnWriteArrayList = this.f106b;
                boolean z3 = false;
                if (copyOnWriteArrayList == null || !copyOnWriteArrayList.isEmpty()) {
                    Iterator it = copyOnWriteArrayList.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        } else if (((l) it.next()).f100a.equals(activity)) {
                            z3 = true;
                            break;
                        }
                    }
                }
                l lVar = new l(activity, cVar, aVar);
                copyOnWriteArrayList.add(lVar);
                if (!z3) {
                    k kVar = (k) aVar2;
                    Window window = activity.getWindow();
                    if (window != null && (attributes = window.getAttributes()) != null) {
                        iBinder = attributes.token;
                    }
                    if (iBinder != null) {
                        kVar.c(iBinder, activity);
                    } else {
                        activity.getWindow().getDecorView().addOnAttachStateChangeListener(new j(kVar, activity));
                    }
                } else {
                    Iterator it2 = copyOnWriteArrayList.iterator();
                    while (true) {
                        if (it2.hasNext()) {
                            obj = it2.next();
                            if (activity.equals(((l) obj).f100a)) {
                                break;
                            }
                        } else {
                            obj = null;
                            break;
                        }
                    }
                    l lVar2 = (l) obj;
                    if (lVar2 != null) {
                        jVar = lVar2.f102c;
                    }
                    if (jVar != null) {
                        lVar.f102c = jVar;
                        lVar.f101b.accept(jVar);
                    }
                }
                reentrantLock.unlock();
                c0684i = C0684i.f6340a;
            } finally {
                reentrantLock.unlock();
            }
        }
        if (c0684i == null) {
            aVar.accept(new z0.j(c0716r));
        }
    }

    @Override // A0.a
    public final void b(io.flutter.embedding.android.a aVar) {
        synchronized (f104d) {
            try {
                if (this.f105a == null) {
                    return;
                }
                ArrayList arrayList = new ArrayList();
                Iterator it = this.f106b.iterator();
                while (it.hasNext()) {
                    l lVar = (l) it.next();
                    if (lVar.f101b == aVar) {
                        arrayList.add(lVar);
                    }
                }
                this.f106b.removeAll(arrayList);
                int size = arrayList.size();
                int i = 0;
                while (i < size) {
                    Object obj = arrayList.get(i);
                    i++;
                    Activity activity = ((l) obj).f100a;
                    CopyOnWriteArrayList copyOnWriteArrayList = this.f106b;
                    if (copyOnWriteArrayList == null || !copyOnWriteArrayList.isEmpty()) {
                        Iterator it2 = copyOnWriteArrayList.iterator();
                        while (it2.hasNext()) {
                            if (((l) it2.next()).f100a.equals(activity)) {
                                break;
                            }
                        }
                    }
                    a aVar2 = this.f105a;
                    if (aVar2 != null) {
                        ((k) aVar2).b(activity);
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
