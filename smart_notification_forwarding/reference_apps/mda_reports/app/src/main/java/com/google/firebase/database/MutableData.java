package com.google.firebase.database;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
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

/* loaded from: classes2.dex */
public class MutableData {
    private final SnapshotHolder holder;
    private final Path prefixPath;

    private MutableData(SnapshotHolder snapshotHolder, Path path) {
        this.holder = snapshotHolder;
        this.prefixPath = path;
        ValidationPath.validateWithObject(this.prefixPath, getValue());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public MutableData(Node node) {
        this(new SnapshotHolder(node), new Path(""));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Node a() {
        return this.holder.getNode(this.prefixPath);
    }

    @NonNull
    public MutableData child(@NonNull String str) {
        Validation.validatePathString(str);
        return new MutableData(this.holder, this.prefixPath.child(new Path(str)));
    }

    public boolean equals(Object obj) {
        if (obj instanceof MutableData) {
            MutableData mutableData = (MutableData) obj;
            if (this.holder.equals(mutableData.holder) && this.prefixPath.equals(mutableData.prefixPath)) {
                return true;
            }
        }
        return false;
    }

    @NonNull
    public Iterable<MutableData> getChildren() {
        Node a = a();
        if (a.isEmpty() || a.isLeafNode()) {
            return new Iterable<MutableData>(this) { // from class: com.google.firebase.database.MutableData.1
                @Override // java.lang.Iterable
                public Iterator<MutableData> iterator() {
                    return new Iterator<MutableData>(this) { // from class: com.google.firebase.database.MutableData.1.1
                        @Override // java.util.Iterator
                        public boolean hasNext() {
                            return false;
                        }

                        /* JADX WARN: Can't rename method to resolve collision */
                        @Override // java.util.Iterator
                        @NonNull
                        public MutableData next() {
                            throw new NoSuchElementException();
                        }

                        @Override // java.util.Iterator
                        public void remove() {
                            throw new UnsupportedOperationException("remove called on immutable collection");
                        }
                    };
                }
            };
        }
        final Iterator<NamedNode> it = IndexedNode.from(a).iterator();
        return new Iterable<MutableData>() { // from class: com.google.firebase.database.MutableData.2
            @Override // java.lang.Iterable
            public Iterator<MutableData> iterator() {
                return new Iterator<MutableData>() { // from class: com.google.firebase.database.MutableData.2.1
                    @Override // java.util.Iterator
                    public boolean hasNext() {
                        return it.hasNext();
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // java.util.Iterator
                    @NonNull
                    public MutableData next() {
                        return new MutableData(MutableData.this.holder, MutableData.this.prefixPath.child(((NamedNode) it.next()).getName()));
                    }

                    @Override // java.util.Iterator
                    public void remove() {
                        throw new UnsupportedOperationException("remove called on immutable collection");
                    }
                };
            }
        };
    }

    public long getChildrenCount() {
        return a().getChildCount();
    }

    @Nullable
    public String getKey() {
        if (this.prefixPath.getBack() != null) {
            return this.prefixPath.getBack().asString();
        }
        return null;
    }

    @Nullable
    public Object getPriority() {
        return a().getPriority().getValue();
    }

    @Nullable
    public Object getValue() {
        return a().getValue();
    }

    @Nullable
    public <T> T getValue(@NonNull GenericTypeIndicator<T> genericTypeIndicator) {
        return (T) CustomClassMapper.convertToCustomClass(a().getValue(), genericTypeIndicator);
    }

    @Nullable
    public <T> T getValue(@NonNull Class<T> cls) {
        return (T) CustomClassMapper.convertToCustomClass(a().getValue(), cls);
    }

    public boolean hasChild(@NonNull String str) {
        return !a().getChild(new Path(str)).isEmpty();
    }

    public boolean hasChildren() {
        Node a = a();
        return (a.isLeafNode() || a.isEmpty()) ? false : true;
    }

    public void setPriority(@Nullable Object obj) {
        this.holder.update(this.prefixPath, a().updatePriority(PriorityUtilities.parsePriority(this.prefixPath, obj)));
    }

    public void setValue(@Nullable Object obj) {
        ValidationPath.validateWithObject(this.prefixPath, obj);
        Object convertToPlainJavaTypes = CustomClassMapper.convertToPlainJavaTypes(obj);
        Validation.validateWritableObject(convertToPlainJavaTypes);
        this.holder.update(this.prefixPath, NodeUtilities.NodeFromJSON(convertToPlainJavaTypes));
    }

    public String toString() {
        ChildKey front = this.prefixPath.getFront();
        StringBuilder sb = new StringBuilder();
        sb.append("MutableData { key = ");
        sb.append(front != null ? front.asString() : "<none>");
        sb.append(", value = ");
        sb.append(this.holder.getRootNode().getValue(true));
        sb.append(" }");
        return sb.toString();
    }
}
