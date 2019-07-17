package com.geanik.cvgenerator.controller

import com.geanik.cvgenerator.model.CvInformation
import com.geanik.cvgenerator.service.CvGeneratorService
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.PostMapping


@Controller
class DashboardController(private val cvGeneratorService: CvGeneratorService) {

    @GetMapping("/")
    fun getDashboard(model: Model): String {
        model.addAttribute("cvInformation", cvGeneratorService.loadCvInfromation())
        return "dashboard"
    }

    @PostMapping("/update")
    fun updateInfo(@ModelAttribute cvInformation: CvInformation): String {
        cvGeneratorService.saveCvInformation(cvInformation)
        return "redirect:/"
    }

}