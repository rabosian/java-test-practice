import java.util.*;

public class TicTacToe {
    static ArrayList<Integer> playerPositions = new ArrayList<Integer>();
    static ArrayList<Integer> cpuPositions = new ArrayList<Integer>();

    public static void main(String[] args) {
        char[][] board = {
                {'1', '|', '2', '|', '3'},
                {'-', '+', '-', '+', '-'},
                {'4', '|', '5', '|', '6'},
                {'-', '+', '-', '+', '-'},
                {'7', '|', '8', '|', '9'},
        };

        displayBoard(board);

        Scanner scan = new Scanner(System.in);

        String result = "";
        while(result.isEmpty()) {
            System.out.print("Enter your placement (1-9): ");
            int playerPos = scan.nextInt();
            while (playerPositions.contains(playerPos) || cpuPositions.contains(playerPos)) {
                System.out.println("position already taken, enter another pos: ");
                playerPos = scan.nextInt();
            }
            while (playerPos < 1 || playerPos > 9) {
                System.out.println("Enter number between 1-9... try again: ");
                playerPos = scan.nextInt();
            }
            placeChar(board, playerPos, "player");
            playerPositions.add(playerPos);
            result = checkWinner();
            if (result.length() > 0) {
                System.out.println(result);
                break;
            }

            Random rnd = new Random();
            int cpuPos = rnd.nextInt(9) + 1;
            while (cpuPositions.contains(cpuPos) || playerPositions.contains(cpuPos)) {
                cpuPos = rnd.nextInt(9) + 1;
            }
            placeChar(board, cpuPos, "cpu");
            cpuPositions.add(cpuPos);

            displayBoard(board);
            result = checkWinner();
            System.out.println(result);
        }

    }
    public static void displayBoard(char[][] board) {
        for(char[] row : board) {
            for(char c: row) {
                System.out.print(c);
            }
            System.out.println();
        }
    }

    public static void placeChar(char[][] board, int pos, String user) {
        char symbol = 'O';
        if(user.equals("player")) {
            symbol = 'X';
        }

        switch(pos) {
            case 1:
                board[0][0] = symbol;
                break;
            case 2:
                board[0][2] = symbol;
                break;
            case 3:
                board[0][4] = symbol;
                break;
            case 4:
                board[2][0] = symbol;
                break;
            case 5:
                board[2][2] = symbol;
                break;
            case 6:
                board[2][4] = symbol;
                break;
            case 7:
                board[4][0] = symbol;
                break;
            case 8:
                board[4][2] = symbol;
                break;
            case 9:
                board[4][4] = symbol;
                break;
        }
    }

    public static String checkWinner() {
        List topRow = Arrays.asList(1,2,3);
        List midRow = Arrays.asList(4,5,6);
        List botRow = Arrays.asList(7,8,9);
        List topCol = Arrays.asList(1,4,7);
        List midCol = Arrays.asList(2,5,8);
        List botCol = Arrays.asList(3,6,9);
        List cross1 = Arrays.asList(1,5,9);
        List cross2 = Arrays.asList(3,5,7);

        List<List> winning = new ArrayList<List>();
        winning.add(topRow);
        winning.add(midRow);
        winning.add(botRow);
        winning.add(topCol);
        winning.add(midCol);
        winning.add(botCol);
        winning.add(cross1);
        winning.add(cross2);

        for(List l: winning) {
            if (playerPositions.containsAll(l)) {
                return "Player WIN!";
            } else if(cpuPositions.containsAll(l)) {
                return "CPU win";
            } else if(playerPositions.size() + cpuPositions.size() == 9) {
                return "Tied!";
            }
        }
        return "";
    }

}
