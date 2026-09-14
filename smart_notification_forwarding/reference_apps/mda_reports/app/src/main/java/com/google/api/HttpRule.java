package com.google.api;

import com.google.api.CustomHttpPattern;
import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import com.google.protobuf.Parser;
import java.io.InputStream;
import java.util.Collections;
import java.util.List;

/* loaded from: classes2.dex */
public final class HttpRule extends GeneratedMessageLite<HttpRule, Builder> implements HttpRuleOrBuilder {
    public static final int ADDITIONAL_BINDINGS_FIELD_NUMBER = 11;
    public static final int BODY_FIELD_NUMBER = 7;
    public static final int CUSTOM_FIELD_NUMBER = 8;
    private static final HttpRule DEFAULT_INSTANCE = new HttpRule();
    public static final int DELETE_FIELD_NUMBER = 5;
    public static final int GET_FIELD_NUMBER = 2;
    private static volatile Parser<HttpRule> PARSER = null;
    public static final int PATCH_FIELD_NUMBER = 6;
    public static final int POST_FIELD_NUMBER = 4;
    public static final int PUT_FIELD_NUMBER = 3;
    public static final int SELECTOR_FIELD_NUMBER = 1;
    private int bitField0_;
    private Object pattern_;
    private int patternCase_ = 0;
    private String selector_ = "";
    private String body_ = "";
    private Internal.ProtobufList<HttpRule> additionalBindings_ = GeneratedMessageLite.f();

