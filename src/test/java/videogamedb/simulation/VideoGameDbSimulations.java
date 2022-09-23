package videogamedb.simulation;

import io.gatling.javaapi.core.*;
import io.gatling.javaapi.http.*;

import static io.gatling.javaapi.core.CoreDsl.*;
import static io.gatling.javaapi.http.HttpDsl.*;

public class VideoGameDbSimulations extends Simulation {

    private HttpProtocolBuilder httpProtocol = http
            .baseUrl("https://videogamedb.uk/api")
            .acceptHeader("application/json");

    private static ChainBuilder getAllVideoGames =
            exec(http("Get all video games")
                    .get("/videogame"));

    private static ChainBuilder getSpecificGame =
            exec(http("Get specific game")
                    .get("/videogame/2"));

    private ScenarioBuilder scn = scenario("Video game db - Section 7 code")
            .exec(getAllVideoGames)
            .pause(5)
            .exec(getSpecificGame)
            .pause(5)
            .exec(getAllVideoGames);

    {
        setUp(
                scn.injectOpen(
                        nothingFor(5),
                        rampUsersPerSec(1).to(5).during(20).randomized()
                ).protocols(httpProtocol)
        );
    }
}
