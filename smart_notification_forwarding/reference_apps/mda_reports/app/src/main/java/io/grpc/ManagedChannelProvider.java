package io.grpc;

import com.google.common.annotations.VisibleForTesting;
import io.grpc.ServiceProviders;
import java.util.ArrayList;
import java.util.Iterator;

@Internal
/* loaded from: classes2.dex */
public abstract class ManagedChannelProvider {

    @VisibleForTesting
    static final Iterable<Class<?>> a = new HardcodedClasses();
    private static final ManagedChannelProvider provider = (ManagedChannelProvider) ServiceProviders.load(ManagedChannelProvider.class, a, ManagedChannelProvider.class.getClassLoader(), new ServiceProviders.PriorityAccessor<ManagedChannelProvider>() { // from class: io.grpc.ManagedChannelProvider.1
        @Override // io.grpc.ServiceProviders.PriorityAccessor
        public int getPriority(ManagedChannelProvider managedChannelProvider) {
            return managedChannelProvider.priority();
        }

        @Override // io.grpc.ServiceProviders.PriorityAccessor
        public boolean isAvailable(ManagedChannelProvider managedChannelProvider) {
            return managedChannelProvider.isAvailable();
        }
    });

    /* loaded from: classes2.dex */
    private static final class HardcodedClasses implements Iterable<Class<?>> {
        private HardcodedClasses() {
        }

        @Override // java.lang.Iterable
        public Iterator<Class<?>> iterator() {
            ArrayList arrayList = new ArrayList();
            try {
                arrayList.add(Class.forName("io.grpc.okhttp.OkHttpChannelProvider"));
            } catch (ClassNotFoundException unused) {
            }
            try {
                arrayList.add(Class.forName("io.grpc.netty.NettyChannelProvider"));
            } catch (ClassNotFoundException unused2) {
            }
            return arrayList.iterator();
        }
    }

    /* loaded from: classes2.dex */
    public static final class ProviderNotFoundException extends RuntimeException {
        private static final long serialVersionUID = 1;

        public ProviderNotFoundException(String str) {
            super(str);
        }
    }

    public static ManagedChannelProvider provider() {
        ManagedChannelProvider managedChannelProvider = provider;
        if (managedChannelProvider != null) {
            return managedChannelProvider;
        }
        throw new ProviderNotFoundException("No functional channel service provider found. Try adding a dependency on the grpc-okhttp, grpc-netty, or grpc-netty-shaded artifact");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract ManagedChannelBuilder<?> builderForAddress(String str, int i);

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract ManagedChannelBuilder<?> builderForTarget(String str);

    protected abstract boolean isAvailable();

    protected abstract int priority();
}
