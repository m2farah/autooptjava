package fr.pji.autooptjava.spoonProcessors.test;

import java.util.concurrent.atomic.AtomicInteger;

import org.apache.log4j.Level;
import spoon.processing.AbstractProcessor;
import spoon.reflect.code.CtCatch;
import spoon.support.reflect.code.CtCommentImpl;
import spoon.reflect.code.CtCodeSnippetStatement;

/**
 * Reports warnings when empty catch blocks are found.
 */

public class CatchProcessor extends AbstractProcessor<CtCatch> {
	private static AtomicInteger countClass = new AtomicInteger(0);
    public void process(CtCatch element) {
        if (element.getBody().getStatements().size() == 0) {
            getFactory().getEnvironment().report(this, Level.WARN, element, "empty catch clause");
        	CtCommentImpl comment = new CtCommentImpl();
        	comment.setContent("empty catch clause");
        	element.getBody().insertBegin(comment);
        	CtCodeSnippetStatement snippet = getFactory().Core().createCodeSnippetStatement();
        	snippet.setValue("System.out.println(\"empty catch clause !\")");
        	element.getBody().insertBegin(snippet);
    		String mesg = "\n================= Empty Catch found : "+countClass.incrementAndGet()+"==========\n";
    		getFactory().getEnvironment().report(this, Level.WARN, element, mesg);
        }
    }
}
