package com.google.android.gms.dynamite;

import android.content.Context;
import com.google.android.gms.dynamite.DynamiteModule;

/* loaded from: classes.dex */
final class g implements DynamiteModule.b {
    @Override // com.google.android.gms.dynamite.DynamiteModule.b
    public final DynamiteModule.b.C0084b a(Context context, String str, DynamiteModule.b.a aVar) {
        DynamiteModule.b.C0084b c0084b = new DynamiteModule.b.C0084b();
        c0084b.f5146a = aVar.a(context, str);
        int b10 = aVar.b(context, str, true);
        c0084b.f5147b = b10;
        int i10 = c0084b.f5146a;
        if (i10 == 0) {
            if (b10 == 0) {
                c0084b.f5148c = 0;
                return c0084b;
            }
            i10 = 0;
        }
        if (i10 >= b10) {
            c0084b.f5148c = -1;
        } else {
            c0084b.f5148c = 1;
        }
        return c0084b;
    }
}
