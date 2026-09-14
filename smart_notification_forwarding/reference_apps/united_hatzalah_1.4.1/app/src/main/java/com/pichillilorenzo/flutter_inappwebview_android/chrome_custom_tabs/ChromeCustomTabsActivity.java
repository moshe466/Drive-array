package com.pichillilorenzo.flutter_inappwebview_android.chrome_custom_tabs;

import android.app.Activity;
import android.app.ActivityOptions;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.RemoteException;
import android.widget.RemoteViews;
import b.C0317b;
import com.google.android.gms.common.internal.ImagesContract;
import com.pichillilorenzo.flutter_inappwebview_android.InAppWebViewFlutterPlugin;
import com.pichillilorenzo.flutter_inappwebview_android.R;
import com.pichillilorenzo.flutter_inappwebview_android.chrome_custom_tabs.CustomTabActivityHelper;
import com.pichillilorenzo.flutter_inappwebview_android.types.AndroidResource;
import com.pichillilorenzo.flutter_inappwebview_android.types.CustomTabsActionButton;
import com.pichillilorenzo.flutter_inappwebview_android.types.CustomTabsMenuItem;
import com.pichillilorenzo.flutter_inappwebview_android.types.CustomTabsSecondaryToolbar;
import com.pichillilorenzo.flutter_inappwebview_android.types.Disposable;
import io.flutter.plugin.common.MethodChannel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import r.AbstractC0626a;
import r.BinderC0639n;
import r.C0634i;
import r.C0635j;
import r.C0640o;
import r.InterfaceC0641p;

/* loaded from: classes.dex */
public class ChromeCustomTabsActivity extends Activity implements Disposable {
    public static final int CHROME_CUSTOM_TAB_REQUEST_CODE = 100;
    protected static final String LOG_TAG = "CustomTabsActivity";
    public static final String METHOD_CHANNEL_NAME_PREFIX = "com.pichillilorenzo/flutter_chromesafaribrowser_";
    public static final int NO_HISTORY_CHROME_CUSTOM_TAB_REQUEST_CODE = 101;
    public CustomTabsActionButton actionButton;
    public C0634i builder;
    public ChromeCustomTabsChannelDelegate channelDelegate;
    public C0640o customTabsSession;
    public String id;
    public Map<String, String> initialHeaders;
    public List<String> initialOtherLikelyURLs;
    public String initialReferrer;
    public String initialUrl;
    public ChromeSafariBrowserManager manager;
    public CustomTabsSecondaryToolbar secondaryToolbar;
    public ChromeCustomTabsSettings customSettings = new ChromeCustomTabsSettings();
    public CustomTabActivityHelper customTabActivityHelper = new CustomTabActivityHelper();
    protected boolean onOpened = false;
    protected boolean onCompletedInitialLoad = false;
    protected boolean isBindSuccess = false;
    public List<CustomTabsMenuItem> menuItems = new ArrayList();

    private PendingIntent createPendingIntent(int i) {
        String str;
        Intent intent = new Intent(this, (Class<?>) ActionBroadcastReceiver.class);
        Bundle bundle = new Bundle();
        bundle.putInt(ActionBroadcastReceiver.KEY_ACTION_ID, i);
        bundle.putString(ActionBroadcastReceiver.KEY_ACTION_VIEW_ID, this.id);
        ChromeSafariBrowserManager chromeSafariBrowserManager = this.manager;
        if (chromeSafariBrowserManager != null) {
            str = chromeSafariBrowserManager.id;
        } else {
            str = null;
        }
        bundle.putString(ActionBroadcastReceiver.KEY_ACTION_MANAGER_ID, str);
        intent.putExtras(bundle);
        if (Build.VERSION.SDK_INT >= 31) {
            return PendingIntent.getBroadcast(this, i, intent, 167772160);
        }
        return PendingIntent.getBroadcast(this, i, intent, 134217728);
    }

