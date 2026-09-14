package com.google.cloud.audit;

import com.google.cloud.audit.AuthenticationInfo;
import com.google.cloud.audit.AuthorizationInfo;
import com.google.cloud.audit.RequestMetadata;
import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.Any;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Parser;
import com.google.protobuf.Struct;
import com.google.rpc.Status;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.List;

/* loaded from: classes2.dex */
public final class AuditLog extends GeneratedMessageLite<AuditLog, Builder> implements AuditLogOrBuilder {
    public static final int AUTHENTICATION_INFO_FIELD_NUMBER = 3;
    public static final int AUTHORIZATION_INFO_FIELD_NUMBER = 9;
    private static final AuditLog DEFAULT_INSTANCE = new AuditLog();
    public static final int METHOD_NAME_FIELD_NUMBER = 8;
    public static final int NUM_RESPONSE_ITEMS_FIELD_NUMBER = 12;
    private static volatile Parser<AuditLog> PARSER = null;
    public static final int REQUEST_FIELD_NUMBER = 16;
    public static final int REQUEST_METADATA_FIELD_NUMBER = 4;
    public static final int RESOURCE_NAME_FIELD_NUMBER = 11;
    public static final int RESPONSE_FIELD_NUMBER = 17;
    public static final int SERVICE_DATA_FIELD_NUMBER = 15;
    public static final int SERVICE_NAME_FIELD_NUMBER = 7;
    public static final int STATUS_FIELD_NUMBER = 2;
    private AuthenticationInfo authenticationInfo_;
    private int bitField0_;
    private long numResponseItems_;
    private RequestMetadata requestMetadata_;
    private Struct request_;
    private Struct response_;
    private Any serviceData_;
    private Status status_;
    private String serviceName_ = "";
    private String methodName_ = "";
    private String resourceName_ = "";
    private Internal.ProtobufList<AuthorizationInfo> authorizationInfo_ = GeneratedMessageLite.f();

    /* renamed from: com.google.cloud.audit.AuditLog$1, reason: invalid class name */
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
    public static final class Builder extends GeneratedMessageLite.Builder<AuditLog, Builder> implements AuditLogOrBuilder {
        private Builder() {
            super(AuditLog.DEFAULT_INSTANCE);
        }

        /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        public Builder addAllAuthorizationInfo(Iterable<? extends AuthorizationInfo> iterable) {
            a();
            ((AuditLog) this.a).addAllAuthorizationInfo(iterable);
            return this;
        }

        public Builder addAuthorizationInfo(int i, AuthorizationInfo.Builder builder) {
            a();
            ((AuditLog) this.a).addAuthorizationInfo(i, builder);
            return this;
        }

        public Builder addAuthorizationInfo(int i, AuthorizationInfo authorizationInfo) {
            a();
            ((AuditLog) this.a).addAuthorizationInfo(i, authorizationInfo);
            return this;
        }

        public Builder addAuthorizationInfo(AuthorizationInfo.Builder builder) {
            a();
            ((AuditLog) this.a).addAuthorizationInfo(builder);
            return this;
        }

        public Builder addAuthorizationInfo(AuthorizationInfo authorizationInfo) {
            a();
            ((AuditLog) this.a).addAuthorizationInfo(authorizationInfo);
            return this;
        }

        public Builder clearAuthenticationInfo() {
            a();
            ((AuditLog) this.a).clearAuthenticationInfo();
            return this;
        }

        public Builder clearAuthorizationInfo() {
            a();
            ((AuditLog) this.a).clearAuthorizationInfo();
            return this;
        }

        public Builder clearMethodName() {
            a();
            ((AuditLog) this.a).clearMethodName();
            return this;
        }

        public Builder clearNumResponseItems() {
            a();
            ((AuditLog) this.a).clearNumResponseItems();
            return this;
        }

        public Builder clearRequest() {
            a();
            ((AuditLog) this.a).clearRequest();
            return this;
        }

        public Builder clearRequestMetadata() {
            a();
            ((AuditLog) this.a).clearRequestMetadata();
            return this;
        }

        public Builder clearResourceName() {
            a();
            ((AuditLog) this.a).clearResourceName();
            return this;
        }

        public Builder clearResponse() {
            a();
            ((AuditLog) this.a).clearResponse();
            return this;
        }

