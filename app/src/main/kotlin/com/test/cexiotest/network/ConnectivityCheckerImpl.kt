package com.test.cexiotest.network

import android.net.ConnectivityManager

class ConnectivityCheckerImpl(
    private val connectivityManager: ConnectivityManager
): ConnectivityChecker {
    override fun isNetworkConnected(): Boolean {
        val activeNetwork = connectivityManager.activeNetworkInfo
        return activeNetwork?.isConnectedOrConnecting ?: false
    }
}