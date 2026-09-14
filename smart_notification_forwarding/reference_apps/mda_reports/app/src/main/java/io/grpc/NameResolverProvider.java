package io.grpc;

import io.grpc.Attributes;
import io.grpc.NameResolver;
import java.util.List;

@ExperimentalApi("https://github.com/grpc/grpc-java/issues/4159")
/* loaded from: classes2.dex */
public abstract class NameResolverProvider extends NameResolver.Factory {

    @Deprecated
    public static final Attributes.Key<Integer> PARAMS_DEFAULT_PORT = NameResolver.Factory.PARAMS_DEFAULT_PORT;

    @Deprecated
    public static NameResolver.Factory asFactory() {
        return NameResolverRegistry.getDefaultRegistry().asFactory();
    }

    @Deprecated
    public static List<NameResolverProvider> providers() {
        return NameResolverRegistry.getDefaultRegistry().a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract boolean a();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract int b();
}
