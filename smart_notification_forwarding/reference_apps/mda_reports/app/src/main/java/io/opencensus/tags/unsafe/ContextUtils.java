package io.opencensus.tags.unsafe;

import io.grpc.Context;
import io.opencensus.internal.Utils;
import io.opencensus.tags.Tag;
import io.opencensus.tags.TagContext;
import java.util.Collections;
import java.util.Iterator;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;

/* loaded from: classes2.dex */
public final class ContextUtils {
    private static final TagContext EMPTY_TAG_CONTEXT = new EmptyTagContext();

    @Deprecated
    public static final Context.Key<TagContext> TAG_CONTEXT_KEY = Context.keyWithDefault("opencensus-tag-context-key", EMPTY_TAG_CONTEXT);

    @Immutable
    /* loaded from: classes2.dex */
    private static final class EmptyTagContext extends TagContext {
        private EmptyTagContext() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // io.opencensus.tags.TagContext
        public Iterator<Tag> a() {
            return Collections.emptySet().iterator();
        }
    }

    private ContextUtils() {
    }

    public static TagContext getValue(Context context) {
        TagContext tagContext = TAG_CONTEXT_KEY.get(context);
        return tagContext == null ? EMPTY_TAG_CONTEXT : tagContext;
    }

    public static Context withValue(Context context, @Nullable TagContext tagContext) {
        return ((Context) Utils.checkNotNull(context, "context")).withValue(TAG_CONTEXT_KEY, tagContext);
    }
}
