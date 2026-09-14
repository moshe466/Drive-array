package io.grpc;

import androidx.core.os.EnvironmentCompat;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import io.grpc.NameResolver;
import io.grpc.ServiceProviders;
import java.net.URI;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
import javax.annotation.concurrent.ThreadSafe;

@ExperimentalApi("https://github.com/grpc/grpc-java/issues/4159")
@ThreadSafe
/* loaded from: classes2.dex */
public final class NameResolverRegistry {
    private static NameResolverRegistry instance;
    private static final Logger logger = Logger.getLogger(NameResolverRegistry.class.getName());
    private final NameResolver.Factory factory = new NameResolverFactory();

    @GuardedBy("this")
    private final LinkedHashSet<NameResolverProvider> allProviders = new LinkedHashSet<>();

    @GuardedBy("this")
    private List<NameResolverProvider> effectiveProviders = Collections.emptyList();

    /* loaded from: classes2.dex */
    private final class NameResolverFactory extends NameResolver.Factory {
        private NameResolverFactory() {
        }

        @Override // io.grpc.NameResolver.Factory
        public String getDefaultScheme() {
            List<NameResolverProvider> a = NameResolverRegistry.this.a();
            return a.isEmpty() ? EnvironmentCompat.MEDIA_UNKNOWN : a.get(0).getDefaultScheme();
        }

        @Override // io.grpc.NameResolver.Factory
        @Nullable
        public NameResolver newNameResolver(URI uri, NameResolver.Args args) {
            Iterator<NameResolverProvider> it = NameResolverRegistry.this.a().iterator();
            while (it.hasNext()) {
                NameResolver newNameResolver = it.next().newNameResolver(uri, args);
                if (newNameResolver != null) {
                    return newNameResolver;
                }
            }
            return null;
        }
    }

    /* loaded from: classes2.dex */
    private static final class NameResolverPriorityAccessor implements ServiceProviders.PriorityAccessor<NameResolverProvider> {
        private NameResolverPriorityAccessor() {
        }

        @Override // io.grpc.ServiceProviders.PriorityAccessor
        public int getPriority(NameResolverProvider nameResolverProvider) {
            return nameResolverProvider.b();
        }

        @Override // io.grpc.ServiceProviders.PriorityAccessor
        public boolean isAvailable(NameResolverProvider nameResolverProvider) {
            return nameResolverProvider.a();
        }
    }

    private synchronized void addProvider(NameResolverProvider nameResolverProvider) {
        Preconditions.checkArgument(nameResolverProvider.a(), "isAvailable() returned false");
        this.allProviders.add(nameResolverProvider);
    }

    @VisibleForTesting
    static List<Class<?>> b() {
        ArrayList arrayList = new ArrayList();
        try {
            arrayList.add(Class.forName("io.grpc.internal.DnsNameResolverProvider"));
        } catch (ClassNotFoundException e) {
            logger.log(Level.FINE, "Unable to find DNS NameResolver", (Throwable) e);
        }
        return Collections.unmodifiableList(arrayList);
    }

    public static synchronized NameResolverRegistry getDefaultRegistry() {
        NameResolverRegistry nameResolverRegistry;
        synchronized (NameResolverRegistry.class) {
            if (instance == null) {
                List<NameResolverProvider> loadAll = ServiceProviders.loadAll(NameResolverProvider.class, b(), NameResolverProvider.class.getClassLoader(), new NameResolverPriorityAccessor());
                if (loadAll.isEmpty()) {
                    logger.warning("No NameResolverProviders found via ServiceLoader, including for DNS. This is probably due to a broken build. If using ProGuard, check your configuration");
                }
                instance = new NameResolverRegistry();
                for (NameResolverProvider nameResolverProvider : loadAll) {
                    logger.fine("Service loader found " + nameResolverProvider);
                    if (nameResolverProvider.a()) {
                        instance.addProvider(nameResolverProvider);
                    }
                }
                instance.refreshProviders();
            }
            nameResolverRegistry = instance;
        }
        return nameResolverRegistry;
    }

    private synchronized void refreshProviders() {
        ArrayList arrayList = new ArrayList(this.allProviders);
        Collections.sort(arrayList, Collections.reverseOrder(new Comparator<NameResolverProvider>(this) { // from class: io.grpc.NameResolverRegistry.1
            @Override // java.util.Comparator
            public int compare(NameResolverProvider nameResolverProvider, NameResolverProvider nameResolverProvider2) {
                return nameResolverProvider.b() - nameResolverProvider2.b();
            }
        }));
        this.effectiveProviders = Collections.unmodifiableList(arrayList);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @VisibleForTesting
    public synchronized List<NameResolverProvider> a() {
        return this.effectiveProviders;
    }

    public NameResolver.Factory asFactory() {
        return this.factory;
    }

    public synchronized void deregister(NameResolverProvider nameResolverProvider) {
        this.allProviders.remove(nameResolverProvider);
        refreshProviders();
    }

    public synchronized void register(NameResolverProvider nameResolverProvider) {
        addProvider(nameResolverProvider);
        refreshProviders();
    }
}
