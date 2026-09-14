package A1;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import com.google.firebase.remoteconfig.internal.ConfigFetchHandler;
import io.flutter.plugins.firebase.crashlytics.Constants;
import java.util.HashMap;
import w1.EnumC0755c;

/* loaded from: classes.dex */
public final /* synthetic */ class h implements j, Continuation, B1.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ long f43a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f44b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f45c;

    public /* synthetic */ h(ConfigFetchHandler configFetchHandler, long j2, HashMap hashMap) {
        this.f44b = configFetchHandler;
        this.f43a = j2;
        this.f45c = hashMap;
    }

    @Override // B1.a
    public Object a() {
        z1.g gVar = (z1.g) this.f44b;
        t1.k kVar = (t1.k) this.f45c;
        d dVar = gVar.f6859c;
        long d2 = gVar.f6863g.d() + this.f43a;
        l lVar = (l) dVar;
        lVar.getClass();
        lVar.c(new g(d2, kVar));
        return null;
    }

    @Override // A1.j
    public Object apply(Object obj) {
        boolean z3;
        String str = (String) this.f44b;
        SQLiteDatabase sQLiteDatabase = (SQLiteDatabase) obj;
        int i = ((EnumC0755c) this.f45c).f6718a;
        Cursor rawQuery = sQLiteDatabase.rawQuery("SELECT 1 FROM log_event_dropped WHERE log_source = ? AND reason = ?", new String[]{str, Integer.toString(i)});
        try {
            if (rawQuery.getCount() > 0) {
                z3 = true;
            } else {
                z3 = false;
            }
            rawQuery.close();
            long j2 = this.f43a;
            if (!z3) {
                ContentValues contentValues = new ContentValues();
                contentValues.put("log_source", str);
                contentValues.put(Constants.REASON, Integer.valueOf(i));
                contentValues.put("events_dropped_count", Long.valueOf(j2));
                sQLiteDatabase.insert("log_event_dropped", null, contentValues);
                return null;
            }
            sQLiteDatabase.execSQL("UPDATE log_event_dropped SET events_dropped_count = events_dropped_count + " + j2 + " WHERE log_source = ? AND reason = ?", new String[]{str, Integer.toString(i)});
            return null;
        } catch (Throwable th) {
            rawQuery.close();
            throw th;
        }
    }

    @Override // com.google.android.gms.tasks.Continuation
    public Object then(Task task) {
        Task lambda$fetch$0;
        lambda$fetch$0 = ((ConfigFetchHandler) this.f44b).lambda$fetch$0(this.f43a, (HashMap) this.f45c, task);
        return lambda$fetch$0;
    }

    public /* synthetic */ h(Object obj, long j2, Object obj2) {
        this.f44b = obj;
        this.f45c = obj2;
        this.f43a = j2;
    }
}
