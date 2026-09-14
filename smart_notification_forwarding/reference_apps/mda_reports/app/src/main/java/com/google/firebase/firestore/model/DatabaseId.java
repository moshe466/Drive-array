package com.google.firebase.firestore.model;

import androidx.annotation.NonNull;

/* loaded from: classes2.dex */
public final class DatabaseId implements Comparable<DatabaseId> {
    public static final String DEFAULT_DATABASE_ID = "(default)";
    private final String databaseId;
    private final String projectId;

    private DatabaseId(String str, String str2) {
        this.projectId = str;
        this.databaseId = str2;
    }

    public static DatabaseId forDatabase(String str, String str2) {
        return new DatabaseId(str, str2);
    }

    public static DatabaseId forProject(String str) {
        return forDatabase(str, DEFAULT_DATABASE_ID);
    }

    @Override // java.lang.Comparable
    public int compareTo(@NonNull DatabaseId databaseId) {
        int compareTo = this.projectId.compareTo(databaseId.projectId);
        return compareTo != 0 ? compareTo : this.databaseId.compareTo(databaseId.databaseId);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || DatabaseId.class != obj.getClass()) {
            return false;
        }
        DatabaseId databaseId = (DatabaseId) obj;
        return this.projectId.equals(databaseId.projectId) && this.databaseId.equals(databaseId.databaseId);
    }

    public String getDatabaseId() {
        return this.databaseId;
    }

    public String getProjectId() {
        return this.projectId;
    }

    public int hashCode() {
        return (this.projectId.hashCode() * 31) + this.databaseId.hashCode();
    }

    public String toString() {
        return "DatabaseId(" + this.projectId + ", " + this.databaseId + ")";
    }
}
