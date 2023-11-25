package org.sopt.doSopkathon.api

import org.sopt.doSopkathon.data.service.DetailService
import org.sopt.doSopkathon.data.service.MockService

object ServicePool {
     val mockService = ApiFactory.create<MockService>()
     val detailService = ApiFactory.create<DetailService>()
}