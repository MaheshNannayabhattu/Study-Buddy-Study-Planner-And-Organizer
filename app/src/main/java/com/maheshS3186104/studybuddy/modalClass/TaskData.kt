package com.maheshS3186104.studybuddy.modalClass



data class TaskData(
    val subject: String = "",
    val description: String = "",
    val deadlineToComplete: String = "",
    val links: String = "",
    val priority: String = ""
)

data class StudyPlannerUserData(
    val fullName: String = "",

    val email: String = "",
    val password: String = "",

)