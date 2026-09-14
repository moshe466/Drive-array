package V;

import java.util.concurrent.ThreadPoolExecutor;

/* loaded from: classes.dex */
public final class m extends p3.h {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ p3.h f2406c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ ThreadPoolExecutor f2407d;

    public m(p3.h hVar, ThreadPoolExecutor threadPoolExecutor) {
        this.f2406c = hVar;
        this.f2407d = threadPoolExecutor;
    }

    @Override // p3.h
    public final void x(Throwable th) {
        ThreadPoolExecutor threadPoolExecutor = this.f2407d;
        try {
            this.f2406c.x(th);
        } finally {
            threadPoolExecutor.shutdown();
        }
    }

    @Override // p3.h
    public final void y(K1.m mVar) {
        ThreadPoolExecutor threadPoolExecutor = this.f2407d;
        try {
            this.f2406c.y(mVar);
        } finally {
            threadPoolExecutor.shutdown();
        }
    }
}
