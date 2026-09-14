package p3;

import androidx.lifecycle.N;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5974a;

    /* renamed from: b, reason: collision with root package name */
    public final n3.a f5975b;

    public c(int i) {
        this.f5974a = i;
        switch (i) {
            case 1:
                this.f5975b = new f();
                new ConcurrentHashMap();
                new ThreadLocal();
                new InheritableThreadLocal();
                return;
            default:
                this.f5975b = new N(28);
                new ConcurrentHashMap();
                return;
        }
    }
}
