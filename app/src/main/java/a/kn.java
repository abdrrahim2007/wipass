package a;

import android.content.res.AssetFileDescriptor;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import androidx.fragment.app.FragmentManager;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* JADX INFO: loaded from: classes.dex */
public final class kn implements sl, sc, il, qs, uf, qb {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f150a;

    public /* synthetic */ kn(int i) {
        this.f150a = i;
    }

    @Override // a.il
    public Object b() {
        switch (this.f150a) {
            case 5:
                return new oi();
            default:
                try {
                    return new sv(MessageDigest.getInstance("SHA-256"));
                } catch (NoSuchAlgorithmException e) {
                    throw new RuntimeException(e);
                }
        }
    }

    @Override // a.qb
    public qa c(qj qjVar) {
        switch (this.f150a) {
            case 13:
                return new um(qjVar.a(Uri.class, AssetFileDescriptor.class), 0);
            case 14:
                return new um(qjVar.a(Uri.class, ParcelFileDescriptor.class), 0);
            case 15:
                return new um(qjVar.a(Uri.class, InputStream.class), 0);
            case 16:
                return new um(qjVar.a(lh.class, InputStream.class), 1);
            default:
                return new wd(qjVar.a(lh.class, InputStream.class));
        }
    }

    @Override // a.hi
    public boolean i(Object obj, File file, qu quVar) {
        try {
            cf.d(((km) ((sf) obj).get()).f149a.f148a.f155a.d.asReadOnlyBuffer(), file);
            return true;
        } catch (IOException unused) {
            Log.isLoggable("GifEncoder", 5);
            return false;
        }
    }

    @Override // a.sl
    public int m(qu quVar) {
        return 1;
    }

    public kn(ah ahVar, FragmentManager fragmentManager) {
        this.f150a = 4;
    }

    @Override // a.qs
    public void a(byte[] bArr, Object obj, MessageDigest messageDigest) {
    }
}
