package com.maheshstudybuddy.S3186104

import android.content.Context

object StudyPlannerUserDetails {

    private const val StudyBuddyPrefs = "StudyBuddyPrefs"

    fun saveStudyPlannerUserLoginStatus(context: Context, value: Boolean) {
        val sharedPref = context.getSharedPreferences(StudyBuddyPrefs, Context.MODE_PRIVATE)
        val editor = sharedPref.edit()
        editor.putBoolean("STUDYPLANNERUSERLOGIN_STATUS", value).apply()
    }

    fun getStudyPlannerUserLoginStatus(context: Context): Boolean {
        val sharedPref = context.getSharedPreferences(StudyBuddyPrefs, Context.MODE_PRIVATE)
        return sharedPref.getBoolean("STUDYPLANNERUSERLOGIN_STATUS", false)
    }

    fun saveStudentName(context: Context, name: String) {
        val sharedPref = context.getSharedPreferences(StudyBuddyPrefs, Context.MODE_PRIVATE)
        val editor = sharedPref.edit()
        editor.putString("STUDENT_NAME", name).apply()
    }

    fun getStudentName(context: Context): String? {
        val sharedPref = context.getSharedPreferences(StudyBuddyPrefs, Context.MODE_PRIVATE)
        return sharedPref.getString("STUDENT_NAME", null)
    }


    fun saveStudentEmail(context: Context, email: String) {
        val sharedPref = context.getSharedPreferences(StudyBuddyPrefs, Context.MODE_PRIVATE)
        val editor = sharedPref.edit()
        editor.putString("STUDENT_EMAIL", email).apply()
    }

    fun getStudentEmail(context: Context): String? {
        val sharedPref = context.getSharedPreferences(StudyBuddyPrefs, Context.MODE_PRIVATE)
        return sharedPref.getString("STUDENT_EMAIL", null)
    }
}