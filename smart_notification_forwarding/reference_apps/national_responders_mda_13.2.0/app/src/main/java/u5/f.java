package u5;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import y8.k;

/* loaded from: classes.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    public static final f f14390a = new f();

    private f() {
    }

    public final String a(s2.d dVar) {
        k.e(dVar, "activity");
        return "Transition: " + b(dVar.g()) + " (" + c(dVar.l()) + ")   " + ((Object) new SimpleDateFormat("HH:mm:ss", Locale.UK).format(new Date())) + "\n\n";
    }

    public final String b(int i10) {
        return i10 != 0 ? i10 != 1 ? i10 != 2 ? i10 != 3 ? i10 != 7 ? i10 != 8 ? "UNKNOWN" : "RUNNING" : "WALKING" : "STILL" : "ON_FOOT" : "ON_BICYCLE" : "IN_VEHICLE";
    }

    public final String c(int i10) {
        return i10 != 0 ? i10 != 1 ? "UNKNOWN" : "EXIT" : "ENTER";
    }
}
