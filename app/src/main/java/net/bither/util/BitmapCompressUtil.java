package net.bither.util;

import android.graphics.Bitmap;

import java.io.File;

/**
 * Created by emery on 2017/4/11.
 */

public class BitmapCompressUtil {
    /**
     * LibJpeg压缩
     * @param mBitmap 压缩来源文件
     * @param file   压缩后的图片地址
     *
     */
    public static void compressBitmapByJpeg(Bitmap mBitmap, File file) {

        NativeUtil.compressBitmapByJpeg(mBitmap, file.getAbsolutePath());
    }


    /**
     * 质量压缩
     * @param mBitmap 压缩来源文件
     * @param file  压缩后的图片地址
     */
    public static void compressBimapByQuality(Bitmap mBitmap, File file) {
        NativeUtil.compressBimapByQuality(mBitmap, file);
    }

    /**
     * 尺寸压缩
     * @param mBitmap 压缩来源文件
     * @param file 压缩后的图片地址
     */
    public static void compressBitmapBySize(Bitmap mBitmap, File file) {
        NativeUtil.compressBitmapBySize(mBitmap, file);

    }

    /**
     * 采样率压缩
     * @param src  压缩来源文件
     * @param file 压缩后的图片地址
     */
    public static void compressBitmapBySamplsize(File src, File file) {

        NativeUtil.compressBitmapBySamplsize(src.getAbsolutePath(), file);
    }

}
