package androidx.appcompat.widget;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Resources;
import android.graphics.Rect;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.TextView;

/* loaded from: classes.dex */
class f1 {

    /* renamed from: a, reason: collision with root package name */
    private final Context f1324a;

    /* renamed from: b, reason: collision with root package name */
    private final View f1325b;

    /* renamed from: c, reason: collision with root package name */
    private final TextView f1326c;

    /* renamed from: d, reason: collision with root package name */
    private final WindowManager.LayoutParams f1327d;

    /* renamed from: e, reason: collision with root package name */
    private final Rect f1328e;

    /* renamed from: f, reason: collision with root package name */
    private final int[] f1329f;

    /* renamed from: g, reason: collision with root package name */
    private final int[] f1330g;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f1(Context context) {
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        this.f1327d = layoutParams;
        this.f1328e = new Rect();
        this.f1329f = new int[2];
        this.f1330g = new int[2];
        this.f1324a = context;
        View inflate = LayoutInflater.from(context).inflate(e.g.f8974s, (ViewGroup) null);
        this.f1325b = inflate;
        this.f1326c = (TextView) inflate.findViewById(e.f.f8948s);
        layoutParams.setTitle(f1.class.getSimpleName());
        layoutParams.packageName = context.getPackageName();
        layoutParams.type = 1002;
        layoutParams.width = -2;
        layoutParams.height = -2;
        layoutParams.format = -3;
        layoutParams.windowAnimations = e.i.f8988a;
        layoutParams.flags = 24;
    }

    private void a(View view, int i10, int i11, boolean z10, WindowManager.LayoutParams layoutParams) {
        int height;
        int i12;
        layoutParams.token = view.getApplicationWindowToken();
        int dimensionPixelOffset = this.f1324a.getResources().getDimensionPixelOffset(e.d.f8901m);
        if (view.getWidth() < dimensionPixelOffset) {
            i10 = view.getWidth() / 2;
        }
        if (view.getHeight() >= dimensionPixelOffset) {
            int dimensionPixelOffset2 = this.f1324a.getResources().getDimensionPixelOffset(e.d.f8900l);
            height = i11 + dimensionPixelOffset2;
            i12 = i11 - dimensionPixelOffset2;
        } else {
            height = view.getHeight();
            i12 = 0;
        }
        layoutParams.gravity = 49;
        int dimensionPixelOffset3 = this.f1324a.getResources().getDimensionPixelOffset(z10 ? e.d.f8903o : e.d.f8902n);
        View b10 = b(view);
        if (b10 == null) {
            return;
        }
        b10.getWindowVisibleDisplayFrame(this.f1328e);
        Rect rect = this.f1328e;
        if (rect.left < 0 && rect.top < 0) {
            Resources resources = this.f1324a.getResources();
            int identifier = resources.getIdentifier("status_bar_height", "dimen", "android");
            int dimensionPixelSize = identifier != 0 ? resources.getDimensionPixelSize(identifier) : 0;
            DisplayMetrics displayMetrics = resources.getDisplayMetrics();
            this.f1328e.set(0, dimensionPixelSize, displayMetrics.widthPixels, displayMetrics.heightPixels);
        }
        b10.getLocationOnScreen(this.f1330g);
        view.getLocationOnScreen(this.f1329f);
        int[] iArr = this.f1329f;
        int i13 = iArr[0];
        int[] iArr2 = this.f1330g;
        iArr[0] = i13 - iArr2[0];
        iArr[1] = iArr[1] - iArr2[1];
        layoutParams.x = (iArr[0] + i10) - (b10.getWidth() / 2);
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        this.f1325b.measure(makeMeasureSpec, makeMeasureSpec);
        int measuredHeight = this.f1325b.getMeasuredHeight();
        int[] iArr3 = this.f1329f;
        int i14 = ((iArr3[1] + i12) - dimensionPixelOffset3) - measuredHeight;
        int i15 = iArr3[1] + height + dimensionPixelOffset3;
        if (!z10 ? measuredHeight + i15 <= this.f1328e.height() : i14 < 0) {
            layoutParams.y = i14;
        } else {
            layoutParams.y = i15;
        }
    }

    private static View b(View view) {
        View rootView = view.getRootView();
        ViewGroup.LayoutParams layoutParams = rootView.getLayoutParams();
        if ((layoutParams instanceof WindowManager.LayoutParams) && ((WindowManager.LayoutParams) layoutParams).type == 2) {
            return rootView;
        }
        for (Context context = view.getContext(); context instanceof ContextWrapper; context = ((ContextWrapper) context).getBaseContext()) {
            if (context instanceof Activity) {
                return ((Activity) context).getWindow().getDecorView();
            }
        }
        return rootView;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c() {
        if (d()) {
            ((WindowManager) this.f1324a.getSystemService("window")).removeView(this.f1325b);
        }
    }

    boolean d() {
        return this.f1325b.getParent() != null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e(View view, int i10, int i11, boolean z10, CharSequence charSequence) {
        if (d()) {
            c();
        }
        this.f1326c.setText(charSequence);
        a(view, i10, i11, z10, this.f1327d);
        ((WindowManager) this.f1324a.getSystemService("window")).addView(this.f1325b, this.f1327d);
    }
}