    private void prepareCustomTabs() {
        Integer num;
        Integer num2;
        Integer num3;
        int i;
        C0634i c0634i = this.builder;
        if (c0634i != null) {
            ChromeCustomTabsSettings chromeCustomTabsSettings = this.customSettings;
            Boolean bool = chromeCustomTabsSettings.addDefaultShareMenuItem;
            if (bool != null) {
                if (bool.booleanValue()) {
                    i = 1;
                } else {
                    i = 2;
                }
                c0634i.b(i);
            } else {
                c0634i.b(chromeCustomTabsSettings.shareState.intValue());
            }
            String str = this.customSettings.toolbarBackgroundColor;
            Integer num4 = null;
            if (str != null && !str.isEmpty()) {
                num = Integer.valueOf(Color.parseColor(this.customSettings.toolbarBackgroundColor) | (-16777216));
            } else {
                num = null;
            }
            String str2 = this.customSettings.navigationBarColor;
            if (str2 != null && !str2.isEmpty()) {
                num2 = Integer.valueOf((-16777216) | Color.parseColor(this.customSettings.navigationBarColor));
            } else {
                num2 = null;
            }
            String str3 = this.customSettings.navigationBarDividerColor;
            if (str3 != null && !str3.isEmpty()) {
                num3 = Integer.valueOf(Color.parseColor(this.customSettings.navigationBarDividerColor));
            } else {
                num3 = null;
            }
            String str4 = this.customSettings.secondaryToolbarColor;
            if (str4 != null && !str4.isEmpty()) {
                num4 = Integer.valueOf(Color.parseColor(this.customSettings.secondaryToolbarColor));
            }
            C0634i c0634i2 = this.builder;
            c0634i2.getClass();
            Bundle bundle = new Bundle();
            if (num != null) {
                bundle.putInt("android.support.customtabs.extra.TOOLBAR_COLOR", num.intValue());
            }
            if (num4 != null) {
                bundle.putInt("android.support.customtabs.extra.SECONDARY_TOOLBAR_COLOR", num4.intValue());
            }
            if (num2 != null) {
                bundle.putInt("androidx.browser.customtabs.extra.NAVIGATION_BAR_COLOR", num2.intValue());
            }
            if (num3 != null) {
                bundle.putInt("androidx.browser.customtabs.extra.NAVIGATION_BAR_DIVIDER_COLOR", num3.intValue());
            }
            c0634i2.f6189e = bundle;
            this.builder.f6185a.putExtra("android.support.customtabs.extra.TITLE_VISIBILITY", this.customSettings.showTitle.booleanValue() ? 1 : 0);
            this.builder.f6185a.putExtra("android.support.customtabs.extra.ENABLE_URLBAR_HIDING", this.customSettings.enableUrlBarHiding.booleanValue());
            this.builder.f6191g = this.customSettings.instantAppsEnabled.booleanValue();
            if (this.customSettings.startAnimations.size() == 2) {
                C0634i c0634i3 = this.builder;
                int identifier = this.customSettings.startAnimations.get(0).getIdentifier(this);
                int identifier2 = this.customSettings.startAnimations.get(1).getIdentifier(this);
                c0634i3.getClass();
                c0634i3.f6188d = ActivityOptions.makeCustomAnimation(this, identifier, identifier2);
            }
            if (this.customSettings.exitAnimations.size() == 2) {
                C0634i c0634i4 = this.builder;
                int identifier3 = this.customSettings.exitAnimations.get(0).getIdentifier(this);
                int identifier4 = this.customSettings.exitAnimations.get(1).getIdentifier(this);
                c0634i4.getClass();
                c0634i4.f6185a.putExtra("android.support.customtabs.extra.EXIT_ANIMATION_BUNDLE", ActivityOptions.makeCustomAnimation(this, identifier3, identifier4).toBundle());
            }
            for (CustomTabsMenuItem customTabsMenuItem : this.menuItems) {
                C0634i c0634i5 = this.builder;
                String label = customTabsMenuItem.getLabel();
                PendingIntent createPendingIntent = createPendingIntent(customTabsMenuItem.getId());
                if (c0634i5.f6187c == null) {
                    c0634i5.f6187c = new ArrayList();
                }
                Bundle bundle2 = new Bundle();
                bundle2.putString("android.support.customtabs.customaction.MENU_ITEM_TITLE", label);
                bundle2.putParcelable("android.support.customtabs.customaction.PENDING_INTENT", createPendingIntent);
                c0634i5.f6187c.add(bundle2);
            }
            CustomTabsActionButton customTabsActionButton = this.actionButton;
            if (customTabsActionButton != null) {
                byte[] icon = customTabsActionButton.getIcon();
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inMutable = true;
                Bitmap decodeByteArray = BitmapFactory.decodeByteArray(icon, 0, icon.length, options);
                C0634i c0634i6 = this.builder;
                String description = this.actionButton.getDescription();
                PendingIntent createPendingIntent2 = createPendingIntent(this.actionButton.getId());
                boolean isShouldTint = this.actionButton.isShouldTint();
                c0634i6.getClass();
                Bundle bundle3 = new Bundle();
                bundle3.putInt("android.support.customtabs.customaction.ID", 0);
                bundle3.putParcelable("android.support.customtabs.customaction.ICON", decodeByteArray);
                bundle3.putString("android.support.customtabs.customaction.DESCRIPTION", description);
                bundle3.putParcelable("android.support.customtabs.customaction.PENDING_INTENT", createPendingIntent2);
                Intent intent = c0634i6.f6185a;
                intent.putExtra("android.support.customtabs.extra.ACTION_BUTTON_BUNDLE", bundle3);
                intent.putExtra("android.support.customtabs.extra.TINT_ACTION_BUTTON", isShouldTint);
            }
            CustomTabsSecondaryToolbar customTabsSecondaryToolbar = this.secondaryToolbar;
            if (customTabsSecondaryToolbar != null) {
                AndroidResource layout = customTabsSecondaryToolbar.getLayout();
                RemoteViews remoteViews = new RemoteViews(layout.getDefPackage(), layout.getIdentifier(this));
                int[] iArr = new int[this.secondaryToolbar.getClickableIDs().size()];
                int size = this.secondaryToolbar.getClickableIDs().size();
                for (int i3 = 0; i3 < size; i3++) {
                    iArr[i3] = this.secondaryToolbar.getClickableIDs().get(i3).getIdentifier(this);
                }
                C0634i c0634i7 = this.builder;
                PendingIntent secondaryToolbarOnClickPendingIntent = getSecondaryToolbarOnClickPendingIntent();
                Intent intent2 = c0634i7.f6185a;
                intent2.putExtra("android.support.customtabs.extra.EXTRA_REMOTEVIEWS", remoteViews);
                intent2.putExtra("android.support.customtabs.extra.EXTRA_REMOTEVIEWS_VIEW_IDS", iArr);
                intent2.putExtra("android.support.customtabs.extra.EXTRA_REMOTEVIEWS_PENDINGINTENT", secondaryToolbarOnClickPendingIntent);
            }
        }
    }

