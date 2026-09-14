package e6;

import android.content.Context;
import android.graphics.Rect;
import android.os.Build;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.WindowManager;

/* loaded from: classes.dex */
class d extends View implements ViewTreeObserver.OnGlobalLayoutListener, View.OnSystemUiVisibilityChangeListener {

    /* renamed from: j, reason: collision with root package name */
    private static final int f9222j;

    /* renamed from: f, reason: collision with root package name */
    private final WindowManager.LayoutParams f9223f;

    /* renamed from: g, reason: collision with root package name */
    private final e f9224g;

    /* renamed from: h, reason: collision with root package name */
    private int f9225h;

    /* renamed from: i, reason: collision with root package name */
    private final Rect f9226i;

    static {
        f9222j = Build.VERSION.SDK_INT <= 25 ? 2006 : 2038;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(Context context, e eVar) {
        super(context);
        this.f9224g = eVar;
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        this.f9223f = layoutParams;
        layoutParams.width = 1;
        layoutParams.height = -1;
        layoutParams.type = f9222j;
        layoutParams.flags = 56;
        layoutParams.format = -3;
        this.f9226i = new Rect();
        this.f9225h = -1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public WindowManager.LayoutParams a() {
        return this.f9223f;
    }

    @Override // android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        getViewTreeObserver().addOnGlobalLayoutListener(this);
        setOnSystemUiVisibilityChangeListener(this);
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        if (Build.VERSION.SDK_INT >= 16) {
            getViewTreeObserver().removeOnGlobalLayoutListener(this);
        } else {
            getViewTreeObserver().removeGlobalOnLayoutListener(this);
        }
        setOnSystemUiVisibilityChangeListener(null);
        super.onDetachedFromWindow();
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public void onGlobalLayout() {
        if (this.f9224g != null) {
            getWindowVisibleDisplayFrame(this.f9226i);
            this.f9224g.b(this.f9226i, this.f9225h);
        }
    }

    @Override // android.view.View.OnSystemUiVisibilityChangeListener
    public void onSystemUiVisibilityChange(int i10) {
        this.f9225h = i10;
        if (this.f9224g != null) {
            getWindowVisibleDisplayFrame(this.f9226i);
            this.f9224g.b(this.f9226i, i10);
        }
    }
}
