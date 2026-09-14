package s0;

import android.view.View;
import android.view.ViewGroup;

/* loaded from: classes.dex */
public class l {

    /* renamed from: a, reason: collision with root package name */
    private ViewGroup f13944a;

    /* renamed from: b, reason: collision with root package name */
    private Runnable f13945b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static l b(View view) {
        return (l) view.getTag(j.f13939b);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void c(View view, l lVar) {
        view.setTag(j.f13939b, lVar);
    }

    public void a() {
        Runnable runnable;
        if (b(this.f13944a) != this || (runnable = this.f13945b) == null) {
            return;
        }
        runnable.run();
    }
}
