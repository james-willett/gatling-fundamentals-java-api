package videogamedb.finalsimulation;

import io.gatling.javaapi.core.*;
import io.gatling.javaapi.http.*;

import static io.gatling.javaapi.core.CoreDsl.*;
import static io.gatling.javaapi.http.HttpDsl.*;

public class VideoGameDbFullTest extends Simulation {

    // HTTP PROTOCOL

    // RUNTIME PARAMETERS



    // FEEDER FOR TEST - CSV, JSON etc.

    // BEFORE BLOCK

    // HTTP CALLS
    private static ChainBuilder getAllVideoGames =
            exec(http("Get all video games")
                    .get("/videogame"));

    // SCENARIO OR USER JOURNEY
    // 1. Get all video games
    // 2. Create a new game
    // 3. Get details of newly created game
    // 4. Delete newly created game

    // LOAD SIMULATION

    // AFTER BLOCK


}
