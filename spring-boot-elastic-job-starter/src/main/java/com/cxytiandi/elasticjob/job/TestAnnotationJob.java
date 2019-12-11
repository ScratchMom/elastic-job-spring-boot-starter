package com.cxytiandi.elasticjob.job;

import com.cxytiandi.elasticjob.annotation.ElasticJobConf;
import com.dangdang.ddframe.job.api.ShardingContext;
import com.dangdang.ddframe.job.api.simple.SimpleJob;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author laowang
 * @date 2019/12/5 17:54
 * @Description:
 */
@Slf4j
@Component
@ElasticJobConf(name = "testAnnotationJob", cron = "0/5 * * * * ?", shardingTotalCount = 5)
public class TestAnnotationJob implements SimpleJob {

    @Value("${server.port:8080}")
    private int port;

    @Override
    public void execute(ShardingContext context) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        log.info("port[{}],time[{}],item[{}]", port, format.format(new Date(System.currentTimeMillis())), context.getShardingItem());
    }
}
