package fr.pji.autooptjava.spoonProcessors.test;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import org.apache.log4j.Level;

import spoon.processing.AbstractProcessor;
import spoon.reflect.code.CtAssignment;
import spoon.reflect.code.CtCodeSnippetExpression;
import spoon.reflect.code.CtCodeSnippetStatement;
import spoon.reflect.code.CtConstructorCall;
import spoon.reflect.code.CtExpression;
import spoon.reflect.code.CtLocalVariable;
import spoon.reflect.code.CtStatement;
import spoon.reflect.code.CtTypeAccess;
import spoon.reflect.code.CtVariableWrite;
import spoon.reflect.code.CtComment;
import spoon.reflect.declaration.CtClass;
import spoon.reflect.declaration.CtField;
import spoon.reflect.declaration.CtMethod;
import spoon.reflect.declaration.CtType;
import spoon.reflect.declaration.CtTypeMember;
import spoon.reflect.declaration.CtVariable;
import spoon.reflect.reference.CtExecutableReference;
import spoon.reflect.reference.CtTypeReference;
import spoon.reflect.visitor.filter.TypeFilter;

public class ArrayListToLinkedList extends AbstractProcessor<CtConstructorCall<java.util.Collection<?>>> {
	private static AtomicInteger countClass = new AtomicInteger(0);
	private String mesg;
	private Class<?> cls;
	private String fullName; // store temporarily "packageName+className" of the
								// class that we work with it.
	private String className;
	private String packageName;

	@SuppressWarnings("unchecked")
	public void process(CtConstructorCall<java.util.Collection<?>> element) {
		// TODO get a manner to convert all the instruction, 
		//i.g ArrayList<?> al  = new ArrayList<>() must become LinkedList al = new LinkedList<>()
		try {
			this.className = element.getType().getSimpleName();
			this.packageName = element.getType().getPackage().getSimpleName();
			this.fullName = this.packageName+"."+this.className ;
			this.cls = Class.forName(fullName);
			if (Collection.class.isAssignableFrom(cls)) {
				
				if (className.equals("ArrayList")) {
//					CtCodeSnippetStatement snippet = getFactory().Core().createCodeSnippetStatement();
					// snippet.setValue("LinkedList lls = new LinkedList<Integer>()");
//					snippet.setValue(element.toString().replaceFirst("ArrayList", "LinkedList"));
					// element.getParent().replace(snippet);
//					getEnvironment().setAutoImports(true); 
					// import necessary package for LinkedList, Integer, ...
					
					/*Firstly, change constructor call Type*/
//					CtTypeReference<?> constructorType = this.getFactory().Type().createReference(element.getType().toString().replaceFirst("ArrayList<", "LinkedList<"));
//					element.getType().replace(constructorType);
					/*And then the variable that store de object*/
					if (element.getParent(CtField.class) != null) {
						CtTypeReference<?> constructorType = this.getFactory().Type().createReference(element.getType().toString().replaceFirst("ArrayList<", "LinkedList<"));
						element.getType().replace(constructorType);
//						CtCodeSnippetStatement snippet = getFactory().Core().createCodeSnippetStatement();
						CtTypeReference<?> fieldType = this.getFactory().Type().createReference(element.getParent(CtField.class).getType().toString().replaceFirst("ArrayList<", "LinkedList<"));
						System.out.println("\n\n ======TRUE "+element.toString()+","+element.getParent(CtField.class).getType().toString()+" \n"+element.getParent(CtField.class).toString().replaceFirst("ArrayList<", "LinkedList<")+"\n");
//						snippet.setValue(element.getParent(CtField.class).toString().replaceAll("ArrayList<", "LinkedList<"));
//						element.getParent(CtField.class).replace(snippet);
//						element.getParent(CtField.class).setType("");
//						element.getParent(CtField.class).getType().replace(ctf);
						element.getParent(CtField.class).setType(fieldType);
						
					} else if (element.getParent(CtLocalVariable.class) != null) {
						CtTypeReference<?> constructorType = this.getFactory().Type().createReference(element.getType().toString().replaceFirst("ArrayList<", "LinkedList<"));
						element.getType().replace(constructorType);
						CtTypeReference<?> variableType = this.getFactory().Type().createReference(element.getParent(CtLocalVariable.class).getType().toString().replaceFirst("ArrayList<", "LinkedList<"));
//						snippet.setValue(element.getParent(CtStatement.class).toString().replaceAll("ArrayList<", "LinkedList<"));
//						element.getParent(CtStatement.class).replace(snippet);
						element.getParent(CtLocalVariable.class).setType(variableType);
					} else if (element.getParent(CtAssignment.class) != null) {

					}

					// List<CtLocalVariable> var =
					// element.getParent().getElements(new
					// TypeFilter(CtLocalVariable.class));
					// List<CtLocalVariable> var =
					// element.getParent(CtLocalVariable.class).getElements(new
					// TypeFilter(CtLocalVariable.class));
					// if (var==null)
					// return;
					// for (CtLocalVariable ctvar : var) {
					// this.getFactory().getEnvironment().report(this,
					// Level.INFO, element, "\n\n>>>>>FORTEST
					// "+countClass.incrementAndGet()+":"+ctvar.toString());
					// }
					this.getFactory().getEnvironment().report(this, Level.INFO, element,
							"\n\n>>>>>FORTEST" + countClass.incrementAndGet() + " : "
									+ element.getParent(CtLocalVariable.class).toString());// .filterChildren(new
																							// TypeFilter(CtVariableWrite.class)).toString());
					// CtCodeSnippetExpression snippet =
					// element.getType().getFactory().Core().createCodeSnippetExpression();
					// snippet.setValue("new
					// java.util.ArrayList<java.lang.Integer>()");
					// element.getParent().replace(snippet);
					// CtTypeReference<java.util.Collection<?>> tr1 =
					// getFactory().createCtTypeReference(Class.forName("java.util.LinkedList"));
					// element.setType(tr1);
					// element.updateAllParentsBelow();
					// element.getParent().replace(snippet);

					// CtExpression cte =
					// getFactory().createCodeSnippetExpression();
					// if (element.getType().hasParent(cte)){
					// System.out.println("He has CtExpression (parent)");
					// }
					// CtExecutableReference<?> arg0 =
					// element.getFactory().createExecutableReference();
					// element.getExecutable().replace(arg0);
					// element.addComment(element.getFactory().Code().createComment("//replaced
					// arraylist by linkedlist", CtComment.CommentType.INLINE));
				}
			}
			// this.packageName = element.getType().getPackage().getSimpleName();
			// this.fullName = this.packageName+"."+this.className ;
			// this.cls = Class.forName(fullName);
			if (Collection.class.isAssignableFrom(cls)) {
				// If instance of collection
				// this.mesg= "\n=================
				// "+countClass.incrementAndGet()+" Collection Type
				// \""+this.fullName+"\" found"+"==========\n";
				// this.getFactory().getEnvironment().report(this, Level.INFO,
				// element, mesg);
			}
		} catch (ClassNotFoundException e) {

		} catch (NullPointerException npe) {

		}

	}
}
