package GameOfLife;


import java.util.ArrayList;

import java.util.List;

import java.util.Random;

import javafx.animation.KeyFrame;

import javafx.animation.Timeline;

import javafx.event.ActionEvent;

import javafx.util.Duration;




public class Game {


    private static int WORLD_SIZE_X = 20, WORLD_SIZE_Y = 20;



    private Cell[][] arrayH = new Cell[WORLD_SIZE_X][WORLD_SIZE_Y];

    private int lifeCycles;

    private Game world;

    private int nIteration;



    private Game() {

        nIteration = 0;

        for (int y = 0; y < WORLD_SIZE_Y; y++) {

            for (int x = 0; x < WORLD_SIZE_X; x++) {

                Random randomGenerator = new Random();

                int r = randomGenerator.nextInt(2);

                Cell cell = new Cell();

                cell.setName("X" + x + "Y" + y);

                if (r == 0) {

                    cell.setAlive(false);

                } else {

                    cell.setAlive(true);

                }

                arrayH[x][y] = cell;




    }



}

    }



    public static Game intialize() {

        Game world = new Game();

        return world;

    }



    public Game update() {

        nIteration++;

        int yMax = this.arrayH.length;

        int xMax = this.arrayH[0].length;

        for (int y = 0; y < yMax; y++) {

            for (int x = 0; x < xMax; x++) {




                List neighborList = new ArrayList();

// her findes cellernes naboer og deres position i arrayet

                if (y < WORLD_SIZE_Y - 1 && x > 0) {

                    if (arrayH[x - 1][y + 1].isAlive()) {

                        neighborList.add("SW");


                    }

                }

                if (y < WORLD_SIZE_Y - 1) {

                    if (arrayH[x][y + 1].isAlive()) {

                        neighborList.add("S");


                    }

                }

                if (x < WORLD_SIZE_X - 1 && y < WORLD_SIZE_Y - 1) {

                    if (arrayH[x + 1][y + 1].isAlive()) {

                        neighborList.add("SE");


                    }

                }



                if (x > 0) {

                    if (arrayH[x - 1][y].isAlive()) {

                        neighborList.add("W");


                    }

                }



                if (x < WORLD_SIZE_X - 1) {

                    if (arrayH[x + 1][y].isAlive()) {

                        neighborList.add("E");



                    }

                }



                if (x > 0 && y > 0) {

                    if (arrayH[x - 1][y - 1].isAlive()) {

                        neighborList.add("NW");


                    }

                }

                if (y > 0) {

                    if (arrayH[x][y - 1].isAlive()) {

                        neighborList.add("N");


                    }

                }

                if (x < WORLD_SIZE_X - 1 && y > 0) {

                    if (arrayH[x + 1][y - 1].isAlive()) {

                        neighborList.add("NE");


                    }

                }



                arrayH[x][y].setLivingNeighbours(neighborList.size());

                arrayH[x][y].setNeighborList(neighborList);



            }

        }


        for (int y = 0; y < yMax; y++) {

            for (int x = 0; x < xMax; x++) {

                String result = arrayH[x][y].update();

            }

        }


        return world;

    }



    public static int getWORLD_SIZE_X() {

        return WORLD_SIZE_X;

    }



    public static void setWORLD_SIZE_X(int WORLD_SIZE_X) {

        Game.WORLD_SIZE_X = WORLD_SIZE_X;

    }



    public int getLifeCycles() {

        return lifeCycles;

    }



    public void setLifeCycles(int lifeCycles) {

        this.lifeCycles = lifeCycles;

    }



    public static int getWORLD_SIZE_Y() {

        return WORLD_SIZE_Y;

    }



    public static void setWORLD_SIZE_Y(int WORLD_SIZE_Y) {

        Game.WORLD_SIZE_Y = WORLD_SIZE_Y;

    }



    public Cell[][] getArrayH() {

        return arrayH;

    }



    public void setArrayH(Cell[][] arrayH) {

        this.arrayH = arrayH;

    }



    public int getnIteration() {

        return nIteration;

    }



    public void setnIteration(int nIteration) {

        this.nIteration = nIteration;

    }



}