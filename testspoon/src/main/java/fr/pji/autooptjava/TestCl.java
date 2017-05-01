package fr.pji.autooptjava;

import java.io.IOException;
import java.util.LinkedList;

import fr.pji.autooptjava.MyClass;

public class TestCl extends MyClass{
	public LinkedList<String> testArrayList;
	public TestCl(){
		testArrayList = new LinkedList<String>();
	}
	public static void main(String[] args) {
		try{
		MyClass my = new MyClass();
		TestCl tc = new TestCl();
		tc.testArrayList.add("BismiLLAH");
		for(int i=0; i<tc.testArrayList.size(); i++)
			System.out.println(tc.testArrayList.get(i));
		}catch (Exception e1) {
		}

	}

}