    private void prepareCustomTabsIntent(C0635j c0635j) {
        String str = this.customSettings.packageName;
        if (str != null) {
            c0635j.f6192a.setPackage(str);
        } else {
            c0635j.f6192a.setPackage(CustomTabsHelper.getPackageNameToUse(this));
        }
        if (this.customSettings.keepAliveEnabled.booleanValue()) {
            CustomTabsHelper.addKeepAliveExtra(this, c0635j.f6192a);
        }
        if (this.customSettings.alwaysUseBrowserUI.booleanValue()) {
            Intent intent = c0635j.f6192a;
            if (intent == null) {
                intent = new Intent("android.intent.action.VIEW");
            }
            intent.addFlags(268435456);
            intent.putExtra("android.support.customtabs.extra.user_opt_out", true);
        }
    }

    public void close() {
        onStop();
        onDestroy();
        this.customTabsSession = null;
        finish();
        ChromeCustomTabsChannelDelegate chromeCustomTabsChannelDelegate = this.channelDelegate;
        if (chromeCustomTabsChannelDelegate != null) {
            chromeCustomTabsChannelDelegate.onClosed();
        }
    }

    public void customTabsConnected() {
        String str;
        C0640o session = this.customTabActivityHelper.getSession();
        this.customTabsSession = session;
        if (session != null) {
            try {
                Bundle bundle = new Bundle();
                if (this.customTabsSession.b(bundle)) {
                    C0640o c0640o = this.customTabsSession;
                    InterfaceC0641p interfaceC0641p = new InterfaceC0641p() { // from class: com.pichillilorenzo.flutter_inappwebview_android.chrome_custom_tabs.ChromeCustomTabsActivity.3
                        @Override // r.InterfaceC0641p
                        public void onGreatestScrollPercentageIncreased(int i, Bundle bundle2) {
                            ChromeCustomTabsChannelDelegate chromeCustomTabsChannelDelegate = ChromeCustomTabsActivity.this.channelDelegate;
                            if (chromeCustomTabsChannelDelegate != null) {
                                chromeCustomTabsChannelDelegate.onGreatestScrollPercentageIncreased(i);
                            }
                        }

                        @Override // r.InterfaceC0641p
                        public void onSessionEnded(boolean z3, Bundle bundle2) {
                            ChromeCustomTabsChannelDelegate chromeCustomTabsChannelDelegate = ChromeCustomTabsActivity.this.channelDelegate;
                            if (chromeCustomTabsChannelDelegate != null) {
                                chromeCustomTabsChannelDelegate.onSessionEnded(z3);
                            }
                        }

                        @Override // r.InterfaceC0641p
                        public void onVerticalScrollEvent(boolean z3, Bundle bundle2) {
                            ChromeCustomTabsChannelDelegate chromeCustomTabsChannelDelegate = ChromeCustomTabsActivity.this.channelDelegate;
                            if (chromeCustomTabsChannelDelegate != null) {
                                chromeCustomTabsChannelDelegate.onVerticalScrollEvent(z3);
                            }
                        }
                    };
                    Bundle a2 = c0640o.a(bundle);
                    try {
                        ((C0317b) c0640o.f6201b).k(c0640o.f6202c, new BinderC0639n(interfaceC0641p), a2);
                    } catch (SecurityException e4) {
                        throw new UnsupportedOperationException("This method isn't supported by the Custom Tabs implementation.", e4);
                    }
                }
            } catch (Throwable unused) {
            }
        }
        if (this.isBindSuccess && (str = this.initialUrl) != null) {
            launchUrl(str, this.initialHeaders, this.initialReferrer, this.initialOtherLikelyURLs);
        }
    }

