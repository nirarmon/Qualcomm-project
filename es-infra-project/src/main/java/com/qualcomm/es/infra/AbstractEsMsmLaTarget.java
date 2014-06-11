package com.qualcomm.es.infra;

import java.io.File;

import com.qualcomm.targets.le.AbstractLeTarget;
import com.qualcomm.targets.le.enums.LeMode;

public abstract class AbstractEsMsmLaTarget extends AbstractLeTarget {
	
	@Override
	public void init() throws Exception {
		this.mode = LeMode.ADB;
		super.init();
		
	}

	public abstract void provisioning (File privateKey, File SignalPublicKey, File anchorSert, File keyProvTool) throws Exception;
	
}
