import com.google.gson.Gson
import io.vertx.core.*

class VertxApplication : AbstractVerticle() {

    @Throws(Exception::class)
    override fun start(future: Future<Void>) {
        val httpServer = vertx.createHttpServer()
        val router = EntryPoint.router

        httpServer
                .requestHandler(router::accept)
                .listen(5555) { result ->
                    run {
                        if (result.succeeded()) {
                            future.complete()
                        } else {
                            future.fail(result.cause())
                        }
                    }
                }


        router.get("/check")
                .handler { routingContext ->
                    val response = routingContext.response()
                    val responseBody = Response("200")
                    val jsonResponseBody = Gson().toJson(responseBody)
                    response.end(jsonResponseBody)
                }
    }

    @Throws(Exception::class)
    override fun stop(future: Future<Void>) {
    }
}