    @Override // com.pichillilorenzo.flutter_inappwebview_android.types.Disposable
    public void dispose() {
        onStop();
        onDestroy();
        ChromeCustomTabsChannelDelegate chromeCustomTabsChannelDelegate = this.channelDelegate;
        if (chromeCustomTabsChannelDelegate != null) {
            chromeCustomTabsChannelDelegate.dispose();
            this.channelDelegate = null;
        }
        ChromeSafariBrowserManager chromeSafariBrowserManager = this.manager;
        if (chromeSafariBrowserManager != null && chromeSafariBrowserManager.browsers.containsKey(this.id)) {
            this.manager.browsers.put(this.id, null);
        }
        this.manager = null;
    }

    public PendingIntent getSecondaryToolbarOnClickPendingIntent() {
        String str;
        Intent intent = new Intent(this, (Class<?>) ActionBroadcastReceiver.class);
        Bundle bundle = new Bundle();
        bundle.putString(ActionBroadcastReceiver.KEY_ACTION_VIEW_ID, this.id);
        ChromeSafariBrowserManager chromeSafariBrowserManager = this.manager;
        if (chromeSafariBrowserManager != null) {
            str = chromeSafariBrowserManager.id;
        } else {
            str = null;
        }
        bundle.putString(ActionBroadcastReceiver.KEY_ACTION_MANAGER_ID, str);
        intent.putExtras(bundle);
        if (Build.VERSION.SDK_INT >= 31) {
            return PendingIntent.getBroadcast(this, 0, intent, 167772160);
        }
        return PendingIntent.getBroadcast(this, 0, intent, 134217728);
    }

