package com.samsung.sr.nmt.t2t.translator.core.pipeline.symbols;

import androidx.appcompat.app.AppCompatDelegate;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.location.LocationRequestCompat;
import com.fasterxml.jackson.annotation.JsonProperty;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlinx.coroutines.scheduling.WorkQueueKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: EmojiSymbols.kt */
@Metadata(d1 = {"\u0000\u0013\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0003\b¯\u0001\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001dj\u0002\b\u001ej\u0002\b\u001fj\u0002\b j\u0002\b!j\u0002\b\"j\u0002\b#j\u0002\b$j\u0002\b%j\u0002\b&j\u0002\b'j\u0002\b(j\u0002\b)j\u0002\b*j\u0002\b+j\u0002\b,j\u0002\b-j\u0002\b.j\u0002\b/j\u0002\b0j\u0002\b1j\u0002\b2j\u0002\b3j\u0002\b4j\u0002\b5j\u0002\b6j\u0002\b7j\u0002\b8j\u0002\b9j\u0002\b:j\u0002\b;j\u0002\b<j\u0002\b=j\u0002\b>j\u0002\b?j\u0002\b@j\u0002\bAj\u0002\bBj\u0002\bCj\u0002\bDj\u0002\bEj\u0002\bFj\u0002\bGj\u0002\bHj\u0002\bIj\u0002\bJj\u0002\bKj\u0002\bLj\u0002\bMj\u0002\bNj\u0002\bOj\u0002\bPj\u0002\bQj\u0002\bRj\u0002\bSj\u0002\bTj\u0002\bUj\u0002\bVj\u0002\bWj\u0002\bXj\u0002\bYj\u0002\bZj\u0002\b[j\u0002\b\\j\u0002\b]j\u0002\b^j\u0002\b_j\u0002\b`j\u0002\baj\u0002\bbj\u0002\bcj\u0002\bdj\u0002\bej\u0002\bfj\u0002\bgj\u0002\bhj\u0002\bij\u0002\bjj\u0002\bkj\u0002\blj\u0002\bmj\u0002\bnj\u0002\boj\u0002\bpj\u0002\bqj\u0002\brj\u0002\bsj\u0002\btj\u0002\buj\u0002\bvj\u0002\bwj\u0002\bxj\u0002\byj\u0002\bzj\u0002\b{j\u0002\b|j\u0002\b}j\u0002\b~j\u0002\b\u007fj\u0003\b\u0080\u0001j\u0003\b\u0081\u0001j\u0003\b\u0082\u0001j\u0003\b\u0083\u0001j\u0003\b\u0084\u0001j\u0003\b\u0085\u0001j\u0003\b\u0086\u0001j\u0003\b\u0087\u0001j\u0003\b\u0088\u0001j\u0003\b\u0089\u0001j\u0003\b\u008a\u0001j\u0003\b\u008b\u0001j\u0003\b\u008c\u0001j\u0003\b\u008d\u0001j\u0003\b\u008e\u0001j\u0003\b\u008f\u0001j\u0003\b\u0090\u0001j\u0003\b\u0091\u0001j\u0003\b\u0092\u0001j\u0003\b\u0093\u0001j\u0003\b\u0094\u0001j\u0003\b\u0095\u0001j\u0003\b\u0096\u0001j\u0003\b\u0097\u0001j\u0003\b\u0098\u0001j\u0003\b\u0099\u0001j\u0003\b\u009a\u0001j\u0003\b\u009b\u0001j\u0003\b\u009c\u0001j\u0003\b\u009d\u0001j\u0003\b\u009e\u0001j\u0003\b\u009f\u0001j\u0003\b \u0001j\u0003\b¡\u0001j\u0003\b¢\u0001j\u0003\b£\u0001j\u0003\b¤\u0001j\u0003\b¥\u0001j\u0003\b¦\u0001j\u0003\b§\u0001j\u0003\b¨\u0001j\u0003\b©\u0001j\u0003\bª\u0001j\u0003\b«\u0001j\u0003\b¬\u0001j\u0003\b\u00ad\u0001j\u0003\b®\u0001j\u0003\b¯\u0001j\u0003\b°\u0001j\u0003\b±\u0001¨\u0006²\u0001"}, d2 = {"Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/symbols/EmojiSymbols;", JsonProperty.USE_DEFAULT_NAME, "regex", JsonProperty.USE_DEFAULT_NAME, "(Ljava/lang/String;ILjava/lang/String;)V", "getRegex", "()Ljava/lang/String;", "EMOJI0", "EMOJI1", "EMOJI2", "EMOJI3", "EMOJI4", "EMOJI5", "EMOJI6", "EMOJI7", "EMOJI8", "EMOJI9", "EMOJI10", "EMOJI12", "EMOJI13", "EMOJI14", "EMOJI15", "EMOJI16", "EMOJI17", "EMOJI18", "EMOJI19", "EMOJI20", "EMOJI21", "EMOJI22", "EMOJI23", "EMOJI24", "EMOJI25", "EMOJI26", "EMOJI27", "EMOJI28", "EMOJI29", "EMOJI30", "EMOJI31", "EMOJI32", "EMOJI33", "EMOJI34", "EMOJI35", "EMOJI36", "EMOJI37", "EMOJI38", "EMOJI39", "EMOJI40", "EMOJI41", "EMOJI42", "EMOJI43", "EMOJI44", "EMOJI45", "EMOJI46", "EMOJI47", "EMOJI48", "EMOJI49", "EMOJI50", "EMOJI51", "EMOJI52", "EMOJI53", "EMOJI54", "EMOJI55", "EMOJI56", "EMOJI57", "EMOJI58", "EMOJI59", "EMOJI60", "EMOJI61", "EMOJI62", "EMOJI63", "EMOJI64", "EMOJI65", "EMOJI66", "EMOJI67", "EMOJI68", "EMOJI69", "EMOJI70", "EMOJI71", "EMOJI72", "EMOJI73", "EMOJI74", "EMOJI75", "EMOJI76", "EMOJI77", "EMOJI78", "EMOJI79", "EMOJI80", "EMOJI81", "EMOJI82", "EMOJI83", "EMOJI84", "EMOJI85", "EMOJI86", "EMOJI87", "EMOJI88", "EMOJI89", "EMOJI90", "EMOJI91", "EMOJI92", "EMOJI93", "EMOJI94", "EMOJI95", "EMOJI96", "EMOJI97", "EMOJI98", "EMOJI99", "EMOJI100", "EMOJI101", "EMOJI102", "EMOJI103", "EMOJI104", "EMOJI105", "EMOJI106", "EMOJI107", "EMOJI108", "EMOJI109", "EMOJI110", "EMOJI111", "EMOJI112", "EMOJI113", "EMOJI114", "EMOJI115", "EMOJI116", "EMOJI117", "EMOJI118", "EMOJI119", "EMOJI120", "EMOJI121", "EMOJI122", "EMOJI123", "EMOJI124", "EMOJI125", "EMOJI126", "EMOJI127", "EMOJI128", "EMOJI129", "EMOJI130", "EMOJI131", "EMOJI132", "EMOJI133", "EMOJI134", "EMOJI135", "EMOJI136", "EMOJI137", "EMOJI138", "EMOJI139", "EMOJI140", "EMOJI141", "EMOJI142", "EMOJI143", "EMOJI144", "EMOJI145", "EMOJI146", "EMOJI147", "EMOJI148", "EMOJI149", "EMOJI150", "EMOJI151", "EMOJI152", "EMOJI153", "EMOJI154", "EMOJI155", "EMOJI156", "EMOJI157", "EMOJI158", "EMOJI159", "EMOJI160", "EMOJI161", "EMOJI162", "EMOJI163", "EMOJI164", "EMOJI165", "EMOJI166", "EMOJI167", "EMOJI168", "EMOJI169", "EMOJI170", "EMOJI171", "translator-core"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class EmojiSymbols {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ EmojiSymbols[] $VALUES;
    private final String regex;
    public static final EmojiSymbols EMOJI0 = new EmojiSymbols("EMOJI0", 0, "[🆭-🇿]");
    public static final EmojiSymbols EMOJI1 = new EmojiSymbols("EMOJI1", 1, "[🇮]");
    public static final EmojiSymbols EMOJI2 = new EmojiSymbols("EMOJI2", 2, "[🇱-🇴]");
    public static final EmojiSymbols EMOJI3 = new EmojiSymbols("EMOJI3", 3, "[🇴]");
    public static final EmojiSymbols EMOJI4 = new EmojiSymbols("EMOJI4", 4, "[🇶-🇿]");
    public static final EmojiSymbols EMOJI5 = new EmojiSymbols("EMOJI5", 5, "[🇼-🇿]");
    public static final EmojiSymbols EMOJI6 = new EmojiSymbols("EMOJI6", 6, "[🇿]");
    public static final EmojiSymbols EMOJI7 = new EmojiSymbols("EMOJI7", 7, "[🇦]");
    public static final EmojiSymbols EMOJI8 = new EmojiSymbols("EMOJI8", 8, "[🎜-🔽]");
    public static final EmojiSymbols EMOJI9 = new EmojiSymbols("EMOJI9", 9, "[#]");
    public static final EmojiSymbols EMOJI10 = new EmojiSymbols("EMOJI10", 10, "[*]");
    public static final EmojiSymbols EMOJI12 = new EmojiSymbols("EMOJI12", 11, "[©]");
    public static final EmojiSymbols EMOJI13 = new EmojiSymbols("EMOJI13", 12, "[®]");
    public static final EmojiSymbols EMOJI14 = new EmojiSymbols("EMOJI14", 13, "[‼]");
    public static final EmojiSymbols EMOJI15 = new EmojiSymbols("EMOJI15", 14, "[⁉]");
    public static final EmojiSymbols EMOJI16 = new EmojiSymbols("EMOJI16", 15, "[™]");
    public static final EmojiSymbols EMOJI17 = new EmojiSymbols("EMOJI17", 16, "[ℹ]");
    public static final EmojiSymbols EMOJI18 = new EmojiSymbols("EMOJI18", 17, "[↔-↙]");
    public static final EmojiSymbols EMOJI19 = new EmojiSymbols("EMOJI19", 18, "[↩-↪]");
    public static final EmojiSymbols EMOJI20 = new EmojiSymbols("EMOJI20", 19, "[⌚-⌛]");
    public static final EmojiSymbols EMOJI21 = new EmojiSymbols("EMOJI21", 20, "[⌨]");
    public static final EmojiSymbols EMOJI22 = new EmojiSymbols("EMOJI22", 21, "[⏏]");
    public static final EmojiSymbols EMOJI23 = new EmojiSymbols("EMOJI23", 22, "[⏩-⏳]");
    public static final EmojiSymbols EMOJI24 = new EmojiSymbols("EMOJI24", 23, "[⏸-⏺]");
    public static final EmojiSymbols EMOJI25 = new EmojiSymbols("EMOJI25", 24, "[Ⓜ]");
    public static final EmojiSymbols EMOJI26 = new EmojiSymbols("EMOJI26", 25, "[▪-▫]");
    public static final EmojiSymbols EMOJI27 = new EmojiSymbols("EMOJI27", 26, "[▶]");
    public static final EmojiSymbols EMOJI28 = new EmojiSymbols("EMOJI28", 27, "[◀]");
    public static final EmojiSymbols EMOJI29 = new EmojiSymbols("EMOJI29", 28, "[◻-◾]");
    public static final EmojiSymbols EMOJI30 = new EmojiSymbols("EMOJI30", 29, "[☀-★]");
    public static final EmojiSymbols EMOJI31 = new EmojiSymbols("EMOJI31", 30, "[☇-☒]");
    public static final EmojiSymbols EMOJI32 = new EmojiSymbols("EMOJI32", 31, "[☇-☑]");
    public static final EmojiSymbols EMOJI33 = new EmojiSymbols("EMOJI33", 32, "[☔-⚅]");
    public static final EmojiSymbols EMOJI34 = new EmojiSymbols("EMOJI34", 33, "[☘]");
    public static final EmojiSymbols EMOJI35 = new EmojiSymbols("EMOJI35", 34, "[☝]");
    public static final EmojiSymbols EMOJI36 = new EmojiSymbols("EMOJI36", 35, "[☠]");
    public static final EmojiSymbols EMOJI37 = new EmojiSymbols("EMOJI37", 36, "[☢-☣]");
    public static final EmojiSymbols EMOJI38 = new EmojiSymbols("EMOJI38", 37, "[☦]");
    public static final EmojiSymbols EMOJI39 = new EmojiSymbols("EMOJI39", 38, "[☪]");
    public static final EmojiSymbols EMOJI40 = new EmojiSymbols("EMOJI40", 39, "[☮-☯]");
    public static final EmojiSymbols EMOJI41 = new EmojiSymbols("EMOJI41", 40, "[☸-☺]");
    public static final EmojiSymbols EMOJI42 = new EmojiSymbols("EMOJI42", 41, "[♀]");
    public static final EmojiSymbols EMOJI43 = new EmojiSymbols("EMOJI43", 42, "[♂]");
    public static final EmojiSymbols EMOJI44 = new EmojiSymbols("EMOJI44", 43, "[♈-♓]");
    public static final EmojiSymbols EMOJI45 = new EmojiSymbols("EMOJI45", 44, "[♟-♠]");
    public static final EmojiSymbols EMOJI46 = new EmojiSymbols("EMOJI46", 45, "[♣]");
    public static final EmojiSymbols EMOJI47 = new EmojiSymbols("EMOJI47", 46, "[♥-♦]");
    public static final EmojiSymbols EMOJI48 = new EmojiSymbols("EMOJI48", 47, "[♨]");
    public static final EmojiSymbols EMOJI49 = new EmojiSymbols("EMOJI49", 48, "[♻]");
    public static final EmojiSymbols EMOJI50 = new EmojiSymbols("EMOJI50", 49, "[♾-♿]");
    public static final EmojiSymbols EMOJI51 = new EmojiSymbols("EMOJI51", 50, "[⚐-✅]");
    public static final EmojiSymbols EMOJI52 = new EmojiSymbols("EMOJI52", 51, "[⚙]");
    public static final EmojiSymbols EMOJI53 = new EmojiSymbols("EMOJI53", 52, "[⚛-⚜]");
    public static final EmojiSymbols EMOJI54 = new EmojiSymbols("EMOJI54", 53, "[⚠-⚡]");
    public static final EmojiSymbols EMOJI55 = new EmojiSymbols("EMOJI55", 54, "[⚪-⚫]");
    public static final EmojiSymbols EMOJI56 = new EmojiSymbols("EMOJI56", 55, "[⚰-⚱]");
    public static final EmojiSymbols EMOJI57 = new EmojiSymbols("EMOJI57", 56, "[⚽-⚾]");
    public static final EmojiSymbols EMOJI58 = new EmojiSymbols("EMOJI58", 57, "[⛄-⛅]");
    public static final EmojiSymbols EMOJI59 = new EmojiSymbols("EMOJI59", 58, "[⛈]");
    public static final EmojiSymbols EMOJI60 = new EmojiSymbols("EMOJI60", 59, "[⛎-⛏]");
    public static final EmojiSymbols EMOJI61 = new EmojiSymbols("EMOJI61", 60, "[⛑]");
    public static final EmojiSymbols EMOJI62 = new EmojiSymbols("EMOJI62", 61, "[⛓-⛔]");
    public static final EmojiSymbols EMOJI63 = new EmojiSymbols("EMOJI63", 62, "[⛩-⛪]");
    public static final EmojiSymbols EMOJI64 = new EmojiSymbols("EMOJI64", 63, "[⛰-⛵]");
    public static final EmojiSymbols EMOJI65 = new EmojiSymbols("EMOJI65", 64, "[⛷-⛺]");
    public static final EmojiSymbols EMOJI66 = new EmojiSymbols("EMOJI66", 65, "[⛽]");
    public static final EmojiSymbols EMOJI67 = new EmojiSymbols("EMOJI67", 66, "[✂]");
    public static final EmojiSymbols EMOJI68 = new EmojiSymbols("EMOJI68", 67, "[✅]");
    public static final EmojiSymbols EMOJI69 = new EmojiSymbols("EMOJI69", 68, "[✈-✒]");
    public static final EmojiSymbols EMOJI70 = new EmojiSymbols("EMOJI70", 69, "[✏]");
    public static final EmojiSymbols EMOJI71 = new EmojiSymbols("EMOJI71", 70, "[✒]");
    public static final EmojiSymbols EMOJI72 = new EmojiSymbols("EMOJI72", 71, "[✔]");
    public static final EmojiSymbols EMOJI73 = new EmojiSymbols("EMOJI73", 72, "[✖]");
    public static final EmojiSymbols EMOJI74 = new EmojiSymbols("EMOJI74", 73, "[✝]");
    public static final EmojiSymbols EMOJI75 = new EmojiSymbols("EMOJI75", 74, "[✡]");
    public static final EmojiSymbols EMOJI76 = new EmojiSymbols("EMOJI76", 75, "[✨]");
    public static final EmojiSymbols EMOJI77 = new EmojiSymbols("EMOJI77", 76, "[✳-✴]");
    public static final EmojiSymbols EMOJI78 = new EmojiSymbols("EMOJI78", 77, "[❄]");
    public static final EmojiSymbols EMOJI79 = new EmojiSymbols("EMOJI79", 78, "[❇]");
    public static final EmojiSymbols EMOJI80 = new EmojiSymbols("EMOJI80", 79, "[❌]");
    public static final EmojiSymbols EMOJI81 = new EmojiSymbols("EMOJI81", 80, "[❎]");
    public static final EmojiSymbols EMOJI82 = new EmojiSymbols("EMOJI82", 81, "[❓-❕]");
    public static final EmojiSymbols EMOJI83 = new EmojiSymbols("EMOJI83", 82, "[❗]");
    public static final EmojiSymbols EMOJI84 = new EmojiSymbols("EMOJI84", 83, "[❣-❧]");
    public static final EmojiSymbols EMOJI85 = new EmojiSymbols("EMOJI85", 84, "[➕-➗]");
    public static final EmojiSymbols EMOJI86 = new EmojiSymbols("EMOJI86", 85, "[➡]");
    public static final EmojiSymbols EMOJI87 = new EmojiSymbols("EMOJI87", 86, "[➰]");
    public static final EmojiSymbols EMOJI88 = new EmojiSymbols("EMOJI88", 87, "[➿]");
    public static final EmojiSymbols EMOJI89 = new EmojiSymbols("EMOJI89", 88, "[⤴-⤵]");
    public static final EmojiSymbols EMOJI90 = new EmojiSymbols("EMOJI90", 89, "[⬅-⬇]");
    public static final EmojiSymbols EMOJI91 = new EmojiSymbols("EMOJI91", 90, "[⬛-⬜]");
    public static final EmojiSymbols EMOJI92 = new EmojiSymbols("EMOJI92", 91, "[⭐]");
    public static final EmojiSymbols EMOJI93 = new EmojiSymbols("EMOJI93", 92, "[⭕]");
    public static final EmojiSymbols EMOJI94 = new EmojiSymbols("EMOJI94", 93, "[〰]");
    public static final EmojiSymbols EMOJI95 = new EmojiSymbols("EMOJI95", 94, "[〽]");
    public static final EmojiSymbols EMOJI96 = new EmojiSymbols("EMOJI96", 95, "[㊗]");
    public static final EmojiSymbols EMOJI97 = new EmojiSymbols("EMOJI97", 96, "[㊙]");
    public static final EmojiSymbols EMOJI98 = new EmojiSymbols("EMOJI98", 97, "[🀀-\u1f0ff]");
    public static final EmojiSymbols EMOJI99 = new EmojiSymbols("EMOJI99", 98, "[\u1f0c0-\u1f0ff]");
    public static final EmojiSymbols EMOJI100 = new EmojiSymbols("EMOJI100", 99, "[🅬-🅱]");
    public static final EmojiSymbols EMOJI101 = new EmojiSymbols("EMOJI101", 100, "[🅾-🅿]");
    public static final EmojiSymbols EMOJI102 = new EmojiSymbols("EMOJI102", 101, "[🆎]");
    public static final EmojiSymbols EMOJI103 = new EmojiSymbols("EMOJI103", LocationRequestCompat.QUALITY_BALANCED_POWER_ACCURACY, "[🆑-🆚]");
    public static final EmojiSymbols EMOJI104 = new EmojiSymbols("EMOJI104", 103, "[🈁-\u1f20f]");
    public static final EmojiSymbols EMOJI105 = new EmojiSymbols("EMOJI105", LocationRequestCompat.QUALITY_LOW_POWER, "[🈚]");
    public static final EmojiSymbols EMOJI106 = new EmojiSymbols("EMOJI106", 105, "[🈯]");
    public static final EmojiSymbols EMOJI107 = new EmojiSymbols("EMOJI107", 106, "[🈲-🈺]");
    public static final EmojiSymbols EMOJI108 = new EmojiSymbols("EMOJI108", 107, "[\u1f249-🏰]");
    public static final EmojiSymbols EMOJI109 = new EmojiSymbols("EMOJI109", AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR, "[🌀-🌡]");
    public static final EmojiSymbols EMOJI110 = new EmojiSymbols("EMOJI110", AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY, "[🌤-🎓]");
    public static final EmojiSymbols EMOJI111 = new EmojiSymbols("EMOJI111", 110, "[🎖-🎗]");
    public static final EmojiSymbols EMOJI112 = new EmojiSymbols("EMOJI112", 111, "[🎙-🎛]");
    public static final EmojiSymbols EMOJI113 = new EmojiSymbols("EMOJI113", 112, "[🎞-🏰]");
    public static final EmojiSymbols EMOJI114 = new EmojiSymbols("EMOJI114", 113, "[🏳-🏵]");
    public static final EmojiSymbols EMOJI115 = new EmojiSymbols("EMOJI115", 114, "[🏷]");
    public static final EmojiSymbols EMOJI116 = new EmojiSymbols("EMOJI116", 115, "[🐀-📽]");
    public static final EmojiSymbols EMOJI117 = new EmojiSymbols("EMOJI117", 116, "[📿-🔽]");
    public static final EmojiSymbols EMOJI118 = new EmojiSymbols("EMOJI118", 117, "[🕆-🙏]");
    public static final EmojiSymbols EMOJI119 = new EmojiSymbols("EMOJI119", 118, "[🕐-🙏]");
    public static final EmojiSymbols EMOJI120 = new EmojiSymbols("EMOJI120", 119, "[🕯-🕰]");
    public static final EmojiSymbols EMOJI121 = new EmojiSymbols("EMOJI121", 120, "[🕳-🕺]");
    public static final EmojiSymbols EMOJI122 = new EmojiSymbols("EMOJI122", 121, "[🖇]");
    public static final EmojiSymbols EMOJI123 = new EmojiSymbols("EMOJI123", 122, "[🖊-🖍]");
    public static final EmojiSymbols EMOJI124 = new EmojiSymbols("EMOJI124", 123, "[🖐]");
    public static final EmojiSymbols EMOJI125 = new EmojiSymbols("EMOJI125", 124, "[🖕-🖖]");
    public static final EmojiSymbols EMOJI126 = new EmojiSymbols("EMOJI126", 125, "[🖤-🖥]");
    public static final EmojiSymbols EMOJI127 = new EmojiSymbols("EMOJI127", 126, "[🖨]");
    public static final EmojiSymbols EMOJI128 = new EmojiSymbols("EMOJI128", WorkQueueKt.MASK, "[🖱-🖲]");
    public static final EmojiSymbols EMOJI129 = new EmojiSymbols("EMOJI129", 128, "[🖼]");
    public static final EmojiSymbols EMOJI130 = new EmojiSymbols("EMOJI130", 129, "[🗂-🗄]");
    public static final EmojiSymbols EMOJI131 = new EmojiSymbols("EMOJI131", 130, "[🗑-🗓]");
    public static final EmojiSymbols EMOJI132 = new EmojiSymbols("EMOJI132", 131, "[🗜-🗞]");
    public static final EmojiSymbols EMOJI133 = new EmojiSymbols("EMOJI133", 132, "[🗡]");
    public static final EmojiSymbols EMOJI134 = new EmojiSymbols("EMOJI134", 133, "[🗣]");
    public static final EmojiSymbols EMOJI135 = new EmojiSymbols("EMOJI135", 134, "[🗨]");
    public static final EmojiSymbols EMOJI136 = new EmojiSymbols("EMOJI136", 135, "[🗯]");
    public static final EmojiSymbols EMOJI137 = new EmojiSymbols("EMOJI137", 136, "[🗳]");
    public static final EmojiSymbols EMOJI138 = new EmojiSymbols("EMOJI138", 137, "[🗺-🙏]");
    public static final EmojiSymbols EMOJI139 = new EmojiSymbols("EMOJI139", 138, "[🚀-\u1f6ff]");
    public static final EmojiSymbols EMOJI140 = new EmojiSymbols("EMOJI140", 139, "[🛋-🛒]");
    public static final EmojiSymbols EMOJI141 = new EmojiSymbols("EMOJI141", 140, "[🛠-🛥]");
    public static final EmojiSymbols EMOJI142 = new EmojiSymbols("EMOJI142", 141, "[🛩]");
    public static final EmojiSymbols EMOJI143 = new EmojiSymbols("EMOJI143", 142, "[🛫-🛬]");
    public static final EmojiSymbols EMOJI144 = new EmojiSymbols("EMOJI144", 143, "[🛰]");
    public static final EmojiSymbols EMOJI145 = new EmojiSymbols("EMOJI145", 144, "[🛳-🛹]");
    public static final EmojiSymbols EMOJI146 = new EmojiSymbols("EMOJI146", 145, "[🤌-🤺]");
    public static final EmojiSymbols EMOJI147 = new EmojiSymbols("EMOJI147", 146, "[🤼-🥅]");
    public static final EmojiSymbols EMOJI148 = new EmojiSymbols("EMOJI148", 147, "[🥀-🥅]");
    public static final EmojiSymbols EMOJI149 = new EmojiSymbols("EMOJI149", 148, "[🥇-\u1fffd]");
    public static final EmojiSymbols EMOJI150 = new EmojiSymbols("EMOJI150", 149, "[🥳-🥶]");
    public static final EmojiSymbols EMOJI151 = new EmojiSymbols("EMOJI151", 150, "[🥺]");
    public static final EmojiSymbols EMOJI152 = new EmojiSymbols("EMOJI152", 151, "[🥼-🦢]");
    public static final EmojiSymbols EMOJI153 = new EmojiSymbols("EMOJI153", 152, "[🦰-🦹]");
    public static final EmojiSymbols EMOJI154 = new EmojiSymbols("EMOJI154", 153, "[🧀-🧂]");
    public static final EmojiSymbols EMOJI155 = new EmojiSymbols("EMOJI155", 154, "[🧐-🧿]");
    public static final EmojiSymbols EMOJI156 = new EmojiSymbols("EMOJI156", 155, "[\u200d]");
    public static final EmojiSymbols EMOJI157 = new EmojiSymbols("EMOJI157", 156, "[⃣]");
    public static final EmojiSymbols EMOJI158 = new EmojiSymbols("EMOJI158", 157, "[️]");
    public static final EmojiSymbols EMOJI159 = new EmojiSymbols("EMOJI159", 158, "[\ue0020-\ue007f]");
    public static final EmojiSymbols EMOJI160 = new EmojiSymbols("EMOJI160", 159, "[⎈]");
    public static final EmojiSymbols EMOJI161 = new EmojiSymbols("EMOJI161", 160, "[🀀-\u1f0c0]");
    public static final EmojiSymbols EMOJI162 = new EmojiSymbols("EMOJI162", 161, "[🄍-🄏]");
    public static final EmojiSymbols EMOJI163 = new EmojiSymbols("EMOJI163", 162, "[🄯]");
    public static final EmojiSymbols EMOJI164 = new EmojiSymbols("EMOJI164", 163, "[\u1f23c-\u1f23f]");
    public static final EmojiSymbols EMOJI165 = new EmojiSymbols("EMOJI165", 164, "[\u1f774-\u1f77f]");
    public static final EmojiSymbols EMOJI166 = new EmojiSymbols("EMOJI166", 165, "[🟕-\u1f7ff]");
    public static final EmojiSymbols EMOJI167 = new EmojiSymbols("EMOJI167", 166, "[\u1f80c-\u1f80f]");
    public static final EmojiSymbols EMOJI168 = new EmojiSymbols("EMOJI168", 167, "[\u1f848-\u1f84f]");
    public static final EmojiSymbols EMOJI169 = new EmojiSymbols("EMOJI169", 168, "[\u1f85a-\u1f85f]");
    public static final EmojiSymbols EMOJI170 = new EmojiSymbols("EMOJI170", 169, "[\u1f888-\u1f88f]");
    public static final EmojiSymbols EMOJI171 = new EmojiSymbols("EMOJI171", 170, "[\u1f8ae-\u1f8ff]");

    private static final /* synthetic */ EmojiSymbols[] $values() {
        return new EmojiSymbols[]{EMOJI0, EMOJI1, EMOJI2, EMOJI3, EMOJI4, EMOJI5, EMOJI6, EMOJI7, EMOJI8, EMOJI9, EMOJI10, EMOJI12, EMOJI13, EMOJI14, EMOJI15, EMOJI16, EMOJI17, EMOJI18, EMOJI19, EMOJI20, EMOJI21, EMOJI22, EMOJI23, EMOJI24, EMOJI25, EMOJI26, EMOJI27, EMOJI28, EMOJI29, EMOJI30, EMOJI31, EMOJI32, EMOJI33, EMOJI34, EMOJI35, EMOJI36, EMOJI37, EMOJI38, EMOJI39, EMOJI40, EMOJI41, EMOJI42, EMOJI43, EMOJI44, EMOJI45, EMOJI46, EMOJI47, EMOJI48, EMOJI49, EMOJI50, EMOJI51, EMOJI52, EMOJI53, EMOJI54, EMOJI55, EMOJI56, EMOJI57, EMOJI58, EMOJI59, EMOJI60, EMOJI61, EMOJI62, EMOJI63, EMOJI64, EMOJI65, EMOJI66, EMOJI67, EMOJI68, EMOJI69, EMOJI70, EMOJI71, EMOJI72, EMOJI73, EMOJI74, EMOJI75, EMOJI76, EMOJI77, EMOJI78, EMOJI79, EMOJI80, EMOJI81, EMOJI82, EMOJI83, EMOJI84, EMOJI85, EMOJI86, EMOJI87, EMOJI88, EMOJI89, EMOJI90, EMOJI91, EMOJI92, EMOJI93, EMOJI94, EMOJI95, EMOJI96, EMOJI97, EMOJI98, EMOJI99, EMOJI100, EMOJI101, EMOJI102, EMOJI103, EMOJI104, EMOJI105, EMOJI106, EMOJI107, EMOJI108, EMOJI109, EMOJI110, EMOJI111, EMOJI112, EMOJI113, EMOJI114, EMOJI115, EMOJI116, EMOJI117, EMOJI118, EMOJI119, EMOJI120, EMOJI121, EMOJI122, EMOJI123, EMOJI124, EMOJI125, EMOJI126, EMOJI127, EMOJI128, EMOJI129, EMOJI130, EMOJI131, EMOJI132, EMOJI133, EMOJI134, EMOJI135, EMOJI136, EMOJI137, EMOJI138, EMOJI139, EMOJI140, EMOJI141, EMOJI142, EMOJI143, EMOJI144, EMOJI145, EMOJI146, EMOJI147, EMOJI148, EMOJI149, EMOJI150, EMOJI151, EMOJI152, EMOJI153, EMOJI154, EMOJI155, EMOJI156, EMOJI157, EMOJI158, EMOJI159, EMOJI160, EMOJI161, EMOJI162, EMOJI163, EMOJI164, EMOJI165, EMOJI166, EMOJI167, EMOJI168, EMOJI169, EMOJI170, EMOJI171};
    }

    public static EnumEntries<EmojiSymbols> getEntries() {
        return $ENTRIES;
    }

    public static EmojiSymbols valueOf(String str) {
        return (EmojiSymbols) Enum.valueOf(EmojiSymbols.class, str);
    }

    public static EmojiSymbols[] values() {
        return (EmojiSymbols[]) $VALUES.clone();
    }

    private EmojiSymbols(String str, int i, String str2) {
        this.regex = str2;
    }

    public final String getRegex() {
        return this.regex;
    }

    static {
        EmojiSymbols[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }
}
