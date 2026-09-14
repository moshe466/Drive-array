package n;

import java.text.DecimalFormat;

/* loaded from: classes.dex */
public abstract class e {

    /* renamed from: a, reason: collision with root package name */
    protected a f12144a;

    /* renamed from: b, reason: collision with root package name */
    protected int[] f12145b = new int[10];

    /* renamed from: c, reason: collision with root package name */
    protected float[] f12146c = new float[10];

    /* renamed from: d, reason: collision with root package name */
    private int f12147d;

    /* renamed from: e, reason: collision with root package name */
    private String f12148e;

    public float a(float f10) {
        return (float) this.f12144a.a(f10, 0);
    }

    public String toString() {
        String str = this.f12148e;
        DecimalFormat decimalFormat = new DecimalFormat("##.##");
        for (int i10 = 0; i10 < this.f12147d; i10++) {
            str = str + "[" + this.f12145b[i10] + " , " + decimalFormat.format(this.f12146c[i10]) + "] ";
        }
        return str;
    }
}
