package org.aklimov.ksde.shared

import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import kotlin.test.Test

class MainCommonTest {
    @Test
    fun serializationCommonTest(){
        println(Json.encodeToString(TestDto("MainCommonTest")))
    }
}
