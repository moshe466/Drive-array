package com.google.firebase.messaging;

import com.google.firebase.encoders.FieldDescriptor;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;
import com.google.firebase.encoders.config.Configurator;
import com.google.firebase.encoders.config.EncoderConfig;
import com.google.firebase.messaging.reporting.MessagingClientEvent;
import com.google.firebase.messaging.reporting.MessagingClientEventExtension;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import org.apache.tika.mime.MimeTypesReaderMetKeys;

/* loaded from: classes.dex */
public final class AutoProtoEncoderDoNotUseEncoder implements Configurator {
    public static final int CODEGEN_VERSION = 2;
    public static final Configurator CONFIG = new AutoProtoEncoderDoNotUseEncoder();

    /* loaded from: classes.dex */
    public static final class MessagingClientEventEncoder implements ObjectEncoder<MessagingClientEvent> {
        static final MessagingClientEventEncoder INSTANCE = new MessagingClientEventEncoder();
        private static final FieldDescriptor PROJECTNUMBER_DESCRIPTOR = e0.a.a(1, FieldDescriptor.builder("projectNumber"));
        private static final FieldDescriptor MESSAGEID_DESCRIPTOR = e0.a.a(2, FieldDescriptor.builder("messageId"));
        private static final FieldDescriptor INSTANCEID_DESCRIPTOR = e0.a.a(3, FieldDescriptor.builder("instanceId"));
        private static final FieldDescriptor MESSAGETYPE_DESCRIPTOR = e0.a.a(4, FieldDescriptor.builder("messageType"));
        private static final FieldDescriptor SDKPLATFORM_DESCRIPTOR = e0.a.a(5, FieldDescriptor.builder("sdkPlatform"));
        private static final FieldDescriptor PACKAGENAME_DESCRIPTOR = e0.a.a(6, FieldDescriptor.builder(RemoteConfigConstants.RequestFieldKey.PACKAGE_NAME));
        private static final FieldDescriptor COLLAPSEKEY_DESCRIPTOR = e0.a.a(7, FieldDescriptor.builder("collapseKey"));
        private static final FieldDescriptor PRIORITY_DESCRIPTOR = e0.a.a(8, FieldDescriptor.builder(MimeTypesReaderMetKeys.MAGIC_PRIORITY_ATTR));
        private static final FieldDescriptor TTL_DESCRIPTOR = e0.a.a(9, FieldDescriptor.builder("ttl"));
        private static final FieldDescriptor TOPIC_DESCRIPTOR = e0.a.a(10, FieldDescriptor.builder("topic"));
        private static final FieldDescriptor BULKID_DESCRIPTOR = e0.a.a(11, FieldDescriptor.builder("bulkId"));
        private static final FieldDescriptor EVENT_DESCRIPTOR = e0.a.a(12, FieldDescriptor.builder("event"));
        private static final FieldDescriptor ANALYTICSLABEL_DESCRIPTOR = e0.a.a(13, FieldDescriptor.builder("analyticsLabel"));
        private static final FieldDescriptor CAMPAIGNID_DESCRIPTOR = e0.a.a(14, FieldDescriptor.builder("campaignId"));
        private static final FieldDescriptor COMPOSERLABEL_DESCRIPTOR = e0.a.a(15, FieldDescriptor.builder("composerLabel"));

        private MessagingClientEventEncoder() {
        }

        @Override // com.google.firebase.encoders.Encoder
        public void encode(MessagingClientEvent messagingClientEvent, ObjectEncoderContext objectEncoderContext) {
            objectEncoderContext.add(PROJECTNUMBER_DESCRIPTOR, messagingClientEvent.getProjectNumber());
            objectEncoderContext.add(MESSAGEID_DESCRIPTOR, messagingClientEvent.getMessageId());
            objectEncoderContext.add(INSTANCEID_DESCRIPTOR, messagingClientEvent.getInstanceId());
            objectEncoderContext.add(MESSAGETYPE_DESCRIPTOR, messagingClientEvent.getMessageType());
            objectEncoderContext.add(SDKPLATFORM_DESCRIPTOR, messagingClientEvent.getSdkPlatform());
            objectEncoderContext.add(PACKAGENAME_DESCRIPTOR, messagingClientEvent.getPackageName());
            objectEncoderContext.add(COLLAPSEKEY_DESCRIPTOR, messagingClientEvent.getCollapseKey());
            objectEncoderContext.add(PRIORITY_DESCRIPTOR, messagingClientEvent.getPriority());
            objectEncoderContext.add(TTL_DESCRIPTOR, messagingClientEvent.getTtl());
            objectEncoderContext.add(TOPIC_DESCRIPTOR, messagingClientEvent.getTopic());
            objectEncoderContext.add(BULKID_DESCRIPTOR, messagingClientEvent.getBulkId());
            objectEncoderContext.add(EVENT_DESCRIPTOR, messagingClientEvent.getEvent());
            objectEncoderContext.add(ANALYTICSLABEL_DESCRIPTOR, messagingClientEvent.getAnalyticsLabel());
            objectEncoderContext.add(CAMPAIGNID_DESCRIPTOR, messagingClientEvent.getCampaignId());
            objectEncoderContext.add(COMPOSERLABEL_DESCRIPTOR, messagingClientEvent.getComposerLabel());
        }
    }

    /* loaded from: classes.dex */
    public static final class MessagingClientEventExtensionEncoder implements ObjectEncoder<MessagingClientEventExtension> {
        static final MessagingClientEventExtensionEncoder INSTANCE = new MessagingClientEventExtensionEncoder();
        private static final FieldDescriptor MESSAGINGCLIENTEVENT_DESCRIPTOR = e0.a.a(1, FieldDescriptor.builder("messagingClientEvent"));

        private MessagingClientEventExtensionEncoder() {
        }

        @Override // com.google.firebase.encoders.Encoder
        public void encode(MessagingClientEventExtension messagingClientEventExtension, ObjectEncoderContext objectEncoderContext) {
            objectEncoderContext.add(MESSAGINGCLIENTEVENT_DESCRIPTOR, messagingClientEventExtension.getMessagingClientEventInternal());
        }
    }

    /* loaded from: classes.dex */
    public static final class ProtoEncoderDoNotUseEncoder implements ObjectEncoder<ProtoEncoderDoNotUse> {
        static final ProtoEncoderDoNotUseEncoder INSTANCE = new ProtoEncoderDoNotUseEncoder();
        private static final FieldDescriptor MESSAGINGCLIENTEVENTEXTENSION_DESCRIPTOR = FieldDescriptor.of("messagingClientEventExtension");

        private ProtoEncoderDoNotUseEncoder() {
        }

        @Override // com.google.firebase.encoders.Encoder
        public void encode(ProtoEncoderDoNotUse protoEncoderDoNotUse, ObjectEncoderContext objectEncoderContext) {
            objectEncoderContext.add(MESSAGINGCLIENTEVENTEXTENSION_DESCRIPTOR, protoEncoderDoNotUse.getMessagingClientEventExtension());
        }
    }

    private AutoProtoEncoderDoNotUseEncoder() {
    }

    @Override // com.google.firebase.encoders.config.Configurator
    public void configure(EncoderConfig<?> encoderConfig) {
        encoderConfig.registerEncoder(ProtoEncoderDoNotUse.class, ProtoEncoderDoNotUseEncoder.INSTANCE);
        encoderConfig.registerEncoder(MessagingClientEventExtension.class, MessagingClientEventExtensionEncoder.INSTANCE);
        encoderConfig.registerEncoder(MessagingClientEvent.class, MessagingClientEventEncoder.INSTANCE);
    }
}
