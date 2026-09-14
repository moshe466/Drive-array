package l1;

import F2.l;
import N2.f;
import java.util.List;
import kotlin.jvm.internal.j;
import kotlin.jvm.internal.k;
import s2.C0679d;

/* renamed from: l1.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0517a extends k implements l {

    /* renamed from: a, reason: collision with root package name */
    public static final C0517a f5483a = new k(1);

    @Override // F2.l
    public final Object invoke(Object obj) {
        List it = (List) obj;
        j.e(it, "it");
        String str = (String) ((C0679d) it.get(0)).f6332a;
        C0679d c0679d = (C0679d) it.get(1);
        String str2 = (String) c0679d.f6332a;
        int intValue = ((Number) c0679d.f6333b).intValue();
        if (f.U(str) && f.U(str2)) {
            return Integer.valueOf(intValue);
        }
        return null;
    }
}
