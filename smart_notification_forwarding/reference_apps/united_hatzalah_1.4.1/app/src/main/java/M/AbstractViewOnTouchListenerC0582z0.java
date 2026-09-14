package m;

import android.view.View;
import android.view.ViewConfiguration;
import l.InterfaceC0500D;

/* renamed from: m.z0, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractViewOnTouchListenerC0582z0 implements View.OnTouchListener, View.OnAttachStateChangeListener {

    /* renamed from: a, reason: collision with root package name */
    public final float f5844a;

    /* renamed from: b, reason: collision with root package name */
    public final int f5845b;

    /* renamed from: c, reason: collision with root package name */
    public final int f5846c;

    /* renamed from: d, reason: collision with root package name */
    public final View f5847d;

    /* renamed from: e, reason: collision with root package name */
    public RunnableC0580y0 f5848e;

    /* renamed from: f, reason: collision with root package name */
    public RunnableC0580y0 f5849f;

    /* renamed from: j, reason: collision with root package name */
    public boolean f5850j;

    /* renamed from: k, reason: collision with root package name */
    public int f5851k;

    /* renamed from: l, reason: collision with root package name */
    public final int[] f5852l = new int[2];

    public AbstractViewOnTouchListenerC0582z0(View view) {
        this.f5847d = view;
        view.setLongClickable(true);
        view.addOnAttachStateChangeListener(this);
        this.f5844a = ViewConfiguration.get(view.getContext()).getScaledTouchSlop();
        int tapTimeout = ViewConfiguration.getTapTimeout();
        this.f5845b = tapTimeout;
        this.f5846c = (ViewConfiguration.getLongPressTimeout() + tapTimeout) / 2;
    }

    public final void a() {
        RunnableC0580y0 runnableC0580y0 = this.f5849f;
        View view = this.f5847d;
        if (runnableC0580y0 != null) {
            view.removeCallbacks(runnableC0580y0);
        }
        RunnableC0580y0 runnableC0580y02 = this.f5848e;
        if (runnableC0580y02 != null) {
            view.removeCallbacks(runnableC0580y02);
        }
    }

    public abstract InterfaceC0500D b();

    public abstract boolean c();

    public boolean d() {
        InterfaceC0500D b4 = b();
        if (b4 != null && b4.a()) {
            b4.dismiss();
            return true;
        }
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0059, code lost:
    
        if (r14 != false) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x007b, code lost:
    
        if (r4 != 3) goto L58;
     */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0100  */
    @Override // android.view.View.OnTouchListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean onTouch(android.view.View r13, android.view.MotionEvent r14) {
        /*
            Method dump skipped, instructions count: 284
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: m.AbstractViewOnTouchListenerC0582z0.onTouch(android.view.View, android.view.MotionEvent):boolean");
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(View view) {
        this.f5850j = false;
        this.f5851k = -1;
        RunnableC0580y0 runnableC0580y0 = this.f5848e;
        if (runnableC0580y0 != null) {
            this.f5847d.removeCallbacks(runnableC0580y0);
        }
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewAttachedToWindow(View view) {
    }
}
