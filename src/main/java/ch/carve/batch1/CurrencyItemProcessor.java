package ch.carve.batch1;

import javax.batch.api.chunk.ItemProcessor;
import javax.batch.runtime.context.JobContext;
import javax.inject.Inject;
import javax.inject.Named;

@Named
public class CurrencyItemProcessor implements ItemProcessor {

    @Inject
    JobContext jobContext;
    
    @Override
    public CurrencyRate processItem(Object t) {
    	System.out.println("processItem: " + t);
    	//Properties jobParameters = BatchRuntime.getJobOperator().getParameters(jobContext.getExecutionId());
        CurrencyRate currencyRate = (CurrencyRate) t;
        currencyRate.setVersion((int) jobContext.getExecutionId());
        return currencyRate;
    }
}
