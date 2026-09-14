package A1;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.firebase.database.connection.PersistentConnectionImpl;
import org.apache.tika.mime.MimeTypesReaderMetKeys;

/* loaded from: classes.dex */
public final /* synthetic */ class g implements j, OnFailureListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ long f41a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f42b;

    public /* synthetic */ g(long j2, t1.k kVar) {
        this.f41a = j2;
        this.f42b = kVar;
    }

    @Override // A1.j
    public Object apply(Object obj) {
        t1.k kVar = (t1.k) this.f42b;
        SQLiteDatabase sQLiteDatabase = (SQLiteDatabase) obj;
        ContentValues contentValues = new ContentValues();
        contentValues.put("next_request_ms", Long.valueOf(this.f41a));
        String str = kVar.f6431a;
        q1.d dVar = kVar.f6433c;
        if (sQLiteDatabase.update("transport_contexts", contentValues, "backend_name = ? and priority = ?", new String[]{str, String.valueOf(D1.a.a(dVar))}) < 1) {
            contentValues.put("backend_name", kVar.f6431a);
            contentValues.put(MimeTypesReaderMetKeys.MAGIC_PRIORITY_ATTR, Integer.valueOf(D1.a.a(dVar)));
            sQLiteDatabase.insert("transport_contexts", null, contentValues);
        }
        return null;
    }

    @Override // com.google.android.gms.tasks.OnFailureListener
    public void onFailure(Exception exc) {
        PersistentConnectionImpl.e((PersistentConnectionImpl) this.f42b, this.f41a, exc);
    }

    public /* synthetic */ g(PersistentConnectionImpl persistentConnectionImpl, long j2) {
        this.f42b = persistentConnectionImpl;
        this.f41a = j2;
    }
}
