package fr.pji.autooptjava;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;

public class TestCl extends MyClass{
	public LinkedList<String> testArrayList;
	HashSet<Integer> hs = new HashSet<Integer>();
	public TestCl(){
		testArrayList = new LinkedList<String>();
		ArrayList<Integer> arrList = new ArrayList<Integer>();
	}
	
	public static void main(String[] args) {
		try{
		MyClass my = new MyClass();
		TestCl tc = new TestCl();
		CollClass cc = new CollClass();
		String testStringClass = new String("Test Spoon - TestCl");
		tc.testArrayList.add(testStringClass);
		for(int i=0; i<tc.testArrayList.size(); i++)
			System.out.println(tc.testArrayList.get(i));
		}catch (Exception e1) {
		}

	}

}
