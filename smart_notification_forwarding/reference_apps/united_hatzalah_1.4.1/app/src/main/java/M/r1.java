package m;

import android.content.Context;
import android.view.View;
import android.view.Window;
import l.C0503a;

/* loaded from: classes.dex */
public final class r1 implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    public final C0503a f5763a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ s1 f5764b;

    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Object, l.a] */
    public r1(s1 s1Var) {
        this.f5764b = s1Var;
        Context context = s1Var.f5772a.getContext();
        CharSequence charSequence = s1Var.f5779h;
        ?? obj = new Object();
        obj.f5343e = 4096;
        obj.f5345g = 4096;
        obj.f5349l = null;
        obj.f5350m = null;
        obj.f5351n = false;
        obj.f5352o = false;
        obj.p = 16;
        obj.i = context;
        obj.f5339a = charSequence;
        this.f5763a = obj;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        s1 s1Var = this.f5764b;
        Window.Callback callback = s1Var.f5781k;
        if (callback != null && s1Var.f5782l) {
            callback.onMenuItemSelected(0, this.f5763a);
        }
    }
}
