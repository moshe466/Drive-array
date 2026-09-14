package com.google.firebase.functions;

import android.content.Context;
import androidx.annotation.Keep;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.auth.internal.InternalAuthProvider;
import com.google.firebase.components.Component;
import com.google.firebase.components.ComponentContainer;
import com.google.firebase.components.ComponentFactory;
import com.google.firebase.components.ComponentRegistrar;
import com.google.firebase.components.Dependency;
import com.google.firebase.iid.internal.FirebaseInstanceIdInternal;
import com.google.firebase.platforminfo.LibraryVersionComponent;
import java.util.Arrays;
import java.util.List;

@Keep
/* loaded from: classes2.dex */
public class FunctionsRegistrar implements ComponentRegistrar {
    public static /* synthetic */ ContextProvider lambda$getComponents$0(ComponentContainer componentContainer) {
        return new FirebaseContextProvider(componentContainer.getProvider(InternalAuthProvider.class), componentContainer.getProvider(FirebaseInstanceIdInternal.class));
    }

    public static /* synthetic */ FunctionsMultiResourceComponent lambda$getComponents$1(ComponentContainer componentContainer) {
        return new FunctionsMultiResourceComponent((Context) componentContainer.get(Context.class), (ContextProvider) componentContainer.get(ContextProvider.class), ((FirebaseOptions) componentContainer.get(FirebaseOptions.class)).getProjectId());
    }

    @Override // com.google.firebase.components.ComponentRegistrar
    public List<Component<?>> getComponents() {
        ComponentFactory componentFactory;
        ComponentFactory componentFactory2;
        Component.Builder add = Component.builder(ContextProvider.class).add(Dependency.optionalProvider(InternalAuthProvider.class)).add(Dependency.requiredProvider(FirebaseInstanceIdInternal.class));
        componentFactory = FunctionsRegistrar$$Lambda$1.instance;
        Component.Builder add2 = Component.builder(FunctionsMultiResourceComponent.class).add(Dependency.required(Context.class)).add(Dependency.required(ContextProvider.class)).add(Dependency.required(FirebaseOptions.class));
        componentFactory2 = FunctionsRegistrar$$Lambda$2.instance;
        return Arrays.asList(add.factory(componentFactory).build(), add2.factory(componentFactory2).build(), LibraryVersionComponent.create("fire-fn", BuildConfig.VERSION_NAME));
    }
}
