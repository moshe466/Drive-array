package com.google.firebase.database.snapshot;

import com.google.firebase.database.core.utilities.Utilities;
import com.google.firebase.database.snapshot.LeafNode;
import com.google.firebase.database.snapshot.Node;

/* loaded from: classes2.dex */
public class StringNode extends LeafNode<StringNode> {
    private final String value;

    /* renamed from: com.google.firebase.database.snapshot.StringNode$1, reason: invalid class name */
    /* loaded from: classes2.dex */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] a = new int[Node.HashVersion.values().length];

        static {
            try {
                a[Node.HashVersion.V1.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[Node.HashVersion.V2.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public StringNode(String str, Node node) {
        super(node);
        this.value = str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.firebase.database.snapshot.LeafNode
    public int a(StringNode stringNode) {
        return this.value.compareTo(stringNode.value);
    }

    @Override // com.google.firebase.database.snapshot.LeafNode
    protected LeafNode.LeafType a() {
        return LeafNode.LeafType.String;
    }

    @Override // com.google.firebase.database.snapshot.LeafNode
    public boolean equals(Object obj) {
        if (!(obj instanceof StringNode)) {
            return false;
        }
        StringNode stringNode = (StringNode) obj;
        return this.value.equals(stringNode.value) && this.a.equals(stringNode.a);
    }

    @Override // com.google.firebase.database.snapshot.Node
    public String getHashRepresentation(Node.HashVersion hashVersion) {
        StringBuilder sb;
        String str;
        int i = AnonymousClass1.a[hashVersion.ordinal()];
        if (i == 1) {
            sb = new StringBuilder();
            sb.append(a(hashVersion));
            sb.append("string:");
            str = this.value;
        } else {
            if (i != 2) {
                throw new IllegalArgumentException("Invalid hash version for string node: " + hashVersion);
            }
            sb = new StringBuilder();
            sb.append(a(hashVersion));
            sb.append("string:");
            str = Utilities.stringHashV2Representation(this.value);
        }
        sb.append(str);
        return sb.toString();
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
    public StringNode updatePriority(Node node) {
        return new StringNode(this.value, node);
    }
}
