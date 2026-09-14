package d1;

import android.content.ContentResolver;
import g1.n;
import s2.C0680e;

/* renamed from: d1.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0358a {

    /* renamed from: a, reason: collision with root package name */
    public final ContentResolver f4413a;

    public /* synthetic */ C0358a(ContentResolver contentResolver) {
        this.f4413a = contentResolver;
    }

    public String a(String str) {
        Object G3 = T.b.G(1000L, new n(this, str, 0));
        if (G3 instanceof C0680e) {
            G3 = "";
        }
        return (String) G3;
    }

    public String b(String str) {
        Object G3 = T.b.G(1000L, new n(this, str, 1));
        if (G3 instanceof C0680e) {
            G3 = "";
        }
        return (String) G3;
    }

    public String c(String str) {
        Object G3 = T.b.G(1000L, new n(this, str, 2));
        if (G3 instanceof C0680e) {
            G3 = "";
        }
        return (String) G3;
    }
}