    /* renamed from: com.google.api.HttpRule$1, reason: invalid class name */
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
            a = new int[PatternCase.values().length];
            try {
                a[PatternCase.GET.ordinal()] = 1;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                a[PatternCase.PUT.ordinal()] = 2;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                a[PatternCase.POST.ordinal()] = 3;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                a[PatternCase.DELETE.ordinal()] = 4;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                a[PatternCase.PATCH.ordinal()] = 5;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                a[PatternCase.CUSTOM.ordinal()] = 6;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                a[PatternCase.PATTERN_NOT_SET.ordinal()] = 7;
            } catch (NoSuchFieldError unused15) {
            }
        }
    }

    /* loaded from: classes2.dex */
    public static final class Builder extends GeneratedMessageLite.Builder<HttpRule, Builder> implements HttpRuleOrBuilder {
        private Builder() {
            super(HttpRule.DEFAULT_INSTANCE);
        }

        /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        public Builder addAdditionalBindings(int i, Builder builder) {
            a();
            ((HttpRule) this.a).addAdditionalBindings(i, builder);
            return this;
        }

        public Builder addAdditionalBindings(int i, HttpRule httpRule) {
            a();
            ((HttpRule) this.a).addAdditionalBindings(i, httpRule);
            return this;
        }

        public Builder addAdditionalBindings(Builder builder) {
            a();
            ((HttpRule) this.a).addAdditionalBindings(builder);
            return this;
        }

        public Builder addAdditionalBindings(HttpRule httpRule) {
            a();
            ((HttpRule) this.a).addAdditionalBindings(httpRule);
            return this;
        }

        public Builder addAllAdditionalBindings(Iterable<? extends HttpRule> iterable) {
            a();
            ((HttpRule) this.a).addAllAdditionalBindings(iterable);
            return this;
        }

        public Builder clearAdditionalBindings() {
            a();
            ((HttpRule) this.a).clearAdditionalBindings();
            return this;
        }

        public Builder clearBody() {
            a();
            ((HttpRule) this.a).clearBody();
            return this;
        }

        public Builder clearCustom() {
            a();
            ((HttpRule) this.a).clearCustom();
            return this;
        }

        public Builder clearDelete() {
            a();
            ((HttpRule) this.a).clearDelete();
            return this;
        }

        public Builder clearGet() {
            a();
            ((HttpRule) this.a).clearGet();
            return this;
        }

        public Builder clearPatch() {
            a();
            ((HttpRule) this.a).clearPatch();
            return this;
        }

        public Builder clearPattern() {
            a();
            ((HttpRule) this.a).clearPattern();
            return this;
        }

        public Builder clearPost() {
            a();
            ((HttpRule) this.a).clearPost();
            return this;
        }

        public Builder clearPut() {
            a();
            ((HttpRule) this.a).clearPut();
            return this;
        }

        public Builder clearSelector() {
            a();
            ((HttpRule) this.a).clearSelector();
            return this;
        }

        @Override // com.google.api.HttpRuleOrBuilder
        public HttpRule getAdditionalBindings(int i) {
            return ((HttpRule) this.a).getAdditionalBindings(i);
        }

        @Override // com.google.api.HttpRuleOrBuilder
        public int getAdditionalBindingsCount() {
            return ((HttpRule) this.a).getAdditionalBindingsCount();
        }

        @Override // com.google.api.HttpRuleOrBuilder
        public List<HttpRule> getAdditionalBindingsList() {
            return Collections.unmodifiableList(((HttpRule) this.a).getAdditionalBindingsList());
        }

        @Override // com.google.api.HttpRuleOrBuilder
        public String getBody() {
            return ((HttpRule) this.a).getBody();
        }

        @Override // com.google.api.HttpRuleOrBuilder
        public ByteString getBodyBytes() {
            return ((HttpRule) this.a).getBodyBytes();
        }

        @Override // com.google.api.HttpRuleOrBuilder
        public CustomHttpPattern getCustom() {
            return ((HttpRule) this.a).getCustom();
        }

        @Override // com.google.api.HttpRuleOrBuilder
        public String getDelete() {
            return ((HttpRule) this.a).getDelete();
        }

        @Override // com.google.api.HttpRuleOrBuilder
        public ByteString getDeleteBytes() {
            return ((HttpRule) this.a).getDeleteBytes();
        }

        @Override // com.google.api.HttpRuleOrBuilder
        public String getGet() {
            return ((HttpRule) this.a).getGet();
        }

        @Override // com.google.api.HttpRuleOrBuilder
        public ByteString getGetBytes() {
            return ((HttpRule) this.a).getGetBytes();
        }

        @Override // com.google.api.HttpRuleOrBuilder
        public String getPatch() {
            return ((HttpRule) this.a).getPatch();
        }

        @Override // com.google.api.HttpRuleOrBuilder
        public ByteString getPatchBytes() {
            return ((HttpRule) this.a).getPatchBytes();
        }

        @Override // com.google.api.HttpRuleOrBuilder
        public PatternCase getPatternCase() {
            return ((HttpRule) this.a).getPatternCase();
        }

        @Override // com.google.api.HttpRuleOrBuilder
        public String getPost() {
            return ((HttpRule) this.a).getPost();
        }

        @Override // com.google.api.HttpRuleOrBuilder
        public ByteString getPostBytes() {
            return ((HttpRule) this.a).getPostBytes();
        }

        @Override // com.google.api.HttpRuleOrBuilder
        public String getPut() {
            return ((HttpRule) this.a).getPut();
        }

        @Override // com.google.api.HttpRuleOrBuilder
        public ByteString getPutBytes() {
            return ((HttpRule) this.a).getPutBytes();
        }

        @Override // com.google.api.HttpRuleOrBuilder
        public String getSelector() {
            return ((HttpRule) this.a).getSelector();
        }

        @Override // com.google.api.HttpRuleOrBuilder
        public ByteString getSelectorBytes() {
            return ((HttpRule) this.a).getSelectorBytes();
        }

        public Builder mergeCustom(CustomHttpPattern customHttpPattern) {
            a();
            ((HttpRule) this.a).mergeCustom(customHttpPattern);
            return this;
        }

        public Builder removeAdditionalBindings(int i) {
            a();
            ((HttpRule) this.a).removeAdditionalBindings(i);
            return this;
        }

        public Builder setAdditionalBindings(int i, Builder builder) {
            a();
            ((HttpRule) this.a).setAdditionalBindings(i, builder);
            return this;
        }

        public Builder setAdditionalBindings(int i, HttpRule httpRule) {
            a();
            ((HttpRule) this.a).setAdditionalBindings(i, httpRule);
            return this;
        }

        public Builder setBody(String str) {
            a();
            ((HttpRule) this.a).setBody(str);
            return this;
        }

        public Builder setBodyBytes(ByteString byteString) {
            a();
            ((HttpRule) this.a).setBodyBytes(byteString);
            return this;
        }

        public Builder setCustom(CustomHttpPattern.Builder builder) {
            a();
            ((HttpRule) this.a).setCustom(builder);
            return this;
        }

        public Builder setCustom(CustomHttpPattern customHttpPattern) {
            a();
            ((HttpRule) this.a).setCustom(customHttpPattern);
            return this;
        }

        public Builder setDelete(String str) {
            a();
            ((HttpRule) this.a).setDelete(str);
            return this;
        }

        public Builder setDeleteBytes(ByteString byteString) {
            a();
            ((HttpRule) this.a).setDeleteBytes(byteString);
            return this;
        }

        public Builder setGet(String str) {
            a();
            ((HttpRule) this.a).setGet(str);
            return this;
        }

        public Builder setGetBytes(ByteString byteString) {
            a();
            ((HttpRule) this.a).setGetBytes(byteString);
            return this;
        }

        public Builder setPatch(String str) {
            a();
            ((HttpRule) this.a).setPatch(str);
            return this;
        }

        public Builder setPatchBytes(ByteString byteString) {
            a();
            ((HttpRule) this.a).setPatchBytes(byteString);
            return this;
        }

        public Builder setPost(String str) {
            a();
            ((HttpRule) this.a).setPost(str);
            return this;
        }

        public Builder setPostBytes(ByteString byteString) {
            a();
            ((HttpRule) this.a).setPostBytes(byteString);
            return this;
        }

        public Builder setPut(String str) {
            a();
            ((HttpRule) this.a).setPut(str);
            return this;
        }

        public Builder setPutBytes(ByteString byteString) {
            a();
            ((HttpRule) this.a).setPutBytes(byteString);
            return this;
        }

        public Builder setSelector(String str) {
            a();
            ((HttpRule) this.a).setSelector(str);
            return this;
        }

        public Builder setSelectorBytes(ByteString byteString) {
            a();
            ((HttpRule) this.a).setSelectorBytes(byteString);
            return this;
        }
    }

    /* loaded from: classes2.dex */
    public enum PatternCase implements Internal.EnumLite {
        GET(2),
        PUT(3),
        POST(4),
        DELETE(5),
        PATCH(6),
        CUSTOM(8),
        PATTERN_NOT_SET(0);

        private final int value;

        PatternCase(int i) {
            this.value = i;
        }

        public static PatternCase forNumber(int i) {
            if (i == 0) {
                return PATTERN_NOT_SET;
            }
            if (i == 8) {
                return CUSTOM;
            }
            if (i == 2) {
                return GET;
            }
            if (i == 3) {
                return PUT;
            }
            if (i == 4) {
                return POST;
            }
            if (i == 5) {
                return DELETE;
            }
            if (i != 6) {
                return null;
            }
            return PATCH;
        }

        @Deprecated
        public static PatternCase valueOf(int i) {
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

    private HttpRule() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAdditionalBindings(int i, Builder builder) {
        ensureAdditionalBindingsIsMutable();
        this.additionalBindings_.add(i, builder.build());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAdditionalBindings(int i, HttpRule httpRule) {
        if (httpRule == null) {
            throw new NullPointerException();
        }
        ensureAdditionalBindingsIsMutable();
        this.additionalBindings_.add(i, httpRule);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAdditionalBindings(Builder builder) {
        ensureAdditionalBindingsIsMutable();
        this.additionalBindings_.add(builder.build());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAdditionalBindings(HttpRule httpRule) {
        if (httpRule == null) {
            throw new NullPointerException();
        }
        ensureAdditionalBindingsIsMutable();
        this.additionalBindings_.add(httpRule);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllAdditionalBindings(Iterable<? extends HttpRule> iterable) {
        ensureAdditionalBindingsIsMutable();
        AbstractMessageLite.a(iterable, this.additionalBindings_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearAdditionalBindings() {
        this.additionalBindings_ = GeneratedMessageLite.f();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearBody() {
        this.body_ = getDefaultInstance().getBody();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearCustom() {
        if (this.patternCase_ == 8) {
            this.patternCase_ = 0;
            this.pattern_ = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearDelete() {
        if (this.patternCase_ == 5) {
            this.patternCase_ = 0;
            this.pattern_ = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearGet() {
        if (this.patternCase_ == 2) {
            this.patternCase_ = 0;
            this.pattern_ = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearPatch() {
        if (this.patternCase_ == 6) {
            this.patternCase_ = 0;
            this.pattern_ = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearPattern() {
        this.patternCase_ = 0;
        this.pattern_ = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearPost() {
        if (this.patternCase_ == 4) {
            this.patternCase_ = 0;
            this.pattern_ = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearPut() {
        if (this.patternCase_ == 3) {
            this.patternCase_ = 0;
            this.pattern_ = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearSelector() {
        this.selector_ = getDefaultInstance().getSelector();
    }

    private void ensureAdditionalBindingsIsMutable() {
        if (this.additionalBindings_.isModifiable()) {
            return;
        }
        this.additionalBindings_ = GeneratedMessageLite.a(this.additionalBindings_);
    }

    public static HttpRule getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeCustom(CustomHttpPattern customHttpPattern) {
        if (this.patternCase_ == 8 && this.pattern_ != CustomHttpPattern.getDefaultInstance()) {
            customHttpPattern = CustomHttpPattern.newBuilder((CustomHttpPattern) this.pattern_).mergeFrom((CustomHttpPattern.Builder) customHttpPattern).buildPartial();
        }
        this.pattern_ = customHttpPattern;
        this.patternCase_ = 8;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static Builder newBuilder(HttpRule httpRule) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom((Builder) httpRule);
    }

    public static HttpRule parseDelimitedFrom(InputStream inputStream) {
        return (HttpRule) GeneratedMessageLite.a(DEFAULT_INSTANCE, inputStream);
    }

    public static HttpRule parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (HttpRule) GeneratedMessageLite.a(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static HttpRule parseFrom(ByteString byteString) {
        return (HttpRule) GeneratedMessageLite.a(DEFAULT_INSTANCE, byteString);
    }

    public static HttpRule parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (HttpRule) GeneratedMessageLite.a(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static HttpRule parseFrom(CodedInputStream codedInputStream) {
        return (HttpRule) GeneratedMessageLite.a(DEFAULT_INSTANCE, codedInputStream);
    }

    public static HttpRule parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (HttpRule) GeneratedMessageLite.a(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }

    public static HttpRule parseFrom(InputStream inputStream) {
        return (HttpRule) GeneratedMessageLite.b(DEFAULT_INSTANCE, inputStream);
    }

    public static HttpRule parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (HttpRule) GeneratedMessageLite.b(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static HttpRule parseFrom(byte[] bArr) {
        return (HttpRule) GeneratedMessageLite.a(DEFAULT_INSTANCE, bArr);
    }

    public static HttpRule parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (HttpRule) GeneratedMessageLite.a(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static Parser<HttpRule> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeAdditionalBindings(int i) {
        ensureAdditionalBindingsIsMutable();
        this.additionalBindings_.remove(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setAdditionalBindings(int i, Builder builder) {
        ensureAdditionalBindingsIsMutable();
        this.additionalBindings_.set(i, builder.build());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setAdditionalBindings(int i, HttpRule httpRule) {
        if (httpRule == null) {
            throw new NullPointerException();
        }
        ensureAdditionalBindingsIsMutable();
        this.additionalBindings_.set(i, httpRule);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setBody(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.body_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setBodyBytes(ByteString byteString) {
        if (byteString == null) {
            throw new NullPointerException();
        }
        AbstractMessageLite.a(byteString);
        this.body_ = byteString.toStringUtf8();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCustom(CustomHttpPattern.Builder builder) {
        this.pattern_ = builder.build();
        this.patternCase_ = 8;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCustom(CustomHttpPattern customHttpPattern) {
        if (customHttpPattern == null) {
            throw new NullPointerException();
        }
        this.pattern_ = customHttpPattern;
        this.patternCase_ = 8;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDelete(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.patternCase_ = 5;
        this.pattern_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDeleteBytes(ByteString byteString) {
        if (byteString == null) {
            throw new NullPointerException();
        }
        AbstractMessageLite.a(byteString);
        this.patternCase_ = 5;
        this.pattern_ = byteString.toStringUtf8();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setGet(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.patternCase_ = 2;
        this.pattern_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setGetBytes(ByteString byteString) {
        if (byteString == null) {
            throw new NullPointerException();
        }
        AbstractMessageLite.a(byteString);
        this.patternCase_ = 2;
        this.pattern_ = byteString.toStringUtf8();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setPatch(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.patternCase_ = 6;
        this.pattern_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setPatchBytes(ByteString byteString) {
        if (byteString == null) {
            throw new NullPointerException();
        }
        AbstractMessageLite.a(byteString);
        this.patternCase_ = 6;
        this.pattern_ = byteString.toStringUtf8();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setPost(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.patternCase_ = 4;
        this.pattern_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setPostBytes(ByteString byteString) {
        if (byteString == null) {
            throw new NullPointerException();
        }
        AbstractMessageLite.a(byteString);
        this.patternCase_ = 4;
        this.pattern_ = byteString.toStringUtf8();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setPut(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.patternCase_ = 3;
        this.pattern_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setPutBytes(ByteString byteString) {
        if (byteString == null) {
            throw new NullPointerException();
        }
        AbstractMessageLite.a(byteString);
        this.patternCase_ = 3;
        this.pattern_ = byteString.toStringUtf8();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSelector(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.selector_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSelectorBytes(ByteString byteString) {
        if (byteString == null) {
            throw new NullPointerException();
        }
        AbstractMessageLite.a(byteString);
        this.selector_ = byteString.toStringUtf8();
    }

    /* JADX WARN: Code restructure failed: missing block: B:117:0x0180, code lost:
    
        if (r11.patternCase_ == 6) goto L103;
     */
    /* JADX WARN: Code restructure failed: missing block: B:118:0x0197, code lost:
    
        r12 = r13.visitOneofString(r7, r11.pattern_, r14.pattern_);
     */
    /* JADX WARN: Code restructure failed: missing block: B:119:0x0196, code lost:
    
        r7 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:121:0x0185, code lost:
    
        if (r11.patternCase_ == 5) goto L103;
     */
    /* JADX WARN: Code restructure failed: missing block: B:123:0x018a, code lost:
    
        if (r11.patternCase_ == 4) goto L103;
     */
    /* JADX WARN: Code restructure failed: missing block: B:125:0x018f, code lost:
    
        if (r11.patternCase_ == 3) goto L103;
     */
    /* JADX WARN: Code restructure failed: missing block: B:127:0x0194, code lost:
    
        if (r11.patternCase_ == 2) goto L103;
     */
    @Override // com.google.protobuf.GeneratedMessageLite
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected final java.lang.Object a(com.google.protobuf.GeneratedMessageLite.MethodToInvoke r12, java.lang.Object r13, java.lang.Object r14) {
        /*
            Method dump skipped, instructions count: 494
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.api.HttpRule.a(com.google.protobuf.GeneratedMessageLite$MethodToInvoke, java.lang.Object, java.lang.Object):java.lang.Object");
    }

    @Override // com.google.api.HttpRuleOrBuilder
    public HttpRule getAdditionalBindings(int i) {
        return this.additionalBindings_.get(i);
    }

    @Override // com.google.api.HttpRuleOrBuilder
    public int getAdditionalBindingsCount() {
        return this.additionalBindings_.size();
    }

    @Override // com.google.api.HttpRuleOrBuilder
    public List<HttpRule> getAdditionalBindingsList() {
        return this.additionalBindings_;
    }

    public HttpRuleOrBuilder getAdditionalBindingsOrBuilder(int i) {
        return this.additionalBindings_.get(i);
    }

    public List<? extends HttpRuleOrBuilder> getAdditionalBindingsOrBuilderList() {
        return this.additionalBindings_;
    }

    @Override // com.google.api.HttpRuleOrBuilder
    public String getBody() {
        return this.body_;
    }

    @Override // com.google.api.HttpRuleOrBuilder
    public ByteString getBodyBytes() {
        return ByteString.copyFromUtf8(this.body_);
    }

    @Override // com.google.api.HttpRuleOrBuilder
    public CustomHttpPattern getCustom() {
        return this.patternCase_ == 8 ? (CustomHttpPattern) this.pattern_ : CustomHttpPattern.getDefaultInstance();
    }

    @Override // com.google.api.HttpRuleOrBuilder
    public String getDelete() {
        return this.patternCase_ == 5 ? (String) this.pattern_ : "";
    }

    @Override // com.google.api.HttpRuleOrBuilder
    public ByteString getDeleteBytes() {
        return ByteString.copyFromUtf8(this.patternCase_ == 5 ? (String) this.pattern_ : "");
    }

    @Override // com.google.api.HttpRuleOrBuilder
    public String getGet() {
        return this.patternCase_ == 2 ? (String) this.pattern_ : "";
    }

    @Override // com.google.api.HttpRuleOrBuilder
    public ByteString getGetBytes() {
        return ByteString.copyFromUtf8(this.patternCase_ == 2 ? (String) this.pattern_ : "");
    }

    @Override // com.google.api.HttpRuleOrBuilder
    public String getPatch() {
        return this.patternCase_ == 6 ? (String) this.pattern_ : "";
    }

    @Override // com.google.api.HttpRuleOrBuilder
    public ByteString getPatchBytes() {
        return ByteString.copyFromUtf8(this.patternCase_ == 6 ? (String) this.pattern_ : "");
    }

    @Override // com.google.api.HttpRuleOrBuilder
    public PatternCase getPatternCase() {
        return PatternCase.forNumber(this.patternCase_);
    }

    @Override // com.google.api.HttpRuleOrBuilder
    public String getPost() {
        return this.patternCase_ == 4 ? (String) this.pattern_ : "";
    }

    @Override // com.google.api.HttpRuleOrBuilder
    public ByteString getPostBytes() {
        return ByteString.copyFromUtf8(this.patternCase_ == 4 ? (String) this.pattern_ : "");
    }

    @Override // com.google.api.HttpRuleOrBuilder
    public String getPut() {
        return this.patternCase_ == 3 ? (String) this.pattern_ : "";
    }

    @Override // com.google.api.HttpRuleOrBuilder
    public ByteString getPutBytes() {
        return ByteString.copyFromUtf8(this.patternCase_ == 3 ? (String) this.pattern_ : "");
    }

    @Override // com.google.api.HttpRuleOrBuilder
    public String getSelector() {
        return this.selector_;
    }

    @Override // com.google.api.HttpRuleOrBuilder
    public ByteString getSelectorBytes() {
        return ByteString.copyFromUtf8(this.selector_);
    }

    @Override // com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int i = this.c;
        if (i != -1) {
            return i;
        }
        int computeStringSize = !this.selector_.isEmpty() ? CodedOutputStream.computeStringSize(1, getSelector()) + 0 : 0;
        if (this.patternCase_ == 2) {
            computeStringSize += CodedOutputStream.computeStringSize(2, getGet());
        }
        if (this.patternCase_ == 3) {
            computeStringSize += CodedOutputStream.computeStringSize(3, getPut());
        }
        if (this.patternCase_ == 4) {
            computeStringSize += CodedOutputStream.computeStringSize(4, getPost());
        }
        if (this.patternCase_ == 5) {
            computeStringSize += CodedOutputStream.computeStringSize(5, getDelete());
        }
        if (this.patternCase_ == 6) {
            computeStringSize += CodedOutputStream.computeStringSize(6, getPatch());
        }
        if (!this.body_.isEmpty()) {
            computeStringSize += CodedOutputStream.computeStringSize(7, getBody());
        }
        if (this.patternCase_ == 8) {
            computeStringSize += CodedOutputStream.computeMessageSize(8, (CustomHttpPattern) this.pattern_);
        }
        for (int i2 = 0; i2 < this.additionalBindings_.size(); i2++) {
            computeStringSize += CodedOutputStream.computeMessageSize(11, this.additionalBindings_.get(i2));
        }
        this.c = computeStringSize;
        return computeStringSize;
    }

    @Override // com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream codedOutputStream) {
        if (!this.selector_.isEmpty()) {
            codedOutputStream.writeString(1, getSelector());
        }
        if (this.patternCase_ == 2) {
            codedOutputStream.writeString(2, getGet());
        }
        if (this.patternCase_ == 3) {
            codedOutputStream.writeString(3, getPut());
        }
        if (this.patternCase_ == 4) {
            codedOutputStream.writeString(4, getPost());
        }
        if (this.patternCase_ == 5) {
            codedOutputStream.writeString(5, getDelete());
        }
        if (this.patternCase_ == 6) {
            codedOutputStream.writeString(6, getPatch());
        }
        if (!this.body_.isEmpty()) {
            codedOutputStream.writeString(7, getBody());
        }
        if (this.patternCase_ == 8) {
            codedOutputStream.writeMessage(8, (CustomHttpPattern) this.pattern_);
        }
        for (int i = 0; i < this.additionalBindings_.size(); i++) {
            codedOutputStream.writeMessage(11, this.additionalBindings_.get(i));
        }
    }
}
