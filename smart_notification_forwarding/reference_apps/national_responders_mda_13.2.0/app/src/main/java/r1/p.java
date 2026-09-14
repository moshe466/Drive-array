package r1;

import android.database.Cursor;
import java.util.Map;
import r1.b0;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final /* synthetic */ class p implements b0.b {

    /* renamed from: a, reason: collision with root package name */
    private final Map f13699a;

    private p(Map map) {
        this.f13699a = map;
    }

    public static b0.b a(Map map) {
        return new p(map);
    }

    @Override // r1.b0.b
    public Object apply(Object obj) {
        return b0.k0(this.f13699a, (Cursor) obj);
    }
}
