package a;

import android.view.accessibility.AccessibilityNodeInfo;
import android.view.inspector.InspectionCompanion;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public abstract /* synthetic */ class p {
    public static /* synthetic */ AccessibilityNodeInfo.TouchDelegateInfo g(Map map) {
        return new AccessibilityNodeInfo.TouchDelegateInfo(map);
    }

    public static /* synthetic */ InspectionCompanion.UninitializedPropertyMapException i() {
        return new InspectionCompanion.UninitializedPropertyMapException();
    }
}
