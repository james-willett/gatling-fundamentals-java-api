package videogamedb;

import java.time.Duration;
import java.util.*;

import io.gatling.javaapi.core.*;
import io.gatling.javaapi.http.*;
import io.gatling.javaapi.jdbc.*;

import static io.gatling.javaapi.core.CoreDsl.*;
import static io.gatling.javaapi.http.HttpDsl.*;
import static io.gatling.javaapi.jdbc.JdbcDsl.*;

public class RecordedSimulationProxy extends Simulation {

  private HttpProtocolBuilder httpProtocol = http
    .baseUrl("https://videogamedb.uk")
    .inferHtmlResources(AllowList(), DenyList(".*\\.js", ".*\\.css", ".*\\.gif", ".*\\.jpeg", ".*\\.jpg", ".*\\.ico", ".*\\.woff", ".*\\.woff2", ".*\\.(t|o)tf", ".*\\.png", ".*detectportal\\.firefox\\.com.*"))
    .acceptHeader("*/*")
    .acceptEncodingHeader("gzip, deflate")
    .userAgentHeader("PostmanRuntime/7.29.2");
  
  private Map<CharSequence, String> headers_0 = Map.ofEntries(
    Map.entry("Cache-Control", "no-cache"),
    Map.entry("Postman-Token", "f87e2c8e-5525-4b03-b208-251efd07f622")
  );
  
  private Map<CharSequence, String> headers_1 = Map.ofEntries(
    Map.entry("Cache-Control", "no-cache"),
    Map.entry("Postman-Token", "f7ad0ff2-5a0c-44c8-9524-3c1d6c139541")
  );
  
  private Map<CharSequence, String> headers_2 = Map.ofEntries(
    Map.entry("Cache-Control", "no-cache"),
    Map.entry("Content-Type", "application/json"),
    Map.entry("Postman-Token", "c920e913-7703-4ad3-8d63-420b1abf4fdc")
  );
  
  private Map<CharSequence, String> headers_3 = Map.ofEntries(
    Map.entry("Cache-Control", "no-cache"),
    Map.entry("Content-Type", "application/json"),
    Map.entry("Postman-Token", "77168760-034c-4165-bd99-fe3ce6b576ab"),
    Map.entry("authorization", "Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhZG1pbiIsImlhdCI6MTY2MjcwNDUzNCwiZXhwIjoxNjYyNzA4MTM0fQ.TFQpEIrCziZonRCBCXmaS0200TBGvrclTAd30t8jaBI")
  );
  
  private Map<CharSequence, String> headers_4 = Map.ofEntries(
    Map.entry("Cache-Control", "no-cache"),
    Map.entry("Content-Type", "application/json"),
    Map.entry("Postman-Token", "0089c6b1-19af-4ed9-95b0-20a1ed5ad451"),
    Map.entry("authorization", "Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhZG1pbiIsImlhdCI6MTY2MjcwNDUzNCwiZXhwIjoxNjYyNzA4MTM0fQ.TFQpEIrCziZonRCBCXmaS0200TBGvrclTAd30t8jaBI")
  );
  
  private Map<CharSequence, String> headers_5 = Map.ofEntries(
    Map.entry("Cache-Control", "no-cache"),
    Map.entry("Postman-Token", "bf6786fd-b4f1-417f-a654-eb09371168a4"),
    Map.entry("authorization", "Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhZG1pbiIsImlhdCI6MTY2MjcwNDUzNCwiZXhwIjoxNjYyNzA4MTM0fQ.TFQpEIrCziZonRCBCXmaS0200TBGvrclTAd30t8jaBI")
  );


  private ScenarioBuilder scn = scenario("RecordedSimulationProxy")
    .exec(
      http("request_0")
        .get("/api/videogame")
        .headers(headers_0)
    )
    .pause(14)
    .exec(
      http("request_1")
        .get("/api/videogame/2")
        .headers(headers_1)
    )
    .pause(6)
    .exec(
      http("request_2")
        .post("/api/authenticate")
        .headers(headers_2)
        .body(RawFileBody("videogamedb/recordedsimulationproxy/0002_request.json"))
    )
    .pause(11)
    .exec(
      http("request_3")
        .post("/api/videogame")
        .headers(headers_3)
        .body(RawFileBody("videogamedb/recordedsimulationproxy/0003_request.json"))
    )
    .pause(6)
    .exec(
      http("request_4")
        .put("/api/videogame/3")
        .headers(headers_4)
        .body(RawFileBody("videogamedb/recordedsimulationproxy/0004_request.json"))
    )
    .pause(4)
    .exec(
      http("request_5")
        .delete("/api/videogame/2")
        .headers(headers_5)
    );

  {
	  setUp(scn.injectOpen(atOnceUsers(1))).protocols(httpProtocol);
  }
}
