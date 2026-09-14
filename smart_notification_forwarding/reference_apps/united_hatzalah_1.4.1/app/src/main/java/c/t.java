package c;

import android.window.BackEvent;
import android.window.OnBackAnimationCallback;

/* loaded from: classes.dex */
public final class t implements OnBackAnimationCallback {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ q f3845a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ q f3846b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ r f3847c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ r f3848d;

    public t(q qVar, q qVar2, r rVar, r rVar2) {
        this.f3845a = qVar;
        this.f3846b = qVar2;
        this.f3847c = rVar;
        this.f3848d = rVar2;
    }

    public final void onBackCancelled() {
        this.f3848d.invoke();
    }

    public final void onBackInvoked() {
        this.f3847c.invoke();
    }

    public final void onBackProgressed(BackEvent backEvent) {
        kotlin.jvm.internal.j.e(backEvent, "backEvent");
        this.f3846b.invoke(new C0325a(backEvent));
    }

    public final void onBackStarted(BackEvent backEvent) {
        kotlin.jvm.internal.j.e(backEvent, "backEvent");
        this.f3845a.invoke(new C0325a(backEvent));
    }
}
