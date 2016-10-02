package easy.trees;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BottomUpLevelOrder {

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> metaList = new ArrayList<List<Integer>>();
        if(root !=null){
            Queue<TreeNode> q = new LinkedList<TreeNode>();
            int currLevelNodes = 1;
            q.add(root);
            // start level order traversal
            while(!q.isEmpty()){
                int nextLevelNodes = 0;
                List<Integer> currLevelList = new ArrayList<Integer>();
                for(int i=0; i < currLevelNodes; i++){
                    TreeNode curr = q.remove();
                    currLevelList.add(curr.val);

                    if(curr.left!=null){
                        q.add(curr.left);
                        nextLevelNodes++;
                    }
                    if(curr.right!=null){
                        q.add(curr.right);
                        nextLevelNodes++;
                    }
                }
                currLevelNodes = nextLevelNodes;
                // add it to the first position, so reversal is not required
                metaList.add(0,currLevelList);
            } // end while
        }
        return metaList;
    }
}
