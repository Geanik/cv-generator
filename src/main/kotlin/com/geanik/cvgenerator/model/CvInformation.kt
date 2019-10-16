package com.geanik.cvgenerator.model

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
class CvInformation(
        var firstName: String = "",
        var lastName: String = "",
        var email: String = "",
        var phone: String = "",
        var jobTitle: String = "",
        var academicDegree: String = "",

        @Id @GeneratedValue
        var id: Long? = null)