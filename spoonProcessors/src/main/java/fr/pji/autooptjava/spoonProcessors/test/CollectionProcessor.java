package fr.pji.autooptjava.spoonProcessors.test;

import java.util.AbstractCollection;
import java.util.concurrent.atomic.AtomicInteger;

import org.apache.log4j.Level;

import spoon.processing.AbstractProcessor;
import spoon.support.reflect.code.CtConstructorCallImpl;

public class CollectionProcessor extends AbstractProcessor<CtConstructorCallImpl<AbstractCollection<?>>>{
	private static AtomicInteger countClass = new AtomicInteger(0);

	public void process(CtConstructorCallImpl<AbstractCollection<?>> element) {
		String mesg = "\n================= Collection Type found : "+countClass.incrementAndGet()+"==========\n";
		getFactory().getEnvironment().report(this, Level.WARN, element, mesg);
	}


}
