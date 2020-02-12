import lejos.hardware.Audio;
import lejos.hardware.Key;
import lejos.hardware.Keys;
import lejos.hardware.LED;
import lejos.hardware.LocalBTDevice;
import lejos.hardware.LocalWifiDevice;
import lejos.hardware.Power;
import lejos.hardware.lcd.Font;
import lejos.hardware.lcd.GraphicsLCD;
import lejos.hardware.lcd.TextLCD;
import lejos.hardware.port.Port;
import lejos.hardware.video.Video;

public class MockBrick implements Mock{

	public Port getPort(String portName) {
		// TODO Auto-generated method stub
		return null;
	}

	public Power getPower() {
		// TODO Auto-generated method stub
		return null;
	}

	public Audio getAudio() {
		// TODO Auto-generated method stub
		return null;
	}

	public Video getVideo() {
		// TODO Auto-generated method stub
		return null;
	}

	public TextLCD getTextLCD() {
		// TODO Auto-generated method stub
		return null;
	}

	public TextLCD getTextLCD(Font f) {
		// TODO Auto-generated method stub
		return null;
	}

	public GraphicsLCD getGraphicsLCD() {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean isLocal() {
		// TODO Auto-generated method stub
		return false;
	}

	public String getType() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}

	public LocalBTDevice getBluetoothDevice() {
		// TODO Auto-generated method stub
		return null;
	}

	public LocalWifiDevice getWifiDevice() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setDefault() {
		// TODO Auto-generated method stub
		
	}

	public Keys getKeys() {
		// TODO Auto-generated method stub
		return null;
	}

	public Key getKey(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	public LED getLED() {
		// TODO Auto-generated method stub
		return null;
	}

}