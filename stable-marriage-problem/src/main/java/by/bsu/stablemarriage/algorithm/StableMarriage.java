package by.bsu.stablemarriage.algorithm;

import by.bsu.stablemarriage.entity.Graph;
import by.bsu.stablemarriage.entity.Pair;
import by.bsu.stablemarriage.entity.Point;
import by.bsu.stablemarriage.entity.Status;

import java.util.LinkedList;
import java.util.List;

public class StableMarriage {
    private int size;
    private Point[] people;
    private Point[] mans;
    private Point[] women;
    private List<Pair> marriages = new LinkedList<>();

    public StableMarriage() {
    }

    public StableMarriage(Graph graph) {
        size = graph.getWants().length / 2;
        people = graph.getPoints();
        setMans();
        setWomen();
    }

    public List<Pair> getMarriages() {
        return marriages;
    }

    public void doAlgorithm() {
        doChoice(mans[0]);
    }

    private void doChoice(Point currentMan) {
        int manWant = currentMan.getWants().getFirst();

        if (isMarried(manWant)) {
            currentMan.getWants().removeFirst();
            doChoice(currentMan);
            return;
        }

        if (isFree(manWant)) {
            marriages.add(new Pair(currentMan.getI(), manWant));
            women[manWant - 1].setStatus(Status.MAYBE);
            mans[currentMan.getI() - 1].setStatus(Status.MAYBE);
            if (isIdeal(women[manWant - 1], currentMan.getI())) {
                women[manWant - 1].setStatus(Status.MARRIED);
                mans[currentMan.getI() - 1].setStatus(Status.MARRIED);
            }
            if (getNextFreeMan() != null) {
                doChoice(getNextFreeMan());
            }
        } else {
            int conflictMan = getConflictMen(manWant);
            int best = getBest(currentMan, mans[conflictMan - 1], women[manWant - 1]);

            if (!currentMan.equals(mans[best - 1])) {//currentLose
                currentMan.setStatus(Status.FREE);
                currentMan.getWants().removeFirst();
                doChoice(currentMan);
            } else {//conflictLose
                mans[conflictMan - 1].getWants().removeFirst();
                mans[conflictMan - 1].setStatus(Status.FREE);

                int pairIndex = getPairByMan(conflictMan);

                marriages.remove(pairIndex);
                marriages.add(pairIndex, new Pair(currentMan.getI(), manWant));
                mans[currentMan.getI() - 1].setStatus(Status.MAYBE);
                if (isIdeal(women[manWant - 1], currentMan.getI())) {
                    women[manWant - 1].setStatus(Status.MARRIED);
                    mans[currentMan.getI() - 1].setStatus(Status.MARRIED);
                }
                doChoice(mans[conflictMan - 1]);
            }
        }
    }

    private Point getNextFreeMan() {
        for (int i = 0; i < size; ++i) {
            if (mans[i].getStatus().equals(Status.FREE)) {
                return mans[i];
            }
        }
        return null;
    }

    private int getPairByMan(int man) {
        int marriagesSize = marriages.size();
        for (int i = 0; i < marriagesSize; ++i) {
            if (marriages.get(i).getMan() == man) {
                return i;
            }
        }
        return -1;
    }

    private int getConflictMen(int woman) {
        for (Pair marriage : marriages) {
            if (marriage.getWoman() == woman) {
                return marriage.getMan();
            }
        }
        return -1;
    }

    private int getBest(Point man1, Point man2, Point woman) {
        int man1I = man1.getI();
        int man2I = man2.getI();

        for (int womanWant : woman.getWants()) {
            if (womanWant == man1I || womanWant == man2I) {
                return womanWant;
            }
        }
        return -1;
    }

    private boolean isIdeal(Point woman, int man) {
        return woman.getWants().getFirst() == man;
    }

    private boolean isMarried(int woman) {
        return women[woman - 1].getStatus().equals(Status.MARRIED);
    }

    private boolean isFree(int woman) {
        return women[woman - 1].getStatus().equals(Status.FREE);
    }

    private void setMans() {
        mans = new Point[size];
        System.arraycopy(people, 0, mans, 0, size);
    }

    private void setWomen() {
        women = new Point[size];
        System.arraycopy(people, size, women, 0, size);
    }
}
