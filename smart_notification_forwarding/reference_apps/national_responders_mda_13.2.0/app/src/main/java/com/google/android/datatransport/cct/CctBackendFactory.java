package com.google.android.datatransport.cct;

import androidx.annotation.Keep;
import com.google.android.datatransport.runtime.backends.f;
import l1.g;

@Keep
/* loaded from: classes.dex */
public class CctBackendFactory implements l1.a {
    @Override // l1.a
    public g create(f fVar) {
        return new d(fVar.b(), fVar.e(), fVar.d());
    }
}
