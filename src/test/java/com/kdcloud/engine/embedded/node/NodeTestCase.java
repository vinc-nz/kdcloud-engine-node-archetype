package com.kdcloud.engine.embedded.node;

import java.io.InputStream;

import org.junit.Assert;
import org.junit.Test;

import com.kdcloud.engine.Worker;
import com.kdcloud.engine.embedded.EmbeddedEngine;

public class NodeTestCase {

	public static final String TEST_WORKFLOW = "test-case.xml";
	

	@Test
	public void test() throws Exception {
		EmbeddedEngine engine = new EmbeddedEngine();
		InputStream is = getClass().getClassLoader().getResourceAsStream(TEST_WORKFLOW);
		Worker worker = engine.getWorker(is);
		Assert.assertTrue(worker.configure());
		worker.run();
		Assert.assertEquals(Worker.STATUS_JOB_COMPLETED, worker.getStatus());
	}

}
