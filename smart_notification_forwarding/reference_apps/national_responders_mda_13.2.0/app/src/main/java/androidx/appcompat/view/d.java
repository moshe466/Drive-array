package androidx.appcompat.view;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.view.LayoutInflater;

/* loaded from: classes.dex */
public class d extends ContextWrapper {

    /* renamed from: f, reason: collision with root package name */
    private static Configuration f752f;

    /* renamed from: a, reason: collision with root package name */
    private int f753a;

    /* renamed from: b, reason: collision with root package name */
    private Resources.Theme f754b;

    /* renamed from: c, reason: collision with root package name */
    private LayoutInflater f755c;

    /* renamed from: d, reason: collision with root package name */
    private Configuration f756d;

    /* renamed from: e, reason: collision with root package name */
    private Resources f757e;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class a {
        static Context a(d dVar, Configuration configuration) {
            return dVar.createConfigurationContext(configuration);
        }
    }

    public d() {
        super(null);
    }

    public d(Context context, int i10) {
        super(context);
        this.f753a = i10;
    }

    public d(Context context, Resources.Theme theme) {
        super(context);
        this.f754b = theme;
    }

    private Resources b() {
        Resources resources;
        int i10;
        if (this.f757e == null) {
            Configuration configuration = this.f756d;
            if (configuration == null || ((i10 = Build.VERSION.SDK_INT) >= 26 && e(configuration))) {
                resources = super.getResources();
            } else if (i10 >= 17) {
                resources = a.a(this, this.f756d).getResources();
            } else {
                Resources resources2 = super.getResources();
                Configuration configuration2 = new Configuration(resources2.getConfiguration());
                configuration2.updateFrom(this.f756d);
                this.f757e = new Resources(resources2.getAssets(), resources2.getDisplayMetrics(), configuration2);
            }
            this.f757e = resources;
        }
        return this.f757e;
    }

    private void d() {
        boolean z10 = this.f754b == null;
        if (z10) {
            this.f754b = getResources().newTheme();
            Resources.Theme theme = getBaseContext().getTheme();
            if (theme != null) {
                this.f754b.setTo(theme);
            }
        }
        f(this.f754b, this.f753a, z10);
    }

    private static boolean e(Configuration configuration) {
        if (configuration == null) {
            return true;
        }
        if (f752f == null) {
            Configuration configuration2 = new Configuration();
            configuration2.fontScale = 0.0f;
            f752f = configuration2;
        }
        return configuration.equals(f752f);
    }

    public void a(Configuration configuration) {
        if (this.f757e != null) {
            throw new IllegalStateException("getResources() or getAssets() has already been called");
        }
        if (this.f756d != null) {
            throw new IllegalStateException("Override configuration has already been set");
        }
        this.f756d = new Configuration(configuration);
    }

    @Override // android.content.ContextWrapper
    protected void attachBaseContext(Context context) {
        super.attachBaseContext(context);
    }

    public int c() {
        return this.f753a;
    }

    protected void f(Resources.Theme theme, int i10, boolean z10) {
        theme.applyStyle(i10, true);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public AssetManager getAssets() {
        return getResources().getAssets();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        return b();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Object getSystemService(String str) {
        if (!"layout_inflater".equals(str)) {
            return getBaseContext().getSystemService(str);
        }
        if (this.f755c == null) {
            this.f755c = LayoutInflater.from(getBaseContext()).cloneInContext(this);
        }
        return this.f755c;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Resources.Theme getTheme() {
        Resources.Theme theme = this.f754b;
        if (theme != null) {
            return theme;
        }
        if (this.f753a == 0) {
            this.f753a = e.i.f8991d;
        }
        d();
        return this.f754b;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void setTheme(int i10) {
        if (this.f753a != i10) {
            this.f753a = i10;
            d();
        }
    }
}
