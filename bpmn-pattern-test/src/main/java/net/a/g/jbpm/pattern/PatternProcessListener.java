package net.a.g.jbpm.pattern;

import org.kie.api.event.process.ProcessCompletedEvent;
import org.kie.api.event.process.ProcessEventListener;
import org.kie.api.event.process.ProcessNodeLeftEvent;
import org.kie.api.event.process.ProcessNodeTriggeredEvent;
import org.kie.api.event.process.ProcessStartedEvent;
import org.kie.api.event.process.ProcessVariableChangedEvent;
import org.kie.api.event.rule.ObjectDeletedEvent;
import org.kie.api.event.rule.ObjectInsertedEvent;
import org.kie.api.event.rule.ObjectUpdatedEvent;
import org.kie.api.event.rule.RuleRuntimeEventListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PatternProcessListener implements ProcessEventListener, RuleRuntimeEventListener {
	private Logger LOG = LoggerFactory.getLogger("net.a.g.jbpm.pattern.ProcessEventListener");


	@Override
	public void beforeProcessStarted(ProcessStartedEvent event) {
		LOG.info("Start Processus : {}", event.getProcessInstance().getProcessName());
	}

	@Override
	public void beforeProcessCompleted(ProcessCompletedEvent event) {
	}

	@Override
	public void beforeNodeTriggered(ProcessNodeTriggeredEvent event) {
		LOG.info("Node Called : {}", event.getNodeInstance().getNodeName());
	}

	@Override
	public void beforeNodeLeft(ProcessNodeLeftEvent event) {
	}

	@Override
	public void afterVariableChanged(ProcessVariableChangedEvent event) {
	}

	@Override
	public void afterProcessStarted(ProcessStartedEvent event) {
	}

	@Override
	public void afterProcessCompleted(ProcessCompletedEvent event) {
		LOG.info("End Process Completed : {}", event.getProcessInstance().getProcessName());

	}

	@Override
	public void afterNodeTriggered(ProcessNodeTriggeredEvent event) {
	}

	@Override
	public void afterNodeLeft(ProcessNodeLeftEvent event) {
	}

	@Override
	public void beforeVariableChanged(ProcessVariableChangedEvent event) {

	}

	@Override
	public void objectInserted(ObjectInsertedEvent event) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void objectUpdated(ObjectUpdatedEvent event) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void objectDeleted(ObjectDeletedEvent event) {
		// TODO Auto-generated method stub
		
	}
}