        public Builder clearServiceData() {
            a();
            ((AuditLog) this.a).clearServiceData();
            return this;
        }

        public Builder clearServiceName() {
            a();
            ((AuditLog) this.a).clearServiceName();
            return this;
        }

        public Builder clearStatus() {
            a();
            ((AuditLog) this.a).clearStatus();
            return this;
        }

        @Override // com.google.cloud.audit.AuditLogOrBuilder
        public AuthenticationInfo getAuthenticationInfo() {
            return ((AuditLog) this.a).getAuthenticationInfo();
        }

        @Override // com.google.cloud.audit.AuditLogOrBuilder
        public AuthorizationInfo getAuthorizationInfo(int i) {
            return ((AuditLog) this.a).getAuthorizationInfo(i);
        }

        @Override // com.google.cloud.audit.AuditLogOrBuilder
        public int getAuthorizationInfoCount() {
            return ((AuditLog) this.a).getAuthorizationInfoCount();
        }

        @Override // com.google.cloud.audit.AuditLogOrBuilder
        public List<AuthorizationInfo> getAuthorizationInfoList() {
            return Collections.unmodifiableList(((AuditLog) this.a).getAuthorizationInfoList());
        }

        @Override // com.google.cloud.audit.AuditLogOrBuilder
        public String getMethodName() {
            return ((AuditLog) this.a).getMethodName();
        }

        @Override // com.google.cloud.audit.AuditLogOrBuilder
        public ByteString getMethodNameBytes() {
            return ((AuditLog) this.a).getMethodNameBytes();
        }

        @Override // com.google.cloud.audit.AuditLogOrBuilder
        public long getNumResponseItems() {
            return ((AuditLog) this.a).getNumResponseItems();
        }

        @Override // com.google.cloud.audit.AuditLogOrBuilder
        public Struct getRequest() {
            return ((AuditLog) this.a).getRequest();
        }

        @Override // com.google.cloud.audit.AuditLogOrBuilder
        public RequestMetadata getRequestMetadata() {
            return ((AuditLog) this.a).getRequestMetadata();
        }

        @Override // com.google.cloud.audit.AuditLogOrBuilder
        public String getResourceName() {
            return ((AuditLog) this.a).getResourceName();
        }

        @Override // com.google.cloud.audit.AuditLogOrBuilder
        public ByteString getResourceNameBytes() {
            return ((AuditLog) this.a).getResourceNameBytes();
        }

        @Override // com.google.cloud.audit.AuditLogOrBuilder
        public Struct getResponse() {
            return ((AuditLog) this.a).getResponse();
        }

        @Override // com.google.cloud.audit.AuditLogOrBuilder
        public Any getServiceData() {
            return ((AuditLog) this.a).getServiceData();
        }

        @Override // com.google.cloud.audit.AuditLogOrBuilder
        public String getServiceName() {
            return ((AuditLog) this.a).getServiceName();
        }

        @Override // com.google.cloud.audit.AuditLogOrBuilder
        public ByteString getServiceNameBytes() {
            return ((AuditLog) this.a).getServiceNameBytes();
        }

        @Override // com.google.cloud.audit.AuditLogOrBuilder
        public Status getStatus() {
            return ((AuditLog) this.a).getStatus();
        }

        @Override // com.google.cloud.audit.AuditLogOrBuilder
        public boolean hasAuthenticationInfo() {
            return ((AuditLog) this.a).hasAuthenticationInfo();
        }

        @Override // com.google.cloud.audit.AuditLogOrBuilder
        public boolean hasRequest() {
            return ((AuditLog) this.a).hasRequest();
        }

        @Override // com.google.cloud.audit.AuditLogOrBuilder
        public boolean hasRequestMetadata() {
            return ((AuditLog) this.a).hasRequestMetadata();
        }

        @Override // com.google.cloud.audit.AuditLogOrBuilder
        public boolean hasResponse() {
            return ((AuditLog) this.a).hasResponse();
        }

        @Override // com.google.cloud.audit.AuditLogOrBuilder
        public boolean hasServiceData() {
            return ((AuditLog) this.a).hasServiceData();
        }

        @Override // com.google.cloud.audit.AuditLogOrBuilder
        public boolean hasStatus() {
            return ((AuditLog) this.a).hasStatus();
        }

        public Builder mergeAuthenticationInfo(AuthenticationInfo authenticationInfo) {
            a();
            ((AuditLog) this.a).mergeAuthenticationInfo(authenticationInfo);
            return this;
        }

