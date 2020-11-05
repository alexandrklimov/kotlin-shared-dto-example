package org.aklimov.ksde.server

import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import org.aklimov.ksde.shared.TestDto
import org.junit.jupiter.api.Test

class TestDtoTest {

    @Test
    fun testSerialization(){
        println(
            Json.encodeToString(
                TestDto("Server serialization")
            )
        )
    }

}
