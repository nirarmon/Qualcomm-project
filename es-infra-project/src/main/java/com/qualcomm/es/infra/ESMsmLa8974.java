package com.qualcomm.es.infra;

import java.io.File;

import jsystem.framework.IgnoreMethod;

import com.qualcomm.targets.le.AbstractLeTarget;

public class ESMsmLa8974 extends AbstractEsMsmLaTarget{
	
	@Override
	
	public void init() throws Exception {
		super.init();
	}

	public void provisioning (File privateKey, File SignalPublicKey, File anchorSert, File keyProvTool) throws Exception{
		//push all files to device
		device.pushFileToDevice(privateKey.getAbsolutePath(), "");
		device.pushFileToDevice(SignalPublicKey.getAbsolutePath(), "");
		device.pushFileToDevice(anchorSert.getAbsolutePath(), "");
		device.pushFileToDevice(keyProvTool.getAbsolutePath(), "");
		device.executeShellCommand("rm -rf /data/tqs");
		device.executeShellCommand("/presist/tqs");
		//reboot and wait for device to connect
		reboot();
		//run keyProvTools
		//ADB ROOT? 
		device.executeShellCommand("./keyProvTools .... ");
	}
	
	
	
}
