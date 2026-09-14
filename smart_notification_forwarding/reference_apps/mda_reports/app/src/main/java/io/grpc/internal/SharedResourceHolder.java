package io.grpc.internal;

import com.google.common.base.Preconditions;
import java.util.IdentityHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import javax.annotation.concurrent.ThreadSafe;

@ThreadSafe
/* loaded from: classes2.dex */
public final class SharedResourceHolder {
    private static final SharedResourceHolder holder = new SharedResourceHolder(new ScheduledExecutorFactory() { // from class: io.grpc.internal.SharedResourceHolder.1
        @Override // io.grpc.internal.SharedResourceHolder.ScheduledExecutorFactory
        public ScheduledExecutorService createScheduledExecutor() {
            return Executors.newSingleThreadScheduledExecutor(GrpcUtil.getThreadFactory("grpc-shared-destroyer-%d", true));
        }
    });
    private ScheduledExecutorService destroyer;
    private final ScheduledExecutorFactory destroyerFactory;
    private final IdentityHashMap<Resource<?>, Instance> instances = new IdentityHashMap<>();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class Instance {
        final Object a;
        int b;
        ScheduledFuture<?> c;

        Instance(Object obj) {
            this.a = obj;
        }
    }

    /* loaded from: classes2.dex */
    public interface Resource<T> {
        void close(T t);

        T create();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public interface ScheduledExecutorFactory {
        ScheduledExecutorService createScheduledExecutor();
    }

    SharedResourceHolder(ScheduledExecutorFactory scheduledExecutorFactory) {
        this.destroyerFactory = scheduledExecutorFactory;
    }

    public static <T> T get(Resource<T> resource) {
        return (T) holder.a(resource);
    }

    public static <T> T release(Resource<T> resource, T t) {
        return (T) holder.a((Resource<Resource<T>>) resource, (Resource<T>) t);
    }

    synchronized <T> T a(Resource<T> resource) {
        Instance instance;
        instance = this.instances.get(resource);
        if (instance == null) {
            instance = new Instance(resource.create());
            this.instances.put(resource, instance);
        }
        if (instance.c != null) {
            instance.c.cancel(false);
            instance.c = null;
        }
        instance.b++;
        return (T) instance.a;
    }

    synchronized <T> T a(final Resource<T> resource, final T t) {
        final Instance instance = this.instances.get(resource);
        if (instance == null) {
            throw new IllegalArgumentException("No cached instance found for " + resource);
        }
        Preconditions.checkArgument(t == instance.a, "Releasing the wrong instance");
        Preconditions.checkState(instance.b > 0, "Refcount has already reached zero");
        instance.b--;
        if (instance.b == 0) {
            if (GrpcUtil.IS_RESTRICTED_APPENGINE) {
                resource.close(t);
                this.instances.remove(resource);
            } else {
                Preconditions.checkState(instance.c == null, "Destroy task already scheduled");
                if (this.destroyer == null) {
                    this.destroyer = this.destroyerFactory.createScheduledExecutor();
                }
                instance.c = this.destroyer.schedule(new LogExceptionRunnable(new Runnable() { // from class: io.grpc.internal.SharedResourceHolder.2
                    @Override // java.lang.Runnable
                    public void run() {
                        synchronized (SharedResourceHolder.this) {
                            if (instance.b == 0) {
                                resource.close(t);
                                SharedResourceHolder.this.instances.remove(resource);
                                if (SharedResourceHolder.this.instances.isEmpty()) {
                                    SharedResourceHolder.this.destroyer.shutdown();
                                    SharedResourceHolder.this.destroyer = null;
                                }
                            }
                        }
                    }
                }), 1L, TimeUnit.SECONDS);
            }
        }
        return null;
    }
}
