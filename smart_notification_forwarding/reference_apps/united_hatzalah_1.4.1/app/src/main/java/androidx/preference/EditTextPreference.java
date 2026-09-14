package androidx.preference;

import android.content.res.TypedArray;

/* loaded from: classes.dex */
public class EditTextPreference extends DialogPreference {
    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public EditTextPreference(android.content.Context r4, android.util.AttributeSet r5) {
        /*
            r3 = this;
            r0 = 2130968723(0x7f040093, float:1.7546108E38)
            r1 = 16842898(0x1010092, float:2.3693967E-38)
            int r0 = z.b.a(r4, r0, r1)
            r3.<init>(r4, r5, r0)
            int[] r1 = h0.AbstractC0445a.f4926c
            r2 = 0
            android.content.res.TypedArray r4 = r4.obtainStyledAttributes(r5, r1, r0, r2)
            boolean r5 = r4.getBoolean(r2, r2)
            boolean r5 = r4.getBoolean(r2, r5)
            if (r5 == 0) goto L2f
            androidx.lifecycle.N r5 = androidx.lifecycle.N.f3571b
            if (r5 != 0) goto L2b
            androidx.lifecycle.N r5 = new androidx.lifecycle.N
            r0 = 10
            r5.<init>(r0)
            androidx.lifecycle.N.f3571b = r5
        L2b:
            androidx.lifecycle.N r5 = androidx.lifecycle.N.f3571b
            r3.f3658j = r5
        L2f:
            r4.recycle()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.preference.EditTextPreference.<init>(android.content.Context, android.util.AttributeSet):void");
    }

    @Override // androidx.preference.Preference
    public final Object c(TypedArray typedArray, int i) {
        return typedArray.getString(i);
    }
}
