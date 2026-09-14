package com.samsung.sr.nmt.core.t2t.translator.helpers.db;

import android.content.Context;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ReplacePairDataBase.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b'\u0018\u0000 \u00072\u00020\u0001:\u0001\u0007B\u0005¢\u0006\u0002\u0010\u0002R\u0012\u0010\u0003\u001a\u00020\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/samsung/sr/nmt/core/t2t/translator/helpers/db/ReplacePairDataBase;", "Landroidx/room/RoomDatabase;", "()V", "replacePairDao", "Lcom/samsung/sr/nmt/core/t2t/translator/helpers/db/ReplacePairDao;", "getReplacePairDao", "()Lcom/samsung/sr/nmt/core/t2t/translator/helpers/db/ReplacePairDao;", "Companion", "translator_release"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public abstract class ReplacePairDataBase extends RoomDatabase {
    private static final String SOURCE_PATH = "replace-pairs.db";
    private static ReplacePairDataBase replacePairDataBaseInstance;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final ReentrantLock lock = new ReentrantLock();

    public abstract ReplacePairDao getReplacePairDao();

    /* compiled from: ReplacePairDataBase.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u000bH\u0002J\u0010\u0010\f\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u000bH\u0002J\u000e\u0010\r\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u000bR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/samsung/sr/nmt/core/t2t/translator/helpers/db/ReplacePairDataBase$Companion;", JsonProperty.USE_DEFAULT_NAME, "()V", "SOURCE_PATH", JsonProperty.USE_DEFAULT_NAME, "lock", "Ljava/util/concurrent/locks/ReentrantLock;", "replacePairDataBaseInstance", "Lcom/samsung/sr/nmt/core/t2t/translator/helpers/db/ReplacePairDataBase;", "checkInstanceNullConcurrent", "context", "Landroid/content/Context;", "createReplacePairDataBase", "getInstance", "translator_release"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    /* loaded from: classes.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final ReplacePairDataBase getInstance(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            ReplacePairDataBase replacePairDataBase = ReplacePairDataBase.replacePairDataBaseInstance;
            return replacePairDataBase == null ? checkInstanceNullConcurrent(context) : replacePairDataBase;
        }

        private final ReplacePairDataBase checkInstanceNullConcurrent(Context context) {
            ReentrantLock reentrantLock = ReplacePairDataBase.lock;
            reentrantLock.lock();
            try {
                ReplacePairDataBase replacePairDataBase = ReplacePairDataBase.replacePairDataBaseInstance;
                if (replacePairDataBase == null) {
                    replacePairDataBase = ReplacePairDataBase.INSTANCE.createReplacePairDataBase(context);
                }
                return replacePairDataBase;
            } finally {
                reentrantLock.unlock();
            }
        }

        private final ReplacePairDataBase createReplacePairDataBase(Context context) {
            RoomDatabase.Builder fallbackToDestructiveMigration = Room.databaseBuilder(context, ReplacePairDataBase.class, ReplacePairDataBase.SOURCE_PATH).fallbackToDestructiveMigration();
            Intrinsics.checkNotNullExpressionValue(fallbackToDestructiveMigration, "fallbackToDestructiveMigration(...)");
            ReplacePairDataBase.replacePairDataBaseInstance = (ReplacePairDataBase) fallbackToDestructiveMigration.createFromAsset(ReplacePairDataBase.SOURCE_PATH).build();
            ReplacePairDataBase replacePairDataBase = ReplacePairDataBase.replacePairDataBaseInstance;
            Intrinsics.checkNotNull(replacePairDataBase);
            return replacePairDataBase;
        }
    }
}
