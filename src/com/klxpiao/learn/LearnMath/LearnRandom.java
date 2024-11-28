package com.klxpiao.learn.LearnMath;

import java.util.Random;
import static java.lang.System.out;

public class LearnRandom {
    public static void main(String[] args) {
        Random rand = new Random();
        int randomNum = rand.nextInt(300,500); //👌== C#'s Math.Next(mix, max)
        out.println(randomNum);

        out.println(Math.random()); //out double of 0-1

        out.println(Math.round(rand.nextDouble(500))); //👎🏻C# have Math.Round(num, decimal)

        double randomNum2 = rand.nextDouble();
        out.println(randomNum2);
        out.printf("%.3f%n", randomNum2);//good👍
    }
}
