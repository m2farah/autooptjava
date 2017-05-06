package fr.pji.autooptjava.spoonProcessors.test;

import java.util.Collection;
import java.util.concurrent.atomic.AtomicInteger;

import org.apache.log4j.Level;

import spoon.processing.AbstractProcessor;
import spoon.reflect.code.CtCodeSnippetExpression;
import spoon.reflect.code.CtCodeSnippetStatement;
import spoon.reflect.code.CtConstructorCall;
import spoon.reflect.code.CtExpression;
import spoon.reflect.declaration.CtClass;

public class ArrayListToLinkedList extends AbstractProcessor<CtConstructorCall<java.util.Collection<?>>>{
	private static AtomicInteger countClass = new AtomicInteger(0);
	private String mesg;
	private Class<?> cls;
	private String fullName; // store temporarily "packageName+className" of the class that we work with it.
	private String className;
	private String packageName;
	
	public void process(CtConstructorCall<java.util.Collection<?>> element) {
		// TODO get a manner to convert all the instruction, i.g ArrayList<?> al = new ArrayList<>() must become LinkedList al = new LinkedList<>()
		try {
			this.className = element.getType().getSimpleName();
			if (className.equals("ArrayList")){
//				CtCodeSnippetStatement snippet = element.getType().getFactory().Core().createCodeSnippetStatement();
//				snippet.setValue("LinkedList");
//				element.getType().replace(snippet);
//				CtCodeSnippetExpression snippet = element.getType().getFactory().Core().createCodeSnippetExpression();
//				snippet.setValue("LinkedList");
//				Ct
//				element.getType().setSimpleName("LinkedList");
//				CtExpression cte = getFactory().createCodeSnippetExpression();
//				if (element.getType().hasParent(cte)){
//					System.out.println("He has CtExpression (parent)");
//				}
			}
			this.packageName = element.getType().getPackage().getSimpleName();
			this.fullName = this.packageName+"."+this.className ;
			this.cls = Class.forName(fullName);
			if (Collection.class.isAssignableFrom(cls)){
				// If instance of collection
//				this.mesg= "\n================= "+countClass.incrementAndGet()+" Collection Type \""+this.fullName+"\" found"+"==========\n";
//				this.getFactory().getEnvironment().report(this, Level.INFO, element, mesg);
			}
		} catch (ClassNotFoundException e) {
			
		} catch (NullPointerException npe) {
			
		}
		
	}
}
