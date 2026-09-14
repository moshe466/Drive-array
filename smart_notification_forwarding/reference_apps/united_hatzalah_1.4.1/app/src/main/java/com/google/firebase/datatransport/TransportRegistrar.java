package com.google.firebase.datatransport;

import Z1.a;
import android.content.Context;
import com.google.firebase.components.Component;
import com.google.firebase.components.ComponentContainer;
import com.google.firebase.components.ComponentRegistrar;
import com.google.firebase.components.Dependency;
import com.google.firebase.components.Qualified;
import com.google.firebase.platforminfo.LibraryVersionComponent;
import java.util.Arrays;
import java.util.List;
import q1.g;
import r1.C0643a;
import t1.t;

/* loaded from: classes.dex */
public class TransportRegistrar implements ComponentRegistrar {
    private static final String LIBRARY_NAME = "fire-transport";

    public static /* synthetic */ g lambda$getComponents$0(ComponentContainer componentContainer) {
        t.b((Context) componentContainer.get(Context.class));
        return t.a().c(C0643a.f6207f);
    }

    public static /* synthetic */ g lambda$getComponents$1(ComponentContainer componentContainer) {
        t.b((Context) componentContainer.get(Context.class));
        return t.a().c(C0643a.f6207f);
    }

    public static /* synthetic */ g lambda$getComponents$2(ComponentContainer componentContainer) {
        t.b((Context) componentContainer.get(Context.class));
        return t.a().c(C0643a.f6206e);
    }

    @Override // com.google.firebase.components.ComponentRegistrar
    public List<Component<?>> getComponents() {
        return Arrays.asList(Component.builder(g.class).name(LIBRARY_NAME).add(Dependency.required((Class<?>) Context.class)).factory(new a(1)).build(), Component.builder(Qualified.qualified(LegacyTransportBackend.class, g.class)).add(Dependency.required((Class<?>) Context.class)).factory(new a(2)).build(), Component.builder(Qualified.qualified(TransportBackend.class, g.class)).add(Dependency.required((Class<?>) Context.class)).factory(new a(3)).build(), LibraryVersionComponent.create(LIBRARY_NAME, BuildConfig.VERSION_NAME));
    }
}
