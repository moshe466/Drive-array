package w6;

import android.database.Cursor;

/* loaded from: classes.dex */
public class p {

    /* renamed from: a, reason: collision with root package name */
    public String f15235a;

    /* renamed from: b, reason: collision with root package name */
    public String f15236b;

    /* renamed from: c, reason: collision with root package name */
    public String f15237c;

    /* renamed from: d, reason: collision with root package name */
    public String f15238d;

    /* renamed from: e, reason: collision with root package name */
    public int f15239e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f15240f;

    /* renamed from: g, reason: collision with root package name */
    public Integer f15241g;

    public static p a(Cursor cursor) {
        q qVar = new q();
        qVar.f15235a = cursor.getString(cursor.getColumnIndex("id"));
        qVar.f15238d = cursor.getString(cursor.getColumnIndex("description"));
        qVar.f15236b = cursor.getString(cursor.getColumnIndex("name"));
        qVar.f15237c = cursor.getString(cursor.getColumnIndex("userName"));
        return qVar;
    }

    public p b(v7.c cVar) {
        this.f15235a = cVar.o();
        this.f15236b = cVar.r();
        this.f15237c = cVar.s();
        this.f15238d = cVar.n();
        return this;
    }

    public String toString() {
        String str = this.f15238d;
        if (str != null && str.length() > 0) {
            return this.f15238d;
        }
        String str2 = this.f15237c;
        if (str2 != null && str2.length() > 0) {
            return this.f15237c;
        }
        String str3 = this.f15236b;
        return (str3 == null || str3.length() <= 0) ? this.f15235a : this.f15236b;
    }
}
