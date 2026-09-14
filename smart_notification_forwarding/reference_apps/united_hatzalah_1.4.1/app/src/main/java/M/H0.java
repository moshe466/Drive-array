package m;

import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;

/* loaded from: classes.dex */
public final class H0 implements View.OnTouchListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ I0 f5529a;

    public H0(I0 i02) {
        this.f5529a = i02;
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View view, MotionEvent motionEvent) {
        C0581z c0581z;
        I0 i02 = this.f5529a;
        F0 f02 = i02.f5549t;
        Handler handler = i02.f5553x;
        int action = motionEvent.getAction();
        int x3 = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        if (action == 0 && (c0581z = i02.f5533B) != null && c0581z.isShowing() && x3 >= 0 && x3 < i02.f5533B.getWidth() && y >= 0 && y < i02.f5533B.getHeight()) {
            handler.postDelayed(f02, 250L);
            return false;
        }
        if (action == 1) {
            handler.removeCallbacks(f02);
            return false;
        }
        return false;
    }
}
