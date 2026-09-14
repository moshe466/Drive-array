package w6;

import android.database.Cursor;
import java.util.Date;

/* loaded from: classes.dex */
public class q extends p {

    /* renamed from: o, reason: collision with root package name */
    public static int f15242o = 1;

    /* renamed from: p, reason: collision with root package name */
    public static int f15243p = 2;

    /* renamed from: h, reason: collision with root package name */
    public int f15244h;

    /* renamed from: i, reason: collision with root package name */
    public Date f15245i;

    /* renamed from: j, reason: collision with root package name */
    public int f15246j;

    /* renamed from: k, reason: collision with root package name */
    public Date f15247k;

    /* renamed from: l, reason: collision with root package name */
    public int f15248l;

    /* renamed from: m, reason: collision with root package name */
    public int f15249m;

    /* renamed from: n, reason: collision with root package name */
    public String f15250n;

    public static q c(Cursor cursor) {
        q qVar = new q();
        qVar.f15235a = cursor.getString(cursor.getColumnIndex("id"));
        if (cursor.getColumnIndex("counter") > 0) {
            qVar.f15246j = cursor.getInt(cursor.getColumnIndex("counter"));
        }
        qVar.f15238d = cursor.getString(cursor.getColumnIndex("description"));
        qVar.f15236b = cursor.getString(cursor.getColumnIndex("name"));
        qVar.f15237c = cursor.getString(cursor.getColumnIndex("userName"));
        qVar.f15244h = cursor.getInt(cursor.getColumnIndex("lastTransaction"));
        qVar.f15245i = new Date(cursor.getLong(cursor.getColumnIndex("lastDate")));
        if (cursor.getColumnIndex("callCompleted") > -1) {
            long j10 = cursor.getLong(cursor.getColumnIndex("callCompleted"));
            if (j10 > 0) {
                qVar.f15247k = new Date(j10);
            }
        }
        if (cursor.getColumnIndex("heard") > -1) {
            qVar.f15248l = cursor.getInt(cursor.getColumnIndex("heard"));
        }
        if (cursor.getColumnIndex("destCount") > -1) {
            qVar.f15249m = cursor.getInt(cursor.getColumnIndex("destCount"));
        }
        if (cursor.getColumnIndex("lastMessageId") > -1) {
            qVar.f15250n = cursor.getString(cursor.getColumnIndex("lastMessageId"));
        }
        return qVar;
    }
}
