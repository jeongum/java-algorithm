package bruteForce;

import java.util.*;
import java.io.*;
public class Main_2613_숫자구슬 {
    static int N, M, left, right;
    static int[] arr, group, rarr;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i =0 ; i < N ; i++){
            arr[i] = Integer.parseInt(st.nextToken());
            left = Math.max(left, arr[i]);      // 합의 최댓값의 최솟값 ( 가장 큰 숫자 )
            right += arr[i];    // 합의 최댓값의 최댓값 ( 모든 숫자의 합 )
        }

        int mid = 0;    // 비교할 값
        while(left <= right){
            mid = (left + right)/2; // 비교값 설정
            int cnt = divide(mid);  // 현재 비교 값으로 몇 번 나눌 수 있는지
            if(cnt > M){    // M보다 더 많이 나눠야 하면, 비교값이 작다는 뜻
                left = mid + 1; // left값을 올려줌
            } else{     // M보다 작거나 같게 나눠지면, 비교값이 크다는 뜻 ( == 한그룹에 많은 숫자가 들어갈 수 있음 )
                right = mid - 1;    // right값을 낮춰줌
            }
        }

        System.out.println(left);

        int cnt = 0 , sum = 0, i;
        for(i = 0 ; i < N ; i++){
            sum += arr[i];
            if(sum > left){     // 구한 max값보다 커지면
                System.out.print(cnt + " ");    // 지금까지 그룹내 구슬 수 출력
                sum = arr[i];   // 다음 그룹에 arr[i] 추가
                cnt = 0;    // cnt 초기화
                M--;
            }

            cnt ++; // 그룹 내 구슬 개수 ++

            if(M == N-i) break;   // 남은 그룹에 하나씩 있어야 하므로
        }
        for(;i<N;i++){
            System.out.print(cnt+" ");
            cnt = 1;
        }

    }

    private static int divide(int mid) {
        int sum = 0 , cnt  = 1;
        for(int i = 0 ; i < N ; i++) {
            sum += arr[i];
            if(sum > mid){
                sum = arr[i];
                cnt ++;
            }
        }
        return cnt;
    }

//    private static void divideGroup(int pos, int cnt) {
//        if(pos == M && cnt == N){
//            int start = 0;
//            int maxIn = Integer.MIN_VALUE;
//
//            for(int i = 0 ; i < M ; i++){
//
//                int sum = 0;
//
//                for(int j = 0 ; j < group[i] ; j++){
//                    sum += arr[start+j];
//                    if(sum >= res) return;
//                }
//
//                maxIn = Math.max(maxIn, sum);
//                start += group[i];
//            }
//
//            if(res > maxIn){
//                res = maxIn;
//                rarr = Arrays.copyOf(group, M);
//            }
//
//            return;
//        }
//
//        if(pos >= M || cnt >= N) return;
//
//        for(int i = 1 ; i < N ; i++){
//            group[pos] = i;
//            divideGroup(pos+1, cnt + i);
//        }
//    }
}
