package ob;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.CancellationException;
import nb.d1;
import nb.m0;
import p8.f;
import y8.g;
import y8.k;

/* loaded from: classes.dex */
public final class a extends b {
    private volatile a _immediate;

    /* renamed from: g, reason: collision with root package name */
    private final Handler f12642g;

    /* renamed from: h, reason: collision with root package name */
    private final String f12643h;

    /* renamed from: i, reason: collision with root package name */
    private final boolean f12644i;

    /* renamed from: j, reason: collision with root package name */
    private final a f12645j;

    public a(Handler handler, String str) {
        this(handler, str, false);
    }

    public /* synthetic */ a(Handler handler, String str, int i10, g gVar) {
        this(handler, (i10 & 2) != 0 ? null : str);
    }

    private a(Handler handler, String str, boolean z10) {
        super(null);
        this.f12642g = handler;
        this.f12643h = str;
        this.f12644i = z10;
        this._immediate = z10 ? this : null;
        a aVar = this._immediate;
        if (aVar == null) {
            aVar = new a(handler, str, true);
            this._immediate = aVar;
        }
        this.f12645j = aVar;
    }

    private final void e0(f fVar, Runnable runnable) {
        d1.a(fVar, new CancellationException("The task was rejected, the handler underlying the dispatcher '" + this + "' was closed"));
        m0.a().c(fVar, runnable);
    }

    @Override // nb.u
    public boolean a0(f fVar) {
        return (this.f12644i && k.a(Looper.myLooper(), this.f12642g.getLooper())) ? false : true;
    }

    @Override // nb.u
    public void c(f fVar, Runnable runnable) {
        if (this.f12642g.post(runnable)) {
            return;
        }
        e0(fVar, runnable);
    }

    public boolean equals(Object obj) {
        return (obj instanceof a) && ((a) obj).f12642g == this.f12642g;
    }

    @Override // nb.i1
    /* renamed from: f0, reason: merged with bridge method [inline-methods] */
    public a c0() {
        return this.f12645j;
    }

    public int hashCode() {
        return System.identityHashCode(this.f12642g);
    }

    @Override // nb.i1, nb.u
    public String toString() {
        String d02 = d0();
        if (d02 != null) {
            return d02;
        }
        String str = this.f12643h;
        if (str == null) {
            str = this.f12642g.toString();
        }
        return this.f12644i ? k.j(str, ".immediate") : str;
    }
}
