package com.google.firebase.database.core.utilities;

import com.google.firebase.database.core.Path;
import com.google.firebase.database.snapshot.ChildKey;
import java.util.Map;

/* loaded from: classes2.dex */
public class Tree<T> {
    private ChildKey name;
    private TreeNode<T> node;
    private Tree<T> parent;

    /* loaded from: classes2.dex */
    public interface TreeFilter<T> {
        boolean filterTreeNode(Tree<T> tree);
    }

    /* loaded from: classes2.dex */
    public interface TreeVisitor<T> {
        void visitTree(Tree<T> tree);
    }

    public Tree() {
        this(null, null, new TreeNode());
    }

    public Tree(ChildKey childKey, Tree<T> tree, TreeNode<T> treeNode) {
        this.name = childKey;
        this.parent = tree;
        this.node = treeNode;
    }

    private void updateChild(ChildKey childKey, Tree<T> tree) {
        boolean isEmpty = tree.isEmpty();
        boolean containsKey = this.node.children.containsKey(childKey);
        if (isEmpty && containsKey) {
            this.node.children.remove(childKey);
        } else if (isEmpty || containsKey) {
            return;
        } else {
            this.node.children.put(childKey, tree.node);
        }
        updateParents();
    }

    private void updateParents() {
        Tree<T> tree = this.parent;
        if (tree != null) {
            tree.updateChild(this.name, this);
        }
    }

    String a(String str) {
        ChildKey childKey = this.name;
        String asString = childKey == null ? "<anon>" : childKey.asString();
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(asString);
        sb.append("\n");
        sb.append(this.node.a(str + "\t"));
        return sb.toString();
    }

    public boolean forEachAncestor(TreeFilter<T> treeFilter) {
        return forEachAncestor(treeFilter, false);
    }

    public boolean forEachAncestor(TreeFilter<T> treeFilter, boolean z) {
        for (Tree<T> tree = z ? this : this.parent; tree != null; tree = tree.parent) {
            if (treeFilter.filterTreeNode(tree)) {
                return true;
            }
        }
        return false;
    }

    public void forEachChild(TreeVisitor<T> treeVisitor) {
        for (Object obj : this.node.children.entrySet().toArray()) {
            Map.Entry entry = (Map.Entry) obj;
            treeVisitor.visitTree(new Tree<>((ChildKey) entry.getKey(), this, (TreeNode) entry.getValue()));
        }
    }

    public void forEachDescendant(TreeVisitor<T> treeVisitor) {
        forEachDescendant(treeVisitor, false, false);
    }

    public void forEachDescendant(TreeVisitor<T> treeVisitor, boolean z) {
        forEachDescendant(treeVisitor, z, false);
    }

    public void forEachDescendant(final TreeVisitor<T> treeVisitor, boolean z, final boolean z2) {
        if (z && !z2) {
            treeVisitor.visitTree(this);
        }
        forEachChild(new TreeVisitor<T>(this) { // from class: com.google.firebase.database.core.utilities.Tree.1
            @Override // com.google.firebase.database.core.utilities.Tree.TreeVisitor
            public void visitTree(Tree<T> tree) {
                tree.forEachDescendant(treeVisitor, true, z2);
            }
        });
        if (z && z2) {
            treeVisitor.visitTree(this);
        }
    }

    public ChildKey getName() {
        return this.name;
    }

    public Tree<T> getParent() {
        return this.parent;
    }

    public Path getPath() {
        Tree<T> tree = this.parent;
        if (tree != null) {
            return tree.getPath().child(this.name);
        }
        ChildKey childKey = this.name;
        return childKey != null ? new Path(childKey) : Path.getEmptyPath();
    }

    public T getValue() {
        return this.node.value;
    }

    public boolean hasChildren() {
        return !this.node.children.isEmpty();
    }

    public boolean isEmpty() {
        TreeNode<T> treeNode = this.node;
        return treeNode.value == null && treeNode.children.isEmpty();
    }

    public TreeNode<T> lastNodeOnPath(Path path) {
        TreeNode<T> treeNode = this.node;
        ChildKey front = path.getFront();
        while (front != null) {
            TreeNode<T> treeNode2 = treeNode.children.containsKey(front) ? treeNode.children.get(front) : null;
            if (treeNode2 == null) {
                return treeNode;
            }
            path = path.popFront();
            TreeNode<T> treeNode3 = treeNode2;
            front = path.getFront();
            treeNode = treeNode3;
        }
        return treeNode;
    }

    public void setValue(T t) {
        this.node.value = t;
        updateParents();
    }

    public Tree<T> subTree(Path path) {
        ChildKey front = path.getFront();
        Path path2 = path;
        Tree<T> tree = this;
        while (front != null) {
            Tree<T> tree2 = new Tree<>(front, tree, tree.node.children.containsKey(front) ? tree.node.children.get(front) : new TreeNode<>());
            path2 = path2.popFront();
            front = path2.getFront();
            tree = tree2;
        }
        return tree;
    }

    public String toString() {
        return a("");
    }
}
