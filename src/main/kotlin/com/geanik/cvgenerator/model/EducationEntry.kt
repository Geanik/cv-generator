package com.geanik.cvgenerator.model

import java.time.LocalDate

class EducationEntry(var instituteName: String,
                     var programmeName: String,
                     var academicDegree: String,
                     var from: LocalDate,
                     var to: LocalDate)