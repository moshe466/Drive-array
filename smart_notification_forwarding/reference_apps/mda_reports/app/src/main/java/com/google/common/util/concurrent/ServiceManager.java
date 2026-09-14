package com.google.common.util.concurrent;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Function;
import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicates;
import com.google.common.base.Stopwatch;
import com.google.common.collect.Collections2;
import com.google.common.collect.ImmutableCollection;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.ImmutableSetMultimap;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.MultimapBuilder;
import com.google.common.collect.Multimaps;
import com.google.common.collect.Multiset;
import com.google.common.collect.Ordering;
import com.google.common.collect.SetMultimap;
import com.google.common.collect.UnmodifiableIterator;
import com.google.common.util.concurrent.ListenerCallQueue;
import com.google.common.util.concurrent.Monitor;
import com.google.common.util.concurrent.Service;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.concurrent.GuardedBy;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumSet;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.logging.Level;
import java.util.logging.Logger;

@Beta
@GwtIncompatible
/* loaded from: classes2.dex */
public final class ServiceManager {
    private final ImmutableList<Service> services;
    private final ServiceManagerState state;
    private static final Logger logger = Logger.getLogger(ServiceManager.class.getName());
    private static final ListenerCallQueue.Event<Listener> HEALTHY_EVENT = new ListenerCallQueue.Event<Listener>() { // from class: com.google.common.util.concurrent.ServiceManager.1
        @Override // com.google.common.util.concurrent.ListenerCallQueue.Event
        public void call(Listener listener) {
            listener.healthy();
        }

        public String toString() {
            return "healthy()";
        }
    };
    private static final ListenerCallQueue.Event<Listener> STOPPED_EVENT = new ListenerCallQueue.Event<Listener>() { // from class: com.google.common.util.concurrent.ServiceManager.2
        @Override // com.google.common.util.concurrent.ListenerCallQueue.Event
        public void call(Listener listener) {
            listener.stopped();
        }

        public String toString() {
            return "stopped()";
        }
    };

    /* loaded from: classes2.dex */
    private static final class EmptyServiceManagerWarning extends Throwable {
        private EmptyServiceManagerWarning() {
        }
    }

    @Beta
    /* loaded from: classes2.dex */
    public static abstract class Listener {
        public void failure(Service service) {
        }

        public void healthy() {
        }

        public void stopped() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static final class NoOpService extends AbstractService {
        private NoOpService() {
        }

        @Override // com.google.common.util.concurrent.AbstractService
        protected void a() {
            c();
        }

        @Override // com.google.common.util.concurrent.AbstractService
        protected void b() {
            d();
        }
    }

    /* loaded from: classes2.dex */
    private static final class ServiceListener extends Service.Listener {
        final Service a;
        final WeakReference<ServiceManagerState> b;

        ServiceListener(Service service, WeakReference<ServiceManagerState> weakReference) {
            this.a = service;
            this.b = weakReference;
        }

        @Override // com.google.common.util.concurrent.Service.Listener
        public void failed(Service.State state, Throwable th) {
            ServiceManagerState serviceManagerState = this.b.get();
            if (serviceManagerState != null) {
                if (!(this.a instanceof NoOpService)) {
                    ServiceManager.logger.log(Level.SEVERE, "Service " + this.a + " has failed in the " + state + " state.", th);
                }
                serviceManagerState.a(this.a, state, Service.State.FAILED);
            }
        }

        @Override // com.google.common.util.concurrent.Service.Listener
        public void running() {
            ServiceManagerState serviceManagerState = this.b.get();
            if (serviceManagerState != null) {
                serviceManagerState.a(this.a, Service.State.STARTING, Service.State.RUNNING);
            }
        }

        @Override // com.google.common.util.concurrent.Service.Listener
        public void starting() {
            ServiceManagerState serviceManagerState = this.b.get();
            if (serviceManagerState != null) {
                serviceManagerState.a(this.a, Service.State.NEW, Service.State.STARTING);
                if (this.a instanceof NoOpService) {
                    return;
                }
                ServiceManager.logger.log(Level.FINE, "Starting {0}.", this.a);
            }
        }

