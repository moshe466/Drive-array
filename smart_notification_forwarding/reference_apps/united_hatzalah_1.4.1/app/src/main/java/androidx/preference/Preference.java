package androidx.preference;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import androidx.lifecycle.N;
import com.google.android.gms.common.api.Api;
import com.uh.sf.R;
import h0.AbstractC0445a;
import z.b;

/* loaded from: classes.dex */
public class Preference implements Comparable<Preference> {

    /* renamed from: a, reason: collision with root package name */
    public final Context f3652a;

    /* renamed from: b, reason: collision with root package name */
    public final int f3653b;

    /* renamed from: c, reason: collision with root package name */
    public final CharSequence f3654c;

    /* renamed from: d, reason: collision with root package name */
    public final CharSequence f3655d;

    /* renamed from: e, reason: collision with root package name */
    public final String f3656e;

    /* renamed from: f, reason: collision with root package name */
    public final Object f3657f;

    /* renamed from: j, reason: collision with root package name */
    public N f3658j;

    public Preference(Context context, AttributeSet attributeSet, int i) {
        this.f3653b = Api.BaseClientBuilder.API_PRIORITY_OTHER;
        this.f3652a = context;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, AbstractC0445a.f4929f, i, 0);
        obtainStyledAttributes.getResourceId(23, obtainStyledAttributes.getResourceId(0, 0));
        String string = obtainStyledAttributes.getString(26);
        this.f3656e = string == null ? obtainStyledAttributes.getString(6) : string;
        CharSequence text = obtainStyledAttributes.getText(34);
        this.f3654c = text == null ? obtainStyledAttributes.getText(4) : text;
        CharSequence text2 = obtainStyledAttributes.getText(33);
        this.f3655d = text2 == null ? obtainStyledAttributes.getText(7) : text2;
        this.f3653b = obtainStyledAttributes.getInt(28, obtainStyledAttributes.getInt(8, Api.BaseClientBuilder.API_PRIORITY_OTHER));
        if (obtainStyledAttributes.getString(22) == null) {
            obtainStyledAttributes.getString(13);
        }
        obtainStyledAttributes.getResourceId(27, obtainStyledAttributes.getResourceId(3, R.layout.preference));
        obtainStyledAttributes.getResourceId(35, obtainStyledAttributes.getResourceId(9, 0));
        obtainStyledAttributes.getBoolean(21, obtainStyledAttributes.getBoolean(2, true));
        boolean z3 = obtainStyledAttributes.getBoolean(30, obtainStyledAttributes.getBoolean(5, true));
        obtainStyledAttributes.getBoolean(29, obtainStyledAttributes.getBoolean(1, true));
        if (obtainStyledAttributes.getString(19) == null) {
            obtainStyledAttributes.getString(10);
        }
        obtainStyledAttributes.getBoolean(16, obtainStyledAttributes.getBoolean(16, z3));
        obtainStyledAttributes.getBoolean(17, obtainStyledAttributes.getBoolean(17, z3));
        if (obtainStyledAttributes.hasValue(18)) {
            this.f3657f = c(obtainStyledAttributes, 18);
        } else if (obtainStyledAttributes.hasValue(11)) {
            this.f3657f = c(obtainStyledAttributes, 11);
        }
        obtainStyledAttributes.getBoolean(31, obtainStyledAttributes.getBoolean(12, true));
        if (obtainStyledAttributes.hasValue(32)) {
            obtainStyledAttributes.getBoolean(32, obtainStyledAttributes.getBoolean(14, true));
        }
        obtainStyledAttributes.getBoolean(24, obtainStyledAttributes.getBoolean(15, false));
        obtainStyledAttributes.getBoolean(25, obtainStyledAttributes.getBoolean(25, true));
        obtainStyledAttributes.getBoolean(20, obtainStyledAttributes.getBoolean(20, false));
        obtainStyledAttributes.recycle();
    }

    public CharSequence a() {
        N n4 = this.f3658j;
        if (n4 != null) {
            return n4.k(this);
        }
        return this.f3655d;
    }

    public void b() {
    }

    public Object c(TypedArray typedArray, int i) {
        return null;
    }

    @Override // java.lang.Comparable
    public final int compareTo(Preference preference) {
        Preference preference2 = preference;
        int i = preference2.f3653b;
        CharSequence charSequence = preference2.f3654c;
        int i3 = this.f3653b;
        if (i3 != i) {
            return i3 - i;
        }
        CharSequence charSequence2 = this.f3654c;
        if (charSequence2 == charSequence) {
            return 0;
        }
        if (charSequence2 == null) {
            return 1;
        }
        if (charSequence == null) {
            return -1;
        }
        return charSequence2.toString().compareToIgnoreCase(charSequence.toString());
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        CharSequence charSequence = this.f3654c;
        if (!TextUtils.isEmpty(charSequence)) {
            sb.append(charSequence);
            sb.append(' ');
        }
        CharSequence a2 = a();
        if (!TextUtils.isEmpty(a2)) {
            sb.append(a2);
            sb.append(' ');
        }
        if (sb.length() > 0) {
            sb.setLength(sb.length() - 1);
        }
        return sb.toString();
    }

    public Preference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, b.a(context, R.attr.preferenceStyle, android.R.attr.preferenceStyle));
    }
}
