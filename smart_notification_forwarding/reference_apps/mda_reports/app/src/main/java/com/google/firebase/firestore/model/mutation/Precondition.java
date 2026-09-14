package com.google.firebase.firestore.model.mutation;

import androidx.annotation.Nullable;
import com.google.firebase.firestore.model.Document;
import com.google.firebase.firestore.model.MaybeDocument;
import com.google.firebase.firestore.model.SnapshotVersion;
import com.google.firebase.firestore.util.Assert;

/* loaded from: classes2.dex */
public final class Precondition {
    public static final Precondition NONE = new Precondition(null, null);

    @Nullable
    private final Boolean exists;

    @Nullable
    private final SnapshotVersion updateTime;

    private Precondition(@Nullable SnapshotVersion snapshotVersion, @Nullable Boolean bool) {
        Assert.hardAssert(snapshotVersion == null || bool == null, "Precondition can specify \"exists\" or \"updateTime\" but not both", new Object[0]);
        this.updateTime = snapshotVersion;
        this.exists = bool;
    }

    public static Precondition exists(boolean z) {
        return new Precondition(null, Boolean.valueOf(z));
    }

    public static Precondition updateTime(SnapshotVersion snapshotVersion) {
        return new Precondition(snapshotVersion, null);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || Precondition.class != obj.getClass()) {
            return false;
        }
        Precondition precondition = (Precondition) obj;
        SnapshotVersion snapshotVersion = this.updateTime;
        if (snapshotVersion == null ? precondition.updateTime != null : !snapshotVersion.equals(precondition.updateTime)) {
            return false;
        }
        Boolean bool = this.exists;
        Boolean bool2 = precondition.exists;
        return bool != null ? bool.equals(bool2) : bool2 == null;
    }

    @Nullable
    public Boolean getExists() {
        return this.exists;
    }

    @Nullable
    public SnapshotVersion getUpdateTime() {
        return this.updateTime;
    }

    public int hashCode() {
        SnapshotVersion snapshotVersion = this.updateTime;
        int hashCode = (snapshotVersion != null ? snapshotVersion.hashCode() : 0) * 31;
        Boolean bool = this.exists;
        return hashCode + (bool != null ? bool.hashCode() : 0);
    }

    public boolean isNone() {
        return this.updateTime == null && this.exists == null;
    }

    public boolean isValidFor(@Nullable MaybeDocument maybeDocument) {
        if (this.updateTime != null) {
            return (maybeDocument instanceof Document) && maybeDocument.getVersion().equals(this.updateTime);
        }
        Boolean bool = this.exists;
        if (bool != null) {
            return bool.booleanValue() == (maybeDocument instanceof Document);
        }
        Assert.hardAssert(isNone(), "Precondition should be empty", new Object[0]);
        return true;
    }

    public String toString() {
        StringBuilder sb;
        Object obj;
        if (isNone()) {
            return "Precondition{<none>}";
        }
        if (this.updateTime != null) {
            sb = new StringBuilder();
            sb.append("Precondition{updateTime=");
            obj = this.updateTime;
        } else {
            if (this.exists == null) {
                throw Assert.fail("Invalid Precondition", new Object[0]);
            }
            sb = new StringBuilder();
            sb.append("Precondition{exists=");
            obj = this.exists;
        }
        sb.append(obj);
        sb.append("}");
        return sb.toString();
    }
}
