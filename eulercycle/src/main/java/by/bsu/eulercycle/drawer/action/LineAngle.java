package by.bsu.eulercycle.drawer.action;

public final class LineAngle {
    private LineAngle() {
    }

    public static double getAngle(double x1, double y1, double x2, double y2) {
        double xDif = x2 - x1;
        double yDif = y2 - y1;

        if (xDif >= 0 && yDif >= 0) {//1 part
            return Math.atan((y2 - y1) / (x2 - x1));
        }

        if (xDif <= 0 && yDif >= 0) {//2 part
            return Math.PI + Math.atan((y2 - y1) / (x2 - x1));
        }

        if (xDif <= 0 && yDif <= 0) {//3 part
            return Math.PI + Math.atan((y2 - y1) / (x2 - x1));
        }

        if (xDif >= 0 && yDif <= 0) {//4 part
            return 2 * Math.PI + Math.atan((y2 - y1) / (x2 - x1));
        }

        return -1;
    }
}
