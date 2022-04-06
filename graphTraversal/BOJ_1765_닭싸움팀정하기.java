package graphTraversal;

import java.util.*;
import java.io.*;

public class BOJ_1765_닭싸움팀정하기 {
    static class Student{
        HashSet<Integer> friends;
        HashSet<Integer> enemies;
        public Student() {
            this.friends = new HashSet<>();
            this.enemies = new HashSet<>();
        }
    }
    static Student[] students;
    static int n;
    static boolean[] visited ;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        students = new Student[n];
        for(int i =0 ; i < n ; i++) students[i] = new Student();
        visited = new boolean[n];

        int m = Integer.parseInt(br.readLine());
        for(int i =0 ; i < m ; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            char r = st.nextToken().charAt(0);
            int p = Integer.parseInt(st.nextToken())-1;
            int q = Integer.parseInt(st.nextToken())-1;
            switch (r){
                case 'E':{
                    students[p].enemies.add(q);
                    students[q].enemies.add(p);
                    enemyFriends(p, q);             // 서로의 적을 상대방의 친구로 추가함
                    break;
                }
                case 'F':{
                    students[p].friends.add(q);
                    students[q].friends.add(p);
                    break;
                }
            }
        }
        int cnt = 0;
        for(int i =0 ; i < n ; i++){
            if(visited[i]) continue;
            findFriends(i);
            cnt++;
        }
        System.out.println(cnt);
    }

    private static void findFriends(int p) {
        if(visited[p]) return;
        visited[p] = true;
        for(Integer i : students[p].friends){
            findFriends(i);
        }
    }

    private static void enemyFriends(int p, int q) {
        for(Integer i: students[q].enemies){        // q의 적들을 p의 친구로 추가
            students[p].friends.add(i);
        }
        for(Integer i : students[p].enemies){       // p의 적들을 q의 친구로 추가
            students[q].friends.add(i);
        }
    }
}
