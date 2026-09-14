package com.google.firebase.tracing;

import b2.C0324a;
import com.google.firebase.components.Component;
import com.google.firebase.components.ComponentContainer;
import com.google.firebase.components.ComponentRegistrar;
import com.google.firebase.components.ComponentRegistrarProcessor;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class ComponentMonitor implements ComponentRegistrarProcessor {
    public static /* synthetic */ Object lambda$processRegistrar$0(String str, Component component, ComponentContainer componentContainer) {
        try {
            FirebaseTrace.pushTrace(str);
            return component.getFactory().create(componentContainer);
        } finally {
            FirebaseTrace.popTrace();
        }
    }

    @Override // com.google.firebase.components.ComponentRegistrarProcessor
    public List<Component<?>> processRegistrar(ComponentRegistrar componentRegistrar) {
        ArrayList arrayList = new ArrayList();
        for (Component<?> component : componentRegistrar.getComponents()) {
            String name = component.getName();
            if (name != null) {
                component = component.withFactory(new C0324a(name, 0, component));
            }
            arrayList.add(component);
        }
        return arrayList;
    }
}
