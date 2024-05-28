package day0321;

public class BingoPrac {
    public static void main(String[] args) {
        int [][] arr = new int [3][3];
        int bingo = 0;

        for (int i=0;i<arr.length;i++)
        {
            for(int j=0;j<arr[i].length;j++)
            {
               arr[i][j]= (int)(Math.random()*3)+1;
            }
        }

        for (int i=0;i<arr.length;i++) {
            for (int j = 0; j < arr[i].length; j++)
            {
                System.out.printf("%3d",arr[i][j]);
            }System.out.println();
        }
        for(int i=0;i<arr.length;i++)
        {
            if (arr[i][0]==arr[i][1]&&arr[i][1]==arr[i][2])
                bingo++;
            if(arr[0][i]==arr[1][i]&&arr[1][i]==arr[2][i])
                bingo++;
        }
        if (arr[1][1]==arr[0][0]&&arr[0][0]==arr[2][2])
            bingo++;
        if(arr[0][2]==arr[1][1]&&arr[1][1]==arr[2][0])
            bingo++;

        if(bingo==0)
            System.out.println("꽝");
        else
            System.out.println(bingo+"개 빙고");
    }

}
