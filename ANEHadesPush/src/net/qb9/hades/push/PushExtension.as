package net.qb9.hades.push
{
	import flash.events.EventDispatcher;
	import flash.events.StatusEvent;
	import flash.external.ExtensionContext;
	
	public class PushExtension extends EventDispatcher
	{
		
		private static var instance:PushExtension = null;
		public var extContext:ExtensionContext = null;
		
		public static function getInstance():PushExtension {
			if ( instance == null ) instance = new PushExtension(new SingletonEnforcer());
			return instance;
		}
		
		public function PushExtension(enforcer:SingletonEnforcer) {
			log("CONSTRUCTOR");
			if ( !extContext ) {
				log("Creating extension context.");
				extContext = ExtensionContext.createExtensionContext("net.qb9.hades.push", "");
				extContext.addEventListener(StatusEvent.STATUS, statusHandle);
				if (extContext){
					initExtension();
				} else {
					log("Failed to create extension context.");
				}
			}
		}
		
		private function log(msg:*):void{
			trace("[ PushExtension ] " + msg);
		}

		public function getContext():ExtensionContext {
			log("getContext");
			return extContext;
		}
		
		public function statusHandle(e:StatusEvent):void{
			log("statusHandle e.type: "+e.type);
			dispatchEvent(e);
		}
		
		private function initExtension():void {
			log("initExtension");
			extContext.call("init");
		}
		
		public function getToken():String {
			return extContext.call("getToken").toString();
		}
		
	}
}

class SingletonEnforcer {}
