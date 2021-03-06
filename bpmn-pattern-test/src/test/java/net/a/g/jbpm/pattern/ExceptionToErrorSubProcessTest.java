package net.a.g.jbpm.pattern;

import org.jbpm.test.JbpmJUnitBaseTestCase;
import org.junit.Test;
import org.kie.api.event.process.ProcessEventListener;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.manager.RuntimeEngine;
import org.kie.api.runtime.manager.RuntimeManager;
import org.kie.api.runtime.process.ProcessInstance;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.a.g.jbpm.pattern.listener.MDCProcessListener;

public class ExceptionToErrorSubProcessTest extends JbpmJUnitBaseTestCase {
    private static final Logger LOG = LoggerFactory.getLogger(ExceptionToErrorSubProcessTest.class);

    @Test
    public void test() {
        ExceptionToErrorSubProcessTest.LOG.debug("jBPM unit test sample");

        final RuntimeManager runtimeManager = createRuntimeManager("net/a/g/jbpm/pattern/ExceptionToErrorWithSubProcess.bpmn","net/a/g/jbpm/pattern/SubWithErrorProcess.bpmn");
        final RuntimeEngine runtimeEngine = getRuntimeEngine(null);
        final KieSession kieSession = runtimeEngine.getKieSession();
        kieSession.addEventListener((ProcessEventListener)new PatternProcessListener());
        kieSession.addEventListener((ProcessEventListener)new MDCProcessListener());

        final ProcessInstance processInstance = kieSession.startProcess("ExceptionToErrorWithSubProcess");

		assertProcessInstanceNotActive(processInstance.getId(), kieSession);

        assertNodeTriggered(processInstance.getId(), "ScriptTask");
		assertNodeTriggered(processInstance.getId(), "Error End");
		
        runtimeManager.disposeRuntimeEngine(runtimeEngine);
        runtimeManager.close();
    }
}