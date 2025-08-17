package com.paulograbin.cloudportal;

import com.paulograbin.cloudportal.ccv2.CloudPortalAPI;
import com.paulograbin.cloudportal.ccv2.dto.DatabackupDetailsDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class BackupService {

    private final Logger LOG = LoggerFactory.getLogger(BuildService.class);

    private final CloudPortalAPI cloudPortalAPI;

    public BackupService(CloudPortalAPI cloudPortalAPI) {
        this.cloudPortalAPI = cloudPortalAPI;
    }

    public DatabackupDetailsDTO listBackups(String environmentCode) {
        LOG.info("Listing builds for " + environmentCode);


        var a = cloudPortalAPI.getDataBackups(environmentCode);

        return a;
    }
}