        @Override // com.google.common.util.concurrent.Service.Listener
        public void stopping(Service.State state) {
            ServiceManagerState serviceManagerState = this.b.get();
            if (serviceManagerState != null) {
                serviceManagerState.a(this.a, state, Service.State.STOPPING);
            }
        }

        @Override // com.google.common.util.concurrent.Service.Listener
        public void terminated(Service.State state) {
            ServiceManagerState serviceManagerState = this.b.get();
            if (serviceManagerState != null) {
                if (!(this.a instanceof NoOpService)) {
                    ServiceManager.logger.log(Level.FINE, "Service {0} has terminated. Previous state was: {1}", new Object[]{this.a, state});
                }
                serviceManagerState.a(this.a, state, Service.State.TERMINATED);
            }
        }
    }

    /* loaded from: classes2.dex */
    private static final class ServiceManagerState {

        @GuardedBy("monitor")
        boolean e;

        @GuardedBy("monitor")
        boolean f;
        final int g;
        final Monitor a = new Monitor();

        @GuardedBy("monitor")
        final SetMultimap<Service.State, Service> b = MultimapBuilder.enumKeys(Service.State.class).linkedHashSetValues().build();

        @GuardedBy("monitor")
        final Multiset<Service.State> c = this.b.keys();

        @GuardedBy("monitor")
        final Map<Service, Stopwatch> d = Maps.newIdentityHashMap();
        final Monitor.Guard h = new AwaitHealthGuard();
        final Monitor.Guard i = new StoppedGuard();
        final ListenerCallQueue<Listener> j = new ListenerCallQueue<>();

        /* loaded from: classes2.dex */
        final class AwaitHealthGuard extends Monitor.Guard {
            AwaitHealthGuard() {
                super(ServiceManagerState.this.a);
            }

            @Override // com.google.common.util.concurrent.Monitor.Guard
            @GuardedBy("ServiceManagerState.this.monitor")
            public boolean isSatisfied() {
                int count = ServiceManagerState.this.c.count(Service.State.RUNNING);
                ServiceManagerState serviceManagerState = ServiceManagerState.this;
                return count == serviceManagerState.g || serviceManagerState.c.contains(Service.State.STOPPING) || ServiceManagerState.this.c.contains(Service.State.TERMINATED) || ServiceManagerState.this.c.contains(Service.State.FAILED);
            }
        }

        /* loaded from: classes2.dex */
        final class StoppedGuard extends Monitor.Guard {
            StoppedGuard() {
                super(ServiceManagerState.this.a);
            }

            @Override // com.google.common.util.concurrent.Monitor.Guard
            @GuardedBy("ServiceManagerState.this.monitor")
            public boolean isSatisfied() {
                return ServiceManagerState.this.c.count(Service.State.TERMINATED) + ServiceManagerState.this.c.count(Service.State.FAILED) == ServiceManagerState.this.g;
            }
        }

        ServiceManagerState(ImmutableCollection<Service> immutableCollection) {
            this.g = immutableCollection.size();
            this.b.putAll(Service.State.NEW, immutableCollection);
        }

        void a() {
            this.a.enterWhenUninterruptibly(this.h);
            try {
                c();
            } finally {
                this.a.leave();
            }
        }

        void a(long j, TimeUnit timeUnit) {
            this.a.enter();
            try {
                if (this.a.waitForUninterruptibly(this.h, j, timeUnit)) {
                    c();
                    return;
                }
                throw new TimeoutException("Timeout waiting for the services to become healthy. The following services have not started: " + Multimaps.filterKeys((SetMultimap) this.b, Predicates.in(ImmutableSet.of(Service.State.NEW, Service.State.STARTING))));
            } finally {
                this.a.leave();
            }
        }

        void a(final Service service) {
            this.j.enqueue(new ListenerCallQueue.Event<Listener>(this) { // from class: com.google.common.util.concurrent.ServiceManager.ServiceManagerState.2
                @Override // com.google.common.util.concurrent.ListenerCallQueue.Event
                public void call(Listener listener) {
                    listener.failure(service);
                }

                public String toString() {
                    return "failed({service=" + service + "})";
                }
            });
        }