    public void launchUrl(String str, Map<String, String> map, String str2, List<String> list) {
        launchUrlWithSession(this.customTabsSession, str, map, str2, list);
    }

    public void launchUrlWithSession(C0640o c0640o, String str, Map<String, String> map, String str2, List<String> list) {
        Uri uri;
        mayLaunchUrl(str, list);
        this.builder = new C0634i(c0640o);
        prepareCustomTabs();
        C0635j a2 = this.builder.a();
        prepareCustomTabsIntent(a2);
        Uri parse = Uri.parse(str);
        if (str2 != null) {
            uri = Uri.parse(str2);
        } else {
            uri = null;
        }
        CustomTabActivityHelper.openCustomTab(this, a2, parse, map, uri, 100);
    }

    public boolean mayLaunchUrl(String str, List<String> list) {
        Uri uri;
        if (str != null) {
            uri = Uri.parse(str);
        } else {
            uri = null;
        }
        ArrayList arrayList = new ArrayList();
        if (list != null) {
            Bundle bundle = new Bundle();
            Iterator<String> it = list.iterator();
            while (it.hasNext()) {
                bundle.putString("android.support.customtabs.otherurls.URL", it.next());
            }
        }
        return this.customTabActivityHelper.mayLaunchUrl(uri, null, arrayList);
    }

