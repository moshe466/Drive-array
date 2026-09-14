package w6;

import android.database.Cursor;
import java.util.Date;

/* loaded from: classes.dex */
public class v {

    /* renamed from: a, reason: collision with root package name */
    public String f15263a;

    /* renamed from: b, reason: collision with root package name */
    public Date f15264b;

    public static v a(Cursor cursor) {
        v vVar = new v();
        vVar.f15263a = cursor.getString(cursor.getColumnIndex("id"));
        long j10 = cursor.getLong(cursor.getColumnIndex("mode"));
        if (j10 > 0) {
            vVar.f15264b = l0.z(j10);
        }
        return vVar;
    }

    public static v b(String str) {
        v vVar = new v();
        vVar.f15263a = str;
        return vVar;
    }

    public static v c(String str, int i10) {
        v vVar = new v();
        vVar.f15263a = str;
        vVar.f15264b = l0.f(new Date(), i10);
        return vVar;
    }

    public long d() {
        Date date = this.f15264b;
        if (date == null) {
            return 0L;
        }
        return date.getTime();
    }

    public boolean e() {
        if (this.f15264b == null) {
            return false;
        }
        return new Date().after(this.f15264b);
    }
}
