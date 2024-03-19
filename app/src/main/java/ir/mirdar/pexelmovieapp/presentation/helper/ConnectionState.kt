package ir.mirdar.pexelmovieapp.presentation.helper

sealed class ConnectionState {
    object Available : ConnectionState()
    object Unavailable : ConnectionState()
}