        public Builder mergeRequest(Struct struct) {
            a();
            ((AuditLog) this.a).mergeRequest(struct);
            return this;
        }

        public Builder mergeRequestMetadata(RequestMetadata requestMetadata) {
            a();
            ((AuditLog) this.a).mergeRequestMetadata(requestMetadata);
            return this;
        }

        public Builder mergeResponse(Struct struct) {
            a();
            ((AuditLog) this.a).mergeResponse(struct);
            return this;
        }

        public Builder mergeServiceData(Any any) {
            a();
            ((AuditLog) this.a).mergeServiceData(any);
            return this;
        }

        public Builder mergeStatus(Status status) {
            a();
            ((AuditLog) this.a).mergeStatus(status);
            return this;
        }

        public Builder removeAuthorizationInfo(int i) {
            a();
            ((AuditLog) this.a).removeAuthorizationInfo(i);
            return this;
        }

        public Builder setAuthenticationInfo(AuthenticationInfo.Builder builder) {
            a();
            ((AuditLog) this.a).setAuthenticationInfo(builder);
            return this;
        }

        public Builder setAuthenticationInfo(AuthenticationInfo authenticationInfo) {
            a();
            ((AuditLog) this.a).setAuthenticationInfo(authenticationInfo);
            return this;
        }

        public Builder setAuthorizationInfo(int i, AuthorizationInfo.Builder builder) {
            a();
            ((AuditLog) this.a).setAuthorizationInfo(i, builder);
            return this;
        }

        public Builder setAuthorizationInfo(int i, AuthorizationInfo authorizationInfo) {
            a();
            ((AuditLog) this.a).setAuthorizationInfo(i, authorizationInfo);
            return this;
        }

        public Builder setMethodName(String str) {
            a();
            ((AuditLog) this.a).setMethodName(str);
            return this;
        }

        public Builder setMethodNameBytes(ByteString byteString) {
            a();
            ((AuditLog) this.a).setMethodNameBytes(byteString);
            return this;
        }

        public Builder setNumResponseItems(long j) {
            a();
            ((AuditLog) this.a).setNumResponseItems(j);
            return this;
        }

        public Builder setRequest(Struct.Builder builder) {
            a();
            ((AuditLog) this.a).setRequest(builder);
            return this;
        }

        public Builder setRequest(Struct struct) {
            a();
            ((AuditLog) this.a).setRequest(struct);
            return this;
        }

        public Builder setRequestMetadata(RequestMetadata.Builder builder) {
            a();
            ((AuditLog) this.a).setRequestMetadata(builder);
            return this;
        }

        public Builder setRequestMetadata(RequestMetadata requestMetadata) {
            a();
            ((AuditLog) this.a).setRequestMetadata(requestMetadata);
            return this;
        }

        public Builder setResourceName(String str) {
            a();
            ((AuditLog) this.a).setResourceName(str);
            return this;
        }

        public Builder setResourceNameBytes(ByteString byteString) {
            a();
            ((AuditLog) this.a).setResourceNameBytes(byteString);
            return this;
        }

        public Builder setResponse(Struct.Builder builder) {
            a();
            ((AuditLog) this.a).setResponse(builder);
            return this;
        }

        public Builder setResponse(Struct struct) {
            a();
            ((AuditLog) this.a).setResponse(struct);
            return this;
        }

        public Builder setServiceData(Any.Builder builder) {
            a();
            ((AuditLog) this.a).setServiceData(builder);
            return this;
        }

        public Builder setServiceData(Any any) {
            a();
            ((AuditLog) this.a).setServiceData(any);
            return this;
        }

        public Builder setServiceName(String str) {
            a();
            ((AuditLog) this.a).setServiceName(str);
            return this;
        }

        public Builder setServiceNameBytes(ByteString byteString) {
            a();
            ((AuditLog) this.a).setServiceNameBytes(byteString);
            return this;
        }

        public Builder setStatus(Status.Builder builder) {
            a();
            ((AuditLog) this.a).setStatus(builder);
            return this;
        }

        public Builder setStatus(Status status) {
            a();
            ((AuditLog) this.a).setStatus(status);
            return this;
        }
    }

    static {
        DEFAULT_INSTANCE.b();
    }

