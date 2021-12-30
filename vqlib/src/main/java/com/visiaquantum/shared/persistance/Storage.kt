package com.visiaquantum.shared.persistance

interface Storage {
    /**
     * Retrieve a value from the storage or return a default value
     */
    fun get(key: String, default: String? = null): String?

    /**
     * Set a value into the storage
     */
    fun set(key: String, value: String): Storage

    /**
     * Retrieve a value from the storage or return a default value
     */
    fun get(key: String, default: Boolean = false): Boolean?

    /**
     * Retrieve a value from the storage or return a default value
     */
    fun get(key: String, default: Int = 0): Int?

    /**
     * Retrieve a value from the storage or return a default value
     */
    fun get(key: String, default: Long = 0): Long?

    /**
     * Set a value into the storage
     */
    fun set(key: String, value: Boolean): Storage

    /**
     * Set a value into the storage
     */
    fun set(key: String, value: Long): Storage

    /**
     * Set a value into the storage
     */
    fun set(key: String, value: Int): Storage

    /**
     * Remove a value from the storage
     */
    fun remove(key: String): Storage

    /**
     * Empty the storage
     */
    fun clear(): Storage
}