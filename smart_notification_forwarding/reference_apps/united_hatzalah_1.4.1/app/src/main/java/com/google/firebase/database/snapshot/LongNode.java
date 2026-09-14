package com.google.firebase.database.snapshot;

import F0.AbstractC0008a;
import com.google.firebase.database.core.utilities.Utilities;
import com.google.firebase.database.snapshot.LeafNode;
import com.google.firebase.database.snapshot.Node;
import e0.a;

/* loaded from: classes.dex */
public class LongNode extends LeafNode<LongNode> {
    private final long value;

    public LongNode(Long l3, Node node) {
        super(node);
        this.value = l3.longValue();
    }

    @Override // com.google.firebase.database.snapshot.LeafNode
    public boolean equals(Object obj) {
        if (!(obj instanceof LongNode)) {
            return false;
        }
        LongNode longNode = (LongNode) obj;
        if (this.value != longNode.value || !this.priority.equals(longNode.priority)) {
            return false;
        }
        return true;
    }

    @Override // com.google.firebase.database.snapshot.Node
    public String getHashRepresentation(Node.HashVersion hashVersion) {
        StringBuilder h2 = a.h(AbstractC0008a.n(getPriorityHash(hashVersion), "number:"));
        h2.append(Utilities.doubleToHashString(this.value));
        return h2.toString();
    }

    @Override // com.google.firebase.database.snapshot.LeafNode
    public LeafNode.LeafType getLeafType() {
        return LeafNode.LeafType.Number;
    }

    @Override // com.google.firebase.database.snapshot.Node
    public Object getValue() {
        return Long.valueOf(this.value);
    }

    @Override // com.google.firebase.database.snapshot.LeafNode
    public int hashCode() {
        long j2 = this.value;
        return this.priority.hashCode() + ((int) (j2 ^ (j2 >>> 32)));
    }

    @Override // com.google.firebase.database.snapshot.LeafNode
    public int compareLeafValues(LongNode longNode) {
        return Utilities.compareLongs(this.value, longNode.value);
    }

    @Override // com.google.firebase.database.snapshot.Node
    public LongNode updatePriority(Node node) {
        return new LongNode(Long.valueOf(this.value), node);
    }
}
