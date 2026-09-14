package t1;

import java.util.Set;
import q1.C0622c;

/* loaded from: classes.dex */
public final class r implements q1.g {

    /* renamed from: a, reason: collision with root package name */
    public final Set f6445a;

    /* renamed from: b, reason: collision with root package name */
    public final k f6446b;

    /* renamed from: c, reason: collision with root package name */
    public final t f6447c;

    public r(Set set, k kVar, t tVar) {
        this.f6445a = set;
        this.f6446b = kVar;
        this.f6447c = tVar;
    }

    public final s a(String str, C0622c c0622c, q1.e eVar) {
        Set set = this.f6445a;
        if (set.contains(c0622c)) {
            return new s(this.f6446b, str, c0622c, eVar, this.f6447c);
        }
        throw new IllegalArgumentException(String.format("%s is not supported byt this factory. Supported encodings are: %s.", c0622c, set));
    }
}
