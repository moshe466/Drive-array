package r1;

import android.database.sqlite.SQLiteDatabase;
import r1.b0;

/* loaded from: classes.dex */
final /* synthetic */ class y implements b0.b {

    /* renamed from: a, reason: collision with root package name */
    private final String f13710a;

    private y(String str) {
        this.f13710a = str;
    }

    public static b0.b a(String str) {
        return new y(str);
    }

    @Override // r1.b0.b
    public Object apply(Object obj) {
        return b0.n0(this.f13710a, (SQLiteDatabase) obj);
    }
}
