package com.paulograbin.cloudportal.build;

import java.text.SimpleDateFormat;
import java.util.Date;

public class BuildNameCreator {

    public String makeBuildNameFromBranch(String branchName) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yy HH-mm");
        String formattedDate = dateFormat.format(new Date());

        String buildName = branchName + " " + formattedDate;

        buildName = buildName.replace("release/", "");
        buildName = buildName.replace("/", "-");

        return buildName;
    }

}
