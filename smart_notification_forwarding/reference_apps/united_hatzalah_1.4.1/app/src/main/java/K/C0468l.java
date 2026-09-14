package k;

import J.X;
import J.Y;
import android.view.View;
import android.view.animation.Interpolator;
import java.util.ArrayList;

/* renamed from: k.l, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0468l {

    /* renamed from: c, reason: collision with root package name */
    public Interpolator f5159c;

    /* renamed from: d, reason: collision with root package name */
    public Y f5160d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f5161e;

    /* renamed from: b, reason: collision with root package name */
    public long f5158b = -1;

    /* renamed from: f, reason: collision with root package name */
    public final C0467k f5162f = new C0467k(this);

    /* renamed from: a, reason: collision with root package name */
    public final ArrayList f5157a = new ArrayList();

    public final void a() {
        if (!this.f5161e) {
            return;
        }
        ArrayList arrayList = this.f5157a;
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            ((X) obj).b();
        }
        this.f5161e = false;
    }

    public final void b() {
        View view;
        if (this.f5161e) {
            return;
        }
        ArrayList arrayList = this.f5157a;
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            X x3 = (X) obj;
            long j2 = this.f5158b;
            if (j2 >= 0) {
                x3.c(j2);
            }
            Interpolator interpolator = this.f5159c;
            if (interpolator != null && (view = (View) x3.f964a.get()) != null) {
                view.animate().setInterpolator(interpolator);
            }
            if (this.f5160d != null) {
                x3.d(this.f5162f);
            }
            View view2 = (View) x3.f964a.get();
            if (view2 != null) {
                view2.animate().start();
            }
        }
        this.f5161e = true;
    }
}
