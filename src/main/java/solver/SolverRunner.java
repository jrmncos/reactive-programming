package solver;

import model.Fixture;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SolverRunner {

  private final ExecutorService executorService = Executors.newCachedThreadPool();

  public List<Future<Fixture>> runNSolverInstances(final Integer n){
    //TODO Removing hardcore instances
    List<Callable<Fixture>> solverInstances = IntStream.iterate(0, i -> i + 1)
      .limit(n)
      .boxed()
      .collect(Collectors.toList())
      .stream()
      .map(this::createSolverInstance)
      .collect(Collectors.toList());
    try{
      return executorService.invokeAll(solverInstances);
    }catch (Exception e){
     return null;
    }
  }

  private Callable<Fixture> createSolverInstance(final Integer i){
    Callable<Fixture> fixture = () -> {
      Solver solver = new HeuristicSolver();
      return solver.solve(new ArrayList<>());
    };
    return fixture;
  }
}
