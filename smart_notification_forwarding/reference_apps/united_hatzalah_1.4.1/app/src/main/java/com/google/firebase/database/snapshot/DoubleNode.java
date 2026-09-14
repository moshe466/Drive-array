package com.google.firebase.database.snapshot;

import F0.AbstractC0008a;
import com.google.firebase.database.core.utilities.Utilities;
import com.google.firebase.database.snapshot.LeafNode;
import com.google.firebase.database.snapshot.Node;
import e0.a;

/* loaded from: classes.dex */
public class DoubleNode extends LeafNode<DoubleNode> {
    private final Double value;

    public DoubleNode(Double d2, Node node) {
        super(node);
        this.value = d2;
    }

    @Override // com.google.firebase.database.snapshot.LeafNode
    public boolean equals(Object obj) {
        if (!(obj instanceof DoubleNode)) {
            return false;
        }
        DoubleNode doubleNode = (DoubleNode) obj;
        if (!this.value.equals(doubleNode.value) || !this.priority.equals(doubleNode.priority)) {
            return false;
        }
        return true;
    }

    @Override // com.google.firebase.database.snapshot.Node
    public String getHashRepresentation(Node.HashVersion hashVersion) {
        StringBuilder h2 = a.h(AbstractC0008a.n(getPriorityHash(hashVersion), "number:"));
        h2.append(Utilities.doubleToHashString(this.value.doubleValue()));
        return h2.toString();
    }

    @Override // com.google.firebase.database.snapshot.LeafNode
    public LeafNode.LeafType getLeafType() {
        return LeafNode.LeafType.Number;
    }

    @Override // com.google.firebase.database.snapshot.Node
    public Object getValue() {
        return this.value;
    }

    @Override // com.google.firebase.database.snapshot.LeafNode
    public int hashCode() {
        return this.priority.hashCode() + this.value.hashCode();
    }

    @Override // com.google.firebase.database.snapshot.LeafNode
    public int compareLeafValues(DoubleNode doubleNode) {
        return this.value.compareTo(doubleNode.value);
    }

    @Override // com.google.firebase.database.snapshot.Node
    public DoubleNode updatePriority(Node node) {
        Utilities.hardAssert(PriorityUtilities.isValidPriority(node));
        return new DoubleNode(this.value, node);
    }
}
