package CredibleExam.exam_9_26;

/**
 * @Classname FriendCircles
 * @Description TODO
 * @Date 2020/7/5 20:45
 * @Created by Administrator
 * There are N students in a class. Some of them are friends,
 * while some are not. Their friendship is transitive in nature.
 * For example, if A is a direct friend of B, and B is a direct friend of C,
 * then A is an indirect friend of C. And we defined a friend circle is a group of students
 * who are direct or indirect friends.
 *
 * Given a N*N matrix M representing the friend relationship between students in the class.
 * If M[i][j] = 1, then the ith and jth students are direct friends with each other,
 * otherwise not. And you have to output the total number of friend circles
 * among all the students.
 *
 */
public class FriendCircles {


    public static void main(String[] args) {
        int[][] M={{1,1,0},{1,1,0},{0,0,1}};
        System.out.println(findCircleNum(M));


    }
    public static int findCircleNum(int[][] M) {
        /**
         使用一个visited数组, 依次判断每个节点, 如果其未访问,
         朋友圈数加1并对该节点进行dfs搜索标记所有访问到的节点
         **/
         boolean[] visited=new boolean[M.length];
         int res=0;
         for(int i=0;i<M.length;i++){
             if(!visited[i]){
                 dfs(M,visited,i);
                 res++;
             }
         }
         return res;

    }

    private static void dfs(int[][] m,boolean[] visited,int i){
            for(int j=0;j<m.length;j++){
                if(m[i][j]==1&&!visited[j]){
                    visited[j]=true;
                    dfs(m,visited,j);
                }
            }
    }
}
