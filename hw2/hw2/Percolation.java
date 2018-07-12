package hw2;

import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {
    WeightedQuickUnionUF eng;
    WeightedQuickUnionUF openState;
    int num;
    int open;
    int full;
    int openCount = 0;

    public Percolation(int N) {      // create N-by-N grid, with all sites initially blocked
        num = N;
        eng = new WeightedQuickUnionUF(N * N + 1);
        openState = new WeightedQuickUnionUF(N * N + 1);
        open = N * N;
        full = N * N;
    }

    public int xyTo1D(int row, int col) {
        int returnVal = row * num + col;
        return returnVal;
    }

    public void open(int row, int col) {    // open the site (row, col) if it is not open already
        openState.union(xyTo1D(row, col), open);
        openCount++;
        checkAround(row, col);
        if (row == 0) {
            eng.union(xyTo1D(row, col), full);
        }
    }

    public void checkAround(int row, int col) {
        int current = xyTo1D(row, col);
        if(row != 0) {
            int up = xyTo1D(row - 1, col);
            if(openState.connected(up, open)) eng.union(up,current);
        }
        if(row != num - 1) {
            int down = xyTo1D(row + 1, col);
            if(openState.connected(down, open)) eng.union(down,current);
        }
        if(col != 0) {
            int left = xyTo1D(row, col - 1);
            if(openState.connected(left, open)) eng.union(left,current);
        }
        if(col != num - 1) {
            int right = xyTo1D(row, col + 1);
            if(openState.connected(right, open)) eng.union(right,current);
        }
    }

    public boolean isOpen(int row, int col) {    // is the site (row, col) open?
        return openState.connected(open, xyTo1D(row, col));
    }

    public boolean isFull(int row, int col) {    // is the site (row, col) full?
        return eng.connected(full, xyTo1D(row, col));
    }

    public int numberOfOpenSites() {    // number of open sites
        return openCount;
    }

    public boolean percolates() {      // does the system percolate?
        for(int i = 0; i < num; i++) {
            if(this.isFull( num - 1, i)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {    // use for unit testing (not required)

    }
}
