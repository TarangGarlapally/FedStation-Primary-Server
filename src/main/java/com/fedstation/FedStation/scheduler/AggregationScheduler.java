package com.fedstation.FedStation.scheduler;

import java.util.Date;
import java.util.List;

import com.fedstation.FedStation.entity.NextAggregationTriggerTime;
import com.fedstation.FedStation.entity.Project;
import com.fedstation.FedStation.repository.NextAggregationTriggerTimeRepo;
import com.fedstation.FedStation.repository.ProjectRepo;
import com.fedstation.FedStation.service.HelperServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class AggregationScheduler {

    @Autowired
    private NextAggregationTriggerTimeRepo nextAggregationTriggerTimeRepo;

    @Autowired
    private ProjectRepo projectRepo;

    @Scheduled(cron = "0 0 * 1 * *")
    public void testTask() {
        Long timestampNow = (new Date()).getTime() / 1000;

        System.out.println("\n" + timestampNow + "\n");

        List<NextAggregationTriggerTime> nextAggregationTriggerTimeList = nextAggregationTriggerTimeRepo
                .findByNextAggTimeStamp(timestampNow);

        if (nextAggregationTriggerTimeList.size() == 0)
            return;

        System.out.println("\n\nAggregating: ");
        for (NextAggregationTriggerTime ngt : nextAggregationTriggerTimeList) {

            Project project = projectRepo.findById(ngt.getProjectId()).orElse(null);
            nextAggregationTriggerTimeRepo.updateTimeStampByProjectID(
                    (new HelperServices()).getNextTimeAggregationStamp(project), ngt.getProjectId());

            if (ngt.getIsTriggerDisabled())
                continue;

            // aggregate
            System.out.println(ngt.getProjectId() + " " + ngt.getNextAggTimeStamp());
        }
        System.out.println("\n");
    }

}
