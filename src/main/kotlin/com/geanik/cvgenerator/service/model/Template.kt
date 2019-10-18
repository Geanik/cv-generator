package com.geanik.cvgenerator.service.model

import com.geanik.cvgenerator.model.CvInformation

interface Template {
    val name: String

    fun populate(info: CvInformation) : ByteArray
}