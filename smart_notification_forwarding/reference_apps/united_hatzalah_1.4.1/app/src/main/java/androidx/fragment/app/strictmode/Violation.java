package androidx.fragment.app.strictmode;

import androidx.fragment.app.G;
import kotlin.jvm.internal.j;

/* loaded from: classes.dex */
public abstract class Violation extends RuntimeException {

    /* renamed from: a, reason: collision with root package name */
    public final G f3514a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Violation(G fragment, String str) {
        super(str);
        j.e(fragment, "fragment");
        this.f3514a = fragment;
    }
}
