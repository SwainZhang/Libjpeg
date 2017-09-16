package com.example.emery.libjpeg;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.text.format.Formatter;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import net.bither.util.BitmapCompressUtil;

import java.io.File;

public class MainActivity extends AppCompatActivity {


    private File mSrcFile;
    private Bitmap mBitmap;
    private TextView mTv_jpeg;
    private TextView mTv_quality;
    private TextView mTv_samplesize;
    private TextView mTv_size;
    private ImageView mIv_jpeg;
    private ImageView mIv_quality;
    private ImageView mIv_sample;
    private ImageView mIv_size;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //来源图片
        mSrcFile = new File(Environment.getExternalStorageDirectory()
                .getAbsolutePath() + "/Download/desk.jpg");

        mBitmap = BitmapFactory.decodeFile(mSrcFile.getAbsolutePath());

        mTv_jpeg = (TextView) findViewById(R.id.file_jpeg_size);
        mTv_quality = (TextView) findViewById(R.id.file_quality_siz);
        mTv_samplesize = (TextView) findViewById(R.id.file_samplszie_size);
        mTv_size = (TextView) findViewById(R.id.file_size_size);

        mIv_jpeg = (ImageView) findViewById(R.id.iv_libjpeg_compress);
        mIv_quality = (ImageView) findViewById(R.id.iv_quality_compress);
        mIv_sample = (ImageView) findViewById(R.id.iv_sample_compress);
        mIv_size = (ImageView) findViewById(R.id.iv_size_compress);


    }

    public void compress(View view) {
        //jpeg压缩
        String distPath = Environment.getExternalStorageDirectory().getAbsolutePath() +
                "/Download/";
        File jpegFile = new File(distPath + "desk_jpeg.jpg");
        if (jpegFile.exists())
            jpegFile.delete();
        Log.i("jpeg压缩目标地址：", jpegFile.getAbsolutePath());
        Log.i("来源地址：", mSrcFile.getAbsolutePath());
        BitmapCompressUtil.compressBitmapByJpeg(mBitmap, jpegFile);
        mIv_jpeg.setImageBitmap(BitmapFactory.decodeFile(jpegFile.getAbsolutePath()));
        mTv_jpeg.setText("jpeg压缩" + Formatter.formatFileSize(this, jpegFile.length()));


        //质量压缩
        File qulityFile = new File(distPath + "desk_quality.jpg");
        if (qulityFile.exists())
            qulityFile.delete();
        Log.i("质量压缩目标地址：", qulityFile.getAbsolutePath());
        Log.i("来源地址：", mSrcFile.getAbsolutePath());
        BitmapCompressUtil.compressBimapByQuality(mBitmap, qulityFile);
        mIv_quality.setImageBitmap(BitmapFactory.decodeFile(qulityFile.getAbsolutePath()));
        mTv_quality.setText("质量压缩" + Formatter.formatFileSize(this, qulityFile.length()));

        //尺寸压缩
        File sizeFile = new File(distPath + "desk_size.jpg");
        if (sizeFile.exists())
            sizeFile.delete();
        Log.i("尺寸压缩目标地址：", qulityFile.getAbsolutePath());
        Log.i("来源地址：", mSrcFile.getAbsolutePath());
        BitmapCompressUtil.compressBitmapBySize(mBitmap, sizeFile);
        mIv_size.setImageBitmap(BitmapFactory.decodeFile(sizeFile.getAbsolutePath()));
        mTv_size.setText("尺寸压缩" + Formatter.formatFileSize(this, sizeFile.length()));

        //采样率压缩
        File sampleFile = new File(distPath + "desk_sample.jpg");
        if (sampleFile.exists())
            sampleFile.delete();
        Log.i("采样率压缩目标地址：", qulityFile.getAbsolutePath());
        Log.i("来源地址：", mSrcFile.getAbsolutePath());
        BitmapCompressUtil.compressBitmapBySamplsize(mSrcFile, sampleFile);
        mIv_sample.setImageBitmap(BitmapFactory.decodeFile(sampleFile.getAbsolutePath()));
        mTv_samplesize.setText("采样率压缩：" + Formatter.formatFileSize(this, sampleFile.length()));

    }
}
