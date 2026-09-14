package p6;

import java.util.Date;

/* loaded from: classes.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private boolean f13089a = false;

    /* renamed from: b, reason: collision with root package name */
    private EnumC0270a f13090b;

    /* renamed from: c, reason: collision with root package name */
    private Date f13091c;

    /* renamed from: d, reason: collision with root package name */
    private String f13092d;

    /* renamed from: e, reason: collision with root package name */
    private c f13093e;

    /* renamed from: p6.a$a, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public enum EnumC0270a {
        IMOH,
        FAMILY_MEMBER,
        MDA_REQUIREMENT,
        OTHER
    }

    public c a() {
        return this.f13093e;
    }

    public EnumC0270a b() {
        return this.f13090b;
    }

    public Date c() {
        return this.f13091c;
    }

    public String d() {
        return this.f13092d;
    }

    public boolean e() {
        return this.f13089a;
    }

    public void f(c cVar) {
        this.f13093e = cVar;
    }

    public void g(EnumC0270a enumC0270a) {
        this.f13090b = enumC0270a;
    }

    public void h(boolean z10) {
        this.f13089a = z10;
    }

    public void i(Date date) {
        this.f13091c = date;
    }

    public void j(String str) {
        this.f13092d = str;
    }
}
