import io.vertx.core.Vertx
import io.vertx.ext.web.Router

object EntryPoint {
    val vertx: Vertx = Vertx.vertx()
    val  router: Router = Router.router(vertx)


    @JvmStatic
    fun main(args: Array<String>) {
        vertx.deployVerticle(VertxApplication())
    }
}