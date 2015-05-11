package net.qb9.hades.push;

import java.util.HashMap;
import java.util.Map;

import net.qb9.hades.push.functions.InitFunction;
import net.qb9.hades.push.functions.GetTokenFunction;

import android.util.Log;

import com.adobe.fre.FREContext;
import com.adobe.fre.FREFunction;

public class PushExtensionContext extends FREContext {
	public static final String TAG = "PushExtensionContext";
	
	@Override
	public void dispose() {
		Log.d(TAG,"Context disposed.");
	}

	@Override
	public Map<String, FREFunction> getFunctions() {
		Map<String, FREFunction> functions = new HashMap<String, FREFunction>();
		
		functions.put("init", new InitFunction());
		functions.put("getToken", new GetTokenFunction());
		
		return functions;
	}
}
