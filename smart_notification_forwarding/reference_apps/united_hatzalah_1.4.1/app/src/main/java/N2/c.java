package N2;

import F2.p;
import java.util.Iterator;

/* loaded from: classes.dex */
public final class c implements M2.d {

    /* renamed from: a, reason: collision with root package name */
    public final CharSequence f1516a;

    /* renamed from: b, reason: collision with root package name */
    public final int f1517b;

    /* renamed from: c, reason: collision with root package name */
    public final p f1518c;

    public c(CharSequence input, int i, p pVar) {
        kotlin.jvm.internal.j.e(input, "input");
        this.f1516a = input;
        this.f1517b = i;
        this.f1518c = pVar;
    }

    @Override // M2.d
    public final Iterator iterator() {
        return new b(this);
    }
}
