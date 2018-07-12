package hw2;

public class PercolationStats {
    int[] record;
    int times;
    public PercolationStats(int N, int T, PercolationFactory pf) {
        times = T;
        record = new int[T];
        for (int i = 0; i < T; i++) {
            Percolation exp = pf.make(N);
            while (!exp.percolates()) {
                int r = edu.princeton.cs.introcs.StdRandom.uniform(0, N);
                int c = edu.princeton.cs.introcs.StdRandom.uniform(0, N);
                if(!exp.isOpen(r, c)) {
                    exp.open(r, c);
                }
            }
            record[i] = exp.numberOfOpenSites();
        }
    }   // perform T independent experiments on an N-by-N grid

    public double mean() {
        return edu.princeton.cs.introcs.StdStats.mean(record);
    }                                          // sample mean of percolation threshold

    public double stddev() {
        return edu.princeton.cs.introcs.StdStats.stddev(record);
    }                                         // sample standard deviation of percolation threshold

    public double confidenceLow() {
        return this.mean() - (1.96 * this.stddev()) / Math.sqrt(times);
    }                                  // low endpoint of 95% confidence interval

    public double confidenceHigh() {
        return this.mean() + (1.96 * this.stddev()) / Math.sqrt(times);
    }                                 // high endpoint of 95%

}
