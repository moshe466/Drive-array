package p4;

import android.content.Context;
import android.content.SharedPreferences;
import java.text.SimpleDateFormat;
import java.util.Date;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g {

    /* renamed from: b, reason: collision with root package name */
    private static g f13058b;

    /* renamed from: c, reason: collision with root package name */
    private static final SimpleDateFormat f13059c = new SimpleDateFormat("dd/MM/yyyy z");

    /* renamed from: a, reason: collision with root package name */
    private final SharedPreferences f13060a;

    private g(Context context) {
        this.f13060a = context.getSharedPreferences("FirebaseAppHeartBeat", 0);
        context.getSharedPreferences("FirebaseAppHeartBeatStorage", 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static synchronized g a(Context context) {
        g gVar;
        synchronized (g.class) {
            if (f13058b == null) {
                f13058b = new g(context);
            }
            gVar = f13058b;
        }
        return gVar;
    }

    static boolean b(long j10, long j11) {
        Date date = new Date(j10);
        Date date2 = new Date(j11);
        SimpleDateFormat simpleDateFormat = f13059c;
        return !simpleDateFormat.format(date).equals(simpleDateFormat.format(date2));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized boolean c(long j10) {
        return d("fire-global", j10);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized boolean d(String str, long j10) {
        if (!this.f13060a.contains(str)) {
            this.f13060a.edit().putLong(str, j10).apply();
            return true;
        }
        if (!b(this.f13060a.getLong(str, -1L), j10)) {
            return false;
        }
        this.f13060a.edit().putLong(str, j10).apply();
        return true;
    }
}
