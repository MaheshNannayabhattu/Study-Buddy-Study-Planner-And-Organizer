package com.maheshstudybuddy.S3186104.modalClass

import android.content.Context
import com.google.firebase.crashlytics.buildtools.reloc.com.google.common.reflect.TypeToken
import com.google.gson.Gson
import com.maheshstudybuddy.S3186104.StudySchedule


object TaskStorage {
    private const val PREF_NAME = "TaskPref"
    private const val TASK_LIST_KEY = "TaskList"
    private const val MONDAY_LIST_KEY = "MondayList"
    private const val TUESDAY_LIST_KEY = "TuesdayList"
    private const val WEDNESDAY_LIST_KEY = "WednesdayList"
    private const val THURSDAY_LIST_KEY = "ThursdayList"
    private const val FRIDAY_LIST_KEY = "FridayList"
    private const val SATURDAY_LIST_KEY = "SaturdayList"
    private const val SUNDAY_LIST_KEY = "SundayList"

    fun saveTask(context: Context, task: TaskData) {
        val sharedPreferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()

        // Retrieve the existing tasks
        val existingTasks = getTasks(context).toMutableList()
        existingTasks.add(task)

        // Convert list to JSON and save it
        val gson = Gson()
        val json = gson.toJson(existingTasks)
        editor.putString(TASK_LIST_KEY, json)
        editor.apply()
    }

     fun getTasks(context: Context): List<TaskData> {
        val sharedPreferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)
        val json = sharedPreferences.getString(TASK_LIST_KEY, null)
        val type = object : TypeToken<List<TaskData>>() {}.type
        return if (json.isNullOrEmpty()) {
            emptyList()
        } else {
            Gson().fromJson(json, type)
        }
    }

    fun saveSchedule(context: Context, studySchedule: StudySchedule,day:String) {
        val sharedPreferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()

        // Retrieve the existing tasks
        val existingTasks = getSchedule(context,day).toMutableList()
        existingTasks.add(studySchedule)

        // Convert list to JSON and save it
        val gson = Gson()
        val json = gson.toJson(existingTasks)
        editor.putString(day, json)
        editor.apply()
    }

    fun getSchedule(context: Context, day: String): List<StudySchedule> {
        val sharedPreferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)
        val json = sharedPreferences.getString(day, null)
        val type = object : TypeToken<List<StudySchedule>>() {}.type
        return if (json.isNullOrEmpty()) {
            emptyList()
        } else {
            Gson().fromJson(json, type)
        }
    }
}
