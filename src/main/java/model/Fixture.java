package model;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Fixture {
  private Map<String, Set<Match>> dateByMatches;

  public Fixture(){
    dateByMatches = new HashMap<>();
  }

  public void addDateAndMatches(final String date, final Set<Match> matches){
    dateByMatches.put(date, matches);
  }
}
