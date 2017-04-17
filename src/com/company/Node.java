package com.company;

/**
 * Created by USER on 2017-04-17.
 */
class Node {
    int x = 0;
    int y = 0;
    double distance = 0.0;

    Node(int x, int y) {
        this.x = x;
        this.y = y;
    }

    double getDistance(Node target) {
        return Math.sqrt(Math.pow(target.x - x, 2) + (Math.pow(target.y - y, 2)));
    }
}
