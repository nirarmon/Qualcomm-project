package com.qualcomm.targets.le;

import jsystem.framework.IgnoreMethod;

import org.jsystemtest.mobile.core.AdbController;
import org.jsystemtest.mobile.core.AdbControllerException;
import org.jsystemtest.mobile.core.device.USBDevice;

import com.aqua.sysobj.conn.CliCommand;
import com.aqua.sysobj.conn.LinuxDefaultCliConnection;
import com.qualcomm.targets.AbstractQualcommTarget;
import com.qualcomm.targets.le.enums.LeMode;

public class AbstractLeTarget extends AbstractQualcommTarget {

	protected LinuxDefaultCliConnection cli;
	protected AdbController adb;
	protected USBDevice device;
	protected LeMode mode;
	protected String deviceId;

	@Override
	@IgnoreMethod
	public void init() throws Exception {
		super.init();
		if (mode == LeMode.ADB) {
			adb = AdbController.getInstance();
			device = adb.waitForDevicesToConnect(1)[0];
			deviceId = device.getSerialNumber();
		}

	}

	public String executeCliCommand(String command) throws Exception {
		switch (mode) {
		case ADB:
			return device.executeShellCommand(command);
		case CLI:
			cli.handleCliCommand("", new CliCommand(command));
			return cli.getTestAgainstObject().toString();
		default:
			return null;
		}
	}

	
	public void reboot() throws Exception{
		device.reboot();
		device = adb.waitForDeviceToConnect(deviceId);
	}
}
