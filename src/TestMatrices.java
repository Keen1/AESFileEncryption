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
        state = mixColumns(matrixFactor, state);
        //print the result
        testBlock(state);
        //perform the inverse mix columns
        state = invMixColumns(invMatrixFactor, state);
        //print the result
        testBlock(state);



    }
    public static int[][] mixColumns(int[][] matrixFactor, int[][] stateBlock){
        int[][] mixedBlock = new int[4][4];
        for(int i = 0; i < stateBlock.length; i++){
            int[] scalarRow = matrixFactor[i];
            for(int k = 0; k < stateBlock.length; k++){
                int[] stateColumn = {stateBlock[0][k], stateBlock[1][k], stateBlock[2][k], stateBlock[3][k]};
                mixedBlock[i][k] = gfMultOp(scalarRow, stateColumn);
            }
        }
        return mixedBlock;
    }
    public static int[][] invMixColumns(int[][] invMatrixFactor, int[][] stateBlock){
        int[][] mixedBlock = new int[4][4];

        for(int i = 0; i < stateBlock.length;i++){
            int[] scalarRow = invMatrixFactor[i];
            for(int k = 0; k < stateBlock[i].length; k++){
                int[] stateColumn = {stateBlock[0][k], stateBlock[1][k], stateBlock[2][k], stateBlock[3][k]};
                mixedBlock[i][k] = gfMultOp(scalarRow, stateColumn);

            }
        }
        return mixedBlock;
    }
    public static int gfMultOp(int[] scalarRow, int[] stateColumn){
        for(int i = 0; i < scalarRow.length; i++){
            if(scalarRow[i] == 2){
                stateColumn[i] = modPrimePoly(stateColumn[i] << 1);
            }
            if(scalarRow[i] == 3){
                stateColumn[i] = modPrimePoly((stateColumn[i] << 1)^stateColumn[i]);
            }
            if(scalarRow[i] == 9){
                stateColumn[i] = modPrimePoly((stateColumn[i] << 3)^stateColumn[i]);
            }
            if(scalarRow[i] == 11){
                stateColumn[i] = modPrimePoly((stateColumn[i] << 3)^(stateColumn[i] << 1)^stateColumn[i]);

            }
            if(scalarRow[i] == 13){
                stateColumn[i] = modPrimePoly((stateColumn[i] <<3)^(stateColumn[i] << 2)^stateColumn[i]);
            }
            if(scalarRow[i] == 14){
                stateColumn[i] = modPrimePoly((stateColumn[i] <<3 )^(stateColumn[i] << 2)^(stateColumn[i]<<1));
            }
        }
        return stateColumn[0]^stateColumn[1]^stateColumn[2]^stateColumn[3];

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
                String bStr = Integer.toHexString(block[i][k]);
                System.out.print(bStr + " ");
            }
        }
        System.out.println("\n________________________________________________________________");
    }
}
