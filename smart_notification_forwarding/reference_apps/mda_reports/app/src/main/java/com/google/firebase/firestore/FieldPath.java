package com.google.firebase.firestore;

import androidx.annotation.NonNull;
import com.google.common.base.Preconditions;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

/* loaded from: classes2.dex */
public final class FieldPath {
    private final com.google.firebase.firestore.model.FieldPath internalPath;
    private static final Pattern RESERVED = Pattern.compile("[~*/\\[\\]]");
    private static final FieldPath DOCUMENT_ID_INSTANCE = new FieldPath(com.google.firebase.firestore.model.FieldPath.KEY_PATH);

    private FieldPath(com.google.firebase.firestore.model.FieldPath fieldPath) {
        this.internalPath = fieldPath;
    }

    private FieldPath(List<String> list) {
        this.internalPath = com.google.firebase.firestore.model.FieldPath.fromSegments(list);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static FieldPath a(@NonNull String str) {
        Preconditions.checkNotNull(str, "Provided field path must not be null.");
        Preconditions.checkArgument(!RESERVED.matcher(str).find(), "Use FieldPath.of() for field names containing '~*/[]'.");
        try {
            return of(str.split("\\.", -1));
        } catch (IllegalArgumentException unused) {
            throw new IllegalArgumentException("Invalid field path (" + str + "). Paths must not be empty, begin with '.', end with '.', or contain '..'");
        }
    }

    @NonNull
    public static FieldPath documentId() {
        return DOCUMENT_ID_INSTANCE;
    }

    @NonNull
    public static FieldPath of(String... strArr) {
        Preconditions.checkArgument(strArr.length > 0, "Invalid field path. Provided path must not be empty.");
        int i = 0;
        while (i < strArr.length) {
            boolean z = (strArr[i] == null || strArr[i].isEmpty()) ? false : true;
            StringBuilder sb = new StringBuilder();
            sb.append("Invalid field name at argument ");
            i++;
            sb.append(i);
            sb.append(". Field names must not be null or empty.");
            Preconditions.checkArgument(z, sb.toString());
        }
        return new FieldPath((List<String>) Arrays.asList(strArr));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public com.google.firebase.firestore.model.FieldPath a() {
        return this.internalPath;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || FieldPath.class != obj.getClass()) {
            return false;
        }
        return this.internalPath.equals(((FieldPath) obj).internalPath);
    }

    public int hashCode() {
        return this.internalPath.hashCode();
    }

    public String toString() {
        return this.internalPath.toString();
    }
}
