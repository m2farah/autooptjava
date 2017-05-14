package fr.pji.autooptjava.spoonProcessors.test;

import java.util.Collection;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import org.apache.log4j.Level;

import spoon.processing.AbstractProcessor;
import spoon.reflect.code.CtConstructorCall;
import spoon.reflect.code.CtFieldWrite;
import spoon.reflect.code.CtVariableWrite;
import spoon.reflect.reference.CtTypeReference;
import spoon.reflect.visitor.filter.TypeFilter;
import spoon.reflect.code.CtAssignment;

public class ArrayToLinked extends AbstractProcessor<CtTypeReference<java.util.Collection<?>>> {
	private static AtomicInteger countClass = new AtomicInteger(0);
	private String mesg;
	private Class<?> cls;
	private String fullName; // store temporarily "packageName+className" of the
								// class that we work with it.
	private String className;
	private String packageName;
	public void process(CtTypeReference<java.util.Collection<?>> element) {
		try {
			this.className = element.getSimpleName();
			this.packageName = element.getPackage().getSimpleName();
			this.fullName = this.packageName+"."+this.className ;
			this.cls = Class.forName(fullName);
			if (Collection.class.isAssignableFrom(cls) && className.equals("ArrayList")) {
				CtTypeReference<?> ctf;
				if (element.toString().contains("ArrayList<>")){
					CtTypeReference<?> typeTemp = null;
					List<?> listElem = null;
					if ((listElem = element.getParent(CtAssignment.class).getElements(new TypeFilter(CtFieldWrite.class)))!= null && listElem.size()==1){
//						listElem = element.getParent(CtAssignment.class).getElements(new TypeFilter(CtFieldWrite.class));
						typeTemp = ((CtFieldWrite) listElem.get(0)).getType();
						typeTemp = this.getFactory().Type().createReference(typeTemp.toString().replaceFirst("[^<]+", "java.util.LinkedList"));
//						CtTypeReference<?> typeTemp = this.getFactory().Type().createReference(element.getParent(""));
					}else if ((listElem = element.getParent(CtAssignment.class).getElements(new TypeFilter(CtVariableWrite.class)))!= null && listElem.size()==1){
//						listElem = element.getParent(CtAssignment.class).getElements(new TypeFilter(CtVariableWrite.class));
						typeTemp = ((CtVariableWrite) listElem.get(0)).getType();
						typeTemp = this.getFactory().Type().createReference(typeTemp.toString().replaceFirst("[^<]+", "java.util.LinkedList"));
					}else{
						typeTemp = this.getFactory().Type().createReference(element.toString().replaceFirst("[^<]+", "java.util.LinkedList"));
					}
					
					/*Test if the replacement was not made*/
					if (element.toString().contains("ArrayList<>")){
						typeTemp = this.getFactory().Type().createReference(element.toString().replaceFirst("[^<]+", "java.util.LinkedList"));
//						this.getFactory().getEnvironment().report(this, Level.INFO,element, "\n\n >>> HERE:"+typeTemp.toString());
//						try {
//							Thread.sleep(10000);
//						} catch (InterruptedException e) {
//							// TODO Auto-generated catch block
//							e.printStackTrace();
//						}
					}
					
					ctf = typeTemp;
				}else{
					ctf = this.getFactory().Type().createReference(element.toString().replaceFirst("[^<]+", "java.util.LinkedList"));
				}
				this.mesg= "\n\n>>>>>>Fortest:"+countClass.incrementAndGet()+" "+ element.toString();
				this.getFactory().getEnvironment().report(this, Level.INFO,element, mesg);
				if (ctf != null){
//					ctf.toString().replaceFirst("\\([^\\)]+", "(");
					element.replace(ctf);
					element.setDeclaringType(ctf);
					CtConstructorCall<?> ctc = element.getParent(CtConstructorCall.class);
					if (ctc != null){
						ctc.setArguments(null);
					}
					if (ctf.toString().contains("ArrayList<>")){
						this.getFactory().getEnvironment().report(this, Level.INFO,element, "\n\n >>> HERE:"+ctf.toString());
						try {
							Thread.sleep(10000);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
			}
		} catch (ClassNotFoundException e) {

		} catch (NullPointerException npe) {
		}
		
	}


}
