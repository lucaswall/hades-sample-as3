package
{
	import flash.display.Sprite;
	import flash.display.StageAlign;
	import flash.display.StageScaleMode;
	import flash.events.Event;
	import flash.geom.Rectangle;
	import flash.text.StageText;
	import flash.text.TextField;
	import flash.text.TextFieldAutoSize;
	import flash.text.TextFormat;
	import flash.events.MouseEvent;
	
	public class NotifSampleAS3 extends Sprite
	{
		
		private var input:StageText;
		
		public function NotifSampleAS3()
		{
			super();
			
			// support autoOrients
			stage.align = StageAlign.TOP_LEFT;
			stage.scaleMode = StageScaleMode.NO_SCALE;
			
			addEventListener(flash.events.Event.ADDED_TO_STAGE, onAdded);
			
		}
		
		public function onAdded(e:Event):void {
			
			input = new StageText();
			input.stage = stage;
			input.text = "USER";
			input.fontSize = 48;
			input.editable = true;
			input.viewPort = new Rectangle(10, 10, stage.stageWidth - 20, 60);
			
			var format:TextFormat = new TextFormat();
			format.size = 48;
			
			var text:TextField = new TextField();
			text.text = "LOGIN";
			text.backgroundColor = 0xedd413;
			text.background = true;
			text.x = 120;
			text.y = 80;
			text.autoSize = TextFieldAutoSize.CENTER;
			text.selectable = false;
			text.setTextFormat(format);
			stage.addChild(text);
			text.addEventListener(MouseEvent.CLICK, onLogin);
			
		}
		
		public function onLogin(e:Event):void {
			trace("Clicked on login!");
		}
		
	}
}