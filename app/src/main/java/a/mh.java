package a;

import androidx.core.content.IntentSanitizer;
import androidx.core.util.Consumer;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class mh implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f181a;

    public /* synthetic */ mh(int i) {
        this.f181a = i;
    }

    @Override // androidx.core.util.Consumer
    public final void accept(Object obj) {
        String str = (String) obj;
        switch (this.f181a) {
            case 0:
                IntentSanitizer.lambda$sanitizeByThrowing$1(str);
                break;
            default:
                IntentSanitizer.lambda$sanitizeByFiltering$0(str);
                break;
        }
    }
}
