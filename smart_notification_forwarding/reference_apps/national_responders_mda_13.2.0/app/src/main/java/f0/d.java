package f0;

import android.view.animation.Interpolator;

/* loaded from: classes.dex */
abstract class d implements Interpolator {

    /* renamed from: a, reason: collision with root package name */
    private final float[] f9352a;

    /* renamed from: b, reason: collision with root package name */
    private final float f9353b;

    /* JADX INFO: Access modifiers changed from: protected */
    public d(float[] fArr) {
        this.f9352a = fArr;
        this.f9353b = 1.0f / (fArr.length - 1);
    }

    @Override // android.animation.TimeInterpolator
    public float getInterpolation(float f10) {
        if (f10 >= 1.0f) {
            return 1.0f;
        }
        if (f10 <= 0.0f) {
            return 0.0f;
        }
        float[] fArr = this.f9352a;
        int min = Math.min((int) ((fArr.length - 1) * f10), fArr.length - 2);
        float f11 = this.f9353b;
        float f12 = (f10 - (min * f11)) / f11;
        float[] fArr2 = this.f9352a;
        return fArr2[min] + (f12 * (fArr2[min + 1] - fArr2[min]));
    }
}
