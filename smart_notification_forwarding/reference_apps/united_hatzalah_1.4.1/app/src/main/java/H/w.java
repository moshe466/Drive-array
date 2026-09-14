package h;

import a.AbstractC0228a;
import android.view.KeyEvent;
import android.view.MotionEvent;
import androidx.appcompat.widget.ContentFrameLayout;
import k.C0461e;

/* loaded from: classes.dex */
public final class w extends ContentFrameLayout {

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ y f4856l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public w(y yVar, C0461e c0461e) {
        super(c0461e, null);
        this.f4856l = yVar;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (!this.f4856l.u(keyEvent) && !super.dispatchKeyEvent(keyEvent)) {
            return false;
        }
        return true;
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            int x3 = (int) motionEvent.getX();
            int y = (int) motionEvent.getY();
            if (x3 < -5 || y < -5 || x3 > getWidth() + 5 || y > getHeight() + 5) {
                y yVar = this.f4856l;
                yVar.s(yVar.z(0), true);
                return true;
            }
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public final void setBackgroundResource(int i) {
        setBackgroundDrawable(AbstractC0228a.q(getContext(), i));
    }
}
