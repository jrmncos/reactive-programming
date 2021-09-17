package solver;

import model.Fixture;
import model.Team;

import java.util.List;

public interface Solver {
  Fixture solve(List<Team> teams);
}
