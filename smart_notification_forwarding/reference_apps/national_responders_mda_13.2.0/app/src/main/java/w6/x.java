package w6;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.ArrayList;
import java.util.Date;

/* loaded from: classes.dex */
public class x extends SQLiteOpenHelper {

    /* renamed from: v, reason: collision with root package name */
    private static x f15265v;

    /* renamed from: w, reason: collision with root package name */
    private static SQLiteDatabase f15266w;

    /* renamed from: x, reason: collision with root package name */
    private static SQLiteDatabase f15267x;

    /* renamed from: f, reason: collision with root package name */
    public String f15268f;

    /* renamed from: g, reason: collision with root package name */
    public String f15269g;

    /* renamed from: h, reason: collision with root package name */
    public String f15270h;

    /* renamed from: i, reason: collision with root package name */
    public String f15271i;

    /* renamed from: j, reason: collision with root package name */
    public String f15272j;

    /* renamed from: k, reason: collision with root package name */
    public String f15273k;

    /* renamed from: l, reason: collision with root package name */
    public String f15274l;

    /* renamed from: m, reason: collision with root package name */
    public String f15275m;

    /* renamed from: n, reason: collision with root package name */
    public String f15276n;

    /* renamed from: o, reason: collision with root package name */
    public String f15277o;

    /* renamed from: p, reason: collision with root package name */
    public String f15278p;

    /* renamed from: q, reason: collision with root package name */
    public String f15279q;

    /* renamed from: r, reason: collision with root package name */
    public String f15280r;

    /* renamed from: s, reason: collision with root package name */
    public String f15281s;

    /* renamed from: t, reason: collision with root package name */
    public String f15282t;

    /* renamed from: u, reason: collision with root package name */
    public String f15283u;

    /* loaded from: classes.dex */
    class a implements Runnable {

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ q f15284f;

        a(q qVar) {
            this.f15284f = qVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            String str = x.this.f15268f;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("addCallToLog:");
            sb2.append(this.f15284f.f15235a);
            String format = String.format(x.this.f15273k, this.f15284f.f15235a);
            try {
                x.this.g(format);
            } catch (Exception unused) {
                String str2 = x.this.f15268f;
                StringBuilder sb3 = new StringBuilder();
                sb3.append("addCallToLog contact id:");
                sb3.append(this.f15284f.f15235a);
            }
            try {
                StringBuilder sb4 = new StringBuilder();
                sb4.append(" ");
                String str3 = x.this.f15272j;
                Object[] objArr = new Object[11];
                q qVar = this.f15284f;
                objArr[0] = qVar.f15235a;
                objArr[1] = qVar.f15238d.replace("'", ".");
                q qVar2 = this.f15284f;
                objArr[2] = qVar2.f15236b;
                objArr[3] = qVar2.f15237c.replace("'", ".");
                objArr[4] = Integer.valueOf(this.f15284f.f15244h);
                objArr[5] = Long.valueOf(this.f15284f.f15245i.getTime());
                objArr[6] = Integer.valueOf(this.f15284f.f15246j);
                Date date = this.f15284f.f15247k;
                objArr[7] = Long.valueOf(date != null ? date.getTime() : 0L);
                objArr[8] = Integer.valueOf(this.f15284f.f15248l);
                objArr[9] = Integer.valueOf(this.f15284f.f15249m);
                objArr[10] = this.f15284f.f15250n;
                sb4.append(String.format(str3, objArr));
                format = sb4.toString();
                x.this.g(format);
            } catch (Exception unused2) {
                String str4 = x.this.f15268f;
                StringBuilder sb5 = new StringBuilder();
                sb5.append("addCallToLog failed. sql:");
                sb5.append(format);
            }
        }
    }

    /* loaded from: classes.dex */
    class b implements Runnable {

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ p f15286f;

        b(p pVar) {
            this.f15286f = pVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            String str = x.this.f15268f;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("addFavorites:");
            sb2.append(this.f15286f.f15235a);
            try {
                x.this.g(String.format(x.this.f15278p, this.f15286f.f15235a));
            } catch (Exception unused) {
                String str2 = x.this.f15268f;
                StringBuilder sb3 = new StringBuilder();
                sb3.append("removeFavorites before add contact id:");
                sb3.append(this.f15286f.f15235a);
            }
            try {
                StringBuilder sb4 = new StringBuilder();
                sb4.append(" ");
                String str3 = x.this.f15277o;
                p pVar = this.f15286f;
                p pVar2 = this.f15286f;
                sb4.append(String.format(str3, pVar.f15235a, pVar.f15238d.replace("'", "."), pVar2.f15236b, pVar2.f15237c.replace("'", ".")));
                x.this.g(sb4.toString());
            } catch (Exception unused2) {
                String str4 = x.this.f15268f;
                StringBuilder sb5 = new StringBuilder();
                sb5.append("addFavorites contact id:");
                sb5.append(this.f15286f.f15235a);
            }
        }
    }

    /* loaded from: classes.dex */
    class c implements Runnable {

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ p f15288f;

