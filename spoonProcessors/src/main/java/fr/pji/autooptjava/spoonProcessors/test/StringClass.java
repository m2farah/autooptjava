package fr.pji.autooptjava.spoonProcessors.test;

import org.apache.log4j.Level;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import spoon.processing.AbstractProcessor;
import spoon.reflect.declaration.*;
import spoon.reflect.visitor.filter.TypeFilter;
import spoon.support.reflect.code.CtConstructorCallImpl;

public class StringClass extends AbstractProcessor<CtConstructorCallImpl<String>>{
	private AtomicInteger countClass = new AtomicInteger(0);
	
	public void process(CtConstructorCallImpl<String> element) {
//		List<String> list= element.getElements(new TypeFilter(element.get));
//		String mesg = "\n================= String Class found : "+countClass.addAndGet(list.size())+"==========\n";
//		if (element.getType() == )
		String mesg = "\n================= String Class found : "+countClass.incrementAndGet()+"==========\n";
		getFactory().getEnvironment().report(this, Level.WARN, element, mesg);
	}

}
