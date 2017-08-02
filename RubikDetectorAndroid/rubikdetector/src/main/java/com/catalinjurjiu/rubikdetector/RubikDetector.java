package com.catalinjurjiu.rubikdetector;

import android.util.Log;

import org.opencv.core.Mat;

import java.util.Arrays;

/**
 * Created by catalin on 11.07.2017.
 */

public class RubikDetector {

    static {
        System.loadLibrary("native_processing");
    }

    private OnCubeDetectionResultListener listener;

    public RubikDetector() {
        //TODO create native object
    }

    private native void findCubeNative(long addrRgba);

    private native byte[] findCubeNative2(byte[] imageData, int width, int height);

    public void setOnCubeDetectionResultListener(OnCubeDetectionResultListener onCubeDetectionResultListener) {
        this.listener = onCubeDetectionResultListener;
    }

    public void findCube(int addrRgba) {
        findCubeNative(addrRgba);
    }

    public byte[] findCube2(byte[] imageData, int width, int height) {
        return findCubeNative2(imageData, width, height);
    }

    public void findCube(Mat mat) {
        findCubeNative(mat.getNativeObjAddr());
    }

    public void onFacetColorsDetected(int[] faceletColors) {
        Log.d("Cata", "####Facelets discovered!!!!!!" + Arrays.toString(faceletColors));
    }

    public interface OnCubeDetectionResultListener {
        void onCubeDetectionResult();
    }

}