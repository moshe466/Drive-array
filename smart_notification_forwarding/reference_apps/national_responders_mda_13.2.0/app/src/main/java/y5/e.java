package y5;

/* loaded from: classes.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    private int f15924a = -1;

    public int a() {
        return this.f15924a;
    }

    public void b(boolean z10) {
        this.f15924a = (!z10 || this.f15924a >= 0) ? -1 : 3600;
    }
}
