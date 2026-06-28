package a;

import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.bumptech.glide.load.ImageHeaderParser$ImageType;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;

/* JADX INFO: loaded from: classes.dex */
public final class fr implements lw {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final byte[] f87a = "Exif\u0000\u0000".getBytes(Charset.forName("UTF-8"));
    public static final int[] b = {0, 1, 1, 2, 4, 8, 1, 1, 2, 4, 8, 4, 8};

    public static int e(fq fqVar, on onVar) {
        int iF;
        try {
            int iF2 = fqVar.f();
            if ((iF2 & 65496) != 65496 && iF2 != 19789 && iF2 != 18761) {
                Log.isLoggable("DfltImageHeaderParser", 3);
                return -1;
            }
            while (true) {
                if (fqVar.e() == 255) {
                    short sE = fqVar.e();
                    if (sE == 218) {
                        break;
                    }
                    if (sE != 217) {
                        iF = fqVar.f() - 2;
                        if (sE == 225) {
                            break;
                        }
                        long j = iF;
                        if (fqVar.skip(j) != j) {
                            Log.isLoggable("DfltImageHeaderParser", 3);
                            break;
                        }
                    } else {
                        Log.isLoggable("DfltImageHeaderParser", 3);
                        break;
                    }
                } else {
                    Log.isLoggable("DfltImageHeaderParser", 3);
                    break;
                }
            }
            iF = -1;
            if (iF == -1) {
                Log.isLoggable("DfltImageHeaderParser", 3);
                return -1;
            }
            byte[] bArr = (byte[]) onVar.c(byte[].class, iF);
            try {
                return g(fqVar, bArr, iF);
            } finally {
                onVar.g(bArr);
            }
        } catch (fp unused) {
            return -1;
        }
    }

    public static ImageHeaderParser$ImageType f(fq fqVar) {
        try {
            int iF = fqVar.f();
            if (iF == 65496) {
                return ImageHeaderParser$ImageType.JPEG;
            }
            int iE = (iF << 8) | fqVar.e();
            if (iE == 4671814) {
                return ImageHeaderParser$ImageType.GIF;
            }
            int iE2 = (iE << 8) | fqVar.e();
            if (iE2 == -1991225785) {
                fqVar.skip(21L);
                try {
                    return fqVar.e() >= 3 ? ImageHeaderParser$ImageType.PNG_A : ImageHeaderParser$ImageType.PNG;
                } catch (fp unused) {
                    return ImageHeaderParser$ImageType.PNG;
                }
            }
            if (iE2 == 1380533830) {
                fqVar.skip(4L);
                if (((fqVar.f() << 16) | fqVar.f()) != 1464156752) {
                    return ImageHeaderParser$ImageType.UNKNOWN;
                }
                int iF2 = (fqVar.f() << 16) | fqVar.f();
                if ((iF2 & InputDeviceCompat.SOURCE_ANY) != 1448097792) {
                    return ImageHeaderParser$ImageType.UNKNOWN;
                }
                int i = iF2 & 255;
                if (i == 88) {
                    fqVar.skip(4L);
                    short sE = fqVar.e();
                    return (sE & 2) != 0 ? ImageHeaderParser$ImageType.ANIMATED_WEBP : (sE & 16) != 0 ? ImageHeaderParser$ImageType.WEBP_A : ImageHeaderParser$ImageType.WEBP;
                }
                if (i != 76) {
                    return ImageHeaderParser$ImageType.WEBP;
                }
                fqVar.skip(4L);
                return (fqVar.e() & 8) != 0 ? ImageHeaderParser$ImageType.WEBP_A : ImageHeaderParser$ImageType.WEBP;
            }
            if (((fqVar.f() << 16) | fqVar.f()) != 1718909296) {
                return ImageHeaderParser$ImageType.UNKNOWN;
            }
            int iF3 = (fqVar.f() << 16) | fqVar.f();
            if (iF3 == 1635150195) {
                return ImageHeaderParser$ImageType.ANIMATED_AVIF;
            }
            int i2 = 0;
            boolean z = iF3 == 1635150182;
            fqVar.skip(4L);
            int i3 = iE2 - 16;
            if (i3 % 4 == 0) {
                while (i2 < 5 && i3 > 0) {
                    int iF4 = (fqVar.f() << 16) | fqVar.f();
                    if (iF4 == 1635150195) {
                        return ImageHeaderParser$ImageType.ANIMATED_AVIF;
                    }
                    if (iF4 == 1635150182) {
                        z = true;
                    }
                    i2++;
                    i3 -= 4;
                }
            }
            return z ? ImageHeaderParser$ImageType.AVIF : ImageHeaderParser$ImageType.UNKNOWN;
        } catch (fp unused2) {
            return ImageHeaderParser$ImageType.UNKNOWN;
        }
    }

