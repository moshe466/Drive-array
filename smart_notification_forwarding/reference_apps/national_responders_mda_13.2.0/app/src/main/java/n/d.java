package n;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes.dex */
public abstract class d {

    /* renamed from: a, reason: collision with root package name */
    private a f12136a;

    /* renamed from: b, reason: collision with root package name */
    private String f12137b;

    /* renamed from: c, reason: collision with root package name */
    private int f12138c = 0;

    /* renamed from: d, reason: collision with root package name */
    private String f12139d = null;

    /* renamed from: e, reason: collision with root package name */
    public int f12140e = 0;

    /* renamed from: f, reason: collision with root package name */
    ArrayList<b> f12141f = new ArrayList<>();

    /* loaded from: classes.dex */
    static class a {
        public double a(float f10) {
            throw null;
        }
    }

    /* loaded from: classes.dex */
    static class b {

        /* renamed from: a, reason: collision with root package name */
        int f12142a;

        /* renamed from: b, reason: collision with root package name */
        float f12143b;
    }

    public float a(float f10) {
        return (float) this.f12136a.a(f10);
    }

    public String toString() {
        String str = this.f12137b;
        DecimalFormat decimalFormat = new DecimalFormat("##.##");
        Iterator<b> it = this.f12141f.iterator();
        while (it.hasNext()) {
            str = str + "[" + it.next().f12142a + " , " + decimalFormat.format(r3.f12143b) + "] ";
        }
        return str;
    }
}
