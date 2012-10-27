package com.kdcloud.engine.embedded.node;

import java.util.HashSet;
import java.util.Set;

import weka.core.Instances;

import com.kdcloud.engine.embedded.BufferedInstances;
import com.kdcloud.engine.embedded.Node;
import com.kdcloud.engine.embedded.WorkerConfiguration;
import com.kdcloud.engine.embedded.WrongConfigurationException;
import com.kdcloud.engine.embedded.WrongInputException;

public class NodeStub implements Node {
	
	//you should keep a reference to your input and output
	private BufferedInstances input = new BufferedInstances();
	private BufferedInstances output = new BufferedInstances();
	
	//you can inject other attributes using the XML workflow
	//in this case you must also add setter methods

	@Override
	public void setInput(BufferedInstances input) throws WrongInputException {
		Instances instances = input.getInstances();
		//here is where you perform input validation
		//if the input is wrong you should throw WrongInputException
		//otherwise just save it
		this.input = input;
		//you should not perform any job on the instances because they may not be fully loaded
	}

	@Override
	public BufferedInstances getOutput() {
		//unless you have very specific needs this should be fine
		return output;
	}

	@Override
	public Set<String> getParameters() {
		//this method should return a set of parameters you need at runtime
		Set<String> parameters = new HashSet<String>();
		//suppose you need a parameter calibration you should do this
		//parameters.add("calibration");
		return parameters;
	}

	@Override
	public void configure(WorkerConfiguration config)
			throws WrongConfigurationException {
		//get all the parameter you need
		//suppose you need an integer parameter called calibration you should do this
		//int calibration = config.getInteger("calibration");
		//if a parameter is missing or it was not set properly you should throw WrongConfigurationException
	}

	@Override
	public void run() throws Exception {
		//here is where you should perform your job
		Instances myInput = input.getInstances();
		//to whatever you need to do
		//you should end this way
		//output.setInstances(myOutput)
	}

}
