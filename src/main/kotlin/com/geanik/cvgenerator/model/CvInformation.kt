package com.geanik.cvgenerator.model

class CvInformation(var firstName: String,
                    var lastName: String,
                    var email: String,
                    var phone: String,
                    var jobTitle: String,
                    var fullAcademicDegree: String,
                    var educationEntries: MutableList<EducationEntry>
//                    var experienceEntries: MutableList<ExperienceEntry>,
//                    var projectEntries: MutableList<ProjectEntry>,
//                    var certificates: MutableList<Certificate>,
//                    var skills: MutableList<String>
)