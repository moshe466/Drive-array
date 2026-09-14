package io.grpc;

import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import javax.annotation.Nullable;

/* loaded from: classes2.dex */
public final class ServiceDescriptor {
    private final Collection<MethodDescriptor<?, ?>> methods;
    private final String name;
    private final Object schemaDescriptor;

    /* loaded from: classes2.dex */
    public static final class Builder {
        private List<MethodDescriptor<?, ?>> methods;
        private String name;
        private Object schemaDescriptor;

        private Builder(String str) {
            this.methods = new ArrayList();
            setName(str);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public Builder addAllMethods(Collection<MethodDescriptor<?, ?>> collection) {
            this.methods.addAll(collection);
            return this;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public Builder addMethod(MethodDescriptor<?, ?> methodDescriptor) {
            this.methods.add(Preconditions.checkNotNull(methodDescriptor, FirebaseAnalytics.Param.METHOD));
            return this;
        }

        public ServiceDescriptor build() {
            return new ServiceDescriptor(this);
        }

        @ExperimentalApi("https://github.com/grpc/grpc-java/issues/2666")
        public Builder setName(String str) {
            this.name = (String) Preconditions.checkNotNull(str, AppMeasurementSdk.ConditionalUserProperty.NAME);
            return this;
        }

        public Builder setSchemaDescriptor(@Nullable Object obj) {
            this.schemaDescriptor = obj;
            return this;
        }
    }

    private ServiceDescriptor(Builder builder) {
        this.name = builder.name;
        a(this.name, builder.methods);
        this.methods = Collections.unmodifiableList(new ArrayList(builder.methods));
        this.schemaDescriptor = builder.schemaDescriptor;
    }

    public ServiceDescriptor(String str, Collection<MethodDescriptor<?, ?>> collection) {
        this(newBuilder(str).addAllMethods((Collection) Preconditions.checkNotNull(collection, "methods")));
    }

    public ServiceDescriptor(String str, MethodDescriptor<?, ?>... methodDescriptorArr) {
        this(str, Arrays.asList(methodDescriptorArr));
    }

    static void a(String str, Collection<MethodDescriptor<?, ?>> collection) {
        HashSet hashSet = new HashSet(collection.size());
        for (MethodDescriptor<?, ?> methodDescriptor : collection) {
            Preconditions.checkNotNull(methodDescriptor, FirebaseAnalytics.Param.METHOD);
            String serviceName = methodDescriptor.getServiceName();
            Preconditions.checkArgument(str.equals(serviceName), "service names %s != %s", serviceName, str);
            Preconditions.checkArgument(hashSet.add(methodDescriptor.getFullMethodName()), "duplicate name %s", methodDescriptor.getFullMethodName());
        }
    }

    public static Builder newBuilder(String str) {
        return new Builder(str);
    }

    public Collection<MethodDescriptor<?, ?>> getMethods() {
        return this.methods;
    }

    public String getName() {
        return this.name;
    }

    @ExperimentalApi("https://github.com/grpc/grpc-java/issues/2222")
    @Nullable
    public Object getSchemaDescriptor() {
        return this.schemaDescriptor;
    }

    public String toString() {
        return MoreObjects.toStringHelper(this).add(AppMeasurementSdk.ConditionalUserProperty.NAME, this.name).add("schemaDescriptor", this.schemaDescriptor).add("methods", this.methods).omitNullValues().toString();
    }
}
