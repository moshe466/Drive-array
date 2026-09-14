package j4;

import android.content.Context;
import com.google.firebase.crashlytics.internal.common.h;

/* loaded from: classes.dex */
public class a implements b {

    /* renamed from: a, reason: collision with root package name */
    private final Context f10965a;

    /* renamed from: b, reason: collision with root package name */
    private boolean f10966b = false;

    /* renamed from: c, reason: collision with root package name */
    private String f10967c;

    public a(Context context) {
        this.f10965a = context;
    }

    @Override // j4.b
    public String a() {
        if (!this.f10966b) {
            this.f10967c = h.D(this.f10965a);
            this.f10966b = true;
        }
        String str = this.f10967c;
        if (str != null) {
            return str;
        }
        return null;
    }
}
