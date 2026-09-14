package com.google.firebase.database.snapshot;

import com.google.firebase.database.collection.ImmutableSortedMap;
import com.google.firebase.database.collection.LLRBNode;
import com.google.firebase.database.core.Path;
import com.google.firebase.database.core.utilities.Utilities;
import com.google.firebase.database.snapshot.Node;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.apache.tika.metadata.TikaCoreProperties;
import org.apache.tika.utils.StringUtils;

/* loaded from: classes.dex */
public class ChildrenNode implements Node {
    public static Comparator<ChildKey> NAME_ONLY_COMPARATOR = new Comparator<ChildKey>() { // from class: com.google.firebase.database.snapshot.ChildrenNode.1
        @Override // java.util.Comparator
        public int compare(ChildKey childKey, ChildKey childKey2) {
            return childKey.compareTo(childKey2);
        }
    };
    private final ImmutableSortedMap<ChildKey, Node> children;
    private String lazyHash;
    private final Node priority;

    /* loaded from: classes.dex */
    public static abstract class ChildVisitor extends LLRBNode.NodeVisitor<ChildKey, Node> {
        public abstract void visitChild(ChildKey childKey, Node node);

        @Override // com.google.firebase.database.collection.LLRBNode.NodeVisitor
        public void visitEntry(ChildKey childKey, Node node) {
            visitChild(childKey, node);
        }
    }

    /* loaded from: classes.dex */
    public static class NamedNodeIterator implements Iterator<NamedNode> {
        private final Iterator<Map.Entry<ChildKey, Node>> iterator;

        public NamedNodeIterator(Iterator<Map.Entry<ChildKey, Node>> it) {
            this.iterator = it;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.iterator.hasNext();
        }

        @Override // java.util.Iterator
        public void remove() {
            this.iterator.remove();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.Iterator
        public NamedNode next() {
            Map.Entry<ChildKey, Node> next = this.iterator.next();
            return new NamedNode(next.getKey(), next.getValue());
        }
    }

    public ChildrenNode() {
        this.lazyHash = null;
        this.children = ImmutableSortedMap.Builder.emptyMap(NAME_ONLY_COMPARATOR);
        this.priority = PriorityUtilities.NullPriority();
    }

