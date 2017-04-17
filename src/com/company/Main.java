package com.company;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Random;

/*
* OS    : Windows 10 Pro 64bit
* CPU   : Intel(R) Core(TM) i3-6100 CPU @ 3.70Hz 3.70GHz
* Tool  : IntelliJ IDEA 2016.3.5
* */

public class Main {

    private static final int LENGTH = 5;

    public static void main(String[] args) {
        Random mRandom = new Random();                  // 포인트생성을 위한 난수함수
        DescDistance mDistance = new DescDistance();    // 어레이 정렬을 위한 Comparator
        ArrayList<Node> mNodes = new ArrayList<>();     // 포인트 어레이
        ArrayList<Node> result = new ArrayList<>();     // 최적 결과 어레이
        Node zeroPoint = new Node(0, 0);          // 원점
        double totalDistance = 0.0;                     // 총 이동거리

        for (int i = 0; i < LENGTH; ++i) {
            mNodes.add(new Node(mRandom.nextInt(LENGTH) + 1, mRandom.nextInt(LENGTH) + 1));     // 어레이에 난수로 푀인트 객체 생성
            mNodes.get(i).distance = mNodes.get(i).getDistance(zeroPoint);                            // 포인트에서 원점 거리 계산 및 저장
        }
        mNodes.sort(mDistance); // 거리에 의해 어레이 내림차순 정렬. 가장 작은 값이 앞으로 오게됨.


        for (int i = 0; i < LENGTH; ++i) {
            totalDistance += mNodes.get(0).distance;            // 어레이 안 가장 짧은 거리값을 더함(Greedy Algorithm)
            result.add(mNodes.get(0));                          // 최적 결과 어레이에 포인트 객체 저장
            mNodes.remove(0);                             // 객체 삭제
            for (Node obj : mNodes) {
                obj.distance = obj.getDistance(result.get(i));  // 가장 짧은 거리의 포인트부터 다시 거리를 계산 및 저장
            }
            mNodes.sort(mDistance);                             // 거리에 의해 내림차순 정렬. 다시 맨 처음 인덱스로 가장 작은 거리값이 정렬됨.
        }

        totalDistance += result.get(result.size() - 1).getDistance(zeroPoint); // 최적 결과 어레이의 마지막 인덱스 포인트부터 원점거리를 저장.


        for (Node obj : result) System.out.print("(" + obj.x + "," + obj.y + ") => "); // 최적 결과 어레이 출력
        System.out.println("총 이동거리 : " + totalDistance);                    // 총 이동거리 출력
    }
}

class DescDistance implements Comparator<Node> {                // 비교자 객체
    @Override
    public int compare(Node o1, Node o2) {
        return Double.compare(o1.distance, o2.distance);
    }
}