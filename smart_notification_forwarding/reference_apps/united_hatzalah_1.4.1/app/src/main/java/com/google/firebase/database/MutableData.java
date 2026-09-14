package com.google.firebase.database;

import com.google.firebase.database.core.Path;
import com.google.firebase.database.core.SnapshotHolder;
import com.google.firebase.database.core.ValidationPath;
import com.google.firebase.database.core.utilities.Validation;
import com.google.firebase.database.core.utilities.encoding.CustomClassMapper;
import com.google.firebase.database.snapshot.ChildKey;
import com.google.firebase.database.snapshot.IndexedNode;
import com.google.firebase.database.snapshot.NamedNode;
import com.google.firebase.database.snapshot.Node;
import com.google.firebase.database.snapshot.NodeUtilities;
import com.google.firebase.database.snapshot.PriorityUtilities;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* loaded from: classes.dex */
public class MutableData {
    private final SnapshotHolder holder;
    private final Path prefixPath;

    public MutableData child(String str) {
        Validation.validatePathString(str);
        return new MutableData(this.holder, this.prefixPath.child(new Path(str)));
    }

    public boolean equals(Object obj) {
        if (obj instanceof MutableData) {
            MutableData mutableData = (MutableData) obj;
            if (this.holder.equals(mutableData.holder) && this.prefixPath.equals(mutableData.prefixPath)) {
                return true;
            }
            return false;
        }
        return false;
    }

    public Iterable<MutableData> getChildren() {
        Node node = getNode();
        if (!node.isEmpty() && !node.isLeafNode()) {
            final Iterator<NamedNode> it = IndexedNode.from(node).iterator();
            return new Iterable<MutableData>() { // from class: com.google.firebase.database.MutableData.2
                @Override // java.lang.Iterable
                public Iterator<MutableData> iterator() {
                    return new Iterator<MutableData>() { // from class: com.google.firebase.database.MutableData.2.1
                        @Override // java.util.Iterator
                        public boolean hasNext() {
                            return it.hasNext();
                        }

                        @Override // java.util.Iterator
                        public void remove() {
                            throw new UnsupportedOperationException("remove called on immutable collection");
                        }

                        /* JADX WARN: Can't rename method to resolve collision */
                        @Override // java.util.Iterator
                        public MutableData next() {
                            return new MutableData(MutableData.this.holder, MutableData.this.prefixPath.child(((NamedNode) it.next()).getName()));
                        }
                    };
                }
            };
        }
        return new Iterable<MutableData>() { // from class: com.google.firebase.database.MutableData.1
            @Override // java.lang.Iterable
            public Iterator<MutableData> iterator() {
                return new Iterator<MutableData>() { // from class: com.google.firebase.database.MutableData.1.1
                    @Override // java.util.Iterator
                    public boolean hasNext() {
                        return false;
                    }

                    @Override // java.util.Iterator
                    public void remove() {
                        throw new UnsupportedOperationException("remove called on immutable collection");
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // java.util.Iterator
                    public MutableData next() {
                        throw new NoSuchElementException();
                    }
                };
            }
        };
    }

    public long getChildrenCount() {
        return getNode().getChildCount();
    }

    public String getKey() {
        if (this.prefixPath.getBack() != null) {
            return this.prefixPath.getBack().asString();
        }
        return null;
    }

    public Node getNode() {
        return this.holder.getNode(this.prefixPath);
    }

    public Object getPriority() {
        return getNode().getPriority().getValue();
    }

    public Object getValue() {
        return getNode().getValue();
    }

    public boolean hasChild(String str) {
        return !getNode().getChild(new Path(str)).isEmpty();
    }

    public boolean hasChildren() {
        Node node = getNode();
        if (!node.isLeafNode() && !node.isEmpty()) {
            return true;
        }
        return false;
    }

    public void setPriority(Object obj) {
        this.holder.update(this.prefixPath, getNode().updatePriority(PriorityUtilities.parsePriority(this.prefixPath, obj)));
    }

    public void setValue(Object obj) {
        ValidationPath.validateWithObject(this.prefixPath, obj);
        Object convertToPlainJavaTypes = CustomClassMapper.convertToPlainJavaTypes(obj);
        Validation.validateWritableObject(convertToPlainJavaTypes);
        this.holder.update(this.prefixPath, NodeUtilities.NodeFromJSON(convertToPlainJavaTypes));
    }

    public String toString() {
        String str;
        ChildKey front = this.prefixPath.getFront();
        StringBuilder sb = new StringBuilder("MutableData { key = ");
        if (front != null) {
            str = front.asString();
        } else {
            str = "<none>";
        }
        sb.append(str);
        sb.append(", value = ");
        sb.append(this.holder.getRootNode().getValue(true));
        sb.append(" }");
        return sb.toString();
    }

    public MutableData(Node node) {
        this(new SnapshotHolder(node), new Path(""));
    }

    public <T> T getValue(Class<T> cls) {
        return (T) CustomClassMapper.convertToCustomClass(getNode().getValue(), cls);
    }

    private MutableData(SnapshotHolder snapshotHolder, Path path) {
        this.holder = snapshotHolder;
        this.prefixPath = path;
        ValidationPath.validateWithObject(path, getValue());
    }

    public <T> T getValue(GenericTypeIndicator<T> genericTypeIndicator) {
        return (T) CustomClassMapper.convertToCustomClass(getNode().getValue(), genericTypeIndicator);
    }
}
