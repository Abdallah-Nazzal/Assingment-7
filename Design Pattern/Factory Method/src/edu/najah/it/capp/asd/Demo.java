package edu.najah.it.capp.asd;

import edu.najah.it.capp.asd.constants.ConnectionType;
import edu.najah.it.capp.asd.impl.Ftp;
import edu.najah.it.capp.asd.intf.Protocol;
import edu.najah.it.capp.asd.service.Connection;
import edu.najah.it.capp.exception.ConnectionIsBusyException;
import edu.najah.it.capp.exception.ConnectionIsReleasedException;
import edu.najah.it.capp.exception.NoConnectionAvaliable;
import edu.najah.it.capp.exception.ProtocolException;
import edu.najah.it.capp.exception.SystemIsBusy;
import edu.najah.it.capp.exception.TimeOutError;
import edu.najah.it.capp.exception.UnknownErrorException;
import edu.najah.it.capp.logger.Logger;

public class Demo {

	public static void main(String[] args) throws ProtocolException {

		Logger.getInstance().logInfo("This is a info message");
		Logger.getInstance().logDebug("This is a debug message");
		Logger.getInstance().logWarning("This is a warning message");
		Logger.getInstance().logError("This is a error message");

		Protocol ssh = Connection.getInstance(ConnectionType.SSH);
		Protocol ssh2 = Connection.getInstance(ConnectionType.SSH);
		Protocol telnet = Connection.getInstance(ConnectionType.TELNET);
		Protocol scp = Connection.getInstance(ConnectionType.SCP);
		Protocol ftp = Connection.getInstance(ConnectionType.FTP);

		if (ssh == ssh2) {
			System.out.println(" ssh is equal to ssh2");
		}
		try {
			ssh.send(" testing ssh ");
			telnet.send("Testing telnet ");
			scp.send("Testing scp");
		} catch (NoConnectionAvaliable e) {
			System.out.println("No Connection is avaliable: " + e.getMessage());
			e.printStackTrace();
		} catch (TimeOutError e) {
			System.out.println("Time out error: " + e.getMessage());
			e.printStackTrace();
		} catch (SystemIsBusy e) {
			System.out.println("System is busy: " + e.getMessage());
			e.printStackTrace();
		} catch (ProtocolException e) {
			System.out.println("Protocol Exception: " + e.getMessage());
			e.printStackTrace();
		}

		System.out.println(Connection.getCurrentConnections());
		try {
			Connection.release(ConnectionType.SSH);
		} catch (ConnectionIsReleasedException e) {
			System.out.println("Connection is released: " + e.getMessage());
			e.printStackTrace();
		} catch (UnknownErrorException e) {
			System.out.println("Unknown erorr: " + e.getMessage());
			e.printStackTrace();
		} catch (ConnectionIsBusyException e) {
			System.out.println("Connection is busy: " + e.getMessage());
			e.printStackTrace();
		} catch (ProtocolException e) {
			System.out.println("Protocol Exception: " + e.getMessage());
			e.printStackTrace();
		}

		System.out.println(Connection.getCurrentConnections());

		ftp = Connection.getInstance(ConnectionType.FTP);
		System.out.println(Connection.getCurrentConnections());

		ssh = Connection.getInstance(ConnectionType.SSH);
		ftp = Connection.getInstance(ConnectionType.FTP);
		ftp = Connection.getInstance(ConnectionType.FTP);

		ftp = Connection.getInstance(ConnectionType.FTP);
		try {
			ftp.send("Testing FTP");
		} catch (NoConnectionAvaliable e) {
			System.out.println("No Connection is avaliable: " + e.getMessage());
			e.printStackTrace();
		} catch (TimeOutError e) {
			System.out.println("Time out error: " + e.getMessage());
			e.printStackTrace();
		} catch (SystemIsBusy e) {
			System.out.println("System is busy: " + e.getMessage());
			e.printStackTrace();
		} catch (ProtocolException e) {
			System.out.println("Protocol Exception: " + e.getMessage());
			e.printStackTrace();
		}
		Connection.release(ConnectionType.FTP);

		Protocol tftp = Connection.getInstance(ConnectionType.TFTP);
		Protocol tftp2 = Connection.getInstance(ConnectionType.TFTP);
		System.out.println(Connection.getCurrentConnections());
		if (tftp == tftp2) {
			System.out.println("Same object");
		}
		try {
			tftp.send("test the TFTP ");
			tftp2.send("test the TFTP ");
		} catch (NoConnectionAvaliable e) {
			System.out.println("No Connection is avaliable: " + e.getMessage());
			e.printStackTrace();
		} catch (TimeOutError e) {
			System.out.println("Time out error: " + e.getMessage());
			e.printStackTrace();
		} catch (SystemIsBusy e) {
			System.out.println("System is busy: " + e.getMessage());
			e.printStackTrace();
		} catch (ProtocolException e) {
			System.out.println("Protocol Exception: " + e.getMessage());
			e.printStackTrace();
		}

		// ftp = Ftp.getInsatnce();
		/// Connection.release(ConnectionType.TFTP);
		System.out.println(Connection.getCurrentConnections());// 3
		System.out.println("FTP is not a null");
		try {
			ftp.send(" breaking the logic ");
		} catch (NoConnectionAvaliable e) {
			System.out.println("No Connection is avaliable: " + e.getMessage());
			e.printStackTrace();
		} catch (TimeOutError e) {
			System.out.println("Time out error: " + e.getMessage());
			e.printStackTrace();
		} catch (SystemIsBusy e) {
			System.out.println("System is busy: " + e.getMessage());
			e.printStackTrace();
		} catch (ProtocolException e) {
			System.out.println("Protocol Exception: " + e.getMessage());
			e.printStackTrace();
		}
	}

}
