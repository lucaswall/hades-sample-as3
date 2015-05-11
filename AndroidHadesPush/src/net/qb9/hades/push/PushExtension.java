package net.qb9.hades.push;

import android.content.Context;
import android.media.AudioManager;
import android.util.Log;

import com.adobe.fre.FREContext;
import com.adobe.fre.FREExtension;

import net.qb9.hades.GCMHelper;

public class PushExtension implements FREExtension {
	public static final String TAG = "PushExtension";
	
	public static FREContext extensionContext;
	public static Context appContext;
	public static GCMHelper gcmHelper;

	@Override
	public FREContext createContext(String contextType) {
		return new PushExtensionContext();
	}

	@Override
	public void dispose() {
		Log.d(TAG, "Extension disposed.");
	
		appContext = null;
		extensionContext = null;
		gcmHelper = null;
	}

	@Override
	public void initialize() {
		Log.d(TAG, "Extension initialized.");
	}
}
