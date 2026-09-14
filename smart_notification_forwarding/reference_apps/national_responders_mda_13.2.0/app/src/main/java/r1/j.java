package r1;

import android.database.sqlite.SQLiteDatabase;
import r1.b0;

/* loaded from: classes.dex */
final /* synthetic */ class j implements b0.b {

    /* renamed from: a, reason: collision with root package name */
    private final long f13689a;

    /* renamed from: b, reason: collision with root package name */
    private final k1.m f13690b;

    private j(long j10, k1.m mVar) {
        this.f13689a = j10;
        this.f13690b = mVar;
    }

    public static b0.b a(long j10, k1.m mVar) {
        return new j(j10, mVar);
    }

    @Override // r1.b0.b
    public Object apply(Object obj) {
        return b0.o0(this.f13689a, this.f13690b, (SQLiteDatabase) obj);
    }
}
