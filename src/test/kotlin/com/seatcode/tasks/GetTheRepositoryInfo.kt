package com.seatcode.tasks

import com.seatcode.api.RepositoryRoute
import net.serenitybdd.screenplay.Actor
import net.serenitybdd.screenplay.Task
import net.serenitybdd.screenplay.rest.interactions.Get

open class GetTheRepositoryInfo : Task {
    override fun <T : Actor?> performAs(actor: T) {
        actor?.attemptsTo(
            Get.resource(RepositoryRoute.get)
        )
    }

}
