package uk.co.sustaination;

import org.acra.*;
import org.acra.annotation.*;
import android.app.Application;

@ReportsCrashes(formKey = "dGVmVWFnMDNVSlJSd014ZWt6dkw5a2c6MQ",
        mode = ReportingInteractionMode.TOAST,
        resToastText = R.string.crash_toast_text) 
public class SustainationApplication extends Application {

    @Override
    public void onCreate() {
        ACRA.init(this);
        super.onCreate();
    }
    
}
