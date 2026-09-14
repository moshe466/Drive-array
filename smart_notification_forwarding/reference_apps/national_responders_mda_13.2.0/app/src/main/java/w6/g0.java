package w6;

import java.util.Date;

/* loaded from: classes.dex */
public class g0 {

    /* renamed from: a, reason: collision with root package name */
    public float f15157a;

    /* renamed from: b, reason: collision with root package name */
    public double f15158b;

    /* renamed from: c, reason: collision with root package name */
    public double f15159c;

    /* renamed from: d, reason: collision with root package name */
    public double f15160d;

    /* renamed from: e, reason: collision with root package name */
    public double f15161e;

    /* renamed from: f, reason: collision with root package name */
    public double f15162f;

    public g0(Date date, Date date2) {
        if (date == null || date2 == null) {
            return;
        }
        this.f15160d = date2.getTime() - date.getTime();
        this.f15162f = (date2.getTime() - date.getTime()) / 1000.0d;
        this.f15161e = (date2.getTime() - date.getTime()) / 60000.0d;
        this.f15159c = (date2.getTime() - date.getTime()) / 3600000.0d;
        double time = (date2.getTime() - date.getTime()) / 8.64E7d;
        this.f15158b = time;
        this.f15157a = ((float) time) / 365.0f;
    }

    public static g0 a(Date date) {
        return new g0(date, new Date());
    }

    public static g0 b(Date date) {
        g0 g0Var = new g0(date, new Date());
        double d10 = g0Var.f15160d;
        if (d10 < 0.0d) {
            g0Var.f15160d = Math.abs(d10);
            g0Var.f15162f = Math.abs(g0Var.f15162f);
            g0Var.f15161e = Math.abs(g0Var.f15161e);
            g0Var.f15159c = Math.abs(g0Var.f15159c);
            g0Var.f15158b = Math.abs(g0Var.f15158b);
            g0Var.f15157a = Math.abs(g0Var.f15157a);
        }
        return g0Var;
    }

    public static boolean c(Date date) {
        return date != null && a(date).f15162f < 0.0d;
    }
}
