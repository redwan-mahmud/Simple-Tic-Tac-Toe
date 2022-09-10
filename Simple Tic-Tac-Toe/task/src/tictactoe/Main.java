package tictactoe;

import java.util.Scanner;

public class Main {

    static void printBlankGameBoard(){
        System.out.println("---------");
        System.out.println("| " +  "     " +" |");
        System.out.println("| " +  "     " +" |");
        System.out.println("| " +  "     " +" |");
        System.out.println("---------");
    }

    static void printGameState(char [][] board, int xdim, int ydim){
        System.out.println("---------");
        for(int col = 0; col <= ydim -1; col++){
            System.out.print("| ");
            for(int row = 0; row <= xdim - 1; row++){
                System.out.print(board[col][row] + " ");
                //put input for counting x and o and _ later
            }
            System.out.println("|");
        }
        System.out.println("---------");

    }

    static boolean checkXWin(boolean threeXinaRow, char[][] boardLayout){
        if((boardLayout[0][0] == 'X' && boardLayout[0][1] == 'X' && boardLayout[0][2] == 'X') ||
                (boardLayout[1][0] == 'X' && boardLayout[1][1] == 'X' && boardLayout[1][2] == 'X') ||
                (boardLayout[2][0] == 'X' && boardLayout[2][1] == 'X' && boardLayout[2][2] == 'X') ||
                (boardLayout[0][0] == 'X' && boardLayout[1][0] == 'X' && boardLayout[2][0] == 'X') ||
                (boardLayout[0][1] == 'X' && boardLayout[1][1] == 'X' && boardLayout[2][1] == 'X') ||
                (boardLayout[0][2] == 'X' && boardLayout[1][2] == 'X' && boardLayout[2][2] == 'X') ||
                (boardLayout[0][0] == 'X' && boardLayout[1][1] == 'X' && boardLayout[2][2] == 'X')||
                (boardLayout[0][2] == 'X' && boardLayout[1][1] == 'X' && boardLayout[2][0] == 'X')){
            threeXinaRow = true;

        }
        return threeXinaRow;
    }

    static boolean checkOWin(boolean threeOinaRow, char[][] boardLayout){
        if((boardLayout[0][0] == 'O' && boardLayout[0][1] == 'O' && boardLayout[0][2] == 'O') ||
                (boardLayout[1][0] == 'O' && boardLayout[1][1] == 'O' && boardLayout[1][2] == 'O') ||
                (boardLayout[2][0] == 'O' && boardLayout[2][1] == 'O' && boardLayout[2][2] == 'O') ||
                (boardLayout[0][0] == 'O' && boardLayout[1][0] == 'O' && boardLayout[2][0] == 'O') ||
                (boardLayout[0][1] == 'O' && boardLayout[1][1] == 'O' && boardLayout[2][1] == 'O') ||
                (boardLayout[0][2] == 'O' && boardLayout[1][2] == 'O' && boardLayout[2][2] == 'O') ||
                (boardLayout[0][0] == 'O' && boardLayout[1][1] == 'O' && boardLayout[2][2] == 'O')||
                (boardLayout[0][2] == 'O' && boardLayout[1][1] == 'O' && boardLayout[2][0] == 'O')){
            threeOinaRow = true;

        }
        return threeOinaRow;
    }
    public static void main(String[] args) {
        // write your code here
        Scanner scannerObj = new Scanner(System.in);

        int xCount =  0;
        int oCount = 0;
        //int blankCount = 0;
        boolean threeXinaRow = false;
        boolean threeOinaRow = false;
        int xdim = 3;
        int ydim = 3;
        boolean inputCorrectX = false; //sets to true means input correct and O can be placed
        boolean inputCorrectO = false; //sets to true means input correct and O can be placed
        boolean gameFinished = false; //Change this to true if someone has won


        printBlankGameBoard();
        //converting String to 1D array

        char[] chInput = {' ',' ',' ',' ',' ',' ',' ',' ', ' '};
        //converting String to 1D array print board in 2D array
        char[][] boardLayout = new char[xdim][ydim];
        for(int col = 0; col <= ydim -1; col++){
            for(int row = 0; row <= xdim - 1; row++){
                boardLayout[col][row] = chInput[(col*3) + row];
                //System.out.println(boardLayout[col][row]);
                //put input for counting x and o and _ later
            }
        }

        while(gameFinished == false){
            //take and verify input X, take and verify Input Y
            while(inputCorrectX == false){
                String[] userInput = scannerObj.nextLine().split(" ");// scanning user input and putting in array of 2 strings

                try
                {
                    int y =Integer.parseInt(userInput[0]);
                    int x =Integer.parseInt(userInput[1]);
                    //System.out.println("You entry is valid");
                    if((x >3 || x < 1) || (y > 3 || y < 1)){
                        System.out.println("Coordinates should be from 1 to 3!");
                    }
                    else{
                        System.out.println("now checking if input is empty");
                        //System.out.println(boardLayout[y-1][x-1]);
                        if(boardLayout[y-1][x-1] == ' '){
                            //System.out.println(boardLayout[y-1][x-1]);
                            boardLayout[y-1][x-1] = 'X';
                            System.out.println("Your Entry is Valid");
                            xCount++;
                            inputCorrectX = true;
                        }
                        else{
                            System.out.println("This cell is occupied choose another one");
                        }

                    }


                }

                catch (NumberFormatException e) {
                    System.out.println("You should enter numbers");
                    break;
                }
            }
            printGameState(boardLayout, xdim, ydim);
            //System.out.println("X: " + xCount + " " + "O: " + oCount);
            if(xCount >= 3 ){
                //check x or O game logic
                //System.out.println("Hello I entered this loop");
                threeXinaRow = checkXWin(threeXinaRow, boardLayout);

            }
            if(threeXinaRow == true){
                System.out.println("X wins");
                gameFinished = true;
                break;
            }

            while(inputCorrectO == false){
                String[] userInput = scannerObj.nextLine().split(" ");// scanning user input and putting in array of 2 strings

                try
                {
                    int y =Integer.parseInt(userInput[0]);
                    int x =Integer.parseInt(userInput[1]);
                    //System.out.println("You entry is valid");
                    if((x >3 || x < 1) || (y > 3 || y < 1)){
                        System.out.println("Coordinates should be from 1 to 3!");
                    }
                    else{
                        System.out.println("now checking if input is empty");
                        //System.out.println(boardLayout[y-1][x-1]);
                        if(boardLayout[y-1][x-1] == ' '){
                            //System.out.println(boardLayout[y-1][x-1]);
                            boardLayout[y-1][x-1] = 'O';
                            System.out.println("Your Entry is Valid");
                            oCount++;
                            inputCorrectO = true;
                        }
                        else{
                            System.out.println("This cell is occupied choose another one");
                        }

                    }


                }

                catch (NumberFormatException e) {
                    System.out.println("You should enter numbers");
                    break;
                }
            }
            printGameState(boardLayout, xdim, ydim);
            if(oCount >= 3 ){
                //check x or O game logic
                //System.out.println("Hello I entered this loop O");
                threeOinaRow = checkOWin(threeOinaRow, boardLayout);
                //System.out.println(threeOinaRow);

            }
            if(threeOinaRow == true){
                System.out.println("O wins");
                gameFinished = true;
                break;
            }
            inputCorrectO = false;
            inputCorrectX = false;

            if((xCount == 5 || oCount ==5) && (threeOinaRow == false && threeXinaRow == false)){
                System.out.println("Draw");
                gameFinished = true;
                break;

            }


        }













    }
}
