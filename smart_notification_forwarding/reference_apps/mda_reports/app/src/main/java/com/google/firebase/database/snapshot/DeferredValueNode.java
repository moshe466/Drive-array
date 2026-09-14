package com.google.firebase.database.snapshot;

import com.google.firebase.database.snapshot.LeafNode;
import com.google.firebase.database.snapshot.Node;
import java.util.Map;

/* loaded from: classes2.dex */
public class DeferredValueNode extends LeafNode<DeferredValueNode> {
    private Map<Object, Object> value;

    public DeferredValueNode(Map<Object, Object> map, Node node) {
        super(node);
        this.value = map;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.firebase.database.snapshot.LeafNode
    public int a(DeferredValueNode deferredValueNode) {
        return 0;
    }

    @Override // com.google.firebase.database.snapshot.LeafNode
    protected LeafNode.LeafType a() {
        return LeafNode.LeafType.DeferredValue;
    }

    @Override // com.google.firebase.database.snapshot.LeafNode
    public boolean equals(Object obj) {
        if (!(obj instanceof DeferredValueNode)) {
            return false;
        }
        DeferredValueNode deferredValueNode = (DeferredValueNode) obj;
        return this.value.equals(deferredValueNode.value) && this.a.equals(deferredValueNode.a);
    }

    @Override // com.google.firebase.database.snapshot.Node
    public String getHashRepresentation(Node.HashVersion hashVersion) {
        return a(hashVersion) + "deferredValue:" + this.value;
    }

    @Override // com.google.firebase.database.snapshot.Node
    public Object getValue() {
        return this.value;
    }

    @Override // com.google.firebase.database.snapshot.LeafNode
    public int hashCode() {
        return this.value.hashCode() + this.a.hashCode();
    }

    @Override // com.google.firebase.database.snapshot.Node
    public DeferredValueNode updatePriority(Node node) {
        return new DeferredValueNode(this.value, node);
    }
}
