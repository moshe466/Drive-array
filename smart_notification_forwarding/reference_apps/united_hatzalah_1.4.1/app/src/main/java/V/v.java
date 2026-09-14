package V;

import android.text.Editable;
import android.text.SpannableStringBuilder;
import java.lang.reflect.Array;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class v extends SpannableStringBuilder {

    /* renamed from: a, reason: collision with root package name */
    public final Class f2435a;

    /* renamed from: b, reason: collision with root package name */
    public final ArrayList f2436b;

    public v(Class cls, CharSequence charSequence) {
        super(charSequence);
        this.f2436b = new ArrayList();
        I.d.c(cls, "watcherClass cannot be null");
        this.f2435a = cls;
    }

    public final void a() {
        int i = 0;
        while (true) {
            ArrayList arrayList = this.f2436b;
            if (i < arrayList.size()) {
                ((u) arrayList.get(i)).f2434b.incrementAndGet();
                i++;
            } else {
                return;
            }
        }
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable, java.lang.Appendable
    public final Editable append(CharSequence charSequence) {
        super.append(charSequence);
        return this;
    }

    public final void b() {
        e();
        int i = 0;
        while (true) {
            ArrayList arrayList = this.f2436b;
            if (i < arrayList.size()) {
                ((u) arrayList.get(i)).onTextChanged(this, 0, length(), length());
                i++;
            } else {
                return;
            }
        }
    }

    public final u c(Object obj) {
        int i = 0;
        while (true) {
            ArrayList arrayList = this.f2436b;
            if (i < arrayList.size()) {
                u uVar = (u) arrayList.get(i);
                if (uVar.f2433a == obj) {
                    return uVar;
                }
                i++;
            } else {
                return null;
            }
        }
    }

    public final boolean d(Object obj) {
        if (obj != null) {
            if (this.f2435a == obj.getClass()) {
                return true;
            }
            return false;
        }
        return false;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable
    public final Editable delete(int i, int i3) {
        super.delete(i, i3);
        return this;
    }

    public final void e() {
        int i = 0;
        while (true) {
            ArrayList arrayList = this.f2436b;
            if (i < arrayList.size()) {
                ((u) arrayList.get(i)).f2434b.decrementAndGet();
                i++;
            } else {
                return;
            }
        }
    }

    @Override // android.text.SpannableStringBuilder, android.text.Spanned
    public final int getSpanEnd(Object obj) {
        u c4;
        if (d(obj) && (c4 = c(obj)) != null) {
            obj = c4;
        }
        return super.getSpanEnd(obj);
    }

    @Override // android.text.SpannableStringBuilder, android.text.Spanned
    public final int getSpanFlags(Object obj) {
        u c4;
        if (d(obj) && (c4 = c(obj)) != null) {
            obj = c4;
        }
        return super.getSpanFlags(obj);
    }

    @Override // android.text.SpannableStringBuilder, android.text.Spanned
    public final int getSpanStart(Object obj) {
        u c4;
        if (d(obj) && (c4 = c(obj)) != null) {
            obj = c4;
        }
        return super.getSpanStart(obj);
    }

    @Override // android.text.SpannableStringBuilder, android.text.Spanned
    public final Object[] getSpans(int i, int i3, Class cls) {
        if (this.f2435a == cls) {
            u[] uVarArr = (u[]) super.getSpans(i, i3, u.class);
            Object[] objArr = (Object[]) Array.newInstance((Class<?>) cls, uVarArr.length);
            for (int i4 = 0; i4 < uVarArr.length; i4++) {
                objArr[i4] = uVarArr[i4].f2433a;
            }
            return objArr;
        }
        return super.getSpans(i, i3, cls);
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable
    public final Editable insert(int i, CharSequence charSequence) {
        super.insert(i, charSequence);
        return this;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Spanned
    public final int nextSpanTransition(int i, int i3, Class cls) {
        if (cls == null || this.f2435a == cls) {
            cls = u.class;
        }
        return super.nextSpanTransition(i, i3, cls);
    }

    @Override // android.text.SpannableStringBuilder, android.text.Spannable
    public final void removeSpan(Object obj) {
        u uVar;
        if (d(obj)) {
            uVar = c(obj);
            if (uVar != null) {
                obj = uVar;
            }
        } else {
            uVar = null;
        }
        super.removeSpan(obj);
        if (uVar != null) {
            this.f2436b.remove(uVar);
        }
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable
    public final /* bridge */ /* synthetic */ Editable replace(int i, int i3, CharSequence charSequence) {
        replace(i, i3, charSequence);
        return this;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Spannable
    public final void setSpan(Object obj, int i, int i3, int i4) {
        if (d(obj)) {
            u uVar = new u(obj);
            this.f2436b.add(uVar);
            obj = uVar;
        }
        super.setSpan(obj, i, i3, i4);
    }

    @Override // android.text.SpannableStringBuilder, java.lang.CharSequence
    public final CharSequence subSequence(int i, int i3) {
        return new v(this.f2435a, this, i, i3);
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable, java.lang.Appendable
    public final SpannableStringBuilder append(CharSequence charSequence) {
        super.append(charSequence);
        return this;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable
    public final SpannableStringBuilder delete(int i, int i3) {
        super.delete(i, i3);
        return this;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable
    public final SpannableStringBuilder insert(int i, CharSequence charSequence) {
        super.insert(i, charSequence);
        return this;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable
    public final /* bridge */ /* synthetic */ Editable replace(int i, int i3, CharSequence charSequence, int i4, int i5) {
        replace(i, i3, charSequence, i4, i5);
        return this;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable, java.lang.Appendable
    public final Appendable append(CharSequence charSequence) {
        super.append(charSequence);
        return this;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable
    public final Editable insert(int i, CharSequence charSequence, int i3, int i4) {
        super.insert(i, charSequence, i3, i4);
        return this;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable
    public final SpannableStringBuilder replace(int i, int i3, CharSequence charSequence) {
        a();
        super.replace(i, i3, charSequence);
        e();
        return this;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable, java.lang.Appendable
    public final Editable append(char c4) {
        super.append(c4);
        return this;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable
    public final SpannableStringBuilder insert(int i, CharSequence charSequence, int i3, int i4) {
        super.insert(i, charSequence, i3, i4);
        return this;
    }

    public v(Class cls, v vVar, int i, int i3) {
        super(vVar, i, i3);
        this.f2436b = new ArrayList();
        I.d.c(cls, "watcherClass cannot be null");
        this.f2435a = cls;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable, java.lang.Appendable
    public final SpannableStringBuilder append(char c4) {
        super.append(c4);
        return this;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable, java.lang.Appendable
    public final Appendable append(char c4) {
        super.append(c4);
        return this;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable
    public final SpannableStringBuilder replace(int i, int i3, CharSequence charSequence, int i4, int i5) {
        a();
        super.replace(i, i3, charSequence, i4, i5);
        e();
        return this;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable, java.lang.Appendable
    public final Editable append(CharSequence charSequence, int i, int i3) {
        super.append(charSequence, i, i3);
        return this;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable, java.lang.Appendable
    public final SpannableStringBuilder append(CharSequence charSequence, int i, int i3) {
        super.append(charSequence, i, i3);
        return this;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable, java.lang.Appendable
    public final Appendable append(CharSequence charSequence, int i, int i3) {
        super.append(charSequence, i, i3);
        return this;
    }

    @Override // android.text.SpannableStringBuilder
    public final SpannableStringBuilder append(CharSequence charSequence, Object obj, int i) {
        super.append(charSequence, obj, i);
        return this;
    }
}
