package com.cxytiandi.elasticjob.job;

import com.dangdang.ddframe.job.api.ShardingContext;
import com.dangdang.ddframe.job.api.simple.SimpleJob;
import lombok.extern.slf4j.Slf4j;

/**
 * @author laowang
 * @date 2019/12/5 17:02
 * @Description:
 */
@Slf4j
public class TestJob implements SimpleJob {

    @Override
    public void execute(ShardingContext shardingContext) {
        log.info("TestJob do execute...");

        log.info("jobName[{}]", shardingContext.getJobName());
    }
}
