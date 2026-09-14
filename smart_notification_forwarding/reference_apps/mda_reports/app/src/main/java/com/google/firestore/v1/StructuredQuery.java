package com.google.firestore.v1;

import com.google.firestore.v1.Cursor;
import com.google.firestore.v1.Value;
import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Int32Value;
import com.google.protobuf.Internal;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.MessageLite;
import com.google.protobuf.MessageLiteOrBuilder;
import com.google.protobuf.Parser;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.List;

/* loaded from: classes2.dex */
public final class StructuredQuery extends GeneratedMessageLite<StructuredQuery, Builder> implements StructuredQueryOrBuilder {
    private static final StructuredQuery DEFAULT_INSTANCE = new StructuredQuery();
    public static final int END_AT_FIELD_NUMBER = 8;
    public static final int FROM_FIELD_NUMBER = 2;
    public static final int LIMIT_FIELD_NUMBER = 5;
    public static final int OFFSET_FIELD_NUMBER = 6;
    public static final int ORDER_BY_FIELD_NUMBER = 4;
    private static volatile Parser<StructuredQuery> PARSER = null;
    public static final int SELECT_FIELD_NUMBER = 1;
    public static final int START_AT_FIELD_NUMBER = 7;
    public static final int WHERE_FIELD_NUMBER = 3;
    private int bitField0_;
    private Cursor endAt_;
    private Int32Value limit_;
    private int offset_;
    private Projection select_;
    private Cursor startAt_;
    private Filter where_;
    private Internal.ProtobufList<CollectionSelector> from_ = GeneratedMessageLite.f();
    private Internal.ProtobufList<Order> orderBy_ = GeneratedMessageLite.f();

