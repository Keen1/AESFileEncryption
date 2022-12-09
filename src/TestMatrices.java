public class TestMatrices {
    public static void main(String[] args){
        int[][] matrixFactor = {
                {2,3,1,1},
                {1,2,3,1},
                {1,1,2,3},
                {3,1,1,2}};
        int[][] invMatrixFactor = {
                {14,11,13,9},
                {9,14,11,13},
                {13,9,14,11},
                {11,13,9,14}};

        int[][] state = new int[4][4];
        String letters = "abcdefghijklmnop";
        int cnt = 0;
        for(int i = 0; i < state.length; i++){
            for(int k = 0; k < state.length; k++){
                state[k][i] = letters.charAt(cnt);
                cnt++;
            }
        }
        System.out.println("Initial block state: " );
        testBlock(state);

        //perform the mix_Columns operation




    }
    public static void mixColumns(int[][] matrixFactor, int[][] stateBlock){
        int[] stateColumn = new int[4];
        for(int i = 0; i < stateBlock.length; i++){
            int[] scalarRow = matrixFactor[i];
            for(int k = 0; k < stateBlock.length; k++){
                stateColumn = {};
            }
        }
    }
    public static void invMixColumns(int[][] invMatrixFactor, int[][] stateBlock){

    }
    public static void gfMultOp(int[] scalarRow, int[] stateColumn){

    }
    public static int modPrimePoly(int value){

        if(value >= 256){
            return value^283;
        }else{
            return value;
        }
    }

    public static void testBlock(int[][] block){
        for(int i = 0; i < block.length; i++){
            System.out.println();
            for(int k = 0; k < block[i].length; k++){
                System.out.print(block[i][k] + " ");
            }
        }
    }
}