        void a(Service service, Service.State state, Service.State state2) {
            Preconditions.checkNotNull(service);
            Preconditions.checkArgument(state != state2);
            this.a.enter();
            try {
                this.f = true;
                if (this.e) {
                    Preconditions.checkState(this.b.remove(state, service), "Service %s not at the expected location in the state map %s", service, state);
                    Preconditions.checkState(this.b.put(state2, service), "Service %s in the state map unexpectedly at %s", service, state2);
                    Stopwatch stopwatch = this.d.get(service);
                    if (stopwatch == null) {
                        stopwatch = Stopwatch.createStarted();
                        this.d.put(service, stopwatch);
                    }
                    if (state2.compareTo(Service.State.RUNNING) >= 0 && stopwatch.isRunning()) {
                        stopwatch.stop();
                        if (!(service instanceof NoOpService)) {
                            ServiceManager.logger.log(Level.FINE, "Started {0} in {1}.", new Object[]{service, stopwatch});
                        }
                    }
                    if (state2 == Service.State.FAILED) {
                        a(service);
                    }
                    if (this.c.count(Service.State.RUNNING) == this.g) {
                        e();
                    } else if (this.c.count(Service.State.TERMINATED) + this.c.count(Service.State.FAILED) == this.g) {
                        f();
                    }
                }
            } finally {
                this.a.leave();
                d();
            }
        }

        void a(Listener listener, Executor executor) {
            this.j.addListener(listener, executor);
        }

        void b() {
            this.a.enterWhenUninterruptibly(this.i);
            this.a.leave();
        }

        void b(long j, TimeUnit timeUnit) {
            this.a.enter();
            try {
                if (this.a.waitForUninterruptibly(this.i, j, timeUnit)) {
                    return;
                }
                throw new TimeoutException("Timeout waiting for the services to stop. The following services have not stopped: " + Multimaps.filterKeys((SetMultimap) this.b, Predicates.not(Predicates.in(EnumSet.of(Service.State.TERMINATED, Service.State.FAILED)))));
            } finally {
                this.a.leave();
            }
        }

        void b(Service service) {
            this.a.enter();
            try {
                if (this.d.get(service) == null) {
                    this.d.put(service, Stopwatch.createStarted());
                }
            } finally {
                this.a.leave();
            }
        }

        @GuardedBy("monitor")
        void c() {
            if (this.c.count(Service.State.RUNNING) == this.g) {
                return;
            }
            throw new IllegalStateException("Expected to be healthy after starting. The following services are not running: " + Multimaps.filterKeys((SetMultimap) this.b, Predicates.not(Predicates.equalTo(Service.State.RUNNING))));
        }

        void d() {
            Preconditions.checkState(!this.a.isOccupiedByCurrentThread(), "It is incorrect to execute listeners with the monitor held.");
            this.j.dispatch();
        }

        void e() {
            this.j.enqueue(ServiceManager.HEALTHY_EVENT);
        }

        void f() {
            this.j.enqueue(ServiceManager.STOPPED_EVENT);
        }

        void g() {
            this.a.enter();
            try {
                if (!this.f) {
                    this.e = true;
                    return;
                }
                ArrayList newArrayList = Lists.newArrayList();
                UnmodifiableIterator<Service> it = h().values().iterator();
                while (it.hasNext()) {
                    Service next = it.next();
                    if (next.state() != Service.State.NEW) {
                        newArrayList.add(next);
                    }
                }
                throw new IllegalArgumentException("Services started transitioning asynchronously before the ServiceManager was constructed: " + newArrayList);
            } finally {
                this.a.leave();
            }
        }

        ImmutableMultimap<Service.State, Service> h() {
            ImmutableSetMultimap.Builder builder = ImmutableSetMultimap.builder();
            this.a.enter();
            try {
                for (Map.Entry<Service.State, Service> entry : this.b.entries()) {
                    if (!(entry.getValue() instanceof NoOpService)) {
                        builder.put((Map.Entry) entry);
                    }
                }
                this.a.leave();
                return builder.build();
            } catch (Throwable th) {
                this.a.leave();
                throw th;
            }
        }

