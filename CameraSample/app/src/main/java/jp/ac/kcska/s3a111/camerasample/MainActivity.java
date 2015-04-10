package jp.ac.kcska.s3a111.camerasample;

import android.app.Activity;
import android.hardware.Camera;
import android.os.Bundle;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.widget.Toast;

import java.io.IOException;


public class MainActivity extends Activity {
    private SurfaceView mSurfaceView;
    private Camera mCamera;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //SurfaceView
        mSurfaceView = (SurfaceView)findViewById(R.id.surfaceView);
        mSurfaceView.setOnClickListener(onSurfaceClickListener);
        //SurfaceHolder
        SurfaceHolder mSurfaceHolder = mSurfaceView.getHolder();
        mSurfaceHolder.addCallback(callback);

    }

    private SurfaceHolder.Callback callback = new SurfaceHolder.Callback() {
        @Override
        public void surfaceCreated(SurfaceHolder holder) {
            mCamera = Camera.open();
            try{
                mCamera.setPreviewDisplay(holder);
            }catch (IOException e){
                throw new RuntimeException(e);
            }
        }

        @Override
        public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
            mCamera.startPreview();
        }

        @Override
        public void surfaceDestroyed(SurfaceHolder holder) {
            mCamera.release();
            mCamera = null;
        }
    };

    private View.OnClickListener onSurfaceClickListener
            = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if(mCamera != null){
                //AutoFocus実行
                mCamera.autoFocus(autoFocusCallBack);
            }
        }
    };

    private Camera.AutoFocusCallback autoFocusCallBack
            = new Camera.AutoFocusCallback() {
        @Override
        public void onAutoFocus(boolean success, Camera camera) {
            mCamera.setOneShotPreviewCallback(previewCallBack);
        }
    };

    private Camera.PreviewCallback previewCallBack
            = new Camera.PreviewCallback() {
        @Override
        public void onPreviewFrame(byte[] data, Camera camera) {
            Toast.makeText(getApplicationContext(),"Set Focus And Triming",Toast.LENGTH_SHORT).show();
        }
    };
}
