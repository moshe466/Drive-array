package com.google.protobuf;

import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import com.google.protobuf.Method;
import com.google.protobuf.Mixin;
import com.google.protobuf.Option;
import com.google.protobuf.SourceContext;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.List;

/* loaded from: classes2.dex */
public final class Api extends GeneratedMessageLite<Api, Builder> implements ApiOrBuilder {
    private static final Api DEFAULT_INSTANCE = new Api();
    public static final int METHODS_FIELD_NUMBER = 2;
    public static final int MIXINS_FIELD_NUMBER = 6;
    public static final int NAME_FIELD_NUMBER = 1;
    public static final int OPTIONS_FIELD_NUMBER = 3;
    private static volatile Parser<Api> PARSER = null;
    public static final int SOURCE_CONTEXT_FIELD_NUMBER = 5;
    public static final int SYNTAX_FIELD_NUMBER = 7;
    public static final int VERSION_FIELD_NUMBER = 4;
    private int bitField0_;
    private SourceContext sourceContext_;
    private int syntax_;
    private String name_ = "";
    private Internal.ProtobufList<Method> methods_ = GeneratedMessageLite.f();
    private Internal.ProtobufList<Option> options_ = GeneratedMessageLite.f();
    private String version_ = "";
    private Internal.ProtobufList<Mixin> mixins_ = GeneratedMessageLite.f();

    /* renamed from: com.google.protobuf.Api$1, reason: invalid class name */
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
    public static final class Builder extends GeneratedMessageLite.Builder<Api, Builder> implements ApiOrBuilder {
        private Builder() {
            super(Api.DEFAULT_INSTANCE);
        }

        /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        public Builder addAllMethods(Iterable<? extends Method> iterable) {
            a();
            ((Api) this.a).addAllMethods(iterable);
            return this;
        }

        public Builder addAllMixins(Iterable<? extends Mixin> iterable) {
            a();
            ((Api) this.a).addAllMixins(iterable);
            return this;
        }

        public Builder addAllOptions(Iterable<? extends Option> iterable) {
            a();
            ((Api) this.a).addAllOptions(iterable);
            return this;
        }

        public Builder addMethods(int i, Method.Builder builder) {
            a();
            ((Api) this.a).addMethods(i, builder);
            return this;
        }

        public Builder addMethods(int i, Method method) {
            a();
            ((Api) this.a).addMethods(i, method);
            return this;
        }

        public Builder addMethods(Method.Builder builder) {
            a();
            ((Api) this.a).addMethods(builder);
            return this;
        }

        public Builder addMethods(Method method) {
            a();
            ((Api) this.a).addMethods(method);
            return this;
        }

        public Builder addMixins(int i, Mixin.Builder builder) {
            a();
            ((Api) this.a).addMixins(i, builder);
            return this;
        }

        public Builder addMixins(int i, Mixin mixin) {
            a();
            ((Api) this.a).addMixins(i, mixin);
            return this;
        }

        public Builder addMixins(Mixin.Builder builder) {
            a();
            ((Api) this.a).addMixins(builder);
            return this;
        }

        public Builder addMixins(Mixin mixin) {
            a();
            ((Api) this.a).addMixins(mixin);
            return this;
        }

        public Builder addOptions(int i, Option.Builder builder) {
            a();
            ((Api) this.a).addOptions(i, builder);
            return this;
        }

        public Builder addOptions(int i, Option option) {
            a();
            ((Api) this.a).addOptions(i, option);
            return this;
        }

        public Builder addOptions(Option.Builder builder) {
            a();
            ((Api) this.a).addOptions(builder);
            return this;
        }

        public Builder addOptions(Option option) {
            a();
            ((Api) this.a).addOptions(option);
            return this;
        }

        public Builder clearMethods() {
            a();
            ((Api) this.a).clearMethods();
            return this;
        }

        public Builder clearMixins() {
            a();
            ((Api) this.a).clearMixins();
            return this;
        }

        public Builder clearName() {
            a();
            ((Api) this.a).clearName();
            return this;
        }

        public Builder clearOptions() {
            a();
            ((Api) this.a).clearOptions();
            return this;
        }

        public Builder clearSourceContext() {
            a();
            ((Api) this.a).clearSourceContext();
            return this;
        }

