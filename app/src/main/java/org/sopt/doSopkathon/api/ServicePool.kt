package org.sopt.doSopkathon.api

import org.sopt.doSopkathon.data.service.MockService
import org.sopt.doSopkathon.data.service.WriteService

object ServicePool {
     val mockService = ApiFactory.create<MockService>()
     val writeService = ApiFactory.create<WriteService>()
}