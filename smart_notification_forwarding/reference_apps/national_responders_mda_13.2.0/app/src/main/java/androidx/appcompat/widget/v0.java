package androidx.appcompat.widget;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.os.Build;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class v0 extends ContextWrapper {

    /* renamed from: c, reason: collision with root package name */
    private static final Object f1529c = new Object();

    /* renamed from: d, reason: collision with root package name */
    private static ArrayList<WeakReference<v0>> f1530d;

    /* renamed from: a, reason: collision with root package name */
    private final Resources f1531a;

    /* renamed from: b, reason: collision with root package name */
    private final Resources.Theme f1532b;

    private v0(Context context) {
        super(context);
        if (!g1.c()) {
            this.f1531a = new x0(this, context.getResources());
            this.f1532b = null;
            return;
        }
        g1 g1Var = new g1(this, context.getResources());
        this.f1531a = g1Var;
        Resources.Theme newTheme = g1Var.newTheme();
        this.f1532b = newTheme;
        newTheme.setTo(context.getTheme());
    }

    private static boolean a(Context context) {
        if ((context instanceof v0) || (context.getResources() instanceof x0) || (context.getResources() instanceof g1)) {
            return false;
        }
        return Build.VERSION.SDK_INT < 21 || g1.c();
    }

    public static Context b(Context context) {
        if (!a(context)) {
            return context;
        }
        synchronized (f1529c) {
            ArrayList<WeakReference<v0>> arrayList = f1530d;
            if (arrayList == null) {
                f1530d = new ArrayList<>();
            } else {
                for (int size = arrayList.size() - 1; size >= 0; size--) {
                    WeakReference<v0> weakReference = f1530d.get(size);
                    if (weakReference == null || weakReference.get() == null) {
                        f1530d.remove(size);
                    }
                }
                for (int size2 = f1530d.size() - 1; size2 >= 0; size2--) {
                    WeakReference<v0> weakReference2 = f1530d.get(size2);
                    v0 v0Var = weakReference2 != null ? weakReference2.get() : null;
                    if (v0Var != null && v0Var.getBaseContext() == context) {
                        return v0Var;
                    }
                }
            }
            v0 v0Var2 = new v0(context);
            f1530d.add(new WeakReference<>(v0Var2));
            return v0Var2;
        }
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public AssetManager getAssets() {
        return this.f1531a.getAssets();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        return this.f1531a;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Resources.Theme getTheme() {
        Resources.Theme theme = this.f1532b;
        return theme == null ? super.getTheme() : theme;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void setTheme(int i10) {
        Resources.Theme theme = this.f1532b;
        if (theme == null) {
            super.setTheme(i10);
        } else {
            theme.applyStyle(i10, true);
        }
    }
}
