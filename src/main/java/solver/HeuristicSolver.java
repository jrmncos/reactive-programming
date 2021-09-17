package solver;

import model.Fixture;
import model.Match;
import model.Team;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class HeuristicSolver implements Solver{

  @Override
  public Fixture solve(List<Team> teams) {

    final Set<Match> matches = generateMatches(0, teams, new HashSet<>())
      .stream()
      .collect(Collectors.toSet());
//TODO Generate Fixture
//    final Integer totalDates = teams.size() - 1;
//    final Set<Match> total = new HashSet<>();
//    final Set<Match> matchesOfTheDate = matches
//      .stream()
//      .filter(match -> !total.contains(match))
//      .limit(teams.size()/2)
//      .collect(Collectors.toSet());
    final Fixture fixture = new Fixture();
    fixture.addDateAndMatches("Date 1", matches);
    return fixture;
  }

  private Set<Match> generateMatches(final Integer idx,
                               final List<Team> teams,
                               final Set<Match> matches){
    if(idx == teams.size() - 1){
      return matches;
    }
    else{
      final Team actualTeam = teams.get(idx);
      for(Team team: teams){
        final Match match = new Match(actualTeam, team);
        if(!team.equals(actualTeam) && !matches.contains(match))
          matches.add(match);
      }
      return generateMatches(idx + 1, teams, matches);
    }
  }
}
