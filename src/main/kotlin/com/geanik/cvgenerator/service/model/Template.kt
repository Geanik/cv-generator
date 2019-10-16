package com.geanik.cvgenerator.service.model

import com.geanik.cvgenerator.model.CvInformation

interface Template {
    fun generateFile(info: CvInformation) : ByteArray
}