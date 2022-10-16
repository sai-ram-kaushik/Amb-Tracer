package com.example.ambtracer;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.view.View;



public class MapView {

    public void openMapView(View view) {
        Intent launchIntent = getPackageManager().getLaunchIntentForPackage("com.google. android. gms. maps");
        if (launchIntent != null) {
            startActivity(launchIntent);
        }
    }

    private void startActivity(Intent launchIntent) {
        return;
    }

    private PackageManager getPackageManager() {
        return null;
    }
}
