package m;

import android.graphics.PointF;
import android.graphics.Rect;
import android.util.Property;
import android.view.View;
import androidx.appcompat.widget.SwitchCompat;
import java.util.WeakHashMap;
import q0.C0619e;

/* loaded from: classes.dex */
public final class g1 extends Property {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5666a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ g1(String str, int i, Class cls) {
        super(cls, str);
        this.f5666a = i;
    }

    @Override // android.util.Property
    public final Object get(Object obj) {
        switch (this.f5666a) {
            case 0:
                return Float.valueOf(((SwitchCompat) obj).f2924C);
            case 1:
                return null;
            case 2:
                return null;
            case 3:
                return null;
            case 4:
                return null;
            case 5:
                return null;
            case 6:
                return Float.valueOf(q0.y.f6139a.w((View) obj));
            default:
                WeakHashMap weakHashMap = J.S.f954a;
                return ((View) obj).getClipBounds();
        }
    }

    @Override // android.util.Property
    public final void set(Object obj, Object obj2) {
        switch (this.f5666a) {
            case 0:
                ((SwitchCompat) obj).setThumbPosition(((Float) obj2).floatValue());
                return;
            case 1:
                C0619e c0619e = (C0619e) obj;
                PointF pointF = (PointF) obj2;
                c0619e.getClass();
                c0619e.f6072a = Math.round(pointF.x);
                int round = Math.round(pointF.y);
                c0619e.f6073b = round;
                int i = c0619e.f6077f + 1;
                c0619e.f6077f = i;
                if (i == c0619e.f6078g) {
                    q0.y.a(c0619e.f6076e, c0619e.f6072a, round, c0619e.f6074c, c0619e.f6075d);
                    c0619e.f6077f = 0;
                    c0619e.f6078g = 0;
                    return;
                }
                return;
            case 2:
                C0619e c0619e2 = (C0619e) obj;
                PointF pointF2 = (PointF) obj2;
                c0619e2.getClass();
                c0619e2.f6074c = Math.round(pointF2.x);
                int round2 = Math.round(pointF2.y);
                c0619e2.f6075d = round2;
                int i3 = c0619e2.f6078g + 1;
                c0619e2.f6078g = i3;
                if (c0619e2.f6077f == i3) {
                    q0.y.a(c0619e2.f6076e, c0619e2.f6072a, c0619e2.f6073b, c0619e2.f6074c, round2);
                    c0619e2.f6077f = 0;
                    c0619e2.f6078g = 0;
                    return;
                }
                return;
            case 3:
                View view = (View) obj;
                PointF pointF3 = (PointF) obj2;
                q0.y.a(view, view.getLeft(), view.getTop(), Math.round(pointF3.x), Math.round(pointF3.y));
                return;
            case 4:
                View view2 = (View) obj;
                PointF pointF4 = (PointF) obj2;
                q0.y.a(view2, Math.round(pointF4.x), Math.round(pointF4.y), view2.getRight(), view2.getBottom());
                return;
            case 5:
                View view3 = (View) obj;
                PointF pointF5 = (PointF) obj2;
                int round3 = Math.round(pointF5.x);
                int round4 = Math.round(pointF5.y);
                q0.y.a(view3, round3, round4, view3.getWidth() + round3, view3.getHeight() + round4);
                return;
            case 6:
                float floatValue = ((Float) obj2).floatValue();
                q0.y.f6139a.O((View) obj, floatValue);
                return;
            default:
                WeakHashMap weakHashMap = J.S.f954a;
                ((View) obj).setClipBounds((Rect) obj2);
                return;
        }
    }
}
