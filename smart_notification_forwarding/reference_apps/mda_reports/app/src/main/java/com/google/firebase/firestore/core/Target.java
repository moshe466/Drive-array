package com.google.firebase.firestore.core;

import androidx.annotation.Nullable;
import com.google.firebase.firestore.core.OrderBy;
import com.google.firebase.firestore.model.DocumentKey;
import com.google.firebase.firestore.model.ResourcePath;
import com.google.firebase.firestore.util.Assert;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes2.dex */
public final class Target {
    public static final long NO_LIMIT = -1;

    @Nullable
    private final String collectionGroup;

    @Nullable
    private final Bound endAt;
    private final List<Filter> filters;
    private final long limit;

    @Nullable
    private String memoizedCannonicalId;
    private final List<OrderBy> orderBy;
    private final ResourcePath path;

    @Nullable
    private final Bound startAt;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Target(ResourcePath resourcePath, @Nullable String str, List<Filter> list, List<OrderBy> list2, long j, @Nullable Bound bound, @Nullable Bound bound2) {
        this.path = resourcePath;
        this.collectionGroup = str;
        this.orderBy = list2;
        this.filters = list;
        this.limit = j;
        this.startAt = bound;
        this.endAt = bound2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || Target.class != obj.getClass()) {
            return false;
        }
        Target target = (Target) obj;
        String str = this.collectionGroup;
        if (str == null ? target.collectionGroup != null : !str.equals(target.collectionGroup)) {
            return false;
        }
        if (this.limit != target.limit || !this.orderBy.equals(target.orderBy) || !this.filters.equals(target.filters) || !this.path.equals(target.path)) {
            return false;
        }
        Bound bound = this.startAt;
        if (bound == null ? target.startAt != null : !bound.equals(target.startAt)) {
            return false;
        }
        Bound bound2 = this.endAt;
        Bound bound3 = target.endAt;
        return bound2 != null ? bound2.equals(bound3) : bound3 == null;
    }

    public String getCanonicalId() {
        String str = this.memoizedCannonicalId;
        if (str != null) {
            return str;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(getPath().canonicalString());
        if (this.collectionGroup != null) {
            sb.append("|cg:");
            sb.append(this.collectionGroup);
        }
        sb.append("|f:");
        Iterator<Filter> it = getFilters().iterator();
        while (it.hasNext()) {
            sb.append(it.next().getCanonicalId());
        }
        sb.append("|ob:");
        for (OrderBy orderBy : getOrderBy()) {
            sb.append(orderBy.getField().canonicalString());
            sb.append(orderBy.getDirection().equals(OrderBy.Direction.ASCENDING) ? "asc" : "desc");
        }
        if (hasLimit()) {
            sb.append("|l:");
            sb.append(getLimit());
        }
        if (this.startAt != null) {
            sb.append("|lb:");
            sb.append(this.startAt.canonicalString());
        }
        if (this.endAt != null) {
            sb.append("|ub:");
            sb.append(this.endAt.canonicalString());
        }
        this.memoizedCannonicalId = sb.toString();
        return this.memoizedCannonicalId;
    }

    @Nullable
    public String getCollectionGroup() {
        return this.collectionGroup;
    }

    @Nullable
    public Bound getEndAt() {
        return this.endAt;
    }

    public List<Filter> getFilters() {
        return this.filters;
    }

    public long getLimit() {
        Assert.hardAssert(hasLimit(), "Called getLimit when no limit was set", new Object[0]);
        return this.limit;
    }

    public List<OrderBy> getOrderBy() {
        return this.orderBy;
    }

    public ResourcePath getPath() {
        return this.path;
    }

    @Nullable
    public Bound getStartAt() {
        return this.startAt;
    }

    public boolean hasLimit() {
        return this.limit != -1;
    }

    public int hashCode() {
        int hashCode = this.orderBy.hashCode() * 31;
        String str = this.collectionGroup;
        int hashCode2 = (((((hashCode + (str != null ? str.hashCode() : 0)) * 31) + this.filters.hashCode()) * 31) + this.path.hashCode()) * 31;
        long j = this.limit;
        int i = (hashCode2 + ((int) (j ^ (j >>> 32)))) * 31;
        Bound bound = this.startAt;
        int hashCode3 = (i + (bound != null ? bound.hashCode() : 0)) * 31;
        Bound bound2 = this.endAt;
        return hashCode3 + (bound2 != null ? bound2.hashCode() : 0);
    }

    public boolean isDocumentQuery() {
        return DocumentKey.isDocumentKey(this.path) && this.collectionGroup == null && this.filters.isEmpty();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Query(");
        sb.append(this.path.canonicalString());
        if (this.collectionGroup != null) {
            sb.append(" collectionGroup=");
            sb.append(this.collectionGroup);
        }
        if (!this.filters.isEmpty()) {
            sb.append(" where ");
            for (int i = 0; i < this.filters.size(); i++) {
                if (i > 0) {
                    sb.append(" and ");
                }
                sb.append(this.filters.get(i).toString());
            }
        }
        if (!this.orderBy.isEmpty()) {
            sb.append(" order by ");
            for (int i2 = 0; i2 < this.orderBy.size(); i2++) {
                if (i2 > 0) {
                    sb.append(", ");
                }
                sb.append(this.orderBy.get(i2));
            }
        }
        sb.append(")");
        return sb.toString();
    }
}
