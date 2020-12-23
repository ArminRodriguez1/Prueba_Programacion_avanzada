/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.generala;

/**
 *
 * @author Marcelo
 */
public class Generala {
    protected int[] dice;
    public Generala(int... dado) {
        dice = new int[5];
        int i=0;
        for(int cara : dado){
            dice[i] = cara;
            i++;
        }
    }
    public static int chance(int... dado) {
        int total = 0;
        for (int cara : dado) {
           total += cara;
        }
        return total;
    }

    // '(int... dice)' es similar a tener public static int generala(int d1, int d2, int d3 , etc) pero permite realizar operaciones como -> for (int die : dice)
    //es una forma de decir que el metodo puede aceptar 1 o más parametros de tipo int ... lista de parametros dinamicos.
    public static int generala(int... dice) {
        int[] counts = new int[6];
        for (int die : dice) {
            counts[die - 1]++;
        }
        for (int i = 0; i != 6; i++) {
            if (counts[i] == 5) {
                return 50;
            }
        }
        return 0;
    }

    public static int ones(int d1, int d2, int d3, int d4, int d5) {
        return suma(1, d1, d2, d3, d4, d5);
    }

    public static int twos(int d1, int d2, int d3, int d4, int d5) {
        return suma(2, d1, d2, d3, d4, d5);
    }

    public static int threes(int d1, int d2, int d3, int d4, int d5) {
        return suma(3, d1, d2, d3, d4, d5);
    }
    public static int suma(int numero, int... dice){
        int suma =0;
        for (int cara : dice) {
            if (cara == numero) {
                suma+=numero;
            }
        }
        return suma;
    }

    public int fours() {
        int sum;
        sum = 0;
        for (int at = 0; at != 5; at++) {
            if (dice[at] == 4) {
                sum += 4;
            }
        }
        return sum;
    }

    public int fives() {
        int s = 0;
        int i;
        for (i = 0; i < dice.length; i++) {
            if (dice[i] == 5) {
                s = s + 5;
            }
        }
        return s;
    }

    public int sixes() {
        int sum = 0;
        for (int at = 0; at < dice.length; at++) {
            if (dice[at] == 6) {
                sum = sum + 6;
            }
        }
        return sum;
    }

    public static int score_pair(int... dice) {
        int[] counts = new int[6];
        for (int cara : dice){
            counts[cara - 1]++;
        }
        int at;
        for (at = 0; at != 6; at++) {
            if (counts[6 - at - 1] >= 2) {
                return (6 - at) * 2;
            }
        }
        return 0;
    }

    public static int two_pair(int... dice) {
        int[] counts = new int[6];
        for (int cara : dice){
            counts[cara - 1]++;
        }
        int n = 0;
        int score = 0;
        for (int i = 0; i < 6; i += 1) {
            if (counts[6 - i - 1] >= 2) {
                n++;
                score += (6 - i);
            }
        }
        if (n == 2) {
            return score * 2;
        } else {
            return 0;
        }
    }
    public static int three_of_a_kind(int d1, int d2, int d3, int d4, int d5) {
        return number_of_a_kind( 3,  d1,  d2,  d3,  d4,  d5);
    }
    public static int four_of_a_kind(int d1, int d2, int d3, int d4, int d5) {
       return number_of_a_kind( 4,  d1,  d2,  d3,  d4,  d5);
    }
    public static int number_of_a_kind(int number,int... dice){
        int[] counts = new int[6];
        for (int die : dice) {
            counts[die - 1]++;
        }
        for (int i = 0; i < 6; i++) {
            if (counts[i] >= number) {
                return (i + 1) * number;
            }
        }
        return 0;
    }

    public static int smallStraight(int d1, int d2, int d3, int d4, int d5) {
        int[] tallies = new int[6];
        tallies[d1 - 1] += 1;
        tallies[d2 - 1] += 1;
        tallies[d3 - 1] += 1;
        tallies[d4 - 1] += 1;
        tallies[d5 - 1] += 1;
        if (tallies[0] == 1
                && tallies[1] == 1
                && tallies[2] == 1
                && tallies[3] == 1
                && tallies[4] == 1) {
            return 15;
        }
        return 0;
    }

    public static int largeStraight(int d1, int d2, int d3, int d4, int d5) {
        int[] tallies = new int[6];
        tallies[d1 - 1] += 1;
        tallies[d2 - 1] += 1;
        tallies[d3 - 1] += 1;
        tallies[d4 - 1] += 1;
        tallies[d5 - 1] += 1;
        if (tallies[1] == 1
                && tallies[2] == 1
                && tallies[3] == 1
                && tallies[4] == 1
                && tallies[5] == 1) {
            return 20;
        }
        return 0;
    }

    public static int fullHouse(int d1, int d2, int d3, int d4, int d5) {
        int[] tallies;
        boolean _2 = false;
        int i;
        int _2_at = 0;
        boolean _3 = false;
        int _3_at = 0;

        tallies = new int[6];
        tallies[d1 - 1] += 1;
        tallies[d2 - 1] += 1;
        tallies[d3 - 1] += 1;
        tallies[d4 - 1] += 1;
        tallies[d5 - 1] += 1;

        for (i = 0; i != 6; i += 1) {
            if (tallies[i] == 2) {
                _2 = true;
                _2_at = i + 1;
            }
        }

        for (i = 0; i != 6; i += 1) {
            if (tallies[i] == 3) {
                _3 = true;
                _3_at = i + 1;
            }
        }

        if (_2 && _3) {
            return _2_at * 2 + _3_at * 3;
        } else {
            return 0;
        }
    }
   
}
