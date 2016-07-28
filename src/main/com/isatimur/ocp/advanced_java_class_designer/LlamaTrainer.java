package com.isatimur.ocp.advanced_java_class_designer;

/**
 * Created by developer on 7/25/16.
 */
public class LlamaTrainer {

    public static void main(String[] args) {
        HayStorage storage = HayStorage.getInstance();
        storage.addHay(0);
        LlamaTrainer trainer = new LlamaTrainer();
        System.out.println(trainer.feedLlamas(10));
        System.out.println(storage.getQuantityOfHay());
    }

    public boolean feedLlamas(int numberOfLlamas) {
        int amountNeeded = 5 * numberOfLlamas;
        HayStorage hayStorage = HayStorage.getInstance();
        if (hayStorage.getQuantityOfHay() < amountNeeded) {
            hayStorage.addHay(amountNeeded + 10);
        }
        boolean fed = hayStorage.removeHay(amountNeeded);
        if (fed)
            System.out.println("Llamas have been fed");
        return fed;
    }
}
