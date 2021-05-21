package workout_clothes;

import java.util.Arrays;

public class workcloth_210519001 {
    public static void main(String[] args) {
        int  n=30;
        int[] lost = {4,14,1,5,30,2,3};
        int[] reserve = {4,7,9,13,20,23,26,28,30};
        int answer=0;

        Arrays.sort(lost);
        Arrays.sort(reserve);
        //들어오는 배열 을 오름차순으로 정렬
        int i=0;
        int j= 0;
        //두 배열을 탐색하기위한 인덱스

        //두배열의 중복되는 값을들 -3으로 설정
        while(i<lost.length &&j<reserve.length){ //두배열중 하나라도 끝에 도달하기전까지 실행
            if(lost[i] > reserve[j])  j++;  //lost가 더크면 j를 증가 (오름차순이라 j가 클수록 reserve갑도 커짐)
            else if(lost[i]< reserve[j]) i++; //위와 같은이유료 i를 증가
            else {// 둘다아닐시 두배열의 값이 같음
                answer++; //체육 참가가능 인원 증가
                lost[i]=-3;
                reserve[j]= -3;
                //두배열값을 -3으로 설정
                i++;
                j++;
                //다음 인덱스 값 이동
            }
        }
        i=0;
        j=0;
        //위에서 사용햇으므로 초기화
        while(i<lost.length &&j<reserve.length){
            if(lost[i]==-3 &&reserve[j]==-3) { //두배열값이 동시에 -3이면 인덱스 증가
                i++;
                j++;
            }
            else if(lost[i]==-3) i++;
            else if(reserve[j]==-3) j++; //둘중에 한개만 -3이면 해당부분만 인덱스 증가
            else{ // 위 조건문들이 전부아니면 비교가능한 값이라는뜻
            if(lost[i] > reserve[j]+1 )  j++;
            //잃어버린사람은  +1 또는 -1 크기의 옷만입을수잇어서 reserve +1 보다 크다면 못입는것이고
            //reserve 인덱스값을 증가 시켜서 다음크기와 비교
            else if(lost[i]< reserve[j]-1) i++;
            //잃어버린사람은 +1 또는 -1 크기의 옷만입을수잇어서 reserve -1 보다 작다면 못입는것이고
            //오름차순정렬에서 위 조건을 만족한다는건 해당 인덱스의 lost 값의 사람은 빌릴수잇는 옷이없다는것
            //그러므로 다음 lost 인사람 의 옷을 찾으로 i값 증가
            else { //둘다 아니라면 입을수잇는 것이므로
                answer++;  //체육참가인원 증가
                i++; //옷빌렷으므로 lost인덱스 증가
                j++; //옷을 빌려줫으므로 lost 인덱스 증가
                }
            }
        }
        answer = answer-lost.length + n; // 전체 - 옷잃어버린사람 +옷빌린사람  == 참가가능인원
        System.out.println(answer);
    }
}
