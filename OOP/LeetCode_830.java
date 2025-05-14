import java.util.ArrayList;
import java.util.List;

class LeetCode_830 {
    public List<List<Integer>> largeGroupPositions(String s) {
        List<Integer> first_index = new ArrayList<>();
        List<Integer> last_index = new ArrayList<>();
        int c = 0;
        int fi = 0;
        int li = 0;

        for (int i = 0; i <s.length(); i++) {
            char letter = s.charAt(i);
            //System.out.print(letter + " ");
            //System.out.println();
            fi=i;
            for (int j = i; j < s.length(); j++) {
                if (letter == s.charAt(j)) { 
                    System.out.println();
                    System.out.print(letter + " ");
                    System.out.println(s.charAt(j));
                    System.out.println();
                    c++; 
                    System.out.println(c);
                } else {
                    break;
                }
                li=j;
                System.out.println();
                System.out.println("last index " + li);
                System.out.println();
                i=li;
            }
            if(c>=3) {
                    first_index.add(fi);
                    last_index.add(li);
            }
            c=0;
            
        }
        
        List<List<Integer>> matrix = new ArrayList<>();
        matrix.add(new ArrayList<>(first_index));
        matrix.add(new ArrayList<>(last_index));
        
        List<List<Integer>> transposedMatrix = new ArrayList<>();
        
        for (int i = 0; i < matrix.get(0).size(); i++) {
        transposedMatrix.add(new ArrayList<>());
        }
        
        // Populate the transposedMatrix with values from the original matrix
        for (int i = 0; i < matrix.size(); i++) {
            for (int j = 0; j < matrix.get(i).size(); j++) {
                transposedMatrix.get(j).add(matrix.get(i).get(j));
            }
        }
    
        return transposedMatrix;
    }
    
    public static void main(String args[]) {
        System.out.println();
        String s = "abcdddeeeeaabbbcd";
        LeetCode_830 obj = new LeetCode_830();
        List<List<Integer>> mat1 = new ArrayList<>();
        mat1 = obj.largeGroupPositions(s);
        for(int i = 0; i < mat1.size(); i++) {
            for(int j = 0; j < mat1.get(i).size(); j++) {
                System.out.print(mat1.get(i).get(j) + " ");
            } 
            System.out.println();
        }
    }
}