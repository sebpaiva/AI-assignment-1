package Puzzle8.UninformedSearches;

import Puzzle8.Puzzle8;

import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.stream.Collectors;

public class BreadthFirst {
    private Queue<Puzzle8> open = new LinkedList<>();
    private Queue<Puzzle8> closed = new LinkedList<>();

    private Puzzle8 initial;
    private boolean foundSolution = false;
    private long totalTime;
    private int moveCounter;

    public BreadthFirst(Puzzle8 initial) {
        this.initial = initial;
        moveCounter = -1; // Processing the initial state brings us to 0
    }
    public void calculate(){
        open.add(initial);

        long startTimer = System.currentTimeMillis();
        while(!open.isEmpty()){
            Puzzle8 current = open.remove();
            closed.add(current);

            if(current.isPuzzleSolved()){
                foundSolution = true;
                totalTime = System.currentTimeMillis()-startTimer;
                return;
            }

            // Filter out states which are already in open or closed lists
            List<Puzzle8> unseenSuccessorsOfCurrent = current.getSuccessorStates().stream()
                    .filter(successor -> !open.contains(successor))
                    .filter(successor -> !closed.contains(successor))
                    .toList();

            moveCounter++;
            open.addAll(unseenSuccessorsOfCurrent);
        }

        totalTime = System.currentTimeMillis()-startTimer;
    }


    @Override
    public String toString() {
        return "BreadthFirst{" +
                "foundSolution=" + foundSolution +
                ", timeTaken=" + totalTime +
                ", moveCounter=" + moveCounter +
                ", openListSize=" + open.size() +
                ", closedListSize(states processed)=" + closed.size() +
                '}';
    }

    public Queue<Puzzle8> getOpen() {
        return open;
    }

    public Queue<Puzzle8> getClosed() {
        return closed;
    }

    public Puzzle8 getInitial() {
        return initial;
    }

    public boolean isFoundSolution() {
        return foundSolution;
    }

    public long getTotalTime() {
        return totalTime;
    }

    public int getMoveCounter() {
        return moveCounter;
    }
}
