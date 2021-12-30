package com.visiaquantum.shared.persistance

import android.content.Context
import androidx.preference.PreferenceManager

class SharedPreferencesStorage(context: Context) : Storage {

    private val sharedPreferences by lazy { PreferenceManager.getDefaultSharedPreferences(context) }

    private val editor by lazy { sharedPreferences.edit() }

    override fun clear(): Storage = apply {
        editor.clear()
        editor.commit()
    }

    override fun get(key: String, default: String?): String? {
        return sharedPreferences.getString(key, default)
    }

    override fun get(key: String, default: Boolean): Boolean {
        return sharedPreferences.getBoolean(key, default)
    }

    override fun get(key: String, default: Int): Int {
        return sharedPreferences.getInt(key, default)
    }

    override fun get(key: String, default: Long): Long {
        return sharedPreferences.getLong(key, default)
    }

    override fun remove(key: String): Storage = apply {
        editor.remove(key)
        editor.commit()
    }

    override fun set(key: String, value: String): Storage = apply {
        editor.putString(key, value)
        editor.commit()
    }

    override fun set(key: String, value: Boolean): Storage = apply {
        editor.putBoolean(key, value)
        editor.commit()
    }

    override fun set(key: String, value: Long): Storage = apply {
        editor.putLong(key, value)
        editor.commit()
    }

    override fun set(key: String, value: Int): Storage = apply {
        editor.putInt(key, value)
        editor.commit()
    }
}