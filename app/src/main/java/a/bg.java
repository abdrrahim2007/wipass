package a;

import android.graphics.Bitmap;
import android.os.SystemClock;
import android.util.Log;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public final class bg implements sl {
    public static final qt b = qt.a(90, "com.bumptech.glide.load.resource.bitmap.BitmapEncoder.CompressionQuality");
    public static final qt c = new qt("com.bumptech.glide.load.resource.bitmap.BitmapEncoder.CompressionFormat", null, qt.e);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final on f26a;

    public bg(on onVar) {
        this.f26a = onVar;
    }

    @Override // a.hi
    public final boolean i(Object obj, File file, qu quVar) throws Throwable {
        boolean z;
        Bitmap bitmap = (Bitmap) ((sf) obj).get();
        qt qtVar = c;
        Bitmap.CompressFormat compressFormat = (Bitmap.CompressFormat) quVar.c(qtVar);
        if (compressFormat == null) {
            compressFormat = bitmap.hasAlpha() ? Bitmap.CompressFormat.PNG : Bitmap.CompressFormat.JPEG;
        }
        bitmap.getWidth();
        bitmap.getHeight();
        int i = oj.f211a;
        SystemClock.elapsedRealtimeNanos();
        int iIntValue = ((Integer) quVar.c(b)).intValue();
        OutputStream brVar = null;
        try {
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(file);
                on onVar = this.f26a;
                if (onVar != null) {
                    try {
                        brVar = new br(fileOutputStream, onVar);
                    } catch (IOException unused) {
                        brVar = fileOutputStream;
                        Log.isLoggable("BitmapEncoder", 3);
                        if (brVar != null) {
                            try {
                                brVar.close();
                            } catch (IOException unused2) {
                            }
                        }
                        z = false;
                    } catch (Throwable th) {
                        th = th;
                        brVar = fileOutputStream;
                        if (brVar != null) {
                            try {
                                brVar.close();
                            } catch (IOException unused3) {
                            }
                        }
                        throw th;
                    }
                } else {
                    brVar = fileOutputStream;
                }
                bitmap.compress(compressFormat, iIntValue, brVar);
                brVar.close();
                try {
                    brVar.close();
                } catch (IOException unused4) {
                }
                z = true;
            } catch (IOException unused5) {
            }
            if (Log.isLoggable("BitmapEncoder", 2)) {
                Objects.toString(compressFormat);
                wh.c(bitmap);
                SystemClock.elapsedRealtimeNanos();
                Objects.toString(quVar.c(qtVar));
                bitmap.hasAlpha();
            }
            return z;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    @Override // a.sl
    public final int m(qu quVar) {
        return 2;
    }
}
