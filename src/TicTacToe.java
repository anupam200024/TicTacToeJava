import java.util.Scanner;

public class TicTacToe {
    // this function displays the matrix
    public static void show(char[][] arr) {

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print("| " + arr[i][j] + " ");
            }
            System.out.println("|");
        }
    }

    // this function puts the X or O in the positions chosen by player
    public static void initialize(char[][] arr, char ch, int x, int y) {
        if (ch == 'X')
            arr[x][y] = 'X';
        else arr[x][y] = 'O';
    }

    // this method converts the given number into coordinates, in tictactoe matrix we have 3*3 matrix and I took all positions from number 1 to 9 for player convenience
    public static int[] coordinate(int num) {
        return switch (num) {
            case 1 -> new int[]{0, 0};
            case 2 -> new int[]{0, 1};
            case 3 -> new int[]{0, 2};
            case 4 -> new int[]{1, 0};
            case 5 -> new int[]{1, 1};
            case 6 -> new int[]{1, 2};
            case 7 -> new int[]{2, 0};
            case 8 -> new int[]{2, 1};
            case 9 -> new int[]{2, 2};
            default -> new int[]{-1, -1};
        };
    }

    // this method checks the winner and return 1 for X wins, 2 for O wins and 0 if none
    public static int winner(char[][] arr) {
        // x wins
        if (arr[0][0] == 'X' && arr[0][1] == 'X' && arr[0][2] == 'X') {
            return 1;
        } else if (arr[1][0] == 'X' && arr[1][1] == 'X' && arr[1][2] == 'X') {
            return 1;
        } else if (arr[2][0] == 'X' && arr[2][1] == 'X' && arr[2][2] == 'X') {
            return 1;
        } else if (arr[0][0] == 'X' && arr[1][0] == 'X' && arr[2][0] == 'X') {
            return 1;
        } else if (arr[0][1] == 'X' && arr[1][1] == 'X' && arr[2][1] == 'X') {
            return 1;
        } else if (arr[0][2] == 'X' && arr[1][2] == 'X' && arr[2][2] == 'X') {
            return 1;
        } else if (arr[0][0] == 'X' && arr[1][1] == 'X' && arr[2][2] == 'X') {
            return 1;
        } else if (arr[0][2] == 'X' && arr[1][1] == 'X' && arr[2][0] == 'X') {
            return 1;
        }

        // o wins

        else if (arr[0][0] == 'O' && arr[0][1] == 'O' && arr[0][2] == 'O') {
            return 2;
        } else if (arr[1][0] == 'O' && arr[1][1] == 'O' && arr[1][2] == 'O') {
            return 2;
        } else if (arr[2][0] == 'O' && arr[2][1] == 'O' && arr[2][2] == 'O') {
            return 2;
        } else if (arr[0][0] == 'O' && arr[1][0] == 'O' && arr[2][0] == 'O') {
            return 2;
        } else if (arr[0][1] == 'O' && arr[1][1] == 'O' && arr[2][1] == 'O') {
            return 2;
        } else if (arr[0][2] == 'O' && arr[1][2] == 'O' && arr[2][2] == 'O') {
            return 2;
        } else if (arr[0][0] == 'O' && arr[1][1] == 'O' && arr[2][2] == 'O') {
            return 2;
        } else if (arr[0][2] == 'O' && arr[1][1] == 'O' && arr[2][0] == 'O') {
            return 2;
        }
        return 0;
    }

    // this function initializes all the matrix positions to number 1-9 for a fresh new game
    public static void start(char[][] arr) {
        char ch = '1';
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                arr[i][j] = ch++;
            }
        }
    }

    // main function of the program
    public static void main(String[] args) {
        char[][] arr = new char[3][3];
        // choice tells if user wants to play again by pressing 1 and other keys for exit
        int choice = 1;
        start(arr);

        Scanner sc = new Scanner(System.in);

        while (true) {
            if (choice == 1) {
                // turn checks if it's X's turn or O's turn
                int turn = 0;
                int i = 0;
                for (i = 0; i < 9; i++) {
                    if (winner(arr) == 1) {
                        show(arr);
                        System.out.println("X Wins 🥳");
                        System.out.println("Do You Want to play more? (1 for Yes)");
                        choice = sc.nextInt();
                        start(arr);
                        break;
                    } else if (winner(arr) == 2) {
                        show(arr);
                        System.out.println("O Wins 🥳");
                        System.out.println("Do You Want to play more? (1 for Yes)");
                        choice = sc.nextInt();
                        start(arr);
                        break;
                    } else {
                        show(arr);
                        if (turn == 0) {
                            System.out.println("X's turn");
                            System.out.println("Enter Position");
                            int index = sc.nextInt();
                            int[] positions = coordinate(index);
                            // checking if the chosen place is already filled or not
                            if ((arr[positions[0]][positions[1]] >= '1' && arr[positions[0]][positions[1]] <= '9')) {
                                initialize(arr, 'X', positions[0], positions[1]);
                                turn = 1;
                            } else {
                                System.out.println("Already filled");
                                i--;
                            }
                        } else {
                            System.out.println("O's turn");
                            System.out.println("Enter Position");
                            int index = sc.nextInt();
                            int[] positions = coordinate(index);
                            // checking if the chosen place is already filled or not
                            if ((arr[positions[0]][positions[1]] >= '1' && arr[positions[0]][positions[1]] <= '9')) {
                                initialize(arr, 'O', positions[0], positions[1]);
                                turn = 0;
                            } else {
                                System.out.println("Already filled");
                                i--;
                            }
                        }
                    }
                }
                if (i == 9) {
                    show(arr);
                    if (winner(arr) == 1) {
                        System.out.println("X Wins 🥳");
                    } else if (winner(arr) == 2) {
                        System.out.println("O Wins 🥳");
                    } else {
                        System.out.println("Match Draw");
                    }
                    System.out.println("Do You Want to play more? (1 for Yes)");
                    choice = sc.nextInt();
                    start(arr);
                }
            } else {
                System.out.println("Thank You for playing! :)");
                return;
            }
        }
    }
}