    @Override // android.app.Activity
    public void onActivityResult(int i, int i3, Intent intent) {
        if (i == 100) {
            close();
            dispose();
        }
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        InAppWebViewFlutterPlugin inAppWebViewFlutterPlugin;
        NoHistoryCustomTabsActivityCallbacks noHistoryCustomTabsActivityCallbacks;
        super.onCreate(bundle);
        setContentView(R.layout.chrome_custom_tabs_layout);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            this.id = extras.getString("id");
            ChromeSafariBrowserManager chromeSafariBrowserManager = ChromeSafariBrowserManager.shared.get(extras.getString("managerId"));
            this.manager = chromeSafariBrowserManager;
            if (chromeSafariBrowserManager != null && (inAppWebViewFlutterPlugin = chromeSafariBrowserManager.plugin) != null && inAppWebViewFlutterPlugin.messenger != null) {
                chromeSafariBrowserManager.browsers.put(this.id, this);
                this.channelDelegate = new ChromeCustomTabsChannelDelegate(this, new MethodChannel(this.manager.plugin.messenger, METHOD_CHANNEL_NAME_PREFIX + this.id));
                this.initialUrl = extras.getString(ImagesContract.URL);
                this.initialHeaders = (Map) extras.getSerializable("headers");
                this.initialReferrer = extras.getString("referrer");
                this.initialOtherLikelyURLs = extras.getStringArrayList("otherLikelyURLs");
                ChromeCustomTabsSettings chromeCustomTabsSettings = new ChromeCustomTabsSettings();
                this.customSettings = chromeCustomTabsSettings;
                chromeCustomTabsSettings.parse2((Map<String, Object>) extras.getSerializable("settings"));
                this.actionButton = CustomTabsActionButton.fromMap((Map) extras.getSerializable("actionButton"));
                this.secondaryToolbar = CustomTabsSecondaryToolbar.fromMap((Map) extras.getSerializable("secondaryToolbar"));
                Iterator it = ((List) extras.getSerializable("menuItemList")).iterator();
                while (it.hasNext()) {
                    this.menuItems.add(CustomTabsMenuItem.fromMap((Map) it.next()));
                }
                if (this.customSettings.noHistory.booleanValue() && (noHistoryCustomTabsActivityCallbacks = this.manager.plugin.noHistoryCustomTabsActivityCallbacks) != null) {
                    Map<String, String> map = noHistoryCustomTabsActivityCallbacks.noHistoryBrowserIDs;
                    String str = this.id;
                    map.put(str, str);
                }
                this.customTabActivityHelper.setConnectionCallback(new CustomTabActivityHelper.ConnectionCallback() { // from class: com.pichillilorenzo.flutter_inappwebview_android.chrome_custom_tabs.ChromeCustomTabsActivity.1
                    @Override // com.pichillilorenzo.flutter_inappwebview_android.chrome_custom_tabs.CustomTabActivityHelper.ConnectionCallback
                    public void onCustomTabsConnected() {
                        ChromeCustomTabsActivity.this.customTabsConnected();
                        ChromeCustomTabsChannelDelegate chromeCustomTabsChannelDelegate = ChromeCustomTabsActivity.this.channelDelegate;
                        if (chromeCustomTabsChannelDelegate != null) {
                            chromeCustomTabsChannelDelegate.onServiceConnected();
                        }
                    }

                    @Override // com.pichillilorenzo.flutter_inappwebview_android.chrome_custom_tabs.CustomTabActivityHelper.ConnectionCallback
                    public void onCustomTabsDisconnected() {
                        this.close();
                        ChromeCustomTabsActivity.this.dispose();
                    }
                });
                this.customTabActivityHelper.setCustomTabsCallback(new AbstractC0626a() { // from class: com.pichillilorenzo.flutter_inappwebview_android.chrome_custom_tabs.ChromeCustomTabsActivity.2
                    @Override // r.AbstractC0626a
                    public void extraCallback(String str2, Bundle bundle2) {
                    }

                    @Override // r.AbstractC0626a
                    public void onMessageChannelReady(Bundle bundle2) {
                        ChromeCustomTabsChannelDelegate chromeCustomTabsChannelDelegate = ChromeCustomTabsActivity.this.channelDelegate;
                        if (chromeCustomTabsChannelDelegate != null) {
                            chromeCustomTabsChannelDelegate.onMessageChannelReady();
                        }
                    }

                    @Override // r.AbstractC0626a
                    public void onNavigationEvent(int i, Bundle bundle2) {
                        if (i == 5) {
                            ChromeCustomTabsActivity chromeCustomTabsActivity = ChromeCustomTabsActivity.this;
                            if (!chromeCustomTabsActivity.onOpened) {
                                chromeCustomTabsActivity.onOpened = true;
                                ChromeCustomTabsChannelDelegate chromeCustomTabsChannelDelegate = chromeCustomTabsActivity.channelDelegate;
                                if (chromeCustomTabsChannelDelegate != null) {
                                    chromeCustomTabsChannelDelegate.onOpened();
                                }
                            }
                        }
                        if (i == 2) {
                            ChromeCustomTabsActivity chromeCustomTabsActivity2 = ChromeCustomTabsActivity.this;
                            if (!chromeCustomTabsActivity2.onCompletedInitialLoad) {
                                chromeCustomTabsActivity2.onCompletedInitialLoad = true;
                                ChromeCustomTabsChannelDelegate chromeCustomTabsChannelDelegate2 = chromeCustomTabsActivity2.channelDelegate;
                                if (chromeCustomTabsChannelDelegate2 != null) {
                                    chromeCustomTabsChannelDelegate2.onCompletedInitialLoad();
                                }
                            }
                        }
                        ChromeCustomTabsChannelDelegate chromeCustomTabsChannelDelegate3 = ChromeCustomTabsActivity.this.channelDelegate;
                        if (chromeCustomTabsChannelDelegate3 != null) {
                            chromeCustomTabsChannelDelegate3.onNavigationEvent(i);
                        }
                    }

                    @Override // r.AbstractC0626a
                    public void onPostMessage(String str2, Bundle bundle2) {
                        ChromeCustomTabsChannelDelegate chromeCustomTabsChannelDelegate = ChromeCustomTabsActivity.this.channelDelegate;
                        if (chromeCustomTabsChannelDelegate != null) {
                            chromeCustomTabsChannelDelegate.onPostMessage(str2);
                        }
                    }

                    @Override // r.AbstractC0626a
                    public void onRelationshipValidationResult(int i, Uri uri, boolean z3, Bundle bundle2) {
                        ChromeCustomTabsChannelDelegate chromeCustomTabsChannelDelegate = ChromeCustomTabsActivity.this.channelDelegate;
                        if (chromeCustomTabsChannelDelegate != null) {
                            chromeCustomTabsChannelDelegate.onRelationshipValidationResult(i, uri, z3);
                        }
                    }
                });
            }
        }
    }

    @Override // android.app.Activity
    public void onDestroy() {
        super.onDestroy();
    }

    @Override // android.app.Activity
    public void onStart() {
        String str;
        super.onStart();
        boolean bindCustomTabsService = this.customTabActivityHelper.bindCustomTabsService(this);
        this.isBindSuccess = bindCustomTabsService;
        if (!bindCustomTabsService && (str = this.initialUrl) != null) {
            launchUrlWithSession(null, str, this.initialHeaders, this.initialReferrer, this.initialOtherLikelyURLs);
        }
    }

    @Override // android.app.Activity
    public void onStop() {
        super.onStop();
        this.customTabActivityHelper.unbindCustomTabsService(this);
        this.isBindSuccess = false;
    }

    public void updateActionButton(byte[] bArr, String str) {
        if (this.customTabsSession != null && this.actionButton != null) {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inMutable = true;
            Bitmap decodeByteArray = BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
            C0640o c0640o = this.customTabsSession;
            c0640o.getClass();
            Bundle bundle = new Bundle();
            bundle.putParcelable("android.support.customtabs.customaction.ICON", decodeByteArray);
            bundle.putString("android.support.customtabs.customaction.DESCRIPTION", str);
            Bundle bundle2 = new Bundle();
            bundle2.putBundle("android.support.customtabs.extra.ACTION_BUTTON_BUNDLE", bundle);
            try {
                ((C0317b) c0640o.f6201b).l(c0640o.f6202c, bundle2);
            } catch (RemoteException unused) {
            }
            this.actionButton.setIcon(bArr);
            this.actionButton.setDescription(str);
        }
    }

    public void updateSecondaryToolbar(CustomTabsSecondaryToolbar customTabsSecondaryToolbar) {
        if (this.customTabsSession == null) {
            return;
        }
        AndroidResource layout = customTabsSecondaryToolbar.getLayout();
        RemoteViews remoteViews = new RemoteViews(layout.getDefPackage(), layout.getIdentifier(this));
        int[] iArr = new int[customTabsSecondaryToolbar.getClickableIDs().size()];
        int size = customTabsSecondaryToolbar.getClickableIDs().size();
        for (int i = 0; i < size; i++) {
            iArr[i] = customTabsSecondaryToolbar.getClickableIDs().get(i).getIdentifier(this);
        }
        C0640o c0640o = this.customTabsSession;
        PendingIntent secondaryToolbarOnClickPendingIntent = getSecondaryToolbarOnClickPendingIntent();
        c0640o.getClass();
        Bundle bundle = new Bundle();
        bundle.putParcelable("android.support.customtabs.extra.EXTRA_REMOTEVIEWS", remoteViews);
        bundle.putIntArray("android.support.customtabs.extra.EXTRA_REMOTEVIEWS_VIEW_IDS", iArr);
        bundle.putParcelable("android.support.customtabs.extra.EXTRA_REMOTEVIEWS_PENDINGINTENT", secondaryToolbarOnClickPendingIntent);
        try {
            ((C0317b) c0640o.f6201b).l(c0640o.f6202c, bundle);
        } catch (RemoteException unused) {
        }
        this.secondaryToolbar = customTabsSecondaryToolbar;
    }
}
