package com.seatcode.step_defs

import baseURL
import cucumber.api.java.Before
import cucumber.api.java.en.Given
import cucumber.api.java.en.Then
import io.restassured.module.jsv.JsonSchemaValidator
import net.serenitybdd.screenplay.actors.Cast
import net.serenitybdd.screenplay.actors.OnStage
import net.serenitybdd.screenplay.rest.abilities.CallAnApi
import net.serenitybdd.screenplay.rest.questions.ResponseConsequence


class GeneralSteps {
    private val theBaseUrl = baseURL

    @Before
    fun setTheStage(){
        OnStage.setTheStage(Cast.ofStandardActors())
    }

    @Given("(.*) can create REST API calls")
    fun userCanCallAnApi(user: String){
        OnStage.theActorCalled(user).can(CallAnApi.at(theBaseUrl))
    }

    @Then("the response follows the (.*) json schema")
    fun theResponseFollowsTheCorrectJsonSchema(schema: String){
        OnStage.theActorInTheSpotlight().should(
            ResponseConsequence.seeThatResponse {
                it.body(JsonSchemaValidator.matchesJsonSchemaInClasspath("schemas/${schema}.json"))
            }
        )
    }

}