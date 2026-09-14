package b2;

import android.content.Context;
import android.content.res.Resources;

/* loaded from: classes.dex */
public class s {

    /* renamed from: a, reason: collision with root package name */
    private final Resources f4074a;

    /* renamed from: b, reason: collision with root package name */
    private final String f4075b;

    public s(Context context) {
        p.k(context);
        Resources resources = context.getResources();
        this.f4074a = resources;
        this.f4075b = resources.getResourcePackageName(z1.e.f16071a);
    }

    public String a(String str) {
        int identifier = this.f4074a.getIdentifier(str, "string", this.f4075b);
        if (identifier == 0) {
            return null;
        }
        return this.f4074a.getString(identifier);
    }
}