    private static void addIndentation(StringBuilder sb, int i) {
        for (int i3 = 0; i3 < i; i3++) {
            sb.append(StringUtils.SPACE);
        }
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ChildrenNode)) {
            return false;
        }
        ChildrenNode childrenNode = (ChildrenNode) obj;
        if (!getPriority().equals(childrenNode.getPriority()) || this.children.size() != childrenNode.children.size()) {
            return false;
        }
        Iterator<Map.Entry<ChildKey, Node>> it = this.children.iterator();
        Iterator<Map.Entry<ChildKey, Node>> it2 = childrenNode.children.iterator();
        while (it.hasNext() && it2.hasNext()) {
            Map.Entry<ChildKey, Node> next = it.next();
            Map.Entry<ChildKey, Node> next2 = it2.next();
            if (!next.getKey().equals(next2.getKey()) || !next.getValue().equals(next2.getValue())) {
                return false;
            }
        }
        if (!it.hasNext() && !it2.hasNext()) {
            return true;
        }
        throw new IllegalStateException("Something went wrong internally.");
    }

    public void forEachChild(ChildVisitor childVisitor) {
        forEachChild(childVisitor, false);
    }

    @Override // com.google.firebase.database.snapshot.Node
    public Node getChild(Path path) {
        ChildKey front = path.getFront();
        if (front == null) {
            return this;
        }
        return getImmediateChild(front).getChild(path.popFront());
    }

    @Override // com.google.firebase.database.snapshot.Node
    public int getChildCount() {
        return this.children.size();
    }

    public ChildKey getFirstChildKey() {
        return this.children.getMinKey();
    }

    @Override // com.google.firebase.database.snapshot.Node
    public String getHash() {
        String sha1HexDigest;
        if (this.lazyHash == null) {
            String hashRepresentation = getHashRepresentation(Node.HashVersion.V1);
            if (hashRepresentation.isEmpty()) {
                sha1HexDigest = "";
            } else {
                sha1HexDigest = Utilities.sha1HexDigest(hashRepresentation);
            }
            this.lazyHash = sha1HexDigest;
        }
        return this.lazyHash;
    }

    @Override // com.google.firebase.database.snapshot.Node
    public String getHashRepresentation(Node.HashVersion hashVersion) {
        boolean z3;
        Node.HashVersion hashVersion2 = Node.HashVersion.V1;
        if (hashVersion == hashVersion2) {
            StringBuilder sb = new StringBuilder();
            if (!this.priority.isEmpty()) {
                sb.append("priority:");
                sb.append(this.priority.getHashRepresentation(hashVersion2));
                sb.append(TikaCoreProperties.NAMESPACE_PREFIX_DELIMITER);
            }
            ArrayList arrayList = new ArrayList();
            Iterator<NamedNode> it = iterator();
            int i = 0;
            loop0: while (true) {
                z3 = false;
                while (it.hasNext()) {
                    NamedNode next = it.next();
                    arrayList.add(next);
                    if (z3 || !next.getNode().getPriority().isEmpty()) {
                        z3 = true;
                    }
                }
            }
            if (z3) {
                Collections.sort(arrayList, PriorityIndex.getInstance());
            }
            int size = arrayList.size();
            while (i < size) {
                Object obj = arrayList.get(i);
                i++;
                NamedNode namedNode = (NamedNode) obj;
                String hash = namedNode.getNode().getHash();
                if (!hash.equals("")) {
                    sb.append(TikaCoreProperties.NAMESPACE_PREFIX_DELIMITER);
                    sb.append(namedNode.getName().asString());
                    sb.append(TikaCoreProperties.NAMESPACE_PREFIX_DELIMITER);
                    sb.append(hash);
                }
            }
            return sb.toString();
        }
        throw new IllegalArgumentException("Hashes on children nodes only supported for V1");
    }

    @Override // com.google.firebase.database.snapshot.Node
    public Node getImmediateChild(ChildKey childKey) {
        if (childKey.isPriorityChildName() && !this.priority.isEmpty()) {
            return this.priority;
        }
        if (this.children.containsKey(childKey)) {
            return this.children.get(childKey);
        }
        return EmptyNode.Empty();
    }

    public ChildKey getLastChildKey() {
        return this.children.getMaxKey();
    }

    @Override // com.google.firebase.database.snapshot.Node
    public ChildKey getPredecessorChildKey(ChildKey childKey) {
        return this.children.getPredecessorKey(childKey);
    }

    @Override // com.google.firebase.database.snapshot.Node
    public Node getPriority() {
        return this.priority;
    }

    @Override // com.google.firebase.database.snapshot.Node
    public ChildKey getSuccessorChildKey(ChildKey childKey) {
        return this.children.getSuccessorKey(childKey);
    }

    @Override // com.google.firebase.database.snapshot.Node
    public Object getValue() {
        return getValue(false);
    }

    @Override // com.google.firebase.database.snapshot.Node
    public boolean hasChild(ChildKey childKey) {
        return !getImmediateChild(childKey).isEmpty();
    }

    public int hashCode() {
        Iterator<NamedNode> it = iterator();
        int i = 0;
        while (it.hasNext()) {
            NamedNode next = it.next();
            i = next.getNode().hashCode() + ((next.getName().hashCode() + (i * 31)) * 17);
        }
        return i;
    }

    @Override // com.google.firebase.database.snapshot.Node
    public boolean isEmpty() {
        return this.children.isEmpty();
    }

    @Override // com.google.firebase.database.snapshot.Node
    public boolean isLeafNode() {
        return false;
    }

    @Override // java.lang.Iterable
    public Iterator<NamedNode> iterator() {
        return new NamedNodeIterator(this.children.iterator());
    }

    @Override // com.google.firebase.database.snapshot.Node
    public Iterator<NamedNode> reverseIterator() {
        return new NamedNodeIterator(this.children.reverseIterator());
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        toString(sb, 0);
        return sb.toString();
    }

    @Override // com.google.firebase.database.snapshot.Node
    public Node updateChild(Path path, Node node) {
        ChildKey front = path.getFront();
        if (front == null) {
            return node;
        }
        if (front.isPriorityChildName()) {
            Utilities.hardAssert(PriorityUtilities.isValidPriority(node));
            return updatePriority(node);
        }
        return updateImmediateChild(front, getImmediateChild(front).updateChild(path.popFront(), node));
    }

    @Override // com.google.firebase.database.snapshot.Node
    public Node updateImmediateChild(ChildKey childKey, Node node) {
        if (childKey.isPriorityChildName()) {
            return updatePriority(node);
        }
        ImmutableSortedMap<ChildKey, Node> immutableSortedMap = this.children;
        if (immutableSortedMap.containsKey(childKey)) {
            immutableSortedMap = immutableSortedMap.remove(childKey);
        }
        if (!node.isEmpty()) {
            immutableSortedMap = immutableSortedMap.insert(childKey, node);
        }
        if (immutableSortedMap.isEmpty()) {
            return EmptyNode.Empty();
        }
        return new ChildrenNode(immutableSortedMap, this.priority);
    }

    @Override // com.google.firebase.database.snapshot.Node
    public Node updatePriority(Node node) {
        if (this.children.isEmpty()) {
            return EmptyNode.Empty();
        }
        return new ChildrenNode(this.children, node);
    }

    @Override // java.lang.Comparable
    public int compareTo(Node node) {
        if (isEmpty()) {
            return node.isEmpty() ? 0 : -1;
        }
        if (node.isLeafNode() || node.isEmpty()) {
            return 1;
        }
        return node == Node.MAX_NODE ? -1 : 0;
    }

    public void forEachChild(final ChildVisitor childVisitor, boolean z3) {
        if (z3 && !getPriority().isEmpty()) {
            this.children.inOrderTraversal(new LLRBNode.NodeVisitor<ChildKey, Node>() { // from class: com.google.firebase.database.snapshot.ChildrenNode.2
                boolean passedPriorityKey = false;

                @Override // com.google.firebase.database.collection.LLRBNode.NodeVisitor
                public void visitEntry(ChildKey childKey, Node node) {
                    if (!this.passedPriorityKey && childKey.compareTo(ChildKey.getPriorityKey()) > 0) {
                        this.passedPriorityKey = true;
                        childVisitor.visitChild(ChildKey.getPriorityKey(), ChildrenNode.this.getPriority());
                    }
                    childVisitor.visitChild(childKey, node);
                }
            });
        } else {
            this.children.inOrderTraversal(childVisitor);
        }
    }

    @Override // com.google.firebase.database.snapshot.Node
    public Object getValue(boolean z3) {
        Integer tryParseInt;
        if (isEmpty()) {
            return null;
        }
        HashMap hashMap = new HashMap();
        Iterator<Map.Entry<ChildKey, Node>> it = this.children.iterator();
        boolean z4 = true;
        int i = 0;
        int i3 = 0;
        while (it.hasNext()) {
            Map.Entry<ChildKey, Node> next = it.next();
            String asString = next.getKey().asString();
            hashMap.put(asString, next.getValue().getValue(z3));
            i++;
            if (z4) {
                if ((asString.length() > 1 && asString.charAt(0) == '0') || (tryParseInt = Utilities.tryParseInt(asString)) == null || tryParseInt.intValue() < 0) {
                    z4 = false;
                } else if (tryParseInt.intValue() > i3) {
                    i3 = tryParseInt.intValue();
                }
            }
        }
        if (!z3 && z4 && i3 < i * 2) {
            ArrayList arrayList = new ArrayList(i3 + 1);
            for (int i4 = 0; i4 <= i3; i4++) {
                arrayList.add(hashMap.get("" + i4));
            }
            return arrayList;
        }
        if (z3 && !this.priority.isEmpty()) {
            hashMap.put(".priority", this.priority.getValue());
        }
        return hashMap;
    }

    private void toString(StringBuilder sb, int i) {
        if (this.children.isEmpty() && this.priority.isEmpty()) {
            sb.append("{ }");
            return;
        }
        sb.append("{\n");
        Iterator<Map.Entry<ChildKey, Node>> it = this.children.iterator();
        while (it.hasNext()) {
            Map.Entry<ChildKey, Node> next = it.next();
            int i3 = i + 2;
            addIndentation(sb, i3);
            sb.append(next.getKey().asString());
            sb.append("=");
            if (next.getValue() instanceof ChildrenNode) {
                ((ChildrenNode) next.getValue()).toString(sb, i3);
            } else {
                sb.append(next.getValue().toString());
            }
            sb.append("\n");
        }
        if (!this.priority.isEmpty()) {
            addIndentation(sb, i + 2);
            sb.append(".priority=");
            sb.append(this.priority.toString());
            sb.append("\n");
        }
        addIndentation(sb, i);
        sb.append("}");
    }

    public ChildrenNode(ImmutableSortedMap<ChildKey, Node> immutableSortedMap, Node node) {
        this.lazyHash = null;
        if (immutableSortedMap.isEmpty() && !node.isEmpty()) {
            throw new IllegalArgumentException("Can't create empty ChildrenNode with priority!");
        }
        this.priority = node;
        this.children = immutableSortedMap;
    }
}
