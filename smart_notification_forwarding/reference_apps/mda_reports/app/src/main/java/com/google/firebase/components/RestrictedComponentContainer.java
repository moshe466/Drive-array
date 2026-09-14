package com.google.firebase.components;

import com.google.firebase.events.Event;
import com.google.firebase.events.Publisher;
import com.google.firebase.inject.Provider;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* loaded from: classes2.dex */
final class RestrictedComponentContainer extends AbstractComponentContainer {
    private final Set<Class<?>> allowedDirectInterfaces;
    private final Set<Class<?>> allowedProviderInterfaces;
    private final Set<Class<?>> allowedPublishedEvents;
    private final Set<Class<?>> allowedSetDirectInterfaces;
    private final Set<Class<?>> allowedSetProviderInterfaces;
    private final ComponentContainer delegateContainer;

    /* loaded from: classes2.dex */
    private static class RestrictedPublisher implements Publisher {
        private final Set<Class<?>> allowedPublishedEvents;
        private final Publisher delegate;

        public RestrictedPublisher(Set<Class<?>> set, Publisher publisher) {
            this.allowedPublishedEvents = set;
            this.delegate = publisher;
        }

        @Override // com.google.firebase.events.Publisher
        public void publish(Event<?> event) {
            if (!this.allowedPublishedEvents.contains(event.getType())) {
                throw new IllegalArgumentException(String.format("Attempting to publish an undeclared event %s.", event));
            }
            this.delegate.publish(event);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public RestrictedComponentContainer(Component<?> component, ComponentContainer componentContainer) {
        HashSet hashSet = new HashSet();
        HashSet hashSet2 = new HashSet();
        HashSet hashSet3 = new HashSet();
        HashSet hashSet4 = new HashSet();
        for (Dependency dependency : component.getDependencies()) {
            if (dependency.isDirectInjection()) {
                boolean isSet = dependency.isSet();
                Class<?> cls = dependency.getInterface();
                if (isSet) {
                    hashSet3.add(cls);
                } else {
                    hashSet.add(cls);
                }
            } else {
                boolean isSet2 = dependency.isSet();
                Class<?> cls2 = dependency.getInterface();
                if (isSet2) {
                    hashSet4.add(cls2);
                } else {
                    hashSet2.add(cls2);
                }
            }
        }
        if (!component.getPublishedEvents().isEmpty()) {
            hashSet.add(Publisher.class);
        }
        this.allowedDirectInterfaces = Collections.unmodifiableSet(hashSet);
        this.allowedProviderInterfaces = Collections.unmodifiableSet(hashSet2);
        this.allowedSetDirectInterfaces = Collections.unmodifiableSet(hashSet3);
        this.allowedSetProviderInterfaces = Collections.unmodifiableSet(hashSet4);
        this.allowedPublishedEvents = component.getPublishedEvents();
        this.delegateContainer = componentContainer;
    }

    @Override // com.google.firebase.components.AbstractComponentContainer, com.google.firebase.components.ComponentContainer
    public <T> T get(Class<T> cls) {
        if (!this.allowedDirectInterfaces.contains(cls)) {
            throw new IllegalArgumentException(String.format("Attempting to request an undeclared dependency %s.", cls));
        }
        T t = (T) this.delegateContainer.get(cls);
        return !cls.equals(Publisher.class) ? t : (T) new RestrictedPublisher(this.allowedPublishedEvents, (Publisher) t);
    }

    @Override // com.google.firebase.components.ComponentContainer
    public <T> Provider<T> getProvider(Class<T> cls) {
        if (this.allowedProviderInterfaces.contains(cls)) {
            return this.delegateContainer.getProvider(cls);
        }
        throw new IllegalArgumentException(String.format("Attempting to request an undeclared dependency Provider<%s>.", cls));
    }

    @Override // com.google.firebase.components.AbstractComponentContainer, com.google.firebase.components.ComponentContainer
    public <T> Set<T> setOf(Class<T> cls) {
        if (this.allowedSetDirectInterfaces.contains(cls)) {
            return this.delegateContainer.setOf(cls);
        }
        throw new IllegalArgumentException(String.format("Attempting to request an undeclared dependency Set<%s>.", cls));
    }

    @Override // com.google.firebase.components.ComponentContainer
    public <T> Provider<Set<T>> setOfProvider(Class<T> cls) {
        if (this.allowedSetProviderInterfaces.contains(cls)) {
            return this.delegateContainer.setOfProvider(cls);
        }
        throw new IllegalArgumentException(String.format("Attempting to request an undeclared dependency Provider<Set<%s>>.", cls));
    }
}
