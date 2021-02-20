package HighConcurrency;

/**
 * @Classname IntGenerator
 * @Description TODO
 * @Date 2019/11/27 15:55
 * @Created by 14241
 */
public abstract class IntGenerator {
    private volatile boolean canceled = false;
    public abstract int next();
    // Allow this to be canceled:
    public void cancel() { canceled = true; }
    public boolean isCanceled() { return canceled; }
} ///:~