        c(p pVar) {
            this.f15288f = pVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            String str = x.this.f15268f;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("removeFavorites:");
            sb2.append(this.f15288f.f15235a);
            try {
                x.this.g(String.format(x.this.f15278p, this.f15288f.f15235a));
            } catch (Exception unused) {
                String str2 = x.this.f15268f;
                StringBuilder sb3 = new StringBuilder();
                sb3.append("removeFavorites contact id:");
                sb3.append(this.f15288f.f15235a);
            }
        }
    }

    /* loaded from: classes.dex */
    class d implements Runnable {

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ v f15290f;

        d(v vVar) {
            this.f15290f = vVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            String str = x.this.f15268f;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("add contactVolumeModes:");
            sb2.append(this.f15290f.f15263a);
            try {
                StringBuilder sb3 = new StringBuilder();
                sb3.append(" ");
                sb3.append(String.format(x.this.f15282t, this.f15290f.f15263a, this.f15290f.d() + ""));
                x.this.g(sb3.toString());
            } catch (Exception unused) {
                String str2 = x.this.f15268f;
                StringBuilder sb4 = new StringBuilder();
                sb4.append("add contactVolumeModes contact id:");
                sb4.append(this.f15290f.f15263a);
            }
        }
    }

    /* loaded from: classes.dex */
    class e implements Runnable {

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ String f15292f;

        e(String str) {
            this.f15292f = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            String str = x.this.f15268f;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("removecontactVolumeModes:");
            sb2.append(this.f15292f);
            try {
                x.this.g(String.format(x.this.f15283u, this.f15292f));
            } catch (Exception unused) {
                String str2 = x.this.f15268f;
                StringBuilder sb3 = new StringBuilder();
                sb3.append("removecontactVolumeModes contact id:");
                sb3.append(this.f15292f);
            }
        }
    }

    public x(Context context) {
        super(context, "mdaDB", (SQLiteDatabase.CursorFactory) null, 9);
        this.f15268f = "SQLLiteManager";
        this.f15269g = "drop table if exists callLog;";
        this.f15270h = "CREATE TABLE IF NOT EXISTS callLog (_id integer primary key autoincrement,id TEXT, description TEXT,name TEXT,userName TEXT,lastTransaction int, lastDate long,counter int,callCompleted long, heard int,destCount int,lastMessageId TEXT)";
        this.f15271i = "select * from callLog order by lastDate desc";
        this.f15272j = "INSERT into callLog (id,description,name,userName,lastTransaction,lastDate,counter,callCompleted, heard,destCount,lastMessageId) values('%s','%s','%s','%s',%s,'%s',%s,%s,%s,%s,'%s')";
        this.f15273k = "delete from callLog where id = '%s'";
        this.f15274l = "drop table if exists favorites;";
        this.f15275m = "CREATE TABLE IF NOT EXISTS favorites (_id integer primary key autoincrement,id TEXT, description TEXT,name TEXT,userName TEXT)";
        this.f15276n = "select * from favorites";
        this.f15277o = "INSERT into favorites (id,description,name,userName) values('%s','%s','%s','%s')";
        this.f15278p = "delete from favorites where id = '%s'";
        this.f15279q = "drop table if exists contactVolumeModes;";
        this.f15280r = "CREATE TABLE IF NOT EXISTS contactVolumeModes (_id integer primary key autoincrement,id TEXT, mode INTEGER)";
        this.f15281s = "select * from contactVolumeModes";
        this.f15282t = "INSERT into contactVolumeModes (id,mode) values('%s',%s)";
        this.f15283u = "delete from contactVolumeModes where id = '%s'";
        onCreate(O());
        N();
    }

    public static x H() {
        return f15265v;
    }

    public static x M(Context context) {
        if (f15265v == null) {
            f15265v = new x(context);
        }
        return f15265v;
    }

    private SQLiteDatabase N() {
        SQLiteDatabase sQLiteDatabase = f15266w;
        if (sQLiteDatabase == null || !sQLiteDatabase.isOpen()) {
            f15266w = getReadableDatabase();
        }
        return f15266w;
    }

    private SQLiteDatabase O() {
        SQLiteDatabase sQLiteDatabase = f15267x;
        if (sQLiteDatabase == null || !sQLiteDatabase.isOpen()) {
            f15267x = getWritableDatabase();
        }
        return f15267x;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(String str) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("execSQL:");
        sb2.append(str);
        O().execSQL(str);
    }

    public ArrayList<q> D() {
        Cursor cursor;
        Throwable th;
        try {
            cursor = N().rawQuery(this.f15271i, null);
            if (cursor != null) {
                try {
                    if (cursor.getCount() != 0) {
                        ArrayList<q> arrayList = new ArrayList<>();
                        while (cursor.moveToNext()) {
                            arrayList.add(q.c(cursor));
                        }
                        cursor.close();
                        return arrayList;
                    }
                } catch (Exception unused) {
                    if (cursor != null) {
                        cursor.close();
                    }
                    return null;
                } catch (Throwable th2) {
                    th = th2;
                    if (cursor != null) {
                        cursor.close();
                    }
                    throw th;
                }
            }
            ArrayList<q> arrayList2 = new ArrayList<>();
            if (cursor != null) {
                cursor.close();
            }
            return arrayList2;
        } catch (Exception unused2) {
            cursor = null;
        } catch (Throwable th3) {
            cursor = null;
            th = th3;
        }
    }

