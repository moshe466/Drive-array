package androidx.core.app;

import android.app.Person;
import androidx.core.graphics.drawable.IconCompat;

/* loaded from: classes.dex */
public class q {

    /* renamed from: a, reason: collision with root package name */
    CharSequence f2292a;

    /* renamed from: b, reason: collision with root package name */
    IconCompat f2293b;

    /* renamed from: c, reason: collision with root package name */
    String f2294c;

    /* renamed from: d, reason: collision with root package name */
    String f2295d;

    /* renamed from: e, reason: collision with root package name */
    boolean f2296e;

    /* renamed from: f, reason: collision with root package name */
    boolean f2297f;

    /* loaded from: classes.dex */
    static class a {
        static q a(Person person) {
            return new b().f(person.getName()).c(person.getIcon() != null ? IconCompat.a(person.getIcon()) : null).g(person.getUri()).e(person.getKey()).b(person.isBot()).d(person.isImportant()).a();
        }

        static Person b(q qVar) {
            return new Person.Builder().setName(qVar.c()).setIcon(qVar.a() != null ? qVar.a().q() : null).setUri(qVar.d()).setKey(qVar.b()).setBot(qVar.e()).setImportant(qVar.f()).build();
        }
    }

    /* loaded from: classes.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        CharSequence f2298a;

        /* renamed from: b, reason: collision with root package name */
        IconCompat f2299b;

        /* renamed from: c, reason: collision with root package name */
        String f2300c;

        /* renamed from: d, reason: collision with root package name */
        String f2301d;

        /* renamed from: e, reason: collision with root package name */
        boolean f2302e;

        /* renamed from: f, reason: collision with root package name */
        boolean f2303f;

        public q a() {
            return new q(this);
        }

        public b b(boolean z10) {
            this.f2302e = z10;
            return this;
        }

        public b c(IconCompat iconCompat) {
            this.f2299b = iconCompat;
            return this;
        }

        public b d(boolean z10) {
            this.f2303f = z10;
            return this;
        }

        public b e(String str) {
            this.f2301d = str;
            return this;
        }

        public b f(CharSequence charSequence) {
            this.f2298a = charSequence;
            return this;
        }

        public b g(String str) {
            this.f2300c = str;
            return this;
        }
    }

    q(b bVar) {
        this.f2292a = bVar.f2298a;
        this.f2293b = bVar.f2299b;
        this.f2294c = bVar.f2300c;
        this.f2295d = bVar.f2301d;
        this.f2296e = bVar.f2302e;
        this.f2297f = bVar.f2303f;
    }

    public IconCompat a() {
        return this.f2293b;
    }

    public String b() {
        return this.f2295d;
    }

    public CharSequence c() {
        return this.f2292a;
    }

    public String d() {
        return this.f2294c;
    }

    public boolean e() {
        return this.f2296e;
    }

    public boolean f() {
        return this.f2297f;
    }

    public String g() {
        String str = this.f2294c;
        if (str != null) {
            return str;
        }
        if (this.f2292a == null) {
            return "";
        }
        return "name:" + ((Object) this.f2292a);
    }

    public Person h() {
        return a.b(this);
    }
}
