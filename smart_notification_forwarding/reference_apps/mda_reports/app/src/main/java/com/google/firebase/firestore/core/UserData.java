package com.google.firebase.firestore.core;

import androidx.annotation.Nullable;
import com.google.firebase.firestore.model.DocumentKey;
import com.google.firebase.firestore.model.FieldPath;
import com.google.firebase.firestore.model.mutation.FieldMask;
import com.google.firebase.firestore.model.mutation.FieldTransform;
import com.google.firebase.firestore.model.mutation.Mutation;
import com.google.firebase.firestore.model.mutation.PatchMutation;
import com.google.firebase.firestore.model.mutation.Precondition;
import com.google.firebase.firestore.model.mutation.SetMutation;
import com.google.firebase.firestore.model.mutation.TransformMutation;
import com.google.firebase.firestore.model.mutation.TransformOperation;
import com.google.firebase.firestore.model.value.ObjectValue;
import com.google.firebase.firestore.util.Assert;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* loaded from: classes2.dex */
public class UserData {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.google.firebase.firestore.core.UserData$1, reason: invalid class name */
    /* loaded from: classes2.dex */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] a = new int[Source.values().length];

        static {
            try {
                a[Source.Set.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[Source.MergeSet.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[Source.Update.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[Source.Argument.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[Source.ArrayArgument.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    /* loaded from: classes2.dex */
    public static class ParseAccumulator {
        private final Source dataSource;
        private final Set<FieldPath> fieldMask = new HashSet();
        private final ArrayList<FieldTransform> fieldTransforms = new ArrayList<>();

        public ParseAccumulator(Source source) {
            this.dataSource = source;
        }

        void a(FieldPath fieldPath) {
            this.fieldMask.add(fieldPath);
        }

        void a(FieldPath fieldPath, TransformOperation transformOperation) {
            this.fieldTransforms.add(new FieldTransform(fieldPath, transformOperation));
        }

        public boolean contains(FieldPath fieldPath) {
            Iterator<FieldPath> it = this.fieldMask.iterator();
            while (it.hasNext()) {
                if (fieldPath.isPrefixOf(it.next())) {
                    return true;
                }
            }
            Iterator<FieldTransform> it2 = this.fieldTransforms.iterator();
            while (it2.hasNext()) {
                if (fieldPath.isPrefixOf(it2.next().getFieldPath())) {
                    return true;
                }
            }
            return false;
        }

        public Source getDataSource() {
            return this.dataSource;
        }

        public List<FieldTransform> getFieldTransforms() {
            return this.fieldTransforms;
        }

        public ParseContext rootContext() {
            return new ParseContext(this, FieldPath.EMPTY_PATH, false, null);
        }

        public ParsedSetData toMergeData(ObjectValue objectValue) {
            return new ParsedSetData(objectValue, FieldMask.fromSet(this.fieldMask), Collections.unmodifiableList(this.fieldTransforms));
        }

        public ParsedSetData toMergeData(ObjectValue objectValue, FieldMask fieldMask) {
            ArrayList arrayList = new ArrayList();
            Iterator<FieldTransform> it = this.fieldTransforms.iterator();
            while (it.hasNext()) {
                FieldTransform next = it.next();
                if (fieldMask.covers(next.getFieldPath())) {
                    arrayList.add(next);
                }
            }
            return new ParsedSetData(objectValue, fieldMask, Collections.unmodifiableList(arrayList));
        }

        public ParsedSetData toSetData(ObjectValue objectValue) {
            return new ParsedSetData(objectValue, null, Collections.unmodifiableList(this.fieldTransforms));
        }

        public ParsedUpdateData toUpdateData(ObjectValue objectValue) {
            return new ParsedUpdateData(objectValue, FieldMask.fromSet(this.fieldMask), Collections.unmodifiableList(this.fieldTransforms));
        }
    }

    /* loaded from: classes2.dex */
    public static class ParseContext {
        private static final String RESERVED_FIELD_DESIGNATOR = "__";
        private final ParseAccumulator accumulator;
        private final boolean arrayElement;

        @Nullable
        private final FieldPath path;

        private ParseContext(ParseAccumulator parseAccumulator, @Nullable FieldPath fieldPath, boolean z) {
            this.accumulator = parseAccumulator;
            this.path = fieldPath;
            this.arrayElement = z;
        }

        /* synthetic */ ParseContext(ParseAccumulator parseAccumulator, FieldPath fieldPath, boolean z, AnonymousClass1 anonymousClass1) {
            this(parseAccumulator, fieldPath, z);
        }

        private void validatePath() {
            if (this.path == null) {
                return;
            }
            for (int i = 0; i < this.path.length(); i++) {
                validatePathSegment(this.path.getSegment(i));
            }
        }

        private void validatePathSegment(String str) {
            if (str.isEmpty()) {
                throw createError("Document fields must not be empty");
            }
            if (isWrite() && str.startsWith(RESERVED_FIELD_DESIGNATOR) && str.endsWith(RESERVED_FIELD_DESIGNATOR)) {
                throw createError("Document fields cannot begin and end with \"__\"");
            }
        }

        public void addToFieldMask(FieldPath fieldPath) {
            this.accumulator.a(fieldPath);
        }

        public void addToFieldTransforms(FieldPath fieldPath, TransformOperation transformOperation) {
            this.accumulator.a(fieldPath, transformOperation);
        }

        public ParseContext childContext(int i) {
            return new ParseContext(this.accumulator, null, true);
        }

        public ParseContext childContext(FieldPath fieldPath) {
            FieldPath fieldPath2 = this.path;
            ParseContext parseContext = new ParseContext(this.accumulator, fieldPath2 == null ? null : fieldPath2.append(fieldPath), false);
            parseContext.validatePath();
            return parseContext;
        }

        public ParseContext childContext(String str) {
            FieldPath fieldPath = this.path;
            ParseContext parseContext = new ParseContext(this.accumulator, fieldPath == null ? null : fieldPath.append(str), false);
            parseContext.validatePathSegment(str);
            return parseContext;
        }

        public RuntimeException createError(String str) {
            String str2;
            FieldPath fieldPath = this.path;
            if (fieldPath == null || fieldPath.isEmpty()) {
                str2 = "";
            } else {
                str2 = " (found in field " + this.path.toString() + ")";
            }
            return new IllegalArgumentException("Invalid data. " + str + str2);
        }

        public Source getDataSource() {
            return this.accumulator.dataSource;
        }

        @Nullable
        public FieldPath getPath() {
            return this.path;
        }

        public boolean isArrayElement() {
            return this.arrayElement;
        }

        public boolean isWrite() {
            int i = AnonymousClass1.a[this.accumulator.dataSource.ordinal()];
            if (i == 1 || i == 2 || i == 3) {
                return true;
            }
            if (i == 4 || i == 5) {
                return false;
            }
            throw Assert.fail("Unexpected case for UserDataSource: %s", this.accumulator.dataSource.name());
        }
    }

    /* loaded from: classes2.dex */
    public static class ParsedSetData {
        private final ObjectValue data;

        @Nullable
        private final FieldMask fieldMask;
        private final List<FieldTransform> fieldTransforms;

        ParsedSetData(ObjectValue objectValue, @Nullable FieldMask fieldMask, List<FieldTransform> list) {
            this.data = objectValue;
            this.fieldMask = fieldMask;
            this.fieldTransforms = list;
        }

        public List<Mutation> toMutationList(DocumentKey documentKey, Precondition precondition) {
            ArrayList arrayList = new ArrayList();
            FieldMask fieldMask = this.fieldMask;
            if (fieldMask != null) {
                arrayList.add(new PatchMutation(documentKey, this.data, fieldMask, precondition));
            } else {
                arrayList.add(new SetMutation(documentKey, this.data, precondition));
            }
            if (!this.fieldTransforms.isEmpty()) {
                arrayList.add(new TransformMutation(documentKey, this.fieldTransforms));
            }
            return arrayList;
        }
    }

    /* loaded from: classes2.dex */
    public static class ParsedUpdateData {
        private final ObjectValue data;
        private final FieldMask fieldMask;
        private final List<FieldTransform> fieldTransforms;

        ParsedUpdateData(ObjectValue objectValue, FieldMask fieldMask, List<FieldTransform> list) {
            this.data = objectValue;
            this.fieldMask = fieldMask;
            this.fieldTransforms = list;
        }

        public List<FieldTransform> getFieldTransforms() {
            return this.fieldTransforms;
        }

        public List<Mutation> toMutationList(DocumentKey documentKey, Precondition precondition) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(new PatchMutation(documentKey, this.data, this.fieldMask, precondition));
            if (!this.fieldTransforms.isEmpty()) {
                arrayList.add(new TransformMutation(documentKey, this.fieldTransforms));
            }
            return arrayList;
        }
    }

    /* loaded from: classes2.dex */
    public enum Source {
        Set,
        MergeSet,
        Update,
        Argument,
        ArrayArgument
    }

    private UserData() {
    }
}
