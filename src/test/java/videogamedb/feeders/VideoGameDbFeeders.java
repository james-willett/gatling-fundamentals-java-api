package videogamedb.feeders;

import io.gatling.javaapi.core.*;
import io.gatling.javaapi.http.*;

import static io.gatling.javaapi.core.CoreDsl.*;
import static io.gatling.javaapi.http.HttpDsl.*;

public class VideoGameDbFeeders extends Simulation {

    private HttpProtocolBuilder httpProtocol = http
            .baseUrl("https://videogamedb.uk/api")
            .acceptHeader("application/json");

    private static FeederBuilder.FileBased<Object> jsonFeeder = jsonFile("data/gameJsonFile.json").random();

    private static ChainBuilder getSpecificGame =
            feed(jsonFeeder)
                    .exec(http("Get video game with name - #{name}")
                    .get("/videogame/#{id}")
                            .check(jmesPath("name").isEL("#{name}")));

    private ScenarioBuilder scn = scenario("Video Game Db - Section 6 code")
            .repeat(10).on(
                    exec(getSpecificGame)
                            .pause(1)
            );

    {
        setUp(
                scn.injectOpen(atOnceUsers(1))
        ).protocols(httpProtocol);
    }
}