    public static int g(fq fqVar, byte[] bArr, int i) {
        ByteOrder byteOrder;
        if (fqVar.d(bArr, i) != i) {
            Log.isLoggable("DfltImageHeaderParser", 3);
            return -1;
        }
        byte[] bArr2 = f87a;
        boolean z = bArr != null && i > bArr2.length;
        if (z) {
            int i2 = 0;
            while (true) {
                if (i2 >= bArr2.length) {
                    break;
                }
                if (bArr[i2] != bArr2[i2]) {
                    z = false;
                    break;
                }
                i2++;
            }
        }
        if (!z) {
            Log.isLoggable("DfltImageHeaderParser", 3);
            return -1;
        }
        ByteBuffer byteBuffer = (ByteBuffer) ByteBuffer.wrap(bArr).order(ByteOrder.BIG_ENDIAN).limit(i);
        short s = byteBuffer.remaining() - 6 >= 2 ? byteBuffer.getShort(6) : (short) -1;
        if (s == 18761) {
            byteOrder = ByteOrder.LITTLE_ENDIAN;
        } else if (s != 19789) {
            Log.isLoggable("DfltImageHeaderParser", 3);
            byteOrder = ByteOrder.BIG_ENDIAN;
        } else {
            byteOrder = ByteOrder.BIG_ENDIAN;
        }
        byteBuffer.order(byteOrder);
        int i3 = byteBuffer.remaining() - 10 >= 4 ? byteBuffer.getInt(10) : -1;
        int i4 = i3 + 6;
        short s2 = byteBuffer.remaining() - i4 >= 2 ? byteBuffer.getShort(i4) : (short) -1;
        for (int i5 = 0; i5 < s2; i5++) {
            int i6 = (i5 * 12) + i3 + 8;
            if ((byteBuffer.remaining() - i6 >= 2 ? byteBuffer.getShort(i6) : (short) -1) == 274) {
                int i7 = i6 + 2;
                short s3 = byteBuffer.remaining() - i7 >= 2 ? byteBuffer.getShort(i7) : (short) -1;
                if (s3 < 1 || s3 > 12) {
                    Log.isLoggable("DfltImageHeaderParser", 3);
                } else {
                    int i8 = i6 + 4;
                    int i9 = byteBuffer.remaining() - i8 >= 4 ? byteBuffer.getInt(i8) : -1;
                    if (i9 < 0) {
                        Log.isLoggable("DfltImageHeaderParser", 3);
                    } else {
                        Log.isLoggable("DfltImageHeaderParser", 3);
                        int i10 = i9 + b[s3];
                        if (i10 > 4) {
                            Log.isLoggable("DfltImageHeaderParser", 3);
                        } else {
                            int i11 = i6 + 8;
                            if (i11 < 0 || i11 > byteBuffer.remaining()) {
                                Log.isLoggable("DfltImageHeaderParser", 3);
                            } else {
                                if (i10 >= 0 && i10 + i11 <= byteBuffer.remaining()) {
                                    if (byteBuffer.remaining() - i11 >= 2) {
                                        return byteBuffer.getShort(i11);
                                    }
                                    return -1;
                                }
                                Log.isLoggable("DfltImageHeaderParser", 3);
                            }
                        }
                    }
                }
            }
        }
        return -1;
    }

    @Override // a.lw
    public final ImageHeaderParser$ImageType a(ByteBuffer byteBuffer) {
        mk.f(byteBuffer, "Argument must not be null");
        return f(new cd(byteBuffer, 1));
    }

    @Override // a.lw
    public final int b(ByteBuffer byteBuffer, on onVar) {
        cd cdVar = new cd(byteBuffer, 1);
        mk.f(onVar, "Argument must not be null");
        return e(cdVar, onVar);
    }

    @Override // a.lw
    public final ImageHeaderParser$ImageType c(InputStream inputStream) {
        return f(new fb(2, inputStream));
    }

    @Override // a.lw
    public final int d(InputStream inputStream, on onVar) {
        fb fbVar = new fb(2, inputStream);
        mk.f(onVar, "Argument must not be null");
        return e(fbVar, onVar);
    }
}
