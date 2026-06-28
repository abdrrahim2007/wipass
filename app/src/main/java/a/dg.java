package a;

import android.app.job.JobWorkItem;
import android.content.Intent;
import android.view.autofill.AutofillManager;

/* JADX INFO: loaded from: classes.dex */
public abstract /* synthetic */ class dg {
    public static /* synthetic */ JobWorkItem e(Intent intent) {
        return new JobWorkItem(intent);
    }

    public static /* bridge */ /* synthetic */ AutofillManager r(Object obj) {
        return (AutofillManager) obj;
    }

    public static /* bridge */ /* synthetic */ Class s() {
        return AutofillManager.class;
    }
}
