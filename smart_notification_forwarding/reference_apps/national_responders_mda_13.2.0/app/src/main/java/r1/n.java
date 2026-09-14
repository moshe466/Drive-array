package r1;

import android.database.Cursor;
import java.util.List;
import r1.b0;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final /* synthetic */ class n implements b0.b {

    /* renamed from: a, reason: collision with root package name */
    private final b0 f13695a;

    /* renamed from: b, reason: collision with root package name */
    private final List f13696b;

    /* renamed from: c, reason: collision with root package name */
    private final k1.m f13697c;

    private n(b0 b0Var, List list, k1.m mVar) {
        this.f13695a = b0Var;
        this.f13696b = list;
        this.f13697c = mVar;
    }

    public static b0.b a(b0 b0Var, List list, k1.m mVar) {
        return new n(b0Var, list, mVar);
    }

    @Override // r1.b0.b
    public Object apply(Object obj) {
        return b0.j0(this.f13695a, this.f13696b, this.f13697c, (Cursor) obj);
    }
}
