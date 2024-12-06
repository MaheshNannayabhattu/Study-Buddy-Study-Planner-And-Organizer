package com.example.studyplannernew.modalClass

object TODOData {
    fun getStudentTasks(): List<TaskData> {
        return listOf(
            TaskData(
                subject = "Mathematics",
                description = "Complete calculus homework (Chapter 3, Exercises 5-10)",
                deadlineToComplete = "2024-11-20"
            ),
            TaskData(
                subject = "Physics",
                description = "Prepare notes on Quantum Mechanics for next class",
                deadlineToComplete = "2024-11-21"
            ),
            TaskData(
                subject = "Chemistry",
                description = "Finish lab report on chemical reactions",
                deadlineToComplete = "2024-11-22"
            ),
            TaskData(
                subject = "Computer Science",
                description = "Code a simple to-do app as a class project",
                deadlineToComplete = "2024-11-25"
            ),
            TaskData(
                subject = "English Literature",
                description = "Read and summarize 'To Kill a Mockingbird'",
                deadlineToComplete = "2024-11-23"
            ),
            TaskData(
                subject = "History",
                description = "Prepare a presentation on World War II",
                deadlineToComplete = "2024-11-24"
            ),
            TaskData(
                subject = "Biology",
                description = "Study cell division for the upcoming quiz",
                deadlineToComplete = "2024-11-19"
            ),
            TaskData(
                subject = "Economics",
                description = "Write an essay on 'Impact of Inflation on Global Markets'",
                deadlineToComplete = "2024-11-26"
            ),
            TaskData(
                subject = "Philosophy",
                description = "Reflect and write about 'The Meaning of Life' essay prompt",
                deadlineToComplete = "2024-11-27"
            ),
            TaskData(
                subject = "Physical Education",
                description = "Practice basketball drills for intercollege tournament",
                deadlineToComplete = "2024-11-22"
            )
        )
    }

}