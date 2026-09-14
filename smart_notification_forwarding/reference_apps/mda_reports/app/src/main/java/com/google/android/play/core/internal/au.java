package com.google.android.play.core.internal;

import java.io.File;
import java.io.IOException;
import java.util.List;

/* loaded from: classes.dex */
final class au implements aq {
    @Override // com.google.android.play.core.internal.aq
    public final Object[] a(Object obj, List<File> list, File file, List<IOException> list2) {
        return (Object[]) ba.a(obj, "makePathElements", Object[].class, (Class<List<File>>) List.class, list);
    }
}
