package com.example.perfectpushup.customviews;

import android.app.Activity;
import android.content.Context;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CameraManager;
import android.media.MediaRecorder;
import android.util.AttributeSet;
import android.util.Size;
import android.view.SurfaceView;
import android.view.SurfaceHolder;

import java.io.File;

public class CustomCameraView extends SurfaceView implements SurfaceHolder.Callback {

    private static final String TAG = "CustomCameraView";

    private static final String VIDEO_STORE_DIR = "PerfectPushUp";
    private SurfaceHolder surfaceHolder;
    private CameraDevice cameraDevice;
    private CameraCaptureSession captureSession;
    private CameraManager cameraManager;
    private String cameraId;

    private MediaRecorder recorder;
    private Size videoSize;
    private boolean isRecordingVideo;

    private File file;
    private Context context;

    public CustomCameraView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;

        surfaceHolder = getHolder();
        surfaceHolder.addCallback(this);
    }

    @Override
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i1, int i2) {

    }

    @Override
    public void surfaceCreated(SurfaceHolder surfaceHolder) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {

    }

    private void openCamera(int height, int width){
        cameraManager = (CameraManager) this.context.getSystemService(Context.CAMERA_SERVICE);
        try {
            if (cameraManager != null) {
                cameraId = cameraManager.getCameraIdList()[0];
            }
            if(cameraManager == null || cameraId == null) {
                throw new RuntimeException("Could not open camera.");
            }

            // Front Camera
            cameraId = cameraManager.getCameraIdList()[0];
            CameraCharacteristics characteristics =
                    cameraManager.getCameraCharacteristics(cameraId);

        } catch (CameraAccessException e) {
            e.printStackTrace();
        }



    }
}
