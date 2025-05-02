package com.realmorty.sofatest.core.service.impl;

import com.realmorty.sofatest.core.service.LeetCodeRushService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.stereotype.Component;

@Component
public class LeetCodeRushServiceImpl implements LeetCodeRushService {

    @Test
    public void testPush() {
//        System.out.println(pushDominoes("RR.L"));
//        Assertions.assertEquals("LL.RR.LLRRLL..", pushDominoes(".L.R...LR..L.."));
//        Assertions.assertEquals("RR.L", pushDominoes("RR.L"));
        Assertions.assertEquals("L.", pushDominoes("L."));
    }

    public String pushDominoes(String dominoes) {
        char[] charArray = dominoes.toCharArray();
        int n = charArray.length;
        int[][] distance = new int[n][2];
        int curL = -100002, curR = 100002;
        for (int i = 0; i < n; i++) {
            if (charArray[i] == 'L') {
                curL = -i - 1;
            } else if (charArray[i] == 'R') {
                curL = i + 1;
            }
            if (charArray[n - i - 1] == 'L') {
                curR = -(n - i - 1) - 1;
            } else if (charArray[n - i - 1] == 'R') {
                curR = n - i - 1 + 1;
            }
            distance[i][0] = curL;
            distance[n - i - 1][1] = curR;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            char c = charArray[i];
            if (c == 'L' || c == 'R') {
                sb.append(c);
                continue;
            }
            int absL = Math.abs(distance[i][0]);
            int absR = Math.abs(distance[i][1]);
            if (absL == 100002 || distance[i][0] < 0) {
                if (absR == 100002 || distance[i][1] > 0) {
                    sb.append(c);
                } else {
                    sb.append('L');
                }
            } else {
                if (absR == 100002 || distance[i][1] > 0) {
                    sb.append('R');
                } else {
                    int distanceL = i - Math.abs(distance[i][0]) + 1;
                    int distanceR = Math.abs(distance[i][1]) - i - 1;
                    if (distanceL == distanceR) {
                        sb.append(c);
                    } else if (distanceL > distanceR) {
                        sb.append('L');
                    } else {
                        sb.append('R');
                    }
                }
            }
        }
        return sb.toString();
    }
}
