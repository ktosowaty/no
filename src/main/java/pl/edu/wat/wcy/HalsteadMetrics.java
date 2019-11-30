package pl.edu.wat.wcy;

public class HalsteadMetrics {

    /**
     * słownik programu
     */
    private int vocabulary;

    /**
     * długość programu
     */
    private int length;

    /**
     * /objętość programu
     */
    private double volume;

    /**
     * trudność programu
     */
    private double difficulty;

    /**
     * wymagany czas pracy
     */
    private double effort;

    /**
     * przewidywana liczba błędów
     */
    private double deliveredBugs;

    public HalsteadMetrics(ProgramParams params) {
        vocabulary = calculateVocabulary(params);
        length = calculateLength(params);
        volume = calculateVolume();
        difficulty = calculateDifficulty(params);
        effort = calculateEffort();
        deliveredBugs = calculateDeliveredBugs();
    }

    private int calculateVocabulary(ProgramParams params) {
        return params.getDistinctOperators() + params.getDistinctOperands();
    }

    private int calculateLength(ProgramParams params) {
        return params.getTotalOperators() + params.getTotalOperands();
    }

    private double calculateVolume() {
        return length * (Math.log(vocabulary) / Math.log(2));
    }

    private double calculateDifficulty(ProgramParams params) {
        return (double) (params.getDistinctOperators() * params.getTotalOperands()) / (2 * params.getDistinctOperands());
    }

    private double calculateEffort() {
        return volume * difficulty;
    }

    private double calculateDeliveredBugs() {
        return volume / 3000;
    }

    public int getVocabulary() {
        return vocabulary;
    }

    public int getLength() {
        return length;
    }

    public double getVolume() {
        return volume;
    }

    public double getDifficulty() {
        return difficulty;
    }

    public double getEffort() {
        return effort;
    }

    public double getDeliveredBugs() {
        return deliveredBugs;
    }

    public void print() {
        System.out.println("Vocabulary: " + vocabulary);
        System.out.println("Length: " + length);
        System.out.println("Volume: " + volume);
        System.out.println("Difficulty: " + difficulty);
        System.out.println("Effort: " + effort);
        System.out.println("Delivered bugs: " + deliveredBugs);
    }

}
