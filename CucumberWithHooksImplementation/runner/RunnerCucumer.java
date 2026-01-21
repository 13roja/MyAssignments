package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features="src/test/java/feature",
glue={"stepdefinition","hooksImplementation"},
publish=true,
tags="@Sanity")

public class RunnerCucumer extends AbstractTestNGCucumberTests{

}
