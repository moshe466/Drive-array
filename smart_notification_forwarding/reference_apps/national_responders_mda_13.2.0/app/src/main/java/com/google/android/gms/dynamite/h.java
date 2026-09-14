package com.google.android.gms.dynamite;

import android.content.Context;
import com.google.android.gms.dynamite.DynamiteModule;

/* loaded from: classes.dex */
final class h implements DynamiteModule.b {
    @Override // com.google.android.gms.dynamite.DynamiteModule.b
    public final DynamiteModule.b.C0084b a(Context context, String str, DynamiteModule.b.a aVar) {
        DynamiteModule.b.C0084b c0084b = new DynamiteModule.b.C0084b();
        int a10 = aVar.a(context, str);
        c0084b.f5146a = a10;
        int i10 = 0;
        int b10 = a10 != 0 ? aVar.b(context, str, false) : aVar.b(context, str, true);
        c0084b.f5147b = b10;
        int i11 = c0084b.f5146a;
        if (i11 != 0) {
            i10 = i11;
        } else if (b10 == 0) {
            c0084b.f5148c = 0;
            return c0084b;
        }
        if (i10 >= b10) {
            c0084b.f5148c = -1;
        } else {
            c0084b.f5148c = 1;
        }
        return c0084b;
    }
}
