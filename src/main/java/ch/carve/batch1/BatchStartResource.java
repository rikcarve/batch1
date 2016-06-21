package ch.carve.batch1;


import java.util.Properties;

import javax.batch.operations.JobOperator;
import javax.batch.runtime.BatchRuntime;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@Path("/start")
public class BatchStartResource {
	@GET
	public Response start() {
		System.out.println("start...");
		JobOperator jobOper = BatchRuntime.getJobOperator();
		Properties properties = new Properties();
		properties.put("resource", "META-INF/currencies.csv");
		long jobId = jobOper.start("myJob", properties);
		System.out.println("Job started: " + jobId);
		return Response.ok(String.valueOf(jobId)).build();
	}
}
