package z;

import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.Resources;

/* loaded from: classes.dex */
public final class h {

    /* renamed from: a, reason: collision with root package name */
    public final ColorStateList f6790a;

    /* renamed from: b, reason: collision with root package name */
    public final Configuration f6791b;

    /* renamed from: c, reason: collision with root package name */
    public final int f6792c;

    public h(ColorStateList colorStateList, Configuration configuration, Resources.Theme theme) {
        int hashCode;
        this.f6790a = colorStateList;
        this.f6791b = configuration;
        if (theme == null) {
            hashCode = 0;
        } else {
            hashCode = theme.hashCode();
        }
        this.f6792c = hashCode;
    }
}
