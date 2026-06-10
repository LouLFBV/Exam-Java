package partie4;

@Rest(path = "/api/scores")
public class ScoreController {
 /** (1 pt) GET /api/scores/top?limit=5
 * Retourne les limit meilleurs scores du ScoreManager sous forme de String.
 * Format : "pseudo1:score1,pseudo2:score2,..." */
 @Get(path = "/top")
 public String getTop(@QueryParam(name = "limit") int limit) { }
 /** (1 pt) POST /api/scores/add
 * Reçoit un ScoreDTO (pseudo + score), l'enregistre via ScoreManager.
 * Retourne "OK" si succès. */
 @Post(path = "/add")
 public String add(ScoreDTO dto) { }
}
