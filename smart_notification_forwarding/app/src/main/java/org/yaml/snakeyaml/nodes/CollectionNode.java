package org.yaml.snakeyaml.nodes;

import java.util.List;
import org.yaml.snakeyaml.DumperOptions;
import org.yaml.snakeyaml.error.Mark;

/* loaded from: classes2.dex */
public abstract class CollectionNode<T> extends Node {
    private DumperOptions.FlowStyle flowStyle;

    public abstract List<T> getValue();

    public CollectionNode(Tag tag, Mark mark, Mark mark2, DumperOptions.FlowStyle flowStyle) {
        super(tag, mark, mark2);
        setFlowStyle(flowStyle);
    }

    @Deprecated
    public CollectionNode(Tag tag, Mark mark, Mark mark2, Boolean bool) {
        this(tag, mark, mark2, DumperOptions.FlowStyle.fromBoolean(bool));
    }

    public DumperOptions.FlowStyle getFlowStyle() {
        return this.flowStyle;
    }

    public void setFlowStyle(DumperOptions.FlowStyle flowStyle) {
        if (flowStyle == null) {
            throw new NullPointerException("Flow style must be provided.");
        }
        this.flowStyle = flowStyle;
    }

    @Deprecated
    public void setFlowStyle(Boolean bool) {
        setFlowStyle(DumperOptions.FlowStyle.fromBoolean(bool));
    }

    public void setEndMark(Mark mark) {
        this.endMark = mark;
    }
}
