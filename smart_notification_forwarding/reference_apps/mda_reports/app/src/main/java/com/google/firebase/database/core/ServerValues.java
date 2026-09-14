package com.google.firebase.database.core;

import com.google.firebase.database.core.SparseSnapshotTree;
import com.google.firebase.database.core.utilities.Clock;
import com.google.firebase.database.snapshot.ChildKey;
import com.google.firebase.database.snapshot.ChildrenNode;
import com.google.firebase.database.snapshot.Node;
import com.google.firebase.database.snapshot.NodeUtilities;
import com.google.firebase.database.snapshot.PriorityUtilities;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes2.dex */
public class ServerValues {
    public static final String NAME_SUBKEY_SERVERVALUE = ".sv";

    public static Map<String, Object> generateServerValues(Clock clock) {
        HashMap hashMap = new HashMap();
        hashMap.put("timestamp", Long.valueOf(clock.millis()));
        return hashMap;
    }

    public static Object resolveDeferredValue(Object obj, Map<String, Object> map) {
        if (!(obj instanceof Map)) {
            return obj;
        }
        Map map2 = (Map) obj;
        if (!map2.containsKey(NAME_SUBKEY_SERVERVALUE)) {
            return obj;
        }
        String str = (String) map2.get(NAME_SUBKEY_SERVERVALUE);
        return map.containsKey(str) ? map.get(str) : obj;
    }

    public static CompoundWrite resolveDeferredValueMerge(CompoundWrite compoundWrite, Map<String, Object> map) {
        CompoundWrite emptyWrite = CompoundWrite.emptyWrite();
        Iterator<Map.Entry<Path, Node>> it = compoundWrite.iterator();
        while (it.hasNext()) {
            Map.Entry<Path, Node> next = it.next();
            emptyWrite = emptyWrite.addWrite(next.getKey(), resolveDeferredValueSnapshot(next.getValue(), map));
        }
        return emptyWrite;
    }

    public static Node resolveDeferredValueSnapshot(Node node, final Map<String, Object> map) {
        Object value = node.getPriority().getValue();
        if (value instanceof Map) {
            Map map2 = (Map) value;
            if (map2.containsKey(NAME_SUBKEY_SERVERVALUE)) {
                value = map.get((String) map2.get(NAME_SUBKEY_SERVERVALUE));
            }
        }
        Node parsePriority = PriorityUtilities.parsePriority(value);
        if (node.isLeafNode()) {
            Object resolveDeferredValue = resolveDeferredValue(node.getValue(), map);
            return (resolveDeferredValue.equals(node.getValue()) && parsePriority.equals(node.getPriority())) ? node : NodeUtilities.NodeFromJSON(resolveDeferredValue, parsePriority);
        }
        if (node.isEmpty()) {
            return node;
        }
        ChildrenNode childrenNode = (ChildrenNode) node;
        final SnapshotHolder snapshotHolder = new SnapshotHolder(childrenNode);
        childrenNode.forEachChild(new ChildrenNode.ChildVisitor() { // from class: com.google.firebase.database.core.ServerValues.2
            @Override // com.google.firebase.database.snapshot.ChildrenNode.ChildVisitor
            public void visitChild(ChildKey childKey, Node node2) {
                Node resolveDeferredValueSnapshot = ServerValues.resolveDeferredValueSnapshot(node2, map);
                if (resolveDeferredValueSnapshot != node2) {
                    snapshotHolder.update(new Path(childKey.asString()), resolveDeferredValueSnapshot);
                }
            }
        });
        return !snapshotHolder.getRootNode().getPriority().equals(parsePriority) ? snapshotHolder.getRootNode().updatePriority(parsePriority) : snapshotHolder.getRootNode();
    }

    public static SparseSnapshotTree resolveDeferredValueTree(SparseSnapshotTree sparseSnapshotTree, final Map<String, Object> map) {
        final SparseSnapshotTree sparseSnapshotTree2 = new SparseSnapshotTree();
        sparseSnapshotTree.forEachTree(new Path(""), new SparseSnapshotTree.SparseSnapshotTreeVisitor() { // from class: com.google.firebase.database.core.ServerValues.1
            @Override // com.google.firebase.database.core.SparseSnapshotTree.SparseSnapshotTreeVisitor
            public void visitTree(Path path, Node node) {
                SparseSnapshotTree.this.remember(path, ServerValues.resolveDeferredValueSnapshot(node, map));
            }
        });
        return sparseSnapshotTree2;
    }
}
