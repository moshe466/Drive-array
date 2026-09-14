package c;

import android.window.OnBackInvokedCallback;
import io.flutter.embedding.android.FlutterActivity;

/* loaded from: classes.dex */
public final /* synthetic */ class s implements OnBackInvokedCallback {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3843a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f3844b;

    public /* synthetic */ s(Object obj, int i) {
        this.f3843a = i;
        this.f3844b = obj;
    }

    public final void onBackInvoked() {
        switch (this.f3843a) {
            case 0:
                ((r) this.f3844b).invoke();
                return;
            case 1:
                ((h.y) this.f3844b).D();
                return;
            case 2:
                ((FlutterActivity) this.f3844b).onBackPressed();
                return;
            default:
                ((Runnable) this.f3844b).run();
                return;
        }
    }
}
