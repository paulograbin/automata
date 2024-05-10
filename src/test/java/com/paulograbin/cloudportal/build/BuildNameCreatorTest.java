package com.paulograbin.cloudportal.build;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


class BuildNameCreatorTest {

    private final BuildNameCreator buildNameCreator = new BuildNameCreator();


    @Test
    void releaseBranch() {
        String buildName = buildNameCreator.makeBuildNameFromBranch("release/release-8.5.1");

        assertThat(buildName).isEqualTo("release-8.5.1");
    }

    @Test
    void featureBranch() {
        String buildName = buildNameCreator.makeBuildNameFromBranch("LKBENCL-4258/remove-esw-and-country-override");

        assertThat(buildName).startsWith("LKBENCL-4258-remove-esw-and-country-override");
    }
}