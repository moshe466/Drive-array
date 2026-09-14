package T0;

import F0.Q2;
import J.S;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.widget.TextView;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
import java.util.WeakHashMap;
import m.U;
import m.Y;
import m.Z;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public final int f2267a;

    /* renamed from: b, reason: collision with root package name */
    public final int f2268b;

    /* renamed from: c, reason: collision with root package name */
    public final Object f2269c;

    /* renamed from: d, reason: collision with root package name */
    public final Object f2270d;

    public a(ByteBuffer byteBuffer, ByteBuffer byteBuffer2, int i, int i3) {
        this.f2269c = byteBuffer;
        this.f2270d = byteBuffer2;
        this.f2267a = i;
        this.f2268b = i3;
    }

    public void a() {
        new Handler(Looper.getMainLooper()).post(new Q2(this, 18));
    }

    public void b(Typeface typeface) {
        int i;
        boolean z3;
        if (Build.VERSION.SDK_INT >= 28 && (i = this.f2267a) != -1) {
            if ((this.f2268b & 2) != 0) {
                z3 = true;
            } else {
                z3 = false;
            }
            typeface = Y.a(typeface, i, z3);
        }
        Z z4 = (Z) this.f2270d;
        WeakReference weakReference = (WeakReference) this.f2269c;
        if (z4.f5622m) {
            z4.f5621l = typeface;
            TextView textView = (TextView) weakReference.get();
            if (textView != null) {
                WeakHashMap weakHashMap = S.f954a;
                if (textView.isAttachedToWindow()) {
                    textView.post(new U(textView, typeface, z4.f5619j));
                } else {
                    textView.setTypeface(typeface, z4.f5619j);
                }
            }
        }
    }

    public a(Z z3, int i, int i3, WeakReference weakReference) {
        this.f2270d = z3;
        this.f2267a = i;
        this.f2268b = i3;
        this.f2269c = weakReference;
    }
}
