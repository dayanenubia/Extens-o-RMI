package br.edu.ifsuldeminas.mch.sd.rmi.remote;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface Operations extends Remote {
	Number sum(Number x, Number y) throws RemoteException;

	Number sub(Number x, Number y) throws RemoteException;
	
	Number root(Number x, int y) throws RemoteException;
	
	Number percentage(Number x, Number y) throws RemoteException;
	
	Number mod(Number x, Number y) throws RemoteException;
	
	Number factorial(Number x) throws RemoteException;
	
	Number power(Number x, int y) throws RemoteException;

	Number mul(Number x, Number y) throws RemoteException;

	Number div(Number x, Number y) throws RemoteException;
	

	List<String> lastOperations(int howMany) throws RemoteException;

	List<String> lastOperations() throws RemoteException;
}