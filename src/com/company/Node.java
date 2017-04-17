package com.company;

class Node {                // 포인트 객체 클래스
    int x = 0;
    int y = 0;
    double distance = 0.0;

    Node(int x, int y) {    // x와 y 좌표를 입력받기 위한 생성자
        this.x = x;
        this.y = y;
    }

    double getDistance(Node target) { // 목표 포인트 객체까지의 거리를 리턴함.
        return Math.sqrt(Math.pow(target.x - x, 2) + (Math.pow(target.y - y, 2)));
    }
}
