package androidx.preference;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import androidx.lifecycle.N;
import com.uh.sf.R;
import h0.AbstractC0445a;
import z.b;

/* loaded from: classes.dex */
public class ListPreference extends DialogPreference {

    /* renamed from: k, reason: collision with root package name */
    public final CharSequence[] f3650k;

    /* renamed from: l, reason: collision with root package name */
    public final String f3651l;

    public ListPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, AbstractC0445a.f4927d, i, 0);
        CharSequence[] textArray = obtainStyledAttributes.getTextArray(2);
        this.f3650k = textArray == null ? obtainStyledAttributes.getTextArray(0) : textArray;
        if (obtainStyledAttributes.getTextArray(3) == null) {
            obtainStyledAttributes.getTextArray(1);
        }
        if (obtainStyledAttributes.getBoolean(4, obtainStyledAttributes.getBoolean(4, false))) {
            if (N.f3572c == null) {
                N.f3572c = new N(11);
            }
            this.f3658j = N.f3572c;
            b();
        }
        obtainStyledAttributes.recycle();
        TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, AbstractC0445a.f4929f, i, 0);
        String string = obtainStyledAttributes2.getString(33);
        this.f3651l = string == null ? obtainStyledAttributes2.getString(7) : string;
        obtainStyledAttributes2.recycle();
    }

    @Override // androidx.preference.Preference
    public final CharSequence a() {
        N n4 = this.f3658j;
        if (n4 != null) {
            return n4.k(this);
        }
        CharSequence a2 = super.a();
        String str = this.f3651l;
        if (str != null) {
            String format = String.format(str, "");
            if (!TextUtils.equals(format, a2)) {
                return format;
            }
        }
        return a2;
    }

    @Override // androidx.preference.Preference
    public final Object c(TypedArray typedArray, int i) {
        return typedArray.getString(i);
    }

    public ListPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, b.a(context, R.attr.dialogPreferenceStyle, android.R.attr.dialogPreferenceStyle));
    }
}
