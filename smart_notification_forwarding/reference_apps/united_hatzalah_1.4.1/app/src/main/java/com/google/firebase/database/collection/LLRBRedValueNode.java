package com.google.firebase.database.collection;

import com.google.firebase.database.collection.LLRBNode;

/* loaded from: classes.dex */
public class LLRBRedValueNode<K, V> extends LLRBValueNode<K, V> {
    public LLRBRedValueNode(K k4, V v2) {
        super(k4, v2, LLRBEmptyNode.getInstance(), LLRBEmptyNode.getInstance());
    }

    @Override // com.google.firebase.database.collection.LLRBValueNode
    public LLRBValueNode<K, V> copy(K k4, V v2, LLRBNode<K, V> lLRBNode, LLRBNode<K, V> lLRBNode2) {
        if (k4 == null) {
            k4 = getKey();
        }
        if (v2 == null) {
            v2 = getValue();
        }
        if (lLRBNode == null) {
            lLRBNode = getLeft();
        }
        if (lLRBNode2 == null) {
            lLRBNode2 = getRight();
        }
        return new LLRBRedValueNode(k4, v2, lLRBNode, lLRBNode2);
    }

    @Override // com.google.firebase.database.collection.LLRBValueNode
    public LLRBNode.Color getColor() {
        return LLRBNode.Color.RED;
    }

    @Override // com.google.firebase.database.collection.LLRBNode
    public boolean isRed() {
        return true;
    }

    @Override // com.google.firebase.database.collection.LLRBNode
    public int size() {
        return getRight().size() + getLeft().size() + 1;
    }

    public LLRBRedValueNode(K k4, V v2, LLRBNode<K, V> lLRBNode, LLRBNode<K, V> lLRBNode2) {
        super(k4, v2, lLRBNode, lLRBNode2);
    }
}
