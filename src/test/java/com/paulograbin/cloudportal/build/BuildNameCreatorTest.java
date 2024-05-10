package com.paulograbin.cloudportal.build;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;


class BuildNameCreatorTest {

    private final BuildNameCreator buildNameCreator = new BuildNameCreator();

    @Test
    void releaseBranch() {
        String buildName = buildNameCreator.makeBuildNameFromBranch("release/release-8.5.1");

        Assertions.assertThat(buildName).startsWith("release-8.5.1");
    }

    @Test
    void featureBranch() {
        String buildName = buildNameCreator.makeBuildNameFromBranch("LKBENCL-4258/remove-esw-and-country-override");

        Assertions.assertThat(buildName).startsWith("LKBENCL-4258-remove-esw-and-country-override");
    }
}