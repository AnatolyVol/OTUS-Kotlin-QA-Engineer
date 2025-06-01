package Homeworks

data class HttpRequest(
    val method: String,
    var url: String = "",
    val headers: MutableMap<String, String> = mutableMapOf(),
    var body: String? = null
)

class HeaderBuilder {
    private val headers = mutableMapOf<String, String>()

    fun contentType(value: String) {
        headers["Content-Type"] = value
    }

    fun authorization(value: String) {
        headers["Authorization"] = value
    }

    fun build(): Map<String, String> = headers
}

class HttpRequestBuilder(private val method: String) {
    private var request = HttpRequest(method)

    fun url(value: String) {
        request.url = value
    }

    fun header(block: HeaderBuilder.() -> Unit) {
        val builder = HeaderBuilder().apply(block)
        request.headers.putAll(builder.build())
    }

    fun body(value: String) {
        request.body = value
    }

    fun build(): HttpRequest = request
}

fun get(block: HttpRequestBuilder.() -> Unit): HttpRequest =
    HttpRequestBuilder("GET").apply(block).build()

fun post(block: HttpRequestBuilder.() -> Unit): HttpRequest =
    HttpRequestBuilder("POST").apply(block).build()

fun put(block: HttpRequestBuilder.() -> Unit): HttpRequest =
    HttpRequestBuilder("PUT").apply(block).build()

fun delete(block: HttpRequestBuilder.() -> Unit): HttpRequest =
    HttpRequestBuilder("DELETE").apply(block).build()

fun main() {
    val request = post {
        url("https://example.com/api")
        header {
            contentType("application/json")
            authorization("Bearer token")
        }
        body("""{"name": "John", "age": 30}""")
    }
    println(request)
}
