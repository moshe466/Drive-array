package r1;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabaseLockedException;
import android.os.SystemClock;
import android.util.Base64;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;
import k1.h;
import s1.b;

/* loaded from: classes.dex */
public class b0 implements r1.c, s1.b {

    /* renamed from: j, reason: collision with root package name */
    private static final i1.b f13659j = i1.b.b("proto");

    /* renamed from: f, reason: collision with root package name */
    private final h0 f13660f;

    /* renamed from: g, reason: collision with root package name */
    private final t1.a f13661g;

    /* renamed from: h, reason: collision with root package name */
    private final t1.a f13662h;

    /* renamed from: i, reason: collision with root package name */
    private final r1.d f13663i;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface b<T, U> {
        U apply(T t10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class c {

        /* renamed from: a, reason: collision with root package name */
        final String f13664a;

        /* renamed from: b, reason: collision with root package name */
        final String f13665b;

        private c(String str, String str2) {
            this.f13664a = str;
            this.f13665b = str2;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface d<T> {
        T a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b0(t1.a aVar, t1.a aVar2, r1.d dVar, h0 h0Var) {
        this.f13660f = h0Var;
        this.f13661g = aVar;
        this.f13662h = aVar2;
        this.f13663i = dVar;
    }

    private Long D(SQLiteDatabase sQLiteDatabase, k1.m mVar) {
        StringBuilder sb2 = new StringBuilder("backend_name = ? and priority = ?");
        ArrayList arrayList = new ArrayList(Arrays.asList(mVar.b(), String.valueOf(u1.a.a(mVar.d()))));
        if (mVar.c() != null) {
            sb2.append(" and extras = ?");
            arrayList.add(Base64.encodeToString(mVar.c(), 0));
        }
        return (Long) w0(sQLiteDatabase.query("transport_contexts", new String[]{"_id"}, sb2.toString(), (String[]) arrayList.toArray(new String[0]), null, null, null), x.a());
    }

    private <T> T H(b<SQLiteDatabase, T> bVar) {
        SQLiteDatabase g10 = g();
        g10.beginTransaction();
        try {
            T apply = bVar.apply(g10);
            g10.setTransactionSuccessful();
            return apply;
        } finally {
            g10.endTransaction();
        }
    }

    private boolean M() {
        return j() * v() >= this.f13663i.f();
    }

    private List<i> N(List<i> list, Map<Long, Set<c>> map) {
        ListIterator<i> listIterator = list.listIterator();
        while (listIterator.hasNext()) {
            i next = listIterator.next();
            if (map.containsKey(Long.valueOf(next.c()))) {
                h.a l10 = next.b().l();
                for (c cVar : map.get(Long.valueOf(next.c()))) {
                    l10.c(cVar.f13664a, cVar.f13665b);
                }
                listIterator.set(i.a(next.c(), next.d(), l10.d()));
            }
        }
        return list;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Object a0(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.beginTransaction();
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Object b0(Throwable th) {
        throw new s1.a("Timed out while trying to acquire the lock.", th);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ SQLiteDatabase c0(Throwable th) {
        throw new s1.a("Timed out while trying to open db.", th);
    }

    private void d(SQLiteDatabase sQLiteDatabase) {
        t0(q.b(sQLiteDatabase), r.a());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Long e0(Cursor cursor) {
        if (cursor.moveToNext()) {
            return Long.valueOf(cursor.getLong(0));
        }
        return null;
    }

    private long f(SQLiteDatabase sQLiteDatabase, k1.m mVar) {
        Long D = D(sQLiteDatabase, mVar);
        if (D != null) {
            return D.longValue();
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("backend_name", mVar.b());
        contentValues.put("priority", Integer.valueOf(u1.a.a(mVar.d())));
        contentValues.put("next_request_ms", (Integer) 0);
        if (mVar.c() != null) {
            contentValues.put("extras", Base64.encodeToString(mVar.c(), 0));
        }
        return sQLiteDatabase.insert("transport_contexts", null, contentValues);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Boolean f0(b0 b0Var, k1.m mVar, SQLiteDatabase sQLiteDatabase) {
        Long D = b0Var.D(sQLiteDatabase, mVar);
        return D == null ? Boolean.FALSE : (Boolean) w0(b0Var.g().rawQuery("SELECT 1 FROM events WHERE context_id = ? LIMIT 1", new String[]{D.toString()}), u.a());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ List g0(Cursor cursor) {
        ArrayList arrayList = new ArrayList();
        while (cursor.moveToNext()) {
            arrayList.add(k1.m.a().b(cursor.getString(1)).d(u1.a.b(cursor.getInt(2))).c(r0(cursor.getString(3))).a());
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ List h0(SQLiteDatabase sQLiteDatabase) {
        return (List) w0(sQLiteDatabase.rawQuery("SELECT distinct t._id, t.backend_name, t.priority, t.extras FROM transport_contexts AS t, events AS e WHERE e.context_id = t._id", new String[0]), t.a());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ List i0(b0 b0Var, k1.m mVar, SQLiteDatabase sQLiteDatabase) {
        List<i> p02 = b0Var.p0(sQLiteDatabase, mVar);
        return b0Var.N(p02, b0Var.q0(sQLiteDatabase, p02));
    }

    private long j() {
        return g().compileStatement("PRAGMA page_count").simpleQueryForLong();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Object j0(b0 b0Var, List list, k1.m mVar, Cursor cursor) {
        while (cursor.moveToNext()) {
            long j10 = cursor.getLong(0);
            boolean z10 = cursor.getInt(7) != 0;
            h.a k10 = k1.h.a().j(cursor.getString(1)).i(cursor.getLong(2)).k(cursor.getLong(3));
            k10.h(z10 ? new k1.g(u0(cursor.getString(4)), cursor.getBlob(5)) : new k1.g(u0(cursor.getString(4)), b0Var.s0(j10)));
            if (!cursor.isNull(6)) {
                k10.g(Integer.valueOf(cursor.getInt(6)));
            }
            list.add(i.a(j10, mVar, k10.d()));
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Object k0(Map map, Cursor cursor) {
        while (true) {
            if (!cursor.moveToNext()) {
                return null;
            }
            long j10 = cursor.getLong(0);
            Set set = (Set) map.get(Long.valueOf(j10));
            if (set == null) {
                set = new HashSet();
                map.put(Long.valueOf(j10), set);
            }
            set.add(new c(cursor.getString(1), cursor.getString(2)));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Long l0(b0 b0Var, k1.m mVar, k1.h hVar, SQLiteDatabase sQLiteDatabase) {
        if (b0Var.M()) {
            return -1L;
        }
        long f10 = b0Var.f(sQLiteDatabase, mVar);
        int e10 = b0Var.f13663i.e();
        byte[] a10 = hVar.e().a();
        boolean z10 = a10.length <= e10;
        ContentValues contentValues = new ContentValues();
        contentValues.put("context_id", Long.valueOf(f10));
        contentValues.put("transport_name", hVar.j());
        contentValues.put("timestamp_ms", Long.valueOf(hVar.f()));
        contentValues.put("uptime_ms", Long.valueOf(hVar.k()));
        contentValues.put("payload_encoding", hVar.e().b().a());
        contentValues.put("code", hVar.d());
        contentValues.put("num_attempts", (Integer) 0);
        contentValues.put("inline", Boolean.valueOf(z10));
        contentValues.put("payload", z10 ? a10 : new byte[0]);
        long insert = sQLiteDatabase.insert("events", null, contentValues);
        if (!z10) {
            int ceil = (int) Math.ceil(a10.length / e10);
            for (int i10 = 1; i10 <= ceil; i10++) {
                byte[] copyOfRange = Arrays.copyOfRange(a10, (i10 - 1) * e10, Math.min(i10 * e10, a10.length));
                ContentValues contentValues2 = new ContentValues();
                contentValues2.put("event_id", Long.valueOf(insert));
                contentValues2.put("sequence_num", Integer.valueOf(i10));
                contentValues2.put("bytes", copyOfRange);
                sQLiteDatabase.insert("event_payloads", null, contentValues2);
            }
        }
        for (Map.Entry<String, String> entry : hVar.i().entrySet()) {
            ContentValues contentValues3 = new ContentValues();
            contentValues3.put("event_id", Long.valueOf(insert));
            contentValues3.put("name", entry.getKey());
            contentValues3.put("value", entry.getValue());
            sQLiteDatabase.insert("event_metadata", null, contentValues3);
        }
        return Long.valueOf(insert);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ byte[] m0(Cursor cursor) {
        ArrayList arrayList = new ArrayList();
        int i10 = 0;
        while (cursor.moveToNext()) {
            byte[] blob = cursor.getBlob(0);
            arrayList.add(blob);
            i10 += blob.length;
        }
        byte[] bArr = new byte[i10];
        int i11 = 0;
        for (int i12 = 0; i12 < arrayList.size(); i12++) {
            byte[] bArr2 = (byte[]) arrayList.get(i12);
            System.arraycopy(bArr2, 0, bArr, i11, bArr2.length);
            i11 += bArr2.length;
        }
        return bArr;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Object n0(String str, SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.compileStatement(str).execute();
        sQLiteDatabase.compileStatement("DELETE FROM events WHERE num_attempts >= 16").execute();
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Object o0(long j10, k1.m mVar, SQLiteDatabase sQLiteDatabase) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("next_request_ms", Long.valueOf(j10));
        if (sQLiteDatabase.update("transport_contexts", contentValues, "backend_name = ? and priority = ?", new String[]{mVar.b(), String.valueOf(u1.a.a(mVar.d()))}) < 1) {
            contentValues.put("backend_name", mVar.b());
            contentValues.put("priority", Integer.valueOf(u1.a.a(mVar.d())));
            sQLiteDatabase.insert("transport_contexts", null, contentValues);
        }
        return null;
    }

    private List<i> p0(SQLiteDatabase sQLiteDatabase, k1.m mVar) {
        ArrayList arrayList = new ArrayList();
        Long D = D(sQLiteDatabase, mVar);
        if (D == null) {
            return arrayList;
        }
        w0(sQLiteDatabase.query("events", new String[]{"_id", "transport_name", "timestamp_ms", "uptime_ms", "payload_encoding", "payload", "code", "inline"}, "context_id = ?", new String[]{D.toString()}, null, null, null, String.valueOf(this.f13663i.d())), n.a(this, arrayList, mVar));
        return arrayList;
    }

    private Map<Long, Set<c>> q0(SQLiteDatabase sQLiteDatabase, List<i> list) {
        HashMap hashMap = new HashMap();
        StringBuilder sb2 = new StringBuilder("event_id IN (");
        for (int i10 = 0; i10 < list.size(); i10++) {
            sb2.append(list.get(i10).c());
            if (i10 < list.size() - 1) {
                sb2.append(',');
            }
        }
        sb2.append(')');
        w0(sQLiteDatabase.query("event_metadata", new String[]{"event_id", "name", "value"}, sb2.toString(), null, null, null, null), p.a(hashMap));
        return hashMap;
    }

    private static byte[] r0(String str) {
        if (str == null) {
            return null;
        }
        return Base64.decode(str, 0);
    }

    private byte[] s0(long j10) {
        return (byte[]) w0(g().query("event_payloads", new String[]{"bytes"}, "event_id = ?", new String[]{String.valueOf(j10)}, null, null, "sequence_num"), o.a());
    }

    private <T> T t0(d<T> dVar, b<Throwable, T> bVar) {
        long a10 = this.f13662h.a();
        while (true) {
            try {
                return dVar.a();
            } catch (SQLiteDatabaseLockedException e10) {
                if (this.f13662h.a() >= this.f13663i.b() + a10) {
                    return bVar.apply(e10);
                }
                SystemClock.sleep(50L);
            }
        }
    }

    private static i1.b u0(String str) {
        return str == null ? f13659j : i1.b.b(str);
    }

    private long v() {
        return g().compileStatement("PRAGMA page_size").simpleQueryForLong();
    }

    private static String v0(Iterable<i> iterable) {
        StringBuilder sb2 = new StringBuilder("(");
        Iterator<i> it = iterable.iterator();
        while (it.hasNext()) {
            sb2.append(it.next().c());
            if (it.hasNext()) {
                sb2.append(',');
            }
        }
        sb2.append(')');
        return sb2.toString();
    }

    private static <T> T w0(Cursor cursor, b<Cursor, T> bVar) {
        try {
            return bVar.apply(cursor);
        } finally {
            cursor.close();
        }
    }

    @Override // r1.c
    public Iterable<k1.m> C() {
        return (Iterable) H(l.a());
    }

    @Override // r1.c
    public boolean I(k1.m mVar) {
        return ((Boolean) H(a0.a(this, mVar))).booleanValue();
    }

    @Override // r1.c
    public void P(Iterable<i> iterable) {
        if (iterable.iterator().hasNext()) {
            H(y.a("UPDATE events SET num_attempts = num_attempts + 1 WHERE _id in " + v0(iterable)));
        }
    }

    @Override // r1.c
    public long Q(k1.m mVar) {
        return ((Long) w0(g().rawQuery("SELECT next_request_ms FROM transport_contexts WHERE backend_name = ? and priority = ?", new String[]{mVar.b(), String.valueOf(u1.a.a(mVar.d()))}), z.a())).longValue();
    }

    @Override // r1.c
    public void Y(k1.m mVar, long j10) {
        H(j.a(j10, mVar));
    }

    @Override // s1.b
    public <T> T c(b.a<T> aVar) {
        SQLiteDatabase g10 = g();
        d(g10);
        try {
            T f10 = aVar.f();
            g10.setTransactionSuccessful();
            return f10;
        } finally {
            g10.endTransaction();
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f13660f.close();
    }

    SQLiteDatabase g() {
        h0 h0Var = this.f13660f;
        h0Var.getClass();
        return (SQLiteDatabase) t0(s.b(h0Var), v.a());
    }

    @Override // r1.c
    public int i() {
        return ((Integer) H(m.a(this.f13661g.a() - this.f13663i.c()))).intValue();
    }

    @Override // r1.c
    public void m(Iterable<i> iterable) {
        if (iterable.iterator().hasNext()) {
            g().compileStatement("DELETE FROM events WHERE _id in " + v0(iterable)).execute();
        }
    }

    @Override // r1.c
    public i u(k1.m mVar, k1.h hVar) {
        n1.a.b("SQLiteEventStore", "Storing event with priority=%s, name=%s for destination %s", mVar.d(), hVar.j(), mVar.b());
        long longValue = ((Long) H(w.a(this, mVar, hVar))).longValue();
        if (longValue < 1) {
            return null;
        }
        return i.a(longValue, mVar, hVar);
    }

    @Override // r1.c
    public Iterable<i> w(k1.m mVar) {
        return (Iterable) H(k.a(this, mVar));
    }
}
