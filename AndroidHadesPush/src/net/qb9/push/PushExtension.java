package net.qb9.hades.push;

import android.content.Context;
import android.media.AudioManager;
import android.util.Log;

import com.adobe.fre.FREContext;
import com.adobe.fre.FREExtension;

public class PushExtension implements FREExtension {
	public static final String TAG = "PushExtension";
	
	public static FREContext extensionContext;
	public static Context appContext;

	@Override
	public FREContext createContext(String contextType) {
		return new PushExtensionContext();
	}

	@Override
	public void dispose() {
		Log.d(TAG, "Extension disposed.");
	
		appContext = null;
		extensionContext = null;
	}

	@Override
	public void initialize() {
		Log.d(TAG, "Extension initialized.");
	}
}
