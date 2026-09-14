package com.google.firebase.inappmessaging.internal.injection.components;

import android.app.Application;
import com.google.firebase.analytics.connector.AnalyticsConnector;
import com.google.firebase.events.Subscriber;
import com.google.firebase.inappmessaging.internal.AnalyticsEventsManager;
import com.google.firebase.inappmessaging.internal.CampaignCacheClient;
import com.google.firebase.inappmessaging.internal.CampaignCacheClient_Factory;
import com.google.firebase.inappmessaging.internal.DeveloperListenerManager;
import com.google.firebase.inappmessaging.internal.ForegroundNotifier;
import com.google.firebase.inappmessaging.internal.ImpressionStorageClient;
import com.google.firebase.inappmessaging.internal.ImpressionStorageClient_Factory;
import com.google.firebase.inappmessaging.internal.ProgramaticContextualTriggers;
import com.google.firebase.inappmessaging.internal.ProtoStorageClient;
import com.google.firebase.inappmessaging.internal.ProviderInstaller;
import com.google.firebase.inappmessaging.internal.ProviderInstaller_Factory;
import com.google.firebase.inappmessaging.internal.RateLimiterClient;
import com.google.firebase.inappmessaging.internal.RateLimiterClient_Factory;
import com.google.firebase.inappmessaging.internal.Schedulers;
import com.google.firebase.inappmessaging.internal.Schedulers_Factory;
import com.google.firebase.inappmessaging.internal.injection.modules.AnalyticsEventsModule;
import com.google.firebase.inappmessaging.internal.injection.modules.AnalyticsEventsModule_ProvidesAnalyticsConnectorEventsFactory;
import com.google.firebase.inappmessaging.internal.injection.modules.AnalyticsEventsModule_ProvidesAnalyticsEventsManagerFactory;
import com.google.firebase.inappmessaging.internal.injection.modules.AppMeasurementModule;
import com.google.firebase.inappmessaging.internal.injection.modules.AppMeasurementModule_ProvidesAnalyticsConnectorFactory;
import com.google.firebase.inappmessaging.internal.injection.modules.AppMeasurementModule_ProvidesSubsriberFactory;
import com.google.firebase.inappmessaging.internal.injection.modules.ApplicationModule;
import com.google.firebase.inappmessaging.internal.injection.modules.ApplicationModule_DeveloperListenerManagerFactory;
import com.google.firebase.inappmessaging.internal.injection.modules.ApplicationModule_ProvidesApplicationFactory;
import com.google.firebase.inappmessaging.internal.injection.modules.ForegroundFlowableModule;
import com.google.firebase.inappmessaging.internal.injection.modules.ForegroundFlowableModule_ProvidesAppForegroundEventStreamFactory;
import com.google.firebase.inappmessaging.internal.injection.modules.ForegroundNotifierModule;
import com.google.firebase.inappmessaging.internal.injection.modules.ForegroundNotifierModule_ProvidesForegroundFactory;
import com.google.firebase.inappmessaging.internal.injection.modules.GrpcChannelModule;
import com.google.firebase.inappmessaging.internal.injection.modules.GrpcChannelModule_ProvidesGrpcChannelFactory;
import com.google.firebase.inappmessaging.internal.injection.modules.GrpcChannelModule_ProvidesServiceHostFactory;
import com.google.firebase.inappmessaging.internal.injection.modules.ProgrammaticContextualTriggerFlowableModule;
import com.google.firebase.inappmessaging.internal.injection.modules.ProgrammaticContextualTriggerFlowableModule_ProvidesProgramaticContextualTriggerStreamFactory;
import com.google.firebase.inappmessaging.internal.injection.modules.ProgrammaticContextualTriggerFlowableModule_ProvidesProgramaticContextualTriggersFactory;
import com.google.firebase.inappmessaging.internal.injection.modules.ProtoStorageClientModule;
import com.google.firebase.inappmessaging.internal.injection.modules.ProtoStorageClientModule_ProvidesProtoStorageClientForCampaignFactory;
import com.google.firebase.inappmessaging.internal.injection.modules.ProtoStorageClientModule_ProvidesProtoStorageClientForImpressionStoreFactory;
import com.google.firebase.inappmessaging.internal.injection.modules.ProtoStorageClientModule_ProvidesProtoStorageClientForLimiterStoreFactory;
import com.google.firebase.inappmessaging.internal.injection.modules.RateLimitModule;
import com.google.firebase.inappmessaging.internal.injection.modules.RateLimitModule_ProvidesAppForegroundRateLimitFactory;
import com.google.firebase.inappmessaging.internal.injection.modules.SchedulerModule;
import com.google.firebase.inappmessaging.internal.injection.modules.SchedulerModule_ProvidesComputeSchedulerFactory;
import com.google.firebase.inappmessaging.internal.injection.modules.SchedulerModule_ProvidesIOSchedulerFactory;
import com.google.firebase.inappmessaging.internal.injection.modules.SchedulerModule_ProvidesMainThreadSchedulerFactory;
import com.google.firebase.inappmessaging.internal.injection.modules.SystemClockModule;
import com.google.firebase.inappmessaging.internal.injection.modules.SystemClockModule_ProvidesSystemClockModuleFactory;
import com.google.firebase.inappmessaging.internal.time.Clock;
import com.google.firebase.inappmessaging.model.ProtoMarshallerClient;
import com.google.firebase.inappmessaging.model.ProtoMarshallerClient_Factory;
import com.google.firebase.inappmessaging.model.RateLimit;
import dagger.internal.DoubleCheck;
import dagger.internal.Preconditions;
import io.grpc.Channel;
import io.reactivex.Scheduler;
import io.reactivex.flowables.ConnectableFlowable;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class DaggerUniversalComponent implements UniversalComponent {
    private Provider<CampaignCacheClient> campaignCacheClientProvider;
    private Provider<DeveloperListenerManager> developerListenerManagerProvider;
    private Provider<ImpressionStorageClient> impressionStorageClientProvider;
    private Provider<ProtoMarshallerClient> protoMarshallerClientProvider;
    private Provider<ProviderInstaller> providerInstallerProvider;
    private Provider<ConnectableFlowable<String>> providesAnalyticsConnectorEventsProvider;
    private Provider<AnalyticsConnector> providesAnalyticsConnectorProvider;
    private Provider<AnalyticsEventsManager> providesAnalyticsEventsManagerProvider;
    private Provider<ConnectableFlowable<String>> providesAppForegroundEventStreamProvider;
    private Provider<Application> providesApplicationProvider;
    private Provider<Scheduler> providesComputeSchedulerProvider;
    private Provider<ForegroundNotifier> providesForegroundProvider;
    private Provider<Channel> providesGrpcChannelProvider;
    private Provider<Scheduler> providesIOSchedulerProvider;
    private Provider<Scheduler> providesMainThreadSchedulerProvider;
    private Provider<ConnectableFlowable<String>> providesProgramaticContextualTriggerStreamProvider;
    private Provider<ProgramaticContextualTriggers> providesProgramaticContextualTriggersProvider;
    private Provider<ProtoStorageClient> providesProtoStorageClientForCampaignProvider;
    private Provider<ProtoStorageClient> providesProtoStorageClientForImpressionStoreProvider;
    private Provider<ProtoStorageClient> providesProtoStorageClientForLimiterStoreProvider;
    private Provider<String> providesServiceHostProvider;
    private Provider<Subscriber> providesSubsriberProvider;
    private Provider<Clock> providesSystemClockModuleProvider;
    private final RateLimitModule rateLimitModule;
    private Provider<RateLimiterClient> rateLimiterClientProvider;
    private Provider<Schedulers> schedulersProvider;
    private final SystemClockModule systemClockModule;

    /* loaded from: classes2.dex */
    public static final class Builder {
        private AnalyticsEventsModule analyticsEventsModule;
        private AppMeasurementModule appMeasurementModule;
        private ApplicationModule applicationModule;
        private ForegroundFlowableModule foregroundFlowableModule;
        private ForegroundNotifierModule foregroundNotifierModule;
        private GrpcChannelModule grpcChannelModule;
        private ProgrammaticContextualTriggerFlowableModule programmaticContextualTriggerFlowableModule;
        private ProtoStorageClientModule protoStorageClientModule;
        private RateLimitModule rateLimitModule;
        private SchedulerModule schedulerModule;
        private SystemClockModule systemClockModule;

        private Builder() {
        }

        public Builder analyticsEventsModule(AnalyticsEventsModule analyticsEventsModule) {
            this.analyticsEventsModule = (AnalyticsEventsModule) Preconditions.checkNotNull(analyticsEventsModule);
            return this;
        }

        public Builder appMeasurementModule(AppMeasurementModule appMeasurementModule) {
            this.appMeasurementModule = (AppMeasurementModule) Preconditions.checkNotNull(appMeasurementModule);
            return this;
        }

        public Builder applicationModule(ApplicationModule applicationModule) {
            this.applicationModule = (ApplicationModule) Preconditions.checkNotNull(applicationModule);
            return this;
        }

        public UniversalComponent build() {
            if (this.grpcChannelModule == null) {
                this.grpcChannelModule = new GrpcChannelModule();
            }
            if (this.schedulerModule == null) {
                this.schedulerModule = new SchedulerModule();
            }
            Preconditions.checkBuilderRequirement(this.applicationModule, ApplicationModule.class);
            if (this.foregroundNotifierModule == null) {
                this.foregroundNotifierModule = new ForegroundNotifierModule();
            }
            if (this.foregroundFlowableModule == null) {
                this.foregroundFlowableModule = new ForegroundFlowableModule();
            }
            Preconditions.checkBuilderRequirement(this.programmaticContextualTriggerFlowableModule, ProgrammaticContextualTriggerFlowableModule.class);
            if (this.analyticsEventsModule == null) {
                this.analyticsEventsModule = new AnalyticsEventsModule();
            }
            if (this.protoStorageClientModule == null) {
                this.protoStorageClientModule = new ProtoStorageClientModule();
            }
            if (this.systemClockModule == null) {
                this.systemClockModule = new SystemClockModule();
            }
            if (this.rateLimitModule == null) {
                this.rateLimitModule = new RateLimitModule();
            }
            Preconditions.checkBuilderRequirement(this.appMeasurementModule, AppMeasurementModule.class);
            return new DaggerUniversalComponent(this.grpcChannelModule, this.schedulerModule, this.applicationModule, this.foregroundNotifierModule, this.foregroundFlowableModule, this.programmaticContextualTriggerFlowableModule, this.analyticsEventsModule, this.protoStorageClientModule, this.systemClockModule, this.rateLimitModule, this.appMeasurementModule);
        }

        public Builder foregroundFlowableModule(ForegroundFlowableModule foregroundFlowableModule) {
            this.foregroundFlowableModule = (ForegroundFlowableModule) Preconditions.checkNotNull(foregroundFlowableModule);
            return this;
        }

        public Builder foregroundNotifierModule(ForegroundNotifierModule foregroundNotifierModule) {
            this.foregroundNotifierModule = (ForegroundNotifierModule) Preconditions.checkNotNull(foregroundNotifierModule);
            return this;
        }

        public Builder grpcChannelModule(GrpcChannelModule grpcChannelModule) {
            this.grpcChannelModule = (GrpcChannelModule) Preconditions.checkNotNull(grpcChannelModule);
            return this;
        }

        public Builder programmaticContextualTriggerFlowableModule(ProgrammaticContextualTriggerFlowableModule programmaticContextualTriggerFlowableModule) {
            this.programmaticContextualTriggerFlowableModule = (ProgrammaticContextualTriggerFlowableModule) Preconditions.checkNotNull(programmaticContextualTriggerFlowableModule);
            return this;
        }

        public Builder protoStorageClientModule(ProtoStorageClientModule protoStorageClientModule) {
            this.protoStorageClientModule = (ProtoStorageClientModule) Preconditions.checkNotNull(protoStorageClientModule);
            return this;
        }

        public Builder rateLimitModule(RateLimitModule rateLimitModule) {
            this.rateLimitModule = (RateLimitModule) Preconditions.checkNotNull(rateLimitModule);
            return this;
        }

        public Builder schedulerModule(SchedulerModule schedulerModule) {
            this.schedulerModule = (SchedulerModule) Preconditions.checkNotNull(schedulerModule);
            return this;
        }

        public Builder systemClockModule(SystemClockModule systemClockModule) {
            this.systemClockModule = (SystemClockModule) Preconditions.checkNotNull(systemClockModule);
            return this;
        }
    }

    private DaggerUniversalComponent(GrpcChannelModule grpcChannelModule, SchedulerModule schedulerModule, ApplicationModule applicationModule, ForegroundNotifierModule foregroundNotifierModule, ForegroundFlowableModule foregroundFlowableModule, ProgrammaticContextualTriggerFlowableModule programmaticContextualTriggerFlowableModule, AnalyticsEventsModule analyticsEventsModule, ProtoStorageClientModule protoStorageClientModule, SystemClockModule systemClockModule, RateLimitModule rateLimitModule, AppMeasurementModule appMeasurementModule) {
        this.systemClockModule = systemClockModule;
        this.rateLimitModule = rateLimitModule;
        initialize(grpcChannelModule, schedulerModule, applicationModule, foregroundNotifierModule, foregroundFlowableModule, programmaticContextualTriggerFlowableModule, analyticsEventsModule, protoStorageClientModule, systemClockModule, rateLimitModule, appMeasurementModule);
    }

    public static Builder builder() {
        return new Builder();
    }

    private void initialize(GrpcChannelModule grpcChannelModule, SchedulerModule schedulerModule, ApplicationModule applicationModule, ForegroundNotifierModule foregroundNotifierModule, ForegroundFlowableModule foregroundFlowableModule, ProgrammaticContextualTriggerFlowableModule programmaticContextualTriggerFlowableModule, AnalyticsEventsModule analyticsEventsModule, ProtoStorageClientModule protoStorageClientModule, SystemClockModule systemClockModule, RateLimitModule rateLimitModule, AppMeasurementModule appMeasurementModule) {
        this.providesApplicationProvider = DoubleCheck.provider(ApplicationModule_ProvidesApplicationFactory.create(applicationModule));
        this.providerInstallerProvider = DoubleCheck.provider(ProviderInstaller_Factory.create(this.providesApplicationProvider));
        this.providesServiceHostProvider = DoubleCheck.provider(GrpcChannelModule_ProvidesServiceHostFactory.create(grpcChannelModule));
        this.providesGrpcChannelProvider = DoubleCheck.provider(GrpcChannelModule_ProvidesGrpcChannelFactory.create(grpcChannelModule, this.providesServiceHostProvider));
        this.providesIOSchedulerProvider = DoubleCheck.provider(SchedulerModule_ProvidesIOSchedulerFactory.create(schedulerModule));
        this.providesComputeSchedulerProvider = DoubleCheck.provider(SchedulerModule_ProvidesComputeSchedulerFactory.create(schedulerModule));
        this.providesMainThreadSchedulerProvider = DoubleCheck.provider(SchedulerModule_ProvidesMainThreadSchedulerFactory.create(schedulerModule));
        this.schedulersProvider = DoubleCheck.provider(Schedulers_Factory.create(this.providesIOSchedulerProvider, this.providesComputeSchedulerProvider, this.providesMainThreadSchedulerProvider));
        this.providesForegroundProvider = DoubleCheck.provider(ForegroundNotifierModule_ProvidesForegroundFactory.create(foregroundNotifierModule));
        this.providesAppForegroundEventStreamProvider = DoubleCheck.provider(ForegroundFlowableModule_ProvidesAppForegroundEventStreamFactory.create(foregroundFlowableModule, this.providesApplicationProvider, this.providesForegroundProvider));
        this.providesProgramaticContextualTriggerStreamProvider = DoubleCheck.provider(ProgrammaticContextualTriggerFlowableModule_ProvidesProgramaticContextualTriggerStreamFactory.create(programmaticContextualTriggerFlowableModule));
        this.providesProgramaticContextualTriggersProvider = DoubleCheck.provider(ProgrammaticContextualTriggerFlowableModule_ProvidesProgramaticContextualTriggersFactory.create(programmaticContextualTriggerFlowableModule));
        this.providesAnalyticsConnectorProvider = DoubleCheck.provider(AppMeasurementModule_ProvidesAnalyticsConnectorFactory.create(appMeasurementModule));
        this.providesAnalyticsEventsManagerProvider = DoubleCheck.provider(AnalyticsEventsModule_ProvidesAnalyticsEventsManagerFactory.create(analyticsEventsModule, this.providesAnalyticsConnectorProvider));
        this.providesAnalyticsConnectorEventsProvider = DoubleCheck.provider(AnalyticsEventsModule_ProvidesAnalyticsConnectorEventsFactory.create(analyticsEventsModule, this.providesAnalyticsEventsManagerProvider));
        this.providesSubsriberProvider = DoubleCheck.provider(AppMeasurementModule_ProvidesSubsriberFactory.create(appMeasurementModule));
        this.providesProtoStorageClientForCampaignProvider = DoubleCheck.provider(ProtoStorageClientModule_ProvidesProtoStorageClientForCampaignFactory.create(protoStorageClientModule, this.providesApplicationProvider));
        this.providesSystemClockModuleProvider = SystemClockModule_ProvidesSystemClockModuleFactory.create(systemClockModule);
        this.campaignCacheClientProvider = DoubleCheck.provider(CampaignCacheClient_Factory.create(this.providesProtoStorageClientForCampaignProvider, this.providesApplicationProvider, this.providesSystemClockModuleProvider));
        this.providesProtoStorageClientForImpressionStoreProvider = DoubleCheck.provider(ProtoStorageClientModule_ProvidesProtoStorageClientForImpressionStoreFactory.create(protoStorageClientModule, this.providesApplicationProvider));
        this.impressionStorageClientProvider = DoubleCheck.provider(ImpressionStorageClient_Factory.create(this.providesProtoStorageClientForImpressionStoreProvider));
        this.protoMarshallerClientProvider = DoubleCheck.provider(ProtoMarshallerClient_Factory.create());
        this.providesProtoStorageClientForLimiterStoreProvider = DoubleCheck.provider(ProtoStorageClientModule_ProvidesProtoStorageClientForLimiterStoreFactory.create(protoStorageClientModule, this.providesApplicationProvider));
        this.rateLimiterClientProvider = DoubleCheck.provider(RateLimiterClient_Factory.create(this.providesProtoStorageClientForLimiterStoreProvider, this.providesSystemClockModuleProvider));
        this.developerListenerManagerProvider = DoubleCheck.provider(ApplicationModule_DeveloperListenerManagerFactory.create(applicationModule));
    }

    @Override // com.google.firebase.inappmessaging.internal.injection.components.UniversalComponent
    public AnalyticsConnector analyticsConnector() {
        return this.providesAnalyticsConnectorProvider.get();
    }

    @Override // com.google.firebase.inappmessaging.internal.injection.components.UniversalComponent
    public ConnectableFlowable<String> analyticsEventsFlowable() {
        return this.providesAnalyticsConnectorEventsProvider.get();
    }

    @Override // com.google.firebase.inappmessaging.internal.injection.components.UniversalComponent
    public AnalyticsEventsManager analyticsEventsManager() {
        return this.providesAnalyticsEventsManagerProvider.get();
    }

    @Override // com.google.firebase.inappmessaging.internal.injection.components.UniversalComponent
    public ConnectableFlowable<String> appForegroundEventFlowable() {
        return this.providesAppForegroundEventStreamProvider.get();
    }

    @Override // com.google.firebase.inappmessaging.internal.injection.components.UniversalComponent
    public RateLimit appForegroundRateLimit() {
        return RateLimitModule_ProvidesAppForegroundRateLimitFactory.providesAppForegroundRateLimit(this.rateLimitModule);
    }

    @Override // com.google.firebase.inappmessaging.internal.injection.components.UniversalComponent
    public Application application() {
        return this.providesApplicationProvider.get();
    }

    @Override // com.google.firebase.inappmessaging.internal.injection.components.UniversalComponent
    public CampaignCacheClient campaignCacheClient() {
        return this.campaignCacheClientProvider.get();
    }

    @Override // com.google.firebase.inappmessaging.internal.injection.components.UniversalComponent
    public Clock clock() {
        return SystemClockModule_ProvidesSystemClockModuleFactory.providesSystemClockModule(this.systemClockModule);
    }

    @Override // com.google.firebase.inappmessaging.internal.injection.components.UniversalComponent
    public DeveloperListenerManager developerListenerManager() {
        return this.developerListenerManagerProvider.get();
    }

    @Override // com.google.firebase.inappmessaging.internal.injection.components.UniversalComponent
    public Subscriber firebaseEventsSubscriber() {
        return this.providesSubsriberProvider.get();
    }

    @Override // com.google.firebase.inappmessaging.internal.injection.components.UniversalComponent
    public Channel gRPCChannel() {
        return this.providesGrpcChannelProvider.get();
    }

    @Override // com.google.firebase.inappmessaging.internal.injection.components.UniversalComponent
    public ImpressionStorageClient impressionStorageClient() {
        return this.impressionStorageClientProvider.get();
    }

    @Override // com.google.firebase.inappmessaging.internal.injection.components.UniversalComponent
    public ProviderInstaller probiderInstaller() {
        return this.providerInstallerProvider.get();
    }

    @Override // com.google.firebase.inappmessaging.internal.injection.components.UniversalComponent
    public ConnectableFlowable<String> programmaticContextualTriggerFlowable() {
        return this.providesProgramaticContextualTriggerStreamProvider.get();
    }

    @Override // com.google.firebase.inappmessaging.internal.injection.components.UniversalComponent
    public ProgramaticContextualTriggers programmaticContextualTriggers() {
        return this.providesProgramaticContextualTriggersProvider.get();
    }

    @Override // com.google.firebase.inappmessaging.internal.injection.components.UniversalComponent
    public ProtoMarshallerClient protoMarshallerClient() {
        return this.protoMarshallerClientProvider.get();
    }

    @Override // com.google.firebase.inappmessaging.internal.injection.components.UniversalComponent
    public RateLimiterClient rateLimiterClient() {
        return this.rateLimiterClientProvider.get();
    }

    @Override // com.google.firebase.inappmessaging.internal.injection.components.UniversalComponent
    public Schedulers schedulers() {
        return this.schedulersProvider.get();
    }
}
