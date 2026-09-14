package k;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.view.LayoutInflater;
import com.uh.sf.R;

/* renamed from: k.e, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0461e extends ContextWrapper {

    /* renamed from: f, reason: collision with root package name */
    public static Configuration f5102f;

    /* renamed from: a, reason: collision with root package name */
    public int f5103a;

    /* renamed from: b, reason: collision with root package name */
    public Resources.Theme f5104b;

    /* renamed from: c, reason: collision with root package name */
    public LayoutInflater f5105c;

    /* renamed from: d, reason: collision with root package name */
    public Configuration f5106d;

    /* renamed from: e, reason: collision with root package name */
    public Resources f5107e;

    public C0461e(Context context, int i) {
        super(context);
        this.f5103a = i;
    }

    public final void a(Configuration configuration) {
        if (this.f5107e == null) {
            if (this.f5106d == null) {
                this.f5106d = new Configuration(configuration);
                return;
            }
            throw new IllegalStateException("Override configuration has already been set");
        }
        throw new IllegalStateException("getResources() or getAssets() has already been called");
    }

    @Override // android.content.ContextWrapper
    public final void attachBaseContext(Context context) {
        super.attachBaseContext(context);
    }

    public final void b() {
        if (this.f5104b == null) {
            this.f5104b = getResources().newTheme();
            Resources.Theme theme = getBaseContext().getTheme();
            if (theme != null) {
                this.f5104b.setTo(theme);
            }
        }
        this.f5104b.applyStyle(this.f5103a, true);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public final AssetManager getAssets() {
        return getResources().getAssets();
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0022, code lost:
    
        if (r0.equals(k.C0461e.f5102f) != false) goto L15;
     */
    @Override // android.content.ContextWrapper, android.content.Context
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final android.content.res.Resources getResources() {
        /*
            r3 = this;
            android.content.res.Resources r0 = r3.f5107e
            if (r0 != 0) goto L38
            android.content.res.Configuration r0 = r3.f5106d
            if (r0 == 0) goto L32
            int r1 = android.os.Build.VERSION.SDK_INT
            r2 = 26
            if (r1 < r2) goto L25
            android.content.res.Configuration r1 = k.C0461e.f5102f
            if (r1 != 0) goto L1c
            android.content.res.Configuration r1 = new android.content.res.Configuration
            r1.<init>()
            r2 = 0
            r1.fontScale = r2
            k.C0461e.f5102f = r1
        L1c:
            android.content.res.Configuration r1 = k.C0461e.f5102f
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L25
            goto L32
        L25:
            android.content.res.Configuration r0 = r3.f5106d
            android.content.Context r0 = k.AbstractC0460d.a(r3, r0)
            android.content.res.Resources r0 = r0.getResources()
            r3.f5107e = r0
            goto L38
        L32:
            android.content.res.Resources r0 = super.getResources()
            r3.f5107e = r0
        L38:
            android.content.res.Resources r0 = r3.f5107e
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: k.C0461e.getResources():android.content.res.Resources");
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public final Object getSystemService(String str) {
        if ("layout_inflater".equals(str)) {
            if (this.f5105c == null) {
                this.f5105c = LayoutInflater.from(getBaseContext()).cloneInContext(this);
            }
            return this.f5105c;
        }
        return getBaseContext().getSystemService(str);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public final Resources.Theme getTheme() {
        Resources.Theme theme = this.f5104b;
        if (theme != null) {
            return theme;
        }
        if (this.f5103a == 0) {
            this.f5103a = R.style.Theme_AppCompat_Light;
        }
        b();
        return this.f5104b;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public final void setTheme(int i) {
        if (this.f5103a != i) {
            this.f5103a = i;
            b();
        }
    }
}
