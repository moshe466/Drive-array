package com.google.firebase.analytics.connector.internal;

import android.annotation.SuppressLint;
import android.content.Context;
import androidx.annotation.Keep;
import java.util.Arrays;
import java.util.List;
import o3.c;
import r3.d;
import r3.i;
import r3.q;
import x4.h;

@Keep
/* loaded from: classes.dex */
public class AnalyticsConnectorRegistrar implements i {
    @Override // r3.i
    @Keep
    @SuppressLint({"MissingPermission"})
    public List<d<?>> getComponents() {
        return Arrays.asList(d.a(p3.a.class).b(q.i(c.class)).b(q.i(Context.class)).b(q.i(o4.d.class)).f(a.f7050a).e().d(), h.a("fire-analytics", "18.0.0"));
    }
}
