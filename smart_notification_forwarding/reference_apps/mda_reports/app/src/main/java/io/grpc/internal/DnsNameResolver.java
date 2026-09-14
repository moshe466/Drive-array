package io.grpc.internal;

import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import com.google.common.base.Stopwatch;
import com.google.common.base.Throwables;
import com.google.common.base.Verify;
import com.google.common.base.VerifyException;
import io.grpc.Attributes;
import io.grpc.EquivalentAddressGroup;
import io.grpc.NameResolver;
import io.grpc.ProxiedSocketAddress;
import io.grpc.ProxyDetector;
import io.grpc.Status;
import io.grpc.SynchronizationContext;
import io.grpc.internal.SharedResourceHolder;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.URI;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class DnsNameResolver extends NameResolver {
    private static final String GRPCLB_NAME_PREFIX = "_grpclb._tcp.";
    private static final String SERVICE_CONFIG_NAME_PREFIX = "_grpc_config.";
    private static String localHostname;

    @VisibleForTesting
    final ProxyDetector a;
    private final String authority;
    private final long cacheTtlNanos;
    private ResolutionResults cachedResolutionResults;
    private Executor executor;
    private final SharedResourceHolder.Resource<Executor> executorResource;
    private final String host;
    private NameResolver.Listener2 listener;
    private final int port;
    private boolean resolving;
    private boolean shutdown;
    private final Stopwatch stopwatch;
    private final SynchronizationContext syncContext;
    private static final Logger logger = Logger.getLogger(DnsNameResolver.class.getName());
    private static final String SERVICE_CONFIG_CHOICE_CLIENT_LANGUAGE_KEY = "clientLanguage";
    private static final String SERVICE_CONFIG_CHOICE_PERCENTAGE_KEY = "percentage";
    private static final String SERVICE_CONFIG_CHOICE_CLIENT_HOSTNAME_KEY = "clientHostname";
    private static final String SERVICE_CONFIG_CHOICE_SERVICE_CONFIG_KEY = "serviceConfig";
    private static final Set<String> SERVICE_CONFIG_CHOICE_KEYS = Collections.unmodifiableSet(new HashSet(Arrays.asList(SERVICE_CONFIG_CHOICE_CLIENT_LANGUAGE_KEY, SERVICE_CONFIG_CHOICE_PERCENTAGE_KEY, SERVICE_CONFIG_CHOICE_CLIENT_HOSTNAME_KEY, SERVICE_CONFIG_CHOICE_SERVICE_CONFIG_KEY)));
    private static final String JNDI_PROPERTY = System.getProperty("io.grpc.internal.DnsNameResolverProvider.enable_jndi", "true");
    private static final String JNDI_LOCALHOST_PROPERTY = System.getProperty("io.grpc.internal.DnsNameResolverProvider.enable_jndi_localhost", "false");
    private static final String JNDI_SRV_PROPERTY = System.getProperty("io.grpc.internal.DnsNameResolverProvider.enable_grpclb", "false");
    private static final String JNDI_TXT_PROPERTY = System.getProperty("io.grpc.internal.DnsNameResolverProvider.enable_service_config", "false");

    @VisibleForTesting
    static boolean b = Boolean.parseBoolean(JNDI_PROPERTY);

    @VisibleForTesting
    static boolean c = Boolean.parseBoolean(JNDI_LOCALHOST_PROPERTY);

    @VisibleForTesting
    static boolean d = Boolean.parseBoolean(JNDI_SRV_PROPERTY);

    @VisibleForTesting
    static boolean e = Boolean.parseBoolean(JNDI_TXT_PROPERTY);
    private static final ResourceResolverFactory resourceResolverFactory = a(DnsNameResolver.class.getClassLoader());
    private final Random random = new Random();
    private volatile AddressResolver addressResolver = JdkAddressResolver.INSTANCE;
    private final AtomicReference<ResourceResolver> resourceResolver = new AtomicReference<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public interface AddressResolver {
        List<InetAddress> resolveAddress(String str);
    }

    /* loaded from: classes2.dex */
    private enum JdkAddressResolver implements AddressResolver {
        INSTANCE;

        @Override // io.grpc.internal.DnsNameResolver.AddressResolver
        public List<InetAddress> resolveAddress(String str) {
            return Collections.unmodifiableList(Arrays.asList(InetAddress.getAllByName(str)));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @VisibleForTesting
    /* loaded from: classes2.dex */
    public static final class ResolutionResults {
        final List<? extends InetAddress> a;
        final List<String> b;
        final List<EquivalentAddressGroup> c;

        ResolutionResults(List<? extends InetAddress> list, List<String> list2, List<EquivalentAddressGroup> list3) {
            this.a = Collections.unmodifiableList((List) Preconditions.checkNotNull(list, "addresses"));
            this.b = Collections.unmodifiableList((List) Preconditions.checkNotNull(list2, "txtRecords"));
            this.c = Collections.unmodifiableList((List) Preconditions.checkNotNull(list3, "balancerAddresses"));
        }

        public String toString() {
            return MoreObjects.toStringHelper(this).add("addresses", this.a).add("txtRecords", this.b).add("balancerAddresses", this.c).toString();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public final class Resolve implements Runnable {
        private final NameResolver.Listener2 savedListener;

        Resolve(NameResolver.Listener2 listener2) {
            this.savedListener = (NameResolver.Listener2) Preconditions.checkNotNull(listener2, "savedListener");
        }

        @VisibleForTesting
        void a() {
            try {
                ProxiedSocketAddress proxyFor = DnsNameResolver.this.a.proxyFor(InetSocketAddress.createUnresolved(DnsNameResolver.this.host, DnsNameResolver.this.port));
                if (proxyFor != null) {
                    if (DnsNameResolver.logger.isLoggable(Level.FINER)) {
                        DnsNameResolver.logger.finer("Using proxy address " + proxyFor);
                    }
                    this.savedListener.onResult(NameResolver.ResolutionResult.newBuilder().setAddresses(Collections.singletonList(new EquivalentAddressGroup(proxyFor))).setAttributes(Attributes.EMPTY).build());
                    return;
                }
                try {
                    final ResolutionResults a = DnsNameResolver.a(DnsNameResolver.this.addressResolver, DnsNameResolver.a(DnsNameResolver.b, DnsNameResolver.c, DnsNameResolver.this.host) ? DnsNameResolver.this.getResourceResolver() : null, DnsNameResolver.d, DnsNameResolver.e, DnsNameResolver.this.host);
                    DnsNameResolver.this.syncContext.execute(new Runnable() { // from class: io.grpc.internal.DnsNameResolver.Resolve.2
                        @Override // java.lang.Runnable
                        public void run() {
                            DnsNameResolver.this.cachedResolutionResults = a;
                            if (DnsNameResolver.this.cacheTtlNanos > 0) {
                                DnsNameResolver.this.stopwatch.reset().start();
                            }
                        }
                    });
                    if (DnsNameResolver.logger.isLoggable(Level.FINER)) {
                        DnsNameResolver.logger.finer("Found DNS results " + a + " for " + DnsNameResolver.this.host);
                    }
                    ArrayList arrayList = new ArrayList();
                    Iterator<? extends InetAddress> it = a.a.iterator();
                    while (it.hasNext()) {
                        arrayList.add(new EquivalentAddressGroup(new InetSocketAddress(it.next(), DnsNameResolver.this.port)));
                    }
                    arrayList.addAll(a.c);
                    if (arrayList.isEmpty()) {
                        this.savedListener.onError(Status.UNAVAILABLE.withDescription("No DNS backend or balancer addresses found for " + DnsNameResolver.this.host));
                        return;
                    }
                    Attributes.Builder newBuilder = Attributes.newBuilder();
                    if (a.b.isEmpty()) {
                        DnsNameResolver.logger.log(Level.FINE, "No TXT records found for {0}", new Object[]{DnsNameResolver.this.host});
                    } else {
                        NameResolver.ConfigOrError a2 = DnsNameResolver.a(a.b, DnsNameResolver.this.random, DnsNameResolver.b());
                        if (a2 != null) {
                            if (a2.getError() != null) {
                                this.savedListener.onError(a2.getError());
                                return;
                            }
                            newBuilder.set(GrpcAttributes.NAME_RESOLVER_SERVICE_CONFIG, (Map) a2.getConfig());
                        }
                    }
                    this.savedListener.onResult(NameResolver.ResolutionResult.newBuilder().setAddresses(arrayList).setAttributes(newBuilder.build()).build());
                } catch (Exception e) {
                    this.savedListener.onError(Status.UNAVAILABLE.withDescription("Unable to resolve host " + DnsNameResolver.this.host).withCause(e));
                }
            } catch (IOException e2) {
                this.savedListener.onError(Status.UNAVAILABLE.withDescription("Unable to resolve host " + DnsNameResolver.this.host).withCause(e2));
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            if (DnsNameResolver.logger.isLoggable(Level.FINER)) {
                DnsNameResolver.logger.finer("Attempting DNS resolution of " + DnsNameResolver.this.host);
            }
            try {
                a();
            } finally {
                DnsNameResolver.this.syncContext.execute(new Runnable() { // from class: io.grpc.internal.DnsNameResolver.Resolve.1
                    @Override // java.lang.Runnable
                    public void run() {
                        DnsNameResolver.this.resolving = false;
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public interface ResourceResolver {
        List<EquivalentAddressGroup> resolveSrv(AddressResolver addressResolver, String str);

        List<String> resolveTxt(String str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public interface ResourceResolverFactory {
        @Nullable
        ResourceResolver newResourceResolver();

        @Nullable
        Throwable unavailabilityCause();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public DnsNameResolver(@Nullable String str, String str2, NameResolver.Args args, SharedResourceHolder.Resource<Executor> resource, Stopwatch stopwatch, boolean z) {
        Preconditions.checkNotNull(args, "args");
        this.executorResource = resource;
        URI create = URI.create("//" + ((String) Preconditions.checkNotNull(str2, AppMeasurementSdk.ConditionalUserProperty.NAME)));
        Preconditions.checkArgument(create.getHost() != null, "Invalid DNS name: %s", str2);
        this.authority = (String) Preconditions.checkNotNull(create.getAuthority(), "nameUri (%s) doesn't have an authority", create);
        this.host = create.getHost();
        this.port = create.getPort() == -1 ? args.getDefaultPort() : create.getPort();
        this.a = (ProxyDetector) Preconditions.checkNotNull(args.getProxyDetector(), "proxyDetector");
        this.cacheTtlNanos = getNetworkAddressCacheTtlNanos(z);
        this.stopwatch = (Stopwatch) Preconditions.checkNotNull(stopwatch, "stopwatch");
        this.syncContext = (SynchronizationContext) Preconditions.checkNotNull(args.getSynchronizationContext(), "syncContext");
    }

    @Nullable
    static NameResolver.ConfigOrError a(List<String> list, Random random, String str) {
        Status status;
        String str2;
        try {
            Iterator<Map<String, ?>> it = a(list).iterator();
            Map<String, ?> map = null;
            while (it.hasNext()) {
                try {
                    map = a(it.next(), random, str);
                    if (map != null) {
                        break;
                    }
                } catch (RuntimeException e2) {
                    e = e2;
                    status = Status.UNKNOWN;
                    str2 = "failed to pick service config choice";
                    return NameResolver.ConfigOrError.fromError(status.withDescription(str2).withCause(e));
                }
            }
            if (map == null) {
                return null;
            }
            return NameResolver.ConfigOrError.fromConfig(map);
        } catch (IOException | RuntimeException e3) {
            e = e3;
            status = Status.UNKNOWN;
            str2 = "failed to parse TXT records";
        }
    }

    @VisibleForTesting
    static ResolutionResults a(AddressResolver addressResolver, @Nullable ResourceResolver resourceResolver, boolean z, boolean z2, String str) {
        Exception e2;
        List<InetAddress> emptyList = Collections.emptyList();
        List<EquivalentAddressGroup> emptyList2 = Collections.emptyList();
        List<String> emptyList3 = Collections.emptyList();
        Exception exc = null;
        try {
            emptyList = addressResolver.resolveAddress(str);
            e = null;
        } catch (Exception e3) {
            e = e3;
        }
        if (resourceResolver != null) {
            if (z) {
                try {
                    emptyList2 = resourceResolver.resolveSrv(addressResolver, GRPCLB_NAME_PREFIX + str);
                } catch (Exception e4) {
                    e2 = e4;
                }
            }
            e2 = null;
            if (z2) {
                boolean z3 = false;
                boolean z4 = (z && e2 == null) ? false : true;
                if (e != null && z4) {
                    z3 = true;
                }
                if (!z3) {
                    try {
                        emptyList3 = resourceResolver.resolveTxt(SERVICE_CONFIG_NAME_PREFIX + str);
                    } catch (Exception e5) {
                        exc = e5;
                    }
                }
            }
        } else {
            e2 = null;
        }
        if (e != null) {
            if (e2 == null) {
                try {
                    if (!emptyList2.isEmpty()) {
                    }
                } finally {
                    if (e != null) {
                        logger.log(Level.FINE, "Address resolution failure", (Throwable) e);
                    }
                    if (e2 != null) {
                        logger.log(Level.FINE, "Balancer resolution failure", (Throwable) e2);
                    }
                    if (exc != null) {
                        logger.log(Level.FINE, "ServiceConfig resolution failure", (Throwable) exc);
                    }
                }
            }
            Throwables.throwIfUnchecked(e);
            throw new RuntimeException(e);
        }
        return new ResolutionResults(emptyList, emptyList3, emptyList2);
    }

    @VisibleForTesting
    @Nullable
    static ResourceResolverFactory a(ClassLoader classLoader) {
        Logger logger2;
        Level level;
        String str;
        ResourceResolverFactory resourceResolverFactory2;
        try {
            try {
                try {
                    resourceResolverFactory2 = (ResourceResolverFactory) Class.forName("io.grpc.internal.JndiResourceResolverFactory", true, classLoader).asSubclass(ResourceResolverFactory.class).getConstructor(new Class[0]).newInstance(new Object[0]);
                } catch (Exception e2) {
                    e = e2;
                    logger2 = logger;
                    level = Level.FINE;
                    str = "Can't construct JndiResourceResolverFactory, skipping.";
                }
            } catch (Exception e3) {
                e = e3;
                logger2 = logger;
                level = Level.FINE;
                str = "Can't find JndiResourceResolverFactory ctor, skipping.";
            }
        } catch (ClassNotFoundException e4) {
            e = e4;
            logger2 = logger;
            level = Level.FINE;
            str = "Unable to find JndiResourceResolverFactory, skipping.";
        }
        if (resourceResolverFactory2.unavailabilityCause() == null) {
            return resourceResolverFactory2;
        }
        logger2 = logger;
        level = Level.FINE;
        e = resourceResolverFactory2.unavailabilityCause();
        str = "JndiResourceResolverFactory not available, skipping.";
        logger2.log(level, str, e);
        return null;
    }

    @VisibleForTesting
    static List<Map<String, ?>> a(List<String> list) {
        ArrayList arrayList = new ArrayList();
        for (String str : list) {
            if (str.startsWith("grpc_config=")) {
                Object parse = JsonParser.parse(str.substring(12));
                if (!(parse instanceof List)) {
                    throw new ClassCastException("wrong type " + parse);
                }
                List list2 = (List) parse;
                ServiceConfigUtil.a((List<?>) list2);
                arrayList.addAll(list2);
            } else {
                logger.log(Level.FINE, "Ignoring non service config {0}", new Object[]{str});
            }
        }
        return arrayList;
    }

    @VisibleForTesting
    @Nullable
    static Map<String, ?> a(Map<String, ?> map, Random random, String str) {
        boolean z;
        boolean z2;
        for (Map.Entry<String, ?> entry : map.entrySet()) {
            Verify.verify(SERVICE_CONFIG_CHOICE_KEYS.contains(entry.getKey()), "Bad key: %s", entry);
        }
        List<String> clientLanguagesFromChoice = getClientLanguagesFromChoice(map);
        if (clientLanguagesFromChoice != null && !clientLanguagesFromChoice.isEmpty()) {
            Iterator<String> it = clientLanguagesFromChoice.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z2 = false;
                    break;
                }
                if ("java".equalsIgnoreCase(it.next())) {
                    z2 = true;
                    break;
                }
            }
            if (!z2) {
                return null;
            }
        }
        Double percentageFromChoice = getPercentageFromChoice(map);
        if (percentageFromChoice != null) {
            int intValue = percentageFromChoice.intValue();
            Verify.verify(intValue >= 0 && intValue <= 100, "Bad percentage: %s", percentageFromChoice);
            if (random.nextInt(100) >= intValue) {
                return null;
            }
        }
        List<String> hostnamesFromChoice = getHostnamesFromChoice(map);
        if (hostnamesFromChoice != null && !hostnamesFromChoice.isEmpty()) {
            Iterator<String> it2 = hostnamesFromChoice.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    z = false;
                    break;
                }
                if (it2.next().equals(str)) {
                    z = true;
                    break;
                }
            }
            if (!z) {
                return null;
            }
        }
        Map<String, ?> d2 = ServiceConfigUtil.d(map, SERVICE_CONFIG_CHOICE_SERVICE_CONFIG_KEY);
        if (d2 != null) {
            return d2;
        }
        throw new VerifyException(String.format("key '%s' missing in '%s'", map, SERVICE_CONFIG_CHOICE_SERVICE_CONFIG_KEY));
    }

    @VisibleForTesting
    static boolean a(boolean z, boolean z2, String str) {
        if (!z) {
            return false;
        }
        if ("localhost".equalsIgnoreCase(str)) {
            return z2;
        }
        if (str.contains(":")) {
            return false;
        }
        boolean z3 = true;
        for (int i = 0; i < str.length(); i++) {
            char charAt = str.charAt(i);
            if (charAt != '.') {
                z3 &= charAt >= '0' && charAt <= '9';
            }
        }
        return true ^ z3;
    }

    static /* synthetic */ String b() {
        return getLocalHostname();
    }

    private boolean cacheRefreshRequired() {
        if (this.cachedResolutionResults != null) {
            long j = this.cacheTtlNanos;
            if (j != 0 && (j <= 0 || this.stopwatch.elapsed(TimeUnit.NANOSECONDS) <= this.cacheTtlNanos)) {
                return false;
            }
        }
        return true;
    }

    @Nullable
    private static final List<String> getClientLanguagesFromChoice(Map<String, ?> map) {
        if (!map.containsKey(SERVICE_CONFIG_CHOICE_CLIENT_LANGUAGE_KEY)) {
            return null;
        }
        List c2 = ServiceConfigUtil.c(map, SERVICE_CONFIG_CHOICE_CLIENT_LANGUAGE_KEY);
        ServiceConfigUtil.b((List<?>) c2);
        return c2;
    }

    @Nullable
    private static final List<String> getHostnamesFromChoice(Map<String, ?> map) {
        if (!map.containsKey(SERVICE_CONFIG_CHOICE_CLIENT_HOSTNAME_KEY)) {
            return null;
        }
        List c2 = ServiceConfigUtil.c(map, SERVICE_CONFIG_CHOICE_CLIENT_HOSTNAME_KEY);
        ServiceConfigUtil.b((List<?>) c2);
        return c2;
    }

    private static String getLocalHostname() {
        if (localHostname == null) {
            try {
                localHostname = InetAddress.getLocalHost().getHostName();
            } catch (UnknownHostException e2) {
                throw new RuntimeException(e2);
            }
        }
        return localHostname;
    }

    private static long getNetworkAddressCacheTtlNanos(boolean z) {
        if (z) {
            return 0L;
        }
        String property = System.getProperty("networkaddress.cache.ttl");
        long j = 30;
        if (property != null) {
            try {
                j = Long.parseLong(property);
            } catch (NumberFormatException unused) {
                logger.log(Level.WARNING, "Property({0}) valid is not valid number format({1}), fall back to default({2})", new Object[]{"networkaddress.cache.ttl", property, 30L});
            }
        }
        return j > 0 ? TimeUnit.SECONDS.toNanos(j) : j;
    }

    @Nullable
    private static final Double getPercentageFromChoice(Map<String, ?> map) {
        if (map.containsKey(SERVICE_CONFIG_CHOICE_PERCENTAGE_KEY)) {
            return ServiceConfigUtil.b(map, SERVICE_CONFIG_CHOICE_PERCENTAGE_KEY);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Nullable
    public ResourceResolver getResourceResolver() {
        ResourceResolverFactory resourceResolverFactory2;
        ResourceResolver resourceResolver = this.resourceResolver.get();
        return (resourceResolver != null || (resourceResolverFactory2 = resourceResolverFactory) == null) ? resourceResolver : resourceResolverFactory2.newResourceResolver();
    }

    private void resolve() {
        if (this.resolving || this.shutdown || !cacheRefreshRequired()) {
            return;
        }
        this.resolving = true;
        this.executor.execute(new Resolve(this.listener));
    }

    @Override // io.grpc.NameResolver
    public String getServiceAuthority() {
        return this.authority;
    }

    @Override // io.grpc.NameResolver
    public void refresh() {
        Preconditions.checkState(this.listener != null, "not started");
        resolve();
    }

    @Override // io.grpc.NameResolver
    public void shutdown() {
        if (this.shutdown) {
            return;
        }
        this.shutdown = true;
        Executor executor = this.executor;
        if (executor != null) {
            this.executor = (Executor) SharedResourceHolder.release(this.executorResource, executor);
        }
    }

    @Override // io.grpc.NameResolver
    public void start(NameResolver.Listener2 listener2) {
        Preconditions.checkState(this.listener == null, "already started");
        this.executor = (Executor) SharedResourceHolder.get(this.executorResource);
        this.listener = (NameResolver.Listener2) Preconditions.checkNotNull(listener2, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        resolve();
    }
}
