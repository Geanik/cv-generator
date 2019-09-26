package com.geanik.cvgenerator.controller

import com.geanik.cvgenerator.model.CvInformation
import com.geanik.cvgenerator.model.EducationEntry
import com.geanik.cvgenerator.service.CvGeneratorService
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.PostMapping
import java.time.LocalDate


@Controller
class DashboardController(private val cvGeneratorService: CvGeneratorService) {

    @GetMapping("/")
    fun getDashboard(model: Model): String {
        model.addAttribute("cvInformation", cvGeneratorService.loadCvInformation())
        return "dashboard"
    }

    @PostMapping("/update")
    fun updateInfo(@ModelAttribute cvInformation: CvInformation): String {
//        val cvInformation = CvInformation(generalInformation, educationEntries)
//        cvGeneratorService.saveCvInformation(cvInformation)
        return "redirect:/"
    }

    @PostMapping("/addEducationEntry")
    fun addEducationEntry(@ModelAttribute cvInformation: CvInformation): String {
        cvInformation.educationEntries.add(EducationEntry("", "", "", LocalDate.now(), LocalDate.now()))
        return "redirect:/"
    }

}