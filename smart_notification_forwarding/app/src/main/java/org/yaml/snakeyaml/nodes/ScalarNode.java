package org.yaml.snakeyaml.nodes;

import org.yaml.snakeyaml.DumperOptions;
import org.yaml.snakeyaml.error.Mark;

/* loaded from: classes2.dex */
public class ScalarNode extends Node {
    private DumperOptions.ScalarStyle style;
    private String value;

    public ScalarNode(Tag tag, String str, Mark mark, Mark mark2, DumperOptions.ScalarStyle scalarStyle) {
        this(tag, true, str, mark, mark2, scalarStyle);
    }

    public ScalarNode(Tag tag, boolean z, String str, Mark mark, Mark mark2, DumperOptions.ScalarStyle scalarStyle) {
        super(tag, mark, mark2);
        if (str == null) {
            throw new NullPointerException("value in a Node is required.");
        }
        this.value = str;
        if (scalarStyle == null) {
            throw new NullPointerException("Scalar style must be provided.");
        }
        this.style = scalarStyle;
        this.resolved = z;
    }

    @Deprecated
    public ScalarNode(Tag tag, String str, Mark mark, Mark mark2, Character ch) {
        this(tag, str, mark, mark2, DumperOptions.ScalarStyle.createStyle(ch));
    }

    @Deprecated
    public ScalarNode(Tag tag, boolean z, String str, Mark mark, Mark mark2, Character ch) {
        this(tag, z, str, mark, mark2, DumperOptions.ScalarStyle.createStyle(ch));
    }

    @Deprecated
    public Character getStyle() {
        return this.style.getChar();
    }

    public DumperOptions.ScalarStyle getScalarStyle() {
        return this.style;
    }

    @Override // org.yaml.snakeyaml.nodes.Node
    public NodeId getNodeId() {
        return NodeId.scalar;
    }

    public String getValue() {
        return this.value;
    }

    public String toString() {
        return "<" + getClass().getName() + " (tag=" + getTag() + ", value=" + getValue() + ")>";
    }

    public boolean isPlain() {
        return this.style == DumperOptions.ScalarStyle.PLAIN;
    }
}
