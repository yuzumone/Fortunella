package net.fortunella.sample.domain

import net.fortunella.UseCase
import java.lang.IllegalArgumentException

class TestUseCase : UseCase<Boolean, String>() {
    override suspend fun run(params: Boolean): String {
        if (params) {
            return "ok"
        } else {
            throw IllegalArgumentException("failure")
        }
    }
}