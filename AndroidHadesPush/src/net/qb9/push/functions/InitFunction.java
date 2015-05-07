package net.qb9.hades.push.functions;

import net.qb9.hades.push.PushExtension;
import android.content.Context;
import android.os.Handler;
import android.provider.Settings.System;
import android.util.Log;

import com.adobe.fre.FREContext;
import com.adobe.fre.FREFunction;
import com.adobe.fre.FREObject;

public class InitFunction implements FREFunction {
	public static final String TAG = "InitFunction";
	
	@Override
	public FREObject call(FREContext context, FREObject[] args) {
		Log.i(TAG, "in init");
		PushExtension.extensionContext = context;
		Context appContext = context.getActivity().getApplicationContext();
		PushExtension.appContext = appContext;


		return null;
	}
}
