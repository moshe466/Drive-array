package r1;

import android.database.sqlite.SQLiteDatabase;
import r1.b0;

/* loaded from: classes.dex */
final /* synthetic */ class m implements b0.b {

    /* renamed from: a, reason: collision with root package name */
    private final long f13694a;

    private m(long j10) {
        this.f13694a = j10;
    }

    public static b0.b a(long j10) {
        return new m(j10);
    }

    @Override // r1.b0.b
    public Object apply(Object obj) {
        Integer valueOf;
        valueOf = Integer.valueOf(((SQLiteDatabase) obj).delete("events", "timestamp_ms < ?", new String[]{String.valueOf(this.f13694a)}));
        return valueOf;
    }
}