        public Builder clearSyntax() {
            a();
            ((Api) this.a).clearSyntax();
            return this;
        }

        public Builder clearVersion() {
            a();
            ((Api) this.a).clearVersion();
            return this;
        }

        @Override // com.google.protobuf.ApiOrBuilder
        public Method getMethods(int i) {
            return ((Api) this.a).getMethods(i);
        }

        @Override // com.google.protobuf.ApiOrBuilder
        public int getMethodsCount() {
            return ((Api) this.a).getMethodsCount();
        }

        @Override // com.google.protobuf.ApiOrBuilder
        public List<Method> getMethodsList() {
            return Collections.unmodifiableList(((Api) this.a).getMethodsList());
        }

        @Override // com.google.protobuf.ApiOrBuilder
        public Mixin getMixins(int i) {
            return ((Api) this.a).getMixins(i);
        }

        @Override // com.google.protobuf.ApiOrBuilder
        public int getMixinsCount() {
            return ((Api) this.a).getMixinsCount();
        }

        @Override // com.google.protobuf.ApiOrBuilder
        public List<Mixin> getMixinsList() {
            return Collections.unmodifiableList(((Api) this.a).getMixinsList());
        }

        @Override // com.google.protobuf.ApiOrBuilder
        public String getName() {
            return ((Api) this.a).getName();
        }

        @Override // com.google.protobuf.ApiOrBuilder
        public ByteString getNameBytes() {
            return ((Api) this.a).getNameBytes();
        }

        @Override // com.google.protobuf.ApiOrBuilder
        public Option getOptions(int i) {
            return ((Api) this.a).getOptions(i);
        }

        @Override // com.google.protobuf.ApiOrBuilder
        public int getOptionsCount() {
            return ((Api) this.a).getOptionsCount();
        }

        @Override // com.google.protobuf.ApiOrBuilder
        public List<Option> getOptionsList() {
            return Collections.unmodifiableList(((Api) this.a).getOptionsList());
        }

        @Override // com.google.protobuf.ApiOrBuilder
        public SourceContext getSourceContext() {
            return ((Api) this.a).getSourceContext();
        }

        @Override // com.google.protobuf.ApiOrBuilder
        public Syntax getSyntax() {
            return ((Api) this.a).getSyntax();
        }

        @Override // com.google.protobuf.ApiOrBuilder
        public int getSyntaxValue() {
            return ((Api) this.a).getSyntaxValue();
        }

        @Override // com.google.protobuf.ApiOrBuilder
        public String getVersion() {
            return ((Api) this.a).getVersion();
        }

        @Override // com.google.protobuf.ApiOrBuilder
        public ByteString getVersionBytes() {
            return ((Api) this.a).getVersionBytes();
        }

        @Override // com.google.protobuf.ApiOrBuilder
        public boolean hasSourceContext() {
            return ((Api) this.a).hasSourceContext();
        }

        public Builder mergeSourceContext(SourceContext sourceContext) {
            a();
            ((Api) this.a).mergeSourceContext(sourceContext);
            return this;
        }

        public Builder removeMethods(int i) {
            a();
            ((Api) this.a).removeMethods(i);
            return this;
        }

        public Builder removeMixins(int i) {
            a();
            ((Api) this.a).removeMixins(i);
            return this;
        }

        public Builder removeOptions(int i) {
            a();
            ((Api) this.a).removeOptions(i);
            return this;
        }

        public Builder setMethods(int i, Method.Builder builder) {
            a();
            ((Api) this.a).setMethods(i, builder);
            return this;
        }

        public Builder setMethods(int i, Method method) {
            a();
            ((Api) this.a).setMethods(i, method);
            return this;
        }

        public Builder setMixins(int i, Mixin.Builder builder) {
            a();
            ((Api) this.a).setMixins(i, builder);
            return this;
        }

        public Builder setMixins(int i, Mixin mixin) {
            a();
            ((Api) this.a).setMixins(i, mixin);
            return this;
        }

        public Builder setName(String str) {
            a();
            ((Api) this.a).setName(str);
            return this;
        }

        public Builder setNameBytes(ByteString byteString) {
            a();
            ((Api) this.a).setNameBytes(byteString);
            return this;
        }

