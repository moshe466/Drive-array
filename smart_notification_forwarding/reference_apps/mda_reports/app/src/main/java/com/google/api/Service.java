package com.google.api;

import com.google.api.Authentication;
import com.google.api.Backend;
import com.google.api.Billing;
import com.google.api.Context;
import com.google.api.Control;
import com.google.api.Documentation;
import com.google.api.Endpoint;
import com.google.api.Experimental;
import com.google.api.Http;
import com.google.api.LogDescriptor;
import com.google.api.Logging;
import com.google.api.MetricDescriptor;
import com.google.api.MonitoredResourceDescriptor;
import com.google.api.Monitoring;
import com.google.api.Quota;
import com.google.api.SourceInfo;
import com.google.api.SystemParameters;
import com.google.api.Usage;
import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.Api;
import com.google.protobuf.ApiOrBuilder;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.Enum;
import com.google.protobuf.EnumOrBuilder;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.MessageLite;
import com.google.protobuf.Parser;
import com.google.protobuf.Type;
import com.google.protobuf.TypeOrBuilder;
import com.google.protobuf.UInt32Value;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.List;

/* loaded from: classes2.dex */
public final class Service extends GeneratedMessageLite<Service, Builder> implements ServiceOrBuilder {
    public static final int APIS_FIELD_NUMBER = 3;
    public static final int AUTHENTICATION_FIELD_NUMBER = 11;
    public static final int BACKEND_FIELD_NUMBER = 8;
    public static final int BILLING_FIELD_NUMBER = 26;
    public static final int CONFIG_VERSION_FIELD_NUMBER = 20;
    public static final int CONTEXT_FIELD_NUMBER = 12;
    public static final int CONTROL_FIELD_NUMBER = 21;
    private static final Service DEFAULT_INSTANCE = new Service();
    public static final int DOCUMENTATION_FIELD_NUMBER = 6;
    public static final int ENDPOINTS_FIELD_NUMBER = 18;
    public static final int ENUMS_FIELD_NUMBER = 5;
    public static final int EXPERIMENTAL_FIELD_NUMBER = 101;
    public static final int HTTP_FIELD_NUMBER = 9;
    public static final int ID_FIELD_NUMBER = 33;
    public static final int LOGGING_FIELD_NUMBER = 27;
    public static final int LOGS_FIELD_NUMBER = 23;
    public static final int METRICS_FIELD_NUMBER = 24;
    public static final int MONITORED_RESOURCES_FIELD_NUMBER = 25;
    public static final int MONITORING_FIELD_NUMBER = 28;
    public static final int NAME_FIELD_NUMBER = 1;
    private static volatile Parser<Service> PARSER = null;
    public static final int PRODUCER_PROJECT_ID_FIELD_NUMBER = 22;
    public static final int QUOTA_FIELD_NUMBER = 10;
    public static final int SOURCE_INFO_FIELD_NUMBER = 37;
    public static final int SYSTEM_PARAMETERS_FIELD_NUMBER = 29;
    public static final int TITLE_FIELD_NUMBER = 2;
    public static final int TYPES_FIELD_NUMBER = 4;
    public static final int USAGE_FIELD_NUMBER = 15;
    private Authentication authentication_;
    private Backend backend_;
    private Billing billing_;
    private int bitField0_;
    private UInt32Value configVersion_;
    private Context context_;
    private Control control_;
    private Documentation documentation_;
    private Experimental experimental_;
    private Http http_;
    private Logging logging_;
    private Monitoring monitoring_;
    private Quota quota_;
    private SourceInfo sourceInfo_;
    private SystemParameters systemParameters_;
    private Usage usage_;
    private String name_ = "";
    private String id_ = "";
    private String title_ = "";
    private String producerProjectId_ = "";
    private Internal.ProtobufList<Api> apis_ = GeneratedMessageLite.f();
    private Internal.ProtobufList<Type> types_ = GeneratedMessageLite.f();
    private Internal.ProtobufList<Enum> enums_ = GeneratedMessageLite.f();
    private Internal.ProtobufList<Endpoint> endpoints_ = GeneratedMessageLite.f();
    private Internal.ProtobufList<LogDescriptor> logs_ = GeneratedMessageLite.f();
    private Internal.ProtobufList<MetricDescriptor> metrics_ = GeneratedMessageLite.f();
    private Internal.ProtobufList<MonitoredResourceDescriptor> monitoredResources_ = GeneratedMessageLite.f();

