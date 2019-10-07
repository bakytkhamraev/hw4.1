package com.company;

import java.util.Random;


public class Main {
    public static int bossHealth = 700;

    public static int[] heroeshealth = {250, 250, 250, 500};


    public static int bossAttack = 50;

    public static int[] heroesAttack = {20, 20, 20};

    public static int medicSave = 20;


    public static String bossDefenceType = "";

    public static String[] heroesAttackType = {"Bakyt", "Bekulan", "Arslan", "Medic"};

    public static void main(String[] args) {
        // write your code here
        int roundNumber = 1;

        prinStatistics(0);

        while (!isFinished()) {

            changeBossDefence();

            round(roundNumber);

            roundNumber++;


        }


    }


    public static void changeBossDefence() {

        Random r = new Random();

        int randomIndex = r.nextInt(3);

        bossDefenceType = heroesAttackType[randomIndex];

        System.out.println("boss defence " + bossDefenceType);


    }


    public static void round(int number) {

        bossHit();

        heroesHit();

        medicTreat();

        prinStatistics(number);


    }


    public static boolean isFinished() {

        if (bossHealth <= 0) {

            System.out.println("Heroes won!");

            return true;

        }

        if (heroeshealth[0] <= 0 && heroeshealth[1] <= 0 && heroeshealth[2] <= 0) {

            System.out.println("Boss won!");


            return true;

        }


        return false;


    }


    public static void bossHit() {


        for (int i = 0; i < heroeshealth.length; i++) {

            heroeshealth[i] = heroeshealth[i] - bossAttack;


        }

    }


    public static void medicTreat() {

        {


        }

        if ((heroeshealth[0] > 0 || heroeshealth[1] > 0 || heroeshealth[2] > 0 || heroeshealth[3] > 0) &&

                (heroeshealth[0] < 250 || heroeshealth[1] < 250 || heroeshealth[2] < 250)) ;

        Random r = new Random();

        int randomNumber = r.nextInt(3);

        switch (randomNumber) {

            case 0:

                heroeshealth[0] = heroeshealth[0] + medicSave;

                System.out.println("Medic helped " + heroesAttackType[0]);

                break;

            case 1:

                heroeshealth[1] = heroeshealth[1] + medicSave;

                System.out.println("Medic helped " + heroesAttackType[1]);

                break;

            case 2:

                heroeshealth[2] = heroeshealth[2] + medicSave;

                System.out.println("Medic helped " + heroesAttackType[2]);

                break;


        }


    }


    public static void heroesHit() {

        for (int i = 0; i < heroesAttack.length; i++) {

            if (bossHealth > 0 && heroeshealth[i] > 0) {

                if (bossDefenceType.equals(heroesAttackType[i])) {

                    Random r = new Random();

                    int randomNumber = r.nextInt(9) + 2;

                    bossHealth = bossHealth - heroesAttack[i] * randomNumber;

                    System.out.println("Critical Damage " + (heroesAttack[i] * randomNumber));

                } else {


                    bossHealth = bossHealth - heroesAttack[i];     //bossHealth-=heroesAttack[i];

                }

            }


        }


    }


    public static void prinStatistics(int round) {

        System.out.println("_________________________________________");

        System.out.println("round " + round);

        System.out.println("Boss health " + bossHealth);

        System.out.println("Bakyt health " + heroeshealth[0]);

        System.out.println("Bekulan health " + heroeshealth[1]);

        System.out.println("Arslan health " + heroeshealth[2]);

        System.out.println("Medic health " + heroeshealth[3]);

        System.out.println("_________________________________________");


    }
}
