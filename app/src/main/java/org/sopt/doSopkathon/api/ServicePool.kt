package org.sopt.doSopkathon.api

import org.sopt.doSopkathon.data.service.ListService
import org.sopt.doSopkathon.data.service.MockService

object ServicePool {
    val mockService = ApiFactory.create<MockService>()
    val listService = ApiFactory.create<ListService>()
}