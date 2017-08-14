package com.tesis.tse.tse_instructivojrv;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.ContentResolver;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Point;
import android.graphics.Rect;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import java.io.FileDescriptor;
import java.io.IOException;

public class ActivityViewImage extends AppCompatActivity {

    ImageView mImageView;
    PinchZoomImageView mPinchZoomImageView;
    private Uri mImageUri;
    private Animator mCurrentAnimator;
    private int mLongAnimationDuration;
    int imagen;
    private static final int REQUEST_OPEN_RESULT_CODE = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_image);

        Bundle datos = this.getIntent().getExtras();
        Integer id_imagen_actividad = datos.getInt("imagen_actividad");

        mImageView = (ImageView) findViewById(R.id.imageView);
        mPinchZoomImageView = (PinchZoomImageView) findViewById(R.id.pinchZoomImageView);

        mImageView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                // Toast.makeText(getApplicationContext(), "ImageView long pressed!", Toast.LENGTH_SHORT).show();
                // zoomImageFromThumb();
                //pinchZoomPan();
                return true;
            }
        });

        Glide.with(this).load(id_imagen_actividad).into(mImageView);
        Uri imageUri = Uri.parse(ContentResolver.SCHEME_ANDROID_RESOURCE +
                "://" + getResources().getResourcePackageName(id_imagen_actividad)
                + '/' + getResources().getResourceTypeName(id_imagen_actividad) + '/' + getResources().getResourceEntryName(id_imagen_actividad) );
        mImageUri = imageUri;
        pinchZoomPan();
        mLongAnimationDuration = getResources().getInteger(android.R.integer.config_longAnimTime);
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);

        View decorView = getWindow().getDecorView();
        if(hasFocus) {
            decorView.setSystemUiVisibility(
                    View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                            | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                            | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                            | View.SYSTEM_UI_FLAG_FULLSCREEN
                            | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                            | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
            );
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent resultData) {
        if(requestCode == REQUEST_OPEN_RESULT_CODE && resultCode == RESULT_OK) {
            if(resultData != null) {
                imagen = getResources().getIdentifier("cierre", "drawable",this.getPackageName());
                Uri imageUri = Uri.parse(ContentResolver.SCHEME_ANDROID_RESOURCE +
                        "://" + getResources().getResourcePackageName(imagen)
                        + '/' + getResources().getResourceTypeName(imagen) + '/' + getResources().getResourceEntryName(imagen) );
                mImageUri = resultData.getData();
                mImageUri = imageUri;
                Log.e("ResultData",resultData.getData()+"");
                Log.e("LoTengo",imageUri+"");
                /*
                try {
                    Bitmap bitmap = getBitmapFromUri(uri);
                    mImageView.setImageBitmap(bitmap);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                */
                Glide.with(this).load(imagen).into(mImageView);
                /*Glide.with(this)
                        .load(mImageUri)
                        .into(mImageView);*/
            }
        }
    }

    private Bitmap getBitmapFromUri(Uri uri) throws IOException {
        ParcelFileDescriptor parcelFileDescriptor = getContentResolver().openFileDescriptor(uri, "r");
        FileDescriptor fileDescriptor = parcelFileDescriptor.getFileDescriptor();
        Bitmap bitmap = BitmapFactory.decodeFileDescriptor(fileDescriptor);
        parcelFileDescriptor.close();
        return bitmap;
    }

    private void pinchZoomPan() {
        mPinchZoomImageView.setImageUri(mImageUri);
        mImageView.setAlpha(0.f);
        mPinchZoomImageView.setVisibility(View.VISIBLE);
    }
}
