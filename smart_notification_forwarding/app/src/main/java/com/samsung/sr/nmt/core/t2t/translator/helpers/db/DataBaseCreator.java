package com.samsung.sr.nmt.core.t2t.translator.helpers.db;

import android.content.Context;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DataBaseCreator.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003B\u0005¢\u0006\u0002\u0010\u0004J5\u0010\u0005\u001a\u00028\u00002\u0006\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\r¢\u0006\u0002\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/samsung/sr/nmt/core/t2t/translator/helpers/db/DataBaseCreator;", "T", "Landroidx/room/RoomDatabase;", JsonProperty.USE_DEFAULT_NAME, "()V", "createDataBase", "context", "Landroid/content/Context;", "directory", "Ljava/io/File;", "dbName", JsonProperty.USE_DEFAULT_NAME, "dbClass", "Ljava/lang/Class;", "(Landroid/content/Context;Ljava/io/File;Ljava/lang/String;Ljava/lang/Class;)Landroidx/room/RoomDatabase;", "translator_release"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class DataBaseCreator<T extends RoomDatabase> {
    public static /* synthetic */ RoomDatabase createDataBase$default(DataBaseCreator dataBaseCreator, Context context, File file, String str, Class cls, int i, Object obj) {
        if ((i & 2) != 0) {
            file = null;
        }
        return dataBaseCreator.createDataBase(context, file, str, cls);
    }

    public final T createDataBase(Context context, File directory, String dbName, Class<T> dbClass) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(dbName, "dbName");
        Intrinsics.checkNotNullParameter(dbClass, "dbClass");
        RoomDatabase.Builder<T> fallbackToDestructiveMigration = Room.databaseBuilder(context, dbClass, dbName).fallbackToDestructiveMigration();
        Intrinsics.checkNotNullExpressionValue(fallbackToDestructiveMigration, "fallbackToDestructiveMigration(...)");
        if (directory == null) {
            T build = fallbackToDestructiveMigration.createFromAsset(dbName).build();
            Intrinsics.checkNotNull(build);
            return build;
        }
        T build2 = fallbackToDestructiveMigration.createFromFile(new File(directory, dbName)).build();
        Intrinsics.checkNotNull(build2);
        return build2;
    }
}
