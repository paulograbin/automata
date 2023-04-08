package com.paulograbin.cloudportal.event;

import com.paulograbin.cloudportal.BuildService;
import com.paulograbin.cloudportal.ccv2.dto.BuildDetailsDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.CompletableFuture;


@Service
public class AsyncSampleService {

    private static final Logger LOG = LoggerFactory.getLogger(AsyncSampleService.class);

    @Async
    public void makeSomeAsyncCalls(BuildService buildService) {
        LOG.info("Lets compare...");

        Instant tenStart = Instant.now();
        CompletableFuture<BuildDetailsDTO> last10Builds = buildService.getLast10Builds();
        CompletableFuture.allOf(last10Builds).thenRun(() -> LOG.info("10 builds na verdade durou {}", Duration.between(tenStart, Instant.now()).toMillis()));
        long tenDuration = Duration.between(tenStart, Instant.now()).toMillis();

        Instant allStart = Instant.now();
        CompletableFuture<BuildDetailsDTO> allBuilds = buildService.fetchAllBuilds();
        CompletableFuture.allOf(allBuilds).thenRun(() -> LOG.info("all na verdade durou {}", Duration.between(allStart, Instant.now()).toMillis()));
        long allDuration = Duration.between(allStart, Instant.now()).toMillis();

        LOG.info("10 builds took {} ms", tenDuration);
        LOG.info("All builds took {} ms", allDuration);


        CompletableFuture.allOf(last10Builds, allBuilds).thenRun(() -> LOG.info("Teste durou {}", Duration.between(tenStart, Instant.now()).toMillis()));
        LOG.info("Comparing finished!!!");
    }
}
