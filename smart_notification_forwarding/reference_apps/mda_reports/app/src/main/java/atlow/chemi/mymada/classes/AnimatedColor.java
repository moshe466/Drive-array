package atlow.chemi.mymada.classes;

import android.graphics.Color;

/* loaded from: classes.dex */
public class AnimatedColor {
    private final int mEndColor;
    private final float[] mEndHsv;
    private float[] mMove = new float[3];
    private final int mStartColor;
    private final float[] mStartHsv;

    public AnimatedColor(int i, int i2) {
        this.mStartColor = i;
        this.mEndColor = i2;
        this.mStartHsv = toHsv(i);
        this.mEndHsv = toHsv(i2);
    }

    private float[] move(float f) {
        float[] fArr = this.mMove;
        float[] fArr2 = this.mEndHsv;
        float f2 = fArr2[0];
        float[] fArr3 = this.mStartHsv;
        fArr[0] = ((f2 - fArr3[0]) * f) + fArr3[0];
        fArr[1] = ((fArr2[1] - fArr3[1]) * f) + fArr3[1];
        fArr[2] = ((fArr2[2] - fArr3[2]) * f) + fArr3[2];
        return fArr;
    }

    private float[] toHsv(int i) {
        float[] fArr = new float[3];
        Color.colorToHSV(i, fArr);
        return fArr;
    }

    public int with(float f) {
        return f <= 0.0f ? this.mStartColor : f >= 1.0f ? this.mEndColor : Color.HSVToColor(move(f));
    }
}