    public void a0(String str) {
        new Thread(new e(str)).start();
    }

    public void b0(p pVar) {
        new Thread(new c(pVar)).start();
    }

    public void c0(p pVar) {
        new Thread(new b(pVar)).start();
    }

    public void d(q qVar) {
        new Thread(new a(qVar)).start();
    }

    public void f(v vVar) {
        new Thread(new d(vVar)).start();
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0039, code lost:
    
        if (0 != 0) goto L20;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.util.ArrayList<w6.v> j() {
        /*
            r4 = this;
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            r1 = 0
            android.database.sqlite.SQLiteDatabase r2 = r4.N()     // Catch: java.lang.Throwable -> L32 java.lang.Exception -> L39
            java.lang.String r3 = r4.f15281s     // Catch: java.lang.Throwable -> L32 java.lang.Exception -> L39
            android.database.Cursor r1 = r2.rawQuery(r3, r1)     // Catch: java.lang.Throwable -> L32 java.lang.Exception -> L39
            if (r1 == 0) goto L27
            int r2 = r1.getCount()     // Catch: java.lang.Throwable -> L32 java.lang.Exception -> L39
            if (r2 != 0) goto L19
            goto L27
        L19:
            boolean r2 = r1.moveToNext()     // Catch: java.lang.Throwable -> L32 java.lang.Exception -> L39
            if (r2 == 0) goto L3b
            w6.v r2 = w6.v.a(r1)     // Catch: java.lang.Throwable -> L32 java.lang.Exception -> L39
            r0.add(r2)     // Catch: java.lang.Throwable -> L32 java.lang.Exception -> L39
            goto L19
        L27:
            java.util.ArrayList r2 = new java.util.ArrayList     // Catch: java.lang.Throwable -> L32 java.lang.Exception -> L39
            r2.<init>()     // Catch: java.lang.Throwable -> L32 java.lang.Exception -> L39
            if (r1 == 0) goto L31
            r1.close()
        L31:
            return r2
        L32:
            r0 = move-exception
            if (r1 == 0) goto L38
            r1.close()
        L38:
            throw r0
        L39:
            if (r1 == 0) goto L3e
        L3b:
            r1.close()
        L3e:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: w6.x.j():java.util.ArrayList");
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        try {
            sQLiteDatabase.execSQL(this.f15270h);
        } catch (Exception unused) {
        }
        try {
            sQLiteDatabase.execSQL(this.f15275m);
        } catch (Exception unused2) {
        }
        try {
            sQLiteDatabase.execSQL(this.f15280r);
        } catch (Exception unused3) {
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i10, int i11) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("onUpgrade ");
        sb2.append(i10);
        sb2.append(",");
        sb2.append(i11);
        if (i10 == 8 && i11 == 9) {
            try {
                sQLiteDatabase.execSQL("ALTER TABLE callLog ADD COLUMN heard int");
                sQLiteDatabase.execSQL("ALTER TABLE callLog ADD COLUMN callCompleted long");
                sQLiteDatabase.execSQL("ALTER TABLE callLog ADD COLUMN destCount int");
                sQLiteDatabase.execSQL("ALTER TABLE callLog ADD COLUMN lastMessageId TEXT");
                return;
            } catch (Exception unused) {
                return;
            }
        }
        try {
            sQLiteDatabase.execSQL(this.f15269g);
        } catch (Exception unused2) {
        }
        try {
            sQLiteDatabase.execSQL(this.f15270h);
        } catch (Exception unused3) {
        }
        try {
            sQLiteDatabase.execSQL(this.f15274l);
        } catch (Exception unused4) {
        }
        try {
            sQLiteDatabase.execSQL(this.f15275m);
        } catch (Exception unused5) {
        }
        try {
            sQLiteDatabase.execSQL(this.f15279q);
        } catch (Exception unused6) {
        }
        try {
            sQLiteDatabase.execSQL(this.f15280r);
        } catch (Exception unused7) {
        }
    }

    public r v() {
        Cursor cursor;
        Throwable th;
        try {
            cursor = N().rawQuery(this.f15276n, null);
            if (cursor != null) {
                try {
                    if (cursor.getCount() != 0) {
                        r rVar = new r();
                        while (cursor.moveToNext()) {
                            rVar.add(p.a(cursor));
                        }
                        cursor.close();
                        return rVar;
                    }
                } catch (Exception unused) {
                    if (cursor != null) {
                        cursor.close();
                    }
                    return null;
                } catch (Throwable th2) {
                    th = th2;
                    if (cursor != null) {
                        cursor.close();
                    }
                    throw th;
                }
            }
            r rVar2 = new r();
            if (cursor != null) {
                cursor.close();
            }
            return rVar2;
        } catch (Exception unused2) {
            cursor = null;
        } catch (Throwable th3) {
            cursor = null;
            th = th3;
        }
    }
}
