package ir.mirdar.pexelmovieapp.presentation.common

object Utils {
    const val API_KEY = "Ex0Hq63A52ZkeqvXc28ryNBNFW6LveesRxtPhIkY0aXRTv4bEQtS40h5"
    const val BASE_URL = "https://api.pexels.com/v1/"
    const val IMAGE_BASE_URL = "https://api.pexels.com/v1/photos/"
    const val MAX_RETRIES = 1L

    private const val INITIAL_BACKOFF = 2000L
    var IS_LOADING = false
    var END_OF_PAGE: Boolean = false
    fun getBackoffDelay(attempt: Long) = INITIAL_BACKOFF * (attempt + 1)


}
