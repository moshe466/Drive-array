package A1;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabaseLockedException;
import android.os.SystemClock;
import android.util.Base64;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Objects;
import q1.C0622c;
import r2.InterfaceC0645a;
import w1.EnumC0755c;

/* loaded from: classes.dex */
public final class l implements d, B1.b, c {

    /* renamed from: f, reason: collision with root package name */
    public static final C0622c f52f = new C0622c("proto");

    /* renamed from: a, reason: collision with root package name */
    public final o f53a;

    /* renamed from: b, reason: collision with root package name */
    public final A.n f54b;

    /* renamed from: c, reason: collision with root package name */
    public final A.n f55c;

    /* renamed from: d, reason: collision with root package name */
    public final a f56d;

    /* renamed from: e, reason: collision with root package name */
    public final InterfaceC0645a f57e;

    public l(A.n nVar, A.n nVar2, a aVar, o oVar, InterfaceC0645a interfaceC0645a) {
        this.f53a = oVar;
        this.f54b = nVar;
        this.f55c = nVar2;
        this.f56d = aVar;
        this.f57e = interfaceC0645a;
    }

    public static Long b(SQLiteDatabase sQLiteDatabase, t1.k kVar) {
        Long valueOf;
        StringBuilder sb = new StringBuilder("backend_name = ? and priority = ?");
        ArrayList arrayList = new ArrayList(Arrays.asList(kVar.f6431a, String.valueOf(D1.a.a(kVar.f6433c))));
        byte[] bArr = kVar.f6432b;
        if (bArr != null) {
            sb.append(" and extras = ?");
            arrayList.add(Base64.encodeToString(bArr, 0));
        } else {
            sb.append(" and extras is null");
        }
        Cursor query = sQLiteDatabase.query("transport_contexts", new String[]{"_id"}, sb.toString(), (String[]) arrayList.toArray(new String[0]), null, null, null);
        try {
            if (!query.moveToNext()) {
                valueOf = null;
            } else {
                valueOf = Long.valueOf(query.getLong(0));
            }
            return valueOf;
        } finally {
            query.close();
        }
    }

    public static String g(Iterable iterable) {
        StringBuilder sb = new StringBuilder("(");
        Iterator it = iterable.iterator();
        while (it.hasNext()) {
            sb.append(((b) it.next()).f33a);
            if (it.hasNext()) {
                sb.append(',');
            }
        }
        sb.append(')');
        return sb.toString();
    }

    public static Object h(Cursor cursor, j jVar) {
        try {
            return jVar.apply(cursor);
        } finally {
            cursor.close();
        }
    }

    public final SQLiteDatabase a() {
        o oVar = this.f53a;
        Objects.requireNonNull(oVar);
        A.n nVar = this.f55c;
        long d2 = nVar.d();
        while (true) {
            try {
                return oVar.getWritableDatabase();
            } catch (SQLiteDatabaseLockedException e4) {
                if (nVar.d() < this.f56d.f30c + d2) {
                    SystemClock.sleep(50L);
                } else {
                    throw new RuntimeException("Timed out while trying to open db.", e4);
                }
            }
        }
    }

    public final Object c(j jVar) {
        SQLiteDatabase a2 = a();
        a2.beginTransaction();
        try {
            Object apply = jVar.apply(a2);
            a2.setTransactionSuccessful();
            return apply;
        } finally {
            a2.endTransaction();
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        this.f53a.close();
    }

    public final ArrayList d(SQLiteDatabase sQLiteDatabase, t1.k kVar, int i) {
        ArrayList arrayList = new ArrayList();
        Long b4 = b(sQLiteDatabase, kVar);
        if (b4 == null) {
            return arrayList;
        }
        h(sQLiteDatabase.query("events", new String[]{"_id", "transport_name", "timestamp_ms", "uptime_ms", "payload_encoding", "payload", "code", "inline", "product_id", "pseudonymous_id", "experiment_ids_clear_blob", "experiment_ids_encrypted_blob"}, "context_id = ?", new String[]{b4.toString()}, null, null, null, String.valueOf(i)), new i(this, arrayList, kVar, 0));
        return arrayList;
    }

    public final void e(long j2, EnumC0755c enumC0755c, String str) {
        c(new h(str, j2, enumC0755c));
    }

    public final Object f(B1.a aVar) {
        SQLiteDatabase a2 = a();
        A.n nVar = this.f55c;
        long d2 = nVar.d();
        while (true) {
            try {
                a2.beginTransaction();
                try {
                    Object a4 = aVar.a();
                    a2.setTransactionSuccessful();
                    return a4;
                } finally {
                    a2.endTransaction();
                }
            } catch (SQLiteDatabaseLockedException e4) {
                if (nVar.d() < this.f56d.f30c + d2) {
                    SystemClock.sleep(50L);
                } else {
                    throw new RuntimeException("Timed out while trying to acquire the lock.", e4);
                }
            }
        }
    }
}
