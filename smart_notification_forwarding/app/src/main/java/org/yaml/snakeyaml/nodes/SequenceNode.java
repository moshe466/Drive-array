package org.yaml.snakeyaml.nodes;

import java.util.Iterator;
import java.util.List;
import org.yaml.snakeyaml.DumperOptions;
import org.yaml.snakeyaml.error.Mark;

/* loaded from: classes2.dex */
public class SequenceNode extends CollectionNode<Node> {
    private final List<Node> value;

    public SequenceNode(Tag tag, boolean z, List<Node> list, Mark mark, Mark mark2, DumperOptions.FlowStyle flowStyle) {
        super(tag, mark, mark2, flowStyle);
        if (list == null) {
            throw new NullPointerException("value in a Node is required.");
        }
        this.value = list;
        this.resolved = z;
    }

    public SequenceNode(Tag tag, List<Node> list, DumperOptions.FlowStyle flowStyle) {
        this(tag, true, list, (Mark) null, (Mark) null, flowStyle);
    }

    @Deprecated
    public SequenceNode(Tag tag, List<Node> list, Boolean bool) {
        this(tag, list, DumperOptions.FlowStyle.fromBoolean(bool));
    }

    @Deprecated
    public SequenceNode(Tag tag, boolean z, List<Node> list, Mark mark, Mark mark2, Boolean bool) {
        this(tag, z, list, mark, mark2, DumperOptions.FlowStyle.fromBoolean(bool));
    }

    @Override // org.yaml.snakeyaml.nodes.Node
    public NodeId getNodeId() {
        return NodeId.sequence;
    }

    @Override // org.yaml.snakeyaml.nodes.CollectionNode
    public List<Node> getValue() {
        return this.value;
    }

    public void setListType(Class<? extends Object> cls) {
        Iterator<Node> it = this.value.iterator();
        while (it.hasNext()) {
            it.next().setType(cls);
        }
    }

    public String toString() {
        return "<" + getClass().getName() + " (tag=" + getTag() + ", value=" + getValue() + ")>";
    }
}
