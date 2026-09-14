package r;

import android.view.View;
import n.f;

/* loaded from: classes.dex */
public abstract class e extends f {

    /* loaded from: classes.dex */
    public static class a extends e {
        @Override // r.e
        public boolean b(View view, float f10, long j10, n.c cVar) {
            return this.f12156h;
        }

        public boolean c(View view, n.c cVar, float f10, long j10, double d10, double d11) {
            view.setRotation(a(f10, j10, view, cVar) + ((float) Math.toDegrees(Math.atan2(d11, d10))));
            return this.f12156h;
        }
    }

    public float a(float f10, long j10, View view, n.c cVar) {
        this.f12149a.c(f10, this.f12155g);
        float[] fArr = this.f12155g;
        float f11 = fArr[1];
        if (f11 == 0.0f) {
            this.f12156h = false;
            return fArr[2];
        }
        if (Float.isNaN(this.f12158j)) {
            throw null;
        }
        this.f12158j = (float) ((this.f12158j + (((j10 - this.f12157i) * 1.0E-9d) * f11)) % 1.0d);
        throw null;
    }

    public abstract boolean b(View view, float f10, long j10, n.c cVar);
}
