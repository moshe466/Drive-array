package p6;

import java.util.Date;

/* loaded from: classes.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    private Date f13098a;

    /* renamed from: b, reason: collision with root package name */
    private Date f13099b;

    public c() {
    }

    public c(Date date, Date date2) {
        this.f13098a = date;
        this.f13099b = date2;
    }

    public Date a() {
        return this.f13099b;
    }

    public Date b() {
        return this.f13098a;
    }

    public void c(Date date) {
        this.f13099b = date;
    }

    public void d(Date date) {
        this.f13098a = date;
    }
}
