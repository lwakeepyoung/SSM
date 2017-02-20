package test;

import java.io.UnsupportedEncodingException;

public class Test {
	public static void main(String[] args) throws UnsupportedEncodingException {
//		Runnable runnable = () -> {System.out.println(Thread.class.getName());};
//		new Thread(runnable).start();
		
		//System.out.println(new String("aa".getBytes(), "utf-8"));
		new It() {
		}.getName();
	}
}