package m;

import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.TouchDelegate;
import android.view.View;
import android.view.ViewConfiguration;

/* loaded from: classes.dex */
public final class d1 extends TouchDelegate {

    /* renamed from: a, reason: collision with root package name */
    public final View f5635a;

    /* renamed from: b, reason: collision with root package name */
    public final Rect f5636b;

    /* renamed from: c, reason: collision with root package name */
    public final Rect f5637c;

    /* renamed from: d, reason: collision with root package name */
    public final Rect f5638d;

    /* renamed from: e, reason: collision with root package name */
    public final int f5639e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f5640f;

    public d1(Rect rect, Rect rect2, View view) {
        super(rect, view);
        int scaledTouchSlop = ViewConfiguration.get(view.getContext()).getScaledTouchSlop();
        this.f5639e = scaledTouchSlop;
        Rect rect3 = new Rect();
        this.f5636b = rect3;
        Rect rect4 = new Rect();
        this.f5638d = rect4;
        Rect rect5 = new Rect();
        this.f5637c = rect5;
        rect3.set(rect);
        rect4.set(rect);
        int i = -scaledTouchSlop;
        rect4.inset(i, i);
        rect5.set(rect2);
        this.f5635a = view;
    }

    @Override // android.view.TouchDelegate
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z3;
        boolean z4;
        int x3 = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        int action = motionEvent.getAction();
        boolean z5 = true;
        if (action != 0) {
            if (action != 1 && action != 2) {
                if (action == 3) {
                    z4 = this.f5640f;
                    this.f5640f = false;
                }
                z3 = true;
                z5 = false;
            } else {
                z4 = this.f5640f;
                if (z4 && !this.f5638d.contains(x3, y)) {
                    z5 = z4;
                    z3 = false;
                }
            }
            z5 = z4;
            z3 = true;
        } else {
            if (this.f5636b.contains(x3, y)) {
                this.f5640f = true;
                z3 = true;
            }
            z3 = true;
            z5 = false;
        }
        if (!z5) {
            return false;
        }
        Rect rect = this.f5637c;
        View view = this.f5635a;
        if (z3 && !rect.contains(x3, y)) {
            motionEvent.setLocation(view.getWidth() / 2, view.getHeight() / 2);
        } else {
            motionEvent.setLocation(x3 - rect.left, y - rect.top);
        }
        return view.dispatchTouchEvent(motionEvent);
    }
}
