package net.qb9.hades.push.functions;

import net.qb9.hades.push.PushExtension;
import android.content.Context;
import android.os.Handler;
import android.provider.Settings.System;
import android.util.Log;

import com.adobe.fre.FREContext;
import com.adobe.fre.FREFunction;
import com.adobe.fre.FREObject;

import net.qb9.hades.GCMHelper;

public class InitFunction implements FREFunction {
	public static final String TAG = "InitFunction";
	
	@Override
	public FREObject call(FREContext context, FREObject[] args) {
		Log.i(TAG, "in init");
		PushExtension.extensionContext = context;
		Context appContext = context.getActivity().getApplicationContext();
		PushExtension.appContext = appContext;

		PushExtension.gcmHelper = new GCMHelper(appContext,
				context.getActivity().getSharedPreferences(PushExtension.class.getSimpleName(),
				Context.MODE_PRIVATE));
		PushExtension.gcmHelper.init();

		return null;
	}
}
