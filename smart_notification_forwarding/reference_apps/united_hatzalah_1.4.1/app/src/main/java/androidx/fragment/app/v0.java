package androidx.fragment.app;

import android.transition.Transition;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class v0 implements Transition.TransitionListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Object f3523a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ArrayList f3524b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f3525c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ ArrayList f3526d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ x0 f3527e;

    public v0(x0 x0Var, Object obj, ArrayList arrayList, Object obj2, ArrayList arrayList2) {
        this.f3527e = x0Var;
        this.f3523a = obj;
        this.f3524b = arrayList;
        this.f3525c = obj2;
        this.f3526d = arrayList2;
    }

    @Override // android.transition.Transition.TransitionListener
    public final void onTransitionCancel(Transition transition) {
    }

    @Override // android.transition.Transition.TransitionListener
    public final void onTransitionEnd(Transition transition) {
        transition.removeListener(this);
    }

    @Override // android.transition.Transition.TransitionListener
    public final void onTransitionPause(Transition transition) {
    }

    @Override // android.transition.Transition.TransitionListener
    public final void onTransitionResume(Transition transition) {
    }

    @Override // android.transition.Transition.TransitionListener
    public final void onTransitionStart(Transition transition) {
        x0 x0Var = this.f3527e;
        Object obj = this.f3523a;
        if (obj != null) {
            x0Var.u(obj, this.f3524b, null);
        }
        Object obj2 = this.f3525c;
        if (obj2 != null) {
            x0Var.u(obj2, this.f3526d, null);
        }
    }
}
