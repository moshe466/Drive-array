package b3;

import android.animation.TypeEvaluator;
import android.graphics.Matrix;

/* loaded from: classes.dex */
public class g implements TypeEvaluator<Matrix> {

    /* renamed from: a, reason: collision with root package name */
    private final float[] f4099a = new float[9];

    /* renamed from: b, reason: collision with root package name */
    private final float[] f4100b = new float[9];

    /* renamed from: c, reason: collision with root package name */
    private final Matrix f4101c = new Matrix();

    @Override // android.animation.TypeEvaluator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Matrix evaluate(float f10, Matrix matrix, Matrix matrix2) {
        matrix.getValues(this.f4099a);
        matrix2.getValues(this.f4100b);
        for (int i10 = 0; i10 < 9; i10++) {
            float[] fArr = this.f4100b;
            float f11 = fArr[i10];
            float[] fArr2 = this.f4099a;
            fArr[i10] = fArr2[i10] + ((f11 - fArr2[i10]) * f10);
        }
        this.f4101c.setValues(this.f4100b);
        return this.f4101c;
    }
}