        public Builder setOptions(int i, Option.Builder builder) {
            a();
            ((Api) this.a).setOptions(i, builder);
            return this;
        }

        public Builder setOptions(int i, Option option) {
            a();
            ((Api) this.a).setOptions(i, option);
            return this;
        }

        public Builder setSourceContext(SourceContext.Builder builder) {
            a();
            ((Api) this.a).setSourceContext(builder);
            return this;
        }

        public Builder setSourceContext(SourceContext sourceContext) {
            a();
            ((Api) this.a).setSourceContext(sourceContext);
            return this;
        }

        public Builder setSyntax(Syntax syntax) {
            a();
            ((Api) this.a).setSyntax(syntax);
            return this;
        }

        public Builder setSyntaxValue(int i) {
            a();
            ((Api) this.a).setSyntaxValue(i);
            return this;
        }

        public Builder setVersion(String str) {
            a();
            ((Api) this.a).setVersion(str);
            return this;
        }

        public Builder setVersionBytes(ByteString byteString) {
            a();
            ((Api) this.a).setVersionBytes(byteString);
            return this;
        }
    }

    static {
        DEFAULT_INSTANCE.b();
    }

    private Api() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllMethods(Iterable<? extends Method> iterable) {
        ensureMethodsIsMutable();
        AbstractMessageLite.a(iterable, this.methods_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllMixins(Iterable<? extends Mixin> iterable) {
        ensureMixinsIsMutable();
        AbstractMessageLite.a(iterable, this.mixins_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllOptions(Iterable<? extends Option> iterable) {
        ensureOptionsIsMutable();
        AbstractMessageLite.a(iterable, this.options_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addMethods(int i, Method.Builder builder) {
        ensureMethodsIsMutable();
        this.methods_.add(i, builder.build());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addMethods(int i, Method method) {
        if (method == null) {
            throw new NullPointerException();
        }
        ensureMethodsIsMutable();
        this.methods_.add(i, method);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addMethods(Method.Builder builder) {
        ensureMethodsIsMutable();
        this.methods_.add(builder.build());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addMethods(Method method) {
        if (method == null) {
            throw new NullPointerException();
        }
        ensureMethodsIsMutable();
        this.methods_.add(method);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addMixins(int i, Mixin.Builder builder) {
        ensureMixinsIsMutable();
        this.mixins_.add(i, builder.build());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addMixins(int i, Mixin mixin) {
        if (mixin == null) {
            throw new NullPointerException();
        }
        ensureMixinsIsMutable();
        this.mixins_.add(i, mixin);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addMixins(Mixin.Builder builder) {
        ensureMixinsIsMutable();
        this.mixins_.add(builder.build());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addMixins(Mixin mixin) {
        if (mixin == null) {
            throw new NullPointerException();
        }
        ensureMixinsIsMutable();
        this.mixins_.add(mixin);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addOptions(int i, Option.Builder builder) {
        ensureOptionsIsMutable();
        this.options_.add(i, builder.build());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addOptions(int i, Option option) {
        if (option == null) {
            throw new NullPointerException();
        }
        ensureOptionsIsMutable();
        this.options_.add(i, option);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addOptions(Option.Builder builder) {
        ensureOptionsIsMutable();
        this.options_.add(builder.build());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addOptions(Option option) {
        if (option == null) {
            throw new NullPointerException();
        }
        ensureOptionsIsMutable();
        this.options_.add(option);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearMethods() {
        this.methods_ = GeneratedMessageLite.f();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearMixins() {
        this.mixins_ = GeneratedMessageLite.f();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearName() {
        this.name_ = getDefaultInstance().getName();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearOptions() {
        this.options_ = GeneratedMessageLite.f();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearSourceContext() {
        this.sourceContext_ = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearSyntax() {
        this.syntax_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearVersion() {
        this.version_ = getDefaultInstance().getVersion();
    }

    private void ensureMethodsIsMutable() {
        if (this.methods_.isModifiable()) {
            return;
        }
        this.methods_ = GeneratedMessageLite.a(this.methods_);
    }

    private void ensureMixinsIsMutable() {
        if (this.mixins_.isModifiable()) {
            return;
        }
        this.mixins_ = GeneratedMessageLite.a(this.mixins_);
    }

    private void ensureOptionsIsMutable() {
        if (this.options_.isModifiable()) {
            return;
        }
        this.options_ = GeneratedMessageLite.a(this.options_);
    }

    public static Api getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeSourceContext(SourceContext sourceContext) {
        SourceContext sourceContext2 = this.sourceContext_;
        if (sourceContext2 != null && sourceContext2 != SourceContext.getDefaultInstance()) {
            sourceContext = SourceContext.newBuilder(this.sourceContext_).mergeFrom((SourceContext.Builder) sourceContext).buildPartial();
        }
        this.sourceContext_ = sourceContext;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static Builder newBuilder(Api api) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom((Builder) api);
    }

    public static Api parseDelimitedFrom(InputStream inputStream) {
        return (Api) GeneratedMessageLite.a(DEFAULT_INSTANCE, inputStream);
    }

    public static Api parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Api) GeneratedMessageLite.a(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static Api parseFrom(ByteString byteString) {
        return (Api) GeneratedMessageLite.a(DEFAULT_INSTANCE, byteString);
    }

    public static Api parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (Api) GeneratedMessageLite.a(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static Api parseFrom(CodedInputStream codedInputStream) {
        return (Api) GeneratedMessageLite.a(DEFAULT_INSTANCE, codedInputStream);
    }

    public static Api parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Api) GeneratedMessageLite.a(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }

    public static Api parseFrom(InputStream inputStream) {
        return (Api) GeneratedMessageLite.b(DEFAULT_INSTANCE, inputStream);
    }

    public static Api parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Api) GeneratedMessageLite.b(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static Api parseFrom(byte[] bArr) {
        return (Api) GeneratedMessageLite.a(DEFAULT_INSTANCE, bArr);
    }

    public static Api parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (Api) GeneratedMessageLite.a(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static Parser<Api> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeMethods(int i) {
        ensureMethodsIsMutable();
        this.methods_.remove(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeMixins(int i) {
        ensureMixinsIsMutable();
        this.mixins_.remove(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeOptions(int i) {
        ensureOptionsIsMutable();
        this.options_.remove(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setMethods(int i, Method.Builder builder) {
        ensureMethodsIsMutable();
        this.methods_.set(i, builder.build());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setMethods(int i, Method method) {
        if (method == null) {
            throw new NullPointerException();
        }
        ensureMethodsIsMutable();
        this.methods_.set(i, method);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setMixins(int i, Mixin.Builder builder) {
        ensureMixinsIsMutable();
        this.mixins_.set(i, builder.build());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setMixins(int i, Mixin mixin) {
        if (mixin == null) {
            throw new NullPointerException();
        }
        ensureMixinsIsMutable();
        this.mixins_.set(i, mixin);
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
    public void setOptions(int i, Option.Builder builder) {
        ensureOptionsIsMutable();
        this.options_.set(i, builder.build());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setOptions(int i, Option option) {
        if (option == null) {
            throw new NullPointerException();
        }
        ensureOptionsIsMutable();
        this.options_.set(i, option);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSourceContext(SourceContext.Builder builder) {
        this.sourceContext_ = builder.build();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSourceContext(SourceContext sourceContext) {
        if (sourceContext == null) {
            throw new NullPointerException();
        }
        this.sourceContext_ = sourceContext;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSyntax(Syntax syntax) {
        if (syntax == null) {
            throw new NullPointerException();
        }
        this.syntax_ = syntax.getNumber();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSyntaxValue(int i) {
        this.syntax_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setVersion(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.version_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setVersionBytes(ByteString byteString) {
        if (byteString == null) {
            throw new NullPointerException();
        }
        AbstractMessageLite.a(byteString);
        this.version_ = byteString.toStringUtf8();
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object a(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        List list;
        MessageLite messageLite;
        AnonymousClass1 anonymousClass1 = null;
        switch (AnonymousClass1.a[methodToInvoke.ordinal()]) {
            case 1:
                return new Api();
            case 2:
                return DEFAULT_INSTANCE;
            case 3:
                this.methods_.makeImmutable();
                this.options_.makeImmutable();
                this.mixins_.makeImmutable();
                return null;
            case 4:
                return new Builder(anonymousClass1);
            case 5:
                GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                Api api = (Api) obj2;
                this.name_ = visitor.visitString(!this.name_.isEmpty(), this.name_, !api.name_.isEmpty(), api.name_);
                this.methods_ = visitor.visitList(this.methods_, api.methods_);
                this.options_ = visitor.visitList(this.options_, api.options_);
                this.version_ = visitor.visitString(!this.version_.isEmpty(), this.version_, !api.version_.isEmpty(), api.version_);
                this.sourceContext_ = (SourceContext) visitor.visitMessage(this.sourceContext_, api.sourceContext_);
                this.mixins_ = visitor.visitList(this.mixins_, api.mixins_);
                this.syntax_ = visitor.visitInt(this.syntax_ != 0, this.syntax_, api.syntax_ != 0, api.syntax_);
                if (visitor == GeneratedMessageLite.MergeFromVisitor.INSTANCE) {
                    this.bitField0_ |= api.bitField0_;
                }
                return this;
            case 6:
                CodedInputStream codedInputStream = (CodedInputStream) obj;
                ExtensionRegistryLite extensionRegistryLite = (ExtensionRegistryLite) obj2;
                while (!r0) {
                    try {
                        int readTag = codedInputStream.readTag();
                        if (readTag != 0) {
                            if (readTag != 10) {
                                if (readTag == 18) {
                                    if (!this.methods_.isModifiable()) {
                                        this.methods_ = GeneratedMessageLite.a(this.methods_);
                                    }
                                    list = this.methods_;
                                    messageLite = (Method) codedInputStream.readMessage(Method.parser(), extensionRegistryLite);
                                } else if (readTag == 26) {
                                    if (!this.options_.isModifiable()) {
                                        this.options_ = GeneratedMessageLite.a(this.options_);
                                    }
                                    list = this.options_;
                                    messageLite = (Option) codedInputStream.readMessage(Option.parser(), extensionRegistryLite);
                                } else if (readTag == 34) {
                                    this.version_ = codedInputStream.readStringRequireUtf8();
                                } else if (readTag == 42) {
                                    SourceContext.Builder builder = this.sourceContext_ != null ? this.sourceContext_.toBuilder() : null;
                                    this.sourceContext_ = (SourceContext) codedInputStream.readMessage(SourceContext.parser(), extensionRegistryLite);
                                    if (builder != null) {
                                        builder.mergeFrom((SourceContext.Builder) this.sourceContext_);
                                        this.sourceContext_ = builder.buildPartial();
                                    }
                                } else if (readTag == 50) {
                                    if (!this.mixins_.isModifiable()) {
                                        this.mixins_ = GeneratedMessageLite.a(this.mixins_);
                                    }
                                    list = this.mixins_;
                                    messageLite = (Mixin) codedInputStream.readMessage(Mixin.parser(), extensionRegistryLite);
                                } else if (readTag == 56) {
                                    this.syntax_ = codedInputStream.readEnum();
                                } else if (!codedInputStream.skipField(readTag)) {
                                }
                                list.add(messageLite);
                            } else {
                                this.name_ = codedInputStream.readStringRequireUtf8();
                            }
                        }
                        r0 = true;
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
                    synchronized (Api.class) {
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

    @Override // com.google.protobuf.ApiOrBuilder
    public Method getMethods(int i) {
        return this.methods_.get(i);
    }

    @Override // com.google.protobuf.ApiOrBuilder
    public int getMethodsCount() {
        return this.methods_.size();
    }

    @Override // com.google.protobuf.ApiOrBuilder
    public List<Method> getMethodsList() {
        return this.methods_;
    }

    public MethodOrBuilder getMethodsOrBuilder(int i) {
        return this.methods_.get(i);
    }

    public List<? extends MethodOrBuilder> getMethodsOrBuilderList() {
        return this.methods_;
    }

    @Override // com.google.protobuf.ApiOrBuilder
    public Mixin getMixins(int i) {
        return this.mixins_.get(i);
    }

    @Override // com.google.protobuf.ApiOrBuilder
    public int getMixinsCount() {
        return this.mixins_.size();
    }

    @Override // com.google.protobuf.ApiOrBuilder
    public List<Mixin> getMixinsList() {
        return this.mixins_;
    }

    public MixinOrBuilder getMixinsOrBuilder(int i) {
        return this.mixins_.get(i);
    }

    public List<? extends MixinOrBuilder> getMixinsOrBuilderList() {
        return this.mixins_;
    }

    @Override // com.google.protobuf.ApiOrBuilder
    public String getName() {
        return this.name_;
    }

    @Override // com.google.protobuf.ApiOrBuilder
    public ByteString getNameBytes() {
        return ByteString.copyFromUtf8(this.name_);
    }

    @Override // com.google.protobuf.ApiOrBuilder
    public Option getOptions(int i) {
        return this.options_.get(i);
    }

    @Override // com.google.protobuf.ApiOrBuilder
    public int getOptionsCount() {
        return this.options_.size();
    }

    @Override // com.google.protobuf.ApiOrBuilder
    public List<Option> getOptionsList() {
        return this.options_;
    }

    public OptionOrBuilder getOptionsOrBuilder(int i) {
        return this.options_.get(i);
    }

    public List<? extends OptionOrBuilder> getOptionsOrBuilderList() {
        return this.options_;
    }

    @Override // com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int i = this.c;
        if (i != -1) {
            return i;
        }
        int computeStringSize = !this.name_.isEmpty() ? CodedOutputStream.computeStringSize(1, getName()) + 0 : 0;
        for (int i2 = 0; i2 < this.methods_.size(); i2++) {
            computeStringSize += CodedOutputStream.computeMessageSize(2, this.methods_.get(i2));
        }
        for (int i3 = 0; i3 < this.options_.size(); i3++) {
            computeStringSize += CodedOutputStream.computeMessageSize(3, this.options_.get(i3));
        }
        if (!this.version_.isEmpty()) {
            computeStringSize += CodedOutputStream.computeStringSize(4, getVersion());
        }
        if (this.sourceContext_ != null) {
            computeStringSize += CodedOutputStream.computeMessageSize(5, getSourceContext());
        }
        for (int i4 = 0; i4 < this.mixins_.size(); i4++) {
            computeStringSize += CodedOutputStream.computeMessageSize(6, this.mixins_.get(i4));
        }
        if (this.syntax_ != Syntax.SYNTAX_PROTO2.getNumber()) {
            computeStringSize += CodedOutputStream.computeEnumSize(7, this.syntax_);
        }
        this.c = computeStringSize;
        return computeStringSize;
    }

    @Override // com.google.protobuf.ApiOrBuilder
    public SourceContext getSourceContext() {
        SourceContext sourceContext = this.sourceContext_;
        return sourceContext == null ? SourceContext.getDefaultInstance() : sourceContext;
    }

    @Override // com.google.protobuf.ApiOrBuilder
    public Syntax getSyntax() {
        Syntax forNumber = Syntax.forNumber(this.syntax_);
        return forNumber == null ? Syntax.UNRECOGNIZED : forNumber;
    }

    @Override // com.google.protobuf.ApiOrBuilder
    public int getSyntaxValue() {
        return this.syntax_;
    }

    @Override // com.google.protobuf.ApiOrBuilder
    public String getVersion() {
        return this.version_;
    }

    @Override // com.google.protobuf.ApiOrBuilder
    public ByteString getVersionBytes() {
        return ByteString.copyFromUtf8(this.version_);
    }

    @Override // com.google.protobuf.ApiOrBuilder
    public boolean hasSourceContext() {
        return this.sourceContext_ != null;
    }

    @Override // com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream codedOutputStream) {
        if (!this.name_.isEmpty()) {
            codedOutputStream.writeString(1, getName());
        }
        for (int i = 0; i < this.methods_.size(); i++) {
            codedOutputStream.writeMessage(2, this.methods_.get(i));
        }
        for (int i2 = 0; i2 < this.options_.size(); i2++) {
            codedOutputStream.writeMessage(3, this.options_.get(i2));
        }
        if (!this.version_.isEmpty()) {
            codedOutputStream.writeString(4, getVersion());
        }
        if (this.sourceContext_ != null) {
            codedOutputStream.writeMessage(5, getSourceContext());
        }
        for (int i3 = 0; i3 < this.mixins_.size(); i3++) {
            codedOutputStream.writeMessage(6, this.mixins_.get(i3));
        }
        if (this.syntax_ != Syntax.SYNTAX_PROTO2.getNumber()) {
            codedOutputStream.writeEnum(7, this.syntax_);
        }
    }
}
