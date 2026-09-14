package n;

import java.lang.reflect.Array;
import java.text.DecimalFormat;

/* loaded from: classes.dex */
public abstract class f {

    /* renamed from: a, reason: collision with root package name */
    protected a f12149a;

    /* renamed from: e, reason: collision with root package name */
    protected int f12153e;

    /* renamed from: f, reason: collision with root package name */
    protected String f12154f;

    /* renamed from: i, reason: collision with root package name */
    protected long f12157i;

    /* renamed from: b, reason: collision with root package name */
    protected int f12150b = 0;

    /* renamed from: c, reason: collision with root package name */
    protected int[] f12151c = new int[10];

    /* renamed from: d, reason: collision with root package name */
    protected float[][] f12152d = (float[][]) Array.newInstance((Class<?>) float.class, 10, 3);

    /* renamed from: g, reason: collision with root package name */
    protected float[] f12155g = new float[3];

    /* renamed from: h, reason: collision with root package name */
    protected boolean f12156h = false;

    /* renamed from: j, reason: collision with root package name */
    protected float f12158j = Float.NaN;

    public String toString() {
        String str = this.f12154f;
        DecimalFormat decimalFormat = new DecimalFormat("##.##");
        for (int i10 = 0; i10 < this.f12153e; i10++) {
            str = str + "[" + this.f12151c[i10] + " , " + decimalFormat.format(this.f12152d[i10]) + "] ";
        }
        return str;
    }
}
