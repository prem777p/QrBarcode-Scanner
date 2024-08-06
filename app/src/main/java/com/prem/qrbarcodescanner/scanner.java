package com.prem.qrbarcodescanner;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;
import com.google.zxing.ResultPoint;
import com.journeyapps.barcodescanner.BarcodeCallback;
import com.journeyapps.barcodescanner.BarcodeResult;
import com.journeyapps.barcodescanner.DecoratedBarcodeView;

import java.util.List;

public class scanner extends AppCompatActivity {


    private DecoratedBarcodeView barcodeView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scanner);

        barcodeView = findViewById(R.id.barcodeView);
        startScanning();
    }

    private void startScanning() {
        barcodeView.resume();
        barcodeView.decodeSingle(new BarcodeCallback() {
            @Override
            public void barcodeResult(BarcodeResult result) {
                handleScannedResult(result.getText());
            }

            @Override
            public void possibleResultPoints(List<ResultPoint> resultPoints) {
            }
        });
    }

    private void handleScannedResult(String resultText) {
        // Process the result as needed
        MainActivity.resultTextView.setText(resultText);
        finish();
    }

    @Override
    protected void onPause() {
        super.onPause();
        barcodeView.pause();
    }
}