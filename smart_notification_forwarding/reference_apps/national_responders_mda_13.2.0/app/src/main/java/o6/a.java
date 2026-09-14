package o6;

import java.util.Date;
import p6.a;

/* loaded from: classes.dex */
public interface a {

    /* renamed from: o6.a$a, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0264a {

        /* renamed from: a, reason: collision with root package name */
        private a.EnumC0270a f12511a;

        /* renamed from: b, reason: collision with root package name */
        private Date f12512b;

        /* renamed from: c, reason: collision with root package name */
        private String f12513c;

        public Date a() {
            return this.f12512b;
        }

        public String b() {
            return this.f12513c;
        }

        public a.EnumC0270a c() {
            return this.f12511a;
        }

        public void d(Date date) {
            this.f12512b = date;
        }

        public void e(String str) {
            this.f12513c = str;
        }

        public void f(a.EnumC0270a enumC0270a) {
            this.f12511a = enumC0270a;
        }
    }

    void a(C0264a c0264a);
}
