package videogamedb.scriptfundamentals;

import io.gatling.javaapi.core.*;
import io.gatling.javaapi.http.*;

import java.time.Duration;
import java.util.List;

import static io.gatling.javaapi.core.CoreDsl.*;
import static io.gatling.javaapi.http.HttpDsl.*;

public class VideoGameDb extends Simulation {

    private HttpProtocolBuilder httpProtocol = http
            .baseUrl("https://videogamedb.uk/api")
            .acceptHeader("application/json");

    private ScenarioBuilder scn = scenario("Video Game Db - Section 5 code")

            .exec(http("Get specific game")
                    .get("/videogame/1")
                    .check(status().in(200, 201, 202))
                    .check(jmesPath("name").is("Resident Evil 4")))
            .pause(1, 10)

            .exec(http("get all video games")
                    .get("/videogame")
                    .check(status().not(404), status().not(500))
                    .check(jmesPath("[1].id").saveAs("gameId")))
            .pause(Duration.ofMillis(4000))

            .exec(http("Get specific game with Id - #{gameId}")
                    .get("/videogame/#{gameId}")
                    .check(jmesPath("name").is("Gran Turismo 3"))
                    .check(bodyString().saveAs("responseBody")));

    {
        setUp(
                scn.injectOpen(atOnceUsers(1))
        ).protocols(httpProtocol);
    }
}
