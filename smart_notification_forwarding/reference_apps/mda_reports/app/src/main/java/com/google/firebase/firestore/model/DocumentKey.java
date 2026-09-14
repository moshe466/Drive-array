package com.google.firebase.firestore.model;

import androidx.annotation.NonNull;
import com.google.firebase.database.collection.ImmutableSortedSet;
import com.google.firebase.firestore.util.Assert;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* loaded from: classes2.dex */
public final class DocumentKey implements Comparable<DocumentKey> {
    private static final Comparator<DocumentKey> COMPARATOR;
    private static final ImmutableSortedSet<DocumentKey> EMPTY_KEY_SET;
    public static final String KEY_FIELD_NAME = "__name__";
    private final ResourcePath path;

    static {
        Comparator<DocumentKey> comparator;
        comparator = DocumentKey$$Lambda$1.instance;
        COMPARATOR = comparator;
        EMPTY_KEY_SET = new ImmutableSortedSet<>(Collections.emptyList(), COMPARATOR);
    }

    private DocumentKey(ResourcePath resourcePath) {
        Assert.hardAssert(isDocumentKey(resourcePath), "Not a document key path: %s", resourcePath);
        this.path = resourcePath;
    }

    public static Comparator<DocumentKey> comparator() {
        return COMPARATOR;
    }

    public static DocumentKey empty() {
        return fromSegments(Collections.emptyList());
    }

    public static ImmutableSortedSet<DocumentKey> emptyKeySet() {
        return EMPTY_KEY_SET;
    }

    public static DocumentKey fromPath(ResourcePath resourcePath) {
        return new DocumentKey(resourcePath);
    }

    public static DocumentKey fromPathString(String str) {
        return new DocumentKey(ResourcePath.fromString(str));
    }

    public static DocumentKey fromSegments(List<String> list) {
        return new DocumentKey(ResourcePath.fromSegments(list));
    }

    public static boolean isDocumentKey(ResourcePath resourcePath) {
        return resourcePath.length() % 2 == 0;
    }

    @Override // java.lang.Comparable
    public int compareTo(@NonNull DocumentKey documentKey) {
        return this.path.compareTo(documentKey.path);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || DocumentKey.class != obj.getClass()) {
            return false;
        }
        return this.path.equals(((DocumentKey) obj).path);
    }

    public ResourcePath getPath() {
        return this.path;
    }

    public boolean hasCollectionId(String str) {
        if (this.path.length() >= 2) {
            ResourcePath resourcePath = this.path;
            if (resourcePath.a.get(resourcePath.length() - 2).equals(str)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return this.path.hashCode();
    }

    public String toString() {
        return this.path.toString();
    }
}
