package h;

import android.R;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import java.lang.reflect.Constructor;
import t.C0694j;

/* renamed from: h.B, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0430B {

    /* renamed from: b, reason: collision with root package name */
    public static final Class[] f4719b = {Context.class, AttributeSet.class};

    /* renamed from: c, reason: collision with root package name */
    public static final int[] f4720c = {R.attr.onClick};

    /* renamed from: d, reason: collision with root package name */
    public static final int[] f4721d = {R.attr.accessibilityHeading};

    /* renamed from: e, reason: collision with root package name */
    public static final int[] f4722e = {R.attr.accessibilityPaneTitle};

    /* renamed from: f, reason: collision with root package name */
    public static final int[] f4723f = {R.attr.screenReaderFocusable};

    /* renamed from: g, reason: collision with root package name */
    public static final String[] f4724g = {"android.widget.", "android.view.", "android.webkit."};

    /* renamed from: h, reason: collision with root package name */
    public static final C0694j f4725h = new C0694j(0);

    /* renamed from: a, reason: collision with root package name */
    public final Object[] f4726a = new Object[2];

    public final View a(Context context, String str, String str2) {
        String concat;
        C0694j c0694j = f4725h;
        Constructor constructor = (Constructor) c0694j.get(str);
        if (constructor == null) {
            if (str2 != null) {
                try {
                    concat = str2.concat(str);
                } catch (Exception unused) {
                    return null;
                }
            } else {
                concat = str;
            }
            constructor = Class.forName(concat, false, context.getClassLoader()).asSubclass(View.class).getConstructor(f4719b);
            c0694j.put(str, constructor);
        }
        constructor.setAccessible(true);
        return (View) constructor.newInstance(this.f4726a);
    }
}
