package K2;

import a.AbstractC0228a;
import java.util.Iterator;

/* loaded from: classes.dex */
public abstract class a implements Iterable, G2.a {

    /* renamed from: a, reason: collision with root package name */
    public final char f1111a;

    /* renamed from: b, reason: collision with root package name */
    public final char f1112b;

    /* renamed from: c, reason: collision with root package name */
    public final int f1113c = 1;

    public a(char c4, char c5) {
        this.f1111a = c4;
        this.f1112b = (char) AbstractC0228a.u(c4, c5, 1);
    }

    @Override // java.lang.Iterable
    public final Iterator iterator() {
        return new b(this.f1111a, this.f1112b, this.f1113c);
    }
}
