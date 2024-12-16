package com.maheshS3186104.studybuddy

import android.content.Context

object StudyPlannerUserDetails {

    private const val PREFS_NAME = "EventBooking"

    fun saveStudyPlannerUserLoginStatus(context: Context, value: Boolean) {
        val sharedPref = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
        val editor = sharedPref.edit()
        editor.putBoolean("STUDYPLANNERUSERLOGIN_STATUS", value).apply()
    }

    fun getStudyPlannerUserLoginStatus(context: Context): Boolean {
        val sharedPref = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
        return sharedPref.getBoolean("STUDYPLANNERUSERLOGIN_STATUS", false)
    }

    fun saveName(context: Context, name: String) {
        val sharedPref = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
        val editor = sharedPref.edit()
        editor.putString("USER_NAME", name).apply()
    }

    fun getName(context: Context): String? {
        val sharedPref = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
        return sharedPref.getString("USER_NAME", null)
    }




    fun saveEmail(context: Context, email: String) {
        val sharedPref = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
        val editor = sharedPref.edit()
        editor.putString("USER_EMAIL", email).apply()
    }

    fun getEmail(context: Context): String? {
        val sharedPref = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
        return sharedPref.getString("USER_EMAIL", null)
    }
}