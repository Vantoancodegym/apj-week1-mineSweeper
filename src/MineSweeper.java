import java.util.Arrays;

public class MineSweeper {
    public static void main(String[] args) {
        String[][] beginArray = {
                {"*",".","*",".","."},
                {".",".","*",".","*"},
                {"*","*",".",".","."},
                {".",".","*","*","."},
                {"*","*","*",".","*"}
        };
        String[][] newArray= new String[beginArray.length][];
        for (int i = 0; i < beginArray.length; i++) {
            newArray[i]=new String[beginArray[i].length];
        }
        for (int i = 0; i < beginArray.length; i++) {
            for (int j = 0; j < beginArray[i].length; j++) {
                if (beginArray[i][j].equals("*")){
                    newArray[i][j]="*";
                }else {
                    int count=0;
                    int[][] neighborArray={
                            {i-1,j-1},{i-1,j},{i-1,j+1},{i,j-1},
                            {i,j+1},{i+1,j-1},{i+1,j},{i+1,j+1}

                    };
                    for (int k = 0; k < neighborArray.length; k++) {
                        int index1=neighborArray[k][0];
                        int index2=neighborArray[k][1];
                        boolean f1=(index1>=0&&index1<beginArray.length)&&
                                (index2>=0&&index2<beginArray[i].length);
                        if (f1){
                            if (beginArray[index1][index2].equals("*")){
                                count++;
                            }
                        }
                    }
                    newArray[i][j]=String.valueOf(count);
                }
            }

        }
        printArray(beginArray);
        printArray(newArray);
    }
    public static void printArray(String[][] array){
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(" "+array[i][j]);
            }
            System.out.print("\n");
        }
    }
}
