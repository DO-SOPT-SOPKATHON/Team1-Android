package org.sopt.doSopkathon.api

import org.sopt.doSopkathon.data.service.DetailService
import org.sopt.doSopkathon.data.service.MockService
import org.sopt.doSopkathon.data.service.WriteService

object ServicePool {
     val mockService = ApiFactory.create<MockService>()
     val writeService = ApiFactory.create<WriteService>()
     val detailService = ApiFactory.create<DetailService>()
}