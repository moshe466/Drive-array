package com.samsung.sr.nmt.t2t.translator.core.pipeline.engine.spec;

import androidx.constraintlayout.widget.ConstraintLayout;
import com.fasterxml.jackson.annotation.JsonProperty;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: EngineSpec.kt */
@Metadata(d1 = {"\u00003\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0003\b\u008a\u0001\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0080\b\u0018\u0000 §\u00012\u00020\u0001:\u0002§\u0001B¡\u0003\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\u0003\u0012\u0006\u0010\r\u001a\u00020\u000b\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u000b\u0012\u0006\u0010\u000f\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0015\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0018\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0018\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u0018\u0012\b\b\u0002\u0010\u001c\u001a\u00020\u0018\u0012\b\b\u0002\u0010\u001d\u001a\u00020\u0018\u0012\b\b\u0002\u0010\u001e\u001a\u00020\u0018\u0012\b\b\u0002\u0010\u001f\u001a\u00020\u000b\u0012\b\b\u0002\u0010 \u001a\u00020\u0003\u0012\b\b\u0002\u0010!\u001a\u00020\u0018\u0012\b\b\u0002\u0010\"\u001a\u00020\u000b\u0012\b\b\u0002\u0010#\u001a\u00020\u0003\u0012\b\b\u0002\u0010$\u001a\u00020\u0018\u0012\b\b\u0002\u0010%\u001a\u00020\u000b\u0012\b\b\u0002\u0010&\u001a\u00020\u000b\u0012\b\b\u0002\u0010'\u001a\u00020\u0018\u0012\b\b\u0002\u0010(\u001a\u00020\u0003\u0012\b\b\u0002\u0010)\u001a\u00020\u0003\u0012\b\b\u0002\u0010*\u001a\u00020\u0003\u0012\b\b\u0002\u0010+\u001a\u00020\u0003\u0012\b\b\u0002\u0010,\u001a\u00020\u0018\u0012\b\b\u0002\u0010-\u001a\u00020\u000b\u0012\b\b\u0002\u0010.\u001a\u00020\u0003\u0012\b\b\u0002\u0010/\u001a\u00020\u0018\u0012\b\b\u0002\u00100\u001a\u00020\u000b¢\u0006\u0002\u00101J\t\u0010t\u001a\u00020\u0003HÆ\u0003J\t\u0010u\u001a\u00020\u000bHÆ\u0003J\t\u0010v\u001a\u00020\u000bHÆ\u0003J\t\u0010w\u001a\u00020\u0003HÆ\u0003J\t\u0010x\u001a\u00020\u0003HÆ\u0003J\t\u0010y\u001a\u00020\u0003HÆ\u0003J\t\u0010z\u001a\u00020\u0003HÆ\u0003J\t\u0010{\u001a\u00020\u0003HÆ\u0003J\t\u0010|\u001a\u00020\u0015HÆ\u0003J\t\u0010}\u001a\u00020\u0003HÆ\u0003J\t\u0010~\u001a\u00020\u0018HÆ\u0003J\t\u0010\u007f\u001a\u00020\u0003HÆ\u0003J\n\u0010\u0080\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010\u0081\u0001\u001a\u00020\u0018HÆ\u0003J\n\u0010\u0082\u0001\u001a\u00020\u0018HÆ\u0003J\n\u0010\u0083\u0001\u001a\u00020\u0018HÆ\u0003J\n\u0010\u0084\u0001\u001a\u00020\u0018HÆ\u0003J\n\u0010\u0085\u0001\u001a\u00020\u0018HÆ\u0003J\n\u0010\u0086\u0001\u001a\u00020\u000bHÆ\u0003J\n\u0010\u0087\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010\u0088\u0001\u001a\u00020\u0018HÆ\u0003J\n\u0010\u0089\u0001\u001a\u00020\u000bHÆ\u0003J\n\u0010\u008a\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010\u008b\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010\u008c\u0001\u001a\u00020\u0018HÆ\u0003J\n\u0010\u008d\u0001\u001a\u00020\u000bHÆ\u0003J\n\u0010\u008e\u0001\u001a\u00020\u000bHÆ\u0003J\n\u0010\u008f\u0001\u001a\u00020\u0018HÆ\u0003J\n\u0010\u0090\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010\u0091\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010\u0092\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010\u0093\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010\u0094\u0001\u001a\u00020\u0018HÆ\u0003J\n\u0010\u0095\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010\u0096\u0001\u001a\u00020\u000bHÆ\u0003J\n\u0010\u0097\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010\u0098\u0001\u001a\u00020\u0018HÆ\u0003J\n\u0010\u0099\u0001\u001a\u00020\u000bHÆ\u0003J\n\u0010\u009a\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010\u009b\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010\u009c\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010\u009d\u0001\u001a\u00020\u000bHÆ\u0003J\n\u0010\u009e\u0001\u001a\u00020\u0003HÆ\u0003J¸\u0003\u0010\u009f\u0001\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u000b2\b\b\u0002\u0010\u000e\u001a\u00020\u000b2\b\b\u0002\u0010\u000f\u001a\u00020\u00032\b\b\u0002\u0010\u0010\u001a\u00020\u00032\b\b\u0002\u0010\u0011\u001a\u00020\u00032\b\b\u0002\u0010\u0012\u001a\u00020\u00032\b\b\u0002\u0010\u0013\u001a\u00020\u00032\b\b\u0002\u0010\u0014\u001a\u00020\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u00032\b\b\u0002\u0010\u0017\u001a\u00020\u00182\b\b\u0002\u0010\u0019\u001a\u00020\u00032\b\b\u0002\u0010\u001a\u001a\u00020\u00182\b\b\u0002\u0010\u001b\u001a\u00020\u00182\b\b\u0002\u0010\u001c\u001a\u00020\u00182\b\b\u0002\u0010\u001d\u001a\u00020\u00182\b\b\u0002\u0010\u001e\u001a\u00020\u00182\b\b\u0002\u0010\u001f\u001a\u00020\u000b2\b\b\u0002\u0010 \u001a\u00020\u00032\b\b\u0002\u0010!\u001a\u00020\u00182\b\b\u0002\u0010\"\u001a\u00020\u000b2\b\b\u0002\u0010#\u001a\u00020\u00032\b\b\u0002\u0010$\u001a\u00020\u00182\b\b\u0002\u0010%\u001a\u00020\u000b2\b\b\u0002\u0010&\u001a\u00020\u000b2\b\b\u0002\u0010'\u001a\u00020\u00182\b\b\u0002\u0010(\u001a\u00020\u00032\b\b\u0002\u0010)\u001a\u00020\u00032\b\b\u0002\u0010*\u001a\u00020\u00032\b\b\u0002\u0010+\u001a\u00020\u00032\b\b\u0002\u0010,\u001a\u00020\u00182\b\b\u0002\u0010-\u001a\u00020\u000b2\b\b\u0002\u0010.\u001a\u00020\u00032\b\b\u0002\u0010/\u001a\u00020\u00182\b\b\u0002\u00100\u001a\u00020\u000bHÆ\u0001J\u0015\u0010 \u0001\u001a\u00020\u000b2\t\u0010¡\u0001\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\n\u0010¢\u0001\u001a\u00030£\u0001H\u0002J\n\u0010¤\u0001\u001a\u00020\u0018HÖ\u0001J\n\u0010¥\u0001\u001a\u00030£\u0001H\u0002J\n\u0010¦\u0001\u001a\u00020\u0003HÖ\u0001R\u0011\u0010'\u001a\u00020\u0018¢\u0006\b\n\u0000\u001a\u0004\b2\u00103R\u001a\u0010\u0017\u001a\u00020\u0018X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u00103\"\u0004\b5\u00106R\u001a\u0010\u0019\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u00108\"\u0004\b9\u0010:R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b;\u00108R\u0011\u0010\u001e\u001a\u00020\u0018¢\u0006\b\n\u0000\u001a\u0004\b<\u00103R\u0011\u0010,\u001a\u00020\u0018¢\u0006\b\n\u0000\u001a\u0004\b=\u00103R\u0011\u0010)\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b>\u00108R\u0011\u0010(\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b?\u00108R\u0011\u0010/\u001a\u00020\u0018¢\u0006\b\n\u0000\u001a\u0004\b@\u00103R\u0011\u0010.\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\bA\u00108R\u0011\u00100\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\bB\u0010CR\u0011\u0010-\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\bD\u0010CR\u0011\u0010+\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\bE\u00108R\u0011\u0010*\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\bF\u00108R\u001a\u0010\b\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bG\u00108\"\u0004\bH\u0010:R\u0011\u0010 \u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\bI\u00108R\u0011\u0010!\u001a\u00020\u0018¢\u0006\b\n\u0000\u001a\u0004\bJ\u00103R\u0011\u0010\u0014\u001a\u00020\u0015¢\u0006\b\n\u0000\u001a\u0004\bK\u0010LR\u0011\u0010\u000e\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010CR\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\bM\u0010CR\u0011\u0010\u001b\u001a\u00020\u0018¢\u0006\b\n\u0000\u001a\u0004\bN\u00103R\u0011\u0010\u001c\u001a\u00020\u0018¢\u0006\b\n\u0000\u001a\u0004\bO\u00103R\u001a\u0010\u0007\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bP\u00108\"\u0004\bQ\u0010:R\u001a\u0010\t\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bR\u00108\"\u0004\bS\u0010:R\u0011\u0010&\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\bT\u0010CR\u001a\u0010$\u001a\u00020\u0018X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bU\u00103\"\u0004\bV\u00106R\u0011\u0010\u001d\u001a\u00020\u0018¢\u0006\b\n\u0000\u001a\u0004\bW\u00103R\u001a\u0010#\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bX\u00108\"\u0004\bY\u0010:R\u001a\u0010%\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bZ\u0010C\"\u0004\b[\u0010\\R\u0011\u0010\u001f\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b]\u0010CR\u001a\u0010\"\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b^\u0010C\"\u0004\b_\u0010\\R\u001a\u0010\u0010\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b`\u00108\"\u0004\ba\u0010:R\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bb\u00108\"\u0004\bc\u0010:R\u001a\u0010\u000f\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bd\u00108\"\u0004\be\u0010:R\u0011\u0010\u001a\u001a\u00020\u0018¢\u0006\b\n\u0000\u001a\u0004\bf\u00103R\u001a\u0010\u0012\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bg\u00108\"\u0004\bh\u0010:R\u001a\u0010\u0005\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bi\u00108\"\u0004\bj\u0010:R\u001a\u0010\u0011\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bk\u00108\"\u0004\bl\u0010:R\u0011\u0010\u0016\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\bm\u00108R\u001a\u0010\r\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bn\u0010C\"\u0004\bo\u0010\\R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\bp\u00108R\u0011\u0010\u0013\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\bq\u00108R\u001a\u0010\f\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\br\u00108\"\u0004\bs\u0010:¨\u0006¨\u0001"}, d2 = {"Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/engine/spec/EngineSpec;", JsonProperty.USE_DEFAULT_NAME, "version", JsonProperty.USE_DEFAULT_NAME, "sourceLanguage", "targetLanguage", "engineType", "modelPath", "hParamsPath", "modelType", "lowerCase", JsonProperty.USE_DEFAULT_NAME, "vocabType", "useUnionVocab", "isIndian", "sourceVocabPath", "sourceAlphabetPath", "targetVocabPath", "targetAlphabetPath", "vocabLanguageIdPath", "invalidLanguageIdRejectionRatioThreshold", JsonProperty.USE_DEFAULT_NAME, "translationMemoryPath", "dirTokId", JsonProperty.USE_DEFAULT_NAME, "dirTokStr", "spaceTokId", "maxInputLength", "maxOutputLength", "padId", "eosId", "processHonorificTag", "honorificTok", "honorificTokId", "processPlh", "plhTok", "numPlhTok", "preventPlhTokenSplits", "needCompatibilityProcess", "compatibilityProcessLevel", "fairseqModelPath", "fairseqHParamsPath", "fairseqVocabPath", "fairseqSourceAlphabetPath", "fairseqDirTokId", "fairseqProcessPlh", "fairseqPlhTok", "fairseqNumPlhTok", "fairseqPreventPlhTokenSplits", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;ZZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;FLjava/lang/String;ILjava/lang/String;IIIIIZLjava/lang/String;IZLjava/lang/String;IZZILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IZLjava/lang/String;IZ)V", "getCompatibilityProcessLevel", "()I", "getDirTokId", "setDirTokId", "(I)V", "getDirTokStr", "()Ljava/lang/String;", "setDirTokStr", "(Ljava/lang/String;)V", "getEngineType", "getEosId", "getFairseqDirTokId", "getFairseqHParamsPath", "getFairseqModelPath", "getFairseqNumPlhTok", "getFairseqPlhTok", "getFairseqPreventPlhTokenSplits", "()Z", "getFairseqProcessPlh", "getFairseqSourceAlphabetPath", "getFairseqVocabPath", "getHParamsPath", "setHParamsPath", "getHonorificTok", "getHonorificTokId", "getInvalidLanguageIdRejectionRatioThreshold", "()F", "getLowerCase", "getMaxInputLength", "getMaxOutputLength", "getModelPath", "setModelPath", "getModelType", "setModelType", "getNeedCompatibilityProcess", "getNumPlhTok", "setNumPlhTok", "getPadId", "getPlhTok", "setPlhTok", "getPreventPlhTokenSplits", "setPreventPlhTokenSplits", "(Z)V", "getProcessHonorificTag", "getProcessPlh", "setProcessPlh", "getSourceAlphabetPath", "setSourceAlphabetPath", "getSourceLanguage", "setSourceLanguage", "getSourceVocabPath", "setSourceVocabPath", "getSpaceTokId", "getTargetAlphabetPath", "setTargetAlphabetPath", "getTargetLanguage", "setTargetLanguage", "getTargetVocabPath", "setTargetVocabPath", "getTranslationMemoryPath", "getUseUnionVocab", "setUseUnionVocab", "getVersion", "getVocabLanguageIdPath", "getVocabType", "setVocabType", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component20", "component21", "component22", "component23", "component24", "component25", "component26", "component27", "component28", "component29", "component3", "component30", "component31", "component32", "component33", "component34", "component35", "component36", "component37", "component38", "component39", "component4", "component40", "component41", "component42", "component43", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "fairseqCompatibility", JsonProperty.USE_DEFAULT_NAME, "hashCode", "placeholderFairseqCompatibility", "toString", "Companion", "translator-core"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final /* data */ class EngineSpec {
    private static final int HIGH = 1;
    private final int compatibilityProcessLevel;
    private int dirTokId;
    private String dirTokStr;
    private final String engineType;
    private final int eosId;
    private final int fairseqDirTokId;
    private final String fairseqHParamsPath;
    private final String fairseqModelPath;
    private final int fairseqNumPlhTok;
    private final String fairseqPlhTok;
    private final boolean fairseqPreventPlhTokenSplits;
    private final boolean fairseqProcessPlh;
    private final String fairseqSourceAlphabetPath;
    private final String fairseqVocabPath;
    private String hParamsPath;
    private final String honorificTok;
    private final int honorificTokId;
    private final float invalidLanguageIdRejectionRatioThreshold;
    private final boolean isIndian;
    private final boolean lowerCase;
    private final int maxInputLength;
    private final int maxOutputLength;
    private String modelPath;
    private String modelType;
    private final boolean needCompatibilityProcess;
    private int numPlhTok;
    private final int padId;
    private String plhTok;
    private boolean preventPlhTokenSplits;
    private final boolean processHonorificTag;
    private boolean processPlh;
    private String sourceAlphabetPath;
    private String sourceLanguage;
    private String sourceVocabPath;
    private final int spaceTokId;
    private String targetAlphabetPath;
    private String targetLanguage;
    private String targetVocabPath;
    private final String translationMemoryPath;
    private boolean useUnionVocab;
    private final String version;
    private final String vocabLanguageIdPath;
    private String vocabType;

    /* renamed from: component1, reason: from getter */
    public final String getVersion() {
        return this.version;
    }

    /* renamed from: component10, reason: from getter */
    public final boolean getUseUnionVocab() {
        return this.useUnionVocab;
    }

    /* renamed from: component11, reason: from getter */
    public final boolean getIsIndian() {
        return this.isIndian;
    }

    /* renamed from: component12, reason: from getter */
    public final String getSourceVocabPath() {
        return this.sourceVocabPath;
    }

    /* renamed from: component13, reason: from getter */
    public final String getSourceAlphabetPath() {
        return this.sourceAlphabetPath;
    }

    /* renamed from: component14, reason: from getter */
    public final String getTargetVocabPath() {
        return this.targetVocabPath;
    }

    /* renamed from: component15, reason: from getter */
    public final String getTargetAlphabetPath() {
        return this.targetAlphabetPath;
    }

    /* renamed from: component16, reason: from getter */
    public final String getVocabLanguageIdPath() {
        return this.vocabLanguageIdPath;
    }

    /* renamed from: component17, reason: from getter */
    public final float getInvalidLanguageIdRejectionRatioThreshold() {
        return this.invalidLanguageIdRejectionRatioThreshold;
    }

    /* renamed from: component18, reason: from getter */
    public final String getTranslationMemoryPath() {
        return this.translationMemoryPath;
    }

    /* renamed from: component19, reason: from getter */
    public final int getDirTokId() {
        return this.dirTokId;
    }

    /* renamed from: component2, reason: from getter */
    public final String getSourceLanguage() {
        return this.sourceLanguage;
    }

    /* renamed from: component20, reason: from getter */
    public final String getDirTokStr() {
        return this.dirTokStr;
    }

    /* renamed from: component21, reason: from getter */
    public final int getSpaceTokId() {
        return this.spaceTokId;
    }

    /* renamed from: component22, reason: from getter */
    public final int getMaxInputLength() {
        return this.maxInputLength;
    }

    /* renamed from: component23, reason: from getter */
    public final int getMaxOutputLength() {
        return this.maxOutputLength;
    }

    /* renamed from: component24, reason: from getter */
    public final int getPadId() {
        return this.padId;
    }

    /* renamed from: component25, reason: from getter */
    public final int getEosId() {
        return this.eosId;
    }

    /* renamed from: component26, reason: from getter */
    public final boolean getProcessHonorificTag() {
        return this.processHonorificTag;
    }

    /* renamed from: component27, reason: from getter */
    public final String getHonorificTok() {
        return this.honorificTok;
    }

    /* renamed from: component28, reason: from getter */
    public final int getHonorificTokId() {
        return this.honorificTokId;
    }

    /* renamed from: component29, reason: from getter */
    public final boolean getProcessPlh() {
        return this.processPlh;
    }

    /* renamed from: component3, reason: from getter */
    public final String getTargetLanguage() {
        return this.targetLanguage;
    }

    /* renamed from: component30, reason: from getter */
    public final String getPlhTok() {
        return this.plhTok;
    }

    /* renamed from: component31, reason: from getter */
    public final int getNumPlhTok() {
        return this.numPlhTok;
    }

    /* renamed from: component32, reason: from getter */
    public final boolean getPreventPlhTokenSplits() {
        return this.preventPlhTokenSplits;
    }

    /* renamed from: component33, reason: from getter */
    public final boolean getNeedCompatibilityProcess() {
        return this.needCompatibilityProcess;
    }

    /* renamed from: component34, reason: from getter */
    public final int getCompatibilityProcessLevel() {
        return this.compatibilityProcessLevel;
    }

    /* renamed from: component35, reason: from getter */
    public final String getFairseqModelPath() {
        return this.fairseqModelPath;
    }

    /* renamed from: component36, reason: from getter */
    public final String getFairseqHParamsPath() {
        return this.fairseqHParamsPath;
    }

    /* renamed from: component37, reason: from getter */
    public final String getFairseqVocabPath() {
        return this.fairseqVocabPath;
    }

    /* renamed from: component38, reason: from getter */
    public final String getFairseqSourceAlphabetPath() {
        return this.fairseqSourceAlphabetPath;
    }

    /* renamed from: component39, reason: from getter */
    public final int getFairseqDirTokId() {
        return this.fairseqDirTokId;
    }

    /* renamed from: component4, reason: from getter */
    public final String getEngineType() {
        return this.engineType;
    }

    /* renamed from: component40, reason: from getter */
    public final boolean getFairseqProcessPlh() {
        return this.fairseqProcessPlh;
    }

    /* renamed from: component41, reason: from getter */
    public final String getFairseqPlhTok() {
        return this.fairseqPlhTok;
    }

    /* renamed from: component42, reason: from getter */
    public final int getFairseqNumPlhTok() {
        return this.fairseqNumPlhTok;
    }

    /* renamed from: component43, reason: from getter */
    public final boolean getFairseqPreventPlhTokenSplits() {
        return this.fairseqPreventPlhTokenSplits;
    }

    /* renamed from: component5, reason: from getter */
    public final String getModelPath() {
        return this.modelPath;
    }

    /* renamed from: component6, reason: from getter */
    public final String getHParamsPath() {
        return this.hParamsPath;
    }

    /* renamed from: component7, reason: from getter */
    public final String getModelType() {
        return this.modelType;
    }

    /* renamed from: component8, reason: from getter */
    public final boolean getLowerCase() {
        return this.lowerCase;
    }

    /* renamed from: component9, reason: from getter */
    public final String getVocabType() {
        return this.vocabType;
    }

    public final EngineSpec copy(String version, String sourceLanguage, String targetLanguage, String engineType, String modelPath, String hParamsPath, String modelType, boolean lowerCase, String vocabType, boolean useUnionVocab, boolean isIndian, String sourceVocabPath, String sourceAlphabetPath, String targetVocabPath, String targetAlphabetPath, String vocabLanguageIdPath, float invalidLanguageIdRejectionRatioThreshold, String translationMemoryPath, int dirTokId, String dirTokStr, int spaceTokId, int maxInputLength, int maxOutputLength, int padId, int eosId, boolean processHonorificTag, String honorificTok, int honorificTokId, boolean processPlh, String plhTok, int numPlhTok, boolean preventPlhTokenSplits, boolean needCompatibilityProcess, int compatibilityProcessLevel, String fairseqModelPath, String fairseqHParamsPath, String fairseqVocabPath, String fairseqSourceAlphabetPath, int fairseqDirTokId, boolean fairseqProcessPlh, String fairseqPlhTok, int fairseqNumPlhTok, boolean fairseqPreventPlhTokenSplits) {
        Intrinsics.checkNotNullParameter(version, "version");
        Intrinsics.checkNotNullParameter(sourceLanguage, "sourceLanguage");
        Intrinsics.checkNotNullParameter(targetLanguage, "targetLanguage");
        Intrinsics.checkNotNullParameter(engineType, "engineType");
        Intrinsics.checkNotNullParameter(modelPath, "modelPath");
        Intrinsics.checkNotNullParameter(hParamsPath, "hParamsPath");
        Intrinsics.checkNotNullParameter(modelType, "modelType");
        Intrinsics.checkNotNullParameter(vocabType, "vocabType");
        Intrinsics.checkNotNullParameter(sourceVocabPath, "sourceVocabPath");
        Intrinsics.checkNotNullParameter(sourceAlphabetPath, "sourceAlphabetPath");
        Intrinsics.checkNotNullParameter(targetVocabPath, "targetVocabPath");
        Intrinsics.checkNotNullParameter(targetAlphabetPath, "targetAlphabetPath");
        Intrinsics.checkNotNullParameter(vocabLanguageIdPath, "vocabLanguageIdPath");
        Intrinsics.checkNotNullParameter(translationMemoryPath, "translationMemoryPath");
        Intrinsics.checkNotNullParameter(dirTokStr, "dirTokStr");
        Intrinsics.checkNotNullParameter(honorificTok, "honorificTok");
        Intrinsics.checkNotNullParameter(plhTok, "plhTok");
        Intrinsics.checkNotNullParameter(fairseqModelPath, "fairseqModelPath");
        Intrinsics.checkNotNullParameter(fairseqHParamsPath, "fairseqHParamsPath");
        Intrinsics.checkNotNullParameter(fairseqVocabPath, "fairseqVocabPath");
        Intrinsics.checkNotNullParameter(fairseqSourceAlphabetPath, "fairseqSourceAlphabetPath");
        Intrinsics.checkNotNullParameter(fairseqPlhTok, "fairseqPlhTok");
        return new EngineSpec(version, sourceLanguage, targetLanguage, engineType, modelPath, hParamsPath, modelType, lowerCase, vocabType, useUnionVocab, isIndian, sourceVocabPath, sourceAlphabetPath, targetVocabPath, targetAlphabetPath, vocabLanguageIdPath, invalidLanguageIdRejectionRatioThreshold, translationMemoryPath, dirTokId, dirTokStr, spaceTokId, maxInputLength, maxOutputLength, padId, eosId, processHonorificTag, honorificTok, honorificTokId, processPlh, plhTok, numPlhTok, preventPlhTokenSplits, needCompatibilityProcess, compatibilityProcessLevel, fairseqModelPath, fairseqHParamsPath, fairseqVocabPath, fairseqSourceAlphabetPath, fairseqDirTokId, fairseqProcessPlh, fairseqPlhTok, fairseqNumPlhTok, fairseqPreventPlhTokenSplits);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof EngineSpec)) {
            return false;
        }
        EngineSpec engineSpec = (EngineSpec) other;
        return Intrinsics.areEqual(this.version, engineSpec.version) && Intrinsics.areEqual(this.sourceLanguage, engineSpec.sourceLanguage) && Intrinsics.areEqual(this.targetLanguage, engineSpec.targetLanguage) && Intrinsics.areEqual(this.engineType, engineSpec.engineType) && Intrinsics.areEqual(this.modelPath, engineSpec.modelPath) && Intrinsics.areEqual(this.hParamsPath, engineSpec.hParamsPath) && Intrinsics.areEqual(this.modelType, engineSpec.modelType) && this.lowerCase == engineSpec.lowerCase && Intrinsics.areEqual(this.vocabType, engineSpec.vocabType) && this.useUnionVocab == engineSpec.useUnionVocab && this.isIndian == engineSpec.isIndian && Intrinsics.areEqual(this.sourceVocabPath, engineSpec.sourceVocabPath) && Intrinsics.areEqual(this.sourceAlphabetPath, engineSpec.sourceAlphabetPath) && Intrinsics.areEqual(this.targetVocabPath, engineSpec.targetVocabPath) && Intrinsics.areEqual(this.targetAlphabetPath, engineSpec.targetAlphabetPath) && Intrinsics.areEqual(this.vocabLanguageIdPath, engineSpec.vocabLanguageIdPath) && Float.compare(this.invalidLanguageIdRejectionRatioThreshold, engineSpec.invalidLanguageIdRejectionRatioThreshold) == 0 && Intrinsics.areEqual(this.translationMemoryPath, engineSpec.translationMemoryPath) && this.dirTokId == engineSpec.dirTokId && Intrinsics.areEqual(this.dirTokStr, engineSpec.dirTokStr) && this.spaceTokId == engineSpec.spaceTokId && this.maxInputLength == engineSpec.maxInputLength && this.maxOutputLength == engineSpec.maxOutputLength && this.padId == engineSpec.padId && this.eosId == engineSpec.eosId && this.processHonorificTag == engineSpec.processHonorificTag && Intrinsics.areEqual(this.honorificTok, engineSpec.honorificTok) && this.honorificTokId == engineSpec.honorificTokId && this.processPlh == engineSpec.processPlh && Intrinsics.areEqual(this.plhTok, engineSpec.plhTok) && this.numPlhTok == engineSpec.numPlhTok && this.preventPlhTokenSplits == engineSpec.preventPlhTokenSplits && this.needCompatibilityProcess == engineSpec.needCompatibilityProcess && this.compatibilityProcessLevel == engineSpec.compatibilityProcessLevel && Intrinsics.areEqual(this.fairseqModelPath, engineSpec.fairseqModelPath) && Intrinsics.areEqual(this.fairseqHParamsPath, engineSpec.fairseqHParamsPath) && Intrinsics.areEqual(this.fairseqVocabPath, engineSpec.fairseqVocabPath) && Intrinsics.areEqual(this.fairseqSourceAlphabetPath, engineSpec.fairseqSourceAlphabetPath) && this.fairseqDirTokId == engineSpec.fairseqDirTokId && this.fairseqProcessPlh == engineSpec.fairseqProcessPlh && Intrinsics.areEqual(this.fairseqPlhTok, engineSpec.fairseqPlhTok) && this.fairseqNumPlhTok == engineSpec.fairseqNumPlhTok && this.fairseqPreventPlhTokenSplits == engineSpec.fairseqPreventPlhTokenSplits;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = ((((((((((((this.version.hashCode() * 31) + this.sourceLanguage.hashCode()) * 31) + this.targetLanguage.hashCode()) * 31) + this.engineType.hashCode()) * 31) + this.modelPath.hashCode()) * 31) + this.hParamsPath.hashCode()) * 31) + this.modelType.hashCode()) * 31;
        boolean z = this.lowerCase;
        int i = z;
        if (z != 0) {
            i = 1;
        }
        int hashCode2 = (((hashCode + i) * 31) + this.vocabType.hashCode()) * 31;
        boolean z2 = this.useUnionVocab;
        int i2 = z2;
        if (z2 != 0) {
            i2 = 1;
        }
        int i3 = (hashCode2 + i2) * 31;
        boolean z3 = this.isIndian;
        int i4 = z3;
        if (z3 != 0) {
            i4 = 1;
        }
        int hashCode3 = (((((((((((((((((((((((((((((i3 + i4) * 31) + this.sourceVocabPath.hashCode()) * 31) + this.sourceAlphabetPath.hashCode()) * 31) + this.targetVocabPath.hashCode()) * 31) + this.targetAlphabetPath.hashCode()) * 31) + this.vocabLanguageIdPath.hashCode()) * 31) + Float.hashCode(this.invalidLanguageIdRejectionRatioThreshold)) * 31) + this.translationMemoryPath.hashCode()) * 31) + Integer.hashCode(this.dirTokId)) * 31) + this.dirTokStr.hashCode()) * 31) + Integer.hashCode(this.spaceTokId)) * 31) + Integer.hashCode(this.maxInputLength)) * 31) + Integer.hashCode(this.maxOutputLength)) * 31) + Integer.hashCode(this.padId)) * 31) + Integer.hashCode(this.eosId)) * 31;
        boolean z4 = this.processHonorificTag;
        int i5 = z4;
        if (z4 != 0) {
            i5 = 1;
        }
        int hashCode4 = (((((hashCode3 + i5) * 31) + this.honorificTok.hashCode()) * 31) + Integer.hashCode(this.honorificTokId)) * 31;
        boolean z5 = this.processPlh;
        int i6 = z5;
        if (z5 != 0) {
            i6 = 1;
        }
        int hashCode5 = (((((hashCode4 + i6) * 31) + this.plhTok.hashCode()) * 31) + Integer.hashCode(this.numPlhTok)) * 31;
        boolean z6 = this.preventPlhTokenSplits;
        int i7 = z6;
        if (z6 != 0) {
            i7 = 1;
        }
        int i8 = (hashCode5 + i7) * 31;
        boolean z7 = this.needCompatibilityProcess;
        int i9 = z7;
        if (z7 != 0) {
            i9 = 1;
        }
        int hashCode6 = (((((((((((((i8 + i9) * 31) + Integer.hashCode(this.compatibilityProcessLevel)) * 31) + this.fairseqModelPath.hashCode()) * 31) + this.fairseqHParamsPath.hashCode()) * 31) + this.fairseqVocabPath.hashCode()) * 31) + this.fairseqSourceAlphabetPath.hashCode()) * 31) + Integer.hashCode(this.fairseqDirTokId)) * 31;
        boolean z8 = this.fairseqProcessPlh;
        int i10 = z8;
        if (z8 != 0) {
            i10 = 1;
        }
        int hashCode7 = (((((hashCode6 + i10) * 31) + this.fairseqPlhTok.hashCode()) * 31) + Integer.hashCode(this.fairseqNumPlhTok)) * 31;
        boolean z9 = this.fairseqPreventPlhTokenSplits;
        return hashCode7 + (z9 ? 1 : z9 ? 1 : 0);
    }

    public String toString() {
        return "EngineSpec(version=" + this.version + ", sourceLanguage=" + this.sourceLanguage + ", targetLanguage=" + this.targetLanguage + ", engineType=" + this.engineType + ", modelPath=" + this.modelPath + ", hParamsPath=" + this.hParamsPath + ", modelType=" + this.modelType + ", lowerCase=" + this.lowerCase + ", vocabType=" + this.vocabType + ", useUnionVocab=" + this.useUnionVocab + ", isIndian=" + this.isIndian + ", sourceVocabPath=" + this.sourceVocabPath + ", sourceAlphabetPath=" + this.sourceAlphabetPath + ", targetVocabPath=" + this.targetVocabPath + ", targetAlphabetPath=" + this.targetAlphabetPath + ", vocabLanguageIdPath=" + this.vocabLanguageIdPath + ", invalidLanguageIdRejectionRatioThreshold=" + this.invalidLanguageIdRejectionRatioThreshold + ", translationMemoryPath=" + this.translationMemoryPath + ", dirTokId=" + this.dirTokId + ", dirTokStr=" + this.dirTokStr + ", spaceTokId=" + this.spaceTokId + ", maxInputLength=" + this.maxInputLength + ", maxOutputLength=" + this.maxOutputLength + ", padId=" + this.padId + ", eosId=" + this.eosId + ", processHonorificTag=" + this.processHonorificTag + ", honorificTok=" + this.honorificTok + ", honorificTokId=" + this.honorificTokId + ", processPlh=" + this.processPlh + ", plhTok=" + this.plhTok + ", numPlhTok=" + this.numPlhTok + ", preventPlhTokenSplits=" + this.preventPlhTokenSplits + ", needCompatibilityProcess=" + this.needCompatibilityProcess + ", compatibilityProcessLevel=" + this.compatibilityProcessLevel + ", fairseqModelPath=" + this.fairseqModelPath + ", fairseqHParamsPath=" + this.fairseqHParamsPath + ", fairseqVocabPath=" + this.fairseqVocabPath + ", fairseqSourceAlphabetPath=" + this.fairseqSourceAlphabetPath + ", fairseqDirTokId=" + this.fairseqDirTokId + ", fairseqProcessPlh=" + this.fairseqProcessPlh + ", fairseqPlhTok=" + this.fairseqPlhTok + ", fairseqNumPlhTok=" + this.fairseqNumPlhTok + ", fairseqPreventPlhTokenSplits=" + this.fairseqPreventPlhTokenSplits + ")";
    }

    public EngineSpec(String version, String sourceLanguage, String targetLanguage, String engineType, String modelPath, String hParamsPath, String modelType, boolean z, String vocabType, boolean z2, boolean z3, String sourceVocabPath, String sourceAlphabetPath, String targetVocabPath, String targetAlphabetPath, String vocabLanguageIdPath, float f, String translationMemoryPath, int i, String dirTokStr, int i2, int i3, int i4, int i5, int i6, boolean z4, String honorificTok, int i7, boolean z5, String plhTok, int i8, boolean z6, boolean z7, int i9, String fairseqModelPath, String fairseqHParamsPath, String fairseqVocabPath, String fairseqSourceAlphabetPath, int i10, boolean z8, String fairseqPlhTok, int i11, boolean z9) {
        Intrinsics.checkNotNullParameter(version, "version");
        Intrinsics.checkNotNullParameter(sourceLanguage, "sourceLanguage");
        Intrinsics.checkNotNullParameter(targetLanguage, "targetLanguage");
        Intrinsics.checkNotNullParameter(engineType, "engineType");
        Intrinsics.checkNotNullParameter(modelPath, "modelPath");
        Intrinsics.checkNotNullParameter(hParamsPath, "hParamsPath");
        Intrinsics.checkNotNullParameter(modelType, "modelType");
        Intrinsics.checkNotNullParameter(vocabType, "vocabType");
        Intrinsics.checkNotNullParameter(sourceVocabPath, "sourceVocabPath");
        Intrinsics.checkNotNullParameter(sourceAlphabetPath, "sourceAlphabetPath");
        Intrinsics.checkNotNullParameter(targetVocabPath, "targetVocabPath");
        Intrinsics.checkNotNullParameter(targetAlphabetPath, "targetAlphabetPath");
        Intrinsics.checkNotNullParameter(vocabLanguageIdPath, "vocabLanguageIdPath");
        Intrinsics.checkNotNullParameter(translationMemoryPath, "translationMemoryPath");
        Intrinsics.checkNotNullParameter(dirTokStr, "dirTokStr");
        Intrinsics.checkNotNullParameter(honorificTok, "honorificTok");
        Intrinsics.checkNotNullParameter(plhTok, "plhTok");
        Intrinsics.checkNotNullParameter(fairseqModelPath, "fairseqModelPath");
        Intrinsics.checkNotNullParameter(fairseqHParamsPath, "fairseqHParamsPath");
        Intrinsics.checkNotNullParameter(fairseqVocabPath, "fairseqVocabPath");
        Intrinsics.checkNotNullParameter(fairseqSourceAlphabetPath, "fairseqSourceAlphabetPath");
        Intrinsics.checkNotNullParameter(fairseqPlhTok, "fairseqPlhTok");
        this.version = version;
        this.sourceLanguage = sourceLanguage;
        this.targetLanguage = targetLanguage;
        this.engineType = engineType;
        this.modelPath = modelPath;
        this.hParamsPath = hParamsPath;
        this.modelType = modelType;
        this.lowerCase = z;
        this.vocabType = vocabType;
        this.useUnionVocab = z2;
        this.isIndian = z3;
        this.sourceVocabPath = sourceVocabPath;
        this.sourceAlphabetPath = sourceAlphabetPath;
        this.targetVocabPath = targetVocabPath;
        this.targetAlphabetPath = targetAlphabetPath;
        this.vocabLanguageIdPath = vocabLanguageIdPath;
        this.invalidLanguageIdRejectionRatioThreshold = f;
        this.translationMemoryPath = translationMemoryPath;
        this.dirTokId = i;
        this.dirTokStr = dirTokStr;
        this.spaceTokId = i2;
        this.maxInputLength = i3;
        this.maxOutputLength = i4;
        this.padId = i5;
        this.eosId = i6;
        this.processHonorificTag = z4;
        this.honorificTok = honorificTok;
        this.honorificTokId = i7;
        this.processPlh = z5;
        this.plhTok = plhTok;
        this.numPlhTok = i8;
        this.preventPlhTokenSplits = z6;
        this.needCompatibilityProcess = z7;
        this.compatibilityProcessLevel = i9;
        this.fairseqModelPath = fairseqModelPath;
        this.fairseqHParamsPath = fairseqHParamsPath;
        this.fairseqVocabPath = fairseqVocabPath;
        this.fairseqSourceAlphabetPath = fairseqSourceAlphabetPath;
        this.fairseqDirTokId = i10;
        this.fairseqProcessPlh = z8;
        this.fairseqPlhTok = fairseqPlhTok;
        this.fairseqNumPlhTok = i11;
        this.fairseqPreventPlhTokenSplits = z9;
        if (i != -1) {
            this.dirTokStr = JsonProperty.USE_DEFAULT_NAME;
        }
        if (i9 == 1) {
            fairseqCompatibility();
            this.dirTokId = i10;
        } else if (z7) {
            fairseqCompatibility();
        }
        if (this.useUnionVocab) {
            this.targetVocabPath = this.sourceVocabPath;
            this.targetAlphabetPath = this.sourceAlphabetPath;
        }
    }

    public /* synthetic */ EngineSpec(String str, String str2, String str3, String str4, String str5, String str6, String str7, boolean z, String str8, boolean z2, boolean z3, String str9, String str10, String str11, String str12, String str13, float f, String str14, int i, String str15, int i2, int i3, int i4, int i5, int i6, boolean z4, String str16, int i7, boolean z5, String str17, int i8, boolean z6, boolean z7, int i9, String str18, String str19, String str20, String str21, int i10, boolean z8, String str22, int i11, boolean z9, int i12, int i13, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, str3, str4, str5, str6, (i12 & 64) != 0 ? "t2t" : str7, (i12 & 128) != 0 ? false : z, str8, z2, (i12 & 1024) != 0 ? false : z3, str9, (i12 & 4096) != 0 ? JsonProperty.USE_DEFAULT_NAME : str10, (i12 & 8192) != 0 ? JsonProperty.USE_DEFAULT_NAME : str11, (i12 & 16384) != 0 ? JsonProperty.USE_DEFAULT_NAME : str12, (32768 & i12) != 0 ? JsonProperty.USE_DEFAULT_NAME : str13, (65536 & i12) != 0 ? 0.5f : f, (131072 & i12) != 0 ? JsonProperty.USE_DEFAULT_NAME : str14, (262144 & i12) != 0 ? -1 : i, (524288 & i12) != 0 ? JsonProperty.USE_DEFAULT_NAME : str15, (1048576 & i12) != 0 ? 0 : i2, (2097152 & i12) != 0 ? -1 : i3, (4194304 & i12) != 0 ? -1 : i4, (8388608 & i12) != 0 ? 0 : i5, (16777216 & i12) != 0 ? 1 : i6, (33554432 & i12) != 0 ? false : z4, (67108864 & i12) != 0 ? JsonProperty.USE_DEFAULT_NAME : str16, (134217728 & i12) != 0 ? -1 : i7, (268435456 & i12) != 0 ? false : z5, (536870912 & i12) != 0 ? "<PLH?>" : str17, (1073741824 & i12) != 0 ? 16 : i8, (i12 & Integer.MIN_VALUE) != 0 ? false : z6, (i13 & 1) != 0 ? false : z7, (i13 & 2) != 0 ? 0 : i9, (i13 & 4) != 0 ? JsonProperty.USE_DEFAULT_NAME : str18, (i13 & 8) != 0 ? JsonProperty.USE_DEFAULT_NAME : str19, (i13 & 16) != 0 ? JsonProperty.USE_DEFAULT_NAME : str20, (i13 & 32) != 0 ? JsonProperty.USE_DEFAULT_NAME : str21, (i13 & 64) != 0 ? -1 : i10, (i13 & 128) != 0 ? false : z8, (i13 & 256) != 0 ? "<PLH?>" : str22, (i13 & 512) != 0 ? 16 : i11, (i13 & 1024) != 0 ? false : z9);
    }

    public final String getVersion() {
        return this.version;
    }

    public final String getSourceLanguage() {
        return this.sourceLanguage;
    }

    public final void setSourceLanguage(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.sourceLanguage = str;
    }

    public final String getTargetLanguage() {
        return this.targetLanguage;
    }

    public final void setTargetLanguage(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.targetLanguage = str;
    }

    public final String getEngineType() {
        return this.engineType;
    }

    public final String getModelPath() {
        return this.modelPath;
    }

    public final void setModelPath(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.modelPath = str;
    }

    public final String getHParamsPath() {
        return this.hParamsPath;
    }

    public final void setHParamsPath(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.hParamsPath = str;
    }

    public final String getModelType() {
        return this.modelType;
    }

    public final void setModelType(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.modelType = str;
    }

    public final boolean getLowerCase() {
        return this.lowerCase;
    }

    public final String getVocabType() {
        return this.vocabType;
    }

    public final void setVocabType(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.vocabType = str;
    }

    public final boolean getUseUnionVocab() {
        return this.useUnionVocab;
    }

    public final void setUseUnionVocab(boolean z) {
        this.useUnionVocab = z;
    }

    public final boolean isIndian() {
        return this.isIndian;
    }

    public final String getSourceVocabPath() {
        return this.sourceVocabPath;
    }

    public final void setSourceVocabPath(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.sourceVocabPath = str;
    }

    public final String getSourceAlphabetPath() {
        return this.sourceAlphabetPath;
    }

    public final void setSourceAlphabetPath(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.sourceAlphabetPath = str;
    }

    public final String getTargetVocabPath() {
        return this.targetVocabPath;
    }

    public final void setTargetVocabPath(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.targetVocabPath = str;
    }

    public final String getTargetAlphabetPath() {
        return this.targetAlphabetPath;
    }

    public final void setTargetAlphabetPath(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.targetAlphabetPath = str;
    }

    public final String getVocabLanguageIdPath() {
        return this.vocabLanguageIdPath;
    }

    public final float getInvalidLanguageIdRejectionRatioThreshold() {
        return this.invalidLanguageIdRejectionRatioThreshold;
    }

    public final String getTranslationMemoryPath() {
        return this.translationMemoryPath;
    }

    public final int getDirTokId() {
        return this.dirTokId;
    }

    public final void setDirTokId(int i) {
        this.dirTokId = i;
    }

    public final String getDirTokStr() {
        return this.dirTokStr;
    }

    public final void setDirTokStr(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.dirTokStr = str;
    }

    public final int getSpaceTokId() {
        return this.spaceTokId;
    }

    public final int getMaxInputLength() {
        return this.maxInputLength;
    }

    public final int getMaxOutputLength() {
        return this.maxOutputLength;
    }

    public final int getPadId() {
        return this.padId;
    }

    public final int getEosId() {
        return this.eosId;
    }

    public final boolean getProcessHonorificTag() {
        return this.processHonorificTag;
    }

    public final String getHonorificTok() {
        return this.honorificTok;
    }

    public final int getHonorificTokId() {
        return this.honorificTokId;
    }

    public final boolean getProcessPlh() {
        return this.processPlh;
    }

    public final void setProcessPlh(boolean z) {
        this.processPlh = z;
    }

    public final String getPlhTok() {
        return this.plhTok;
    }

    public final void setPlhTok(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.plhTok = str;
    }

    public final int getNumPlhTok() {
        return this.numPlhTok;
    }

    public final void setNumPlhTok(int i) {
        this.numPlhTok = i;
    }

    public final boolean getPreventPlhTokenSplits() {
        return this.preventPlhTokenSplits;
    }

    public final void setPreventPlhTokenSplits(boolean z) {
        this.preventPlhTokenSplits = z;
    }

    public final boolean getNeedCompatibilityProcess() {
        return this.needCompatibilityProcess;
    }

    public final int getCompatibilityProcessLevel() {
        return this.compatibilityProcessLevel;
    }

    public final String getFairseqModelPath() {
        return this.fairseqModelPath;
    }

    public final String getFairseqHParamsPath() {
        return this.fairseqHParamsPath;
    }

    public final String getFairseqVocabPath() {
        return this.fairseqVocabPath;
    }

    public final String getFairseqSourceAlphabetPath() {
        return this.fairseqSourceAlphabetPath;
    }

    public final int getFairseqDirTokId() {
        return this.fairseqDirTokId;
    }

    public final boolean getFairseqProcessPlh() {
        return this.fairseqProcessPlh;
    }

    public final String getFairseqPlhTok() {
        return this.fairseqPlhTok;
    }

    public final int getFairseqNumPlhTok() {
        return this.fairseqNumPlhTok;
    }

    public final boolean getFairseqPreventPlhTokenSplits() {
        return this.fairseqPreventPlhTokenSplits;
    }

    private final void fairseqCompatibility() {
        this.modelPath = this.fairseqModelPath;
        this.hParamsPath = this.fairseqHParamsPath;
        String str = this.fairseqVocabPath;
        this.sourceVocabPath = str;
        this.targetVocabPath = str;
        this.sourceAlphabetPath = this.fairseqSourceAlphabetPath;
        placeholderFairseqCompatibility();
        this.modelType = "fairseq";
        this.vocabType = "sentencepiece";
        this.useUnionVocab = true;
    }

    private final void placeholderFairseqCompatibility() {
        boolean z = this.fairseqProcessPlh;
        if (z) {
            this.processPlh = z;
            this.plhTok = this.fairseqPlhTok;
            this.numPlhTok = this.fairseqNumPlhTok;
            this.preventPlhTokenSplits = this.fairseqPreventPlhTokenSplits;
        }
    }
}
