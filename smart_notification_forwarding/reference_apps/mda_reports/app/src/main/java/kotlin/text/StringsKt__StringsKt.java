package kotlin.text;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ReplaceWith;
import kotlin.SinceKotlin;
import kotlin.TuplesKt;
import kotlin.TypeCastException;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CharIterator;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.internal.InlineOnly;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntProgression;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt___RangesKt;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt___SequencesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000|\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\f\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0019\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\b\n\u0002\u0010\u0011\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u001b\u001a\u001c\u0010\t\u001a\u00020\n*\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u00022\b\b\u0002\u0010\f\u001a\u00020\r\u001a\u001c\u0010\u000e\u001a\u00020\n*\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u00022\b\b\u0002\u0010\f\u001a\u00020\r\u001a\u001f\u0010\u000f\u001a\u00020\r*\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\f\u001a\u00020\rH\u0086\u0002\u001a\u001f\u0010\u000f\u001a\u00020\r*\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u00022\b\b\u0002\u0010\f\u001a\u00020\rH\u0086\u0002\u001a\u0015\u0010\u000f\u001a\u00020\r*\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u0013H\u0087\n\u001a\u001c\u0010\u0014\u001a\u00020\r*\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\f\u001a\u00020\r\u001a\u001c\u0010\u0014\u001a\u00020\r*\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u00022\b\b\u0002\u0010\f\u001a\u00020\r\u001a:\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\n\u0018\u00010\u0017*\u00020\u00022\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\n0\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u00062\b\b\u0002\u0010\f\u001a\u00020\r\u001aE\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\n\u0018\u00010\u0017*\u00020\u00022\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\n0\u00192\u0006\u0010\u001a\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u001b\u001a\u00020\rH\u0002¢\u0006\u0002\b\u001c\u001a:\u0010\u001d\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\n\u0018\u00010\u0017*\u00020\u00022\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\n0\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u00062\b\b\u0002\u0010\f\u001a\u00020\r\u001a\u0012\u0010\u001e\u001a\u00020\r*\u00020\u00022\u0006\u0010\u001f\u001a\u00020\u0006\u001a4\u0010 \u001a\u0002H!\"\f\b\u0000\u0010\"*\u00020\u0002*\u0002H!\"\u0004\b\u0001\u0010!*\u0002H\"2\f\u0010#\u001a\b\u0012\u0004\u0012\u0002H!0$H\u0087\b¢\u0006\u0002\u0010%\u001a4\u0010&\u001a\u0002H!\"\f\b\u0000\u0010\"*\u00020\u0002*\u0002H!\"\u0004\b\u0001\u0010!*\u0002H\"2\f\u0010#\u001a\b\u0012\u0004\u0012\u0002H!0$H\u0087\b¢\u0006\u0002\u0010%\u001a&\u0010'\u001a\u00020\u0006*\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u001a\u001a\u00020\u00062\b\b\u0002\u0010\f\u001a\u00020\r\u001a;\u0010'\u001a\u00020\u0006*\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u00062\u0006\u0010(\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u001b\u001a\u00020\rH\u0002¢\u0006\u0002\b)\u001a&\u0010'\u001a\u00020\u0006*\u00020\u00022\u0006\u0010*\u001a\u00020\n2\b\b\u0002\u0010\u001a\u001a\u00020\u00062\b\b\u0002\u0010\f\u001a\u00020\r\u001a&\u0010+\u001a\u00020\u0006*\u00020\u00022\u0006\u0010,\u001a\u00020-2\b\b\u0002\u0010\u001a\u001a\u00020\u00062\b\b\u0002\u0010\f\u001a\u00020\r\u001a,\u0010+\u001a\u00020\u0006*\u00020\u00022\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\n0\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u00062\b\b\u0002\u0010\f\u001a\u00020\r\u001a\r\u0010.\u001a\u00020\r*\u00020\u0002H\u0087\b\u001a\r\u0010/\u001a\u00020\r*\u00020\u0002H\u0087\b\u001a\r\u00100\u001a\u00020\r*\u00020\u0002H\u0087\b\u001a \u00101\u001a\u00020\r*\u0004\u0018\u00010\u0002H\u0087\b\u0082\u0002\u000e\n\f\b\u0000\u0012\u0002\u0018\u0001\u001a\u0004\b\u0003\u0010\u0000\u001a \u00102\u001a\u00020\r*\u0004\u0018\u00010\u0002H\u0087\b\u0082\u0002\u000e\n\f\b\u0000\u0012\u0002\u0018\u0001\u001a\u0004\b\u0003\u0010\u0000\u001a\r\u00103\u001a\u000204*\u00020\u0002H\u0086\u0002\u001a&\u00105\u001a\u00020\u0006*\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u001a\u001a\u00020\u00062\b\b\u0002\u0010\f\u001a\u00020\r\u001a&\u00105\u001a\u00020\u0006*\u00020\u00022\u0006\u0010*\u001a\u00020\n2\b\b\u0002\u0010\u001a\u001a\u00020\u00062\b\b\u0002\u0010\f\u001a\u00020\r\u001a&\u00106\u001a\u00020\u0006*\u00020\u00022\u0006\u0010,\u001a\u00020-2\b\b\u0002\u0010\u001a\u001a\u00020\u00062\b\b\u0002\u0010\f\u001a\u00020\r\u001a,\u00106\u001a\u00020\u0006*\u00020\u00022\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\n0\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u00062\b\b\u0002\u0010\f\u001a\u00020\r\u001a\u0010\u00107\u001a\b\u0012\u0004\u0012\u00020\n08*\u00020\u0002\u001a\u0010\u00109\u001a\b\u0012\u0004\u0012\u00020\n0:*\u00020\u0002\u001a\u0015\u0010;\u001a\u00020\r*\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u0013H\u0087\f\u001a\u000f\u0010<\u001a\u00020\n*\u0004\u0018\u00010\nH\u0087\b\u001a\u001c\u0010=\u001a\u00020\u0002*\u00020\u00022\u0006\u0010>\u001a\u00020\u00062\b\b\u0002\u0010?\u001a\u00020\u0011\u001a\u001c\u0010=\u001a\u00020\n*\u00020\n2\u0006\u0010>\u001a\u00020\u00062\b\b\u0002\u0010?\u001a\u00020\u0011\u001a\u001c\u0010@\u001a\u00020\u0002*\u00020\u00022\u0006\u0010>\u001a\u00020\u00062\b\b\u0002\u0010?\u001a\u00020\u0011\u001a\u001c\u0010@\u001a\u00020\n*\u00020\n2\u0006\u0010>\u001a\u00020\u00062\b\b\u0002\u0010?\u001a\u00020\u0011\u001aG\u0010A\u001a\b\u0012\u0004\u0012\u00020\u000108*\u00020\u00022\u000e\u0010B\u001a\n\u0012\u0006\b\u0001\u0012\u00020\n0C2\b\b\u0002\u0010\u001a\u001a\u00020\u00062\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010D\u001a\u00020\u0006H\u0002¢\u0006\u0004\bE\u0010F\u001a=\u0010A\u001a\b\u0012\u0004\u0012\u00020\u000108*\u00020\u00022\u0006\u0010B\u001a\u00020-2\b\b\u0002\u0010\u001a\u001a\u00020\u00062\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010D\u001a\u00020\u0006H\u0002¢\u0006\u0002\bE\u001a4\u0010G\u001a\u00020\r*\u00020\u00022\u0006\u0010H\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010I\u001a\u00020\u00062\u0006\u0010>\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\rH\u0000\u001a\u0012\u0010J\u001a\u00020\u0002*\u00020\u00022\u0006\u0010K\u001a\u00020\u0002\u001a\u0012\u0010J\u001a\u00020\n*\u00020\n2\u0006\u0010K\u001a\u00020\u0002\u001a\u001a\u0010L\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u00062\u0006\u0010(\u001a\u00020\u0006\u001a\u0012\u0010L\u001a\u00020\u0002*\u00020\u00022\u0006\u0010M\u001a\u00020\u0001\u001a\u001d\u0010L\u001a\u00020\n*\u00020\n2\u0006\u0010\u001a\u001a\u00020\u00062\u0006\u0010(\u001a\u00020\u0006H\u0087\b\u001a\u0015\u0010L\u001a\u00020\n*\u00020\n2\u0006\u0010M\u001a\u00020\u0001H\u0087\b\u001a\u0012\u0010N\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0002\u001a\u0012\u0010N\u001a\u00020\n*\u00020\n2\u0006\u0010\u0015\u001a\u00020\u0002\u001a\u0012\u0010O\u001a\u00020\u0002*\u00020\u00022\u0006\u0010P\u001a\u00020\u0002\u001a\u001a\u0010O\u001a\u00020\u0002*\u00020\u00022\u0006\u0010K\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0002\u001a\u0012\u0010O\u001a\u00020\n*\u00020\n2\u0006\u0010P\u001a\u00020\u0002\u001a\u001a\u0010O\u001a\u00020\n*\u00020\n2\u0006\u0010K\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0002\u001a+\u0010Q\u001a\u00020\n*\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u00132\u0014\b\b\u0010R\u001a\u000e\u0012\u0004\u0012\u00020T\u0012\u0004\u0012\u00020\u00020SH\u0087\b\u001a\u001d\u0010Q\u001a\u00020\n*\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010U\u001a\u00020\nH\u0087\b\u001a$\u0010V\u001a\u00020\n*\u00020\n2\u0006\u0010P\u001a\u00020\u00112\u0006\u0010U\u001a\u00020\n2\b\b\u0002\u0010W\u001a\u00020\n\u001a$\u0010V\u001a\u00020\n*\u00020\n2\u0006\u0010P\u001a\u00020\n2\u0006\u0010U\u001a\u00020\n2\b\b\u0002\u0010W\u001a\u00020\n\u001a$\u0010X\u001a\u00020\n*\u00020\n2\u0006\u0010P\u001a\u00020\u00112\u0006\u0010U\u001a\u00020\n2\b\b\u0002\u0010W\u001a\u00020\n\u001a$\u0010X\u001a\u00020\n*\u00020\n2\u0006\u0010P\u001a\u00020\n2\u0006\u0010U\u001a\u00020\n2\b\b\u0002\u0010W\u001a\u00020\n\u001a$\u0010Y\u001a\u00020\n*\u00020\n2\u0006\u0010P\u001a\u00020\u00112\u0006\u0010U\u001a\u00020\n2\b\b\u0002\u0010W\u001a\u00020\n\u001a$\u0010Y\u001a\u00020\n*\u00020\n2\u0006\u0010P\u001a\u00020\n2\u0006\u0010U\u001a\u00020\n2\b\b\u0002\u0010W\u001a\u00020\n\u001a$\u0010Z\u001a\u00020\n*\u00020\n2\u0006\u0010P\u001a\u00020\u00112\u0006\u0010U\u001a\u00020\n2\b\b\u0002\u0010W\u001a\u00020\n\u001a$\u0010Z\u001a\u00020\n*\u00020\n2\u0006\u0010P\u001a\u00020\n2\u0006\u0010U\u001a\u00020\n2\b\b\u0002\u0010W\u001a\u00020\n\u001a\u001d\u0010[\u001a\u00020\n*\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010U\u001a\u00020\nH\u0087\b\u001a\"\u0010\\\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u00062\u0006\u0010(\u001a\u00020\u00062\u0006\u0010U\u001a\u00020\u0002\u001a\u001a\u0010\\\u001a\u00020\u0002*\u00020\u00022\u0006\u0010M\u001a\u00020\u00012\u0006\u0010U\u001a\u00020\u0002\u001a%\u0010\\\u001a\u00020\n*\u00020\n2\u0006\u0010\u001a\u001a\u00020\u00062\u0006\u0010(\u001a\u00020\u00062\u0006\u0010U\u001a\u00020\u0002H\u0087\b\u001a\u001d\u0010\\\u001a\u00020\n*\u00020\n2\u0006\u0010M\u001a\u00020\u00012\u0006\u0010U\u001a\u00020\u0002H\u0087\b\u001a=\u0010]\u001a\b\u0012\u0004\u0012\u00020\n0:*\u00020\u00022\u0012\u0010B\u001a\n\u0012\u0006\b\u0001\u0012\u00020\n0C\"\u00020\n2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010D\u001a\u00020\u0006¢\u0006\u0002\u0010^\u001a0\u0010]\u001a\b\u0012\u0004\u0012\u00020\n0:*\u00020\u00022\n\u0010B\u001a\u00020-\"\u00020\u00112\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010D\u001a\u00020\u0006\u001a/\u0010]\u001a\b\u0012\u0004\u0012\u00020\n0:*\u00020\u00022\u0006\u0010P\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010D\u001a\u00020\u0006H\u0002¢\u0006\u0002\b_\u001a%\u0010]\u001a\b\u0012\u0004\u0012\u00020\n0:*\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010D\u001a\u00020\u0006H\u0087\b\u001a=\u0010`\u001a\b\u0012\u0004\u0012\u00020\n08*\u00020\u00022\u0012\u0010B\u001a\n\u0012\u0006\b\u0001\u0012\u00020\n0C\"\u00020\n2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010D\u001a\u00020\u0006¢\u0006\u0002\u0010a\u001a0\u0010`\u001a\b\u0012\u0004\u0012\u00020\n08*\u00020\u00022\n\u0010B\u001a\u00020-\"\u00020\u00112\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010D\u001a\u00020\u0006\u001a\u001c\u0010b\u001a\u00020\r*\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\f\u001a\u00020\r\u001a\u001c\u0010b\u001a\u00020\r*\u00020\u00022\u0006\u0010K\u001a\u00020\u00022\b\b\u0002\u0010\f\u001a\u00020\r\u001a$\u0010b\u001a\u00020\r*\u00020\u00022\u0006\u0010K\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u00062\b\b\u0002\u0010\f\u001a\u00020\r\u001a\u0012\u0010c\u001a\u00020\u0002*\u00020\u00022\u0006\u0010M\u001a\u00020\u0001\u001a\u001d\u0010c\u001a\u00020\u0002*\u00020\n2\u0006\u0010d\u001a\u00020\u00062\u0006\u0010e\u001a\u00020\u0006H\u0087\b\u001a\u001f\u0010f\u001a\u00020\n*\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u00062\b\b\u0002\u0010(\u001a\u00020\u0006H\u0087\b\u001a\u0012\u0010f\u001a\u00020\n*\u00020\u00022\u0006\u0010M\u001a\u00020\u0001\u001a\u0012\u0010f\u001a\u00020\n*\u00020\n2\u0006\u0010M\u001a\u00020\u0001\u001a\u001c\u0010g\u001a\u00020\n*\u00020\n2\u0006\u0010P\u001a\u00020\u00112\b\b\u0002\u0010W\u001a\u00020\n\u001a\u001c\u0010g\u001a\u00020\n*\u00020\n2\u0006\u0010P\u001a\u00020\n2\b\b\u0002\u0010W\u001a\u00020\n\u001a\u001c\u0010h\u001a\u00020\n*\u00020\n2\u0006\u0010P\u001a\u00020\u00112\b\b\u0002\u0010W\u001a\u00020\n\u001a\u001c\u0010h\u001a\u00020\n*\u00020\n2\u0006\u0010P\u001a\u00020\n2\b\b\u0002\u0010W\u001a\u00020\n\u001a\u001c\u0010i\u001a\u00020\n*\u00020\n2\u0006\u0010P\u001a\u00020\u00112\b\b\u0002\u0010W\u001a\u00020\n\u001a\u001c\u0010i\u001a\u00020\n*\u00020\n2\u0006\u0010P\u001a\u00020\n2\b\b\u0002\u0010W\u001a\u00020\n\u001a\u001c\u0010j\u001a\u00020\n*\u00020\n2\u0006\u0010P\u001a\u00020\u00112\b\b\u0002\u0010W\u001a\u00020\n\u001a\u001c\u0010j\u001a\u00020\n*\u00020\n2\u0006\u0010P\u001a\u00020\n2\b\b\u0002\u0010W\u001a\u00020\n\u001a\n\u0010k\u001a\u00020\u0002*\u00020\u0002\u001a!\u0010k\u001a\u00020\u0002*\u00020\u00022\u0012\u0010l\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\r0SH\u0086\b\u001a\u0016\u0010k\u001a\u00020\u0002*\u00020\u00022\n\u0010,\u001a\u00020-\"\u00020\u0011\u001a\r\u0010k\u001a\u00020\n*\u00020\nH\u0087\b\u001a!\u0010k\u001a\u00020\n*\u00020\n2\u0012\u0010l\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\r0SH\u0086\b\u001a\u0016\u0010k\u001a\u00020\n*\u00020\n2\n\u0010,\u001a\u00020-\"\u00020\u0011\u001a\n\u0010m\u001a\u00020\u0002*\u00020\u0002\u001a!\u0010m\u001a\u00020\u0002*\u00020\u00022\u0012\u0010l\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\r0SH\u0086\b\u001a\u0016\u0010m\u001a\u00020\u0002*\u00020\u00022\n\u0010,\u001a\u00020-\"\u00020\u0011\u001a\r\u0010m\u001a\u00020\n*\u00020\nH\u0087\b\u001a!\u0010m\u001a\u00020\n*\u00020\n2\u0012\u0010l\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\r0SH\u0086\b\u001a\u0016\u0010m\u001a\u00020\n*\u00020\n2\n\u0010,\u001a\u00020-\"\u00020\u0011\u001a\n\u0010n\u001a\u00020\u0002*\u00020\u0002\u001a!\u0010n\u001a\u00020\u0002*\u00020\u00022\u0012\u0010l\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\r0SH\u0086\b\u001a\u0016\u0010n\u001a\u00020\u0002*\u00020\u00022\n\u0010,\u001a\u00020-\"\u00020\u0011\u001a\r\u0010n\u001a\u00020\n*\u00020\nH\u0087\b\u001a!\u0010n\u001a\u00020\n*\u00020\n2\u0012\u0010l\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\r0SH\u0086\b\u001a\u0016\u0010n\u001a\u00020\n*\u00020\n2\n\u0010,\u001a\u00020-\"\u00020\u0011\"\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\"\u0015\u0010\u0005\u001a\u00020\u0006*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006o"}, d2 = {"indices", "Lkotlin/ranges/IntRange;", "", "getIndices", "(Ljava/lang/CharSequence;)Lkotlin/ranges/IntRange;", "lastIndex", "", "getLastIndex", "(Ljava/lang/CharSequence;)I", "commonPrefixWith", "", "other", "ignoreCase", "", "commonSuffixWith", "contains", "char", "", "regex", "Lkotlin/text/Regex;", "endsWith", "suffix", "findAnyOf", "Lkotlin/Pair;", "strings", "", "startIndex", "last", "findAnyOf$StringsKt__StringsKt", "findLastAnyOf", "hasSurrogatePairAt", FirebaseAnalytics.Param.INDEX, "ifBlank", "R", "C", "defaultValue", "Lkotlin/Function0;", "(Ljava/lang/CharSequence;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "ifEmpty", "indexOf", "endIndex", "indexOf$StringsKt__StringsKt", "string", "indexOfAny", "chars", "", "isEmpty", "isNotBlank", "isNotEmpty", "isNullOrBlank", "isNullOrEmpty", "iterator", "Lkotlin/collections/CharIterator;", "lastIndexOf", "lastIndexOfAny", "lineSequence", "Lkotlin/sequences/Sequence;", "lines", "", "matches", "orEmpty", "padEnd", "length", "padChar", "padStart", "rangesDelimitedBy", "delimiters", "", "limit", "rangesDelimitedBy$StringsKt__StringsKt", "(Ljava/lang/CharSequence;[Ljava/lang/String;IZI)Lkotlin/sequences/Sequence;", "regionMatchesImpl", "thisOffset", "otherOffset", "removePrefix", "prefix", "removeRange", "range", "removeSuffix", "removeSurrounding", "delimiter", "replace", "transform", "Lkotlin/Function1;", "Lkotlin/text/MatchResult;", "replacement", "replaceAfter", "missingDelimiterValue", "replaceAfterLast", "replaceBefore", "replaceBeforeLast", "replaceFirst", "replaceRange", "split", "(Ljava/lang/CharSequence;[Ljava/lang/String;ZI)Ljava/util/List;", "split$StringsKt__StringsKt", "splitToSequence", "(Ljava/lang/CharSequence;[Ljava/lang/String;ZI)Lkotlin/sequences/Sequence;", "startsWith", "subSequence", "start", "end", "substring", "substringAfter", "substringAfterLast", "substringBefore", "substringBeforeLast", "trim", "predicate", "trimEnd", "trimStart", "kotlin-stdlib"}, k = 5, mv = {1, 1, 15}, xi = 1, xs = "kotlin/text/StringsKt")
/* loaded from: classes.dex */
public class StringsKt__StringsKt extends StringsKt__StringsJVMKt {
    static /* synthetic */ int a(CharSequence charSequence, CharSequence charSequence2, int i, int i2, boolean z, boolean z2, int i3, Object obj) {
        return indexOf$StringsKt__StringsKt(charSequence, charSequence2, i, i2, z, (i3 & 16) != 0 ? false : z2);
    }

    static /* synthetic */ Sequence a(CharSequence charSequence, char[] cArr, int i, boolean z, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            z = false;
        }
        if ((i3 & 8) != 0) {
            i2 = 0;
        }
        return rangesDelimitedBy$StringsKt__StringsKt(charSequence, cArr, i, z, i2);
    }

    static /* synthetic */ Sequence a(CharSequence charSequence, String[] strArr, int i, boolean z, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            z = false;
        }
        if ((i3 & 8) != 0) {
            i2 = 0;
        }
        return rangesDelimitedBy$StringsKt__StringsKt(charSequence, strArr, i, z, i2);
    }

    @NotNull
    public static final String commonPrefixWith(@NotNull CharSequence commonPrefixWith, @NotNull CharSequence other, boolean z) {
        Intrinsics.checkParameterIsNotNull(commonPrefixWith, "$this$commonPrefixWith");
        Intrinsics.checkParameterIsNotNull(other, "other");
        int min = Math.min(commonPrefixWith.length(), other.length());
        int i = 0;
        while (i < min && CharsKt__CharKt.equals(commonPrefixWith.charAt(i), other.charAt(i), z)) {
            i++;
        }
        int i2 = i - 1;
        if (hasSurrogatePairAt(commonPrefixWith, i2) || hasSurrogatePairAt(other, i2)) {
            i--;
        }
        return commonPrefixWith.subSequence(0, i).toString();
    }

    public static /* synthetic */ String commonPrefixWith$default(CharSequence charSequence, CharSequence charSequence2, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return commonPrefixWith(charSequence, charSequence2, z);
    }

    @NotNull
    public static final String commonSuffixWith(@NotNull CharSequence commonSuffixWith, @NotNull CharSequence other, boolean z) {
        Intrinsics.checkParameterIsNotNull(commonSuffixWith, "$this$commonSuffixWith");
        Intrinsics.checkParameterIsNotNull(other, "other");
        int length = commonSuffixWith.length();
        int min = Math.min(length, other.length());
        int i = 0;
        while (i < min && CharsKt__CharKt.equals(commonSuffixWith.charAt((length - i) - 1), other.charAt((r1 - i) - 1), z)) {
            i++;
        }
        if (hasSurrogatePairAt(commonSuffixWith, (length - i) - 1) || hasSurrogatePairAt(other, (r1 - i) - 1)) {
            i--;
        }
        return commonSuffixWith.subSequence(length - i, length).toString();
    }

    public static /* synthetic */ String commonSuffixWith$default(CharSequence charSequence, CharSequence charSequence2, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return commonSuffixWith(charSequence, charSequence2, z);
    }

    public static final boolean contains(@NotNull CharSequence contains, char c, boolean z) {
        int indexOf$default;
        Intrinsics.checkParameterIsNotNull(contains, "$this$contains");
        indexOf$default = indexOf$default(contains, c, 0, z, 2, (Object) null);
        return indexOf$default >= 0;
    }

    public static final boolean contains(@NotNull CharSequence contains, @NotNull CharSequence other, boolean z) {
        Intrinsics.checkParameterIsNotNull(contains, "$this$contains");
        Intrinsics.checkParameterIsNotNull(other, "other");
        if (other instanceof String) {
            if (indexOf$default(contains, (String) other, 0, z, 2, (Object) null) >= 0) {
                return true;
            }
        } else if (a(contains, other, 0, contains.length(), z, false, 16, null) >= 0) {
            return true;
        }
        return false;
    }

    @InlineOnly
    private static final boolean contains(@NotNull CharSequence contains, Regex regex) {
        Intrinsics.checkParameterIsNotNull(contains, "$this$contains");
        return regex.containsMatchIn(contains);
    }

    public static /* synthetic */ boolean contains$default(CharSequence charSequence, char c, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return contains(charSequence, c, z);
    }

    public static /* synthetic */ boolean contains$default(CharSequence charSequence, CharSequence charSequence2, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return contains(charSequence, charSequence2, z);
    }

    public static final boolean endsWith(@NotNull CharSequence endsWith, char c, boolean z) {
        Intrinsics.checkParameterIsNotNull(endsWith, "$this$endsWith");
        return endsWith.length() > 0 && CharsKt__CharKt.equals(endsWith.charAt(getLastIndex(endsWith)), c, z);
    }

    public static final boolean endsWith(@NotNull CharSequence endsWith, @NotNull CharSequence suffix, boolean z) {
        Intrinsics.checkParameterIsNotNull(endsWith, "$this$endsWith");
        Intrinsics.checkParameterIsNotNull(suffix, "suffix");
        return (!z && (endsWith instanceof String) && (suffix instanceof String)) ? StringsKt__StringsJVMKt.endsWith$default((String) endsWith, (String) suffix, false, 2, null) : regionMatchesImpl(endsWith, endsWith.length() - suffix.length(), suffix, 0, suffix.length(), z);
    }

    public static /* synthetic */ boolean endsWith$default(CharSequence charSequence, char c, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return endsWith(charSequence, c, z);
    }

    public static /* synthetic */ boolean endsWith$default(CharSequence charSequence, CharSequence charSequence2, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return endsWith(charSequence, charSequence2, z);
    }

    @Nullable
    public static final Pair<Integer, String> findAnyOf(@NotNull CharSequence findAnyOf, @NotNull Collection<String> strings, int i, boolean z) {
        Intrinsics.checkParameterIsNotNull(findAnyOf, "$this$findAnyOf");
        Intrinsics.checkParameterIsNotNull(strings, "strings");
        return findAnyOf$StringsKt__StringsKt(findAnyOf, strings, i, z, false);
    }

    /* JADX WARN: Code restructure failed: missing block: B:37:0x0090, code lost:
    
        return kotlin.TuplesKt.to(java.lang.Integer.valueOf(r12), r9);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final kotlin.Pair<java.lang.Integer, java.lang.String> findAnyOf$StringsKt__StringsKt(@org.jetbrains.annotations.NotNull java.lang.CharSequence r10, java.util.Collection<java.lang.String> r11, int r12, boolean r13, boolean r14) {
        /*
            r0 = 0
            if (r13 != 0) goto L2d
            int r1 = r11.size()
            r2 = 1
            if (r1 != r2) goto L2d
            java.lang.Object r11 = kotlin.collections.CollectionsKt.single(r11)
            java.lang.String r11 = (java.lang.String) r11
            r4 = 0
            r5 = 4
            r6 = 0
            r1 = r10
            r2 = r11
            r3 = r12
            if (r14 != 0) goto L1d
            int r10 = indexOf$default(r1, r2, r3, r4, r5, r6)
            goto L21
        L1d:
            int r10 = lastIndexOf$default(r1, r2, r3, r4, r5, r6)
        L21:
            if (r10 >= 0) goto L24
            goto L2c
        L24:
            java.lang.Integer r10 = java.lang.Integer.valueOf(r10)
            kotlin.Pair r0 = kotlin.TuplesKt.to(r10, r11)
        L2c:
            return r0
        L2d:
            r1 = 0
            if (r14 != 0) goto L3e
            int r12 = kotlin.ranges.RangesKt.coerceAtLeast(r12, r1)
            kotlin.ranges.IntRange r14 = new kotlin.ranges.IntRange
            int r1 = r10.length()
            r14.<init>(r12, r1)
            goto L4a
        L3e:
            int r14 = getLastIndex(r10)
            int r12 = kotlin.ranges.RangesKt.coerceAtMost(r12, r14)
            kotlin.ranges.IntProgression r14 = kotlin.ranges.RangesKt.downTo(r12, r1)
        L4a:
            boolean r12 = r10 instanceof java.lang.String
            if (r12 == 0) goto L95
            int r12 = r14.getFirst()
            int r1 = r14.getLast()
            int r14 = r14.getStep()
            if (r14 < 0) goto L5f
            if (r12 > r1) goto Ld2
            goto L61
        L5f:
            if (r12 < r1) goto Ld2
        L61:
            java.util.Iterator r8 = r11.iterator()
        L65:
            boolean r2 = r8.hasNext()
            if (r2 == 0) goto L83
            java.lang.Object r9 = r8.next()
            r2 = r9
            java.lang.String r2 = (java.lang.String) r2
            r3 = 0
            r4 = r10
            java.lang.String r4 = (java.lang.String) r4
            int r6 = r2.length()
            r5 = r12
            r7 = r13
            boolean r2 = kotlin.text.StringsKt__StringsJVMKt.regionMatches(r2, r3, r4, r5, r6, r7)
            if (r2 == 0) goto L65
            goto L84
        L83:
            r9 = r0
        L84:
            java.lang.String r9 = (java.lang.String) r9
            if (r9 == 0) goto L91
        L88:
            java.lang.Integer r10 = java.lang.Integer.valueOf(r12)
            kotlin.Pair r10 = kotlin.TuplesKt.to(r10, r9)
            return r10
        L91:
            if (r12 == r1) goto Ld2
            int r12 = r12 + r14
            goto L61
        L95:
            int r12 = r14.getFirst()
            int r1 = r14.getLast()
            int r14 = r14.getStep()
            if (r14 < 0) goto La6
            if (r12 > r1) goto Ld2
            goto La8
        La6:
            if (r12 < r1) goto Ld2
        La8:
            java.util.Iterator r8 = r11.iterator()
        Lac:
            boolean r2 = r8.hasNext()
            if (r2 == 0) goto Lc8
            java.lang.Object r9 = r8.next()
            r2 = r9
            java.lang.String r2 = (java.lang.String) r2
            r3 = 0
            int r6 = r2.length()
            r4 = r10
            r5 = r12
            r7 = r13
            boolean r2 = regionMatchesImpl(r2, r3, r4, r5, r6, r7)
            if (r2 == 0) goto Lac
            goto Lc9
        Lc8:
            r9 = r0
        Lc9:
            java.lang.String r9 = (java.lang.String) r9
            if (r9 == 0) goto Lce
            goto L88
        Lce:
            if (r12 == r1) goto Ld2
            int r12 = r12 + r14
            goto La8
        Ld2:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.text.StringsKt__StringsKt.findAnyOf$StringsKt__StringsKt(java.lang.CharSequence, java.util.Collection, int, boolean, boolean):kotlin.Pair");
    }

    public static /* synthetic */ Pair findAnyOf$default(CharSequence charSequence, Collection collection, int i, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        if ((i2 & 4) != 0) {
            z = false;
        }
        return findAnyOf(charSequence, collection, i, z);
    }

    @Nullable
    public static final Pair<Integer, String> findLastAnyOf(@NotNull CharSequence findLastAnyOf, @NotNull Collection<String> strings, int i, boolean z) {
        Intrinsics.checkParameterIsNotNull(findLastAnyOf, "$this$findLastAnyOf");
        Intrinsics.checkParameterIsNotNull(strings, "strings");
        return findAnyOf$StringsKt__StringsKt(findLastAnyOf, strings, i, z, true);
    }

    public static /* synthetic */ Pair findLastAnyOf$default(CharSequence charSequence, Collection collection, int i, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = getLastIndex(charSequence);
        }
        if ((i2 & 4) != 0) {
            z = false;
        }
        return findLastAnyOf(charSequence, collection, i, z);
    }

    @NotNull
    public static final IntRange getIndices(@NotNull CharSequence indices) {
        Intrinsics.checkParameterIsNotNull(indices, "$this$indices");
        return new IntRange(0, indices.length() - 1);
    }

    public static final int getLastIndex(@NotNull CharSequence lastIndex) {
        Intrinsics.checkParameterIsNotNull(lastIndex, "$this$lastIndex");
        return lastIndex.length() - 1;
    }

    public static final boolean hasSurrogatePairAt(@NotNull CharSequence hasSurrogatePairAt, int i) {
        Intrinsics.checkParameterIsNotNull(hasSurrogatePairAt, "$this$hasSurrogatePairAt");
        return i >= 0 && hasSurrogatePairAt.length() + (-2) >= i && Character.isHighSurrogate(hasSurrogatePairAt.charAt(i)) && Character.isLowSurrogate(hasSurrogatePairAt.charAt(i + 1));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @SinceKotlin(version = "1.3")
    @InlineOnly
    private static final <C extends CharSequence & R, R> R ifBlank(C c, Function0<? extends R> function0) {
        return StringsKt__StringsJVMKt.isBlank(c) ? function0.invoke() : c;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @SinceKotlin(version = "1.3")
    @InlineOnly
    private static final <C extends CharSequence & R, R> R ifEmpty(C c, Function0<? extends R> function0) {
        return c.length() == 0 ? function0.invoke() : c;
    }

    public static final int indexOf(@NotNull CharSequence indexOf, char c, int i, boolean z) {
        Intrinsics.checkParameterIsNotNull(indexOf, "$this$indexOf");
        return (z || !(indexOf instanceof String)) ? indexOfAny(indexOf, new char[]{c}, i, z) : ((String) indexOf).indexOf(c, i);
    }

    public static final int indexOf(@NotNull CharSequence indexOf, @NotNull String string, int i, boolean z) {
        Intrinsics.checkParameterIsNotNull(indexOf, "$this$indexOf");
        Intrinsics.checkParameterIsNotNull(string, "string");
        return (z || !(indexOf instanceof String)) ? a(indexOf, string, i, indexOf.length(), z, false, 16, null) : ((String) indexOf).indexOf(string, i);
    }

    private static final int indexOf$StringsKt__StringsKt(@NotNull CharSequence charSequence, CharSequence charSequence2, int i, int i2, boolean z, boolean z2) {
        int coerceAtMost;
        int coerceAtLeast;
        IntProgression downTo;
        int coerceAtLeast2;
        int coerceAtMost2;
        if (z2) {
            coerceAtMost = RangesKt___RangesKt.coerceAtMost(i, getLastIndex(charSequence));
            coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(i2, 0);
            downTo = RangesKt___RangesKt.downTo(coerceAtMost, coerceAtLeast);
        } else {
            coerceAtLeast2 = RangesKt___RangesKt.coerceAtLeast(i, 0);
            coerceAtMost2 = RangesKt___RangesKt.coerceAtMost(i2, charSequence.length());
            downTo = new IntRange(coerceAtLeast2, coerceAtMost2);
        }
        if ((charSequence instanceof String) && (charSequence2 instanceof String)) {
            int first = downTo.getFirst();
            int last = downTo.getLast();
            int step = downTo.getStep();
            if (step >= 0) {
                if (first > last) {
                    return -1;
                }
            } else if (first < last) {
                return -1;
            }
            while (!StringsKt__StringsJVMKt.regionMatches((String) charSequence2, 0, (String) charSequence, first, charSequence2.length(), z)) {
                if (first == last) {
                    return -1;
                }
                first += step;
            }
            return first;
        }
        int first2 = downTo.getFirst();
        int last2 = downTo.getLast();
        int step2 = downTo.getStep();
        if (step2 >= 0) {
            if (first2 > last2) {
                return -1;
            }
        } else if (first2 < last2) {
            return -1;
        }
        while (!regionMatchesImpl(charSequence2, 0, charSequence, first2, charSequence2.length(), z)) {
            if (first2 == last2) {
                return -1;
            }
            first2 += step2;
        }
        return first2;
    }

    public static /* synthetic */ int indexOf$default(CharSequence charSequence, char c, int i, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        if ((i2 & 4) != 0) {
            z = false;
        }
        return indexOf(charSequence, c, i, z);
    }

    public static /* synthetic */ int indexOf$default(CharSequence charSequence, String str, int i, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        if ((i2 & 4) != 0) {
            z = false;
        }
        return indexOf(charSequence, str, i, z);
    }

    public static final int indexOfAny(@NotNull CharSequence indexOfAny, @NotNull Collection<String> strings, int i, boolean z) {
        Integer first;
        Intrinsics.checkParameterIsNotNull(indexOfAny, "$this$indexOfAny");
        Intrinsics.checkParameterIsNotNull(strings, "strings");
        Pair<Integer, String> findAnyOf$StringsKt__StringsKt = findAnyOf$StringsKt__StringsKt(indexOfAny, strings, i, z, false);
        if (findAnyOf$StringsKt__StringsKt == null || (first = findAnyOf$StringsKt__StringsKt.getFirst()) == null) {
            return -1;
        }
        return first.intValue();
    }

    public static final int indexOfAny(@NotNull CharSequence indexOfAny, @NotNull char[] chars, int i, boolean z) {
        int coerceAtLeast;
        boolean z2;
        char single;
        Intrinsics.checkParameterIsNotNull(indexOfAny, "$this$indexOfAny");
        Intrinsics.checkParameterIsNotNull(chars, "chars");
        if (!z && chars.length == 1 && (indexOfAny instanceof String)) {
            single = ArraysKt___ArraysKt.single(chars);
            return ((String) indexOfAny).indexOf(single, i);
        }
        coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(i, 0);
        int lastIndex = getLastIndex(indexOfAny);
        if (coerceAtLeast > lastIndex) {
            return -1;
        }
        while (true) {
            char charAt = indexOfAny.charAt(coerceAtLeast);
            int length = chars.length;
            int i2 = 0;
            while (true) {
                if (i2 >= length) {
                    z2 = false;
                    break;
                }
                if (CharsKt__CharKt.equals(chars[i2], charAt, z)) {
                    z2 = true;
                    break;
                }
                i2++;
            }
            if (z2) {
                return coerceAtLeast;
            }
            if (coerceAtLeast == lastIndex) {
                return -1;
            }
            coerceAtLeast++;
        }
    }

    public static /* synthetic */ int indexOfAny$default(CharSequence charSequence, Collection collection, int i, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        if ((i2 & 4) != 0) {
            z = false;
        }
        return indexOfAny(charSequence, (Collection<String>) collection, i, z);
    }

    public static /* synthetic */ int indexOfAny$default(CharSequence charSequence, char[] cArr, int i, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        if ((i2 & 4) != 0) {
            z = false;
        }
        return indexOfAny(charSequence, cArr, i, z);
    }

    @InlineOnly
    private static final boolean isEmpty(@NotNull CharSequence charSequence) {
        return charSequence.length() == 0;
    }

    @InlineOnly
    private static final boolean isNotBlank(@NotNull CharSequence charSequence) {
        return !StringsKt__StringsJVMKt.isBlank(charSequence);
    }

    @InlineOnly
    private static final boolean isNotEmpty(@NotNull CharSequence charSequence) {
        return charSequence.length() > 0;
    }

    @InlineOnly
    private static final boolean isNullOrBlank(@Nullable CharSequence charSequence) {
        return charSequence == null || StringsKt__StringsJVMKt.isBlank(charSequence);
    }

    @InlineOnly
    private static final boolean isNullOrEmpty(@Nullable CharSequence charSequence) {
        return charSequence == null || charSequence.length() == 0;
    }

    @NotNull
    public static final CharIterator iterator(@NotNull final CharSequence iterator) {
        Intrinsics.checkParameterIsNotNull(iterator, "$this$iterator");
        return new CharIterator() { // from class: kotlin.text.StringsKt__StringsKt$iterator$1
            private int index;

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.index < iterator.length();
            }

            @Override // kotlin.collections.CharIterator
            public char nextChar() {
                CharSequence charSequence = iterator;
                int i = this.index;
                this.index = i + 1;
                return charSequence.charAt(i);
            }
        };
    }

    public static final int lastIndexOf(@NotNull CharSequence lastIndexOf, char c, int i, boolean z) {
        Intrinsics.checkParameterIsNotNull(lastIndexOf, "$this$lastIndexOf");
        return (z || !(lastIndexOf instanceof String)) ? lastIndexOfAny(lastIndexOf, new char[]{c}, i, z) : ((String) lastIndexOf).lastIndexOf(c, i);
    }

    public static final int lastIndexOf(@NotNull CharSequence lastIndexOf, @NotNull String string, int i, boolean z) {
        Intrinsics.checkParameterIsNotNull(lastIndexOf, "$this$lastIndexOf");
        Intrinsics.checkParameterIsNotNull(string, "string");
        return (z || !(lastIndexOf instanceof String)) ? indexOf$StringsKt__StringsKt(lastIndexOf, string, i, 0, z, true) : ((String) lastIndexOf).lastIndexOf(string, i);
    }

    public static /* synthetic */ int lastIndexOf$default(CharSequence charSequence, char c, int i, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = getLastIndex(charSequence);
        }
        if ((i2 & 4) != 0) {
            z = false;
        }
        return lastIndexOf(charSequence, c, i, z);
    }

    public static /* synthetic */ int lastIndexOf$default(CharSequence charSequence, String str, int i, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = getLastIndex(charSequence);
        }
        if ((i2 & 4) != 0) {
            z = false;
        }
        return lastIndexOf(charSequence, str, i, z);
    }

    public static final int lastIndexOfAny(@NotNull CharSequence lastIndexOfAny, @NotNull Collection<String> strings, int i, boolean z) {
        Integer first;
        Intrinsics.checkParameterIsNotNull(lastIndexOfAny, "$this$lastIndexOfAny");
        Intrinsics.checkParameterIsNotNull(strings, "strings");
        Pair<Integer, String> findAnyOf$StringsKt__StringsKt = findAnyOf$StringsKt__StringsKt(lastIndexOfAny, strings, i, z, true);
        if (findAnyOf$StringsKt__StringsKt == null || (first = findAnyOf$StringsKt__StringsKt.getFirst()) == null) {
            return -1;
        }
        return first.intValue();
    }

    public static final int lastIndexOfAny(@NotNull CharSequence lastIndexOfAny, @NotNull char[] chars, int i, boolean z) {
        int coerceAtMost;
        char single;
        Intrinsics.checkParameterIsNotNull(lastIndexOfAny, "$this$lastIndexOfAny");
        Intrinsics.checkParameterIsNotNull(chars, "chars");
        if (!z && chars.length == 1 && (lastIndexOfAny instanceof String)) {
            single = ArraysKt___ArraysKt.single(chars);
            return ((String) lastIndexOfAny).lastIndexOf(single, i);
        }
        for (coerceAtMost = RangesKt___RangesKt.coerceAtMost(i, getLastIndex(lastIndexOfAny)); coerceAtMost >= 0; coerceAtMost--) {
            char charAt = lastIndexOfAny.charAt(coerceAtMost);
            int length = chars.length;
            boolean z2 = false;
            int i2 = 0;
            while (true) {
                if (i2 >= length) {
                    break;
                }
                if (CharsKt__CharKt.equals(chars[i2], charAt, z)) {
                    z2 = true;
                    break;
                }
                i2++;
            }
            if (z2) {
                return coerceAtMost;
            }
        }
        return -1;
    }

    public static /* synthetic */ int lastIndexOfAny$default(CharSequence charSequence, Collection collection, int i, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = getLastIndex(charSequence);
        }
        if ((i2 & 4) != 0) {
            z = false;
        }
        return lastIndexOfAny(charSequence, (Collection<String>) collection, i, z);
    }

    public static /* synthetic */ int lastIndexOfAny$default(CharSequence charSequence, char[] cArr, int i, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = getLastIndex(charSequence);
        }
        if ((i2 & 4) != 0) {
            z = false;
        }
        return lastIndexOfAny(charSequence, cArr, i, z);
    }

    @NotNull
    public static final Sequence<String> lineSequence(@NotNull CharSequence lineSequence) {
        Intrinsics.checkParameterIsNotNull(lineSequence, "$this$lineSequence");
        return splitToSequence$default(lineSequence, new String[]{"\r\n", "\n", "\r"}, false, 0, 6, (Object) null);
    }

    @NotNull
    public static final List<String> lines(@NotNull CharSequence lines) {
        List<String> list;
        Intrinsics.checkParameterIsNotNull(lines, "$this$lines");
        list = SequencesKt___SequencesKt.toList(lineSequence(lines));
        return list;
    }

    @InlineOnly
    private static final boolean matches(@NotNull CharSequence charSequence, Regex regex) {
        return regex.matches(charSequence);
    }

    @InlineOnly
    private static final String orEmpty(@Nullable String str) {
        return str != null ? str : "";
    }

    @NotNull
    public static final CharSequence padEnd(@NotNull CharSequence padEnd, int i, char c) {
        Intrinsics.checkParameterIsNotNull(padEnd, "$this$padEnd");
        if (i < 0) {
            throw new IllegalArgumentException("Desired length " + i + " is less than zero.");
        }
        if (i <= padEnd.length()) {
            return padEnd.subSequence(0, padEnd.length());
        }
        StringBuilder sb = new StringBuilder(i);
        sb.append(padEnd);
        int length = i - padEnd.length();
        int i2 = 1;
        if (1 <= length) {
            while (true) {
                sb.append(c);
                if (i2 == length) {
                    break;
                }
                i2++;
            }
        }
        return sb;
    }

    @NotNull
    public static final String padEnd(@NotNull String padEnd, int i, char c) {
        Intrinsics.checkParameterIsNotNull(padEnd, "$this$padEnd");
        return padEnd((CharSequence) padEnd, i, c).toString();
    }

    public static /* synthetic */ CharSequence padEnd$default(CharSequence charSequence, int i, char c, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            c = ' ';
        }
        return padEnd(charSequence, i, c);
    }

    public static /* synthetic */ String padEnd$default(String str, int i, char c, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            c = ' ';
        }
        return padEnd(str, i, c);
    }

    @NotNull
    public static final CharSequence padStart(@NotNull CharSequence padStart, int i, char c) {
        Intrinsics.checkParameterIsNotNull(padStart, "$this$padStart");
        if (i < 0) {
            throw new IllegalArgumentException("Desired length " + i + " is less than zero.");
        }
        if (i <= padStart.length()) {
            return padStart.subSequence(0, padStart.length());
        }
        StringBuilder sb = new StringBuilder(i);
        int length = i - padStart.length();
        int i2 = 1;
        if (1 <= length) {
            while (true) {
                sb.append(c);
                if (i2 == length) {
                    break;
                }
                i2++;
            }
        }
        sb.append(padStart);
        return sb;
    }

    @NotNull
    public static String padStart(@NotNull String padStart, int i, char c) {
        Intrinsics.checkParameterIsNotNull(padStart, "$this$padStart");
        return padStart((CharSequence) padStart, i, c).toString();
    }

    public static /* synthetic */ CharSequence padStart$default(CharSequence charSequence, int i, char c, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            c = ' ';
        }
        return padStart(charSequence, i, c);
    }

    public static /* synthetic */ String padStart$default(String str, int i, char c, int i2, Object obj) {
        String padStart;
        if ((i2 & 2) != 0) {
            c = ' ';
        }
        padStart = padStart(str, i, c);
        return padStart;
    }

    private static final Sequence<IntRange> rangesDelimitedBy$StringsKt__StringsKt(@NotNull CharSequence charSequence, final char[] cArr, int i, final boolean z, int i2) {
        if (i2 >= 0) {
            return new DelimitedRangesSequence(charSequence, i, i2, new Function2<CharSequence, Integer, Pair<? extends Integer, ? extends Integer>>() { // from class: kotlin.text.StringsKt__StringsKt$rangesDelimitedBy$2
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Pair<? extends Integer, ? extends Integer> invoke(CharSequence charSequence2, Integer num) {
                    return invoke(charSequence2, num.intValue());
                }

                @Nullable
                public final Pair<Integer, Integer> invoke(@NotNull CharSequence receiver, int i3) {
                    Intrinsics.checkParameterIsNotNull(receiver, "$receiver");
                    int indexOfAny = StringsKt__StringsKt.indexOfAny(receiver, cArr, i3, z);
                    if (indexOfAny < 0) {
                        return null;
                    }
                    return TuplesKt.to(Integer.valueOf(indexOfAny), 1);
                }
            });
        }
        throw new IllegalArgumentException(("Limit must be non-negative, but was " + i2 + '.').toString());
    }

    private static final Sequence<IntRange> rangesDelimitedBy$StringsKt__StringsKt(@NotNull CharSequence charSequence, String[] strArr, int i, final boolean z, int i2) {
        final List asList;
        if (i2 >= 0) {
            asList = ArraysKt___ArraysJvmKt.asList(strArr);
            return new DelimitedRangesSequence(charSequence, i, i2, new Function2<CharSequence, Integer, Pair<? extends Integer, ? extends Integer>>() { // from class: kotlin.text.StringsKt__StringsKt$rangesDelimitedBy$4
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Pair<? extends Integer, ? extends Integer> invoke(CharSequence charSequence2, Integer num) {
                    return invoke(charSequence2, num.intValue());
                }

                @Nullable
                public final Pair<Integer, Integer> invoke(@NotNull CharSequence receiver, int i3) {
                    Pair findAnyOf$StringsKt__StringsKt;
                    Intrinsics.checkParameterIsNotNull(receiver, "$receiver");
                    findAnyOf$StringsKt__StringsKt = StringsKt__StringsKt.findAnyOf$StringsKt__StringsKt(receiver, asList, i3, z, false);
                    if (findAnyOf$StringsKt__StringsKt != null) {
                        return TuplesKt.to(findAnyOf$StringsKt__StringsKt.getFirst(), Integer.valueOf(((String) findAnyOf$StringsKt__StringsKt.getSecond()).length()));
                    }
                    return null;
                }
            });
        }
        throw new IllegalArgumentException(("Limit must be non-negative, but was " + i2 + '.').toString());
    }

    public static final boolean regionMatchesImpl(@NotNull CharSequence regionMatchesImpl, int i, @NotNull CharSequence other, int i2, int i3, boolean z) {
        Intrinsics.checkParameterIsNotNull(regionMatchesImpl, "$this$regionMatchesImpl");
        Intrinsics.checkParameterIsNotNull(other, "other");
        if (i2 < 0 || i < 0 || i > regionMatchesImpl.length() - i3 || i2 > other.length() - i3) {
            return false;
        }
        for (int i4 = 0; i4 < i3; i4++) {
            if (!CharsKt__CharKt.equals(regionMatchesImpl.charAt(i + i4), other.charAt(i2 + i4), z)) {
                return false;
            }
        }
        return true;
    }

    @NotNull
    public static final CharSequence removePrefix(@NotNull CharSequence removePrefix, @NotNull CharSequence prefix) {
        Intrinsics.checkParameterIsNotNull(removePrefix, "$this$removePrefix");
        Intrinsics.checkParameterIsNotNull(prefix, "prefix");
        return startsWith$default(removePrefix, prefix, false, 2, (Object) null) ? removePrefix.subSequence(prefix.length(), removePrefix.length()) : removePrefix.subSequence(0, removePrefix.length());
    }

    @NotNull
    public static final String removePrefix(@NotNull String removePrefix, @NotNull CharSequence prefix) {
        Intrinsics.checkParameterIsNotNull(removePrefix, "$this$removePrefix");
        Intrinsics.checkParameterIsNotNull(prefix, "prefix");
        if (!startsWith$default((CharSequence) removePrefix, prefix, false, 2, (Object) null)) {
            return removePrefix;
        }
        String substring = removePrefix.substring(prefix.length());
        Intrinsics.checkExpressionValueIsNotNull(substring, "(this as java.lang.String).substring(startIndex)");
        return substring;
    }

    @NotNull
    public static final CharSequence removeRange(@NotNull CharSequence removeRange, int i, int i2) {
        Intrinsics.checkParameterIsNotNull(removeRange, "$this$removeRange");
        if (i2 >= i) {
            if (i2 == i) {
                return removeRange.subSequence(0, removeRange.length());
            }
            StringBuilder sb = new StringBuilder(removeRange.length() - (i2 - i));
            sb.append(removeRange, 0, i);
            sb.append(removeRange, i2, removeRange.length());
            return sb;
        }
        throw new IndexOutOfBoundsException("End index (" + i2 + ") is less than start index (" + i + ").");
    }

    @NotNull
    public static final CharSequence removeRange(@NotNull CharSequence removeRange, @NotNull IntRange range) {
        Intrinsics.checkParameterIsNotNull(removeRange, "$this$removeRange");
        Intrinsics.checkParameterIsNotNull(range, "range");
        return removeRange(removeRange, range.getStart().intValue(), range.getEndInclusive().intValue() + 1);
    }

    @InlineOnly
    private static final String removeRange(@NotNull String str, int i, int i2) {
        if (str != null) {
            return removeRange((CharSequence) str, i, i2).toString();
        }
        throw new TypeCastException("null cannot be cast to non-null type kotlin.CharSequence");
    }

    @InlineOnly
    private static final String removeRange(@NotNull String str, IntRange intRange) {
        if (str != null) {
            return removeRange((CharSequence) str, intRange).toString();
        }
        throw new TypeCastException("null cannot be cast to non-null type kotlin.CharSequence");
    }

    @NotNull
    public static final CharSequence removeSuffix(@NotNull CharSequence removeSuffix, @NotNull CharSequence suffix) {
        Intrinsics.checkParameterIsNotNull(removeSuffix, "$this$removeSuffix");
        Intrinsics.checkParameterIsNotNull(suffix, "suffix");
        return endsWith$default(removeSuffix, suffix, false, 2, (Object) null) ? removeSuffix.subSequence(0, removeSuffix.length() - suffix.length()) : removeSuffix.subSequence(0, removeSuffix.length());
    }

    @NotNull
    public static final String removeSuffix(@NotNull String removeSuffix, @NotNull CharSequence suffix) {
        Intrinsics.checkParameterIsNotNull(removeSuffix, "$this$removeSuffix");
        Intrinsics.checkParameterIsNotNull(suffix, "suffix");
        if (!endsWith$default((CharSequence) removeSuffix, suffix, false, 2, (Object) null)) {
            return removeSuffix;
        }
        String substring = removeSuffix.substring(0, removeSuffix.length() - suffix.length());
        Intrinsics.checkExpressionValueIsNotNull(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        return substring;
    }

    @NotNull
    public static final CharSequence removeSurrounding(@NotNull CharSequence removeSurrounding, @NotNull CharSequence delimiter) {
        Intrinsics.checkParameterIsNotNull(removeSurrounding, "$this$removeSurrounding");
        Intrinsics.checkParameterIsNotNull(delimiter, "delimiter");
        return removeSurrounding(removeSurrounding, delimiter, delimiter);
    }

    @NotNull
    public static final CharSequence removeSurrounding(@NotNull CharSequence removeSurrounding, @NotNull CharSequence prefix, @NotNull CharSequence suffix) {
        Intrinsics.checkParameterIsNotNull(removeSurrounding, "$this$removeSurrounding");
        Intrinsics.checkParameterIsNotNull(prefix, "prefix");
        Intrinsics.checkParameterIsNotNull(suffix, "suffix");
        return (removeSurrounding.length() >= prefix.length() + suffix.length() && startsWith$default(removeSurrounding, prefix, false, 2, (Object) null) && endsWith$default(removeSurrounding, suffix, false, 2, (Object) null)) ? removeSurrounding.subSequence(prefix.length(), removeSurrounding.length() - suffix.length()) : removeSurrounding.subSequence(0, removeSurrounding.length());
    }

    @NotNull
    public static final String removeSurrounding(@NotNull String removeSurrounding, @NotNull CharSequence delimiter) {
        Intrinsics.checkParameterIsNotNull(removeSurrounding, "$this$removeSurrounding");
        Intrinsics.checkParameterIsNotNull(delimiter, "delimiter");
        return removeSurrounding(removeSurrounding, delimiter, delimiter);
    }

    @NotNull
    public static final String removeSurrounding(@NotNull String removeSurrounding, @NotNull CharSequence prefix, @NotNull CharSequence suffix) {
        Intrinsics.checkParameterIsNotNull(removeSurrounding, "$this$removeSurrounding");
        Intrinsics.checkParameterIsNotNull(prefix, "prefix");
        Intrinsics.checkParameterIsNotNull(suffix, "suffix");
        if (removeSurrounding.length() < prefix.length() + suffix.length() || !startsWith$default((CharSequence) removeSurrounding, prefix, false, 2, (Object) null) || !endsWith$default((CharSequence) removeSurrounding, suffix, false, 2, (Object) null)) {
            return removeSurrounding;
        }
        String substring = removeSurrounding.substring(prefix.length(), removeSurrounding.length() - suffix.length());
        Intrinsics.checkExpressionValueIsNotNull(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        return substring;
    }

    @InlineOnly
    private static final String replace(@NotNull CharSequence charSequence, Regex regex, String str) {
        return regex.replace(charSequence, str);
    }

    @InlineOnly
    private static final String replace(@NotNull CharSequence charSequence, Regex regex, Function1<? super MatchResult, ? extends CharSequence> function1) {
        return regex.replace(charSequence, function1);
    }

    @NotNull
    public static final String replaceAfter(@NotNull String replaceAfter, char c, @NotNull String replacement, @NotNull String missingDelimiterValue) {
        int indexOf$default;
        Intrinsics.checkParameterIsNotNull(replaceAfter, "$this$replaceAfter");
        Intrinsics.checkParameterIsNotNull(replacement, "replacement");
        Intrinsics.checkParameterIsNotNull(missingDelimiterValue, "missingDelimiterValue");
        indexOf$default = indexOf$default((CharSequence) replaceAfter, c, 0, false, 6, (Object) null);
        return indexOf$default == -1 ? missingDelimiterValue : replaceRange((CharSequence) replaceAfter, indexOf$default + 1, replaceAfter.length(), (CharSequence) replacement).toString();
    }

    @NotNull
    public static final String replaceAfter(@NotNull String replaceAfter, @NotNull String delimiter, @NotNull String replacement, @NotNull String missingDelimiterValue) {
        Intrinsics.checkParameterIsNotNull(replaceAfter, "$this$replaceAfter");
        Intrinsics.checkParameterIsNotNull(delimiter, "delimiter");
        Intrinsics.checkParameterIsNotNull(replacement, "replacement");
        Intrinsics.checkParameterIsNotNull(missingDelimiterValue, "missingDelimiterValue");
        int indexOf$default = indexOf$default((CharSequence) replaceAfter, delimiter, 0, false, 6, (Object) null);
        return indexOf$default == -1 ? missingDelimiterValue : replaceRange((CharSequence) replaceAfter, indexOf$default + delimiter.length(), replaceAfter.length(), (CharSequence) replacement).toString();
    }

    public static /* synthetic */ String replaceAfter$default(String str, char c, String str2, String str3, int i, Object obj) {
        if ((i & 4) != 0) {
            str3 = str;
        }
        return replaceAfter(str, c, str2, str3);
    }

    public static /* synthetic */ String replaceAfter$default(String str, String str2, String str3, String str4, int i, Object obj) {
        if ((i & 4) != 0) {
            str4 = str;
        }
        return replaceAfter(str, str2, str3, str4);
    }

    @NotNull
    public static final String replaceAfterLast(@NotNull String replaceAfterLast, char c, @NotNull String replacement, @NotNull String missingDelimiterValue) {
        Intrinsics.checkParameterIsNotNull(replaceAfterLast, "$this$replaceAfterLast");
        Intrinsics.checkParameterIsNotNull(replacement, "replacement");
        Intrinsics.checkParameterIsNotNull(missingDelimiterValue, "missingDelimiterValue");
        int lastIndexOf$default = lastIndexOf$default((CharSequence) replaceAfterLast, c, 0, false, 6, (Object) null);
        return lastIndexOf$default == -1 ? missingDelimiterValue : replaceRange((CharSequence) replaceAfterLast, lastIndexOf$default + 1, replaceAfterLast.length(), (CharSequence) replacement).toString();
    }

    @NotNull
    public static final String replaceAfterLast(@NotNull String replaceAfterLast, @NotNull String delimiter, @NotNull String replacement, @NotNull String missingDelimiterValue) {
        Intrinsics.checkParameterIsNotNull(replaceAfterLast, "$this$replaceAfterLast");
        Intrinsics.checkParameterIsNotNull(delimiter, "delimiter");
        Intrinsics.checkParameterIsNotNull(replacement, "replacement");
        Intrinsics.checkParameterIsNotNull(missingDelimiterValue, "missingDelimiterValue");
        int lastIndexOf$default = lastIndexOf$default((CharSequence) replaceAfterLast, delimiter, 0, false, 6, (Object) null);
        return lastIndexOf$default == -1 ? missingDelimiterValue : replaceRange((CharSequence) replaceAfterLast, lastIndexOf$default + delimiter.length(), replaceAfterLast.length(), (CharSequence) replacement).toString();
    }

    public static /* synthetic */ String replaceAfterLast$default(String str, char c, String str2, String str3, int i, Object obj) {
        if ((i & 4) != 0) {
            str3 = str;
        }
        return replaceAfterLast(str, c, str2, str3);
    }

    public static /* synthetic */ String replaceAfterLast$default(String str, String str2, String str3, String str4, int i, Object obj) {
        if ((i & 4) != 0) {
            str4 = str;
        }
        return replaceAfterLast(str, str2, str3, str4);
    }

    @NotNull
    public static final String replaceBefore(@NotNull String replaceBefore, char c, @NotNull String replacement, @NotNull String missingDelimiterValue) {
        int indexOf$default;
        Intrinsics.checkParameterIsNotNull(replaceBefore, "$this$replaceBefore");
        Intrinsics.checkParameterIsNotNull(replacement, "replacement");
        Intrinsics.checkParameterIsNotNull(missingDelimiterValue, "missingDelimiterValue");
        indexOf$default = indexOf$default((CharSequence) replaceBefore, c, 0, false, 6, (Object) null);
        return indexOf$default == -1 ? missingDelimiterValue : replaceRange((CharSequence) replaceBefore, 0, indexOf$default, (CharSequence) replacement).toString();
    }

    @NotNull
    public static final String replaceBefore(@NotNull String replaceBefore, @NotNull String delimiter, @NotNull String replacement, @NotNull String missingDelimiterValue) {
        Intrinsics.checkParameterIsNotNull(replaceBefore, "$this$replaceBefore");
        Intrinsics.checkParameterIsNotNull(delimiter, "delimiter");
        Intrinsics.checkParameterIsNotNull(replacement, "replacement");
        Intrinsics.checkParameterIsNotNull(missingDelimiterValue, "missingDelimiterValue");
        int indexOf$default = indexOf$default((CharSequence) replaceBefore, delimiter, 0, false, 6, (Object) null);
        return indexOf$default == -1 ? missingDelimiterValue : replaceRange((CharSequence) replaceBefore, 0, indexOf$default, (CharSequence) replacement).toString();
    }

    public static /* synthetic */ String replaceBefore$default(String str, char c, String str2, String str3, int i, Object obj) {
        if ((i & 4) != 0) {
            str3 = str;
        }
        return replaceBefore(str, c, str2, str3);
    }

    public static /* synthetic */ String replaceBefore$default(String str, String str2, String str3, String str4, int i, Object obj) {
        if ((i & 4) != 0) {
            str4 = str;
        }
        return replaceBefore(str, str2, str3, str4);
    }

    @NotNull
    public static final String replaceBeforeLast(@NotNull String replaceBeforeLast, char c, @NotNull String replacement, @NotNull String missingDelimiterValue) {
        Intrinsics.checkParameterIsNotNull(replaceBeforeLast, "$this$replaceBeforeLast");
        Intrinsics.checkParameterIsNotNull(replacement, "replacement");
        Intrinsics.checkParameterIsNotNull(missingDelimiterValue, "missingDelimiterValue");
        int lastIndexOf$default = lastIndexOf$default((CharSequence) replaceBeforeLast, c, 0, false, 6, (Object) null);
        return lastIndexOf$default == -1 ? missingDelimiterValue : replaceRange((CharSequence) replaceBeforeLast, 0, lastIndexOf$default, (CharSequence) replacement).toString();
    }

    @NotNull
    public static final String replaceBeforeLast(@NotNull String replaceBeforeLast, @NotNull String delimiter, @NotNull String replacement, @NotNull String missingDelimiterValue) {
        Intrinsics.checkParameterIsNotNull(replaceBeforeLast, "$this$replaceBeforeLast");
        Intrinsics.checkParameterIsNotNull(delimiter, "delimiter");
        Intrinsics.checkParameterIsNotNull(replacement, "replacement");
        Intrinsics.checkParameterIsNotNull(missingDelimiterValue, "missingDelimiterValue");
        int lastIndexOf$default = lastIndexOf$default((CharSequence) replaceBeforeLast, delimiter, 0, false, 6, (Object) null);
        return lastIndexOf$default == -1 ? missingDelimiterValue : replaceRange((CharSequence) replaceBeforeLast, 0, lastIndexOf$default, (CharSequence) replacement).toString();
    }

    public static /* synthetic */ String replaceBeforeLast$default(String str, char c, String str2, String str3, int i, Object obj) {
        if ((i & 4) != 0) {
            str3 = str;
        }
        return replaceBeforeLast(str, c, str2, str3);
    }

    public static /* synthetic */ String replaceBeforeLast$default(String str, String str2, String str3, String str4, int i, Object obj) {
        if ((i & 4) != 0) {
            str4 = str;
        }
        return replaceBeforeLast(str, str2, str3, str4);
    }

    @InlineOnly
    private static final String replaceFirst(@NotNull CharSequence charSequence, Regex regex, String str) {
        return regex.replaceFirst(charSequence, str);
    }

    @NotNull
    public static final CharSequence replaceRange(@NotNull CharSequence replaceRange, int i, int i2, @NotNull CharSequence replacement) {
        Intrinsics.checkParameterIsNotNull(replaceRange, "$this$replaceRange");
        Intrinsics.checkParameterIsNotNull(replacement, "replacement");
        if (i2 >= i) {
            StringBuilder sb = new StringBuilder();
            sb.append(replaceRange, 0, i);
            sb.append(replacement);
            sb.append(replaceRange, i2, replaceRange.length());
            return sb;
        }
        throw new IndexOutOfBoundsException("End index (" + i2 + ") is less than start index (" + i + ").");
    }

    @NotNull
    public static final CharSequence replaceRange(@NotNull CharSequence replaceRange, @NotNull IntRange range, @NotNull CharSequence replacement) {
        Intrinsics.checkParameterIsNotNull(replaceRange, "$this$replaceRange");
        Intrinsics.checkParameterIsNotNull(range, "range");
        Intrinsics.checkParameterIsNotNull(replacement, "replacement");
        return replaceRange(replaceRange, range.getStart().intValue(), range.getEndInclusive().intValue() + 1, replacement);
    }

    @InlineOnly
    private static final String replaceRange(@NotNull String str, int i, int i2, CharSequence charSequence) {
        if (str != null) {
            return replaceRange((CharSequence) str, i, i2, charSequence).toString();
        }
        throw new TypeCastException("null cannot be cast to non-null type kotlin.CharSequence");
    }

    @InlineOnly
    private static final String replaceRange(@NotNull String str, IntRange intRange, CharSequence charSequence) {
        if (str != null) {
            return replaceRange((CharSequence) str, intRange, charSequence).toString();
        }
        throw new TypeCastException("null cannot be cast to non-null type kotlin.CharSequence");
    }

    @InlineOnly
    private static final List<String> split(@NotNull CharSequence charSequence, Regex regex, int i) {
        return regex.split(charSequence, i);
    }

    @NotNull
    public static final List<String> split(@NotNull CharSequence split, @NotNull char[] delimiters, boolean z, int i) {
        Iterable asIterable;
        int collectionSizeOrDefault;
        Intrinsics.checkParameterIsNotNull(split, "$this$split");
        Intrinsics.checkParameterIsNotNull(delimiters, "delimiters");
        if (delimiters.length == 1) {
            return split$StringsKt__StringsKt(split, String.valueOf(delimiters[0]), z, i);
        }
        asIterable = SequencesKt___SequencesKt.asIterable(a(split, delimiters, 0, z, i, 2, (Object) null));
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(asIterable, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        Iterator it = asIterable.iterator();
        while (it.hasNext()) {
            arrayList.add(substring(split, (IntRange) it.next()));
        }
        return arrayList;
    }

    @NotNull
    public static final List<String> split(@NotNull CharSequence split, @NotNull String[] delimiters, boolean z, int i) {
        Iterable asIterable;
        int collectionSizeOrDefault;
        Intrinsics.checkParameterIsNotNull(split, "$this$split");
        Intrinsics.checkParameterIsNotNull(delimiters, "delimiters");
        if (delimiters.length == 1) {
            String str = delimiters[0];
            if (!(str.length() == 0)) {
                return split$StringsKt__StringsKt(split, str, z, i);
            }
        }
        asIterable = SequencesKt___SequencesKt.asIterable(a(split, delimiters, 0, z, i, 2, (Object) null));
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(asIterable, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        Iterator it = asIterable.iterator();
        while (it.hasNext()) {
            arrayList.add(substring(split, (IntRange) it.next()));
        }
        return arrayList;
    }

    private static final List<String> split$StringsKt__StringsKt(@NotNull CharSequence charSequence, String str, boolean z, int i) {
        List<String> listOf;
        int i2 = 0;
        if (!(i >= 0)) {
            throw new IllegalArgumentException(("Limit must be non-negative, but was " + i + '.').toString());
        }
        int indexOf = indexOf(charSequence, str, 0, z);
        if (indexOf == -1 || i == 1) {
            listOf = CollectionsKt__CollectionsJVMKt.listOf(charSequence.toString());
            return listOf;
        }
        boolean z2 = i > 0;
        ArrayList arrayList = new ArrayList(z2 ? RangesKt___RangesKt.coerceAtMost(i, 10) : 10);
        do {
            arrayList.add(charSequence.subSequence(i2, indexOf).toString());
            i2 = str.length() + indexOf;
            if (z2 && arrayList.size() == i - 1) {
                break;
            }
            indexOf = indexOf(charSequence, str, i2, z);
        } while (indexOf != -1);
        arrayList.add(charSequence.subSequence(i2, charSequence.length()).toString());
        return arrayList;
    }

    public static /* synthetic */ List split$default(CharSequence charSequence, char[] cArr, boolean z, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = false;
        }
        if ((i2 & 4) != 0) {
            i = 0;
        }
        return split(charSequence, cArr, z, i);
    }

    public static /* synthetic */ List split$default(CharSequence charSequence, String[] strArr, boolean z, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = false;
        }
        if ((i2 & 4) != 0) {
            i = 0;
        }
        return split(charSequence, strArr, z, i);
    }

    @NotNull
    public static final Sequence<String> splitToSequence(@NotNull final CharSequence splitToSequence, @NotNull char[] delimiters, boolean z, int i) {
        Sequence<String> map;
        Intrinsics.checkParameterIsNotNull(splitToSequence, "$this$splitToSequence");
        Intrinsics.checkParameterIsNotNull(delimiters, "delimiters");
        map = SequencesKt___SequencesKt.map(a(splitToSequence, delimiters, 0, z, i, 2, (Object) null), new Function1<IntRange, String>() { // from class: kotlin.text.StringsKt__StringsKt$splitToSequence$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final String invoke(@NotNull IntRange it) {
                Intrinsics.checkParameterIsNotNull(it, "it");
                return StringsKt__StringsKt.substring(splitToSequence, it);
            }
        });
        return map;
    }

    @NotNull
    public static final Sequence<String> splitToSequence(@NotNull final CharSequence splitToSequence, @NotNull String[] delimiters, boolean z, int i) {
        Sequence<String> map;
        Intrinsics.checkParameterIsNotNull(splitToSequence, "$this$splitToSequence");
        Intrinsics.checkParameterIsNotNull(delimiters, "delimiters");
        map = SequencesKt___SequencesKt.map(a(splitToSequence, delimiters, 0, z, i, 2, (Object) null), new Function1<IntRange, String>() { // from class: kotlin.text.StringsKt__StringsKt$splitToSequence$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final String invoke(@NotNull IntRange it) {
                Intrinsics.checkParameterIsNotNull(it, "it");
                return StringsKt__StringsKt.substring(splitToSequence, it);
            }
        });
        return map;
    }

    public static /* synthetic */ Sequence splitToSequence$default(CharSequence charSequence, char[] cArr, boolean z, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = false;
        }
        if ((i2 & 4) != 0) {
            i = 0;
        }
        return splitToSequence(charSequence, cArr, z, i);
    }

    public static /* synthetic */ Sequence splitToSequence$default(CharSequence charSequence, String[] strArr, boolean z, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = false;
        }
        if ((i2 & 4) != 0) {
            i = 0;
        }
        return splitToSequence(charSequence, strArr, z, i);
    }

    public static final boolean startsWith(@NotNull CharSequence startsWith, char c, boolean z) {
        Intrinsics.checkParameterIsNotNull(startsWith, "$this$startsWith");
        return startsWith.length() > 0 && CharsKt__CharKt.equals(startsWith.charAt(0), c, z);
    }

    public static final boolean startsWith(@NotNull CharSequence startsWith, @NotNull CharSequence prefix, int i, boolean z) {
        Intrinsics.checkParameterIsNotNull(startsWith, "$this$startsWith");
        Intrinsics.checkParameterIsNotNull(prefix, "prefix");
        return (!z && (startsWith instanceof String) && (prefix instanceof String)) ? StringsKt__StringsJVMKt.startsWith$default((String) startsWith, (String) prefix, i, false, 4, null) : regionMatchesImpl(startsWith, i, prefix, 0, prefix.length(), z);
    }

    public static final boolean startsWith(@NotNull CharSequence startsWith, @NotNull CharSequence prefix, boolean z) {
        Intrinsics.checkParameterIsNotNull(startsWith, "$this$startsWith");
        Intrinsics.checkParameterIsNotNull(prefix, "prefix");
        return (!z && (startsWith instanceof String) && (prefix instanceof String)) ? StringsKt__StringsJVMKt.startsWith$default((String) startsWith, (String) prefix, false, 2, null) : regionMatchesImpl(startsWith, 0, prefix, 0, prefix.length(), z);
    }

    public static /* synthetic */ boolean startsWith$default(CharSequence charSequence, char c, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return startsWith(charSequence, c, z);
    }

    public static /* synthetic */ boolean startsWith$default(CharSequence charSequence, CharSequence charSequence2, int i, boolean z, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            z = false;
        }
        return startsWith(charSequence, charSequence2, i, z);
    }

    public static /* synthetic */ boolean startsWith$default(CharSequence charSequence, CharSequence charSequence2, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return startsWith(charSequence, charSequence2, z);
    }

    @NotNull
    public static final CharSequence subSequence(@NotNull CharSequence subSequence, @NotNull IntRange range) {
        Intrinsics.checkParameterIsNotNull(subSequence, "$this$subSequence");
        Intrinsics.checkParameterIsNotNull(range, "range");
        return subSequence.subSequence(range.getStart().intValue(), range.getEndInclusive().intValue() + 1);
    }

    @Deprecated(message = "Use parameters named startIndex and endIndex.", replaceWith = @ReplaceWith(expression = "subSequence(startIndex = start, endIndex = end)", imports = {}))
    @InlineOnly
    private static final CharSequence subSequence(@NotNull String str, int i, int i2) {
        return str.subSequence(i, i2);
    }

    @InlineOnly
    private static final String substring(@NotNull CharSequence charSequence, int i, int i2) {
        return charSequence.subSequence(i, i2).toString();
    }

    @NotNull
    public static final String substring(@NotNull CharSequence substring, @NotNull IntRange range) {
        Intrinsics.checkParameterIsNotNull(substring, "$this$substring");
        Intrinsics.checkParameterIsNotNull(range, "range");
        return substring.subSequence(range.getStart().intValue(), range.getEndInclusive().intValue() + 1).toString();
    }

    @NotNull
    public static final String substring(@NotNull String substring, @NotNull IntRange range) {
        Intrinsics.checkParameterIsNotNull(substring, "$this$substring");
        Intrinsics.checkParameterIsNotNull(range, "range");
        String substring2 = substring.substring(range.getStart().intValue(), range.getEndInclusive().intValue() + 1);
        Intrinsics.checkExpressionValueIsNotNull(substring2, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        return substring2;
    }

    @NotNull
    public static final String substringAfter(@NotNull String substringAfter, char c, @NotNull String missingDelimiterValue) {
        int indexOf$default;
        Intrinsics.checkParameterIsNotNull(substringAfter, "$this$substringAfter");
        Intrinsics.checkParameterIsNotNull(missingDelimiterValue, "missingDelimiterValue");
        indexOf$default = indexOf$default((CharSequence) substringAfter, c, 0, false, 6, (Object) null);
        if (indexOf$default == -1) {
            return missingDelimiterValue;
        }
        String substring = substringAfter.substring(indexOf$default + 1, substringAfter.length());
        Intrinsics.checkExpressionValueIsNotNull(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        return substring;
    }

    @NotNull
    public static final String substringAfter(@NotNull String substringAfter, @NotNull String delimiter, @NotNull String missingDelimiterValue) {
        Intrinsics.checkParameterIsNotNull(substringAfter, "$this$substringAfter");
        Intrinsics.checkParameterIsNotNull(delimiter, "delimiter");
        Intrinsics.checkParameterIsNotNull(missingDelimiterValue, "missingDelimiterValue");
        int indexOf$default = indexOf$default((CharSequence) substringAfter, delimiter, 0, false, 6, (Object) null);
        if (indexOf$default == -1) {
            return missingDelimiterValue;
        }
        String substring = substringAfter.substring(indexOf$default + delimiter.length(), substringAfter.length());
        Intrinsics.checkExpressionValueIsNotNull(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        return substring;
    }

    public static /* synthetic */ String substringAfter$default(String str, char c, String str2, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = str;
        }
        return substringAfter(str, c, str2);
    }

    public static /* synthetic */ String substringAfter$default(String str, String str2, String str3, int i, Object obj) {
        if ((i & 2) != 0) {
            str3 = str;
        }
        return substringAfter(str, str2, str3);
    }

    @NotNull
    public static String substringAfterLast(@NotNull String substringAfterLast, char c, @NotNull String missingDelimiterValue) {
        Intrinsics.checkParameterIsNotNull(substringAfterLast, "$this$substringAfterLast");
        Intrinsics.checkParameterIsNotNull(missingDelimiterValue, "missingDelimiterValue");
        int lastIndexOf$default = lastIndexOf$default((CharSequence) substringAfterLast, c, 0, false, 6, (Object) null);
        if (lastIndexOf$default == -1) {
            return missingDelimiterValue;
        }
        String substring = substringAfterLast.substring(lastIndexOf$default + 1, substringAfterLast.length());
        Intrinsics.checkExpressionValueIsNotNull(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        return substring;
    }

    @NotNull
    public static final String substringAfterLast(@NotNull String substringAfterLast, @NotNull String delimiter, @NotNull String missingDelimiterValue) {
        Intrinsics.checkParameterIsNotNull(substringAfterLast, "$this$substringAfterLast");
        Intrinsics.checkParameterIsNotNull(delimiter, "delimiter");
        Intrinsics.checkParameterIsNotNull(missingDelimiterValue, "missingDelimiterValue");
        int lastIndexOf$default = lastIndexOf$default((CharSequence) substringAfterLast, delimiter, 0, false, 6, (Object) null);
        if (lastIndexOf$default == -1) {
            return missingDelimiterValue;
        }
        String substring = substringAfterLast.substring(lastIndexOf$default + delimiter.length(), substringAfterLast.length());
        Intrinsics.checkExpressionValueIsNotNull(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        return substring;
    }

    public static /* synthetic */ String substringAfterLast$default(String str, char c, String str2, int i, Object obj) {
        String substringAfterLast;
        if ((i & 2) != 0) {
            str2 = str;
        }
        substringAfterLast = substringAfterLast(str, c, str2);
        return substringAfterLast;
    }

    public static /* synthetic */ String substringAfterLast$default(String str, String str2, String str3, int i, Object obj) {
        if ((i & 2) != 0) {
            str3 = str;
        }
        return substringAfterLast(str, str2, str3);
    }

    @NotNull
    public static final String substringBefore(@NotNull String substringBefore, char c, @NotNull String missingDelimiterValue) {
        int indexOf$default;
        Intrinsics.checkParameterIsNotNull(substringBefore, "$this$substringBefore");
        Intrinsics.checkParameterIsNotNull(missingDelimiterValue, "missingDelimiterValue");
        indexOf$default = indexOf$default((CharSequence) substringBefore, c, 0, false, 6, (Object) null);
        if (indexOf$default == -1) {
            return missingDelimiterValue;
        }
        String substring = substringBefore.substring(0, indexOf$default);
        Intrinsics.checkExpressionValueIsNotNull(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        return substring;
    }

    @NotNull
    public static final String substringBefore(@NotNull String substringBefore, @NotNull String delimiter, @NotNull String missingDelimiterValue) {
        Intrinsics.checkParameterIsNotNull(substringBefore, "$this$substringBefore");
        Intrinsics.checkParameterIsNotNull(delimiter, "delimiter");
        Intrinsics.checkParameterIsNotNull(missingDelimiterValue, "missingDelimiterValue");
        int indexOf$default = indexOf$default((CharSequence) substringBefore, delimiter, 0, false, 6, (Object) null);
        if (indexOf$default == -1) {
            return missingDelimiterValue;
        }
        String substring = substringBefore.substring(0, indexOf$default);
        Intrinsics.checkExpressionValueIsNotNull(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        return substring;
    }

    public static /* synthetic */ String substringBefore$default(String str, char c, String str2, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = str;
        }
        return substringBefore(str, c, str2);
    }

    public static /* synthetic */ String substringBefore$default(String str, String str2, String str3, int i, Object obj) {
        if ((i & 2) != 0) {
            str3 = str;
        }
        return substringBefore(str, str2, str3);
    }

    @NotNull
    public static final String substringBeforeLast(@NotNull String substringBeforeLast, char c, @NotNull String missingDelimiterValue) {
        Intrinsics.checkParameterIsNotNull(substringBeforeLast, "$this$substringBeforeLast");
        Intrinsics.checkParameterIsNotNull(missingDelimiterValue, "missingDelimiterValue");
        int lastIndexOf$default = lastIndexOf$default((CharSequence) substringBeforeLast, c, 0, false, 6, (Object) null);
        if (lastIndexOf$default == -1) {
            return missingDelimiterValue;
        }
        String substring = substringBeforeLast.substring(0, lastIndexOf$default);
        Intrinsics.checkExpressionValueIsNotNull(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        return substring;
    }

    @NotNull
    public static final String substringBeforeLast(@NotNull String substringBeforeLast, @NotNull String delimiter, @NotNull String missingDelimiterValue) {
        Intrinsics.checkParameterIsNotNull(substringBeforeLast, "$this$substringBeforeLast");
        Intrinsics.checkParameterIsNotNull(delimiter, "delimiter");
        Intrinsics.checkParameterIsNotNull(missingDelimiterValue, "missingDelimiterValue");
        int lastIndexOf$default = lastIndexOf$default((CharSequence) substringBeforeLast, delimiter, 0, false, 6, (Object) null);
        if (lastIndexOf$default == -1) {
            return missingDelimiterValue;
        }
        String substring = substringBeforeLast.substring(0, lastIndexOf$default);
        Intrinsics.checkExpressionValueIsNotNull(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        return substring;
    }

    public static /* synthetic */ String substringBeforeLast$default(String str, char c, String str2, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = str;
        }
        return substringBeforeLast(str, c, str2);
    }

    public static /* synthetic */ String substringBeforeLast$default(String str, String str2, String str3, int i, Object obj) {
        if ((i & 2) != 0) {
            str3 = str;
        }
        return substringBeforeLast(str, str2, str3);
    }

    @NotNull
    public static final CharSequence trim(@NotNull CharSequence trim) {
        Intrinsics.checkParameterIsNotNull(trim, "$this$trim");
        int length = trim.length() - 1;
        int i = 0;
        boolean z = false;
        while (i <= length) {
            boolean isWhitespace = CharsKt__CharJVMKt.isWhitespace(trim.charAt(!z ? i : length));
            if (z) {
                if (!isWhitespace) {
                    break;
                }
                length--;
            } else if (isWhitespace) {
                i++;
            } else {
                z = true;
            }
        }
        return trim.subSequence(i, length + 1);
    }

    @NotNull
    public static final CharSequence trim(@NotNull CharSequence trim, @NotNull Function1<? super Character, Boolean> predicate) {
        Intrinsics.checkParameterIsNotNull(trim, "$this$trim");
        Intrinsics.checkParameterIsNotNull(predicate, "predicate");
        int length = trim.length() - 1;
        int i = 0;
        boolean z = false;
        while (i <= length) {
            boolean booleanValue = predicate.invoke(Character.valueOf(trim.charAt(!z ? i : length))).booleanValue();
            if (z) {
                if (!booleanValue) {
                    break;
                }
                length--;
            } else if (booleanValue) {
                i++;
            } else {
                z = true;
            }
        }
        return trim.subSequence(i, length + 1);
    }

    @NotNull
    public static final CharSequence trim(@NotNull CharSequence trim, @NotNull char... chars) {
        boolean contains;
        Intrinsics.checkParameterIsNotNull(trim, "$this$trim");
        Intrinsics.checkParameterIsNotNull(chars, "chars");
        int length = trim.length() - 1;
        int i = 0;
        boolean z = false;
        while (i <= length) {
            contains = ArraysKt___ArraysKt.contains(chars, trim.charAt(!z ? i : length));
            if (z) {
                if (!contains) {
                    break;
                }
                length--;
            } else if (contains) {
                i++;
            } else {
                z = true;
            }
        }
        return trim.subSequence(i, length + 1);
    }

    @InlineOnly
    private static final String trim(@NotNull String str) {
        if (str != null) {
            return trim((CharSequence) str).toString();
        }
        throw new TypeCastException("null cannot be cast to non-null type kotlin.CharSequence");
    }

    @NotNull
    public static final String trim(@NotNull String trim, @NotNull Function1<? super Character, Boolean> predicate) {
        Intrinsics.checkParameterIsNotNull(trim, "$this$trim");
        Intrinsics.checkParameterIsNotNull(predicate, "predicate");
        int length = trim.length() - 1;
        int i = 0;
        boolean z = false;
        while (i <= length) {
            boolean booleanValue = predicate.invoke(Character.valueOf(trim.charAt(!z ? i : length))).booleanValue();
            if (z) {
                if (!booleanValue) {
                    break;
                }
                length--;
            } else if (booleanValue) {
                i++;
            } else {
                z = true;
            }
        }
        return trim.subSequence(i, length + 1).toString();
    }

    @NotNull
    public static final String trim(@NotNull String trim, @NotNull char... chars) {
        boolean contains;
        Intrinsics.checkParameterIsNotNull(trim, "$this$trim");
        Intrinsics.checkParameterIsNotNull(chars, "chars");
        int length = trim.length() - 1;
        int i = 0;
        boolean z = false;
        while (i <= length) {
            contains = ArraysKt___ArraysKt.contains(chars, trim.charAt(!z ? i : length));
            if (z) {
                if (!contains) {
                    break;
                }
                length--;
            } else if (contains) {
                i++;
            } else {
                z = true;
            }
        }
        return trim.subSequence(i, length + 1).toString();
    }

    @NotNull
    public static final CharSequence trimEnd(@NotNull CharSequence trimEnd) {
        Intrinsics.checkParameterIsNotNull(trimEnd, "$this$trimEnd");
        int length = trimEnd.length();
        do {
            length--;
            if (length < 0) {
                return "";
            }
        } while (CharsKt__CharJVMKt.isWhitespace(trimEnd.charAt(length)));
        return trimEnd.subSequence(0, length + 1);
    }

    @NotNull
    public static final CharSequence trimEnd(@NotNull CharSequence trimEnd, @NotNull Function1<? super Character, Boolean> predicate) {
        Intrinsics.checkParameterIsNotNull(trimEnd, "$this$trimEnd");
        Intrinsics.checkParameterIsNotNull(predicate, "predicate");
        int length = trimEnd.length();
        do {
            length--;
            if (length < 0) {
                return "";
            }
        } while (predicate.invoke(Character.valueOf(trimEnd.charAt(length))).booleanValue());
        return trimEnd.subSequence(0, length + 1);
    }

    @NotNull
    public static final CharSequence trimEnd(@NotNull CharSequence trimEnd, @NotNull char... chars) {
        boolean contains;
        Intrinsics.checkParameterIsNotNull(trimEnd, "$this$trimEnd");
        Intrinsics.checkParameterIsNotNull(chars, "chars");
        int length = trimEnd.length();
        do {
            length--;
            if (length < 0) {
                return "";
            }
            contains = ArraysKt___ArraysKt.contains(chars, trimEnd.charAt(length));
        } while (contains);
        return trimEnd.subSequence(0, length + 1);
    }

    @InlineOnly
    private static final String trimEnd(@NotNull String str) {
        if (str != null) {
            return trimEnd((CharSequence) str).toString();
        }
        throw new TypeCastException("null cannot be cast to non-null type kotlin.CharSequence");
    }

    @NotNull
    public static final String trimEnd(@NotNull String trimEnd, @NotNull Function1<? super Character, Boolean> predicate) {
        CharSequence charSequence;
        Intrinsics.checkParameterIsNotNull(trimEnd, "$this$trimEnd");
        Intrinsics.checkParameterIsNotNull(predicate, "predicate");
        int length = trimEnd.length();
        while (true) {
            length--;
            if (length < 0) {
                charSequence = "";
                break;
            }
            if (!predicate.invoke(Character.valueOf(trimEnd.charAt(length))).booleanValue()) {
                charSequence = trimEnd.subSequence(0, length + 1);
                break;
            }
        }
        return charSequence.toString();
    }

    @NotNull
    public static final String trimEnd(@NotNull String trimEnd, @NotNull char... chars) {
        CharSequence charSequence;
        boolean contains;
        Intrinsics.checkParameterIsNotNull(trimEnd, "$this$trimEnd");
        Intrinsics.checkParameterIsNotNull(chars, "chars");
        int length = trimEnd.length();
        while (true) {
            length--;
            if (length < 0) {
                charSequence = "";
                break;
            }
            contains = ArraysKt___ArraysKt.contains(chars, trimEnd.charAt(length));
            if (!contains) {
                charSequence = trimEnd.subSequence(0, length + 1);
                break;
            }
        }
        return charSequence.toString();
    }

    @NotNull
    public static final CharSequence trimStart(@NotNull CharSequence trimStart) {
        Intrinsics.checkParameterIsNotNull(trimStart, "$this$trimStart");
        int length = trimStart.length();
        for (int i = 0; i < length; i++) {
            if (!CharsKt__CharJVMKt.isWhitespace(trimStart.charAt(i))) {
                return trimStart.subSequence(i, trimStart.length());
            }
        }
        return "";
    }

    @NotNull
    public static final CharSequence trimStart(@NotNull CharSequence trimStart, @NotNull Function1<? super Character, Boolean> predicate) {
        Intrinsics.checkParameterIsNotNull(trimStart, "$this$trimStart");
        Intrinsics.checkParameterIsNotNull(predicate, "predicate");
        int length = trimStart.length();
        for (int i = 0; i < length; i++) {
            if (!predicate.invoke(Character.valueOf(trimStart.charAt(i))).booleanValue()) {
                return trimStart.subSequence(i, trimStart.length());
            }
        }
        return "";
    }

    @NotNull
    public static final CharSequence trimStart(@NotNull CharSequence trimStart, @NotNull char... chars) {
        boolean contains;
        Intrinsics.checkParameterIsNotNull(trimStart, "$this$trimStart");
        Intrinsics.checkParameterIsNotNull(chars, "chars");
        int length = trimStart.length();
        for (int i = 0; i < length; i++) {
            contains = ArraysKt___ArraysKt.contains(chars, trimStart.charAt(i));
            if (!contains) {
                return trimStart.subSequence(i, trimStart.length());
            }
        }
        return "";
    }

    @InlineOnly
    private static final String trimStart(@NotNull String str) {
        if (str != null) {
            return trimStart((CharSequence) str).toString();
        }
        throw new TypeCastException("null cannot be cast to non-null type kotlin.CharSequence");
    }

    @NotNull
    public static final String trimStart(@NotNull String trimStart, @NotNull Function1<? super Character, Boolean> predicate) {
        CharSequence charSequence;
        Intrinsics.checkParameterIsNotNull(trimStart, "$this$trimStart");
        Intrinsics.checkParameterIsNotNull(predicate, "predicate");
        int length = trimStart.length();
        int i = 0;
        while (true) {
            if (i >= length) {
                charSequence = "";
                break;
            }
            if (!predicate.invoke(Character.valueOf(trimStart.charAt(i))).booleanValue()) {
                charSequence = trimStart.subSequence(i, trimStart.length());
                break;
            }
            i++;
        }
        return charSequence.toString();
    }

    @NotNull
    public static final String trimStart(@NotNull String trimStart, @NotNull char... chars) {
        CharSequence charSequence;
        boolean contains;
        Intrinsics.checkParameterIsNotNull(trimStart, "$this$trimStart");
        Intrinsics.checkParameterIsNotNull(chars, "chars");
        int length = trimStart.length();
        int i = 0;
        while (true) {
            if (i >= length) {
                charSequence = "";
                break;
            }
            contains = ArraysKt___ArraysKt.contains(chars, trimStart.charAt(i));
            if (!contains) {
                charSequence = trimStart.subSequence(i, trimStart.length());
                break;
            }
            i++;
        }
        return charSequence.toString();
    }
}
