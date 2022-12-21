package com.lec.ex03_speakertv;

public class TestMain {
	public static void main(String[] args) {
		Ivolume speaker = new Speaker();
		Ivolume tv = new TV();
		Ivolume[] devices = {speaker, tv};
		for(Ivolume device :devices) {
			
			device.volumeDown();
			device.volumeDown(50);
			device.volumeUp(30);
			device.setMute(true);
			device.setMute(false);
			
		}
		speaker.setMute(true);
		Ivolume.changeBattery();
	}
}