    /* renamed from: com.google.api.Service$1, reason: invalid class name */
    /* loaded from: classes2.dex */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] a = new int[GeneratedMessageLite.MethodToInvoke.values().length];

        static {
            try {
                a[GeneratedMessageLite.MethodToInvoke.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[GeneratedMessageLite.MethodToInvoke.IS_INITIALIZED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[GeneratedMessageLite.MethodToInvoke.MAKE_IMMUTABLE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[GeneratedMessageLite.MethodToInvoke.NEW_BUILDER.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[GeneratedMessageLite.MethodToInvoke.VISIT.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                a[GeneratedMessageLite.MethodToInvoke.MERGE_FROM_STREAM.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                a[GeneratedMessageLite.MethodToInvoke.GET_DEFAULT_INSTANCE.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                a[GeneratedMessageLite.MethodToInvoke.GET_PARSER.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
        }
    }

    /* loaded from: classes2.dex */
    public static final class Builder extends GeneratedMessageLite.Builder<Service, Builder> implements ServiceOrBuilder {
        private Builder() {
            super(Service.DEFAULT_INSTANCE);
        }

        /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        public Builder addAllApis(Iterable<? extends Api> iterable) {
            a();
            ((Service) this.a).addAllApis(iterable);
            return this;
        }

        public Builder addAllEndpoints(Iterable<? extends Endpoint> iterable) {
            a();
            ((Service) this.a).addAllEndpoints(iterable);
            return this;
        }

        public Builder addAllEnums(Iterable<? extends Enum> iterable) {
            a();
            ((Service) this.a).addAllEnums(iterable);
            return this;
        }

        public Builder addAllLogs(Iterable<? extends LogDescriptor> iterable) {
            a();
            ((Service) this.a).addAllLogs(iterable);
            return this;
        }

        public Builder addAllMetrics(Iterable<? extends MetricDescriptor> iterable) {
            a();
            ((Service) this.a).addAllMetrics(iterable);
            return this;
        }

        public Builder addAllMonitoredResources(Iterable<? extends MonitoredResourceDescriptor> iterable) {
            a();
            ((Service) this.a).addAllMonitoredResources(iterable);
            return this;
        }

        public Builder addAllTypes(Iterable<? extends Type> iterable) {
            a();
            ((Service) this.a).addAllTypes(iterable);
            return this;
        }

        public Builder addApis(int i, Api.Builder builder) {
            a();
            ((Service) this.a).addApis(i, builder);
            return this;
        }

        public Builder addApis(int i, Api api) {
            a();
            ((Service) this.a).addApis(i, api);
            return this;
        }

        public Builder addApis(Api.Builder builder) {
            a();
            ((Service) this.a).addApis(builder);
            return this;
        }

        public Builder addApis(Api api) {
            a();
            ((Service) this.a).addApis(api);
            return this;
        }

        public Builder addEndpoints(int i, Endpoint.Builder builder) {
            a();
            ((Service) this.a).addEndpoints(i, builder);
            return this;
        }

        public Builder addEndpoints(int i, Endpoint endpoint) {
            a();
            ((Service) this.a).addEndpoints(i, endpoint);
            return this;
        }

        public Builder addEndpoints(Endpoint.Builder builder) {
            a();
            ((Service) this.a).addEndpoints(builder);
            return this;
        }

        public Builder addEndpoints(Endpoint endpoint) {
            a();
            ((Service) this.a).addEndpoints(endpoint);
            return this;
        }

        public Builder addEnums(int i, Enum.Builder builder) {
            a();
            ((Service) this.a).addEnums(i, builder);
            return this;
        }

        public Builder addEnums(int i, Enum r3) {
            a();
            ((Service) this.a).addEnums(i, r3);
            return this;
        }

        public Builder addEnums(Enum.Builder builder) {
            a();
            ((Service) this.a).addEnums(builder);
            return this;
        }

        public Builder addEnums(Enum r2) {
            a();
            ((Service) this.a).addEnums(r2);
            return this;
        }

        public Builder addLogs(int i, LogDescriptor.Builder builder) {
            a();
            ((Service) this.a).addLogs(i, builder);
            return this;
        }

        public Builder addLogs(int i, LogDescriptor logDescriptor) {
            a();
            ((Service) this.a).addLogs(i, logDescriptor);
            return this;
        }

        public Builder addLogs(LogDescriptor.Builder builder) {
            a();
            ((Service) this.a).addLogs(builder);
            return this;
        }

        public Builder addLogs(LogDescriptor logDescriptor) {
            a();
            ((Service) this.a).addLogs(logDescriptor);
            return this;
        }

        public Builder addMetrics(int i, MetricDescriptor.Builder builder) {
            a();
            ((Service) this.a).addMetrics(i, builder);
            return this;
        }

        public Builder addMetrics(int i, MetricDescriptor metricDescriptor) {
            a();
            ((Service) this.a).addMetrics(i, metricDescriptor);
            return this;
        }

        public Builder addMetrics(MetricDescriptor.Builder builder) {
            a();
            ((Service) this.a).addMetrics(builder);
            return this;
        }

        public Builder addMetrics(MetricDescriptor metricDescriptor) {
            a();
            ((Service) this.a).addMetrics(metricDescriptor);
            return this;
        }

        public Builder addMonitoredResources(int i, MonitoredResourceDescriptor.Builder builder) {
            a();
            ((Service) this.a).addMonitoredResources(i, builder);
            return this;
        }

        public Builder addMonitoredResources(int i, MonitoredResourceDescriptor monitoredResourceDescriptor) {
            a();
            ((Service) this.a).addMonitoredResources(i, monitoredResourceDescriptor);
            return this;
        }

        public Builder addMonitoredResources(MonitoredResourceDescriptor.Builder builder) {
            a();
            ((Service) this.a).addMonitoredResources(builder);
            return this;
        }

        public Builder addMonitoredResources(MonitoredResourceDescriptor monitoredResourceDescriptor) {
            a();
            ((Service) this.a).addMonitoredResources(monitoredResourceDescriptor);
            return this;
        }

        public Builder addTypes(int i, Type.Builder builder) {
            a();
            ((Service) this.a).addTypes(i, builder);
            return this;
        }

        public Builder addTypes(int i, Type type) {
            a();
            ((Service) this.a).addTypes(i, type);
            return this;
        }

        public Builder addTypes(Type.Builder builder) {
            a();
            ((Service) this.a).addTypes(builder);
            return this;
        }

        public Builder addTypes(Type type) {
            a();
            ((Service) this.a).addTypes(type);
            return this;
        }

        public Builder clearApis() {
            a();
            ((Service) this.a).clearApis();
            return this;
        }

        public Builder clearAuthentication() {
            a();
            ((Service) this.a).clearAuthentication();
            return this;
        }

        public Builder clearBackend() {
            a();
            ((Service) this.a).clearBackend();
            return this;
        }

        public Builder clearBilling() {
            a();
            ((Service) this.a).clearBilling();
            return this;
        }

        public Builder clearConfigVersion() {
            a();
            ((Service) this.a).clearConfigVersion();
            return this;
        }

        public Builder clearContext() {
            a();
            ((Service) this.a).clearContext();
            return this;
        }

        public Builder clearControl() {
            a();
            ((Service) this.a).clearControl();
            return this;
        }

        public Builder clearDocumentation() {
            a();
            ((Service) this.a).clearDocumentation();
            return this;
        }

        public Builder clearEndpoints() {
            a();
            ((Service) this.a).clearEndpoints();
            return this;
        }

        public Builder clearEnums() {
            a();
            ((Service) this.a).clearEnums();
            return this;
        }

        public Builder clearExperimental() {
            a();
            ((Service) this.a).clearExperimental();
            return this;
        }

        public Builder clearHttp() {
            a();
            ((Service) this.a).clearHttp();
            return this;
        }

        public Builder clearId() {
            a();
            ((Service) this.a).clearId();
            return this;
        }

        public Builder clearLogging() {
            a();
            ((Service) this.a).clearLogging();
            return this;
        }

        public Builder clearLogs() {
            a();
            ((Service) this.a).clearLogs();
            return this;
        }

        public Builder clearMetrics() {
            a();
            ((Service) this.a).clearMetrics();
            return this;
        }

        public Builder clearMonitoredResources() {
            a();
            ((Service) this.a).clearMonitoredResources();
            return this;
        }

        public Builder clearMonitoring() {
            a();
            ((Service) this.a).clearMonitoring();
            return this;
        }

        public Builder clearName() {
            a();
            ((Service) this.a).clearName();
            return this;
        }

        public Builder clearProducerProjectId() {
            a();
            ((Service) this.a).clearProducerProjectId();
            return this;
        }

        public Builder clearQuota() {
            a();
            ((Service) this.a).clearQuota();
            return this;
        }

        public Builder clearSourceInfo() {
            a();
            ((Service) this.a).clearSourceInfo();
            return this;
        }

        public Builder clearSystemParameters() {
            a();
            ((Service) this.a).clearSystemParameters();
            return this;
        }

        public Builder clearTitle() {
            a();
            ((Service) this.a).clearTitle();
            return this;
        }

        public Builder clearTypes() {
            a();
            ((Service) this.a).clearTypes();
            return this;
        }

        public Builder clearUsage() {
            a();
            ((Service) this.a).clearUsage();
            return this;
        }

        @Override // com.google.api.ServiceOrBuilder
        public Api getApis(int i) {
            return ((Service) this.a).getApis(i);
        }

        @Override // com.google.api.ServiceOrBuilder
        public int getApisCount() {
            return ((Service) this.a).getApisCount();
        }

        @Override // com.google.api.ServiceOrBuilder
        public List<Api> getApisList() {
            return Collections.unmodifiableList(((Service) this.a).getApisList());
        }

        @Override // com.google.api.ServiceOrBuilder
        public Authentication getAuthentication() {
            return ((Service) this.a).getAuthentication();
        }

        @Override // com.google.api.ServiceOrBuilder
        public Backend getBackend() {
            return ((Service) this.a).getBackend();
        }

        @Override // com.google.api.ServiceOrBuilder
        public Billing getBilling() {
            return ((Service) this.a).getBilling();
        }

        @Override // com.google.api.ServiceOrBuilder
        public UInt32Value getConfigVersion() {
            return ((Service) this.a).getConfigVersion();
        }

        @Override // com.google.api.ServiceOrBuilder
        public Context getContext() {
            return ((Service) this.a).getContext();
        }

        @Override // com.google.api.ServiceOrBuilder
        public Control getControl() {
            return ((Service) this.a).getControl();
        }

        @Override // com.google.api.ServiceOrBuilder
        public Documentation getDocumentation() {
            return ((Service) this.a).getDocumentation();
        }

        @Override // com.google.api.ServiceOrBuilder
        public Endpoint getEndpoints(int i) {
            return ((Service) this.a).getEndpoints(i);
        }

        @Override // com.google.api.ServiceOrBuilder
        public int getEndpointsCount() {
            return ((Service) this.a).getEndpointsCount();
        }

        @Override // com.google.api.ServiceOrBuilder
        public List<Endpoint> getEndpointsList() {
            return Collections.unmodifiableList(((Service) this.a).getEndpointsList());
        }

        @Override // com.google.api.ServiceOrBuilder
        public Enum getEnums(int i) {
            return ((Service) this.a).getEnums(i);
        }

        @Override // com.google.api.ServiceOrBuilder
        public int getEnumsCount() {
            return ((Service) this.a).getEnumsCount();
        }

        @Override // com.google.api.ServiceOrBuilder
        public List<Enum> getEnumsList() {
            return Collections.unmodifiableList(((Service) this.a).getEnumsList());
        }

        @Override // com.google.api.ServiceOrBuilder
        public Experimental getExperimental() {
            return ((Service) this.a).getExperimental();
        }

        @Override // com.google.api.ServiceOrBuilder
        public Http getHttp() {
            return ((Service) this.a).getHttp();
        }

        @Override // com.google.api.ServiceOrBuilder
        public String getId() {
            return ((Service) this.a).getId();
        }

        @Override // com.google.api.ServiceOrBuilder
        public ByteString getIdBytes() {
            return ((Service) this.a).getIdBytes();
        }

        @Override // com.google.api.ServiceOrBuilder
        public Logging getLogging() {
            return ((Service) this.a).getLogging();
        }

        @Override // com.google.api.ServiceOrBuilder
        public LogDescriptor getLogs(int i) {
            return ((Service) this.a).getLogs(i);
        }

        @Override // com.google.api.ServiceOrBuilder
        public int getLogsCount() {
            return ((Service) this.a).getLogsCount();
        }

        @Override // com.google.api.ServiceOrBuilder
        public List<LogDescriptor> getLogsList() {
            return Collections.unmodifiableList(((Service) this.a).getLogsList());
        }

        @Override // com.google.api.ServiceOrBuilder
        public MetricDescriptor getMetrics(int i) {
            return ((Service) this.a).getMetrics(i);
        }

        @Override // com.google.api.ServiceOrBuilder
        public int getMetricsCount() {
            return ((Service) this.a).getMetricsCount();
        }

        @Override // com.google.api.ServiceOrBuilder
        public List<MetricDescriptor> getMetricsList() {
            return Collections.unmodifiableList(((Service) this.a).getMetricsList());
        }

        @Override // com.google.api.ServiceOrBuilder
        public MonitoredResourceDescriptor getMonitoredResources(int i) {
            return ((Service) this.a).getMonitoredResources(i);
        }

        @Override // com.google.api.ServiceOrBuilder
        public int getMonitoredResourcesCount() {
            return ((Service) this.a).getMonitoredResourcesCount();
        }

        @Override // com.google.api.ServiceOrBuilder
        public List<MonitoredResourceDescriptor> getMonitoredResourcesList() {
            return Collections.unmodifiableList(((Service) this.a).getMonitoredResourcesList());
        }

        @Override // com.google.api.ServiceOrBuilder
        public Monitoring getMonitoring() {
            return ((Service) this.a).getMonitoring();
        }

        @Override // com.google.api.ServiceOrBuilder
        public String getName() {
            return ((Service) this.a).getName();
        }

        @Override // com.google.api.ServiceOrBuilder
        public ByteString getNameBytes() {
            return ((Service) this.a).getNameBytes();
        }

        @Override // com.google.api.ServiceOrBuilder
        public String getProducerProjectId() {
            return ((Service) this.a).getProducerProjectId();
        }

        @Override // com.google.api.ServiceOrBuilder
        public ByteString getProducerProjectIdBytes() {
            return ((Service) this.a).getProducerProjectIdBytes();
        }

        @Override // com.google.api.ServiceOrBuilder
        public Quota getQuota() {
            return ((Service) this.a).getQuota();
        }

        @Override // com.google.api.ServiceOrBuilder
        public SourceInfo getSourceInfo() {
            return ((Service) this.a).getSourceInfo();
        }

        @Override // com.google.api.ServiceOrBuilder
        public SystemParameters getSystemParameters() {
            return ((Service) this.a).getSystemParameters();
        }

        @Override // com.google.api.ServiceOrBuilder
        public String getTitle() {
            return ((Service) this.a).getTitle();
        }

        @Override // com.google.api.ServiceOrBuilder
        public ByteString getTitleBytes() {
            return ((Service) this.a).getTitleBytes();
        }

        @Override // com.google.api.ServiceOrBuilder
        public Type getTypes(int i) {
            return ((Service) this.a).getTypes(i);
        }

        @Override // com.google.api.ServiceOrBuilder
        public int getTypesCount() {
            return ((Service) this.a).getTypesCount();
        }

        @Override // com.google.api.ServiceOrBuilder
        public List<Type> getTypesList() {
            return Collections.unmodifiableList(((Service) this.a).getTypesList());
        }

        @Override // com.google.api.ServiceOrBuilder
        public Usage getUsage() {
            return ((Service) this.a).getUsage();
        }

        @Override // com.google.api.ServiceOrBuilder
        public boolean hasAuthentication() {
            return ((Service) this.a).hasAuthentication();
        }

        @Override // com.google.api.ServiceOrBuilder
        public boolean hasBackend() {
            return ((Service) this.a).hasBackend();
        }

        @Override // com.google.api.ServiceOrBuilder
        public boolean hasBilling() {
            return ((Service) this.a).hasBilling();
        }

        @Override // com.google.api.ServiceOrBuilder
        public boolean hasConfigVersion() {
            return ((Service) this.a).hasConfigVersion();
        }

        @Override // com.google.api.ServiceOrBuilder
        public boolean hasContext() {
            return ((Service) this.a).hasContext();
        }

        @Override // com.google.api.ServiceOrBuilder
        public boolean hasControl() {
            return ((Service) this.a).hasControl();
        }

        @Override // com.google.api.ServiceOrBuilder
        public boolean hasDocumentation() {
            return ((Service) this.a).hasDocumentation();
        }

        @Override // com.google.api.ServiceOrBuilder
        public boolean hasExperimental() {
            return ((Service) this.a).hasExperimental();
        }

        @Override // com.google.api.ServiceOrBuilder
        public boolean hasHttp() {
            return ((Service) this.a).hasHttp();
        }

        @Override // com.google.api.ServiceOrBuilder
        public boolean hasLogging() {
            return ((Service) this.a).hasLogging();
        }

        @Override // com.google.api.ServiceOrBuilder
        public boolean hasMonitoring() {
            return ((Service) this.a).hasMonitoring();
        }

        @Override // com.google.api.ServiceOrBuilder
        public boolean hasQuota() {
            return ((Service) this.a).hasQuota();
        }

        @Override // com.google.api.ServiceOrBuilder
        public boolean hasSourceInfo() {
            return ((Service) this.a).hasSourceInfo();
        }

        @Override // com.google.api.ServiceOrBuilder
        public boolean hasSystemParameters() {
            return ((Service) this.a).hasSystemParameters();
        }

        @Override // com.google.api.ServiceOrBuilder
        public boolean hasUsage() {
            return ((Service) this.a).hasUsage();
        }

        public Builder mergeAuthentication(Authentication authentication) {
            a();
            ((Service) this.a).mergeAuthentication(authentication);
            return this;
        }

        public Builder mergeBackend(Backend backend) {
            a();
            ((Service) this.a).mergeBackend(backend);
            return this;
        }

        public Builder mergeBilling(Billing billing) {
            a();
            ((Service) this.a).mergeBilling(billing);
            return this;
        }

        public Builder mergeConfigVersion(UInt32Value uInt32Value) {
            a();
            ((Service) this.a).mergeConfigVersion(uInt32Value);
            return this;
        }

        public Builder mergeContext(Context context) {
            a();
            ((Service) this.a).mergeContext(context);
            return this;
        }

        public Builder mergeControl(Control control) {
            a();
            ((Service) this.a).mergeControl(control);
            return this;
        }

        public Builder mergeDocumentation(Documentation documentation) {
            a();
            ((Service) this.a).mergeDocumentation(documentation);
            return this;
        }

        public Builder mergeExperimental(Experimental experimental) {
            a();
            ((Service) this.a).mergeExperimental(experimental);
            return this;
        }

        public Builder mergeHttp(Http http) {
            a();
            ((Service) this.a).mergeHttp(http);
            return this;
        }

        public Builder mergeLogging(Logging logging) {
            a();
            ((Service) this.a).mergeLogging(logging);
            return this;
        }

        public Builder mergeMonitoring(Monitoring monitoring) {
            a();
            ((Service) this.a).mergeMonitoring(monitoring);
            return this;
        }

        public Builder mergeQuota(Quota quota) {
            a();
            ((Service) this.a).mergeQuota(quota);
            return this;
        }

        public Builder mergeSourceInfo(SourceInfo sourceInfo) {
            a();
            ((Service) this.a).mergeSourceInfo(sourceInfo);
            return this;
        }

        public Builder mergeSystemParameters(SystemParameters systemParameters) {
            a();
            ((Service) this.a).mergeSystemParameters(systemParameters);
            return this;
        }

        public Builder mergeUsage(Usage usage) {
            a();
            ((Service) this.a).mergeUsage(usage);
            return this;
        }

        public Builder removeApis(int i) {
            a();
            ((Service) this.a).removeApis(i);
            return this;
        }

        public Builder removeEndpoints(int i) {
            a();
            ((Service) this.a).removeEndpoints(i);
            return this;
        }

        public Builder removeEnums(int i) {
            a();
            ((Service) this.a).removeEnums(i);
            return this;
        }

        public Builder removeLogs(int i) {
            a();
            ((Service) this.a).removeLogs(i);
            return this;
        }

        public Builder removeMetrics(int i) {
            a();
            ((Service) this.a).removeMetrics(i);
            return this;
        }

        public Builder removeMonitoredResources(int i) {
            a();
            ((Service) this.a).removeMonitoredResources(i);
            return this;
        }

        public Builder removeTypes(int i) {
            a();
            ((Service) this.a).removeTypes(i);
            return this;
        }

        public Builder setApis(int i, Api.Builder builder) {
            a();
            ((Service) this.a).setApis(i, builder);
            return this;
        }

        public Builder setApis(int i, Api api) {
            a();
            ((Service) this.a).setApis(i, api);
            return this;
        }

        public Builder setAuthentication(Authentication.Builder builder) {
            a();
            ((Service) this.a).setAuthentication(builder);
            return this;
        }

        public Builder setAuthentication(Authentication authentication) {
            a();
            ((Service) this.a).setAuthentication(authentication);
            return this;
        }

        public Builder setBackend(Backend.Builder builder) {
            a();
            ((Service) this.a).setBackend(builder);
            return this;
        }

        public Builder setBackend(Backend backend) {
            a();
            ((Service) this.a).setBackend(backend);
            return this;
        }

        public Builder setBilling(Billing.Builder builder) {
            a();
            ((Service) this.a).setBilling(builder);
            return this;
        }

        public Builder setBilling(Billing billing) {
            a();
            ((Service) this.a).setBilling(billing);
            return this;
        }

        public Builder setConfigVersion(UInt32Value.Builder builder) {
            a();
            ((Service) this.a).setConfigVersion(builder);
            return this;
        }

        public Builder setConfigVersion(UInt32Value uInt32Value) {
            a();
            ((Service) this.a).setConfigVersion(uInt32Value);
            return this;
        }

        public Builder setContext(Context.Builder builder) {
            a();
            ((Service) this.a).setContext(builder);
            return this;
        }

        public Builder setContext(Context context) {
            a();
            ((Service) this.a).setContext(context);
            return this;
        }

        public Builder setControl(Control.Builder builder) {
            a();
            ((Service) this.a).setControl(builder);
            return this;
        }

        public Builder setControl(Control control) {
            a();
            ((Service) this.a).setControl(control);
            return this;
        }

        public Builder setDocumentation(Documentation.Builder builder) {
            a();
            ((Service) this.a).setDocumentation(builder);
            return this;
        }

        public Builder setDocumentation(Documentation documentation) {
            a();
            ((Service) this.a).setDocumentation(documentation);
            return this;
        }

        public Builder setEndpoints(int i, Endpoint.Builder builder) {
            a();
            ((Service) this.a).setEndpoints(i, builder);
            return this;
        }

        public Builder setEndpoints(int i, Endpoint endpoint) {
            a();
            ((Service) this.a).setEndpoints(i, endpoint);
            return this;
        }

        public Builder setEnums(int i, Enum.Builder builder) {
            a();
            ((Service) this.a).setEnums(i, builder);
            return this;
        }

        public Builder setEnums(int i, Enum r3) {
            a();
            ((Service) this.a).setEnums(i, r3);
            return this;
        }

        public Builder setExperimental(Experimental.Builder builder) {
            a();
            ((Service) this.a).setExperimental(builder);
            return this;
        }

        public Builder setExperimental(Experimental experimental) {
            a();
            ((Service) this.a).setExperimental(experimental);
            return this;
        }

        public Builder setHttp(Http.Builder builder) {
            a();
            ((Service) this.a).setHttp(builder);
            return this;
        }

        public Builder setHttp(Http http) {
            a();
            ((Service) this.a).setHttp(http);
            return this;
        }

        public Builder setId(String str) {
            a();
            ((Service) this.a).setId(str);
            return this;
        }

        public Builder setIdBytes(ByteString byteString) {
            a();
            ((Service) this.a).setIdBytes(byteString);
            return this;
        }

        public Builder setLogging(Logging.Builder builder) {
            a();
            ((Service) this.a).setLogging(builder);
            return this;
        }

        public Builder setLogging(Logging logging) {
            a();
            ((Service) this.a).setLogging(logging);
            return this;
        }

        public Builder setLogs(int i, LogDescriptor.Builder builder) {
            a();
            ((Service) this.a).setLogs(i, builder);
            return this;
        }

        public Builder setLogs(int i, LogDescriptor logDescriptor) {
            a();
            ((Service) this.a).setLogs(i, logDescriptor);
            return this;
        }

        public Builder setMetrics(int i, MetricDescriptor.Builder builder) {
            a();
            ((Service) this.a).setMetrics(i, builder);
            return this;
        }

        public Builder setMetrics(int i, MetricDescriptor metricDescriptor) {
            a();
            ((Service) this.a).setMetrics(i, metricDescriptor);
            return this;
        }

        public Builder setMonitoredResources(int i, MonitoredResourceDescriptor.Builder builder) {
            a();
            ((Service) this.a).setMonitoredResources(i, builder);
            return this;
        }

        public Builder setMonitoredResources(int i, MonitoredResourceDescriptor monitoredResourceDescriptor) {
            a();
            ((Service) this.a).setMonitoredResources(i, monitoredResourceDescriptor);
            return this;
        }

        public Builder setMonitoring(Monitoring.Builder builder) {
            a();
            ((Service) this.a).setMonitoring(builder);
            return this;
        }

        public Builder setMonitoring(Monitoring monitoring) {
            a();
            ((Service) this.a).setMonitoring(monitoring);
            return this;
        }

        public Builder setName(String str) {
            a();
            ((Service) this.a).setName(str);
            return this;
        }

        public Builder setNameBytes(ByteString byteString) {
            a();
            ((Service) this.a).setNameBytes(byteString);
            return this;
        }

        public Builder setProducerProjectId(String str) {
            a();
            ((Service) this.a).setProducerProjectId(str);
            return this;
        }

        public Builder setProducerProjectIdBytes(ByteString byteString) {
            a();
            ((Service) this.a).setProducerProjectIdBytes(byteString);
            return this;
        }

        public Builder setQuota(Quota.Builder builder) {
            a();
            ((Service) this.a).setQuota(builder);
            return this;
        }

        public Builder setQuota(Quota quota) {
            a();
            ((Service) this.a).setQuota(quota);
            return this;
        }

        public Builder setSourceInfo(SourceInfo.Builder builder) {
            a();
            ((Service) this.a).setSourceInfo(builder);
            return this;
        }

        public Builder setSourceInfo(SourceInfo sourceInfo) {
            a();
            ((Service) this.a).setSourceInfo(sourceInfo);
            return this;
        }

        public Builder setSystemParameters(SystemParameters.Builder builder) {
            a();
            ((Service) this.a).setSystemParameters(builder);
            return this;
        }

        public Builder setSystemParameters(SystemParameters systemParameters) {
            a();
            ((Service) this.a).setSystemParameters(systemParameters);
            return this;
        }

        public Builder setTitle(String str) {
            a();
            ((Service) this.a).setTitle(str);
            return this;
        }

        public Builder setTitleBytes(ByteString byteString) {
            a();
            ((Service) this.a).setTitleBytes(byteString);
            return this;
        }

        public Builder setTypes(int i, Type.Builder builder) {
            a();
            ((Service) this.a).setTypes(i, builder);
            return this;
        }

        public Builder setTypes(int i, Type type) {
            a();
            ((Service) this.a).setTypes(i, type);
            return this;
        }

        public Builder setUsage(Usage.Builder builder) {
            a();
            ((Service) this.a).setUsage(builder);
            return this;
        }

        public Builder setUsage(Usage usage) {
            a();
            ((Service) this.a).setUsage(usage);
            return this;
        }
    }

    static {
        DEFAULT_INSTANCE.b();
    }

    private Service() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllApis(Iterable<? extends Api> iterable) {
        ensureApisIsMutable();
        AbstractMessageLite.a(iterable, this.apis_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllEndpoints(Iterable<? extends Endpoint> iterable) {
        ensureEndpointsIsMutable();
        AbstractMessageLite.a(iterable, this.endpoints_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllEnums(Iterable<? extends Enum> iterable) {
        ensureEnumsIsMutable();
        AbstractMessageLite.a(iterable, this.enums_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllLogs(Iterable<? extends LogDescriptor> iterable) {
        ensureLogsIsMutable();
        AbstractMessageLite.a(iterable, this.logs_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllMetrics(Iterable<? extends MetricDescriptor> iterable) {
        ensureMetricsIsMutable();
        AbstractMessageLite.a(iterable, this.metrics_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllMonitoredResources(Iterable<? extends MonitoredResourceDescriptor> iterable) {
        ensureMonitoredResourcesIsMutable();
        AbstractMessageLite.a(iterable, this.monitoredResources_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllTypes(Iterable<? extends Type> iterable) {
        ensureTypesIsMutable();
        AbstractMessageLite.a(iterable, this.types_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addApis(int i, Api.Builder builder) {
        ensureApisIsMutable();
        this.apis_.add(i, builder.build());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addApis(int i, Api api) {
        if (api == null) {
            throw new NullPointerException();
        }
        ensureApisIsMutable();
        this.apis_.add(i, api);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addApis(Api.Builder builder) {
        ensureApisIsMutable();
        this.apis_.add(builder.build());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addApis(Api api) {
        if (api == null) {
            throw new NullPointerException();
        }
        ensureApisIsMutable();
        this.apis_.add(api);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addEndpoints(int i, Endpoint.Builder builder) {
        ensureEndpointsIsMutable();
        this.endpoints_.add(i, builder.build());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addEndpoints(int i, Endpoint endpoint) {
        if (endpoint == null) {
            throw new NullPointerException();
        }
        ensureEndpointsIsMutable();
        this.endpoints_.add(i, endpoint);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addEndpoints(Endpoint.Builder builder) {
        ensureEndpointsIsMutable();
        this.endpoints_.add(builder.build());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addEndpoints(Endpoint endpoint) {
        if (endpoint == null) {
            throw new NullPointerException();
        }
        ensureEndpointsIsMutable();
        this.endpoints_.add(endpoint);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addEnums(int i, Enum.Builder builder) {
        ensureEnumsIsMutable();
        this.enums_.add(i, builder.build());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addEnums(int i, Enum r3) {
        if (r3 == null) {
            throw new NullPointerException();
        }
        ensureEnumsIsMutable();
        this.enums_.add(i, r3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addEnums(Enum.Builder builder) {
        ensureEnumsIsMutable();
        this.enums_.add(builder.build());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addEnums(Enum r2) {
        if (r2 == null) {
            throw new NullPointerException();
        }
        ensureEnumsIsMutable();
        this.enums_.add(r2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addLogs(int i, LogDescriptor.Builder builder) {
        ensureLogsIsMutable();
        this.logs_.add(i, builder.build());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addLogs(int i, LogDescriptor logDescriptor) {
        if (logDescriptor == null) {
            throw new NullPointerException();
        }
        ensureLogsIsMutable();
        this.logs_.add(i, logDescriptor);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addLogs(LogDescriptor.Builder builder) {
        ensureLogsIsMutable();
        this.logs_.add(builder.build());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addLogs(LogDescriptor logDescriptor) {
        if (logDescriptor == null) {
            throw new NullPointerException();
        }
        ensureLogsIsMutable();
        this.logs_.add(logDescriptor);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addMetrics(int i, MetricDescriptor.Builder builder) {
        ensureMetricsIsMutable();
        this.metrics_.add(i, builder.build());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addMetrics(int i, MetricDescriptor metricDescriptor) {
        if (metricDescriptor == null) {
            throw new NullPointerException();
        }
        ensureMetricsIsMutable();
        this.metrics_.add(i, metricDescriptor);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addMetrics(MetricDescriptor.Builder builder) {
        ensureMetricsIsMutable();
        this.metrics_.add(builder.build());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addMetrics(MetricDescriptor metricDescriptor) {
        if (metricDescriptor == null) {
            throw new NullPointerException();
        }
        ensureMetricsIsMutable();
        this.metrics_.add(metricDescriptor);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addMonitoredResources(int i, MonitoredResourceDescriptor.Builder builder) {
        ensureMonitoredResourcesIsMutable();
        this.monitoredResources_.add(i, builder.build());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addMonitoredResources(int i, MonitoredResourceDescriptor monitoredResourceDescriptor) {
        if (monitoredResourceDescriptor == null) {
            throw new NullPointerException();
        }
        ensureMonitoredResourcesIsMutable();
        this.monitoredResources_.add(i, monitoredResourceDescriptor);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addMonitoredResources(MonitoredResourceDescriptor.Builder builder) {
        ensureMonitoredResourcesIsMutable();
        this.monitoredResources_.add(builder.build());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addMonitoredResources(MonitoredResourceDescriptor monitoredResourceDescriptor) {
        if (monitoredResourceDescriptor == null) {
            throw new NullPointerException();
        }
        ensureMonitoredResourcesIsMutable();
        this.monitoredResources_.add(monitoredResourceDescriptor);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addTypes(int i, Type.Builder builder) {
        ensureTypesIsMutable();
        this.types_.add(i, builder.build());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addTypes(int i, Type type) {
        if (type == null) {
            throw new NullPointerException();
        }
        ensureTypesIsMutable();
        this.types_.add(i, type);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addTypes(Type.Builder builder) {
        ensureTypesIsMutable();
        this.types_.add(builder.build());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addTypes(Type type) {
        if (type == null) {
            throw new NullPointerException();
        }
        ensureTypesIsMutable();
        this.types_.add(type);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearApis() {
        this.apis_ = GeneratedMessageLite.f();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearAuthentication() {
        this.authentication_ = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearBackend() {
        this.backend_ = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearBilling() {
        this.billing_ = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearConfigVersion() {
        this.configVersion_ = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearContext() {
        this.context_ = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearControl() {
        this.control_ = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearDocumentation() {
        this.documentation_ = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearEndpoints() {
        this.endpoints_ = GeneratedMessageLite.f();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearEnums() {
        this.enums_ = GeneratedMessageLite.f();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearExperimental() {
        this.experimental_ = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearHttp() {
        this.http_ = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearId() {
        this.id_ = getDefaultInstance().getId();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearLogging() {
        this.logging_ = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearLogs() {
        this.logs_ = GeneratedMessageLite.f();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearMetrics() {
        this.metrics_ = GeneratedMessageLite.f();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearMonitoredResources() {
        this.monitoredResources_ = GeneratedMessageLite.f();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearMonitoring() {
        this.monitoring_ = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearName() {
        this.name_ = getDefaultInstance().getName();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearProducerProjectId() {
        this.producerProjectId_ = getDefaultInstance().getProducerProjectId();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearQuota() {
        this.quota_ = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearSourceInfo() {
        this.sourceInfo_ = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearSystemParameters() {
        this.systemParameters_ = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearTitle() {
        this.title_ = getDefaultInstance().getTitle();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearTypes() {
        this.types_ = GeneratedMessageLite.f();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearUsage() {
        this.usage_ = null;
    }

    private void ensureApisIsMutable() {
        if (this.apis_.isModifiable()) {
            return;
        }
        this.apis_ = GeneratedMessageLite.a(this.apis_);
    }

    private void ensureEndpointsIsMutable() {
        if (this.endpoints_.isModifiable()) {
            return;
        }
        this.endpoints_ = GeneratedMessageLite.a(this.endpoints_);
    }

    private void ensureEnumsIsMutable() {
        if (this.enums_.isModifiable()) {
            return;
        }
        this.enums_ = GeneratedMessageLite.a(this.enums_);
    }

    private void ensureLogsIsMutable() {
        if (this.logs_.isModifiable()) {
            return;
        }
        this.logs_ = GeneratedMessageLite.a(this.logs_);
    }

    private void ensureMetricsIsMutable() {
        if (this.metrics_.isModifiable()) {
            return;
        }
        this.metrics_ = GeneratedMessageLite.a(this.metrics_);
    }

    private void ensureMonitoredResourcesIsMutable() {
        if (this.monitoredResources_.isModifiable()) {
            return;
        }
        this.monitoredResources_ = GeneratedMessageLite.a(this.monitoredResources_);
    }

    private void ensureTypesIsMutable() {
        if (this.types_.isModifiable()) {
            return;
        }
        this.types_ = GeneratedMessageLite.a(this.types_);
    }

    public static Service getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeAuthentication(Authentication authentication) {
        Authentication authentication2 = this.authentication_;
        if (authentication2 != null && authentication2 != Authentication.getDefaultInstance()) {
            authentication = Authentication.newBuilder(this.authentication_).mergeFrom((Authentication.Builder) authentication).buildPartial();
        }
        this.authentication_ = authentication;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeBackend(Backend backend) {
        Backend backend2 = this.backend_;
        if (backend2 != null && backend2 != Backend.getDefaultInstance()) {
            backend = Backend.newBuilder(this.backend_).mergeFrom((Backend.Builder) backend).buildPartial();
        }
        this.backend_ = backend;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeBilling(Billing billing) {
        Billing billing2 = this.billing_;
        if (billing2 != null && billing2 != Billing.getDefaultInstance()) {
            billing = Billing.newBuilder(this.billing_).mergeFrom((Billing.Builder) billing).buildPartial();
        }
        this.billing_ = billing;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeConfigVersion(UInt32Value uInt32Value) {
        UInt32Value uInt32Value2 = this.configVersion_;
        if (uInt32Value2 != null && uInt32Value2 != UInt32Value.getDefaultInstance()) {
            uInt32Value = UInt32Value.newBuilder(this.configVersion_).mergeFrom((UInt32Value.Builder) uInt32Value).buildPartial();
        }
        this.configVersion_ = uInt32Value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeContext(Context context) {
        Context context2 = this.context_;
        if (context2 != null && context2 != Context.getDefaultInstance()) {
            context = Context.newBuilder(this.context_).mergeFrom((Context.Builder) context).buildPartial();
        }
        this.context_ = context;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeControl(Control control) {
        Control control2 = this.control_;
        if (control2 != null && control2 != Control.getDefaultInstance()) {
            control = Control.newBuilder(this.control_).mergeFrom((Control.Builder) control).buildPartial();
        }
        this.control_ = control;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeDocumentation(Documentation documentation) {
        Documentation documentation2 = this.documentation_;
        if (documentation2 != null && documentation2 != Documentation.getDefaultInstance()) {
            documentation = Documentation.newBuilder(this.documentation_).mergeFrom((Documentation.Builder) documentation).buildPartial();
        }
        this.documentation_ = documentation;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeExperimental(Experimental experimental) {
        Experimental experimental2 = this.experimental_;
        if (experimental2 != null && experimental2 != Experimental.getDefaultInstance()) {
            experimental = Experimental.newBuilder(this.experimental_).mergeFrom((Experimental.Builder) experimental).buildPartial();
        }
        this.experimental_ = experimental;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeHttp(Http http) {
        Http http2 = this.http_;
        if (http2 != null && http2 != Http.getDefaultInstance()) {
            http = Http.newBuilder(this.http_).mergeFrom((Http.Builder) http).buildPartial();
        }
        this.http_ = http;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeLogging(Logging logging) {
        Logging logging2 = this.logging_;
        if (logging2 != null && logging2 != Logging.getDefaultInstance()) {
            logging = Logging.newBuilder(this.logging_).mergeFrom((Logging.Builder) logging).buildPartial();
        }
        this.logging_ = logging;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeMonitoring(Monitoring monitoring) {
        Monitoring monitoring2 = this.monitoring_;
        if (monitoring2 != null && monitoring2 != Monitoring.getDefaultInstance()) {
            monitoring = Monitoring.newBuilder(this.monitoring_).mergeFrom((Monitoring.Builder) monitoring).buildPartial();
        }
        this.monitoring_ = monitoring;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeQuota(Quota quota) {
        Quota quota2 = this.quota_;
        if (quota2 != null && quota2 != Quota.getDefaultInstance()) {
            quota = Quota.newBuilder(this.quota_).mergeFrom((Quota.Builder) quota).buildPartial();
        }
        this.quota_ = quota;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeSourceInfo(SourceInfo sourceInfo) {
        SourceInfo sourceInfo2 = this.sourceInfo_;
        if (sourceInfo2 != null && sourceInfo2 != SourceInfo.getDefaultInstance()) {
            sourceInfo = SourceInfo.newBuilder(this.sourceInfo_).mergeFrom((SourceInfo.Builder) sourceInfo).buildPartial();
        }
        this.sourceInfo_ = sourceInfo;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeSystemParameters(SystemParameters systemParameters) {
        SystemParameters systemParameters2 = this.systemParameters_;
        if (systemParameters2 != null && systemParameters2 != SystemParameters.getDefaultInstance()) {
            systemParameters = SystemParameters.newBuilder(this.systemParameters_).mergeFrom((SystemParameters.Builder) systemParameters).buildPartial();
        }
        this.systemParameters_ = systemParameters;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeUsage(Usage usage) {
        Usage usage2 = this.usage_;
        if (usage2 != null && usage2 != Usage.getDefaultInstance()) {
            usage = Usage.newBuilder(this.usage_).mergeFrom((Usage.Builder) usage).buildPartial();
        }
        this.usage_ = usage;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static Builder newBuilder(Service service) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom((Builder) service);
    }

    public static Service parseDelimitedFrom(InputStream inputStream) {
        return (Service) GeneratedMessageLite.a(DEFAULT_INSTANCE, inputStream);
    }

    public static Service parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Service) GeneratedMessageLite.a(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static Service parseFrom(ByteString byteString) {
        return (Service) GeneratedMessageLite.a(DEFAULT_INSTANCE, byteString);
    }

    public static Service parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (Service) GeneratedMessageLite.a(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static Service parseFrom(CodedInputStream codedInputStream) {
        return (Service) GeneratedMessageLite.a(DEFAULT_INSTANCE, codedInputStream);
    }

    public static Service parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Service) GeneratedMessageLite.a(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }

    public static Service parseFrom(InputStream inputStream) {
        return (Service) GeneratedMessageLite.b(DEFAULT_INSTANCE, inputStream);
    }

    public static Service parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Service) GeneratedMessageLite.b(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static Service parseFrom(byte[] bArr) {
        return (Service) GeneratedMessageLite.a(DEFAULT_INSTANCE, bArr);
    }

    public static Service parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (Service) GeneratedMessageLite.a(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static Parser<Service> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeApis(int i) {
        ensureApisIsMutable();
        this.apis_.remove(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeEndpoints(int i) {
        ensureEndpointsIsMutable();
        this.endpoints_.remove(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeEnums(int i) {
        ensureEnumsIsMutable();
        this.enums_.remove(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeLogs(int i) {
        ensureLogsIsMutable();
        this.logs_.remove(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeMetrics(int i) {
        ensureMetricsIsMutable();
        this.metrics_.remove(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeMonitoredResources(int i) {
        ensureMonitoredResourcesIsMutable();
        this.monitoredResources_.remove(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeTypes(int i) {
        ensureTypesIsMutable();
        this.types_.remove(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setApis(int i, Api.Builder builder) {
        ensureApisIsMutable();
        this.apis_.set(i, builder.build());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setApis(int i, Api api) {
        if (api == null) {
            throw new NullPointerException();
        }
        ensureApisIsMutable();
        this.apis_.set(i, api);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setAuthentication(Authentication.Builder builder) {
        this.authentication_ = builder.build();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setAuthentication(Authentication authentication) {
        if (authentication == null) {
            throw new NullPointerException();
        }
        this.authentication_ = authentication;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setBackend(Backend.Builder builder) {
        this.backend_ = builder.build();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setBackend(Backend backend) {
        if (backend == null) {
            throw new NullPointerException();
        }
        this.backend_ = backend;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setBilling(Billing.Builder builder) {
        this.billing_ = builder.build();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setBilling(Billing billing) {
        if (billing == null) {
            throw new NullPointerException();
        }
        this.billing_ = billing;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setConfigVersion(UInt32Value.Builder builder) {
        this.configVersion_ = builder.build();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setConfigVersion(UInt32Value uInt32Value) {
        if (uInt32Value == null) {
            throw new NullPointerException();
        }
        this.configVersion_ = uInt32Value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setContext(Context.Builder builder) {
        this.context_ = builder.build();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setContext(Context context) {
        if (context == null) {
            throw new NullPointerException();
        }
        this.context_ = context;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setControl(Control.Builder builder) {
        this.control_ = builder.build();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setControl(Control control) {
        if (control == null) {
            throw new NullPointerException();
        }
        this.control_ = control;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDocumentation(Documentation.Builder builder) {
        this.documentation_ = builder.build();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDocumentation(Documentation documentation) {
        if (documentation == null) {
            throw new NullPointerException();
        }
        this.documentation_ = documentation;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setEndpoints(int i, Endpoint.Builder builder) {
        ensureEndpointsIsMutable();
        this.endpoints_.set(i, builder.build());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setEndpoints(int i, Endpoint endpoint) {
        if (endpoint == null) {
            throw new NullPointerException();
        }
        ensureEndpointsIsMutable();
        this.endpoints_.set(i, endpoint);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setEnums(int i, Enum.Builder builder) {
        ensureEnumsIsMutable();
        this.enums_.set(i, builder.build());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setEnums(int i, Enum r3) {
        if (r3 == null) {
            throw new NullPointerException();
        }
        ensureEnumsIsMutable();
        this.enums_.set(i, r3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setExperimental(Experimental.Builder builder) {
        this.experimental_ = builder.build();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setExperimental(Experimental experimental) {
        if (experimental == null) {
            throw new NullPointerException();
        }
        this.experimental_ = experimental;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setHttp(Http.Builder builder) {
        this.http_ = builder.build();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setHttp(Http http) {
        if (http == null) {
            throw new NullPointerException();
        }
        this.http_ = http;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setId(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.id_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setIdBytes(ByteString byteString) {
        if (byteString == null) {
            throw new NullPointerException();
        }
        AbstractMessageLite.a(byteString);
        this.id_ = byteString.toStringUtf8();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setLogging(Logging.Builder builder) {
        this.logging_ = builder.build();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setLogging(Logging logging) {
        if (logging == null) {
            throw new NullPointerException();
        }
        this.logging_ = logging;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setLogs(int i, LogDescriptor.Builder builder) {
        ensureLogsIsMutable();
        this.logs_.set(i, builder.build());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setLogs(int i, LogDescriptor logDescriptor) {
        if (logDescriptor == null) {
            throw new NullPointerException();
        }
        ensureLogsIsMutable();
        this.logs_.set(i, logDescriptor);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setMetrics(int i, MetricDescriptor.Builder builder) {
        ensureMetricsIsMutable();
        this.metrics_.set(i, builder.build());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setMetrics(int i, MetricDescriptor metricDescriptor) {
        if (metricDescriptor == null) {
            throw new NullPointerException();
        }
        ensureMetricsIsMutable();
        this.metrics_.set(i, metricDescriptor);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setMonitoredResources(int i, MonitoredResourceDescriptor.Builder builder) {
        ensureMonitoredResourcesIsMutable();
        this.monitoredResources_.set(i, builder.build());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setMonitoredResources(int i, MonitoredResourceDescriptor monitoredResourceDescriptor) {
        if (monitoredResourceDescriptor == null) {
            throw new NullPointerException();
        }
        ensureMonitoredResourcesIsMutable();
        this.monitoredResources_.set(i, monitoredResourceDescriptor);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setMonitoring(Monitoring.Builder builder) {
        this.monitoring_ = builder.build();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setMonitoring(Monitoring monitoring) {
        if (monitoring == null) {
            throw new NullPointerException();
        }
        this.monitoring_ = monitoring;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setName(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.name_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setNameBytes(ByteString byteString) {
        if (byteString == null) {
            throw new NullPointerException();
        }
        AbstractMessageLite.a(byteString);
        this.name_ = byteString.toStringUtf8();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setProducerProjectId(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.producerProjectId_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setProducerProjectIdBytes(ByteString byteString) {
        if (byteString == null) {
            throw new NullPointerException();
        }
        AbstractMessageLite.a(byteString);
        this.producerProjectId_ = byteString.toStringUtf8();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setQuota(Quota.Builder builder) {
        this.quota_ = builder.build();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setQuota(Quota quota) {
        if (quota == null) {
            throw new NullPointerException();
        }
        this.quota_ = quota;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSourceInfo(SourceInfo.Builder builder) {
        this.sourceInfo_ = builder.build();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSourceInfo(SourceInfo sourceInfo) {
        if (sourceInfo == null) {
            throw new NullPointerException();
        }
        this.sourceInfo_ = sourceInfo;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSystemParameters(SystemParameters.Builder builder) {
        this.systemParameters_ = builder.build();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSystemParameters(SystemParameters systemParameters) {
        if (systemParameters == null) {
            throw new NullPointerException();
        }
        this.systemParameters_ = systemParameters;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTitle(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.title_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTitleBytes(ByteString byteString) {
        if (byteString == null) {
            throw new NullPointerException();
        }
        AbstractMessageLite.a(byteString);
        this.title_ = byteString.toStringUtf8();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTypes(int i, Type.Builder builder) {
        ensureTypesIsMutable();
        this.types_.set(i, builder.build());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTypes(int i, Type type) {
        if (type == null) {
            throw new NullPointerException();
        }
        ensureTypesIsMutable();
        this.types_.set(i, type);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setUsage(Usage.Builder builder) {
        this.usage_ = builder.build();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setUsage(Usage usage) {
        if (usage == null) {
            throw new NullPointerException();
        }
        this.usage_ = usage;
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:26:0x003a. Please report as an issue. */
    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object a(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        List list;
        MessageLite messageLite;
        AnonymousClass1 anonymousClass1 = null;
        switch (AnonymousClass1.a[methodToInvoke.ordinal()]) {
            case 1:
                return new Service();
            case 2:
                return DEFAULT_INSTANCE;
            case 3:
                this.apis_.makeImmutable();
                this.types_.makeImmutable();
                this.enums_.makeImmutable();
                this.endpoints_.makeImmutable();
                this.logs_.makeImmutable();
                this.metrics_.makeImmutable();
                this.monitoredResources_.makeImmutable();
                return null;
            case 4:
                return new Builder(anonymousClass1);
            case 5:
                GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                Service service = (Service) obj2;
                this.configVersion_ = (UInt32Value) visitor.visitMessage(this.configVersion_, service.configVersion_);
                this.name_ = visitor.visitString(!this.name_.isEmpty(), this.name_, !service.name_.isEmpty(), service.name_);
                this.id_ = visitor.visitString(!this.id_.isEmpty(), this.id_, !service.id_.isEmpty(), service.id_);
                this.title_ = visitor.visitString(!this.title_.isEmpty(), this.title_, !service.title_.isEmpty(), service.title_);
                this.producerProjectId_ = visitor.visitString(!this.producerProjectId_.isEmpty(), this.producerProjectId_, true ^ service.producerProjectId_.isEmpty(), service.producerProjectId_);
                this.apis_ = visitor.visitList(this.apis_, service.apis_);
                this.types_ = visitor.visitList(this.types_, service.types_);
                this.enums_ = visitor.visitList(this.enums_, service.enums_);
                this.documentation_ = (Documentation) visitor.visitMessage(this.documentation_, service.documentation_);
                this.backend_ = (Backend) visitor.visitMessage(this.backend_, service.backend_);
                this.http_ = (Http) visitor.visitMessage(this.http_, service.http_);
                this.quota_ = (Quota) visitor.visitMessage(this.quota_, service.quota_);
                this.authentication_ = (Authentication) visitor.visitMessage(this.authentication_, service.authentication_);
                this.context_ = (Context) visitor.visitMessage(this.context_, service.context_);
                this.usage_ = (Usage) visitor.visitMessage(this.usage_, service.usage_);
                this.endpoints_ = visitor.visitList(this.endpoints_, service.endpoints_);
                this.control_ = (Control) visitor.visitMessage(this.control_, service.control_);
                this.logs_ = visitor.visitList(this.logs_, service.logs_);
                this.metrics_ = visitor.visitList(this.metrics_, service.metrics_);
                this.monitoredResources_ = visitor.visitList(this.monitoredResources_, service.monitoredResources_);
                this.billing_ = (Billing) visitor.visitMessage(this.billing_, service.billing_);
                this.logging_ = (Logging) visitor.visitMessage(this.logging_, service.logging_);
                this.monitoring_ = (Monitoring) visitor.visitMessage(this.monitoring_, service.monitoring_);
                this.systemParameters_ = (SystemParameters) visitor.visitMessage(this.systemParameters_, service.systemParameters_);
                this.sourceInfo_ = (SourceInfo) visitor.visitMessage(this.sourceInfo_, service.sourceInfo_);
                this.experimental_ = (Experimental) visitor.visitMessage(this.experimental_, service.experimental_);
                if (visitor == GeneratedMessageLite.MergeFromVisitor.INSTANCE) {
                    this.bitField0_ |= service.bitField0_;
                }
                return this;
            case 6:
                CodedInputStream codedInputStream = (CodedInputStream) obj;
                ExtensionRegistryLite extensionRegistryLite = (ExtensionRegistryLite) obj2;
                boolean z = false;
                while (!z) {
                    try {
                        int readTag = codedInputStream.readTag();
                        switch (readTag) {
                            case 0:
                                z = true;
                            case 10:
                                this.name_ = codedInputStream.readStringRequireUtf8();
                            case 18:
                                this.title_ = codedInputStream.readStringRequireUtf8();
                            case 26:
                                if (!this.apis_.isModifiable()) {
                                    this.apis_ = GeneratedMessageLite.a(this.apis_);
                                }
                                list = this.apis_;
                                messageLite = (Api) codedInputStream.readMessage(Api.parser(), extensionRegistryLite);
                                list.add(messageLite);
                            case 34:
                                if (!this.types_.isModifiable()) {
                                    this.types_ = GeneratedMessageLite.a(this.types_);
                                }
                                list = this.types_;
                                messageLite = (Type) codedInputStream.readMessage(Type.parser(), extensionRegistryLite);
                                list.add(messageLite);
                            case 42:
                                if (!this.enums_.isModifiable()) {
                                    this.enums_ = GeneratedMessageLite.a(this.enums_);
                                }
                                list = this.enums_;
                                messageLite = (Enum) codedInputStream.readMessage(Enum.parser(), extensionRegistryLite);
                                list.add(messageLite);
                            case 50:
                                Documentation.Builder builder = this.documentation_ != null ? this.documentation_.toBuilder() : null;
                                this.documentation_ = (Documentation) codedInputStream.readMessage(Documentation.parser(), extensionRegistryLite);
                                if (builder != null) {
                                    builder.mergeFrom((Documentation.Builder) this.documentation_);
                                    this.documentation_ = builder.buildPartial();
                                }
                            case 66:
                                Backend.Builder builder2 = this.backend_ != null ? this.backend_.toBuilder() : null;
                                this.backend_ = (Backend) codedInputStream.readMessage(Backend.parser(), extensionRegistryLite);
                                if (builder2 != null) {
                                    builder2.mergeFrom((Backend.Builder) this.backend_);
                                    this.backend_ = builder2.buildPartial();
                                }
                            case 74:
                                Http.Builder builder3 = this.http_ != null ? this.http_.toBuilder() : null;
                                this.http_ = (Http) codedInputStream.readMessage(Http.parser(), extensionRegistryLite);
                                if (builder3 != null) {
                                    builder3.mergeFrom((Http.Builder) this.http_);
                                    this.http_ = builder3.buildPartial();
                                }
                            case 82:
                                Quota.Builder builder4 = this.quota_ != null ? this.quota_.toBuilder() : null;
                                this.quota_ = (Quota) codedInputStream.readMessage(Quota.parser(), extensionRegistryLite);
                                if (builder4 != null) {
                                    builder4.mergeFrom((Quota.Builder) this.quota_);
                                    this.quota_ = builder4.buildPartial();
                                }
                            case 90:
                                Authentication.Builder builder5 = this.authentication_ != null ? this.authentication_.toBuilder() : null;
                                this.authentication_ = (Authentication) codedInputStream.readMessage(Authentication.parser(), extensionRegistryLite);
                                if (builder5 != null) {
                                    builder5.mergeFrom((Authentication.Builder) this.authentication_);
                                    this.authentication_ = builder5.buildPartial();
                                }
                            case 98:
                                Context.Builder builder6 = this.context_ != null ? this.context_.toBuilder() : null;
                                this.context_ = (Context) codedInputStream.readMessage(Context.parser(), extensionRegistryLite);
                                if (builder6 != null) {
                                    builder6.mergeFrom((Context.Builder) this.context_);
                                    this.context_ = builder6.buildPartial();
                                }
                            case 122:
                                Usage.Builder builder7 = this.usage_ != null ? this.usage_.toBuilder() : null;
                                this.usage_ = (Usage) codedInputStream.readMessage(Usage.parser(), extensionRegistryLite);
                                if (builder7 != null) {
                                    builder7.mergeFrom((Usage.Builder) this.usage_);
                                    this.usage_ = builder7.buildPartial();
                                }
                            case 146:
                                if (!this.endpoints_.isModifiable()) {
                                    this.endpoints_ = GeneratedMessageLite.a(this.endpoints_);
                                }
                                list = this.endpoints_;
                                messageLite = (Endpoint) codedInputStream.readMessage(Endpoint.parser(), extensionRegistryLite);
                                list.add(messageLite);
                            case 162:
                                UInt32Value.Builder builder8 = this.configVersion_ != null ? this.configVersion_.toBuilder() : null;
                                this.configVersion_ = (UInt32Value) codedInputStream.readMessage(UInt32Value.parser(), extensionRegistryLite);
                                if (builder8 != null) {
                                    builder8.mergeFrom((UInt32Value.Builder) this.configVersion_);
                                    this.configVersion_ = builder8.buildPartial();
                                }
                            case 170:
                                Control.Builder builder9 = this.control_ != null ? this.control_.toBuilder() : null;
                                this.control_ = (Control) codedInputStream.readMessage(Control.parser(), extensionRegistryLite);
                                if (builder9 != null) {
                                    builder9.mergeFrom((Control.Builder) this.control_);
                                    this.control_ = builder9.buildPartial();
                                }
                            case 178:
                                this.producerProjectId_ = codedInputStream.readStringRequireUtf8();
                            case 186:
                                if (!this.logs_.isModifiable()) {
                                    this.logs_ = GeneratedMessageLite.a(this.logs_);
                                }
                                list = this.logs_;
                                messageLite = (LogDescriptor) codedInputStream.readMessage(LogDescriptor.parser(), extensionRegistryLite);
                                list.add(messageLite);
                            case 194:
                                if (!this.metrics_.isModifiable()) {
                                    this.metrics_ = GeneratedMessageLite.a(this.metrics_);
                                }
                                list = this.metrics_;
                                messageLite = (MetricDescriptor) codedInputStream.readMessage(MetricDescriptor.parser(), extensionRegistryLite);
                                list.add(messageLite);
                            case 202:
                                if (!this.monitoredResources_.isModifiable()) {
                                    this.monitoredResources_ = GeneratedMessageLite.a(this.monitoredResources_);
                                }
                                list = this.monitoredResources_;
                                messageLite = (MonitoredResourceDescriptor) codedInputStream.readMessage(MonitoredResourceDescriptor.parser(), extensionRegistryLite);
                                list.add(messageLite);
                            case 210:
                                Billing.Builder builder10 = this.billing_ != null ? this.billing_.toBuilder() : null;
                                this.billing_ = (Billing) codedInputStream.readMessage(Billing.parser(), extensionRegistryLite);
                                if (builder10 != null) {
                                    builder10.mergeFrom((Billing.Builder) this.billing_);
                                    this.billing_ = builder10.buildPartial();
                                }
                            case 218:
                                Logging.Builder builder11 = this.logging_ != null ? this.logging_.toBuilder() : null;
                                this.logging_ = (Logging) codedInputStream.readMessage(Logging.parser(), extensionRegistryLite);
                                if (builder11 != null) {
                                    builder11.mergeFrom((Logging.Builder) this.logging_);
                                    this.logging_ = builder11.buildPartial();
                                }
                            case 226:
                                Monitoring.Builder builder12 = this.monitoring_ != null ? this.monitoring_.toBuilder() : null;
                                this.monitoring_ = (Monitoring) codedInputStream.readMessage(Monitoring.parser(), extensionRegistryLite);
                                if (builder12 != null) {
                                    builder12.mergeFrom((Monitoring.Builder) this.monitoring_);
                                    this.monitoring_ = builder12.buildPartial();
                                }
                            case 234:
                                SystemParameters.Builder builder13 = this.systemParameters_ != null ? this.systemParameters_.toBuilder() : null;
                                this.systemParameters_ = (SystemParameters) codedInputStream.readMessage(SystemParameters.parser(), extensionRegistryLite);
                                if (builder13 != null) {
                                    builder13.mergeFrom((SystemParameters.Builder) this.systemParameters_);
                                    this.systemParameters_ = builder13.buildPartial();
                                }
                            case 266:
                                this.id_ = codedInputStream.readStringRequireUtf8();
                            case 298:
                                SourceInfo.Builder builder14 = this.sourceInfo_ != null ? this.sourceInfo_.toBuilder() : null;
                                this.sourceInfo_ = (SourceInfo) codedInputStream.readMessage(SourceInfo.parser(), extensionRegistryLite);
                                if (builder14 != null) {
                                    builder14.mergeFrom((SourceInfo.Builder) this.sourceInfo_);
                                    this.sourceInfo_ = builder14.buildPartial();
                                }
                            case 810:
                                Experimental.Builder builder15 = this.experimental_ != null ? this.experimental_.toBuilder() : null;
                                this.experimental_ = (Experimental) codedInputStream.readMessage(Experimental.parser(), extensionRegistryLite);
                                if (builder15 != null) {
                                    builder15.mergeFrom((Experimental.Builder) this.experimental_);
                                    this.experimental_ = builder15.buildPartial();
                                }
                            default:
                                if (!codedInputStream.skipField(readTag)) {
                                    z = true;
                                }
                        }
                    } catch (InvalidProtocolBufferException e) {
                        throw new RuntimeException(e.setUnfinishedMessage(this));
                    } catch (IOException e2) {
                        throw new RuntimeException(new InvalidProtocolBufferException(e2.getMessage()).setUnfinishedMessage(this));
                    }
                }
                break;
            case 7:
                break;
            case 8:
                if (PARSER == null) {
                    synchronized (Service.class) {
                        if (PARSER == null) {
                            PARSER = new GeneratedMessageLite.DefaultInstanceBasedParser(DEFAULT_INSTANCE);
                        }
                    }
                }
                return PARSER;
            default:
                throw new UnsupportedOperationException();
        }
        return DEFAULT_INSTANCE;
    }

    @Override // com.google.api.ServiceOrBuilder
    public Api getApis(int i) {
        return this.apis_.get(i);
    }

    @Override // com.google.api.ServiceOrBuilder
    public int getApisCount() {
        return this.apis_.size();
    }

    @Override // com.google.api.ServiceOrBuilder
    public List<Api> getApisList() {
        return this.apis_;
    }

    public ApiOrBuilder getApisOrBuilder(int i) {
        return this.apis_.get(i);
    }

    public List<? extends ApiOrBuilder> getApisOrBuilderList() {
        return this.apis_;
    }

    @Override // com.google.api.ServiceOrBuilder
    public Authentication getAuthentication() {
        Authentication authentication = this.authentication_;
        return authentication == null ? Authentication.getDefaultInstance() : authentication;
    }

    @Override // com.google.api.ServiceOrBuilder
    public Backend getBackend() {
        Backend backend = this.backend_;
        return backend == null ? Backend.getDefaultInstance() : backend;
    }

    @Override // com.google.api.ServiceOrBuilder
    public Billing getBilling() {
        Billing billing = this.billing_;
        return billing == null ? Billing.getDefaultInstance() : billing;
    }

    @Override // com.google.api.ServiceOrBuilder
    public UInt32Value getConfigVersion() {
        UInt32Value uInt32Value = this.configVersion_;
        return uInt32Value == null ? UInt32Value.getDefaultInstance() : uInt32Value;
    }

    @Override // com.google.api.ServiceOrBuilder
    public Context getContext() {
        Context context = this.context_;
        return context == null ? Context.getDefaultInstance() : context;
    }

    @Override // com.google.api.ServiceOrBuilder
    public Control getControl() {
        Control control = this.control_;
        return control == null ? Control.getDefaultInstance() : control;
    }

    @Override // com.google.api.ServiceOrBuilder
    public Documentation getDocumentation() {
        Documentation documentation = this.documentation_;
        return documentation == null ? Documentation.getDefaultInstance() : documentation;
    }

    @Override // com.google.api.ServiceOrBuilder
    public Endpoint getEndpoints(int i) {
        return this.endpoints_.get(i);
    }

    @Override // com.google.api.ServiceOrBuilder
    public int getEndpointsCount() {
        return this.endpoints_.size();
    }

    @Override // com.google.api.ServiceOrBuilder
    public List<Endpoint> getEndpointsList() {
        return this.endpoints_;
    }

    public EndpointOrBuilder getEndpointsOrBuilder(int i) {
        return this.endpoints_.get(i);
    }

    public List<? extends EndpointOrBuilder> getEndpointsOrBuilderList() {
        return this.endpoints_;
    }

    @Override // com.google.api.ServiceOrBuilder
    public Enum getEnums(int i) {
        return this.enums_.get(i);
    }

    @Override // com.google.api.ServiceOrBuilder
    public int getEnumsCount() {
        return this.enums_.size();
    }

    @Override // com.google.api.ServiceOrBuilder
    public List<Enum> getEnumsList() {
        return this.enums_;
    }

    public EnumOrBuilder getEnumsOrBuilder(int i) {
        return this.enums_.get(i);
    }

    public List<? extends EnumOrBuilder> getEnumsOrBuilderList() {
        return this.enums_;
    }

    @Override // com.google.api.ServiceOrBuilder
    public Experimental getExperimental() {
        Experimental experimental = this.experimental_;
        return experimental == null ? Experimental.getDefaultInstance() : experimental;
    }

    @Override // com.google.api.ServiceOrBuilder
    public Http getHttp() {
        Http http = this.http_;
        return http == null ? Http.getDefaultInstance() : http;
    }

    @Override // com.google.api.ServiceOrBuilder
    public String getId() {
        return this.id_;
    }

    @Override // com.google.api.ServiceOrBuilder
    public ByteString getIdBytes() {
        return ByteString.copyFromUtf8(this.id_);
    }

    @Override // com.google.api.ServiceOrBuilder
    public Logging getLogging() {
        Logging logging = this.logging_;
        return logging == null ? Logging.getDefaultInstance() : logging;
    }

    @Override // com.google.api.ServiceOrBuilder
    public LogDescriptor getLogs(int i) {
        return this.logs_.get(i);
    }

    @Override // com.google.api.ServiceOrBuilder
    public int getLogsCount() {
        return this.logs_.size();
    }

    @Override // com.google.api.ServiceOrBuilder
    public List<LogDescriptor> getLogsList() {
        return this.logs_;
    }

    public LogDescriptorOrBuilder getLogsOrBuilder(int i) {
        return this.logs_.get(i);
    }

    public List<? extends LogDescriptorOrBuilder> getLogsOrBuilderList() {
        return this.logs_;
    }

    @Override // com.google.api.ServiceOrBuilder
    public MetricDescriptor getMetrics(int i) {
        return this.metrics_.get(i);
    }

    @Override // com.google.api.ServiceOrBuilder
    public int getMetricsCount() {
        return this.metrics_.size();
    }

    @Override // com.google.api.ServiceOrBuilder
    public List<MetricDescriptor> getMetricsList() {
        return this.metrics_;
    }

    public MetricDescriptorOrBuilder getMetricsOrBuilder(int i) {
        return this.metrics_.get(i);
    }

    public List<? extends MetricDescriptorOrBuilder> getMetricsOrBuilderList() {
        return this.metrics_;
    }

    @Override // com.google.api.ServiceOrBuilder
    public MonitoredResourceDescriptor getMonitoredResources(int i) {
        return this.monitoredResources_.get(i);
    }

    @Override // com.google.api.ServiceOrBuilder
    public int getMonitoredResourcesCount() {
        return this.monitoredResources_.size();
    }

    @Override // com.google.api.ServiceOrBuilder
    public List<MonitoredResourceDescriptor> getMonitoredResourcesList() {
        return this.monitoredResources_;
    }

    public MonitoredResourceDescriptorOrBuilder getMonitoredResourcesOrBuilder(int i) {
        return this.monitoredResources_.get(i);
    }

    public List<? extends MonitoredResourceDescriptorOrBuilder> getMonitoredResourcesOrBuilderList() {
        return this.monitoredResources_;
    }

    @Override // com.google.api.ServiceOrBuilder
    public Monitoring getMonitoring() {
        Monitoring monitoring = this.monitoring_;
        return monitoring == null ? Monitoring.getDefaultInstance() : monitoring;
    }

    @Override // com.google.api.ServiceOrBuilder
    public String getName() {
        return this.name_;
    }

    @Override // com.google.api.ServiceOrBuilder
    public ByteString getNameBytes() {
        return ByteString.copyFromUtf8(this.name_);
    }

    @Override // com.google.api.ServiceOrBuilder
    public String getProducerProjectId() {
        return this.producerProjectId_;
    }

    @Override // com.google.api.ServiceOrBuilder
    public ByteString getProducerProjectIdBytes() {
        return ByteString.copyFromUtf8(this.producerProjectId_);
    }

    @Override // com.google.api.ServiceOrBuilder
    public Quota getQuota() {
        Quota quota = this.quota_;
        return quota == null ? Quota.getDefaultInstance() : quota;
    }

    @Override // com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int i = this.c;
        if (i != -1) {
            return i;
        }
        int computeStringSize = !this.name_.isEmpty() ? CodedOutputStream.computeStringSize(1, getName()) + 0 : 0;
        if (!this.title_.isEmpty()) {
            computeStringSize += CodedOutputStream.computeStringSize(2, getTitle());
        }
        int i2 = computeStringSize;
        for (int i3 = 0; i3 < this.apis_.size(); i3++) {
            i2 += CodedOutputStream.computeMessageSize(3, this.apis_.get(i3));
        }
        for (int i4 = 0; i4 < this.types_.size(); i4++) {
            i2 += CodedOutputStream.computeMessageSize(4, this.types_.get(i4));
        }
        for (int i5 = 0; i5 < this.enums_.size(); i5++) {
            i2 += CodedOutputStream.computeMessageSize(5, this.enums_.get(i5));
        }
        if (this.documentation_ != null) {
            i2 += CodedOutputStream.computeMessageSize(6, getDocumentation());
        }
        if (this.backend_ != null) {
            i2 += CodedOutputStream.computeMessageSize(8, getBackend());
        }
        if (this.http_ != null) {
            i2 += CodedOutputStream.computeMessageSize(9, getHttp());
        }
        if (this.quota_ != null) {
            i2 += CodedOutputStream.computeMessageSize(10, getQuota());
        }
        if (this.authentication_ != null) {
            i2 += CodedOutputStream.computeMessageSize(11, getAuthentication());
        }
        if (this.context_ != null) {
            i2 += CodedOutputStream.computeMessageSize(12, getContext());
        }
        if (this.usage_ != null) {
            i2 += CodedOutputStream.computeMessageSize(15, getUsage());
        }
        for (int i6 = 0; i6 < this.endpoints_.size(); i6++) {
            i2 += CodedOutputStream.computeMessageSize(18, this.endpoints_.get(i6));
        }
        if (this.configVersion_ != null) {
            i2 += CodedOutputStream.computeMessageSize(20, getConfigVersion());
        }
        if (this.control_ != null) {
            i2 += CodedOutputStream.computeMessageSize(21, getControl());
        }
        if (!this.producerProjectId_.isEmpty()) {
            i2 += CodedOutputStream.computeStringSize(22, getProducerProjectId());
        }
        for (int i7 = 0; i7 < this.logs_.size(); i7++) {
            i2 += CodedOutputStream.computeMessageSize(23, this.logs_.get(i7));
        }
        for (int i8 = 0; i8 < this.metrics_.size(); i8++) {
            i2 += CodedOutputStream.computeMessageSize(24, this.metrics_.get(i8));
        }
        for (int i9 = 0; i9 < this.monitoredResources_.size(); i9++) {
            i2 += CodedOutputStream.computeMessageSize(25, this.monitoredResources_.get(i9));
        }
        if (this.billing_ != null) {
            i2 += CodedOutputStream.computeMessageSize(26, getBilling());
        }
        if (this.logging_ != null) {
            i2 += CodedOutputStream.computeMessageSize(27, getLogging());
        }
        if (this.monitoring_ != null) {
            i2 += CodedOutputStream.computeMessageSize(28, getMonitoring());
        }
        if (this.systemParameters_ != null) {
            i2 += CodedOutputStream.computeMessageSize(29, getSystemParameters());
        }
        if (!this.id_.isEmpty()) {
            i2 += CodedOutputStream.computeStringSize(33, getId());
        }
        if (this.sourceInfo_ != null) {
            i2 += CodedOutputStream.computeMessageSize(37, getSourceInfo());
        }
        if (this.experimental_ != null) {
            i2 += CodedOutputStream.computeMessageSize(101, getExperimental());
        }
        this.c = i2;
        return i2;
    }

    @Override // com.google.api.ServiceOrBuilder
    public SourceInfo getSourceInfo() {
        SourceInfo sourceInfo = this.sourceInfo_;
        return sourceInfo == null ? SourceInfo.getDefaultInstance() : sourceInfo;
    }

    @Override // com.google.api.ServiceOrBuilder
    public SystemParameters getSystemParameters() {
        SystemParameters systemParameters = this.systemParameters_;
        return systemParameters == null ? SystemParameters.getDefaultInstance() : systemParameters;
    }

    @Override // com.google.api.ServiceOrBuilder
    public String getTitle() {
        return this.title_;
    }

    @Override // com.google.api.ServiceOrBuilder
    public ByteString getTitleBytes() {
        return ByteString.copyFromUtf8(this.title_);
    }

    @Override // com.google.api.ServiceOrBuilder
    public Type getTypes(int i) {
        return this.types_.get(i);
    }

    @Override // com.google.api.ServiceOrBuilder
    public int getTypesCount() {
        return this.types_.size();
    }

    @Override // com.google.api.ServiceOrBuilder
    public List<Type> getTypesList() {
        return this.types_;
    }

    public TypeOrBuilder getTypesOrBuilder(int i) {
        return this.types_.get(i);
    }

    public List<? extends TypeOrBuilder> getTypesOrBuilderList() {
        return this.types_;
    }

    @Override // com.google.api.ServiceOrBuilder
    public Usage getUsage() {
        Usage usage = this.usage_;
        return usage == null ? Usage.getDefaultInstance() : usage;
    }

    @Override // com.google.api.ServiceOrBuilder
    public boolean hasAuthentication() {
        return this.authentication_ != null;
    }

    @Override // com.google.api.ServiceOrBuilder
    public boolean hasBackend() {
        return this.backend_ != null;
    }

    @Override // com.google.api.ServiceOrBuilder
    public boolean hasBilling() {
        return this.billing_ != null;
    }

    @Override // com.google.api.ServiceOrBuilder
    public boolean hasConfigVersion() {
        return this.configVersion_ != null;
    }

    @Override // com.google.api.ServiceOrBuilder
    public boolean hasContext() {
        return this.context_ != null;
    }

    @Override // com.google.api.ServiceOrBuilder
    public boolean hasControl() {
        return this.control_ != null;
    }

    @Override // com.google.api.ServiceOrBuilder
    public boolean hasDocumentation() {
        return this.documentation_ != null;
    }

    @Override // com.google.api.ServiceOrBuilder
    public boolean hasExperimental() {
        return this.experimental_ != null;
    }

    @Override // com.google.api.ServiceOrBuilder
    public boolean hasHttp() {
        return this.http_ != null;
    }

    @Override // com.google.api.ServiceOrBuilder
    public boolean hasLogging() {
        return this.logging_ != null;
    }

    @Override // com.google.api.ServiceOrBuilder
    public boolean hasMonitoring() {
        return this.monitoring_ != null;
    }

    @Override // com.google.api.ServiceOrBuilder
    public boolean hasQuota() {
        return this.quota_ != null;
    }

    @Override // com.google.api.ServiceOrBuilder
    public boolean hasSourceInfo() {
        return this.sourceInfo_ != null;
    }

    @Override // com.google.api.ServiceOrBuilder
    public boolean hasSystemParameters() {
        return this.systemParameters_ != null;
    }

    @Override // com.google.api.ServiceOrBuilder
    public boolean hasUsage() {
        return this.usage_ != null;
    }

    @Override // com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream codedOutputStream) {
        if (!this.name_.isEmpty()) {
            codedOutputStream.writeString(1, getName());
        }
        if (!this.title_.isEmpty()) {
            codedOutputStream.writeString(2, getTitle());
        }
        for (int i = 0; i < this.apis_.size(); i++) {
            codedOutputStream.writeMessage(3, this.apis_.get(i));
        }
        for (int i2 = 0; i2 < this.types_.size(); i2++) {
            codedOutputStream.writeMessage(4, this.types_.get(i2));
        }
        for (int i3 = 0; i3 < this.enums_.size(); i3++) {
            codedOutputStream.writeMessage(5, this.enums_.get(i3));
        }
        if (this.documentation_ != null) {
            codedOutputStream.writeMessage(6, getDocumentation());
        }
        if (this.backend_ != null) {
            codedOutputStream.writeMessage(8, getBackend());
        }
        if (this.http_ != null) {
            codedOutputStream.writeMessage(9, getHttp());
        }
        if (this.quota_ != null) {
            codedOutputStream.writeMessage(10, getQuota());
        }
        if (this.authentication_ != null) {
            codedOutputStream.writeMessage(11, getAuthentication());
        }
        if (this.context_ != null) {
            codedOutputStream.writeMessage(12, getContext());
        }
        if (this.usage_ != null) {
            codedOutputStream.writeMessage(15, getUsage());
        }
        for (int i4 = 0; i4 < this.endpoints_.size(); i4++) {
            codedOutputStream.writeMessage(18, this.endpoints_.get(i4));
        }
        if (this.configVersion_ != null) {
            codedOutputStream.writeMessage(20, getConfigVersion());
        }
        if (this.control_ != null) {
            codedOutputStream.writeMessage(21, getControl());
        }
        if (!this.producerProjectId_.isEmpty()) {
            codedOutputStream.writeString(22, getProducerProjectId());
        }
        for (int i5 = 0; i5 < this.logs_.size(); i5++) {
            codedOutputStream.writeMessage(23, this.logs_.get(i5));
        }
        for (int i6 = 0; i6 < this.metrics_.size(); i6++) {
            codedOutputStream.writeMessage(24, this.metrics_.get(i6));
        }
        for (int i7 = 0; i7 < this.monitoredResources_.size(); i7++) {
            codedOutputStream.writeMessage(25, this.monitoredResources_.get(i7));
        }
        if (this.billing_ != null) {
            codedOutputStream.writeMessage(26, getBilling());
        }
        if (this.logging_ != null) {
            codedOutputStream.writeMessage(27, getLogging());
        }
        if (this.monitoring_ != null) {
            codedOutputStream.writeMessage(28, getMonitoring());
        }
        if (this.systemParameters_ != null) {
            codedOutputStream.writeMessage(29, getSystemParameters());
        }
        if (!this.id_.isEmpty()) {
            codedOutputStream.writeString(33, getId());
        }
        if (this.sourceInfo_ != null) {
            codedOutputStream.writeMessage(37, getSourceInfo());
        }
        if (this.experimental_ != null) {
            codedOutputStream.writeMessage(101, getExperimental());
        }
    }
}
