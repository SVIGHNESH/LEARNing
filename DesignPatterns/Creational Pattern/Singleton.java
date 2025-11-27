class JudgeAnalytics{
    private static final JudgeAnalytics judgeAnalytics = new JudgeAnalytics();
    private int runCount = 0;
    private int submitCount = 0;

    private JudgeAnalytics() {}
    
    //This is the Method That Ensures Singleton Pattern
    public static JudgeAnalytics getInstance() {
        return judgeAnalytics;
    }

    public void countRun() {
        runCount++;
    }

    public void countSubmit() {
        submitCount++;
    }

    public int getRunCount() {
        return runCount;
    }

    public int getSubmitCount() {
        return submitCount;
    }
}
class Singleton {
    public static void main(String[] args){
       JudgeAnalytics ja = JudgeAnalytics.getInstance();
       JudgeAnalytics ja2 = JudgeAnalytics.getInstance();
       
       System.out.println(ja);
       System.out.println(ja2);
       ja.countRun();
       ja2.countRun();
       System.out.println(ja.getRunCount());
       System.out.println(ja2.getRunCount());
       
    }
}
