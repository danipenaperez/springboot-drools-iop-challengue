package com.dppware.swa.domain.service;

import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.stereotype.Component;

import com.dppware.swa.domain.entity.PriceCalculatorOperation;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class PriceCalculatorDomainService {
	
	public static final String RULES_FILE_LOCATION = "rules/priceResolverRules.drl";
	
	private KieContainer kieContainer;
	
	public void calculatePrice(PriceCalculatorOperation operation) {
		KieSession kieSession = kieContainer.newKieSession();
		kieSession.insert(operation);
		kieSession.fireAllRules();
		kieSession.dispose();
	}
}

/**
 * 	
	public void process(PriceBean productPrice) throws IOException {
		StatelessKieSession session = kieContainer.newStatelessKieSession();
		
		KieRuntimeLogger kieLogger = KieServices.get().getLoggers().newFileLogger(session, "droolsLogger");
		
		session.setGlobal("employeeProvider", productPrice);
		session.setGlobal("notificationService", productPrice);
		
		//Prepare facts to insert
		List<Object> facts = new ArrayList<Object>();
		facts.add(productPrice);
		//Execute all rules
		session.execute(facts);
		kieLogger.close();
		//return productPrice;
    }
**/
