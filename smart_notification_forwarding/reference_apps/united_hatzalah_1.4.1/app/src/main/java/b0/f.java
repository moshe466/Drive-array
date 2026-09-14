package B0;

import android.content.Context;
import androidx.window.extensions.core.util.function.Consumer;
import androidx.window.extensions.layout.WindowLayoutInfo;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.concurrent.locks.ReentrantLock;
import z0.j;

/* loaded from: classes.dex */
public final class f implements I.a, Consumer {

    /* renamed from: a, reason: collision with root package name */
    public final Context f78a;

    /* renamed from: c, reason: collision with root package name */
    public j f80c;

    /* renamed from: b, reason: collision with root package name */
    public final ReentrantLock f79b = new ReentrantLock();

    /* renamed from: d, reason: collision with root package name */
    public final LinkedHashSet f81d = new LinkedHashSet();

    public f(Context context) {
        this.f78a = context;
    }

    @Override // I.a, androidx.window.extensions.core.util.function.Consumer
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public final void accept(WindowLayoutInfo value) {
        kotlin.jvm.internal.j.e(value, "value");
        ReentrantLock reentrantLock = this.f79b;
        reentrantLock.lock();
        try {
            this.f80c = e.b(this.f78a, value);
            Iterator it = this.f81d.iterator();
            while (it.hasNext()) {
                ((I.a) it.next()).accept(this.f80c);
            }
        } finally {
            reentrantLock.unlock();
        }
    }

    public final void b(io.flutter.embedding.android.a aVar) {
        ReentrantLock reentrantLock = this.f79b;
        reentrantLock.lock();
        try {
            j jVar = this.f80c;
            if (jVar != null) {
                aVar.accept(jVar);
            }
            this.f81d.add(aVar);
            reentrantLock.unlock();
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }
}
