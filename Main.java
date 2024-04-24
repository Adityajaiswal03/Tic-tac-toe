import java.util.Scanner;

public class Main {
    public static void print(char[][]A){
        for(int i=0;i<A.length;i++){
            for(int j=0;j<A[0].length;j++){   
                System.out.print(A[i][j]);
            }
            System.out.println();
        }
    }
    // optimise the code for O(n) and O(1);
    public static boolean checkWinner(char[][]A,Character sym){
        for(int i=0;i<A.length;i++){
            if(A[i][0]==sym && A[i][1]==sym && A[i][2]==sym)return true;
            else if(A[0][i]==sym && A[1][i]==sym && A[2][i]==sym)return true;
        }
        if(A[0][0]==sym && A[1][1]==sym && A[2][2]==sym)return true;
        if(A[0][2]==sym && A[1][1]==sym && A[2][0]==sym)return true;
        return false;
    }
    public static void main(String[] args) {
        int n=3;
        char[][] board=new char[n][n];
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){   
                board[i][j]='-';
            }

        }
        Scanner sc=new Scanner(System.in);
        System.out.println("Please Enter the name of Player1");
        String s1=sc.nextLine();
        System.out.println("Please Enter the name of Player2");
        String s2=sc.nextLine();
        //true means player 1 turn
        Boolean flag=true;
        int countofMove=0;
        while(true){
            char sym;
                if(flag){
                    sym='X';
                }else{
                    sym='O';
                }
            while(true){
                if(flag){
                    System.out.print(s1);
                    System.out.println(",Please make your turn");
                }else{
                    System.out.print(s2);
                    System.out.println(",Please make your turn");
                }
                System.out.println("Please input the row");
                int r=sc.nextInt();
                System.out.println("Please input the col");
                int c=sc.nextInt();
                if(r<0 ||r>=n||c<0 || c>=n){
                    System.out.println("Invaild Move");
                    break;
                }else if(board[r][c]!='-'){
                    System.out.println("The cell is already occupied");
                    break;
                }else{
                    board[r][c]=sym;
                    print(board);
                    countofMove++;
                    flag=!flag;
                    break;
                }
                
            }
            if(checkWinner(board, sym)){
                    System.out.print(sym);
                    System.out.println(" is the winner");
                    break; 
            }else if(countofMove==9){
                System.out.println("It is a Draw");
                break;
            }
            
        }
        print(board);
    }
}