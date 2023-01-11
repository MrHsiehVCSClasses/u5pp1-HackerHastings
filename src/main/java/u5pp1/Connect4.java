package u5pp1;

public class Connect4 {

    public static final int RED_WIN = 0;
    public static final int BLACK_WIN = 1;
    public static final int NO_WINNER = 2;
    public static final int BOTH_WIN = 3;

    public static final int RED = 1;
    public static final int BLACK = -1;
    public static final int EMPTY = 0;
//checks if the board has no empty spaces
    public static boolean isFull(int[][] board){
    //returns true if all the board spaces have a piece in them. Red pieces are indicated by `1` and black pieces are indicated by `-1`. Empty spaces are indicated by `0`.
    for(int i = 0; i<board.length; i++){
        for(int j = 0; j<board[i].length; j++){
            if(board[i][j] == 0){
                return false;
            }
        }
    }
    return true;
    }
//checks if pieces are obeying gravity
    public static boolean isBoardValid(int[][] board){
    //returns true if the board is a valid configuration. A board is valid if there are no floating pieces.
    for(int i = 0; i<board.length; i++){
        for(int j = 0; j<board[i].length; j++){
            if(board[i][j] == 1 || board[i][j] == -1){
                for(int k = i + 1; k<board.length; k++){
                    if(board[k][j] == 0){
                        return false;
                    }
                }
            }
        }
    }
    return true;
    }
    
//checks who da winna is
    public static int getWinner(int[][] board){
//horizontal check

boolean REDWIN = false;
boolean BLACKWIN = false;

    for(int i = 0; i<board.length; i++){
        for(int j = 0; j<board[i].length - 3; j++){
            if(board[i][j] == 1){
                if(board[i][j+1] == 1){
                    if((board[i][j+2] == 1) && (board[i][j+3] == 1)){
                        REDWIN = true;
                    }
                }
            } else if(board[i][j] == -1){
                if(board[i][j+1] == -1){
                    if((board[i][j+2] == -1) && (board[i][j+3] == -1)){
                        BLACKWIN = true;
                    }
                }
            }
        }
    }
//vertical check
    for(int i = 0; i<board.length - 3; i++){
        for(int j = 0; j<board[i].length; j++){
            if(board[i][j] == 1){
                if(board[i+1][j] == 1){
                    if((board[i+2][j] == 1) && (board[i+3][j] == 1)){
                        REDWIN = true;
                    }
                }
            } else if(board[i][j] == -1){
                if(board[i+1][j] == -1){
                    if((board[i+2][j] == -1) && (board[i+3][j] == -1)){
                        BLACKWIN = true;
                    }
                }
            }
        }
    }
//upwards diagonal chek
    for(int i = 3; i<board.length; i++){
        for(int j = 0; j<board[i].length - 3; j++){
            if(board[i][j] == 1){
                if(board[i-1][j+1] == 1){
                    if((board[i-2][j+2] == 1) && (board[i-3][j+3] == 1)){
                        REDWIN = true;
                    }
                }
            } else if(board[i][j] == -1){
                if(board[i-1][j+1] == -1){
                    if((board[i-2][j+2] == -1) && (board[i-3][j+3] == -1)){
                        BLACKWIN = true;
                    }
                }
            }
        }
    }
//downwards diag check
    for(int i = 0; i<board.length-3; i++){
        for(int j = 0; j<board[0].length - 3; j++){
            if(board[i][j] == 1){
                if(board[i+1][j+1] == 1){
                    if((board[i+2][j+2] == 1) && (board[i+3][j+3] == 1)){
                        REDWIN = true;
                    }
                }
            } else if(board[i][j] == -1){
                if(board[i+1][j+1] == -1){
                    if((board[i+2][j+2] == -1) && (board[i+3][j+3] == -1)){
                        BLACKWIN = true;
                    }
                }
            }
        }
    }

    if(REDWIN && BLACKWIN){
        return BOTH_WIN;
    } else if(REDWIN){
        return RED_WIN;
    } else if(BLACKWIN){
        return BLACK_WIN;
    } else{
        return NO_WINNER;
    }
            
    

    }


//dumb idea 
   private boolean checkCorner(int[] [] board, int dude, int dude2){
    if((dude2 - 1 <= -1) || (dude2 + 1 >= board[0].length)){
        return true;
    } else if((dude - 1 <= -1) || (dude + 1 >= board.length)){
        return true;
    } else{
        return false;
    }
   }

}