package io.spring.batch.remotechunking.configuration;

import org.springframework.batch.core.partition.support.Partitioner;
import org.springframework.batch.item.ExecutionContext;

import java.util.HashMap;
import java.util.Map;

public class CustomPartitioner implements Partitioner {

    @Override
    public Map<String, ExecutionContext> partition(int gridSize) {
        Map<String, ExecutionContext> map = new HashMap<>(gridSize);

        for(int i = 1; i <= gridSize; i++){
            ExecutionContext context = new ExecutionContext();
            context.putString("file", "inputFlatFile=/data/transactions.csv");
            map.put("PARTITION_KEY" + i, context);
        }

        return map;
    }
}