    /* renamed from: com.google.firestore.v1.StructuredQuery$1, reason: invalid class name */
    /* loaded from: classes2.dex */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] a;
        static final /* synthetic */ int[] b;
        static final /* synthetic */ int[] c = new int[UnaryFilter.OperandTypeCase.values().length];

        static {
            try {
                c[UnaryFilter.OperandTypeCase.FIELD.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                c[UnaryFilter.OperandTypeCase.OPERANDTYPE_NOT_SET.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            b = new int[Filter.FilterTypeCase.values().length];
            try {
                b[Filter.FilterTypeCase.COMPOSITE_FILTER.ordinal()] = 1;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                b[Filter.FilterTypeCase.FIELD_FILTER.ordinal()] = 2;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                b[Filter.FilterTypeCase.UNARY_FILTER.ordinal()] = 3;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                b[Filter.FilterTypeCase.FILTERTYPE_NOT_SET.ordinal()] = 4;
            } catch (NoSuchFieldError unused6) {
            }
            a = new int[GeneratedMessageLite.MethodToInvoke.values().length];
            try {
                a[GeneratedMessageLite.MethodToInvoke.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                a[GeneratedMessageLite.MethodToInvoke.IS_INITIALIZED.ordinal()] = 2;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                a[GeneratedMessageLite.MethodToInvoke.MAKE_IMMUTABLE.ordinal()] = 3;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                a[GeneratedMessageLite.MethodToInvoke.NEW_BUILDER.ordinal()] = 4;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                a[GeneratedMessageLite.MethodToInvoke.VISIT.ordinal()] = 5;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                a[GeneratedMessageLite.MethodToInvoke.MERGE_FROM_STREAM.ordinal()] = 6;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                a[GeneratedMessageLite.MethodToInvoke.GET_DEFAULT_INSTANCE.ordinal()] = 7;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                a[GeneratedMessageLite.MethodToInvoke.GET_PARSER.ordinal()] = 8;
            } catch (NoSuchFieldError unused14) {
            }
        }
    }

    /* loaded from: classes2.dex */
    public static final class Builder extends GeneratedMessageLite.Builder<StructuredQuery, Builder> implements StructuredQueryOrBuilder {
        private Builder() {
            super(StructuredQuery.DEFAULT_INSTANCE);
        }

        /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        public Builder addAllFrom(Iterable<? extends CollectionSelector> iterable) {
            a();
            ((StructuredQuery) this.a).addAllFrom(iterable);
            return this;
        }

        public Builder addAllOrderBy(Iterable<? extends Order> iterable) {
            a();
            ((StructuredQuery) this.a).addAllOrderBy(iterable);
            return this;
        }

        public Builder addFrom(int i, CollectionSelector.Builder builder) {
            a();
            ((StructuredQuery) this.a).addFrom(i, builder);
            return this;
        }

        public Builder addFrom(int i, CollectionSelector collectionSelector) {
            a();
            ((StructuredQuery) this.a).addFrom(i, collectionSelector);
            return this;
        }

        public Builder addFrom(CollectionSelector.Builder builder) {
            a();
            ((StructuredQuery) this.a).addFrom(builder);
            return this;
        }

        public Builder addFrom(CollectionSelector collectionSelector) {
            a();
            ((StructuredQuery) this.a).addFrom(collectionSelector);
            return this;
        }

        public Builder addOrderBy(int i, Order.Builder builder) {
            a();
            ((StructuredQuery) this.a).addOrderBy(i, builder);
            return this;
        }

        public Builder addOrderBy(int i, Order order) {
            a();
            ((StructuredQuery) this.a).addOrderBy(i, order);
            return this;
        }

        public Builder addOrderBy(Order.Builder builder) {
            a();
            ((StructuredQuery) this.a).addOrderBy(builder);
            return this;
        }

        public Builder addOrderBy(Order order) {
            a();
            ((StructuredQuery) this.a).addOrderBy(order);
            return this;
        }

        public Builder clearEndAt() {
            a();
            ((StructuredQuery) this.a).clearEndAt();
            return this;
        }

        public Builder clearFrom() {
            a();
            ((StructuredQuery) this.a).clearFrom();
            return this;
        }

        public Builder clearLimit() {
            a();
            ((StructuredQuery) this.a).clearLimit();
            return this;
        }

        public Builder clearOffset() {
            a();
            ((StructuredQuery) this.a).clearOffset();
            return this;
        }

        public Builder clearOrderBy() {
            a();
            ((StructuredQuery) this.a).clearOrderBy();
            return this;
        }

        public Builder clearSelect() {
            a();
            ((StructuredQuery) this.a).clearSelect();
            return this;
        }

        public Builder clearStartAt() {
            a();
            ((StructuredQuery) this.a).clearStartAt();
            return this;
        }

        public Builder clearWhere() {
            a();
            ((StructuredQuery) this.a).clearWhere();
            return this;
        }

        @Override // com.google.firestore.v1.StructuredQueryOrBuilder
        public Cursor getEndAt() {
            return ((StructuredQuery) this.a).getEndAt();
        }

        @Override // com.google.firestore.v1.StructuredQueryOrBuilder
        public CollectionSelector getFrom(int i) {
            return ((StructuredQuery) this.a).getFrom(i);
        }

        @Override // com.google.firestore.v1.StructuredQueryOrBuilder
        public int getFromCount() {
            return ((StructuredQuery) this.a).getFromCount();
        }

        @Override // com.google.firestore.v1.StructuredQueryOrBuilder
        public List<CollectionSelector> getFromList() {
            return Collections.unmodifiableList(((StructuredQuery) this.a).getFromList());
        }

        @Override // com.google.firestore.v1.StructuredQueryOrBuilder
        public Int32Value getLimit() {
            return ((StructuredQuery) this.a).getLimit();
        }

        @Override // com.google.firestore.v1.StructuredQueryOrBuilder
        public int getOffset() {
            return ((StructuredQuery) this.a).getOffset();
        }

        @Override // com.google.firestore.v1.StructuredQueryOrBuilder
        public Order getOrderBy(int i) {
            return ((StructuredQuery) this.a).getOrderBy(i);
        }

        @Override // com.google.firestore.v1.StructuredQueryOrBuilder
        public int getOrderByCount() {
            return ((StructuredQuery) this.a).getOrderByCount();
        }

        @Override // com.google.firestore.v1.StructuredQueryOrBuilder
        public List<Order> getOrderByList() {
            return Collections.unmodifiableList(((StructuredQuery) this.a).getOrderByList());
        }

        @Override // com.google.firestore.v1.StructuredQueryOrBuilder
        public Projection getSelect() {
            return ((StructuredQuery) this.a).getSelect();
        }

        @Override // com.google.firestore.v1.StructuredQueryOrBuilder
        public Cursor getStartAt() {
            return ((StructuredQuery) this.a).getStartAt();
        }

        @Override // com.google.firestore.v1.StructuredQueryOrBuilder
        public Filter getWhere() {
            return ((StructuredQuery) this.a).getWhere();
        }

        @Override // com.google.firestore.v1.StructuredQueryOrBuilder
        public boolean hasEndAt() {
            return ((StructuredQuery) this.a).hasEndAt();
        }

        @Override // com.google.firestore.v1.StructuredQueryOrBuilder
        public boolean hasLimit() {
            return ((StructuredQuery) this.a).hasLimit();
        }

        @Override // com.google.firestore.v1.StructuredQueryOrBuilder
        public boolean hasSelect() {
            return ((StructuredQuery) this.a).hasSelect();
        }

        @Override // com.google.firestore.v1.StructuredQueryOrBuilder
        public boolean hasStartAt() {
            return ((StructuredQuery) this.a).hasStartAt();
        }

        @Override // com.google.firestore.v1.StructuredQueryOrBuilder
        public boolean hasWhere() {
            return ((StructuredQuery) this.a).hasWhere();
        }

        public Builder mergeEndAt(Cursor cursor) {
            a();
            ((StructuredQuery) this.a).mergeEndAt(cursor);
            return this;
        }

        public Builder mergeLimit(Int32Value int32Value) {
            a();
            ((StructuredQuery) this.a).mergeLimit(int32Value);
            return this;
        }

        public Builder mergeSelect(Projection projection) {
            a();
            ((StructuredQuery) this.a).mergeSelect(projection);
            return this;
        }

        public Builder mergeStartAt(Cursor cursor) {
            a();
            ((StructuredQuery) this.a).mergeStartAt(cursor);
            return this;
        }

        public Builder mergeWhere(Filter filter) {
            a();
            ((StructuredQuery) this.a).mergeWhere(filter);
            return this;
        }

        public Builder removeFrom(int i) {
            a();
            ((StructuredQuery) this.a).removeFrom(i);
            return this;
        }

        public Builder removeOrderBy(int i) {
            a();
            ((StructuredQuery) this.a).removeOrderBy(i);
            return this;
        }

        public Builder setEndAt(Cursor.Builder builder) {
            a();
            ((StructuredQuery) this.a).setEndAt(builder);
            return this;
        }

        public Builder setEndAt(Cursor cursor) {
            a();
            ((StructuredQuery) this.a).setEndAt(cursor);
            return this;
        }

        public Builder setFrom(int i, CollectionSelector.Builder builder) {
            a();
            ((StructuredQuery) this.a).setFrom(i, builder);
            return this;
        }

        public Builder setFrom(int i, CollectionSelector collectionSelector) {
            a();
            ((StructuredQuery) this.a).setFrom(i, collectionSelector);
            return this;
        }

        public Builder setLimit(Int32Value.Builder builder) {
            a();
            ((StructuredQuery) this.a).setLimit(builder);
            return this;
        }

        public Builder setLimit(Int32Value int32Value) {
            a();
            ((StructuredQuery) this.a).setLimit(int32Value);
            return this;
        }

        public Builder setOffset(int i) {
            a();
            ((StructuredQuery) this.a).setOffset(i);
            return this;
        }

        public Builder setOrderBy(int i, Order.Builder builder) {
            a();
            ((StructuredQuery) this.a).setOrderBy(i, builder);
            return this;
        }

        public Builder setOrderBy(int i, Order order) {
            a();
            ((StructuredQuery) this.a).setOrderBy(i, order);
            return this;
        }

        public Builder setSelect(Projection.Builder builder) {
            a();
            ((StructuredQuery) this.a).setSelect(builder);
            return this;
        }

        public Builder setSelect(Projection projection) {
            a();
            ((StructuredQuery) this.a).setSelect(projection);
            return this;
        }

        public Builder setStartAt(Cursor.Builder builder) {
            a();
            ((StructuredQuery) this.a).setStartAt(builder);
            return this;
        }

        public Builder setStartAt(Cursor cursor) {
            a();
            ((StructuredQuery) this.a).setStartAt(cursor);
            return this;
        }

        public Builder setWhere(Filter.Builder builder) {
            a();
            ((StructuredQuery) this.a).setWhere(builder);
            return this;
        }

        public Builder setWhere(Filter filter) {
            a();
            ((StructuredQuery) this.a).setWhere(filter);
            return this;
        }
    }

    /* loaded from: classes2.dex */
    public static final class CollectionSelector extends GeneratedMessageLite<CollectionSelector, Builder> implements CollectionSelectorOrBuilder {
        public static final int ALL_DESCENDANTS_FIELD_NUMBER = 3;
        public static final int COLLECTION_ID_FIELD_NUMBER = 2;
        private static final CollectionSelector DEFAULT_INSTANCE = new CollectionSelector();
        private static volatile Parser<CollectionSelector> PARSER;
        private boolean allDescendants_;
        private String collectionId_ = "";

        /* loaded from: classes2.dex */
        public static final class Builder extends GeneratedMessageLite.Builder<CollectionSelector, Builder> implements CollectionSelectorOrBuilder {
            private Builder() {
                super(CollectionSelector.DEFAULT_INSTANCE);
            }

            /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            public Builder clearAllDescendants() {
                a();
                ((CollectionSelector) this.a).clearAllDescendants();
                return this;
            }

            public Builder clearCollectionId() {
                a();
                ((CollectionSelector) this.a).clearCollectionId();
                return this;
            }

            @Override // com.google.firestore.v1.StructuredQuery.CollectionSelectorOrBuilder
            public boolean getAllDescendants() {
                return ((CollectionSelector) this.a).getAllDescendants();
            }

            @Override // com.google.firestore.v1.StructuredQuery.CollectionSelectorOrBuilder
            public String getCollectionId() {
                return ((CollectionSelector) this.a).getCollectionId();
            }

            @Override // com.google.firestore.v1.StructuredQuery.CollectionSelectorOrBuilder
            public ByteString getCollectionIdBytes() {
                return ((CollectionSelector) this.a).getCollectionIdBytes();
            }

            public Builder setAllDescendants(boolean z) {
                a();
                ((CollectionSelector) this.a).setAllDescendants(z);
                return this;
            }

            public Builder setCollectionId(String str) {
                a();
                ((CollectionSelector) this.a).setCollectionId(str);
                return this;
            }

            public Builder setCollectionIdBytes(ByteString byteString) {
                a();
                ((CollectionSelector) this.a).setCollectionIdBytes(byteString);
                return this;
            }
        }

        static {
            DEFAULT_INSTANCE.b();
        }

        private CollectionSelector() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearAllDescendants() {
            this.allDescendants_ = false;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearCollectionId() {
            this.collectionId_ = getDefaultInstance().getCollectionId();
        }

        public static CollectionSelector getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(CollectionSelector collectionSelector) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom((Builder) collectionSelector);
        }

        public static CollectionSelector parseDelimitedFrom(InputStream inputStream) {
            return (CollectionSelector) GeneratedMessageLite.a(DEFAULT_INSTANCE, inputStream);
        }

        public static CollectionSelector parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (CollectionSelector) GeneratedMessageLite.a(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static CollectionSelector parseFrom(ByteString byteString) {
            return (CollectionSelector) GeneratedMessageLite.a(DEFAULT_INSTANCE, byteString);
        }

        public static CollectionSelector parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
            return (CollectionSelector) GeneratedMessageLite.a(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static CollectionSelector parseFrom(CodedInputStream codedInputStream) {
            return (CollectionSelector) GeneratedMessageLite.a(DEFAULT_INSTANCE, codedInputStream);
        }

        public static CollectionSelector parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (CollectionSelector) GeneratedMessageLite.a(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        public static CollectionSelector parseFrom(InputStream inputStream) {
            return (CollectionSelector) GeneratedMessageLite.b(DEFAULT_INSTANCE, inputStream);
        }

        public static CollectionSelector parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (CollectionSelector) GeneratedMessageLite.b(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static CollectionSelector parseFrom(byte[] bArr) {
            return (CollectionSelector) GeneratedMessageLite.a(DEFAULT_INSTANCE, bArr);
        }

        public static CollectionSelector parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
            return (CollectionSelector) GeneratedMessageLite.a(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static Parser<CollectionSelector> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setAllDescendants(boolean z) {
            this.allDescendants_ = z;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setCollectionId(String str) {
            if (str == null) {
                throw new NullPointerException();
            }
            this.collectionId_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setCollectionIdBytes(ByteString byteString) {
            if (byteString == null) {
                throw new NullPointerException();
            }
            AbstractMessageLite.a(byteString);
            this.collectionId_ = byteString.toStringUtf8();
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        protected final Object a(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            AnonymousClass1 anonymousClass1 = null;
            switch (AnonymousClass1.a[methodToInvoke.ordinal()]) {
                case 1:
                    return new CollectionSelector();
                case 2:
                    return DEFAULT_INSTANCE;
                case 3:
                    return null;
                case 4:
                    return new Builder(anonymousClass1);
                case 5:
                    GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                    CollectionSelector collectionSelector = (CollectionSelector) obj2;
                    this.collectionId_ = visitor.visitString(!this.collectionId_.isEmpty(), this.collectionId_, true ^ collectionSelector.collectionId_.isEmpty(), collectionSelector.collectionId_);
                    boolean z = this.allDescendants_;
                    boolean z2 = collectionSelector.allDescendants_;
                    this.allDescendants_ = visitor.visitBoolean(z, z, z2, z2);
                    GeneratedMessageLite.MergeFromVisitor mergeFromVisitor = GeneratedMessageLite.MergeFromVisitor.INSTANCE;
                    return this;
                case 6:
                    CodedInputStream codedInputStream = (CodedInputStream) obj;
                    boolean z3 = false;
                    while (!z3) {
                        try {
                            int readTag = codedInputStream.readTag();
                            if (readTag != 0) {
                                if (readTag == 18) {
                                    this.collectionId_ = codedInputStream.readStringRequireUtf8();
                                } else if (readTag == 24) {
                                    this.allDescendants_ = codedInputStream.readBool();
                                } else if (!codedInputStream.skipField(readTag)) {
                                }
                            }
                            z3 = true;
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
                        synchronized (CollectionSelector.class) {
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

        @Override // com.google.firestore.v1.StructuredQuery.CollectionSelectorOrBuilder
        public boolean getAllDescendants() {
            return this.allDescendants_;
        }

        @Override // com.google.firestore.v1.StructuredQuery.CollectionSelectorOrBuilder
        public String getCollectionId() {
            return this.collectionId_;
        }

        @Override // com.google.firestore.v1.StructuredQuery.CollectionSelectorOrBuilder
        public ByteString getCollectionIdBytes() {
            return ByteString.copyFromUtf8(this.collectionId_);
        }

        @Override // com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i = this.c;
            if (i != -1) {
                return i;
            }
            int computeStringSize = this.collectionId_.isEmpty() ? 0 : 0 + CodedOutputStream.computeStringSize(2, getCollectionId());
            boolean z = this.allDescendants_;
            if (z) {
                computeStringSize += CodedOutputStream.computeBoolSize(3, z);
            }
            this.c = computeStringSize;
            return computeStringSize;
        }

        @Override // com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) {
            if (!this.collectionId_.isEmpty()) {
                codedOutputStream.writeString(2, getCollectionId());
            }
            boolean z = this.allDescendants_;
            if (z) {
                codedOutputStream.writeBool(3, z);
            }
        }
    }

    /* loaded from: classes2.dex */
    public interface CollectionSelectorOrBuilder extends MessageLiteOrBuilder {
        boolean getAllDescendants();

        String getCollectionId();

        ByteString getCollectionIdBytes();
    }

    /* loaded from: classes2.dex */
    public static final class CompositeFilter extends GeneratedMessageLite<CompositeFilter, Builder> implements CompositeFilterOrBuilder {
        private static final CompositeFilter DEFAULT_INSTANCE = new CompositeFilter();
        public static final int FILTERS_FIELD_NUMBER = 2;
        public static final int OP_FIELD_NUMBER = 1;
        private static volatile Parser<CompositeFilter> PARSER;
        private int bitField0_;
        private Internal.ProtobufList<Filter> filters_ = GeneratedMessageLite.f();
        private int op_;

        /* loaded from: classes2.dex */
        public static final class Builder extends GeneratedMessageLite.Builder<CompositeFilter, Builder> implements CompositeFilterOrBuilder {
            private Builder() {
                super(CompositeFilter.DEFAULT_INSTANCE);
            }

            /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            public Builder addAllFilters(Iterable<? extends Filter> iterable) {
                a();
                ((CompositeFilter) this.a).addAllFilters(iterable);
                return this;
            }

            public Builder addFilters(int i, Filter.Builder builder) {
                a();
                ((CompositeFilter) this.a).addFilters(i, builder);
                return this;
            }

            public Builder addFilters(int i, Filter filter) {
                a();
                ((CompositeFilter) this.a).addFilters(i, filter);
                return this;
            }

            public Builder addFilters(Filter.Builder builder) {
                a();
                ((CompositeFilter) this.a).addFilters(builder);
                return this;
            }

            public Builder addFilters(Filter filter) {
                a();
                ((CompositeFilter) this.a).addFilters(filter);
                return this;
            }

            public Builder clearFilters() {
                a();
                ((CompositeFilter) this.a).clearFilters();
                return this;
            }

            public Builder clearOp() {
                a();
                ((CompositeFilter) this.a).clearOp();
                return this;
            }

            @Override // com.google.firestore.v1.StructuredQuery.CompositeFilterOrBuilder
            public Filter getFilters(int i) {
                return ((CompositeFilter) this.a).getFilters(i);
            }

            @Override // com.google.firestore.v1.StructuredQuery.CompositeFilterOrBuilder
            public int getFiltersCount() {
                return ((CompositeFilter) this.a).getFiltersCount();
            }

            @Override // com.google.firestore.v1.StructuredQuery.CompositeFilterOrBuilder
            public List<Filter> getFiltersList() {
                return Collections.unmodifiableList(((CompositeFilter) this.a).getFiltersList());
            }

            @Override // com.google.firestore.v1.StructuredQuery.CompositeFilterOrBuilder
            public Operator getOp() {
                return ((CompositeFilter) this.a).getOp();
            }

            @Override // com.google.firestore.v1.StructuredQuery.CompositeFilterOrBuilder
            public int getOpValue() {
                return ((CompositeFilter) this.a).getOpValue();
            }

            public Builder removeFilters(int i) {
                a();
                ((CompositeFilter) this.a).removeFilters(i);
                return this;
            }

            public Builder setFilters(int i, Filter.Builder builder) {
                a();
                ((CompositeFilter) this.a).setFilters(i, builder);
                return this;
            }

            public Builder setFilters(int i, Filter filter) {
                a();
                ((CompositeFilter) this.a).setFilters(i, filter);
                return this;
            }

            public Builder setOp(Operator operator) {
                a();
                ((CompositeFilter) this.a).setOp(operator);
                return this;
            }

            public Builder setOpValue(int i) {
                a();
                ((CompositeFilter) this.a).setOpValue(i);
                return this;
            }
        }

        /* loaded from: classes2.dex */
        public enum Operator implements Internal.EnumLite {
            OPERATOR_UNSPECIFIED(0),
            AND(1),
            UNRECOGNIZED(-1);

            public static final int AND_VALUE = 1;
            public static final int OPERATOR_UNSPECIFIED_VALUE = 0;
            private static final Internal.EnumLiteMap<Operator> internalValueMap = new Internal.EnumLiteMap<Operator>() { // from class: com.google.firestore.v1.StructuredQuery.CompositeFilter.Operator.1
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // com.google.protobuf.Internal.EnumLiteMap
                public Operator findValueByNumber(int i) {
                    return Operator.forNumber(i);
                }
            };
            private final int value;

            Operator(int i) {
                this.value = i;
            }

            public static Operator forNumber(int i) {
                if (i == 0) {
                    return OPERATOR_UNSPECIFIED;
                }
                if (i != 1) {
                    return null;
                }
                return AND;
            }

            public static Internal.EnumLiteMap<Operator> internalGetValueMap() {
                return internalValueMap;
            }

            @Deprecated
            public static Operator valueOf(int i) {
                return forNumber(i);
            }

            @Override // com.google.protobuf.Internal.EnumLite
            public final int getNumber() {
                return this.value;
            }
        }

        static {
            DEFAULT_INSTANCE.b();
        }

        private CompositeFilter() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addAllFilters(Iterable<? extends Filter> iterable) {
            ensureFiltersIsMutable();
            AbstractMessageLite.a(iterable, this.filters_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addFilters(int i, Filter.Builder builder) {
            ensureFiltersIsMutable();
            this.filters_.add(i, builder.build());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addFilters(int i, Filter filter) {
            if (filter == null) {
                throw new NullPointerException();
            }
            ensureFiltersIsMutable();
            this.filters_.add(i, filter);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addFilters(Filter.Builder builder) {
            ensureFiltersIsMutable();
            this.filters_.add(builder.build());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addFilters(Filter filter) {
            if (filter == null) {
                throw new NullPointerException();
            }
            ensureFiltersIsMutable();
            this.filters_.add(filter);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearFilters() {
            this.filters_ = GeneratedMessageLite.f();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearOp() {
            this.op_ = 0;
        }

        private void ensureFiltersIsMutable() {
            if (this.filters_.isModifiable()) {
                return;
            }
            this.filters_ = GeneratedMessageLite.a(this.filters_);
        }

        public static CompositeFilter getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(CompositeFilter compositeFilter) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom((Builder) compositeFilter);
        }

        public static CompositeFilter parseDelimitedFrom(InputStream inputStream) {
            return (CompositeFilter) GeneratedMessageLite.a(DEFAULT_INSTANCE, inputStream);
        }

        public static CompositeFilter parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (CompositeFilter) GeneratedMessageLite.a(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static CompositeFilter parseFrom(ByteString byteString) {
            return (CompositeFilter) GeneratedMessageLite.a(DEFAULT_INSTANCE, byteString);
        }

        public static CompositeFilter parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
            return (CompositeFilter) GeneratedMessageLite.a(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static CompositeFilter parseFrom(CodedInputStream codedInputStream) {
            return (CompositeFilter) GeneratedMessageLite.a(DEFAULT_INSTANCE, codedInputStream);
        }

        public static CompositeFilter parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (CompositeFilter) GeneratedMessageLite.a(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        public static CompositeFilter parseFrom(InputStream inputStream) {
            return (CompositeFilter) GeneratedMessageLite.b(DEFAULT_INSTANCE, inputStream);
        }

        public static CompositeFilter parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (CompositeFilter) GeneratedMessageLite.b(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static CompositeFilter parseFrom(byte[] bArr) {
            return (CompositeFilter) GeneratedMessageLite.a(DEFAULT_INSTANCE, bArr);
        }

        public static CompositeFilter parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
            return (CompositeFilter) GeneratedMessageLite.a(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static Parser<CompositeFilter> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void removeFilters(int i) {
            ensureFiltersIsMutable();
            this.filters_.remove(i);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setFilters(int i, Filter.Builder builder) {
            ensureFiltersIsMutable();
            this.filters_.set(i, builder.build());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setFilters(int i, Filter filter) {
            if (filter == null) {
                throw new NullPointerException();
            }
            ensureFiltersIsMutable();
            this.filters_.set(i, filter);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setOp(Operator operator) {
            if (operator == null) {
                throw new NullPointerException();
            }
            this.op_ = operator.getNumber();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setOpValue(int i) {
            this.op_ = i;
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        protected final Object a(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            AnonymousClass1 anonymousClass1 = null;
            switch (AnonymousClass1.a[methodToInvoke.ordinal()]) {
                case 1:
                    return new CompositeFilter();
                case 2:
                    return DEFAULT_INSTANCE;
                case 3:
                    this.filters_.makeImmutable();
                    return null;
                case 4:
                    return new Builder(anonymousClass1);
                case 5:
                    GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                    CompositeFilter compositeFilter = (CompositeFilter) obj2;
                    this.op_ = visitor.visitInt(this.op_ != 0, this.op_, compositeFilter.op_ != 0, compositeFilter.op_);
                    this.filters_ = visitor.visitList(this.filters_, compositeFilter.filters_);
                    if (visitor == GeneratedMessageLite.MergeFromVisitor.INSTANCE) {
                        this.bitField0_ |= compositeFilter.bitField0_;
                    }
                    return this;
                case 6:
                    CodedInputStream codedInputStream = (CodedInputStream) obj;
                    ExtensionRegistryLite extensionRegistryLite = (ExtensionRegistryLite) obj2;
                    while (!r1) {
                        try {
                            try {
                                int readTag = codedInputStream.readTag();
                                if (readTag != 0) {
                                    if (readTag == 8) {
                                        this.op_ = codedInputStream.readEnum();
                                    } else if (readTag == 18) {
                                        if (!this.filters_.isModifiable()) {
                                            this.filters_ = GeneratedMessageLite.a(this.filters_);
                                        }
                                        this.filters_.add((Filter) codedInputStream.readMessage(Filter.parser(), extensionRegistryLite));
                                    } else if (!codedInputStream.skipField(readTag)) {
                                    }
                                }
                                r1 = true;
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
                        synchronized (CompositeFilter.class) {
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

        @Override // com.google.firestore.v1.StructuredQuery.CompositeFilterOrBuilder
        public Filter getFilters(int i) {
            return this.filters_.get(i);
        }

        @Override // com.google.firestore.v1.StructuredQuery.CompositeFilterOrBuilder
        public int getFiltersCount() {
            return this.filters_.size();
        }

        @Override // com.google.firestore.v1.StructuredQuery.CompositeFilterOrBuilder
        public List<Filter> getFiltersList() {
            return this.filters_;
        }

        public FilterOrBuilder getFiltersOrBuilder(int i) {
            return this.filters_.get(i);
        }

        public List<? extends FilterOrBuilder> getFiltersOrBuilderList() {
            return this.filters_;
        }

        @Override // com.google.firestore.v1.StructuredQuery.CompositeFilterOrBuilder
        public Operator getOp() {
            Operator forNumber = Operator.forNumber(this.op_);
            return forNumber == null ? Operator.UNRECOGNIZED : forNumber;
        }

        @Override // com.google.firestore.v1.StructuredQuery.CompositeFilterOrBuilder
        public int getOpValue() {
            return this.op_;
        }

        @Override // com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i = this.c;
            if (i != -1) {
                return i;
            }
            int computeEnumSize = this.op_ != Operator.OPERATOR_UNSPECIFIED.getNumber() ? CodedOutputStream.computeEnumSize(1, this.op_) + 0 : 0;
            for (int i2 = 0; i2 < this.filters_.size(); i2++) {
                computeEnumSize += CodedOutputStream.computeMessageSize(2, this.filters_.get(i2));
            }
            this.c = computeEnumSize;
            return computeEnumSize;
        }

        @Override // com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) {
            if (this.op_ != Operator.OPERATOR_UNSPECIFIED.getNumber()) {
                codedOutputStream.writeEnum(1, this.op_);
            }
            for (int i = 0; i < this.filters_.size(); i++) {
                codedOutputStream.writeMessage(2, this.filters_.get(i));
            }
        }
    }

    /* loaded from: classes2.dex */
    public interface CompositeFilterOrBuilder extends MessageLiteOrBuilder {
        Filter getFilters(int i);

        int getFiltersCount();

        List<Filter> getFiltersList();

        CompositeFilter.Operator getOp();

        int getOpValue();
    }

    /* loaded from: classes2.dex */
    public enum Direction implements Internal.EnumLite {
        DIRECTION_UNSPECIFIED(0),
        ASCENDING(1),
        DESCENDING(2),
        UNRECOGNIZED(-1);

        public static final int ASCENDING_VALUE = 1;
        public static final int DESCENDING_VALUE = 2;
        public static final int DIRECTION_UNSPECIFIED_VALUE = 0;
        private static final Internal.EnumLiteMap<Direction> internalValueMap = new Internal.EnumLiteMap<Direction>() { // from class: com.google.firestore.v1.StructuredQuery.Direction.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.google.protobuf.Internal.EnumLiteMap
            public Direction findValueByNumber(int i) {
                return Direction.forNumber(i);
            }
        };
        private final int value;

        Direction(int i) {
            this.value = i;
        }

        public static Direction forNumber(int i) {
            if (i == 0) {
                return DIRECTION_UNSPECIFIED;
            }
            if (i == 1) {
                return ASCENDING;
            }
            if (i != 2) {
                return null;
            }
            return DESCENDING;
        }

        public static Internal.EnumLiteMap<Direction> internalGetValueMap() {
            return internalValueMap;
        }

        @Deprecated
        public static Direction valueOf(int i) {
            return forNumber(i);
        }

        @Override // com.google.protobuf.Internal.EnumLite
        public final int getNumber() {
            return this.value;
        }
    }

    /* loaded from: classes2.dex */
    public static final class FieldFilter extends GeneratedMessageLite<FieldFilter, Builder> implements FieldFilterOrBuilder {
        private static final FieldFilter DEFAULT_INSTANCE = new FieldFilter();
        public static final int FIELD_FIELD_NUMBER = 1;
        public static final int OP_FIELD_NUMBER = 2;
        private static volatile Parser<FieldFilter> PARSER = null;
        public static final int VALUE_FIELD_NUMBER = 3;
        private FieldReference field_;
        private int op_;
        private Value value_;

        /* loaded from: classes2.dex */
        public static final class Builder extends GeneratedMessageLite.Builder<FieldFilter, Builder> implements FieldFilterOrBuilder {
            private Builder() {
                super(FieldFilter.DEFAULT_INSTANCE);
            }

            /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            public Builder clearField() {
                a();
                ((FieldFilter) this.a).clearField();
                return this;
            }

            public Builder clearOp() {
                a();
                ((FieldFilter) this.a).clearOp();
                return this;
            }

            public Builder clearValue() {
                a();
                ((FieldFilter) this.a).clearValue();
                return this;
            }

            @Override // com.google.firestore.v1.StructuredQuery.FieldFilterOrBuilder
            public FieldReference getField() {
                return ((FieldFilter) this.a).getField();
            }

            @Override // com.google.firestore.v1.StructuredQuery.FieldFilterOrBuilder
            public Operator getOp() {
                return ((FieldFilter) this.a).getOp();
            }

            @Override // com.google.firestore.v1.StructuredQuery.FieldFilterOrBuilder
            public int getOpValue() {
                return ((FieldFilter) this.a).getOpValue();
            }

            @Override // com.google.firestore.v1.StructuredQuery.FieldFilterOrBuilder
            public Value getValue() {
                return ((FieldFilter) this.a).getValue();
            }

            @Override // com.google.firestore.v1.StructuredQuery.FieldFilterOrBuilder
            public boolean hasField() {
                return ((FieldFilter) this.a).hasField();
            }

            @Override // com.google.firestore.v1.StructuredQuery.FieldFilterOrBuilder
            public boolean hasValue() {
                return ((FieldFilter) this.a).hasValue();
            }

            public Builder mergeField(FieldReference fieldReference) {
                a();
                ((FieldFilter) this.a).mergeField(fieldReference);
                return this;
            }

            public Builder mergeValue(Value value) {
                a();
                ((FieldFilter) this.a).mergeValue(value);
                return this;
            }

            public Builder setField(FieldReference.Builder builder) {
                a();
                ((FieldFilter) this.a).setField(builder);
                return this;
            }

            public Builder setField(FieldReference fieldReference) {
                a();
                ((FieldFilter) this.a).setField(fieldReference);
                return this;
            }

            public Builder setOp(Operator operator) {
                a();
                ((FieldFilter) this.a).setOp(operator);
                return this;
            }

            public Builder setOpValue(int i) {
                a();
                ((FieldFilter) this.a).setOpValue(i);
                return this;
            }

            public Builder setValue(Value.Builder builder) {
                a();
                ((FieldFilter) this.a).setValue(builder);
                return this;
            }

            public Builder setValue(Value value) {
                a();
                ((FieldFilter) this.a).setValue(value);
                return this;
            }
        }

        /* loaded from: classes2.dex */
        public enum Operator implements Internal.EnumLite {
            OPERATOR_UNSPECIFIED(0),
            LESS_THAN(1),
            LESS_THAN_OR_EQUAL(2),
            GREATER_THAN(3),
            GREATER_THAN_OR_EQUAL(4),
            EQUAL(5),
            ARRAY_CONTAINS(7),
            IN(8),
            ARRAY_CONTAINS_ANY(9),
            UNRECOGNIZED(-1);

            public static final int ARRAY_CONTAINS_ANY_VALUE = 9;
            public static final int ARRAY_CONTAINS_VALUE = 7;
            public static final int EQUAL_VALUE = 5;
            public static final int GREATER_THAN_OR_EQUAL_VALUE = 4;
            public static final int GREATER_THAN_VALUE = 3;
            public static final int IN_VALUE = 8;
            public static final int LESS_THAN_OR_EQUAL_VALUE = 2;
            public static final int LESS_THAN_VALUE = 1;
            public static final int OPERATOR_UNSPECIFIED_VALUE = 0;
            private static final Internal.EnumLiteMap<Operator> internalValueMap = new Internal.EnumLiteMap<Operator>() { // from class: com.google.firestore.v1.StructuredQuery.FieldFilter.Operator.1
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // com.google.protobuf.Internal.EnumLiteMap
                public Operator findValueByNumber(int i) {
                    return Operator.forNumber(i);
                }
            };
            private final int value;

            Operator(int i) {
                this.value = i;
            }

            public static Operator forNumber(int i) {
                switch (i) {
                    case 0:
                        return OPERATOR_UNSPECIFIED;
                    case 1:
                        return LESS_THAN;
                    case 2:
                        return LESS_THAN_OR_EQUAL;
                    case 3:
                        return GREATER_THAN;
                    case 4:
                        return GREATER_THAN_OR_EQUAL;
                    case 5:
                        return EQUAL;
                    case 6:
                    default:
                        return null;
                    case 7:
                        return ARRAY_CONTAINS;
                    case 8:
                        return IN;
                    case 9:
                        return ARRAY_CONTAINS_ANY;
                }
            }

            public static Internal.EnumLiteMap<Operator> internalGetValueMap() {
                return internalValueMap;
            }

            @Deprecated
            public static Operator valueOf(int i) {
                return forNumber(i);
            }

            @Override // com.google.protobuf.Internal.EnumLite
            public final int getNumber() {
                return this.value;
            }
        }

        static {
            DEFAULT_INSTANCE.b();
        }

        private FieldFilter() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearField() {
            this.field_ = null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearOp() {
            this.op_ = 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearValue() {
            this.value_ = null;
        }

        public static FieldFilter getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void mergeField(FieldReference fieldReference) {
            FieldReference fieldReference2 = this.field_;
            if (fieldReference2 != null && fieldReference2 != FieldReference.getDefaultInstance()) {
                fieldReference = FieldReference.newBuilder(this.field_).mergeFrom((FieldReference.Builder) fieldReference).buildPartial();
            }
            this.field_ = fieldReference;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void mergeValue(Value value) {
            Value value2 = this.value_;
            if (value2 != null && value2 != Value.getDefaultInstance()) {
                value = Value.newBuilder(this.value_).mergeFrom((Value.Builder) value).buildPartial();
            }
            this.value_ = value;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(FieldFilter fieldFilter) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom((Builder) fieldFilter);
        }

        public static FieldFilter parseDelimitedFrom(InputStream inputStream) {
            return (FieldFilter) GeneratedMessageLite.a(DEFAULT_INSTANCE, inputStream);
        }

        public static FieldFilter parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (FieldFilter) GeneratedMessageLite.a(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static FieldFilter parseFrom(ByteString byteString) {
            return (FieldFilter) GeneratedMessageLite.a(DEFAULT_INSTANCE, byteString);
        }

        public static FieldFilter parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
            return (FieldFilter) GeneratedMessageLite.a(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static FieldFilter parseFrom(CodedInputStream codedInputStream) {
            return (FieldFilter) GeneratedMessageLite.a(DEFAULT_INSTANCE, codedInputStream);
        }

        public static FieldFilter parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (FieldFilter) GeneratedMessageLite.a(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        public static FieldFilter parseFrom(InputStream inputStream) {
            return (FieldFilter) GeneratedMessageLite.b(DEFAULT_INSTANCE, inputStream);
        }

        public static FieldFilter parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (FieldFilter) GeneratedMessageLite.b(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static FieldFilter parseFrom(byte[] bArr) {
            return (FieldFilter) GeneratedMessageLite.a(DEFAULT_INSTANCE, bArr);
        }

        public static FieldFilter parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
            return (FieldFilter) GeneratedMessageLite.a(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static Parser<FieldFilter> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setField(FieldReference.Builder builder) {
            this.field_ = builder.build();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setField(FieldReference fieldReference) {
            if (fieldReference == null) {
                throw new NullPointerException();
            }
            this.field_ = fieldReference;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setOp(Operator operator) {
            if (operator == null) {
                throw new NullPointerException();
            }
            this.op_ = operator.getNumber();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setOpValue(int i) {
            this.op_ = i;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setValue(Value.Builder builder) {
            this.value_ = builder.build();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setValue(Value value) {
            if (value == null) {
                throw new NullPointerException();
            }
            this.value_ = value;
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        protected final Object a(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            AnonymousClass1 anonymousClass1 = null;
            switch (AnonymousClass1.a[methodToInvoke.ordinal()]) {
                case 1:
                    return new FieldFilter();
                case 2:
                    return DEFAULT_INSTANCE;
                case 3:
                    return null;
                case 4:
                    return new Builder(anonymousClass1);
                case 5:
                    GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                    FieldFilter fieldFilter = (FieldFilter) obj2;
                    this.field_ = (FieldReference) visitor.visitMessage(this.field_, fieldFilter.field_);
                    this.op_ = visitor.visitInt(this.op_ != 0, this.op_, fieldFilter.op_ != 0, fieldFilter.op_);
                    this.value_ = (Value) visitor.visitMessage(this.value_, fieldFilter.value_);
                    GeneratedMessageLite.MergeFromVisitor mergeFromVisitor = GeneratedMessageLite.MergeFromVisitor.INSTANCE;
                    return this;
                case 6:
                    CodedInputStream codedInputStream = (CodedInputStream) obj;
                    ExtensionRegistryLite extensionRegistryLite = (ExtensionRegistryLite) obj2;
                    while (!r0) {
                        try {
                            int readTag = codedInputStream.readTag();
                            if (readTag != 0) {
                                if (readTag == 10) {
                                    FieldReference.Builder builder = this.field_ != null ? this.field_.toBuilder() : null;
                                    this.field_ = (FieldReference) codedInputStream.readMessage(FieldReference.parser(), extensionRegistryLite);
                                    if (builder != null) {
                                        builder.mergeFrom((FieldReference.Builder) this.field_);
                                        this.field_ = builder.buildPartial();
                                    }
                                } else if (readTag == 16) {
                                    this.op_ = codedInputStream.readEnum();
                                } else if (readTag == 26) {
                                    Value.Builder builder2 = this.value_ != null ? this.value_.toBuilder() : null;
                                    this.value_ = (Value) codedInputStream.readMessage(Value.parser(), extensionRegistryLite);
                                    if (builder2 != null) {
                                        builder2.mergeFrom((Value.Builder) this.value_);
                                        this.value_ = builder2.buildPartial();
                                    }
                                } else if (!codedInputStream.skipField(readTag)) {
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
                        synchronized (FieldFilter.class) {
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

        @Override // com.google.firestore.v1.StructuredQuery.FieldFilterOrBuilder
        public FieldReference getField() {
            FieldReference fieldReference = this.field_;
            return fieldReference == null ? FieldReference.getDefaultInstance() : fieldReference;
        }

        @Override // com.google.firestore.v1.StructuredQuery.FieldFilterOrBuilder
        public Operator getOp() {
            Operator forNumber = Operator.forNumber(this.op_);
            return forNumber == null ? Operator.UNRECOGNIZED : forNumber;
        }

        @Override // com.google.firestore.v1.StructuredQuery.FieldFilterOrBuilder
        public int getOpValue() {
            return this.op_;
        }

        @Override // com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i = this.c;
            if (i != -1) {
                return i;
            }
            int computeMessageSize = this.field_ != null ? 0 + CodedOutputStream.computeMessageSize(1, getField()) : 0;
            if (this.op_ != Operator.OPERATOR_UNSPECIFIED.getNumber()) {
                computeMessageSize += CodedOutputStream.computeEnumSize(2, this.op_);
            }
            if (this.value_ != null) {
                computeMessageSize += CodedOutputStream.computeMessageSize(3, getValue());
            }
            this.c = computeMessageSize;
            return computeMessageSize;
        }

        @Override // com.google.firestore.v1.StructuredQuery.FieldFilterOrBuilder
        public Value getValue() {
            Value value = this.value_;
            return value == null ? Value.getDefaultInstance() : value;
        }

        @Override // com.google.firestore.v1.StructuredQuery.FieldFilterOrBuilder
        public boolean hasField() {
            return this.field_ != null;
        }

        @Override // com.google.firestore.v1.StructuredQuery.FieldFilterOrBuilder
        public boolean hasValue() {
            return this.value_ != null;
        }

        @Override // com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) {
            if (this.field_ != null) {
                codedOutputStream.writeMessage(1, getField());
            }
            if (this.op_ != Operator.OPERATOR_UNSPECIFIED.getNumber()) {
                codedOutputStream.writeEnum(2, this.op_);
            }
            if (this.value_ != null) {
                codedOutputStream.writeMessage(3, getValue());
            }
        }
    }

    /* loaded from: classes2.dex */
    public interface FieldFilterOrBuilder extends MessageLiteOrBuilder {
        FieldReference getField();

        FieldFilter.Operator getOp();

        int getOpValue();

        Value getValue();

        boolean hasField();

        boolean hasValue();
    }

    /* loaded from: classes2.dex */
    public static final class FieldReference extends GeneratedMessageLite<FieldReference, Builder> implements FieldReferenceOrBuilder {
        private static final FieldReference DEFAULT_INSTANCE = new FieldReference();
        public static final int FIELD_PATH_FIELD_NUMBER = 2;
        private static volatile Parser<FieldReference> PARSER;
        private String fieldPath_ = "";

        /* loaded from: classes2.dex */
        public static final class Builder extends GeneratedMessageLite.Builder<FieldReference, Builder> implements FieldReferenceOrBuilder {
            private Builder() {
                super(FieldReference.DEFAULT_INSTANCE);
            }

            /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            public Builder clearFieldPath() {
                a();
                ((FieldReference) this.a).clearFieldPath();
                return this;
            }

            @Override // com.google.firestore.v1.StructuredQuery.FieldReferenceOrBuilder
            public String getFieldPath() {
                return ((FieldReference) this.a).getFieldPath();
            }

            @Override // com.google.firestore.v1.StructuredQuery.FieldReferenceOrBuilder
            public ByteString getFieldPathBytes() {
                return ((FieldReference) this.a).getFieldPathBytes();
            }

            public Builder setFieldPath(String str) {
                a();
                ((FieldReference) this.a).setFieldPath(str);
                return this;
            }

            public Builder setFieldPathBytes(ByteString byteString) {
                a();
                ((FieldReference) this.a).setFieldPathBytes(byteString);
                return this;
            }
        }

        static {
            DEFAULT_INSTANCE.b();
        }

        private FieldReference() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearFieldPath() {
            this.fieldPath_ = getDefaultInstance().getFieldPath();
        }

        public static FieldReference getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(FieldReference fieldReference) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom((Builder) fieldReference);
        }

        public static FieldReference parseDelimitedFrom(InputStream inputStream) {
            return (FieldReference) GeneratedMessageLite.a(DEFAULT_INSTANCE, inputStream);
        }

        public static FieldReference parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (FieldReference) GeneratedMessageLite.a(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static FieldReference parseFrom(ByteString byteString) {
            return (FieldReference) GeneratedMessageLite.a(DEFAULT_INSTANCE, byteString);
        }

        public static FieldReference parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
            return (FieldReference) GeneratedMessageLite.a(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static FieldReference parseFrom(CodedInputStream codedInputStream) {
            return (FieldReference) GeneratedMessageLite.a(DEFAULT_INSTANCE, codedInputStream);
        }

        public static FieldReference parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (FieldReference) GeneratedMessageLite.a(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        public static FieldReference parseFrom(InputStream inputStream) {
            return (FieldReference) GeneratedMessageLite.b(DEFAULT_INSTANCE, inputStream);
        }

        public static FieldReference parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (FieldReference) GeneratedMessageLite.b(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static FieldReference parseFrom(byte[] bArr) {
            return (FieldReference) GeneratedMessageLite.a(DEFAULT_INSTANCE, bArr);
        }

        public static FieldReference parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
            return (FieldReference) GeneratedMessageLite.a(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static Parser<FieldReference> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setFieldPath(String str) {
            if (str == null) {
                throw new NullPointerException();
            }
            this.fieldPath_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setFieldPathBytes(ByteString byteString) {
            if (byteString == null) {
                throw new NullPointerException();
            }
            AbstractMessageLite.a(byteString);
            this.fieldPath_ = byteString.toStringUtf8();
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        protected final Object a(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            AnonymousClass1 anonymousClass1 = null;
            switch (AnonymousClass1.a[methodToInvoke.ordinal()]) {
                case 1:
                    return new FieldReference();
                case 2:
                    return DEFAULT_INSTANCE;
                case 3:
                    return null;
                case 4:
                    return new Builder(anonymousClass1);
                case 5:
                    FieldReference fieldReference = (FieldReference) obj2;
                    this.fieldPath_ = ((GeneratedMessageLite.Visitor) obj).visitString(!this.fieldPath_.isEmpty(), this.fieldPath_, true ^ fieldReference.fieldPath_.isEmpty(), fieldReference.fieldPath_);
                    GeneratedMessageLite.MergeFromVisitor mergeFromVisitor = GeneratedMessageLite.MergeFromVisitor.INSTANCE;
                    return this;
                case 6:
                    CodedInputStream codedInputStream = (CodedInputStream) obj;
                    boolean z = false;
                    while (!z) {
                        try {
                            int readTag = codedInputStream.readTag();
                            if (readTag != 0) {
                                if (readTag == 18) {
                                    this.fieldPath_ = codedInputStream.readStringRequireUtf8();
                                } else if (!codedInputStream.skipField(readTag)) {
                                }
                            }
                            z = true;
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
                        synchronized (FieldReference.class) {
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

        @Override // com.google.firestore.v1.StructuredQuery.FieldReferenceOrBuilder
        public String getFieldPath() {
            return this.fieldPath_;
        }

        @Override // com.google.firestore.v1.StructuredQuery.FieldReferenceOrBuilder
        public ByteString getFieldPathBytes() {
            return ByteString.copyFromUtf8(this.fieldPath_);
        }

        @Override // com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i = this.c;
            if (i != -1) {
                return i;
            }
            int computeStringSize = this.fieldPath_.isEmpty() ? 0 : 0 + CodedOutputStream.computeStringSize(2, getFieldPath());
            this.c = computeStringSize;
            return computeStringSize;
        }

        @Override // com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) {
            if (this.fieldPath_.isEmpty()) {
                return;
            }
            codedOutputStream.writeString(2, getFieldPath());
        }
    }

    /* loaded from: classes2.dex */
    public interface FieldReferenceOrBuilder extends MessageLiteOrBuilder {
        String getFieldPath();

        ByteString getFieldPathBytes();
    }

    /* loaded from: classes2.dex */
    public static final class Filter extends GeneratedMessageLite<Filter, Builder> implements FilterOrBuilder {
        public static final int COMPOSITE_FILTER_FIELD_NUMBER = 1;
        private static final Filter DEFAULT_INSTANCE = new Filter();
        public static final int FIELD_FILTER_FIELD_NUMBER = 2;
        private static volatile Parser<Filter> PARSER = null;
        public static final int UNARY_FILTER_FIELD_NUMBER = 3;
        private int filterTypeCase_ = 0;
        private Object filterType_;

        /* loaded from: classes2.dex */
        public static final class Builder extends GeneratedMessageLite.Builder<Filter, Builder> implements FilterOrBuilder {
            private Builder() {
                super(Filter.DEFAULT_INSTANCE);
            }

            /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            public Builder clearCompositeFilter() {
                a();
                ((Filter) this.a).clearCompositeFilter();
                return this;
            }

            public Builder clearFieldFilter() {
                a();
                ((Filter) this.a).clearFieldFilter();
                return this;
            }

            public Builder clearFilterType() {
                a();
                ((Filter) this.a).clearFilterType();
                return this;
            }

            public Builder clearUnaryFilter() {
                a();
                ((Filter) this.a).clearUnaryFilter();
                return this;
            }

            @Override // com.google.firestore.v1.StructuredQuery.FilterOrBuilder
            public CompositeFilter getCompositeFilter() {
                return ((Filter) this.a).getCompositeFilter();
            }

            @Override // com.google.firestore.v1.StructuredQuery.FilterOrBuilder
            public FieldFilter getFieldFilter() {
                return ((Filter) this.a).getFieldFilter();
            }

            @Override // com.google.firestore.v1.StructuredQuery.FilterOrBuilder
            public FilterTypeCase getFilterTypeCase() {
                return ((Filter) this.a).getFilterTypeCase();
            }

            @Override // com.google.firestore.v1.StructuredQuery.FilterOrBuilder
            public UnaryFilter getUnaryFilter() {
                return ((Filter) this.a).getUnaryFilter();
            }

            public Builder mergeCompositeFilter(CompositeFilter compositeFilter) {
                a();
                ((Filter) this.a).mergeCompositeFilter(compositeFilter);
                return this;
            }

            public Builder mergeFieldFilter(FieldFilter fieldFilter) {
                a();
                ((Filter) this.a).mergeFieldFilter(fieldFilter);
                return this;
            }

            public Builder mergeUnaryFilter(UnaryFilter unaryFilter) {
                a();
                ((Filter) this.a).mergeUnaryFilter(unaryFilter);
                return this;
            }

            public Builder setCompositeFilter(CompositeFilter.Builder builder) {
                a();
                ((Filter) this.a).setCompositeFilter(builder);
                return this;
            }

            public Builder setCompositeFilter(CompositeFilter compositeFilter) {
                a();
                ((Filter) this.a).setCompositeFilter(compositeFilter);
                return this;
            }

            public Builder setFieldFilter(FieldFilter.Builder builder) {
                a();
                ((Filter) this.a).setFieldFilter(builder);
                return this;
            }

            public Builder setFieldFilter(FieldFilter fieldFilter) {
                a();
                ((Filter) this.a).setFieldFilter(fieldFilter);
                return this;
            }

            public Builder setUnaryFilter(UnaryFilter.Builder builder) {
                a();
                ((Filter) this.a).setUnaryFilter(builder);
                return this;
            }

            public Builder setUnaryFilter(UnaryFilter unaryFilter) {
                a();
                ((Filter) this.a).setUnaryFilter(unaryFilter);
                return this;
            }
        }

        /* loaded from: classes2.dex */
        public enum FilterTypeCase implements Internal.EnumLite {
            COMPOSITE_FILTER(1),
            FIELD_FILTER(2),
            UNARY_FILTER(3),
            FILTERTYPE_NOT_SET(0);

            private final int value;

            FilterTypeCase(int i) {
                this.value = i;
            }

            public static FilterTypeCase forNumber(int i) {
                if (i == 0) {
                    return FILTERTYPE_NOT_SET;
                }
                if (i == 1) {
                    return COMPOSITE_FILTER;
                }
                if (i == 2) {
                    return FIELD_FILTER;
                }
                if (i != 3) {
                    return null;
                }
                return UNARY_FILTER;
            }

            @Deprecated
            public static FilterTypeCase valueOf(int i) {
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

        private Filter() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearCompositeFilter() {
            if (this.filterTypeCase_ == 1) {
                this.filterTypeCase_ = 0;
                this.filterType_ = null;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearFieldFilter() {
            if (this.filterTypeCase_ == 2) {
                this.filterTypeCase_ = 0;
                this.filterType_ = null;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearFilterType() {
            this.filterTypeCase_ = 0;
            this.filterType_ = null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearUnaryFilter() {
            if (this.filterTypeCase_ == 3) {
                this.filterTypeCase_ = 0;
                this.filterType_ = null;
            }
        }

        public static Filter getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void mergeCompositeFilter(CompositeFilter compositeFilter) {
            if (this.filterTypeCase_ == 1 && this.filterType_ != CompositeFilter.getDefaultInstance()) {
                compositeFilter = CompositeFilter.newBuilder((CompositeFilter) this.filterType_).mergeFrom((CompositeFilter.Builder) compositeFilter).buildPartial();
            }
            this.filterType_ = compositeFilter;
            this.filterTypeCase_ = 1;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void mergeFieldFilter(FieldFilter fieldFilter) {
            if (this.filterTypeCase_ == 2 && this.filterType_ != FieldFilter.getDefaultInstance()) {
                fieldFilter = FieldFilter.newBuilder((FieldFilter) this.filterType_).mergeFrom((FieldFilter.Builder) fieldFilter).buildPartial();
            }
            this.filterType_ = fieldFilter;
            this.filterTypeCase_ = 2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void mergeUnaryFilter(UnaryFilter unaryFilter) {
            if (this.filterTypeCase_ == 3 && this.filterType_ != UnaryFilter.getDefaultInstance()) {
                unaryFilter = UnaryFilter.newBuilder((UnaryFilter) this.filterType_).mergeFrom((UnaryFilter.Builder) unaryFilter).buildPartial();
            }
            this.filterType_ = unaryFilter;
            this.filterTypeCase_ = 3;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(Filter filter) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom((Builder) filter);
        }

        public static Filter parseDelimitedFrom(InputStream inputStream) {
            return (Filter) GeneratedMessageLite.a(DEFAULT_INSTANCE, inputStream);
        }

        public static Filter parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (Filter) GeneratedMessageLite.a(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static Filter parseFrom(ByteString byteString) {
            return (Filter) GeneratedMessageLite.a(DEFAULT_INSTANCE, byteString);
        }

        public static Filter parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
            return (Filter) GeneratedMessageLite.a(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static Filter parseFrom(CodedInputStream codedInputStream) {
            return (Filter) GeneratedMessageLite.a(DEFAULT_INSTANCE, codedInputStream);
        }

        public static Filter parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (Filter) GeneratedMessageLite.a(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        public static Filter parseFrom(InputStream inputStream) {
            return (Filter) GeneratedMessageLite.b(DEFAULT_INSTANCE, inputStream);
        }

        public static Filter parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (Filter) GeneratedMessageLite.b(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static Filter parseFrom(byte[] bArr) {
            return (Filter) GeneratedMessageLite.a(DEFAULT_INSTANCE, bArr);
        }

        public static Filter parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
            return (Filter) GeneratedMessageLite.a(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static Parser<Filter> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setCompositeFilter(CompositeFilter.Builder builder) {
            this.filterType_ = builder.build();
            this.filterTypeCase_ = 1;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setCompositeFilter(CompositeFilter compositeFilter) {
            if (compositeFilter == null) {
                throw new NullPointerException();
            }
            this.filterType_ = compositeFilter;
            this.filterTypeCase_ = 1;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setFieldFilter(FieldFilter.Builder builder) {
            this.filterType_ = builder.build();
            this.filterTypeCase_ = 2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setFieldFilter(FieldFilter fieldFilter) {
            if (fieldFilter == null) {
                throw new NullPointerException();
            }
            this.filterType_ = fieldFilter;
            this.filterTypeCase_ = 2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setUnaryFilter(UnaryFilter.Builder builder) {
            this.filterType_ = builder.build();
            this.filterTypeCase_ = 3;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setUnaryFilter(UnaryFilter unaryFilter) {
            if (unaryFilter == null) {
                throw new NullPointerException();
            }
            this.filterType_ = unaryFilter;
            this.filterTypeCase_ = 3;
        }

        /* JADX WARN: Code restructure failed: missing block: B:104:0x0124, code lost:
        
            if (r6.filterTypeCase_ == 3) goto L89;
         */
        /* JADX WARN: Code restructure failed: missing block: B:105:0x0131, code lost:
        
            r6.filterType_ = r8.visitOneofMessage(r2, r6.filterType_, r9.filterType_);
         */
        /* JADX WARN: Code restructure failed: missing block: B:106:0x0130, code lost:
        
            r2 = true;
         */
        /* JADX WARN: Code restructure failed: missing block: B:108:0x0129, code lost:
        
            if (r6.filterTypeCase_ == 2) goto L89;
         */
        /* JADX WARN: Code restructure failed: missing block: B:110:0x012e, code lost:
        
            if (r6.filterTypeCase_ == 1) goto L89;
         */
        @Override // com.google.protobuf.GeneratedMessageLite
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        protected final java.lang.Object a(com.google.protobuf.GeneratedMessageLite.MethodToInvoke r7, java.lang.Object r8, java.lang.Object r9) {
            /*
                Method dump skipped, instructions count: 362
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.firestore.v1.StructuredQuery.Filter.a(com.google.protobuf.GeneratedMessageLite$MethodToInvoke, java.lang.Object, java.lang.Object):java.lang.Object");
        }

        @Override // com.google.firestore.v1.StructuredQuery.FilterOrBuilder
        public CompositeFilter getCompositeFilter() {
            return this.filterTypeCase_ == 1 ? (CompositeFilter) this.filterType_ : CompositeFilter.getDefaultInstance();
        }

        @Override // com.google.firestore.v1.StructuredQuery.FilterOrBuilder
        public FieldFilter getFieldFilter() {
            return this.filterTypeCase_ == 2 ? (FieldFilter) this.filterType_ : FieldFilter.getDefaultInstance();
        }

        @Override // com.google.firestore.v1.StructuredQuery.FilterOrBuilder
        public FilterTypeCase getFilterTypeCase() {
            return FilterTypeCase.forNumber(this.filterTypeCase_);
        }

        @Override // com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i = this.c;
            if (i != -1) {
                return i;
            }
            int computeMessageSize = this.filterTypeCase_ == 1 ? 0 + CodedOutputStream.computeMessageSize(1, (CompositeFilter) this.filterType_) : 0;
            if (this.filterTypeCase_ == 2) {
                computeMessageSize += CodedOutputStream.computeMessageSize(2, (FieldFilter) this.filterType_);
            }
            if (this.filterTypeCase_ == 3) {
                computeMessageSize += CodedOutputStream.computeMessageSize(3, (UnaryFilter) this.filterType_);
            }
            this.c = computeMessageSize;
            return computeMessageSize;
        }

        @Override // com.google.firestore.v1.StructuredQuery.FilterOrBuilder
        public UnaryFilter getUnaryFilter() {
            return this.filterTypeCase_ == 3 ? (UnaryFilter) this.filterType_ : UnaryFilter.getDefaultInstance();
        }

        @Override // com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) {
            if (this.filterTypeCase_ == 1) {
                codedOutputStream.writeMessage(1, (CompositeFilter) this.filterType_);
            }
            if (this.filterTypeCase_ == 2) {
                codedOutputStream.writeMessage(2, (FieldFilter) this.filterType_);
            }
            if (this.filterTypeCase_ == 3) {
                codedOutputStream.writeMessage(3, (UnaryFilter) this.filterType_);
            }
        }
    }

    /* loaded from: classes2.dex */
    public interface FilterOrBuilder extends MessageLiteOrBuilder {
        CompositeFilter getCompositeFilter();

        FieldFilter getFieldFilter();

        Filter.FilterTypeCase getFilterTypeCase();

        UnaryFilter getUnaryFilter();
    }

    /* loaded from: classes2.dex */
    public static final class Order extends GeneratedMessageLite<Order, Builder> implements OrderOrBuilder {
        private static final Order DEFAULT_INSTANCE = new Order();
        public static final int DIRECTION_FIELD_NUMBER = 2;
        public static final int FIELD_FIELD_NUMBER = 1;
        private static volatile Parser<Order> PARSER;
        private int direction_;
        private FieldReference field_;

        /* loaded from: classes2.dex */
        public static final class Builder extends GeneratedMessageLite.Builder<Order, Builder> implements OrderOrBuilder {
            private Builder() {
                super(Order.DEFAULT_INSTANCE);
            }

            /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            public Builder clearDirection() {
                a();
                ((Order) this.a).clearDirection();
                return this;
            }

            public Builder clearField() {
                a();
                ((Order) this.a).clearField();
                return this;
            }

            @Override // com.google.firestore.v1.StructuredQuery.OrderOrBuilder
            public Direction getDirection() {
                return ((Order) this.a).getDirection();
            }

            @Override // com.google.firestore.v1.StructuredQuery.OrderOrBuilder
            public int getDirectionValue() {
                return ((Order) this.a).getDirectionValue();
            }

            @Override // com.google.firestore.v1.StructuredQuery.OrderOrBuilder
            public FieldReference getField() {
                return ((Order) this.a).getField();
            }

            @Override // com.google.firestore.v1.StructuredQuery.OrderOrBuilder
            public boolean hasField() {
                return ((Order) this.a).hasField();
            }

            public Builder mergeField(FieldReference fieldReference) {
                a();
                ((Order) this.a).mergeField(fieldReference);
                return this;
            }

            public Builder setDirection(Direction direction) {
                a();
                ((Order) this.a).setDirection(direction);
                return this;
            }

            public Builder setDirectionValue(int i) {
                a();
                ((Order) this.a).setDirectionValue(i);
                return this;
            }

            public Builder setField(FieldReference.Builder builder) {
                a();
                ((Order) this.a).setField(builder);
                return this;
            }

            public Builder setField(FieldReference fieldReference) {
                a();
                ((Order) this.a).setField(fieldReference);
                return this;
            }
        }

        static {
            DEFAULT_INSTANCE.b();
        }

        private Order() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearDirection() {
            this.direction_ = 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearField() {
            this.field_ = null;
        }

        public static Order getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void mergeField(FieldReference fieldReference) {
            FieldReference fieldReference2 = this.field_;
            if (fieldReference2 != null && fieldReference2 != FieldReference.getDefaultInstance()) {
                fieldReference = FieldReference.newBuilder(this.field_).mergeFrom((FieldReference.Builder) fieldReference).buildPartial();
            }
            this.field_ = fieldReference;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(Order order) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom((Builder) order);
        }

        public static Order parseDelimitedFrom(InputStream inputStream) {
            return (Order) GeneratedMessageLite.a(DEFAULT_INSTANCE, inputStream);
        }

        public static Order parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (Order) GeneratedMessageLite.a(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static Order parseFrom(ByteString byteString) {
            return (Order) GeneratedMessageLite.a(DEFAULT_INSTANCE, byteString);
        }

        public static Order parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
            return (Order) GeneratedMessageLite.a(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static Order parseFrom(CodedInputStream codedInputStream) {
            return (Order) GeneratedMessageLite.a(DEFAULT_INSTANCE, codedInputStream);
        }

        public static Order parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (Order) GeneratedMessageLite.a(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        public static Order parseFrom(InputStream inputStream) {
            return (Order) GeneratedMessageLite.b(DEFAULT_INSTANCE, inputStream);
        }

        public static Order parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (Order) GeneratedMessageLite.b(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static Order parseFrom(byte[] bArr) {
            return (Order) GeneratedMessageLite.a(DEFAULT_INSTANCE, bArr);
        }

        public static Order parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
            return (Order) GeneratedMessageLite.a(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static Parser<Order> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setDirection(Direction direction) {
            if (direction == null) {
                throw new NullPointerException();
            }
            this.direction_ = direction.getNumber();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setDirectionValue(int i) {
            this.direction_ = i;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setField(FieldReference.Builder builder) {
            this.field_ = builder.build();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setField(FieldReference fieldReference) {
            if (fieldReference == null) {
                throw new NullPointerException();
            }
            this.field_ = fieldReference;
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        protected final Object a(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            AnonymousClass1 anonymousClass1 = null;
            switch (AnonymousClass1.a[methodToInvoke.ordinal()]) {
                case 1:
                    return new Order();
                case 2:
                    return DEFAULT_INSTANCE;
                case 3:
                    return null;
                case 4:
                    return new Builder(anonymousClass1);
                case 5:
                    GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                    Order order = (Order) obj2;
                    this.field_ = (FieldReference) visitor.visitMessage(this.field_, order.field_);
                    this.direction_ = visitor.visitInt(this.direction_ != 0, this.direction_, order.direction_ != 0, order.direction_);
                    GeneratedMessageLite.MergeFromVisitor mergeFromVisitor = GeneratedMessageLite.MergeFromVisitor.INSTANCE;
                    return this;
                case 6:
                    CodedInputStream codedInputStream = (CodedInputStream) obj;
                    ExtensionRegistryLite extensionRegistryLite = (ExtensionRegistryLite) obj2;
                    while (!r0) {
                        try {
                            int readTag = codedInputStream.readTag();
                            if (readTag != 0) {
                                if (readTag == 10) {
                                    FieldReference.Builder builder = this.field_ != null ? this.field_.toBuilder() : null;
                                    this.field_ = (FieldReference) codedInputStream.readMessage(FieldReference.parser(), extensionRegistryLite);
                                    if (builder != null) {
                                        builder.mergeFrom((FieldReference.Builder) this.field_);
                                        this.field_ = builder.buildPartial();
                                    }
                                } else if (readTag == 16) {
                                    this.direction_ = codedInputStream.readEnum();
                                } else if (!codedInputStream.skipField(readTag)) {
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
                        synchronized (Order.class) {
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

        @Override // com.google.firestore.v1.StructuredQuery.OrderOrBuilder
        public Direction getDirection() {
            Direction forNumber = Direction.forNumber(this.direction_);
            return forNumber == null ? Direction.UNRECOGNIZED : forNumber;
        }

        @Override // com.google.firestore.v1.StructuredQuery.OrderOrBuilder
        public int getDirectionValue() {
            return this.direction_;
        }

        @Override // com.google.firestore.v1.StructuredQuery.OrderOrBuilder
        public FieldReference getField() {
            FieldReference fieldReference = this.field_;
            return fieldReference == null ? FieldReference.getDefaultInstance() : fieldReference;
        }

        @Override // com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i = this.c;
            if (i != -1) {
                return i;
            }
            int computeMessageSize = this.field_ != null ? 0 + CodedOutputStream.computeMessageSize(1, getField()) : 0;
            if (this.direction_ != Direction.DIRECTION_UNSPECIFIED.getNumber()) {
                computeMessageSize += CodedOutputStream.computeEnumSize(2, this.direction_);
            }
            this.c = computeMessageSize;
            return computeMessageSize;
        }

        @Override // com.google.firestore.v1.StructuredQuery.OrderOrBuilder
        public boolean hasField() {
            return this.field_ != null;
        }

        @Override // com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) {
            if (this.field_ != null) {
                codedOutputStream.writeMessage(1, getField());
            }
            if (this.direction_ != Direction.DIRECTION_UNSPECIFIED.getNumber()) {
                codedOutputStream.writeEnum(2, this.direction_);
            }
        }
    }

    /* loaded from: classes2.dex */
    public interface OrderOrBuilder extends MessageLiteOrBuilder {
        Direction getDirection();

        int getDirectionValue();

        FieldReference getField();

        boolean hasField();
    }

    /* loaded from: classes2.dex */
    public static final class Projection extends GeneratedMessageLite<Projection, Builder> implements ProjectionOrBuilder {
        private static final Projection DEFAULT_INSTANCE = new Projection();
        public static final int FIELDS_FIELD_NUMBER = 2;
        private static volatile Parser<Projection> PARSER;
        private Internal.ProtobufList<FieldReference> fields_ = GeneratedMessageLite.f();

        /* loaded from: classes2.dex */
        public static final class Builder extends GeneratedMessageLite.Builder<Projection, Builder> implements ProjectionOrBuilder {
            private Builder() {
                super(Projection.DEFAULT_INSTANCE);
            }

            /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            public Builder addAllFields(Iterable<? extends FieldReference> iterable) {
                a();
                ((Projection) this.a).addAllFields(iterable);
                return this;
            }

            public Builder addFields(int i, FieldReference.Builder builder) {
                a();
                ((Projection) this.a).addFields(i, builder);
                return this;
            }

            public Builder addFields(int i, FieldReference fieldReference) {
                a();
                ((Projection) this.a).addFields(i, fieldReference);
                return this;
            }

            public Builder addFields(FieldReference.Builder builder) {
                a();
                ((Projection) this.a).addFields(builder);
                return this;
            }

            public Builder addFields(FieldReference fieldReference) {
                a();
                ((Projection) this.a).addFields(fieldReference);
                return this;
            }

            public Builder clearFields() {
                a();
                ((Projection) this.a).clearFields();
                return this;
            }

            @Override // com.google.firestore.v1.StructuredQuery.ProjectionOrBuilder
            public FieldReference getFields(int i) {
                return ((Projection) this.a).getFields(i);
            }

            @Override // com.google.firestore.v1.StructuredQuery.ProjectionOrBuilder
            public int getFieldsCount() {
                return ((Projection) this.a).getFieldsCount();
            }

            @Override // com.google.firestore.v1.StructuredQuery.ProjectionOrBuilder
            public List<FieldReference> getFieldsList() {
                return Collections.unmodifiableList(((Projection) this.a).getFieldsList());
            }

            public Builder removeFields(int i) {
                a();
                ((Projection) this.a).removeFields(i);
                return this;
            }

            public Builder setFields(int i, FieldReference.Builder builder) {
                a();
                ((Projection) this.a).setFields(i, builder);
                return this;
            }

            public Builder setFields(int i, FieldReference fieldReference) {
                a();
                ((Projection) this.a).setFields(i, fieldReference);
                return this;
            }
        }

        static {
            DEFAULT_INSTANCE.b();
        }

        private Projection() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addAllFields(Iterable<? extends FieldReference> iterable) {
            ensureFieldsIsMutable();
            AbstractMessageLite.a(iterable, this.fields_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addFields(int i, FieldReference.Builder builder) {
            ensureFieldsIsMutable();
            this.fields_.add(i, builder.build());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addFields(int i, FieldReference fieldReference) {
            if (fieldReference == null) {
                throw new NullPointerException();
            }
            ensureFieldsIsMutable();
            this.fields_.add(i, fieldReference);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addFields(FieldReference.Builder builder) {
            ensureFieldsIsMutable();
            this.fields_.add(builder.build());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addFields(FieldReference fieldReference) {
            if (fieldReference == null) {
                throw new NullPointerException();
            }
            ensureFieldsIsMutable();
            this.fields_.add(fieldReference);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearFields() {
            this.fields_ = GeneratedMessageLite.f();
        }

        private void ensureFieldsIsMutable() {
            if (this.fields_.isModifiable()) {
                return;
            }
            this.fields_ = GeneratedMessageLite.a(this.fields_);
        }

        public static Projection getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(Projection projection) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom((Builder) projection);
        }

        public static Projection parseDelimitedFrom(InputStream inputStream) {
            return (Projection) GeneratedMessageLite.a(DEFAULT_INSTANCE, inputStream);
        }

        public static Projection parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (Projection) GeneratedMessageLite.a(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static Projection parseFrom(ByteString byteString) {
            return (Projection) GeneratedMessageLite.a(DEFAULT_INSTANCE, byteString);
        }

        public static Projection parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
            return (Projection) GeneratedMessageLite.a(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static Projection parseFrom(CodedInputStream codedInputStream) {
            return (Projection) GeneratedMessageLite.a(DEFAULT_INSTANCE, codedInputStream);
        }

        public static Projection parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (Projection) GeneratedMessageLite.a(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        public static Projection parseFrom(InputStream inputStream) {
            return (Projection) GeneratedMessageLite.b(DEFAULT_INSTANCE, inputStream);
        }

        public static Projection parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (Projection) GeneratedMessageLite.b(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static Projection parseFrom(byte[] bArr) {
            return (Projection) GeneratedMessageLite.a(DEFAULT_INSTANCE, bArr);
        }

        public static Projection parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
            return (Projection) GeneratedMessageLite.a(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static Parser<Projection> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void removeFields(int i) {
            ensureFieldsIsMutable();
            this.fields_.remove(i);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setFields(int i, FieldReference.Builder builder) {
            ensureFieldsIsMutable();
            this.fields_.set(i, builder.build());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setFields(int i, FieldReference fieldReference) {
            if (fieldReference == null) {
                throw new NullPointerException();
            }
            ensureFieldsIsMutable();
            this.fields_.set(i, fieldReference);
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        protected final Object a(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            AnonymousClass1 anonymousClass1 = null;
            switch (AnonymousClass1.a[methodToInvoke.ordinal()]) {
                case 1:
                    return new Projection();
                case 2:
                    return DEFAULT_INSTANCE;
                case 3:
                    this.fields_.makeImmutable();
                    return null;
                case 4:
                    return new Builder(anonymousClass1);
                case 5:
                    this.fields_ = ((GeneratedMessageLite.Visitor) obj).visitList(this.fields_, ((Projection) obj2).fields_);
                    GeneratedMessageLite.MergeFromVisitor mergeFromVisitor = GeneratedMessageLite.MergeFromVisitor.INSTANCE;
                    return this;
                case 6:
                    CodedInputStream codedInputStream = (CodedInputStream) obj;
                    ExtensionRegistryLite extensionRegistryLite = (ExtensionRegistryLite) obj2;
                    boolean z = false;
                    while (!z) {
                        try {
                            try {
                                int readTag = codedInputStream.readTag();
                                if (readTag != 0) {
                                    if (readTag == 18) {
                                        if (!this.fields_.isModifiable()) {
                                            this.fields_ = GeneratedMessageLite.a(this.fields_);
                                        }
                                        this.fields_.add((FieldReference) codedInputStream.readMessage(FieldReference.parser(), extensionRegistryLite));
                                    } else if (!codedInputStream.skipField(readTag)) {
                                    }
                                }
                                z = true;
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
                        synchronized (Projection.class) {
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

        @Override // com.google.firestore.v1.StructuredQuery.ProjectionOrBuilder
        public FieldReference getFields(int i) {
            return this.fields_.get(i);
        }

        @Override // com.google.firestore.v1.StructuredQuery.ProjectionOrBuilder
        public int getFieldsCount() {
            return this.fields_.size();
        }

        @Override // com.google.firestore.v1.StructuredQuery.ProjectionOrBuilder
        public List<FieldReference> getFieldsList() {
            return this.fields_;
        }

        public FieldReferenceOrBuilder getFieldsOrBuilder(int i) {
            return this.fields_.get(i);
        }

        public List<? extends FieldReferenceOrBuilder> getFieldsOrBuilderList() {
            return this.fields_;
        }

        @Override // com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i = this.c;
            if (i != -1) {
                return i;
            }
            int i2 = 0;
            for (int i3 = 0; i3 < this.fields_.size(); i3++) {
                i2 += CodedOutputStream.computeMessageSize(2, this.fields_.get(i3));
            }
            this.c = i2;
            return i2;
        }

        @Override // com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) {
            for (int i = 0; i < this.fields_.size(); i++) {
                codedOutputStream.writeMessage(2, this.fields_.get(i));
            }
        }
    }

    /* loaded from: classes2.dex */
    public interface ProjectionOrBuilder extends MessageLiteOrBuilder {
        FieldReference getFields(int i);

        int getFieldsCount();

        List<FieldReference> getFieldsList();
    }

    /* loaded from: classes2.dex */
    public static final class UnaryFilter extends GeneratedMessageLite<UnaryFilter, Builder> implements UnaryFilterOrBuilder {
        private static final UnaryFilter DEFAULT_INSTANCE = new UnaryFilter();
        public static final int FIELD_FIELD_NUMBER = 2;
        public static final int OP_FIELD_NUMBER = 1;
        private static volatile Parser<UnaryFilter> PARSER;
        private int op_;
        private int operandTypeCase_ = 0;
        private Object operandType_;

        /* loaded from: classes2.dex */
        public static final class Builder extends GeneratedMessageLite.Builder<UnaryFilter, Builder> implements UnaryFilterOrBuilder {
            private Builder() {
                super(UnaryFilter.DEFAULT_INSTANCE);
            }

            /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            public Builder clearField() {
                a();
                ((UnaryFilter) this.a).clearField();
                return this;
            }

            public Builder clearOp() {
                a();
                ((UnaryFilter) this.a).clearOp();
                return this;
            }

            public Builder clearOperandType() {
                a();
                ((UnaryFilter) this.a).clearOperandType();
                return this;
            }

            @Override // com.google.firestore.v1.StructuredQuery.UnaryFilterOrBuilder
            public FieldReference getField() {
                return ((UnaryFilter) this.a).getField();
            }

            @Override // com.google.firestore.v1.StructuredQuery.UnaryFilterOrBuilder
            public Operator getOp() {
                return ((UnaryFilter) this.a).getOp();
            }

            @Override // com.google.firestore.v1.StructuredQuery.UnaryFilterOrBuilder
            public int getOpValue() {
                return ((UnaryFilter) this.a).getOpValue();
            }

            @Override // com.google.firestore.v1.StructuredQuery.UnaryFilterOrBuilder
            public OperandTypeCase getOperandTypeCase() {
                return ((UnaryFilter) this.a).getOperandTypeCase();
            }

            public Builder mergeField(FieldReference fieldReference) {
                a();
                ((UnaryFilter) this.a).mergeField(fieldReference);
                return this;
            }

            public Builder setField(FieldReference.Builder builder) {
                a();
                ((UnaryFilter) this.a).setField(builder);
                return this;
            }

            public Builder setField(FieldReference fieldReference) {
                a();
                ((UnaryFilter) this.a).setField(fieldReference);
                return this;
            }

            public Builder setOp(Operator operator) {
                a();
                ((UnaryFilter) this.a).setOp(operator);
                return this;
            }

            public Builder setOpValue(int i) {
                a();
                ((UnaryFilter) this.a).setOpValue(i);
                return this;
            }
        }

        /* loaded from: classes2.dex */
        public enum OperandTypeCase implements Internal.EnumLite {
            FIELD(2),
            OPERANDTYPE_NOT_SET(0);

            private final int value;

            OperandTypeCase(int i) {
                this.value = i;
            }

            public static OperandTypeCase forNumber(int i) {
                if (i == 0) {
                    return OPERANDTYPE_NOT_SET;
                }
                if (i != 2) {
                    return null;
                }
                return FIELD;
            }

            @Deprecated
            public static OperandTypeCase valueOf(int i) {
                return forNumber(i);
            }

            @Override // com.google.protobuf.Internal.EnumLite
            public int getNumber() {
                return this.value;
            }
        }

        /* loaded from: classes2.dex */
        public enum Operator implements Internal.EnumLite {
            OPERATOR_UNSPECIFIED(0),
            IS_NAN(2),
            IS_NULL(3),
            UNRECOGNIZED(-1);

            public static final int IS_NAN_VALUE = 2;
            public static final int IS_NULL_VALUE = 3;
            public static final int OPERATOR_UNSPECIFIED_VALUE = 0;
            private static final Internal.EnumLiteMap<Operator> internalValueMap = new Internal.EnumLiteMap<Operator>() { // from class: com.google.firestore.v1.StructuredQuery.UnaryFilter.Operator.1
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // com.google.protobuf.Internal.EnumLiteMap
                public Operator findValueByNumber(int i) {
                    return Operator.forNumber(i);
                }
            };
            private final int value;

            Operator(int i) {
                this.value = i;
            }

            public static Operator forNumber(int i) {
                if (i == 0) {
                    return OPERATOR_UNSPECIFIED;
                }
                if (i == 2) {
                    return IS_NAN;
                }
                if (i != 3) {
                    return null;
                }
                return IS_NULL;
            }

            public static Internal.EnumLiteMap<Operator> internalGetValueMap() {
                return internalValueMap;
            }

            @Deprecated
            public static Operator valueOf(int i) {
                return forNumber(i);
            }

            @Override // com.google.protobuf.Internal.EnumLite
            public final int getNumber() {
                return this.value;
            }
        }

        static {
            DEFAULT_INSTANCE.b();
        }

        private UnaryFilter() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearField() {
            if (this.operandTypeCase_ == 2) {
                this.operandTypeCase_ = 0;
                this.operandType_ = null;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearOp() {
            this.op_ = 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearOperandType() {
            this.operandTypeCase_ = 0;
            this.operandType_ = null;
        }

        public static UnaryFilter getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void mergeField(FieldReference fieldReference) {
            if (this.operandTypeCase_ == 2 && this.operandType_ != FieldReference.getDefaultInstance()) {
                fieldReference = FieldReference.newBuilder((FieldReference) this.operandType_).mergeFrom((FieldReference.Builder) fieldReference).buildPartial();
            }
            this.operandType_ = fieldReference;
            this.operandTypeCase_ = 2;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(UnaryFilter unaryFilter) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom((Builder) unaryFilter);
        }

        public static UnaryFilter parseDelimitedFrom(InputStream inputStream) {
            return (UnaryFilter) GeneratedMessageLite.a(DEFAULT_INSTANCE, inputStream);
        }

        public static UnaryFilter parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (UnaryFilter) GeneratedMessageLite.a(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static UnaryFilter parseFrom(ByteString byteString) {
            return (UnaryFilter) GeneratedMessageLite.a(DEFAULT_INSTANCE, byteString);
        }

        public static UnaryFilter parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
            return (UnaryFilter) GeneratedMessageLite.a(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static UnaryFilter parseFrom(CodedInputStream codedInputStream) {
            return (UnaryFilter) GeneratedMessageLite.a(DEFAULT_INSTANCE, codedInputStream);
        }

        public static UnaryFilter parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (UnaryFilter) GeneratedMessageLite.a(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        public static UnaryFilter parseFrom(InputStream inputStream) {
            return (UnaryFilter) GeneratedMessageLite.b(DEFAULT_INSTANCE, inputStream);
        }

        public static UnaryFilter parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (UnaryFilter) GeneratedMessageLite.b(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static UnaryFilter parseFrom(byte[] bArr) {
            return (UnaryFilter) GeneratedMessageLite.a(DEFAULT_INSTANCE, bArr);
        }

        public static UnaryFilter parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
            return (UnaryFilter) GeneratedMessageLite.a(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static Parser<UnaryFilter> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setField(FieldReference.Builder builder) {
            this.operandType_ = builder.build();
            this.operandTypeCase_ = 2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setField(FieldReference fieldReference) {
            if (fieldReference == null) {
                throw new NullPointerException();
            }
            this.operandType_ = fieldReference;
            this.operandTypeCase_ = 2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setOp(Operator operator) {
            if (operator == null) {
                throw new NullPointerException();
            }
            this.op_ = operator.getNumber();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setOpValue(int i) {
            this.op_ = i;
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        protected final Object a(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            int i;
            AnonymousClass1 anonymousClass1 = null;
            switch (AnonymousClass1.a[methodToInvoke.ordinal()]) {
                case 1:
                    return new UnaryFilter();
                case 2:
                    return DEFAULT_INSTANCE;
                case 3:
                    return null;
                case 4:
                    return new Builder(anonymousClass1);
                case 5:
                    GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                    UnaryFilter unaryFilter = (UnaryFilter) obj2;
                    this.op_ = visitor.visitInt(this.op_ != 0, this.op_, unaryFilter.op_ != 0, unaryFilter.op_);
                    int i2 = AnonymousClass1.c[unaryFilter.getOperandTypeCase().ordinal()];
                    if (i2 == 1) {
                        this.operandType_ = visitor.visitOneofMessage(this.operandTypeCase_ == 2, this.operandType_, unaryFilter.operandType_);
                    } else if (i2 == 2) {
                        visitor.visitOneofNotSet(this.operandTypeCase_ != 0);
                    }
                    if (visitor == GeneratedMessageLite.MergeFromVisitor.INSTANCE && (i = unaryFilter.operandTypeCase_) != 0) {
                        this.operandTypeCase_ = i;
                    }
                    return this;
                case 6:
                    CodedInputStream codedInputStream = (CodedInputStream) obj;
                    ExtensionRegistryLite extensionRegistryLite = (ExtensionRegistryLite) obj2;
                    while (!r2) {
                        try {
                            try {
                                int readTag = codedInputStream.readTag();
                                if (readTag != 0) {
                                    if (readTag == 8) {
                                        this.op_ = codedInputStream.readEnum();
                                    } else if (readTag == 18) {
                                        FieldReference.Builder builder = this.operandTypeCase_ == 2 ? ((FieldReference) this.operandType_).toBuilder() : null;
                                        this.operandType_ = codedInputStream.readMessage(FieldReference.parser(), extensionRegistryLite);
                                        if (builder != null) {
                                            builder.mergeFrom((FieldReference.Builder) this.operandType_);
                                            this.operandType_ = builder.buildPartial();
                                        }
                                        this.operandTypeCase_ = 2;
                                    } else if (!codedInputStream.skipField(readTag)) {
                                    }
                                }
                                r2 = true;
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
                        synchronized (UnaryFilter.class) {
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

        @Override // com.google.firestore.v1.StructuredQuery.UnaryFilterOrBuilder
        public FieldReference getField() {
            return this.operandTypeCase_ == 2 ? (FieldReference) this.operandType_ : FieldReference.getDefaultInstance();
        }

        @Override // com.google.firestore.v1.StructuredQuery.UnaryFilterOrBuilder
        public Operator getOp() {
            Operator forNumber = Operator.forNumber(this.op_);
            return forNumber == null ? Operator.UNRECOGNIZED : forNumber;
        }

        @Override // com.google.firestore.v1.StructuredQuery.UnaryFilterOrBuilder
        public int getOpValue() {
            return this.op_;
        }

        @Override // com.google.firestore.v1.StructuredQuery.UnaryFilterOrBuilder
        public OperandTypeCase getOperandTypeCase() {
            return OperandTypeCase.forNumber(this.operandTypeCase_);
        }

        @Override // com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i = this.c;
            if (i != -1) {
                return i;
            }
            int computeEnumSize = this.op_ != Operator.OPERATOR_UNSPECIFIED.getNumber() ? 0 + CodedOutputStream.computeEnumSize(1, this.op_) : 0;
            if (this.operandTypeCase_ == 2) {
                computeEnumSize += CodedOutputStream.computeMessageSize(2, (FieldReference) this.operandType_);
            }
            this.c = computeEnumSize;
            return computeEnumSize;
        }

        @Override // com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) {
            if (this.op_ != Operator.OPERATOR_UNSPECIFIED.getNumber()) {
                codedOutputStream.writeEnum(1, this.op_);
            }
            if (this.operandTypeCase_ == 2) {
                codedOutputStream.writeMessage(2, (FieldReference) this.operandType_);
            }
        }
    }

    /* loaded from: classes2.dex */
    public interface UnaryFilterOrBuilder extends MessageLiteOrBuilder {
        FieldReference getField();

        UnaryFilter.Operator getOp();

        int getOpValue();

        UnaryFilter.OperandTypeCase getOperandTypeCase();
    }

    static {
        DEFAULT_INSTANCE.b();
    }

    private StructuredQuery() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllFrom(Iterable<? extends CollectionSelector> iterable) {
        ensureFromIsMutable();
        AbstractMessageLite.a(iterable, this.from_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllOrderBy(Iterable<? extends Order> iterable) {
        ensureOrderByIsMutable();
        AbstractMessageLite.a(iterable, this.orderBy_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addFrom(int i, CollectionSelector.Builder builder) {
        ensureFromIsMutable();
        this.from_.add(i, builder.build());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addFrom(int i, CollectionSelector collectionSelector) {
        if (collectionSelector == null) {
            throw new NullPointerException();
        }
        ensureFromIsMutable();
        this.from_.add(i, collectionSelector);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addFrom(CollectionSelector.Builder builder) {
        ensureFromIsMutable();
        this.from_.add(builder.build());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addFrom(CollectionSelector collectionSelector) {
        if (collectionSelector == null) {
            throw new NullPointerException();
        }
        ensureFromIsMutable();
        this.from_.add(collectionSelector);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addOrderBy(int i, Order.Builder builder) {
        ensureOrderByIsMutable();
        this.orderBy_.add(i, builder.build());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addOrderBy(int i, Order order) {
        if (order == null) {
            throw new NullPointerException();
        }
        ensureOrderByIsMutable();
        this.orderBy_.add(i, order);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addOrderBy(Order.Builder builder) {
        ensureOrderByIsMutable();
        this.orderBy_.add(builder.build());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addOrderBy(Order order) {
        if (order == null) {
            throw new NullPointerException();
        }
        ensureOrderByIsMutable();
        this.orderBy_.add(order);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearEndAt() {
        this.endAt_ = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearFrom() {
        this.from_ = GeneratedMessageLite.f();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearLimit() {
        this.limit_ = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearOffset() {
        this.offset_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearOrderBy() {
        this.orderBy_ = GeneratedMessageLite.f();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearSelect() {
        this.select_ = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearStartAt() {
        this.startAt_ = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearWhere() {
        this.where_ = null;
    }

    private void ensureFromIsMutable() {
        if (this.from_.isModifiable()) {
            return;
        }
        this.from_ = GeneratedMessageLite.a(this.from_);
    }

    private void ensureOrderByIsMutable() {
        if (this.orderBy_.isModifiable()) {
            return;
        }
        this.orderBy_ = GeneratedMessageLite.a(this.orderBy_);
    }

    public static StructuredQuery getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeEndAt(Cursor cursor) {
        Cursor cursor2 = this.endAt_;
        if (cursor2 != null && cursor2 != Cursor.getDefaultInstance()) {
            cursor = Cursor.newBuilder(this.endAt_).mergeFrom((Cursor.Builder) cursor).buildPartial();
        }
        this.endAt_ = cursor;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeLimit(Int32Value int32Value) {
        Int32Value int32Value2 = this.limit_;
        if (int32Value2 != null && int32Value2 != Int32Value.getDefaultInstance()) {
            int32Value = Int32Value.newBuilder(this.limit_).mergeFrom((Int32Value.Builder) int32Value).buildPartial();
        }
        this.limit_ = int32Value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeSelect(Projection projection) {
        Projection projection2 = this.select_;
        if (projection2 != null && projection2 != Projection.getDefaultInstance()) {
            projection = Projection.newBuilder(this.select_).mergeFrom((Projection.Builder) projection).buildPartial();
        }
        this.select_ = projection;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeStartAt(Cursor cursor) {
        Cursor cursor2 = this.startAt_;
        if (cursor2 != null && cursor2 != Cursor.getDefaultInstance()) {
            cursor = Cursor.newBuilder(this.startAt_).mergeFrom((Cursor.Builder) cursor).buildPartial();
        }
        this.startAt_ = cursor;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeWhere(Filter filter) {
        Filter filter2 = this.where_;
        if (filter2 != null && filter2 != Filter.getDefaultInstance()) {
            filter = Filter.newBuilder(this.where_).mergeFrom((Filter.Builder) filter).buildPartial();
        }
        this.where_ = filter;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static Builder newBuilder(StructuredQuery structuredQuery) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom((Builder) structuredQuery);
    }

    public static StructuredQuery parseDelimitedFrom(InputStream inputStream) {
        return (StructuredQuery) GeneratedMessageLite.a(DEFAULT_INSTANCE, inputStream);
    }

    public static StructuredQuery parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (StructuredQuery) GeneratedMessageLite.a(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static StructuredQuery parseFrom(ByteString byteString) {
        return (StructuredQuery) GeneratedMessageLite.a(DEFAULT_INSTANCE, byteString);
    }

    public static StructuredQuery parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (StructuredQuery) GeneratedMessageLite.a(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static StructuredQuery parseFrom(CodedInputStream codedInputStream) {
        return (StructuredQuery) GeneratedMessageLite.a(DEFAULT_INSTANCE, codedInputStream);
    }

    public static StructuredQuery parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (StructuredQuery) GeneratedMessageLite.a(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }

    public static StructuredQuery parseFrom(InputStream inputStream) {
        return (StructuredQuery) GeneratedMessageLite.b(DEFAULT_INSTANCE, inputStream);
    }

    public static StructuredQuery parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (StructuredQuery) GeneratedMessageLite.b(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static StructuredQuery parseFrom(byte[] bArr) {
        return (StructuredQuery) GeneratedMessageLite.a(DEFAULT_INSTANCE, bArr);
    }

    public static StructuredQuery parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (StructuredQuery) GeneratedMessageLite.a(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static Parser<StructuredQuery> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeFrom(int i) {
        ensureFromIsMutable();
        this.from_.remove(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeOrderBy(int i) {
        ensureOrderByIsMutable();
        this.orderBy_.remove(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setEndAt(Cursor.Builder builder) {
        this.endAt_ = builder.build();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setEndAt(Cursor cursor) {
        if (cursor == null) {
            throw new NullPointerException();
        }
        this.endAt_ = cursor;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setFrom(int i, CollectionSelector.Builder builder) {
        ensureFromIsMutable();
        this.from_.set(i, builder.build());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setFrom(int i, CollectionSelector collectionSelector) {
        if (collectionSelector == null) {
            throw new NullPointerException();
        }
        ensureFromIsMutable();
        this.from_.set(i, collectionSelector);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setLimit(Int32Value.Builder builder) {
        this.limit_ = builder.build();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setLimit(Int32Value int32Value) {
        if (int32Value == null) {
            throw new NullPointerException();
        }
        this.limit_ = int32Value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setOffset(int i) {
        this.offset_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setOrderBy(int i, Order.Builder builder) {
        ensureOrderByIsMutable();
        this.orderBy_.set(i, builder.build());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setOrderBy(int i, Order order) {
        if (order == null) {
            throw new NullPointerException();
        }
        ensureOrderByIsMutable();
        this.orderBy_.set(i, order);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSelect(Projection.Builder builder) {
        this.select_ = builder.build();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSelect(Projection projection) {
        if (projection == null) {
            throw new NullPointerException();
        }
        this.select_ = projection;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setStartAt(Cursor.Builder builder) {
        this.startAt_ = builder.build();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setStartAt(Cursor cursor) {
        if (cursor == null) {
            throw new NullPointerException();
        }
        this.startAt_ = cursor;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setWhere(Filter.Builder builder) {
        this.where_ = builder.build();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setWhere(Filter filter) {
        if (filter == null) {
            throw new NullPointerException();
        }
        this.where_ = filter;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object a(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        List list;
        MessageLite messageLite;
        AnonymousClass1 anonymousClass1 = null;
        switch (AnonymousClass1.a[methodToInvoke.ordinal()]) {
            case 1:
                return new StructuredQuery();
            case 2:
                return DEFAULT_INSTANCE;
            case 3:
                this.from_.makeImmutable();
                this.orderBy_.makeImmutable();
                return null;
            case 4:
                return new Builder(anonymousClass1);
            case 5:
                GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                StructuredQuery structuredQuery = (StructuredQuery) obj2;
                this.select_ = (Projection) visitor.visitMessage(this.select_, structuredQuery.select_);
                this.from_ = visitor.visitList(this.from_, structuredQuery.from_);
                this.where_ = (Filter) visitor.visitMessage(this.where_, structuredQuery.where_);
                this.orderBy_ = visitor.visitList(this.orderBy_, structuredQuery.orderBy_);
                this.startAt_ = (Cursor) visitor.visitMessage(this.startAt_, structuredQuery.startAt_);
                this.endAt_ = (Cursor) visitor.visitMessage(this.endAt_, structuredQuery.endAt_);
                this.offset_ = visitor.visitInt(this.offset_ != 0, this.offset_, structuredQuery.offset_ != 0, structuredQuery.offset_);
                this.limit_ = (Int32Value) visitor.visitMessage(this.limit_, structuredQuery.limit_);
                if (visitor == GeneratedMessageLite.MergeFromVisitor.INSTANCE) {
                    this.bitField0_ |= structuredQuery.bitField0_;
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
                                if (readTag != 10) {
                                    if (readTag == 18) {
                                        if (!this.from_.isModifiable()) {
                                            this.from_ = GeneratedMessageLite.a(this.from_);
                                        }
                                        list = this.from_;
                                        messageLite = (CollectionSelector) codedInputStream.readMessage(CollectionSelector.parser(), extensionRegistryLite);
                                    } else if (readTag == 26) {
                                        Filter.Builder builder = this.where_ != null ? this.where_.toBuilder() : null;
                                        this.where_ = (Filter) codedInputStream.readMessage(Filter.parser(), extensionRegistryLite);
                                        if (builder != null) {
                                            builder.mergeFrom((Filter.Builder) this.where_);
                                            this.where_ = builder.buildPartial();
                                        }
                                    } else if (readTag == 34) {
                                        if (!this.orderBy_.isModifiable()) {
                                            this.orderBy_ = GeneratedMessageLite.a(this.orderBy_);
                                        }
                                        list = this.orderBy_;
                                        messageLite = (Order) codedInputStream.readMessage(Order.parser(), extensionRegistryLite);
                                    } else if (readTag == 42) {
                                        Int32Value.Builder builder2 = this.limit_ != null ? this.limit_.toBuilder() : null;
                                        this.limit_ = (Int32Value) codedInputStream.readMessage(Int32Value.parser(), extensionRegistryLite);
                                        if (builder2 != null) {
                                            builder2.mergeFrom((Int32Value.Builder) this.limit_);
                                            this.limit_ = builder2.buildPartial();
                                        }
                                    } else if (readTag == 48) {
                                        this.offset_ = codedInputStream.readInt32();
                                    } else if (readTag == 58) {
                                        Cursor.Builder builder3 = this.startAt_ != null ? this.startAt_.toBuilder() : null;
                                        this.startAt_ = (Cursor) codedInputStream.readMessage(Cursor.parser(), extensionRegistryLite);
                                        if (builder3 != null) {
                                            builder3.mergeFrom((Cursor.Builder) this.startAt_);
                                            this.startAt_ = builder3.buildPartial();
                                        }
                                    } else if (readTag == 66) {
                                        Cursor.Builder builder4 = this.endAt_ != null ? this.endAt_.toBuilder() : null;
                                        this.endAt_ = (Cursor) codedInputStream.readMessage(Cursor.parser(), extensionRegistryLite);
                                        if (builder4 != null) {
                                            builder4.mergeFrom((Cursor.Builder) this.endAt_);
                                            this.endAt_ = builder4.buildPartial();
                                        }
                                    } else if (!codedInputStream.skipField(readTag)) {
                                    }
                                    list.add(messageLite);
                                } else {
                                    Projection.Builder builder5 = this.select_ != null ? this.select_.toBuilder() : null;
                                    this.select_ = (Projection) codedInputStream.readMessage(Projection.parser(), extensionRegistryLite);
                                    if (builder5 != null) {
                                        builder5.mergeFrom((Projection.Builder) this.select_);
                                        this.select_ = builder5.buildPartial();
                                    }
                                }
                            }
                            r0 = true;
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
                    synchronized (StructuredQuery.class) {
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

    @Override // com.google.firestore.v1.StructuredQueryOrBuilder
    public Cursor getEndAt() {
        Cursor cursor = this.endAt_;
        return cursor == null ? Cursor.getDefaultInstance() : cursor;
    }

    @Override // com.google.firestore.v1.StructuredQueryOrBuilder
    public CollectionSelector getFrom(int i) {
        return this.from_.get(i);
    }

    @Override // com.google.firestore.v1.StructuredQueryOrBuilder
    public int getFromCount() {
        return this.from_.size();
    }

    @Override // com.google.firestore.v1.StructuredQueryOrBuilder
    public List<CollectionSelector> getFromList() {
        return this.from_;
    }

    public CollectionSelectorOrBuilder getFromOrBuilder(int i) {
        return this.from_.get(i);
    }

    public List<? extends CollectionSelectorOrBuilder> getFromOrBuilderList() {
        return this.from_;
    }

    @Override // com.google.firestore.v1.StructuredQueryOrBuilder
    public Int32Value getLimit() {
        Int32Value int32Value = this.limit_;
        return int32Value == null ? Int32Value.getDefaultInstance() : int32Value;
    }

    @Override // com.google.firestore.v1.StructuredQueryOrBuilder
    public int getOffset() {
        return this.offset_;
    }

    @Override // com.google.firestore.v1.StructuredQueryOrBuilder
    public Order getOrderBy(int i) {
        return this.orderBy_.get(i);
    }

    @Override // com.google.firestore.v1.StructuredQueryOrBuilder
    public int getOrderByCount() {
        return this.orderBy_.size();
    }

    @Override // com.google.firestore.v1.StructuredQueryOrBuilder
    public List<Order> getOrderByList() {
        return this.orderBy_;
    }

    public OrderOrBuilder getOrderByOrBuilder(int i) {
        return this.orderBy_.get(i);
    }

    public List<? extends OrderOrBuilder> getOrderByOrBuilderList() {
        return this.orderBy_;
    }

    @Override // com.google.firestore.v1.StructuredQueryOrBuilder
    public Projection getSelect() {
        Projection projection = this.select_;
        return projection == null ? Projection.getDefaultInstance() : projection;
    }

    @Override // com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int i = this.c;
        if (i != -1) {
            return i;
        }
        int computeMessageSize = this.select_ != null ? CodedOutputStream.computeMessageSize(1, getSelect()) + 0 : 0;
        for (int i2 = 0; i2 < this.from_.size(); i2++) {
            computeMessageSize += CodedOutputStream.computeMessageSize(2, this.from_.get(i2));
        }
        if (this.where_ != null) {
            computeMessageSize += CodedOutputStream.computeMessageSize(3, getWhere());
        }
        for (int i3 = 0; i3 < this.orderBy_.size(); i3++) {
            computeMessageSize += CodedOutputStream.computeMessageSize(4, this.orderBy_.get(i3));
        }
        if (this.limit_ != null) {
            computeMessageSize += CodedOutputStream.computeMessageSize(5, getLimit());
        }
        int i4 = this.offset_;
        if (i4 != 0) {
            computeMessageSize += CodedOutputStream.computeInt32Size(6, i4);
        }
        if (this.startAt_ != null) {
            computeMessageSize += CodedOutputStream.computeMessageSize(7, getStartAt());
        }
        if (this.endAt_ != null) {
            computeMessageSize += CodedOutputStream.computeMessageSize(8, getEndAt());
        }
        this.c = computeMessageSize;
        return computeMessageSize;
    }

    @Override // com.google.firestore.v1.StructuredQueryOrBuilder
    public Cursor getStartAt() {
        Cursor cursor = this.startAt_;
        return cursor == null ? Cursor.getDefaultInstance() : cursor;
    }

    @Override // com.google.firestore.v1.StructuredQueryOrBuilder
    public Filter getWhere() {
        Filter filter = this.where_;
        return filter == null ? Filter.getDefaultInstance() : filter;
    }

    @Override // com.google.firestore.v1.StructuredQueryOrBuilder
    public boolean hasEndAt() {
        return this.endAt_ != null;
    }

    @Override // com.google.firestore.v1.StructuredQueryOrBuilder
    public boolean hasLimit() {
        return this.limit_ != null;
    }

    @Override // com.google.firestore.v1.StructuredQueryOrBuilder
    public boolean hasSelect() {
        return this.select_ != null;
    }

    @Override // com.google.firestore.v1.StructuredQueryOrBuilder
    public boolean hasStartAt() {
        return this.startAt_ != null;
    }

    @Override // com.google.firestore.v1.StructuredQueryOrBuilder
    public boolean hasWhere() {
        return this.where_ != null;
    }

    @Override // com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream codedOutputStream) {
        if (this.select_ != null) {
            codedOutputStream.writeMessage(1, getSelect());
        }
        for (int i = 0; i < this.from_.size(); i++) {
            codedOutputStream.writeMessage(2, this.from_.get(i));
        }
        if (this.where_ != null) {
            codedOutputStream.writeMessage(3, getWhere());
        }
        for (int i2 = 0; i2 < this.orderBy_.size(); i2++) {
            codedOutputStream.writeMessage(4, this.orderBy_.get(i2));
        }
        if (this.limit_ != null) {
            codedOutputStream.writeMessage(5, getLimit());
        }
        int i3 = this.offset_;
        if (i3 != 0) {
            codedOutputStream.writeInt32(6, i3);
        }
        if (this.startAt_ != null) {
            codedOutputStream.writeMessage(7, getStartAt());
        }
        if (this.endAt_ != null) {
            codedOutputStream.writeMessage(8, getEndAt());
        }
    }
}
