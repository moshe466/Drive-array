package com.google.firebase.database.core.persistence;

import com.google.firebase.database.core.view.QuerySpec;

/* loaded from: classes.dex */
public final class TrackedQuery {
    public final boolean active;
    public final boolean complete;
    public final long id;
    public final long lastUse;
    public final QuerySpec querySpec;

    public TrackedQuery(long j2, QuerySpec querySpec, long j3, boolean z3, boolean z4) {
        this.id = j2;
        if (querySpec.loadsAllData() && !querySpec.isDefault()) {
            throw new IllegalArgumentException("Can't create TrackedQuery for a non-default query that loads all data");
        }
        this.querySpec = querySpec;
        this.lastUse = j3;
        this.complete = z3;
        this.active = z4;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj != null && obj.getClass() == TrackedQuery.class) {
            TrackedQuery trackedQuery = (TrackedQuery) obj;
            if (this.id == trackedQuery.id && this.querySpec.equals(trackedQuery.querySpec) && this.lastUse == trackedQuery.lastUse && this.complete == trackedQuery.complete && this.active == trackedQuery.active) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return Boolean.valueOf(this.active).hashCode() + ((Boolean.valueOf(this.complete).hashCode() + ((Long.valueOf(this.lastUse).hashCode() + ((this.querySpec.hashCode() + (Long.valueOf(this.id).hashCode() * 31)) * 31)) * 31)) * 31);
    }

    public TrackedQuery setActiveState(boolean z3) {
        return new TrackedQuery(this.id, this.querySpec, this.lastUse, this.complete, z3);
    }

    public TrackedQuery setComplete() {
        return new TrackedQuery(this.id, this.querySpec, this.lastUse, true, this.active);
    }

    public String toString() {
        return "TrackedQuery{id=" + this.id + ", querySpec=" + this.querySpec + ", lastUse=" + this.lastUse + ", complete=" + this.complete + ", active=" + this.active + "}";
    }

    public TrackedQuery updateLastUse(long j2) {
        return new TrackedQuery(this.id, this.querySpec, j2, this.complete, this.active);
    }
}
