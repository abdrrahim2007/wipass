package a;

import android.content.Context;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.profileinstaller.ProfileInstaller;
import androidx.profileinstaller.ProfileInstallerInitializer;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class al implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f9a;
    public final /* synthetic */ Context b;

    public /* synthetic */ al(Context context, int i) {
        this.f9a = i;
        this.b = context;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f9a) {
            case 0:
                AppCompatDelegate.lambda$syncRequestedAndStoredLocales$1(this.b);
                break;
            case 1:
                AppCompatDelegate.syncRequestedAndStoredLocales(this.b);
                break;
            case 2:
                ProfileInstallerInitializer.writeInBackground(this.b);
                break;
            default:
                ProfileInstaller.writeProfile(this.b);
                break;
        }
    }
}
