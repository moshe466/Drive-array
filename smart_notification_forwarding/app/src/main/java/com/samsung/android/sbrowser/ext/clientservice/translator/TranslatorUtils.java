package com.samsung.android.sbrowser.ext.clientservice.translator;

import android.content.Context;
import android.os.Handler;
import android.util.Log;
import com.samsung.android.sbrowser.ext.ExClientService;
import com.samsung.android.sbrowser.ext.clientservice.six.SixObject;
import com.samsung.android.sbrowser.ext.utils.SysUtils;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class TranslatorUtils extends SixObject {
    private static final String TAG = "TranslatorUtils";
    ExClientService mClientService;
    Context mContext;
    private String mDstLocale;
    private String mObjectName;
    private final String mPendingWaitAndGetResultId;
    private Handler mSixHandler;
    private Translator mTranslator;

    public TranslatorUtils(Context context, ExClientService exClientService) {
        super(exClientService);
        this.mPendingWaitAndGetResultId = null;
        this.mContext = null;
        this.mClientService = null;
        this.mSixHandler = null;
        this.mDstLocale = null;
        Log.d(TAG, "TranslatorUtils ctor");
        this.mContext = context;
        this.mClientService = exClientService;
    }

    void logException(Exception exc) {
        Log.e(TAG, exc.toString());
        exc.printStackTrace();
    }

    public void init(String str, String str2) {
        Log.d(TAG, "init called with  " + str2);
        try {
            SixObject.registerObject(str2, this);
            this.mObjectName = str2;
            Translator createTranslator = TranslatorFactory.createTranslator(this.mContext);
            this.mTranslator = createTranslator;
            if (createTranslator == null) {
                throw new RuntimeException("fail to create Translator ");
            }
            createTranslator.init(this.mContext, null);
            sendSuccess(str, new String[0]);
        } catch (Exception e) {
            sendFail(str, e);
        }
    }

    public void delete(String str) {
        Log.i(TAG, "delete called");
        try {
            Translator translator = this.mTranslator;
            if (translator != null) {
                translator.delete();
                this.mTranslator = null;
            }
            SixObject.removeObject(this.mObjectName);
            sendSuccess(str, new String[0]);
        } catch (Exception e) {
            sendFail(str, e);
        }
    }

    public void getSourceLanguageList(String str) {
        try {
            new ArrayList();
            sendSuccess(str, this.mTranslator.getSourceLanguageList());
        } catch (Exception e) {
            sendFail(str, e);
        }
    }

    public void identifyLanguage(String str, String str2) {
        try {
            sendSuccess(str, this.mTranslator.identifyLanguage(str2));
        } catch (Exception e) {
            sendFail(str, e);
        }
    }

    public void getSupportAllLanguageList(String str) {
        try {
            new ArrayList();
            sendSuccess(str, this.mTranslator.getDownloadableLanguageDirectionList());
        } catch (Exception e) {
            sendFail(str, e);
        }
    }

    public void getAvailableLanguageList(String str) {
        try {
            new ArrayList();
            sendSuccess(str, this.mTranslator.getAvailableLanguageDirectionList());
        } catch (Exception e) {
            sendFail(str, e);
        }
    }

    public void getAvailableLangListWithLocale(String str, String str2) {
        try {
            new ArrayList();
            sendSuccess(str, this.mTranslator.getAvailableLanguageDirectionListWithLocale(str2));
        } catch (Exception e) {
            sendFail(str, e);
        }
    }

    public void refresh(String str) {
        try {
            this.mTranslator.refresh();
            sendSuccess(str, new String[0]);
        } catch (Exception e) {
            sendFail(str, e);
        }
    }

    public void clearTranslator(String str) {
        try {
            this.mTranslator.clear();
            sendSuccess(str, new String[0]);
        } catch (Exception e) {
            sendFail(str, e);
        }
    }

    public void getSupportASR(String str) {
        try {
            sendSuccess(str, String.valueOf(SysUtils.isFlagShip()));
        } catch (Exception e) {
            sendFail(str, e);
        }
    }

    public void isPivot(String str) {
        try {
            sendSuccess(str, this.mTranslator.isPivot() ? "True" : "False");
        } catch (Exception e) {
            sendFail(str, e);
        }
    }

    public void setPivot(String str, String str2) {
        try {
            this.mTranslator.setPivot(str2);
            sendSuccess(str, new String[0]);
        } catch (Exception e) {
            sendFail(str, e);
        }
    }

    public void getAvailableLangpackListWithLocale(String str, String str2) {
        try {
            new ArrayList();
            ArrayList<String> availableLangpackListWithLocale = this.mTranslator.getAvailableLangpackListWithLocale(str2);
            Log.i(TAG, "getAvailableLangpackListWithLocale called:" + availableLangpackListWithLocale);
            sendSuccess(str, availableLangpackListWithLocale);
        } catch (Exception e) {
            sendFail(str, e);
        }
    }
}
