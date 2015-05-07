package net.qb9.hades.push.functions;

import android.content.Context;
import android.media.AudioManager;

import com.adobe.fre.FREContext;
import com.adobe.fre.FREFunction;
import com.adobe.fre.FREObject;

public class GetTokenFunction implements FREFunction {
	public static final String TAG = "GetTokenFunction";
	
	@Override
	public FREObject call(FREContext context, FREObject[] args) {
		Log.i(TAG, "in GetTokenFunction");
		Context appContext = context.getActivity().getApplicationContext();


		return null;
	}
}
