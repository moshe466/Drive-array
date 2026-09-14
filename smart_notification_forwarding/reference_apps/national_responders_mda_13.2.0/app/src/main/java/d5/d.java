package d5;

import a5.d;
import com.google.gson.y;
import java.sql.Timestamp;
import java.util.Date;

/* loaded from: classes.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public static final boolean f8664a;

    /* renamed from: b, reason: collision with root package name */
    public static final d.b<? extends Date> f8665b;

    /* renamed from: c, reason: collision with root package name */
    public static final d.b<? extends Date> f8666c;

    /* renamed from: d, reason: collision with root package name */
    public static final y f8667d;

    /* renamed from: e, reason: collision with root package name */
    public static final y f8668e;

    /* renamed from: f, reason: collision with root package name */
    public static final y f8669f;

    /* loaded from: classes.dex */
    class a extends d.b<java.sql.Date> {
        a(Class cls) {
            super(cls);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // a5.d.b
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public java.sql.Date d(Date date) {
            return new java.sql.Date(date.getTime());
        }
    }

    /* loaded from: classes.dex */
    class b extends d.b<Timestamp> {
        b(Class cls) {
            super(cls);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // a5.d.b
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public Timestamp d(Date date) {
            return new Timestamp(date.getTime());
        }
    }

    static {
        boolean z10;
        y yVar;
        try {
            Class.forName("java.sql.Date");
            z10 = true;
        } catch (ClassNotFoundException unused) {
            z10 = false;
        }
        f8664a = z10;
        if (z10) {
            f8665b = new a(java.sql.Date.class);
            f8666c = new b(Timestamp.class);
            f8667d = d5.a.f8658b;
            f8668e = d5.b.f8660b;
            yVar = c.f8662b;
        } else {
            yVar = null;
            f8665b = null;
            f8666c = null;
            f8667d = null;
            f8668e = null;
        }
        f8669f = yVar;
    }
}
