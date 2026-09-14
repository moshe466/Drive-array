package u7;

/* loaded from: classes.dex */
public abstract class l extends t {
    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // u7.t
    public void b(byte[] bArr) {
        String e10 = m7.a.e(bArr, m7.a.f12022a);
        int d10 = m7.a.d(bArr, m7.a.f12023b);
        if (d10 == 0) {
            c(d10, e10);
        } else {
            a(d10);
        }
    }

    public abstract void c(int i10, String str);
}
