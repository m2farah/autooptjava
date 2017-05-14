package fr.pji.autooptjava;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;

public class TestCl extends MyClass{
	public ArrayList<String> testArrayList;
	public ArrayList<Double> testArrayList2 = new ArrayList<Double>();
	HashSet<Integer> hs = new HashSet<Integer>();
	
	public TestCl(){
		testArrayList = new ArrayList<String>();
		ArrayList<Integer> arrList = new ArrayList<Integer>();
		
	}
	
	public static ArrayList<Integer> ArList(ArrayList<Integer> arrList3){
		arrList3 = new ArrayList<Integer>();
		ArrayList<Integer> arrList4;
		arrList4 = new ArrayList<Integer>();
		return arrList3;
	}
	
	public static void main(String[] args) {
		try{
			MyClass my = new MyClass();
			TestCl tc = new TestCl();
			CollClass cc = new CollClass();
			ArrayList<Integer> arrList2= new ArrayList<Integer>();
			ArrayList<Integer> arrList3 = ArList(arrList2);
			String testStringClass = new String("Test Spoon - TestCl");
			tc.testArrayList.add(testStringClass);
			for(int i=0; i<tc.testArrayList.size(); i++)
				System.out.println(tc.testArrayList.get(i));
		}catch (Exception e1) {
		}

	}

}
