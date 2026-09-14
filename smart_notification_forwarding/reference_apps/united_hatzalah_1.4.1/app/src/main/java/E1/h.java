package E1;

import F0.C0035g2;
import android.os.Bundle;
import com.google.android.gms.tasks.TaskCompletionSource;

/* loaded from: classes.dex */
public abstract class h extends F1.d implements F1.i {

    /* renamed from: a, reason: collision with root package name */
    public final C0035g2 f140a;

    /* renamed from: b, reason: collision with root package name */
    public final TaskCompletionSource f141b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ k f142c;

    public h(k kVar, C0035g2 c0035g2, TaskCompletionSource taskCompletionSource) {
        this.f142c = kVar;
        attachInterface(this, "com.google.android.play.core.appupdate.protocol.IAppUpdateServiceCallback");
        this.f140a = c0035g2;
        this.f141b = taskCompletionSource;
    }

    @Override // F1.i
    public void f(Bundle bundle) {
        this.f142c.f147a.c(this.f141b);
        this.f140a.y("onRequestInfo", new Object[0]);
    }

    @Override // F1.i
    public void g(Bundle bundle) {
        this.f142c.f147a.c(this.f141b);
        this.f140a.y("onCompleteUpdate", new Object[0]);
    }
}
