package r1;

import android.database.Cursor;
import r1.b0;

/* loaded from: classes.dex */
final /* synthetic */ class z implements b0.b {

    /* renamed from: a, reason: collision with root package name */
    private static final z f13711a = new z();

    private z() {
    }

    public static b0.b a() {
        return f13711a;
    }

    @Override // r1.b0.b
    public Object apply(Object obj) {
        Long valueOf;
        valueOf = Long.valueOf(r2.moveToNext() ? ((Cursor) obj).getLong(0) : 0L);
        return valueOf;
    }
}
