package y3;

import okhttp3.a0;
import okhttp3.q;

/* loaded from: classes.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    private int f15910a;

    /* renamed from: b, reason: collision with root package name */
    private String f15911b;

    /* renamed from: c, reason: collision with root package name */
    private q f15912c;

    d(int i10, String str, q qVar) {
        this.f15910a = i10;
        this.f15911b = str;
        this.f15912c = qVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static d c(a0 a0Var) {
        return new d(a0Var.f(), a0Var.c() == null ? null : a0Var.c().D(), a0Var.D());
    }

    public String a() {
        return this.f15911b;
    }

    public int b() {
        return this.f15910a;
    }

    public String d(String str) {
        return this.f15912c.c(str);
    }
}
