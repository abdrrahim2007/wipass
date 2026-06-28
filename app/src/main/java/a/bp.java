package a;

import android.content.ClipData;
import android.location.LocationRequest;
import android.os.OutcomeReceiver;
import android.view.ContentInfo;

/* JADX INFO: loaded from: classes.dex */
public abstract /* synthetic */ class bp {
    public static /* bridge */ /* synthetic */ LocationRequest e(Object obj) {
        return (LocationRequest) obj;
    }

    public static /* bridge */ /* synthetic */ OutcomeReceiver h(Object obj) {
        return (OutcomeReceiver) obj;
    }

    public static /* synthetic */ ContentInfo.Builder i(ClipData clipData, int i) {
        return new ContentInfo.Builder(clipData, i);
    }

    public static /* synthetic */ ContentInfo.Builder j(ContentInfo contentInfo) {
        return new ContentInfo.Builder(contentInfo);
    }

    public static /* bridge */ /* synthetic */ ContentInfo l(Object obj) {
        return (ContentInfo) obj;
    }

    public static /* synthetic */ void o() {
    }
}
