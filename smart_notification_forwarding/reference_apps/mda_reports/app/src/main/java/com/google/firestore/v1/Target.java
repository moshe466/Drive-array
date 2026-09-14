package com.google.firestore.v1;

import com.google.firestore.v1.StructuredQuery;
import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.MessageLiteOrBuilder;
import com.google.protobuf.Parser;
import com.google.protobuf.Timestamp;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.List;

/* loaded from: classes2.dex */
public final class Target extends GeneratedMessageLite<Target, Builder> implements TargetOrBuilder {
    private static final Target DEFAULT_INSTANCE = new Target();
    public static final int DOCUMENTS_FIELD_NUMBER = 3;
    public static final int ONCE_FIELD_NUMBER = 6;
    private static volatile Parser<Target> PARSER = null;
    public static final int QUERY_FIELD_NUMBER = 2;
    public static final int READ_TIME_FIELD_NUMBER = 11;
    public static final int RESUME_TOKEN_FIELD_NUMBER = 4;
    public static final int TARGET_ID_FIELD_NUMBER = 5;
    private boolean once_;
    private Object resumeType_;
    private int targetId_;
    private Object targetType_;
    private int targetTypeCase_ = 0;
    private int resumeTypeCase_ = 0;

    /* renamed from: com.google.firestore.v1.Target$1, reason: invalid class name */
    /* loaded from: classes2.dex */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] a;
        static final /* synthetic */ int[] b;
        static final /* synthetic */ int[] c;
        static final /* synthetic */ int[] d = new int[ResumeTypeCase.values().length];

        static {
            try {
                d[ResumeTypeCase.RESUME_TOKEN.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                d[ResumeTypeCase.READ_TIME.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                d[ResumeTypeCase.RESUMETYPE_NOT_SET.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            c = new int[TargetTypeCase.values().length];
            try {
                c[TargetTypeCase.QUERY.ordinal()] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                c[TargetTypeCase.DOCUMENTS.ordinal()] = 2;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                c[TargetTypeCase.TARGETTYPE_NOT_SET.ordinal()] = 3;
            } catch (NoSuchFieldError unused6) {
            }
            b = new int[QueryTarget.QueryTypeCase.values().length];
            try {
                b[QueryTarget.QueryTypeCase.STRUCTURED_QUERY.ordinal()] = 1;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                b[QueryTarget.QueryTypeCase.QUERYTYPE_NOT_SET.ordinal()] = 2;
            } catch (NoSuchFieldError unused8) {
            }
            a = new int[GeneratedMessageLite.MethodToInvoke.values().length];
            try {
                a[GeneratedMessageLite.MethodToInvoke.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                a[GeneratedMessageLite.MethodToInvoke.IS_INITIALIZED.ordinal()] = 2;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                a[GeneratedMessageLite.MethodToInvoke.MAKE_IMMUTABLE.ordinal()] = 3;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                a[GeneratedMessageLite.MethodToInvoke.NEW_BUILDER.ordinal()] = 4;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                a[GeneratedMessageLite.MethodToInvoke.VISIT.ordinal()] = 5;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                a[GeneratedMessageLite.MethodToInvoke.MERGE_FROM_STREAM.ordinal()] = 6;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                a[GeneratedMessageLite.MethodToInvoke.GET_DEFAULT_INSTANCE.ordinal()] = 7;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                a[GeneratedMessageLite.MethodToInvoke.GET_PARSER.ordinal()] = 8;
            } catch (NoSuchFieldError unused16) {
            }
        }
    }

    /* loaded from: classes2.dex */
    public static final class Builder extends GeneratedMessageLite.Builder<Target, Builder> implements TargetOrBuilder {
        private Builder() {
            super(Target.DEFAULT_INSTANCE);
        }

        /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        public Builder clearDocuments() {
            a();
            ((Target) this.a).clearDocuments();
            return this;
        }

        public Builder clearOnce() {
            a();
            ((Target) this.a).clearOnce();
            return this;
        }

        public Builder clearQuery() {
            a();
            ((Target) this.a).clearQuery();
            return this;
        }

        public Builder clearReadTime() {
            a();
            ((Target) this.a).clearReadTime();
            return this;
        }

        public Builder clearResumeToken() {
            a();
            ((Target) this.a).clearResumeToken();
            return this;
        }

        public Builder clearResumeType() {
            a();
            ((Target) this.a).clearResumeType();
            return this;
        }

        public Builder clearTargetId() {
            a();
            ((Target) this.a).clearTargetId();
            return this;
        }

        public Builder clearTargetType() {
            a();
            ((Target) this.a).clearTargetType();
            return this;
        }

        @Override // com.google.firestore.v1.TargetOrBuilder
        public DocumentsTarget getDocuments() {
            return ((Target) this.a).getDocuments();
        }

        @Override // com.google.firestore.v1.TargetOrBuilder
        public boolean getOnce() {
            return ((Target) this.a).getOnce();
        }

        @Override // com.google.firestore.v1.TargetOrBuilder
        public QueryTarget getQuery() {
            return ((Target) this.a).getQuery();
        }

        @Override // com.google.firestore.v1.TargetOrBuilder
        public Timestamp getReadTime() {
            return ((Target) this.a).getReadTime();
        }

        @Override // com.google.firestore.v1.TargetOrBuilder
        public ByteString getResumeToken() {
            return ((Target) this.a).getResumeToken();
        }

        @Override // com.google.firestore.v1.TargetOrBuilder
        public ResumeTypeCase getResumeTypeCase() {
            return ((Target) this.a).getResumeTypeCase();
        }

        @Override // com.google.firestore.v1.TargetOrBuilder
        public int getTargetId() {
            return ((Target) this.a).getTargetId();
        }

        @Override // com.google.firestore.v1.TargetOrBuilder
        public TargetTypeCase getTargetTypeCase() {
            return ((Target) this.a).getTargetTypeCase();
        }

        public Builder mergeDocuments(DocumentsTarget documentsTarget) {
            a();
            ((Target) this.a).mergeDocuments(documentsTarget);
            return this;
        }

        public Builder mergeQuery(QueryTarget queryTarget) {
            a();
            ((Target) this.a).mergeQuery(queryTarget);
            return this;
        }

        public Builder mergeReadTime(Timestamp timestamp) {
            a();
            ((Target) this.a).mergeReadTime(timestamp);
            return this;
        }

        public Builder setDocuments(DocumentsTarget.Builder builder) {
            a();
            ((Target) this.a).setDocuments(builder);
            return this;
        }

        public Builder setDocuments(DocumentsTarget documentsTarget) {
            a();
            ((Target) this.a).setDocuments(documentsTarget);
            return this;
        }

        public Builder setOnce(boolean z) {
            a();
            ((Target) this.a).setOnce(z);
            return this;
        }

        public Builder setQuery(QueryTarget.Builder builder) {
            a();
            ((Target) this.a).setQuery(builder);
            return this;
        }

        public Builder setQuery(QueryTarget queryTarget) {
            a();
            ((Target) this.a).setQuery(queryTarget);
            return this;
        }

        public Builder setReadTime(Timestamp.Builder builder) {
            a();
            ((Target) this.a).setReadTime(builder);
            return this;
        }

        public Builder setReadTime(Timestamp timestamp) {
            a();
            ((Target) this.a).setReadTime(timestamp);
            return this;
        }

        public Builder setResumeToken(ByteString byteString) {
            a();
            ((Target) this.a).setResumeToken(byteString);
            return this;
        }

        public Builder setTargetId(int i) {
            a();
            ((Target) this.a).setTargetId(i);
            return this;
        }
    }

    /* loaded from: classes2.dex */
    public static final class DocumentsTarget extends GeneratedMessageLite<DocumentsTarget, Builder> implements DocumentsTargetOrBuilder {
        private static final DocumentsTarget DEFAULT_INSTANCE = new DocumentsTarget();
        public static final int DOCUMENTS_FIELD_NUMBER = 2;
        private static volatile Parser<DocumentsTarget> PARSER;
        private Internal.ProtobufList<String> documents_ = GeneratedMessageLite.f();

        /* loaded from: classes2.dex */
        public static final class Builder extends GeneratedMessageLite.Builder<DocumentsTarget, Builder> implements DocumentsTargetOrBuilder {
            private Builder() {
                super(DocumentsTarget.DEFAULT_INSTANCE);
            }

            /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            public Builder addAllDocuments(Iterable<String> iterable) {
                a();
                ((DocumentsTarget) this.a).addAllDocuments(iterable);
                return this;
            }

            public Builder addDocuments(String str) {
                a();
                ((DocumentsTarget) this.a).addDocuments(str);
                return this;
            }

            public Builder addDocumentsBytes(ByteString byteString) {
                a();
                ((DocumentsTarget) this.a).addDocumentsBytes(byteString);
                return this;
            }

            public Builder clearDocuments() {
                a();
                ((DocumentsTarget) this.a).clearDocuments();
                return this;
            }

            @Override // com.google.firestore.v1.Target.DocumentsTargetOrBuilder
            public String getDocuments(int i) {
                return ((DocumentsTarget) this.a).getDocuments(i);
            }

            @Override // com.google.firestore.v1.Target.DocumentsTargetOrBuilder
            public ByteString getDocumentsBytes(int i) {
                return ((DocumentsTarget) this.a).getDocumentsBytes(i);
            }

            @Override // com.google.firestore.v1.Target.DocumentsTargetOrBuilder
            public int getDocumentsCount() {
                return ((DocumentsTarget) this.a).getDocumentsCount();
            }

            @Override // com.google.firestore.v1.Target.DocumentsTargetOrBuilder
            public List<String> getDocumentsList() {
                return Collections.unmodifiableList(((DocumentsTarget) this.a).getDocumentsList());
            }

            public Builder setDocuments(int i, String str) {
                a();
                ((DocumentsTarget) this.a).setDocuments(i, str);
                return this;
            }
        }

        static {
            DEFAULT_INSTANCE.b();
        }

        private DocumentsTarget() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addAllDocuments(Iterable<String> iterable) {
            ensureDocumentsIsMutable();
            AbstractMessageLite.a(iterable, this.documents_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addDocuments(String str) {
            if (str == null) {
                throw new NullPointerException();
            }
            ensureDocumentsIsMutable();
            this.documents_.add(str);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addDocumentsBytes(ByteString byteString) {
            if (byteString == null) {
                throw new NullPointerException();
            }
            AbstractMessageLite.a(byteString);
            ensureDocumentsIsMutable();
            this.documents_.add(byteString.toStringUtf8());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearDocuments() {
            this.documents_ = GeneratedMessageLite.f();
        }

        private void ensureDocumentsIsMutable() {
            if (this.documents_.isModifiable()) {
                return;
            }
            this.documents_ = GeneratedMessageLite.a(this.documents_);
        }

        public static DocumentsTarget getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(DocumentsTarget documentsTarget) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom((Builder) documentsTarget);
        }

        public static DocumentsTarget parseDelimitedFrom(InputStream inputStream) {
            return (DocumentsTarget) GeneratedMessageLite.a(DEFAULT_INSTANCE, inputStream);
        }

        public static DocumentsTarget parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (DocumentsTarget) GeneratedMessageLite.a(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static DocumentsTarget parseFrom(ByteString byteString) {
            return (DocumentsTarget) GeneratedMessageLite.a(DEFAULT_INSTANCE, byteString);
        }

        public static DocumentsTarget parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
            return (DocumentsTarget) GeneratedMessageLite.a(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static DocumentsTarget parseFrom(CodedInputStream codedInputStream) {
            return (DocumentsTarget) GeneratedMessageLite.a(DEFAULT_INSTANCE, codedInputStream);
        }

        public static DocumentsTarget parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (DocumentsTarget) GeneratedMessageLite.a(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        public static DocumentsTarget parseFrom(InputStream inputStream) {
            return (DocumentsTarget) GeneratedMessageLite.b(DEFAULT_INSTANCE, inputStream);
        }

        public static DocumentsTarget parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (DocumentsTarget) GeneratedMessageLite.b(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static DocumentsTarget parseFrom(byte[] bArr) {
            return (DocumentsTarget) GeneratedMessageLite.a(DEFAULT_INSTANCE, bArr);
        }

        public static DocumentsTarget parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
            return (DocumentsTarget) GeneratedMessageLite.a(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static Parser<DocumentsTarget> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setDocuments(int i, String str) {
            if (str == null) {
                throw new NullPointerException();
            }
            ensureDocumentsIsMutable();
            this.documents_.set(i, str);
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        protected final Object a(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            AnonymousClass1 anonymousClass1 = null;
            switch (AnonymousClass1.a[methodToInvoke.ordinal()]) {
                case 1:
                    return new DocumentsTarget();
                case 2:
                    return DEFAULT_INSTANCE;
                case 3:
                    this.documents_.makeImmutable();
                    return null;
                case 4:
                    return new Builder(anonymousClass1);
                case 5:
                    this.documents_ = ((GeneratedMessageLite.Visitor) obj).visitList(this.documents_, ((DocumentsTarget) obj2).documents_);
                    GeneratedMessageLite.MergeFromVisitor mergeFromVisitor = GeneratedMessageLite.MergeFromVisitor.INSTANCE;
                    return this;
                case 6:
                    CodedInputStream codedInputStream = (CodedInputStream) obj;
                    boolean z = false;
                    while (!z) {
                        try {
                            try {
                                int readTag = codedInputStream.readTag();
                                if (readTag != 0) {
                                    if (readTag == 18) {
                                        String readStringRequireUtf8 = codedInputStream.readStringRequireUtf8();
                                        if (!this.documents_.isModifiable()) {
                                            this.documents_ = GeneratedMessageLite.a(this.documents_);
                                        }
                                        this.documents_.add(readStringRequireUtf8);
                                    } else if (!codedInputStream.skipField(readTag)) {
                                    }
                                }
                                z = true;
                            } catch (IOException e) {
                                throw new RuntimeException(new InvalidProtocolBufferException(e.getMessage()).setUnfinishedMessage(this));
                            }
                        } catch (InvalidProtocolBufferException e2) {
                            throw new RuntimeException(e2.setUnfinishedMessage(this));
                        }
                    }
                    break;
                case 7:
                    break;
                case 8:
                    if (PARSER == null) {
                        synchronized (DocumentsTarget.class) {
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

        @Override // com.google.firestore.v1.Target.DocumentsTargetOrBuilder
        public String getDocuments(int i) {
            return this.documents_.get(i);
        }

        @Override // com.google.firestore.v1.Target.DocumentsTargetOrBuilder
        public ByteString getDocumentsBytes(int i) {
            return ByteString.copyFromUtf8(this.documents_.get(i));
        }

        @Override // com.google.firestore.v1.Target.DocumentsTargetOrBuilder
        public int getDocumentsCount() {
            return this.documents_.size();
        }

        @Override // com.google.firestore.v1.Target.DocumentsTargetOrBuilder
        public List<String> getDocumentsList() {
            return this.documents_;
        }

        @Override // com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i = this.c;
            if (i != -1) {
                return i;
            }
            int i2 = 0;
            for (int i3 = 0; i3 < this.documents_.size(); i3++) {
                i2 += CodedOutputStream.computeStringSizeNoTag(this.documents_.get(i3));
            }
            int size = 0 + i2 + (getDocumentsList().size() * 1);
            this.c = size;
            return size;
        }

        @Override // com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) {
            for (int i = 0; i < this.documents_.size(); i++) {
                codedOutputStream.writeString(2, this.documents_.get(i));
            }
        }
    }

    /* loaded from: classes2.dex */
    public interface DocumentsTargetOrBuilder extends MessageLiteOrBuilder {
        String getDocuments(int i);

        ByteString getDocumentsBytes(int i);

        int getDocumentsCount();

        List<String> getDocumentsList();
    }

    /* loaded from: classes2.dex */
    public static final class QueryTarget extends GeneratedMessageLite<QueryTarget, Builder> implements QueryTargetOrBuilder {
        private static final QueryTarget DEFAULT_INSTANCE = new QueryTarget();
        public static final int PARENT_FIELD_NUMBER = 1;
        private static volatile Parser<QueryTarget> PARSER = null;
        public static final int STRUCTURED_QUERY_FIELD_NUMBER = 2;
        private Object queryType_;
        private int queryTypeCase_ = 0;
        private String parent_ = "";

        /* loaded from: classes2.dex */
        public static final class Builder extends GeneratedMessageLite.Builder<QueryTarget, Builder> implements QueryTargetOrBuilder {
            private Builder() {
                super(QueryTarget.DEFAULT_INSTANCE);
            }

            /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            public Builder clearParent() {
                a();
                ((QueryTarget) this.a).clearParent();
                return this;
            }

            public Builder clearQueryType() {
                a();
                ((QueryTarget) this.a).clearQueryType();
                return this;
            }

            public Builder clearStructuredQuery() {
                a();
                ((QueryTarget) this.a).clearStructuredQuery();
                return this;
            }

            @Override // com.google.firestore.v1.Target.QueryTargetOrBuilder
            public String getParent() {
                return ((QueryTarget) this.a).getParent();
            }

            @Override // com.google.firestore.v1.Target.QueryTargetOrBuilder
            public ByteString getParentBytes() {
                return ((QueryTarget) this.a).getParentBytes();
            }

            @Override // com.google.firestore.v1.Target.QueryTargetOrBuilder
            public QueryTypeCase getQueryTypeCase() {
                return ((QueryTarget) this.a).getQueryTypeCase();
            }

            @Override // com.google.firestore.v1.Target.QueryTargetOrBuilder
            public StructuredQuery getStructuredQuery() {
                return ((QueryTarget) this.a).getStructuredQuery();
            }

            public Builder mergeStructuredQuery(StructuredQuery structuredQuery) {
                a();
                ((QueryTarget) this.a).mergeStructuredQuery(structuredQuery);
                return this;
            }

            public Builder setParent(String str) {
                a();
                ((QueryTarget) this.a).setParent(str);
                return this;
            }

            public Builder setParentBytes(ByteString byteString) {
                a();
                ((QueryTarget) this.a).setParentBytes(byteString);
                return this;
            }

            public Builder setStructuredQuery(StructuredQuery.Builder builder) {
                a();
                ((QueryTarget) this.a).setStructuredQuery(builder);
                return this;
            }

            public Builder setStructuredQuery(StructuredQuery structuredQuery) {
                a();
                ((QueryTarget) this.a).setStructuredQuery(structuredQuery);
                return this;
            }
        }

        /* loaded from: classes2.dex */
        public enum QueryTypeCase implements Internal.EnumLite {
            STRUCTURED_QUERY(2),
            QUERYTYPE_NOT_SET(0);

            private final int value;

            QueryTypeCase(int i) {
                this.value = i;
            }

            public static QueryTypeCase forNumber(int i) {
                if (i == 0) {
                    return QUERYTYPE_NOT_SET;
                }
                if (i != 2) {
                    return null;
                }
                return STRUCTURED_QUERY;
            }

            @Deprecated
            public static QueryTypeCase valueOf(int i) {
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

        private QueryTarget() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearParent() {
            this.parent_ = getDefaultInstance().getParent();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearQueryType() {
            this.queryTypeCase_ = 0;
            this.queryType_ = null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearStructuredQuery() {
            if (this.queryTypeCase_ == 2) {
                this.queryTypeCase_ = 0;
                this.queryType_ = null;
            }
        }

        public static QueryTarget getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void mergeStructuredQuery(StructuredQuery structuredQuery) {
            if (this.queryTypeCase_ == 2 && this.queryType_ != StructuredQuery.getDefaultInstance()) {
                structuredQuery = StructuredQuery.newBuilder((StructuredQuery) this.queryType_).mergeFrom((StructuredQuery.Builder) structuredQuery).buildPartial();
            }
            this.queryType_ = structuredQuery;
            this.queryTypeCase_ = 2;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(QueryTarget queryTarget) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom((Builder) queryTarget);
        }

        public static QueryTarget parseDelimitedFrom(InputStream inputStream) {
            return (QueryTarget) GeneratedMessageLite.a(DEFAULT_INSTANCE, inputStream);
        }

        public static QueryTarget parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (QueryTarget) GeneratedMessageLite.a(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static QueryTarget parseFrom(ByteString byteString) {
            return (QueryTarget) GeneratedMessageLite.a(DEFAULT_INSTANCE, byteString);
        }

        public static QueryTarget parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
            return (QueryTarget) GeneratedMessageLite.a(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static QueryTarget parseFrom(CodedInputStream codedInputStream) {
            return (QueryTarget) GeneratedMessageLite.a(DEFAULT_INSTANCE, codedInputStream);
        }

        public static QueryTarget parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (QueryTarget) GeneratedMessageLite.a(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        public static QueryTarget parseFrom(InputStream inputStream) {
            return (QueryTarget) GeneratedMessageLite.b(DEFAULT_INSTANCE, inputStream);
        }

        public static QueryTarget parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (QueryTarget) GeneratedMessageLite.b(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static QueryTarget parseFrom(byte[] bArr) {
            return (QueryTarget) GeneratedMessageLite.a(DEFAULT_INSTANCE, bArr);
        }

        public static QueryTarget parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
            return (QueryTarget) GeneratedMessageLite.a(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static Parser<QueryTarget> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setParent(String str) {
            if (str == null) {
                throw new NullPointerException();
            }
            this.parent_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setParentBytes(ByteString byteString) {
            if (byteString == null) {
                throw new NullPointerException();
            }
            AbstractMessageLite.a(byteString);
            this.parent_ = byteString.toStringUtf8();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setStructuredQuery(StructuredQuery.Builder builder) {
            this.queryType_ = builder.build();
            this.queryTypeCase_ = 2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setStructuredQuery(StructuredQuery structuredQuery) {
            if (structuredQuery == null) {
                throw new NullPointerException();
            }
            this.queryType_ = structuredQuery;
            this.queryTypeCase_ = 2;
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        protected final Object a(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            int i;
            AnonymousClass1 anonymousClass1 = null;
            switch (AnonymousClass1.a[methodToInvoke.ordinal()]) {
                case 1:
                    return new QueryTarget();
                case 2:
                    return DEFAULT_INSTANCE;
                case 3:
                    return null;
                case 4:
                    return new Builder(anonymousClass1);
                case 5:
                    GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                    QueryTarget queryTarget = (QueryTarget) obj2;
                    this.parent_ = visitor.visitString(!this.parent_.isEmpty(), this.parent_, !queryTarget.parent_.isEmpty(), queryTarget.parent_);
                    int i2 = AnonymousClass1.b[queryTarget.getQueryTypeCase().ordinal()];
                    if (i2 == 1) {
                        this.queryType_ = visitor.visitOneofMessage(this.queryTypeCase_ == 2, this.queryType_, queryTarget.queryType_);
                    } else if (i2 == 2) {
                        visitor.visitOneofNotSet(this.queryTypeCase_ != 0);
                    }
                    if (visitor == GeneratedMessageLite.MergeFromVisitor.INSTANCE && (i = queryTarget.queryTypeCase_) != 0) {
                        this.queryTypeCase_ = i;
                    }
                    return this;
                case 6:
                    CodedInputStream codedInputStream = (CodedInputStream) obj;
                    ExtensionRegistryLite extensionRegistryLite = (ExtensionRegistryLite) obj2;
                    while (!r0) {
                        try {
                            try {
                                int readTag = codedInputStream.readTag();
                                if (readTag != 0) {
                                    if (readTag == 10) {
                                        this.parent_ = codedInputStream.readStringRequireUtf8();
                                    } else if (readTag == 18) {
                                        StructuredQuery.Builder builder = this.queryTypeCase_ == 2 ? ((StructuredQuery) this.queryType_).toBuilder() : null;
                                        this.queryType_ = codedInputStream.readMessage(StructuredQuery.parser(), extensionRegistryLite);
                                        if (builder != null) {
                                            builder.mergeFrom((StructuredQuery.Builder) this.queryType_);
                                            this.queryType_ = builder.buildPartial();
                                        }
                                        this.queryTypeCase_ = 2;
                                    } else if (!codedInputStream.skipField(readTag)) {
                                    }
                                }
                                r0 = true;
                            } catch (InvalidProtocolBufferException e) {
                                throw new RuntimeException(e.setUnfinishedMessage(this));
                            }
                        } catch (IOException e2) {
                            throw new RuntimeException(new InvalidProtocolBufferException(e2.getMessage()).setUnfinishedMessage(this));
                        }
                    }
                    break;
                case 7:
                    break;
                case 8:
                    if (PARSER == null) {
                        synchronized (QueryTarget.class) {
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

        @Override // com.google.firestore.v1.Target.QueryTargetOrBuilder
        public String getParent() {
            return this.parent_;
        }

        @Override // com.google.firestore.v1.Target.QueryTargetOrBuilder
        public ByteString getParentBytes() {
            return ByteString.copyFromUtf8(this.parent_);
        }

        @Override // com.google.firestore.v1.Target.QueryTargetOrBuilder
        public QueryTypeCase getQueryTypeCase() {
            return QueryTypeCase.forNumber(this.queryTypeCase_);
        }

        @Override // com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i = this.c;
            if (i != -1) {
                return i;
            }
            int computeStringSize = this.parent_.isEmpty() ? 0 : 0 + CodedOutputStream.computeStringSize(1, getParent());
            if (this.queryTypeCase_ == 2) {
                computeStringSize += CodedOutputStream.computeMessageSize(2, (StructuredQuery) this.queryType_);
            }
            this.c = computeStringSize;
            return computeStringSize;
        }

        @Override // com.google.firestore.v1.Target.QueryTargetOrBuilder
        public StructuredQuery getStructuredQuery() {
            return this.queryTypeCase_ == 2 ? (StructuredQuery) this.queryType_ : StructuredQuery.getDefaultInstance();
        }

        @Override // com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) {
            if (!this.parent_.isEmpty()) {
                codedOutputStream.writeString(1, getParent());
            }
            if (this.queryTypeCase_ == 2) {
                codedOutputStream.writeMessage(2, (StructuredQuery) this.queryType_);
            }
        }
    }

    /* loaded from: classes2.dex */
    public interface QueryTargetOrBuilder extends MessageLiteOrBuilder {
        String getParent();

        ByteString getParentBytes();

        QueryTarget.QueryTypeCase getQueryTypeCase();

        StructuredQuery getStructuredQuery();
    }

    /* loaded from: classes2.dex */
    public enum ResumeTypeCase implements Internal.EnumLite {
        RESUME_TOKEN(4),
        READ_TIME(11),
        RESUMETYPE_NOT_SET(0);

        private final int value;

        ResumeTypeCase(int i) {
            this.value = i;
        }

        public static ResumeTypeCase forNumber(int i) {
            if (i == 0) {
                return RESUMETYPE_NOT_SET;
            }
            if (i == 4) {
                return RESUME_TOKEN;
            }
            if (i != 11) {
                return null;
            }
            return READ_TIME;
        }

        @Deprecated
        public static ResumeTypeCase valueOf(int i) {
            return forNumber(i);
        }

        @Override // com.google.protobuf.Internal.EnumLite
        public int getNumber() {
            return this.value;
        }
    }

    /* loaded from: classes2.dex */
    public enum TargetTypeCase implements Internal.EnumLite {
        QUERY(2),
        DOCUMENTS(3),
        TARGETTYPE_NOT_SET(0);

        private final int value;

        TargetTypeCase(int i) {
            this.value = i;
        }

        public static TargetTypeCase forNumber(int i) {
            if (i == 0) {
                return TARGETTYPE_NOT_SET;
            }
            if (i == 2) {
                return QUERY;
            }
            if (i != 3) {
                return null;
            }
            return DOCUMENTS;
        }

        @Deprecated
        public static TargetTypeCase valueOf(int i) {
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

    private Target() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearDocuments() {
        if (this.targetTypeCase_ == 3) {
            this.targetTypeCase_ = 0;
            this.targetType_ = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearOnce() {
        this.once_ = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearQuery() {
        if (this.targetTypeCase_ == 2) {
            this.targetTypeCase_ = 0;
            this.targetType_ = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearReadTime() {
        if (this.resumeTypeCase_ == 11) {
            this.resumeTypeCase_ = 0;
            this.resumeType_ = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearResumeToken() {
        if (this.resumeTypeCase_ == 4) {
            this.resumeTypeCase_ = 0;
            this.resumeType_ = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearResumeType() {
        this.resumeTypeCase_ = 0;
        this.resumeType_ = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearTargetId() {
        this.targetId_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearTargetType() {
        this.targetTypeCase_ = 0;
        this.targetType_ = null;
    }

    public static Target getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeDocuments(DocumentsTarget documentsTarget) {
        if (this.targetTypeCase_ == 3 && this.targetType_ != DocumentsTarget.getDefaultInstance()) {
            documentsTarget = DocumentsTarget.newBuilder((DocumentsTarget) this.targetType_).mergeFrom((DocumentsTarget.Builder) documentsTarget).buildPartial();
        }
        this.targetType_ = documentsTarget;
        this.targetTypeCase_ = 3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeQuery(QueryTarget queryTarget) {
        if (this.targetTypeCase_ == 2 && this.targetType_ != QueryTarget.getDefaultInstance()) {
            queryTarget = QueryTarget.newBuilder((QueryTarget) this.targetType_).mergeFrom((QueryTarget.Builder) queryTarget).buildPartial();
        }
        this.targetType_ = queryTarget;
        this.targetTypeCase_ = 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeReadTime(Timestamp timestamp) {
        if (this.resumeTypeCase_ == 11 && this.resumeType_ != Timestamp.getDefaultInstance()) {
            timestamp = Timestamp.newBuilder((Timestamp) this.resumeType_).mergeFrom((Timestamp.Builder) timestamp).buildPartial();
        }
        this.resumeType_ = timestamp;
        this.resumeTypeCase_ = 11;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static Builder newBuilder(Target target) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom((Builder) target);
    }

    public static Target parseDelimitedFrom(InputStream inputStream) {
        return (Target) GeneratedMessageLite.a(DEFAULT_INSTANCE, inputStream);
    }

    public static Target parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Target) GeneratedMessageLite.a(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static Target parseFrom(ByteString byteString) {
        return (Target) GeneratedMessageLite.a(DEFAULT_INSTANCE, byteString);
    }

    public static Target parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (Target) GeneratedMessageLite.a(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static Target parseFrom(CodedInputStream codedInputStream) {
        return (Target) GeneratedMessageLite.a(DEFAULT_INSTANCE, codedInputStream);
    }

    public static Target parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Target) GeneratedMessageLite.a(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }

    public static Target parseFrom(InputStream inputStream) {
        return (Target) GeneratedMessageLite.b(DEFAULT_INSTANCE, inputStream);
    }

    public static Target parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Target) GeneratedMessageLite.b(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static Target parseFrom(byte[] bArr) {
        return (Target) GeneratedMessageLite.a(DEFAULT_INSTANCE, bArr);
    }

    public static Target parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (Target) GeneratedMessageLite.a(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static Parser<Target> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDocuments(DocumentsTarget.Builder builder) {
        this.targetType_ = builder.build();
        this.targetTypeCase_ = 3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDocuments(DocumentsTarget documentsTarget) {
        if (documentsTarget == null) {
            throw new NullPointerException();
        }
        this.targetType_ = documentsTarget;
        this.targetTypeCase_ = 3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setOnce(boolean z) {
        this.once_ = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setQuery(QueryTarget.Builder builder) {
        this.targetType_ = builder.build();
        this.targetTypeCase_ = 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setQuery(QueryTarget queryTarget) {
        if (queryTarget == null) {
            throw new NullPointerException();
        }
        this.targetType_ = queryTarget;
        this.targetTypeCase_ = 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setReadTime(Timestamp.Builder builder) {
        this.resumeType_ = builder.build();
        this.resumeTypeCase_ = 11;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setReadTime(Timestamp timestamp) {
        if (timestamp == null) {
            throw new NullPointerException();
        }
        this.resumeType_ = timestamp;
        this.resumeTypeCase_ = 11;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setResumeToken(ByteString byteString) {
        if (byteString == null) {
            throw new NullPointerException();
        }
        this.resumeTypeCase_ = 4;
        this.resumeType_ = byteString;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTargetId(int i) {
        this.targetId_ = i;
    }

    /* JADX WARN: Code restructure failed: missing block: B:147:0x016c, code lost:
    
        if (r9.targetTypeCase_ == 3) goto L102;
     */
    /* JADX WARN: Code restructure failed: missing block: B:148:0x0175, code lost:
    
        r10 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:150:0x0173, code lost:
    
        r10 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:152:0x0171, code lost:
    
        if (r9.targetTypeCase_ == 2) goto L102;
     */
    /* JADX WARN: Removed duplicated region for block: B:122:0x018e  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x01bd  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x01aa  */
    @Override // com.google.protobuf.GeneratedMessageLite
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected final java.lang.Object a(com.google.protobuf.GeneratedMessageLite.MethodToInvoke r10, java.lang.Object r11, java.lang.Object r12) {
        /*
            Method dump skipped, instructions count: 494
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firestore.v1.Target.a(com.google.protobuf.GeneratedMessageLite$MethodToInvoke, java.lang.Object, java.lang.Object):java.lang.Object");
    }

    @Override // com.google.firestore.v1.TargetOrBuilder
    public DocumentsTarget getDocuments() {
        return this.targetTypeCase_ == 3 ? (DocumentsTarget) this.targetType_ : DocumentsTarget.getDefaultInstance();
    }

    @Override // com.google.firestore.v1.TargetOrBuilder
    public boolean getOnce() {
        return this.once_;
    }

    @Override // com.google.firestore.v1.TargetOrBuilder
    public QueryTarget getQuery() {
        return this.targetTypeCase_ == 2 ? (QueryTarget) this.targetType_ : QueryTarget.getDefaultInstance();
    }

    @Override // com.google.firestore.v1.TargetOrBuilder
    public Timestamp getReadTime() {
        return this.resumeTypeCase_ == 11 ? (Timestamp) this.resumeType_ : Timestamp.getDefaultInstance();
    }

    @Override // com.google.firestore.v1.TargetOrBuilder
    public ByteString getResumeToken() {
        return this.resumeTypeCase_ == 4 ? (ByteString) this.resumeType_ : ByteString.EMPTY;
    }

    @Override // com.google.firestore.v1.TargetOrBuilder
    public ResumeTypeCase getResumeTypeCase() {
        return ResumeTypeCase.forNumber(this.resumeTypeCase_);
    }

    @Override // com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int i = this.c;
        if (i != -1) {
            return i;
        }
        int computeMessageSize = this.targetTypeCase_ == 2 ? 0 + CodedOutputStream.computeMessageSize(2, (QueryTarget) this.targetType_) : 0;
        if (this.targetTypeCase_ == 3) {
            computeMessageSize += CodedOutputStream.computeMessageSize(3, (DocumentsTarget) this.targetType_);
        }
        if (this.resumeTypeCase_ == 4) {
            computeMessageSize += CodedOutputStream.computeBytesSize(4, (ByteString) this.resumeType_);
        }
        int i2 = this.targetId_;
        if (i2 != 0) {
            computeMessageSize += CodedOutputStream.computeInt32Size(5, i2);
        }
        boolean z = this.once_;
        if (z) {
            computeMessageSize += CodedOutputStream.computeBoolSize(6, z);
        }
        if (this.resumeTypeCase_ == 11) {
            computeMessageSize += CodedOutputStream.computeMessageSize(11, (Timestamp) this.resumeType_);
        }
        this.c = computeMessageSize;
        return computeMessageSize;
    }

    @Override // com.google.firestore.v1.TargetOrBuilder
    public int getTargetId() {
        return this.targetId_;
    }

    @Override // com.google.firestore.v1.TargetOrBuilder
    public TargetTypeCase getTargetTypeCase() {
        return TargetTypeCase.forNumber(this.targetTypeCase_);
    }

    @Override // com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream codedOutputStream) {
        if (this.targetTypeCase_ == 2) {
            codedOutputStream.writeMessage(2, (QueryTarget) this.targetType_);
        }
        if (this.targetTypeCase_ == 3) {
            codedOutputStream.writeMessage(3, (DocumentsTarget) this.targetType_);
        }
        if (this.resumeTypeCase_ == 4) {
            codedOutputStream.writeBytes(4, (ByteString) this.resumeType_);
        }
        int i = this.targetId_;
        if (i != 0) {
            codedOutputStream.writeInt32(5, i);
        }
        boolean z = this.once_;
        if (z) {
            codedOutputStream.writeBool(6, z);
        }
        if (this.resumeTypeCase_ == 11) {
            codedOutputStream.writeMessage(11, (Timestamp) this.resumeType_);
        }
    }
}
