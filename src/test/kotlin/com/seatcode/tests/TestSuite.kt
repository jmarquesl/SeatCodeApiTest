package com.seatcode.tests

import cucumber.api.CucumberOptions
import net.serenitybdd.cucumber.CucumberWithSerenity
import org.junit.runner.RunWith

@RunWith(CucumberWithSerenity::class)
@CucumberOptions(features =["src/test/resources/features"], glue=["com.seatcode"], tags=["not @ignore"])
class TestSuite