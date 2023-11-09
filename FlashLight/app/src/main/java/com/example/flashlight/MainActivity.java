package com.example.flashlight;

import static android.content.ContentValues.TAG;

import android.content.Context;
import android.content.pm.PackageManager;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraManager;
import android.os.Bundle;
import android.util.Log;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private Switch flash;
    private CameraManager cameraManager;

    private TextView tv2;
    private boolean flashlightOn = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        flash = findViewById(R.id.flashSwitch);
        cameraManager = (CameraManager) getSystemService(Context.CAMERA_SERVICE);
        tv2 = findViewById(R.id.tv2);


        if (!getPackageManager().hasSystemFeature(PackageManager.FEATURE_CAMERA_FLASH)) {
            // Disable the toggle button if there is no camera flash
            flash.setEnabled(false);
            return;
        }

        flash.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    turnOnFlashlight();
                    tv2.setText("ON");
                } else {
                    turnOffFlashlight();
                    tv2.setText("OFF");
                }
            }
        });
    }

    @Override
    protected void onPause() {
        super.onPause();
        turnOffFlashlight();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        turnOffFlashlight();
    }

    private void turnOnFlashlight() {
        try {
            String cameraId = cameraManager.getCameraIdList()[0];
            cameraManager.setTorchMode(cameraId, true);
            flashlightOn = true;
        } catch (CameraAccessException e) {
            Log.d(TAG, e.getMessage());
        }
    }

    private void turnOffFlashlight() {
        try {
            String cameraId = cameraManager.getCameraIdList()[0];
            cameraManager.setTorchMode(cameraId, false);
            flashlightOn = false;
        } catch (CameraAccessException e) {
            e.getMessage();
            Log.d(TAG, e.getMessage());
        }
    }
}
