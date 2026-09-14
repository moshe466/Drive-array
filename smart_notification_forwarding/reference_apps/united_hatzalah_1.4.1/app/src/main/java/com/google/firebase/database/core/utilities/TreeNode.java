package com.google.firebase.database.core.utilities;

import F0.AbstractC0008a;
import com.google.firebase.database.snapshot.ChildKey;
import e0.a;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public class TreeNode<T> {
    public Map<ChildKey, TreeNode<T>> children = new HashMap();
    public T value;

    public String toString(String str) {
        StringBuilder i = a.i(str, "<value>: ");
        i.append(this.value);
        i.append("\n");
        String sb = i.toString();
        if (this.children.isEmpty()) {
            return AbstractC0008a.o(sb, str, "<empty>");
        }
        for (Map.Entry<ChildKey, TreeNode<T>> entry : this.children.entrySet()) {
            StringBuilder i3 = a.i(sb, str);
            i3.append(entry.getKey());
            i3.append(":\n");
            i3.append(entry.getValue().toString(str + "\t"));
            i3.append("\n");
            sb = i3.toString();
        }
        return sb;
    }
}
