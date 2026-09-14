package androidx.core.os;

import android.os.LocaleList;
import java.util.Locale;

/* loaded from: classes.dex */
final class j implements i {

    /* renamed from: a, reason: collision with root package name */
    private final LocaleList f2427a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(Object obj) {
        this.f2427a = (LocaleList) obj;
    }

    @Override // androidx.core.os.i
    public Object a() {
        return this.f2427a;
    }

    public boolean equals(Object obj) {
        return this.f2427a.equals(((i) obj).a());
    }

    @Override // androidx.core.os.i
    public Locale get(int i10) {
        return this.f2427a.get(i10);
    }

    public int hashCode() {
        return this.f2427a.hashCode();
    }

    public String toString() {
        return this.f2427a.toString();
    }
}
