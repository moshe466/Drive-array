package p6;

import java.util.Date;

/* loaded from: classes.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    @y4.c("serialNumber")
    private int f13094a;

    /* renamed from: b, reason: collision with root package name */
    private EnumC0271b f13095b;

    /* renamed from: c, reason: collision with root package name */
    private Date f13096c;

    /* renamed from: d, reason: collision with root package name */
    private a f13097d;

    /* loaded from: classes.dex */
    public enum a {
        NONE,
        NEGATIVE,
        POSITIVE,
        MARGINAL_POSITIVE
    }

    /* renamed from: p6.b$b, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public enum EnumC0271b {
        PCR,
        ANTIBODY
    }

    public Date a() {
        return this.f13096c;
    }

    public a b() {
        return this.f13097d;
    }

    public EnumC0271b c() {
        return this.f13095b;
    }

    public void d(Date date) {
        this.f13096c = date;
    }

    public void e(int i10) {
        this.f13094a = i10;
    }

    public void f(a aVar) {
        this.f13097d = aVar;
    }

    public void g(EnumC0271b enumC0271b) {
        this.f13095b = enumC0271b;
    }
}
