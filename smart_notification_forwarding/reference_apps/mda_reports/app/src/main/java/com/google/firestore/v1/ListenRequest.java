package com.google.firestore.v1;

import com.google.firestore.v1.Target;
import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import com.google.protobuf.MapEntryLite;
import com.google.protobuf.MapFieldLite;
import com.google.protobuf.Parser;
import com.google.protobuf.WireFormat;
import java.io.InputStream;
import java.util.Collections;
import java.util.Map;

/* loaded from: classes2.dex */
public final class ListenRequest extends GeneratedMessageLite<ListenRequest, Builder> implements ListenRequestOrBuilder {
    public static final int ADD_TARGET_FIELD_NUMBER = 2;
    public static final int DATABASE_FIELD_NUMBER = 1;
    private static final ListenRequest DEFAULT_INSTANCE = new ListenRequest();
    public static final int LABELS_FIELD_NUMBER = 4;
    private static volatile Parser<ListenRequest> PARSER = null;
    public static final int REMOVE_TARGET_FIELD_NUMBER = 3;
    private int bitField0_;
    private Object targetChange_;
    private int targetChangeCase_ = 0;
    private MapFieldLite<String, String> labels_ = MapFieldLite.emptyMapField();
    private String database_ = "";

    /* renamed from: com.google.firestore.v1.ListenRequest$1, reason: invalid class name */
    /* loaded from: classes2.dex */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] a;
        static final /* synthetic */ int[] b = new int[GeneratedMessageLite.MethodToInvoke.values().length];

        static {
            try {
                b[GeneratedMessageLite.MethodToInvoke.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                b[GeneratedMessageLite.MethodToInvoke.IS_INITIALIZED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                b[GeneratedMessageLite.MethodToInvoke.MAKE_IMMUTABLE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                b[GeneratedMessageLite.MethodToInvoke.NEW_BUILDER.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                b[GeneratedMessageLite.MethodToInvoke.VISIT.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                b[GeneratedMessageLite.MethodToInvoke.MERGE_FROM_STREAM.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                b[GeneratedMessageLite.MethodToInvoke.GET_DEFAULT_INSTANCE.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                b[GeneratedMessageLite.MethodToInvoke.GET_PARSER.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            a = new int[TargetChangeCase.values().length];
            try {
                a[TargetChangeCase.ADD_TARGET.ordinal()] = 1;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                a[TargetChangeCase.REMOVE_TARGET.ordinal()] = 2;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                a[TargetChangeCase.TARGETCHANGE_NOT_SET.ordinal()] = 3;
            } catch (NoSuchFieldError unused11) {
            }
        }
    }

    /* loaded from: classes2.dex */
    public static final class Builder extends GeneratedMessageLite.Builder<ListenRequest, Builder> implements ListenRequestOrBuilder {
        private Builder() {
            super(ListenRequest.DEFAULT_INSTANCE);
        }

        /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        public Builder clearAddTarget() {
            a();
            ((ListenRequest) this.a).clearAddTarget();
            return this;
        }

        public Builder clearDatabase() {
            a();
            ((ListenRequest) this.a).clearDatabase();
            return this;
        }

        public Builder clearLabels() {
            a();
            ((ListenRequest) this.a).getMutableLabelsMap().clear();
            return this;
        }

        public Builder clearRemoveTarget() {
            a();
            ((ListenRequest) this.a).clearRemoveTarget();
            return this;
        }

        public Builder clearTargetChange() {
            a();
            ((ListenRequest) this.a).clearTargetChange();
            return this;
        }

        @Override // com.google.firestore.v1.ListenRequestOrBuilder
        public boolean containsLabels(String str) {
            if (str != null) {
                return ((ListenRequest) this.a).getLabelsMap().containsKey(str);
            }
            throw new NullPointerException();
        }

        @Override // com.google.firestore.v1.ListenRequestOrBuilder
        public Target getAddTarget() {
            return ((ListenRequest) this.a).getAddTarget();
        }

        @Override // com.google.firestore.v1.ListenRequestOrBuilder
        public String getDatabase() {
            return ((ListenRequest) this.a).getDatabase();
        }

        @Override // com.google.firestore.v1.ListenRequestOrBuilder
        public ByteString getDatabaseBytes() {
            return ((ListenRequest) this.a).getDatabaseBytes();
        }

        @Override // com.google.firestore.v1.ListenRequestOrBuilder
        @Deprecated
        public Map<String, String> getLabels() {
            return getLabelsMap();
        }

        @Override // com.google.firestore.v1.ListenRequestOrBuilder
        public int getLabelsCount() {
            return ((ListenRequest) this.a).getLabelsMap().size();
        }

        @Override // com.google.firestore.v1.ListenRequestOrBuilder
        public Map<String, String> getLabelsMap() {
            return Collections.unmodifiableMap(((ListenRequest) this.a).getLabelsMap());
        }

        @Override // com.google.firestore.v1.ListenRequestOrBuilder
        public String getLabelsOrDefault(String str, String str2) {
            if (str == null) {
                throw new NullPointerException();
            }
            Map<String, String> labelsMap = ((ListenRequest) this.a).getLabelsMap();
            return labelsMap.containsKey(str) ? labelsMap.get(str) : str2;
        }

        @Override // com.google.firestore.v1.ListenRequestOrBuilder
        public String getLabelsOrThrow(String str) {
            if (str == null) {
                throw new NullPointerException();
            }
            Map<String, String> labelsMap = ((ListenRequest) this.a).getLabelsMap();
            if (labelsMap.containsKey(str)) {
                return labelsMap.get(str);
            }
            throw new IllegalArgumentException();
        }

        @Override // com.google.firestore.v1.ListenRequestOrBuilder
        public int getRemoveTarget() {
            return ((ListenRequest) this.a).getRemoveTarget();
        }

        @Override // com.google.firestore.v1.ListenRequestOrBuilder
        public TargetChangeCase getTargetChangeCase() {
            return ((ListenRequest) this.a).getTargetChangeCase();
        }

        public Builder mergeAddTarget(Target target) {
            a();
            ((ListenRequest) this.a).mergeAddTarget(target);
            return this;
        }

        public Builder putAllLabels(Map<String, String> map) {
            a();
            ((ListenRequest) this.a).getMutableLabelsMap().putAll(map);
            return this;
        }

        public Builder putLabels(String str, String str2) {
            if (str == null) {
                throw new NullPointerException();
            }
            if (str2 == null) {
                throw new NullPointerException();
            }
            a();
            ((ListenRequest) this.a).getMutableLabelsMap().put(str, str2);
            return this;
        }

        public Builder removeLabels(String str) {
            if (str == null) {
                throw new NullPointerException();
            }
            a();
            ((ListenRequest) this.a).getMutableLabelsMap().remove(str);
            return this;
        }

        public Builder setAddTarget(Target.Builder builder) {
            a();
            ((ListenRequest) this.a).setAddTarget(builder);
            return this;
        }

        public Builder setAddTarget(Target target) {
            a();
            ((ListenRequest) this.a).setAddTarget(target);
            return this;
        }

        public Builder setDatabase(String str) {
            a();
            ((ListenRequest) this.a).setDatabase(str);
            return this;
        }

        public Builder setDatabaseBytes(ByteString byteString) {
            a();
            ((ListenRequest) this.a).setDatabaseBytes(byteString);
            return this;
        }

        public Builder setRemoveTarget(int i) {
            a();
            ((ListenRequest) this.a).setRemoveTarget(i);
            return this;
        }
    }

    /* loaded from: classes2.dex */
    private static final class LabelsDefaultEntryHolder {
        static final MapEntryLite<String, String> a;

        static {
            WireFormat.FieldType fieldType = WireFormat.FieldType.STRING;
            a = MapEntryLite.newDefaultInstance(fieldType, "", fieldType, "");
        }

        private LabelsDefaultEntryHolder() {
        }
    }

    /* loaded from: classes2.dex */
    public enum TargetChangeCase implements Internal.EnumLite {
        ADD_TARGET(2),
        REMOVE_TARGET(3),
        TARGETCHANGE_NOT_SET(0);

        private final int value;

        TargetChangeCase(int i) {
            this.value = i;
        }

        public static TargetChangeCase forNumber(int i) {
            if (i == 0) {
                return TARGETCHANGE_NOT_SET;
            }
            if (i == 2) {
                return ADD_TARGET;
            }
            if (i != 3) {
                return null;
            }
            return REMOVE_TARGET;
        }

        @Deprecated
        public static TargetChangeCase valueOf(int i) {
            return forNumber(i);
        }

        @Override // com.google.protobuf.Internal.EnumLite
        public int getNumber() {
            return this.value;
        }
    }

    static {
        DEFAULT_INSTANCE.b();
    }

    private ListenRequest() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearAddTarget() {
        if (this.targetChangeCase_ == 2) {
            this.targetChangeCase_ = 0;
            this.targetChange_ = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearDatabase() {
        this.database_ = getDefaultInstance().getDatabase();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearRemoveTarget() {
        if (this.targetChangeCase_ == 3) {
            this.targetChangeCase_ = 0;
            this.targetChange_ = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearTargetChange() {
        this.targetChangeCase_ = 0;
        this.targetChange_ = null;
    }

    public static ListenRequest getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Map<String, String> getMutableLabelsMap() {
        return internalGetMutableLabels();
    }

    private MapFieldLite<String, String> internalGetLabels() {
        return this.labels_;
    }

    private MapFieldLite<String, String> internalGetMutableLabels() {
        if (!this.labels_.isMutable()) {
            this.labels_ = this.labels_.mutableCopy();
        }
        return this.labels_;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeAddTarget(Target target) {
        if (this.targetChangeCase_ == 2 && this.targetChange_ != Target.getDefaultInstance()) {
            target = Target.newBuilder((Target) this.targetChange_).mergeFrom((Target.Builder) target).buildPartial();
        }
        this.targetChange_ = target;
        this.targetChangeCase_ = 2;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static Builder newBuilder(ListenRequest listenRequest) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom((Builder) listenRequest);
    }

    public static ListenRequest parseDelimitedFrom(InputStream inputStream) {
        return (ListenRequest) GeneratedMessageLite.a(DEFAULT_INSTANCE, inputStream);
    }

    public static ListenRequest parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (ListenRequest) GeneratedMessageLite.a(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static ListenRequest parseFrom(ByteString byteString) {
        return (ListenRequest) GeneratedMessageLite.a(DEFAULT_INSTANCE, byteString);
    }

    public static ListenRequest parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (ListenRequest) GeneratedMessageLite.a(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static ListenRequest parseFrom(CodedInputStream codedInputStream) {
        return (ListenRequest) GeneratedMessageLite.a(DEFAULT_INSTANCE, codedInputStream);
    }

    public static ListenRequest parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (ListenRequest) GeneratedMessageLite.a(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }

    public static ListenRequest parseFrom(InputStream inputStream) {
        return (ListenRequest) GeneratedMessageLite.b(DEFAULT_INSTANCE, inputStream);
    }

    public static ListenRequest parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (ListenRequest) GeneratedMessageLite.b(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static ListenRequest parseFrom(byte[] bArr) {
        return (ListenRequest) GeneratedMessageLite.a(DEFAULT_INSTANCE, bArr);
    }

    public static ListenRequest parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (ListenRequest) GeneratedMessageLite.a(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static Parser<ListenRequest> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setAddTarget(Target.Builder builder) {
        this.targetChange_ = builder.build();
        this.targetChangeCase_ = 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setAddTarget(Target target) {
        if (target == null) {
            throw new NullPointerException();
        }
        this.targetChange_ = target;
        this.targetChangeCase_ = 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDatabase(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.database_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDatabaseBytes(ByteString byteString) {
        if (byteString == null) {
            throw new NullPointerException();
        }
        AbstractMessageLite.a(byteString);
        this.database_ = byteString.toStringUtf8();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setRemoveTarget(int i) {
        this.targetChangeCase_ = 3;
        this.targetChange_ = Integer.valueOf(i);
    }

    /* JADX WARN: Removed duplicated region for block: B:92:0x0139  */
    @Override // com.google.protobuf.GeneratedMessageLite
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected final java.lang.Object a(com.google.protobuf.GeneratedMessageLite.MethodToInvoke r8, java.lang.Object r9, java.lang.Object r10) {
        /*
            Method dump skipped, instructions count: 368
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firestore.v1.ListenRequest.a(com.google.protobuf.GeneratedMessageLite$MethodToInvoke, java.lang.Object, java.lang.Object):java.lang.Object");
    }

    @Override // com.google.firestore.v1.ListenRequestOrBuilder
    public boolean containsLabels(String str) {
        if (str != null) {
            return internalGetLabels().containsKey(str);
        }
        throw new NullPointerException();
    }

    @Override // com.google.firestore.v1.ListenRequestOrBuilder
    public Target getAddTarget() {
        return this.targetChangeCase_ == 2 ? (Target) this.targetChange_ : Target.getDefaultInstance();
    }

    @Override // com.google.firestore.v1.ListenRequestOrBuilder
    public String getDatabase() {
        return this.database_;
    }

    @Override // com.google.firestore.v1.ListenRequestOrBuilder
    public ByteString getDatabaseBytes() {
        return ByteString.copyFromUtf8(this.database_);
    }

    @Override // com.google.firestore.v1.ListenRequestOrBuilder
    @Deprecated
    public Map<String, String> getLabels() {
        return getLabelsMap();
    }

    @Override // com.google.firestore.v1.ListenRequestOrBuilder
    public int getLabelsCount() {
        return internalGetLabels().size();
    }

    @Override // com.google.firestore.v1.ListenRequestOrBuilder
    public Map<String, String> getLabelsMap() {
        return Collections.unmodifiableMap(internalGetLabels());
    }

    @Override // com.google.firestore.v1.ListenRequestOrBuilder
    public String getLabelsOrDefault(String str, String str2) {
        if (str == null) {
            throw new NullPointerException();
        }
        MapFieldLite<String, String> internalGetLabels = internalGetLabels();
        return internalGetLabels.containsKey(str) ? internalGetLabels.get(str) : str2;
    }

    @Override // com.google.firestore.v1.ListenRequestOrBuilder
    public String getLabelsOrThrow(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        MapFieldLite<String, String> internalGetLabels = internalGetLabels();
        if (internalGetLabels.containsKey(str)) {
            return internalGetLabels.get(str);
        }
        throw new IllegalArgumentException();
    }

    @Override // com.google.firestore.v1.ListenRequestOrBuilder
    public int getRemoveTarget() {
        if (this.targetChangeCase_ == 3) {
            return ((Integer) this.targetChange_).intValue();
        }
        return 0;
    }

    @Override // com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int i = this.c;
        if (i != -1) {
            return i;
        }
        int computeStringSize = this.database_.isEmpty() ? 0 : 0 + CodedOutputStream.computeStringSize(1, getDatabase());
        if (this.targetChangeCase_ == 2) {
            computeStringSize += CodedOutputStream.computeMessageSize(2, (Target) this.targetChange_);
        }
        if (this.targetChangeCase_ == 3) {
            computeStringSize += CodedOutputStream.computeInt32Size(3, ((Integer) this.targetChange_).intValue());
        }
        for (Map.Entry<String, String> entry : internalGetLabels().entrySet()) {
            computeStringSize += LabelsDefaultEntryHolder.a.computeMessageSize(4, entry.getKey(), entry.getValue());
        }
        this.c = computeStringSize;
        return computeStringSize;
    }

    @Override // com.google.firestore.v1.ListenRequestOrBuilder
    public TargetChangeCase getTargetChangeCase() {
        return TargetChangeCase.forNumber(this.targetChangeCase_);
    }

    @Override // com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream codedOutputStream) {
        if (!this.database_.isEmpty()) {
            codedOutputStream.writeString(1, getDatabase());
        }
        if (this.targetChangeCase_ == 2) {
            codedOutputStream.writeMessage(2, (Target) this.targetChange_);
        }
        if (this.targetChangeCase_ == 3) {
            codedOutputStream.writeInt32(3, ((Integer) this.targetChange_).intValue());
        }
        for (Map.Entry<String, String> entry : internalGetLabels().entrySet()) {
            LabelsDefaultEntryHolder.a.serializeTo(codedOutputStream, 4, entry.getKey(), entry.getValue());
        }
    }
}
