package ua.nure.pihnastyi.practice6.part3;

import java.security.SecureRandom;
import java.util.Random;


public class Parking {

    private static final int N = 10;
    private boolean[] parking = new boolean[N];

    private void comeCar() {
        while (!parking[N - 1]) {
            findPlace();
        }
    }

    private void outCar() {
        for (int z = 0; z < N; z++) {
            if (parking[z] == true) {
                goAway();
                z = 0;
            }
        }
        System.out.println("Parking clean");
    }

    private void goAway() {
        Random random = new SecureRandom();
        int currentPlace = random.nextInt(N);
        if (parking[currentPlace]) {
            parking[currentPlace] = false;
        }
    }

    private void findPlace() {
        Random random = new SecureRandom();
        int currentPlace = random.nextInt(N);

        while (currentPlace <= N) {
            if (!parking[currentPlace]) {
                parking[currentPlace] = true;
                break;
            }
            currentPlace++;
        }

    }

    private void printParking() {
        for (int i = 0; i < N; i++) {
            System.out.println(i + ") " + parking[i] + " ");
        }

    }

    public static void main(String[] args) {
        Parking p = new Parking();
        p.comeCar();
        p.printParking();
        p.outCar();
        p.printParking();
    }

}
