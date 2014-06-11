package com.qualcomm.es.tests;

import java.io.File;

import junit.framework.SystemTestCase4;

import org.junit.Before;
import org.junit.Test;

import com.qualcomm.es.infra.AbstractEsMsmLaTarget;

public class TqsOperations extends SystemTestCase4 {
	//Systme Objects
	private AbstractEsMsmLaTarget la8974Ttarget;
	//Paramters
	private File privateKey;
	private File SignalPublicKey;
	private File anchorSert;
	private File keyProvTool;
	


	@Before 
	public void init() throws Exception{
		la8974Ttarget = (AbstractEsMsmLaTarget) system.getSystemObject("target");
	}
	
	@Test
	public void doProvisioning() throws Exception{
		la8974Ttarget.provisioning(privateKey, SignalPublicKey, anchorSert, keyProvTool);
	}

	public File getPrivateKey() {
		return privateKey;
	}

	public void setPrivateKey(File privateKey) {
		this.privateKey = privateKey;
	}

	public File getSignalPublicKey() {
		return SignalPublicKey;
	}

	public void setSignalPublicKey(File signalPublicKey) {
		SignalPublicKey = signalPublicKey;
	}

	public File getAnchorSert() {
		return anchorSert;
	}

	public void setAnchorSert(File anchorSert) {
		this.anchorSert = anchorSert;
	}

	public File getKeyProvTool() {
		return keyProvTool;
	}

	public void setKeyProvTool(File keyProvTool) {
		this.keyProvTool = keyProvTool;
	}

}
