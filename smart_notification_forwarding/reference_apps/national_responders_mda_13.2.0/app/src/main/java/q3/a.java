package q3;

import java.util.HashSet;
import java.util.Set;
import p3.a;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    Set<String> f13555a;

    /* renamed from: b, reason: collision with root package name */
    private a.b f13556b;

    /* renamed from: c, reason: collision with root package name */
    private u2.a f13557c;

    /* renamed from: d, reason: collision with root package name */
    private d f13558d;

    public a(u2.a aVar, a.b bVar) {
        this.f13556b = bVar;
        this.f13557c = aVar;
        d dVar = new d(this);
        this.f13558d = dVar;
        this.f13557c.b(dVar);
        this.f13555a = new HashSet();
    }
}
