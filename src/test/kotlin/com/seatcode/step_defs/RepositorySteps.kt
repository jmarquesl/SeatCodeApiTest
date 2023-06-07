package com.seatcode.step_defs

import com.seatcode.tasks.GetTheRepositoryInfo
import cucumber.api.java.en.Then
import cucumber.api.java.en.When
import net.serenitybdd.screenplay.actors.OnStage
import net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse
import org.hamcrest.Matchers


class RepositorySteps {

    @When("they call the repository information endpoint")
    fun userCallsTheRepositoryInformationEndpoint(){
        OnStage.theActorInTheSpotlight().attemptsTo(
            GetTheRepositoryInfo()
        )
    }

    @Then("the response has the correct owner value")
    fun responseHasCorrectOwnerValue(){
        OnStage.theActorInTheSpotlight().should(
            seeThatResponse{
                it.body("owner.login",Matchers.equalTo("seatcode"))
            }
        )
    }

    @Then("the response has the incorrect owner value")
    fun responseHasIncorrectCorrectOwnerValue(){
        OnStage.theActorInTheSpotlight().should(
            seeThatResponse{
                it.body("owner.login",Matchers.equalTo("jordi"))
            }
        )
    }

}