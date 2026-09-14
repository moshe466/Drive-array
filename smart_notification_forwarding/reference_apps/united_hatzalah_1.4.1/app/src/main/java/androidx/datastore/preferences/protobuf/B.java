package androidx.datastore.preferences.protobuf;

import java.nio.charset.Charset;

/* loaded from: classes.dex */
public final class B {

    /* renamed from: b, reason: collision with root package name */
    public static final r f3088b = new r(1);

    /* renamed from: a, reason: collision with root package name */
    public final Object f3089a;

    public B(C0244k c0244k) {
        AbstractC0255w.a(c0244k, "output");
        this.f3089a = c0244k;
        c0244k.f3197j = this;
    }

    public void a(int i, Object obj, S s3) {
        C0244k c0244k = (C0244k) this.f3089a;
        c0244k.f0(i, 3);
        s3.d((AbstractC0234a) obj, c0244k.f3197j);
        c0244k.f0(i, 4);
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [androidx.datastore.preferences.protobuf.A, java.lang.Object] */
    public B() {
        H h2;
        O o2 = O.f3120c;
        try {
            h2 = (H) Class.forName("androidx.datastore.preferences.protobuf.DescriptorMessageInfoFactory").getDeclaredMethod("getInstance", null).invoke(null, null);
        } catch (Exception unused) {
            h2 = f3088b;
        }
        H[] hArr = {r.f3232b, h2};
        ?? obj = new Object();
        obj.f3087a = hArr;
        Charset charset = AbstractC0255w.f3236a;
        this.f3089a = obj;
    }
}
