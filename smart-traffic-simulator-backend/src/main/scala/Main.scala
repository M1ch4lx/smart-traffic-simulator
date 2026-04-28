import sttp.tapir._
import sttp.tapir.server.http4s.Http4sServerInterpreter
import org.http4s.ember.server.EmberServerBuilder
import cats.effect.{IO, IOApp}
import com.comcast.ip4s._

object Main extends IOApp.Simple {

  // 1. Definicja endpointu
  val helloEndpoint = endpoint
    .get
    .in("hello" / query[String]("name"))
    .out(stringBody)

  // 2. Logika serwera (co się dzieje po zapytaniu)
  val helloServerEndpoint = helloEndpoint.serverLogic { name =>
    IO.pure(Right(s"Hello, $name!"))
  }

  // 3. Uruchomienie serwera
  override def run: IO[Unit] = {
    val routes = Http4sServerInterpreter[IO]().toRoutes(helloServerEndpoint)
    
    EmberServerBuilder
      .default[IO]
      .withHost(ipv4"0.0.0.0")
      .withPort(port"8080")
      .withHttpApp(routes.orNotFound)
      .build
      .use(_ => IO.never)
  }
}