package org.yaml.snakeyaml.comments;

import org.yaml.snakeyaml.error.Mark;
import org.yaml.snakeyaml.events.CommentEvent;

/* loaded from: classes2.dex */
public class CommentLine {
    private CommentType commentType;
    private Mark endMark;
    private Mark startMark;
    private String value;

    public CommentLine(CommentEvent commentEvent) {
        this(commentEvent.getStartMark(), commentEvent.getEndMark(), commentEvent.getValue(), commentEvent.getCommentType());
    }

    public CommentLine(Mark mark, Mark mark2, String str, CommentType commentType) {
        this.startMark = mark;
        this.endMark = mark2;
        this.value = str;
        this.commentType = commentType;
    }

    public Mark getEndMark() {
        return this.endMark;
    }

    public Mark getStartMark() {
        return this.startMark;
    }

    public CommentType getCommentType() {
        return this.commentType;
    }

    public String getValue() {
        return this.value;
    }

    public String toString() {
        return "<" + getClass().getName() + " (type=" + getCommentType() + ", value=" + getValue() + ")>";
    }
}
