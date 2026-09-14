package C0;

import android.app.Activity;
import android.os.IBinder;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import java.lang.ref.WeakReference;

/* loaded from: classes.dex */
public final class j implements View.OnAttachStateChangeListener {

    /* renamed from: a, reason: collision with root package name */
    public final k f93a;

    /* renamed from: b, reason: collision with root package name */
    public final WeakReference f94b;

    public j(k sidecarCompat, Activity activity) {
        kotlin.jvm.internal.j.e(sidecarCompat, "sidecarCompat");
        this.f93a = sidecarCompat;
        this.f94b = new WeakReference(activity);
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewAttachedToWindow(View view) {
        IBinder iBinder;
        Window window;
        WindowManager.LayoutParams attributes;
        kotlin.jvm.internal.j.e(view, "view");
        view.removeOnAttachStateChangeListener(this);
        Activity activity = (Activity) this.f94b.get();
        if (activity != null && (window = activity.getWindow()) != null && (attributes = window.getAttributes()) != null) {
            iBinder = attributes.token;
        } else {
            iBinder = null;
        }
        if (activity == null || iBinder == null) {
            return;
        }
        this.f93a.c(iBinder, activity);
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(View view) {
        kotlin.jvm.internal.j.e(view, "view");
    }
}
