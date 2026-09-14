package androidx.preference;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import com.uh.sf.R;
import h0.AbstractC0445a;

/* loaded from: classes.dex */
public class SeekBarPreference extends Preference {

    /* renamed from: k, reason: collision with root package name */
    public final int f3659k;

    /* renamed from: l, reason: collision with root package name */
    public final int f3660l;

    public SeekBarPreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, R.attr.seekBarPreferenceStyle);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, AbstractC0445a.i, R.attr.seekBarPreferenceStyle, 0);
        int i = obtainStyledAttributes.getInt(3, 0);
        int i3 = obtainStyledAttributes.getInt(1, 100);
        i3 = i3 < i ? i : i3;
        if (i3 != this.f3659k) {
            this.f3659k = i3;
        }
        int i4 = obtainStyledAttributes.getInt(4, 0);
        if (i4 != this.f3660l) {
            this.f3660l = Math.min(this.f3659k - i, Math.abs(i4));
        }
        obtainStyledAttributes.getBoolean(2, true);
        obtainStyledAttributes.getBoolean(5, false);
        obtainStyledAttributes.getBoolean(6, false);
        obtainStyledAttributes.recycle();
    }

    @Override // androidx.preference.Preference
    public final Object c(TypedArray typedArray, int i) {
        return Integer.valueOf(typedArray.getInt(i, 0));
    }
}
