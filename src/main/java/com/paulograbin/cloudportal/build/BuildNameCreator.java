package com.paulograbin.cloudportal.build;

import java.text.SimpleDateFormat;
import java.util.Date;

public class BuildNameCreator {

    public String makeBuildNameFromBranch(String branchName) {
        String buildName = branchName;

        if (buildName.contains("release/")) {
            buildName = buildName.replace("release/", "");

            return buildName;
        }

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yy HH-mm");
        String formattedDate = dateFormat.format(new Date());

        buildName = buildName.replace("/", "-");

        buildName = buildName + " " + formattedDate;

        return buildName;
    }

}