    private AuditLog() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllAuthorizationInfo(Iterable<? extends AuthorizationInfo> iterable) {
        ensureAuthorizationInfoIsMutable();
        AbstractMessageLite.a(iterable, this.authorizationInfo_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAuthorizationInfo(int i, AuthorizationInfo.Builder builder) {
        ensureAuthorizationInfoIsMutable();
        this.authorizationInfo_.add(i, builder.build());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAuthorizationInfo(int i, AuthorizationInfo authorizationInfo) {
        if (authorizationInfo == null) {
            throw new NullPointerException();
        }
        ensureAuthorizationInfoIsMutable();
        this.authorizationInfo_.add(i, authorizationInfo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAuthorizationInfo(AuthorizationInfo.Builder builder) {
        ensureAuthorizationInfoIsMutable();
        this.authorizationInfo_.add(builder.build());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAuthorizationInfo(AuthorizationInfo authorizationInfo) {
        if (authorizationInfo == null) {
            throw new NullPointerException();
        }
        ensureAuthorizationInfoIsMutable();
        this.authorizationInfo_.add(authorizationInfo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearAuthenticationInfo() {
        this.authenticationInfo_ = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearAuthorizationInfo() {
        this.authorizationInfo_ = GeneratedMessageLite.f();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearMethodName() {
        this.methodName_ = getDefaultInstance().getMethodName();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearNumResponseItems() {
        this.numResponseItems_ = 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearRequest() {
        this.request_ = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearRequestMetadata() {
        this.requestMetadata_ = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearResourceName() {
        this.resourceName_ = getDefaultInstance().getResourceName();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearResponse() {
        this.response_ = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearServiceData() {
        this.serviceData_ = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearServiceName() {
        this.serviceName_ = getDefaultInstance().getServiceName();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearStatus() {
        this.status_ = null;
    }

    private void ensureAuthorizationInfoIsMutable() {
        if (this.authorizationInfo_.isModifiable()) {
            return;
        }
        this.authorizationInfo_ = GeneratedMessageLite.a(this.authorizationInfo_);
    }

    public static AuditLog getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeAuthenticationInfo(AuthenticationInfo authenticationInfo) {
        AuthenticationInfo authenticationInfo2 = this.authenticationInfo_;
        if (authenticationInfo2 != null && authenticationInfo2 != AuthenticationInfo.getDefaultInstance()) {
            authenticationInfo = AuthenticationInfo.newBuilder(this.authenticationInfo_).mergeFrom((AuthenticationInfo.Builder) authenticationInfo).buildPartial();
        }
        this.authenticationInfo_ = authenticationInfo;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeRequest(Struct struct) {
        Struct struct2 = this.request_;
        if (struct2 != null && struct2 != Struct.getDefaultInstance()) {
            struct = Struct.newBuilder(this.request_).mergeFrom((Struct.Builder) struct).buildPartial();
        }
        this.request_ = struct;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeRequestMetadata(RequestMetadata requestMetadata) {
        RequestMetadata requestMetadata2 = this.requestMetadata_;
        if (requestMetadata2 != null && requestMetadata2 != RequestMetadata.getDefaultInstance()) {
            requestMetadata = RequestMetadata.newBuilder(this.requestMetadata_).mergeFrom((RequestMetadata.Builder) requestMetadata).buildPartial();
        }
        this.requestMetadata_ = requestMetadata;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeResponse(Struct struct) {
        Struct struct2 = this.response_;
        if (struct2 != null && struct2 != Struct.getDefaultInstance()) {
            struct = Struct.newBuilder(this.response_).mergeFrom((Struct.Builder) struct).buildPartial();
        }
        this.response_ = struct;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeServiceData(Any any) {
        Any any2 = this.serviceData_;
        if (any2 != null && any2 != Any.getDefaultInstance()) {
            any = Any.newBuilder(this.serviceData_).mergeFrom((Any.Builder) any).buildPartial();
        }
        this.serviceData_ = any;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeStatus(Status status) {
        Status status2 = this.status_;
        if (status2 != null && status2 != Status.getDefaultInstance()) {
            status = Status.newBuilder(this.status_).mergeFrom((Status.Builder) status).buildPartial();
        }
        this.status_ = status;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static Builder newBuilder(AuditLog auditLog) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom((Builder) auditLog);
    }

    public static AuditLog parseDelimitedFrom(InputStream inputStream) {
        return (AuditLog) GeneratedMessageLite.a(DEFAULT_INSTANCE, inputStream);
    }

    public static AuditLog parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (AuditLog) GeneratedMessageLite.a(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static AuditLog parseFrom(ByteString byteString) {
        return (AuditLog) GeneratedMessageLite.a(DEFAULT_INSTANCE, byteString);
    }

    public static AuditLog parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (AuditLog) GeneratedMessageLite.a(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static AuditLog parseFrom(CodedInputStream codedInputStream) {
        return (AuditLog) GeneratedMessageLite.a(DEFAULT_INSTANCE, codedInputStream);
    }

    public static AuditLog parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (AuditLog) GeneratedMessageLite.a(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }

    public static AuditLog parseFrom(InputStream inputStream) {
        return (AuditLog) GeneratedMessageLite.b(DEFAULT_INSTANCE, inputStream);
    }

    public static AuditLog parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (AuditLog) GeneratedMessageLite.b(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static AuditLog parseFrom(byte[] bArr) {
        return (AuditLog) GeneratedMessageLite.a(DEFAULT_INSTANCE, bArr);
    }

    public static AuditLog parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (AuditLog) GeneratedMessageLite.a(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static Parser<AuditLog> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeAuthorizationInfo(int i) {
        ensureAuthorizationInfoIsMutable();
        this.authorizationInfo_.remove(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setAuthenticationInfo(AuthenticationInfo.Builder builder) {
        this.authenticationInfo_ = builder.build();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setAuthenticationInfo(AuthenticationInfo authenticationInfo) {
        if (authenticationInfo == null) {
            throw new NullPointerException();
        }
        this.authenticationInfo_ = authenticationInfo;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setAuthorizationInfo(int i, AuthorizationInfo.Builder builder) {
        ensureAuthorizationInfoIsMutable();
        this.authorizationInfo_.set(i, builder.build());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setAuthorizationInfo(int i, AuthorizationInfo authorizationInfo) {
        if (authorizationInfo == null) {
            throw new NullPointerException();
        }
        ensureAuthorizationInfoIsMutable();
        this.authorizationInfo_.set(i, authorizationInfo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setMethodName(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.methodName_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setMethodNameBytes(ByteString byteString) {
        if (byteString == null) {
            throw new NullPointerException();
        }
        AbstractMessageLite.a(byteString);
        this.methodName_ = byteString.toStringUtf8();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setNumResponseItems(long j) {
        this.numResponseItems_ = j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setRequest(Struct.Builder builder) {
        this.request_ = builder.build();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setRequest(Struct struct) {
        if (struct == null) {
            throw new NullPointerException();
        }
        this.request_ = struct;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setRequestMetadata(RequestMetadata.Builder builder) {
        this.requestMetadata_ = builder.build();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setRequestMetadata(RequestMetadata requestMetadata) {
        if (requestMetadata == null) {
            throw new NullPointerException();
        }
        this.requestMetadata_ = requestMetadata;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setResourceName(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.resourceName_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setResourceNameBytes(ByteString byteString) {
        if (byteString == null) {
            throw new NullPointerException();
        }
        AbstractMessageLite.a(byteString);
        this.resourceName_ = byteString.toStringUtf8();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setResponse(Struct.Builder builder) {
        this.response_ = builder.build();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setResponse(Struct struct) {
        if (struct == null) {
            throw new NullPointerException();
        }
        this.response_ = struct;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setServiceData(Any.Builder builder) {
        this.serviceData_ = builder.build();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setServiceData(Any any) {
        if (any == null) {
            throw new NullPointerException();
        }
        this.serviceData_ = any;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setServiceName(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.serviceName_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setServiceNameBytes(ByteString byteString) {
        if (byteString == null) {
            throw new NullPointerException();
        }
        AbstractMessageLite.a(byteString);
        this.serviceName_ = byteString.toStringUtf8();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setStatus(Status.Builder builder) {
        this.status_ = builder.build();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setStatus(Status status) {
        if (status == null) {
            throw new NullPointerException();
        }
        this.status_ = status;
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:26:0x003a. Please report as an issue. */
    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object a(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        boolean z = false;
        AnonymousClass1 anonymousClass1 = null;
        switch (AnonymousClass1.a[methodToInvoke.ordinal()]) {
            case 1:
                return new AuditLog();
            case 2:
                return DEFAULT_INSTANCE;
            case 3:
                this.authorizationInfo_.makeImmutable();
                return null;
            case 4:
                return new Builder(anonymousClass1);
            case 5:
                GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                AuditLog auditLog = (AuditLog) obj2;
                this.serviceName_ = visitor.visitString(!this.serviceName_.isEmpty(), this.serviceName_, !auditLog.serviceName_.isEmpty(), auditLog.serviceName_);
                this.methodName_ = visitor.visitString(!this.methodName_.isEmpty(), this.methodName_, !auditLog.methodName_.isEmpty(), auditLog.methodName_);
                this.resourceName_ = visitor.visitString(!this.resourceName_.isEmpty(), this.resourceName_, !auditLog.resourceName_.isEmpty(), auditLog.resourceName_);
                this.numResponseItems_ = visitor.visitLong(this.numResponseItems_ != 0, this.numResponseItems_, auditLog.numResponseItems_ != 0, auditLog.numResponseItems_);
                this.status_ = (Status) visitor.visitMessage(this.status_, auditLog.status_);
                this.authenticationInfo_ = (AuthenticationInfo) visitor.visitMessage(this.authenticationInfo_, auditLog.authenticationInfo_);
                this.authorizationInfo_ = visitor.visitList(this.authorizationInfo_, auditLog.authorizationInfo_);
                this.requestMetadata_ = (RequestMetadata) visitor.visitMessage(this.requestMetadata_, auditLog.requestMetadata_);
                this.request_ = (Struct) visitor.visitMessage(this.request_, auditLog.request_);
                this.response_ = (Struct) visitor.visitMessage(this.response_, auditLog.response_);
                this.serviceData_ = (Any) visitor.visitMessage(this.serviceData_, auditLog.serviceData_);
                if (visitor == GeneratedMessageLite.MergeFromVisitor.INSTANCE) {
                    this.bitField0_ |= auditLog.bitField0_;
                }
                return this;
            case 6:
                CodedInputStream codedInputStream = (CodedInputStream) obj;
                ExtensionRegistryLite extensionRegistryLite = (ExtensionRegistryLite) obj2;
                while (!z) {
                    try {
                        int readTag = codedInputStream.readTag();
                        switch (readTag) {
                            case 0:
                                z = true;
                            case 18:
                                Status.Builder builder = this.status_ != null ? this.status_.toBuilder() : null;
                                this.status_ = (Status) codedInputStream.readMessage(Status.parser(), extensionRegistryLite);
                                if (builder != null) {
                                    builder.mergeFrom((Status.Builder) this.status_);
                                    this.status_ = builder.buildPartial();
                                }
                            case 26:
                                AuthenticationInfo.Builder builder2 = this.authenticationInfo_ != null ? this.authenticationInfo_.toBuilder() : null;
                                this.authenticationInfo_ = (AuthenticationInfo) codedInputStream.readMessage(AuthenticationInfo.parser(), extensionRegistryLite);
                                if (builder2 != null) {
                                    builder2.mergeFrom((AuthenticationInfo.Builder) this.authenticationInfo_);
                                    this.authenticationInfo_ = builder2.buildPartial();
                                }
                            case 34:
                                RequestMetadata.Builder builder3 = this.requestMetadata_ != null ? this.requestMetadata_.toBuilder() : null;
                                this.requestMetadata_ = (RequestMetadata) codedInputStream.readMessage(RequestMetadata.parser(), extensionRegistryLite);
                                if (builder3 != null) {
                                    builder3.mergeFrom((RequestMetadata.Builder) this.requestMetadata_);
                                    this.requestMetadata_ = builder3.buildPartial();
                                }
                            case 58:
                                this.serviceName_ = codedInputStream.readStringRequireUtf8();
                            case 66:
                                this.methodName_ = codedInputStream.readStringRequireUtf8();
                            case 74:
                                if (!this.authorizationInfo_.isModifiable()) {
                                    this.authorizationInfo_ = GeneratedMessageLite.a(this.authorizationInfo_);
                                }
                                this.authorizationInfo_.add((AuthorizationInfo) codedInputStream.readMessage(AuthorizationInfo.parser(), extensionRegistryLite));
                            case 90:
                                this.resourceName_ = codedInputStream.readStringRequireUtf8();
                            case 96:
                                this.numResponseItems_ = codedInputStream.readInt64();
                            case 122:
                                Any.Builder builder4 = this.serviceData_ != null ? this.serviceData_.toBuilder() : null;
                                this.serviceData_ = (Any) codedInputStream.readMessage(Any.parser(), extensionRegistryLite);
                                if (builder4 != null) {
                                    builder4.mergeFrom((Any.Builder) this.serviceData_);
                                    this.serviceData_ = builder4.buildPartial();
                                }
                            case 130:
                                Struct.Builder builder5 = this.request_ != null ? this.request_.toBuilder() : null;
                                this.request_ = (Struct) codedInputStream.readMessage(Struct.parser(), extensionRegistryLite);
                                if (builder5 != null) {
                                    builder5.mergeFrom((Struct.Builder) this.request_);
                                    this.request_ = builder5.buildPartial();
                                }
                            case 138:
                                Struct.Builder builder6 = this.response_ != null ? this.response_.toBuilder() : null;
                                this.response_ = (Struct) codedInputStream.readMessage(Struct.parser(), extensionRegistryLite);
                                if (builder6 != null) {
                                    builder6.mergeFrom((Struct.Builder) this.response_);
                                    this.response_ = builder6.buildPartial();
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
                    synchronized (AuditLog.class) {
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

    @Override // com.google.cloud.audit.AuditLogOrBuilder
    public AuthenticationInfo getAuthenticationInfo() {
        AuthenticationInfo authenticationInfo = this.authenticationInfo_;
        return authenticationInfo == null ? AuthenticationInfo.getDefaultInstance() : authenticationInfo;
    }

    @Override // com.google.cloud.audit.AuditLogOrBuilder
    public AuthorizationInfo getAuthorizationInfo(int i) {
        return this.authorizationInfo_.get(i);
    }

    @Override // com.google.cloud.audit.AuditLogOrBuilder
    public int getAuthorizationInfoCount() {
        return this.authorizationInfo_.size();
    }

    @Override // com.google.cloud.audit.AuditLogOrBuilder
    public List<AuthorizationInfo> getAuthorizationInfoList() {
        return this.authorizationInfo_;
    }

    public AuthorizationInfoOrBuilder getAuthorizationInfoOrBuilder(int i) {
        return this.authorizationInfo_.get(i);
    }

    public List<? extends AuthorizationInfoOrBuilder> getAuthorizationInfoOrBuilderList() {
        return this.authorizationInfo_;
    }

    @Override // com.google.cloud.audit.AuditLogOrBuilder
    public String getMethodName() {
        return this.methodName_;
    }

    @Override // com.google.cloud.audit.AuditLogOrBuilder
    public ByteString getMethodNameBytes() {
        return ByteString.copyFromUtf8(this.methodName_);
    }

    @Override // com.google.cloud.audit.AuditLogOrBuilder
    public long getNumResponseItems() {
        return this.numResponseItems_;
    }

    @Override // com.google.cloud.audit.AuditLogOrBuilder
    public Struct getRequest() {
        Struct struct = this.request_;
        return struct == null ? Struct.getDefaultInstance() : struct;
    }

    @Override // com.google.cloud.audit.AuditLogOrBuilder
    public RequestMetadata getRequestMetadata() {
        RequestMetadata requestMetadata = this.requestMetadata_;
        return requestMetadata == null ? RequestMetadata.getDefaultInstance() : requestMetadata;
    }

    @Override // com.google.cloud.audit.AuditLogOrBuilder
    public String getResourceName() {
        return this.resourceName_;
    }

    @Override // com.google.cloud.audit.AuditLogOrBuilder
    public ByteString getResourceNameBytes() {
        return ByteString.copyFromUtf8(this.resourceName_);
    }

    @Override // com.google.cloud.audit.AuditLogOrBuilder
    public Struct getResponse() {
        Struct struct = this.response_;
        return struct == null ? Struct.getDefaultInstance() : struct;
    }

    @Override // com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int i = this.c;
        if (i != -1) {
            return i;
        }
        int computeMessageSize = this.status_ != null ? CodedOutputStream.computeMessageSize(2, getStatus()) + 0 : 0;
        if (this.authenticationInfo_ != null) {
            computeMessageSize += CodedOutputStream.computeMessageSize(3, getAuthenticationInfo());
        }
        if (this.requestMetadata_ != null) {
            computeMessageSize += CodedOutputStream.computeMessageSize(4, getRequestMetadata());
        }
        if (!this.serviceName_.isEmpty()) {
            computeMessageSize += CodedOutputStream.computeStringSize(7, getServiceName());
        }
        if (!this.methodName_.isEmpty()) {
            computeMessageSize += CodedOutputStream.computeStringSize(8, getMethodName());
        }
        for (int i2 = 0; i2 < this.authorizationInfo_.size(); i2++) {
            computeMessageSize += CodedOutputStream.computeMessageSize(9, this.authorizationInfo_.get(i2));
        }
        if (!this.resourceName_.isEmpty()) {
            computeMessageSize += CodedOutputStream.computeStringSize(11, getResourceName());
        }
        long j = this.numResponseItems_;
        if (j != 0) {
            computeMessageSize += CodedOutputStream.computeInt64Size(12, j);
        }
        if (this.serviceData_ != null) {
            computeMessageSize += CodedOutputStream.computeMessageSize(15, getServiceData());
        }
        if (this.request_ != null) {
            computeMessageSize += CodedOutputStream.computeMessageSize(16, getRequest());
        }
        if (this.response_ != null) {
            computeMessageSize += CodedOutputStream.computeMessageSize(17, getResponse());
        }
        this.c = computeMessageSize;
        return computeMessageSize;
    }

    @Override // com.google.cloud.audit.AuditLogOrBuilder
    public Any getServiceData() {
        Any any = this.serviceData_;
        return any == null ? Any.getDefaultInstance() : any;
    }

    @Override // com.google.cloud.audit.AuditLogOrBuilder
    public String getServiceName() {
        return this.serviceName_;
    }

    @Override // com.google.cloud.audit.AuditLogOrBuilder
    public ByteString getServiceNameBytes() {
        return ByteString.copyFromUtf8(this.serviceName_);
    }

    @Override // com.google.cloud.audit.AuditLogOrBuilder
    public Status getStatus() {
        Status status = this.status_;
        return status == null ? Status.getDefaultInstance() : status;
    }

    @Override // com.google.cloud.audit.AuditLogOrBuilder
    public boolean hasAuthenticationInfo() {
        return this.authenticationInfo_ != null;
    }

    @Override // com.google.cloud.audit.AuditLogOrBuilder
    public boolean hasRequest() {
        return this.request_ != null;
    }

    @Override // com.google.cloud.audit.AuditLogOrBuilder
    public boolean hasRequestMetadata() {
        return this.requestMetadata_ != null;
    }

    @Override // com.google.cloud.audit.AuditLogOrBuilder
    public boolean hasResponse() {
        return this.response_ != null;
    }

    @Override // com.google.cloud.audit.AuditLogOrBuilder
    public boolean hasServiceData() {
        return this.serviceData_ != null;
    }

    @Override // com.google.cloud.audit.AuditLogOrBuilder
    public boolean hasStatus() {
        return this.status_ != null;
    }

    @Override // com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream codedOutputStream) {
        if (this.status_ != null) {
            codedOutputStream.writeMessage(2, getStatus());
        }
        if (this.authenticationInfo_ != null) {
            codedOutputStream.writeMessage(3, getAuthenticationInfo());
        }
        if (this.requestMetadata_ != null) {
            codedOutputStream.writeMessage(4, getRequestMetadata());
        }
        if (!this.serviceName_.isEmpty()) {
            codedOutputStream.writeString(7, getServiceName());
        }
        if (!this.methodName_.isEmpty()) {
            codedOutputStream.writeString(8, getMethodName());
        }
        for (int i = 0; i < this.authorizationInfo_.size(); i++) {
            codedOutputStream.writeMessage(9, this.authorizationInfo_.get(i));
        }
        if (!this.resourceName_.isEmpty()) {
            codedOutputStream.writeString(11, getResourceName());
        }
        long j = this.numResponseItems_;
        if (j != 0) {
            codedOutputStream.writeInt64(12, j);
        }
        if (this.serviceData_ != null) {
            codedOutputStream.writeMessage(15, getServiceData());
        }
        if (this.request_ != null) {
            codedOutputStream.writeMessage(16, getRequest());
        }
        if (this.response_ != null) {
            codedOutputStream.writeMessage(17, getResponse());
        }
    }
}
