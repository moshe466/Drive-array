package e6;

import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.util.DisplayMetrics;
import android.util.Property;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import android.view.animation.OvershootInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import java.lang.ref.WeakReference;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f extends FrameLayout implements ViewTreeObserver.OnPreDrawListener {

    /* renamed from: v, reason: collision with root package name */
    private static final int f9227v = ViewConfiguration.getLongPressTimeout();

    /* renamed from: w, reason: collision with root package name */
    private static final int f9228w;

    /* renamed from: f, reason: collision with root package name */
    private final WindowManager f9229f;

    /* renamed from: g, reason: collision with root package name */
    private final WindowManager.LayoutParams f9230g;

    /* renamed from: h, reason: collision with root package name */
    private final DisplayMetrics f9231h;

    /* renamed from: i, reason: collision with root package name */
    private final ViewGroup f9232i;

    /* renamed from: j, reason: collision with root package name */
    private final FrameLayout f9233j;

    /* renamed from: k, reason: collision with root package name */
    private final ImageView f9234k;

    /* renamed from: l, reason: collision with root package name */
    private final ImageView f9235l;

    /* renamed from: m, reason: collision with root package name */
    private int f9236m;

    /* renamed from: n, reason: collision with root package name */
    private int f9237n;

    /* renamed from: o, reason: collision with root package name */
    private float f9238o;

    /* renamed from: p, reason: collision with root package name */
    private final FrameLayout f9239p;

    /* renamed from: q, reason: collision with root package name */
    private ObjectAnimator f9240q;

    /* renamed from: r, reason: collision with root package name */
    private ObjectAnimator f9241r;

    /* renamed from: s, reason: collision with root package name */
    private final a f9242s;

    /* renamed from: t, reason: collision with root package name */
    private g f9243t;

    /* renamed from: u, reason: collision with root package name */
    private boolean f9244u;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class a extends Handler {

        /* renamed from: a, reason: collision with root package name */
        private long f9245a;

        /* renamed from: b, reason: collision with root package name */
        private float f9246b;

        /* renamed from: c, reason: collision with root package name */
        private float f9247c;

        /* renamed from: e, reason: collision with root package name */
        private float f9249e;

        /* renamed from: f, reason: collision with root package name */
        private float f9250f;

        /* renamed from: g, reason: collision with root package name */
        private float f9251g;

        /* renamed from: h, reason: collision with root package name */
        private float f9252h;

        /* renamed from: j, reason: collision with root package name */
        private float f9254j;

        /* renamed from: l, reason: collision with root package name */
        private final WeakReference<f> f9256l;

        /* renamed from: d, reason: collision with root package name */
        private int f9248d = 0;

        /* renamed from: i, reason: collision with root package name */
        private final Rect f9253i = new Rect();

        /* renamed from: k, reason: collision with root package name */
        private final OvershootInterpolator f9255k = new OvershootInterpolator(1.0f);

        a(f fVar) {
            this.f9256l = new WeakReference<>(fVar);
        }

        private static void c(ViewGroup viewGroup) {
            viewGroup.setClipChildren(true);
            viewGroup.invalidate();
            viewGroup.setClipChildren(false);
        }

        private static Message e(int i10, int i11) {
            Message obtain = Message.obtain();
            obtain.what = i10;
            obtain.arg1 = i11;
            return obtain;
        }

        boolean d(int i10) {
            return this.f9248d == i10;
        }

        void f() {
            f fVar = this.f9256l.get();
            if (fVar == null) {
                return;
            }
            float f10 = fVar.f9231h.density;
            float measuredHeight = fVar.f9239p.getMeasuredHeight();
            float f11 = 22.0f * f10;
            int measuredHeight2 = fVar.f9233j.getMeasuredHeight();
            this.f9253i.set((int) (-f11), (int) (((measuredHeight2 - measuredHeight) / 2.0f) - (f10 * (-4.0f))), (int) f11, measuredHeight2);
            this.f9254j = measuredHeight * 0.2f;
        }

        void g(int i10) {
            sendMessage(e(i10, 1));
        }

        void h(int i10, long j10) {
            sendMessageAtTime(e(i10, 1), SystemClock.uptimeMillis() + j10);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            f fVar = this.f9256l.get();
            if (fVar == null) {
                removeMessages(1);
                removeMessages(2);
                removeMessages(3);
                return;
            }
            if (fVar.n()) {
                int i10 = message.what;
                int i11 = message.arg1;
                FrameLayout frameLayout = fVar.f9239p;
                FrameLayout frameLayout2 = fVar.f9233j;
                g gVar = fVar.f9243t;
                float f10 = fVar.f9231h.widthPixels;
                float f11 = fVar.f9230g.x;
                if (i11 == 1) {
                    this.f9245a = SystemClock.uptimeMillis();
                    this.f9246b = frameLayout.getAlpha();
                    this.f9247c = frameLayout2.getTranslationY();
                    this.f9248d = i10;
                    if (gVar != null) {
                        gVar.a(i10);
                    }
                }
                float uptimeMillis = (float) (SystemClock.uptimeMillis() - this.f9245a);
                if (i10 == 1) {
                    if (frameLayout.getAlpha() < 1.0f) {
                        frameLayout.setAlpha(Math.min(this.f9246b + Math.min(uptimeMillis / 200.0f, 1.0f), 1.0f));
                    }
                    if (uptimeMillis >= 200.0f) {
                        float f12 = fVar.f9231h.heightPixels;
                        float f13 = this.f9249e;
                        float f14 = this.f9251g;
                        float width = f11 + (((f13 + f14) / (f10 + f14)) * this.f9253i.width()) + this.f9253i.left;
                        float f15 = this.f9250f;
                        float f16 = this.f9252h;
                        float min = this.f9253i.bottom - ((((this.f9254j * Math.min(((f15 + f16) * 2.0f) / (f12 + f16), 1.0f)) + this.f9253i.height()) - this.f9254j) * this.f9255k.getInterpolation(Math.min((uptimeMillis - 200.0f) / 400.0f, 1.0f)));
                        frameLayout2.setTranslationX(width);
                        frameLayout2.setTranslationY(min);
                        if (Build.VERSION.SDK_INT <= 17) {
                            c(fVar.f9232i);
                            c(fVar.f9233j);
                        }
                    }
                } else {
                    if (i10 != 2) {
                        if (i10 == 3) {
                            frameLayout.setAlpha(0.0f);
                            frameLayout2.setTranslationY(this.f9253i.bottom);
                            this.f9248d = 0;
                            if (gVar != null) {
                                gVar.d(3);
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    float f17 = uptimeMillis / 200.0f;
                    float min2 = Math.min(f17, 1.0f);
                    frameLayout.setAlpha(Math.max(this.f9246b - min2, 0.0f));
                    float min3 = Math.min(f17, 1.0f);
                    if (min2 >= 1.0f && min3 >= 1.0f) {
                        frameLayout2.setTranslationY(this.f9253i.bottom);
                        this.f9248d = 0;
                        if (gVar != null) {
                            gVar.d(2);
                            return;
                        }
                        return;
                    }
                    frameLayout2.setTranslationY(this.f9247c + (this.f9253i.height() * min3));
                }
                sendMessageAtTime(e(i10, 2), SystemClock.uptimeMillis() + 10);
            }
        }

        void i(float f10, float f11) {
            this.f9249e = f10;
            this.f9250f = f11;
        }
    }

    static {
        f9228w = Build.VERSION.SDK_INT <= 25 ? 2007 : 2038;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(Context context) {
        super(context);
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        this.f9229f = windowManager;
        DisplayMetrics displayMetrics = new DisplayMetrics();
        this.f9231h = displayMetrics;
        windowManager.getDefaultDisplay().getMetrics(displayMetrics);
        this.f9242s = new a(this);
        this.f9244u = true;
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        this.f9230g = layoutParams;
        layoutParams.width = -1;
        layoutParams.height = -1;
        layoutParams.type = f9228w;
        layoutParams.flags = 56;
        layoutParams.format = -3;
        layoutParams.gravity = 83;
        FrameLayout frameLayout = new FrameLayout(context);
        this.f9232i = frameLayout;
        frameLayout.setClipChildren(false);
        FrameLayout frameLayout2 = new FrameLayout(context);
        this.f9233j = frameLayout2;
        frameLayout2.setClipChildren(false);
        ImageView imageView = new ImageView(context);
        this.f9234k = imageView;
        ImageView imageView2 = new ImageView(context);
        this.f9235l = imageView2;
        FrameLayout frameLayout3 = new FrameLayout(context);
        this.f9239p = frameLayout3;
        frameLayout3.setAlpha(0.0f);
        GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{0, 1342177280});
        if (Build.VERSION.SDK_INT < 16) {
            frameLayout3.setBackgroundDrawable(gradientDrawable);
        } else {
            frameLayout3.setBackground(gradientDrawable);
        }
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, (int) (displayMetrics.density * 164.0f));
        layoutParams2.gravity = 80;
        frameLayout.addView(frameLayout3, layoutParams2);
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams3.gravity = 17;
        frameLayout2.addView(imageView2, layoutParams3);
        FrameLayout.LayoutParams layoutParams4 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams4.gravity = 17;
        frameLayout2.addView(imageView, layoutParams4);
        FrameLayout.LayoutParams layoutParams5 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams5.gravity = 81;
        frameLayout.addView(frameLayout2, layoutParams5);
        addView(frameLayout);
        getViewTreeObserver().addOnPreDrawListener(this);
    }

    private void g() {
        ObjectAnimator objectAnimator = this.f9240q;
        if (objectAnimator != null && objectAnimator.isStarted()) {
            this.f9240q.cancel();
        }
        ObjectAnimator objectAnimator2 = this.f9241r;
        if (objectAnimator2 == null || !objectAnimator2.isStarted()) {
            return;
        }
        this.f9241r.cancel();
    }

    private boolean m() {
        return (this.f9236m == 0 || this.f9237n == 0) ? false : true;
    }

    private void s(boolean z10) {
        g();
        this.f9235l.setScaleX(z10 ? this.f9238o : 1.0f);
        this.f9235l.setScaleY(z10 ? this.f9238o : 1.0f);
    }

    private void w() {
        this.f9229f.getDefaultDisplay().getMetrics(this.f9231h);
        this.f9230g.x = (this.f9231h.widthPixels - getWidth()) / 2;
        this.f9230g.y = 0;
        this.f9243t.c();
        this.f9242s.f();
        this.f9229f.updateViewLayout(this, this.f9230g);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void h() {
        this.f9242s.removeMessages(1);
        this.f9242s.removeMessages(2);
        this.f9242s.g(3);
        s(false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float i() {
        float paddingLeft = (m() ? this.f9235l : this.f9234k).getPaddingLeft();
        return this.f9233j.getX() + paddingLeft + (((r0.getWidth() - paddingLeft) - r0.getPaddingRight()) / 2.0f);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float j() {
        ImageView imageView = m() ? this.f9235l : this.f9234k;
        float height = imageView.getHeight();
        float paddingBottom = imageView.getPaddingBottom();
        return ((this.f9232i.getHeight() - this.f9233j.getY()) - height) + paddingBottom + (((height - imageView.getPaddingTop()) - paddingBottom) / 2.0f);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void k(Rect rect) {
        ImageView imageView = m() ? this.f9235l : this.f9234k;
        float paddingLeft = imageView.getPaddingLeft();
        float paddingTop = imageView.getPaddingTop();
        float width = (imageView.getWidth() - paddingLeft) - imageView.getPaddingRight();
        float height = (imageView.getHeight() - paddingTop) - imageView.getPaddingBottom();
        float x10 = this.f9233j.getX() + paddingLeft;
        float height2 = ((this.f9232i.getHeight() - this.f9233j.getY()) - paddingTop) - height;
        int i10 = (int) (x10 - (this.f9231h.density * 30.0f));
        int i11 = -this.f9232i.getHeight();
        float f10 = x10 + width;
        float f11 = this.f9231h.density;
        rect.set(i10, i11, (int) (f10 + (30.0f * f11)), (int) (height2 + height + (f11 * 4.0f)));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public WindowManager.LayoutParams l() {
        return this.f9230g;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean n() {
        return this.f9244u;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void o(MotionEvent motionEvent, float f10, float f11) {
        int action = motionEvent.getAction();
        if (action == 0) {
            this.f9242s.i(f10, f11);
            this.f9242s.removeMessages(2);
            this.f9242s.h(1, f9227v);
        } else {
            if (action == 2) {
                this.f9242s.i(f10, f11);
                if (this.f9242s.d(1)) {
                    return;
                }
                this.f9242s.removeMessages(1);
                this.f9242s.g(1);
                return;
            }
            if (action == 1 || action == 3) {
                this.f9242s.removeMessages(1);
                this.f9242s.g(2);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f9243t.c();
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        w();
    }

    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public boolean onPreDraw() {
        getViewTreeObserver().removeOnPreDrawListener(this);
        this.f9233j.setTranslationY(r0.getMeasuredHeight());
        return true;
    }

    @Override // android.view.View
    protected void onSizeChanged(int i10, int i11, int i12, int i13) {
        super.onSizeChanged(i10, i11, i12, i13);
        w();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void p(int i10) {
        this.f9235l.setImageResource(i10);
        Drawable drawable = this.f9235l.getDrawable();
        if (drawable != null) {
            this.f9236m = drawable.getIntrinsicWidth();
            this.f9237n = drawable.getIntrinsicHeight();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void q(int i10) {
        this.f9234k.setImageResource(i10);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void r(boolean z10) {
        if (m()) {
            g();
            (z10 ? this.f9240q : this.f9241r).start();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void t(boolean z10) {
        if (this.f9244u == z10) {
            return;
        }
        this.f9244u = z10;
        if (z10) {
            return;
        }
        h();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void u(g gVar) {
        this.f9243t = gVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void v(float f10, float f11, float f12) {
        if (m()) {
            this.f9242s.f9251g = f10;
            this.f9242s.f9252h = f11;
            float max = Math.max(((f10 / 2.0f) / this.f9236m) * f12, ((f11 / 2.0f) / this.f9237n) * f12);
            this.f9238o = max;
            ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(this.f9235l, PropertyValuesHolder.ofFloat((Property<?, Float>) ImageView.SCALE_X, max), PropertyValuesHolder.ofFloat((Property<?, Float>) ImageView.SCALE_Y, this.f9238o));
            this.f9240q = ofPropertyValuesHolder;
            ofPropertyValuesHolder.setInterpolator(new OvershootInterpolator());
            this.f9240q.setDuration(200L);
            ObjectAnimator ofPropertyValuesHolder2 = ObjectAnimator.ofPropertyValuesHolder(this.f9235l, PropertyValuesHolder.ofFloat((Property<?, Float>) ImageView.SCALE_X, 1.0f), PropertyValuesHolder.ofFloat((Property<?, Float>) ImageView.SCALE_Y, 1.0f));
            this.f9241r = ofPropertyValuesHolder2;
            ofPropertyValuesHolder2.setInterpolator(new OvershootInterpolator());
            this.f9241r.setDuration(200L);
        }
    }
}