        ImmutableMap<Service, Long> i() {
            this.a.enter();
            try {
                ArrayList newArrayListWithCapacity = Lists.newArrayListWithCapacity(this.d.size());
                for (Map.Entry<Service, Stopwatch> entry : this.d.entrySet()) {
                    Service key = entry.getKey();
                    Stopwatch value = entry.getValue();
                    if (!value.isRunning() && !(key instanceof NoOpService)) {
                        newArrayListWithCapacity.add(Maps.immutableEntry(key, Long.valueOf(value.elapsed(TimeUnit.MILLISECONDS))));
                    }
                }
                this.a.leave();
                Collections.sort(newArrayListWithCapacity, Ordering.natural().onResultOf(new Function<Map.Entry<Service, Long>, Long>(this) { // from class: com.google.common.util.concurrent.ServiceManager.ServiceManagerState.1
                    @Override // com.google.common.base.Function
                    public Long apply(Map.Entry<Service, Long> entry2) {
                        return entry2.getValue();
                    }
                }));
                return ImmutableMap.copyOf(newArrayListWithCapacity);
            } catch (Throwable th) {
                this.a.leave();
                throw th;
            }
        }
    }

    public ServiceManager(Iterable<? extends Service> iterable) {
        ImmutableList<Service> copyOf = ImmutableList.copyOf(iterable);
        if (copyOf.isEmpty()) {
            logger.log(Level.WARNING, "ServiceManager configured with no services.  Is your application configured properly?", (Throwable) new EmptyServiceManagerWarning());
            copyOf = ImmutableList.of(new NoOpService());
        }
        this.state = new ServiceManagerState(copyOf);
        this.services = copyOf;
        WeakReference weakReference = new WeakReference(this.state);
        UnmodifiableIterator<Service> it = copyOf.iterator();
        while (it.hasNext()) {
            Service next = it.next();
            next.addListener(new ServiceListener(next, weakReference), MoreExecutors.directExecutor());
            Preconditions.checkArgument(next.state() == Service.State.NEW, "Can only manage NEW services, %s", next);
        }
        this.state.g();
    }

    public void addListener(Listener listener) {
        this.state.a(listener, MoreExecutors.directExecutor());
    }

    public void addListener(Listener listener, Executor executor) {
        this.state.a(listener, executor);
    }

    public void awaitHealthy() {
        this.state.a();
    }

    public void awaitHealthy(long j, TimeUnit timeUnit) {
        this.state.a(j, timeUnit);
    }

    public void awaitStopped() {
        this.state.b();
    }

    public void awaitStopped(long j, TimeUnit timeUnit) {
        this.state.b(j, timeUnit);
    }

    public boolean isHealthy() {
        UnmodifiableIterator<Service> it = this.services.iterator();
        while (it.hasNext()) {
            if (!it.next().isRunning()) {
                return false;
            }
        }
        return true;
    }

    public ImmutableMultimap<Service.State, Service> servicesByState() {
        return this.state.h();
    }

    @CanIgnoreReturnValue
    public ServiceManager startAsync() {
        UnmodifiableIterator<Service> it = this.services.iterator();
        while (it.hasNext()) {
            Service next = it.next();
            Service.State state = next.state();
            Preconditions.checkState(state == Service.State.NEW, "Service %s is %s, cannot start it.", next, state);
        }
        UnmodifiableIterator<Service> it2 = this.services.iterator();
        while (it2.hasNext()) {
            Service next2 = it2.next();
            try {
                this.state.b(next2);
                next2.startAsync();
            } catch (IllegalStateException e) {
                logger.log(Level.WARNING, "Unable to start Service " + next2, (Throwable) e);
            }
        }
        return this;
    }

    public ImmutableMap<Service, Long> startupTimes() {
        return this.state.i();
    }

    @CanIgnoreReturnValue
    public ServiceManager stopAsync() {
        UnmodifiableIterator<Service> it = this.services.iterator();
        while (it.hasNext()) {
            it.next().stopAsync();
        }
        return this;
    }

    public String toString() {
        return MoreObjects.toStringHelper((Class<?>) ServiceManager.class).add("services", Collections2.filter(this.services, Predicates.not(Predicates.instanceOf(NoOpService.class)))).toString();
    }
}
