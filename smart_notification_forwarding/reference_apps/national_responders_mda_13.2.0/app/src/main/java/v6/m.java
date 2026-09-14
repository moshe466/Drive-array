package v6;

import android.view.MotionEvent;
import android.view.View;

/* loaded from: classes.dex */
public class m implements View.OnTouchListener {

    /* renamed from: f, reason: collision with root package name */
    private int f14694f = 50;

    /* renamed from: g, reason: collision with root package name */
    private float f14695g;

    /* renamed from: h, reason: collision with root package name */
    private float f14696h;

    /* renamed from: i, reason: collision with root package name */
    private float f14697i;

    /* renamed from: j, reason: collision with root package name */
    private float f14698j;

    /* renamed from: k, reason: collision with root package name */
    View f14699k;

    public void a() {
    }

    public void b() {
    }

    public void c() {
    }

    public void d() {
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        this.f14699k = view;
        int action = motionEvent.getAction();
        if (action == 0) {
            this.f14695g = motionEvent.getX();
            this.f14696h = motionEvent.getY();
            return true;
        }
        if (action != 1) {
            return false;
        }
        this.f14697i = motionEvent.getX();
        float y10 = motionEvent.getY();
        this.f14698j = y10;
        float f10 = this.f14695g - this.f14697i;
        float f11 = this.f14696h - y10;
        if (Math.abs(f10) > Math.abs(f11)) {
            if (Math.abs(f10) <= this.f14694f) {
                return false;
            }
            if (f10 < 0.0f) {
                b();
                return true;
            }
            if (f10 > 0.0f) {
                c();
                return true;
            }
        } else if (Math.abs(f11) > this.f14694f) {
            if (f11 < 0.0f) {
                d();
                return true;
            }
            if (f11 > 0.0f) {
                a();
                return true;
            }
        }
        return false;
    }
}
