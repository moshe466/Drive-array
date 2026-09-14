package p6;

import java.util.Date;

/* loaded from: classes.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    @y4.c("expoSerialNumber")
    private int f13100a;

    /* renamed from: b, reason: collision with root package name */
    private b f13101b;

    /* renamed from: c, reason: collision with root package name */
    private Date f13102c;

    /* renamed from: d, reason: collision with root package name */
    private String f13103d;

    /* renamed from: e, reason: collision with root package name */
    private a f13104e;

    /* renamed from: f, reason: collision with root package name */
    private String f13105f;

    /* renamed from: g, reason: collision with root package name */
    private boolean f13106g;

    /* renamed from: h, reason: collision with root package name */
    private c f13107h;

    /* loaded from: classes.dex */
    public enum a {
        HOME,
        WORK,
        OTHER
    }

    /* loaded from: classes.dex */
    public enum b {
        PATIENT,
        FAMILY_MEMBER
    }

    public Date a() {
        return this.f13102c;
    }

    public String b() {
        return this.f13103d;
    }

    public String c() {
        return this.f13105f;
    }

    public a d() {
        return this.f13104e;
    }

    public b e() {
        return this.f13101b;
    }

    public c f() {
        return this.f13107h;
    }

    public boolean g() {
        return this.f13106g;
    }

    public void h(p6.a aVar) {
    }

    public void i(Date date) {
        this.f13102c = date;
    }

    public void j(String str) {
        this.f13103d = str;
    }

    public void k(String str) {
        this.f13105f = str;
    }

    public void l(a aVar) {
        this.f13104e = aVar;
    }

    public void m(b bVar) {
        this.f13101b = bVar;
    }

    public void n(e eVar) {
    }

    public void o(int i10) {
        this.f13100a = i10;
    }

    public void p(boolean z10) {
        this.f13106g = z10;
    }

    public void q(c cVar) {
        this.f13107h = cVar;
    }
}
